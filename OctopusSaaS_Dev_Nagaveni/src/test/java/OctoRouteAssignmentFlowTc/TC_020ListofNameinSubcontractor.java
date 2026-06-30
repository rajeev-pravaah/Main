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
import com.Octopussaas.ObjectRepository.AddNewGenerator;
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

public class TC_020ListofNameinSubcontractor extends Baseclass {

	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	@Test
	public void TC_020ListofNameInSubcontractor() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib=new webDriverutility();
		hp.getGeneratoemanag().click();
		GeneratorManagentPage gmp = new GeneratorManagentPage(driver);
		String gname = elib.getDataFromExcel("Generator", 1, 1);
		gmp.CharlieAccounttwo(gname);
		ras = new RouteAssignment(driver);
		GeneretorInformation gip = new GeneretorInformation(driver);
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
		ras.getClickoutside().click();
		;
		utilityclassobject.gettest().log(Status.INFO, "week days selected successfully");
		ras.getCalendar().click();
		LocalDate today = LocalDate.now();
		String day = String.valueOf(today.getDayOfMonth());
		driver.findElement(By.xpath("//*[text()='" + day + "']")).click();
		utilityclassobject.gettest().log(Status.INFO, "Current date selected successfully");
		ras.ServiceType();
		utilityclassobject.gettest().log(Status.INFO, "Service type selected successfully");
		WebElement element = ras.getDefaultdisposalFacility();
		if (element.isDisplayed()) {
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
		String serviceType = driver
				.findElement(By.xpath("//span[contains(@class,'truncate') and text()='Medical Waste']")).getText();
		System.out.println(serviceType);
		Thread.sleep(15000);
		ras.getSubcontractiorserviceRequest().click();
		utilityclassobject.gettest().log(Status.INFO, "Sub contractor ");

		ras.SubcontractorDropdown();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on subcontractor dropdown until T-3,and T-7 viibile");
	
	List<WebElement> list = driver.findElements(By.xpath("//li[@role='option']//span"));

	for(WebElement option1 : list)
	{
	    System.out.println(option1.getText());
	}
	utilityclassobject.gettest().log(Status.INFO, "Subcontractor name displayed successfully");
    ras.getCanclebtninsubcontractor().click();
	utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");

    ras.RemoveServiceSchedule();
	utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
	}



}
