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
public class TC_031InvoiceChcekBoxWithConfirmAndCancelBtnInPOpup extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_031InvoiceChcekBoxWithConfirmandCancekBtn() throws InterruptedException {
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
		invoiceCheckbox.click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Invoice # checkbox");
		System.out.println("INFO: Clicked on Invoice # checkbox");
		//verify the confirm popup appears with confirm and cancel buttons
		if(bs.getConfirmButton().isDisplayed() && bs.getCloseButton().isDisplayed())	
		{
			utilityclassobject.gettest().log(Status.PASS, "Confirm popup is displayed with Confirm and Cancel buttons");
			System.out.println("PASS: Confirm popup is displayed with Confirm and Cancel buttons");
		}
		else
		{
			utilityclassobject.gettest().log(Status.FAIL, "Confirm popup is not displayed correctly");
			System.out.println("FAIL: Confirm popup is not displayed correctly");
		}
	

}
}