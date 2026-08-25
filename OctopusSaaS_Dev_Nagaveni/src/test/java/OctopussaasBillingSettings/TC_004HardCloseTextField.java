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
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_004HardCloseTextField extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_004HardCloseDateVerification() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib=new webDriverutility();
		Thread.sleep(2000);
        // Ensure page zoom is 80% so the element positions are consistent
        try { ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'"); } catch (Exception e) { /* ignore if not supported */ }
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		hp.getBillingSettings().click();
		// Ensure page zoom is 80% after Billing Settings page loads
		try { ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'"); } catch (Exception e) { /* ignore if not supported */ }
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		
		
		
		bs = new BillingSettings(driver);
		Thread.sleep(2000);
		wlib.scrollToelement(driver, bs.getHardCloseDate());
		if(bs.getHardCloseDate().isDisplayed())
		{
			utilityclassobject.gettest().log(Status.PASS, "Hard close date field is displayed successfully");
		}
		else
		{
			utilityclassobject.gettest().log(Status.FAIL, "Hard close date field is not displayed");
		}
		String txt = bs.getHardCloseDate().getText();
		System.out.println(txt);
		//compare with date format Thu,mm/dd/yyyy
		if(txt.matches("^[A-Za-z]{3},\\s\\d{2}/\\d{2}/\\d{4}$"))
		{
			utilityclassobject.gettest().log(Status.PASS, "Hard close date field is in correct format");
		}
		else
		{
			utilityclassobject.gettest().log(Status.FAIL, "Hard close date field is not in correct format");
		}
 	}
}