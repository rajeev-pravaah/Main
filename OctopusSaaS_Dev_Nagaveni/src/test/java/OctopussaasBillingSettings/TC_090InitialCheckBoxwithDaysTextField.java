package OctopussaasBillingSettings;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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

public class TC_090InitialCheckBoxwithDaysTextField extends BaseClass80 {
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_089NotificationfrequencyIntialCheckBox()
			throws InterruptedException, EncryptedDocumentException, IOException {
		try {
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
			bs = new BillingSettings(driver);
			// scroll to the custom invoice text field (use invoice date element as anchor)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
			utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
			System.out.println("INFO: Billing setting page is displayed successfully");
			Thread.sleep(2000);
			wlib.scrollToelement(driver, bs.getNotificationfrequencyinitialCheckBox());

			// Desired value to set
			String daysValue = "7";

			// Use robust checker for the initial notification checkbox
			boolean initiallyChecked = bs.isNotificationfrequencyinitialChecked();
			System.out.println("INFO: Detected initial checkbox checked state: " + initiallyChecked);

			if (initiallyChecked) {
				utilityclassobject.gettest().log(Status.INFO, "Initial checkbox already checked - setting value " + daysValue);
				System.out.println("INFO: Initial checkbox already checked - setting value " + daysValue);
				// ensure textfield is clickable then set value
				try {
					wlib.waitUntilElementClickable(driver, bs.getNotificationfrequencyinitialTextfield());
					bs.getNotificationfrequencyinitialTextfield().clear();
					bs.getNotificationfrequencyinitialTextfield().sendKeys(daysValue);
				} catch (Exception e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].focus(); arguments[0].value='';", bs.getNotificationfrequencyinitialTextfield());
					js.executeScript("arguments[0].value='" + daysValue + "';", bs.getNotificationfrequencyinitialTextfield());
				}
				utilityclassobject.gettest().log(Status.PASS, "Set initial notification frequency to " + daysValue);
				System.out.println("PASS: Set initial notification frequency to " + daysValue);
			} else {
				utilityclassobject.gettest().log(Status.INFO, "Initial checkbox not checked - attempting to check it and set value " + daysValue);
				System.out.println("INFO: Initial checkbox not checked - attempting to check it and set value " + daysValue);
				// attempt to check using the robust ensure helper
				boolean becameChecked = false;
				try {
					becameChecked = bs.ensureNotificationfrequencyinitialChecked(true, 10);
					System.out.println("INFO: ensureNotificationfrequencyinitialChecked returned: " + becameChecked);
				} catch (Exception e) {
					System.out.println("WARN: Exception while trying to ensure initial checkbox: " + e.getMessage());
				}

				if (!becameChecked) {
					utilityclassobject.gettest().log(Status.FAIL, "Could not check the Initial checkbox; will still try to set value");
					System.out.println("FAIL: Could not check the Initial checkbox; will still try to set value");
				} else {
					utilityclassobject.gettest().log(Status.PASS, "Initial checkbox is checked");
					System.out.println("PASS: Initial checkbox is checked");
				}

				// Set the field value regardless of checkbox final state
				try {
					wlib.waitUntilElementClickable(driver, bs.getNotificationfrequencyinitialTextfield());
					bs.getNotificationfrequencyinitialTextfield().clear();
					bs.getNotificationfrequencyinitialTextfield().sendKeys(daysValue);
				} catch (Exception e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].focus(); arguments[0].value='';", bs.getNotificationfrequencyinitialTextfield());
					js.executeScript("arguments[0].value='" + daysValue + "';", bs.getNotificationfrequencyinitialTextfield());
				}
				utilityclassobject.gettest().log(Status.INFO, "Notification frequency initial text field set to " + daysValue);
				System.out.println("INFO: Notification frequency initial text field set to " + daysValue);
			}
		} catch (Exception e) {
			// Capture detailed diagnostics to help find root cause
			System.out.println("ERROR: Exception in test flow: " + e.getClass().getName() + " - " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "Exception while handling Initial checkbox: " + e.getMessage());
			// Try to safely locate the checkbox and textfield and log their attributes
			try {
				By chkXpath = By.xpath("//span[text()='Initial:']/ancestor::div[@class='pl-6 flex items-center gap-4']/descendant::div");
				By txtXpath = By.xpath("//span[text()='Initial:']/following::input[1]");
				WebElement chk = null;
				WebElement txt = null;
				try { chk = driver.findElement(chkXpath); } catch (NoSuchElementException nse) { System.out.println("CHK not found by xpath"); }
				try { txt = driver.findElement(txtXpath); } catch (NoSuchElementException nse) { System.out.println("TXT not found by xpath"); }
				if (chk != null) {
					System.out.println("CHK.tagName=" + chk.getTagName());
					System.out.println("CHK.text=" + chk.getText());
					System.out.println("CHK.aria-checked=" + chk.getAttribute("aria-checked"));
					System.out.println("CHK.class=" + chk.getAttribute("class"));
					System.out.println("CHK.outerHTML=" + chk.getAttribute("outerHTML"));
				}
				if (txt != null) {
					System.out.println("TXT.tagName=" + txt.getTagName());
					System.out.println("TXT.value=" + txt.getAttribute("value"));
					System.out.println("TXT.class=" + txt.getAttribute("class"));
					System.out.println("TXT.outerHTML=" + txt.getAttribute("outerHTML"));
				}
			} catch (Exception ex) {
				System.out.println("ERROR while gathering diagnostics: " + ex.getMessage());
			}
			// Re-throw to mark test as failed after logging
			throw e;
		}
	}
}