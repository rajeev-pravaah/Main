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

public class TC_106AutmaticSuspensiondropdownwith2ndvlause extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_106AutmaticSuspensiondropdownwith2ndvlause() throws InterruptedException, EncryptedDocumentException, IOException {

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
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, bs.getAutomativsuspensionSettingsSectiondropdown());
		Thread.sleep(2000);

		// Click on the dropdown to open it
		WebElement dropdown = bs.getAutomativsuspensionSettingsSectiondropdown();
		dropdown.click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Automatic Suspension Settings dropdown");
		System.out.println("INFO: Clicked on Automatic Suspension Settings dropdown");

		// Fetch all dropdown options
		List<WebElement> allOptions = driver.findElements(
				By.xpath("(//div[@class='relative flex items-center  my-2 '])[2]//following-sibling::ul//li"));
		if (allOptions == null || allOptions.isEmpty()) {
			allOptions = driver.findElements(
					By.xpath("//ul[contains(@class,'dropdown') or contains(@class,'options') or contains(@class,'list')]//li"));
		}

		// Fetch 2nd value
		if (allOptions != null && allOptions.size() >= 2) {
			String secondValue = allOptions.get(1).getText().trim();
			System.out.println("2nd Value from dropdown: " + secondValue);
			utilityclassobject.gettest().log(Status.INFO, "2nd Value from dropdown: " + secondValue);
		} else {
			System.out.println("2nd option not found in the dropdown");
			utilityclassobject.gettest().log(Status.FAIL, "2nd option not found in the dropdown");
		}
	}
}
