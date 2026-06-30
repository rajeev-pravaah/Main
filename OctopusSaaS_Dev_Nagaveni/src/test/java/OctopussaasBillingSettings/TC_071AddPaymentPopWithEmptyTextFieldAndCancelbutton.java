package OctopussaasBillingSettings;

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

public class TC_071AddPaymentPopWithEmptyTextFieldAndCancelbutton extends BaseClass80 {
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_071AddpaymentTypeLinkPopupWithEmptyTxetFieldandCancelbtn() throws InterruptedException {
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
		bs.getAddPaymentTypelink().click();
		Thread.sleep(2000);
		//verify the popup is displayed
		if(bs.getAddPaymentTypePopup().isDisplayed()) {
			System.out.println("Add Payment Type popup is displayed successfully");
			utilityclassobject.gettest().log(Status.PASS, "Add Payment Type popup is displayed successfully");
		} else {
			System.out.println("Add Payment Type popup is not displayed");
			utilityclassobject.gettest().log(Status.FAIL, "Add Payment Type popup is not displayed");
		}
		//verify the popup is displayed empty text field and cancel button
		if(bs.getPaymentTypeTextField().getText().isEmpty() && bs.getCancelButtonfrompaymentTypePopup().isDisplayed()) {
			System.out.println("Add Payment Type popup is displayed with empty text field and cancel button");
			utilityclassobject.gettest().log(Status.PASS, "Add Payment Type popup is displayed with empty text field and cancel button");
		} else {
			System.out.println("Add Payment Type popup is not displayed with empty text field and cancel button");
			utilityclassobject.gettest().log(Status.FAIL, "Add Payment Type popup is not displayed with empty text field and cancel button");
		}	
		//also verify it should displaye disabled save button
		if(!bs.getSaveButtonfromPaymentTypePopup().isEnabled()) {
			System.out.println("Save button is disabled as expected");
			utilityclassobject.gettest().log(Status.PASS, "Save button is disabled as expected");
		} else {
			System.out.println("Save button is not disabled");
			utilityclassobject.gettest().log(Status.FAIL, "Save button is not disabled");
		}
		//click on cancel button
		bs.getCancelButtonfrompaymentTypePopup().click();
	}
}
