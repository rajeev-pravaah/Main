package OctopussaasBillingSettings;

import org.openqa.selenium.JavascriptExecutor;
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

public class TC_040LastApymentCheckBox extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_040alstpaymentChcekBox() throws InterruptedException {
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
		bs=new BillingSettings(driver);
		//scrollTo invoice checkbox
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getInvoiceDateCheckbox());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);
		bs.getLastPaymentCheckbox().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Last payment check box is unchecked successfully");
		System.out.println("INFO: Last payment check box is unchecked successfully");
		bs.getLastPaymentCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO, "Last payment check box is checked successfully");
		System.out.println("INFO: Last payment check box is checked successfully");
		
	}

}
