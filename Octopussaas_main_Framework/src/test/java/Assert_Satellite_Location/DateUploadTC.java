package Assert_Satellite_Location;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.SatelliteLocation;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class DateUploadTC extends BaseClassForGEneratorContacts {
	HomePage hp;
	SatelliteLocation sl;
	ExcelUtility elib;
	webDriverutility wd;

	@Test()
	public void TC_053VerifyStartofFiscalYearAcceptsManualInputs()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		
		//it is not an Magic Tc While running check the dependency To run independently comment dependency 
		
		//comment it
		//comment it
		//comment it
		
		
		hp = new HomePage(driver);
		utilityclassobject.gettest().log(com.aventstack.extentreports.Status.INFO, "Home Page is displayed");
		System.out.println("Home Page is displayed");
		Thread.sleep(6000);
		sl = new SatelliteLocation(driver);
		sl.getAssets().click();
		sl.getSatellite_Locations().click();
		sl.getSatelliteLocationsList().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Satellite Location Page is displayed");
		 System.out.println("Satellite Location Page is displayed");
		  List<WebElement> namelists = sl.getSatelliteLocationNameinlist();
		   //print each value using for loop
		  for(int i=0; i<namelists.size(); i++) {
			  String name = namelists.get(i).getText();
			  ExcelUtility elib1 = new ExcelUtility();
				 String satellitename = elib1.getDataFromExcel("SatelliteLocation", 35, 7);
			  if(name.equals(satellitename)) {
				  namelists.get(i).click();
				  utilityclassobject.gettest().log(Status.INFO, "Clicked on Satellite Location Name in the list: " +name);
				  System.out.println("Clicked on Satellite Location Name in the list: " +name);
				  break;
			  }
		  }
		  
		 
		 //comment it
		//comment it//comment it
		//comment it
		 
		 
		
		
		
		// Verify that the Start of Fiscal Year field does not accept manual typing
		String before = sl.getStartoffiscalyearfield().getText();
		System.out.println("Start of Fiscal Year before trying manual input: " + before);
		utilityclassobject.gettest().log(Status.INFO, "Start of Fiscal Year before trying manual input: " + before);
		// Try to send keys via Actions (many datepicker spans won't accept direct
		// input)
		Actions actions = new Actions(driver);
		try {
			actions.click(sl.getStartoffiscalyearfield()).sendKeys("01/01/2000").perform();
		} catch (Exception e) {
			// ignore - expected for non-input elements
		}
		Thread.sleep(500);
		String after = sl.getStartoffiscalyearfield().getText();
		System.out.println("Start of Fiscal Year after trying manual input: " + after);
		utilityclassobject.gettest().log(Status.INFO, "Start of Fiscal Year after trying manual input: " + after);
		if (after.equals(before)) {
			System.out.println("PASS: Start of Fiscal Year field did not accept manual input");
			utilityclassobject.gettest().log(Status.PASS, "Start of Fiscal Year field did not accept manual input");
		} else {
			System.out.println("FAIL: Start of Fiscal Year field accepted manual input: " + after);
			utilityclassobject.gettest().log(Status.FAIL, "Start of Fiscal Year field accepted manual input: " + after);
		}
	}

	@Test(dependsOnMethods = "TC_053VerifyStartofFiscalYearAcceptsManualInputs")
	public void TC_054VerifyStartofFiscalYearTextfieldAcceptDate()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
//sl.getGeneralphonetext().click();
		try {
			sl.getStartoffiscalyearfield().click();
		} catch (Exception e) {
			System.out.println("Start of Fiscal Year field is not clickable");
			utilityclassobject.gettest().log(Status.INFO, "Start of Fiscal Year field is not clickable");
		}
//sl.getStartoffiscalendaricon().click();
		LocalDate today = LocalDate.now();
		String currentDay = String.valueOf(today.getDayOfMonth());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + currentDay + "']")));

		date.click();
		sl.getGeneralphonetext().click();

	}

	@Test(dependsOnMethods = "TC_054VerifyStartofFiscalYearTextfieldAcceptDate")
	public void TC_055VerifyUsercanAbletoSelectMonth()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// open datepicker
		try {
			js.executeScript("arguments[0].click();", sl.getStartoffiscalyearfield());
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", sl.getStartoffiscalendaricon());
		}
		Thread.sleep(500);
		String before = sl.getStartoffiscalyearfield().getText();
		// determine a month different than current
		LocalDate today = LocalDate.now();
		String curMonth = today.getMonth().name();
		String pickMonth = curMonth.equalsIgnoreCase("JANUARY") ? "February" : "January";
		// select the different month
		By monthSelectBy = By.xpath("//select[contains(@class,'react-datepicker__month-select')]");
		Thread.sleep(3000);
		WebElement monthSelect = wait.until(ExpectedConditions.elementToBeClickable(monthSelectBy));
		Select monthSel = new Select(monthSelect);
		monthSel.selectByVisibleText(pickMonth);
		Thread.sleep(500);
		// click day 1 to apply
		By dayOne = By.xpath(
				"//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='1']");
		WebElement day1 = wait.until(ExpectedConditions.elementToBeClickable(dayOne));
		try {
			day1.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", day1);
		}
		Thread.sleep(500);
		String after = sl.getStartoffiscalyearfield().getText();
		System.out.println("Value after selecting different month (" + pickMonth + "): " + after);
		utilityclassobject.gettest().log(Status.INFO,
				"Value after selecting different month (" + pickMonth + "): " + after);
		if (!after.equals(before)) {
			System.out.println("PASS: User able to select a different month: " + pickMonth);
			utilityclassobject.gettest().log(Status.PASS, "User able to select a different month: " + pickMonth);
		} else {
			System.out.println("FAIL: User not able to select a different month");
			utilityclassobject.gettest().log(Status.FAIL, "User not able to select a different month");
		}
		// now select current month based on system date
		String currentMonthTitle = curMonth.substring(0, 1).toUpperCase() + curMonth.substring(1).toLowerCase();
		try {
			js.executeScript("arguments[0].click();", sl.getStartoffiscalyearfield());
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", sl.getStartoffiscalendaricon());
		}
		monthSelect = wait.until(ExpectedConditions.elementToBeClickable(monthSelectBy));
		monthSel = new Select(monthSelect);
		monthSel.selectByVisibleText(currentMonthTitle);
		Thread.sleep(500);
		String currentDay = String.valueOf(today.getDayOfMonth());
		By currDayBy = By.xpath(
				"//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='"
						+ currentDay + "']");
		WebElement currDayElem = wait.until(ExpectedConditions.elementToBeClickable(currDayBy));
		try {
			currDayElem.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", currDayElem);
		}
		Thread.sleep(500);
		String afterCurrent = sl.getStartoffiscalyearfield().getText();
		System.out.println("Value after selecting current month/day: " + afterCurrent);
		utilityclassobject.gettest().log(Status.INFO, "Value after selecting current month/day: " + afterCurrent);
	}

	@Test(dependsOnMethods = "TC_055VerifyUsercanAbletoSelectMonth")
	public void TC_056VerifyUsercanAbletoSelectYear()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// open datepicker
		try {
			js.executeScript("arguments[0].click();", sl.getStartoffiscalyearfield());
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", sl.getStartoffiscalendaricon());
		}
		Thread.sleep(500);
		LocalDate today = LocalDate.now();
		String curYear = String.valueOf(today.getYear());
		By yearSelectBy = By.xpath("//select[contains(@class,'react-datepicker__year-select')]");
		WebElement yearSelect = wait.until(ExpectedConditions.elementToBeClickable(yearSelectBy));
		Select yearSel = new Select(yearSelect);
		try {
			yearSel.selectByVisibleText(curYear);
		} catch (Exception e) {
			/* ignore */ }
		Thread.sleep(500);
		// pick current day to apply
		String currentDay = String.valueOf(today.getDayOfMonth());
		By currDayBy = By.xpath(
				"//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='"
						+ currentDay + "']");
		WebElement currDayElem = wait.until(ExpectedConditions.elementToBeClickable(currDayBy));
		try {
			currDayElem.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", currDayElem);
		}
		Thread.sleep(500);
		String after = sl.getStartoffiscalyearfield().getText();
		System.out.println("Value after selecting current year: " + after);
		utilityclassobject.gettest().log(Status.INFO, "Value after selecting current year: " + after);
		if (after.contains(curYear)) {
			System.out.println("PASS: Current year selected successfully: " + curYear);
			utilityclassobject.gettest().log(Status.PASS, "Current year selected successfully: " + curYear);
		} else {
			System.out.println("FAIL: Could not select current year: " + curYear);
			utilityclassobject.gettest().log(Status.FAIL, "Could not select current year: " + curYear);
		}
	}
}
