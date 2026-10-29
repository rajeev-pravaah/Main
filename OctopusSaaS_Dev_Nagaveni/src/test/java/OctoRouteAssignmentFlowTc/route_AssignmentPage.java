package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.io.IOException;
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
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.PriceBook;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class route_AssignmentPage extends Baseclass {

	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;

	String GeneretorName;

	@Test

	public void TC_001RouteAssignmentPage()
			throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");

	}

	@Test
	public void TC_002RouteassignmentwithoutContracted()
			throws EncryptedDocumentException, IOException, AWTException, InterruptedException {
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
		ginfo.Ellisebtn();
		TransporterProfile transProf = new TransporterProfile(driver);
		String popupmsg = transProf.getProfilenotsetuppopup().getText();
		System.out.println(popupmsg);
		Assert.assertTrue(popupmsg.contains("Generator Profile Not Setup"), "Popup message not matched");
		utilityclassobject.gettest().log(Status.INFO, "Popup displayed and verified successfully");
		Thread.sleep(5000);

	}

	@Test
	public void TC_003GeneratorNameOnRouteAssignmentPage()
			throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		String Gname = ras.GeneratorName();
		Assert.assertTrue(Gname.contains(GeneretorName));
		utilityclassobject.gettest().log(Status.INFO, "Generator name matched successfully ");

	}

	@Test
	public void TC_004GeneratorNamewithAddress()
			throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		String tct = ginfo.getStreet().getText();
		System.out.println(tct);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		String Gname = ras.GeneratorName();
		Assert.assertTrue(Gname.contains(GeneretorName));
		String gnAddress = ras.getGenAddress().getText();
		System.out.println(gnAddress);
		Assert.assertTrue(gnAddress.contains(tct));
		utilityclassobject.gettest().log(Status.INFO, "Generator name  and address matched successfully ");

	}

	@Test
	public void TC_005EgneratorCreateddate()
			throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		String tct = ginfo.getStreet().getText();
		System.out.println(tct);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		String Gname = ras.GeneratorName();
		Assert.assertTrue(Gname.contains(GeneretorName));
		String gnAddress = ras.getGenAddress().getText();
		System.out.println(gnAddress);
		Assert.assertTrue(gnAddress.contains(tct));
		utilityclassobject.gettest().log(Status.INFO, "Generator name  and address matched successfully ");
		String createddate = ras.getCreateddate().getText();
		System.out.println(createddate);
		utilityclassobject.gettest().log(Status.INFO, "Generator craeted date verified successfully ");

	}

	@Test
	public void TC_006AddTagbtn() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		String tct = ginfo.getStreet().getText();
		System.out.println(tct);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		String Gname = ras.GeneratorName();
		Assert.assertTrue(Gname.contains(GeneretorName));
		String gnAddress = ras.getGenAddress().getText();
		System.out.println(gnAddress);
		Assert.assertTrue(gnAddress.contains(tct));
		utilityclassobject.gettest().log(Status.INFO, "Generator name  and address matched successfully ");
		String createddate = ras.getCreateddate().getText();
		System.out.println(createddate);
		utilityclassobject.gettest().log(Status.INFO, "Generator craeted date verified successfully ");
		WebElement ele = ras.getAddtagbtn();
		Assert.assertTrue(ele.isDisplayed(), "Element is visible");
	}

	@Test
	public void TC_007TagnamelistofElements()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		String tct = ginfo.getStreet().getText();
		System.out.println(tct);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		String Gname = ras.GeneratorName();
		Assert.assertTrue(Gname.contains(GeneretorName));
		String gnAddress = ras.getGenAddress().getText();
		System.out.println(gnAddress);
		Assert.assertTrue(gnAddress.contains(tct));
		utilityclassobject.gettest().log(Status.INFO, "Generator name  and address matched successfully ");
		String createddate = ras.getCreateddate().getText();
		System.out.println(createddate);
		utilityclassobject.gettest().log(Status.INFO, "Generator craeted date verified successfully ");
		WebElement ele = ras.getAddtagbtn();
		Assert.assertTrue(ele.isDisplayed(), "Element is visible");
		ele.click();
		List<WebElement> taglist = driver.findElements(By.xpath("//div[@id='tag-options-list']//label"));
		for (WebElement tag : taglist) {
			System.out.println(tag.getText());
			utilityclassobject.gettest().log(Status.INFO, "Displayed list of tags ");
		}

	}

	@Test
	public void TC_008AddtagswithListOfelementswithCheckbox()
			throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		String tct = ginfo.getStreet().getText();
		System.out.println(tct);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		String Gname = ras.GeneratorName();
		Assert.assertTrue(Gname.contains(GeneretorName));
		String gnAddress = ras.getGenAddress().getText();
		System.out.println(gnAddress);
		Assert.assertTrue(gnAddress.contains(tct));
		utilityclassobject.gettest().log(Status.INFO, "Generator name  and address matched successfully ");
		String createddate = ras.getCreateddate().getText();
		System.out.println(createddate);
		utilityclassobject.gettest().log(Status.INFO, "Generator craeted date verified successfully ");
		WebElement ele = ras.getAddtagbtn();
		Assert.assertTrue(ele.isDisplayed(), "Element is visible");
		ele.click();
		List<WebElement> taglist = driver.findElements(By.xpath("//div[@id='tag-options-list']//label"));
		for (WebElement tag : taglist) {
			System.out.println(tag.getText());
			utilityclassobject.gettest().log(Status.INFO, "Displayed list of tags ");
			WebElement checkbox = tag.findElement(By.xpath(".//input[@type='checkbox']"));

			if (checkbox.isDisplayed()) {
				System.out.println(tag.getText() + " -> Checkbox Present");
			} else {
				System.out.println(tag.getText() + " -> Checkbox Missing");
			}
			utilityclassobject.gettest().log(Status.INFO, "Check box are verified successfully ");
		}

	}

	@Test
	public void TC_009BackToRouteassignment()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
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
		ginfo.Ellisebtn();
		TransporterProfile transProf = new TransporterProfile(driver);
		String popupmsg = transProf.getProfilenotsetuppopup().getText();
		System.out.println(popupmsg);
		Assert.assertTrue(popupmsg.contains("Generator Profile Not Setup"), "Popup message not matched");
		utilityclassobject.gettest().log(Status.INFO, "Popup displayed and verified successfully");
		Thread.sleep(5000);
		ras.getGobacktorouteAssignmentpageBtn().click();
		utilityclassobject.gettest().log(Status.INFO, "Route assignment page is displayed successfully");

	}

	@Test
	public void TC_010MapviewAddress()
			throws EncryptedDocumentException, IOException, InterruptedException, AWTException {

		elib = new ExcelUtility();
		jlib = new javautility();
		wlib = new webDriverutility();
		lp = new LoginPage(driver);
		utilityclassobject.gettest().log(Status.INFO, "Login Page is displayed");
		lp.getLoginBtn().click();
		utilityclassobject.gettest().log(Status.INFO, "Home Page is d1545isplayed");
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
		wlib.scrollToelement(driver, ele1);
		WebElement billingEmail = ginfo.getBillingInfo();
		String BillingMail = billingEmail.getText();
		// Assert.assertTrue(BillingMail.contains(emailId));
		System.out.println("Billing Email" + BillingMail);
		utilityclassobject.gettest().log(Status.INFO, "Billing information cpoied from Generator service information");
		WebElement street = ginfo.getStreet();
		String streetAddress = street.getAttribute("value");

		System.out.println("Street Address: " + streetAddress);

		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		String tct = ginfo.getStreet().getText();
		System.out.println(tct);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		ras.getStarsymbol().click();

		String add = driver.findElement(By.xpath("//p[contains(text(),'" + streetAddress + "')]")).getText();
		System.out.println(add);
		Assert.assertTrue(add.contains(streetAddress));
		utilityclassobject.gettest().log(Status.INFO, "Adresss matched successfully");

	}

	@Test
	public void TC_011MapviewGeneratorName()
			throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
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
		String ActualName = ginfo.GeneratorName();
		System.out.println(ActualName);
		Assert.assertTrue(ActualName.contains(GeneretorName));
		WebElement BillingInfo = ginfo.getBillingInfo();

		wlib.scrollToelement(driver, BillingInfo);
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
		wlib.scrollToelement(driver, ele1);
		WebElement billingEmail = ginfo.getBillingInfo();
		String BillingMail = billingEmail.getText();
		// Assert.assertTrue(BillingMail.contains(emailId));
		System.out.println("Bil"
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ "ling Email" + BillingMail);
		utilityclassobject.gettest().log(Status.INFO, "Billing information cpoied from Generator service information");
		WebElement street = ginfo.getStreet();
		String streetAddress = street.getAttribute("value");
		System.out.println("Street Address: " + streetAddress);
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		String tct = ginfo.getStreet().getText();
		System.out.println(tct);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		ras.getStarsymbol().click();
		String add = driver.findElement(By.xpath("//p[contains(text(),'" + streetAddress + "')]")).getText();
		System.out.println(add);
		Assert.assertTrue(add.contains(streetAddress));
		utilityclassobject.gettest().log(Status.INFO, "Adresss matched successfully");
		String Gname = ras.getMapGenName().getText();
		System.out.println(Gname);
		Assert.assertTrue(Gname.contains(GeneretorName));
		utilityclassobject.gettest().log(Status.INFO, "Generator name in map view is verified successfully");

	}

	@Test
	public void TC_012() throws InterruptedException, EncryptedDocumentException, IOException, AWTException {

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
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(2000);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		ras = new RouteAssignment(driver);
		WebElement elessr = ras.getSSRbtn();
		Thread.sleep(2000);
		wlib.scrollToelement(driver, elessr);
		WebElement plusButton = ras.getPlusIconinMap();
		plusButton.click();
		plusButton.click();
		plusButton.click();

	
		
		
	}

}
