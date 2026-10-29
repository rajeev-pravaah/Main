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

public class TC_133AddnewWith5thElement extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_133AddnewWith5thElement() throws InterruptedException, EncryptedDocumentException, IOException {

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

		// Fetch and print the 5th element from the dropdown
		if (dropdownItems != null && dropdownItems.size() >= 5) {

			// Print total number of elements
			System.out.println("INFO: Total elements in Add New dropdown: " + dropdownItems.size());
			utilityclassobject.gettest().log(Status.INFO, "Total elements in Add New dropdown: " + dropdownItems.size());

			// Fetch 5th element (index 4)
			WebElement fifthElement = dropdownItems.get(4);
			String fifthElementText = fifthElement.getText();
			System.out.println("INFO: 5th element in Add New dropdown: " + fifthElementText);
			utilityclassobject.gettest().log(Status.INFO, "5th element in Add New dropdown: " + fifthElementText);

			// Verify the 5th element is "Satellite Location"
			if (fifthElementText.contains("Satellite Location") || fifthElementText.contains("Satellite location")) {
				System.out.println("PASS: 5th element is 'Satellite Location' as expected");
				utilityclassobject.gettest().log(Status.PASS, "5th element is 'Satellite Location' as expected");

				// Click on the 5th element (Satellite Location)
				fifthElement.click();
				Thread.sleep(2000);
				System.out.println("INFO: Clicked on 5th element 'Satellite Location' from Add New dropdown successfully");
				utilityclassobject.gettest().log(Status.INFO,
						"Clicked on 5th element 'Satellite Location' from Add New dropdown successfully");

			} else {
				System.out.println("FAIL: 5th element is '" + fifthElementText + "' but expected 'Satellite Location'");
				utilityclassobject.gettest().log(Status.FAIL,
						"5th element is '" + fifthElementText + "' but expected 'Satellite Location'");
			}

		} else {
			System.out.println("FAIL: Add New dropdown does not have 5 or more elements");
			utilityclassobject.gettest().log(Status.FAIL, "Add New dropdown does not have 5 or more elements");
		}

		// Verify Satellite Location page is displayed
		boolean isPageDisplayed = driver.getPageSource().contains("Satellite Location")
				|| driver.getPageSource().contains("Satellite location")
				|| driver.getCurrentUrl().contains("satellite-location")
				|| driver.getCurrentUrl().contains("satelliteLocation")
				|| driver.getCurrentUrl().contains("satellite");

		if (isPageDisplayed) {
			System.out.println("PASS: Satellite Location page is displayed successfully after clicking on Satellite Location element");
			utilityclassobject.gettest().log(Status.PASS,
					"Satellite Location page is displayed successfully after clicking on Satellite Location element");
		} else {
			System.out.println("FAIL: Satellite Location page is NOT displayed after clicking on Satellite Location element");
			utilityclassobject.gettest().log(Status.FAIL,
					"Satellite Location page is NOT displayed after clicking on Satellite Location element");
		}
	}
}
