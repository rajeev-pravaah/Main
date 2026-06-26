package OctopussaasBillingSettings;

import java.io.IOException;
import java.util.List;

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

public class TC_134AddnewWith6thElement extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_134AddnewWith6thElement() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is displayed successfully");
		System.out.println("INFO: Transporter setting page is displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		bs = new BillingSettings(driver);

		// Scroll to payment terms dropdown as anchor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);

		// Click on Add New dropdown
		bs.getAddNewDropdown().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New dropdown successfully");
		System.out.println("INFO: Clicked on Add New dropdown successfully");

		// Capture all elements in the dropdown
		List<WebElement> dropdownItems = driver.findElements(By.xpath("//ul[@role='menu']//li"));

		// Fetch and print the 6th element from the dropdown
		if (dropdownItems != null && dropdownItems.size() >= 6) {

			// Print total number of elements
			System.out.println("INFO: Total elements in Add New dropdown: " + dropdownItems.size());
			utilityclassobject.gettest().log(Status.INFO, "Total elements in Add New dropdown: " + dropdownItems.size());

			// Fetch 6th element (index 5)
			WebElement sixthElement = dropdownItems.get(5);
			String sixthElementText = sixthElement.getText();
			System.out.println("INFO: 6th element in Add New dropdown: " + sixthElementText);
			utilityclassobject.gettest().log(Status.INFO, "6th element in Add New dropdown: " + sixthElementText);

			// Verify the 6th element is "Route"
			if (sixthElementText.contains("Route")) {
				System.out.println("PASS: 6th element is 'Route' as expected");
				utilityclassobject.gettest().log(Status.PASS, "6th element is 'Route' as expected");

				// Click on the 6th element (Route)
				sixthElement.click();
				Thread.sleep(2000);
				System.out.println("INFO: Clicked on 6th element 'Route' from Add New dropdown successfully");
				utilityclassobject.gettest().log(Status.INFO,
						"Clicked on 6th element 'Route' from Add New dropdown successfully");

			} else {
				System.out.println("FAIL: 6th element is '" + sixthElementText + "' but expected 'Route'");
				utilityclassobject.gettest().log(Status.FAIL,
						"6th element is '" + sixthElementText + "' but expected 'Route'");
			}

		} else {
			System.out.println("FAIL: Add New dropdown does not have 6 or more elements");
			utilityclassobject.gettest().log(Status.FAIL, "Add New dropdown does not have 6 or more elements");
		}

		// Verify Route page is displayed
		boolean isPageDisplayed = driver.getPageSource().contains("Route")
				|| driver.getCurrentUrl().contains("route");

		if (isPageDisplayed) {
			System.out.println("PASS: Route page is displayed successfully after clicking on Route element");
			utilityclassobject.gettest().log(Status.PASS,
					"Route page is displayed successfully after clicking on Route element");
		} else {
			System.out.println("FAIL: Route page is NOT displayed after clicking on Route element");
			utilityclassobject.gettest().log(Status.FAIL,
					"Route page is NOT displayed after clicking on Route element");
		}
	}
}
