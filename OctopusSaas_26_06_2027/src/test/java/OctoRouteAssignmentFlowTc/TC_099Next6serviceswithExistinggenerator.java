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

public class TC_099Next6serviceswithExistinggenerator extends Baseclass{
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
	public void TC_099Next6serviceswithExistingGenerator() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
     	ras.MoveTogeneratorInfo();
    	utilityclassobject.gettest().log(Status.INFO, "Generator information page displayed successfully");
    	ras.MoveTosundsay();
    
    	

    	List<WebElement> closeCheckboxes = driver.findElements(
    	        By.xpath("//div[@role='checkbox']")
    	);

    	System.out.println("Total close checkboxes: " + closeCheckboxes.size());

    	// Click only first 3 days
    	for (int i = 0; i < 3 && i < closeCheckboxes.size(); i++) {

    	    WebElement checkbox = closeCheckboxes.get(i);

    	    if (checkbox.isDisplayed()) {
    	        checkbox.click();

    	        utilityclassobject.gettest().log(
    	                Status.INFO,
    	                "Closed checkbox clicked for day " + (i + 1)
    	        );
    	    }
    	}
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
		driver.navigate().refresh();
		utilityclassobject.gettest().log(Status.INFO, "Page refreshed ");
		List<WebElement> closedDates = driver.findElements(
			    By.xpath("//div[contains(@class,'items-center bg-gray-100')]")
			);

			for (WebElement closed : closedDates) {

			    String date = closed.findElement(By.xpath(".//p[1]")).getText();
			    String status = closed.findElement(By.xpath(".//p[2]")).getText();

			    System.out.println(date + " - " + status);
	    		utilityclassobject.gettest().log(Status.INFO, "Next 6 services are displayed as closed ");

			}
			ras.RemoveServiceSchedule();
        	utilityclassobject.gettest().log(Status.INFO, "Service removed successfully ");
        	ras.MoveTogeneratorInfo();
        	utilityclassobject.gettest().log(Status.INFO, "Generator information page displayed successfully");
        	ras.MoveTosundsay();

        	driver.findElement(By.xpath("(//div[@role='checkbox'])[2]")).click();
        	driver.findElement(By.xpath("(//div[@role='checkbox'])[3]")).click();
            utilityclassobject.gettest().log(Status.INFO, "office hour removed from closed to new office hours ");
            driver.findElement(By.xpath("(//span[@class='w-1/4 flex items-center justify-center'])[5]")).click();
            driver.findElement(By.xpath("(//span[@class='w-1/4 flex items-center justify-center'])[4]")).click();
            driver.findElement(By.xpath("(//span[@class='w-1/4 flex items-center justify-center'])[2]")).click();
        	utilityclassobject.gettest().log(Status.INFO, "office hour again  added ");
        	
                	


	}
}
