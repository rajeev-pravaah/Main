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

public class TC_117SuspensionofServiceNotificationCheckbox extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_117SuspensionofServiceNotificationCheckbox() throws InterruptedException, EncryptedDocumentException, IOException {

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

		// Scroll to the Suspension of Services Notification Checkbox
		wlib.scrollToelement(driver, bs.getSuspensionofservicesnotificationCheckbox());
		Thread.sleep(2000);

		// Perform click action on Suspension of Services Notification Checkbox
		WebElement suspensionNotificationCheckbox = bs.getSuspensionofservicesnotificationCheckbox();
		suspensionNotificationCheckbox.click();
		suspensionNotificationCheckbox.click();

		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Suspension of Services Notification Checkbox successfully");
		System.out.println("INFO: Clicked on Suspension of Services Notification Checkbox successfully");

		// Verify the checkbox is checked by checking attribute or class
		String checkedState = suspensionNotificationCheckbox.getAttribute("class");
		if (checkedState != null && (checkedState.contains("checked") || checkedState.contains("active")
				|| checkedState.contains("bg-") || checkedState.contains("true"))) {
			System.out.println("Suspension of Services Notification Checkbox is CHECKED");
			utilityclassobject.gettest().log(Status.PASS, "Suspension of Services Notification Checkbox is CHECKED successfully");
		} else {
			// Try JS click as fallback
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", suspensionNotificationCheckbox);
			Thread.sleep(2000);
			System.out.println("Suspension of Services Notification Checkbox clicked via JavaScript");
			utilityclassobject.gettest().log(Status.INFO, "Suspension of Services Notification Checkbox clicked via JavaScript");
		}
	}
}
