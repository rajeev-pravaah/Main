package OctopussaasBillingSettings;

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

public class TC_033InvoiceDatewithConfirmandCancelBtn extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_033InvoiceDateChcekPopUpConfirmAndcancelBt() throws InterruptedException {
		// Log via utility class and stdout for important events
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		// wlib is provided by BaseClass80, no need to reinitialize here
		Thread.sleep(2000);
        // Ensure page zoom is 80% so the element positions are consistent
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		System.out.println("INFO: Transporter setting page is displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		// Ensure page zoom is 80% after Billing Settings page loads
		try { ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'"); } catch (Exception e) { /* ignore if not supported */ }
		bs=new BillingSettings(driver);
		//scrollTo invoice checkbox
		WebElement invoiceCheckbox = bs.getInvoiceCheckbox();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", invoiceCheckbox);
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		bs.getInvoiceDateCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Invoice Date checkbox");
		//check that confirm and cancel buttons are displayed
		if(bs.getConfirmButton().isDisplayed() && bs.getCloseButton().isDisplayed())
		{
			utilityclassobject.gettest().log(Status.PASS, "Confirm and Cancel buttons are displayed in the popup");
			System.out.println("PASS: Confirm and Cancel buttons are displayed in the popup");
		}
		else
		{
			utilityclassobject.gettest().log(Status.FAIL, "Confirm and Cancel buttons are not displayed in the popup");
			System.out.println("FAIL: Confirm and Cancel buttons are not displayed in the popup");
		}
		Thread.sleep(2000);
		}
}