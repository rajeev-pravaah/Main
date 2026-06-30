package OctopussaasBillingSettings;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import com.aventstack.extentreports.Status;

import org.openqa.selenium.By;


@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_075AcceptedPaymenttypewithDefaultValues extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_075AcceptedpaymentTypeWithDefaultvalue() throws InterruptedException, EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		System.out.println("INFO: Transporter setting page is displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		bs=new BillingSettings(driver);
		//scroll to the custom invoice text field (use invoice date element as anchor)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);

		// Credit Memo - only check displayed or not
		WebElement creditMemo = driver.findElement(
		        By.xpath("//span[text()='Credit Memo']/../descendant::div"));

		if (creditMemo.isDisplayed()) {
		    System.out.println("Credit Memo checkbox is displayed");
			utilityclassobject.gettest().log(Status.PASS, "Credit Memo is displayed successfully");
		} else {
		    System.out.println("Credit Memo checkbox is NOT displayed");
		  utilityclassobject.gettest().log(Status.FAIL, "Credit Memo is NOT displayed");
		    
		}

		// Credit Card / ACH - only check displayed or not
		WebElement creditCardACH = driver.findElement(
		        By.xpath("//span[text()='Credit Card / ACH']/../descendant::div"));

		if(creditCardACH.isDisplayed()) {
		    System.out.println("Credit Card / ACH checkbox is displayed");
			utilityclassobject.gettest().log(Status.PASS, "Credit Card / ACH is displayed successfully");
		} else {
		    System.out.println("Credit Card / ACH checkbox is NOT displayed");
		    utilityclassobject.gettest().log(Status.FAIL, "Credit Card / ACH is NOT displayed");
		}

		// Check - only check displayed or not
		WebElement checkBox = driver.findElement(
		        By.xpath("//span[text()='Check']/../descendant::div"));

		if(checkBox.isDisplayed()) {
		    System.out.println("Check checkbox is displayed");
		   utilityclassobject.gettest().log(Status.PASS, "Check is displayed successfully");
		} else {
		    System.out.println("Check checkbox is NOT displayed");
		    utilityclassobject.gettest().log(Status.FAIL, "Check is NOT displayed");
		}
	}

}