package OctoRouteAssignmentFlowTc;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class TC_055DeliveryNoteWithValidData extends Baseclass{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;
	
	
	@Test
	public void TC_055DeliveryNotewithValidData () throws InterruptedException, EncryptedDocumentException, IOException
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
     	Thread.sleep(7000);
    	ras.getHrCheckbox24().click();
    	ras.getSamedaycheckbox().click();
    	utilityclassobject.gettest().log(Status.INFO, "Both check box selected successfully");
    	WebElement element1 = ras.getGenratorServiceInstr();
    	Assert.assertTrue(element1.isDisplayed(), "Generator Service Instructions section is not visible");
    	utilityclassobject.gettest().log(Status.INFO, "User can proceed further if user leaves Generator service Instructions ");
    	elib= new ExcelUtility();
    	String note = elib.getDataFromExcel("Routeassignment",4,1);
        ras.DeliveryNOte(note);
    	utilityclassobject.gettest().log(Status.INFO, "Delivery note text field successfully accepted valid input");


}
}
