
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

public class TC_038Service_Type extends Baseclass {
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;

	@Test
	public void TC_038() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		hp.getGeneratoemanag().click();
		GeneratorManagentPage gmp = new GeneratorManagentPage(driver);
		String gname = elib.getDataFromExcel("Generator", 1, 1);
		gmp.CharlieAccounttwo(gname);
		ras = new RouteAssignment(driver);
		GeneretorInformation gip = new GeneretorInformation(driver);
		gip.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		Thread.sleep(7000);
		ras = new RouteAssignment(driver);
		ras.AddService();
		Thread.sleep(5000);
		utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
		ras.Route1();
		utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
		ras.ServiceFrequency();
		utilityclassobject.gettest().log(Status.INFO, "Service frequency selected successfully");
		ras.SelectWeekDay();
		ras.getClickoutside().click();
		
		utilityclassobject.gettest().log(Status.INFO, "week days selected successfully");
		ras.getCalendar().click();
		LocalDate today = LocalDate.now();
		String day = String.valueOf(today.getDayOfMonth());
		driver.findElement(By.xpath("//*[text()='" + day + "']")).click();
		utilityclassobject.gettest().log(Status.INFO, "Current date selected successfully");
		ras.ServiceType();
		utilityclassobject.gettest().log(Status.INFO, "Service type selected successfully");
		ras.getRemoveserviceschedule().click();
	}
}
