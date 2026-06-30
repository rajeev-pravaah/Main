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

public class TC_058CustomInvoiceTextFieledWithDefaultData extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	

	@Test
	public void TC_058CustomInvioceWithDefaultData() throws InterruptedException {
		// Log via utility class and stdout for important events
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		// wlib is provided by BaseClass80, no need to reinitialize here
		Thread.sleep(2000);
        // Ensure page zoom is 80% so the element positions are consistent
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		System.out.println("INFO: Transporter setting page is displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		bs=new BillingSettings(driver);
		//scrollTo aging report checkbox
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getInvoiceDateCheckbox());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);
		//read data from custom invoice text field
		// The custom invoice message is implemented as a div (not an input), so getAttribute("value") may return null.
		// Use getText() and guard against null to avoid NullPointerException when calling contains().
		String customInvoiceText = bs.getCustominvoicemessageTextfield().getText();
		if (customInvoiceText == null) {
			customInvoiceText = "";
		}
		utilityclassobject.gettest().log(Status.INFO, "Custom invoice text field default data is: "+customInvoiceText);
		System.out.println("INFO: Custom invoice text field default data is: "+customInvoiceText);
		//compare the default data with expected data by using assertion
		String expectedData="Thank you for choosing our services!!";
		if(customInvoiceText.contains(expectedData)) {
			utilityclassobject.gettest().log(Status.PASS, "Custom invoice text field default data is as expected: "+customInvoiceText);
			System.out.println("PASS: Custom invoice text field default data is as expected: "+customInvoiceText);
			}else {
					utilityclassobject.gettest().log(Status.FAIL, "Custom invoice text field default data is not as expected. Actual: "+customInvoiceText+", Expected: "+expectedData);
				System.out.println("FAIL: Custom invoice text field default data is not as expected. Actual: "+customInvoiceText+", Expected: "+expectedData);
					
			}
		
	}
}