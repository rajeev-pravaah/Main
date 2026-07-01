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

public class TC_094SubsequentDaysWithoutCheckbox extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_094SubsequentDaysWithoutCheckbox() throws InterruptedException, EncryptedDocumentException, IOException {
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
		wlib.scrollToelement(driver, bs.getNotificationfrequencySubsequentChcekBox());
		bs.getNotificationfrequencySubsequentChcekBox().click();
		utilityclassobject.gettest().log(Status.INFO, "Notification frequency subsequent checkbox is unchecked ");
		System.out.println("INFO: Notification frequency subsequent checkbox is unchecked ");
		Thread.sleep(2000);
		WebElement daystxtfield = bs.getSubsequent1DaysTextfieldfromNotificationSettings();
		//try to pass value in days text field and it should not accept value as it is disabled
		try {
			daystxtfield.sendKeys("5");
			utilityclassobject.gettest().log(Status.FAIL, "Days text field is accepting value even when the checkbox is unchecked");
			System.out.println("FAIL: Days text field is accepting value even when the checkbox is unchecked");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.PASS, "Days text	 field is not accepting value as the checkbox is unchecked");
			System.out.println("PASS: Days text field is not accepting value as the checkbox is unchecked");
		}
		bs.getNotificationfrequencySubsequentChcekBox().click();

	}
}
