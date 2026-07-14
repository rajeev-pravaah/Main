package Drivers;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseclassforDrivers;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AssestsDrivers;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_001toTC_050Drivers extends BaseclassforDrivers {
	AssestsDrivers ad;
	ExcelUtility elib;

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
		String firstnameinput = elib.getDataFromExcel("Drivers", 1, 1);
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
		String email = emailInput + randomnumber + "@gmail.com";
		ad.getEmailField().sendKeys(email);
		ad.NewDriverLocation();
		Thread.sleep(2000);
		ad.Driverstatus();
		Thread.sleep(2000);
		ad.AddnewDriver();
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
		ad.getDriverFirstname().sendKeys("arjun");
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
		utilityclassobject.gettest().log(Status.INFO,"Phone Text field will accept numbers");			
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
		Thread.sleep(3000);
		ad.OctoLoginButton();
		String errormsg = ad.getPhonetextErmsg().getText();
		System.out.println(errormsg);
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
	

}
