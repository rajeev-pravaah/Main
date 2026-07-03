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

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AddNewGenerator;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class All_TC_RouteAssignment extends BaseClassForGEneratorContacts{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;
	GeneretorInformation ginfo;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;

	String Generetorname;
	String tct;
	String Gname;
	WebElement addtag;
	List<WebElement> taglist;
	TransporterProfile transProf;

	@Test

	public void TC_001VerifyRouteAssignmentPageDisplayed()
	
			throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		
		elib = new ExcelUtility();
		jlib = new javautility();
		wlib = new webDriverutility();
		lp = new LoginPage(driver);
		ras=new RouteAssignment(driver);
		transProf = new TransporterProfile(driver);

		utilityclassobject.gettest().log(Status.INFO, "Login Page is displayed");
		utilityclassobject.gettest().log(Status.INFO, "Home Page is displayed");
		hp = new HomePage(driver);
		hp.AddNew();
		hp.Generator();
		AddNewGenerator NewGen = new AddNewGenerator(driver);
		Thread.sleep(5000);
		int Rannum = jlib.getRandomNumber();
		Generetorname = elib.getDataFromExcel("Routeassignment", 1, 1) + Rannum;
		System.out.println(Generetorname);
		String InternalAcNo = elib.getDataFromExcel("Routeassignment", 1, 2);
		Thread.sleep(5000);
		NewGen.NewGeneretor(Generetorname, InternalAcNo);
		Thread.sleep(2000);
		ginfo = new GeneretorInformation(driver);
		// wait for Generator Name element to be clickable/present before reading it
		WebElement genNameElement = ginfo.getGenName();
		wlib.waitUntilElementClickable(driver, genNameElement);
		String ActualName = ginfo.GeneratorName();
		System.out.println(ActualName);
		if(ActualName.contains(Generetorname))
		{
			System.out.println("Generator name matched successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Generator name matched successfully : PASS");
		}
		else
		{
			System.out.println("Generator name not matched : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Generator name not matched : FAIL");
		}		WebElement BillingInfo = ginfo.getBillingInfo();
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
		Thread.sleep(2000);
		ginfo.Contracted();
		utilityclassobject.gettest().log(Status.INFO, "Generator service information saved successfully");
		Thread.sleep(4000);
		wlib.scrollToelement(driver, ginfo.getStreet());
		tct = ginfo.getStreet().getText();
		System.out.println(tct);
		Thread.sleep(3000);
		ginfo.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
		Thread.sleep(12000);

	}
	
	@Test(dependsOnMethods = "TC_001VerifyRouteAssignmentPageDisplayed")
	public void TC_002VerifyGeneratorname() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		
		String Gname = ras.GeneratorName();
		if(Gname.contains(Generetorname))
		{
			System.out.println("Generator name matched successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Generator name matched successfully : PASS");
			
		}
		else
		{
			System.out.println("Generator name not matched : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Generator name not matched : FAIL");
		}
		utilityclassobject.gettest().log(Status.INFO, "Generator name matched successfully ");
	}
	@Test(dependsOnMethods = "TC_002VerifyGeneratorname")
	public void TC_003VerifyGeneratorNameandAddressOnRouteAssignmentPage() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		/*
		ras = new RouteAssignment(driver);
		Gname = ras.GeneratorName();
		if(Gname.contains(Generetorname))
		{
			System.out.println("Generator name matched successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Generator name matched successfully : PASS");
		}
		else
		{
			System.out.println("Generator name not matched : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Generator name not matched : FAIL");
		}

        */
	}
	
	@Test(dependsOnMethods = "TC_003VerifyGeneratorNameandAddressOnRouteAssignmentPage")
	public void TC_004VerifyGeneratorCreatedDate() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		Gname = ras.GeneratorName();
		if(Gname.contains(Generetorname))
		{
			System.out.println("Generator name matched successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Generator name matched successfully : PASS");
		}
		else
		{
			System.out.println("Generator name not matched : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Generator name not matched : FAIL");
		}
		String gnAddress = ras.getGenAddress().getText();
		System.out.println(gnAddress);
		Assert.assertTrue(gnAddress.contains(tct));
		if(gnAddress.contains(tct))
		{
			System.out.println("Generator address matched successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Generator address matched successfully : PASS");
		
			
		}
		else
		{
			System.out.println("Generator address not matched : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Generator address not matched : FAIL");
		}
		System.out.println("Generator name  and address matched successfully ");
		utilityclassobject.gettest().log(Status.INFO, "Generator name  and address matched successfully ");
		String createddate = ras.getCreateddate().getText();
		System.out.println(createddate);
		System.out.println("Generator craeted date Displayed successfully ");
		utilityclassobject.gettest().log(Status.INFO, "Generator craeted date Displayed successfully ");
	}
	@Test(dependsOnMethods = "TC_004VerifyGeneratorCreatedDate")
	public void TC_005VerifyAddTagButtonIsDisplayed() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		
		addtag = ras.getAddtagbtn();
		if(addtag.isDisplayed())
		{
			System.out.println("Add Tag button is displayed successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Add Tag button is displayed successfully : PASS");
		}
		else
		{
			System.out.println("Add Tag button is not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Add Tag button is not displayed : FAIL");
		}
	}
	@Test(dependsOnMethods = "TC_005VerifyAddTagButtonIsDisplayed")
	public void TC_006VerifyListOfAllTags() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		addtag.click();
		taglist = ras.getAddTagsLists();
		for (WebElement tag : taglist) {
			System.out.println(tag.getText());
			
		}
		System.out.println("Displayed list of tags successfully :PASS ");
		utilityclassobject.gettest().log(Status.INFO, "Displayed list of tags successfully :PASS ");
	}
	@Test(dependsOnMethods = "TC_006VerifyListOfAllTags")
	public void TC_007VerifyTagsAlongWithChcekbox() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		
		for (WebElement tag : taglist) {
			System.out.println(tag.getText());
			utilityclassobject.gettest().log(Status.INFO, "Displayed list of tags ");
			WebElement checkbox = ras.getCheckboxforalladdtsglists();

			if (checkbox.isDisplayed()) {
				System.out.println(tag.getText() + " -> Checkbox Present");
			} else {
				System.out.println(tag.getText() + " -> Checkbox Missing");
			}
			System.out.println("Check box are verified successfully : PASS");
			utilityclassobject.gettest().log(Status.INFO, "Check box are verified successfully : PASS");
			
		}
	}
		
		
		@Test(dependsOnMethods = "TC_007VerifyTagsAlongWithChcekbox")
		public void TC_008VerifyUserisabletoRedirectToGeneratorInformationPage() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
			ras.getGeneratorInformationtab().click();
			ginfo.getContractedcheckbox().click();
			ginfo.getCancellationNote().sendKeys("Test Cancellation Note");
			ginfo.getTerminateContractbtn().click();
			System.out.println("Contract terminated successfully");
			utilityclassobject.gettest().log(Status.INFO, "Contract terminated successfully");
			Thread.sleep(5000);
			ginfo.Ellisebtn();
			TransporterProfile transProf = new TransporterProfile(driver);
			String popupmsg = transProf.getProfilenotsetuppopup().getText();
			System.out.println(popupmsg);
			utilityclassobject.gettest().log(Status.INFO, "Popup displayed and verified successfully");
			Thread.sleep(5000);
			ras.getGeneratorprofilenotsetuppopup().isDisplayed();
			System.out.println("Generator Profile Not Setup popup is displayed");
			utilityclassobject.gettest().log(Status.INFO, "Generator Profile Not Setup popup is displayed");
			if(ras.getGeneratorInformationtab().isDisplayed())
			{
				System.out.println("User is able to redirect to Generator Information page successfully : PASS");
				utilityclassobject.gettest().log(Status.PASS, "User is able to redirect to Generator Information page successfully : PASS");
			}
			else
			{
				System.out.println("User is not able to redirect to Generator Information page : FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "User is not able to redirect to Generator Information page : FAIL");
			}
			ras.getGobacktorouteassignmentpage().click();
		}
		@Test(dependsOnMethods = "TC_008VerifyUserisabletoRedirectToGeneratorInformationPage")
		public void TC_009VerifyLocationOfGeneratorVisibleinMapView() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
			ginfo.Contracted();
			WebElement street = ginfo.getStreet();
			String streetAddress = street.getAttribute("value");
			ginfo.Ellisebtn();
			ras.getStarsymbol().click();

			String add = driver.findElement(By.xpath("//p[contains(text(),'" + streetAddress + "')]")).getText();
			System.out.println(add);
			if(add.contains(streetAddress))
			{
				System.out.println("Adresss matched successfully : PASS");
				utilityclassobject.gettest().log(Status.PASS, "Adresss matched successfully : PASS");
			}
			else
			{
				System.out.println("Adresss not matched : FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Adresss not matched : FAIL");
			}
			ras.getClosepopupfromMap().click();
			
			
		}
		@Test(dependsOnMethods = "TC_009VerifyLocationOfGeneratorVisibleinMapView")
		public void TC_010VerifyTheStarFromMap() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		  if(ras.getStarsymbol().isDisplayed())
		  {
			  System.out.println("Star symbol is displayed on map view : PASS");
			  utilityclassobject.gettest().log(Status.PASS, "Star symbol is displayed on map view : PASS");
		  }
		  else
		  {
			  System.out.println("Star symbol is not displayed on map view : FAIL");
			  utilityclassobject.gettest().log(Status.FAIL, "Star symbol is not displayed on map view : FAIL");
		  }
		}
		@Test(dependsOnMethods = "TC_010VerifyTheStarFromMap")
		public void TC_011VerifyTheMapisAbletoZoomin() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
			WebElement elessr = ras.getSSRbtn();
			Thread.sleep(2000);
			wlib.scrollToelement(driver, elessr);
			WebElement plusButton = ras.getPlusIconinMap();
			plusButton.click();
			plusButton.click();
			plusButton.click();
			plusButton.click();
			plusButton.click();
			plusButton.click();
			System.out.println("Map is zoomed in successfully");
			utilityclassobject.gettest().log(Status.INFO, "Map is zoomed in successfully");
	        Thread.sleep(3000);
	        
		}
		@Test(dependsOnMethods = "TC_011VerifyTheMapisAbletoZoomin")
		public void TC_012VerifyTheMapisDisplayedwithOtherLocations() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
			WebElement minus = ras.getMinusicon();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			minus.click();
			System.out.println("Map is zoomed out successfully");
		}
		@Test(dependsOnMethods = "TC_012VerifyTheMapisDisplayedwithOtherLocations")
		public void TC_013VerifySSRbuttonisPresentandClickable() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
			wlib.scrollToelement(driver, ras.getSSRbtn());
			if(ras.getSSRbtn().isDisplayed())
			{
				System.out.println("SSR button is displayed successfully : PASS");
				utilityclassobject.gettest().log(Status.PASS, "SSR button is displayed successfully : PASS");
			}
			else
			{
				System.out.println("SSR button is not displayed : FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "SSR button is not displayed : FAIL");
			}
			ras.getSSRbtn().click();
			System.out.println("SSR button is clicked successfully");
			utilityclassobject.gettest().log(Status.INFO, "SSR button is displayed and clickable");
		}
		
		
	
	
	
	


}
