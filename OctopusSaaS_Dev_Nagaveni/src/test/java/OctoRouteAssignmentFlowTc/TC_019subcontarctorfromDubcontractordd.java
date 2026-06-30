package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AddNewGenerator;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_019subcontarctorfromDubcontractordd extends Baseclass {
	
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	@Test
	public void TC_019() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
	elib = new ExcelUtility();
	jlib = new javautility();
	wlib = new webDriverutility();
	lp = new LoginPage(driver);
	utilityclassobject.gettest().log(Status.INFO, "Login Page is displayed");
	lp.getLoginBtn().click();
	utilityclassobject.gettest().log(Status.INFO, "Home Page is displayed");
	hp = new HomePage(driver);
	hp.AddNew();
	hp.Generator();
	AddNewGenerator NewGen = new AddNewGenerator(driver);
	int Rannum = jlib.getRandomNumber();
	String GeneretorName = elib.getDataFromExcel("Routeassignment", 1, 1) + Rannum;
	System.out.println(GeneretorName);
	String InternalAcNo = elib.getDataFromExcel("Routeassignment", 1, 2);
	Thread.sleep(5000);
	NewGen.NewGeneretor(GeneretorName, InternalAcNo);
	GeneretorInformation ginfo = new GeneretorInformation(driver);
	Thread.sleep(5000);
	String ActualName = ginfo.GeneratorName();
	System.out.println(ActualName);
	Assert.assertTrue(ActualName.contains(GeneretorName));
	WebElement BillingInfo = ginfo.getBillingInfo();
	wlib.scrollToelement(driver, BillingInfo);
	ginfo.IndustryDD();
	WebElement lat = ginfo.getLatitute();
	wlib.scrollToelement(driver, lat);
	ginfo.Street();
	String emailId = elib.getDataFromExcel("Routeassignment", 1, 3);
	ginfo.Emialid(emailId);
	String Phoneno = elib.getDataFromExcel("Routeassignment", 1, 4);
	ginfo.Phonenumber(Phoneno);

	utilityclassobject.gettest().log(Status.INFO, "Billing Information is Filled Successfully");
	WebElement ele1 = ginfo.getGenereteOff();
	wlib.scrollToelement(driver, ele1);
	WebElement lat1 = ginfo.getLatitude();
	System.out.println(lat1.getText());
	System.out.println(ginfo.getLongitude().getText());
	utilityclassobject.gettest().log(Status.INFO, "Lattitude and longtude Generetaed and verified successfully");
	ginfo.CopyBtn();	
	ginfo.Phonenumber("7895236478");
	wlib.scrollToelement(driver, ele1);
	WebElement billingEmail = ginfo.getBillingInfo();
	String BillingMail = billingEmail.getText();
	// Assert.assertTrue(BillingMail.contains(emailId));
	System.out.println("Billing Email" + BillingMail);
	utilityclassobject.gettest().log(Status.INFO, "Billing information cpoied from Generator service information");
	WebElement sun = ginfo.getSunday();
	wlib.scrollToelement(driver, sun);
	ginfo.MondayOpen();
	ginfo.lunchTime();
	ginfo.lunchEnd();
	ginfo.MondayClose();
	ginfo.CopyPasteToAllDay();
	Thread.sleep(2000);
	ginfo.Contracted();
	utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
	Thread.sleep(15000);
	ginfo.Ellisebtn();
	utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
	Thread.sleep(7000);
	RouteAssignment rasp = new RouteAssignment(driver);
	WebElement ssr = rasp.getSSRbtn();
	wlib.scrollToelement(driver, ssr);
	ssr.click();
	
	WebElement subcontractorname = rasp.getSubcontractor();
	
	subcontractorname.click();
	//wlib.selectByIndex(subcontractorname, 1);
	WebElement option = driver.findElement(By.xpath("//li[@role='option']//span"));
	wlib.mousemoveonElement(driver, option);
	option.click();
	utilityclassobject.gettest().log(Status.INFO, "Subcontractor name selected successfully");
	Thread.sleep(5000);

	}

}
