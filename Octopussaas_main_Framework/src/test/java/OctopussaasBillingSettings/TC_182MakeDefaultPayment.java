package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClass80;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.BillingSettings;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)
public class TC_182MakeDefaultPayment extends BaseClass80 {

	ExcelUtility elib;
	HomePage hp;
	BillingSettings bs;
	JavascriptExecutor js;
	WebDriverWait wait;

	@Test
	public void TC_182MakeDefaultPayment() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		bs = new BillingSettings(driver);
		wlib = new webDriverutility();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		Thread.sleep(2000);
		js.executeScript("document.body.style.zoom='80%'");

		// Step 1: Click on Profile Icon
		hp.getUserprofile().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on User Profile icon successfully");
		System.out.println("INFO: Clicked on User Profile icon successfully");

		// Step 2: Click on Transporter Settings
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Transporter Settings successfully");
		System.out.println("INFO: Clicked on Transporter Settings successfully");

		// Step 3: Click on Billing Settings
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		bs = new BillingSettings(driver);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Billing Settings successfully");
		System.out.println("INFO: Clicked on Billing Settings successfully");

		// Step 4: Scroll to and click Add New Payment Method button
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddNewPaymentMethodButton());
		Thread.sleep(5000);
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(8000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(1000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 6: Enter Last 4 Digits of Credit Card
		try {
			WebElement cardNumberTextField = wait.until(ExpectedConditions.visibilityOf(bs.getLast4DigitsOfCreditCardTextfield()));
			js.executeScript("arguments[0].scrollIntoView(true);", cardNumberTextField);
			Thread.sleep(1000);
			String creditcardno = elib.getDataFromExcel("BillingSettings", 4, 1);
			System.out.println(creditcardno);
			cardNumberTextField.clear();
			cardNumberTextField.sendKeys(creditcardno);
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.PASS, "Entered '" + creditcardno + "' in Card Number text field successfully");
			System.out.println("PASS: Entered '" + creditcardno + "' in Card Number text field successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter Card Number - " + e.getMessage());
			System.out.println("FAIL: Failed to enter Card Number - " + e.getMessage());
		}

		// Step 7: Enter Account Holder Name
		WebElement accountHolderName = bs.getAccountHolderNameTextfield();
		js.executeScript("arguments[0].removeAttribute('disabled')", accountHolderName);
		js.executeScript("arguments[0].removeAttribute('readonly')", accountHolderName);
		accountHolderName.clear();
		accountHolderName.click();
		String acname = elib.getDataFromExcel("BillingSettings", 6, 1);
		accountHolderName.sendKeys(acname);
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.PASS, "Entered '"+acname+"' in Account Holder Name text field successfully");
		System.out.println("PASS: Entered '"+acname+"' in Account Holder Name text field successfully");

		// Step 8: Enter CVV/CVC value
		Thread.sleep(2000);
		bs.getCvvCvcTextfield().sendKeys("123");

		// Step 9: Click Add Card Details Button 2
		bs.getAddCardDetailsButton2().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.PASS, "Entered '123' in CVV/CVC field and clicked Add Card Details button successfully");
		System.out.println("PASS: Entered '123' in CVV/CVC field and clicked Add Card Details button successfully");

		// Step 10: Verify Credit Card Information header is displayed
		try {
			WebElement creditCardInfoHeader = wait.until(ExpectedConditions.visibilityOf(bs.getCreditCardInformationHeader()));
			if (creditCardInfoHeader.isDisplayed()) {
				utilityclassobject.gettest().log(Status.PASS, "Credit Card Information header is displayed successfully");
				System.out.println("PASS: Credit Card Information header is displayed successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Credit Card Information header is not displayed");
				System.out.println("FAIL: Credit Card Information header is not displayed");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to verify Credit Card Information header - " + e.getMessage());
			System.out.println("FAIL: Failed to verify Credit Card Information header - " + e.getMessage());
		}
		Thread.sleep(8000);

		// Step 11: Enter card number '4242424242424242' in Stripe iframe
		try {
			driver.switchTo().defaultContent();
			java.util.List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println("INFO: Total iframes found on page: " + iframes.size());
			for (WebElement iframe : iframes) {
				try {
					driver.switchTo().frame(iframe);
					if (!driver.findElements(By.id("card-number-input")).isEmpty()) break;
					driver.switchTo().defaultContent();
				} catch (Exception ex) { driver.switchTo().defaultContent(); }
			}
			WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card-number-input")));
			js.executeScript("arguments[0].scrollIntoView(true);", cardNumberField);
			Thread.sleep(500);
			js.executeScript("arguments[0].removeAttribute('disabled')", cardNumberField);
			js.executeScript("arguments[0].removeAttribute('readonly')", cardNumberField);
			cardNumberField.click();
			Thread.sleep(300);
			cardNumberField.sendKeys(Keys.CONTROL + "a");
			cardNumberField.sendKeys(Keys.DELETE);
			Thread.sleep(300);
			Actions actions = new Actions(driver);
			actions.moveToElement(cardNumberField).click().perform();
			for (char c : "4242424242424242".toCharArray()) {
				actions.sendKeys(String.valueOf(c)).perform();
				Thread.sleep(80);
			}
			Thread.sleep(1000);
			js.executeScript(
				"var el = arguments[0];" +
				"var s = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
				"s.call(el,'4242424242424242');" +
				"el.dispatchEvent(new Event('input',{bubbles:true}));" +
				"el.dispatchEvent(new Event('change',{bubbles:true}));", cardNumberField);
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.PASS, "Entered '4242424242424242' in Card Number field successfully");
			System.out.println("PASS: Entered '4242424242424242' in Card Number field successfully");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter card number - " + e.getMessage());
			System.out.println("FAIL: Failed to enter card number - " + e.getMessage());
		}

		// Step 12: Enter expiration date '1231'
		try {
			driver.switchTo().defaultContent();
			java.util.List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));
			for (WebElement iframe : allIframes) {
				try {
					driver.switchTo().frame(iframe);
					if (!driver.findElements(By.xpath("//input[@placeholder='MM / YY']")).isEmpty()) break;
					driver.switchTo().defaultContent();
				} catch (Exception ex) { driver.switchTo().defaultContent(); }
			}
			WebElement expirationDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='MM / YY']")));
			js.executeScript("arguments[0].scrollIntoView(true);", expirationDateField);
			Thread.sleep(500);
			js.executeScript("arguments[0].removeAttribute('disabled')", expirationDateField);
			js.executeScript("arguments[0].removeAttribute('readonly')", expirationDateField);
			js.executeScript("arguments[0].removeAttribute('maxlength')", expirationDateField);
			expirationDateField.click();
			Thread.sleep(300);
			expirationDateField.sendKeys(Keys.CONTROL + "a");
			expirationDateField.sendKeys(Keys.DELETE);
			Thread.sleep(300);
			Actions actionsExpiry = new Actions(driver);
			actionsExpiry.moveToElement(expirationDateField).click().perform();
			for (char c : "1231".toCharArray()) {
				actionsExpiry.sendKeys(String.valueOf(c)).perform();
				Thread.sleep(150);
			}
			Thread.sleep(1000);
			js.executeScript(
				"var el = arguments[0];" +
				"var s = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
				"s.call(el,'1231');" +
				"el.dispatchEvent(new Event('input',{bubbles:true}));" +
				"el.dispatchEvent(new Event('change',{bubbles:true}));" +
				"el.dispatchEvent(new KeyboardEvent('keyup',{bubbles:true}));", expirationDateField);
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.PASS, "Entered '1231' in Expiration Date field successfully");
			System.out.println("PASS: Entered '1231' in Expiration Date field successfully");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter Expiration Date - " + e.getMessage());
			System.out.println("FAIL: Failed to enter Expiration Date - " + e.getMessage());
		}

		// Step 13: Enter CVC '123' in iframe
		try {
			driver.switchTo().defaultContent();
			By[] cvcLocators = {
				By.id("cvc-input"),
				By.xpath("//input[@id='cvc-input']"),
				By.xpath("//input[@name='cvc']"),
				By.xpath("//input[@placeholder='CVC']"),
				By.xpath("//input[@placeholder='CVV']"),
				By.xpath("//input[@placeholder='Security Code']"),
				By.xpath("//input[@aria-label='CVC']"),
				By.xpath("//input[contains(@class,'cvc') or contains(@id,'cvc') or contains(@name,'cvc')]")
			};
			WebElement cvcField = null;
			int totalIframes = driver.findElements(By.tagName("iframe")).size();
			System.out.println("INFO: Total iframes found for CVC field: " + totalIframes);
			outerLoop:
			for (int i = 0; i < totalIframes; i++) {
				for (By locator : cvcLocators) {
					try {
						driver.switchTo().defaultContent();
						driver.switchTo().frame(i);
						java.util.List<WebElement> found = driver.findElements(locator);
						if (!found.isEmpty()) { cvcField = found.get(0); break outerLoop; }
					} catch (Exception ex) { /* try next */ }
				}
			}
			if (cvcField == null) {
				driver.switchTo().defaultContent();
				for (By locator : cvcLocators) {
					java.util.List<WebElement> found = driver.findElements(locator);
					if (!found.isEmpty()) { cvcField = found.get(0); break; }
				}
			}
			if (cvcField == null) throw new Exception("CVC input field could not be located.");

			js.executeScript("arguments[0].scrollIntoView(true);", cvcField);
			Thread.sleep(300);
			js.executeScript("arguments[0].removeAttribute('disabled')", cvcField);
			js.executeScript("arguments[0].removeAttribute('readonly')", cvcField);
			cvcField.click();
			Thread.sleep(300);
			cvcField.sendKeys(Keys.CONTROL + "a");
			cvcField.sendKeys(Keys.DELETE);
			Thread.sleep(300);
			Actions actionsCvc = new Actions(driver);
			actionsCvc.moveToElement(cvcField).click().perform();
			actionsCvc.sendKeys("1").perform(); Thread.sleep(150);
			actionsCvc.sendKeys("2").perform(); Thread.sleep(150);
			actionsCvc.sendKeys("3").perform(); Thread.sleep(150);
			Thread.sleep(500);
			js.executeScript(
				"var el = arguments[0];" +
				"var s = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
				"s.call(el,'123');" +
				"el.dispatchEvent(new Event('input',{bubbles:true}));" +
				"el.dispatchEvent(new Event('change',{bubbles:true}));", cvcField);
			Thread.sleep(500);

			// Enter postal code
			try {
				bs.getPostalCodeTextfieldinframe().sendKeys("58965");
				Thread.sleep(500);
			} catch (Exception postalEx) {
				System.out.println("INFO: Postal code field not found - " + postalEx.getMessage());
			}
			utilityclassobject.gettest().log(Status.PASS, "Entered CVC '123' and postal code successfully");
			System.out.println("PASS: Entered CVC '123' and postal code successfully");

			// Switch back to default content before clicking Save
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			bs = new BillingSettings(driver);

			// Click Save button
			By[] saveBtnLocators = {
				By.xpath("//button[.//span[text()='Save']]"),
				By.xpath("//button[normalize-space()='Save']"),
				By.xpath("//button[contains(text(),'Save')]"),
				By.xpath("//span[text()='Save']/ancestor::button")
			};
			boolean saveBtnClicked = false;
			for (By saveLoc : saveBtnLocators) {
				try {
					WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveLoc));
					js.executeScript("arguments[0].scrollIntoView(true);", saveBtn);
					Thread.sleep(500);
					try { saveBtn.click(); } catch (Exception ce) { js.executeScript("arguments[0].click();", saveBtn); }
					Thread.sleep(3000);
					saveBtnClicked = true;
					utilityclassobject.gettest().log(Status.PASS, "Clicked Save button successfully");
					System.out.println("PASS: Clicked Save button successfully using: " + saveLoc);
					break;
				} catch (Exception ex) {
					System.out.println("INFO: Save button not found with: " + saveLoc);
				}
			}
			if (!saveBtnClicked) {
				utilityclassobject.gettest().log(Status.FAIL, "Failed to click Save button - no locator matched");
				System.out.println("FAIL: Failed to click Save button");
			}
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			utilityclassobject.gettest().log(Status.FAIL, "Exception in CVC/Save step - " + e.getMessage());
			System.out.println("FAIL: Exception in CVC/Save step - " + e.getMessage());
		}

		// Wait for page to settle after saving payment method
		Thread.sleep(7000);

		// Step 14: Verify 'Raju' payment card is added and scroll to it
		try {
			WebElement paymentCard = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[normalize-space(text())='"+acname+"'] | //p[normalize-space(text())='Raju']")));

			// Scroll to payment card container
			WebElement scrollTarget = null;
			By[] cardLocators = {
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'border') and contains(@class,'rounded')]"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'p-4')]"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'relative')]"),
				By.xpath("//p[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'border')]")
			};
			for (By loc : cardLocators) {
				try {
					java.util.List<WebElement> cards = driver.findElements(loc);
					if (!cards.isEmpty()) { scrollTarget = cards.get(0); break; }
				} catch (Exception ex) { /* try next */ }
			}
			if (scrollTarget == null) scrollTarget = paymentCard;

			js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center',inline:'nearest'});", scrollTarget);
			Thread.sleep(1500);
			js.executeScript("arguments[0].style.border='3px solid red';", scrollTarget);
			Thread.sleep(500);
			js.executeScript("arguments[0].style.border='';", scrollTarget);

			utilityclassobject.gettest().log(Status.PASS, "New payment method '"+acname+"' added successfully and displayed in the list");
			System.out.println("PASS: New payment method '"+acname+"' added successfully and scrolled into view");

		} catch (Exception e) {	
			utilityclassobject.gettest().log(Status.FAIL, "Failed to verify new payment method - " + e.getMessage());
			System.out.println("FAIL: Failed to verify new payment method - " + e.getMessage());
		}
		driver.findElement(By.xpath("//div[text()='"+acname+"']/ancestor::div[@class='flex-1']/descendant::div[8]")).click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.PASS, "Clicked on Make Default option successfully");
		System.out.println("PASS: Clicked on Make Default option successfully");

		// Step 15: Verify Make Default radio button is selected
		Thread.sleep(2000);
		try {
			boolean isDefaultSelected = false;
			By[] verifyDefaultLocators = {
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[@class='flex-1']/descendant::div[8]"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'border') and contains(@class,'rounded')]/descendant::input[@type='radio']"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'p-4')]/descendant::input[@type='radio']"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/following::input[@type='radio'][1]")
			};
			for (By loc : verifyDefaultLocators) {
				try {
					WebElement radioBtn = driver.findElement(loc);
					isDefaultSelected = radioBtn.isSelected();
					if (!isDefaultSelected) {
						String ariaChecked = radioBtn.getAttribute("aria-checked");
						String cls = radioBtn.getAttribute("class");
						isDefaultSelected = "true".equalsIgnoreCase(ariaChecked)
							|| (cls != null && (cls.contains("checked") || cls.contains("selected") || cls.contains("active") || cls.contains("bg-")));
					}
					break;
				} catch (Exception ex) { /* try next */ }
			}
			if (isDefaultSelected) {
				utilityclassobject.gettest().log(Status.PASS, "'"+acname+"' payment method is set as Default successfully");
				System.out.println("PASS: '"+acname+"' payment method is set as Default successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "'"+acname+"' Make Default radio button is NOT selected");
				System.out.println("FAIL: '"+acname+"' Make Default radio button is NOT selected");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Exception verifying Make Default - " + e.getMessage());
			System.out.println("FAIL: Exception verifying Make Default - " + e.getMessage());
		}

		// Step 16: Delete the newly added payment card
		Thread.sleep(2000);
		try {
			By[] deleteIconLocators = {
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'border') and contains(@class,'rounded')]/descendant::button[contains(@aria-label,'delete') or contains(@aria-label,'Delete') or contains(@aria-label,'remove')]"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'border') and contains(@class,'rounded')]/descendant::svg/ancestor::button[1]"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'p-4')]/descendant::button[last()]"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'border')]/descendant::button[last()]"),
				By.xpath("//div[normalize-space(text())='"+acname+"']/ancestor::div[contains(@class,'relative')]/descendant::button[last()]")
			};
			boolean deleteIconClicked = false;
			for (By loc : deleteIconLocators) {
				try {
					java.util.List<WebElement> btns = driver.findElements(loc);
					if (!btns.isEmpty()) {
						WebElement iconBtn = btns.get(btns.size() - 1);
						js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", iconBtn);
						Thread.sleep(500);
						try { iconBtn.click(); } catch (Exception ce) { js.executeScript("arguments[0].click();", iconBtn); }
						deleteIconClicked = true;
						utilityclassobject.gettest().log(Status.INFO, "Clicked delete icon on '"+acname+"' card successfully");
						System.out.println("INFO: Clicked delete icon on '"+acname+"' card using: " + loc);
						break;
					}
				} catch (Exception ex) { System.out.println("INFO: Delete icon not found with: " + loc); }
			}
			if (!deleteIconClicked) {
				utilityclassobject.gettest().log(Status.FAIL, "Could not click delete icon on '"+acname+"' payment card");
				System.out.println("FAIL: Could not click delete icon on '"+acname+"' payment card");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Exception clicking delete icon - " + e.getMessage());
			System.out.println("FAIL: Exception clicking delete icon - " + e.getMessage());
		}

		// Step 17: Wait for 'Are you sure?' confirmation popup and click Delete button
		Thread.sleep(5000);
		System.out.println("INFO: Waiting 5 seconds for confirmation popup to appear...");
		Thread.sleep(3000);
		try {
			WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement confirmPopup = null;
			By[] popupLocators = {
				By.xpath("//h3[contains(text(),'Are you sure?')]"),
				By.xpath("//h3[contains(text(),'Are you sure')]"),
				By.xpath("//*[contains(text(),'Are you sure')]"),
				By.xpath("//div[contains(@class,'modal') or contains(@class,'dialog') or contains(@class,'popup')][.//button[normalize-space()='Delete']]")
			};
			for (By pLoc : popupLocators) {
				try {
					confirmPopup = popupWait.until(ExpectedConditions.visibilityOfElementLocated(pLoc));
					System.out.println("INFO: Confirmation popup found using: " + pLoc);
					break;
				} catch (Exception ex) { System.out.println("INFO: Popup not found with: " + pLoc); }
			}

			if (confirmPopup != null) {
				By[] confirmDeleteLocators = {
					By.xpath("//h3[contains(text(),'Are you sure')]/..//button[normalize-space()='Delete']"),
					By.xpath("//h3[contains(text(),'Are you sure')]/../..//button[normalize-space()='Delete']"),
					By.xpath("//h3[contains(text(),'Are you sure')]/ancestor::div[3]//button[normalize-space()='Delete']"),
					By.xpath("//h3[contains(text(),'Are you sure')]/ancestor::div[4]//button[normalize-space()='Delete']"),
					By.xpath("//h3[contains(text(),'Are you sure')]/ancestor::div[contains(@class,'rounded') or contains(@class,'modal') or contains(@class,'dialog')]//button[normalize-space()='Delete']")
				};
				boolean deleteBtnClicked = false;
				for (By loc : confirmDeleteLocators) {
					try {
						WebElement deleteBtn = popupWait.until(ExpectedConditions.presenceOfElementLocated(loc));
						js.executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
						Thread.sleep(300);
						js.executeScript("arguments[0].click();", deleteBtn);
						Thread.sleep(3000);
						deleteBtnClicked = true;
						utilityclassobject.gettest().log(Status.PASS, "Deleted '"+acname+"' payment method successfully");
						System.out.println("PASS: Deleted '"+acname+"' payment method successfully");
						break;
					} catch (Exception ex) { System.out.println("INFO: Delete confirm btn not found with: " + loc); }
				}
				if (!deleteBtnClicked) {
					utilityclassobject.gettest().log(Status.FAIL, "Could not click Delete button in confirmation popup");
					System.out.println("FAIL: Could not click Delete button in confirmation popup");
				}
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Confirmation popup did not appear - skipping Delete to avoid clicking wrong card");
				System.out.println("FAIL: Confirmation popup did not appear");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Exception in delete confirmation step - " + e.getMessage());
			System.out.println("FAIL: Exception in delete confirmation step - " + e.getMessage());
		}
	}
}
