package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.GeneratorManagentPage;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_091NextSixserviiceWithSelecteddays extends Baseclass{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;
	
	
	@Test
	public void TC_091Next6ServiceWithSelectesweekdays() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	{
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		hp.getGeneratoemanag().click();
		gmp = new GeneratorManagentPage(driver);
		String gname = elib.getDataFromExcel("Generator", 1, 1);
		gmp.CharlieAccounttwo(gname);
		ras = new RouteAssignment(driver);
		gip = new GeneretorInformation(driver);
		gip.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route assignment page is displayed successfully");
		Thread.sleep(15000);
		ras.AddService();
		Thread.sleep(5000);
    	utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
    	ras.Route1();
    	utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
    	ras.ServiceFrequency();
    	utilityclassobject.gettest().log(Status.INFO, "Service frequency selected successfully");
    	ras.SelectWeekDay();
    	ras.getClickoutside().click();;
    	utilityclassobject.gettest().log(Status.INFO, "week days selected successfully");
    	ras.getCalendar().click();
        LocalDate today = LocalDate.now();
        String day = String.valueOf(today.getDayOfMonth());
        driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
    	utilityclassobject.gettest().log(Status.INFO, "Current date selected successfully");
    	ras.ServiceType();
    	utilityclassobject.gettest().log(Status.INFO, "Service type selected successfully");
    	WebElement element = ras.getDefaultdisposalFacility();


    	if(element.isDisplayed()) {
    	    System.out.println("Default disposal facility Element is visible");
    	} else {
    	    System.out.println("Default disposal facility Element is not visible");
    	}
    	Assert.assertTrue(element.isDisplayed());
    	utilityclassobject.gettest().log(Status.INFO, "Default disposal facility displayed successfully");
    	ras.defaultdisposaldd();
    	utilityclassobject.gettest().log(Status.INFO, "Default disposal facility seleccted value successfully");
        ras.ServiceDuration();
    	utilityclassobject.gettest().log(Status.INFO, "Service duration selected successfully");
    	ras.ScopeOfWork();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
    	ras.getClickoutside().click();
    	//ras.getSowclick().click();
    	ras.IncreaseGalone();
    	ras.IncreaseGaltwo();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
    	ras.decreasesevGalBioone();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work decreased successfully");
    	ras.getRequitepiccheckbox().click();
    	utilityclassobject.gettest().log(Status.INFO, "Require picture check box checked  successfully");
    	//List<WebElement> schedules = driver.findElements( By.xpath("//div[contains(@class,'bg-gray-100 rounded-full')]"));
    	List<WebElement> scheduleservce = driver.findElements(By.xpath("//div[contains(@class,'bg-gray-100 rounded-full')]"));

    	System.out.println("Total schedules: " + scheduleservce.size());

    	if(scheduleservce.size() == 6) {
    	    System.out.println("All 6 schedules are displayed");
        	utilityclassobject.gettest().log(Status.INFO, "All 6 schedules are displayed");
    	} else {
    	    System.out.println("Schedules count mismatch");
    	}
    	
    	for(WebElement schedule : scheduleservce)
    	{
    	    String service = schedule.getText();

    	    boolean hasTime = service.matches(".*\\d{1,2}:\\d{2}.*");

    	    Assert.assertFalse(hasTime, "Office hours should not be displayed: " + service);
    	    System.out.println("Next service with office hours displayed successfully");
        	utilityclassobject.gettest().log(Status.INFO, "Next service with office hour displayed successfully");

    	}
    	
    	Set<String> uniqueDays = new LinkedHashSet<>();

    	List<WebElement> selectedDays = driver.findElements(
    	    By.xpath("//p[text()='Select Weekdays *']/following::div[contains(@class,'overflow-hidden')]//span[contains(@class,'bg-gray-200')]")
    	);

    	for (WebElement day2 : selectedDays) {

    	    if(day2.isDisplayed()) {   // important fix
    	        uniqueDays.add(day2.getText());
    	    }

    	    if (uniqueDays.size() == 4) {
    	        break;
    	    }
    	}

    	// Convert to list
    	List<String> selectedWeekList = new ArrayList<>(uniqueDays);

    	// Debug print
    	System.out.println(selectedWeekList);

    	// Print one by one
    	for (String day2 : uniqueDays) {
    	    System.out.println(day2);
        	utilityclassobject.gettest().log(Status.INFO, "All 6 days are displayed fron next 6 services ");

    	}
    	

    	List<WebElement> serviceWeeks = driver.findElements(
    		    By.xpath("(//p[contains(text(),',') and contains(text(),'2026')])[position()<=6]")
    		);

    		for (WebElement week : serviceWeeks) {
    		    String dayOnly = week.getText().split(",")[0];
    		    System.out.println(dayOnly);
    		}
    		
    		//List<String> selectedWeekList = new ArrayList<>(uniqueDays);
    		// Compare cyclically
    		for (int i = 0; i < serviceWeeks.size(); i++) {

    		    String serviceDay = serviceWeeks.get(i).getText().split(",")[0];

    		    // restart comparison after 4
    		    String expectedDay = selectedWeekList.get(i % selectedWeekList.size());

    		    if (expectedDay.contains(serviceDay) || serviceDay.contains(expectedDay.substring(0,3))) {

    		        System.out.println(serviceDay + " matches with " + expectedDay);

    		    } else {

    		        System.out.println(serviceDay + " NOT matching with " + expectedDay);

    		    }
    		}
    		
    
    	
		ras.getRemoveserviceschedule().click();
    	utilityclassobject.gettest().log(Status.INFO, "Successfully removed successfully ");


	}
}
