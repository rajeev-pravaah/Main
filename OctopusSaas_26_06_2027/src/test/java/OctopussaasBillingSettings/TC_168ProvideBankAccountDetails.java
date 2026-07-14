package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClass80;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.BillingSettings;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)
public class TC_168ProvideBankAccountDetails extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_168ProvideBankAccountDetails() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);
		wlib = new webDriverutility();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js = (JavascriptExecutor) driver;

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
		Thread.sleep(1000);
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(5000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(8000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 6: Enter last 4 digits in credit card number field
		bs.getLast4DigitsOfCreditCardTextfield().sendKeys(elib.getDataFromExcel("BillingSettings", 4, 1));
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Entered last 4 digits of credit card successfully");
		System.out.println("INFO: Entered last 4 digits of credit card successfully");

		// Step 7: Enter Account Holder Name (outside iframe - credit card section)
		bs.getAccountHolderNameTextfield().sendKeys("Rajeev");
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Entered account holder name 'Rajeev' successfully");
		System.out.println("INFO: Entered account holder name 'Rajeev' successfully");

		// Step 8: Click on ACH radio button
		bs.getACHradiobtn().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on ACH radio button successfully");
		System.out.println("INFO: Clicked on ACH radio button successfully");

		// Step 9: Click on Add Card Details button
		bs.getAddCardDetailsButton().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 10: Verify that Bank Account Information is displayed
		try {
			WebElement bankAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//label[contains(text(),'Bank Account Information')]")));
			if (bankAccountInfo.isDisplayed()) {
				utilityclassobject.gettest().log(Status.PASS, "Bank account information is displayed successfully");
				System.out.println("PASS: Bank account information is displayed successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Bank account information is not displayed");
				System.out.println("FAIL: Bank account information is not displayed");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Bank account information section not found - " + e.getMessage());
			System.out.println("FAIL: Bank account information section not found - " + e.getMessage());
		}
		Thread.sleep(5000);

		// ======================================================
		// Step 11: Switch into iframe → Enter Account Holder Name,
		//          Select Account Type = Business, Click Instant radio,
		//          Click Provide bank account details, Verify popup
		// ======================================================

		// Find the iframe that contains the ACH form (field-_r_0_)
		int targetIframeIndex = -1;
		List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));
		System.out.println("INFO: Total iframes found: " + allIframes.size());

		for (int i = 0; i < allIframes.size(); i++) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(allIframes.get(i));
				List<WebElement> check = driver.findElements(By.id("field-_r_0_"));
				if (!check.isEmpty()) {
					targetIframeIndex = i;
					System.out.println("INFO: ACH form found in iframe[" + i + "]");
					break;
				}
				driver.switchTo().defaultContent();
			} catch (Exception ex) {
				driver.switchTo().defaultContent();
			}
		}

		if (targetIframeIndex == -1) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			System.out.println("WARN: ACH iframe not found by scan, falling back to iframe[0]");
		}

		// 11a: Enter Account Holder Name as "Rajeev" inside iframe
		try {
			WebElement accountHolderField = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("field-_r_0_")));
			js.executeScript("arguments[0].scrollIntoView(true);", accountHolderField);
			Thread.sleep(500);
			accountHolderField.click();
			accountHolderField.clear();
			accountHolderField.sendKeys("Rajeev");
			Thread.sleep(500);
			utilityclassobject.gettest().log(Status.INFO, "Entered Account Holder Name 'Rajeev' inside iframe successfully");
			System.out.println("INFO: Entered Account Holder Name 'Rajeev' inside iframe successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter Account Holder Name inside iframe: " + e.getMessage());
			System.out.println("FAIL: Could not enter Account Holder Name - " + e.getMessage());
		}

		// 11b: Select Account Type as "Business" inside iframe
		try {
			WebElement accountTypeDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("field-_r_1_")));
			js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
			Thread.sleep(500);
			Select accountTypeSelect = new Select(accountTypeDropdown);

			// Log all available options
			List<WebElement> allOptions = accountTypeSelect.getOptions();
			System.out.println("INFO: Account Type dropdown options count: " + allOptions.size());
			for (int j = 0; j < allOptions.size(); j++) {
				System.out.println("INFO: Option[" + j + "] = '" + allOptions.get(j).getText().trim() + "'");
			}

			accountTypeSelect.selectByVisibleText("Business");
			Thread.sleep(500);
			utilityclassobject.gettest().log(Status.INFO, "Selected Account Type as 'Business' inside iframe successfully");
			System.out.println("INFO: Selected Account Type as 'Business' inside iframe successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to select Account Type 'Business' inside iframe: " + e.getMessage());
			System.out.println("FAIL: Could not select Account Type - " + e.getMessage());
		}

		// 11c: Click Instant radio button inside iframe
		try {
			WebElement instantRadio = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("instant")));
			js.executeScript("arguments[0].scrollIntoView(true);", instantRadio);
			Thread.sleep(300);
			js.executeScript("arguments[0].click();", instantRadio);
			Thread.sleep(500);
			utilityclassobject.gettest().log(Status.INFO, "Clicked Instant radio button inside iframe successfully");
			System.out.println("INFO: Clicked Instant radio button inside iframe successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to click Instant radio button inside iframe: " + e.getMessage());
			System.out.println("FAIL: Could not click Instant radio button - " + e.getMessage());
		}

		// 11d: Click "Provide bank account details" button inside iframe
		//      Retry clicking until the popup is displayed (up to 5 attempts)
		boolean popupDisplayed = false;
		int maxAttempts = 5;

		// XPath variants to try for the button
		String[] btnXpaths = {
			"//button[normalize-space(text())='Provide bank account details']",
			"//button[contains(text(),'Provide bank account')]",
			"//button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'provide bank account')]",
			"//*[@type='button' and contains(text(),'Provide bank')]",
			"//*[contains(@class,'btn') and contains(text(),'bank account')]"
		};

		Actions actions = new Actions(driver);

		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			try {
				// Make sure we are inside the correct iframe before each attempt
				driver.switchTo().defaultContent();
				allIframes = driver.findElements(By.tagName("iframe"));
				System.out.println("INFO: Attempt [" + attempt + "] - Total iframes: " + allIframes.size());

				// Re-scan for the correct iframe every attempt
				int foundIframe = -1;
				for (int i = 0; i < allIframes.size(); i++) {
					try {
						driver.switchTo().defaultContent();
						driver.switchTo().frame(allIframes.get(i));
						List<WebElement> checkBtn = driver.findElements(
								By.xpath("//button[contains(text(),'Provide bank') or contains(text(),'bank account')]"));
						if (!checkBtn.isEmpty()) {
							foundIframe = i;
							System.out.println("INFO: Attempt [" + attempt + "] - 'Provide bank account details' button found in iframe[" + i + "]");
							break;
						}
						driver.switchTo().defaultContent();
					} catch (Exception ex) {
						driver.switchTo().defaultContent();
					}
				}

				// Fall back to previously detected iframe if button not found by scan
				if (foundIframe == -1) {
					driver.switchTo().defaultContent();
					if (targetIframeIndex != -1 && targetIframeIndex < allIframes.size()) {
						driver.switchTo().frame(allIframes.get(targetIframeIndex));
						System.out.println("WARN: Attempt [" + attempt + "] - Button not found by scan, using stored iframe[" + targetIframeIndex + "]");
					} else if (!allIframes.isEmpty()) {
						driver.switchTo().frame(allIframes.get(0));
						System.out.println("WARN: Attempt [" + attempt + "] - Falling back to iframe[0]");
					}
				}

				Thread.sleep(1000);

				// Try each XPath variant to locate and click the button
				WebElement provideBankBtn = null;
				for (String xpath : btnXpaths) {
					try {
						List<WebElement> found = driver.findElements(By.xpath(xpath));
						if (!found.isEmpty()) {
							provideBankBtn = found.get(0);
							System.out.println("INFO: Attempt [" + attempt + "] - Button found using xpath: " + xpath);
							break;
						}
					} catch (Exception xe) { /* try next */ }
				}

				if (provideBankBtn == null) {
					// List all buttons inside iframe for debugging
					List<WebElement> allBtns = driver.findElements(By.tagName("button"));
					System.out.println("INFO: Attempt [" + attempt + "] - All buttons in current iframe: " + allBtns.size());
					for (WebElement b : allBtns) {
						System.out.println("  Button text: '" + b.getText().trim() + "' | class: '" + b.getAttribute("class") + "'");
					}
					throw new Exception("'Provide bank account details' button not found with any XPath variant");
				}

				// Scroll into view
				js.executeScript("arguments[0].scrollIntoView({block:'center'});", provideBankBtn);
				Thread.sleep(500);

				// Try normal click first, then JS click, then Actions click
				try {
					provideBankBtn.click();
					System.out.println("INFO: Attempt [" + attempt + "] - Normal click succeeded on 'Provide bank account details'");
				} catch (Exception ce) {
					try {
						js.executeScript("arguments[0].click();", provideBankBtn);
						System.out.println("INFO: Attempt [" + attempt + "] - JS click succeeded on 'Provide bank account details'");
					} catch (Exception je) {
						actions.moveToElement(provideBankBtn).click().perform();
						System.out.println("INFO: Attempt [" + attempt + "] - Actions click succeeded on 'Provide bank account details'");
					}
				}

				utilityclassobject.gettest().log(Status.INFO,
						"Attempt [" + attempt + "] - Clicked 'Provide bank account details' button");
				Thread.sleep(3000);

				// ---- Check for popup in DEFAULT content ----
				driver.switchTo().defaultContent();
				Thread.sleep(1000);

				// Check in default content
				List<WebElement> popupInDefault = driver.findElements(
						By.xpath("//*[contains(@class,'modal') or contains(@class,'popup') or contains(@class,'dialog') or contains(@class,'overlay')]"));
				List<WebElement> bankTextInDefault = driver.findElements(
						By.xpath("//*[contains(text(),'Routing Number') or contains(text(),'routing') or contains(text(),'Account Number') or contains(text(),'Bank Account')]"));

				if (!popupInDefault.isEmpty() || !bankTextInDefault.isEmpty()) {
					popupDisplayed = true;
					utilityclassobject.gettest().log(Status.PASS,
							"Attempt [" + attempt + "] - Bank account details popup is displayed in default content");
					System.out.println("PASS: Attempt [" + attempt + "] - Popup visible in default content");
					break;
				}

				// ---- Check for popup inside each iframe ----
				allIframes = driver.findElements(By.tagName("iframe"));
				for (int fi = 0; fi < allIframes.size(); fi++) {
					try {
						driver.switchTo().defaultContent();
						driver.switchTo().frame(allIframes.get(fi));
						List<WebElement> bankTextInIframe = driver.findElements(
								By.xpath("//*[contains(text(),'Routing Number') or contains(text(),'routing') or contains(text(),'Account Number') or contains(text(),'Bank Account')]"));
						List<WebElement> popupInIframe = driver.findElements(
								By.xpath("//*[contains(@class,'modal') or contains(@class,'popup') or contains(@class,'dialog')]"));
						if (!bankTextInIframe.isEmpty() || !popupInIframe.isEmpty()) {
							popupDisplayed = true;
							utilityclassobject.gettest().log(Status.PASS,
									"Attempt [" + attempt + "] - Bank account details popup is displayed inside iframe[" + fi + "]");
							System.out.println("PASS: Attempt [" + attempt + "] - Popup visible inside iframe[" + fi + "]");
							break;
						}
						driver.switchTo().defaultContent();
					} catch (Exception iframeEx) {
						driver.switchTo().defaultContent();
					}
				}

				if (popupDisplayed) break;

				System.out.println("INFO: Attempt [" + attempt + "] - Popup not yet visible, retrying...");
				utilityclassobject.gettest().log(Status.INFO,
						"Attempt [" + attempt + "] - Popup not yet visible, retrying...");
				driver.switchTo().defaultContent();
				Thread.sleep(1500);

			} catch (Exception e) {
				driver.switchTo().defaultContent();
				utilityclassobject.gettest().log(Status.FAIL,
						"Attempt [" + attempt + "] - Failed: " + e.getMessage());
				System.out.println("FAIL: Attempt [" + attempt + "] - " + e.getMessage());
				Thread.sleep(1500);
			}
		}

		// Final result after all attempts
		if (!popupDisplayed) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Bank account details popup did NOT appear after " + maxAttempts + " attempts");
			System.out.println("FAIL: Bank account details popup did NOT appear after " + maxAttempts + " attempts");
		}

		// Ensure we are back on default content
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
}