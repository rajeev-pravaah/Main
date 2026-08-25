package OctopussaasBillingSettings;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class TC_095InvoiceReminderinitialCheckBox extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_095InvoicereminderemailInitialChcekbox() throws InterruptedException, EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		System.out.println("INFO: Transporter setting page is displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		bs=new BillingSettings(driver);
		//scroll to the custom invoice text field (use invoice date element as anchor)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, bs.getFirstoverdueEmailInitialCheckbox());
		bs.getFirstoverdueEmailInitialCheckbox().click();
		bs.getFirstoverdueEmailInitialCheckbox().click();

		utilityclassobject.gettest().log(Status.INFO, "First overdue email initial checkbox is checked");
		System.out.println("INFO: First overdue email initial checkbox is checked");
		Thread.sleep(2000);

		// Verify the days text field is displayed after checking the initial checkbox
		boolean isDaysTextfieldDisplayed = bs.getThefirstoverdueemailSentInitialDaysTextfield().isDisplayed();
		if (isDaysTextfieldDisplayed) {
			utilityclassobject.gettest().log(Status.PASS, "Days text field is displayed after checking the first overdue email initial checkbox");
			System.out.println("PASS: Days text field is displayed after checking the first overdue email initial checkbox");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Days text field is NOT displayed after checking the first overdue email initial checkbox");
			System.out.println("FAIL: Days text field is NOT displayed after checking the first overdue email initial checkbox");
		}
		Thread.sleep(2000);

		// Scroll to and check the 'Subsequent Reminders are sent at intervals' checkbox
		wlib.scrollToelement(driver, bs.getSubsequentcheckboxremindersaresentcheckbox());
		bs.getSubsequentcheckboxremindersaresentcheckbox().click();
		bs.getSubsequentcheckboxremindersaresentcheckbox().click();

		
		utilityclassobject.gettest().log(Status.INFO, "Subsequent reminders checkbox (Reminders are sent at intervals of) is checked");
		System.out.println("INFO: Subsequent reminders checkbox (Reminders are sent at intervals of) is checked");
		Thread.sleep(2000);

		// Verify the subsequent days text field is displayed
		boolean isSubsequentDaysTextfieldDisplayed = bs.getSecondremindersentatintervalsSubsequentDaysTextfield().isDisplayed();
		if (isSubsequentDaysTextfieldDisplayed) {
			utilityclassobject.gettest().log(Status.PASS, "Subsequent days text field is displayed after checking the subsequent reminders checkbox");
			System.out.println("PASS: Subsequent days text field is displayed after checking the subsequent reminders checkbox");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Subsequent days text field is NOT displayed after checking the subsequent reminders checkbox");
			System.out.println("FAIL: Subsequent days text field is NOT displayed after checking the subsequent reminders checkbox");
		}
		Thread.sleep(2000);
	}
}
