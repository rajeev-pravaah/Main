package OctopussaasBillingSettings;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class TC_120DaystextFieldFromsuspenssionsettings extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_120DaystextFieldFromsuspenssionsettings() throws InterruptedException, EncryptedDocumentException, IOException {

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

		// Scroll to the Subsequent Checkbox from Suspension Settings
		wlib.scrollToelement(driver, bs.getSubsequentCheckboxfromsuspenssionsettings());
		Thread.sleep(2000);

		// Step 1: Click on Subsequent Checkbox from Suspension Settings
		WebElement subsequentCheckbox = bs.getSubsequentCheckboxfromsuspenssionsettings();
		subsequentCheckbox.click();
		subsequentCheckbox.click();
		
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Subsequent Checkbox from Suspension Settings successfully");
		System.out.println("INFO: Clicked on Subsequent Checkbox from Suspension Settings successfully");

		// Step 2: Scroll to the Days text field from Suspension Settings
		wlib.scrollToelement(driver, bs.getSubsequentDaysTextfieldfromsuspenssionsettings());
		Thread.sleep(2000);

		// Step 3: Click on Days text field
		WebElement daysTextField = bs.getSubsequentDaysTextfieldfromsuspenssionsettings();
		daysTextField.click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Days text field from Suspension Settings successfully");
		System.out.println("INFO: Clicked on Days text field from Suspension Settings successfully");

		// Step 4: Clear the existing value
		daysTextField.sendKeys(Keys.CONTROL + "a");
		daysTextField.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Cleared the existing value from Days text field successfully");
		System.out.println("INFO: Cleared the existing value from Days text field successfully");

		// Step 5: Pass the new value
		String newValue = "10";
		daysTextField.sendKeys(newValue);
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO, "Entered new value '" + newValue + "' in Days text field from Suspension Settings successfully");
		System.out.println("INFO: Entered new value '" + newValue + "' in Days text field from Suspension Settings successfully");
	}
}
