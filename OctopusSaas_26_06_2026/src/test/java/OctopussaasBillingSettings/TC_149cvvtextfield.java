package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import java.util.List;

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
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_149cvvtextfield extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_149cvvtextfield() throws InterruptedException, EncryptedDocumentException, IOException {

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
		Thread.sleep(1000);
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(3000);
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

		// Step 7: Pass the value in Account Holder Name text field using JavaScript Executor
		WebElement accountHolderName = bs.getAccountHolderNameTextfield();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", accountHolderName);
		js.executeScript("arguments[0].value='Raju'", accountHolderName);
		utilityclassobject.gettest().log(Status.PASS, "Entered 'Raju' in Account Holder Name text field successfully using JavaScript Executor");
		System.out.println("PASS: Entered 'Raju' in Account Holder Name text field successfully using JavaScript Executor");

		//verify cvv text field is displayed and enabled
		try {
			WebElement cvvTextField = wait.until(
					ExpectedConditions.visibilityOf(bs.getCvvCvcTextfield()));
			if (cvvTextField.isDisplayed() && cvvTextField.isEnabled()) {
				utilityclassobject.gettest().log(Status.PASS, "CVV/CVC text field is displayed and enabled successfully");
				System.out.println("PASS: CVV/CVC text field is displayed and enabled successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "CVV/CVC text field is not displayed or not enabled");
				System.out.println("FAIL: CVV/CVC text field is not displayed or not enabled");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to verify CVV/CVC text field - " + e.getMessage());
			System.out.println("FAIL: Failed to verify CVV/CVC text field - " + e.getMessage());
		}
		// Step 8: Enter 3-digit value in CVV/CVC text field
		// XPath: //input[@placeholder='Enter CVV/CVC']
		try {
			WebElement cvvTextField = wait.until(
					ExpectedConditions.visibilityOf(bs.getCvvCvcTextfield()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cvvTextField);
			Thread.sleep(1000);
			cvvTextField.clear();
			cvvTextField.sendKeys("123");
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.PASS, "Entered '123' in CVV/CVC text field successfully");
			System.out.println("PASS: Entered '123' in CVV/CVC text field successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter CVV/CVC value - " + e.getMessage());
			System.out.println("FAIL: Failed to enter CVV/CVC value - " + e.getMessage());
		}
	}
}
