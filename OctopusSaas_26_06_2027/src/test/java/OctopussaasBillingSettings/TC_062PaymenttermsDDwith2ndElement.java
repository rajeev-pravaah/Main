package OctopussaasBillingSettings;

import java.util.List;

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

public class TC_062PaymenttermsDDwith2ndElement extends BaseClass80{
// This test case will verify the presence of the second element in the payment terms dropdown and validate its text
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_062PaymentTermsDDwithelSecondElemetNet10() throws InterruptedException {
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
		//get the text from dropdown
		String defaultPaymentTerms = bs.getPaymenttermsdropdown().getText();
		System.out.println("Default Payment Terms: " + defaultPaymentTerms);
		utilityclassobject.gettest().log(Status.INFO, "Default payment terms from dropdown: " + defaultPaymentTerms);
		bs.getPaymenttermsdropdown().click();
		// Fetch all elements with role='option'
		 List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']"));

		// Print all option texts
		for (WebElement option : options) {
		    System.out.println(option.getText());
		}
		// Log the options in the report
		utilityclassobject.gettest().log(Status.INFO, "Payment terms dropdown options:");
		for (WebElement option : options) {
		    utilityclassobject.gettest().log(Status.INFO, option.getText());
		}
		//verify the second elemt is Net 10
		if(options.size() >= 2) {
			String secondOptionText = options.get(1).getText();
			System.out.println("Second option text: " + secondOptionText);
			utilityclassobject.gettest().log(Status.INFO, "Second option text: " + secondOptionText);
			if(secondOptionText.equals("Net 10")) {
				System.out.println("Second element is Net 10 as expected");
				utilityclassobject.gettest().log(Status.PASS, "Second element is Net 10 as expected");
			} else {
				System.out.println("Second element is not Net 10, found: " + secondOptionText);
				utilityclassobject.gettest().log(Status.FAIL, "Second element is not Net 10, found: " + secondOptionText);
			}
		} else {
			System.out.println("Less than 2 options found in the dropdown");
			utilityclassobject.gettest().log(Status.FAIL, "Less than 2 options found in the dropdown");
		}
		
		
		
	}
}
