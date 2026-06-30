package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

public class TC_093ServioceSchedukeWithoutOperatingHour extends Baseclass{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;
	GeneretorInformation ginfo;
	
	
	@Test
	public void TC_093ServiceSchedulewithoutOperatingHours() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	{
		hp=new HomePage(driver);
		elib=new ExcelUtility();
		hp.getGeneratoemanag().click();
        gmp = new GeneratorManagentPage(driver);
    	String gname = elib.getDataFromExcel("Generator", 1, 1);
		gmp.CharlieAccounttwo(gname);
        ras=new RouteAssignment(driver);
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
    	Thread.sleep(5000);
    	ras.ScopeOfWork();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
        Thread.sleep(2000);
        ras.IncreaseGalone();
    	ras.IncreaseGaltwo();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
    	ras.AddRoute();
    	utilityclassobject.gettest().log(Status.INFO, "Service is added to route successfully");
    	Thread.sleep(15000);
    	ras.MoveTogeneratorInfo();
    	utilityclassobject.gettest().log(Status.INFO, "Generator information page displayed successfully");
    	ras.MoveTosundsay();
    
    	
    	By cancelBtn = By.xpath("//button[contains(@class,'absolute') and contains(@class,'right-8')]");

    	List<WebElement> cancelButtons = driver.findElements(cancelBtn);
    	System.out.println("Total cancel buttons: " + cancelButtons.size());

    	int i = 1;

    	while(driver.findElements(cancelBtn).size() > 0) {

    	    driver.findElements(cancelBtn).get(0).click();

    	    utilityclassobject.gettest().log(Status.INFO,
    	            "Cancel button " + i + " clicked successfully");

    	    i++;
    	}
		    utilityclassobject.gettest().log(Status.INFO, "All the assignmed office hours romived successfully");
    		ginfo = new GeneretorInformation(driver);
    		ginfo.Ellisebtn();
    		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
    		driver.navigate().refresh();
    		utilityclassobject.gettest().log(Status.INFO, "Page refreshed ");
    		ras.CopyToclipBoard();
    		List<WebElement> naValues = driver.findElements(
    			    By.xpath("//div[@class='flex items-center gap-2 shrink-0 w-40']/../descendant::p[contains(text(),'N/A')]")
    			);

    		System.out.println("Total N/A values: " + naValues.size());

    		for (int j = 0; j < naValues.size(); j++) {
    		    String value = naValues.get(j).getText();
    		    System.out.println("Value " + (j + 1) + ": " + value);
    		}
        		utilityclassobject.gettest().log(Status.INFO, "Successfully fetched all th 10 operating hours as we mention as N/A");
 
        		ras.RemoveServiceSchedule();
        		//ras.getRemoveserviceschedule();
            	utilityclassobject.gettest().log(Status.INFO, "Successfully removed successfully ");
        		ras.MoveTogeneratorInfo();
            	utilityclassobject.gettest().log(Status.INFO, "Generator information page displayed successfully");
            	ras.MoveTosundsay();
            	ginfo.MondayOpen();
        		ginfo.lunchTime();
        		ginfo.lunchEnd();
        		ginfo.MondayClose();
        		ginfo.CopyPasteToAllDay();
            	utilityclassobject.gettest().log(Status.INFO, "offioce hour again  added ");


	}
}
