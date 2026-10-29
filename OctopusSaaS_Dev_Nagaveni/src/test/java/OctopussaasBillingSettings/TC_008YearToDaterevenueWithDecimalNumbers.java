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

public class TC_008YearToDaterevenueWithDecimalNumbers extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_008YearTodateRevenueWithDecimalVAlue() throws InterruptedException {
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
		bs.getYeartoDateRevenue().clear();
		utilityclassobject.gettest().log(Status.INFO, "Year To date revenue field is cleared  value");
		System.out.println("INFO: Year To date revenue field cleared");
		String defaultValue = bs.getYeartoDateRevenue().getAttribute("value");
		System.out.println("Default value in Year to Date Revenue field: " + defaultValue);
		utilityclassobject.gettest().log(Status.INFO, "Default value fetched successfully from Year to Date Revenue field");
		System.out.println("INFO: Default value fetched successfully from Year to Date Revenue field");

		// Provide digits to input. Change this string to test different digit sequences.
		String newValue = "123.456"; // digits to type into the field

		// 1) Click and send keys normally
		bs.getYeartoDateRevenue().click();
		bs.getYeartoDateRevenue().sendKeys(newValue);

		// 2) Also set the value via JavaScript using native setter so frameworks (React/Angular) pick it up
		String jsSetValueNative = "var el = arguments[0]; var val = arguments[1]; el.removeAttribute('readonly'); el.removeAttribute('disabled'); el.focus(); var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set; nativeSetter.call(el, val); el.setAttribute('value', val); el.dispatchEvent(new Event('input', {bubbles:true})); el.dispatchEvent(new Event('change', {bubbles:true})); el.blur();";
		((JavascriptExecutor) driver).executeScript(jsSetValueNative, bs.getYeartoDateRevenue(), newValue);

		// Read back final value and log
		String finalValue = bs.getYeartoDateRevenue().getAttribute("value");
		systemOutAndUtilityLog("Final value in Year to Date Revenue field after send: ", finalValue);
	}

	private void systemOutAndUtilityLog(String prefix, String value) {
		utilityclassobject.gettest().log(Status.INFO, prefix + value);
		System.out.println("INFO: " + prefix + value);
	}
}