package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
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

public class TC_015SubContractorWithValidName extends Baseclass{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;

	@Test
	public void TC_015SubcontractorWithValidInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,
			HeadlessException, UnsupportedFlavorException {
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib=new webDriverutility();
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
		ras.getClickoutside().click();
		
		utilityclassobject.gettest().log(Status.INFO, "week days selected successfully");
		wlib.scrollToelement(driver, ras.getCalendar());
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
		wlib.scrollToelement(driver, ras.getDefaultdisposalDD());
		ras.defaultdisposaldd();
		utilityclassobject.gettest().log(Status.INFO, "Default disposal facility seleccted value successfully");
		ras.ServiceDuration();
		utilityclassobject.gettest().log(Status.INFO, "Service duration selected successfully");
		Thread.sleep(5000);
		wlib.scrollToelement(driver, ras.getReqout());
		Thread.sleep(2000);
		ras.ScopeOfWork();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
		Thread.sleep(2000);
		ras.IncreaseGalone();
		ras.IncreaseGaltwo();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
		ras.AddRoute();
		
		utilityclassobject.gettest().log(Status.INFO, "Service is added to route successfully");
		String serviceType = ras.getServicetxt().getText();
		System.out.println(serviceType);
		Thread.sleep(15000);
		wlib.scrollToelement(driver, ras.getSubcontractiorserviceRequest());
		ras.getSubcontractiorserviceRequest().click();
		utilityclassobject.gettest().log(Status.INFO, "Sub contractor ");

		ras.SubcontractorDropdown();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on subcontractor dropdown until T-3,and T-7 viibile");
		wlib.scrollToelement(driver, ras.getSendtosubcontractor());
		ras.getT_3Subcontractor().click();
		//ras.ServiceFrequency();
		ras.Servicefreq2();
		utilityclassobject.gettest().log(Status.INFO, "Service Frequency selected successfully");
		ras.selectweekday2();
		utilityclassobject.gettest().log(Status.INFO, "Week days selected successfully");

		ras.RequestStartDate();
		utilityclassobject.gettest().log(Status.INFO, "Request start date added successfully");
		ras.ServiceTypeInSSR();
		utilityclassobject.gettest().log(Status.INFO, "Service Type added successfully");
		ras.ServiceDurationInSSR();
		utilityclassobject.gettest().log(Status.INFO, "Service Duration 15 minute added successfully");
		ras.ScopeOfWork();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work  added successfully");
		//wlib.scrollToelement(driver, ras.getSendtosubcontractor());
		
		//click on that cancel 
		ras.getCancelbuttoninSSRbesideSendtosubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
		Thread.sleep(8000);

	}

}
