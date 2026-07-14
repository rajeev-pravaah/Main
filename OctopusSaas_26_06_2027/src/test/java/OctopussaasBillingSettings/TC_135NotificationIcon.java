package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
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

public class TC_135NotificationIcon extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_135NotificationIcon() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
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

		// Scroll to payment terms dropdown as anchor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);

		// Step 1: Scroll to and click on the Notification Bell Icon
		// XPath from Repository: //div[@title='Notifications']
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement notificationIcon = wait.until(
					ExpectedConditions.elementToBeClickable(bs.getNotificationsBellIcon()));
			wlib.scrollToelement(driver, notificationIcon);
			Thread.sleep(1000);
			notificationIcon.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on Notification Bell Icon successfully");
			System.out.println("INFO: Clicked on Notification Bell Icon successfully");
		} catch (Exception e) {
			// Fallback: JS click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bs.getNotificationsBellIcon());
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on Notification Bell Icon via JavaScript");
			System.out.println("INFO: Clicked on Notification Bell Icon via JavaScript");
		}

		// Step 2: Verify Notification Popup is displayed
		try {
			WebElement notificationPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(@class,'notification') or contains(@id,'notification')" +
							" or contains(@aria-label,'notification') or contains(@class,'Notification')" +
							" or contains(text(),'Notification') or contains(text(),'notification')]")));

			if (notificationPopup != null && notificationPopup.isDisplayed()) {
				String popupText = notificationPopup.getText();
				System.out.println("PASS: Notification popup is displayed successfully");
				System.out.println("INFO: Notification popup text --> " + popupText);
				utilityclassobject.gettest().log(Status.PASS, "Notification popup is displayed successfully");
				utilityclassobject.gettest().log(Status.INFO, "Notification popup text --> " + popupText);
			} else {
				System.out.println("FAIL: Notification popup is NOT displayed");
				utilityclassobject.gettest().log(Status.FAIL, "Notification popup is NOT displayed");
			}
		} catch (Exception e) {
			System.out.println("FAIL: Exception while verifying Notification popup - " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL,
					"Exception while verifying Notification popup - " + e.getMessage());
		}
	}
}
