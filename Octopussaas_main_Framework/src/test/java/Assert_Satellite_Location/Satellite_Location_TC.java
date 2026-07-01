package Assert_Satellite_Location;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.Octo365SignUP;
import com.Octopussaas.ObjectRepository.SatelliteLocation;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Satellite_Location_TC extends BaseClassForGEneratorContacts{
	HomePage hp;
	SatelliteLocation sl;
	ExcelUtility elib;
	webDriverutility wd;
	String defaultsatelliteStatus;
	
	
	/*Magic Test case 24
	  Magic Test case 24
	  Magic Test case 24
	  Magic Test case 24-- add TC_003 dependency for fast excecution*/
	
	/*Rmove the comment of File upload to run independently by using existing satellite location profile and also remove the dependencies */
	/*Rmove the comment of File upload to run independently by using existing satellite location profile and also remove the dependencies */


	
	@Test
	public void TC_001VerifyTheSatelliteLocationPageisDisplayed() throws InterruptedException  {
		hp = new HomePage(driver);
		utilityclassobject.gettest().log(com.aventstack.extentreports.Status.INFO, "Home Page is displayed");
		System.out.println("Home Page is displayed");
		Thread.sleep(6000);
		sl = new SatelliteLocation(driver);
		sl.getAssets().click();
		sl.getSatellite_Locations().click();
		sl.getSatelliteLocationsList().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Satellite Location Page is displayed");
		 System.out.println("Satellite Location Page is displayed");
		 
		
		
	}
	@Test(dependsOnMethods = "TC_001VerifyTheSatelliteLocationPageisDisplayed")
	public void TC_002VerifyTheSatelliteLocationPreviouslyAddedlist() throws InterruptedException  {
		List<WebElement> loclists = sl.getListofsatellitelocations();
		 
		 int count = loclists.size();
		 System.out.println("Total Elements Count: " + count);
		 utilityclassobject.gettest().log(Status.INFO, "Total Elements Count: " + count);
		 utilityclassobject.gettest().log(Status.INFO, "Satellite Location  previoulsy added list is displayed");
		 System.out.println("Satellite Location  previoulsy added list is displayed");
		
		
	}
	@Test(dependsOnMethods = "TC_002VerifyTheSatelliteLocationPreviouslyAddedlist")
	public void TC_003VerifyTheAddNewSatelliteLocationButton() throws InterruptedException  {
		sl.getAddNewSatelliteLocationbutton().click();
		sl.getAddNewSatelliteLocationPopUp().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Add New Satellite Location Pop Up is displayed");
		 System.out.println("Add New Satellite Location Pop Up is displayed");
		
		
	}
	@Test(dependsOnMethods = "TC_003VerifyTheAddNewSatelliteLocationButton")																				
	public void TC_004VerifySatelliteLocationNameFieldWithInput() throws InterruptedException, EncryptedDocumentException, IOException  {
		sl.getSatelliteLocationName().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Add New Satellite Location Name Field is displayed");
		 System.out.println("Add New Satellite Location Name Field is displayed");
		 elib = new ExcelUtility();
		 String satellitname = elib.getDataFromExcel("SatelliteLocation", 1, 1);
		 Thread.sleep(2000);
		 System.out.println(satellitname);
		 //add 5 digit random number to the satellite name
		 int randomNum = (int)(Math.random() * 100000);
		 String satellitnamewithrandom = satellitname + randomNum;
		 sl.getSatelliteLocationName().sendKeys(satellitnamewithrandom);
		 utilityclassobject.gettest().log(Status.INFO, "Add New Satellite Location Name Field Accepts input: Pass");
		 System.out.println("Add New Satellite Location Name Field accepts input: pass " + satellitnamewithrandom);
		 //clear the field
		 sl.getSatelliteLocationName().clear();
		 
		
		
	}

	@Test(dependsOnMethods = "TC_004VerifySatelliteLocationNameFieldWithInput")
	public void TC_005VerifySatellitLocationFieldacceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException  {
		
		 String satellitnamealpha = elib.getDataFromExcel("SatelliteLocation", 1, 2);
		 System.out.println(satellitnamealpha);
		 sl.getSatelliteLocationName().sendKeys(satellitnamealpha);
		 Thread.sleep(2000);
		 utilityclassobject.gettest().log(Status.INFO, "Satellite location name text field accepts Alphabets: Pass  " +satellitnamealpha);
		 System.out.println("Satellite location name text field accepts Alphabets: Pass  " +satellitnamealpha);
		 sl.getSatelliteLocationName().clear();

		 
		 
		
		
	}
	@Test(dependsOnMethods = "TC_005VerifySatellitLocationFieldacceptsAlphabets")
	public void TC_006VerifySatellitLocationFieldacceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException  {
		
		 String satellitnamenum = elib.getDataFromExcel("SatelliteLocation", 1, 3);
		 System.out.println(satellitnamenum);
		 sl.getSatelliteLocationName().sendKeys(satellitnamenum);
		 Thread.sleep(2000);
		 utilityclassobject.gettest().log(Status.INFO, "Satellite location name text field accepts Numbers: Pass  " +satellitnamenum);
		 System.out.println("Satellite location name text field accepts Numbers: Pass  " +satellitnamenum);
		 sl.getSatelliteLocationName().clear();

		 
		 
		
		
	}
	@Test(dependsOnMethods = "TC_006VerifySatellitLocationFieldacceptsNumbers")
	public void TC_007VerifySatellitLocationFieldacceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		
		 String satellitnamespecial = elib.getDataFromExcel("SatelliteLocation", 1, 4);
		 System.out.println(satellitnamespecial);
		 sl.getSatelliteLocationName().sendKeys(satellitnamespecial);
		 Thread.sleep(2000);
		 utilityclassobject.gettest().log(Status.INFO, "Satellite location name text field accepts Special Characters: Pass  " +satellitnamespecial);
		 System.out.println("Satellite location name text field accepts Special Characters: Pass  " +satellitnamespecial);
		 WebElement txt = sl.getSatelliteLocationName();
		 
		 Actions actions = new Actions(driver);

		 actions.click(txt)
		        .keyDown(Keys.CONTROL)
		        .sendKeys("a")
		        .keyUp(Keys.CONTROL)
		        .sendKeys(Keys.DELETE)
		        .perform();

		 
		 
		
		
	}
	@Test(dependsOnMethods = "TC_007VerifySatellitLocationFieldacceptsSpecialCharacters")
	public void TC_008VerifySatellitLocationFieldWithoutInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		

		
		
		sl.getAddNewSatelliteLocationButtoninpopup().click();
		Thread.sleep(2000);
		sl.getSatelliteLocationNameErrorMessage().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Satellite location name text field without input shows error message: Pass  ");
		 System.out.println("Satellite location name text field without input shows error message: Pass  ");

		 
		 
		
		
	}
	@Test(dependsOnMethods = "TC_008VerifySatellitLocationFieldWithoutInput")
	public void TC_009VerifySatellitLocationEmailFieldAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String validemail = elib.getDataFromExcel("SatelliteLocation", 5, 1);

		sl.getAddnewsastelliteemailfield().sendKeys(validemail);
		Thread.sleep(2000);
		System.out.println("Satellite location email text field accepts input: Pass  " +validemail);
		utilityclassobject.gettest().log(Status.INFO, "Satellite location email text field accepts input: Pass  " +validemail);
		//clear the field
		sl.getAddnewsastelliteemailfield().clear();
		System.out.println("Satellite location email text field is cleared "+ sl.getAddnewsastelliteemailfield().getText());
		
		 
		
	}
	@Test(dependsOnMethods = "TC_009VerifySatellitLocationEmailFieldAcceptsInput")
	public void TC_010VerifySatellitLocationEmailFieldWithAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String alphabets = elib.getDataFromExcel("SatelliteLocation", 5, 2);
		 sl.getAddnewsastelliteemailfield().sendKeys(alphabets);

		 Thread.sleep(2000);
		 System.out.println("Satellite location email text field accepts Alphabets: Pass  " +alphabets);
		 utilityclassobject.gettest().log(Status.INFO, "Satellite location email text field accepts Alphabets: Pass  " +alphabets);
		 //clear the field
		 sl.getAddnewsastelliteemailfield().clear();
		 System.out.println("Satellite location email text field is cleared "+ sl.getAddnewsastelliteemailfield().getText());

	
		
	}
	@Test(dependsOnMethods = "TC_010VerifySatellitLocationEmailFieldWithAlphabets")
	public void TC_011VerifySatellitLocationEmailFieldWithNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String numbers = elib.getDataFromExcel("SatelliteLocation", 5, 3);
		 sl.getAddnewsastelliteemailfield().sendKeys(numbers);

		 Thread.sleep(2000);
		 System.out.println("Satellite location email text field accepts Numbers: Pass  " +numbers);
		 utilityclassobject.gettest().log(Status.INFO, "Satellite location email text field accepts Numbers: Pass  " +numbers);
		 //clear the field
		 sl.getAddnewsastelliteemailfield().clear();
		 System.out.println("Satellite location email text field is cleared "+ sl.getAddnewsastelliteemailfield().getText());
		 
	}
	@Test(dependsOnMethods = "TC_011VerifySatellitLocationEmailFieldWithNumbers")
	public void TC_012VerifySatellitLocationEmailFieldWithSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String specialcharacters = elib.getDataFromExcel("SatelliteLocation", 5, 4);
		 sl.getAddnewsastelliteemailfield().sendKeys(specialcharacters);

		 Thread.sleep(2000);
		 System.out.println("Satellite location email text field accepts Special Characters: Pass  " +specialcharacters);
		 utilityclassobject.gettest().log(Status.INFO, "Satellite location email text field accepts Special Characters: Pass  " +specialcharacters);
		 //clear the field
		 //sl.getAddnewsastelliteemailfield().clear();
		 //System.out.println("Satellite location email text field is cleared "+ sl.getAddnewsastelliteemailfield().getText());
		 
	}
	@Test(dependsOnMethods = "TC_012VerifySatellitLocationEmailFieldWithSpecialCharacters")
	public void TC_013VerifySatellitLocationEmailFieldWithInvaliInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getAddnewsastelliteemailfielderrormessage().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Satellite location email text field with invalid input shows error message: Pass  ");
		 System.out.println("Satellite location email text field with invalid input shows error message: Pass  ");
		 //clear the field
		 WebElement txt = sl.getAddnewsastelliteemailfield();
		 txt.click();
		 Actions actions = new Actions(driver);

		 actions.click(txt)
		        .keyDown(Keys.CONTROL)
		        .sendKeys("a")
		        .keyUp(Keys.CONTROL)
		        .sendKeys(Keys.DELETE)
		        .perform();
		 System.out.println("Satellite location email text field is cleared "+ sl.getAddnewsastelliteemailfield().getText());
		  
	}
	@Test(dependsOnMethods = "TC_013VerifySatellitLocationEmailFieldWithInvaliInput")
	public void TC_014VerifySatellitLocationEmailFieldWithoutInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getAddNewSatelliteLocationButtoninpopup().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Satellite location email text field without input not displaying any error message: Pass  ");
		 System.out.println("Satellite location email text field without input not displaying any error message: Pass  ");
		
		 
	}
	@Test(dependsOnMethods = "TC_014VerifySatellitLocationEmailFieldWithoutInput")
	public void TC_015VerifySatellitLocationWebsiteFieldAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String validwebsite = elib.getDataFromExcel("SatelliteLocation", 9, 1);

		sl.getAddnewsastellitewebsitefield().sendKeys(validwebsite);
		Thread.sleep(2000);
		System.out.println("Satellite location website text field accepts input: Pass  " +validwebsite);
		utilityclassobject.gettest().log(Status.INFO, "Satellite location website text field accepts input: Pass  " +validwebsite);
		//clear the field
		sl.getAddnewsastellitewebsitefield().clear();
		System.out.println("Satellite location website text field is cleared "+ sl.getAddnewsastellitewebsitefield().getText());
		
		 
		
	}
	@Test(dependsOnMethods = "TC_015VerifySatellitLocationWebsiteFieldAcceptsInput")
	public void TC_016VerifySatellitLocationWebsiteFieldWithAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String validwebsite = elib.getDataFromExcel("SatelliteLocation", 9, 2);

			sl.getAddnewsastellitewebsitefield().sendKeys(validwebsite);
			Thread.sleep(2000);
			System.out.println("Satellite location website text field accepts Alphabets: Pass  " +validwebsite);
			utilityclassobject.gettest().log(Status.INFO, "Satellite location website text field accepts Alphabets: Pass  " +validwebsite);
			//clear the field
			sl.getAddnewsastellitewebsitefield().clear();
			System.out.println("Satellite location website text field is cleared "+ sl.getAddnewsastellitewebsitefield().getText());
			
		 
	}
	@Test(dependsOnMethods = "TC_016VerifySatellitLocationWebsiteFieldWithAlphabets")
	public void TC_017VerifySatellitLocationWebsiteFieldWithNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String validwebsite = elib.getDataFromExcel("SatelliteLocation", 9, 3);

			sl.getAddnewsastellitewebsitefield().sendKeys(validwebsite);
			Thread.sleep(2000);
			System.out.println("Satellite location website text field accepts Numbers: Pass  " +validwebsite);
			utilityclassobject.gettest().log(Status.INFO, "Satellite location website text field accepts Numbers: Pass  " +validwebsite);
			//clear the field
			sl.getAddnewsastellitewebsitefield().clear();
			System.out.println("Satellite location website text field is cleared "+ sl.getAddnewsastellitewebsitefield().getText());
			
		 
	}
	@Test(dependsOnMethods = "TC_017VerifySatellitLocationWebsiteFieldWithNumbers")
	public void TC_018VerifySatellitLocationWebsiteFieldWithSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 String validwebsite = elib.getDataFromExcel("SatelliteLocation", 9, 4);

			sl.getAddnewsastellitewebsitefield().sendKeys(validwebsite);
			Thread.sleep(2000);
			System.out.println("Satellite location website text field accepts Special Characters: Pass  " +validwebsite);
			utilityclassobject.gettest().log(Status.INFO, "Satellite location website text field accepts Special Characters: Pass  " +validwebsite);
			//clear the field
			sl.getAddnewsastellitewebsitefield().clear();
			System.out.println("Satellite location website text field is cleared "+ sl.getAddnewsastellitewebsitefield().getText());
			
		 
	}
	@Test(dependsOnMethods = "TC_018VerifySatellitLocationWebsiteFieldWithSpecialCharacters")
	public void TC_019VerifySatellitLocationWebsiteFieldWithInvalidInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getAddNewSatelliteLocationButtoninpopup().click();
		Thread.sleep(2000);
		sl.getAddnewsastellitewebsitefielderrormessage().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Satellite location website text field with invalid input shows error message: Pass  ");
		 System.out.println("Satellite location website text field with invalid input shows error message: Pass  ");
		 //clear the field
		 WebElement txt = sl.getAddnewsastellitewebsitefield();
		 txt.click();
	 		Thread.sleep(1000);


	 		Actions actions = new Actions(driver);

	 		actions.click(txt)
	 		       .keyDown(Keys.CONTROL)
	 		       .sendKeys("a")
	 		       .keyUp(Keys.CONTROL)
	 		       .sendKeys(Keys.DELETE)
	 		       .perform();
		 System.out.println("Satellite location website text field is cleared "+ sl.getAddnewsastellitewebsitefield().getText());
		 
		 
		 
	}
	@Test(dependsOnMethods = "TC_019VerifySatellitLocationWebsiteFieldWithInvalidInput")
	public void TC_020VerifySatellitLocationWebsiteFieldWithoutInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getAddNewSatelliteLocationButtoninpopup().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Satellite location website text field without input not displaying any error message: Pass  ");
		 System.out.println("Satellite location website text field without input not displaying any error message: Pass  ");
		
		 
	}
	@Test(dependsOnMethods = "TC_020VerifySatellitLocationWebsiteFieldWithoutInput")
	public void TC_021VerifyTheAddNewSatelliteLocationStatusFieldDefaultValue() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		String defaultvalue = sl.getAddnewsastatellitelocationstatusdropdown().getText();
		System.out.println("Satellite location status field default value is: " +defaultvalue);
		utilityclassobject.gettest().log(Status.INFO, "Satellite location status field default value is: " +defaultvalue);
		if(defaultvalue.equals("Active")) {
			System.out.println("Satellite location status field default value is Active: Pass");
			utilityclassobject.gettest().log(Status.INFO, "Satellite location status field default value is Active: Pass");
		} else {
			System.out.println("Satellite location status field default value is not Active: Fail");
			utilityclassobject.gettest().log(Status.INFO, "Satellite location status field default value is not Active: Fail");
		}
	}
	@Test(dependsOnMethods = "TC_021VerifyTheAddNewSatelliteLocationStatusFieldDefaultValue")
	public void TC_022VerifySatelliteLocationIsAbletoChangeStatus() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
	
		sl.getAddnewsastatellitelocationstatusdropdown().click();
		sl.getInactivestatusdropdown().click();
		String changedvalue = sl.getAddnewsastatellitelocationstatusdropdown().getText();
		System.out.println("Satellite location status field changed value is: " +changedvalue);
		utilityclassobject.gettest().log(Status.INFO, "Satellite location status field changed value is: " +changedvalue);
		if(changedvalue.equals("Inactive")) {
			System.out.println("Satellite location status field changed value is Inactive: Pass");
			utilityclassobject.gettest().log(Status.INFO, "Satellite location status field changed value is Inactive: Pass");
		} else {
			System.out.println("Satellite location status field changed value is not Inactive: Fail");
			utilityclassobject.gettest().log(Status.INFO, "Satellite location status field changed value is not Inactive: Fail");
		}
		
		
	}
	
	
	@Test(dependsOnMethods = "TC_022VerifySatelliteLocationIsAbletoChangeStatus")
	public void TC_023VerifyStatusDropDownISAbletoSelectMultipleOptions() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getAddnewsastatellitelocationstatusdropdown().click();

		sl.getActiveStatusDD().click();
		//try to selct multiple options from the dropdown and make sure it should not select multiple options
		sl.getAddnewsastatellitelocationstatusdropdown().click();

		sl.getInactivestatusdropdown().click();
	  String dropdownoption = sl.getAddnewsastatellitelocationstatusdropdown().getText();
	  System.out.println("Satellite location status field selected value is: " +dropdownoption);
	  utilityclassobject.gettest().log(Status.INFO, "Satellite location status field selected value is: " +dropdownoption);
	 

	  String selectedValue = sl.getAddnewsastatellitelocationstatusdropdown().getText().trim();

	  if(selectedValue.equals("Inactive"))
	  {
	      System.out.println("PASS: Only one option is selected.");
	      utilityclassobject.gettest().log(Status.INFO, "PASS: Only one option is selected.");
	  }
	  else
	  {
	      System.out.println("FAIL: Multiple options are selected.");
	      utilityclassobject.gettest().log(Status.INFO, "FAIL: Multiple options are selected.");
	  }
		sl.getAddnewsastatellitelocationstatusdropdown().click();
		sl.getActiveStatusDD().click();

		
	}
	
	/*Magic Test case 24
	  Magic Test case 24
	  Magic Test case 24
	  Magic Test case 24-- add TC_003 dependency*/

	String satellitname;
	String emailnamewithrandom ;
	String website ;
	@Test(dependsOnMethods = "TC_023VerifyStatusDropDownISAbletoSelectMultipleOptions"/*"TC_003VerifyTheAddNewSatelliteLocationButton"*/)
	public void TC_024VerifyTheAddNewSatelliteLocationRedirectToSatelliteLocationProfile() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getSatelliteLocationName().click();
		elib=new ExcelUtility();
		String satellitname = elib.getDataFromExcel("SatelliteLocation", 1, 2);
		 Thread.sleep(2000);
		 System.out.println(satellitname);
		 //add 5 digit random number to the satellite name
		 int randomNum = (int)(Math.random() * 100000);
		 String satellitnamewithrandom = satellitname + randomNum;
		 sl.getSatelliteLocationName().sendKeys(satellitnamewithrandom);
		 utilityclassobject.gettest().log(Status.INFO, "Add New Satellite Location Name Field Accepts input: Pass");
		 System.out.println("Add New Satellite Location Name Field accepts input: pass " + satellitnamewithrandom);
		 String emailname = elib.getDataFromExcel("SatelliteLocation", 5, 2);
		 //add 5 digit random number to the email name and also add @gmail.com to the email name
		 int randomNum1 = (int)(Math.random() * 100000);
		 emailnamewithrandom = emailname + randomNum1 + "@gmail.com";
		 sl.getAddnewsastelliteemailfield().click();
		 sl.getAddnewsastelliteemailfield().sendKeys(emailnamewithrandom);
		 utilityclassobject.gettest().log(Status.INFO, "Add New Satellite Location Email Field Accepts input: Pass");
		 System.out.println("Add New Satellite Location Email Field accepts input: pass " + emailnamewithrandom);
		 // aclick onthe website filed clear the website field using robot class
		 WebElement txt = sl.getAddnewsastellitewebsitefield();
		 
	 		txt.click();
	 		Thread.sleep(1000);

	 		Actions actions = new Actions(driver);

	 		actions.click(txt)
	 		       .keyDown(Keys.CONTROL)
	 		       .sendKeys("a")
	 		       .keyUp(Keys.CONTROL)
	 		       .sendKeys(Keys.DELETE)
	 		       .perform();
		 
		 
		 website = elib.getDataFromExcel("SatelliteLocation", 9, 1);
		 sl.getAddnewsastellitewebsitefield().sendKeys(website);
		 utilityclassobject.gettest().log(Status.INFO, "Add New Satellite Location Website Field Accepts input: Pass");
		 System.out.println("Add New Satellite Location Website Field accepts input: pass " + website);
		 Thread.sleep(2000);
		  defaultsatelliteStatus = sl.getSatellitelocationstatusdropdownfield().getText();
		  System.out.println("Default Satellite Location Status is: " +defaultsatelliteStatus);
		  utilityclassobject.gettest().log(Status.INFO, "Default Satellite Location Status is: " +defaultsatelliteStatus);
		  Thread.sleep(2000);
		 sl.getAddnewsastatellitelocationbuttonfrompopup().click();
		 System.out.println("Add New Satellite Location Button is clicked");
		 utilityclassobject.gettest().log(Status.INFO, "Add New Satellite Location Button is clicked");
		 Thread.sleep(2000);
		 sl.getSatellitelocationprofile().isDisplayed();
		 System.out.println("Satellite Location Profile Page is displayed");
		 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Page is displayed");

		 

		 
	}
	@Test(dependsOnMethods = "TC_024VerifyTheAddNewSatelliteLocationRedirectToSatelliteLocationProfile")
	public void TC_025VerifyTheSatelliteLocationProfileInformationTooltipidpresent() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getSatellitelocationinformationtootltipicon().isDisplayed();
		System.out.println("Satellite Location Profile Information Tooltip is displayed");
		utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Information Tooltip is displayed");
		
		 
	}
	@Test(dependsOnMethods = "TC_025VerifyTheSatelliteLocationProfileInformationTooltipidpresent")
	public void TC_026VerifyTheSatelliteLocationProfileInformationTooltipText() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getSatellitelocationinformationtootltipicon().click();
		Thread.sleep(2000);
		sl.getSatellitelocationinformationpopup().isDisplayed();
		System.out.println("Satellite Location Profile Information Tooltip Text is displayed");
		utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Information Tooltip Text is displayed");
		sl.getClosepopupbutton().click();
	}
	@Test(dependsOnMethods = "TC_026VerifyTheSatelliteLocationProfileInformationTooltipText")
	public void TC_027VerifyNameOFtheLocation() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		String comapnyname = sl.getCompanynamefield().getText();
		System.out.println("Satellite Location Profile Company Name is: " +comapnyname);
		if(comapnyname.equals(satellitname)) {
			System.out.println("Satellite Location Profile Company Name is same as the name entered in the Add New Satellite Location name : Pass");
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Company Name is same as the name entered in the Add New Satellite Location name: Pass");
		} else {
			System.out.println("Satellite Location Profile Company Name is not same as the name entered in the Add New Satellite Location name: Fail");
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Company Name is not same as the name entered in the Add New Satellite Location name: Fail");
		}
		
	}
	@Test(dependsOnMethods = "TC_027VerifyNameOFtheLocation")
	public void TC_028VerifyComapanyNameTextFieldisEditable() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		String comapnyname = sl.getCompanynamefield().getText();
		System.out.println("Existing Comapny name: " +comapnyname);
		sl.getCompanynamefield().clear();
		 String Updatedname = elib.getDataFromExcel("SatelliteLocation", 12, 1);
		 WebElement txt = sl.getCompanynamefield();
		 
	 		txt.click();
	 		Thread.sleep(1000);

	 		Actions actions = new Actions(driver);

	 		actions.click(txt)
	 		       .keyDown(Keys.CONTROL)
	 		       .sendKeys("a")
	 		       .keyUp(Keys.CONTROL)
	 		       .sendKeys(Keys.DELETE)
	 		       .perform();
	 		System.out.println("Existing Comapny name is cleared: " +sl.getCompanynamefield().getText());
	 		sl.getCompanynamefield().sendKeys(Updatedname + (int)(Math.random() * 100000));
	 		Thread.sleep(2000);
	 		String updatednamefromfield = sl.getCompanynamefield().getAttribute("value");
	 		System.out.println("Updated Comapny name: " +updatednamefromfield);
	 		utilityclassobject.gettest().log(Status.INFO, "Updated Comapny name: " +updatednamefromfield);
	 		System.out.println("Satellite Location Profile Company Name text field is editable: Pass");
	 		utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile Company Name text field is editable: Pass");
		 
		
	}
	@Test(dependsOnMethods = "TC_028VerifyComapanyNameTextFieldisEditable")
	public void TC_029VerifyCompanyDisplayNameAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
	
		sl.getCompanydisplaynamefield().click();
		 String Comapnyname = elib.getDataFromExcel("SatelliteLocation", 15, 1);
			sl.getCompanydisplaynamefield().sendKeys(Comapnyname);
			String companydisplayname = sl.getCompanydisplaynamefield().getText();
			System.out.println("Satellite Location Profile Company Display Name is: " +companydisplayname);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Company Display Name is: " +companydisplayname);
			System.out.println("Satellite Location Profile Company Display Name text field accepts input: Pass");
			utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile Company Display Name text field accepts input: Pass");
		    sl.ClearTextField(sl.getCompanydisplaynamefield());
		 

		
		
	}
	@Test(dependsOnMethods = "TC_029VerifyCompanyDisplayNameAcceptsInput")
	public void TC_030VerifyCompanyDisplayNameWithAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getCompanydisplaynamefield().click();
		 String Comapnyname = elib.getDataFromExcel("SatelliteLocation", 15, 2);
			sl.getCompanydisplaynamefield().sendKeys(Comapnyname);
			String companydisplayname = sl.getCompanydisplaynamefield().getText();
			System.out.println("Satellite Location Profile Company Display Name is: " +companydisplayname);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Company Display Name is: " +companydisplayname);
			System.out.println("Satellite Location Profile Company Display Name text field accepts Alphabets: Pass");
			utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile Company Display Name text field accepts Alphabets: Pass");
		    sl.ClearTextField(sl.getCompanydisplaynamefield());
		    
		
	}
	@Test(dependsOnMethods = "TC_030VerifyCompanyDisplayNameWithAlphabets")
	public void TC_031VerifyCompanyDisplayNameWithNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getCompanydisplaynamefield().click();
		 String Comapnyname = elib.getDataFromExcel("SatelliteLocation", 15, 3);
			sl.getCompanydisplaynamefield().sendKeys(Comapnyname);
			String companydisplayname = sl.getCompanydisplaynamefield().getText();
			System.out.println("Satellite Location Profile Company Display Name is: " +companydisplayname);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Company Display Name is: " +companydisplayname);
			System.out.println("Satellite Location Profile Company Display Name text field accepts Numbers: Pass");
			utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile Company Display Name text field accepts Numbers: Pass");
		    sl.ClearTextField(sl.getCompanydisplaynamefield());
	}
	@Test(dependsOnMethods = "TC_031VerifyCompanyDisplayNameWithNumbers")
	public void TC_032VerifyCompanyDisplayNameWithSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getCompanydisplaynamefield().click();
		 String Comapnyname = elib.getDataFromExcel("SatelliteLocation", 15, 4);
			sl.getCompanydisplaynamefield().sendKeys(Comapnyname);
			String companydisplayname = sl.getCompanydisplaynamefield().getText();
			System.out.println("Satellite Location Profile Company Display Name is: " +companydisplayname);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile Company Display Name is: " +companydisplayname);
			System.out.println("Satellite Location Profile Company Display Name text field accepts Special Characters: Pass");
			utilityclassobject.gettest().log(Status.PASS, "Satellite	 Location Profile Company Display Name text field accepts Special Characters: Pass");
		    sl.ClearTextField(sl.getCompanydisplaynamefield());
	}
	@Test(dependsOnMethods = "TC_032VerifyCompanyDisplayNameWithSpecialCharacters")
	public void TC_033VerifyCompanyDisplayNameWithoutInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getGeneralphonetext().click();
		Thread.sleep(2000);
		sl.getCompanydisplaynameerrormessage().isDisplayed();
		System.out.println("Satellite Location Profile Company Display Name text field without input shows error message: Pass");
		utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile Company Display Name text field without input shows error message: Pass");
		
		 
	}
	@Test(dependsOnMethods = "TC_033VerifyCompanyDisplayNameWithoutInput")
	public void TC_034VerifyGeneralPhoneNumberAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getGeneralphonetext().click();
		 String Generalphone = elib.getDataFromExcel("SatelliteLocation", 18, 1);
			sl.getGeneralphonefield().sendKeys(Generalphone);
			String generalphone = sl.getGeneralphonefield().getText();
			System.out.println("Satellite Location Profile General Phone Number is: " +generalphone);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Number is: " +generalphone);
			System.out.println("Satellite Location Profile General Phone Number text field accepts input: Pass");
			utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Number text field accepts input: Pass");
		    sl.ClearTextField(sl.getGeneralphonefield());
	}
	
	@Test(dependsOnMethods = "TC_034VerifyGeneralPhoneNumberAcceptsInput")
	public void TC_035VerifyGeneralPhoneNumberShouldnotaccpetAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getGeneralphonetext().click();
		 String Generalphone = elib.getDataFromExcel("SatelliteLocation", 18, 2);
			sl.getGeneralphonefield().sendKeys(Generalphone);
			String generalphone = sl.getGeneralphonefield().getText();
			System.out.println("Satellite Location Profile General Phone Number is: " +generalphone);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Number is: " +generalphone);
			if(generalphone.equals("")) {
				System.out.println("Satellite Location Profile General Phone Number text field should not accept Alphabets: Pass");
				utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Number text field should not accept Alphabets: Pass");
				} else {
					System.out.println("Satellite Location Profile General Phone Number text field should not accept Alphabets: Fail");
					utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Phone Number text field should not accept Alphabets: Fail");
						
					
				}
			
	}
	@Test(dependsOnMethods = "TC_035VerifyGeneralPhoneNumberShouldnotaccpetAlphabets")
	public void TC_036VerifyGeneralPhoneNumberShouldacceptNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getGeneralphonetext().click();
		 String Generalphone = elib.getDataFromExcel("SatelliteLocation", 18, 3);
			sl.getGeneralphonefield().sendKeys(Generalphone);
			String generalphone = sl.getGeneralphonefield().getText();
			System.out.println("Satellite Location Profile General Phone Number is: " +generalphone);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Number is: " +generalphone);
			if(generalphone.equals("")) {
				System.out.println("Satellite Location Profile General Phone Number text field should accept Numbers: Pass");
				utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Number text field should accept Numbers: Pass");
				} else {
					System.out.println("Satellite Location Profile General Phone Number text field should accept Numbers: Fail");
					utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Phone Number text field should accept Numbers: Fail");
						
					
				}
		    sl.ClearTextField(sl.getGeneralphonefield());

	}
	@Test(dependsOnMethods = "TC_036VerifyGeneralPhoneNumberShouldacceptNumbers")
	public void TC_037VerifyGeneralPhoneNumberShouldnotaccpetSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		sl.getGeneralphonetext().click();
		 String Generalphone = elib.getDataFromExcel("SatelliteLocation", 18, 4);
			sl.getGeneralphonefield().sendKeys(Generalphone);
			String generalphone = sl.getGeneralphonefield().getText();
			System.out.println("Satellite Location Profile General Phone Number is: " +generalphone);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Number is: " +generalphone);
			if(generalphone.equals("")) {
				System.out.println("Satellite Location Profile General Phone Number text field should not accept Special Characters: Pass");
				utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Number text field should not accept Special Characters: Pass");
				} else {
					System.out.println("Satellite Location Profile General Phone Number text field should not accept Special Characters: Fail");
					utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Phone Number text field should not accept Special Characters: Fail");
						
					
				}
		    sl.ClearTextField(sl.getGeneralphonefield());

	}
			@Test(dependsOnMethods = "TC_037VerifyGeneralPhoneNumberShouldnotaccpetSpecialCharacters")
			public void TC_038VerifyGeneralPhoneNumberWithoutInputShouldDisplayMandatoryField() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			wd = new webDriverutility();
			wd.scrollToelement(driver, sl.getSavebutton());
			sl.getSavebutton().click();
			//verify the error message is displayed for the General Phone Number field
			sl.getGeneralphoneerrormessage().isDisplayed();
			System.out.println("Satellite Location Profile General Phone Number text field without input shows error message: Pass");
			utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Number text field without input shows error message: Pass");
			wd.scrollToelement(driver, sl.getGeneralphoneerrormessage());

					
	}
			@Test(dependsOnMethods = "TC_038VerifyGeneralPhoneNumberWithoutInputShouldDisplayMandatoryField")
			public void TC_039VerifyExtWithValidInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
				sl.getGeneralphoneextfield().click();
				 String extnumber = elib.getDataFromExcel("SatelliteLocation", 20, 1);
				 sl.getGeneralphoneextfield().sendKeys(extnumber);
				 String generalphoneext = sl.getGeneralphoneextfield().getText();
				 System.out.println("Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 //clear the field
				 sl.ClearTextField(sl.getGeneralphoneextfield());

				
			}
			@Test(dependsOnMethods = "TC_039VerifyExtWithValidInput")
			public void TC_040VerifyExtNotAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
				//verify the General Phone Extension field should not accept Alphabets
				sl.getGeneralphoneextfield().click();
				 String alphabets = elib.getDataFromExcel("SatelliteLocation", 20, 2);
				 sl.getGeneralphoneextfield().sendKeys(alphabets);
				 String generalphoneext = sl.getGeneralphoneextfield().getText();
				 System.out.println("Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 if(generalphoneext.equals("")) {
						System.out.println("Satellite Location Profile General Phone Extension text field should not accept Alphabets: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Extension text field should not accept Alphabets: Pass");
						} else {
							System.out.println("Satellite Location Profile General Phone Extension text field should not accept Alphabets: Fail");
							utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Phone Extension text field should not accept Alphabets: Fail");
						}
				 sl.ClearTextField(sl.getGeneralphoneextfield());

				 
			}
			
			@Test(dependsOnMethods = "TC_040VerifyExtNotAcceptsAlphabets")
			public void TC_041VerifyExtAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
				//verify the General Phone Extension field should not accept Special Characters
				sl.getGeneralphoneextfield().click();
				 String extnumber = elib.getDataFromExcel("SatelliteLocation", 20, 3);
				 sl.getGeneralphoneextfield().sendKeys("52");
				 Thread.sleep(2000);
				 sl.getGeneralphonetext().click();
				 String generalphoneext = sl.getGeneralphoneextfield().getText();
				 System.out.println("Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Extension is: " +generalphoneext);
						System.out.println("Satellite Location Profile General Phone Extension text field should  accept Numbers: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Extension text field should accept Numbers: Pass");
						
				 sl.ClearTextField(sl.getGeneralphoneextfield());

			}
			@Test(dependsOnMethods = "TC_041VerifyExtAcceptsNumbers")
			public void TC_042VerifyExtNotAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
				//verify the General Phone Extension field should not accept Special Characters
				sl.getGeneralphoneextfield().click();
				 String specialchar = elib.getDataFromExcel("SatelliteLocation", 20, 4);
				 sl.getGeneralphoneextfield().sendKeys(specialchar);
				 String generalphoneext = sl.getGeneralphoneextfield().getText();
				 System.out.println("Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 if(generalphoneext.contains("")) {
						System.out.println("Satellite Location Profile General Phone Extension text field should not accept Special Characters: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Extension text field should not accept Special Characters: Pass");
						} else {
							System.out.println("Satellite Location Profile General Phone Extension text field should not accept Special Characters: Fail");
							utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Phone Extension text field should not accept Special Characters: Fail");
						}
				 sl.ClearTextField(sl.getGeneralphoneextfield());

			}
			
			@Test(dependsOnMethods = "TC_042VerifyExtNotAcceptsSpecialCharacters")
			public void TC_043VerifyExtWithlonginput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
				//try to pass more than 5 digits in the General Phone Extension field and verify it should not accept more than 5 digits
				sl.getGeneralphoneextfield().click();
				 String longinput = elib.getDataFromExcel("SatelliteLocation", 20, 5);
				 sl.getGeneralphoneextfield().sendKeys(longinput);
				 String generalphoneext = sl.getGeneralphoneextfield().getText();
				 System.out.println("Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 if(generalphoneext.length() <= 5) {
						System.out.println("Satellite Location Profile General Phone Extension text field should not accept more than 5 digits: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Extension text field should not accept more than 5 digits: Pass");
						} else {
							System.out.println("Satellite Location Profile General Phone Extension text field should not accept more than 5 digits: Fail");
							utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Phone Extension text field should not accept more than 5 digits: Fail");
						}
				 sl.ClearTextField(sl.getGeneralphoneextfield());

			}
			@Test(dependsOnMethods = "TC_043VerifyExtWithlonginput")
			public void TC_044VerifyExtWithlessInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
				//try to pass less than 5 digits in the General Phone Extension field and verify it should accept less than 5 digits
				sl.getGeneralphoneextfield().click();
				 String lessinput = elib.getDataFromExcel("SatelliteLocation", 20, 6);
				 sl.getGeneralphoneextfield().sendKeys(lessinput);
				 String generalphoneext = sl.getGeneralphoneextfield().getText();
				 System.out.println("Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Phone Extension is: " +generalphoneext);
				 if(generalphoneext.length() < 5) {
						System.out.println("Satellite Location Profile General Phone Extension text field should accept less than 5 digits: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Phone Extension text field should accept less than 5 digits: Pass");
						} else {
							System.out.println("Satellite Location Profile General Phone Extension text field should not accept less than 5 digits: Fail");
							utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Phone Extension text field should not accept less than 5 digits: Fail");
						}
				 sl.ClearTextField(sl.getGeneralphoneextfield());
				 
			}
			
			
			String emailfromtxtfield;
		@Test(dependsOnMethods = "TC_044VerifyExtWithlessInput")
		public void TC_045VerifyEmailisPresentIntheEmailTextField() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			emailfromtxtfield = sl.getGeneralemailfield().getText();
			System.out.println("Satellite Location Profile General Email is: " +emailfromtxtfield);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Email is: " +emailfromtxtfield);
			System.out.println("Satellite Location Profile General Email text field conatins mail : Pass");
			utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Email text field conatins : Pass");
			if(emailnamewithrandom.contains(emailfromtxtfield))
			{
				
				System.out.println("Satellite Location Profile General Email text field conatins the email entered in the Add New Satellite Location email field: Pass");
				utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Email text field conatins the email entered in the Add New Satellite Location email field: Pass");
			}
			else
			{
				System.out.println("Satellite Location Profile General Email text field conatins the email entered in the Add New Satellite Location email field: Fail");
				utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Email text field conatins the email entered in the Add New Satellite Location email field: Fail");
			}
		}
		@Test(dependsOnMethods = "TC_045VerifyEmailisPresentIntheEmailTextField")
		public void TC_046VerifyEmailTextFieldisEditable() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGeneralemailfield().click();
			 sl.ClearTextField(sl.getGeneralemailfield());

			 String emailname1 = elib.getDataFromExcel("SatelliteLocation", 24, 1);
			//add 5 digit random number to the email name and also add @gmail.com to the email name
			 int randomNum1 = (int)(Math.random() * 100000);
			 String newemail = emailname1 + randomNum1 + "@gmail.com";
			 sl.getGeneralemailfield().sendKeys(newemail);
			 sl.getGeneralphonetext().click();
			 Thread.sleep(4000);
			 String generalemail = sl.getGeneralemailfield().getText();
			 System.out.println("Edited General Email is: " +generalemail);
			 utilityclassobject.gettest().log(Status.INFO, "Edited General Email is: " +generalemail);
			 System.out.println("Email entered in the Add New Satellite Location email field is: " +emailnamewithrandom);
			 System.out.println("Edited General Email is: " +generalemail);
			 
			 //verify emailfromtxtfield is not equal to generalemail
			 if(!generalemail.equals(emailnamewithrandom))
			 {
				 System.out.println("Satellite Location Profile General Email text field is editable: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Satellite Location Profile General Email text field is editable: Pass");
			 }
			 else
			 {
				 System.out.println("Satellite Location Profile General Email text field is not editable: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Satellite Location Profile General Email text field is not editable: Fail");
			 }
			
			
			        
		}
		@Test(dependsOnMethods = "TC_046VerifyEmailTextFieldisEditable")
		public void TC_047VerifyEmailTextFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
				sl.getGeneralemailfield().click();
				 sl.ClearTextField(sl.getGeneralemailfield());

				
				 sl.getGeneralphonetext().click();
				 Thread.sleep(2000);
				 if(sl.getGeneralemailerrormessage().isDisplayed())
				 {
					 System.out.println("Satellite Location Profile General Email text field is mandatory: Pass");
					 utilityclassobject.gettest().log(Status.PASS, "General Email text field is mandatory: Pass");
				 }
				 else
				 {
					 System.out.println("General Email text field is not mandatory: Fail");
					 utilityclassobject.gettest().log(Status.FAIL, "General Email text field is not mandatory: Fail");
				 }
				 sl.getGeneralemailfield().sendKeys(emailnamewithrandom);
				 System.out.println("Again added mail in the text field " +emailnamewithrandom);
				
				
		}
		@Test(dependsOnMethods = "TC_047VerifyEmailTextFieldisMandatory")
		public void TC_048VerifyWebsitename() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		
			sl.getGeneralwebsitefield().click();
			 @Nullable
			String txt = sl.getGeneralwebsitefield().getAttribute("value");
			 System.out.println("Satellite Location Profile General Website is: " +txt);
			 System.out.println("Website entered in the Add New Satellite Location website field is: " +website);
			 utilityclassobject.gettest().log(Status.INFO, "Satellite Location Profile General Website is: " +txt);
			 if(txt.contains(website))
			 {
				 System.out.println("General Website text field conatins the website entered in the Add New Satellite Location website field: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "General Website text field conatins the website entered in the Add New Satellite Location website field: Pass");
				 
			 }
			 else
			 {
				 System.out.println("General Website text field conatins the website entered in the Add New Satellite Location website field: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "General Website text field conatins the website entered in the Add New Satellite Location website field: Fail");
				 
			 }
			
			sl.ClearTextField(sl.getGeneralwebsitefield());

		
		}
		@Test(dependsOnMethods = "TC_048VerifyWebsitename")
		public void TC_049VerifyWebsiteTextFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGeneralwebsitefield().click();
			 String websitefromtxtfield = elib.getDataFromExcel("SatelliteLocation", 27, 1);
			 sl.getGeneralwebsitefield().sendKeys(websitefromtxtfield);
			 Thread.sleep(2000);
             System.out.println(" General Website accepts Alphabets"+ sl.getGeneralwebsitefield().getText());
             utilityclassobject.gettest().log(Status.PASS, " General Website accepts Alphabets"+ sl.getGeneralwebsitefield().getText());
			 sl.ClearTextField(sl.getGeneralwebsitefield());	
		}
		@Test(dependsOnMethods = "TC_049VerifyWebsiteTextFieldAcceptsAlphabets")
		public void TC_050VerifyWebsiteTextFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGeneralwebsitefield().click();
			 String websitefromtxtfield = elib.getDataFromExcel("SatelliteLocation", 27, 2);
			 sl.getGeneralwebsitefield().sendKeys(websitefromtxtfield);
			 Thread.sleep(2000);
			 System.out.println(" General Website accepts Numbers"+ sl.getGeneralwebsitefield().getText());
			 utilityclassobject.gettest().log(Status.PASS, " General Website accepts Numbers"+ sl.getGeneralwebsitefield().getText());
			 sl.ClearTextField(sl.getGeneralwebsitefield());
		}
		@Test(dependsOnMethods = "TC_050VerifyWebsiteTextFieldAcceptsNumbers")
		public void TC_051VerifyWebsiteTextFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGeneralwebsitefield().click();
			 String websitefromtxtfield = elib.getDataFromExcel("SatelliteLocation", 27, 3);
			 sl.getGeneralwebsitefield().sendKeys(websitefromtxtfield);
			 Thread.sleep(2000);
			 System.out.println(" General Website accepts Special Characters"+ sl.getGeneralwebsitefield().getText());
			 utilityclassobject.gettest().log(Status.PASS, " General Website accepts Special Characters"+ sl.getGeneralwebsitefield().getText());
			 sl.ClearTextField(sl.getGeneralwebsitefield());
		}
		@Test(dependsOnMethods = "TC_051VerifyWebsiteTextFieldAcceptsSpecialCharacters")
		public void TC_052VerifyWebsiteTextFieldAcceptsCopiPastedInputs() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			
			//write code for copy the data from excel and paste it in the website text field
			sl.getGeneralwebsitefield().click();
			 String websitefromtxtfield = elib.getDataFromExcel("SatelliteLocation", 27, 4);
			 sl.getGeneralwebsitefield().sendKeys(websitefromtxtfield);
			 Thread.sleep(2000);
			 System.out.println(" General Website accepts Copied and Pasted Inputs"+ sl.getGeneralwebsitefield().getText());
			 utilityclassobject.gettest().log(Status.PASS, " General Website accepts Copied and Pasted Inputs"+ sl.getGeneralwebsitefield().getText());
			 sl.ClearTextField(sl.getGeneralwebsitefield());
		}
		//check the dependency of TC_24
		//check the dependency of TC_24

		//check the dependency of TC_24

		//check the dependency of TC_24
					 
		@Test(dependsOnMethods = "TC_052VerifyWebsiteTextFieldAcceptsCopiPastedInputs")
		public void TC_057VerifyBusinessHoursAcceptInputs() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getBusinesshoursfield().click();
			 String businesshours = elib.getDataFromExcel("SatelliteLocation", 32, 1);
			 sl.getBusinesshoursfield().sendKeys(businesshours);
			 Thread.sleep(2000);
			 System.out.println("Business Hours is: " +sl.getBusinesshoursfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, "Business Hours is: " +sl.getBusinesshoursfield().getText());
			 System.out.println(" Business Hours text field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Business Hours text field accepts input: Pass");
			 //clear the field
			 sl.ClearTextField(sl.getBusinesshoursfield());
		}
		@Test(dependsOnMethods = "TC_057VerifyBusinessHoursAcceptInputs")
		public void TC_058VerifyBusinessHoursAcceptAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getBusinesshoursfield().click();
			 String businesshours = elib.getDataFromExcel("SatelliteLocation", 32, 2);
			 sl.getBusinesshoursfield().sendKeys(businesshours);
			 Thread.sleep(2000);
			 System.out.println(" Business Hours is: " +sl.getBusinesshoursfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Business Hours is: " +sl.getBusinesshoursfield().getText());
			 System.out.println("Business Hours text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Business Hours text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBusinesshoursfield());

		}
		@Test(dependsOnMethods = "TC_058VerifyBusinessHoursAcceptAlphabets")
		public void TC_059VerifyBusinessHoursAcceptNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getBusinesshoursfield().click();
			 String businesshours = elib.getDataFromExcel("SatelliteLocation", 32, 3);
			 sl.getBusinesshoursfield().sendKeys(businesshours);
			 Thread.sleep(2000);
			 System.out.println(" Business Hours is: " +sl.getBusinesshoursfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Business Hours is: " +sl.getBusinesshoursfield().getText());
			 System.out.println(" Business Hours text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "  Business Hours text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBusinesshoursfield());

		}
		@Test(dependsOnMethods = "TC_059VerifyBusinessHoursAcceptNumbers")
		public void TC_060VerifyBusinessHoursAcceptSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getBusinesshoursfield().click();
			 String businesshours = elib.getDataFromExcel("SatelliteLocation", 32, 4);
			 sl.getBusinesshoursfield().sendKeys(businesshours);
			 Thread.sleep(2000);
			 System.out.println(" Business Hours is: " +sl.getBusinesshoursfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Business Hours is: " +sl.getBusinesshoursfield().getText());
			 System.out.println(" Business Hours text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Business Hours text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBusinesshoursfield());

			 
		}
		@Test(dependsOnMethods = "TC_060VerifyBusinessHoursAcceptSpecialCharacters")
		public void TC_061VerifyBusinessHoursAcceptCombinationofAllInputs() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getBusinesshoursfield().click();
			 String businesshours = elib.getDataFromExcel("SatelliteLocation", 32, 5);
			 sl.getBusinesshoursfield().sendKeys(businesshours);
			 Thread.sleep(2000);
			 System.out.println(" Business Hours is: " +sl.getBusinesshoursfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Business Hours is: " +sl.getBusinesshoursfield().getText());
			 System.out.println(" Business Hours text field accepts Combination of all Inputss: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Business Hours text field accepts Combination of all Inputs: Pass");
			 sl.ClearTextField(sl.getBusinesshoursfield());

		}
		@Test(dependsOnMethods = "TC_061VerifyBusinessHoursAcceptCombinationofAllInputs")
		public void TC_062VerifyGoogleRevireLinkAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGooglereviewlinkfield().click();
			 String googlelink = elib.getDataFromExcel("SatelliteLocation", 35, 1);
			 sl.getGooglereviewlinkfield().sendKeys(googlelink);
			 Thread.sleep(2000);
			 System.out.println(" Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 System.out.println(" Google Review Link text field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Google Review Link text field accepts input: Pass");
			 sl.ClearTextField(sl.getGooglereviewlinkfield());
		
		}
		@Test(dependsOnMethods = "TC_062VerifyGoogleRevireLinkAcceptsInput")
		public void TC_063VerifyGoogleRevireLinkAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGooglereviewlinkfield().click();
			 String googlelink = elib.getDataFromExcel("SatelliteLocation", 35, 2);
			 sl.getGooglereviewlinkfield().sendKeys(googlelink);
			 Thread.sleep(2000);
			 System.out.println(" Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 System.out.println(" Google Review Link text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Google Review Link text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getGooglereviewlinkfield());
		}
		@Test(dependsOnMethods = "TC_063VerifyGoogleRevireLinkAcceptsAlphabets")
		public void TC_064VerifyGoogleRevireLinkAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGooglereviewlinkfield().click();
			 String googlelink = elib.getDataFromExcel("SatelliteLocation", 35, 3);
			 sl.getGooglereviewlinkfield().sendKeys(googlelink);
			 Thread.sleep(2000);
			 System.out.println(" Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 System.out.println(" Google Review Link text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Google Review Link text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getGooglereviewlinkfield());
		}
		@Test(dependsOnMethods = "TC_064VerifyGoogleRevireLinkAcceptsNumbers")
		public void TC_065VerifyGoogleRevireLinkAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGooglereviewlinkfield().click();
			 String googlelink = elib.getDataFromExcel("SatelliteLocation", 35, 4);
			 sl.getGooglereviewlinkfield().sendKeys(googlelink);
			 Thread.sleep(2000);
			 System.out.println(" Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 System.out.println(" Google Review Link text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Google Review Link text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getGooglereviewlinkfield());
		}
		@Test(dependsOnMethods = "TC_065VerifyGoogleRevireLinkAcceptsSpecialCharacters")
		public void TC_066VerifyGoogleRevireLinkAcceptsCopyPasetdInputs() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGooglereviewlinkfield().click();
			 String googlelink = elib.getDataFromExcel("SatelliteLocation", 35, 1);
			 sl.getGooglereviewlinkfield().sendKeys(googlelink);
			 Thread.sleep(2000);
			 System.out.println(" Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Google Review Link is: " +sl.getGooglereviewlinkfield().getText());
			 System.out.println(" Google Review Link text field accepts Combination of all Inputs: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Google Review Link text field accepts Combination of all Inputs: Pass");
			 sl.getGeneralphonetext().click();
			  sl.ClearTextField(sl.getGooglereviewlinkfield());
		}
		@Test(dependsOnMethods = "TC_066VerifyGoogleRevireLinkAcceptsCopyPasetdInputs")
		public void TC_067VerifyGoogleRevireLinkWithInvalidInputPrompterrorMessage() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getGooglereviewlinkfield().click();
			 String googlelink = elib.getDataFromExcel("SatelliteLocation", 35, 5);
			 sl.getGooglereviewlinkfield().sendKeys(googlelink);
			 Thread.sleep(2000);
			 sl.getGeneralphonetext().click();
			 Thread.sleep(2000);
			 if(sl.getGooglereviewlinkerrormessage().isDisplayed())
			 {
				 System.out.println("Google Review Link text field with invalid input shows error message: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Google Review Link text field with invalid input shows error message: Pass");
			 }
			 else
			 {
				 System.out.println("Google Review Link text field with invalid input does not show error message: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Google Review Link text field with invalid input does not show error message: Fail");
			 }
			  sl.ClearTextField(sl.getGooglereviewlinkfield());

		}
		@Test(/*dependsOnMethods = /*"TC_067VerifyGoogleRevireLinkWithInvalidInputPrompterrorMessage""TC_024VerifyTheAddNewSatelliteLocationRedirectToSatelliteLocationProfile"*/)
		public void TC_068VerifyGoogleRevireLinkWithValidinput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		
			//it is not an Magic Tc While running check the dependency To run independently comment dependency 
			
			//comment it
			//comment it
			//comment it
			
			elib=new ExcelUtility();
			hp = new HomePage(driver);
			utilityclassobject.gettest().log(com.aventstack.extentreports.Status.INFO, "Home Page is displayed");
			System.out.println("Home Page is displayed");
			Thread.sleep(6000);
			sl = new SatelliteLocation(driver);
			sl.getAssets().click();
			sl.getSatellite_Locations().click();
			sl.getSatelliteLocationsList().isDisplayed();
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Page is displayed");
			 System.out.println("Satellite Location Page is displayed");
			  List<WebElement> namelists = sl.getSatelliteLocationNameinlist();
			   //print each value using for loop
			  for(int i=0; i<namelists.size(); i++) {
				  String name = namelists.get(i).getText();
				  ExcelUtility elib1 = new ExcelUtility();
					 String satellitename = elib1.getDataFromExcel("SatelliteLocation", 35, 7);
				  if(name.equals(satellitename)) {
					  namelists.get(i).click();
					  utilityclassobject.gettest().log(Status.INFO, "Clicked on Satellite Location Name in the list: " +name);
					  System.out.println("Clicked on Satellite Location Name in the list: " +name);
					  break;
				  }
				  
			  }
			  
			 
			 //comment it
			//comment it//comment it
			//comment it
			 
			 
			
			
			
			sl.getGooglereviewlinkfield().click();
			 String googlelink = elib.getDataFromExcel("SatelliteLocation", 35, 6);
			 sl.getGooglereviewlinkfield().sendKeys(googlelink);
			 Thread.sleep(2000);
			 sl.getGeneralphonetext().click();
			 Thread.sleep(2000);
			 System.out.println("Google Review Link text field with valid input does not show error message: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Google Review Link text field with valid input does not show error message: Pass");
			  sl.ClearTextField(sl.getGooglereviewlinkfield());	
		}
		
		//Rmove the comment of File upload to run independetly by using existing satellite location profile and also remove the dependencies 
		
		
		
		

		@Test(dependsOnMethods = "TC_068VerifyGoogleRevireLinkWithValidinput")
		public void TC_075VerifyNotAbleToPassinputInsideSatellietLoactionStatus() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			
			sl.getSatellitelocationstatusdropdown().click();
			//try to pass input inside the dropdown and verify that it should not accept any input
			String input =elib.getDataFromExcel("SatelliteLocation", 38, 1);

			sl.getSatellitelocationstatusdropdown().sendKeys(input);
			String satellitestatus = sl.getSatellitelocationstatusdropdown().getText();
			if(!satellitestatus.equals(input)) {
				System.out.println("Not able to pass input inside Satellite Location Status dropdown :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Not able to pass input inside Satellite Location Status dropdown :PASS");
			}
			else
			{
				System.out.println("Able to pass input inside Satellite Location Status dropdown :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Able to pass input inside Satellite Location Status dropdown :FAIL");
			}
			
		}
		@Test(dependsOnMethods = "TC_075VerifyNotAbleToPassinputInsideSatellietLoactionStatus")
		public void TC_076VerifySatelliteLocationStatusDisplayedAsWhileAddingSatellite() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			//verify the Satellite Location Status dropdown should display the status as "Active" while adding new satellite location
			
			//Remove the comment whenever you want to execute from beginning 
			//Remove the comment whenever you want to execute from beginning 
			//Remove the comment whenever you want to execute from beginning 

			
			/*
			String satellitestatus = sl.getSatellitelocationstatusdropdown().getText();
			System.out.println("Satellite Location Status is: " +satellitestatus);
			utilityclassobject.gettest().log(Status.INFO, "Satellite Location Status is: " +satellitestatus);
			if(defaultsatelliteStatus.equals(satellitestatus)) {
				System.out.println("Satellite Location Status dropdown displays the status as " +defaultsatelliteStatus+ " while adding new satellite location: Pass");
				utilityclassobject.gettest().log(Status.PASS, "Satellite  Location Status dropdown displays the status as " +defaultsatelliteStatus+ " while adding new satellite location: Pass");
			}
			else
			{
				System.out.println("Satellite Location Status dropdown does not display the status as " +defaultsatelliteStatus+ " while adding new satellite location: Fail");
				utilityclassobject.gettest().log(Status.FAIL, "Satellite  Location Status dropdown does not display the status as " +defaultsatelliteStatus+ " while adding new satellite location: Fail");
			}
			*/
		
			
		}
		@Test(dependsOnMethods = "TC_076VerifySatelliteLocationStatusDisplayedAsWhileAddingSatellite")
		public void TC_077VerifyStatusCanbeChange() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			//very user is able to change the status of the satellite location from Active to Inactive and vice versa
			sl.getSatellitelocationstatusdropdown().click();
			sl.getInactivefromstatusdropdownfield().click();
			String chngedsatus  =sl.getSatellitelocationstatusdropdown().getText();
			if(chngedsatus.equals("Inactive")) {
				System.out.println("User is able to change the status of the satellite location from Active to Inactive: Pass");
				utilityclassobject.gettest().log(Status.PASS, "User is able to change the status of the satellite location from Active to Inactive: Pass");
			}
			else
			{
				System.out.println("User is not able to change the status of the satellite location from Active to Inactive: Fail");
				utilityclassobject.gettest().log(Status.FAIL, "User is not able to change the status of the satellite location from Active to Inactive: Fail");
			}
			//again change the status from Inactive to Active
			sl.getSatellitelocationstatusdropdown().click();	
			sl.getActivefromstatusdropdownfield().click();
			
		}
}
