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

public class TC_097SecondInitialCheckboxWithoutChcekDyasTextField extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_097SecondInitialCheckboxWithoutChcekDyasTextfield() throws InterruptedException, EncryptedDocumentException, IOException {
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
		Thread.sleep(2000);
		WebElement checkbox = bs.getFirstoverdueEmailInitialCheckbox();
		WebElement textfield = bs.getThefirstoverdueemailSentInitialDaysTextfield();
		
	    checkbox.click();

		// Step 1: Uncheck checkbox if selected
		if (checkbox.isSelected()) {
		    checkbox.click();
		}
		

		// Step 2: Verify text field is disabled
		if (!textfield.isEnabled()) {
		    System.out.println("PASS: Text field is disabled");
		    utilityclassobject.gettest().log(Status.INFO, "Text field is disabled as expected");

		    // Step 3: Try entering value
		    try {
		    	textfield.sendKeys("Test Value");
		        System.out.println("FAIL: Value entered even though field is disabled");
		        utilityclassobject.gettest().log(Status.FAIL, "Value entered even though field is disabled");
		    } catch (Exception e) {
		        System.out.println("PASS: Cannot enter value because field is disabled");
		        	utilityclassobject.gettest().log(Status.INFO, "Cannot enter value because field is disabled");
		    }

		} else {
		    System.out.println("FAIL: Text field is still enabled");
		    utilityclassobject.gettest().log(Status.FAIL, "Text field is still enabled");
		}
	    checkbox.click();

	}
}
