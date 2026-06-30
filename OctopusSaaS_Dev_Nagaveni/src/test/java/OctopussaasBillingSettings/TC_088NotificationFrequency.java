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

public class TC_088NotificationFrequency extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_088NotificationfrequencyCheckBox() throws InterruptedException, EncryptedDocumentException, IOException {
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
		wlib.scrollToelement(driver, bs.getOctoSmartManifestCheckbox());
	    //verify check box notification frequency initial check box is displayed and enabled
		if(bs.getNotificationfrequencyinitialCheckBox().isDisplayed() && bs.getNotificationfrequencyinitialCheckBox().isEnabled()) {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency initial check box is displayed and enabled");
			System.out.println("INFO: Notification frequency initial check box is displayed and enabled");
		}
		else {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency initial check box is not displayed or not enabled");
			System.out.println("INFO: Notification frequency initial check box is not displayed or not enabled");
		}
		//verify notification frequency intial text field is displayed and enabled
		if(bs.getNotificationfrequencyinitialTextfield().isDisplayed() && bs.getNotificationfrequencyinitialTextfield().isEnabled()) {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency initial text field is displayed and enabled");
			System.out.println("INFO: Notification frequency initial text field is displayed and enabled");
		}
		else {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency initial text field is not displayed or not enabled");
			System.out.println("INFO: Notification frequency initial text field is not displayed or not enabled");
		}
	    //verify check box notification frequency initial check box is displayed and enabled
		if(bs.getNotificationfrequencySubsequentChcekBox().isDisplayed() && bs.getNotificationfrequencySubsequentChcekBox().isEnabled()) {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency subsequent check box is displayed and enabled");
			System.out.println("INFO: Notification frequency subsequent check box is displayed and enabled");
		}
		else {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency subsequent check box is not displayed or not enabled");
			System.out.println("INFO: Notification frequency subsequent check box is not displayed or not enabled");
		}	
		//verify notification frequency subsequent text field is displayed and enabled
		if(bs.getNotificationfrequencySubsequentTextfield().isDisplayed() && bs.getNotificationfrequencySubsequentTextfield().isEnabled()) {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency subsequent text field is displayed and enabled");
			System.out.println("INFO: Notification frequency subsequent text field is displayed and enabled");
		}
		else {
			utilityclassobject.gettest().log(Status.INFO, "Notification frequency subsequent text field is not displayed or not enabled");
			System.out.println("INFO: Notification frequency subsequent text field is not displayed or not enabled");
		}
		}
}
