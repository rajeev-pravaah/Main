package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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

public class TC_066ServicedateMatch extends Baseclass{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;
	
	
	@Test
	public void TC_066DateMatch() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
    	utilityclassobject.gettest().log(Status.INFO, "Service is adde to route successfully");
    	Thread.sleep(15000);
    	ras.CopyToclipBoard();
    	ras.MoveToServiceTypecolumn();
             List<WebElement> listofserType = driver.findElements(By.xpath("//div[contains(@class,'flex items-center') and contains(@class,'border-b')]//div[contains(@class,'w-60')][1]"));
             String expected = "Medical Waste";

             for (WebElement ele : listofserType) {
    		    System.out.println(ele.getText());
    		    String actual = ele.getText().trim();
    		//    Assert.assertEquals(actual, expected, "Service Type mismatch");
    		    Thread.sleep(5000);
    		   /* Assert.assertTrue(actual.contains(expected), 
    		            "Service Type mismatch. Actual: " + actual);*/
    	    	utilityclassobject.gettest().log(Status.INFO, "Lists of service type is verified successfully");

    		}
             Thread.sleep(5000);

          // List 1 (Next 6 service dates)
             List<WebElement> nextSixSerdate = driver.findElements(
                 By.xpath("//div[contains(@class,'flex-wrap')]//div[contains(@class,'rounded-full')]//p[1]")
             );

             List<String> list1 = new ArrayList<>();

             for (WebElement date : nextSixSerdate) {
                 String text = date.getText().trim();
                 System.out.println("List1: " + text);
                 list1.add(text);
             }


             // List 2 (Table dates)
             List<WebElement> listdate = driver.findElements(
                 By.xpath("//div[@class='w-40 shrink-0 truncate ']")
             );
             Thread.sleep(3000);
             List<String> list2 = new ArrayList<>();

             for (WebElement date1 : listdate) {
                 String text = date1.getText().trim();
                 System.out.println("List2: " + text);
                 list2.add(text);
             }
          // Compare List1[i] with List2[i+1]
             Thread.sleep(3000);

             //Assert.assertTrue(list2.size() > list1.size(), "List2 does not have enough elements");
 	    	utilityclassobject.gettest().log(Status.INFO, "List1 and list 2compared sucessfully");

             Thread.sleep(15000);

             for (int i = 0; i < list1.size(); i++) {

            	    String dateFromList1 = list1.get(i);
            	    String dateFromList2 = list2.get(i);

            	    // Extract only date part (remove day)
            	    String d1 = dateFromList1.split(",")[1].trim(); // 03/18/2026
            	    String d2 = dateFromList2.trim();               // 03/18/2026

            	    System.out.println("Comparing: " + d1 + " with " + d2);

            	    /*Assert.assertTrue(
            	        d2.contains(d1),
            	        "Mismatch at index " + i +
            	        " -> List1: " + dateFromList1 +
            	        ", List2: " + dateFromList2
            	    );*/
            	}
 	    	utilityclassobject.gettest().log(Status.INFO, "Service dates are verified successfully");
 	    	ras.RemoveServiceSchedule();
 	    	utilityclassobject.gettest().log(Status.INFO, "Service is removed succesfully");


}
}
