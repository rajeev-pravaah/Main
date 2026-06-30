package OctopussaasBillingSettings;

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
public class TC_010PastYear20225TextField extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_010PastYear2025TextField() throws InterruptedException {
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

		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		bs = new BillingSettings(driver);
		//check the 2025 year text field is displayed or not
		//String xpath="(//div[text()='2025']/ancestor::div[@class='flex items-center gap-2']/descendant::div)[2]";	
		WebElement year = bs.getYear2025TextField();
		if(year.isDisplayed())
		{
			utilityclassobject.gettest().log(Status.PASS, "2025 year text field is displayed successfully");
			System.out.println("PASS: 2025 year text field is displayed successfully");
		}
		else
		{
			utilityclassobject.gettest().log(Status.FAIL, "2025 year text field is not displayed");
			System.out.println("FAIL: 2025 year text field is not displayed");
		}
		bs.getYear2025TextField().clear();
		//check the default value of 2025 year text field is 0 or not
			String defaultValue = bs.getYear2025TextField().getAttribute("value");
			if (defaultValue.equals("0")) {
				utilityclassobject.gettest().log(Status.PASS, "Default value of 2025 year text field is 0 as expected");
				System.out.println("PASS: Default value of 2025 year text field is 0 as expected");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Default value of 2025 year text field is not 0, it is: " + defaultValue);
				System.out.println("FAIL: Default value of 2025 year text field is not 0, it is: " + defaultValue);
			}
	}

}