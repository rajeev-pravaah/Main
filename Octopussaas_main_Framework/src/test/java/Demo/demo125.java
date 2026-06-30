package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseclassforDrivers;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AssestsDrivers;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class demo125 extends BaseclassforDrivers {

	AssestsDrivers ad;
	ExcelUtility elib;
	HomePage hp;

	@Test
	public void demo125_DriverProfileDateOfBirth() throws InterruptedException {

		utilityclassobject.gettest().log(Status.INFO, "Dashboard page is displayed successfully");
		System.out.println("INFO: Dashboard page is displayed successfully");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");

		// Step 1: Click on Assets dropdown from left navigation
		ad = new AssestsDrivers(driver);
		ad.getAssests().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Assets dropdown in left navigation");
		System.out.println("INFO: Clicked on Assets dropdown in left navigation");

		// Step 2: Click on Drivers from the Assets dropdown
		ad.getAssestsDrivers().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Drivers from Assets dropdown");
		System.out.println("INFO: Clicked on Drivers from Assets dropdown");

		// Step 3: Verify Driver List page is displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean isDriverListPageDisplayed = driver.getPageSource().contains("Drivers");
		if (isDriverListPageDisplayed) {
			System.out.println("PASS: Driver List page is displayed successfully");
			utilityclassobject.gettest().log(Status.PASS, "Driver List page is displayed successfully");
		} else {
			System.out.println("FAIL: Driver List page is NOT displayed");
			utilityclassobject.gettest().log(Status.FAIL, "Driver List page is NOT displayed");
		}
		Thread.sleep(2000);
// click on first name Toby Heelo name 
		driver.findElement(By.xpath("//div[contains(text(),'Toby  Hello')]")).click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on driver name 'T"
				+ "oby  Hello' to open driver profile");
		System.out.println("INFO: Clicked on driver name 'Toby  Hello' to"
				+ " open driver profile");
		
	}
	@Test
	public void demo125_DriverProfileDateOfBirth2() throws InterruptedException {
		System.out.println("INFO: Driver profile page is displayed successfully");
	}
}
