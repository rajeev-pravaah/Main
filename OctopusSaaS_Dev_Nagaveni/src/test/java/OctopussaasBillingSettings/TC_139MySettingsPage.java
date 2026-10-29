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

public class TC_139MySettingsPage extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_139MySettingsPage() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");

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

		// Step 2: Click on My Settings option from the profile dropdown
		// XPath from Repository: //a[contains(text(),'My Settings')]
		try {
			WebElement mySettingsOption = wait.until(
					ExpectedConditions.elementToBeClickable(hp.getMySettings()));
			mySettingsOption.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on My Settings option successfully");
			System.out.println("INFO: Clicked on My Settings option successfully");
		} catch (Exception e) {
			// Fallback: JS click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", hp.getMySettings());
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on My Settings option via JavaScript");
			System.out.println("INFO: Clicked on My Settings option via JavaScript");
		}

		// Step 3: Verify My Profile page is displayed successfully
		try {
			boolean isMyProfilePageDisplayed = driver.getPageSource().contains("My Profile")
					|| driver.getPageSource().contains("My Settings")
					|| driver.getCurrentUrl().contains("my-profile")
					|| driver.getCurrentUrl().contains("myProfile")
					|| driver.getCurrentUrl().contains("my-settings")
					|| driver.getCurrentUrl().contains("mySettings");

			if (isMyProfilePageDisplayed) {
				System.out.println("PASS: My Profile page is displayed successfully");
				utilityclassobject.gettest().log(Status.PASS, "My Profile page is displayed successfully");
			} else {
				System.out.println("FAIL: My Profile page is NOT displayed");
				utilityclassobject.gettest().log(Status.FAIL, "My Profile page is NOT displayed");
			}
		} catch (Exception e) {
			System.out.println("FAIL: Exception while verifying My Profile page - " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL,
					"Exception while verifying My Profile page - " + e.getMessage());
		}
	}
}