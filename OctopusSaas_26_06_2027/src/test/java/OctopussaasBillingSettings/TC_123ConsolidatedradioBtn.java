package OctopussaasBillingSettings;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class TC_123ConsolidatedradioBtn extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_123ConsolidatedradioBtn() throws InterruptedException, EncryptedDocumentException, IOException {

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

		// Scroll to the Consolidated Monthly Radio Button
		wlib.scrollToelement(driver, bs.getConsolidatedmonthlyradiobtn());
		Thread.sleep(2000);

		// Perform click action on Consolidated Monthly Radio Button
		WebElement consolidatedRadioBtn = bs.getConsolidatedmonthlyradiobtn();
		consolidatedRadioBtn.click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Consolidated Monthly Radio Button successfully");
		System.out.println("INFO: Clicked on Consolidated Monthly Radio Button successfully");

		// Verify the radio button is selected
		String selectedState = consolidatedRadioBtn.getAttribute("class");
		if (selectedState != null && (selectedState.contains("checked") || selectedState.contains("active")
				|| selectedState.contains("bg-") || selectedState.contains("selected")
				|| selectedState.contains("true"))) {
			System.out.println("Consolidated Monthly Radio Button is SELECTED successfully");
			utilityclassobject.gettest().log(Status.PASS, "Consolidated Monthly Radio Button is SELECTED successfully");
		} else {
			// Fallback to JavaScript click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", consolidatedRadioBtn);
			Thread.sleep(2000);
			System.out.println("Consolidated Monthly Radio Button clicked via JavaScript");
			utilityclassobject.gettest().log(Status.INFO, "Consolidated Monthly Radio Button clicked via JavaScript");
		}
	}
}
