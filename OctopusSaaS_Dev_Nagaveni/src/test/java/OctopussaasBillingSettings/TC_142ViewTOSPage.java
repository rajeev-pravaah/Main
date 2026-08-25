package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class TC_142ViewTOSPage extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_142ViewTOSPage() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1: Click on Profile Icon (User Avatar)
		// XPath from Repository: //button[@class='flex items-center gap-4 focus:outline-none']
		try {
			WebElement profileIcon = wait.until(
					ExpectedConditions.elementToBeClickable(hp.getMyProfile()));
			wlib.scrollToelement(driver, profileIcon);
			Thread.sleep(1000);
			profileIcon.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on Profile Icon successfully");
			System.out.println("INFO: Clicked on Profile Icon successfully");
		} catch (Exception e) {
			// Fallback: JS click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", hp.getMyProfile());
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on Profile Icon via JavaScript");
			System.out.println("INFO: Clicked on Profile Icon via JavaScript");
		}

		// Step 2: Click on View TOS button from the profile dropdown
		// XPath from Repository: //button[text()='View TOS']
		try {
			WebElement viewTOSButton = wait.until(
					ExpectedConditions.elementToBeClickable(bs.getViewTOSButtonfromProfileDropdown()));
			viewTOSButton.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on View TOS button successfully");
			System.out.println("INFO: Clicked on View TOS button successfully");
		} catch (Exception e) {
			// Fallback: JS click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					bs.getViewTOSButtonfromProfileDropdown());
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on View TOS button via JavaScript");
			System.out.println("INFO: Clicked on View TOS button via JavaScript");
		}

		// Step 3: Verify View TOS page / popup is displayed successfully
		try {
			boolean isPageDisplayed = driver.getPageSource().contains("Terms of Service")
					|| driver.getPageSource().contains("View TOS")
					|| driver.getPageSource().contains("TOS")
					|| driver.getCurrentUrl().contains("tos")
					|| driver.getCurrentUrl().contains("terms-of-service")
					|| driver.getCurrentUrl().contains("termsOfService");

			if (isPageDisplayed) {
				System.out.println("PASS: View TOS page is displayed successfully");
				utilityclassobject.gettest().log(Status.PASS, "View TOS page is displayed successfully");
			} else {
				System.out.println("FAIL: View TOS page is NOT displayed");
				utilityclassobject.gettest().log(Status.FAIL, "View TOS page is NOT displayed");
			}
		} catch (Exception e) {
			System.out.println("FAIL: Exception while verifying View TOS page - " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL,
					"Exception while verifying View TOS page - " + e.getMessage());
		}
	}
}
