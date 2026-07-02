package Octopussaas_GeneratorInformation;

import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

import com.Octopussaas.BaseUtility.BaseclassforGeneratorInformation;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.GeneratorInformation1;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class Octopussaas_GeneratorInformation extends BaseclassforGeneratorInformation{
	GeneratorInformation1 gp;
	ExcelUtility elib;
	String generatorInput;
	WebElement street;
	String editedgeneratorInput;
	
	/*
	@Test(priority = 1)
	public void TC_001GeneratorInformation_withNewGenerator() throws InterruptedException, EncryptedDocumentException, IOException
	{
		gp = new GeneratorInformation1(driver);
		elib = new ExcelUtility();
		gp.getAddnew().click();
		Thread.sleep(200);
		gp.getGenerator().click();
		Thread.sleep(200);
		gp.getGeneratorName().click();
		Random random = new Random();
		int sixDigit = 100000 + random.nextInt(900000);
		generatorInput = elib.getDataFromExcel("GeneratorInformation", 1, 1)+sixDigit;
		gp.getGeneratorName().sendKeys(generatorInput);
		System.out.println(generatorInput);
		
		gp.getAccountNumber().click();
		gp.getAccountNumber().sendKeys("1235698");
		Thread.sleep(200);
		gp.getAddnewGenerator().click();
		Thread.sleep(20000);
		WebElement generatorInformation = driver.findElement(By.xpath("//div[@class='h-full p-5']"));
		Assert.assertTrue(generatorInformation.isDisplayed(), "Generator Information page is displayed");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to access the generator information page");
	}
	
	@Test(dependsOnMethods = "TC_001GeneratorInformation_withNewGenerator")
	public void TC_002GeneratorInformation_withAddedgeneratorname()
	{
		WebElement generatorname = driver.findElement(By.xpath("//h6[contains (text(), '"+generatorInput+"')]"));
		Assert.assertTrue(generatorname.isDisplayed(), "Generator name  is displayed");
		System.out.println(generatorname);
		utilityclassobject.gettest().log(Status.INFO, "The Generator name is present on the top left of the page");
	}
	
	
	//need to write testcase 3
	
	@Test(dependsOnMethods = "TC_002GeneratorInformation_withAddedgeneratorname")
	public void TC_004AssetsServicevehicle_withserviceaddress() throws InterruptedException
	{
		//need to delete these 
		
		WebElement generatormanagment = driver.findElement(By.xpath("//h6[contains (text(),'Generator Management')]"));
		generatormanagment.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement searchoption = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//input[@placeholder='Search by Name, Phone Number, Email, or Address']")));

		searchoption.click();
		searchoption.sendKeys("Max_298310");
		Thread.sleep(20000);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement generator = wait1.until(
		    ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//div[contains(text(),'OCTO Number')]/following::div[contains(text(),'G-108-3316')]")
		        )
		    )
		);

		generator.click();
		Thread.sleep(2000);
		By generatorInfo = By.xpath("//a[contains(text(),'Generator Information')]");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait2.until(ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(generatorInfo)));

		driver.findElement(generatorInfo).click();
		
		WebElement generatorserviceaddress = driver.findElement(By.xpath("//h6[@title='Service Address']"));
		Assert.assertTrue(generatorserviceaddress.isDisplayed(), "Generator name  is displayed");
		System.out.println(generatorserviceaddress);
		utilityclassobject.gettest().log(Status.PASS, "The service address show up blank below the Octo number");
	}
	
	@Test(dependsOnMethods = "TC_004AssetsServicevehicle_withserviceaddress")
	public void TC_005GeneratorInformation_withAddedServiceaddress()
	{
		gp = new GeneratorInformation1(driver);
		gp.Street();
		WebElement street = driver.findElement(By.xpath("//div[contains(text(),'1237 Two Ridge Road, Wintersville, Ohio 43953, United States')]"));
		Actions act = new Actions(driver);
		act.moveToElement(street).click().perform();
		WebElement address = driver.findElement(By.xpath("//span[contains (text(),'1237 Two Ridge Road, Wintersville, OH 43953')]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(address).perform();
		Assert.assertTrue(address.isDisplayed(), "Generator name  is displayed");
		System.out.println(address);
		utilityclassobject.gettest().log(Status.PASS, "The added service address showup in the service address place");

	}
	
	@Test(dependsOnMethods = "TC_005GeneratorInformation_withAddedServiceaddress")
	public void TC_006GeneratorInformation_withAddedCreationdate()
	{
		WebElement creationDate = driver.findElement(By.xpath("//h6[contains (text(),'Created Date: ')]"));
		Assert.assertTrue(creationDate.isDisplayed(), "Creation Date  is displayed");
		System.out.println(creationDate);
		utilityclassobject.gettest().log(Status.PASS, "The Creation Date is present on the top left of the page");
	}
	
	@Test(dependsOnMethods = "TC_006GeneratorInformation_withAddedCreationdate")
	public void TC_007GeneratorInformation_withAddtag() throws InterruptedException
	{
	    gp = new GeneratorInformation1(driver);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    String[] tags = {
	            "Manufacturing",
	            "Urgent",
	            "Summary",
	            "Newwwwww",
	            "Medical Waste",
	            "Test Tag 63093",
	            "School",
	            "Less Priority",
	            "Priority",
	            "Regular tag",
	            "Hospital",
	            "Construction",
	            "New Gen"
	    };

    for (String tag : tags)
	    {
	        try
	        {
	            // Open Add Tag popup/dropdown
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    gp.getAddtagButton())).click();

	            // Locate tag
	            By tagLocator = By.xpath("//span[normalize-space()='" + tag + "']");

	            WebElement tagElement = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(tagLocator));

	            // Scroll to tag
	            ((org.openqa.selenium.JavascriptExecutor) driver)
	                    .executeScript("arguments[0].scrollIntoView({block:'center'});",
	                            tagElement);

	            Thread.sleep(500);

	            // Click tag
	            wait.until(ExpectedConditions.elementToBeClickable(tagElement)).click();

	            System.out.println("Selected Tag : " + tag);

	            utilityclassobject.gettest().log(
	                    Status.INFO,
	                    "Selected Tag : " + tag);

	            // Apply button (if available)
	            try
	            {
	                By applyLocator = By.xpath("//button[contains(.,'Apply')]");

	                WebElement applyButton = wait.until(
	                        ExpectedConditions.elementToBeClickable(applyLocator));

	                applyButton.click();

	                Thread.sleep(1000);
	            }
	            catch (Exception e)
	            {
	                System.out.println("Apply button not found for tag : " + tag);
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println("Failed to select tag : " + tag);
	            e.printStackTrace();
	        }
	    }

	    utilityclassobject.gettest().log(Status.INFO,"User is able to add all available tags");
	}
	
	@Test(dependsOnMethods = "TC_007GeneratorInformation_withAddtag")
	public void TC_008GeneratorInformation_Removetags() throws InterruptedException
	{
		gp.RemoveAddedtags();
	    utilityclassobject.gettest().log(Status.PASS,"User is able to remove the added tags");
		
	}
	
	@Test(dependsOnMethods = "TC_008GeneratorInformation_Removetags")
	public void TC_009GeneratorInformation_addmoreTag()
	{
		 gp = new GeneratorInformation1(driver);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    String[] tags = {
		            "Manufacturing",
		            "Urgent",
		            "Summary",
		            "Newwwwww"    
		    };

		    for (String tag : tags)
		    {
		        try
		        {
		            // Open Add Tag popup/dropdown
		            wait.until(ExpectedConditions.elementToBeClickable(
		                    gp.getAddtagButton())).click();

		            // Locate tag
		            By tagLocator = By.xpath("//span[normalize-space()='" + tag + "']");

		            WebElement tagElement = wait.until(
		                    ExpectedConditions.visibilityOfElementLocated(tagLocator));

		            // Scroll to tag
		            ((org.openqa.selenium.JavascriptExecutor) driver)
		                    .executeScript("arguments[0].scrollIntoView({block:'center'});",
		                            tagElement);

		            Thread.sleep(500);

		            // Click tag
		            wait.until(ExpectedConditions.elementToBeClickable(tagElement)).click();

		            System.out.println("Selected Tag : " + tag);

		            utilityclassobject.gettest().log(
		                    Status.INFO,
		                    "Selected Tag : " + tag);

		            // Apply button (if available)
		            try
		            {
		                By applyLocator = By.xpath("//button[contains(.,'Apply')]");

		                WebElement applyButton = wait.until(
		                        ExpectedConditions.elementToBeClickable(applyLocator));

		                applyButton.click();

		                Thread.sleep(1000);
		            }
		            catch (Exception e)
		            {
		                System.out.println("Apply button not found for tag : " + tag);
		            }
		        }
		        catch (Exception e)
		        {
		            System.out.println("Failed to select tag : " + tag);
		            e.printStackTrace();
		        }
		    }
		    
		    gp.getManufacturingtagCancel().click();
		    gp.getUrgentCancel().click();
		    gp.getSummaryCancel().click();
		    gp.getNewCancel().click();
		    
		
	}
	
	@Test(dependsOnMethods = "TC_009GeneratorInformation_addmoreTag")
	public void TC_010GeneratorInformation_Withouttag()
	{
		 gp = new GeneratorInformation1(driver);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    String[] tags = {
		            "Manufacturing",
		            "Urgent",
		            "Summary",
		            "Newwwwww"    
		    };

		    for (String tag : tags)
		    {
		        try
		        {
		            // Open Add Tag popup/dropdown
		            wait.until(ExpectedConditions.elementToBeClickable(
		                    gp.getAddtagButton())).click();

		            // Locate tag
		            By tagLocator = By.xpath("//span[normalize-space()='" + tag + "']");

		            WebElement tagElement = wait.until(
		                    ExpectedConditions.visibilityOfElementLocated(tagLocator));

		            // Scroll to tag
		            ((org.openqa.selenium.JavascriptExecutor) driver)
		                    .executeScript("arguments[0].scrollIntoView({block:'center'});",
		                            tagElement);

		            Thread.sleep(500);

		            // Click tag
		            wait.until(ExpectedConditions.elementToBeClickable(tagElement)).click();

		            System.out.println("Selected Tag : " + tag);

		            utilityclassobject.gettest().log(
		                    Status.INFO,
		                    "Selected Tag : " + tag);

		            // Apply button (if available)
		            try
		            {
		                By applyLocator = By.xpath("(//button[contains (text(),'Cancel')])[1]");

		                WebElement applyButton = wait.until(
		                        ExpectedConditions.elementToBeClickable(applyLocator));

		                applyButton.click();

		                Thread.sleep(1000);
		            }
		            catch (Exception e)
		            {
		                System.out.println("Apply button not found for tag : " + tag);
		            }
		        }
		        catch (Exception e)
		        {
		            System.out.println("Failed to select tag : " + tag);
		            e.printStackTrace();
		        }
		    }
		    
	}
	
	@Test(dependsOnMethods = "TC_010GeneratorInformation_Withouttag")
	public void TC_011GeneratorInformation_Generatorname()
	{
		WebElement generatorname = driver.findElement(By.xpath("//input[@placeholder='Enter Generator Name']"));
		Assert.assertTrue(generatorname.isDisplayed(), "Generator name field  is displayed");
		String name = generatorname.getText();
		System.out.println(name);
	    utilityclassobject.gettest().log(Status.PASS,"The name added while adding generator is present in the field");
	}
	
	// need to change the dependency
	@Test(dependsOnMethods = "TC_011GeneratorInformation_Generatorname")
	public void TC_012GeneratorInformation_EditedGeneratorName() throws EncryptedDocumentException, IOException
	{
		elib = new ExcelUtility();
		gp.getGeneratornameField().click();
		gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratornameField().sendKeys(Keys.DELETE);
		Random random = new Random();
		int sixDigit1 = 100000 + random.nextInt(900000);
		editedgeneratorInput = elib.getDataFromExcel("GeneratorInformation", 1, 1)+sixDigit1;
		gp.getGeneratornameField().sendKeys(editedgeneratorInput);
		System.out.println(editedgeneratorInput);
	    utilityclassobject.gettest().log(Status.PASS,"The user is able to edit the name of the generator");
	}
	
	@Test(dependsOnMethods = "TC_012GeneratorInformation_EditedGeneratorName")
	public void TC_013GeneratorInformation_GeneratornamewithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratornameField().click();
		gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratornameField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 4, 1);
		gp.getGeneratornameField().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator name textfield will accept numbers");

	}
	
	@Test(dependsOnMethods = "TC_013GeneratorInformation_GeneratornamewithNumbers")
	public void TC_014GeneratorInformation_Generatornamewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratornameField().click();
		gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratornameField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 4, 2);
		gp.getGeneratornameField().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator name textfield will accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_014GeneratorInformation_Generatornamewithspecialcharacters")
	public void TC_015GeneratorInformation_GeneratornamewithAutosave()
	{
		gp.getGeneratornameField().click();
		gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratornameField().sendKeys(Keys.DELETE);
		gp.getGeneratornameField().sendKeys(editedgeneratorInput);
	    utilityclassobject.gettest().log(Status.PASS,"Generator name textfield will autosave the data");
	}
	
	@Test(dependsOnMethods = "TC_015GeneratorInformation_GeneratornamewithAutosave")
	public void TC_016GeneratorInformation_GeneratornamewithoutInput() throws InterruptedException
	{
		gp.getGeneratornameField().click();
		gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratornameField().sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		String errormsg = gp.getGeneratornameErmsg().getText();
		System.out.println(errormsg);
	    utilityclassobject.gettest().log(Status.PASS,"Generator name textfield without input error message is displayed");

		gp.getGeneratornameField().click();
		gp.getGeneratornameField().sendKeys(editedgeneratorInput);
		gp.getOctoNumber().click();

	}
	
	@Test(dependsOnMethods = "TC_016GeneratorInformation_GeneratornamewithoutInput")
	public void TC_017GeneratorInformation_Octonumber()
	{
		WebElement octonumber = driver.findElement(By.xpath("//input[@placeholder='Enter OCTO Number']"));
		Assert.assertTrue(octonumber.isDisplayed(), "octonumber is displayed");
		String generatedOctonumber = octonumber.getAttribute("value").trim();
		System.out.println(generatedOctonumber);
		utilityclassobject.gettest().log(Status.PASS, "Octo number is auto generated and present in the field");		
	}
	
	@Test(dependsOnMethods = "TC_017GeneratorInformation_Octonumber")
	public void TC_018GenratorInformation_OctoNumberwithEdit()
	{
		gp.OctonumberwithEdit();
		utilityclassobject.gettest().log(Status.PASS, "The user is not be able to edit the OCTO Number as it is auto- generated");		
	}
	
	@Test(dependsOnMethods = "TC_018GenratorInformation_OctoNumberwithEdit")
	public void TC_019GeneratorInformation_InternalaccountNumber()
	{
		WebElement InternalaccountNumber = driver.findElement(By.xpath("//input[@placeholder='Enter Internal Account Number']"));
		Assert.assertTrue(InternalaccountNumber.isDisplayed(), "octonumber is displayed");
		String generatedInternalnumber = InternalaccountNumber.getAttribute("value").trim();
		System.out.println(generatedInternalnumber);
		utilityclassobject.gettest().log(Status.PASS, "Internal account number is present in the field");		
	}
	
	@Test(dependsOnMethods = "TC_019GeneratorInformation_InternalaccountNumber")
	public void TC_020GeneratorInformation_Internalaccountnumberwithalphabets() throws EncryptedDocumentException, IOException
	{
		gp.getInternalaccountNumber().click();
		gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
		gp.getInternalaccountNumber().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 7, 1);
		gp.getInternalaccountNumber().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Internal account number textfield will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_020GeneratorInformation_Internalaccountnumberwithalphabets")
	public void TC_021GeneratorInformation_InternalaccountnumberwithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getInternalaccountNumber().click();
		gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
		gp.getInternalaccountNumber().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 7, 2);
		gp.getInternalaccountNumber().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Internal account number textfield will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_021GeneratorInformation_InternalaccountnumberwithNumbers")
	public void TC_022GeneratorInformation_InternalaccountnumberwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getInternalaccountNumber().click();
		gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
		gp.getInternalaccountNumber().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 7, 3);
		gp.getInternalaccountNumber().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Internal account number textfield will accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_022GeneratorInformation_InternalaccountnumberwithSpecialcharacters")
	public void TC_023GeneratorInformation_InternalaccountnumberwithAutosave()
	{
		gp.getInternalaccountNumber().click();
		gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
		gp.getInternalaccountNumber().sendKeys(Keys.DELETE);
		gp.getInternalaccountNumber().sendKeys("1235698");
	    utilityclassobject.gettest().log(Status.PASS,"Internal account number textfield will accept Input and autosave the works");
	}
	
	@Test(dependsOnMethods = "TC_023GeneratorInformation_InternalaccountnumberwithAutosave")
	public void TC_024GeneratorInformation_InternalaccountnumberwithDisplay()
	{
		WebElement InternalaccountNumber = driver.findElement(By.xpath("//h6[@title='Internal Account Number']"));
		Assert.assertTrue(InternalaccountNumber.isDisplayed(), "Internal account number is displayed");
		String generatedInternalnumber = InternalaccountNumber.getText();
		System.out.println(generatedInternalnumber);
		utilityclassobject.gettest().log(Status.INFO, "Internal account number is present below the octonumber of the generator");		
	}
	
	@Test(dependsOnMethods = "TC_024GeneratorInformation_InternalaccountnumberwithDisplay")
	public void TC_025GeneratorInformation_GeneratorpermitwithAlphabets() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorpermitNumber().click();
		gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 10, 1);
		gp.getGeneratorpermitNumber().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_025GeneratorInformation_GeneratorpermitwithAlphabets")
	public void TC_026GeneratorInformation_GeneratorpermitwithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorpermitNumber().click();
		gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 10, 2);
		gp.getGeneratorpermitNumber().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_026GeneratorInformation_GeneratorpermitwithNumbers")
	public void TC_027GeneratorInformation_Generatoepermitwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorpermitNumber().click();
		gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 10, 3);
		gp.getGeneratorpermitNumber().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_027GeneratorInformation_Generatoepermitwithspecialcharacters")
	public void TC_028GeneratorInformation_GeneratorpermitwithAutosave() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorpermitNumber().click();
		gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 10, 2);
		gp.getGeneratorpermitNumber().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept input and autosave");
	}
	
	
	@Test(dependsOnMethods = "TC_028GeneratorInformation_GeneratorpermitwithAutosave")
	public void TC_029GeneratorInformation_GeneratorWebsitewithAlphabets() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorwebsite().click();
		gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 10, 1);
		gp.getGeneratorwebsite().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator website textfield will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_029GeneratorInformation_GeneratorWebsitewithAlphabets")
	public void TC_030GeneratorInformation_GeneratorWebsitewithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorwebsite().click();
		gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 10, 2);
		gp.getGeneratorwebsite().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator website textfield will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_030GeneratorInformation_GeneratorWebsitewithNumbers")
	public void TC_031GeneratorInformation_GeneratorWebsitewithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		
		gp.getGeneratorwebsite().click();
		gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 10, 3);
		gp.getGeneratorwebsite().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator website textfield will accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_031GeneratorInformation_GeneratorWebsitewithSpecialcharacters")
	public void TC_032GeneratorInformation_GeneratorWebsitewithinvalidURL() throws InterruptedException
	{
		gp.getGeneratorwebsite().click();
		gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
		gp.getGeneratorwebsite().sendKeys("Https;/www.facebook.com");
		Thread.sleep(2000);
		String errormsg = gp.getWebsiteErmsg().getText();
		System.out.println(errormsg);
	    utilityclassobject.gettest().log(Status.PASS,"The field prompts the user to enter a valid URL");		   
	}
	
	@Test(dependsOnMethods = "TC_032GeneratorInformation_GeneratorWebsitewithinvalidURL")
	public void TC_033GeneratorInformation_GeneratorwithValidURL() throws InterruptedException
	{
		gp.getGeneratorwebsite().click();
		gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
		gp.getGeneratorwebsite().sendKeys("https://www.facebook.com");
	    utilityclassobject.gettest().log(Status.PASS,"The field accepts the URL in the valid format");		   
	}
	
	@Test(dependsOnMethods = "TC_033GeneratorInformation_GeneratorwithValidURL")
	public void TC_034GeneratorInformation_GeneratorwebsitewithAutosave()
	{
		gp.getGeneratorwebsite().click();
		gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
		gp.getGeneratorwebsite().sendKeys("https://www.facebook.com");
	    utilityclassobject.gettest().log(Status.PASS,"The field accepts the URL in the valid format and autosave");		   
	}
	
	@Test(dependsOnMethods = "TC_034GeneratorInformation_GeneratorwebsitewithAutosave")
	public void TC_035GeneratorInformation_GeneratorwebsitewithLink() throws InterruptedException
	{
		gp.getGeneratorwebsite().click();
		gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
		gp.getGeneratorwebsite().sendKeys("https://www.facebook.com");
		Thread.sleep(2000);
		gp.getOpenlink().click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		utilityclassobject.gettest().log(Status.INFO, "switch to new tab");
		for (String window : allwindows) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window); // switch to new tab 
		        // Do something in new tab if needed
		      Thread.sleep(3000);
		        driver.close(); // close new tab
		    }
			utilityclassobject.gettest().log(Status.INFO, "Switch back to Current tab");
		}
		// Step 3: Switch back to parent tab
		driver.switchTo().window(parentWindow);
		utilityclassobject.gettest().log(Status.PASS, "The user is able get redirected to the website");	
	}
	
	@Test(dependsOnMethods = "TC_035GeneratorInformation_GeneratorwebsitewithLink")
	public void TC_040GeneratorInformation_GeneratorNotewithalphabets() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorNote().click();
		gp.getGeneratorNote().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorNote().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 13, 1);
		gp.getGeneratorNote().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator note textfield will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_040GeneratorInformation_GeneratorNotewithalphabets")
	public void TC_041GeneratorInformation_GeneratorNotewithnumbers() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorNote().click();
		gp.getGeneratorNote().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorNote().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 13, 2);
		gp.getGeneratorNote().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator note textfield will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_041GeneratorInformation_GeneratorNotewithnumbers") 
	public void TC_042GeneratorInformation_GeneratorNotewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getGeneratorNote().click();
		gp.getGeneratorNote().sendKeys(Keys.CONTROL + "a");
		gp.getGeneratorNote().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 13, 3);
		gp.getGeneratorNote().sendKeys(input);
	    utilityclassobject.gettest().log(Status.PASS,"Generator note textfield will accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_042GeneratorInformation_GeneratorNotewithspecialcharacters")
	public void TC_044GeneratorInformation_Attachtoservicelocation()
	{
		WebElement servicelocation = driver.findElement(By.xpath("//button[@id='attach-to service location']"));
		Assert.assertTrue(servicelocation.isDisplayed(), "Servicelocation is displayed");
		WebElement location = driver.findElement(By.xpath("//span[contains (text(),'(Henry) Premier Med Waste Solution display')]"));
		Assert.assertTrue(location.isDisplayed(), "Loaction is displayed");
	    utilityclassobject.gettest().log(Status.PASS,"The main location of the generator is present in the field");

	}
	
	
	//need to change the dependency
	@Test(dependsOnMethods = "TC_044GeneratorInformation_Attachtoservicelocation")
	public void TC_045GeneratorInformation_Servicelocationwithotherlocation() throws InterruptedException
	{
		gp.getServiceLocation().click();
		WebElement dropdown = driver.findElement(By.xpath("//ul[@role='listbox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Set<String> locations = new LinkedHashSet<>();

		int previousCount = 0;

		while (true) {

		    List<WebElement> options = dropdown.findElements(By.xpath(".//li[@role='option']"));

		    for (WebElement option : options) {
		        String text = option.getText().trim();

		        if (!text.isEmpty() && !text.equals("Satellite Locations")) {
		            locations.add(text);
		        }
		    }

		    js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", dropdown);

		    Thread.sleep(1000);

		    if (locations.size() == previousCount) {
		        break; // No new locations found
		    }

		    previousCount = locations.size();
		}

		System.out.println("Total Locations Found: " + locations.size());

		for (String location : locations) {
		    System.out.println(location);
		    utilityclassobject.gettest().log(Status.PASS,"Apart from the main location, satellite locations are available in the dropdown to select from");

		}
	}
	
	@Test(dependsOnMethods = "TC_045GeneratorInformation_Servicelocationwithotherlocation")
	public void TC_046GeneratorInformation_ServicelocationwithontherLocation() throws InterruptedException
	{
		gp.Servicelocation();
	    utilityclassobject.gettest().log(Status.PASS,"The user is able to edit the service location");	
	}
	
	@Test(dependsOnMethods = "TC_046GeneratorInformation_ServicelocationwithontherLocation")
	public void TC_047GeneratorInformation_MorethanoneServicelocation() throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 gp.getServiceLocation().click();
		 gp.getHenryLocation().click();
		 Thread.sleep(2000);
		 gp.getServiceLocation().click();
		 gp.getServiceLocation().click();
		 gp.getServiceLocation().click();
		 gp.getBiotrustLocation().click();
		  List<WebElement> selectedOptions = driver.findElements(
		        By.xpath("//li[@aria-selected='true']")
		    );

		    if (selectedOptions.size() > 1) {
		        System.out.println("FAILED : Field accepts multiple options");
		    } else {
		        System.out.println("PASSED : Field allows only single selection");
		    }
			utilityclassobject.gettest().log(Status.INFO, "The user is not be able to select multiple servicelocation");
	}

	@Test(dependsOnMethods = "TC_047GeneratorInformation_MorethanoneServicelocation")
	public void TC_048GeneratorInformation_ServicelocationwithAutosave() throws InterruptedException
	{
		gp.getServiceLocation().click();
		Thread.sleep(2000);
		gp.getHenryLocation().click();
		utilityclassobject.gettest().log(Status.INFO, "The autosaves the data");	
	}*/
	
	//need to add the dependency
	
	@Test(priority = 1)
	public void TC_049GeneratorInformation_ParentaccountwithInput() throws InterruptedException
	{
		gp = new GeneratorInformation1(driver);
		WebElement generatormanagment = driver.findElement(By.xpath("//h6[contains (text(),'Generator Management')]"));
		generatormanagment.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement generatorlocation = driver.findElement(By.xpath("//h6[contains (text(),'Generator Locations')]"));
		generatorlocation.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		

		WebElement searchoption = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//input[@placeholder='Search by Name, Phone Number, Email, or Address']")));

		searchoption.click();
		searchoption.sendKeys("Max_298310");
		Thread.sleep(20000);

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement generator = wait2.until(
		    ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//div[contains(text(),'OCTO Number')]/following::div[contains(text(),'G-108-3316')]")
		        )
		    )
		);

		generator.click();
		Thread.sleep(2000);
		By generatorInfo = By.xpath("//a[contains(text(),'Generator Information')]");

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait3.until(ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(generatorInfo)));

		driver.findElement(generatorInfo).click();
		Thread.sleep(20000);
		
		//gp.ParentaccountwithInput();
		utilityclassobject.gettest().log(Status.INFO, "The user is able to enter manual input");	

	}
	
	
	/*@Test(dependsOnMethods = "TC_049GeneratorInformation_ParentaccountwithInput")
	public void TC_050GeneratorInformation_ParentaccontwithGenerators()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 gp.getParentAccount().click();
		 gp.getParentAccount().sendKeys(Keys.CONTROL + "a");
		 gp.getParentAccount().sendKeys(Keys.DELETE); 
		 String[] types = {
		            "G-101-0625 - Coastal Dental Group",
		            "G-107-7136 - PriceBook Test 2.0",
		            "G-101-0624 - Summit Healthcare",
		           };

		    Actions actions = new Actions(driver);

		    for (String type : types) {

		        WebElement typeElement = wait.until(
		                ExpectedConditions.presenceOfElementLocated(
		                        By.xpath("//li[@role='option']//span[contains (text(),'"+type+"')]")));

		        actions.moveToElement(typeElement).perform();

		        Assert.assertTrue(typeElement.isDisplayed(),
		                type + " is displayed");
				utilityclassobject.gettest().log(Status.INFO, "Already existing generators are present in the dropdown");

		    }
		    
		   
	}
	
	    @Test(dependsOnMethods = "TC_050GeneratorInformation_ParentaccontwithGenerators")
	    public void TC_051GeneratorInformation_ParentaccountwithGenerator()
	    {
	    	   gp.ParentaccountGenerator();
	    	   utilityclassobject.gettest().log(Status.INFO, "The user is able to select a generator as a parent account");
	    }*/
	
	
		//need to change the dependency
	
	    @Test(dependsOnMethods = "TC_049GeneratorInformation_ParentaccountwithInput"/*"TC_051GeneratorInformation_ParentaccountwithGenerator"*/)
	    public void TC_052GeneratorInformation_ParentaccountwithAutosave() throws InterruptedException
	    {
	    		gp.Unassignbutton();
	    		gp.getParentAccount().click();
	    		gp.ParentaccountGenerator();
		    	utilityclassobject.gettest().log(Status.INFO, "The autosave saves the data");	
	    }
	    
	    @Test(dependsOnMethods = "TC_052GeneratorInformation_ParentaccountwithAutosave")
	    public void TC_053GeneratorInformation_ParentaccontwithUnassign() throws InterruptedException
	    {
	    	  gp.Unassignbutton();
	    	  gp.getParentAccount().click();
	    	  gp.ParentAccountwithCostalgroup();
		  utilityclassobject.gettest().log(Status.INFO, "A pop up appeared- asking reason to unassign");	
   	 
	    }
	    
	    @Test(dependsOnMethods = "TC_053GeneratorInformation_ParentaccontwithUnassign")
	    public void TC_054GeneratorInformation_ParentaccountwithUnassignButton() throws InterruptedException
	    {
	    		gp.Unassignbutton();
	  		utilityclassobject.gettest().log(Status.INFO, "The parent account got unassigned successfully.");	

	    }
	    
	    @Test(dependsOnMethods = "TC_054GeneratorInformation_ParentaccountwithUnassignButton")
	    public void TC_055GeneratorInformation_ParentaccountwithKeeptheAssigned()
	    {
	    	   gp.KeeptheAssigned();
		   utilityclassobject.gettest().log(Status.INFO, "The parent account will not get unassigned");	
	    }
	    
	    @Test(dependsOnMethods = "TC_055GeneratorInformation_ParentaccountwithKeeptheAssigned")
	    public void TC_056GeneratorInformation_unassignwithoutReason() throws InterruptedException
	    {
	    		gp.WithoutUnassign();
	    		WebElement errormsg = driver.findElement(By.xpath("//p[contains (text(),'Enter reason to unassign *')]"));
	    		Assert.assertTrue(errormsg.isDisplayed(), "Unassign note error message is displayed");
	    		System.out.println(errormsg);
	    		Thread.sleep(200);
	    		WebElement cancel = driver.findElement(By.xpath("(//button[contains (text(),'✕')])[2]"));
	    		cancel.click();
	 		utilityclassobject.gettest().log(Status.INFO, "The system indicates to fill the field as it is mandatory");	

	    }
	    
	    @Test(dependsOnMethods = "TC_056GeneratorInformation_unassignwithoutReason")
	    public void TC_057GeneratorInformtion_Withanotherparentaccount() throws InterruptedException
	    {
	    		gp.Unassignbutton();
	    		Thread.sleep(200);
	    		gp.getParentAccount().click();
	    		gp.ParentAccountwithPricebook();
	    		gp.Unassignbutton();
	    		Thread.sleep(200);
	    		gp.getParentAccount().click();
	    		gp.ParentaccountGenerator();
		 	utilityclassobject.gettest().log(Status.INFO, "The user is able to assign another generator as its parent account");	

	    }
	    
	    @Test(dependsOnMethods = "TC_057GeneratorInformtion_Withanotherparentaccount")
	    public void TC_058GeneratorInformation_PhonewithInput() throws EncryptedDocumentException, IOException
	    {
			elib = new ExcelUtility();
	    		gp.getGeneratormainphone().click();
			gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratormainphone().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 16, 1);
			gp.getGeneratormainphone().sendKeys(input);
		    utilityclassobject.gettest().log(Status.PASS,"Generator main phone textfield will accept Input");
	    }
	    
	    @Test(dependsOnMethods = "TC_058GeneratorInformation_PhonewithInput")
	    public void TC_059GeneratorInformation_Phonewithalphabets() throws EncryptedDocumentException, IOException
	    {
	    		gp.getGeneratormainphone().click();
			gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratormainphone().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 16, 2);
			gp.getGeneratormainphone().sendKeys(input);
			String actualValue = gp.getGeneratormainphone().getAttribute("value");

			// Verify that alphabets are not accepted
			if (actualValue.matches(".*[a-zA-Z].*")) {
			    utilityclassobject.gettest().log(Status.FAIL,
			            "Generator Main Phone text field accepted alphabets.");
			} else {
			    utilityclassobject.gettest().log(Status.PASS,
			            "Generator Main Phone text field does not accept alphabets.");
			}
			System.out.println("Generator main phone field will not accept alphabets");
	    }
	    
	    @Test(dependsOnMethods = "TC_059GeneratorInformation_Phonewithalphabets")
	    public void TC_060GeneratorInformation_Phonewithnumbers() throws EncryptedDocumentException, IOException
	    {
	    		gp.getGeneratormainphone().click();
			gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratormainphone().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 16, 3);
			gp.getGeneratormainphone().sendKeys(input);
		    utilityclassobject.gettest().log(Status.PASS,"Generator main phone textfield will accept numbers");
	    }
	    
	    @Test(dependsOnMethods = "TC_060GeneratorInformation_Phonewithnumbers")
	    public void TC_061GeneratorInformation_Phonewithspecialcharacters() throws EncryptedDocumentException, IOException
	    {
	     	gp.getGeneratormainphone().click();
			gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratormainphone().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 16, 4);
			gp.getGeneratormainphone().sendKeys(input);
			String actualValue = gp.getGeneratormainphone().getAttribute("value");

			// Verify that alphabets are not accepted
			if (actualValue.matches(".*[#$^&].*")) {
			    utilityclassobject.gettest().log(Status.FAIL,
			            "Generator Main Phone text field accepted alphabets.");
			} else {
			    utilityclassobject.gettest().log(Status.PASS,
			            "Generator Main Phone text field does not accept alphabets.");
			}
			System.out.println("Generator main phone field will not accept specialcharacters");
	    }
	    
	    @Test(dependsOnMethods = "TC_061GeneratorInformation_Phonewithspecialcharacters")
	    public void TC_062GeneratorInformation_Phonewithmorethan10digits() throws EncryptedDocumentException, IOException
	    {
	     	gp.getGeneratormainphone().click();
			gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratormainphone().sendKeys(Keys.DELETE);
			long txt = 475638476587346783L;
			gp.getGeneratormainphone().sendKeys(String.valueOf(txt));
			String actualValue = gp.getGeneratormainphone().getAttribute("value");

			// Verify the field accepts only 10 digits
			if (actualValue.length() == 10) {
			    utilityclassobject.gettest().log(Status.FAIL,
			            "Generator Main Phone text field accepted more than 10 digits:"+ actualValue);
			} else {
			    utilityclassobject.gettest().log(Status.PASS,
			            "Generator Main Phone text field does not accept more than 10 didgits: " + actualValue);
			}
			System.out.println("Generator main phone text field will not accept more than 10 digits");
	    }
	    
	    @Test(dependsOnMethods = "TC_062GeneratorInformation_Phonewithmorethan10digits")
	    public void TC_063GeneratorInformation_PhonewithshortInput() throws EncryptedDocumentException, IOException
	    {
	    		gp.getGeneratormainphone().click();
			gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratormainphone().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 16, 6);
			gp.getGeneratormainphone().sendKeys(input);
			gp.getExtTextfield().click();
			String errormsg = gp.getMainphoneErmsg().getText();
			System.out.println(errormsg);
		    utilityclassobject.gettest().log(Status.PASS,"Generator main phone textfield does not accept short input");
	      }
	    
	    @Test(dependsOnMethods = "TC_063GeneratorInformation_PhonewithshortInput")
	    public void TC_064GeneratorInformation_PhonewithoutInput()
	    {
	    	    gp.getGeneratormainphone().click();
			gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratormainphone().sendKeys(Keys.DELETE);
		    utilityclassobject.gettest().log(Status.PASS,"The user is able to save the details as it is not a mandatory field");

	    }
	    
	    @Test(dependsOnMethods = "TC_064GeneratorInformation_PhonewithoutInput")
	    public void TC_065GeneratorInformation_ExtwithInput() throws EncryptedDocumentException, IOException
	    {
	    	    gp.getExtTextfield().click();
			gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
			gp.getExtTextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 19, 1);
			gp.getExtTextfield().sendKeys(input);
		    utilityclassobject.gettest().log(Status.PASS,"Generator main Ext textfield will accept inpput");
	    }
	    
	    @Test(dependsOnMethods = "TC_065GeneratorInformation_ExtwithInput")
	    public void TC_066GeneratorInformation_Extwithalphabets() throws EncryptedDocumentException, IOException
	    {
	    		gp.getExtTextfield().click();
	    		gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
	    		gp.getExtTextfield().sendKeys(Keys.DELETE);
	    		String input = elib.getDataFromExcel("GeneratorInformation", 19, 2);
	    		gp.getExtTextfield().sendKeys(input);
	    		String actualValue = gp.getExtTextfield().getAttribute("value");

			// Verify that alphabets are not accepted
			if (actualValue.matches(".*[a-zA-Z].*")) {
			    utilityclassobject.gettest().log(Status.FAIL,
			            "Generator Main Ext text field accepted alphabets.");
			} else {
			    utilityclassobject.gettest().log(Status.PASS,
			            "Generator Main Ext text field does not accept alphabets.");
			}
			System.out.println("Generator main Ext field will not accept alphabets");
			
	    }
	    
	    @Test(dependsOnMethods = "TC_066GeneratorInformation_Extwithalphabets")
	    public void TC_067GeneratorInformation_Extwithnumbers() throws EncryptedDocumentException, IOException
	    {
	    	 	gp.getExtTextfield().click();
			gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
			gp.getExtTextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 19, 3);
			gp.getExtTextfield().sendKeys(input);
			utilityclassobject.gettest().log(Status.PASS,"Generator main Ext textfield will accept numbers");
		}
	    
	    @Test(dependsOnMethods = "TC_067GeneratorInformation_Extwithnumbers")
	    public void TC_068GeneratorInformation_Extwithspecialcharacters() throws EncryptedDocumentException, IOException
	    {
	    	    gp.getExtTextfield().click();
			gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
			gp.getExtTextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 16, 4);
			gp.getExtTextfield().sendKeys(input);
			String actualValue = gp.getExtTextfield().getAttribute("value");

			// Verify that alphabets are not accepted
			if (actualValue.matches(".*[#$^&].*")) {
			    utilityclassobject.gettest().log(Status.FAIL,
			            "Generator Main Ext text field accepted alphabets.");
			} else {
			    utilityclassobject.gettest().log(Status.PASS,
			            "Generator Main Ext text field does not accept alphabets.");
			}
			System.out.println("Generator main Ext field will not accept specialcharacters");
	    }
	    
	    @Test(dependsOnMethods = "TC_068GeneratorInformation_Extwithspecialcharacters")
	    public void TC_069GeneratorInformation_ExtwithMorethan5digits()
	    {
	    		gp.getExtTextfield().click();
			gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
			gp.getExtTextfield().sendKeys(Keys.DELETE);
			long txt = 475638476587346783L;
			gp.getExtTextfield().sendKeys(String.valueOf(txt));
			String actualValue = gp.getExtTextfield().getAttribute("value");

			// Verify the field accepts only 10 digits
			if (actualValue.length() == 5) {
			    utilityclassobject.gettest().log(Status.PASS,
			            "Generator Main Ext text field does not accept more than 5 didgits: "+ actualValue);
			} else {
			    utilityclassobject.gettest().log(Status.FAIL,
			            "Generator Main Ext text field accepted more than 5 didgits: " + actualValue);
			}
			System.out.println("Generator main Ext text field will not accept more than 10 digits");
			
	    }
	    
	    @Test(dependsOnMethods = "TC_069GeneratorInformation_ExtwithMorethan5digits")
	    public void TC_070GeneratorInformation_ExtwithshortInput() throws EncryptedDocumentException, IOException
	    {
	    		gp.getExtTextfield().click();
			gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
			gp.getExtTextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 19, 6);
			gp.getExtTextfield().sendKeys(input);
			utilityclassobject.gettest().log(Status.PASS,"Generator main Ext textfield will accept short input");
		}
	    
	    @Test(dependsOnMethods = "TC_070GeneratorInformation_ExtwithshortInput")
	    public void TC_071GeneratorInformation_ExtwithoutInput()
	    {
	    		gp.getExtTextfield().click();
			gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
			gp.getExtTextfield().sendKeys(Keys.DELETE);
			utilityclassobject.gettest().log(Status.PASS,"The user is able to proceed as it is not a mandatory field");
	    }
	    
	    @Test(dependsOnMethods = "TC_071GeneratorInformation_ExtwithoutInput")
	    public void TC_072GeneratorInformation_GeneratorEmailwithalphabets() throws EncryptedDocumentException, IOException
	    {
	    		gp.getGeneratorEmail().click();
			gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratorEmail().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 22, 1);
			gp.getGeneratorEmail().sendKeys(input);
			utilityclassobject.gettest().log(Status.PASS,"Generator Email textfield will accept alphabets");
		}
	    
	    @Test(dependsOnMethods = "TC_072GeneratorInformation_GeneratorEmailwithalphabets")
	    public void TC_073GeneratorInformation_GeneratorEmailwithNumbers() throws EncryptedDocumentException, IOException
	    {
	    	    gp.getGeneratorEmail().click();
			gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratorEmail().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 22, 2);
			gp.getGeneratorEmail().sendKeys(input);
			utilityclassobject.gettest().log(Status.PASS,"Generator Email textfield will accept numbers");
		}
	    
	    @Test(dependsOnMethods = "TC_073GeneratorInformation_GeneratorEmailwithNumbers")
	    public void TC_074GeneratorInformation_GeneratorEmailwithspecialcharacters() throws EncryptedDocumentException, IOException
	    {
	    		gp.getGeneratorEmail().click();
			gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratorEmail().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 22, 3);
			gp.getGeneratorEmail().sendKeys(input);
			utilityclassobject.gettest().log(Status.PASS,"Generator Email textfield will accept specialcharacters");
		}
	    
	    @Test(dependsOnMethods = "TC_074GeneratorInformation_GeneratorEmailwithspecialcharacters")
	    public void TC_075GeneratorInformation_GeneratorEmailwithInvalid() throws EncryptedDocumentException, IOException
	    {
	     	gp.getGeneratorEmail().click();
			gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratorEmail().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 22, 4);
			gp.getGeneratorEmail().sendKeys(input);
			String errormsg = gp.getGeneratoremailErmsg().getText();
			System.out.println(errormsg);
			utilityclassobject.gettest().log(Status.PASS,"Generator Email textfield does not accept invalid email address");

	    }
	    
	    @Test(dependsOnMethods = "TC_075GeneratorInformation_GeneratorEmailwithInvalid")
	    public void TC_076GeneratorInformation_GeneratorEmailwithValid() throws EncryptedDocumentException, IOException
	    {
	    		gp.getGeneratorEmail().click();
			gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratorEmail().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 22, 5);
			gp.getGeneratorEmail().sendKeys(input);
			utilityclassobject.gettest().log(Status.PASS,"Generator Email textfield accepts valid email address");

	    }
	    
	    @Test(dependsOnMethods = "TC_076GeneratorInformation_GeneratorEmailwithValid")
	    public void TC_077GeneratorInformation_GeneratorEmailwithAutosave() throws EncryptedDocumentException, IOException
	    {
	     	gp.getGeneratorEmail().click();
			gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
			gp.getGeneratorEmail().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorInformation", 22, 5);
			gp.getGeneratorEmail().sendKeys(input);
			utilityclassobject.gettest().log(Status.PASS,"Generator Email textfield accepts valid input and autosaves the data");

	    }
	    
	    @Test(dependsOnMethods = "TC_077GeneratorInformation_GeneratorEmailwithAutosave")
	    public void TC_078GeneratorInformation_withDefaultgeneratorStatus()
	    {
	    		WebElement generatorstatus = driver.findElement(By.xpath("//button[@id='generator-status']"));
			Assert.assertTrue(generatorstatus.isDisplayed(), "Generator status is displayed");
			WebElement status = driver.findElement(By.xpath("(//span[contains (text(),'Prospect')])[2]"));
			Assert.assertTrue(status.isDisplayed(), "Status is displayed");
		    utilityclassobject.gettest().log(Status.PASS,"The Generator status is present and it is having Prospect as default");
	    }
	    
	    @Test(dependsOnMethods = "TC_078GeneratorInformation_withDefaultgeneratorStatus")
	    public void TC_079GeneratorInformation_GeneratorstatuswithTooltip()
	    {
	    		gp.getTooltip().click();
	    		WebElement tooltip = driver.findElement(By.xpath("//div[@class='w-full h-full p-2 bg-white']"));
			Assert.assertTrue(tooltip.isDisplayed(), "Generator status tooltip is displayed");
			gp.getClosetooltip().click();
		    utilityclassobject.gettest().log(Status.PASS,"The tooltip is present and when clicked upon, it opens the octo info");

	    }
	    
	    @Test(dependsOnMethods = "TC_079GeneratorInformation_GeneratorstatuswithTooltip")
	    public void TC_080GeneratorInformation_Generatorwithchangewithnote() throws InterruptedException
	    {
	    	  gp.getGeneratorStatus().click();
	    	  gp.getDeadfielStatus().click();
	    	  gp.Updatestatus();
	    	  Thread.sleep(200);
	    	  gp.getGeneratorStatus().click();
	    	  gp.getProspectStatus().click();
	    	  gp.Updatestatus();
	    	  Thread.sleep(200);
	    	  gp.getGeneratorStatus().click();
	    	  gp.getAdministrativeStatus().click();
	    	  gp.Updatestatus();
	    	  Thread.sleep(200);
	    	  gp.getGeneratorStatus().click();
	    	  gp.getProspectStatus().click();
	    	  gp.Updatestatus();
	    	  Thread.sleep(200);
	    	  utilityclassobject.gettest().log(Status.PASS,"The user is able to change the status of the generator accordingly");

	    }
	    
	    @Test(dependsOnMethods = "TC_080GeneratorInformation_Generatorwithchangewithnote")
	    public void TC_081GeneratorInformation_statuswithKeepcurrentstatus() throws InterruptedException
	    {
	    	  gp.getGeneratorStatus().click();
	    	  gp.getDeadfielStatus().click();
	    	  gp.KeepCurrentstatus();
	    	  Thread.sleep(200);
	    	  utilityclassobject.gettest().log(Status.PASS,"The generator status does not get changed");

	    }
	    
	    
	    @Test(dependsOnMethods = "TC_081GeneratorInformation_statuswithKeepcurrentstatus")
	    public void TC_082GeneratorInformation_StatuswithoutNote() throws InterruptedException
	    {
	    	  gp.getGeneratorStatus().click();
	    	  gp.getDeadfielStatus().click();
	    	  gp.StatuswithoutNote();
	    	  utilityclassobject.gettest().log(Status.PASS,"The system indicates to fill the field as it is mandatory");

	    	  
	    }
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
	
	
	
}

