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

public class TC_129AddnewWith1stElement extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_129AddnewWith1stElement() throws InterruptedException, EncryptedDocumentException, IOException {

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

		// Fetch and print the 1st element from the dropdown
		if (dropdownItems != null && dropdownItems.size() > 0) {
			WebElement firstElement = dropdownItems.get(0);
			String firstElementText = firstElement.getText();
			System.out.println("INFO: Total elements in Add New dropdown: " + dropdownItems.size());
			System.out.println("INFO: 1st element in Add New dropdown: " + firstElementText);
			utilityclassobject.gettest().log(Status.INFO, "Total elements in Add New dropdown: " + dropdownItems.size());
			utilityclassobject.gettest().log(Status.INFO, "1st element in Add New dropdown: " + firstElementText);

			// Click on the 1st element
			firstElement.click();
			Thread.sleep(2000);
			System.out.println("PASS: Clicked on 1st element '" + firstElementText + "' from Add New dropdown successfully");
			utilityclassobject.gettest().log(Status.PASS,
					"Clicked on 1st element '" + firstElementText + "' from Add New dropdown successfully");
		} else {
			System.out.println("FAIL: No elements found in Add New dropdown");
			utilityclassobject.gettest().log(Status.FAIL, "No elements found in Add New dropdown");
		}
	}
}
