package Assert_Satellite_Location;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;
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
import org.testng.annotations.BeforeMethod;
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
        sl.getGeneralphonetext().click();
		if (sl == null) {
			sl = new SatelliteLocation(driver);
		}
		try {
			sl.getStartoffiscalyearfield().click();
		} catch (Exception e) {
			System.out.println("Start of Fiscal Year field is not clickable");
			utilityclassobject.gettest().log(Status.INFO, "Start of Fiscal Year field is not clickable");
		}
        sl.getStartoffiscalendaricon().click();
		LocalDate today = LocalDate.now();
		String currentDay = String.valueOf(today.getDayOfMonth());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + currentDay + "']")));

		date.click();
		System.out.println("Selected current date: " + today);
		utilityclassobject.gettest().log(Status.INFO, "Selected current date: " + today);
		sl.getGeneralphonetext().click();

	}

	@Test(dependsOnMethods = "TC_054VerifyStartofFiscalYearTextfieldAcceptDate")

	public void TC_055VerifyUsercanAbletoSelectYear()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {

		// Open calendar – safeClick twice to handle stubborn span
		wlib.safeClick(driver, sl.getStartoffiscalyearfield());
		Thread.sleep(500);
		wlib.safeClick(driver, sl.getStartoffiscalyearfield());
		Thread.sleep(800);

		// Click the year dropdown in the datepicker header
		sl.getExportyeardropdown().click();
		System.out.println("Clicked on year dropdown");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on year dropdown");
		Thread.sleep(500);

		// Select year 2019 using Select class
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sl.getExportyeardropdown()));
		Select yearSelect = new Select(sl.getExportyeardropdown());
		//fetch the current year from the system
		int currentYear = Year.now().getValue();
		System.out.println("Current Year: " + currentYear);
		
		
		yearSelect.selectByVisibleText(String.valueOf(currentYear));
		System.out.println("TC_055 PASS: Selected year 2019 from the year dropdown");
		utilityclassobject.gettest().log(Status.PASS, "Selected year 2019 from the year dropdown");

		// Confirm selected value
		String selectedYear = yearSelect.getFirstSelectedOption().getText();
		System.out.println("Confirmed selected year: " + selectedYear);
		utilityclassobject.gettest().log(Status.INFO, "Confirmed selected year: " + selectedYear);
		System.out.println("TC_055 PASS: User can select year from the year dropdown");
		utilityclassobject.gettest().log(Status.PASS, "User can select year from the year dropdown");
	}

	@Test(dependsOnMethods = "TC_055VerifyUsercanAbletoSelectYear")
	
	public void TC_056VerifyUsercanAbletoSelectMonth()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {

		// Click the month dropdown in the datepicker header
		sl.getExportyearmonthdropdown().click();
		System.out.println("Clicked on month dropdown");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on month dropdown");
		Thread.sleep(500);

		// Select September using Select class
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sl.getExportyearmonthdropdown()));
		Select monthSelect = new Select(sl.getExportyearmonthdropdown());
		monthSelect.selectByVisibleText("September");
		System.out.println("TC_056 PASS: Selected month September from the month dropdown");
		utilityclassobject.gettest().log(Status.PASS, "Selected month September from the month dropdown");

		// Confirm selected value
		String selectedMonth = monthSelect.getFirstSelectedOption().getText();
		System.out.println("Confirmed selected month: " + selectedMonth);
		utilityclassobject.gettest().log(Status.INFO, "Confirmed selected month: " + selectedMonth);

		// Click month dropdown again and select current month from system
		sl.getExportyearmonthdropdown().click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(sl.getExportyearmonthdropdown()));
		String currentMonth = LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println("Current Month from system: " + currentMonth);
		Select monthSelectAgain = new Select(sl.getExportyearmonthdropdown());
		monthSelectAgain.selectByVisibleText(currentMonth);
		System.out.println("TC_056 PASS: Re-selected current month " + currentMonth + " from the month dropdown");
		utilityclassobject.gettest().log(Status.PASS, "Re-selected current month " + currentMonth + " from the month dropdown");

		// Confirm final selected value
		String finalMonth = monthSelectAgain.getFirstSelectedOption().getText();
		System.out.println("Final confirmed selected month: " + finalMonth);
		utilityclassobject.gettest().log(Status.INFO, "Final confirmed selected month: " + finalMonth);
		System.out.println("TC_056 PASS: User can select month from the month dropdown");
		utilityclassobject.gettest().log(Status.PASS, "User can select month from the month dropdown");
		sl.getGeneralphonetext().click();

	}
}
