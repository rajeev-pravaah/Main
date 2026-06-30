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

public class TC_173AccountTypeDropdownfromAccountdetailsCheckBox extends BaseClass80 {
	ExcelUtility elib;
	javautility jlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_173AccountTypeDropdownfromAccountdetailsCheckBox()
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

		// Step 2: Click on Transporter Settings
		hp.clickTransporterSettings();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Transporter Settings successfully");

		// Step 3: Click on Billing Settings
		hp.getBillingSettings().click();
		Thread.sleep(1000);
		bs = new BillingSettings(driver);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Billing Settings successfully");

		// Step 4: Click Add New Payment Method button
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddNewPaymentMethodButton());
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(5000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");

		// Step 6: Enter last 4 digits of credit card
		bs.getLast4DigitsOfCreditCardTextfield().sendKeys(elib.getDataFromExcel("BillingSettings", 4, 1));
		Thread.sleep(500);
		utilityclassobject.gettest().log(Status.INFO, "Entered last 4 digits of credit card successfully");

		// Step 7: Enter Account Holder Name
		bs.getAccountHolderNameTextfield().sendKeys("Rajeev");
		Thread.sleep(500);
		utilityclassobject.gettest().log(Status.INFO, "Entered account holder name 'Rajeev' successfully");

		// Step 8: Click ACH radio button
		bs.getACHradiobtn().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on ACH radio button successfully");

		// Step 9: Click Add Card Details button
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");

		// Step 10: Verify Bank Account Information is displayed
		try {
			WebElement bankAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//label[contains(text(),'Bank Account Information')]")));
			if (bankAccountInfo.isDisplayed())
				utilityclassobject.gettest().log(Status.PASS, "Bank account information is displayed successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Bank account information section not found - " + e.getMessage());
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
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter Account Holder Name: " + e.getMessage());
		}

		// 11b: Select Account Type as "Business" inside iframe
		try {
			WebElement accountTypeDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("field-_r_1_")));
			js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
			new Select(accountTypeDropdown).selectByVisibleText("Business");
			utilityclassobject.gettest().log(Status.INFO, "Selected Account Type as 'Business' successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to select Account Type: " + e.getMessage());
		}

		// 11c: Click Manual radio button
		try {
			WebElement manualRadio = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("manual")));
			js.executeScript("arguments[0].scrollIntoView(true);", manualRadio);
			js.executeScript("arguments[0].click();", manualRadio);
			utilityclassobject.gettest().log(Status.INFO, "Clicked Manual radio button successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to click Manual radio button: " + e.getMessage());
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
			utilityclassobject.gettest().log(Status.PASS, "Clicked 'Provide bank account details' button successfully");

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
						break;
					}
					driver.switchTo().defaultContent();
				} catch (Exception iex) {
					driver.switchTo().defaultContent();
				}
			}
			if (!popupDisplayed)
				utilityclassobject.gettest().log(Status.FAIL, "Bank account details popup did NOT appear");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Failed to click 'Provide bank account details': " + e.getMessage());
		}

		// Switch directly to popup iframe
		driver.switchTo().defaultContent();
		allIframes = driver.findElements(By.tagName("iframe"));
		int targetIdx = (popupIframeIndex != -1) ? popupIframeIndex : targetIframeIndex;
		driver.switchTo().frame(allIframes.get(targetIdx));

		// ======================================================
		// Step 12: Enter Routing Number inside the popup
		// ======================================================
		String routeNum = elib.getDataFromExcel("BillingSettings", 9, 1);
		boolean routingEntered = false;

		try {
			WebElement routingField = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//input[@name='routingNumber' or @placeholder='Routing number' " +
									 "or contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'routing')]")));

			js.executeScript("arguments[0].scrollIntoView({block:'center'});", routingField);
			routingField.click();
			routingField.clear();
			routingField.sendKeys(routeNum);

			String val = routingField.getAttribute("value");
			if (val == null || val.trim().isEmpty()) {
				js.executeScript(
					"var s=Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
					"s.call(arguments[0],arguments[1]);" +
					"arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
					"arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
					routingField, routeNum);
				val = routingField.getAttribute("value");
			}

			if (val != null && !val.trim().isEmpty()) {
				routingEntered = true;
				utilityclassobject.gettest().log(Status.PASS,
						"Entered Routing Number '" + routeNum + "' in popup successfully");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "FAIL: Could NOT enter Routing Number - " + e.getMessage());
		}

		if (!routingEntered)
			utilityclassobject.gettest().log(Status.FAIL, "FAIL: Could NOT enter Routing Number in popup");

		// ======================================================
		// Step 13: Enter Account Number inside the popup
		// Fetch from Excel - BillingSettings sheet, row 9, column 2
		// ======================================================
		String accountNum = elib.getDataFromExcel("BillingSettings", 9, 2);
		boolean accountEntered = false;

		try {
			WebElement accountField = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//input[@name='accountNumber' or @placeholder='Account number' " +
									 "or contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'account number')]")));

			js.executeScript("arguments[0].scrollIntoView({block:'center'});", accountField);
			accountField.click();
			accountField.clear();
			accountField.sendKeys(accountNum);

			String val = accountField.getAttribute("value");
			if (val == null || val.trim().isEmpty()) {
				js.executeScript(
					"var s=Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
					"s.call(arguments[0],arguments[1]);" +
					"arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
					"arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
					accountField, accountNum);
				val = accountField.getAttribute("value");
			}

			if (val != null && !val.trim().isEmpty()) {
				accountEntered = true;
				utilityclassobject.gettest().log(Status.PASS,
						"Entered Account Number '" + accountNum + "' in popup successfully");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "FAIL: Could NOT enter Account Number - " + e.getMessage());
		}

		if (!accountEntered)
			utilityclassobject.gettest().log(Status.FAIL, "FAIL: Could NOT enter Account Number in popup");

		// ======================================================
		// Step 14: Fetch default value from accountSubType dropdown
		// Uses @name='accountSubType' locator from BillingSettings.java
		// ======================================================
		try {
			WebElement accountSubTypeDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("accountSubType")));

			js.executeScript("arguments[0].scrollIntoView({block:'center'});", accountSubTypeDropdown);

			Select subTypeSelect = new Select(accountSubTypeDropdown);
			String defaultValue = subTypeSelect.getFirstSelectedOption().getText().trim();

			utilityclassobject.gettest().log(Status.PASS,
					"Default value of Account Sub Type dropdown is: '" + defaultValue + "'");
			System.out.println("PASS: Default value of accountSubType dropdown: '" + defaultValue + "'");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL,
					"FAIL: Could NOT fetch default value from accountSubType dropdown - " + e.getMessage());
			System.out.println("FAIL: Could NOT fetch accountSubType dropdown value - " + e.getMessage());
		}

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
}
