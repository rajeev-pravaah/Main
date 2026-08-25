package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

public class TC_145EnterditiDataInCardNumberTextField extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_145EnterditiDataInCardNumberTextField() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1: Click on Profile Icon to go to Transporter Settings
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
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Billing Settings successfully");
		System.out.println("INFO: Clicked on Billing Settings successfully");
		bs = new BillingSettings(driver);
		wlib = new webDriverutility();

		// Step 4: Scroll to and click Add New Payment Method button
		wlib.scrollToelement(driver, bs.getAddNewPaymentMethodButton());
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Scroll to and click Add Card Details button
		wlib.scrollToelement(driver, bs.getAddCardDetailsButton());
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 6: Enter 4242 in the Card Number (Last 4 Digits) text field
		// XPath from Repository: //input[@placeholder='Last 4 Digits Of Credit Card / ACH Number']
		try {
			WebElement cardNumberTextField = wait.until(
					ExpectedConditions.visibilityOf(bs.getLast4DigitsOfCreditCardTextfield()));
			wlib.scrollToelement(driver, cardNumberTextField);
			Thread.sleep(1000);
			cardNumberTextField.clear();
			String creaditcardno = elib.getDataFromExcel("BillingSettings", 4, 1);
			cardNumberTextField.sendKeys(creaditcardno);
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.PASS, "Entered '4242' in Card Number text field successfully");
			System.out.println("PASS: Entered '4242' in Card Number text field successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Failed to enter data in Card Number text field - " + e.getMessage());
			System.out.println("FAIL: Failed to enter data in Card Number text field - " + e.getMessage());
		}
		
	}
	
}
