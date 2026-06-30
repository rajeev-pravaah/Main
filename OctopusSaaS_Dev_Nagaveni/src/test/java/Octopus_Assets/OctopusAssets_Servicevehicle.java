package Octopus_Assets;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseclassforServicevehicle;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AssetsServicevehicle;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class OctopusAssets_Servicevehicle extends BaseclassforServicevehicle {
	ExcelUtility elib;
	AssetsServicevehicle as;
	String nicknameinput;
	String addedvehicleID;
	String input;
	String input1;
	String editnickname;
	String input2;
	
	@Test(priority = 1)
	public void TC_001AssetsServicevehicel_withservicevehiclepage() throws InterruptedException
	{
		elib = new ExcelUtility();
		as = new AssetsServicevehicle(driver);
		as.Servicevehicle();
		utilityclassobject.gettest().log(Status.INFO, "System is redirected the user to the Servicevehicle page");
		Thread.sleep(2000);	
	}
	
	
	@Test(dependsOnMethods = "TC_001AssetsServicevehicel_withservicevehiclepage")
	public void TC_002AssetsServicevehicle_withTooltip() throws InterruptedException
	{
		as.getServicetooltip().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "The user is able to see the octo info");
	}
	
	@Test(dependsOnMethods = "TC_002AssetsServicevehicle_withTooltip")
	public void TC_003AssetsServicevehicle_withAddnew() throws InterruptedException
	{
		as.getAddnewService().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "The user is able to add a new service vehicles");
	}
	
	@Test(dependsOnMethods = "TC_003AssetsServicevehicle_withAddnew")
	public void TC_004AssetsServicevehicle_FirstnamewithInput() throws EncryptedDocumentException, IOException
	{
		as.getNickname().click();
		as.getNickname().sendKeys(Keys.CONTROL + "a");
		as.getNickname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Servicevehicle", 1, 1);
		as.getNickname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Nickname textfield will accept input");
	}
	
	@Test(dependsOnMethods = "TC_004AssetsServicevehicle_FirstnamewithInput")
	public void TC_005Assetsservicevehicle_Firstnamewithalphabets() throws EncryptedDocumentException, IOException
	{
		as.getNickname().click();
		as.getNickname().sendKeys(Keys.CONTROL + "a");
		as.getNickname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Servicevehicle", 1, 2);
		as.getNickname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Nickname textfield will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_005Assetsservicevehicle_Firstnamewithalphabets")
	public void TC_006AssetsServicevehicle_Firstnamewithnumbers() throws EncryptedDocumentException, IOException
	{
		as.getNickname().click();
		as.getNickname().sendKeys(Keys.CONTROL + "a");
		as.getNickname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Servicevehicle", 1, 3);
		as.getNickname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Nickname textfield will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_006AssetsServicevehicle_Firstnamewithnumbers")
	public void TC_007AssetsServicevehicle_Firstnamewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		as.getNickname().click();
		as.getNickname().sendKeys(Keys.CONTROL + "a");
		as.getNickname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Servicevehicle", 1, 4);
		as.getNickname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Nickname textfield will accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_007AssetsServicevehicle_Firstnamewithspecialcharacters")
	public void TC_008AssetsServicevehicle_FirstnamewithoutInput() throws InterruptedException
	{
		as.getNickname().click();
		as.getNickname().sendKeys(Keys.CONTROL + "a");
		as.getNickname().sendKeys(Keys.DELETE);
		as.getAddnewServicebutton().click();
		Thread.sleep(2000);
		String errormsg = as.getNicknameErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Nickname textfield without input displayed error message");
	}
	
	@Test (dependsOnMethods = "TC_008AssetsServicevehicle_FirstnamewithoutInput")
	public void TC_009AssetsServicevehicle_Vehiclelocationwithinput()
	{
		as.VehiclelocationwithInput();
		utilityclassobject.gettest().log(Status.INFO, "Vehicle location assignment dropdown will not accept input");
	}
	
	@Test(dependsOnMethods = "TC_009AssetsServicevehicle_Vehiclelocationwithinput")
	public void TC_013AssetsServicevehicle_Vehiclelocationwithoutlocation() throws InterruptedException
	{
		as.getAddnewServicebutton().click();
		Thread.sleep(2000);
		String errormsg = as.getVehiclelocationErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Vehicle location assignment without location displayed error message");

	}
	
	@Test(dependsOnMethods = "TC_013AssetsServicevehicle_Vehiclelocationwithoutlocation")
	public void TC_010AssetsServicevehicle_VehiclelocationwithLocations()
	{
		as.VehiclelocationwithVehicleLocations();
		utilityclassobject.gettest().log(Status.INFO, "The locations are available in the Vehicle location assignment dropdown");
	}
	
	@Test(dependsOnMethods = "TC_010AssetsServicevehicle_VehiclelocationwithLocations")
	public void TC_011AssetsServicevehicle_Vehiclelocationwithselected() throws InterruptedException
	{
		as.getVehiclelocationassignment().click();
		as.getVehiclelocationassignment().click();
		Thread.sleep(2000);
		as.getHenrylocation().click();
		utilityclassobject.gettest().log(Status.INFO, "user ia able to select location form the vehicle location assignment dropdown");
	}
	
	@Test(dependsOnMethods = "TC_011AssetsServicevehicle_Vehiclelocationwithselected")
	public void TC_012AssetServicevehicle_VehiclelocationwithMultipleoptions() throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    as.getVehiclelocationassignment().click();
		    as.getVehiclelocationassignment().click();
		    as.getVehiclelocationassignment().click();
		    as.getHenrylocation().click();
		    Thread.sleep(2000);
		    
		    as.getVehiclelocationassignment().click();
		    as.getVehiclelocationassignment().click();
		    as.getVehiclelocationassignment().click();
		    as.getBiotrustmedicallocation().click();
		    
		    List<WebElement> selectedOptions = driver.findElements(
		        By.xpath("//li[@aria-selected='true']")
		    );

		    if (selectedOptions.size() > 1) {
		        System.out.println("FAILED : Field accepts multiple options");
		    } else {
		        System.out.println("PASSED : Field allows only single selection");
		    }
			utilityclassobject.gettest().log(Status.INFO, "The user is not be able to select multiple locations");

		}
	
		@Test(dependsOnMethods = "TC_012AssetServicevehicle_VehiclelocationwithMultipleoptions")
		public void TC_014AssetsServiceVehicle_servicetypewithInput()
		{
			as.VehicletypewithInput();
			utilityclassobject.gettest().log(Status.INFO, "Vehicle type dropdown will not accept input");
		}
		
		@Test(dependsOnMethods = "TC_014AssetsServiceVehicle_servicetypewithInput")
		public void TC_015AssetsServiceVehicle_servicetype()
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getVehicletype().click();
			    WebElement dropdown = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(
			                    By.xpath("//ul[@role='listbox']")));

			    Assert.assertTrue(dropdown.isDisplayed(),
			            "vehicle type dropdown is displayed");

			    String[] types = {
			            "Box Truck",
			            "Cargo Van",
			            "Mobile Shred Truck",
			            "Flatbed Truck",
			            "Semi-Truck",
			            "Step Van",
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until(
			                ExpectedConditions.presenceOfElementLocated(
			                        By.xpath("//li[@role='option']//div[contains (text(),'"+type+"')]")));

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(),
			                type + " is displayed");
					utilityclassobject.gettest().log(Status.INFO, "Vehicle types are present in the dropdwon");

			    }
		}
		
		@Test(dependsOnMethods = "TC_015AssetsServiceVehicle_servicetype")
		public void TC_016AssetsServicevehicle_ServicetypewithMultipleoption() throws InterruptedException
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getVehicletype().click();
			 as.getVehicletype().click();
			 as.getBoxtruckType().click();
			 Thread.sleep(2000);
			 as.getVehicletype().click();
			 as.getVehicletype().click();
			 as.getVehicletype().click();
			 as.getStepvanType().click();			    
			  List<WebElement> selectedOptions = driver.findElements(
			        By.xpath("//li[@aria-selected='true']")
			    );

			    if (selectedOptions.size() > 1) {
			        System.out.println("FAILED : Field accepts multiple options");
			    } else {
			        System.out.println("PASSED : Field allows only single selection");
			    }
				utilityclassobject.gettest().log(Status.INFO, "The user is not be able to select multiple servicetypes");
		}
		
		@Test(dependsOnMethods = "TC_016AssetsServicevehicle_ServicetypewithMultipleoption")
		public void TC_017AssetsServicevehicle_servicetypewithoutInput() throws EncryptedDocumentException, IOException, InterruptedException
		{
			as.getNickname().click();
			as.getNickname().sendKeys(Keys.CONTROL + "a");
			as.getNickname().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 1, 1);
			as.getNickname().sendKeys(input);
			Thread.sleep(2000);
			as.getAddnewServicebutton().click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "The user is able to new service without Service type");

		}
		
		@Test(dependsOnMethods = "TC_017AssetsServicevehicle_servicetypewithoutInput")
		public void TC_018AssetsServiceVehicle_Status() throws InterruptedException
		{
			as.Vehiclestatus();
			utilityclassobject.gettest().log(Status.INFO, "The status of the service vehicle is present");

		}
		
		//need change the dependency
		@Test(dependsOnMethods = "TC_018AssetsServiceVehicle_Status")
		public void TC_019AssetsServicevehicle_statuswithInput()
		{
			as.vehiclestatuswithInput();
			utilityclassobject.gettest().log(Status.INFO, "Status field will not accept input");

		}
		
		@Test(dependsOnMethods = "TC_019AssetsServicevehicle_statuswithInput")
		public void TC_020AssetsServicevehicle_statuswithOptions()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getStatusbutton().click();
			    WebElement dropdown = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(
			                    By.xpath("//ul[@role='listbox']")));

			    Assert.assertTrue(dropdown.isDisplayed(),
			            "vehicle status dropdown is displayed");

			    String[] types = {
			            "Active",
			            "Inactive",
			            "Maintenance",
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until(
			                ExpectedConditions.presenceOfElementLocated(
			                        By.xpath("//li[@role='option']//div[contains (text(),'"+type+"')]")));

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(),
			                type + " is displayed");
					utilityclassobject.gettest().log(Status.INFO, "Vehicle status are present in the dropdwon");
			    }
		}
		
		@Test(dependsOnMethods = "TC_020AssetsServicevehicle_statuswithOptions")
		public void TC_021AsssetsServicevehicle_Statuswithchange() throws InterruptedException
		{
			as.getStatusbutton().click();
			as.getStatusbutton().click();
			Thread.sleep(2000);
			as.getMaintenanceStatus().click();
			utilityclassobject.gettest().log(Status.INFO, "The user is able to change the status");

		}
		
		@Test(dependsOnMethods = "TC_021AsssetsServicevehicle_Statuswithchange")
		public void TC_022AssetsServicevehicle_statuswithMultipleoption() throws InterruptedException
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getStatusbutton().click();
			 as.getInactiveStatus().click();
			 Thread.sleep(2000);
			 as.getStatusbutton().click();
			 as.getStatusbutton().click();
			 as.getStatusbutton().click();
			 as.getActivestatus().click();
			  List<WebElement> selectedOptions = driver.findElements(
			        By.xpath("//li[@aria-selected='true']")
			    );


			    
			    if (selectedOptions.size() > 1) {
			        System.out.println("FAILED : Field accepts multiple options");
			    } else {
			        System.out.println("PASSED : Field allows only single selection");
			    }
				utilityclassobject.gettest().log(Status.INFO, "The user is not be able to select multiple servicestatus");
		}
		
		@Test(dependsOnMethods = "TC_022AssetsServicevehicle_statuswithMultipleoption") 
		public void TC_023AssetsDrivers_closemodal() throws InterruptedException
		{
			as.getCloseButton().click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "The user is able to close the modal");
		}
		
		@Test(dependsOnMethods = "TC_023AssetsDrivers_closemodal")
		public void TC_024AssetsServicevehicle_withAddServicevehicle() throws EncryptedDocumentException, IOException, InterruptedException
		{
			as.getAddnewService().click();
			as.getNickname().click();
			Random random1 = new Random();
			int sixDigit1 = 100000 + random1.nextInt(900000);
			nicknameinput = elib.getDataFromExcel("Servicevehicle", 1, 1)+sixDigit1;
			as.getNickname().sendKeys(nicknameinput);
		
			
			as.getVehiclelocationassignment().click();
			Thread.sleep(2000);
			as.getHenrylocation().click();
			
			as.getVehicletype().click();
			Thread.sleep(2000);
			as.getStepvanType().click();
			
			as.getStatusbutton().click();
			Thread.sleep(2000);
			as.getActivestatus().click();
			as.getAddnewServicebutton().click();
			Thread.sleep(20000);	
			utilityclassobject.gettest().log(Status.INFO, "The user is able to add the service vehicle");

		}
		
		@Test(dependsOnMethods = "TC_024AssetsServicevehicle_withAddServicevehicle")
		public void TC_025AssetsServicevehicle_Servicevehiclepage()
		{
			as.ServicevehiclePage();
			utilityclassobject.gettest().log(Status.INFO, "System is redirected to the servicevehicle page");		
		}
		
		
		//need to change the dependency
		@Test(dependsOnMethods = "TC_025AssetsServicevehicle_Servicevehiclepage")
		public void TC_026AssetsServiceVehicle_Octoinfo() throws InterruptedException
		{
			as.getOctoinfo().click();
			Thread.sleep(200);
			as.getClosetooltip().click();
			utilityclassobject.gettest().log(Status.INFO, "The octo info popup is opned");		
		}
		
		@Test(dependsOnMethods = "TC_026AssetsServiceVehicle_Octoinfo")
		public void TC_027AssetsServicevehicle_AddedNickname()
		{
			WebElement nickname = driver.findElement(By.xpath("//input[@placeholder='Enter the Nickname']"));
			Assert.assertTrue(nickname.isDisplayed(), "nickname is displayed");
			String addednickname = nickname.getAttribute("value").trim();
			System.out.println(addednickname);
			utilityclassobject.gettest().log(Status.INFO, "The nickname given while adding the service vehicle is present");		
		}
		
		@Test(dependsOnMethods = "TC_027AssetsServicevehicle_AddedNickname")
		public void TC_028AssetsServicevehicle_editNickname() throws EncryptedDocumentException, IOException
		{
			as.getServiceNickname().click();
			as.getServiceNickname().sendKeys(Keys.CONTROL + "a");
			as.getServiceNickname().sendKeys(Keys.DELETE);
			Random random1 = new Random();
			int sixDigit1 = 100000 + random1.nextInt(900000);
			String editnickname = elib.getDataFromExcel("Servicevehicle", 1, 1)+sixDigit1;
			as.getServiceNickname().sendKeys(editnickname);
			utilityclassobject.gettest().log(Status.INFO, "The user is able to edit the nickname");		

		}
		
		@Test(dependsOnMethods = "TC_028AssetsServicevehicle_editNickname")
		public void TC_029AssetsServicevehicle_AutosaveNickname() throws EncryptedDocumentException, IOException
		{
			as.getServiceNickname().click();
			as.getServiceNickname().sendKeys(Keys.CONTROL + "a");
			as.getServiceNickname().sendKeys(Keys.DELETE);
			Random random1 = new Random();
			int sixDigit1 = 100000 + random1.nextInt(900000);
			editnickname = elib.getDataFromExcel("Servicevehicle", 1, 1)+sixDigit1;
			as.getServiceNickname().sendKeys(editnickname);
			utilityclassobject.gettest().log(Status.INFO, "The new nickname get autosaved");		
		}
		
		@Test(dependsOnMethods = "TC_029AssetsServicevehicle_AutosaveNickname")
		public void TC_030AssetsServicevehicle_VehicleID()
		{
			WebElement vehicleid = driver.findElement(By.xpath("//input[@placeholder='Enter the Vehicle ID #']"));
			Assert.assertTrue(vehicleid.isDisplayed(), "nickname is displayed");
			addedvehicleID = vehicleid.getAttribute("value").trim();
			System.out.println(addedvehicleID);
			utilityclassobject.gettest().log(Status.INFO, "The vehicle Id get autogenerated");		
		}
		
		@Test(dependsOnMethods = "TC_030AssetsServicevehicle_VehicleID")
		public void TC_031AssetsServicevehicle_VehicleIDwithEdit()
		{
			as.VehicleIDwithEdit();
			utilityclassobject.gettest().log(Status.INFO, "The user is not able to edit the vehicle ID");		
		}
		
		@Test(dependsOnMethods = "TC_031AssetsServicevehicle_VehicleIDwithEdit")
		public void TC_032AssetsServicevehicle_YearwithInput() throws EncryptedDocumentException, IOException
		{
			as.getYear().click();
			as.getYear().sendKeys(Keys.CONTROL + "a");
			as.getYear().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 4, 1);
			as.getYear().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Year textfield will accept input");		
		}
		
		@Test(dependsOnMethods = "TC_032AssetsServicevehicle_YearwithInput")
		public void TC_033AssetsServicevehcile_Yearswithalphabets() throws EncryptedDocumentException, IOException
		{
			as.getYear().click();
			as.getYear().sendKeys(Keys.CONTROL + "a");
			as.getYear().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 4, 2);
			as.getYear().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Year textfield will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_033AssetsServicevehcile_Yearswithalphabets")
		public void TC_034AssetsServicevehicle_Yearswithnumbers() throws EncryptedDocumentException, IOException
		{
			as.getYear().click();
			as.getYear().sendKeys(Keys.CONTROL + "a");
			as.getYear().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 4, 3);
			as.getYear().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Year textfield will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_034AssetsServicevehicle_Yearswithnumbers")
		public void TC_035AssetsServicevehicle_Yearswithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getYear().click();
			as.getYear().sendKeys(Keys.CONTROL + "a");
			as.getYear().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 4, 4);
			as.getYear().sendKeys(input);
			
			as.getYear().click();
			as.getYear().sendKeys(Keys.CONTROL + "a");
			as.getYear().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 4, 1);
			as.getYear().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "Year textfield will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_035AssetsServicevehicle_Yearswithspecialcharacters")
		public void TC_036AssetsServicevehicle_MakewithInput() throws EncryptedDocumentException, IOException
		{
			as.getMake().click();
			as.getMake().sendKeys(Keys.CONTROL + "a");
			as.getMake().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 7, 1);
			as.getMake().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Make textfield will accept Input");		
		}
		
		@Test(dependsOnMethods = "TC_036AssetsServicevehicle_MakewithInput")
		public void TC_037AssetsServicevehicle_Makewithalphabets() throws EncryptedDocumentException, IOException
		{
			as.getMake().click();
			as.getMake().sendKeys(Keys.CONTROL + "a");
			as.getMake().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 7, 2);
			as.getMake().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Make textfield will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_037AssetsServicevehicle_Makewithalphabets")
		public void TC_038AssetsServicevehicle_Makewithnumbers() throws EncryptedDocumentException, IOException
		{
			as.getMake().click();
			as.getMake().sendKeys(Keys.CONTROL + "a");
			as.getMake().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 7, 3);
			as.getMake().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Make textfield will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_038AssetsServicevehicle_Makewithnumbers")
		public void TC_039AssetsServicevehicle_Makewithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getMake().click();
			as.getMake().sendKeys(Keys.CONTROL + "a");
			as.getMake().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 7, 4);
			as.getMake().sendKeys(input);
			
			as.getMake().click();
			as.getMake().sendKeys(Keys.CONTROL + "a");
			as.getMake().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 7, 1);
			as.getMake().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "Make textfield will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_039AssetsServicevehicle_Makewithspecialcharacters")
		public void TC_040AssetsServicevehicle_ModelwithInput() throws EncryptedDocumentException, IOException
		{
			as.getModel().click();
			as.getModel().sendKeys(Keys.CONTROL + "a");
			as.getModel().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 10, 1);
			as.getModel().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Model textfield will accept Input");		
		}
		
		@Test(dependsOnMethods = "TC_040AssetsServicevehicle_ModelwithInput")
		public void TC_041AssetsServicevehicle_Modelwithalphabets() throws EncryptedDocumentException, IOException
		{
			as.getModel().click();
			as.getModel().sendKeys(Keys.CONTROL + "a");
			as.getModel().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 10, 2);
			as.getModel().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Model textfield will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_041AssetsServicevehicle_Modelwithalphabets")
		public void TC_042AssetsServicevehicle_ModelwithNumbers() throws EncryptedDocumentException, IOException
		{
			as.getModel().click();
			as.getModel().sendKeys(Keys.CONTROL + "a");
			as.getModel().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 10, 3);
			as.getModel().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Model textfield will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_042AssetsServicevehicle_ModelwithNumbers")
		public void TC_043AssetsServicevehicle_Modelwithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getModel().click();
			as.getModel().sendKeys(Keys.CONTROL + "a");
			as.getModel().sendKeys(Keys.DELETE);
			
			String input = elib.getDataFromExcel("Servicevehicle", 10, 4);
			as.getModel().sendKeys(input);
			
			as.getModel().click();
			as.getModel().sendKeys(Keys.CONTROL + "a");
			as.getModel().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 10, 1);
			as.getModel().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "Model textfield will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_043AssetsServicevehicle_Modelwithspecialcharacters")
		public void TC_044AssetsServicevehicle_licenseplatewithInput() throws EncryptedDocumentException, IOException
		{
			as.getLicenseplate().click();
			as.getLicenseplate().sendKeys(Keys.CONTROL + "a");
			as.getLicenseplate().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 13, 1);
			as.getLicenseplate().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "licenseplate textfield will accept Input");		
		}
		
		@Test(dependsOnMethods = "TC_044AssetsServicevehicle_licenseplatewithInput")
		public void TC_045AssetsServicevehicle_licenseplatewithAlphabets() throws EncryptedDocumentException, IOException
		{
			as.getLicenseplate().click();
			as.getLicenseplate().sendKeys(Keys.CONTROL + "a");
			as.getLicenseplate().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 13, 2);
			as.getLicenseplate().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "licenseplate textfield will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_045AssetsServicevehicle_licenseplatewithAlphabets")
		public void TC_046AssetsServicevehicle_licenseplatewithNumbers() throws EncryptedDocumentException, IOException
		{
			as.getLicenseplate().click();
			as.getLicenseplate().sendKeys(Keys.CONTROL + "a");
			as.getLicenseplate().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 13, 3);
			as.getLicenseplate().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "licenseplate textfield will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_046AssetsServicevehicle_licenseplatewithNumbers")
		public void TC_047AssetsServicevehicle_licenseplatewithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getLicenseplate().click();
			as.getLicenseplate().sendKeys(Keys.CONTROL + "a");
			as.getLicenseplate().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 13, 4);
			as.getLicenseplate().sendKeys(input);
			
			as.getLicenseplate().click();
			as.getLicenseplate().sendKeys(Keys.CONTROL + "a");
			as.getLicenseplate().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 13, 1);
			as.getLicenseplate().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "licenseplate textfield will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_047AssetsServicevehicle_licenseplatewithspecialcharacters")
		public void TC_048AssetsServicevehicle_VINwithInput() throws EncryptedDocumentException, IOException
		{
			as.getVintextfield().click();
			as.getVintextfield().sendKeys(Keys.CONTROL + "a");
			as.getVintextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 16, 1);
			as.getVintextfield().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "VIN textfield will accept Input");		
		}
		
		@Test(dependsOnMethods = "TC_048AssetsServicevehicle_VINwithInput")
		public void TC_049AssetsServicevehicle_VINwithalphabets() throws EncryptedDocumentException, IOException
		{
			as.getVintextfield().click();
			as.getVintextfield().sendKeys(Keys.CONTROL + "a");
			as.getVintextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 16, 2);
			as.getVintextfield().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "VIN textfield will accept alphabets");		
		}
		
		@Test(	dependsOnMethods = "TC_049AssetsServicevehicle_VINwithalphabets")
		public void TC_050AssetServicevehicle_VINwithnumbers() throws EncryptedDocumentException, IOException
		{
			as.getVintextfield().click();
			as.getVintextfield().sendKeys(Keys.CONTROL + "a");
			as.getVintextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 16, 3);
			as.getVintextfield().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "VIN textfield will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_050AssetServicevehicle_VINwithnumbers")
		public void TC_051AssetServicevehicle_VINwithSpecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getVintextfield().click();
			as.getVintextfield().sendKeys(Keys.CONTROL + "a");
			as.getVintextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 16, 4);
			as.getVintextfield().sendKeys(input);
			
			as.getVintextfield().click();
			as.getVintextfield().sendKeys(Keys.CONTROL + "a");
			as.getVintextfield().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 16, 1);
			as.getVintextfield().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "VIN textfield will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_051AssetServicevehicle_VINwithSpecialcharacters")
		public void TC_052AssetsServicevehicle_Servicevehicletype()
		{
			as.ServicevehicleType();
			utilityclassobject.gettest().log(Status.INFO, "The vehicle type entered while adding the vehicle is present");		

		}
		
		@Test(dependsOnMethods = "TC_052AssetsServicevehicle_Servicevehicletype")
		public void TC_053AssetsServicevehicle_withServicetype() throws InterruptedException
		{
			as.getServiceVehicletype().click();
			Thread.sleep(2000);
			as.getMobileshredtrckType().click();
			utilityclassobject.gettest().log(Status.INFO, "The user is able to change the vehicle type");		
		}
		
		@Test(dependsOnMethods = "TC_053AssetsServicevehicle_withServicetype")
		public void TC_054AssetsServicevehicle_VehicleclasswithInput() throws InterruptedException
		{
			as.VehicleclasswithInput();
			utilityclassobject.gettest().log(Status.INFO, "Vehicle class dropdown will not accept input");		

		}
		
		@Test(dependsOnMethods = "TC_054AssetsServicevehicle_VehicleclasswithInput")
		public void TC_055AssetsServicevehicle_Vehicleclasswithoptions()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getVehicleClass().click();
			    WebElement dropdown = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(
			                    By.xpath("//ul[@role='listbox']")));

			    Assert.assertTrue(dropdown.isDisplayed(),
			            "vehicle status dropdown is displayed");

			    String[] types = {
			            "Class 1: 6,000 lbs or less",
			            "Class 2: 6,001 to 10,000 lbs",
			            "Class 3: 10,001 to 14,000 lbs",
			            "Class 4: 14,001 to 16,000 lbs",
			            "Class 5: 16,001 to 19,500 lbs",
			            "Class 6: 19,501 to 26,000 lbs",
			            "Class 7: 26,001 to 33,000 lbs",
			            "Class 8: 33,001 lbs and over",
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until(
			                ExpectedConditions.presenceOfElementLocated(
			                        By.xpath("//li[@role='option']//div[contains (text(),'"+type+"')]")));

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(),
			                type + " is displayed");
					utilityclassobject.gettest().log(Status.INFO, "The options are present in the Vehicle class dropdown");
			    }
		}
		
		@Test(dependsOnMethods = "TC_055AssetsServicevehicle_Vehicleclasswithoptions")
		public void TC_056AssetsServicevehicle_selectedvehicleclassoption() throws InterruptedException
		{
			as.getVehicleClass().click();
			as.getVehicleClass().click();
			Thread.sleep(2000);
			as.getVehicleclassoptions().click();
			as.getVehicleClass().click();
			utilityclassobject.gettest().log(Status.INFO, "The user is able to select the class of their choice");
		}
		
		@Test(dependsOnMethods = "TC_056AssetsServicevehicle_selectedvehicleclassoption")
		public void TC_057AssetsServicevehicle_vehicleclasswithMultipleoption() throws InterruptedException
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getVehicleClass().click();
			 as.getVehicleClass().click();
			 as.getVehicleclassoptions().click();
			 Thread.sleep(2000);
			 as.getVehicleClass().click();
			 as.getVehicleClass().click();
			 as.getVehicleClass().click();
			 as.getVehicleclass3option().click();
			  List<WebElement> selectedOptions = driver.findElements(
			        By.xpath("//li[@aria-selected='true']")
			    );

			    if (selectedOptions.size() > 1) {
			        System.out.println("FAILED : Field accepts multiple options");
			    } else {
			        System.out.println("PASSED : Field allows only single selection");
			    }
				utilityclassobject.gettest().log(Status.INFO, "The user is not be able to select multiple vehicleclass");
		}
		
		@Test(dependsOnMethods = "TC_057AssetsServicevehicle_vehicleclasswithMultipleoption")
		public void TC_058AssetsServicevehicle_FueltypewithInput()
		{
			as.FueltypewithInput();
			utilityclassobject.gettest().log(Status.INFO, "Fuel type dropdown will not accept input");

		}
		
		@Test(dependsOnMethods = "TC_058AssetsServicevehicle_FueltypewithInput")
		public void TC_059AssetsServicevehicle_FueltypewithOptions()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getFuelType().click();
			    WebElement dropdown = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(
			                    By.xpath("//ul[@role='listbox']")));

			    Assert.assertTrue(dropdown.isDisplayed(),
			            "vehicle status dropdown is displayed");

			    String[] types = {
			            "Diesel",
			            "Electric",
			            "Gasoline",
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until(
			                ExpectedConditions.presenceOfElementLocated(
			                        By.xpath("//li[@role='option']//div[contains (text(),'"+type+"')]")));

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(),
			                type + " is displayed");
					utilityclassobject.gettest().log(Status.INFO, "The options are present in the Fueltype dropdown");
			    }
		}
		
		@Test(dependsOnMethods = "TC_059AssetsServicevehicle_FueltypewithOptions")
		public void TC_060AssetsServicevehicle_Fueltypewithselectedoption() throws InterruptedException
		{
			as.getFuelType().click();
			as.getFuelType().click();
			Thread.sleep(200);
			as.getGasloinFuel().click();
			as.getFuelType().click();
			Thread.sleep(200);
			as.getDieselFuel().click();
			as.getFuelType().click();
			Thread.sleep(200);
			as.getElectricFuel().click();
			utilityclassobject.gettest().log(Status.INFO, "The user is able to select the fuel type");
		}
		
		@Test(dependsOnMethods = "TC_060AssetsServicevehicle_Fueltypewithselectedoption")
		public void TC_061AssetsServicevehicle_FueltypewithMultipleoption() throws InterruptedException
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getFuelType().click();
			 as.getFuelType().click();
			 as.getFuelType().click();
			 as.getGasloinFuel().click();
			 Thread.sleep(2000);
			 as.getFuelType().click();
			 as.getFuelType().click();
			 as.getFuelType().click();
			 as.getElectricFuel().click();
			  List<WebElement> selectedOptions = driver.findElements(
			        By.xpath("//li[@aria-selected='true']")
			    );

			    if (selectedOptions.size() > 1) {
			        System.out.println("FAILED : Field accepts multiple options");
			    } else {
			        System.out.println("PASSED : Field allows only single selection");
			    }
				utilityclassobject.gettest().log(Status.INFO, "The user is not be able to select multiple Fueltype");
		}
		
		@Test(dependsOnMethods = "TC_061AssetsServicevehicle_FueltypewithMultipleoption")
		public void TC_062AssetsServicevehicle_Payloadwithalphabets() throws EncryptedDocumentException, IOException
		{
			as.getPayloadCapicty().click();
			as.getPayloadCapicty().sendKeys(Keys.CONTROL + "a");
			as.getPayloadCapicty().sendKeys(Keys.DELETE);
			input = elib.getDataFromExcel("Servicevehicle", 19, 1);
			as.getPayloadCapicty().sendKeys(input);
			System.out.println(input);
			utilityclassobject.gettest().log(Status.INFO, "Payload capacity field will not accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_062AssetsServicevehicle_Payloadwithalphabets")
		public void TC_063AssetsServicevehicle_Payloadwithnumbers() throws EncryptedDocumentException, IOException
		{
			as.getPayloadCapicty().click();
			as.getPayloadCapicty().sendKeys(Keys.CONTROL + "a");
			as.getPayloadCapicty().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 19, 2);
			as.getPayloadCapicty().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Payload capacity field will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_063AssetsServicevehicle_Payloadwithnumbers")
		public void TC_064AssetServicevehicle_PayloadwithSpecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getPayloadCapicty().click();
			as.getPayloadCapicty().sendKeys(Keys.CONTROL + "a");
			as.getPayloadCapicty().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 19, 3);
			as.getPayloadCapicty().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Payload capacity field will not accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_064AssetServicevehicle_PayloadwithSpecialcharacters")
		public void TC_065AssetsServicevehicle_PayloadwithScientificnotation() throws EncryptedDocumentException, IOException
		{
			as.getPayloadCapicty().click();
			as.getPayloadCapicty().sendKeys(Keys.CONTROL + "a");
			as.getPayloadCapicty().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 19, 4);
			as.getPayloadCapicty().sendKeys(input);
			
			as.getPayloadCapicty().click();
			as.getPayloadCapicty().sendKeys(Keys.CONTROL + "a");
			as.getPayloadCapicty().sendKeys(Keys.DELETE);
			input2 = elib.getDataFromExcel("Servicevehicle", 19, 5);
			as.getPayloadCapicty().sendKeys(input2);
			utilityclassobject.gettest().log(Status.INFO, "Payload capacity field accept Scientificnotation values");		
		}
		
		@Test(dependsOnMethods = "TC_065AssetsServicevehicle_PayloadwithScientificnotation")
		public void TC_066AssetsServicevehicle_VehicleStatus()
		{
			as.ServiceStatus();
			utilityclassobject.gettest().log(Status.INFO, "The status selected while adding the vehicle is present");		

		}
		
		//need to change the dependency
		@Test(dependsOnMethods = "TC_066AssetsServicevehicle_VehicleStatus")
		public void TC_067AssetsServicevehicle_Vehiclestatuswithoption() throws InterruptedException
		{
			as.getServiceStatus().click();
			as.getMaintenanceStatus().click();
			Thread.sleep(2000);
			as.getServiceStatus().click();
			as.getInactiveStatus().click();
			Thread.sleep(2000);
			as.getServiceStatus().click();
			as.getActivestatus().click();
			utilityclassobject.gettest().log(Status.INFO, "user is able to change the status");		
		}
		
		
		@Test(dependsOnMethods = "TC_067AssetsServicevehicle_Vehiclestatuswithoption")
		public void TC_068AssetsServicevehicle_VehiclelocationAssignment()
		{
			as.ServiceLocationassignment();
			utilityclassobject.gettest().log(Status.INFO, "The location assigned while adding the vehicle is present");		
		}
		
		@Test(dependsOnMethods = "TC_068AssetsServicevehicle_VehiclelocationAssignment")
		public void TC_069AssetsServicevehicle_VehiclelocationChange() throws InterruptedException
		{
			as.ServicelocationChange();
			utilityclassobject.gettest().log(Status.INFO, "user is able to update the location");		
		}
		
		@Test(dependsOnMethods = "TC_069AssetsServicevehicle_VehiclelocationChange")
		public void TC_070AssetsServicevehicle_VehiclelocationAutosave() throws InterruptedException
		{
			as.ServicelocationAutosave();
			utilityclassobject.gettest().log(Status.INFO, "The autosave save the changes");		
		}
		
		@Test(dependsOnMethods = "TC_070AssetsServicevehicle_VehiclelocationAutosave")
		public void TC_071AssetsServicevehicle_DotwithInput() throws EncryptedDocumentException, IOException
		{
			as.getDotField().click();
			as.getDotField().sendKeys(Keys.CONTROL + "a");
			as.getDotField().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 22, 1);
			as.getDotField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "DOT# field will accept Input");		
		}
		
		@Test(dependsOnMethods = "TC_071AssetsServicevehicle_DotwithInput")
		public void TC_072AssetsServicevehicle_DOTwithalphabets() throws EncryptedDocumentException, IOException
		{
			as.getDotField().click();
			as.getDotField().sendKeys(Keys.CONTROL + "a");
			as.getDotField().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 22, 2);
			as.getDotField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "DOT# field will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_072AssetsServicevehicle_DOTwithalphabets")
		public void TC_073AssetsServicevehicle_DOTwithnumbers() throws EncryptedDocumentException, IOException
		{
			as.getDotField().click();
			as.getDotField().sendKeys(Keys.CONTROL + "a");
			as.getDotField().sendKeys(
					Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 22, 3);
			as.getDotField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "DOT# field will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_073AssetsServicevehicle_DOTwithnumbers")
		public void TC_074AssetsServicevehicle_DOTwithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getDotField().click();
			as.getDotField().sendKeys(Keys.CONTROL + "a");
			as.getDotField().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 22, 4);
			as.getDotField().sendKeys(input);
			
			
			as.getDotField().click();
			as.getDotField().sendKeys(Keys.CONTROL + "a");
			as.getDotField().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 22, 1);
			as.getDotField().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "DOT# field will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_074AssetsServicevehicle_DOTwithspecialcharacters")
		public void TC_075AssetsServicevehicle_IntrastatewithInput() throws EncryptedDocumentException, IOException
		{
			as.getIntrastateField().click();
			as.getIntrastateField().sendKeys(Keys.CONTROL + "a");
			as.getIntrastateField().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 25, 1);
			as.getIntrastateField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Intrastate# field will accept Input");		
		}
		
		@Test(dependsOnMethods = "TC_075AssetsServicevehicle_IntrastatewithInput")
		public void TC_076AssetsServicevehicle_Intrastatewithalphabetrs() throws EncryptedDocumentException, IOException
		{
			as.getIntrastateField().click();
			as.getIntrastateField().sendKeys(Keys.CONTROL + "a");
			as.getIntrastateField().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 25, 2);
			as.getIntrastateField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Intrastate# field will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_076AssetsServicevehicle_Intrastatewithalphabetrs")
		public void TC_077AssetsServicevehicle_Intrastatewithnumbers() throws EncryptedDocumentException, IOException
		{
			as.getIntrastateField().click();
			as.getIntrastateField().sendKeys(Keys.CONTROL + "a");
			as.getIntrastateField().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 25, 3);
			as.getIntrastateField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Intrastate# field will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_077AssetsServicevehicle_Intrastatewithnumbers")
		public void TC_078AssetsServicevehicle_Intrastatewithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getIntrastateField().click();
			as.getIntrastateField().sendKeys(Keys.CONTROL + "a");
			as.getIntrastateField().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 25, 4);
			as.getIntrastateField().sendKeys(input);
			
			as.getIntrastateField().click();
			as.getIntrastateField().sendKeys(Keys.CONTROL + "a");
			as.getIntrastateField().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 25, 1);
			as.getIntrastateField().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "Intrastate# field will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_078AssetsServicevehicle_Intrastatewithspecialcharacters")
		public void TC_079AssetsServicevehicle_RegistrationcalendarwithInput()
		{
			as.RegistrationDatewithInput();
			utilityclassobject.gettest().log(Status.INFO, "The user is not be able to add a manual input");		
		}
		
		@Test(dependsOnMethods = "TC_079AssetsServicevehicle_RegistrationcalendarwithInput")
		public void TC_080AssetsServicevehicle_RegistrationCalendarwithDate()
		{
			as.RegistrationcalendarwithDate();
			utilityclassobject.gettest().log(Status.INFO, "The user is able to add date in the field");		
		}
		
		@Test(dependsOnMethods = "TC_080AssetsServicevehicle_RegistrationCalendarwithDate")
		public void TC_081AssetsServicevehicle_RegistrationCalendarwithMonth() throws InterruptedException
		{
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    String[] months = {
			            "January",
			            "February",
			            "March",
			            "April",
			            "May",
			            "June",
			            "July",
			            "August",
			            "September",
			            "October",
			            "November",
			            "December"
			    };

			    for (String month : months)
			    {
			        // Open calendar
			        as.getRegistrationCalendar().click();

			        // Open month dropdown
			        WebElement dropdown = wait.until(
			                ExpectedConditions.elementToBeClickable(
		                            	                        By.xpath("(//details[@class='dropdown'])[2]")));

			        dropdown.click();

			        // Select month
			        WebElement monthElement = wait.until(
			                ExpectedConditions.elementToBeClickable(
			                        By.xpath("//a[contains(text(),'" + month + "')]")));

			        monthElement.click();

			        System.out.println(month + " is clickable");

			        utilityclassobject.gettest().log(Status.INFO,
			                month + " is clickable");

			        Thread.sleep(1000);
					utilityclassobject.gettest().log(Status.INFO, "The user is able to select month");		
		}
		}
		
		@Test(dependsOnMethods = "TC_081AssetsServicevehicle_RegistrationCalendarwithMonth")
		public void TC_082AssetsServicevehicle_RegistrationCalendarwithYear() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    String[] years = {
		            "1973",
		            "1992",
		            "2010",
		            "2027",
		            "2035"
		    };

		    for (String year : years)
		    {
		        // Open calendar
		        as.getRegistrationCalendar().click();

		        // Open month dropdown
		        WebElement dropdown = wait.until(
		                ExpectedConditions.elementToBeClickable(
		                        By.xpath("(//details[@class='dropdown'])[1]")));

		        dropdown.click();

		        // Select month
		        WebElement monthElement = wait.until(
		                ExpectedConditions.elementToBeClickable(
		                        By.xpath("//a[contains(text(),'" + year + "')]")));

		        monthElement.click();

		        System.out.println(year + " is clickable");

		        utilityclassobject.gettest().log(Status.INFO,
		        		year + " is clickable");

		        Thread.sleep(1000);
		        as.getIntrastateField().click();
				utilityclassobject.gettest().log(Status.INFO, "The user is able to select year");		
	}
		}
		
		@Test(dependsOnMethods = "TC_082AssetsServicevehicle_RegistrationCalendarwithYear")
		public void TC_083AssetsServicevehicle_InsuranceCalendarwithInput()
		{
			as.InsuranceDatewithInput();
			utilityclassobject.gettest().log(Status.INFO, "The user is not be able to add a manual input");		

		}
		
		@Test(dependsOnMethods = "TC_083AssetsServicevehicle_InsuranceCalendarwithInput")
		public void TC_084AssetsServicevehicle_InsuranceCalendarwithDate()
		{
			as.InsurancecalendarwithDate();
			utilityclassobject.gettest().log(Status.INFO, "The user is able to add date in the field");		

		}
		
		@Test(dependsOnMethods = "TC_084AssetsServicevehicle_InsuranceCalendarwithDate")
		public void TC_085AssetsServicevehicle_InsuranceCalendarwithMonth() throws InterruptedException
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    String[] months = {
			            "January",
			            "February",
			            "March",
			            "April",
			            "May",
			            "June",
			            "July",
			            "August",
			            "September",
			            "October",
			            "November",
			            "December"
			    };

			    for (String month : months)
			    {
			        // Open calendar
			        as.getInsuranceCalendar().click
			        ();

			        // Open month dropdown
			        WebElement dropdown = wait.until(
			                ExpectedConditions.elementToBeClickable(
			                        By.xpath("(//details[@class='dropdown'])[2]")));

			        dropdown.click();

			        // Select month
			        WebElement monthElement = wait.until(
			                ExpectedConditions.elementToBeClickable(
			                        By.xpath("//a[contains(text(),'" + month + "')]")));

			        monthElement.click();

			        System.out.println(month + " is clickable");

			        utilityclassobject.gettest().log(Status.INFO,
			                month + " is clickable");

			        Thread.sleep(1000);
					utilityclassobject.gettest().log(Status.INFO, "The user is able to select month");		
		}
		}
		
		@Test(dependsOnMethods = "TC_085AssetsServicevehicle_InsuranceCalendarwithMonth")
		public void TC_086AssetsServicevehicle_InsuranceCalendarwithYear() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    String[] years = {
		            "2015",
		            "2021",
		            "2027",
		            "2035"
		    };

		    for (String year : years)
		    {
		        // Open calendar
		        as.getInsuranceCalendar().click();

		        // Open month dropdown
		        WebElement dropdown = wait.until(
		                ExpectedConditions.elementToBeClickable(
		                        By.xpath("(//details[@class='dropdown'])[1]")));

		        dropdown.click();

		        // Select month
		        WebElement monthElement = wait.until(
		                ExpectedConditions.elementToBeClickable(
		                        By.xpath("//a[contains(text(),'" + year + "')]")));

		        monthElement.click();

		        System.out.println(year + " is clickable");

		        utilityclassobject.gettest().log(Status.INFO,
		        		year + " is clickable");

		        Thread.sleep(1000);
		        as.getIntrastateField().click();
				utilityclassobject.gettest().log(Status.INFO, "The user is able to select year");		
	}
			
		}
		
		@Test(dependsOnMethods = "TC_086AssetsServicevehicle_InsuranceCalendarwithYear")
		public void TC_105AssetsServicevehicle_SpecialequipmentwithInput() throws EncryptedDocumentException, IOException
		{
			as.getSpecialequipment().click();
			as.getSpecialequipment().sendKeys(Keys.CONTROL + "a");
			as.getSpecialequipment().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 28, 1);
			as.getSpecialequipment().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "special equipment field will accept Input");		
		}
		
		@Test(dependsOnMethods = "TC_105AssetsServicevehicle_SpecialequipmentwithInput")
		public void TC_106AssetsServicevehicle_Specialequipmentwithalphabets() throws EncryptedDocumentException, IOException
		{
			as.getSpecialequipment().click();
			as.getSpecialequipment().sendKeys(Keys.CONTROL + "a");
			as.getSpecialequipment().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 28, 2);
			as.getSpecialequipment().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "special equipment field will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_106AssetsServicevehicle_Specialequipmentwithalphabets")
		public void TC_107AssetsServicevehicle_SpecialequipmentwithNumbers() throws EncryptedDocumentException, IOException
		{
			as.getSpecialequipment().click();
			as.getSpecialequipment().sendKeys(Keys.CONTROL + "a");
			as.getSpecialequipment().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 28, 3);
			as.getSpecialequipment().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "special equipment field will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_107AssetsServicevehicle_SpecialequipmentwithNumbers")
		public void TC_108AssetServicevehicle_Specialequipmentwithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getSpecialequipment().click();
			as.getSpecialequipment().sendKeys(Keys.CONTROL + "a");
			as.getSpecialequipment().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 28, 4);
			as.getSpecialequipment().sendKeys(input);
			
			as.getSpecialequipment().click();
			as.getSpecialequipment().sendKeys(Keys.CONTROL + "a");
			as.getSpecialequipment().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("Servicevehicle", 28, 1);
			as.getSpecialequipment().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "special equipment field will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_108AssetServicevehicle_Specialequipmentwithspecialcharacters")
		public void TC_109AssetsServicevehicle_specialequipment() throws AWTException, EncryptedDocumentException, IOException
		{
			as.getSpecialequipment().click();
			as.getSpecialequipment().sendKeys(Keys.CONTROL + "a");
			as.getSpecialequipment().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 28, 1);
			as.getSpecialequipment().sendKeys(input);
			Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
			utilityclassobject.gettest().log(Status.INFO, "user is able to expand the field to see the text entered");		
		}
		
		@Test(dependsOnMethods = "TC_109AssetsServicevehicle_specialequipment")
		public void TC_110AssetsServicevehicle_TruckcostwithValue()
		{
			as.TruckcostfieldwithValue();
			utilityclassobject.gettest().log(Status.INFO, "The default Turck cost per mile is displayed");		
		}
		
		@Test(dependsOnMethods = "TC_110AssetsServicevehicle_TruckcostwithValue")
		public void TC_111AssetsServiceVehicle_TruckcostwithInput()
		{
			as.getTruckcostField().click();
			as.getTruckcostField().sendKeys(Keys.CONTROL + "a");
			as.getTruckcostField().sendKeys(Keys.DELETE);
			as.getTruckcostField().sendKeys("10");
			utilityclassobject.gettest().log(Status.INFO, "The user is able to edit the cost");		
		}
		
		@Test(dependsOnMethods = "TC_111AssetsServiceVehicle_TruckcostwithInput")
		public void TC_112AssetServicevehicle_Truckwithnumbers()
		{
			as.getTruckcostField().click();
			as.getTruckcostField().sendKeys(Keys.CONTROL + "a");
			as.getTruckcostField().sendKeys(Keys.DELETE);
			as.getTruckcostField().sendKeys("2877823");
			utilityclassobject.gettest().log(Status.INFO, "Truck cost per mile will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_112AssetServicevehicle_Truckwithnumbers")
		public void TC_113AssetsServicevehicle_TruckwithAlphabets()
		{
			as.getTruckcostField().click();
			as.getTruckcostField().sendKeys(Keys.CONTROL + "a");
			as.getTruckcostField().sendKeys(Keys.DELETE);
			as.getTruckcostField().sendKeys("Hsgahfd");
			utilityclassobject.gettest().log(Status.INFO, "Truck cost per mile will not accept alphbets");		
		}
		
		@Test(dependsOnMethods = "TC_113AssetsServicevehicle_TruckwithAlphabets")
		public void TC_114AssetsServicevehicle_Truckwithspecialcharacters()
		{
			as.getTruckcostField().click();
			as.getTruckcostField().sendKeys(Keys.CONTROL + "a");
			as.getTruckcostField().sendKeys(Keys.DELETE);
			as.getTruckcostField().sendKeys("$%*&^#");
			
			as.getTruckcostField().click();
			as.getTruckcostField().sendKeys(Keys.CONTROL + "a");
			as.getTruckcostField().sendKeys(Keys.DELETE);
			as.getTruckcostField().sendKeys("10");
			utilityclassobject.gettest().log(Status.INFO, "Truck cost per mile will not accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_114AssetsServicevehicle_Truckwithspecialcharacters")
		public void TC_115AssetsServicevehicle_NoteswithInput() throws EncryptedDocumentException, IOException
		{
			as.getServiceNotes().click();
			as.getServiceNotes().sendKeys(Keys.CONTROL + "a");
			as.getServiceNotes().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 31, 1);
			as.getServiceNotes().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Notes textarea field will accept input");		
		}
		
		@Test(dependsOnMethods = "TC_115AssetsServicevehicle_NoteswithInput")
		public void TC_116AssetsSerivevehicle_Noteswithalpahbets() throws EncryptedDocumentException, IOException
		{
			as.getServiceNotes().click();
			as.getServiceNotes().sendKeys(Keys.CONTROL + "a");
			as.getServiceNotes().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 31, 2);
			as.getServiceNotes().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Notes textarea field will accept alphabets");		
		}
		
		@Test(dependsOnMethods = "TC_116AssetsSerivevehicle_Noteswithalpahbets")
		public void TC_117AssetsServicevehicle_NoteswithNumbers() throws EncryptedDocumentException, IOException
		{
			as.getServiceNotes().click();
			as.getServiceNotes().sendKeys(Keys.CONTROL + "a");
			as.getServiceNotes().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 31, 3);
			as.getServiceNotes().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Notes textarea field will accept numbers");		
		}
		
		@Test(dependsOnMethods = "TC_117AssetsServicevehicle_NoteswithNumbers")
		public void TC_118AssetsServicevehicle_Noteswithspecialcharacters() throws EncryptedDocumentException, IOException
		{
			as.getServiceNotes().click();
			as.getServiceNotes().sendKeys(Keys.CONTROL + "a");
			as.getServiceNotes().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 31, 4);
			as.getServiceNotes().sendKeys(input);
			
			as.getServiceNotes().click();
			as.getServiceNotes().sendKeys(Keys.CONTROL + "a");
			as.getServiceNotes().sendKeys(Keys.DELETE);
			input1 = elib.getDataFromExcel("Servicevehicle", 31, 1);
			as.getServiceNotes().sendKeys(input1);
			utilityclassobject.gettest().log(Status.INFO, "Notes textarea field will accept specialcharacters");		
		}
		
		@Test(dependsOnMethods = "TC_118AssetsServicevehicle_Noteswithspecialcharacters")
		public void TC_119AssetsServicevehicle_Notes() throws EncryptedDocumentException, IOException, AWTException
		{
			as.getServiceNotes().click();
			as.getServiceNotes().sendKeys(Keys.CONTROL + "a");
			as.getServiceNotes().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("Servicevehicle", 31, 1);
			as.getServiceNotes().sendKeys(input);
			Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
			utilityclassobject.gettest().log(Status.INFO, "user is able to expand the field to see the text entered");		
		}
		
		
		@Test(dependsOnMethods = "TC_119AssetsServicevehicle_Notes")
		public void TC_120AssetsServicevehicle_Savebutton()
		{
			as.Savebutton();
			utilityclassobject.gettest().log(Status.INFO, "user is able to save the details");		
		}
		
		@Test(dependsOnMethods = "TC_120AssetsServicevehicle_Savebutton")
		public void TC_121AssetsServicevehicle_ViewservicevehicleList() throws InterruptedException
		{
			as.getViewservicelist().click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "The user is able get redirected to the service vehicle list");		
		}
		
		@Test(dependsOnMethods = "TC_121AssetsServicevehicle_ViewservicevehicleList")
		public void TC_122AssetServicevehicle_WithaddedServicevehicle() throws InterruptedException
		{
			webDriverutility wlib = new webDriverutility();
			WebElement addedServicevehicle = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]"));
			wlib.scrollToelement(driver, addedServicevehicle);
			Thread.sleep(2000);
		    Assert.assertTrue(addedServicevehicle.isDisplayed(), "addedServicevehicle is displayed");
		    Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "The added service vehicle is present in the list");		

		}
		
		@Test(dependsOnMethods = "TC_122AssetServicevehicle_WithaddedServicevehicle") 
		public void TC_123AssetsServicevehicle_WithaddedNickname()
		{
			WebElement addedNickname = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]/ancestor::a//div[contains (text(),'"+editnickname+"')]"));
			System.out.println(addedNickname);
		    Assert.assertTrue(addedNickname.isDisplayed(), "addedservicevehciel Nickname is displayed in the list");
			utilityclassobject.gettest().log(Status.INFO,"Added Servicevehicle Nickname is displayed in the list");			
		}
		
		@Test(dependsOnMethods = "TC_123AssetsServicevehicle_WithaddedNickname")
		public void TC_124AssetsServicevehicle_WithVehicleID()
		{
			List<WebElement> vehicleidnumbers = driver.findElements(
			        By.xpath("//div[text()[contains(.,'SV')]]"));

			boolean isVehicleIdFound = false;

			for (WebElement vehcileidnumber : vehicleidnumbers)
			{
			    String actualVehicleId = vehcileidnumber.getText().trim();

			    if (actualVehicleId.equals(addedvehicleID.trim()))
			    {
			        System.out.println("Vehicleidnumber is verified");

			        utilityclassobject.gettest().log(Status.INFO,
			                "VehicleID is verified successfully");

			        isVehicleIdFound = true;

			        break;
			    }
			}

			if (!isVehicleIdFound)
			{
			    System.out.println("Vehicleidnumber is not verified");

			    utilityclassobject.gettest().log(Status.FAIL,
			            "VehicleID is not verified successfully");
			}

			utilityclassobject.gettest().log(Status.INFO,
			        "Added Servicevehicle ServiceID is displayed in the list");
		}
		
		@Test(dependsOnMethods = "TC_124AssetsServicevehicle_WithVehicleID")
		public void TC_125AssetServicevehicle_withVehiclelocation()
		{
			WebElement addedVehiclelocation = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]/ancestor::a//div[contains(text(),'(Henry) Premier Med Waste Solution display')]"));
		    Assert.assertTrue(addedVehiclelocation.isDisplayed(), "addedSerivevehicle location is displayed in the list");
			utilityclassobject.gettest().log(Status.INFO,"Added Servicevehicle location is displayed in the list");				
		}
		
		@Test(dependsOnMethods = "TC_125AssetServicevehicle_withVehiclelocation")
		public void TC_126AssetsServicevehicle_withStatus()
		{
			WebElement addedVehiclestatus = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]/ancestor::a//div[contains(text(),'Active')]"));
		    Assert.assertTrue(addedVehiclestatus.isDisplayed(), "addedSerivevehicle status is displayed in the list");
			utilityclassobject.gettest().log(Status.INFO,"Added Servicevehicle status is displayed in the list");				
		}
		
		@Test(dependsOnMethods = "TC_126AssetsServicevehicle_withStatus")
		public void TC_127AssetsServicevehicle_withVehicletype()
		{
			WebElement addedVehicletype = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]/ancestor::a//div[contains(text(),'Mobile Shred Truck')]"));
		    Assert.assertTrue(addedVehicletype.isDisplayed(), "addedSerivevehicle Vehicletype is displayed in the list");
			utilityclassobject.gettest().log(Status.INFO,"Added Servicevehicle Vehcieltype is displayed in the list");				
		}
		
		@Test(dependsOnMethods = "TC_127AssetsServicevehicle_withVehicletype")
		public void TC_128AssetsServicevehicle_WithPayloadCapacity()
		{
			WebElement addedPayloadcapacity = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]/ancestor::a//div[contains (text(),'"+input2+"')]"));
			System.out.println(addedPayloadcapacity);
		    Assert.assertTrue(addedPayloadcapacity.isDisplayed(), "addedservicevehciel PayloadCapacity is displayed in the list");
			utilityclassobject.gettest().log(Status.INFO,"Added Servicevehicle Payloadcapacity is displayed in the list");			
		}
		
		@Test(dependsOnMethods = "TC_128AssetsServicevehicle_WithPayloadCapacity")
		public void TC_129AssestsServicevehicle_WithNotes() throws InterruptedException
		{
			webDriverutility wlib = new webDriverutility();
			WebElement addedNotes = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]/ancestor::a//div[contains (text(),'"+input1+"')]"));
			wlib.scrollToelement(driver, addedNotes);
			Thread.sleep(2000);
		    Assert.assertTrue(addedNotes.isDisplayed(), "addedServicevehicle is displayed");
		    Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO,"Added Servicevehicle Notes is displayed in the list");			

		}
		
		@Test(dependsOnMethods = "TC_129AssestsServicevehicle_WithNotes")
		public void TC_133AssetsServicevehicle_StatusDrpwithoptions() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 as.getServicelistStatusdrp().click();
			    WebElement dropdown = wait.until(
			            ExpectedConditions.visibilityOfElementLocated(
			                    By.xpath("(//div[contains(@style,'z-index: 9999')])[2]")));

			    Assert.assertTrue(dropdown.isDisplayed(),
			            "vehicle status dropdown is displayed");

			    String[] types = {
			            "Active",
			            "Inactive",
			            "Maintenance",
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until(
			                ExpectedConditions.presenceOfElementLocated(
			                        By.xpath("//span[contains (text(),'"+type+"')]")));

			        actions.moveToElement(typeElement).perform();
			      
			        Assert.assertTrue(typeElement.isDisplayed(),
			                type + " is displayed");
					utilityclassobject.gettest().log(Status.INFO, "The options are present in the Service status dropdown");
			    }
		}
		
			@Test(dependsOnMethods = "TC_133AssetsServicevehicle_StatusDrpwithoptions")
			public void TC_134AssetsServivevehcile_ServicelistwithActivestatus()throws InterruptedException
			{
				as.getSearchOption().click();
				as.getSearchOption().sendKeys("Active");
				as.getListedActivestatus().click();
				Thread.sleep(2000);
				utilityclassobject.gettest().log(Status.INFO, "Service vehicles with Active status are getting filtered out from the list");
			}
			  
			@Test(dependsOnMethods = "TC_134AssetsServivevehcile_ServicelistwithActivestatus")
			public void TC_135AssetsServicevehicle_ServicelistwithInactivestatus() throws InterruptedException
			{
				as.getListedActivestatus().click();
				as.getSearchOption().click();
				as.getSearchOption().sendKeys(Keys.CONTROL + "a");
				as.getSearchOption().sendKeys(Keys.DELETE);
				as.getSearchOption().sendKeys("Inactive");
				as.getListedInactivestatus().click();
				Thread.sleep(2000);
				utilityclassobject.gettest().log(Status.INFO, "Service vehicles with Inactive status are getting filtered out from the list");
			}
			
			@Test(dependsOnMethods = "TC_135AssetsServicevehicle_ServicelistwithInactivestatus")
			public void TC_136AssetsServicevehicle_ServicelistwithMaintenance() throws InterruptedException
			{
				as.getListedInactivestatus().click();
				as.getSearchOption().click();
				as.getSearchOption().sendKeys(Keys.CONTROL + "a");
				as.getSearchOption().sendKeys(Keys.DELETE);
				as.getSearchOption().sendKeys("Maintenance");
				as.getListedmaintenancestatus().click();
				Thread.sleep(2000);
				utilityclassobject.gettest().log(Status.INFO, "Service vehicles with Maintenance status are getting filtered out from the list");
			}
			
			@Test(dependsOnMethods = "TC_136AssetsServicevehicle_ServicelistwithMaintenance")
			public void TC_137AssetsServicevehicle_ServicelistwithMultipleoption()throws InterruptedException
			{
				as.getListedmaintenancestatus().click();
				as.getSearchOption().click();
				as.getSearchOption().sendKeys(Keys.CONTROL + "a");
				as.getSearchOption().sendKeys(Keys.DELETE);
				as.getSearchOption().sendKeys("Inactive");
				as.getListedInactivestatus().click();
				Thread.sleep(2000);
				as.getSearchOption().click();
				as.getSearchOption().sendKeys(Keys.CONTROL + "a");
				as.getSearchOption().sendKeys(Keys.DELETE);
				as.getSearchOption().sendKeys("active");
				as.getListedActivestatus().click();
				Thread.sleep(2000);
				utilityclassobject.gettest().log(Status.INFO, "The user is able to select one or more statuses at a time from the dropdown and the results are filtered out and show correctly");

			}
			
			@Test(dependsOnMethods = "TC_137AssetsServicevehicle_ServicelistwithMultipleoption")
			public void TC_138AssetServicevehicle_Servicewithunselectoption() throws InterruptedException
			{
				as.getListedActivestatus().click();
				Thread.sleep(2000);
				utilityclassobject.gettest().log(Status.INFO, "The user is able to unselect the option and the results are filtered out accordingly");

			}
			
			@Test(dependsOnMethods = "TC_138AssetServicevehicle_Servicewithunselectoption")
			public void TC_139AssetsServicevehicle_withExport() throws InterruptedException
			{
				as.getListedActivestatus().click();
				as.getListedInactivestatus().click();
				Thread.sleep(2000);
				webDriverutility wlib = new webDriverutility();
				WebElement addedservicevehicle = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]"));
				wlib.scrollToelement(driver, addedservicevehicle);
				Thread.sleep(2000);
			    Assert.assertTrue(addedservicevehicle.isDisplayed(), "addedservicevehicle is displayed");
			    Thread.sleep(2000);
				webDriverutility wlib1 = new webDriverutility();
			    WebElement checkbox = driver.findElement(By.xpath("//div[contains(text(),'"+addedvehicleID+"')]/ancestor::a//input[@type='checkbox']"));
				wlib1.scrollToelement(driver, checkbox);
				checkbox.click();
			    as.getExportButton().click();
				utilityclassobject.gettest().log(Status.INFO,"The user is able to export the details of the servicevehicle from selected/list");			

			}
			
			@Test(dependsOnMethods = "TC_139AssetsServicevehicle_withExport")
			public void TC_140AssetsServicevhicle_MultipleservicevehiclewithExport() throws InterruptedException
			{
				webDriverutility wlib = new webDriverutility();
				WebElement servicevehicle = driver.findElement(By.xpath("//div[contains (text(),'SV0000244')]"));
				wlib.scrollToelement(driver, servicevehicle);
			    WebElement checkbox = driver.findElement(By.xpath("//div[contains(text(),'SV0000244')]/ancestor::a//input[@type='checkbox']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
		    		js.executeScript("arguments[0].click();", checkbox);			    
		    		Thread.sleep(2000);
			    WebElement servicevehicle1 = driver.findElement(By.xpath("//div[contains(text(),'SV0000226')]"));
			    	wlib.scrollToelement(driver, servicevehicle1);
			    	WebElement checkbox1 = driver.findElement(By.xpath("//div[contains(text(),'SV0000226')]/ancestor::a//input[@type='checkbox']"));
			    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
			    	js1.executeScript("arguments[0].click();", checkbox1);
				utilityclassobject.gettest().log(Status.INFO,"The user is able to export the details of the Multiple servicevehicles from selected/list");			
			}
			
			@Test(dependsOnMethods = "TC_140AssetsServicevhicle_MultipleservicevehiclewithExport")
			public void TC_141AssetsServicevehicle_withAllExportbutton() throws InterruptedException
			{
				as.getCheckbox().click();
				Thread.sleep(2000);
				as.getExportButton().click();
				utilityclassobject.gettest().log(Status.INFO,"The user is able to export the details of all the service vehicles");			

			}
			
			   
		
		}	
		

		

		
		
		
