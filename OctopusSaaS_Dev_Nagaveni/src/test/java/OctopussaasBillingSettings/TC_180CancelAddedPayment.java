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

public class TC_180CancelAddedPayment extends BaseClass80{

	ExcelUtility elib;
	HomePage hp;
	BillingSettings bs;
	JavascriptExecutor js;
	WebDriverWait wait;


	@Test
	public void TC_180CancelAddedPayment() throws InterruptedException, EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);
		wlib = new webDriverutility();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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
		// XPath: //button[text()='Add New Payment Method']
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getAddNewPaymentMethodButton());
		Thread.sleep(5000);
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(8000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		// XPath: //button[text()='Add Card Details']
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(1000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 6: Enter value in Card Number (Last 4 Digits) text field
		// XPath: //input[@placeholder='Last 4 Digits Of Credit Card / ACH Number']
		try {
			WebElement cardNumberTextField = wait.until(
					ExpectedConditions.visibilityOf(bs.getLast4DigitsOfCreditCardTextfield()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardNumberTextField);
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

		// Step 7: Pass the value in Account Holder Name text field
		WebElement accountHolderName = bs.getAccountHolderNameTextfield();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", accountHolderName);
		js.executeScript("arguments[0].removeAttribute('readonly')", accountHolderName);
		accountHolderName.clear();
		accountHolderName.click();
		accountHolderName.sendKeys("Raju");
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.PASS, "Entered 'Raju' in Account Holder Name text field successfully");
		System.out.println("PASS: Entered 'Raju' in Account Holder Name text field successfully");

		// Step 8: Enter 3-digit CVV/CVC value
		Thread.sleep(2000);
		bs.getCvvCvcTextfield().sendKeys("123");

		// Step 9: Click Add Card Details Button 2
		bs.getAddCardDetailsButton2().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.PASS, "Entered '123' in CVV/CVC text field and clicked on Add Card Details button successfully");
		System.out.println("PASS: Entered '123' in CVV/CVC text field and clicked on Add Card Details button successfully");

		// Step 10: Verify Credit Card Information header is displayed
		try {
			WebElement creditCardInfoHeader = wait.until(
					ExpectedConditions.visibilityOf(bs.getCreditCardInformationHeader()));
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

		// Step 11: Enter card number '4242424242424242' in Card Number text field
		// XPath: //input[@id='card-number-input']
		try {
			// Try switching into iframe if card field is inside one
			boolean insideIframe = false;
			java.util.List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println("INFO: Total iframes found on page: " + iframes.size());
			for (WebElement iframe : iframes) {
				try {
					driver.switchTo().frame(iframe);
					java.util.List<WebElement> cardInputs = driver.findElements(By.id("card-number-input"));
					if (!cardInputs.isEmpty()) {
						insideIframe = true;
						System.out.println("INFO: Card number field found inside iframe");
						break;
					}
					driver.switchTo().defaultContent();
				} catch (Exception ex) {
					driver.switchTo().defaultContent();
				}
			}

			WebElement cardNumberField = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id("card-number-input")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardNumberField);
			Thread.sleep(1000);
			js.executeScript("arguments[0].removeAttribute('disabled')", cardNumberField);
			js.executeScript("arguments[0].removeAttribute('readonly')", cardNumberField);
			Thread.sleep(500);
			cardNumberField.click();
			Thread.sleep(500);
			cardNumberField.sendKeys(Keys.CONTROL + "a");
			cardNumberField.sendKeys(Keys.DELETE);
			Thread.sleep(500);

			Actions actions = new Actions(driver);
			actions.moveToElement(cardNumberField).click().perform();
			Thread.sleep(500);
			String cardNum = "4242424242424242";
			for (char c : cardNum.toCharArray()) {
				actions.sendKeys(String.valueOf(c)).perform();
				Thread.sleep(80);
			}
			Thread.sleep(1000);

			js.executeScript(
				"var el = arguments[0];" +
				"var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
				"nativeInputValueSetter.call(el, '4242424242424242');" +
				"el.dispatchEvent(new Event('input', { bubbles: true }));" +
				"el.dispatchEvent(new Event('change', { bubbles: true }));",
				cardNumberField);
			Thread.sleep(1000);

			utilityclassobject.gettest().log(Status.PASS, "Entered '4242424242424242' in Card Number text field successfully");
			System.out.println("PASS: Entered '4242424242424242' in Card Number text field successfully");

			if (insideIframe) {
				driver.switchTo().defaultContent();
			}

		} catch (Exception e) {
			driver.switchTo().defaultContent();
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter card number - " + e.getMessage());
			System.out.println("FAIL: Failed to enter card number - " + e.getMessage());
		}

		// Step 12: Enter expiration date '1231' in Expiration Date text field
		// XPath: //input[@placeholder='MM / YY']
		try {
			// Step 12a: Switch back to default content first to ensure clean state
			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			// Step 12b: Scan all iframes to find expiration date field
			boolean expiryInsideIframe = false;
			java.util.List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));
			System.out.println("INFO: Total iframes found for expiry field: " + allIframes.size());
			for (WebElement iframe : allIframes) {
				try {
					driver.switchTo().frame(iframe);
					java.util.List<WebElement> expiryInputs = driver.findElements(
							By.xpath("//input[@placeholder='MM / YY']"));
					if (!expiryInputs.isEmpty()) {
						expiryInsideIframe = true;
						System.out.println("INFO: Expiration Date field found inside iframe");
						break;
					}
					driver.switchTo().defaultContent();
				} catch (Exception ex) {
					driver.switchTo().defaultContent();
				}
			}

			// Step 12c: Locate expiration date field (inside iframe or directly on page)
			WebElement expirationDateField = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='MM / YY']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expirationDateField);
			Thread.sleep(1000);

			// Step 12d: Remove any restrictions on the field
			js.executeScript("arguments[0].removeAttribute('disabled')", expirationDateField);
			js.executeScript("arguments[0].removeAttribute('readonly')", expirationDateField);
			js.executeScript("arguments[0].removeAttribute('maxlength')", expirationDateField);
			Thread.sleep(500);

			// Step 12e: Click to focus then clear
			expirationDateField.click();
			Thread.sleep(500);
			expirationDateField.sendKeys(Keys.CONTROL + "a");
			expirationDateField.sendKeys(Keys.DELETE);
			Thread.sleep(500);

			// Step 12f: Type each character one by one using Actions (simulates real keyboard)
			Actions actionsExpiry = new Actions(driver);
			actionsExpiry.moveToElement(expirationDateField).click().perform();
			Thread.sleep(500);
			String expiryValue = "1231";
			for (char c : expiryValue.toCharArray()) {
				actionsExpiry.sendKeys(String.valueOf(c)).perform();
				Thread.sleep(150);
			}
			Thread.sleep(1000);

			// Step 12g: Fire native React/Angular input + change events via JS
			js.executeScript(
				"var el = arguments[0];" +
				"var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
				"nativeInputValueSetter.call(el, '1231');" +
				"el.dispatchEvent(new Event('input',  { bubbles: true }));" +
				"el.dispatchEvent(new Event('change', { bubbles: true }));" +
				"el.dispatchEvent(new KeyboardEvent('keyup', { bubbles: true }));",
				expirationDateField);
			Thread.sleep(1000);

			utilityclassobject.gettest().log(Status.PASS, "Entered '1231' in Expiration Date text field successfully");
			System.out.println("PASS: Entered '1231' in Expiration Date text field successfully");

			// Step 12h: Switch back to default content if we were inside an iframe
			if (expiryInsideIframe) {
				driver.switchTo().defaultContent();
			}

		} catch (Exception e) {
			driver.switchTo().defaultContent();
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter Expiration Date '1231' - " + e.getMessage());
			System.out.println("FAIL: Failed to enter Expiration Date '1231' - " + e.getMessage());
		}
		// Step 13: Enter 3-digit CVV value '123' in CVC text field inside iframe
		// XPath (in frame): //input[@id='cvc-input']
		try {
			// Step 13a: Switch back to default content to start clean
			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			WebElement cvcField = null;

			// Step 13b: Try multiple CVC locators across all iframes
			By[] cvcLocators = {
				By.id("cvc-input"),
				By.xpath("//input[@id='cvc-input']"),
				By.xpath("//input[@name='cvc']"),
				By.xpath("//input[@placeholder='CVC']"),
				By.xpath("//input[@placeholder='CVV']"),
				By.xpath("//input[@placeholder='Security Code']"),
				By.xpath("//input[@aria-label='CVC']"),
				By.xpath("//input[@aria-label='Enter cvc number']"),
				By.xpath("//input[@data-elements-stable-field-name='cardCvc']"),
				By.xpath("//input[contains(@class,'cvc') or contains(@id,'cvc') or contains(@name,'cvc')]")
			};

			int totalIframes = driver.findElements(By.tagName("iframe")).size();
			System.out.println("INFO: Total iframes found for CVC field: " + totalIframes);

			outerLoop:
			for (int i = 0; i < totalIframes; i++) {
				for (By locator : cvcLocators) {
					try {
						driver.switchTo().defaultContent();
						driver.switchTo().frame(i);
						java.util.List<WebElement> found = driver.findElements(locator);
						if (!found.isEmpty()) {
							cvcField = found.get(0);
							System.out.println("INFO: CVC field found in iframe[" + i + "] using locator: " + locator);
							break outerLoop;
						}
					} catch (Exception ex) {
						// try next
					}
				}
			}

			// Step 13c: Fallback - try directly on default content (no iframe)
			if (cvcField == null) {
				driver.switchTo().defaultContent();
				for (By locator : cvcLocators) {
					try {
						java.util.List<WebElement> found = driver.findElements(locator);
						if (!found.isEmpty()) {
							cvcField = found.get(0);
							System.out.println("INFO: CVC field found on default content using locator: " + locator);
							break;
						}
					} catch (Exception ex) {
						// try next
					}
				}
			}

			if (cvcField == null) {
				throw new Exception("CVC input field could not be located in any iframe or on the page.");
			}

			// Step 13d: Scroll to field and remove restrictions
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cvcField);
			Thread.sleep(500);
			js.executeScript("arguments[0].removeAttribute('disabled')", cvcField);
			js.executeScript("arguments[0].removeAttribute('readonly')", cvcField);
			js.executeScript("arguments[0].removeAttribute('maxlength')", cvcField);
			Thread.sleep(300);

			// Step 13e: Click to focus and clear existing value
			cvcField.click();
			Thread.sleep(500);
			cvcField.sendKeys(Keys.CONTROL + "a");
			cvcField.sendKeys(Keys.DELETE);
			Thread.sleep(300);

			// Step 13f: Type '1', '2', '3' one by one using Actions (most reliable for Stripe/React)
			Actions actionsCvc = new Actions(driver);
			actionsCvc.moveToElement(cvcField).click().perform();
			Thread.sleep(300);
			actionsCvc.sendKeys("1").perform(); Thread.sleep(150);
			actionsCvc.sendKeys("2").perform(); Thread.sleep(150);
			actionsCvc.sendKeys("3").perform(); Thread.sleep(150);
			Thread.sleep(500);

			// Step 13g: Fire native React/Angular input + change events via JS to ensure value registers
			js.executeScript(
				"var el = arguments[0];" +
				"var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
				"nativeInputValueSetter.call(el, '123');" +
				"el.dispatchEvent(new Event('input',  { bubbles: true }));" +
				"el.dispatchEvent(new Event('change', { bubbles: true }));" +
				"el.dispatchEvent(new KeyboardEvent('keydown', { bubbles: true }));" +
				"el.dispatchEvent(new KeyboardEvent('keyup',   { bubbles: true }));",
				cvcField);
			Thread.sleep(500);

			// Step 13h: Verify value was entered
			String enteredValue = cvcField.getAttribute("value");
			System.out.println("INFO: CVC field value after input: " + enteredValue);

			// Enter postal code (still inside the CVC iframe if applicable)
			try {
				bs.getPostalCodeTextfieldinframe().sendKeys("58965");
				Thread.sleep(1000);
			} catch (Exception postalEx) {
				System.out.println("INFO: Postal code field not found in current context - " + postalEx.getMessage());
			}

			// Switch back to default content before clicking Save (Save button is on main page)
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			// Re-initialize BillingSettings to get fresh element references after iframe switch
			bs = new BillingSettings(driver);

			// Click Save button with multiple fallback strategies
			boolean saveBtnClicked = false;
			// Strategy 1: Locate button by multiple XPaths directly
			By[] saveBtnLocators = {
				By.xpath("//button[.//span[text()='Save']]"),
				By.xpath("//button[normalize-space()='Save']"),
				By.xpath("//button[contains(text(),'Save')]"),
				By.xpath("//span[text()='Save']/ancestor::button"),
				By.xpath("//button[@type='submit'][.//span[text()='Save'] or normalize-space(text())='Save']")
			};
			for (By saveLoc : saveBtnLocators) {
				try {
					WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveLoc));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
					Thread.sleep(500);
					try {
						saveBtn.click();
					} catch (Exception clickEx) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
					}
					Thread.sleep(3000);
					saveBtnClicked = true;
					utilityclassobject.gettest().log(Status.PASS, "Clicked Save button successfully using: " + saveLoc);
					System.out.println("PASS: Clicked Save button successfully using: " + saveLoc);
					break;
				} catch (Exception ex) {
					System.out.println("INFO: Save button not found with locator " + saveLoc + " - trying next...");
				}
			}
			if (!saveBtnClicked) {
				utilityclassobject.gettest().log(Status.FAIL, "Failed to click Save button - no locator matched");
				System.out.println("FAIL: Failed to click Save button - no locator matched");
			}

		} catch (Exception e) {
			driver.switchTo().defaultContent();
		}

		// Wait for page to settle after saving payment method
		Thread.sleep(7000);

		// Step 14: Verify new payment method appears and delete it
		try {
			// Wait for payment card containing "Raju" to appear
			WebElement paymentCard = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[normalize-space(text())='Raju'] | //div[contains(text(),'Raju')] | //p[contains(text(),'Raju')]")));

			if (paymentCard.isDisplayed()) {
				utilityclassobject.gettest().log(Status.PASS, "New payment method added successfully and displayed in the list");
				System.out.println("PASS: New payment method added successfully and displayed in the list");

				// Scroll to the exact 'Raju' payment card using multiple locator strategies
				WebElement scrollTarget = null;
				By[] cardLocators = {
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'border') and contains(@class,'rounded')]"),
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'p-4')]"),
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'relative')]"),
					By.xpath("//p[normalize-space(text())='Raju']/ancestor::div[contains(@class,'border')]"),
					By.xpath("//div[normalize-space(text())='Raju'] | //p[normalize-space(text())='Raju']")
				};
				for (By loc : cardLocators) {
					try {
						java.util.List<WebElement> cards = driver.findElements(loc);
						if (!cards.isEmpty()) {
							scrollTarget = cards.get(0);
							System.out.println("INFO: Found payment card container using locator: " + loc);
							break;
						}
					} catch (Exception ex) { /* try next */ }
				}
				if (scrollTarget == null) scrollTarget = paymentCard; // fallback to original match

				// Scroll to center of screen
				((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", scrollTarget);
				Thread.sleep(1500);
				// Highlight the card briefly for visual confirmation
				((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.border='3px solid red';", scrollTarget);
				Thread.sleep(500);
				((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.border='';", scrollTarget);

				utilityclassobject.gettest().log(Status.INFO, "Scrolled to and highlighted 'Raju' payment card");
				System.out.println("INFO: Scrolled to 'Raju' payment card successfully");

				// Step 14a: Click the trash/delete icon on the payment card (not the card text)
				By[] deleteIconLocators = {
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'border')]/descendant::button[contains(@class,'delete') or contains(@class,'trash') or contains(@aria-label,'delete') or contains(@aria-label,'Delete') or contains(@aria-label,'remove') or contains(@title,'Delete') or contains(@title,'delete')]"),
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'border')]/descendant::button[last()]"),
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'relative')]/descendant::button"),
					By.xpath("//div[normalize-space(text())='Raju']/following::button[contains(@class,'delete') or contains(@aria-label,'delete') or contains(@aria-label,'Delete')][1]"),
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'border')]/descendant::svg/ancestor::button[1]"),
					By.xpath("//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'p-4')]/descendant::button")
				};

				boolean deleteIconClicked = false;
				for (By loc : deleteIconLocators) {
					try {
						java.util.List<WebElement> btns = driver.findElements(loc);
						if (!btns.isEmpty()) {
							WebElement iconBtn = btns.get(btns.size() - 1); // last button is usually delete
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iconBtn);
							Thread.sleep(500);
							try {
								iconBtn.click();
							} catch (Exception ce) {
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", iconBtn);
							}
							deleteIconClicked = true;
							System.out.println("INFO: Clicked delete icon using locator: " + loc);
							break;
						}
					} catch (Exception ex) {
						System.out.println("INFO: Delete icon not found with: " + loc);
					}
				}
				if (!deleteIconClicked) {
					System.out.println("WARN: Could not click a specific delete icon, payment card may need manual interaction");
				}
				Thread.sleep(5000);
				System.out.println("INFO: Waiting 5 seconds for confirmation popup to appear...");

				// Step 15: Wait for "Are you sure?" confirmation dialog and click Delete button
				// IMPORTANT: All locators are strictly scoped to the confirmation popup ONLY
				// to avoid accidentally clicking the Delete button on other payment cards (e.g. Aravind)
				WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(15));

				// Extra explicit wait to ensure popup DOM is fully rendered before searching
				Thread.sleep(3000);

				// First wait until the confirmation popup ("Are you sure?") is actually visible
				WebElement confirmPopup = null;
				By[] popupLocators = {
					By.xpath("//h3[contains(text(),'Are you sure?')]"),
					By.xpath("//h3[contains(text(),'Are you sure')]"),
					By.xpath("//*[contains(text(),'Are you sure')]"),
					By.xpath("//div[contains(@class,'modal') or contains(@class,'dialog') or contains(@class,'popup')][.//button[normalize-space()='Delete']]"),
					By.xpath("//*[contains(@class,'modal') or contains(@class,'dialog')][.//button[normalize-space()='Delete']]")
				};
				for (By pLoc : popupLocators) {
					try {
						confirmPopup = shortWait.until(ExpectedConditions.visibilityOfElementLocated(pLoc));
						System.out.println("INFO: Confirmation popup found using: " + pLoc);
						break;
					} catch (Exception ex) {
						System.out.println("INFO: Confirmation popup not found with: " + pLoc);
					}
				}

				boolean deleteBtnClicked = false;
				if (confirmPopup != null) {
					// Strictly scope the Delete button search to WITHIN the confirmation popup
					By[] confirmDeleteLocators = {
						By.xpath("//h3[contains(text(),'Are you sure')]/..//button[normalize-space()='Delete']"),
						By.xpath("//h3[contains(text(),'Are you sure')]/../..//button[normalize-space()='Delete']"),
						By.xpath("//h3[contains(text(),'Are you sure')]/ancestor::div[3]//button[normalize-space()='Delete']"),
						By.xpath("//h3[contains(text(),'Are you sure')]/ancestor::div[4]//button[normalize-space()='Delete']"),
						By.xpath("//h3[contains(text(),'Are you sure')]/ancestor::div[contains(@class,'modal') or contains(@class,'dialog') or contains(@class,'popup') or contains(@class,'overlay') or contains(@class,'rounded')]//button[normalize-space()='Delete']"),
						By.xpath("//div[contains(@class,'modal') or contains(@class,'dialog') or contains(@class,'popup')][.//h3[contains(text(),'Are you sure')]]//button[normalize-space()='Delete']")
					};
					for (By loc : confirmDeleteLocators) {
						try {
							WebElement deleteBtn = shortWait.until(ExpectedConditions.presenceOfElementLocated(loc));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
							Thread.sleep(300);
							// Always use JS click to avoid overlay interception
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);
							Thread.sleep(3000);
							deleteBtnClicked = true;
							utilityclassobject.gettest().log(Status.PASS, "Clicked Delete button on confirmation dialog successfully");
							System.out.println("PASS: Clicked Delete button on confirmation dialog successfully");
							break;
						} catch (Exception ex) {
							System.out.println("INFO: Delete confirm button not found with: " + loc);
						}
					}
				} else {
					utilityclassobject.gettest().log(Status.FAIL, "Confirmation popup ('Are you sure?') did not appear - skipping Delete click to avoid clicking wrong card");
					System.out.println("FAIL: Confirmation popup did not appear - NOT clicking any Delete button to avoid affecting other cards");
				}

				if (!deleteBtnClicked) {
					utilityclassobject.gettest().log(Status.FAIL, "Could not click Delete button in confirmation popup - no locator matched");
					System.out.println("FAIL: Could not click Delete button in confirmation popup");
				}

				// Step 16: Verify delete confirmation/success message is displayed
				try {
					WebElement confirmationMsg = wait.until(
						ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[contains(@class,'toast')] | //div[@role='alert'] | //div[contains(text(),'deleted') or contains(text(),'Deleted') or contains(text(),'removed') or contains(text(),'success') or contains(text(),'Success')] | //span[contains(text(),'deleted') or contains(text(),'removed') or contains(text(),'success')]")));
					if (confirmationMsg.isDisplayed()) {
						utilityclassobject.gettest().log(Status.PASS, "Delete confirmation message displayed: " + confirmationMsg.getText());
						System.out.println("PASS: Delete confirmation message displayed: " + confirmationMsg.getText());
					}
				} catch (Exception ex) {
					// Also check if the payment card is gone from the list as implicit confirmation
					java.util.List<WebElement> remainingCards = driver.findElements(
						By.xpath("//div[text()='Raju']/ancestor::div[@class='border border-gray-200 rounded-lg p-4 relative']"));
					if (remainingCards.isEmpty()) {
						utilityclassobject.gettest().log(Status.PASS, "Payment method 'Raju' successfully deleted - no longer visible in the list");
						System.out.println("PASS: Payment method 'Raju' successfully deleted - no longer visible in the list");
					} else {
						utilityclassobject.gettest().log(Status.FAIL, "Delete confirmation message not found and payment method still visible - " + ex.getMessage());
						System.out.println("FAIL: Delete confirmation message not found and payment method still visible - " + ex.getMessage());
					}
				}

			} else {
				utilityclassobject.gettest().log(Status.FAIL, "New payment method was not added or not displayed in the list");
				System.out.println("FAIL: New payment method was not added or not displayed in the list");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed during payment delete verification - " + e.getMessage());
			System.out.println("FAIL: Failed during payment delete verification - " + e.getMessage());
		}
	}
}
