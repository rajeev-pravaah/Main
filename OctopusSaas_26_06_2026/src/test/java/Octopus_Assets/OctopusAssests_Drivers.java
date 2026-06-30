package Octopus_Assets;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.emulation.model.SensorMetadata;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.BaseUtility.BaseclassforDrivers;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AssestsDrivers;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class OctopusAssests_Drivers extends BaseclassforDrivers{
	AssestsDrivers ad;
	ExcelUtility elib;
	String octoid ;
	String firstnameinput;
	String phone;

	@Test(priority = 1)
	public void TC_001AssetsDrivers_withDriverPage() throws InterruptedException
	{
		elib = new ExcelUtility();
		ad = new AssestsDrivers(driver);
		ad.Drivers();
		utilityclassobject.gettest().log(Status.INFO, "System is redirected the user to the drivers page");
		Thread.sleep(2000);
	}
	
	
	@Test(dependsOnMethods = "TC_001AssetsDrivers_withDriverPage")
	public void TC_002AssetsDrivers_withTooltip()
	{
		ad.getDriversTooltip().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ad.getDriversTooltip()));
		utilityclassobject.gettest().log(Status.INFO, "User is able to see the octo info");
	}
	
	
	@Test(dependsOnMethods = "TC_002AssetsDrivers_withTooltip")
	public void TC_003AssetsDrivers_AddnewDriver()
	{
		ad.getAddNewdriverButton().click();
		utilityclassobject.gettest().log(Status.INFO, "User is able to add Add new Driver");
	}
	
	@Test(dependsOnMethods = "TC_003AssetsDrivers_AddnewDriver") 
	public void TC_004AssestsDrivers_FirstnamewithInput() throws EncryptedDocumentException, IOException
	{
		ad.getFirstnameField().click();
		String input = elib.getDataFromExcel("Drivers", 1, 1);
		ad.getFirstnameField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "First name text field accepted input");	
	}
	
	@Test(dependsOnMethods = "TC_004AssestsDrivers_FirstnamewithInput") 
	public void TC_005AssetsDrivers_firstnamewithNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getFirstnameField().click();
		ad.getFirstnameField().sendKeys(Keys.CONTROL + "a");
		ad.getFirstnameField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 1, 2);
		ad.getFirstnameField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "First name text field accepted numbers");	
	}
	
	@Test(dependsOnMethods = "TC_005AssetsDrivers_firstnamewithNumbers")
	public void TC_006AssetsDrivers_firstnamewithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getFirstnameField().click();
		ad.getFirstnameField().sendKeys(Keys.CONTROL + "a");
		ad.getFirstnameField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 1, 3);
		ad.getFirstnameField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "First name text field accepted specialcharaters");	
	}
	
	@Test(dependsOnMethods = "TC_006AssetsDrivers_firstnamewithSpecialcharacters") 
	public void TC_007AssetsDrivers_firstnamewithoutInput()
	{
		ad.getFirstnameField().click();
		ad.getFirstnameField().sendKeys(Keys.CONTROL + "a");
		ad.getFirstnameField().sendKeys(Keys.DELETE);
		ad.AddnewDriverSubmit();
		String errormsg = ad.getFirstnameErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "First name text field without input displayed error message");		
	}
	
	@Test(dependsOnMethods = "TC_007AssetsDrivers_firstnamewithoutInput")
	public void TC_008AssestsDrivers_MiddleIntialwithInput() throws EncryptedDocumentException, IOException
	{
		ad.getMiddleIntialField().click();
		String input = elib.getDataFromExcel("Drivers", 4, 1);
		ad.getMiddleIntialField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Middle Intial text field accepted Input");		
	}
	
	@Test(dependsOnMethods = "TC_008AssestsDrivers_MiddleIntialwithInput")
	public void TC_009AssetsDrivers_MiddleIntialwithNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getMiddleIntialField().click();
		ad.getMiddleIntialField().sendKeys(Keys.CONTROL + "a");
		ad.getMiddleIntialField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 4, 2);
		ad.getMiddleIntialField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Middle Intial text field accepted numbers");		
	}
	
	@Test(dependsOnMethods = "TC_009AssetsDrivers_MiddleIntialwithNumbers")
	public void TC_010AssetsDrivers_MiddleIntialwithSpecialCharacters() throws EncryptedDocumentException, IOException 
	{	
		ad.getMiddleIntialField().click();
		ad.getMiddleIntialField().sendKeys(Keys.CONTROL + "a");
		ad.getMiddleIntialField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 4, 3);
		ad.getMiddleIntialField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Middle Intial text field accepted specialcharacters");		
	}
	
	@Test(dependsOnMethods = "TC_010AssetsDrivers_MiddleIntialwithSpecialCharacters")
	public void TC_011AssetsDrivers_MiddleIntialmorethanonecharacter() throws EncryptedDocumentException, IOException
	{
		ad.getMiddleIntialField().click();
		ad.getMiddleIntialField().sendKeys(Keys.CONTROL + "a");
		ad.getMiddleIntialField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 4, 1);
		if (input != null && input.length() > 1) {
		    input = input.substring(0, 1);
		}
		ad.getMiddleIntialField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Middle Intial text field accepted only one character");		
	
	}
	
	@Test(dependsOnMethods = "TC_011AssetsDrivers_MiddleIntialmorethanonecharacter")
	public void TC_012AssetsDrivers_MiddleIntialwithoutInput()
	{
		ad.getMiddleIntialField().click();
		ad.getMiddleIntialField().sendKeys(Keys.CONTROL + "a");
		ad.getMiddleIntialField().sendKeys(Keys.DELETE);
		ad.AddnewDriverSubmit();
		utilityclassobject.gettest().log(Status.INFO, "Middle Intial text field without input error message is not dispalyed(not mandataroyfield)");		
	}
	
	@Test(dependsOnMethods = "TC_012AssetsDrivers_MiddleIntialwithoutInput")
	public void TC_013AssetsDrivers_LastnamewithInput() throws EncryptedDocumentException, IOException
	{
		ad.getLastnameField().click();
		String input = elib.getDataFromExcel("Drivers", 7, 1);
		ad.getLastnameField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Last name text field accepted input");		
	}
	
	@Test(dependsOnMethods = "TC_013AssetsDrivers_LastnamewithInput")
	public void TC_014AssetsDrivers_LastnamewithNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getLastnameField().click();
		ad.getLastnameField().sendKeys(Keys.CONTROL + "a");
		ad.getLastnameField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 7, 2);
		ad.getLastnameField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Last name text field accepted numbers");		
	}
	
	@Test(dependsOnMethods = "TC_014AssetsDrivers_LastnamewithNumbers")
	public void TC_015AssetsDrivers_LastnamewithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getLastnameField().click();
		ad.getLastnameField().sendKeys(Keys.CONTROL + "a");
		ad.getLastnameField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 7, 3);
		ad.getLastnameField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Last name text field accepted specialcharacters");		
	}
	
	@Test(dependsOnMethods = "TC_015AssetsDrivers_LastnamewithSpecialcharacters")
	public void TC_016AssestsDrivers_lastnamewithoutInput()
	{
		ad.getLastnameField().click();
		ad.getLastnameField().sendKeys(Keys.CONTROL + "a");
		ad.getLastnameField().sendKeys(Keys.DELETE);
		ad.AddnewDriverSubmit();
		utilityclassobject.gettest().log(Status.INFO, "Last name text field without input displayed error message");		
	}
	
	@Test(dependsOnMethods = "TC_016AssestsDrivers_lastnamewithoutInput")
	public void TC_017AssetsDrivers_EmailwithInput() throws EncryptedDocumentException, IOException
	{
		ad.getEmailField().click();
		String input = elib.getDataFromExcel("Drivers", 10, 1);
		ad.getEmailField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Email text field accepted input");			
	}
		
	@Test(dependsOnMethods = "TC_017AssetsDrivers_EmailwithInput")
	public void TC_018AssetsDrivers_EmailwithNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getEmailField().click();
		ad.getEmailField().sendKeys(Keys.CONTROL + "a");
		ad.getEmailField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 10, 2);
		ad.getEmailField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Email text field accepted numbers");			
	}
	
	@Test(dependsOnMethods = "TC_018AssetsDrivers_EmailwithNumbers")
	public void TC_019AssestsDrivers_Emailwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getEmailField().click();
		ad.getEmailField().sendKeys(Keys.CONTROL + "a");
		ad.getEmailField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 10, 3);
		ad.getEmailField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Email text field accepted specialcharaacters");			
	}
	
	
	@Test(dependsOnMethods = "TC_019AssestsDrivers_Emailwithspecialcharacters")
	public void TC_020AssestsDrivers_EmialwithoutInput()throws InterruptedException
	{
		ad.getEmailField().click();
		ad.getEmailField().sendKeys(Keys.CONTROL + "a");
		ad.getEmailField().sendKeys(Keys.DELETE);
		ad.AddnewDriverSubmit();
		Thread.sleep(20000);
		String errormsg = ad.getEmailErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Email text field without input displayed error message");			
	}
	
	@Test(dependsOnMethods = "TC_020AssestsDrivers_EmialwithoutInput")
	public void TC_021AssestsDrivers_DriverLocation()
	{
		ad.DriverLocation();
		utilityclassobject.gettest().log(Status.INFO, "Driver Location Assignment dropdown is disaplyed with locations");			

	}
	
	@Test(dependsOnMethods = "TC_021AssestsDrivers_DriverLocation")
	public void TC_022AssetsDrivers_uncheck() throws InterruptedException
	{
		ad.UnchecktheDriverLocation();
		utilityclassobject.gettest().log(Status.INFO, "Driver Location Assignment dropdown is unchecked sucessfully");			

	}
	
	@Test(dependsOnMethods = "TC_022AssetsDrivers_uncheck")
	public void TC_023AssetsDrivers_LocationCheck() throws InterruptedException
	{
		ad.DriverLocationCheck();
		utilityclassobject.gettest().log(Status.INFO, "Driver Location Assignment dropdown is checked sucessfully");			

	}
	
	@Test(dependsOnMethods = "TC_023AssetsDrivers_LocationCheck")
	public void TC_024AssetsDrivers_removeLocations()
	{
		ad.getDriverLocation().click();
		ad.RemoveLocation();
		utilityclassobject.gettest().log(Status.INFO, "user is able to remove the locations");			
	}
	
	@Test(dependsOnMethods = "TC_024AssetsDrivers_removeLocations")
	public void TC_025AssetsDriver_withstatus()
	{
		ad.Driverstatus();
		utilityclassobject.gettest().log(Status.INFO, "Driver dropdown is displayed with active status");			

	}
	
	@Test(dependsOnMethods = "TC_025AssetsDriver_withstatus")
	public void TC_026AssetsDrivers_withbothstatus()
	{
		ad.CheckDriverstatus();
		utilityclassobject.gettest().log(Status.INFO, "Driver status dropdown contains both status ");			
	}
	
	@Test(dependsOnMethods = "TC_026AssetsDrivers_withbothstatus")
	public void TC_027AssestsDrivers_statusSelection() throws InterruptedException
	{
		ad.DriverStatusselection();
		utilityclassobject.gettest().log(Status.INFO,"user is able to select the status from the dropdown");			
	}
	
	@Test(dependsOnMethods = "TC_027AssestsDrivers_statusSelection")
	public void TC_028AssetsDrivers_addnewClikcable()
	{
		ad.getAddnewSubmitButton().click();
		utilityclassobject.gettest().log(Status.INFO,"Add new driver button is clickable");			
	}
	
	@Test(dependsOnMethods = "TC_028AssetsDrivers_addnewClikcable")
	public void TC_029AssetsDrivers_addnewwithoutMandatoryfield()
	{
		ad.Addnew();
		utilityclassobject.gettest().log(Status.INFO,"user is not able to add new driver without mandatoryfields");			
	}
	
	@Test(dependsOnMethods = "TC_029AssetsDrivers_addnewwithoutMandatoryfield")
	public void TC_030AssetsDrivers_AddnewDriver() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ad.getFirstnameField().click();
		Random random1 = new Random();
		int sixDigit1 = 100000 + random1.nextInt(900000);

		firstnameinput = elib.getDataFromExcel("Drivers", 1, 1)+sixDigit1;
		ad.getFirstnameField().sendKeys(firstnameinput);
		
		ad.getMiddleIntialField().click();
		String middlenameInput = elib.getDataFromExcel("Drivers", 4, 1);
		ad.getMiddleIntialField().sendKeys(middlenameInput);
		
		ad.getLastnameField().click();
		String lastnameInput = elib.getDataFromExcel("Drivers", 7, 1);
		ad.getLastnameField().sendKeys(lastnameInput);	
		ad.getEmailField().click();
		String emailInput = elib.getDataFromExcel("Drivers", 10, 4);
		int randomnumber = jlib.getRandomNumber();
		Random random6digit = new Random();
		int Sixnumber = 100000 + random6digit.nextInt(900000); // 100000–999999
		//Random random = new Random();
		//int sixDigit = 100000 + random.nextInt(900000);
		//String email = "test" + sixDigit + "@gmail.com";
		String email = emailInput + Sixnumber + "@gmail.com";
		ad.getEmailField().sendKeys(email);
		System.out.println(email);
		ad.NewDriverLocation();
		Thread.sleep(2000);
		ad.Driverstatus();
		Thread.sleep(2000);
		ad.AddnewDriver();
		octoid = driver.findElement(By.xpath("//input[@placeholder='Enter OCTO ID']")).getAttribute("value").trim();
		System.out.println("Captured OctoID : " + octoid);
		Thread.sleep(20000);
		utilityclassobject.gettest().log(Status.INFO,"user is able to add new driver with all the  mandatoryfields");			

	}
	
	@Test(dependsOnMethods = "TC_030AssetsDrivers_AddnewDriver")
	public void TC_031AssetsDrivers_DriverprofileInfo()throws InterruptedException
	{
		ad.getDriverprofileOctoinfo().click();
		ad.getTooltipCancelbutton().click();
		utilityclassobject.gettest().log(Status.INFO,"Driverprofile Octo info is displayed");			

	}
	
	@Test(dependsOnMethods = "TC_031AssetsDrivers_DriverprofileInfo")
	public void TC_032AssetsDrivers_driverFirstname()
	{
		ad.FirstnamewithValue();
		utilityclassobject.gettest().log(Status.INFO,"Firstname textfield is displayed with entered value");			

	}
	
	@Test(dependsOnMethods = "TC_032AssetsDrivers_driverFirstname")
	public void TC_033AssetsDriver_firstnamewithEdit()
	{
		ad.getDriverFirstname().click();
		ad.getDriverFirstname().sendKeys(Keys.CONTROL + "a");
		ad.getDriverFirstname().sendKeys(Keys.DELETE);
		ad.getDriverFirstname().sendKeys(firstnameinput);
		utilityclassobject.gettest().log(Status.INFO,"user is able to edit the firstname");			
	}
	
	@Test(dependsOnMethods = "TC_033AssetsDriver_firstnamewithEdit")
	public void TC_034AssetsDrivers_DriverMiddlename()
	{
		ad.Middlenamevalue();
		utilityclassobject.gettest().log(Status.INFO,"Middale name text field is displayed with entered value");			
	}
	
	@Test(dependsOnMethods = "TC_034AssetsDrivers_DriverMiddlename")
	public void TC_035AssetsDrivers_MiddlenamewithEdit()
	{
		ad.getDriverMiddlename().click();
		ad.getDriverMiddlename().sendKeys(Keys.CONTROL + "a");
		ad.getDriverMiddlename().sendKeys(Keys.DELETE);
		ad.getDriverMiddlename().sendKeys("K");
		utilityclassobject.gettest().log(Status.INFO,"user is able to edit the middlename");			
	}
	
	@Test(dependsOnMethods = "TC_035AssetsDrivers_MiddlenamewithEdit")
	public void TC_036AssetsDriver_driverLastname()
	{
		ad.LastnameValue();
		utilityclassobject.gettest().log(Status.INFO,"last name text field is displayed with entered value");				
	}
	
	@Test(dependsOnMethods = "TC_036AssetsDriver_driverLastname")
	public void TC_037AssetsDrivers_lastnamewithEdit()
	{
		ad.getDriverLastname().click();
		ad.getDriverLastname().sendKeys(Keys.CONTROL + "a");
		ad.getDriverLastname().sendKeys(Keys.DELETE);
		ad.getDriverLastname().sendKeys("reddy");
		utilityclassobject.gettest().log(Status.INFO,"user is able to edit the lastname");			
	}
	
	@Test(dependsOnMethods ="TC_037AssetsDrivers_lastnamewithEdit")
	public void TC_038AssetsDrivers_OctoID()
	{
		ad.OctoIDField();
		utilityclassobject.gettest().log(Status.INFO,"Octo ID text field is displayed with entered value");			
	}
	
	@Test(dependsOnMethods = "TC_038AssetsDrivers_OctoID")
	public void TC_039AssetsDrivers_OctoIDwithEdit()
	{
		ad.OctoIdwithEdit();
		utilityclassobject.gettest().log(Status.INFO,"user is not able to edit Octo ID");			
	}
	
	@Test(dependsOnMethods = "TC_039AssetsDrivers_OctoIDwithEdit")
	public void TC_040AssetsDrivers_PhonewithInput() throws EncryptedDocumentException, IOException
	{
		ad.getPhonetextField().click();
		ad.getPhonetextField().sendKeys(Keys.CONTROL + "a");
		ad.getPhonetextField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 13, 1);
		ad.getPhonetextField().sendKeys(input);
		phone = driver.findElement(By.xpath("//input[@id='phoneNumber']")).getText();
		utilityclassobject.gettest().log(Status.INFO,"Phone Text field accepted input");			
	}
	
	@Test(dependsOnMethods = "TC_040AssetsDrivers_PhonewithInput")
	public void TC_041AssetsDrivers_PhonewithAlphabets() throws EncryptedDocumentException, IOException
	{
		ad.getPhonetextField().click();
		ad.getPhonetextField().sendKeys(Keys.CONTROL + "a");
		ad.getPhonetextField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 13, 2);
		ad.getPhonetextField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Phone Text field will not accept alphabets");			
	}
	
	@Test(dependsOnMethods = "TC_041AssetsDrivers_PhonewithAlphabets")
	public void TC_042AssetsDrivers_PhonewithNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getPhonetextField().click();
		ad.getPhonetextField().sendKeys(Keys.CONTROL + "a");
		ad.getPhonetextField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 13, 3);
		ad.getPhonetextField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Phone Text field will accept numbers");			
	}
	
	@Test(dependsOnMethods = "TC_042AssetsDrivers_PhonewithNumbers")
	public void TC_043AssetsDrivers_PhonewithSpecialchracters() throws EncryptedDocumentException, IOException
	{
		ad.getPhonetextField().click();
		ad.getPhonetextField().sendKeys(Keys.CONTROL + "a");
		ad.getPhonetextField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 13, 4);
		ad.getPhonetextField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Phone Text field will not accept specialcharacters");			
	}
	
	@Test(dependsOnMethods = "TC_043AssetsDrivers_PhonewithSpecialchracters")
	public void TC_044AssetsDrivers_PhonewithMorethan10() throws EncryptedDocumentException, IOException
	{
		ad.getPhonetextField().click();
		ad.getPhonetextField().sendKeys(Keys.CONTROL + "a");
		ad.getPhonetextField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 13, 5);
		ad.getPhonetextField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Phone Text field will not accept more than 10 digits");			
	}
		
	@Test(dependsOnMethods = "TC_044AssetsDrivers_PhonewithMorethan10")
	public void TC_045AssetsDrivers_Phonewithlessthan10() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ad.getPhonetextField().click();
		ad.getPhonetextField().sendKeys(Keys.CONTROL + "a");
		ad.getPhonetextField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 13, 6);
		ad.getPhonetextField().sendKeys(input);
		ad.OctoLoginButton();
		Thread.sleep(3000);
		String errormsg = ad.getPhonetextErmsg().getText();
		System.out.println(errormsg);
		
		Thread.sleep(2000);
		ad.getPhonetextField().click();
		ad.getPhonetextField().click();
		ad.getPhonetextField().sendKeys(Keys.CONTROL + "a");
		ad.getPhonetextField().sendKeys(Keys.DELETE);
		String input1 = elib.getDataFromExcel("Drivers", 13, 1);
		ad.getPhonetextField().sendKeys(input1);
		utilityclassobject.gettest().log(Status.INFO,"Phone Text field will not accept less than 10 digits and displayed error message");			
	}
	
	@Test(dependsOnMethods = "TC_045AssetsDrivers_Phonewithlessthan10")
	public void TC_046AssetsDrivers_ExtwithInput() throws EncryptedDocumentException, IOException
	{
		ad.getExttextfield().click();
		ad.getExttextfield().sendKeys(Keys.CONTROL + "a");
		ad.getExttextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 16, 1);
		ad.getExttextfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Ext text field accepted input");			
	}
	
	@Test(dependsOnMethods = "TC_046AssetsDrivers_ExtwithInput")
	public void TC_047AssetsDrivers_Extwithalphabets() throws EncryptedDocumentException, IOException
	{
		ad.getExttextfield().click();
		ad.getExttextfield().sendKeys(Keys.CONTROL + "a");
		ad.getExttextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 16, 2);
		ad.getExttextfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Ext text field will not accept alphabets");			
	}
	
	@Test(dependsOnMethods = "TC_047AssetsDrivers_Extwithalphabets")
	public void TC_048AssetsDrivers_Extwithnumbers() throws EncryptedDocumentException, IOException
	{
		ad.getExttextfield().click();
		ad.getExttextfield().sendKeys(Keys.CONTROL + "a");
		ad.getExttextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 16, 3);
		ad.getExttextfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Ext text field accept numbers");			
	}
	
	@Test(dependsOnMethods = "TC_048AssetsDrivers_Extwithnumbers")
	public void TC_049AssetsDrivers_Extwithspecailcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getExttextfield().click();
		ad.getExttextfield().sendKeys(Keys.CONTROL + "a");
		ad.getExttextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 16, 4);
		ad.getExttextfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Ext text field will not accept specialcharacters");			
	}
	
	@Test(dependsOnMethods = "TC_049AssetsDrivers_Extwithspecailcharacters")
	public void TC_050AssetsDrivers_Extmorethan5digits() throws EncryptedDocumentException, IOException
	{
		ad.getExttextfield().click();
		ad.getExttextfield().sendKeys(Keys.CONTROL + "a");
		ad.getExttextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 16, 5);
		ad.getExttextfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Ext text field will not more than 5 digits");			
	}
	
	@Test(dependsOnMethods = "TC_050AssetsDrivers_Extmorethan5digits")
	public void TC_051AssetsDrivers_Extlessthan5digits() throws EncryptedDocumentException, IOException
	{
		ad.getExttextfield().click();
		ad.getExttextfield().sendKeys(Keys.CONTROL + "a");
		ad.getExttextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 16, 6);
		ad.getExttextfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Ext text field accept less than 5 digits");			
	}
	
	@Test(dependsOnMethods = "TC_051AssetsDrivers_Extlessthan5digits")
	public void TC_052AssetsDrivers_withEmail()
	{
		ad.DriverEmail();
		utilityclassobject.gettest().log(Status.INFO,"Email textfield is displayed with value");			
	}
	
	@Test(dependsOnMethods = "TC_052AssetsDrivers_withEmail")
	public void TC_053AssestsDrivers_Emailwithedit()
	{
		ad.EmailwithEdit();
		utilityclassobject.gettest().log(Status.INFO,"user is able to edit the email");			
	}
	
	@Test(dependsOnMethods = "TC_053AssestsDrivers_Emailwithedit")
	public void TC_054AssetsDrivers_PasswordwithInput() throws EncryptedDocumentException, IOException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 19, 1);
		ad.getDriverPassword().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Password textfield accepts input");			
	}
	
	@Test(dependsOnMethods = "TC_054AssetsDrivers_PasswordwithInput")
	public void TC_055AssetsDrivers_Passwordwithalphabets() throws EncryptedDocumentException, IOException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 19, 2);
		ad.getDriverPassword().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Password textfield accepts alphabets");			
	}
	
	@Test(dependsOnMethods = "TC_055AssetsDrivers_Passwordwithalphabets")
	public void TC_056AssetsDrivers_Passwordwithnumbers() throws EncryptedDocumentException, IOException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 19, 3);
		ad.getDriverPassword().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Password textfield accepts numbers");			
	}
	
	@Test(dependsOnMethods = "TC_056AssetsDrivers_Passwordwithnumbers")
	public void TC_057AssetsDrivers_Passwordwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 19, 4);
		ad.getDriverPassword().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Password textfield accepts specialcharacters");			
	}
	
	@Test(dependsOnMethods = "TC_057AssetsDrivers_Passwordwithspecialcharacters")
	public void TC_058AssetsDrivers_Passwordwithlessthan8() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 19, 5);
		ad.getDriverPassword().sendKeys(input);
		ad.OctoLoginButton();
		Thread.sleep(30000);
		String errormsg = ad.getPasswordErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO,"Password textfield will not accept less than 8 digits");			
	}
	
	@Test(dependsOnMethods = "TC_058AssetsDrivers_Passwordwithlessthan8")
	public void TC_59AssetsDrivers_Passwordwithmorethan8() throws EncryptedDocumentException, IOException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 19, 6);
		ad.getDriverPassword().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Password textfield will accept more than 8 digits");			
	}
	
	@Test(dependsOnMethods = "TC_59AssetsDrivers_Passwordwithmorethan8")
	public void TC_60AssetsDrivers_PasswordinMaskedForm() throws EncryptedDocumentException, IOException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 19, 1);
		ad.getDriverPassword().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"User is able to see the password in masked form");			
	}
	
	
	@Test(dependsOnMethods = "TC_60AssetsDrivers_PasswordinMaskedForm")
	public void TC_061AssetsDrivers_PasswordinUnmaskedForm() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		ad.getPasswordVisibility().click();
		String input = elib.getDataFromExcel("Drivers", 19, 1);
		ad.getDriverPassword().sendKeys(input);
		Thread.sleep(3000);
		ad.getPasswordVisibility().click();
		Thread.sleep(2000);
		ad.getPasswordVisibility().click();
		utilityclassobject.gettest().log(Status.INFO,"User is able to see the password in ummasked form");			
	}
	
	@Test(dependsOnMethods = "TC_061AssetsDrivers_PasswordinUnmaskedForm")
	public void TC_062AssetsDrivers_PasswordwithoutInput() throws InterruptedException, EncryptedDocumentException, IOException
	{
		ad.getDriverPassword().click();
		ad.getDriverPassword().sendKeys(Keys.CONTROL + "a");
		ad.getDriverPassword().sendKeys(Keys.DELETE);
		ad.getPasswordVisibility().click();
		ad.OctoLoginButton();
		Thread.sleep(3000);
		String errormsg = ad.getPasswordMandatoryErmsg().getText();
		System.out.println(errormsg);
		
		Thread.sleep(2000);
		ad.getDriverPassword().click();
		String input = elib.getDataFromExcel("Drivers", 19, 1);
		ad.getDriverPassword().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Password without input displayed error message");			
	}
	
	/*@Test(dependsOnMethods = "TC_062AssetsDrivers_PasswordwithoutInput")
	public void TC_063AssetsDrivers_DateofBirthWithInput()
	{
		ad.DateofBirthCalendarwithInput();
		utilityclassobject.gettest().log(Status.INFO,"Date of birth field will not accept input");			
	}

	@Test(dependsOnMethods = "TC_062AssetsDrivers_PasswordwithoutInput")
	public void TC_064AssetsDrivers_CalendarwithDate()
	{
		ad.DateofbirthwithDate();
		utilityclassobject.gettest().log(Status.INFO,"user is able to select the date from the calendar");			

	}
	
	@Test(dependsOnMethods = "TC_064AssetsDrivers_CalendarwithDate")
	public void TC_065AssetsDrivers_CalendarwithYear()
	{
		ad.DateofbirthwithYear();
		utilityclassobject.gettest().log(Status.INFO,"user is able to select the year from the calendar");			
	}
	
	@Test(dependsOnMethods = "TC_065AssetsDrivers_CalendarwithYear")
	public void TC_066AssetsDrivers_calendarwithMonth()
	{
		ad.DateofbirthwithMonth();
		utilityclassobject.gettest().log(Status.INFO,"user is able to select the month from the calendar");			
	}*/
	
	@Test(dependsOnMethods = "TC_062AssetsDrivers_PasswordwithoutInput")
	public void TC_067AssetsDrivers_DriverlicensewithInput() throws EncryptedDocumentException, IOException
	{
		ad.DriverLicense();
		ad.getDriverlicense().click();
		ad.getDriverlicense().sendKeys(Keys.CONTROL + "a");
		ad.getDriverlicense().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 22, 1);
		ad.getDriverlicense().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Driver license number textfield will accept input");			
	}
	
	@Test(dependsOnMethods = "TC_067AssetsDrivers_DriverlicensewithInput")
	public void TC_068AssetsDrivers_Driverlicensewithalphabets() throws EncryptedDocumentException, IOException
	{
		ad.getDriverlicense().click();
		ad.getDriverlicense().sendKeys(Keys.CONTROL + "a");
		ad.getDriverlicense().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 22, 2);
		ad.getDriverlicense().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Driver license number textfield will accept alphabets");			
	}
	
	@Test(dependsOnMethods = "TC_068AssetsDrivers_Driverlicensewithalphabets")
	public void TC_069Assets0Drivers_DriverlicensewithNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getDriverlicense().click();
		ad.getDriverlicense().sendKeys(Keys.CONTROL + "a");
		ad.getDriverlicense().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 22, 3);
		ad.getDriverlicense().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Driver license number textfield will accept numbers");			
	}
	
	@Test(dependsOnMethods = "TC_069AssetsDrivers_DriverlicensewithNumbers")
	public void TC_070AssetsDrivers_DriverlicensewithSpecailcharacters() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ad.getDriverlicense().click();
		ad.getDriverlicense().sendKeys(Keys.CONTROL + "a");
		ad.getDriverlicense().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 22, 4);
		ad.getDriverlicense().sendKeys(input);
		Thread.sleep(2000);
		ad.getDriverlicense().click();
		ad.getDriverlicense().sendKeys(Keys.CONTROL + "a");
		ad.getDriverlicense().sendKeys(Keys.DELETE);
		String input1 = elib.getDataFromExcel("Drivers", 22, 1);
		ad.getDriverlicense().sendKeys(input1);
		utilityclassobject.gettest().log(Status.INFO,"Driver license number textfield will accept specialcharacters");			
	}
	
	/*@Test(dependsOnMethods = "TC_070AssetsDrivers_DriverlicensewithSpecailcharacters")
	public void TC_071AssetsDrivers_licenseExpirationwithInput()
	{
		
	}*/
	
	/*@Test(dependsOnMethods = "TC_070AssetsDrivers_DriverlicensewithSpecailcharacters")
	public void TC_072AssetsDrivers_licenseExpirationCalendarDate() throws InterruptedException
	{
		/*WebElement newdriver = driver.findElement(By.xpath("//div[contains(text(),'100061')]"));
		Actions act = new Actions(driver);
		act.moveToElement(newdriver).click().perform();
		ad.LicenseExpiratiowithDate();
		Thread.sleep(20000);
		utilityclassobject.gettest().log(Status.INFO,"User is able to select date from the license Expiration calendar");			
	}
	
	/*@Test(dependsOnMethods = "TC_072AssetsDrivers_licenseExpirationCalendarDate")
	public void TC_073AssetsDrivers_licenseExpirationCalendarYear()
	{
		/*WebElement newdriver = driver.findElement(By.xpath("//div[contains(text(),'100062')]"));
	
		Actions act = new Actions(driver);
		act.moveToElement(newdriver).click().perform();
		ad.LicenseExpirationwithYear();
		utilityclassobject.gettest().log(Status.INFO,"User is able to select Year from the license Expiration calendar");			
	}

	
	@Test(dependsOnMethods = "TC_072AssetsDrivers_licenseExpirationCalendarDate")
	public void TC_074AssetsDriver_licenseExpirationCalendarMonth()
	{
		ad.licenseExpirationwithDate();
		utilityclassobject.gettest().log(Status.INFO,"User is able to select month from the license Expiration calendar");			

	}*/
	
	
	//need to change the dependeancy
	
	@Test(dependsOnMethods = "TC_070AssetsDrivers_DriverlicensewithSpecailcharacters")
	public void TC_075AssetsDrivers_EmgcontactpersonInput() throws EncryptedDocumentException, IOException
	{	
		ad.getEmgcontactperson().click();
		ad.getEmgcontactperson().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactperson().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 25, 1);
		ad.getEmgcontactperson().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact person text filed accept input");			
	}
	
	@Test(dependsOnMethods = "TC_075AssetsDrivers_EmgcontactpersonInput")
	public void TC_076AssetsDrivers_EmgcontactpersonAlphabets() throws EncryptedDocumentException, IOException
	{
		ad.getEmgcontactperson().click();
		ad.getEmgcontactperson().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactperson().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 25, 2);
		ad.getEmgcontactperson().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact person text filed accept alphabets");			
	}
	
	@Test(dependsOnMethods = "TC_076AssetsDrivers_EmgcontactpersonAlphabets")
	public void TC_077AssestsDrivers_EmgcontactpersonNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getEmgcontactperson().click();
		ad.getEmgcontactperson().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactperson().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 25, 3);
		ad.getEmgcontactperson().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact person text filed accept numbers");			
	}
	
	@Test(dependsOnMethods = "TC_077AssestsDrivers_EmgcontactpersonNumbers")
	public void TC_078AssetsDrivers_Emgcontactpersonspecailcharacters() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ad.getEmgcontactperson().click();
		ad.getEmgcontactperson().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactperson().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 25, 4);
		ad.getEmgcontactperson().sendKeys(input);
		
		Thread.sleep(2000);
		ad.getEmgcontactperson().click();
		ad.getEmgcontactperson().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactperson().sendKeys(Keys.DELETE);
		String input1 = elib.getDataFromExcel("Drivers", 25, 1);
		ad.getEmgcontactperson().sendKeys(input1);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact person text filed accept specialcharacters");			
	}
	
	@Test(dependsOnMethods = "TC_078AssetsDrivers_Emgcontactpersonspecailcharacters")
	public void TC_079AssetsDrivers_EmgcontactPhoneInput() throws EncryptedDocumentException, IOException
	{
		ad.getEmgcontactPhone().click();
		ad.getEmgcontactPhone().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 28, 1);
		ad.getEmgcontactPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Phone text filed accept numbers");			
	}
	
	@Test(dependsOnMethods = "TC_079AssetsDrivers_EmgcontactPhoneInput")
	public void TC_080AssetsDrivers_EmgcontactPhonespecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getEmgcontactPhone().click();
		ad.getEmgcontactPhone().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 28, 2);
		ad.getEmgcontactPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Phone text filed will not accept specialcharacters");			
	}
	
	@Test(dependsOnMethods = "TC_080AssetsDrivers_EmgcontactPhonespecialcharacters")
	public void TC_081AssestsDrivers_EmgcontactPhonemorethan10() throws EncryptedDocumentException, IOException
	{
		ad.getEmgcontactPhone().click();
		ad.getEmgcontactPhone().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 28, 3);
		ad.getEmgcontactPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Phone text filed will not accept more than 10 digits");			
	}
	
	@Test(dependsOnMethods = "TC_081AssestsDrivers_EmgcontactPhonemorethan10")
	public void TC_082AssetsDrivers_EmgcontactPhoneshortInput() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ad.getEmgcontactPhone().click();
		ad.getEmgcontactPhone().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 28, 4);
		ad.getEmgcontactPhone().sendKeys(input);
		Thread.sleep(2000);
		ad.getEmgExt().click();
		ad.getEmgExt().sendKeys(Keys.CONTROL + "a");
		ad.getEmgExt().sendKeys(Keys.DELETE);
		String errormsg = ad.getEmgcontactPhoneErmsg().getText();
		System.out.println(errormsg);
		Thread.sleep(2000);
		
		ad.getEmgcontactPhone().click();
		ad.getEmgcontactPhone().sendKeys(Keys.CONTROL + "a");
		ad.getEmgcontactPhone().sendKeys(Keys.DELETE);
		String input1 = elib.getDataFromExcel("Drivers", 28, 1);
		ad.getEmgcontactPhone().sendKeys(input1);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Phone text filed will not accept short input");			
	}
	
	@Test(dependsOnMethods = "TC_082AssetsDrivers_EmgcontactPhoneshortInput")
	public void TC_083AssetsDrivers_EmgextwithInput() throws EncryptedDocumentException, IOException
	{
		ad.getEmgExt().click();
		ad.getEmgExt().sendKeys(Keys.CONTROL + "a");
		ad.getEmgExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 31, 1);
		ad.getEmgExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Ext text filed accepts input");			
	}
	
	@Test(dependsOnMethods = "TC_083AssetsDrivers_EmgextwithInput")
	 public void TC_084AssetsDrivers_EmgextwithAlphabets() throws EncryptedDocumentException, IOException
	{
		ad.getEmgExt().click();
		ad.getEmgExt().sendKeys(Keys.CONTROL + "a");
		ad.getEmgExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 31, 2);
		ad.getEmgExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Ext text filed will not accept input");			
	}
	
	@Test(dependsOnMethods = "TC_084AssetsDrivers_EmgextwithAlphabets")
	public void TC_085AssetsDrivers_EmgextwithNumbers() throws EncryptedDocumentException, IOException
	{
		ad.getEmgExt().click();
		ad.getEmgExt().sendKeys(Keys.CONTROL +"a");
		ad.getEmgExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 31, 3);
		ad.getEmgExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Ext text filed accept numbers");			
	}
	
	@Test(dependsOnMethods = "TC_085AssetsDrivers_EmgextwithNumbers")
	public void TC_086AssetsDrivers_Emgextwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getEmgExt().click();
		ad.getEmgExt().sendKeys(Keys.CONTROL + "a");
		ad.getEmgExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 31, 4);
		ad.getEmgExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Ext text filed will not accept specialcharacters");			
	}
	
	@Test(dependsOnMethods = "TC_086AssetsDrivers_Emgextwithspecialcharacters")
	public void TC_087AssetsDrivers_Emgextmorethan5digits() throws EncryptedDocumentException, IOException
	{
		ad.getEmgExt().click();
		ad.getEmgExt().sendKeys(Keys.CONTROL + "a");
		ad.getEmgExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 31, 5);
		ad.getEmgExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Ext text filed will not accept more than 5 digits");			
	}
	
	@Test(dependsOnMethods = "TC_087AssetsDrivers_Emgextmorethan5digits")
	public void TC_088AssetsDrivers_EmgextwithshortInput() throws EncryptedDocumentException, IOException
	{
		ad.getEmgExt().click();
		ad.getEmgExt().sendKeys(Keys.CONTROL + "a");
		ad.getEmgExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 31, 6);
		ad.getEmgExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Emergency contact Ext text filed will not accept more than 5 digits");			
	}
	
	@Test(dependsOnMethods = "TC_088AssetsDrivers_EmgextwithshortInput")
	public void TC_089AssetsDrivers_DriverlistLocationwithInput()
	{
		
		ad.DriverlistLocationInput();
		utilityclassobject.gettest().log(Status.INFO,"Driver location Assignement will not accept input");			

	}
	
	@Test(dependsOnMethods = "TC_089AssetsDrivers_DriverlistLocationwithInput")
	public void TC_090AssetsDrivers_DriverListlocation()
	{
		ad.DriverlistLocation();
		utilityclassobject.gettest().log(Status.INFO,"Driver location Assignment is displayed along with the location");			
	}
	
	@Test(dependsOnMethods = "TC_090AssetsDrivers_DriverListlocation")
	public void TC_091AssetsDrivers_DriverlistUncheck() throws InterruptedException
	{
		ad.DriverListlocationUncheck();
		utilityclassobject.gettest().log(Status.INFO,"User is able to uncheck the driver location from the dropdown");	
	}
	  
	@Test(dependsOnMethods = "TC_091AssetsDrivers_DriverlistUncheck")
	public void TC_092AssetsDrivers_DriverlistCheck() throws InterruptedException
	{	
		ad.DriverListLocationCheck();
		utilityclassobject.gettest().log(Status.INFO,"User is able to check the driver location from the dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_092AssetsDrivers_DriverlistCheck")
	public void TC_093AssetsDrivers_DriverremoveLocation() throws InterruptedException
	{
		ad.DriverlistremoveLocation();
		utilityclassobject.gettest().log(Status.INFO,"User is able to remove the driver location from the dropdown");			

	}
	
	//need to add the dependency
	/*@Test
	public void TC_097AssetsDrivers_StartDatewithInput()
	{
		
	}*/
	
	/*@Test(dependsOnMethods = "TC_070AssetsDrivers_DriverlicensewithSpecailcharacters")
	public void TC_098AssetsDrivers_StardatewithDate()
	{
		ad.StartDatewithDate();
		utilityclassobject.gettest().log(Status.INFO,"User is able to select the date from the start date calendar");			
	}
	
	@Test(dependsOnMethods = "TC_098AssetsDrivers_StardatewithDate")
	public void TC_099AssetsDrivers_StartdatewithYear()
	{
		ad.StartDatewithYear();
	
		utilityclassobject.gettest().log(Status.INFO,"User is able to select the year from the start date calendar");			

	}
	
	//need to add the dependency
	@Test
	public void TC_100AssetsDrivers_StartdatewithMonth()
	{			

	}*/
	
	
	@Test(dependsOnMethods = "TC_093AssetsDrivers_DriverremoveLocation")
	public void TC_101AssetsDrivers_HourlywagewithInput() throws EncryptedDocumentException, IOException
	{
		ad.getHourlywage().click();
		ad.getHourlywage().sendKeys(Keys.CONTROL + "a");
		ad.getHourlywage().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 34, 1);
		ad.getHourlywage().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Hourly wage text field will accept input");			
	}
	
	@Test(dependsOnMethods = "TC_101AssetsDrivers_HourlywagewithInput")
	public void TC_102AssetsDrivers_Hourlywagewithnumbers() throws EncryptedDocumentException, IOException
	{
		ad.getHourlywage().click();
		ad.getHourlywage().sendKeys(Keys.CONTROL + "a");
		ad.getHourlywage().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 34, 2);
		ad.getHourlywage().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Hourly wage text field will accept numbers");			
	}
	
	@Test(dependsOnMethods = "TC_102AssetsDrivers_Hourlywagewithnumbers")
	public void TC_103AssetsDrivers_Hourlywagewithalphabets() throws EncryptedDocumentException, IOException
	{
		ad.getHourlywage().click();
		ad.getHourlywage().sendKeys(Keys.CONTROL + "a");
		ad.getHourlywage().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 34, 3);
		ad.getHourlywage().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Hourly wage text field will not accept alphabets");			
	}
	
	@Test(dependsOnMethods = "TC_103AssetsDrivers_Hourlywagewithalphabets")
	public void TC_104AssetsDrivers_Hourlywagewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getHourlywage().click();
		ad.getHourlywage().sendKeys(Keys.CONTROL + "a");
		ad.getHourlywage().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 34, 4);
		ad.getHourlywage().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,"Hourly wage text field will not accept specialcharacters");			
	}
	
	@Test(dependsOnMethods = "TC_104AssetsDrivers_Hourlywagewithspecialcharacters")
	public void TC_105AssetsDrivers_DaysscheduledwithInput()
	{
		ad.DaysScheduledtoWork();
		utilityclassobject.gettest().log(Status.INFO,"Scheduled work day dropdown will not accept input");			

	}
	
	@Test(dependsOnMethods = "TC_105AssetsDrivers_DaysscheduledwithInput")
	public void TC_106AssetsDrivers_DayascheduledDropdown() throws InterruptedException
	{
		ad.getScheduledworkday().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO,"when user click on the Scheduled work day dropdown will open");			
	}
	
	@Test(dependsOnMethods = "TC_106AssetsDrivers_DayascheduledDropdown")
	public void TC_107AssetsDrivers_Daysscheduleddrpwithdays() throws InterruptedException
	{
		ad.DaysSchediledworkDrpdown();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO,"Days are present in the Scheduled work day dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_107AssetsDrivers_Daysscheduleddrpwithdays") 
	public void TC_108AssetsDrivers_ScheduledworkdrpwithDays() throws InterruptedException
	{
		ad.DaysSchedulewithDays();
		utilityclassobject.gettest().log(Status.INFO,"User is able to select the weekdays from the dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_108AssetsDrivers_ScheduledworkdrpwithDays")
	public void TC_109AssetsDrivers_ScheduledworkdrpMultipleDays() throws InterruptedException
	{
		ad.ScheduledworkwithMultipleDays();
		utilityclassobject.gettest().log(Status.INFO,"User is able to select the Multiple weekdays from the dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_109AssetsDrivers_ScheduledworkdrpMultipleDays")
	public void TC_110AssetsDrivers_ScheduledworkdrpUnselect() throws InterruptedException
	{
		ad.ScheduledworkwithUnselect();
		utilityclassobject.gettest().log(Status.INFO,"User is able to unselect the weekdays from the dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_110AssetsDrivers_ScheduledworkdrpUnselect")
	public void TC_111AssestsDrivers_ScheduledWorkday() throws InterruptedException
	{
		Thread.sleep(2000);
		ad.ScheduledworkwithMultipleDays();
		Thread.sleep(20000);
		ad.ScheduledworkdaywithDays();
		utilityclassobject.gettest().log(Status.INFO,"Selected weekdays are visible in the field");			
	}
	
	@Test(dependsOnMethods = "TC_111AssestsDrivers_ScheduledWorkday")
	public void TC_112AssetsDrivers_ScheduledworkdayRemove() throws InterruptedException
	{
		ad.ScheduledworkwithUnselect();
		utilityclassobject.gettest().log(Status.INFO,"Selected weekdays are removed from the field");			

	}
	
	@Test(dependsOnMethods = "TC_112AssetsDrivers_ScheduledworkdayRemove")
	public void TC_113AssetsDrivers_ZebrprintingwithInput()
	{
		ad.ZebraPrinting();
		utilityclassobject.gettest().log(Status.INFO,"Zebra printing dropdown field will not accept input");			

	}
	
	@Test(dependsOnMethods = "TC_113AssetsDrivers_ZebrprintingwithInput")
	public void TC_114AssetsDrivers_Zebraprinting() throws InterruptedException
	{
		ad.getZebraPrintingField().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO,"Zebra printing dropdown will open");			

	}
	
	@Test(dependsOnMethods = "TC_114AssetsDrivers_Zebraprinting") 
	public void TC_115AssetsDrivers_ZebraprintingwithOptions()
	{
		ad.ZebraPrintingwithOption();
		utilityclassobject.gettest().log(Status.INFO,"Options are present in the Zebra printing dropdown");			
	}
	
	@Test(dependsOnMethods = "TC_115AssetsDrivers_ZebraprintingwithOptions")
	public void TC_116AssetsDrivers_Zebraprintingselectoption() throws InterruptedException
	{
		ad.ZebraprintingwithSelection();
		utilityclassobject.gettest().log(Status.INFO,"user is able to select the options from the Zebra printing dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_116AssetsDrivers_Zebraprintingselectoption")
	public void TC_117AssetsDrivers_ZebraprintingwithMultipleoption()
	{
		ad.ZebraprintingwithMultiple();
		utilityclassobject.gettest().log(Status.INFO,"user is not able to select the multiple options from the Zebra printing dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_117AssetsDrivers_ZebraprintingwithMultipleoption")
	public void TC_118AssetsDrivers_ZebraprintingOntheroption() throws InterruptedException
	{
		ad.Zebraprintingwithontheroption();
		utilityclassobject.gettest().log(Status.INFO,"user is not able to select the onther options from the Zebra printing dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_118AssetsDrivers_ZebraprintingOntheroption")
	public void TC_119AssetsDrivers_ZebraPrintingwithselectedoption()
	{
		ad.Zebraprinting();
		utilityclassobject.gettest().log(Status.INFO,"selected is shown up in the zebraprinting dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_119AssetsDrivers_ZebraPrintingwithselectedoption")
	public void TC_120AssetsDrivers_DutystatuswithInput()
	{
		ad.DutyStatus();
		utilityclassobject.gettest().log(Status.INFO,"Duty status dropdwon will not accept input");			

	}
	
	@Test(dependsOnMethods = "TC_120AssetsDrivers_DutystatuswithInput")
	public void TC_121AssetsDrivers_DutyStatus() throws InterruptedException
	{
		ad.getDutystatus().click();
		ad.getDutystatus().click();
		Thread.sleep(2000);
		ad.getDutystatus().click();
		utilityclassobject.gettest().log(Status.INFO,"Duty status dropdwon will appear when the arrow is clicked");			

	}
	
	@Test(dependsOnMethods = "TC_121AssetsDrivers_DutyStatus")
	public void TC_122AssetsDrivers_DutystatuswithOption()
	{
		ad.DutystatuswithOption();
		utilityclassobject.gettest().log(Status.INFO,"Options are present in the duty status dropdown");			
	}
	
	@Test(dependsOnMethods = "TC_122AssetsDrivers_DutystatuswithOption")
	public void TC_123AssetsDrivers_Dutystatus() throws InterruptedException
	{
		ad.Dutystatuswithclick();
		utilityclassobject.gettest().log(Status.INFO,"User is able to select option from the dropdown");			
	
	}
	
	@Test(dependsOnMethods = "TC_123AssetsDrivers_Dutystatus")
	public void TC_124AssetsDrivers_DutystatuswithMultiple()
	{
		ad.DutystatuswithMultiple();
		utilityclassobject.gettest().log(Status.INFO,"User is not able to select more than one option from the dropdown");			
	}
	
	@Test(dependsOnMethods = "TC_124AssetsDrivers_DutystatuswithMultiple")
	public void TC_125AssetsDrivers_DutyStatuswithOntheroption() throws InterruptedException
	{
		ad.DutystatuswithChangeinoption();
		utilityclassobject.gettest().log(Status.INFO,"User is able to change the option from the dropdown");			
	}
	
	@Test(dependsOnMethods = "TC_125AssetsDrivers_DutyStatuswithOntheroption")
	public void TC_126AssetsDrivers_Dutystatuswithselectedoption()
	{
		ad.Dutystatuswithselectedoption();
		utilityclassobject.gettest().log(Status.INFO,"Selected option is shown up in the field");			

	}
	
	@Test(dependsOnMethods = "TC_126AssetsDrivers_Dutystatuswithselectedoption")
	public void TC_127AssetsDrivers_DriverstatuswithInput()
	{
		ad.DriverstatuswithInput();
		utilityclassobject.gettest().log(Status.INFO,"Driver status dropdown will not accept input");			
	}
	
	@Test(dependsOnMethods = "TC_127AssetsDrivers_DriverstatuswithInput")
	public void TC_128AssetsDrivers_Driverstatusdrpdown() throws InterruptedException
	{
		ad.getDriverstatus().click();
		Thread.sleep(2000);
		ad.getDriverstatus().click();
		utilityclassobject.gettest().log(Status.INFO,"Driver status dropdown will appear when user click on the arrow");			

	}
	
	@Test(dependsOnMethods = "TC_128AssetsDrivers_Driverstatusdrpdown")
	public void TC_129AssestDrivers_Driverstatuswithoption()
	{
		ad.DriverStatuswithOption();
		utilityclassobject.gettest().log(Status.INFO,"Options are present in the driver status dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_129AssestDrivers_Driverstatuswithoption")
	public void TC_130AssetsDrivers_DriverStatus() throws InterruptedException
	{
		ad.Driverstatusselectedoption();
		utilityclassobject.gettest().log(Status.INFO,"User is able to select the option from dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_130AssetsDrivers_DriverStatus")
	public void TC_131AssetsDriver_DriverstatuswithMultiple()
	{
		ad.DriverstatuswithMultiple();
		utilityclassobject.gettest().log(Status.INFO,"User is not able to select more than option from dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_131AssetsDriver_DriverstatuswithMultiple")
	public void TC_132AssetsDrivers_DriverstatusSelectedoption()
	{
		ad.Driverstatuswithontheroption();
		utilityclassobject.gettest().log(Status.INFO,"User is able to change the option from dropdown");			

	}
	
	@Test(dependsOnMethods = "TC_132AssetsDrivers_DriverstatusSelectedoption")
	public void TC_133AssetsDrivers_DriverstatusSelectedoption()
	{
		ad.Driverwithselectedoption();
		utilityclassobject.gettest().log(Status.INFO,"Driver status dropdown is displayed with selected option");			
	}
	
	@Test(dependsOnMethods = "TC_133AssetsDrivers_DriverstatusSelectedoption")
	public void TC_142AssetsDrivers_OctofieldloginButton()
	{
		ad.OctofieldLoginButton();
		utilityclassobject.gettest().log(Status.INFO,"Send OCTO Field App Login Instructions button is clickable");			

	}
	
	@Test(dependsOnMethods = "TC_142AssetsDrivers_OctofieldloginButton")
	public void TC_143AssetsDrivers_OctofieldloginwithEmail()
	{
		ad.OctofieldLoginButton();
		utilityclassobject.gettest().log(Status.INFO,"details are send to the driver via email");			
	}
	
	@Test(dependsOnMethods = "TC_143AssetsDrivers_OctofieldloginwithEmail")
	public void TC_144AssetsDrrivers_FieldappaccesswithOption()
	{
		ad.OctoFieldappaccesswithOption();
		utilityclassobject.gettest().log(Status.INFO,"Octo field app access options are present");			

	}
	
	@Test(dependsOnMethods = "TC_144AssetsDrrivers_FieldappaccesswithOption")
	public void TC_145AssetsDrivers_Fieldappaccesswithselectedoptions() throws InterruptedException
	{
		ad.Octofieldappwithselectedoptions();
		utilityclassobject.gettest().log(Status.INFO,"user is able to select the options");			

	}
	
	@Test(dependsOnMethods = "TC_145AssetsDrivers_Fieldappaccesswithselectedoptions")
	public void TC_146AssetsDrivers_Fieldappaccesswithunselectedoptions() throws InterruptedException
	{
		ad.Octofieldappwithunselectedoptions();
		utilityclassobject.gettest().log(Status.INFO,"user is able to unselect the options");			

	}
	
	@Test(dependsOnMethods = "TC_146AssetsDrivers_Fieldappaccesswithunselectedoptions")
	public void TC_147AssetsDrivers_Fieldappaccesswithcalloption() throws InterruptedException
	{
		ad.OctofieldappwithCalloption();
		utilityclassobject.gettest().log(Status.INFO,"user is able to select either one of the option");			

	}
	
	@Test(dependsOnMethods = "TC_147AssetsDrivers_Fieldappaccesswithcalloption")
	public void TC_148AssetsDrivers_FieldappaccesswithEmailoption() throws InterruptedException
	{
		ad.OctofieldappwithEmailoption();
		utilityclassobject.gettest().log(Status.INFO,"user is able to unselect either one of the option");			

	}
	
	@Test(dependsOnMethods = "TC_148AssetsDrivers_FieldappaccesswithEmailoption")
	public void TC_149AssetsDrivers_Savebutton()
	{
		ad.Savebutton();
		utilityclassobject.gettest().log(Status.INFO,"user is able to save the details by clicking on the save buuton");			
	}
	
	@Test(dependsOnMethods = "TC_149AssetsDrivers_Savebutton")
	public void TC_150AssetsDrivers_DriverList() throws InterruptedException
	{
		ad.Driverlist();
		utilityclassobject.gettest().log(Status.INFO,"The user is able redirected to the driver's list");			

	}
	
	@Test(dependsOnMethods = "TC_150AssetsDrivers_DriverList")
	public void TC_151AssetsDrivers_withaddedDriver() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement addeddriver = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[contains(text(),'"+octoid+"')]")));
		System.out.println(addeddriver);
	    Assert.assertTrue(addeddriver.isDisplayed(), "addeddriver is displayed");
		utilityclassobject.gettest().log(Status.INFO,"Added driver is displayed");			
	}
	
	@Test(dependsOnMethods = "TC_151AssetsDrivers_withaddedDriver")
	public void TC_152AssetsDriver_withActivestatus() throws InterruptedException
	{
		ad.DriverswithActivestatus();
		utilityclassobject.gettest().log(Status.INFO,"The active driver status are shown in the driverlist ");			
	}
	
	@Test(dependsOnMethods = "TC_152AssetsDriver_withActivestatus")
	public void TC_153AssetsDrivers_withInactivestatus() throws InterruptedException
	{
		ad.DriverswithInactivestatus();
		utilityclassobject.gettest().log(Status.INFO,"The Inactive driver status are shown in the driverlist ");			
	}
	
	//need to add the list
	@Test(dependsOnMethods = "TC_153AssetsDrivers_withInactivestatus")
	public void TC_154AssestsDriver_withExport() throws InterruptedException
	{
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search options...']"));
		search.sendKeys(Keys.CONTROL + "a");
		search.sendKeys(Keys.DELETE);
		search.sendKeys("Active");
		ad.getListedActivestatus().click();
		webDriverutility wlib = new webDriverutility();
		WebElement addeddriver = driver.findElement(By.xpath("//div[contains(text(),'"+octoid+"')]"));
		wlib.scrollToelement(driver, addeddriver);
		Thread.sleep(2000);
	    Assert.assertTrue(addeddriver.isDisplayed(), "addeddriver is displayed");
	    Thread.sleep(2000);
	    WebElement checkbox = driver.findElement(By.xpath("//div[contains(text(),'"+octoid+"')]/ancestor::a//input[@type='checkbox']"));
	    checkbox.click();
	    ad.getExportCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,"The user is able to export the details of the driver selected/list");			

	}
	
	@Test(dependsOnMethods = "TC_154AssestsDriver_withExport")
	public void TC_155AssetsDrivers_WithName() throws InterruptedException
	{
		webDriverutility wlib = new webDriverutility();
		WebElement addeddriver = driver.findElement(By.xpath("//div[contains(text(),'"+octoid+"')]"));
		wlib.scrollToelement(driver, addeddriver);
		Thread.sleep(2000);
	    Assert.assertTrue(addeddriver.isDisplayed(), "addeddriver is displayed");
	    Thread.sleep(2000);
		WebElement addeddrivername = driver.findElement(By.xpath("//div[contains(text(),'"+octoid+"')]/ancestor::a//div[contains (text(),'"+firstnameinput+" K reddy')]"));
		System.out.println(addeddrivername);
	    Assert.assertTrue(addeddrivername.isDisplayed(), "addeddriver name is displayed in the list");
		utilityclassobject.gettest().log(Status.INFO,"Added driver name is displayed in the driverlist");			

	}
	
	@Test(dependsOnMethods = "TC_155AssetsDrivers_WithName")
	public void TC_156AssetsDrivers_withOctoID()
	{
		
		List<WebElement> octoidnumbers = driver.findElements(By.xpath("//div[@class='truncate w-32']"));
		 for(WebElement octoidnumber:octoidnumbers)
		 {
			 if (octoidnumber.getText().trim().equals(octoid.trim()))
		  {
			  System.out.println("octoidnumber is verified");
			utilityclassobject.gettest().log(Status.INFO,"OctoID is verified successfully");			

		  }  
		  else {
			  System.out.println("octoidnumber is not verified");
			utilityclassobject.gettest().log(Status.INFO,"OctoID is not verified successfully");			

		  }
		 }
		utilityclassobject.gettest().log(Status.INFO,"Added driver OctoID is displayed in the driverlist");			

	}
	
	@Test(dependsOnMethods = "TC_156AssetsDrivers_withOctoID")
	public void TC_157AssetsDrivers_Withphonenumber()
	{

		WebElement addeddriverphone = driver.findElement(By.xpath("//div[contains(text(),'"+octoid+"')]/ancestor::a//span[contains (text(),'"+phone+"')]"));
	    Assert.assertTrue(addeddriverphone.isDisplayed(), "addeddriver name is displayed in the list");
		utilityclassobject.gettest().log(Status.INFO,"Added driver Phonenumber is displayed in the driverlist");			

	}
	
	@Test(dependsOnMethods = "TC_157AssetsDrivers_Withphonenumber")
	public void TC_158AssetsDriver_withEmail()
	{
		ad.DriverswithEmail();
		utilityclassobject.gettest().log(Status.INFO,"Added driver Phonenumber is displayed in the driverlist");			

	}
	
	@Test(dependsOnMethods = "TC_158AssetsDriver_withEmail")
	public void TC_159AssetsDriver_withLocation()
	{
		WebElement addeddrivelocation = driver.findElement(By.xpath("//div[contains(text(),'"+octoid+"')]/ancestor::a//div[contains(@class,'truncate w-60')]//p"));
	    Assert.assertTrue(addeddrivelocation.isDisplayed(), "addeddriver name is displayed in the list");
		utilityclassobject.gettest().log(Status.INFO,"Added driver Driverloction is displayed in the driverlist");			

		
		
	}
	
	@Test(dependsOnMethods = "TC_159AssetsDriver_withLocation")
	public void TC_160AssetsDriver_withDriverstatus()
	{
		WebElement addeddrivestatus = driver.findElement(By.xpath("//div[contains(text(),'"+octoid+"')]/ancestor::a//div[contains (text(),'active')]"));
	    Assert.assertTrue(addeddrivestatus.isDisplayed(), "addeddriver name is displayed in the list");
		utilityclassobject.gettest().log(Status.INFO,"Added driver driverstatus is displayed in the driverlist");			

	}
	
	
}
	
	
	
	
	
	
	
	
	
		
	

	
	
	
	

 