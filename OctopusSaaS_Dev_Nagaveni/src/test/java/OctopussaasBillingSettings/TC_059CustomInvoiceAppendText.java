package OctopussaasBillingSettings;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClass80;
import com.Octopussaas.ObjectRepository.BillingSettings;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)
public class TC_059CustomInvoiceAppendText extends BaseClass80 {

	HomePage hp;
	BillingSettings bs;

	@Test
	public void TC_059AppendCustomInvoiceText() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");

		hp = new HomePage(driver);
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
		// scroll to the custom invoice text field
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getInvoiceDateCheckbox());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);

		// Enter new text in the custom invoice text field using sendKeys
		String newCustomText = "This is appended text.";
		bs.getCustominvoicemessageTextfield().sendKeys(newCustomText);
		Thread.sleep(2000);
		// Click outside to trigger save/update
		//bs.getPrintingAndEnvelopeInstructionsHeader().click();
		//click ouside to trigger save/update
		((JavascriptExecutor) driver).executeScript("document.body.click();");
		
		
		Thread.sleep(2000);
		// Verify that the new text is appended - getText() may return empty on contenteditable divs, fallback to textContent
		String updatedCustomInvoiceText = bs.getCustominvoicemessageTextfield().getText();
		if (updatedCustomInvoiceText == null || updatedCustomInvoiceText.isEmpty()) {
			updatedCustomInvoiceText = (String) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].textContent;", bs.getCustominvoicemessageTextfield());
		}
		if (updatedCustomInvoiceText != null && updatedCustomInvoiceText.contains(newCustomText)) {
			utilityclassobject.gettest().log(Status.PASS, "Custom invoice text field updated text is: " + updatedCustomInvoiceText);
			System.out.println("PASS: Custom invoice text field updated text is: " + updatedCustomInvoiceText);
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Custom invoice text was not appended correctly. Actual: " + updatedCustomInvoiceText);
			System.out.println("FAIL: Custom invoice text was not appended correctly. Actual: " + updatedCustomInvoiceText);
			Assert.fail("Custom invoice text was not appended correctly. Actual: " + updatedCustomInvoiceText);
		}
	}
}