package OctopussaasBillingSettings;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
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

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_096InvoiceReminderChcekBOxwithDyas extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_096InvoicereminderemailInitialChcekboxWithDaysTextfield() throws InterruptedException, EncryptedDocumentException, IOException {
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
		Thread.sleep(2000);
		wlib.scrollToelement(driver, bs.getFirstoverdueEmailInitialCheckbox());
		//bs.getFirstoverdueEmailInitialCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO, "First overdue email initial checkbox is checked");
		System.out.println("INFO: First overdue email initial checkbox is checked");
		Thread.sleep(2000);
		bs.getFirstoverdueEmailInitialCheckbox().click();
		Thread.sleep(2000);
		bs.getFirstoverdueEmailInitialCheckbox().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "First overdue email initial checkbox is unchecked");
		System.out.println("INFO: First overdue email initial checkbox is unchecked");
		bs.getThefirstoverdueemailSentInitialDaysTextfield().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "First overdue email initial days text field is clickable");
		System.out.println("INFO: First overdue email initial days text field is clickable");
		bs.getThefirstoverdueemailSentInitialDaysTextfield().clear();
		Thread.sleep(2000);
		bs.getThefirstoverdueemailSentInitialDaysTextfield().sendKeys("5");
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "First overdue email initial days text field is editable");
		System.out.println("INFO: First overdue email initial days text field is editable");
		
		
	}
}