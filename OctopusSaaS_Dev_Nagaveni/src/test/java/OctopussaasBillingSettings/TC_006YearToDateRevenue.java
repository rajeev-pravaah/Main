package OctopussaasBillingSettings;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
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

public class TC_006YearToDateRevenue extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_006YearTodateRevenueDefaultValue() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		// wlib is provided by BaseClass80, no need to reinitialize here
		Thread.sleep(2000);
        // Ensure page zoom is 80% so the element positions are consistent
        try { ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'"); } catch (Exception e) { /* ignore if not supported */ }
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
        // Ensure page zoom is 80% after Billing Settings page loads
        try { ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'"); } catch (Exception e) { /* ignore if not supported */ }

		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		bs = new BillingSettings(driver);
		bs.getYeartoDateRevenue().clear();
		utilityclassobject.gettest().log(Status.INFO, "Year To date revenue field is cleared  value");
		String defaultValue = bs.getYeartoDateRevenue().getAttribute("value");
		System.out.println("Default value in Year to Date Revenue field: " + defaultValue);
		utilityclassobject.gettest().log(Status.INFO, "Default value fetched successfully from Year to Date Revenue field");

		Assert.assertEquals(defaultValue, "$0.00", "Default value in Year to Date Revenue field is not 0");
	}
}