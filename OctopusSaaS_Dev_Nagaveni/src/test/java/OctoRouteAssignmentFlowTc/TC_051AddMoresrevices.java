package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class TC_051AddMoresrevices extends Baseclass{

	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;
	
	
	@Test
	public void TC_051RemoveNewlyaddedService() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	{
		hp=new HomePage(driver);
		hp.getGeneratoemanag().click();
        gmp = new GeneratorManagentPage(driver);
       // String gname = elib.getDataFromExcel("Generator", 1, 0);
        gmp.CharlieAccount("Charlie_48955");
        ras=new RouteAssignment(driver);
         gip = new GeneretorInformation(driver);
         gip.Ellisebtn();
     	utilityclassobject.gettest().log(Status.INFO, "Route assignment page is displayed successfully");
     	Thread.sleep(7000);
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
    
    	utilityclassobject.gettest().log(Status.INFO, "Default disposal facility displayed successfully");
    	ras.defaultdisposaldd();
    	utilityclassobject.gettest().log(Status.INFO, "Default disposal facility seleccted value successfully");
        ras.ServiceDuration();
    	utilityclassobject.gettest().log(Status.INFO, "Service duration selected successfully");
    	ras.ScopeOfWork();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
    	ras.getClickoutside().click();
    	//ras.getSowclick().click();
    	ras.ScopeOfWork();
    	ras.IncreaseGalone();
    	ras.IncreaseGaltwo();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
    	ras.decreasesevGalBioone();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work decreased successfully");
    	ras.getRequitepiccheckbox().click();
    	utilityclassobject.gettest().log(Status.INFO, "Require picture check box checked  successfully");
    	ras.AddRoute();
    	utilityclassobject.gettest().log(Status.INFO, "Route added successfully");
    	Thread.sleep(15000);
    	ras.AddserviceSecondBtn();
    	utilityclassobject.gettest().log(Status.INFO, "One more add service displayed successfully");
    	Thread.sleep(3000);
    	ras.Route2();
    	ras.ServiceType2();
    	ras.Servicefreq2();
    	ras.selectweekday2();
    	ras.ScopeOfWork2();
    	ras.Anchordate2();
    	ras.disposalfacility2();
    	ras.AddRoute();
    	utilityclassobject.gettest().log(Status.INFO, "One more add service added successfully");
    	Thread.sleep(20000);
    	ras.getRemoveServiceschedule2().click();
    	//Thread.sleep(20000);
    	//ras.CancellationNOTe2();
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	        By.xpath("//dialog//textarea")));
    	textarea.sendKeys("Delete");

    	WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//button[normalize-space()='Remove Schedule']")));

    	removeButton.click();
/*
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	

    	WebElement textarea = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//textarea[contains(@class,'text-cardTextGray')]")));
    	textarea.sendKeys("Delete");

    	WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//button[normalize-space()='Remove Schedule']")));

    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", removeButton);
    	/*
    	WebElement removeBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove Schedule')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
    	//JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", removeBtn);
    	/*
    	driver.findElement(By.xpath("//textarea[contains(@class,'text-cardTextGray')]")).sendKeys("Delete");
    	driver.findElement(By.xpath("(//button[contains(text(),'Remove')])[4]")).click();
    	Thread.sleep(10000);
    	
    	ras.CancellationNOTe();
    	
    	utilityclassobject.gettest().log(Status.INFO, "Newly added service removed successfully");
    	ras.getRemoveServiceSchedule().click();
    	ras.CancellationNOTe();
    	utilityclassobject.gettest().log(Status.INFO, "old or first time added Service schedule deleted successfully");

*/
	}

}
