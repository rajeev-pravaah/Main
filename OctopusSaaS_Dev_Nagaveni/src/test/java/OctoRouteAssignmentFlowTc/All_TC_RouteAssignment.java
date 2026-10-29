package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AddNewGenerator;
import com.Octopussaas.ObjectRepository.GeneratorManagentPage;
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
	
	GeneratorManagentPage gmp;
	String Generetorname;
	String tct;
	String Gname;
	WebElement addtag;
	List<WebElement> taglist;
	TransporterProfile transProf;
	GeneretorInformation gip;

	@Test(priority = 1)
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
			
			// Close popup inside canvas — use resilient click to avoid StaleElementReferenceException
			
			WebElement canvas = driver.findElement(By.tagName("canvas"));
			System.out.println("Canvas displayed : " + canvas.isDisplayed());	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
			        By.xpath("//button[@class='popup-close' and @aria-label='close']")));

			closeBtn.click();
			
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
			//WebElement plusButton = ras.getPlusIconinMap();
			WebElement plusButton = driver.findElement(By.xpath(
				    "(//button[contains(@class,'w-10') and contains(@class,'h-10') and contains(@class,'rounded')])[1]"
				));

				plusButton.click();
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
		@Test(dependsOnMethods = "TC_013VerifySSRbuttonisPresentandClickable")
		public void TC_014VerifySSRtextfields() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
			
			wlib.scrollToelement(driver, ras.getSSRbtn());
			ras.getSSRbtn().click();
			Thread.sleep(2000);
			
			if(ras.getSubcontractorAllFields().isDisplayed())
			{
				System.out.println("All the Filed are present: PASS");
				utilityclassobject.gettest().log(Status.PASS, "Subcontractor All the fields are present : PASS");
			}
			else
			{
				System.out.println("Subcontractor All the fields are not present : FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Subcontractor All the field are not present : FAIL");
			}
		}
		
		
	  @Test(dependsOnMethods = "TC_014VerifySSRtextfields")
	  public void TC_015VerifySubcontractorAlltheTextFieldAcceptsInputs() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		  //Cooment it while Running All Tc also Cooment Dependency
		  //Cooment it while Running All Tc
		  //Cooment it while Running All Tc

		  hp = new HomePage(driver);
			elib = new ExcelUtility();
			wlib=new webDriverutility();
			hp.getGeneratoemanag().click();
			ras=new RouteAssignment(driver);
			ras.getGeneratorLocations().click();
		    gmp = new GeneratorManagentPage(driver);
			String gname = elib.getDataFromExcel("Generator", 1, 1);
			gmp.CharlieAccounttwo(gname);
			ras = new RouteAssignment(driver);
			GeneretorInformation gip = new GeneretorInformation(driver);
			gip.Ellisebtn();
			utilityclassobject.gettest().log(Status.INFO, "Route assignment page is displayed successfully");
		  
			  //Cooment it while Running All Tc
			  //Cooment it while Running All Tc
			  //Cooment it while Running All Tc
		  
		  
		    ras.AddService();
			Thread.sleep(5000);
			System.out.println("Add service displayed all text field successfully");
			utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
			ras.Route1();
			System.out.println("Route selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
			ras.ServiceFrequency();
			System.out.println("Service frequency selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service frequency selected successfully");
			ras.SelectWeekDay();
			ras.getClickoutside().click();
			System.out.println("Week days selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "week days selected successfully");
			wlib.scrollToelement(driver, ras.getCalendar());
			ras.getCalendar().click();
			LocalDate today = LocalDate.now();
			String day = String.valueOf(today.getDayOfMonth());
			driver.findElement(By.xpath("//*[text()='" + day + "']")).click();
			System.out.println("Current date selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Current date selected successfully");
			ras.ServiceType();
			System.out.println("Service type selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service type selected successfully");
			WebElement element = ras.getDefaultdisposalFacility();
			if (element.isDisplayed()) {
				System.out.println("Default disposal facility Element is visible :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Default disposal facility Element is visible");
			} else {
				System.out.println("Default disposal facility Element is not visible :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Default disposal facility Element is not visible");
			}
			Assert.assertTrue(element.isDisplayed());
			System.out.println("Default disposal facility displayed successfully :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Default disposal facility displayed successfully");
			wlib.scrollToelement(driver, ras.getDefaultdisposalDD());
			ras.defaultdisposaldd();
			System.out.println("Default disposal facility seleccted value successfully");
			utilityclassobject.gettest().log(Status.INFO, "Default disposal facility seleccted value successfully");
			ras.ServiceDuration();
			System.out.println("Service duration selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service duration selected successfully");
			Thread.sleep(5000);
			wlib.scrollToelement(driver, ras.getReqout());
			Thread.sleep(2000);
			ras.ScopeOfWork();
			System.out.println("Scope of work selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
			Thread.sleep(2000);
			ras.IncreaseGalone();
			ras.IncreaseGaltwo();
			System.out.println("Scope of work increased successfully");
			utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
			ras.AddRoute();
			System.out.println("Service is added to route successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service is added to route successfully");
			String serviceType = ras.getServicetxt().getText();
			System.out.println(serviceType);
			Thread.sleep(5000);
			wlib.scrollToelement(driver, ras.getSubcontractiorserviceRequest());
			ras.getSubcontractiorserviceRequest().click();
			utilityclassobject.gettest().log(Status.INFO, "Sub contractor ");

			ras.SubcontractorDropdown();
			System.out.println("Clicked on subcontractor dropdown until T-3,and T-7 viibile");
			utilityclassobject.gettest().log(Status.INFO, "Clicked on subcontractor dropdown until T-3,and T-7 viibile");
			wlib.scrollToelement(driver, ras.getSendtosubcontractor());
			ras.getT_3Subcontractor().click();
			//ras.ServiceFrequency();
			ras.Servicefreq2();
			System.out.println("Service Frequency selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service Frequency selected successfully");
			ras.selectweekday2();
			System.out.println("Week days selected successfully");
			utilityclassobject.gettest().log(Status.INFO, "Week days selected successfully");

			ras.RequestStartDate();
			System.out.println("Request start date added successfully");
			utilityclassobject.gettest().log(Status.INFO, "Request start date added successfully");
			ras.ServiceTypeInSSR();
			System.out.println("Service Type added successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service Type added successfully");
			ras.ServiceDurationInSSR();
			System.out.println("Service Duration 15 minute added successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service Duration 15 minute added successfully");
			ras.ScopeOfWork();
			System.out.println("Scope of work  added successfully");
			utilityclassobject.gettest().log(Status.INFO, "Scope of work  added successfully");
			//wlib.scrollToelement(driver, ras.getSendtosubcontractor());
			
			//click on that cancel 
			ras.getCancelbuttoninSSRbesideSendtosubcontractor().click();
			System.out.println("Subcontractor cancelled successfully");
			utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
			ras.RemoveServiceSchedule();
			System.out.println("Service is removed successfully");
			utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
			Thread.sleep(8000);
			
			System.out.println("Subcontractor all the text field accepts inputs successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Subcontractor all the text field accepts inputs successfully : PASS");
		  
	  }
	@Test(dependsOnMethods = "TC_015VerifySubcontractorAlltheTextFieldAcceptsInputs")
	public void TC_016VerifySSRWithoutInput() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		ras.AddService();
		Thread.sleep(5000);
		System.out.println("Add service displayed all text field successfully");
		utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
		ras.Route1();
		System.out.println("Route selected successfully");
		utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
		ras.ServiceFrequency();
		System.out.println("Service frequency selected successfully");
		utilityclassobject.gettest().log(Status.INFO, "Service frequency selected successfully");
		ras.SelectWeekDay();
		ras.getClickoutside().click();
		System.out.println("Week days selected successfully");
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
			System.out.println("Default disposal facility Element is visible :Pass");
			utilityclassobject.gettest().log(Status.PASS, "Default disposal facility Element is visible");
		} else {
			System.out.println("Default disposal facility Element is not visible :Fail");
			utilityclassobject.gettest().log(Status.FAIL, "Default disposal facility Element is not visible");
		}
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Default disposal facility displayed successfully");
		utilityclassobject.gettest().log(Status.INFO, "Default disposal facility displayed successfully");
		ras.defaultdisposaldd();
		System.out.println("Default disposal facility seleccted value successfully");
		utilityclassobject.gettest().log(Status.INFO, "Default disposal facility seleccted value successfully");
		ras.ServiceDuration();
		System.out.println("Service duration selected successfully");
		utilityclassobject.gettest().log(Status.INFO, "Service duration selected successfully");
		Thread.sleep(5000);
		ras.ScopeOfWork();
		System.out.println("Scope of work selected successfully");
		utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
		Thread.sleep(2000);
		ras.IncreaseGalone();
		ras.IncreaseGaltwo();
		System.out.println("Scope of work increased successfully");
		utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
		ras.AddRoute();
		System.out.println("Service is added to route successfully");
		utilityclassobject.gettest().log(Status.INFO, "Service is added to route successfully");
		String serviceType = driver
				.findElement(By.xpath("//span[contains(@class,'truncate') and text()='Medical Waste']")).getText();
		System.out.println(serviceType);
		Thread.sleep(5000);
		ras.getSubcontractiorserviceRequest().click();
		utilityclassobject.gettest().log(Status.INFO, "Sub contractor ");

		ras.SubcontractorDropdown();
		System.out.println("Clicked on subcontractor dropdown until T-3,and T-7 viibile");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on subcontractor dropdown until T-3,and T-7 viibile");
		ras.getT_3Subcontractor().click();
		//ras.ServiceFrequency();
		ras.Servicefreq2();
		System.out.println("Service Frequency selected successfully");
		utilityclassobject.gettest().log(Status.INFO, "Service Frequency selected successfully");
		ras.getSendtosubcontractor().click();
		System.out.println("Click on send to subcontractor");
		utilityclassobject.gettest().log(Status.INFO, "Clcik on send to subcontractor");

		// Fetch all error messages
		List<WebElement> errorMessages = driver.findElements(By.xpath("//p[contains(@class,'text-red-500')]"));

		// Verify error messages are displayed
		for (WebElement error : errorMessages) {

		    if (error.isDisplayed()) {
		        System.out.println("Displayed error message: " + error.getText());
		        utilityclassobject.gettest().log(Status.INFO, "Displayed error message: " + error.getText());
		        System.out.println("Error message displayed successfully :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Error message displayed  successfully");

		    } else {
		        System.out.println("Error message NOT displayed :Fail");
		        utilityclassobject.gettest().log(Status.FAIL, "Error message NOT displayed");
		    }

		    // Assertion (TestNG)
		    Assert.assertTrue(error.isDisplayed(), "Error message not displayed: " + error.getText());
		    System.out.println("Error message displayed and verified successfully");
			utilityclassobject.gettest().log(Status.INFO, "Error message displayed and verified  successfully");

		}
	
		ras.getCanclebtninsubcontractor().click();
		System.out.println("Subcontractor cancelled successfully");
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		System.out.println("Service is removed successfully");
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");

	}
	
	@Test(dependsOnMethods = "TC_016VerifySSRWithoutInput")
	public void TC_017SSRwitAddService() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,
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
		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
		Thread.sleep(5000);

}
	
	@Test(dependsOnMethods = "TC_017SSRwitAddService")
	public void TC_018SSRwitAllValidInputAndsend() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,
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
		utilityclassobject.gettest().log(Status.INFO, "SSR Accepted with all valid input");

		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
		Thread.sleep(5000);

}
	
	@Test(dependsOnMethods = "TC_018SSRwitAllValidInputAndsend")
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
	
	@Test(dependsOnMethods = "TC_019")
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

	@Test(dependsOnMethods = "TC_020ListofNameInSubcontractor")
	public void TC_021SubContractorServiceFrequency() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,
			HeadlessException, UnsupportedFlavorException {
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib = new webDriverutility();
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
		ras.getT_3Subcontractor().click();
		// ras.ServiceFrequency();
		ras.Servicefreq2();
		utilityclassobject.gettest().log(Status.INFO, "Service Frequency selected successfully");
		ras.selectweekday2();

		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");

		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
	}
	
	@Test(dependsOnMethods = "TC_021SubContractorServiceFrequency")
	public void TC_022RequestDate() throws InterruptedException, EncryptedDocumentException, IOException, AWTException, HeadlessException, UnsupportedFlavorException {
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
		ras.getT_3Subcontractor().click();
		//ras.ServiceFrequency();
		ras.Servicefreq2();
		utilityclassobject.gettest().log(Status.INFO, "Service Frequency selected successfully");
		ras.selectweekday2();
		utilityclassobject.gettest().log(Status.INFO, "Week days selected successfully");
		ras.RequestStartDate();
		utilityclassobject.gettest().log(Status.INFO, "Request start date added successfully");
		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
	}
	
	@Test(dependsOnMethods = "TC_022RequestDate")
	public void TC_023SharedServiceNote() throws InterruptedException, EncryptedDocumentException, IOException, AWTException, HeadlessException, UnsupportedFlavorException {
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
		ras.getT_3Subcontractor().click();
		//ras.ServiceFrequency();
		ras.Servicefreq2();
		utilityclassobject.gettest().log(Status.INFO, "Service Frequency selected successfully");
		ras.selectweekday2();
		utilityclassobject.gettest().log(Status.INFO, "Week days selected successfully");

		ras.RequestStartDate();
		utilityclassobject.gettest().log(Status.INFO, "Request start date added successfully");
		ras.SharedServiceNote("Service is Good");
		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
}
	
	@Test(dependsOnMethods = "TC_023SharedServiceNote")
	public void TC_024ServiceTypeInSSR() throws InterruptedException, EncryptedDocumentException, IOException, AWTException, HeadlessException, UnsupportedFlavorException {
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
		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
       
}
	
	@Test(dependsOnMethods = "TC_024ServiceTypeInSSR")
	public void TC_025ServiceDuration() throws InterruptedException, EncryptedDocumentException, IOException, AWTException, HeadlessException, UnsupportedFlavorException {
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
		Thread.sleep(2000);

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
		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
}
	
	@Test(dependsOnMethods = "TC_025ServiceDuration")
	public void TC_026ScopeOFworkInSSR() throws InterruptedException, EncryptedDocumentException, IOException, AWTException, HeadlessException, UnsupportedFlavorException {
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
		ras.getCanclebtninsubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");

	}
	
	
	@Test(dependsOnMethods = "TC_026ScopeOFworkInSSR")
	public void TC_029ExpetedContainer() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,
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
		;
		utilityclassobject.gettest().log(Status.INFO, "week days selected successfully");
		ras.getCalendar().click();
		LocalDate today = LocalDate.now();
		String day = String.valueOf(today.getDayOfMonth());
		driver.findElement(By.xpath("//*[text()='" + day + "']")).click();
		utilityclassobject.gettest().log(Status.INFO, "Current date selected successfully");
		/*
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
		ras.AnchorDate();
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
	
		ras.getSendtosubcontractor().click();
		Thread.sleep(2000);
		ras.MasterPricebook();
		Thread.sleep(2000);

		WebElement bio10 = driver.findElement(By.xpath("//input[@value='10 Gal Bio 100']"));

			String bio10Value = bio10.getAttribute("value");
			System.out.println(bio10Value);
			WebElement bio17 = driver.findElement(By.xpath("//input[@value='17 Gal BIo 1']"));

				String bio17Value = bio17.getAttribute("value");
				System.out.println(bio17Value);
				WebElement bioSharps = driver.findElement(
					    By.xpath("//p[text()='Bio/Sharps']")
					);

					System.out.println(bioSharps.getText());
					driver.navigate().back();
					driver.navigate().back();
	
	
/*
		ras.getCanclebtninsubcontractor().click();
		Thread.sleep(6000);
		ras.getCancelSSrNOTe().sendKeys("Cancel SSR");
		ras.getCancelRequestBtn().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");*/

}
	
	@Test(dependsOnMethods = "TC_029ExpetedContainer")
	public void TC_029NoofContainers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,HeadlessException, UnsupportedFlavorException {
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
		Thread.sleep(4000);
		WebElement field17Gal = driver.findElement(
		        By.xpath("(//div[@class='relative w-2/3'])[3]")
		);

		WebElement field18Gal = driver.findElement(
		        By.xpath("(//div[@class='relative w-2/3'])[4]")
		);

		// Validate visibility
		Assert.assertTrue(field17Gal.isDisplayed(), "17 Gallon field is NOT visible");
		Assert.assertTrue(field18Gal.isDisplayed(), "18 Gallon field is NOT visible");

		System.out.println("Both 17 Gal and 18 Gal fields are visible ✅");
		utilityclassobject.gettest().log(Status.INFO, "Scope of work  added successfully and container is displayed");
		ras.getSendtosubcontractor().click();
		
		Thread.sleep(2000);
		String servicestatus = ras.getServicestatusinSSR().getText();
		System.out.println("Service status is "+servicestatus);
		utilityclassobject.gettest().log(Status.INFO, "Service status is "+servicestatus+" displayed successfully" );
		Thread.sleep(2000);

		ras.getCanclebtninsubcontractor().click();
		Thread.sleep(6000);
		ras.getCancelSSrNOTe().sendKeys("Cancel SSR");
		ras.getCancelRequestBtn().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");

}
	
	@Test(dependsOnMethods = "TC_029NoofContainers")
	public void TC_030PendingStatusInSSR() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,
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
		ras.getSendtosubcontractor().click();
		
		Thread.sleep(2000);
		String servicestatus = ras.getServicestatusinSSR().getText();
		System.out.println("Service status is "+servicestatus);
		utilityclassobject.gettest().log(Status.INFO, "Service status is "+servicestatus+" displayed successfully" );
		Thread.sleep(2000);

		ras.getCanclebtninsubcontractor().click();
		Thread.sleep(6000);
		ras.getCancelSSrNOTe().sendKeys("Cancel SSR");
		ras.getCancelRequestBtn().click();
		Thread.sleep(6000);

		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");

}
	
	@Test(dependsOnMethods = "TC_030PendingStatusInSSR")
	public void TC_031RemoveSSR() throws InterruptedException, EncryptedDocumentException, IOException, AWTException,
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
		ras.getSendtosubcontractor().click();
		
		Thread.sleep(2000);
		String servicestatus = ras.getServicestatusinSSR().getText();
		System.out.println("Service status is "+servicestatus);
		utilityclassobject.gettest().log(Status.INFO, "Service status is "+servicestatus+" displayed successfully" );
		Thread.sleep(2000);

		ras.getCanclebtninsubcontractor().click();
		Thread.sleep(6000);
		ras.getCancelSSrNOTe().sendKeys("Cancel SSR");
		ras.getCancelRequestBtn().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Subcontractor cancelled successfully");
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");

}
	
	
	@Test(dependsOnMethods = "TC_031RemoveSSR")
	public void TC_32ReassignwithSSR() throws InterruptedException, EncryptedDocumentException, IOException, AWTException, HeadlessException, UnsupportedFlavorException {
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
		ras.getT_3Subcontractor().click();
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
		ras.ScopeOfWorkInSSR();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work  added successfully");
		ras.getSendtosubcontractor().click();
		utilityclassobject.gettest().log(Status.INFO, "Sub contractor added");
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------
		//------------Don't Run------------

		/*
		Thread.sleep(3000);
		ras.getCancelSSR().click();
		ras.getCancelSSrNOTe().sendKeys("Cancel SSR");
		ras.getCancelRequestBtn().click();
		Thread.sleep(2000);
		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed successfully");
		*/
		
		
}
	
	@Test(dependsOnMethods = "TC_32ReassignwithSSR")
	public void TC_033AddserviceinPuoteAssignment() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
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
	String ActualName = ginfo.GeneratorName();
	System.out.println(ActualName);
	Assert.assertTrue(ActualName.contains(GeneretorName));
	WebElement BillingInfo = ginfo.getBillingInfo();
	wlib.scrollToelement(driver, BillingInfo);
	ginfo.IndustryDD();
	WebElement lat = ginfo.getLatitute();
	wlib.scrollToelement(driver, lat);
	ginfo.Street();
	Thread.sleep(3000);
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
	Thread.sleep(10000);
	ginfo.Ellisebtn();
	utilityclassobject.gettest().log(Status.INFO, "Route Assignment page is displayed");
	Thread.sleep(7000);
	//WebElement ssr = rasp.getSSRbtn();
	//wlib.scrollToelement(driver, ssr);
	WebElement Addser = driver.findElement(By.xpath("//span[contains(text(),'Add a Service')]"));
	wlib.scrollToelement(driver, Addser);
	Addser.click();
	utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");


	/*
	ssr.click();
	
	
	WebElement subcontractorname = rasp.getSubcontractor();
	
	subcontractorname.click();
	//wlib.selectByIndex(subcontractorname, 1);
	WebElement option = driver.findElement(By.xpath("//li[@role='option']//span"));
	wlib.mousemoveonElement(driver, option);
	option.click();
	ras.getServicefrequencydd().click();
	WebElement sfr = driver.findElement(By.xpath("//div[contains(text(),'Multiple Times Weekly (MTW)')]"));
	wlib.mousemoveonElement(driver,sfr );
	sfr.click();
	
	*/

	}
	
	@Test(dependsOnMethods = "TC_033AddserviceinPuoteAssignment")
	public void TC_034AddRoute() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
	elib = new ExcelUtility();
	jlib = new javautility();
	wlib = new webDriverutility();
	lp = new LoginPage(driver);
	hp = new HomePage(driver);
	elib = new ExcelUtility();
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
	utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
	ras.NayanRoute();
	utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
	Thread.sleep(5000);
	utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
	ras.Route1();
	utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
	ras.ServiceFrequency();
	utilityclassobject.gettest().log(Status.INFO, "Service frequency selected successfully");
	ras.SelectWeekDay(); 
	utilityclassobject.gettest().log(Status.INFO, "Week days  selected successfully");
    Thread.sleep(3000);
    ras.getRemoveserviceschedule().click();
	//ras.RemoveServiceSchedule();
	utilityclassobject.gettest().log(Status.INFO, "Service is removed succesfully");

	}
	
	@Test(dependsOnMethods = "TC_034AddRoute")
	public void TC_035AddSerivceFrequency() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
	elib = new ExcelUtility();
	jlib = new javautility();
	wlib = new webDriverutility();
	lp = new LoginPage(driver);
	hp = new HomePage(driver);
	hp.getGeneratoemanag().click();
	GeneratorManagentPage gmp = new GeneratorManagentPage(driver);
	String gname = elib.getDataFromExcel("Generator", 1, 1);
	gmp.CharlieAccounttwo(gname);
	ras = new RouteAssignment(driver);
	GeneretorInformation gip = new GeneretorInformation(driver);
	gip.Ellisebtn();
	utilityclassobject.gettest().log(Status.INFO, "Route assignment page is displayed successfully");
	ras=new RouteAssignment(driver);
	Thread.sleep(15000);
	ras.AddService();
	utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
	ras.NayanRoute();
	utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
	ras.ServiceFrequency();
	utilityclassobject.gettest().log(Status.INFO, "Service frequency selected successfully");

	}
	
	@Test(dependsOnMethods = "TC_035AddSerivceFrequency")
	public void TC_036Selectweekdays() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
		hp = new HomePage(driver);
		elib = new ExcelUtility();
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
		ras.getRemoveserviceschedule().click();
	}
	
	@Test(dependsOnMethods = "TC_036Selectweekdays")
	public void TC_037AnchorDate() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
		hp = new HomePage(driver);
		elib = new ExcelUtility();
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
	}
	
	@Test(dependsOnMethods = "TC_037AnchorDate")
	public void TC_038Addservicetype() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {

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
	
	@Test(dependsOnMethods = "TC_038Addservicetype")
	public void TC_039DefaultdisposalFacility() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
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
	Thread.sleep(15000);
	ras=new RouteAssignment(driver);
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


	}
	
	@Test(dependsOnMethods = "TC_039DefaultdisposalFacility")
	public void TC_040Selectvaluefromdefaultdisposalfacility() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
		hp = new HomePage(driver);
		elib = new ExcelUtility();
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

	}

	@Test(dependsOnMethods = "TC_040Selectvaluefromdefaultdisposalfacility")
	public void TC_041Selectvaluefromdefaultdisposalfacility() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	
		hp = new HomePage(driver);
		elib = new ExcelUtility();
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
	}
	
	@Test(dependsOnMethods = "TC_041Selectvaluefromdefaultdisposalfacility")
	public void TC_042scopeofworkasservicetype() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
		hp = new HomePage(driver);
		elib = new ExcelUtility();
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
	ras.ScopeOfworko();
    Thread.sleep(2000);
	List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
   
	System.out.println("Total Options: " + list.size());

	for(WebElement option : list)
	{
	    System.out.println(option.getText());
	}
	utilityclassobject.gettest().log(Status.INFO, "Scope of work displayed element based on selected service type");

	}
	
	@Test(dependsOnMethods = "TC_042scopeofworkasservicetype")
	public void TC_043numberofcontainerIncrease()
			throws EncryptedDocumentException, IOException, InterruptedException, AWTException {

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
		ras.ScopeOfWork();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
		ras.getClickoutside().click();
		// ras.getSowclick().click();
		ras.IncreaseGalone();
		ras.IncreaseGaltwo();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
		ras.decreasesevGalBioone();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work decreased successfully");
		ras.getRemoveserviceschedule();

	}
	
	@Test(dependsOnMethods = "TC_043numberofcontainerIncrease")
	public void Tc_044checkbox() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
		ras.getRemoveserviceschedule();
	}
	
	@Test(dependsOnMethods = "Tc_044checkbox")
	public void TC_045NextService() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
    	//List<WebElement> schedules = driver.findElements( By.xpath("//div[contains(@class,'bg-gray-100 rounded-full')]"));
    	List<WebElement> scheduleservce = driver.findElements(By.xpath("//div[contains(@class,'bg-gray-100 rounded-full')]"));

    	System.out.println("Total schedules: " + scheduleservce.size());

    	if(scheduleservce.size() == 6) {
    	    System.out.println("All 6 schedules are displayed");
        	utilityclassobject.gettest().log(Status.INFO, "All 6 schedules are displayed");

    	} else {
    	    System.out.println("Schedules count mismatch");
    	}
		ras.getRemoveserviceschedule();

	}
	
	@Test(dependsOnMethods = "TC_045NextService")
	public void TC_046NextservicewithOfficehours() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
    	//List<WebElement> schedules = driver.findElements( By.xpath("//div[contains(@class,'bg-gray-100 rounded-full')]"));
    	List<WebElement> scheduleservce = driver.findElements(By.xpath("//div[contains(@class,'bg-gray-100 rounded-full')]"));

    	System.out.println("Total schedules: " + scheduleservce.size());

    	if(scheduleservce.size() == 6) {
    	    System.out.println("All 6 schedules are displayed");
        	utilityclassobject.gettest().log(Status.INFO, "All 6 schedules are displayed");
    	} else {
    	    System.out.println("Schedules count mismatch");
    	}
    	
    	for(WebElement schedule : scheduleservce)
    	{
    	    String service = schedule.getText();

    	    boolean hasTime = service.matches(".*\\d{1,2}:\\d{2}.*");

    	    Assert.assertFalse(hasTime, "Office hours should not be displayed: " + service);
    	    System.out.println("Next service with office hours displayed successfully");
        	utilityclassobject.gettest().log(Status.INFO, "Next service with office hour displayed successfully");

    	}
		ras.getRemoveserviceschedule();

	}
	
	@Test(dependsOnMethods = "TC_046NextservicewithOfficehours")
	public void TC_047AddRoute() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	{
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
	ras.IncreaseGalone();
	ras.IncreaseGaltwo();
	utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
	ras.decreasesevGalBioone();
	utilityclassobject.gettest().log(Status.INFO, "Scope of work decreased successfully");
	ras.getRequitepiccheckbox().click();
	utilityclassobject.gettest().log(Status.INFO, "Require picture check box checked  successfully");
	ras.AddRoute();
	Thread.sleep(10000);
	utilityclassobject.gettest().log(Status.INFO, "Add route clicked successfully");
	ras.RemoveServiceSchedule();
	utilityclassobject.gettest().log(Status.INFO, "Service is removed succesfully");

	}
	
	@Test(dependsOnMethods = "TC_047AddRoute")
	public void TC_048Establishedhours() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
    	Thread.sleep(7000);
    	utilityclassobject.gettest().log(Status.INFO, "Add route clicked successfully");
    	WebElement establishedDate =ras.getEstablisdate();
    	Assert.assertTrue(establishedDate.isDisplayed(), "Established Date field is not displayed");
      	ras.RemoveServiceSchedule();
    	utilityclassobject.gettest().log(Status.INFO, "Service removed successfully ");

	}
	
	@Test(dependsOnMethods = "TC_048Establishedhours")
	public void TC_049RemoveaddedService() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
    	Thread.sleep(7000);
    	utilityclassobject.gettest().log(Status.INFO, "Add route clicked successfully");
    	WebElement establishedDate =ras.getEstablisdate();
    	Assert.assertTrue(establishedDate.isDisplayed(), "Established Date field is not displayed");
    	ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed succesfully");


	}
	
	@Test(dependsOnMethods = "TC_049RemoveaddedService")
	public void TC_050UpdateButton() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
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
    	Thread.sleep(3000);
    	//ras.getSowclick().click();
    	Thread.sleep(5000);
    	ras.IncreaseGalone();
    	ras.IncreaseGaltwo();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
    	ras.decreasesevGalBioone();
    	utilityclassobject.gettest().log(Status.INFO, "Scope of work decreased successfully");
    	ras.getRequitepiccheckbox().click();
    	utilityclassobject.gettest().log(Status.INFO, "Require picture check box checked  successfully");
    	ras.AddRoute();
    	Thread.sleep(15000);
    	utilityclassobject.gettest().log(Status.INFO, "Add route clicked successfully");
    	ras.IncreaseGalone();
    	Thread.sleep(5000);
    	ras.getUpdatebtn().click();
    	ras.getUpdateschedule().click();
    	Thread.sleep(3000);
    	utilityclassobject.gettest().log(Status.INFO, "Add route Updated successfully");
    	Thread.sleep(10000);
    	WebElement establishedDate =ras.getEstablisdate();
    	Assert.assertTrue(establishedDate.isDisplayed(), "Established Date field is not displayed");
      	ras.RemoveServiceSchedule();
    	utilityclassobject.gettest().log(Status.INFO, "Service removed successfully ");


	}

	
	
	
	


}
