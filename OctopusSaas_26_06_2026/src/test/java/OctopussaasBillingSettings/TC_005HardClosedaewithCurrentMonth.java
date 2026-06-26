package OctopussaasBillingSettings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_005HardClosedaewithCurrentMonth extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_005HardCloseDateWithCurrentcalender() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);

		// Ensure page zoom is 80% so the element positions are consistent
		try {
			((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
			System.out.println("INFO: Page zoom set to 80% successfully");
		} catch (Exception e) { /* ignore if not supported */ }

		hp.getUserprofile().click();
		System.out.println("INFO: Clicked on User Profile icon successfully");

		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is displayed successfully");
		System.out.println("INFO: Clicked on Transporter Settings and page is displayed successfully");

		hp.getBillingSettings().click();
		Thread.sleep(2000);

		// Ensure page zoom is 80% after Billing Settings page loads
		try {
			((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
			System.out.println("INFO: Page zoom set to 80% after Billing Settings load");
		} catch (Exception e) { /* ignore if not supported */ }

		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Clicked on Billing Settings and page is displayed successfully");

		bs = new BillingSettings(driver);

		// Wait for Billing header to ensure the page is loaded
		wlib.waitForElementPresent(driver, bs.getBillingHeader());
		System.out.println("INFO: Billing Settings page header is present - page loaded successfully");
		Thread.sleep(500);

		try {
			WebElement hardClose = bs.getHardCloseDate();
			System.out.println("INFO: Hard Close Date element located successfully");

			wlib.scrollToelement(driver, hardClose);
			System.out.println("INFO: Scrolled to Hard Close Date element successfully");

			hardClose.click();
			utilityclassobject.gettest().log(Status.INFO, "Clicked Hard Close date element");
			System.out.println("PASS: Clicked on Hard Close Date element successfully");

		} catch (NoSuchElementException ne) {
			utilityclassobject.gettest().log(Status.INFO, "Hard Close element not found: " + ne.getMessage());
			System.out.println("FAIL: Hard Close Date element not found - " + ne.getMessage());
			throw new AssertionError("Hard Close date element not found or not interactable. Details: " + ne.getMessage());
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.INFO, "Failed to click Hard Close element: " + e.getMessage());
			System.out.println("FAIL: Failed to click Hard Close Date element - " + e.getMessage());
			throw new AssertionError("Failed to click Hard Close date element: " + e.getMessage());
		}
	}
}