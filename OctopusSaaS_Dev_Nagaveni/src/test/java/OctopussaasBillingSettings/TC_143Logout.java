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

public class TC_143Logout extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_143Logout() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1: Click on Profile Icon to go to Transporter Settings
		// XPath from Repository: //img[@alt='User Avatar']
		hp.getUserprofile().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on User Profile icon successfully");
		System.out.println("INFO: Clicked on User Profile icon successfully");

		// Step 2: Click on Transporter Settings
		// XPath from Repository: //a[contains(text(),'Transporter Settings')]
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Transporter Settings successfully");
		System.out.println("INFO: Clicked on Transporter Settings successfully");

		// Step 3: Click on Billing Settings
		// XPath from Repository: //a[text()='Billing Settings']
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Billing Settings successfully");
		System.out.println("INFO: Clicked on Billing Settings successfully");
		bs = new BillingSettings(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Billing Settings page is displayed successfully");
		System.out.println("INFO: Billing Settings page is displayed successfully");

		// Step 4: Click on My Profile (User Avatar) button
		// XPath from Repository: //button[@class='flex items-center gap-4 focus:outline-none']
		try {
			WebElement profileIcon = wait.until(
					ExpectedConditions.elementToBeClickable(hp.getMyProfile()));
			wlib.scrollToelement(driver, profileIcon);
			Thread.sleep(1000);
			profileIcon.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on My Profile button successfully");
			System.out.println("INFO: Clicked on My Profile button successfully");
		} catch (Exception e) {
			// Fallback: JS click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", hp.getMyProfile());
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on My Profile button via JavaScript");
			System.out.println("INFO: Clicked on My Profile button via JavaScript");
		}

		// Step 5: Click on Logout button from the profile dropdown
		// XPath from Repository: //button[contains(text(),'Logout')]
		try {
			WebElement logoutButton = wait.until(
					ExpectedConditions.elementToBeClickable(hp.getLogOut()));
			logoutButton.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on Logout button successfully");
			System.out.println("INFO: Clicked on Logout button successfully");
		} catch (Exception e) {
			// Fallback: JS click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", hp.getLogOut());
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on Logout button via JavaScript");
			System.out.println("INFO: Clicked on Logout button via JavaScript");
		}

		// Step 6: Verify Login page is displayed after logout
		try {
			boolean isLoginPageDisplayed = driver.getPageSource().contains("Login")
					|| driver.getPageSource().contains("Sign In")
					|| driver.getPageSource().contains("Email")
					|| driver.getPageSource().contains("Password")
					|| driver.getCurrentUrl().contains("login")
					|| driver.getCurrentUrl().contains("signin")
					|| driver.getCurrentUrl().contains("sign-in");

			if (isLoginPageDisplayed) {
				System.out.println("PASS: Login page is displayed successfully after Logout");
				utilityclassobject.gettest().log(Status.PASS, "Login page is displayed successfully after Logout");
			} else {
				System.out.println("FAIL: Login page is NOT displayed after Logout");
				utilityclassobject.gettest().log(Status.FAIL, "Login page is NOT displayed after Logout");
			}
		} catch (Exception e) {
			System.out.println("FAIL: Exception while verifying Login page - " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL,
					"Exception while verifying Login page - " + e.getMessage());
		}
	}
}
