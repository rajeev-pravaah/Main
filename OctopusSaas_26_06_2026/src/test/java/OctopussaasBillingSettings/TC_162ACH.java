package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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

public class TC_162ACH extends BaseClass80{

	ExcelUtility elib;
	javautility jlib;
	LoginPage lp;	
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_162ACH() throws InterruptedException, EncryptedDocumentException, IOException {

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
		Thread.sleep(5000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		// XPath: //button[text()='Add Card Details']
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(8000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		//eneter last 4 digit in credit card number field
		bs.getLast4DigitsOfCreditCardTextfield().sendKeys(elib.getDataFromExcel("BillingSettings", 4, 1));
		Thread.sleep(2000);
		 utilityclassobject.gettest().log(Status.INFO, "Entered last 4 digits of credit card successfully");
		 System.out.println("INFO: Entered last 4 digits of credit card successfully");
		 //Enter  Account holder name in account holder name as Rajeev dont read data from excel
		 bs.getAccountHolderNameTextfield().sendKeys("Rajeev");
		 Thread.sleep(2000);
		 utilityclassobject.gettest().log(Status.INFO, "Entered account holder name successfully");
		 System.out.println("INFO: Entered account holder name successfully");
		 //Click on ACH radio button
		 bs.getACHradiobtn().click();
		 Thread.sleep(2000);
		 utilityclassobject.gettest().log(Status.INFO, "Clicked on ACH radio button successfully");
		 System.out.println("INFO: Clicked on ACH radio button successfully");
		 //Clcik on Add card details button without javaexecutor
		 bs.getAddCardDetailsButton().click();
		 //verify that bank account information is displayed
		 WebElement bankAccountInfo = driver.findElement(By.xpath("//label[contains(text(),'Bank Account Information')]"));
		 wait.until(ExpectedConditions.visibilityOf(bankAccountInfo));
		 if(bankAccountInfo.isDisplayed())
		 {
			 utilityclassobject.gettest().log(Status.PASS, "Bank account information is displayed successfully");
			 System.out.println("PASS: Bank account information is displayed successfully");
		 }
		 else
		 {
			 utilityclassobject.gettest().log(Status.FAIL, "Bank account information is not displayed");
			 System.out.println("FAIL: Bank account information is not displayed");
		 }
		 
		 
		 
		 
		 
		
		
		
	}
}
