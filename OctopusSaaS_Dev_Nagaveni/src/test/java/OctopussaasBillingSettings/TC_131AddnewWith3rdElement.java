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

public class TC_131AddnewWith3rdElement extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_131AddnewWith3rdElement() throws InterruptedException, EncryptedDocumentException, IOException {

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

		// Fetch and print the 3rd element from the dropdown
		if (dropdownItems != null && dropdownItems.size() >= 3) {

			// Print total number of elements
			System.out.println("INFO: Total elements in Add New dropdown: " + dropdownItems.size());
			utilityclassobject.gettest().log(Status.INFO, "Total elements in Add New dropdown: " + dropdownItems.size());

			// Fetch 3rd element (index 2)
			WebElement thirdElement = dropdownItems.get(2);
			String thirdElementText = thirdElement.getText();
			System.out.println("INFO: 3rd element in Add New dropdown: " + thirdElementText);
			utilityclassobject.gettest().log(Status.INFO, "3rd element in Add New dropdown: " + thirdElementText);

			// Verify the 3rd element is "Service Vehicle"
			if (thirdElementText.contains("Service Vehicle")) {
				System.out.println("PASS: 3rd element is 'Service Vehicle' as expected");
				utilityclassobject.gettest().log(Status.PASS, "3rd element is 'Service Vehicle' as expected");

				// Click on the 3rd element (Service Vehicle)
				thirdElement.click();
				Thread.sleep(2000);
				System.out.println("INFO: Clicked on 3rd element 'Service Vehicle' from Add New dropdown successfully");
				utilityclassobject.gettest().log(Status.INFO,
						"Clicked on 3rd element 'Service Vehicle' from Add New dropdown successfully");

			} else {
				System.out.println("FAIL: 3rd element is '" + thirdElementText + "' but expected 'Service Vehicle'");
				utilityclassobject.gettest().log(Status.FAIL,
						"3rd element is '" + thirdElementText + "' but expected 'Service Vehicle'");
			}

		} else {
			System.out.println("FAIL: Add New dropdown does not have 3 or more elements");
			utilityclassobject.gettest().log(Status.FAIL, "Add New dropdown does not have 3 or more elements");
		}

		// Verify Service Vehicle page is displayed
		boolean isPageDisplayed = driver.getPageSource().contains("Service Vehicle")
				|| driver.getCurrentUrl().contains("service-vehicle")
				|| driver.getCurrentUrl().contains("serviceVehicle")
				|| driver.getCurrentUrl().contains("vehicle");

		if (isPageDisplayed) {
			System.out.println("PASS: Service Vehicle page is displayed successfully after clicking on Service Vehicle element");
			utilityclassobject.gettest().log(Status.PASS,
					"Service Vehicle page is displayed successfully after clicking on Service Vehicle element");
		} else {
			System.out.println("FAIL: Service Vehicle page is NOT displayed after clicking on Service Vehicle element");
			utilityclassobject.gettest().log(Status.FAIL,
					"Service Vehicle page is NOT displayed after clicking on Service Vehicle element");
		}
	}
}
