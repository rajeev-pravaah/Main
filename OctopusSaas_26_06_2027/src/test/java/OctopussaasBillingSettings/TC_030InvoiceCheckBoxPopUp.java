package OctopussaasBillingSettings;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClass80;
import com.Octopussaas.ObjectRepository.BillingSettings;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)
public class TC_030InvoiceCheckBoxPopUp extends BaseClass80 {
	HomePage hp;
	BillingSettings bs;

	@Test
	public void TC_030InvoiceChcekBOxPopup() throws InterruptedException {
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
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");

		// Scroll to invoice checkbox and click
		WebElement invoiceCheckbox = bs.getInvoiceCheckbox();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", invoiceCheckbox);
		Thread.sleep(1000);
		invoiceCheckbox.click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Invoice # checkbox");
		System.out.println("INFO: Clicked on Invoice # checkbox");

		// Wait for confirm popup to appear
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(bs.getConfirmButton()));
			utilityclassobject.gettest().log(Status.PASS, "Confirm popup is displayed successfully after clicking Invoice # checkbox");
			System.out.println("PASS: Confirm popup is displayed successfully after clicking Invoice # checkbox");

			// Close the popup using the ✕ button
			WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(bs.getCloseButton()));
			Thread.sleep(1000);
			closeBtn.click();
			utilityclassobject.gettest().log(Status.INFO, "Clicked close (✕) on popup");
			System.out.println("INFO: Clicked close (✕) on popup");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Confirm popup did NOT appear after clicking Invoice # checkbox: " + e.getMessage());
			System.out.println("FAIL: Confirm popup did NOT appear: " + e.getMessage());
		}
	}
}