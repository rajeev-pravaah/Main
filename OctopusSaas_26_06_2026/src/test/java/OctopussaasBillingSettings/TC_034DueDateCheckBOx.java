package OctopussaasBillingSettings;

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

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_034DueDateCheckBOx extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_034DueDateChcekBOx() throws InterruptedException {
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
		// Ensure page zoom is 80% after Billing Settings page loads
		try { ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'"); } catch (Exception e) { /* ignore if not supported */ }
		bs=new BillingSettings(driver);
		//scrollTo invoice checkbox
		WebElement invoiceCheckbox = bs.getInvoiceCheckbox();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", invoiceCheckbox);
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);
		//due date checkbox should be click
		WebElement dueCheckbox = bs.getDueDateCheckbox();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dueCheckbox);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dueCheckbox));
		System.out.println("INFO: Before click, dueCheckbox.isSelected(): " + dueCheckbox.isSelected());
		dueCheckbox.click();
		Thread.sleep(500);
		// if the click didn't toggle the checkbox, use JS click as fallback
		if (dueCheckbox.isSelected() == false) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dueCheckbox);
			Thread.sleep(300);
		}
		utilityclassobject.gettest().log(Status.INFO, "Due date checkbox is clicked (first toggle). Selected: " + dueCheckbox.isSelected());
		System.out.println("INFO: Due date checkbox is clicked (first toggle). Selected: " + dueCheckbox.isSelected());
		//again check due date checkbox (toggle back)
		wait.until(ExpectedConditions.elementToBeClickable(dueCheckbox));
		dueCheckbox.click();
		Thread.sleep(500);
		if (dueCheckbox.isSelected() == true) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dueCheckbox);
			Thread.sleep(300);
		}
		utilityclassobject.gettest().log(Status.INFO, "Due date checkbox is clicked (second toggle). Selected: " + dueCheckbox.isSelected());
		System.out.println("INFO: Due date checkbox is clicked (second toggle). Selected: " + dueCheckbox.isSelected());
	}
}