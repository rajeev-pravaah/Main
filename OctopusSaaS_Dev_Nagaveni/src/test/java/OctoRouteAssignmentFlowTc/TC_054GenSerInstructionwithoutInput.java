package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;

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

public class TC_054GenSerInstructionwithoutInput extends Baseclass{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;
	
	
	@Test
	public void TC_054GeneratorServiceInstructionsWithoutINput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
    	ras.AddRoute();
    	Thread.sleep(20000);
    	utilityclassobject.gettest().log(Status.INFO, "Add route clicked successfully");
    	WebElement establishedDate =ras.getEstablisdate();
    	Assert.assertTrue(establishedDate.isDisplayed(), "Established Date field is not displayed");
    			ras.RemoveServiceSchedule();
    			utilityclassobject.gettest().log(Status.INFO, "Service is removed succesfully");
    	ras.getHrCheckbox24().click();
    	ras.getSamedaycheckbox().click();
    	utilityclassobject.gettest().log(Status.INFO, "Both check box selected successfully");
    	WebElement element1 = ras.getGenratorServiceInstr();
    	Assert.assertTrue(element1.isDisplayed(), "Generator Service Instructions section is not visible");
    	utilityclassobject.gettest().log(Status.INFO, "User can proceed further if user leaves Generator service Instructions ");


}
}
