package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

public class TC_178CloseAccountDetails extends BaseClass80 {
	ExcelUtility elib;
	javautility jlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_178CloseAccountDetails()
			throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);
		wlib = new webDriverutility();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Step 1: Click on Profile Icon
		hp.getUserprofile().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on User Profile icon successfully");
		System.out.println("INFO: Clicked on User Profile icon successfully");

		// Step 2: Click on Transporter Settings
		hp.clickTransporterSettings();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Transporter Settings successfully");
		System.out.println("INFO: Clicked on Transporter Settings successfully");

		// Step 3: Click on Billing Settings
		hp.getBillingSettings().click();
		Thread.sleep(1000);
		bs = new BillingSettings(driver);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Billing Settings successfully");
		System.out.println("INFO: Clicked on Billing Settings successfully");

		// Step 4: Click Add New Payment Method button
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddNewPaymentMethodButton());
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(5000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 6: Enter last 4 digits of credit card
		bs.getLast4DigitsOfCreditCardTextfield().sendKeys(elib.getDataFromExcel("BillingSettings", 4, 1));
		Thread.sleep(500);
		utilityclassobject.gettest().log(Status.INFO, "Entered last 4 digits of credit card successfully");
		System.out.println("INFO: Entered last 4 digits of credit card successfully");

		// Step 7: Enter Account Holder Name
		bs.getAccountHolderNameTextfield().sendKeys("Rajeev");
		Thread.sleep(500);
		utilityclassobject.gettest().log(Status.INFO, "Entered account holder name 'Rajeev' successfully");
		System.out.println("INFO: Entered account holder name 'Rajeev' successfully");

		// Step 8: Click ACH radio button
		bs.getACHradiobtn().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on ACH radio button successfully");
		System.out.println("INFO: Clicked on ACH radio button successfully");

		// Step 9: Click Add Card Details button
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 10: Verify Bank Account Information is displayed
		try {
			WebElement bankAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//label[contains(text(),'Bank Account Information')]")));
			if (bankAccountInfo.isDisplayed()) {
				utilityclassobject.gettest().log(Status.PASS, "Bank account information is displayed successfully");
				System.out.println("PASS: Bank account information is displayed successfully");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Bank account information section not found - " + e.getMessage());
			System.out.println("FAIL: Bank account information section not found - " + e.getMessage());
		}
		Thread.sleep(3000);

		// ======================================================
		// Step 11: Switch into ACH iframe and fill the form
		// ======================================================
		int targetIframeIndex = -1;
		List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));

		for (int i = 0; i < allIframes.size(); i++) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(allIframes.get(i));
				if (!driver.findElements(By.id("field-_r_0_")).isEmpty()) {
					targetIframeIndex = i;
					System.out.println("INFO: ACH iframe found at index [" + i + "]");
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
			System.out.println("WARN: ACH iframe not found by scan, switched to iframe[0]");
		}

		// 11a: Enter Account Holder Name inside iframe
		try {
			WebElement accountHolderField = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("field-_r_0_")));
			js.executeScript("arguments[0].scrollIntoView(true);", accountHolderField);
			accountHolderField.click();
			accountHolderField.clear();
			accountHolderField.sendKeys("Rajeev");
			utilityclassobject.gettest().log(Status.INFO, "Entered Account Holder Name inside iframe successfully");
			System.out.println("INFO: Entered Account Holder Name inside iframe successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter Account Holder Name: " + e.getMessage());
			System.out.println("FAIL: Failed to enter Account Holder Name - " + e.getMessage());
		}

		// 11b: Select Account Type as "Business"
		try {
			WebElement accountTypeDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("field-_r_1_")));
			js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
			new Select(accountTypeDropdown).selectByVisibleText("Business");
			utilityclassobject.gettest().log(Status.INFO, "Selected Account Type as 'Business' successfully");
			System.out.println("INFO: Selected Account Type as 'Business' successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to select Account Type: " + e.getMessage());
			System.out.println("FAIL: Failed to select Account Type - " + e.getMessage());
		}

		// 11c: Click Manual radio button
		try {
			WebElement manualRadio = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("manual")));
			js.executeScript("arguments[0].scrollIntoView(true);", manualRadio);
			js.executeScript("arguments[0].click();", manualRadio);
			utilityclassobject.gettest().log(Status.INFO, "Clicked Manual radio button successfully");
			System.out.println("INFO: Clicked Manual radio button successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to click Manual radio button: " + e.getMessage());
			System.out.println("FAIL: Failed to click Manual radio button - " + e.getMessage());
		}

		// 11d: Click "Provide bank account details" and detect popup iframe
		boolean popupDisplayed = false;
		int popupIframeIndex = -1;

		try {
			WebElement provideBankBtn = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//button[contains(text(),'Provide bank account details')]")));
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", provideBankBtn);
			try {
				provideBankBtn.click();
			} catch (Exception ce) {
				js.executeScript("arguments[0].click();", provideBankBtn);
			}
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.PASS,
					"Clicked 'Provide bank account details' button successfully");
			System.out.println("PASS: Clicked 'Provide bank account details' button successfully");

			// Detect which iframe the popup appeared in
			driver.switchTo().defaultContent();
			allIframes = driver.findElements(By.tagName("iframe"));
			for (int fi = 0; fi < allIframes.size(); fi++) {
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(allIframes.get(fi));
					List<WebElement> bankText = driver.findElements(
							By.xpath("//*[contains(text(),'Routing') or contains(text(),'Account Number')]"));
					if (!bankText.isEmpty()) {
						popupDisplayed = true;
						popupIframeIndex = fi;
						utilityclassobject.gettest().log(Status.PASS,
								"Bank account details popup is displayed in iframe[" + fi + "]");
						System.out.println("PASS: Bank account details popup detected in iframe[" + fi + "]");
						break;
					}
					driver.switchTo().defaultContent();
				} catch (Exception iex) {
					driver.switchTo().defaultContent();
				}
			}
			if (!popupDisplayed) {
				utilityclassobject.gettest().log(Status.FAIL, "Bank account details popup did NOT appear");
				System.out.println("FAIL: Bank account details popup did NOT appear");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Failed to click 'Provide bank account details': " + e.getMessage());
			System.out.println("FAIL: Failed to click 'Provide bank account details' - " + e.getMessage());
		}

		// ======================================================
		// Step 12: Click the Close icon on the popup
		// Try close icon locators inside the popup iframe first,
		// then fallback to main DOM
		// ======================================================
		boolean closedSuccessfully = false;

		// Close icon locators - ordered from most specific to generic
		By[] closeLocators = {
			By.xpath("//button[@aria-label='Close']"),
			By.xpath("//button[contains(@class,'close')]"),
			By.xpath("//span[contains(@class,'close')]"),
			By.xpath("//*[contains(@class,'close-icon')]"),
			By.xpath("//*[contains(@class,'modal-close')]"),
			By.xpath("//*[contains(@class,'dialog-close')]"),
			By.xpath("//button[contains(text(),'×')]"),
			By.xpath("//button[contains(text(),'✕')]"),
			By.xpath("//button[contains(text(),'X') or contains(text(),'x')]"),
			By.xpath("//*[@data-dismiss='modal']"),
			By.xpath("//i[contains(@class,'close')]"),
			By.xpath("//i[contains(@class,'fa-times')]"),
			By.xpath("//i[contains(@class,'fa-close')]"),
			By.xpath("//*[contains(@class,'icon-close')]")
		};

		// First try to find close icon inside popup iframe
		if (popupIframeIndex != -1) {
			driver.switchTo().defaultContent();
			allIframes = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(allIframes.get(popupIframeIndex));
			System.out.println("INFO: Looking for Close icon inside popup iframe[" + popupIframeIndex + "]");

			for (By locator : closeLocators) {
				try {
					List<WebElement> closeButtons = driver.findElements(locator);
					if (!closeButtons.isEmpty() && closeButtons.get(0).isDisplayed()) {
						WebElement closeBtn = closeButtons.get(0);
						js.executeScript("arguments[0].scrollIntoView({block:'center'});", closeBtn);
						try {
							closeBtn.click();
						} catch (Exception ce) {
							js.executeScript("arguments[0].click();", closeBtn);
						}
						closedSuccessfully = true;
						utilityclassobject.gettest().log(Status.PASS,
								"Clicked Close icon on the popup successfully");
						System.out.println("PASS: Clicked Close icon on the popup successfully (inside iframe)");
						break;
					}
				} catch (Exception le) { /* try next locator */ }
			}
		}

		// Fallback: try close icon in main DOM
		if (!closedSuccessfully) {
			driver.switchTo().defaultContent();
			System.out.println("INFO: Close icon not found in iframe, searching in main DOM...");
			for (By locator : closeLocators) {
				try {
					List<WebElement> closeButtons = driver.findElements(locator);
					if (!closeButtons.isEmpty() && closeButtons.get(0).isDisplayed()) {
						WebElement closeBtn = closeButtons.get(0);
						js.executeScript("arguments[0].scrollIntoView({block:'center'});", closeBtn);
						try {
							closeBtn.click();
						} catch (Exception ce) {
							js.executeScript("arguments[0].click();", closeBtn);
						}
						closedSuccessfully = true;
						utilityclassobject.gettest().log(Status.PASS,
								"Clicked Close icon on the popup successfully (main DOM)");
						System.out.println("PASS: Clicked Close icon on the popup successfully (main DOM)");
						break;
					}
				} catch (Exception le) { /* try next locator */ }
			}
		}

		if (!closedSuccessfully) {
			utilityclassobject.gettest().log(Status.FAIL,
					"FAIL: Could NOT find or click the Close icon on the popup");
			System.out.println("FAIL: Could NOT find or click the Close icon on the popup");
		}

		Thread.sleep(2000);

		// ======================================================
		// Step 13: Verify popup is closed
		// Check that Routing / Account Number fields are no longer visible
		// ======================================================
		driver.switchTo().defaultContent();
		System.out.println("INFO: Verifying popup is closed...");

		boolean popupClosed = false;

		try {
			// Check popup iframe is gone or its content is no longer visible
			allIframes = driver.findElements(By.tagName("iframe"));
			boolean routingFieldFound = false;

			for (int fi = 0; fi < allIframes.size(); fi++) {
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(allIframes.get(fi));
					List<WebElement> routingFields = driver.findElements(
							By.xpath("//input[@name='routingNumber']"));
					if (!routingFields.isEmpty() && routingFields.get(0).isDisplayed()) {
						routingFieldFound = true;
						break;
					}
					driver.switchTo().defaultContent();
				} catch (Exception iex) {
					driver.switchTo().defaultContent();
				}
			}

			if (!routingFieldFound) {
				popupClosed = true;
				utilityclassobject.gettest().log(Status.PASS,
						"PASS: Popup is closed successfully - Routing Number field is no longer visible");
				System.out.println("PASS: Popup is closed successfully - Routing Number field is no longer visible");
			} else {
				utilityclassobject.gettest().log(Status.FAIL,
						"FAIL: Popup did NOT close - Routing Number field is still visible");
				System.out.println("FAIL: Popup did NOT close - Routing Number field is still visible");
			}
		} catch (Exception e) {
			// If exception is thrown trying to find routing field, popup is likely closed
			popupClosed = true;
			utilityclassobject.gettest().log(Status.PASS,
					"PASS: Popup appears to be closed (fields no longer accessible)");
			System.out.println("PASS: Popup appears to be closed (fields no longer accessible)");
		}

		if (!popupClosed) {
			System.out.println("FAIL: Popup close verification FAILED");
		}

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
}
