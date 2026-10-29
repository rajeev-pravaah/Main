package OctopussaasBillingSettings;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
	public void TC_090InitialCheckBoxwithDaysTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		
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
			wlib.scrollToelement(driver, bs.getNotificationfrequencyinitialCheckBox());
			Thread.sleep(2000);
			// Click the checkbox only once to enable the input field
			bs.getNotificationfrequencyinitialCheckBox().click();
			bs.getNotificationfrequencyinitialCheckBox().click();

			Thread.sleep(1500);

			// Re-find the days input field fresh (avoids stale element after DOM re-render)
			WebElement daysField = driver.findElement(By.xpath("//span[text()='Initial:']/following::input[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", daysField);
			Thread.sleep(500);

			// Use Actions triple-click to select all existing text, then type the new value
			Actions actions = new Actions(driver);
			actions.click(daysField).keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("a").keyUp(org.openqa.selenium.Keys.CONTROL).perform();
			daysField.sendKeys(org.openqa.selenium.Keys.DELETE);
			daysField.sendKeys("5");

			// Trigger React's synthetic onChange event via native value setter
			((JavascriptExecutor) driver).executeScript(
				"var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
				"nativeInputValueSetter.call(arguments[0], '5');" +
				"arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
				"arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", daysField);
			Thread.sleep(2000);

			
	}
}