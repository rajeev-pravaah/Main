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
import org.openqa.selenium.By;


@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_073AddnewPaymentTypeWithCheckBox extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_073AddpaymentTypeWithValidInputandCheckBox() throws InterruptedException {
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
		//add valid input in the text field and click on save button
		jlib=new javautility();
		int randomnum = jlib.getRandomNumber();
		 String newname = "NetBanking"+randomnum;
		bs.getPaymentTypeTextField().sendKeys(newname);
		bs.getSaveButtonfromPaymentTypePopup().click();
		Thread.sleep(2000);
		//verify the new payment type is added is visible in the accepted payment type list
		String actualpaymenttype=bs.getAcceptedpaymentTypeListSection().getText();
		if(actualpaymenttype.contains("NetBanking"+randomnum+"")) {
			System.out.println("New payment type is added successfully and visible in the accepted payment type list");
			utilityclassobject.gettest().log(Status.PASS, "New payment type is added successfully and visible in the accepted payment type list");
		} else {
			System.out.println("New payment type is not added and not visible in the accepted payment type list");
			utilityclassobject.gettest().log(Status.FAIL, "New payment type is not added and not visible in the accepted payment type list");
		}
		// validate this check box is present or not and select the check box
		if(driver.findElement(By.xpath("//span[text()='"+newname+"']/../descendant::div")).isDisplayed()) {

		    driver.findElement(By.xpath("//span[text()='"+newname+"']/../descendant::div")).click();

		    System.out.println("The check box is present and selected successfully");
		    utilityclassobject.gettest().log(Status.PASS,
		            "The check box is present and selected successfully");

		} else {

		    System.out.println("The check box is not present");
		    utilityclassobject.gettest().log(Status.FAIL,
		            "The check box is not present");
		}
	}
}
