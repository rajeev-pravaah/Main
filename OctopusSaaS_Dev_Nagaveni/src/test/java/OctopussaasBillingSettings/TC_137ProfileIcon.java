package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

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

public class TC_137ProfileIcon extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_137ProfileIcon() throws InterruptedException, EncryptedDocumentException, IOException {

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
		// Step 1: Click on Profile Icon (User Avatar)
		// XPath from Repository: //button[@class='flex items-center gap-4 focus:outline-none']
		hp.getMyProfile().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Profile Icon successfully");
		System.out.println("INFO: Clicked on Profile Icon successfully");

		// Step 2: Fetch and print profile name and list of dropdown elements
		List<WebElement> dropdownItems = driver.findElements(By.xpath("//li[contains(@class,'hover:bg-lightBlue')]"));
		for(WebElement item : dropdownItems) {
		    System.out.println(item.getText());
		    System.out.println("First element: " + dropdownItems.get(0).getText());
		}
		String profilename = driver.findElement(By.xpath("//div[@class='flex flex-col px-4 py-2']")).getText();
		System.out.println("First element: " + profilename);
		utilityclassobject.gettest().log(Status.INFO, "Profile name is displayed successfully");
		System.out.println("INFO: Profile name is displayed successfully");
		
	}
}
