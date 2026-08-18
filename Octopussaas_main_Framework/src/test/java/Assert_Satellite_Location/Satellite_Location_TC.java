package Assert_Satellite_Location;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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
	
	
	
	String randomName;
	 String Satelliteserviceinfostreet;
	 String Zipcode;
	 String Email;
	 String PhoneNumber;
	 String companynamevalue;
	 String streetaddress;
	 String dispatchphonenumber;
	 String status;
	
	
	
	/*Magic Test case 24
	  Magic Test case 24
	  Magic Test case 24
	  Magic Test case 24-- add TC_003 dependency for fast excecution*/
	
	/*Rmove the comment of File upload to run independently by using existing satellite location profile and also remove the dependencies */
	/*Rmove the comment of File upload to run independently by using existing satellite location profile and also remove the dependencies */

	// Helper: robust name comparison used by TC_230..TC_236
	

	   //-----------------------------To execute TC without using Dependency use this ----------------
	   //comment it
		//comment it
		//comment it
		/*
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
		  
		 */
		 //comment it
		//comment it//comment it
		//comment it
	   //-----------------------------To execute TC without using Dependency use this ----------------
	 
	 
	 
	
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
		@Test(dependsOnMethods = "TC_067VerifyGoogleRevireLinkWithInvalidInputPrompterrorMessage"/*"TC_024VerifyTheAddNewSatelliteLocationRedirectToSatelliteLocationProfile"*/)
		public void TC_068VerifyGoogleRevireLinkWithValidinput() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
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
			/*
			WebElement element = sl.getSatellitelocationstatusdropdown();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			//sl.getSatellitelocationstatusdropdown().click();
*/
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
			Thread.sleep(2000);
			sl.getActivefromstatusdropdownfield().click();
			
		}
		@Test(dependsOnMethods = "TC_077VerifyStatusCanbeChange")
		public void TC_078VerifyRegistrationNumber1AcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			//verify user is able to change the status of the satellite location from Inactive to Active
			sl.getRegistrationnumber1field().click();
			 String registrationnumber1 = elib.getDataFromExcel("SatelliteLocation", 40, 1);
			 sl.getRegistrationnumber1field().sendKeys(registrationnumber1);
			 Thread.sleep(2000);
			 System.out.println(" Registration Number 1 is: " +sl.getRegistrationnumber1field().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Registration Number 1 is: " +sl.getRegistrationnumber1field().getText());
			 System.out.println(" Registration Number 1 text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Registration Number 1 text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getRegistrationnumber1field());
		}
		@Test(dependsOnMethods = "TC_078VerifyRegistrationNumber1AcceptsAlphabets")
		public void TC_079VerifyRegistrationNumber1AcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getRegistrationnumber1field().click();
			 String registrationnumber1 = elib.getDataFromExcel("SatelliteLocation", 40, 2);
			 sl.getRegistrationnumber1field().sendKeys(registrationnumber1);
			 Thread.sleep(2000);
			 System.out.println(" Registration Number 1 is: " +sl.getRegistrationnumber1field().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Registration Number 1 is: " +sl.getRegistrationnumber1field().getText());
			 System.out.println(" Registration Number 1 text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Registration Number 1 text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getRegistrationnumber1field());
		}
		@Test(dependsOnMethods = "TC_079VerifyRegistrationNumber1AcceptsNumbers")
		public void TC_080VerifyRegistrationNumber1AcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			sl.getRegistrationnumber1field().click();
			 String registrationnumber1 = elib.getDataFromExcel("SatelliteLocation", 40, 3);
			 sl.getRegistrationnumber1field().sendKeys(registrationnumber1);
			 Thread.sleep(2000);
			 System.out.println(" Registration Number 1 is: " +sl.getRegistrationnumber1field().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Registration Number 1 is: " +sl.getRegistrationnumber1field().getText());
			 System.out.println(" Registration Number 1 text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Registration Number 1 text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getRegistrationnumber1field());
		}
		@Test(dependsOnMethods = "TC_080VerifyRegistrationNumber1AcceptsSpecialCharacters")
		public void TC_081VerifyRegistrationNumber1IsMandatoryField() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			//verify that Registration Number 1 is a mandatory field and it should display error message if user does not enter any value in the field
			sl.getRegistrationnumber1field().click();
			 sl.ClearTextField(sl.getRegistrationnumber1field());
			 sl.getGeneralphonetext().click();
			 Thread.sleep(2000);
			 if(sl.getRegistrationnumber1errormessage().isDisplayed())
			 {
				 System.out.println("Registration Number 1 text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Registration Number 1 text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Registration Number 1 text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Registration Number 1 text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_081VerifyRegistrationNumber1IsMandatoryField")
		public void TC_082VerifyRegistrationNumber2AcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		 sl.getRegistrationnumber2field().click();
			 String registrationnumber2 = elib.getDataFromExcel("SatelliteLocation", 42, 1);
			 sl.getRegistrationnumber2field().sendKeys(registrationnumber2);
			 Thread.sleep(2000);
			 System.out.println(" Registration Number 2 is: " +sl.getRegistrationnumber2field().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Registration Number 2 is: " +sl.getRegistrationnumber2field().getText());
			 System.out.println(" Registration Number 2 text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Registration Number 2 text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getRegistrationnumber2field());
			
		}
		@Test(dependsOnMethods = "TC_082VerifyRegistrationNumber2AcceptsAlphabets")
		public void TC_083VerifyRegistrationNumber2AcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			 sl.getRegistrationnumber2field().click();
			 String registrationnumber2 = elib.getDataFromExcel("SatelliteLocation", 42, 2);
			 sl.getRegistrationnumber2field().sendKeys(registrationnumber2);
			 Thread.sleep(2000);
			 System.out.println(" Registration Number 2 is: " +sl.getRegistrationnumber2field().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Registration Number 2 is: " +sl.getRegistrationnumber2field().getText());
			 System.out.println(" Registration Number 2 text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Registration Number 2 text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getRegistrationnumber2field());
		}
		@Test(dependsOnMethods = "TC_083VerifyRegistrationNumber2AcceptsNumbers")
		public void TC_084VerifyRegistrationNumber2AcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			 sl.getRegistrationnumber2field().click();
			 String registrationnumber2 = elib.getDataFromExcel("SatelliteLocation", 42, 3);
			 sl.getRegistrationnumber2field().sendKeys(registrationnumber2);
			 Thread.sleep(2000);
			 System.out.println(" Registration Number 2 is: " +sl.getRegistrationnumber2field().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Registration Number 2 is: " +sl.getRegistrationnumber2field().getText());
			 System.out.println(" Registration Number 2 text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Registration Number 2 text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getRegistrationnumber2field());
		}
		@Test(dependsOnMethods = "TC_084VerifyRegistrationNumber2AcceptsSpecialCharacters")
		public void TC_085VerifyRegistrationNumber2IsNotMandatoryField() throws InterruptedException
		{
			sl.getRegistrationnumber2field().click();
			 sl.getGeneralphonetext().click();
			 Thread.sleep(2000);
			 System.out.println("Registration Number 2 text field is not mandatory: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Registration Number 2 text field is not mandatory: Pass");
			 
		}
		@Test(dependsOnMethods = "TC_085VerifyRegistrationNumber2IsNotMandatoryField")
		public void TC_086VerifyEPAidNumberTextfieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			 sl.getEpanumberfield().click();
			 String Epanumber = elib.getDataFromExcel("SatelliteLocation", 44, 1);
			 sl.getEpanumberfield().sendKeys(Epanumber);
			 Thread.sleep(2000);
			 System.out.println(" EPA ID Number is: " +sl.getEpanumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " EPA ID Number is: " +sl.getEpanumberfield().getText());
			 System.out.println(" EPA ID Number text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " EPA ID Number text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getEpanumberfield());
			 
		}
		@Test(dependsOnMethods = "TC_086VerifyEPAidNumberTextfieldAcceptsAlphabets")
		public void TC_087VerifyEPAidNumberTextfieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			 sl.getEpanumberfield().click();
			 String Epanumber = elib.getDataFromExcel("SatelliteLocation", 44, 2);
			 sl.getEpanumberfield().sendKeys(Epanumber);
			 Thread.sleep(2000);
			 System.out.println(" EPA ID Number is: " +sl.getEpanumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " EPA ID Number is: " +sl.getEpanumberfield().getText());
			 System.out.println(" EPA ID Number text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " EPA ID Number text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getEpanumberfield());
		}
		@Test(dependsOnMethods = "TC_087VerifyEPAidNumberTextfieldAcceptsNumbers")
		public void TC_088VerifyEPAidNumberTextfieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
			 sl.getEpanumberfield().click();
			 String Epanumber = elib.getDataFromExcel("SatelliteLocation", 44, 3);
			 sl.getEpanumberfield().sendKeys(Epanumber);
			 Thread.sleep(2000);
			 System.out.println(" EPA ID Number is: " +sl.getEpanumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " EPA ID Number is: " +sl.getEpanumberfield().getText());
			 System.out.println(" EPA ID Number text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " EPA ID Number text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getEpanumberfield());
		}
		@Test(dependsOnMethods = "TC_088VerifyEPAidNumberTextfieldAcceptsSpecialCharacters")
		public void TC_089VerifyDOTnumberfieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDotnumberfield().click();
			 String Dotnumber = elib.getDataFromExcel("SatelliteLocation", 46, 1);
			 sl.getDotnumberfield().sendKeys(Dotnumber);
			 Thread.sleep(2000);
			 System.out.println(" DOT Number is: " +sl.getDotnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " DOT Number is: " +sl.getDotnumberfield().getText());
			 System.out.println(" DOT Number text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " DOT Number text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getDotnumberfield());
		}
		@Test(dependsOnMethods = "TC_089VerifyDOTnumberfieldAcceptsAlphabets")
		public void TC_090VerifyDOTnumberfieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDotnumberfield().click();
			 String Dotnumber = elib.getDataFromExcel("SatelliteLocation", 46, 2);
			 sl.getDotnumberfield().sendKeys(Dotnumber);
			 Thread.sleep(2000);
			 System.out.println(" DOT Number is: " +sl.getDotnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " DOT Number is: " +sl.getDotnumberfield().getText());
			 System.out.println(" DOT Number text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " DOT Number text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getDotnumberfield());
		}
		@Test(dependsOnMethods = "TC_090VerifyDOTnumberfieldAcceptsNumbers")
		public void TC_091VerifyDOTnumberfieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDotnumberfield().click();
			 String Dotnumber = elib.getDataFromExcel("SatelliteLocation", 46, 3);
			 sl.getDotnumberfield().sendKeys(Dotnumber);
			 Thread.sleep(2000);
			 System.out.println(" DOT Number is: " +sl.getDotnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " DOT Number is: " +sl.getDotnumberfield().getText());
			 System.out.println(" DOT Number text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " DOT Number text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getDotnumberfield());
		}
		@Test(dependsOnMethods = "TC_091VerifyDOTnumberfieldAcceptsSpecialCharacters")
		public void TC_092VerifyEINFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getEinfield().click();
			 String Einnumber = elib.getDataFromExcel("SatelliteLocation", 48, 1);
			 sl.getEinfield().sendKeys(Einnumber);
			 Thread.sleep(2000);
			 System.out.println(" EIN Number is: " +sl.getEinfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " EIN Number is: " +sl.getEinfield().getText());
			 System.out.println(" EIN Number text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " EIN Number text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getEinfield());
		
		}
		@Test(dependsOnMethods = "TC_092VerifyEINFieldAcceptsAlphabets")
		public void TC_093VerifyEINFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getEinfield().click();
			 String Einnumber = elib.getDataFromExcel("SatelliteLocation", 48, 2);
			 sl.getEinfield().sendKeys(Einnumber);
			 Thread.sleep(2000);
			 System.out.println(" EIN Number is: " +sl.getEinfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " EIN Number is: " +sl.getEinfield().getText());
			 System.out.println(" EIN Number text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " EIN Number text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getEinfield());
		
		}
		@Test(dependsOnMethods = "TC_093VerifyEINFieldAcceptsNumbers")
		public void TC_094VerifyEINFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getEinfield().click();
			 String Einnumber = elib.getDataFromExcel("SatelliteLocation", 48, 3);
			 sl.getEinfield().sendKeys(Einnumber);
			 Thread.sleep(2000);
			 System.out.println(" EIN Number is: " +sl.getEinfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " EIN Number is: " +sl.getEinfield().getText());
			 System.out.println(" EIN Number text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " EIN Number text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getEinfield());
		
		}
		@Test(dependsOnMethods = "TC_094VerifyEINFieldAcceptsSpecialCharacters")
		public void TC_095VerifyEntityIDNumberieldAcceptsAlpabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getEntityidnumberfield().click();
			 String Entityidnumber = elib.getDataFromExcel("SatelliteLocation", 50, 1);
			 sl.getEntityidnumberfield().sendKeys(Entityidnumber);
			 Thread.sleep(2000);
			 System.out.println(" Entity ID Number is: " +sl.getEntityidnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Entity ID Number is: " +sl.getEntityidnumberfield().getText());
			 System.out.println(" Entity ID Number text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Entity ID Number text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getEntityidnumberfield());
			 
		}
		@Test(dependsOnMethods = "TC_095VerifyEntityIDNumberieldAcceptsAlpabets")
		public void TC_096VerifyEntityIDNumberieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getEntityidnumberfield().click();
			 String Entityidnumber = elib.getDataFromExcel("SatelliteLocation", 50, 2);
			 sl.getEntityidnumberfield().sendKeys(Entityidnumber);
			 Thread.sleep(2000);
			 System.out.println(" Entity ID Number is: " +sl.getEntityidnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Entity ID Number is: " +sl.getEntityidnumberfield().getText());
			 System.out.println(" Entity ID Number text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Entity ID Number text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getEntityidnumberfield());
			 
		}
		@Test(dependsOnMethods = "TC_096VerifyEntityIDNumberieldAcceptsNumbers")
		public void TC_097VerifyEntityIDNumberieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getEntityidnumberfield().click();
			 String Entityidnumber = elib.getDataFromExcel("SatelliteLocation", 50, 3);
			 sl.getEntityidnumberfield().sendKeys(Entityidnumber);
			 Thread.sleep(2000);
			 System.out.println(" Entity ID Number is: " +sl.getEntityidnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Entity ID Number is: " +sl.getEntityidnumberfield().getText());
			 System.out.println(" Entity ID Number text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Entity ID Number text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getEntityidnumberfield());
			 
		}
		@Test(dependsOnMethods = "TC_097VerifyEntityIDNumberieldAcceptsSpecialCharacters")
		public void TC_098VerifySOSNumberFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSosnumberfield().click();
			 String Sosnumber = elib.getDataFromExcel("SatelliteLocation", 52, 1);
			 sl.getSosnumberfield().sendKeys(Sosnumber);
			 Thread.sleep(2000);
			 System.out.println(" SOS Number is: " +sl.getSosnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " SOS Number is: " +sl.getSosnumberfield().getText());
			 System.out.println(" SOS Number text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " SOS Number text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getSosnumberfield());
		}
		@Test(dependsOnMethods = "TC_098VerifySOSNumberFieldAcceptsAlphabets")
		public void TC_099VerifySOSNumberFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSosnumberfield().click();
			 String Sosnumber = elib.getDataFromExcel("SatelliteLocation", 52, 2);
			 sl.getSosnumberfield().sendKeys(Sosnumber);
			 Thread.sleep(2000);
			 System.out.println(" SOS Number is: " +sl.getSosnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " SOS Number is: " +sl.getSosnumberfield().getText());
			 System.out.println(" SOS Number text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " SOS Number text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getSosnumberfield());
		}
		@Test(dependsOnMethods = "TC_099VerifySOSNumberFieldAcceptsNumbers")
		public void TC_100VerifySOSNumberFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSosnumberfield().click();
			 String Sosnumber = elib.getDataFromExcel("SatelliteLocation", 52, 3);
			 sl.getSosnumberfield().sendKeys(Sosnumber);
			 Thread.sleep(2000);
			 System.out.println(" SOS Number is: " +sl.getSosnumberfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " SOS Number is: " +sl.getSosnumberfield().getText());
			 System.out.println(" SOS Number text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " SOS Number text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getSosnumberfield());
		}
		@Test(dependsOnMethods = "TC_100VerifySOSNumberFieldAcceptsSpecialCharacters")
		public void TC_101VerifySICFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSiccodefield().click();
			 String Sicnumber = elib.getDataFromExcel("SatelliteLocation", 54, 1);
			 sl.getSiccodefield().sendKeys(Sicnumber);
			 Thread.sleep(2000);
			 System.out.println(" SIC Number is: " +sl.getSiccodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " SIC Number is: " +sl.getSiccodefield().getText());
			 System.out.println(" SIC Number text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " SIC Number text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getSiccodefield());
		}
		@Test(dependsOnMethods = "TC_101VerifySICFieldAcceptsAlphabets")
		public void TC_102VerifySICFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSiccodefield().click();
			 String Sicnumber = elib.getDataFromExcel("SatelliteLocation", 54, 2);
			 sl.getSiccodefield().sendKeys(Sicnumber);
			 Thread.sleep(2000);
			 System.out.println(" SIC Number is: " +sl.getSiccodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " SIC Number is: " +sl.getSiccodefield().getText());
			 System.out.println(" SIC Number text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " SIC Number text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getSiccodefield());
		}
		@Test(dependsOnMethods = "TC_102VerifySICFieldAcceptsNumbers")
		public void TC_103VerifySICFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSiccodefield().click();
			 String Sicnumber = elib.getDataFromExcel("SatelliteLocation", 54, 3);
			 sl.getSiccodefield().sendKeys(Sicnumber);
			 Thread.sleep(2000);
			 System.out.println(" SIC Number is: " +sl.getSiccodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " SIC Number is: " +sl.getSiccodefield().getText());
			 System.out.println(" SIC Number text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " SIC Number text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getSiccodefield());
		}
		@Test(dependsOnMethods = "TC_103VerifySICFieldAcceptsSpecialCharacters")
		public void TC_104VerifyNAICSCodeAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getNaicscodefield().click();
			 String Naicsnumber = elib.getDataFromExcel("SatelliteLocation", 56, 1);
			 sl.getNaicscodefield().sendKeys(Naicsnumber);
			 Thread.sleep(2000);
			 System.out.println(" NAICS Code is: " +sl.getNaicscodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " NAICS Code is: " +sl.getNaicscodefield().getText());
			 System.out.println(" NAICS Code text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " NAICS Code text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getNaicscodefield());
		}
		@Test(dependsOnMethods = "TC_104VerifyNAICSCodeAcceptsAlphabets")
		public void TC_105VerifyNAICSCodeAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getNaicscodefield().click();
			 String Naicsnumber = elib.getDataFromExcel("SatelliteLocation", 56, 2);
			 sl.getNaicscodefield().sendKeys(Naicsnumber);
			 Thread.sleep(2000);
			 System.out.println(" NAICS Code is: " +sl.getNaicscodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " NAICS Code is: " +sl.getNaicscodefield().getText());
			 System.out.println(" NAICS Code text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " NAICS Code text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getNaicscodefield());
		}
		@Test(dependsOnMethods = "TC_105VerifyNAICSCodeAcceptsNumbers")
		public void TC_106VerifyNAICSCodeAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getNaicscodefield().click();
			 String Naicsnumber = elib.getDataFromExcel("SatelliteLocation", 56, 3);
			 sl.getNaicscodefield().sendKeys(Naicsnumber);
			 Thread.sleep(2000);
			 System.out.println(" NAICS Code is: " +sl.getNaicscodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " NAICS Code is: " +sl.getNaicscodefield().getText());
			 System.out.println(" NAICS Code text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " NAICS Code text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getNaicscodefield());
		}
		@Test(dependsOnMethods = "TC_106VerifyNAICSCodeAcceptsSpecialCharacters")
		public void TC_107VerifyCageCodeFiledAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getCagecodefield().click();
			 String Cagecodenumber = elib.getDataFromExcel("SatelliteLocation", 58, 1);
			 sl.getCagecodefield().sendKeys(Cagecodenumber);
			 Thread.sleep(2000);
			 System.out.println(" Cage Code is: " +sl.getCagecodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Cage Code is: " +sl.getCagecodefield().getText());
			 System.out.println(" Cage Code text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Cage Code text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getCagecodefield());
		
          }
		@Test(dependsOnMethods = "TC_107VerifyCageCodeFiledAcceptsAlphabets")
		public void TC_108VerifyCageCodeFiledAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getCagecodefield().click();
			 String Cagecodenumber = elib.getDataFromExcel("SatelliteLocation", 58, 2);
			 sl.getCagecodefield().sendKeys(Cagecodenumber);
			 Thread.sleep(2000);
			 System.out.println(" Cage Code is: " +sl.getCagecodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Cage Code is: " +sl.getCagecodefield().getText());
			 System.out.println(" Cage Code text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Cage Code text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getCagecodefield());
		
		  }
		@Test(dependsOnMethods = "TC_108VerifyCageCodeFiledAcceptsNumbers")
		public void TC_109VerifyCageCodeFiledAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getCagecodefield().click();
			 String Cagecodenumber = elib.getDataFromExcel("SatelliteLocation", 58, 3);
			 sl.getCagecodefield().sendKeys(Cagecodenumber);
			 Thread.sleep(2000);
			 System.out.println(" Cage Code is: " +sl.getCagecodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Cage Code is: " +sl.getCagecodefield().getText());
			 System.out.println(" Cage Code text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Cage Code text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getCagecodefield());
		
		  }
		@Test(dependsOnMethods = "TC_109VerifyCageCodeFiledAcceptsSpecialCharacters")
		public void TC_110VerifySatelliteServiceinfoNamefieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSatelliteserviceinfonamefield().click();
			 String Satelliteserviceinfoname = elib.getDataFromExcel("SatelliteLocation", 60, 1);
			 sl.getSatelliteserviceinfonamefield().sendKeys(Satelliteserviceinfoname);
			 Thread.sleep(2000);
			 System.out.println(" Satellite Service Info Name is: " +sl.getSatelliteserviceinfonamefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Satellite Service Info Name is: " +sl.getSatelliteserviceinfonamefield().getText());
			 System.out.println(" Satellite Service Info Name text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Satellite Service Info Name text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getSatelliteserviceinfonamefield());
			 
		
		  }
		@Test(dependsOnMethods = "TC_110VerifySatelliteServiceinfoNamefieldAcceptsAlphabets")
		public void TC_111VerifySatelliteServiceinfoNamefieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSatelliteserviceinfonamefield().click();
			 String Satelliteserviceinfoname = elib.getDataFromExcel("SatelliteLocation", 60, 2);
			 sl.getSatelliteserviceinfonamefield().sendKeys(Satelliteserviceinfoname);
			 Thread.sleep(2000);
			 System.out.println(" Satellite Service Info Name is: " +sl.getSatelliteserviceinfonamefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Satellite Service Info Name is: " +sl.getSatelliteserviceinfonamefield().getText());
			 System.out.println(" Satellite Service Info Name text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Satellite Service Info Name text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getSatelliteserviceinfonamefield());
			 
		  }
		@Test(dependsOnMethods = "TC_111VerifySatelliteServiceinfoNamefieldAcceptsNumbers")
		public void TC_112VerifySatelliteServiceinfoNamefieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSatelliteserviceinfonamefield().click();
			 String Satelliteserviceinfoname = elib.getDataFromExcel("SatelliteLocation", 60, 3);
			 sl.getSatelliteserviceinfonamefield().sendKeys(Satelliteserviceinfoname);
			 Thread.sleep(2000);
			 System.out.println(" Satellite Service Info Name is: " +sl.getSatelliteserviceinfonamefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Satellite Service Info Name is: " +sl.getSatelliteserviceinfonamefield().getText());
			 System.out.println(" Satellite Service Info Name text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Satellite Service Info Name text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getSatelliteserviceinfonamefield());
			 
		  }
		@Test(dependsOnMethods = "TC_112VerifySatelliteServiceinfoNamefieldAcceptsSpecialCharacters")
		public void TC_113VerifySatelliteServiceinfoNameFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSatelliteserviceinfonamefield().click();
			 sl.ClearTextField(sl.getSatelliteserviceinfonamefield());
			 sl.SaveButton();
			 wlib.scrollToelement(driver,sl.getSatelliteserviceinfonamefield());
			 Thread.sleep(2000);
			 if(sl.getSatelliteserviceinfoNameerrormessage().isDisplayed())
			 {
				 System.out.println("Satellite Service Info Name text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Satellite Service Info Name text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Satellite Service Info Name text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Satellite Service Info Name text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_113VerifySatelliteServiceinfoNameFieldisMandatory")
		public void TC_114VerifySatelliteServiceinfoStreetFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
            //it is not an Magic Tc While running check the dependency To run independently comment dependency 
			//SatelliteLocation s1 = new SatelliteLocation(driver);
			sl.getSatelliteserviceinfostreetfield().click();
			 String Satelliteserviceinfostreet = elib.getDataFromExcel("SatelliteLocation", 62, 1);
			 sl.getSatelliteserviceinfostreetfield().sendKeys(Satelliteserviceinfostreet);
			 Thread.sleep(2000);
			 System.out.println(" Satellite Service Info Street is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Satellite Service Info Street is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 System.out.println(" Satellite Service Info Street text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Satellite Service Info Street text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getSatelliteserviceinfostreetfield());
			 
		  }
		@Test(dependsOnMethods = "TC_114VerifySatelliteServiceinfoStreetFieldAcceptsAlphabets")
		public void TC_115VerifySatelliteServiceinfoStreetFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSatelliteserviceinfostreetfield().click();
			 String Satelliteserviceinfostreet = elib.getDataFromExcel("SatelliteLocation", 62, 2);
			 sl.getSatelliteserviceinfostreetfield().sendKeys(Satelliteserviceinfostreet);
			 Thread.sleep(2000);
			 System.out.println(" Satellite Service Info Street is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Satellite Service Info Street is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 System.out.println(" Satellite Service Info Street text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Satellite Service Info Street text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getSatelliteserviceinfostreetfield());
			 
		  }
		@Test(dependsOnMethods = "TC_115VerifySatelliteServiceinfoStreetFieldAcceptsNumbers")
		public void TC_116VerifySatelliteServiceinfoStreetFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSatelliteserviceinfostreetfield().click();
			 String Satelliteserviceinfostreet = elib.getDataFromExcel("SatelliteLocation", 62, 3);
			 sl.getSatelliteserviceinfostreetfield().sendKeys(Satelliteserviceinfostreet);
			 Thread.sleep(2000);
			 System.out.println(" Satellite Service Info Street is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Satellite Service Info Street is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 System.out.println(" Satellite Service Info Street text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Satellite Service Info Street text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getSatelliteserviceinfostreetfield());
		}
		@Test(dependsOnMethods = "TC_116VerifySatelliteServiceinfoStreetFieldAcceptsSpecialCharacters")
		public void TC_117VerifySatelliteServiceinfoStreetFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSatelliteserviceinfostreetfield().click();
			 sl.ClearTextField(sl.getSatelliteserviceinfostreetfield());
			 sl.SaveButton();
			 wlib.scrollToelement(driver,sl.getSatelliteserviceinfostreetfield());
			 Thread.sleep(2000);
			 if(sl.getSatelliteserviceinfostreeterrormessage().isDisplayed())
			 {
				 System.out.println("Satellite Service Info Street text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Satellite Service Info Street text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Satellite Service Info Street text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Satellite Service Info Street text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_117VerifySatelliteServiceinfoStreetFieldisMandatory")
		public void TC_118VerifyStreetDisplayedSuggestionDropdownWhenUserEntersValidStreetName() throws InterruptedException, EncryptedDocumentException, IOException
		{
          
			
			   wlib.scrollToelement(driver, sl.getMedicalwasteservicestxt());
			sl.getSatelliteserviceinfostreetfield().click();
			 String Satelliteserviceinfostreet = elib.getDataFromExcel("SatelliteLocation", 62, 4);
			 sl.getSatelliteserviceinfostreetfield().sendKeys(Satelliteserviceinfostreet);
			 //write code click on backspace button in text field only one time to get the suggestion dropdown
			// Click the text field first
			 WebElement textField = sl.getSatelliteserviceinfostreetfield();
			 textField.click();

			 // Press Backspace only once
			 textField.sendKeys(Keys.BACK_SPACE);
			 
			 
			 
			 Thread.sleep(2000);
			 if(sl.getStreetSuggestionbox().isDisplayed())
			 {
				 System.out.println("Street suggestion dropdown is displayed when user enters valid street name: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Street suggestion dropdown is displayed when user enters valid street name: Pass");
			 }
			 else
			 {
				 System.out.println("Street suggestion dropdown is not displayed when user enters valid street name: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Street suggestion dropdown is not displayed when user enters valid street name: Fail");
			 }
			 Thread.sleep(2000);
			 sl.ClearTextField(sl.getSatelliteserviceinfostreetfield());
     
     
			 
		}
		@Test(dependsOnMethods = "TC_118VerifyStreetDisplayedSuggestionDropdownWhenUserEntersValidStreetName")
		public void TC_119VerifyStreetisAbleToSelectSuggestionnames() throws InterruptedException, EncryptedDocumentException, IOException
		{
		  
			
			 wlib.scrollToelement(driver, sl.getMedicalwasteservicestxt());
			 sl.getSatelliteserviceinfostreetfield().click();
			 //String Satelliteserviceinfostreet = elib.getDataFromExcel("SatelliteLocation", 62, 5);
			 sl.getSatelliteserviceinfostreetfield().sendKeys("1237 s");
			 Thread.sleep(2000);
			 sl.getStreetSuggestionboxfirstoption().click();
			 System.out.println("Selected Street name from suggestion dropdown is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, "Selected Street name from suggestion dropdown is: " +sl.getSatelliteserviceinfostreetfield().getText());
			 System.out.println("User is able to select street name from suggestion dropdown: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "User is able to select street name from suggestion dropdown: Pass");
			 	
         
		}
		@Test(dependsOnMethods = "TC_119VerifyStreetisAbleToSelectSuggestionnames")
		public void TC_120VerifySuiteAcceptsalphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			//scroll to suite field and click on that and pass the alphabtes
			//scroll to suite field
			 wlib.scrollToelement(driver, sl.getSuitefield());
			sl.getSuitefield().click();
			 String Suite = elib.getDataFromExcel("SatelliteLocation", 64, 1);
			 sl.getSuitefield().sendKeys(Suite);
			 Thread.sleep(2000);
			 System.out.println(" Suite is: " +sl.getSuitefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Suite is: " +sl.getSuitefield().getText());
			 System.out.println(" Suite text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Suite text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getSuitefield());
			

		}
		@Test(dependsOnMethods = "TC_120VerifySuiteAcceptsalphabets")
		public void TC_121VerifySuiteAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSuitefield().click();
			 String Suite = elib.getDataFromExcel("SatelliteLocation", 64, 2);
			 sl.getSuitefield().sendKeys(Suite);
			 Thread.sleep(2000);
			 System.out.println(" Suite is: " +sl.getSuitefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Suite is: " +sl.getSuitefield().getText());
			 System.out.println(" Suite text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Suite text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getSuitefield());
			

		}
		@Test(dependsOnMethods = "TC_121VerifySuiteAcceptsNumbers")
		public void TC_122VerifySuiteAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSuitefield().click();
			 String Suite = elib.getDataFromExcel("SatelliteLocation", 64, 3);
			 sl.getSuitefield().sendKeys(Suite);
			 Thread.sleep(2000);
			 System.out.println(" Suite is: " +sl.getSuitefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Suite is: " +sl.getSuitefield().getText());
			 System.out.println(" Suite text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Suite text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getSuitefield());
			

		}
		@Test(dependsOnMethods = "TC_122VerifySuiteAcceptsSpecialCharacters")
		public void TC_123VerifySuiteFieldisNOtMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getSuitefield().click();
			 sl.ClearTextField(sl.getSuitefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getSuitefield());
			 Thread.sleep(2000);
			 System.out.println("Suite text field is not mandatory: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Suite text field is not mandatory: Pass");
		}
		
		@Test(dependsOnMethods = "TC_123VerifySuiteFieldisNOtMandatory")
		public void TC_124VerifyCityFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getCityfield().click();
			 String City = elib.getDataFromExcel("SatelliteLocation", 66, 1);
			 sl.getCityfield().sendKeys(City);
			 Thread.sleep(2000);
			 System.out.println(" City is: " +sl.getCityfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " City is: " +sl.getCityfield().getText());
			 System.out.println(" City text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " City text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getCityfield());
		}
		@Test(dependsOnMethods = "TC_124VerifyCityFieldAcceptsAlphabets")
		public void TC_125VerifyCityFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getCityfield().click();
			 String City = elib.getDataFromExcel("SatelliteLocation", 66, 2);
			 sl.getCityfield().sendKeys(City);
			 Thread.sleep(2000);
			 System.out.println(" City is: " +sl.getCityfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " City is: " +sl.getCityfield().getText());
			 System.out.println(" City text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " City text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getCityfield());
		}
			 
		@Test(dependsOnMethods = "TC_125VerifyCityFieldAcceptsNumbers")
		public void TC_126VerifyCityFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getCityfield().click();
			 String City = elib.getDataFromExcel("SatelliteLocation", 66, 3);
			 sl.getCityfield().sendKeys(City);
			 Thread.sleep(2000);
			 System.out.println(" City is: " +sl.getCityfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " City is: " +sl.getCityfield().getText());
			 System.out.println(" City text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " City text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getCityfield());
		}
		
		@Test(dependsOnMethods = "TC_126VerifyCityFieldAcceptsSpecialCharacters")
		public void TC_127VerifyCityFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getCityfield().click();
			 sl.ClearTextField(sl.getCityfield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getCityfield());
			 Thread.sleep(2000);
			 if(sl.getCityerrormessage().isDisplayed())
			 {
				 System.out.println("City text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "City text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("City text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "City text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_127VerifyCityFieldisMandatory")
		public void TC_128VerifyStateFieldIsMandatoryField() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getStatefield().click();
			 sl.ClearTextField(sl.getStatefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getStatefield());
			 Thread.sleep(2000);
			 if(sl.getStateerrormessage().isDisplayed())
			 {
				 System.out.println("State text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "State text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("State text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "State text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_128VerifyStateFieldIsMandatoryField")
		public void TC_129VerifyStateFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getStatefield().click();
			 String State = elib.getDataFromExcel("SatelliteLocation", 68, 1);
			 sl.getStatefield().sendKeys(State);
			 Thread.sleep(2000);
			 System.out.println(" State is: " +sl.getStatefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " State is: " +sl.getStatefield().getText());
			 System.out.println(" State text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " State text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getStatefield());
		}
		@Test(dependsOnMethods = "TC_129VerifyStateFieldAcceptsAlphabets")
		public void TC_130VerifyStateFieldShouldNotAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getStatefield().click();
			 String State = elib.getDataFromExcel("SatelliteLocation", 68, 2);
			 sl.getStatefield().sendKeys(State);
			 Thread.sleep(2000);
			 System.out.println(" State is: " +sl.getStatefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " State is: " +sl.getStatefield().getText());
			//verify that state field should not accept numbers
			 if(sl.getStatefield().getText().equals(State))
			 {
				 System.out.println(" State text field accepts Numbers: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " State text field accepts Numbers: Fail");
			 }
			 else
			 {
				 System.out.println(" State text field should not accept Numbers: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " State text field should not accept Numbers: Pass");
			 }
			 sl.ClearTextField(sl.getStatefield());
		}
		@Test(dependsOnMethods = "TC_130VerifyStateFieldShouldNotAcceptsNumbers")
		public void TC_131VerifyStateFieldShouldNotAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getStatefield().click();
			 String State = elib.getDataFromExcel("SatelliteLocation", 68, 3);
			 sl.getStatefield().sendKeys(State);
			 Thread.sleep(2000);
			 System.out.println(" State is: " +sl.getStatefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " State is: " +sl.getStatefield().getText());
			//verify that state field should not accept special characters
			 if(sl.getStatefield().getText().equals(State))
			 {	
				 System.out.println(" State text field accepts Special Characters: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " State text field accepts Special Characters: Fail");
			 }
			 else
			 {
				 System.out.println(" State text field should not accept Special Characters: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " State text field should not accept Special Characters: Pass");
			 }
			 sl.ClearTextField(sl.getStatefield());
		}
		@Test(dependsOnMethods = "TC_131VerifyStateFieldShouldNotAcceptsSpecialCharacters")
		public void TC_132VerifyUserIsAbleToSelectValueFromStateDD() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			//verify that user is able to select value from state dropdown
			  wlib.scrollToelement(driver, sl.getServicesofferedtxt());
		;;;;	sl.getStatefield().click();
			List<WebElement> elements = sl.getStatelist();
			for(WebElement element : elements) {
				//click on first element in the list
				System.out.println("State dropdown values are: " +element.getText());
				if(element.getText().equals("AL")) {
					element.click();
					System.out.println("User is able to select value from state dropdown: Pass");
					utilityclassobject.gettest().log(Status.PASS, "User is able to select value from state dropdown: Pass");
				
					break;
				}
				else {
					System.out.println("User is not able to select value from state dropdown: Fail");
					utilityclassobject.gettest().log(Status.FAIL, "User is not able to select value from state dropdown: Fail");
				}
				
					
			}
			 sl.ClearTextField(sl.getStatefield());
			 //click on text field and using back space clear the value in the text field
			 sl.ClearthevalueUsingBackspace(sl.getStatefield());
			 sl.getServicesofferedtxt().click();

			
		}
		@Test(dependsOnMethods = "TC_132VerifyUserIsAbleToSelectValueFromStateDD")
		public void TC_133VerifyZipCodeFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getZipcodefield().click();
			 String Zipcode = elib.getDataFromExcel("SatelliteLocation", 70, 1);
			 sl.getZipcodefield().sendKeys(Zipcode);
			 Thread.sleep(2000);
			 System.out.println(" Zip Code is: " +sl.getZipcodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Zip Code is: " +sl.getZipcodefield().getText());
			 System.out.println(" Zip Code text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Zip Code text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getZipcodefield());
			
		}
		@Test(dependsOnMethods = "TC_133VerifyZipCodeFieldAcceptsAlphabets")
		public void TC_134VerifyZipCodeFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getZipcodefield().click();
			 String Zipcode = elib.getDataFromExcel("SatelliteLocation", 70, 2);
			 sl.getZipcodefield().sendKeys(Zipcode);
			 Thread.sleep(2000);
			 System.out.println(" Zip Code is: " +sl.getZipcodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Zip Code is: " +sl.getZipcodefield().getText());
			 System.out.println(" Zip Code text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Zip Code text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getZipcodefield());
			
		}
		@Test(dependsOnMethods = "TC_134VerifyZipCodeFieldAcceptsNumbers")
		public void TC_135VerifyZipCodeFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getZipcodefield().click();
			 String Zipcode = elib.getDataFromExcel("SatelliteLocation", 70, 3);
			 sl.getZipcodefield().sendKeys(Zipcode);
			 Thread.sleep(2000);
			 System.out.println(" Zip Code is: " +sl.getZipcodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Zip Code is: " +sl.getZipcodefield().getText());
			 System.out.println(" Zip Code text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Zip Code text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getZipcodefield());
			
		}
		@Test(dependsOnMethods = "TC_135VerifyZipCodeFieldAcceptsSpecialCharacters")
		public void TC_136VerifyZipCodeFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getZipcodefield().click();
			 sl.ClearTextField(sl.getZipcodefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getZipcodefield());
			 Thread.sleep(2000);
			 if(sl.getZipcodeerrormessage().isDisplayed())
			 {
				 System.out.println("Zip Code text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Zip Code text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Zip Code text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Zip Code text field is not mandatory: Fail");
			 }
		}
			 
		@Test(dependsOnMethods = "TC_136VerifyZipCodeFieldisMandatory")
		public void TC_137VerifyEmailfoeldAcceptsValidInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			 sl.getServiceaddressemailfield().click();
			 String Email = elib.getDataFromExcel("SatelliteLocation", 72, 1);
			 sl.getServiceaddressemailfield().sendKeys(Email);
			 Thread.sleep(2000);
			 System.out.println(" Email is: " +sl.getServiceaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Email is: " +sl.getServiceaddressemailfield().getText());
			 System.out.println(" Email text field accepts valid input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Email text field accepts valid input: Pass");
			 sl.ClearTextField(sl.getServiceaddressemailfield());
			
		}
		@Test(dependsOnMethods = "TC_137VerifyEmailfoeldAcceptsValidInput")
		public void TC_138VerifyEmailfoeldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressemailfield().click();
			 String Email = elib.getDataFromExcel("SatelliteLocation", 72, 2);
			 sl.getServiceaddressemailfield().sendKeys(Email);
			 Thread.sleep(2000);
			 System.out.println(" Email is: " +sl.getServiceaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Email is: " +sl.getServiceaddressemailfield().getText());
			 System.out.println(" Email text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Email text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getServiceaddressemailfield());
			
			
		}
		@Test(dependsOnMethods = "TC_138VerifyEmailfoeldAcceptsAlphabets")
		public void TC_139VerifyEmailfoeldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressemailfield().click();
			 String Email = elib.getDataFromExcel("SatelliteLocation", 72, 3);
			 sl.getServiceaddressemailfield().sendKeys(Email);
			 Thread.sleep(2000);
			 System.out.println(" Email is: " +sl.getServiceaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Email is: " +sl.getServiceaddressemailfield().getText());
			 System.out.println(" Email text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Email text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getServiceaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_139VerifyEmailfoeldAcceptsNumbers")
		public void TC_140VerifyEmailfoeldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressemailfield().click();
			 String Email = elib.getDataFromExcel("SatelliteLocation", 72, 4);
			 sl.getServiceaddressemailfield().sendKeys(Email);
			 Thread.sleep(2000);
			 System.out.println(" Email is: " +sl.getServiceaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Email is: " +sl.getServiceaddressemailfield().getText());
			 System.out.println(" Email text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Email text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getServiceaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_140VerifyEmailfoeldAcceptsSpecialCharacters")
		public void TC_141VerifyEmailIdShouldNotAcceptsInvalidInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressemailfield().click();
			 String Email = elib.getDataFromExcel("SatelliteLocation", 72, 5);
			 sl.getServiceaddressemailfield().sendKeys(Email);
			 Thread.sleep(2000);
			 System.out.println(" Email is: " +sl.getServiceaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Email is: " +sl.getServiceaddressemailfield().getText());
			if(sl.getServiceaddressemailformaterrormessage().isDisplayed())
			 {
				 System.out.println("Email text field should not accept invalid input: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Email text field should not accept invalid input: Pass");
			 }
			 else
			{
				 System.out.println("Email text field should accept invalid input: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Email text field should accept invalid input: Fail");
				
			}
			 sl.ClearTextField(sl.getServiceaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_141VerifyEmailIdShouldNotAcceptsInvalidInput")
		public void TC_142VerifyEmailIdShouldAcceptsvalidInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressemailfield().click();
			 String Email = elib.getDataFromExcel("SatelliteLocation", 72, 6);
			 sl.getServiceaddressemailfield().sendKeys(Email);
			 Thread.sleep(2000);
			 System.out.println(" Email is: " +sl.getServiceaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Email is: " +sl.getServiceaddressemailfield().getText());
			 wlib.scrollToelement(driver, sl.getServicesofferedtxt());
		     sl.getServicesofferedtxt().click();
		     System.out.println("Email text field should accept valid input: Pass");
		     utilityclassobject.gettest().log(Status.PASS, "Email text field should accept valid input: Pass");
			 sl.ClearTextField(sl.getServiceaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_142VerifyEmailIdShouldAcceptsvalidInput")
		public void TC_143VerifyEmailfoeldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressemailfield().click();
			 sl.ClearTextField(sl.getServiceaddressemailfield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getServiceaddressemailfield());
			 Thread.sleep(2000);
			 if(sl.getServiceaddressemailerrormessage().isDisplayed())
			 {
				 System.out.println("Email text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Email text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Email text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Email text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_143VerifyEmailfoeldisMandatory")
		public void TC_144VerifyPhoneNumberFieldAcceptsValidInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressphonefield().click();
			 String PhoneNumber = elib.getDataFromExcel("SatelliteLocation", 74, 1);
			 sl.getServiceaddressphonefield().sendKeys(PhoneNumber);
			 Thread.sleep(2000);
			 System.out.println(" Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 System.out.println(" Phone Number text field accepts valid input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Phone Number text field accepts valid input: Pass");
			 sl.ClearTextField(sl.getServiceaddressphonefield());
			
		}
		@Test(dependsOnMethods = "TC_144VerifyPhoneNumberFieldAcceptsValidInput")
		public void TC_145VerifyPhoneNumberFieldShouldNotAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressphonefield().click();
			 String PhoneNumber = elib.getDataFromExcel("SatelliteLocation", 74, 2);
			 sl.getServiceaddressphonefield().sendKeys(PhoneNumber);
			 Thread.sleep(2000);
			 System.out.println(" Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 //verify that phone number field should not accept alphabets
			 if(sl.getServiceaddressphonefield().getText().contains(PhoneNumber))
			 {
				 System.out.println(" Phone Number text field accepts Alphabets: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " Phone Number text field accepts Alphabets: Fail");
			 }
			 else
			 {
				 System.out.println(" Phone Number text field should not accept Alphabets: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " Phone Number text field should not accept Alphabets: Pass");
			 }
		}
		@Test(dependsOnMethods = "TC_145VerifyPhoneNumberFieldShouldNotAcceptsAlphabets")
		public void TC_146VerifyPhoneNumberFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressphonefield().click();
			 String PhoneNumber = elib.getDataFromExcel("SatelliteLocation", 74, 3);
			 sl.getServiceaddressphonefield().sendKeys(PhoneNumber);
			 Thread.sleep(2000);
			 System.out.println(" Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 System.out.println(" Phone Number text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Phone Number text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getServiceaddressphonefield());
		}
		@Test(dependsOnMethods = "TC_146VerifyPhoneNumberFieldAcceptsNumbers")
		public void TC_147VerifyPhoneNumberFieldShouldNotAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressphonefield().click();
			 String PhoneNumber = elib.getDataFromExcel("SatelliteLocation", 74, 4);
			 sl.getServiceaddressphonefield().sendKeys(PhoneNumber);
			 Thread.sleep(2000);
			 System.out.println(" Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Number is: " +sl.getServiceaddressphonefield().getText());
			 //verify that phone number field should not accept special characters
			 if(sl.getServiceaddressphonefield().getText().contains(PhoneNumber))
			 {
				 System.out.println(" Phone Number text field accepts Special Characters: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " Phone Number text field accepts Special Characters: Fail");
			 }
			 else
			 {
				 System.out.println(" Phone Number text field should not accept Special Characters: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " Phone Number text field should not accept Special Characters: Pass");
			 }
			
		}
		@Test(dependsOnMethods = "TC_147VerifyPhoneNumberFieldShouldNotAcceptsSpecialCharacters")
		public void TC_148VerifyPhoneNumberFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressphonefield().click();
			 sl.ClearTextField(sl.getServiceaddressphonefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getServiceaddressphonefield());
			 Thread.sleep(2000);
			 if(sl.getServiceaddressphoneerrormessage().isDisplayed())
			 {
				 System.out.println("Phone Number text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Phone Number text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Phone Number text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Phone Number text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_148VerifyPhoneNumberFieldisMandatory")
		public void TC_149VerifPhonenumberExtfieldAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			 sl.getServiceaddressphoneextfield().click();
			 String PhoneExt = elib.getDataFromExcel("SatelliteLocation", 76, 1);
			 sl.getServiceaddressphoneextfield().sendKeys(PhoneExt);
			 Thread.sleep(2000);
			 System.out.println(" Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 System.out.println(" Phone Ext text field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Phone Ext text field accepts input: Pass");
			 sl.ClearTextField(sl.getServiceaddressphoneextfield());
			
		}
		@Test(dependsOnMethods = "TC_149VerifPhonenumberExtfieldAcceptsInput")
		public void TC_150VerifyPhonenumberExtfieldShouldNotAcceptAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getServiceaddressphoneextfield().click();
			 String PhoneExt = elib.getDataFromExcel("SatelliteLocation", 76, 2);
			 sl.getServiceaddressphoneextfield().sendKeys(PhoneExt);
			 Thread.sleep(2000);
			 System.out.println(" Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 //verify that phone number ext field should not accept alphabets
			 if(sl.getServiceaddressphoneextfield().getText().contains(PhoneExt))
			 {
				 System.out.println(" Phone Ext text field accepts Alphabets: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " Phone Ext text field accepts Alphabets: Fail");
			 }
			 else
			 {
				 System.out.println(" Phone Ext text field should not accept Alphabets: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " Phone Ext text field should not accept Alphabets: Pass");
			 }
		
			
		}
		@Test(dependsOnMethods = "TC_150VerifyPhonenumberExtfieldShouldNotAcceptAlphabets")
		public void TC_151VerifyPhonenumberExtfieldAcceptNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
		     sl.getServiceaddressphoneextfield().click();
			 String PhoneExt = elib.getDataFromExcel("SatelliteLocation", 76, 3);
			 sl.getServiceaddressphoneextfield().sendKeys(PhoneExt);
			 Thread.sleep(2000);
			 System.out.println(" Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 System.out.println(" Phone Ext text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Phone Ext text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getServiceaddressphoneextfield());
		}
		@Test(dependsOnMethods = "TC_151VerifyPhonenumberExtfieldAcceptNumbers")
		public void TC_152VerifyPhonenumberExtfieldShouldNotAcceptSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getServiceaddressphoneextfield().click();
			 String PhoneExt = elib.getDataFromExcel("SatelliteLocation", 76, 4);
			 sl.getServiceaddressphoneextfield().sendKeys(PhoneExt);
			 Thread.sleep(2000);
			 System.out.println(" Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 //verify that phone number ext field should not accept special characters
			 if(sl.getServiceaddressphoneextfield().getText().contains(PhoneExt))
			 {
				 System.out.println(" Phone Ext text field accepts Special Characters: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " Phone Ext text field accepts Special Characters: Fail");
			 }
			 else
			 {
				 System.out.println(" Phone Ext text field should not accept Special Characters: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " Phone Ext text field should not accept Special Characters: Pass");
			 }

		}
		@Test(dependsOnMethods = "TC_152VerifyPhonenumberExtfieldShouldNotAcceptSpecialCharacters")
		public void TC_153VerifyPhonenumberExtfieldisNotAcceptsMoreThan5digits() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getServiceaddressphoneextfield().click();
			 String PhoneExt = elib.getDataFromExcel("SatelliteLocation", 76, 5);
			 sl.getServiceaddressphoneextfield().sendKeys(PhoneExt);
			 Thread.sleep(2000);
			 System.out.println(" Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 //verify that phone number ext field should not accept more than 5 digits
			 if(sl.getServiceaddressphoneextfield().getText().length() > 5)
			 {
				 System.out.println(" Phone Ext text field accepts more than 5 digits: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " Phone Ext text field accepts more than 5 digits: Fail");
			 }
			 else
			 {
				 System.out.println(" Phone Ext text field should not accept more than 5 digits: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " Phone Ext text field should not accept more than 5 digits: Pass");
			 }
			 sl.ClearTextField(sl.getServiceaddressphoneextfield());

		}
			
		@Test(dependsOnMethods = "TC_153VerifyPhonenumberExtfieldisNotAcceptsMoreThan5digits")
		public void TC_154VerifyPhonenumberExtfieldShouldAcceptsLessDigits() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getServiceaddressphoneextfield().click();
			 String PhoneExt = elib.getDataFromExcel("SatelliteLocation", 76, 6);
			 sl.getServiceaddressphoneextfield().sendKeys(PhoneExt);
			 Thread.sleep(2000);
			 System.out.println(" Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Phone Ext is: " +sl.getServiceaddressphoneextfield().getText());
			 //verify that phone number ext field should accept less than 5 digits
			 if(sl.getServiceaddressphoneextfield().getText().length() < 5)
			 {
				 System.out.println(" Phone Ext text field accepts less than 5 digits: Pass");
				 utilityclassobject.gettest().log(Status.PASS, " Phone Ext text field accepts less than 5 digits: Pass");
			 }
			 else
			 {
				 System.out.println(" Phone Ext text field should not accept less than 5 digits: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, " Phone Ext text field should not accept less than 5 digits: Fail");
			 }
			 sl.ClearTextField(sl.getServiceaddressphoneextfield());

		}
		@Test(dependsOnMethods = "TC_154VerifyPhonenumberExtfieldShouldAcceptsLessDigits")
		public void TC_155VerifyBillingInformationNameFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressnamefield().click();
			 String BillingInformationName = elib.getDataFromExcel("SatelliteLocation", 79, 1);
			 sl.getBillingaddressnamefield().sendKeys(BillingInformationName);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Name is: " +sl.getBillingaddressnamefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Name is: " +sl.getBillingaddressnamefield().getText());
			 System.out.println(" Billing Information Name text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Name text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddressnamefield());
		}
		@Test(dependsOnMethods = "TC_155VerifyBillingInformationNameFieldAcceptsAlphabets")
		public void TC_156VerifyBillingInformationNameFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressnamefield().click();
			 String BillingInformationName = elib.getDataFromExcel("SatelliteLocation", 79, 2);
			 sl.getBillingaddressnamefield().sendKeys(BillingInformationName);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Name is: " +sl.getBillingaddressnamefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Name is: " +sl.getBillingaddressnamefield().getText());
			 System.out.println(" Billing Information Name text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Name text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddressnamefield());
		}
		@Test(dependsOnMethods = "TC_156VerifyBillingInformationNameFieldAcceptsNumbers")
		public void TC_157VerifyBillingInformationNameFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressnamefield().click();
			 String BillingInformationName = elib.getDataFromExcel("SatelliteLocation", 79, 3);
			 sl.getBillingaddressnamefield().sendKeys(BillingInformationName);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Name is: " +sl.getBillingaddressnamefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Name is: " +sl.getBillingaddressnamefield().getText());
			 System.out.println(" Billing Information Name text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Name text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddressnamefield());
		}
		@Test(dependsOnMethods = "TC_157VerifyBillingInformationNameFieldAcceptsSpecialCharacters")
		public void TC_158VerifyBillingInformationNameFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressnamefield().click();
			 sl.ClearTextField(sl.getBillingaddressnamefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddressnamefield());
			 Thread.sleep(2000);
			 if(sl.getBillingaddressnameerrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information Name text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Name text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Name text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Name text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_158VerifyBillingInformationNameFieldisMandatory")
		public void TC_159VerifyBillingInformationStreetFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			sl.getBillingaddressstreetfield().click();
			 String BillingInformationStreet = elib.getDataFromExcel("SatelliteLocation", 81, 1);
			 sl.getBillingaddressstreetfield().sendKeys(BillingInformationStreet);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Street is: " +sl.getBillingaddressstreetfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Street is: " +sl.getBillingaddressstreetfield().getText());
			 System.out.println(" Billing Information Street text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Street text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddressstreetfield());
			
		}
		@Test(dependsOnMethods = "TC_159VerifyBillingInformationStreetFieldAcceptsAlphabets")
		public void TC_160VerifyBillingInformationStreetFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstreetfield().click();
			 String BillingInformationStreet = elib.getDataFromExcel("SatelliteLocation", 81, 2);
			 sl.getBillingaddressstreetfield().sendKeys(BillingInformationStreet);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Street is: " +sl.getBillingaddressstreetfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Street is: " +sl.getBillingaddressstreetfield().getText());
			 System.out.println(" Billing Information Street text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Street text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddressstreetfield());
		}
		@Test(dependsOnMethods = "TC_160VerifyBillingInformationStreetFieldAcceptsNumbers")
		public void TC_161VerifyBillingInformationStreetFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstreetfield().click();
			 String BillingInformationStreet = elib.getDataFromExcel("SatelliteLocation", 81, 3);
			 sl.getBillingaddressstreetfield().sendKeys(BillingInformationStreet);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Street is: " +sl.getBillingaddressstreetfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Street is: " +sl.getBillingaddressstreetfield().getText());
			 System.out.println(" Billing Information Street text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Street text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddressstreetfield());
		}
		@Test(dependsOnMethods = "TC_161VerifyBillingInformationStreetFieldAcceptsSpecialCharacters")
		public void TC_162VerifyBillingInformationStreetFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstreetfield().click();
			 sl.ClearTextField(sl.getBillingaddressstreetfield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddressstreetfield());
			 Thread.sleep(2000);
			 if(sl.getBillingaddressstreeterrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information Street text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Street text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Street text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Street text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_162VerifyBillingInformationStreetFieldisMandatory")
		public void TC_163VerifyBillingInformationShouldDisplaySuggestion() throws InterruptedException, EncryptedDocumentException, IOException
		{
			/*
			// click on street and verify is that giving any suggestion or not
			sl.getBillingaddressstreetfield().click();
			

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//div[contains(text(),'Manage addresses') or @role='option']")));
			List<WebElement> suggestions = driver.findElements(
			        By.xpath("//div[@role='option']"));

			if (!suggestions.isEmpty() && suggestions.get(0).isDisplayed()) {
			    System.out.println("Suggestion is displayed");
			    utilityclassobject.gettest().log(Status.PASS, "Suggestion is displayed");	
			} else {
			    System.out.println("Suggestion is not displayed");
			    utilityclassobject.gettest().log(Status.FAIL, "Suggestion is not displayed");
			}
			
			*/
			
		}
		@Test(dependsOnMethods = "TC_163VerifyBillingInformationShouldDisplaySuggestion")
		public void TC_164VerifyBillingInformationStreetFieldAcceptsSuggestions() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
		}
		@Test(dependsOnMethods = "TC_164VerifyBillingInformationStreetFieldAcceptsSuggestions")
		public void TC_165VerifyBillingInformationSuiteTxtfieldAcceptsAlpabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			sl.getBillingaddresssuitefield().click();
			 String BillingInformationSuite = elib.getDataFromExcel("SatelliteLocation", 83, 1);
			 sl.getBillingaddresssuitefield().sendKeys(BillingInformationSuite);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Suite is: " +sl.getBillingaddresssuitefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Suite is: " +sl.getBillingaddresssuitefield().getText());
			 System.out.println(" Billing Information Suite text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Suite text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddresssuitefield());
			
			
			
			
		}
		@Test(dependsOnMethods = "TC_165VerifyBillingInformationSuiteTxtfieldAcceptsAlpabets")
		public void TC_166VerifyBillingInformationSuiteTxtfieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresssuitefield().click();
			 String BillingInformationSuite = elib.getDataFromExcel("SatelliteLocation", 83, 2);
			 sl.getBillingaddresssuitefield().sendKeys(BillingInformationSuite);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Suite is: " +sl.getBillingaddresssuitefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Suite is: " +sl.getBillingaddresssuitefield().getText());
			 System.out.println(" Billing Information Suite text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Suite text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddresssuitefield());
		}
		@Test(dependsOnMethods = "TC_166VerifyBillingInformationSuiteTxtfieldAcceptsNumbers")
		public void TC_167VerifyBillingInformationSuiteTxtfieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresssuitefield().click();
			 String BillingInformationSuite = elib.getDataFromExcel("SatelliteLocation", 83, 3);
			 sl.getBillingaddresssuitefield().sendKeys(BillingInformationSuite);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Suite is: " +sl.getBillingaddresssuitefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Suite is: " +sl.getBillingaddresssuitefield().getText());
			 System.out.println(" Billing Information Suite text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Suite text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddresssuitefield());
		}
		@Test(dependsOnMethods = "TC_167VerifyBillingInformationSuiteTxtfieldAcceptsSpecialCharacters")
		public void TC_168VerifyBillingInformationSuiteTxtfieldisNotMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresssuitefield().click();
			 sl.ClearTextField(sl.getBillingaddresssuitefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddresssuitefield());
			 Thread.sleep(2000);
			 
				 System.out.println("Billing Information Suite text field is not mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Suite text field is not mandatory: Pass");
			 }
		@Test(dependsOnMethods = "TC_168VerifyBillingInformationSuiteTxtfieldisNotMandatory")
		public void TC_169VerifyBillingInformationCityFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresscityfield().click();
			 String BillingInformationCity = elib.getDataFromExcel("SatelliteLocation", 85, 1);
			 sl.getBillingaddresscityfield().sendKeys(BillingInformationCity);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information City is: " +sl.getBillingaddresscityfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information City is: " +sl.getBillingaddresscityfield().getText());
			 System.out.println(" Billing Information City text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information City text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddresscityfield());
		}
		@Test(dependsOnMethods = "TC_169VerifyBillingInformationCityFieldAcceptsAlphabets")
		public void TC_170VerifyBillingInformationCityFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresscityfield().click();
			 String BillingInformationCity = elib.getDataFromExcel("SatelliteLocation", 85, 2);
			 sl.getBillingaddresscityfield().sendKeys(BillingInformationCity);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information City is: " +sl.getBillingaddresscityfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information City is: " +sl.getBillingaddresscityfield().getText());
			 System.out.println(" Billing Information City text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information City text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddresscityfield());
		}
		@Test(dependsOnMethods = "TC_170VerifyBillingInformationCityFieldAcceptsNumbers")
		public void TC_171VerifyBillingInformationCityFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresscityfield().click();
			 String BillingInformationCity = elib.getDataFromExcel("SatelliteLocation", 85, 3);
			 sl.getBillingaddresscityfield().sendKeys(BillingInformationCity);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information City is: " +sl.getBillingaddresscityfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information City is: " +sl.getBillingaddresscityfield().getText());
			 System.out.println(" Billing Information City text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information City text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddresscityfield());
		}
		
		@Test(dependsOnMethods = "TC_171VerifyBillingInformationCityFieldAcceptsSpecialCharacters")
		public void TC_172VerifyBillingInformationCityFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresscityfield().click();
			 sl.ClearTextField(sl.getBillingaddresscityfield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddresscityfield());
			 Thread.sleep(2000);
			 if(sl.getBillingaddresscityerrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information City text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information City text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information City text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information City text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_172VerifyBillingInformationCityFieldisMandatory")
		public void TC_173VerifyBillingInformationStateFieldisMandatoryField() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstatefield().click();
			 sl.ClearTextField(sl.getBillingaddressstatefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddressstatefield());
			 Thread.sleep(2000);
			 if(sl.getBillingaddressstateerrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information State text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information State text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information State text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information State text field is not mandatory: Fail");
			 }
		
		}
		@Test(dependsOnMethods = "TC_173VerifyBillingInformationStateFieldisMandatoryField")
		public void TC_174VerifyBillingInformationStateFieldAcceptsAlphabtes() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstatefield().click();
			 String BillingInformationState = elib.getDataFromExcel("SatelliteLocation", 87, 1);
			 sl.getBillingaddressstatefield().sendKeys(BillingInformationState);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information State is: " +sl.getBillingaddressstatefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information State is: " +sl.getBillingaddressstatefield().getText());
			 System.out.println(" Billing Information State text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information State text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddressstatefield());
			 
		}
		@Test(dependsOnMethods = "TC_174VerifyBillingInformationStateFieldAcceptsAlphabtes")
		public void TC_175VerifyBillingInformationStateFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstatefield().click();
			 String BillingInformationState = elib.getDataFromExcel("SatelliteLocation", 87, 2);
			 sl.getBillingaddressstatefield().sendKeys(BillingInformationState);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information State is: " +sl.getBillingaddressstatefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information State is: " +sl.getBillingaddressstatefield().getText());
			 System.out.println(" Billing Information State text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information State text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddressstatefield());
		}
		@Test(dependsOnMethods = "TC_175VerifyBillingInformationStateFieldAcceptsNumbers")
		public void TC_176VerifyBillingInformationStateFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstatefield().click();
			 String BillingInformationState = elib.getDataFromExcel("SatelliteLocation", 87, 3);
			 sl.getBillingaddressstatefield().sendKeys(BillingInformationState);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information State is: " +sl.getBillingaddressstatefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information State is: " +sl.getBillingaddressstatefield().getText());
			 System.out.println(" Billing Information State text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information State text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddressstatefield());
		}
		@Test(dependsOnMethods = "TC_176VerifyBillingInformationStateFieldAcceptsSpecialCharacters")
		public void TC_177VerifyBillingInformationSateDDabletoSelectOptionFromDropdown() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressstatefield().click();
			 List<WebElement> lists = sl.getBillingaddressstatelist();
			 for(WebElement list:lists) {
				 if(list.getText().equals("Al")) {
					 list.click();
					 System.out.println("Selected State from the dropdown: " +list.getText());
					 utilityclassobject.gettest().log(Status.INFO, "Selected State from the dropdown: " +list.getText());
					 break;
				
			 }
			 }
		}
		@Test(dependsOnMethods = "TC_177VerifyBillingInformationSateDDabletoSelectOptionFromDropdown")
		public void TC_178VerifyBillingInformationZipcodeAccceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			
			sl.getBillingaddresszipcodefield().click();
			 String BillingInformationZipcode = elib.getDataFromExcel("SatelliteLocation", 89, 1);
			 sl.getBillingaddresszipcodefield().sendKeys(BillingInformationZipcode);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Zipcode is: " +sl.getBillingaddresszipcodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Zipcode is: " +sl.getBillingaddresszipcodefield().getText());
			 System.out.println(" Billing Information Zipcode text field accepts Alphabtes: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Zipcode text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddresszipcodefield());
		}
		
		@Test(dependsOnMethods = "TC_178VerifyBillingInformationZipcodeAccceptsAlphabets")
		public void TC_179VerifyBillingInformationZipcodeAccceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresszipcodefield().click();
			 String BillingInformationZipcode = elib.getDataFromExcel("SatelliteLocation", 89, 2);
			 sl.getBillingaddresszipcodefield().sendKeys(BillingInformationZipcode);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Zipcode is: " +sl.getBillingaddresszipcodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Zipcode is: " +sl.getBillingaddresszipcodefield().getText());
			 System.out.println(" Billing Information Zipcode text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Zipcode text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddresszipcodefield());
		}
		@Test(dependsOnMethods = "TC_179VerifyBillingInformationZipcodeAccceptsNumbers")
		public void TC_180VerifyBillingInformationZipcodeAccceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresszipcodefield().click();
			 String BillingInformationZipcode = elib.getDataFromExcel("SatelliteLocation", 89, 3);
			 sl.getBillingaddresszipcodefield().sendKeys(BillingInformationZipcode);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Zipcode is: " +sl.getBillingaddresszipcodefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Zipcode is: " +sl.getBillingaddresszipcodefield().getText());
			 System.out.println(" Billing Information Zipcode text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Zipcode text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddresszipcodefield());
		}
		@Test(dependsOnMethods = "TC_180VerifyBillingInformationZipcodeAccceptsSpecialCharacters")
		public void TC_181VerifyBillingInformationZipcodeFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddresszipcodefield().click();
			 sl.ClearTextField(sl.getBillingaddresszipcodefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddresszipcodefield());
			 Thread.sleep(2000);
			 if(sl.getBillingaddresszipcodeerrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information Zipcode text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Zipcode text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Zipcode text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Zipcode text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_181VerifyBillingInformationZipcodeFieldisMandatory")
		public void TC_182VerifyBillingInformationEmailFieldAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressemailfield().click();
			 String BillingInformationEmail = elib.getDataFromExcel("SatelliteLocation", 91, 1);
			 sl.getBillingaddressemailfield().sendKeys(BillingInformationEmail);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 System.out.println(" Billing Information Email text field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Email text field accepts input: Pass");
			 sl.ClearTextField(sl.getBillingaddressemailfield());
			
		}
		@Test(dependsOnMethods = "TC_182VerifyBillingInformationEmailFieldAcceptsInput")
		public void TC_183VerifyBillingInformationEmailFieldAcceptsAlphabtes() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressemailfield().click();
			 String BillingInformationEmail = elib.getDataFromExcel("SatelliteLocation", 91, 2);
			 sl.getBillingaddressemailfield().sendKeys(BillingInformationEmail);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 System.out.println(" Billing Information Email text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Email text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_183VerifyBillingInformationEmailFieldAcceptsAlphabtes")
		public void TC_184VerifyBillingInformationEmailFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressemailfield().click();
			 String BillingInformationEmail = elib.getDataFromExcel("SatelliteLocation", 91, 3);
			 sl.getBillingaddressemailfield().sendKeys(BillingInformationEmail);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 System.out.println(" Billing Information Email text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Email text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_184VerifyBillingInformationEmailFieldAcceptsNumbers")
		public void TC_185VerifyBillingInformationEmailFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressemailfield().click();
			 String BillingInformationEmail = elib.getDataFromExcel("SatelliteLocation", 91, 4);
			 sl.getBillingaddressemailfield().sendKeys(BillingInformationEmail);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 System.out.println(" Billing Information Email text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Email text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_185VerifyBillingInformationEmailFieldAcceptsSpecialCharacters")
		public void TC_186VerifyBillingInformationEmailFieldIvalidErrorMessage() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressemailfield().click();
			 String BillingInformationEmail = elib.getDataFromExcel("SatelliteLocation", 91, 5);
			 sl.getBillingaddressemailfield().sendKeys(BillingInformationEmail);
			 Thread.sleep(2000);
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddressemailfield());
			 Thread.sleep(2000);
			 if(sl.getBillingaddressemailInvaliderrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information Email text field is invalid: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Email text field is invalid: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Email text field is not invalid: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Email text field is not invalid: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_186VerifyBillingInformationEmailFieldIvalidErrorMessage")
		public void TC_187VerifyBillingInformationEmailFieldAcceptsValidFormat() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressemailfield().click();
			 String BillingInformationEmail = elib.getDataFromExcel("SatelliteLocation", 91, 6);
			 sl.getBillingaddressemailfield().sendKeys(BillingInformationEmail);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Email is: " +sl.getBillingaddressemailfield().getText());
			 System.out.println(" Billing Information Email text field accepts Valid Format: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Email text field accepts Valid Format: Pass");
			 sl.ClearTextField(sl.getBillingaddressemailfield());
		}
		@Test(dependsOnMethods = "TC_187VerifyBillingInformationEmailFieldAcceptsValidFormat")
		public void TC_188VerifyBillingInformationEmailFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressemailfield().click();
			 sl.ClearTextField(sl.getBillingaddressemailfield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getServicesofferedtxt());
			 Thread.sleep(2000);
			 if(sl.getBillingaddressemailerrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information Email text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Email text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Email text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Email text field is not mandatory: Fail");
			 }
			 
		}
		@Test(dependsOnMethods = "TC_188VerifyBillingInformationEmailFieldisMandatory")
		public void TC_189VerifyBillingInformationPhoneFieldAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphonefield().click();
			 String BillingInformationPhone = elib.getDataFromExcel("SatelliteLocation", 93, 1);
			 sl.getBillingaddressphonefield().sendKeys(BillingInformationPhone);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 System.out.println(" Billing Information Phone text field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Phone text field accepts input: Pass");
			 sl.ClearTextField(sl.getBillingaddressphonefield());
		}
		@Test(dependsOnMethods = "TC_189VerifyBillingInformationPhoneFieldAcceptsInput")
		public void TC_190VerifyBillingInformationPhoneFieldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphonefield().click();
			 String BillingInformationPhone = elib.getDataFromExcel("SatelliteLocation", 93, 2);
			 sl.getBillingaddressphonefield().sendKeys(BillingInformationPhone);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 System.out.println(" Billing Information Phone text field accepts Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Phone text field accepts Alphabets: Pass");
			 sl.ClearTextField(sl.getBillingaddressphonefield());
		}
		@Test(dependsOnMethods = "TC_190VerifyBillingInformationPhoneFieldAcceptsAlphabets")
		public void TC_191VerifyBillingInformationPhoneFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphonefield().click();
			 String BillingInformationPhone = elib.getDataFromExcel("SatelliteLocation", 93, 3);
			 sl.getBillingaddressphonefield().sendKeys(BillingInformationPhone);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 System.out.println(" Billing Information Phone text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Phone text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddressphonefield());
		}
		@Test(dependsOnMethods = "TC_191VerifyBillingInformationPhoneFieldAcceptsNumbers")
		public void TC_192VerifyBillingInformationPhoneFieldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphonefield().click();
			 String BillingInformationPhone = elib.getDataFromExcel("SatelliteLocation", 93, 4);
			 sl.getBillingaddressphonefield().sendKeys(BillingInformationPhone);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Phone is: " +sl.getBillingaddressphonefield().getText());
			 System.out.println(" Billing Information Phone text field accepts Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Phone text field accepts Special Characters: Pass");
			 sl.ClearTextField(sl.getBillingaddressphonefield());
		}
		@Test(dependsOnMethods = "TC_192VerifyBillingInformationPhoneFieldAcceptsSpecialCharacters")
		public void TC_193VerifyBillingInformationPhoneFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphonefield().click();
			 sl.ClearTextField(sl.getBillingaddressphonefield());
			 sl.SaveButton();
			 
			 wlib.scrollToelement(driver,sl.getBillingaddressphonefield());
			 Thread.sleep(2000);
			 if(sl.getBillingaddressphoneerrormessage().isDisplayed())
			 {
				 System.out.println("Billing Information Phone text field is mandatory: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Phone text field is mandatory: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Phone text field is not mandatory: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Phone text field is not mandatory: Fail");
			 }
		}
		@Test(dependsOnMethods = "TC_193VerifyBillingInformationPhoneFieldisMandatory")
		public void TC_194VerifyBillingInformationExtFieldAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			sl.getBillingaddressphoneextfield().click();
			 String BillingInformationExt = elib.getDataFromExcel("SatelliteLocation", 95, 1);
			 sl.getBillingaddressphoneextfield().sendKeys(BillingInformationExt);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 System.out.println(" Billing Information Ext text field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Ext text field accepts input: Pass");
			 sl.ClearTextField(sl.getBillingaddressphoneextfield());
		}
		@Test(dependsOnMethods = "TC_194VerifyBillingInformationExtFieldAcceptsInput")
		public void TC_195VerifyBillingInformationExtFieldShouldNotAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphoneextfield().click();
			 String BillingInformationExt = elib.getDataFromExcel("SatelliteLocation", 95, 2);
			 sl.getBillingaddressphoneextfield().sendKeys(BillingInformationExt);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 System.out.println(" Billing Information Ext text field should not accept Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Ext text field should not accept Alphabets: Pass");
			
		}
		@Test(dependsOnMethods = "TC_195VerifyBillingInformationExtFieldShouldNotAcceptsAlphabets")
		public void TC_196VerifyBillingInformationExtFieldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphoneextfield().click();
			 String BillingInformationExt = elib.getDataFromExcel("SatelliteLocation", 95, 3);
			 sl.getBillingaddressphoneextfield().sendKeys(BillingInformationExt);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 System.out.println(" Billing Information Ext text field accepts Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Ext text field accepts Numbers: Pass");
			 sl.ClearTextField(sl.getBillingaddressphoneextfield());
		}
		@Test(dependsOnMethods = "TC_196VerifyBillingInformationExtFieldAcceptsNumbers")
		public void TC_197VerifyBillingInformationExtFieldNotAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphoneextfield().click();
			 String BillingInformationExt = elib.getDataFromExcel("SatelliteLocation", 95, 4);
			 sl.getBillingaddressphoneextfield().sendKeys(BillingInformationExt);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 System.out.println(" Billing Information Ext text field should not accept Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Ext text field should not accept Special Characters: Pass");
		}
		@Test(dependsOnMethods = "TC_197VerifyBillingInformationExtFieldNotAcceptsSpecialCharacters")
		public void TC_198VerifyBillingInformationExtFieldisNotAcceptsMoreThan5digits() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getBillingaddressphoneextfield().click();
			 String BillingInformationExt = elib.getDataFromExcel("SatelliteLocation", 95, 5);
			 sl.getBillingaddressphoneextfield().sendKeys(BillingInformationExt);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 System.out.println(" Billing Information Ext text field should not accept more than 5 digits: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Ext text field should not accept more than 5 digits: Pass");
			 sl.ClearTextField(sl.getBillingaddressphoneextfield());
			
		}
		@Test(dependsOnMethods = "TC_198VerifyBillingInformationExtFieldisNotAcceptsMoreThan5digits")
		public void TC_199VerifyBillingInformationExtFieldisAcceptsShoerInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
       	    sl.getBillingaddressphoneextfield().click();
			 String BillingInformationExt = elib.getDataFromExcel("SatelliteLocation", 95, 6);
			 sl.getBillingaddressphoneextfield().sendKeys(BillingInformationExt);
			 Thread.sleep(2000);
			 System.out.println(" Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 utilityclassobject.gettest().log(Status.INFO, " Billing Information Ext is: " +sl.getBillingaddressphoneextfield().getText());
			 System.out.println(" Billing Information Ext text field should accept less than 5 digits: Pass");
			 utilityclassobject.gettest().log(Status.PASS, " Billing Information Ext text field should accept less than 5 digits: Pass");	
		}
		@Test(dependsOnMethods = "TC_199VerifyBillingInformationExtFieldisAcceptsShoerInput")
		public void TC_200VerifyServiceOfferedAutosavesTheData() throws InterruptedException, EncryptedDocumentException, IOException
		{ 
		wlib = new webDriverutility();
		// Use robust safeClick helper which tries normal click, Actions click and JS click
		boolean clicked = sl.clickBioAndSharps(wlib);
		if (clicked) {
			System.out.println("Clicked on Bio and Sharps checkbox :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Clicked on Bio and Sharps checkbox");
		} else {
			System.out.println("Failed to click on Bio and Sharps checkbox :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Failed to click on Bio and Sharps checkbox");
			// Diagnostic info
			try {
				WebElement e = sl.getBioandsharpsClickable();
				if (e != null) {
					System.out.println("Displayed: " + e.isDisplayed() + " Enabled: " + e.isEnabled() + " Text: '" + e.getText() + "' class: " + e.getAttribute("class"));
					Object centerEquals = ((JavascriptExecutor) driver).executeScript(
							"var el=arguments[0]; var r=el.getBoundingClientRect(); var x=r.left + r.width/2; var y=r.top + r.height/2; var at=document.elementFromPoint(x,y); return at===el;",
							e);
					System.out.println("Element at center equals target? " + centerEquals);
				} else {
					System.out.println("Clickable target for Bio/Sharps not found");
				}
			} catch (Exception ex) {
				System.out.println("Diagnostics failed: " + ex.getMessage());
			}
		}
		Thread.sleep(1000);
		//verify that it should dsiplay the message "Changes have been saved" after 2 seconds in right corner 
		/*if(sl.getAutosavedsuccessfullytxt().isDisplayed())
		{
			System.out.println("Autosaved successfully! message  displayed: PASS");
			utilityclassobject.gettest().log(Status.PASS, "Autosaved successfully! message  displayed");
		}
		else
		{
			System.out.println("Autosaved successfully! message  not displayed: FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Autosaved successfully! message  is not displayed");
			
		}*/
		}
		
		@Test(dependsOnMethods = "TC_200VerifyServiceOfferedAutosavesTheData")
		public void TC_201VerifyCopyBillingInformationAbleToCopyTheInformation() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			
			
			//Enter the valid data inside Satellite Service Information and click on Copy Billing Information button and verify that it should copy the information inside Billing Information section
			//sl.getSatelliteserviceinfonamefield().sendKeys("Rajeev");
			sl.getSatelliteserviceinfonamefield().click();
			//clear the text field before entering the data
			 sl.ClearTextField(sl.getSatelliteserviceinfonamefield());
			 String Satelliteserviceinfoname = elib.getDataFromExcel("SatelliteLocation", 60, 4);
			 //add random number for this name
			 Random rand = new Random();
			 int randomNum = rand.nextInt(100000); // Generates a random number between 0 and 999
			 randomName = Satelliteserviceinfoname + randomNum;
			 sl.getSatelliteserviceinfonamefield().sendKeys(randomName);
			 Thread.sleep(2000);
			

			  wlib.scrollToelement(driver, sl.getMedicalwasteservicestxt());
				sl.getSatelliteserviceinfostreetfield().click();
				 sl.ClearTextField(sl.getSatelliteserviceinfostreetfield());

				 Satelliteserviceinfostreet = elib.getDataFromExcel("SatelliteLocation", 62, 4);
				 sl.getSatelliteserviceinfostreetfield().sendKeys(Satelliteserviceinfostreet);
				 //write code click on backspace button in text field only one time to get the suggestion dropdown
				// Click the text field first
				 WebElement textField = sl.getSatelliteserviceinfostreetfield();
				 textField.click();

				 // Press Backspace only once
				 textField.sendKeys(Keys.BACK_SPACE);
				
				 
				 Thread.sleep(2000);
				 /*
				 if(sl.getStreetSuggestionbox().isDisplayed())
				 {
					 System.out.println("Street suggestion dropdown is displayed when user enters valid street name: Pass");
					 utilityclassobject.gettest().log(Status.PASS, "Street suggestion dropdown is displayed when user enters valid street name: Pass");
				 }
				 else
				 {
					 System.out.println("Street suggestion dropdown is not displayed when user enters valid street name: Fail");
					 utilityclassobject.gettest().log(Status.FAIL, "Street suggestion dropdown is not displayed when user enters valid street name: Fail");
				 }
				 */
                 sl.getStreetSuggestionboxfirstoptionFromSatellitserciveinfo().click();
				 Thread.sleep(2000);		
				 sl.getZipcodefield().click();
				 sl.ClearTextField(sl.getZipcodefield());

				 
				 Zipcode = elib.getDataFromExcel("SatelliteLocation", 70, 4);
				 sl.getZipcodefield().sendKeys(Zipcode);
				 Thread.sleep(2000);
				 sl.getServiceaddressemailfield().click();
				 sl.ClearTextField(sl.getServiceaddressemailfield());

				 String Emailname = elib.getDataFromExcel("SatelliteLocation", 72, 7);
				 //along with email add 4 digitional random number to make it unique
				 Random rand1 = new Random();
				 int randomNum1 = rand1.nextInt(10000); // Generates a random number between 0 and 9999
				 Email = Emailname + randomNum1 + "@gmail.com";
				 System.out.println("Email is: " +Email);
				 sl.getServiceaddressemailfield().sendKeys(Email);
				 Thread.sleep(2000);
				 sl.getServiceaddressphonefield().click();
				 sl.ClearTextField(sl.getServiceaddressphonefield());

				 PhoneNumber = elib.getDataFromExcel("SatelliteLocation", 74, 5);
				 sl.getServiceaddressphonefield().sendKeys(PhoneNumber);
				 Thread.sleep(2000);
				 sl.getCopytobillinginformationbutton().click();
				 
				 //fetch tha date inside name fiel which is present inside Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
				 String BillingInformationName = sl.getBillingaddressnamefield().getAttribute("value");
				 if(BillingInformationName.equals(randomName))
				 {
					 System.out.println("Billing Information Name field is copied from Satellite Service Information Name field: Pass");
					 utilityclassobject.gettest().log(Status.PASS, "Billing Information Name field is copied from Satellite Service Information Name field: Pass");
				 }
				 else
				 {
					 System.out.println("Billing Information Name field is not copied from Satellite Service Information Name field: Fail");
					 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Name field is not copied from Satellite Service Information Name field: Fail");
				 }
				 //fetch street field data from Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
				 String BillingInformationStreet = sl.getBillingaddressstreetfield().getAttribute("value");
				 if(BillingInformationStreet.equals(Satelliteserviceinfostreet))
				 {
					 System.out.println("Billing Information Street field is copied from Satellite Service Information Street field: Pass");
					 utilityclassobject.gettest().log(Status.PASS, "Billing Information Street field is copied from Satellite Service Information Street field: Pass");
				 }
				 else
				 {
					 System.out.println("Billing Information Street field is not copied from Satellite Service Information Street field: Fail");
					 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Street field is not copied from Satellite Service Information Street field: Fail");
				 }
				 //fetch zipcode field data from Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
				 String BillingInformationZipcode = sl.getBillingaddresszipcodefield().getAttribute("value");
				 if(BillingInformationZipcode.equals(Zipcode))
				 {
					 System.out.println("Billing Information Zipcode field is copied from Satellite Service Information Zipcode field: Pass");
					 utilityclassobject.gettest().log(Status.PASS, "Billing Information Zipcode field is copied from Satellite Service Information Zipcode field: Pass");
				 }
				 else
				 {
					 System.out.println("Billing Information Zipcode field is not copied from Satellite Service Information Zipcode field: Fail");
					 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Zipcode field is not copied from Satellite Service Information Zipcode field: Fail");
				 }
				 //ftech the Email id and Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
				 String BillingInformationEmail = sl.getBillingaddressemailfield().getAttribute("value");
				 if(BillingInformationEmail.equals(Email))
				 {
					 System.out.println("Billing Information Email field is copied from Satellite Service Information Email field: Pass");
					 utilityclassobject.gettest().log(Status.PASS, "Billing Information Email field is copied from Satellite Service Information Email field: Pass");
				 }
				 else
				 {
					 System.out.println("Billing Information Email field is not copied from Satellite Service Information Email field: Fail");
					 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Email field is not copied from Satellite Service Information Email field: Fail");
				 }	
				 //fetch  phone number from Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
				
				 
				 System.out.println("Billing Information section is copied from Satellite Service Information section: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information section is copied from Satellite Service Information section: Pass");
				 
		}
		@Test(dependsOnMethods = "TC_201VerifyCopyBillingInformationAbleToCopyTheInformation")
		public void TC_202VerifyAllTheDatagetPastedinSatelliteBillingInformation() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 //fetch tha date inside name fiel which is present inside Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
			 String BillingInformationName = sl.getBillingaddressnamefield().getAttribute("value");
			 if(BillingInformationName.equals(randomName))
			 {
				 System.out.println("Billing Information Name field is copied from Satellite Service Information Name field: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Name field is copied from Satellite Service Information Name field: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Name field is not copied from Satellite Service Information Name field: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Name field is not copied from Satellite Service Information Name field: Fail");
			 }
			 //fetch street field data from Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
			 String BillingInformationStreet = sl.getBillingaddressstreetfield().getAttribute("value");
			 if(BillingInformationStreet.equals(Satelliteserviceinfostreet))
			 {
				 System.out.println("Billing Information Street field is copied from Satellite Service Information Street field: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Street field is copied from Satellite Service Information Street field: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Street field is not copied from Satellite Service Information Street field: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Street field is not copied from Satellite Service Information Street field: Fail");
			 }
			 //fetch zipcode field data from Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
			 String BillingInformationZipcode = sl.getBillingaddresszipcodefield().getAttribute("value");
			 if(BillingInformationZipcode.equals(Zipcode))
			 {
				 System.out.println("Billing Information Zipcode field is copied from Satellite Service Information Zipcode field: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Zipcode field is copied from Satellite Service Information Zipcode field: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Zipcode field is not copied from Satellite Service Information Zipcode field: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Zipcode field is not copied from Satellite Service Information Zipcode field: Fail");
			 }
			 //ftech the Email id and Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
			 String BillingInformationEmail = sl.getBillingaddressemailfield().getAttribute("value");
			 if(BillingInformationEmail.equals(Email))
			 {
				 System.out.println("Billing Information Email field is copied from Satellite Service Information Email field: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Email field is copied from Satellite Service Information Email field: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Email field is not copied from Satellite Service Information Email field: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Email field is not copied from Satellite Service Information Email field: Fail");
			 }	
			 //fetch  phone number from Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
			 
			 System.out.println("Data Pasted successfully inside Satellite Billing Information: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Data Pasted successfully inside Satellite Billing Information: Pass");
			
		}
		
		@Test(dependsOnMethods = "TC_202VerifyAllTheDatagetPastedinSatelliteBillingInformation")
		public void TC_203VerifyTheSystemShouldAutoSaveTheAddress() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 //fetch street field data from Billing Information section and verify that it should match with the data which is present inside Satellite Service Information section
			 String BillingInformationStreet = sl.getBillingaddressstreetfield().getAttribute("value");
			 if(BillingInformationStreet.equals(Satelliteserviceinfostreet))
			 {
				 System.out.println("Billing Information Street field is copied from Satellite Service Information Street field: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Billing Information Street field is copied from Satellite Service Information Street field: Pass");
			 }
			 else
			 {
				 System.out.println("Billing Information Street field is not copied from Satellite Service Information Street field: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Billing Information Street field is not copied from Satellite Service Information Street field: Fail");
			 }
			 System.out.println("System should auto save the address: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "System should auto save the address: Pass");
			
		}
		@Test(dependsOnMethods = "TC_203VerifyTheSystemShouldAutoSaveTheAddress")
		public void TC_204VerifyVariousServices()
		{
			List<WebElement> services = sl.getVariousservices();
			for(WebElement service : services) {
				System.out.println("Service: " + service.getText());
				utilityclassobject.gettest().log(Status.INFO, "Service: " + service.getText());
			}
			System.out.println("Various Services are displayed: Pass");
			utilityclassobject.gettest().log(Status.PASS, "Various Services are displayed: Pass");
			
		}
		@Test(dependsOnMethods = "TC_204VerifyVariousServices")
		public void TC_205VerifyUserisAbleToslecttheServices() throws InterruptedException, EncryptedDocumentException, IOException
		{
			//comment it
			//comment it
			//comment it
			/*
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
			  
			 */
			 //comment it
			//comment it//comment it
			//comment it
			
			List<WebElement> services = sl.getVariousservices();
			for(WebElement service : services) {
				wlib.scrollToelement(driver, service);
				service.click();
				Thread.sleep(1000);
				System.out.println("Selected Service: " + service.getText());
				utilityclassobject.gettest().log(Status.INFO, "Selected Service: " + service.getText());
			}
			System.out.println("User is able to select the Services: Pass");
			utilityclassobject.gettest().log(Status.PASS, "User is able to select the Services: Pass");
			
		}
		@Test(dependsOnMethods = "TC_205VerifyUserisAbleToslecttheServices")
		public void TC_206VerifyUserisAbleToslectAllTheSubWasteByClickingOnMAinServiceType() throws InterruptedException, EncryptedDocumentException, IOException
		{
			wlib = new webDriverutility();
			wlib.safeClick(driver, sl.getAllmedicalwasteservicescheckbox());
			System.out.println("User is able to select all the sub waste by clicking on main service type: Pass");
			utilityclassobject.gettest().log(Status.PASS, "User is able to select all the sub waste by clicking on main service type: Pass");
		
			
		}
		@Test(dependsOnMethods = "TC_206VerifyUserisAbleToslectAllTheSubWasteByClickingOnMAinServiceType")
		public void TC_207VerifyUserisAbletoSelectIndividually() throws InterruptedException, EncryptedDocumentException, IOException
		{
			wlib = new webDriverutility();
			wlib.safeClick(driver, sl.getAllmedicalwasteservicescheckbox());
			//List<WebElement> services = sl.getVariousservices();
			List<WebElement> individualcheckboxes = sl.getAllmedicalwasteservicesindividualcheckboxes();
			for(WebElement checkbox:individualcheckboxes)
			{
				checkbox.click();
				Thread.sleep(1000);
				System.out.println("User is able to select the individual sub waste " );
				utilityclassobject.gettest().log(Status.INFO, "User is able to select the individual sub waste ");
			}
			System.out.println("User is able to select the individual sub waste: Pass");
			utilityclassobject.gettest().log(Status.PASS, "User is able to select the individual sub waste: Pass");
			
			
		}
		@Test(dependsOnMethods = "TC_207VerifyUserisAbletoSelectIndividually")
		public void TC_208VerifyUserisNotAbletoDeselectDisabledCheckbox() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getRecyclingcheckboxdisabled().click();
			//verify this should not selcect it sgoud fail to click
			if(sl.getRecyclingcheckboxdisabled().isSelected())
			{
				System.out.println("User is able to select the disabled checkbox: Fail");
				utilityclassobject.gettest().log(Status.FAIL, "User is able to select the disabled checkbox: Fail");
			}
			else
			{
				System.out.println("User is not able to select the disabled checkbox: Pass");
				utilityclassobject.gettest().log(Status.PASS, "User is not able to select the disabled checkbox: Pass");
			}
			
			
		}
		@Test(dependsOnMethods = "TC_208VerifyUserisNotAbletoDeselectDisabledCheckbox")
		public void TC_209VerifyUserisAbletoDeselecttheSelectedCheckbox() throws InterruptedException, EncryptedDocumentException, IOException
		{
			List<WebElement> individualcheckboxes = sl.getAllmedicalwasteservicesindividualcheckboxes();
			for(WebElement checkbox:individualcheckboxes)
			{
				checkbox.click();
				Thread.sleep(1000);
				System.out.println("User is able to deselect the individual sub waste " );
				utilityclassobject.gettest().log(Status.INFO, "User is able to deselect the individual sub waste ");
			}	
			System.out.println("User is able to deselect the individual sub waste: Pass");
			utilityclassobject.gettest().log(Status.PASS, "User is able to deselect the individual sub waste: Pass");
		}
		@Test(dependsOnMethods = "TC_209VerifyUserisAbletoDeselecttheSelectedCheckbox")
		public void TC_210VerifyUserisAbletoDeselecttheSelectedMainServiceTypeCheckbox() throws InterruptedException, EncryptedDocumentException, IOException
		{
			wlib = new webDriverutility();
			wlib.safeClick(driver, sl.getAllmedicalwasteservicescheckbox());
			System.out.println("User is able to select the main service type checkbox: Pass");
			utilityclassobject.gettest().log(Status.PASS, "User is able to select the main service type checkbox: Pass");
			wlib = new webDriverutility();
			wlib.safeClick(driver, sl.getAllmedicalwasteservicescheckbox());
			System.out.println("User is able to deselect the main service type checkbox: Pass");
			utilityclassobject.gettest().log(Status.PASS, "User is able to deselect the main service type checkbox: Pass");
			
			
		}
		@Test(dependsOnMethods = "TC_210VerifyUserisAbletoDeselecttheSelectedMainServiceTypeCheckbox")
		public void TC_211VerifyDispatchDepartmentEmailFieldAcceptsInputs() throws InterruptedException, EncryptedDocumentException, IOException
		{
		  sl.getDispatchemailfield().click();
		  String email = elib.getDataFromExcel("SatelliteLocation", 98, 1);
		  sl.getDispatchemailfield().sendKeys(email);
		  System.out.println("Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
		  utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
		  System.out.println("Dispatch Department Email field accepts input: Pass");
		  utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Email field accepts input: Pass");
		  //clear the field
		  sl.ClearTextField(sl.getDispatchemailfield());
		
		}
		@Test(dependsOnMethods = "TC_211VerifyDispatchDepartmentEmailFieldAcceptsInputs")
		public void TC_212VerifyDispatchDepartmentEmailFieldShouldAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchemailfield().click();
			 String email = elib.getDataFromExcel("SatelliteLocation", 98, 2);
			 sl.getDispatchemailfield().sendKeys(email);
			 System.out.println("Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 System.out.println("Dispatch Department Email field should accept Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Email field should accept Alphabets: Pass");
			 sl.ClearTextField(sl.getDispatchemailfield());
		}
		@Test(dependsOnMethods = "TC_212VerifyDispatchDepartmentEmailFieldShouldAcceptsAlphabets")
		public void TC_213VerifyDispatchDepartmentEmailFieldShouldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchemailfield().click();
			 String email = elib.getDataFromExcel("SatelliteLocation", 98, 3);
			 sl.getDispatchemailfield().sendKeys(email);
			 System.out.println("Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 System.out.println("Dispatch Department Email field should accept Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Email field should accept Numbers: Pass");
			 sl.ClearTextField(sl.getDispatchemailfield());
		}
		@Test(dependsOnMethods = "TC_213VerifyDispatchDepartmentEmailFieldShouldAcceptsNumbers")
		public void TC_214VerifyDispatchDepartmentEmailFieldShouldAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchemailfield().click();
			 String email = elib.getDataFromExcel("SatelliteLocation", 98, 4);
			 sl.getDispatchemailfield().sendKeys(email);
			 System.out.println("Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 System.out.println("Dispatch Department Email field should accept Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Email field should accept Special Characters: Pass");
			 sl.ClearTextField(sl.getDispatchemailfield());
		}
		@Test(dependsOnMethods = "TC_214VerifyDispatchDepartmentEmailFieldShouldAcceptsSpecialCharacters")
		public void TC_215VerifyDispatchDepartmentEmailFieldShouldNotAcceptsInValidEmail() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchemailfield().click();
			 String email = elib.getDataFromExcel("SatelliteLocation", 98, 5);
			 sl.getDispatchemailfield().sendKeys(email);
			 sl.getDispatchdepartmenttxt().click();
			 if(sl.getDispatchemailinvaliderrormessage().isDisplayed())
			 {
				 System.out.println("Dispatch Department Email field should not accept invalid email: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Email field should not accept invalid email: Pass");
			 }
			 else
			 {
				 System.out.println("Dispatch Department Email field should not accept invalid email: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Dispatch Department Email field should not accept invalid email: Fail");
			 }


		}
		@Test(dependsOnMethods = "TC_215VerifyDispatchDepartmentEmailFieldShouldNotAcceptsInValidEmail")
		public void TC_216VerifyDispatchDepartmentEmailFieldShouldAcceptsValidEmail() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchemailfield().click();
			 String emailname = elib.getDataFromExcel("SatelliteLocation", 98, 6);
			 //for this email name add 5digit random number and then add @gmail.com to make it unique
			 Random rand = new Random();
			 int randomNum = rand.nextInt(100000); // Generates a random number between 0 and 99999
			 String email = emailname + randomNum + "@gmail.com";
			 sl.getDispatchemailfield().sendKeys(email);
			 sl.getDispatchdepartmenttxt().click();
			 System.out.println("Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Email is: " +sl.getDispatchemailfield().getAttribute("value"));
			 System.out.println("Dispatch Department Email field should accept valid email: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Email field should accept valid email: Pass");
			 sl.ClearTextField(sl.getDispatchemailfield());

			
		}
		@Test(dependsOnMethods = "TC_216VerifyDispatchDepartmentEmailFieldShouldAcceptsValidEmail")
		public void TC_217VerifyDispatchDepartmentEmailFieldISMandatoryField()
		{
			sl.getDispatchemailfield().click();
			//click on save button 
			sl.SaveButton();
			// sl.getDispatchdepartmenttxt().click();
			//scroll back to top Email field
			 wlib.scrollToelement(driver, sl.getDispatchemailrequirederrormessage());
			 if(sl.getDispatchemailrequirederrormessage().isDisplayed())
			 {
				 System.out.println("Dispatch Department Email field is mandatory field: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Email field is mandatory field: Pass");
			 }
			 else
			 {
				 System.out.println("Dispatch Department Email field is not mandatory field: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Dispatch Department Email field is not mandatory field: Fail");
			 }
		}
		
		@Test(dependsOnMethods = "TC_217VerifyDispatchDepartmentEmailFieldISMandatoryField")
		public void TC_218VerifyDispatchDepartmentPhoneFieldAcceptsInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			wlib.scrollToelement(driver, sl.getDispatchphonenumberfield());
			sl.getDispatchphonenumberfield().click();
			 String phone = elib.getDataFromExcel("SatelliteLocation", 100, 1);
			 sl.getDispatchphonenumberfield().sendKeys(phone);
			 System.out.println("Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 System.out.println("Dispatch Department Phone field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Phone field accepts input: Pass");
			 sl.ClearTextField(sl.getDispatchphonenumberfield());
			
		}
		@Test(dependsOnMethods = "TC_218VerifyDispatchDepartmentPhoneFieldAcceptsInput")
		public void TC_219VerifyDispatchDepartmentPhoneFieldShouldNotAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{	
			sl.getDispatchphonenumberfield().click();
			 String phone = elib.getDataFromExcel("SatelliteLocation", 100, 2);
			 sl.getDispatchphonenumberfield().sendKeys(phone);
			 sl.getDispatchdepartmenttxt().click();
			 System.out.println("Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 System.out.println("Dispatch Department Phone field should not accept Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Phone field should not accept Alphabets: Pass");
			
		}
		@Test(dependsOnMethods = "TC_219VerifyDispatchDepartmentPhoneFieldShouldNotAcceptsAlphabets")
		public void TC_220VerifyDispatchDepartmentPhoneFieldShouldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchphonenumberfield().click();
			 String phone = elib.getDataFromExcel("SatelliteLocation", 100, 3);
			 sl.getDispatchphonenumberfield().sendKeys(phone);
			 System.out.println("Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 System.out.println("Dispatch Department Phone field should accept Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Phone field should accept Numbers: Pass");
			 //clear the field
			 sl.ClearTextField(sl.getDispatchphonenumberfield());
		}
		@Test(dependsOnMethods = "TC_220VerifyDispatchDepartmentPhoneFieldShouldAcceptsNumbers")	
		public void TC_221VerifyDispatchDepartmentPhoneFieldShouldNotAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchphonenumberfield().click();
			 String phone = elib.getDataFromExcel("SatelliteLocation", 100, 4);
			 sl.getDispatchphonenumberfield().sendKeys(phone);
			 sl.getDispatchdepartmenttxt().click();
			 System.out.println("Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Phone is: " +sl.getDispatchphonenumberfield().getAttribute("value"));
			 System.out.println("Dispatch Department Phone field should not accept Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Phone field should not accept Special Characters: Pass");
		}
		@Test(dependsOnMethods = "TC_221VerifyDispatchDepartmentPhoneFieldShouldNotAcceptsSpecialCharacters")
		public void TC_222VerifyDispatchDepartmentPhoneFieldisMandatory() throws InterruptedException, EncryptedDocumentException, IOException
		{
		 sl.SaveButton();
		 if(sl.getDispatchphonenumbererrormessage().isDisplayed())
		 {
			 System.out.println("Dispatch Department Phone field is mandatory: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Phone field is mandatory: Pass");
		 }
		 else
		 {
			 System.out.println("Dispatch Department Phone field is not mandatory: Fail");
			 utilityclassobject.gettest().log(Status.FAIL, "Dispatch Department Phone field is not mandatory: Fail");
		 }
		}
		
		@Test(dependsOnMethods = "TC_222VerifyDispatchDepartmentPhoneFieldisMandatory")
		public void TC_223VerifyDispatchDepartmentPhoneExtfieldAcceptsInput() throws EncryptedDocumentException, IOException, InterruptedException
		{
			
			sl.getDispatchphonenumberextfield().click();
			 String ext = elib.getDataFromExcel("SatelliteLocation", 102, 1);
			 sl.getDispatchphonenumberextfield().sendKeys(ext);
			 System.out.println("Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 System.out.println("Dispatch Department Ext field accepts input: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Ext field accepts input: Pass");
			 //celar thr field
			 sl.ClearTextField(sl.getDispatchphonenumberextfield());
		}
		@Test(dependsOnMethods = "TC_223VerifyDispatchDepartmentPhoneExtfieldAcceptsInput")
		public void TC_224VerifyDispatchDepartmentPhoneExtfieldShouldNotAcceptsAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchphonenumberextfield().click();
			 String ext = elib.getDataFromExcel("SatelliteLocation", 102, 2);
			 sl.getDispatchphonenumberextfield().sendKeys(ext);
			 sl.getDispatchdepartmenttxt().click();
			 System.out.println("Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 System.out.println("Dispatch Department Ext field should not accept Alphabets: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Ext field should not accept Alphabets: Pass");
			// sl.ClearTextField(sl.getDispatchphonenumberextfield());

		}
		@Test(dependsOnMethods = "TC_224VerifyDispatchDepartmentPhoneExtfieldShouldNotAcceptsAlphabets")
		public void TC_225VerifyDispatchDepartmentPhoneExtfieldShouldAcceptsNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchphonenumberextfield().click();
			 String ext = elib.getDataFromExcel("SatelliteLocation", 102, 3);
			 sl.getDispatchphonenumberextfield().sendKeys(ext);
			 System.out.println("Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 System.out.println("Dispatch Department Ext field should accept Numbers: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Ext field should accept Numbers: Pass");
			 //clear the field
			 sl.ClearTextField(sl.getDispatchphonenumberextfield());
		}
		@Test(dependsOnMethods = "TC_225VerifyDispatchDepartmentPhoneExtfieldShouldAcceptsNumbers")
		public void TC_226VerifyDispatchDepartmentPhoneExtfieldShouldNotAcceptsSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			sl.getDispatchphonenumberextfield().click();
			 String ext = elib.getDataFromExcel("SatelliteLocation", 102, 4);
			 sl.getDispatchphonenumberextfield().sendKeys(ext);
			 sl.getDispatchdepartmenttxt().click();
			 System.out.println("Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 utilityclassobject.gettest().log(Status.INFO, "Dispatch Department Ext is: " +sl.getDispatchphonenumberextfield().getAttribute("value"));
			 System.out.println("Dispatch Department Ext field should not accept Special Characters: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Ext field should not accept Special Characters: Pass");
		}
		@Test(dependsOnMethods = "TC_226VerifyDispatchDepartmentPhoneExtfieldShouldNotAcceptsSpecialCharacters")
		public void TC_227VerifyDispatchDepartmentPhoneExtFieldShouldNotAcceptsMorethan6digits() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getDispatchphonenumberextfield().click();
			 String ext = elib.getDataFromExcel("SatelliteLocation", 102, 5);
			 sl.getDispatchphonenumberextfield().sendKeys(ext);
			 sl.getDispatchdepartmenttxt().click();
			 String extvalue = sl.getDispatchphonenumberextfield().getAttribute("value");
			 if(extvalue.length()<=6)
			 {
				 System.out.println("Dispatch Department Ext field should not accept more than 6 digits: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Ext field should not accept more than 6 digits: Pass");
			 }
			 else
			 {
				 System.out.println("Dispatch Department Ext field should not accept more than 6 digits: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Dispatch Department Ext field should not accept more than 6 digits: Fail");
			 }
			 sl.ClearTextField(sl.getDispatchphonenumberextfield());

			 
		}
		@Test(dependsOnMethods = "TC_227VerifyDispatchDepartmentPhoneExtFieldShouldNotAcceptsMorethan6digits")
		public void TC_228VerifyDispatchDepartmentPhoneExtFieldShouldAcceptsShortInputs() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 sl.getDispatchphonenumberextfield().click();
			 String ext = elib.getDataFromExcel("SatelliteLocation", 102, 6);
			 sl.getDispatchphonenumberextfield().sendKeys(ext);
			 sl.getDispatchdepartmenttxt().click();
			 String extvalue = sl.getDispatchphonenumberextfield().getAttribute("value");
			if(extvalue.length()<=5)
			 {
				 System.out.println("Dispatch Department Ext field should accept short inputs: Pass");
				 utilityclassobject.gettest().log(Status.PASS, "Dispatch Department Ext field should accept short inputs: Pass");
			 }
			 else
			 {
				 System.out.println("Dispatch Department Ext field should not accept more than 6 digits: Fail");
				 utilityclassobject.gettest().log(Status.FAIL, "Dispatch Department Ext field should not accept more than 6 digits: Fail");
			 }
			 sl.ClearTextField(sl.getDispatchphonenumberextfield());
			 
		}		
		@Test(dependsOnMethods = "TC_228VerifyDispatchDepartmentPhoneExtFieldShouldAcceptsShortInputs")
		public void TC_229VerifyClikingOnSaveBittonShouldSavesTheData() throws InterruptedException, EncryptedDocumentException, IOException
		{
			 String companyname = elib.getDataFromExcel("SatelliteLocation", 105, 1);
			sl.getCompanydisplaynamefield().sendKeys(companyname);
			 String generalphone = elib.getDataFromExcel("SatelliteLocation", 105, 2);
			sl.getGeneralphonefield().sendKeys(generalphone);
			 String registrationnumber1 = elib.getDataFromExcel("SatelliteLocation", 105, 3);
			sl.getRegistrationnumber1field().sendKeys(registrationnumber1);
			sl.getDispatchemailfield().click();
			 String emailname = elib.getDataFromExcel("SatelliteLocation", 105, 4);
			 List<WebElement> services = sl.getVariousservices();
				for(WebElement service : services) {
					wlib.scrollToelement(driver, service);
					service.click();
					Thread.sleep(1000);
					System.out.println("Selected Service: " + service.getText());
					utilityclassobject.gettest().log(Status.INFO, "Selected Service: " + service.getText());
				}
			 //for this email name add 5digit random number and then add @gmail.com to make it unique
			 Random rand = new Random();
			 int randomNum = rand.nextInt(100000); // Generates a random number between 0 and 99999
			 String email = emailname + randomNum + "@gmail.com";
			 sl.getDispatchemailfield().sendKeys(email);
			 sl.getDispatchphonenumberfield().click();
			 String phone = elib.getDataFromExcel("SatelliteLocation", 105, 5);
			 sl.getDispatchphonenumberfield().sendKeys(phone);
			 wlib.scrollToelement(driver, sl.getCompanynamefield());
			 //fetch the company name 
			 companynamevalue = sl.getCompanydisplaynamefield().getAttribute("value");
			 System.out.println("Company Name is: " +companynamevalue);
			 //fetch street field data
			 streetaddress = sl.getSatelliteserviceinfostreetfield().getAttribute("value");
			 System.out.println("Street Address is: " +streetaddress);
			 utilityclassobject.gettest().log(Status.INFO, "Street Address is: " +streetaddress);
			   //fetch dispatch phonenumber
			 dispatchphonenumber = sl.getDispatchphonenumberfield().getAttribute("value");
			 System.out.println("Dispatch Phone Number is: " +dispatchphonenumber);
			 //fetch satellite location dropdoen status dropdown
			 status = sl.getSatellitelocationstatusdropdownfieldtext().getText();
			 System.out.println("Satellite Location Status is: " +status);
			// Diagnostic: print expected values (useful when list display truncates or formats values)
			System.out.println("[DIAG] Expected - companynamevalue='" + companynamevalue + "', streetaddress='" + streetaddress + "', dispatchphonenumber='" + dispatchphonenumber + "', status='" + status + "'");
			utilityclassobject.gettest().log(Status.INFO, "[DIAG] Expected - companynamevalue='" + companynamevalue + "', streetaddress='" + streetaddress + "', dispatchphonenumber='" + dispatchphonenumber + "', status='" + status + "'");
			 sl.SaveButton();
			 Thread.sleep(2000);			 System.out.println("Clicking on Save button should save the data: Pass");
			 utilityclassobject.gettest().log(Status.PASS, "Clicking on Save button should save the data: Pass");
		}
		@Test(dependsOnMethods = "TC_229VerifyClikingOnSaveBittonShouldSavesTheData")
		public void TC_230VerifySavedSatelliteLocationIspresentInSatelliteLocationLists() throws InterruptedException, EncryptedDocumentException, IOException
		{
			/*
			elib=new ExcelUtility();
			hp = new HomePage(driver);
			utilityclassobject.gettest().log(com.aventstack.extentreports.Status.INFO, "Home Page is displayed");
			System.out.println("Home Page is displayed");
			Thread.sleep(6000);
			sl = new SatelliteLocation(driver);
			sl.getAssets().click();
			sl.getSatellite_Locations().click();
			*/
			sl.getSatellitelocationslink().click();
			
			//refresh the page
			driver.navigate().refresh();
			Thread.sleep(5000);
			
			List<WebElement> lists = sl.getSatellitenamelists();
			boolean found = false;
			//System.out.println("[DIAG] TC_230 expected companynamevalue='" + companynamevalue + "'. List size=" + lists.size());
			for (WebElement list : lists) {
		
				
					String name = list.getText();
					if(name.equals(satellitname))
					{
						System.out.println("Saved Satellite Location is present in Satellite Location Lists: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Saved Satellite Location is present in Satellite Location Lists: Pass");
						break;
					}
					else
					{
						System.out.println("Saved Satellite Location is not present in Satellite Location Lists: Fail");
						utilityclassobject.gettest().log(Status.FAIL, "Saved Satellite Location is not present in Satellite Location Lists: Fail");
					}
			}
			
		}
		@Test(dependsOnMethods = "TC_230VerifySavedSatelliteLocationIspresentInSatelliteLocationLists")
		public void TC_231VerifyNameOftheSatelliteisPresentInsideSatelliteLists()
		{
			List<WebElement> lists = sl.getSatellitenamelists();
			for(WebElement list:lists)
			{
				String name = list.getText();
				if(name.equals(satellitname))
				{
					System.out.println("Saved Satellite Location is present in Satellite Location Lists: Pass");
					utilityclassobject.gettest().log(Status.PASS, "Saved Satellite Location is present in Satellite Location Lists: Pass");
					break;
				}
				else
				{
					System.out.println("Saved Satellite Location is not present in Satellite Location Lists: Fail");
					utilityclassobject.gettest().log(Status.FAIL, "Saved Satellite Location is not present in Satellite Location Lists: Fail");
				}
			}
			
			
			
		}
		@Test(dependsOnMethods = "TC_231VerifyNameOftheSatelliteisPresentInsideSatelliteLists")
		public void TC_232VerifyAddressoftheSatellteisPresentInsideSatelliteLocationslist() throws InterruptedException, EncryptedDocumentException, IOException
		{
			List<WebElement> namelists = sl.getSatellitenamelists();
			for(WebElement list:namelists)
			{
				String name = list.getText();
				if(name.equals(satellitname))
				{
					String actulaadress = driver.findElement(By.xpath("(//div[text()='"+companynamevalue+"']/../descendant::div)[3]")).getText();
					if(actulaadress.equals(streetaddress))
					{
						System.out.println("Saved Satellite Location Address is present in Satellite Location Lists: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Saved Satellite Location Address is present in Satellite Location Lists: Pass");
						break;
					}
					else
					{
						System.out.println("Saved Satellite Location Address is not present in Satellite Location Lists: Fail");
						utilityclassobject.gettest().log(Status.FAIL, "Saved Satellite Location Address is not present in Satellite Location Lists: Fail");
					}
					
				}
			}
		}
		@Test(dependsOnMethods = "TC_232VerifyAddressoftheSatellteisPresentInsideSatelliteLocationslist")
		public void TC_233VerifyDispatchPhoneNumberoftheSatellteisPresentInsideSatelliteLocationslist() throws InterruptedException, EncryptedDocumentException, IOException
		{
			List<WebElement> namelists = sl.getSatellitenamelists();
			for(WebElement list:namelists)
			{
				String name = list.getText();
				if(name.equals(satellitname))
				{
					String actulaphonenumber = driver.findElement(By.xpath("(//div[text()='"+satellitname+"']/../descendant::div)[4]")).getText();
					if(actulaphonenumber.equals(dispatchphonenumber))
					{
						System.out.println("Saved Satellite Location Dispatch Phone Number is present in Satellite Location Lists: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Saved Satellite Location Dispatch Phone Number is present in Satellite Location Lists: Pass");
						break;
					}
					else
					{
						System.out.println("Saved Satellite Location Dispatch Phone Number is not present in Satellite Location Lists: Fail");
						utilityclassobject.gettest().log(Status.FAIL, "Saved Satellite Location Dispatch Phone Number is not present in Satellite Location Lists: Fail");
					}
					
				}
			}
			
		}
		@Test(dependsOnMethods = "TC_233VerifyDispatchPhoneNumberoftheSatellteisPresentInsideSatelliteLocationslist")
		public void TC_234VerifyEmailoftheSatellteisPresentInsideSatelliteLocationslist() throws InterruptedException, EncryptedDocumentException, IOException
		{
			List<WebElement> namelists = sl.getSatellitenamelists();
			for(WebElement list:namelists)
			{
				String name = list.getText();
				if(name.equals(satellitname))
				{
					String actulemail = driver.findElement(By.xpath("(//div[text()='"+satellitname+"']/../descendant::div)[5]")).getText();
					if(actulemail.equals(Email))
					{
						System.out.println("Saved Satellite Location Email is present in Satellite Location Lists: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Saved Satellite Location Email is present in Satellite Location Lists: Pass");
						break;
					}
					else
					{
						System.out.println("Saved Satellite Location Email is not present in Satellite Location Lists: Fail");
						utilityclassobject.gettest().log(Status.FAIL, "Saved Satellite Location Email is not present in Satellite Location Lists: Fail");
					}

				}
			}
			
		}
		@Test(dependsOnMethods = "TC_234VerifyEmailoftheSatellteisPresentInsideSatelliteLocationslist")
		public void TC_235VerifyStatusoftheSatellteisPresentInsideSatelliteLocationslist() throws InterruptedException, EncryptedDocumentException, IOException
		{
			List<WebElement> namelists = sl.getSatellitenamelists();
			for(WebElement list:namelists)
			{
				String name = list.getText();
				if(name.equals(satellitname))
				{
					String actulastatus = driver.findElement(By.xpath("(//div[text()='"+satellitname+"']/../descendant::div)[6]")).getText();
					if(actulastatus.equals(status))
					{
						System.out.println("Saved Satellite Location Status is present in Satellite Location Lists: Pass");
						utilityclassobject.gettest().log(Status.PASS, "Saved Satellite Location Status is present in Satellite Location Lists: Pass");
						break;
					}
					else
					{
						System.out.println("Saved Satellite Location Status is not present in Satellite Location Lists: Fail");
						utilityclassobject.gettest().log(Status.FAIL, "Saved Satellite Location Status is not present in Satellite Location Lists: Fail");
					}

				}
			}
			
		}
		@Test(dependsOnMethods = "TC_235VerifyStatusoftheSatellteisPresentInsideSatelliteLocationslist")
		public void TC_236VerifySatelliteisAbletoExport() throws InterruptedException, EncryptedDocumentException, IOException
		{
			List<WebElement> namelists = sl.getSatellitenamelists();
			for(WebElement list:namelists)
			{
				String name = list.getText();
				if(name.equals(satellitname))
				{
					WebElement checkbox = driver.findElement(By.xpath("(//div[text()='"+satellitname+"']/../descendant::div)[1]"));
					checkbox.click();
					sl.getExportbutton().click();
					Thread.sleep(3000);
					System.out.println("User is able to export the Satellite Location: Pass");
					utilityclassobject.gettest().log(Status.PASS, "User is able to export the Satellite Location: Pass");
					break;
				}
			}
			
		}
		
		
		
}