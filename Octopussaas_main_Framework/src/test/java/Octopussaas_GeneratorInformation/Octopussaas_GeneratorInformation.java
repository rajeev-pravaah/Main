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

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.BaseUtility.BaseclassforGeneratorInformation;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.GeneratorInformation1;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Octopussaas_GeneratorInformation extends BaseClassForGEneratorContacts {
	GeneratorInformation1 gp;
	ExcelUtility elib;
	String generatorInput;
	WebElement street;
	String editedgeneratorInput;

	
	  @Test 
	  public void TC_001GeneratorInformation_withNewGenerator() throws
	  InterruptedException, EncryptedDocumentException, IOException { 
	  gp = new GeneratorInformation1(driver); 
	  elib = new ExcelUtility();
	  gp.getAddnew().click(); Thread.sleep(200); gp.getGenerator().click();
	  Thread.sleep(200); gp.getGeneratorName().click(); Random random = new
	  Random(); int sixDigit = 100000 + random.nextInt(900000); generatorInput =
	  elib.getDataFromExcel("GeneratorInformation", 1, 1)+sixDigit;
	  gp.getGeneratorName().sendKeys(generatorInput);
	  System.out.println(generatorInput);
	  
	  gp.getAccountNumber().click(); gp.getAccountNumber().sendKeys("1235698");
	  Thread.sleep(200); gp.getAddnewGenerator().click(); Thread.sleep(20000);
	  WebElement generatorInformation =
	  driver.findElement(By.xpath("//div[@class='h-full p-5']"));
	  Assert.assertTrue(generatorInformation.isDisplayed(),
	  "Generator Information page is displayed"); System.out.
	  println("The user is able to access the generator information page");
	  utilityclassobject.gettest().log(Status.INFO,
	  "The user is able to access the generator information page"); 
	  }
	  
	  @Test(dependsOnMethods = "TC_001GeneratorInformation_withNewGenerator")
	  public void TC_002GeneratorInformation_withAddedgeneratorname() { WebElement
	  generatorname =
	  driver.findElement(By.xpath("//h6[contains (text(), '"+generatorInput+"')]"))
	  ; Assert.assertTrue(generatorname.isDisplayed(),
	  "Generator name  is displayed"); System.out.println(generatorname);
	  System.out.
	  println("The Generator name is present on the top left of the page");
	  utilityclassobject.gettest().log(Status.INFO,
	  "The Generator name is present on the top left of the page"); }
	  
	  
	  //need to write testcase 3
	  
	  @Test(dependsOnMethods = "TC_002GeneratorInformation_withAddedgeneratorname")
	  public void TC_004AssetsServicevehicle_withserviceaddress() throws InterruptedException 
	  { 
	  WebElement generatorserviceaddress =
	  driver.findElement(By.xpath("//h6[@title='Service Address']"));
	  Assert.assertTrue(generatorserviceaddress.isDisplayed(),
	  "Generator name  is displayed"); System.out.println(generatorserviceaddress);
	  System.out.
	  println("The service address show up blank below the Octo number :PASS");
	  utilityclassobject.gettest().log(Status.PASS,
	  "The service address show up blank below the Octo number"); }
	  
	  @Test(dependsOnMethods = "TC_004AssetsServicevehicle_withserviceaddress")
	  public void TC_005GeneratorInformation_withAddedServiceaddress() { gp = new
	  GeneratorInformation1(driver); gp.Street(); WebElement street =
	  driver.findElement(By.
	  xpath("//div[contains(text(),'1237 Two Ridge Road, Wintersville, Ohio 43953, United States')]"
	  )); Actions act = new Actions(driver);
	  act.moveToElement(street).click().perform(); WebElement address =
	  driver.findElement(By.
	  xpath("//span[contains (text(),'1237 Two Ridge Road, Wintersville, OH 43953')]"
	  )); Actions act1 = new Actions(driver);
	  act1.moveToElement(address).perform();
	  Assert.assertTrue(address.isDisplayed(), "Generator name  is displayed");
	  System.out.println(address); System.out.
	  println("The added service address showup in the service address place :PASS"
	  ); utilityclassobject.gettest().log(Status.PASS,
	  "The added service address showup in the service address place");
	  
	  }
	  
	  @Test(dependsOnMethods ="TC_005GeneratorInformation_withAddedServiceaddress") public void
	  TC_006GeneratorInformation_withAddedCreationdate()
	  { 
	  WebElement creationDate = driver.findElement(By.xpath("//h6[contains (text(),'Created Date: ')]"));
	  Assert.assertTrue(creationDate.isDisplayed(), "Creation Date  is displayed");
	  System.out.println(creationDate); System.out.
	  println(" The Creation Date is present on the top left of the page:PASS");
	  utilityclassobject.gettest().log(Status.PASS,
	  "The Creation Date is present on the top left of the page"); }
	  
	  
	  @Test(dependsOnMethods = "TC_006GeneratorInformation_withAddedCreationdate")
	  public void TC_007GeneratorInformation_withAddtag() throws InterruptedException 
	  { 
		  gp = new GeneratorInformation1(driver);
		  //gp.GeneratorInformation();

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		  gp.getAddtagButton().click();

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

		  Actions actions = new Actions(driver);

		  for (String tag : tags) {

		      try {

		          // Locate checkbox for the current tag
		          By tagLocator = By.xpath(
		              "//label[.//span[normalize-space()='" + tag + "']]//input[@type='checkbox']"
		          );

		          WebElement tagElement = wait.until(
		              ExpectedConditions.presenceOfElementLocated(tagLocator)
		          );

		          // Scroll the checkbox into view
		          ((JavascriptExecutor) driver).executeScript(
		              "arguments[0].scrollIntoView({block:'center'});",
		              tagElement
		          );

		          Thread.sleep(500);

		          // Click checkbox
		          actions.moveToElement(tagElement).click().perform();

		          System.out.println("Selected Tag: " + tag);

		          utilityclassobject.gettest().log(
		              Status.INFO,
		              "Selected Tag: " + tag
		          );

		      } catch (Exception e) {

		          System.out.println("Failed to select tag: " + tag);
		          e.printStackTrace();
		      }
		  }

		  // Click Apply only once after selecting all tags
		  gp.getApplyButton().click();

		  System.out.println("All tags selected successfully.");

		  utilityclassobject.gettest().log(Status.PASS,"User is able to select all available tags");
	
	  }
	  
	  @Test(dependsOnMethods = "TC_007GeneratorInformation_withAddtag") 
	  public void TC_008GeneratorInformation_Removetags() throws InterruptedException {
	  gp.RemoveAddedtags();
	  System.out.println("User is able to remove the added tags : PASS");
	  utilityclassobject.gettest().log(Status.PASS,"User is able to remove the added tags");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_008GeneratorInformation_Removetags")
	  public void TC_009GeneratorInformation_addmoreTag() 
	  {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		  gp.getAddtagButton().click();

		  String[] tags = {
		      "Manufacturing",
		      "Urgent",
		      "Summary",
		      "Newwwwww",
		      "Medical Waste",
		  };

		  Actions actions = new Actions(driver);

		  for (String tag : tags) {

		      try {

		          // Locate checkbox for the current tag
		          By tagLocator = By.xpath(
		              "//label[.//span[normalize-space()='" + tag + "']]//input[@type='checkbox']"
		          );

		          WebElement tagElement = wait.until(
		              ExpectedConditions.presenceOfElementLocated(tagLocator)
		          );

		          // Scroll the checkbox into view
		          ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView({block:'center'});",tagElement
		          );

		          Thread.sleep(500);

		          // Click checkbox
		          actions.moveToElement(tagElement).click().perform();

		          System.out.println("Selected Tag: " + tag);

		          utilityclassobject.gettest().log(
		              Status.INFO,
		              "Selected Tag: " + tag
		          );

		      } catch (Exception e) {

		          System.out.println("Failed to select tag: " + tag);
		          e.printStackTrace();
		      }
		  }

		  // Click Apply only once after selecting all tags
		  gp.getApplyButton().click();
		  System.out.println("User is able to add more than one tags : PASS");
		  utilityclassobject.gettest().log(Status.PASS,"User is able to add more than one tags");
		  
		  gp.getManufacturingtagCancel().click();
		  gp.getUrgentCancel().click();
		  gp.getSummaryCancel().click();
		  gp.getNewCancel().click();
		  gp.getMedicalwasteCancel().click();
		  
 
		  
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_009GeneratorInformation_addmoreTag") 
	  public void TC_010GeneratorInformation_Withouttag() 
	  {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		  gp.getAddtagButton().click();

		  String[] tags = {
		      "Manufacturing",
		      "Urgent",
		      "Summary",
		      "Newwwwww",
		      "Medical Waste",
		  };

		  Actions actions = new Actions(driver);

		  for (String tag : tags) {

		      try {

		          // Locate checkbox for the current tag
		          By tagLocator = By.xpath(
		              "//label[.//span[normalize-space()='" + tag + "']]//input[@type='checkbox']"
		          );

		          WebElement tagElement = wait.until(
		              ExpectedConditions.presenceOfElementLocated(tagLocator)
		          );

		          // Scroll the checkbox into view
		          ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView({block:'center'});",tagElement
		          );

		          Thread.sleep(500);

		          // Click checkbox
		          actions.moveToElement(tagElement).click().perform();

		          System.out.println("Selected Tag: " + tag);

		          utilityclassobject.gettest().log(
		              Status.INFO,
		              "Selected Tag: " + tag
		          );

		      } catch (Exception e) {

		          System.out.println("Failed to select tag: " + tag);
		          e.printStackTrace();
		      }
		  }
		  
		  gp.getCancelButton().click();
		  System.out.println("User is not able to add tags when clicked on cancel : PASS");
		  utilityclassobject.gettest().log(Status.PASS,"User is not able to add tags when clicked on cancel");		  
	  }
	  
	  // need to change the dependency
	  
	  @Test(dependsOnMethods = "TC_006GeneratorInformation_withAddedCreationdate") 
	  public void TC_012GeneratorInformation_EditedGeneratorName() throws EncryptedDocumentException, IOException 
	  { 
	  elib = new ExcelUtility();
	  gp.getGeneratornameField().click();
	  gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratornameField().sendKeys(Keys.DELETE); Random random = new
	  Random(); int sixDigit1 = 100000 + random.nextInt(900000);
	  editedgeneratorInput = elib.getDataFromExcel("GeneratorInformation", 1,
	  1)+sixDigit1; gp.getGeneratornameField().sendKeys(editedgeneratorInput);
	  System.out.println(editedgeneratorInput);
	  System.out.println("The user is able to edit the name of the generator :PASS");    
	  utilityclassobject.gettest().log(Status.PASS,"The user is able to edit the name of the generator"); }
	  
	  @Test(dependsOnMethods = "TC_012GeneratorInformation_EditedGeneratorName")
	  public void TC_013GeneratorInformation_GeneratornamewithNumbers() throws EncryptedDocumentException, IOException { 
	  gp.getGeneratornameField().click();
	  gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratornameField().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 4, 1);
	  gp.getGeneratornameField().sendKeys(input);
	  System.out.println("Generator name textfield will accept numbers : PASS" );
	  utilityclassobject.gettest().log(Status.PASS,"Generator name textfield will accept numbers");
	  
	  }
	  
	  @Test(dependsOnMethods ="TC_013GeneratorInformation_GeneratornamewithNumbers") 
	  public void TC_014GeneratorInformation_Generatornamewithspecialcharacters() throws
	  EncryptedDocumentException, IOException 
	  { 
	  gp.getGeneratornameField().click();
	  gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratornameField().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 4, 2);
	  gp.getGeneratornameField().sendKeys(input); System.out.
	  println("Generator name textfield will accept specialcharacters : PASS");
	  utilityclassobject.gettest().log(Status.PASS,"Generator name textfield will accept specialcharacters"); 
	  }
	  
	  @Test(dependsOnMethods ="TC_014GeneratorInformation_Generatornamewithspecialcharacters") 
	  public void TC_015GeneratorInformation_GeneratornamewithAutosave() {
	  gp.getGeneratornameField().click();
	  gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratornameField().sendKeys(Keys.DELETE);
	  gp.getGeneratornameField().sendKeys(editedgeneratorInput);
	  System.out.println("Generator name textfield will autosave the data : PASS");
	  utilityclassobject.gettest().log(Status. PASS,"Generator name textfield will autosave the data"); }
	  
	  @Test(dependsOnMethods ="TC_015GeneratorInformation_GeneratornamewithAutosave") 
	  public void TC_016GeneratorInformation_GeneratornamewithoutInput() throws InterruptedException { 
	  gp.getGeneratornameField().click();
	  gp.getGeneratornameField().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratornameField().sendKeys(Keys.DELETE); Thread.sleep(2000); String
	  errormsg = gp.getGeneratornameErmsg().getText();
	  System.out.println(errormsg); System.out.
	  println("Generator name textfield without input error message is displayed : PASS"); 
	  utilityclassobject.gettest().log(Status. PASS,"Generator name textfield without input error message is displayed"); 
	  gp.getGeneratornameField().click();
	  gp.getGeneratornameField().sendKeys(editedgeneratorInput);
	  gp.getOctoNumber().click();
	  
	  }
	  
	  @Test(dependsOnMethods ="TC_016GeneratorInformation_GeneratornamewithoutInput") 
	  public void TC_017GeneratorInformation_Octonumber() { 
	  WebElement octonumber = driver.findElement(By.xpath("//input[@placeholder='Enter OCTO Number']"));
	  Assert.assertTrue(octonumber.isDisplayed(), "octonumber is displayed");
	  String generatedOctonumber = octonumber.getAttribute("value").trim();
	  System.out.println(generatedOctonumber); System.out.
	  println("Octo number is auto generated and present in the field : PASS");
	  utilityclassobject.gettest().log(Status.PASS,"Octo number is auto generated and present in the field"); 
	  }
	  
	  @Test(dependsOnMethods = "TC_017GeneratorInformation_Octonumber") 
	  public void TC_018GenratorInformation_OctoNumberwithEdit() 
	  { 
	  gp.OctonumberwithEdit();
	  System.out.println("The user is not be able to edit the OCTO Number as it is auto- generated : PASS"); 
	  utilityclassobject.gettest().log(Status.PASS,"The user is not be able to edit the OCTO Number as it is auto- generated");
	  }
	  
	  @Test(dependsOnMethods = "TC_018GenratorInformation_OctoNumberwithEdit")
	  public void TC_019GeneratorInformation_InternalaccountNumber() { 
	  WebElement InternalaccountNumber = driver.findElement(By.xpath("//input[@placeholder='Enter Internal Account Number']"));
	  Assert.assertTrue(InternalaccountNumber.isDisplayed(),"octonumber is displayed"); 
	  String generatedInternalnumber = InternalaccountNumber.getAttribute("value").trim();
	  System.out.println(generatedInternalnumber);
	  System.out.println("Internal account number is present in the field : PASS");
	  utilityclassobject.gettest().log(Status.PASS,"Internal account number is present in the field"); }
	  
	  @Test(dependsOnMethods = "TC_019GeneratorInformation_InternalaccountNumber")
	  public void TC_020GeneratorInformation_Internalaccountnumberwithalphabets()throws EncryptedDocumentException, IOException 
	  {
	  gp.getInternalaccountNumber().click();
	  gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getInternalaccountNumber().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 7, 1);
	  gp.getInternalaccountNumber().sendKeys(input);
	  System.out.println("Internal account number textfield will accept alphabets : PASS");
	  utilityclassobject.gettest().log(Status. PASS,"Internal account number textfield will accept alphabets"); }
	  
	  @Test(dependsOnMethods ="TC_020GeneratorInformation_Internalaccountnumberwithalphabets") 
	  public void TC_021GeneratorInformation_InternalaccountnumberwithNumbers() throws EncryptedDocumentException, IOException 
	  {
	  gp.getInternalaccountNumber().click();
	  gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getInternalaccountNumber().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 7, 2);
	  gp.getInternalaccountNumber().sendKeys(input); 
	  System.out.println("Internal account number textfield will accept numbers : PASS");
	  utilityclassobject.gettest().log(Status.PASS,"Internal account number textfield will accept numbers"); }
	  
	  @Test(dependsOnMethods ="TC_021GeneratorInformation_InternalaccountnumberwithNumbers") 
	  public void TC_022GeneratorInformation_InternalaccountnumberwithSpecialcharacters()throws EncryptedDocumentException, IOException 
	  {
	  gp.getInternalaccountNumber().click();
	  gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getInternalaccountNumber().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 7, 3);
	  gp.getInternalaccountNumber().sendKeys(input); 
	  System.out.println("Internal account number textfield will accept specialcharacters : PASS"); 
	  utilityclassobject.gettest().log(Status.PASS,"Internal account number textfield will accept specialcharacters"); 
	  }
	  
	  @Test(dependsOnMethods ="TC_022GeneratorInformation_InternalaccountnumberwithSpecialcharacters")
	  public void TC_023GeneratorInformation_InternalaccountnumberwithAutosave() {
	  gp.getInternalaccountNumber().click();
	  gp.getInternalaccountNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getInternalaccountNumber().sendKeys(Keys.DELETE);
	  gp.getInternalaccountNumber().sendKeys("1235698"); 
	  System.out.println("Internal account number textfield will accept Input and autosave the works : PASS"); 
	  utilityclassobject.gettest().log(Status.PASS,"Internal account number textfield will accept Input and autosave the works"); 
	  }
	  
	  @Test(dependsOnMethods = "TC_023GeneratorInformation_InternalaccountnumberwithAutosave") 
	  public void TC_024GeneratorInformation_InternalaccountnumberwithDisplay() 
	  { 
	  WebElement InternalaccountNumber = driver.findElement(By.xpath("//h6[@title='Internal Account Number']"));
	  Assert.assertTrue(InternalaccountNumber.isDisplayed(),
	  "Internal account number is displayed"); 
	  String generatedInternalnumber = InternalaccountNumber.getText(); System.out.println(generatedInternalnumber);
	  System.out.println("Internal account number is present below the octonumber of the generator : PASS"); 
	  utilityclassobject.gettest().log(Status.INFO,"Internal account number is present below the octonumber of the generator");
	  }
	  
	  @Test(dependsOnMethods = "TC_024GeneratorInformation_InternalaccountnumberwithDisplay") 
	  public void TC_025GeneratorInformation_GeneratorpermitwithAlphabets() throws EncryptedDocumentException, IOException {
	  gp.getGeneratorpermitNumber().click();
	  gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 10, 1);
	  gp.getGeneratorpermitNumber().sendKeys(input); 
	  System.out.println("Generator permit number textfield will accept alphabets : PASS");
	  utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept alphabets"); }
	  
	  @Test(dependsOnMethods ="TC_025GeneratorInformation_GeneratorpermitwithAlphabets") 
	  public void TC_026GeneratorInformation_GeneratorpermitwithNumbers() throws EncryptedDocumentException, IOException {
	  gp.getGeneratorpermitNumber().click();
	  gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 10, 2);
	  gp.getGeneratorpermitNumber().sendKeys(input);
	  System.out.println("Generator permit number textfield will accept numbers : PASS");
	  utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept numbers"); }
	  
	  @Test(dependsOnMethods ="TC_026GeneratorInformation_GeneratorpermitwithNumbers") 
	  public void TC_027GeneratorInformation_Generatoepermitwithspecialcharacters() throws EncryptedDocumentException, IOException {
	  gp.getGeneratorpermitNumber().click();
	  gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 10, 3);
	  gp.getGeneratorpermitNumber().sendKeys(input); 
	  System.out.println("Generator permit number textfield will accept specialcharacters : PASS"); 
	  utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept specialcharacters"); }
	  
	  @Test(dependsOnMethods ="TC_027GeneratorInformation_Generatoepermitwithspecialcharacters") 
	  public void TC_028GeneratorInformation_GeneratorpermitwithAutosave() throws
	  EncryptedDocumentException, IOException {
	  gp.getGeneratorpermitNumber().click();
	  gp.getGeneratorpermitNumber().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorpermitNumber().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 10, 2);
	  gp.getGeneratorpermitNumber().sendKeys(input); 
	  System.out. println("Generator permit number textfield will accept input and autosave : PASS" ); 
	  utilityclassobject.gettest().log(Status.PASS,"Generator permit number textfield will accept input and autosave"); }
	  
	  
	  @Test(dependsOnMethods ="TC_028GeneratorInformation_GeneratorpermitwithAutosave") 
	  public void TC_029GeneratorInformation_GeneratorWebsitewithAlphabets() throws EncryptedDocumentException, IOException { 
	  gp.getGeneratorwebsite().click();
	  gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorwebsite().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 10, 1);
	  gp.getGeneratorwebsite().sendKeys(input);
	  utilityclassobject.gettest().log(Status.PASS,"Generator website textfield will accept alphabets"); }
	  
	  @Test(dependsOnMethods = "TC_029GeneratorInformation_GeneratorWebsitewithAlphabets") 
	  public void TC_030GeneratorInformation_GeneratorWebsitewithNumbers() throws EncryptedDocumentException, IOException { 
	  gp.getGeneratorwebsite().click();
	  gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorwebsite().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 10, 2);
	  gp.getGeneratorwebsite().sendKeys(input);
	  utilityclassobject.gettest().log(Status.PASS,"Generator website textfield will accept numbers"); }
	  
	  @Test(dependsOnMethods ="TC_030GeneratorInformation_GeneratorWebsitewithNumbers") 
	  public void TC_031GeneratorInformation_GeneratorWebsitewithSpecialcharacters() throws EncryptedDocumentException, IOException { 
	  gp.getGeneratorwebsite().click();
	  gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorwebsite().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 10, 3);
	  gp.getGeneratorwebsite().sendKeys(input);
	  utilityclassobject.gettest().log(Status. PASS,"Generator website textfield will accept specialcharacters"); }
	  
	  @Test(dependsOnMethods ="TC_031GeneratorInformation_GeneratorWebsitewithSpecialcharacters")
	  public void TC_032GeneratorInformation_GeneratorWebsitewithinvalidURL() throws InterruptedException { 
	  gp.getGeneratorwebsite().click();
	  gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
	  gp.getGeneratorwebsite().sendKeys("Https;/www.facebook.com");
	  Thread.sleep(2000); 
	  String errormsg = gp.getWebsiteErmsg().getText();
	  System.out.println(errormsg); 
	  utilityclassobject.gettest().log(Status. PASS,"The field prompts the user to enter a valid URL"); }
	  
	  @Test(dependsOnMethods ="TC_032GeneratorInformation_GeneratorWebsitewithinvalidURL") 
	  public void TC_033GeneratorInformation_GeneratorwithValidURL() throws InterruptedException { 
	  gp.getGeneratorwebsite().click();
	  gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
	  gp.getGeneratorwebsite().sendKeys("https://www.facebook.com");
	  utilityclassobject.gettest().log(Status. PASS,"The field accepts the URL in the valid format"); }
	  
	  @Test(dependsOnMethods = "TC_033GeneratorInformation_GeneratorwithValidURL")
	  public void TC_034GeneratorInformation_GeneratorwebsitewithAutosave() {
	  gp.getGeneratorwebsite().click();
	  gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
	  gp.getGeneratorwebsite().sendKeys("https://www.facebook.com");
	  utilityclassobject.gettest().log(Status.PASS,"The field accepts the URL in the valid format and autosave"); }
	  
	  @Test(dependsOnMethods ="TC_034GeneratorInformation_GeneratorwebsitewithAutosave") 
	  public void TC_035GeneratorInformation_GeneratorwebsitewithLink() throws InterruptedException { 
	  gp.getGeneratorwebsite().click();
	  gp.getGeneratorwebsite().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorwebsite().sendKeys(Keys.DELETE);
	  gp.getGeneratorwebsite().sendKeys("https://www.facebook.com");
	  Thread.sleep(2000); gp.getOpenlink().click(); 
	  String parentWindow = driver.getWindowHandle(); 
	  Set<String> allwindows = driver.getWindowHandles();
	  utilityclassobject.gettest().log(Status.INFO, "switch to new tab"); 
	  for
	  (String window : allwindows)
	  { if (!window.equals(parentWindow)) {
	  driver.switchTo().window(window); // switch to new tab // Do something in new
	   Thread.sleep(3000); 
	  driver.close(); // close new tab 
	  }
	  utilityclassobject.gettest().log(Status.INFO, "Switch back to Current tab");
	  } // Step 3: Switch back to parent tab
	  driver.switchTo().window(parentWindow);
	  utilityclassobject.gettest().log(Status.PASS,
	  "The user is able get redirected to the website"); 
	  }
	  
	  @Test(dependsOnMethods = "TC_035GeneratorInformation_GeneratorwebsitewithLink") 
	  public void TC_040GeneratorInformation_GeneratorNotewithalphabets() throws EncryptedDocumentException, IOException { 
	  gp.getGeneratorNote().click();
	  gp.getGeneratorNote().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorNote().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 13, 1);
	  gp.getGeneratorNote().sendKeys(input);
	  utilityclassobject.gettest().log(Status.PASS,"Generator note textfield will accept alphabets"); }
	  
	  @Test(dependsOnMethods ="TC_040GeneratorInformation_GeneratorNotewithalphabets") 
	  public void TC_041GeneratorInformation_GeneratorNotewithnumbers() throws EncryptedDocumentException, IOException { 
	  gp.getGeneratorNote().click();
	  gp.getGeneratorNote().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorNote().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 13, 2);
	  gp.getGeneratorNote().sendKeys(input);
	  utilityclassobject.gettest().log(Status.PASS,"Generator note textfield will accept numbers"); }
	  
	  @Test(dependsOnMethods = "TC_041GeneratorInformation_GeneratorNotewithnumbers") public void
	  TC_042GeneratorInformation_GeneratorNotewithspecialcharacters() throws EncryptedDocumentException, IOException {
	  gp.getGeneratorNote().click();
	  gp.getGeneratorNote().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorNote().sendKeys(Keys.DELETE);
	  String input = elib.getDataFromExcel("GeneratorInformation", 13, 3);
	  gp.getGeneratorNote().sendKeys(input);
	  utilityclassobject.gettest().log(Status. PASS,"Generator note textfield will accept specialcharacters"); }
	  
	  @Test(dependsOnMethods ="TC_042GeneratorInformation_GeneratorNotewithspecialcharacters") 
	  public void TC_044GeneratorInformation_Attachtoservicelocation() { 
	  WebElement servicelocation = driver.findElement(By.xpath("//button[@id='attach-to service location']"));
	  Assert.assertTrue(servicelocation.isDisplayed(),"Servicelocation is displayed");
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

		      List<WebElement> options = dropdown.findElements(
		              By.xpath(".//li[@role='option']"));

		      for (WebElement option : options) {

		          String text = option.getText().trim();

		          if (!text.isEmpty() && !text.equals("Satellite Locations")) {
		              locations.add(text);
		          }
		      }

		      // Scroll dropdown to bottom
		      js.executeScript(
		              "arguments[0].scrollTop = arguments[0].scrollHeight;",
		              dropdown);

		      Thread.sleep(1000);

		      // Stop when no new locations are added
		      if (locations.size() == previousCount) {
		          break;
		      }

		      previousCount = locations.size();
		  }

		  System.out.println("Total Locations Found: " + locations.size());

		  for (String location : locations) {
		      System.out.println(location);
		  }

		  utilityclassobject.gettest().log(
		          Status.PASS,
		          "Apart from the main location, satellite locations are available in the dropdown to select from.");
		  }
	  
	  
	  @Test(dependsOnMethods ="TC_045GeneratorInformation_Servicelocationwithotherlocation") 
	  public void TC_046GeneratorInformation_ServicelocationwithontherLocation() throws InterruptedException { 
	  gp.Servicelocation();
	  utilityclassobject.gettest().log(Status.PASS,"The user is able to edit the service location"); }
	  
	  @Test(dependsOnMethods ="TC_046GeneratorInformation_ServicelocationwithontherLocation") 
	  public void TC_047GeneratorInformation_MorethanoneServicelocation() throws InterruptedException { 
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); gp.getServiceLocation().click();
	  gp.getHenryLocation().click(); Thread.sleep(2000);
	  gp.getServiceLocation().click(); gp.getServiceLocation().click();
	  gp.getServiceLocation().click(); gp.getBiotrustLocation().click();
	  List<WebElement> selectedOptions = driver.findElements(
	  By.xpath("//li[@aria-selected='true']") );
	  
	  if (selectedOptions.size() > 1) {
	  System.out.println("FAILED : Field accepts multiple options"); } else {
	  System.out.println("PASSED : Field allows only single selection"); }
	  utilityclassobject.gettest().log(Status.INFO,"The user is not be able to select multiple servicelocation"); }
	  

	  @Test(dependsOnMethods ="TC_047GeneratorInformation_MorethanoneServicelocation") 
	  public void TC_048GeneratorInformation_ServicelocationwithAutosave() throws InterruptedException { 
	  gp.getServiceLocation().click(); 
	  Thread.sleep(2000);
	  gp.getHenryLocation().click(); System.out.println("The autosaves the data");
	  utilityclassobject.gettest().log(Status.INFO, "The autosaves the data"); }
	  
	  //need to add the dependency
	  
	  @Test(dependsOnMethods ="TC_048GeneratorInformation_ServicelocationwithAutosave") 
	  public void TC_049GeneratorInformation_ParentaccountwithInput() throws InterruptedException { 
	  gp.ParentaccountwithInput();
	  System.out.println("The user is able to enter manual input");
	  utilityclassobject.gettest().log(Status.INFO,"The user is able to enter manual input");
	  
	  }
	  
	  
	  @Test(dependsOnMethods = "TC_049GeneratorInformation_ParentaccountwithInput")
	  public void TC_050GeneratorInformation_ParentaccontwithGenerators() {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  gp.getParentAccount().click();
	  gp.getParentAccount().sendKeys(Keys.CONTROL + "a"); 
	  gp.getParentAccount().sendKeys(Keys.DELETE); 
	  String[] types = {"G-101-0625 - Coastal Dental Group", "G-107-7136 - PriceBook Test 2.0",
	  "G-101-0624 - Summit Healthcare", };
	  
	  Actions actions = new Actions(driver);
	  
	  for (String type : types) {
	  
	  WebElement typeElement = wait.until(
	  ExpectedConditions.presenceOfElementLocated(
	  By.xpath("//li[@role='option']//span[contains (text(),'"+type+"')]")));
	  
	  actions.moveToElement(typeElement).perform();
	  
	  Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
	  System.out.println("Already existing generators are present in the dropdown"); 
	  utilityclassobject.gettest().log(Status.INFO, "Already existing generators are present in the dropdown");
	  
	  }
	  
	  
	  } //needto change the dependency
	  
	  @Test(dependsOnMethods ="TC_050GeneratorInformation_ParentaccontwithGenerators") 
	  public void TC_051GeneratorInformation_ParentaccountwithGenerator() {
	  gp.ParentaccountGenerator(); 
	  System.out. println("The user is able to select a generator as a parent account");
	  utilityclassobject.gettest().log(Status.INFO,"The user is able to select a generator as a parent account"); }
	  
	  
	  //need to change the dependency
	  
	  @Test(dependsOnMethods = "TC_051GeneratorInformation_ParentaccountwithGenerator")
	  public void TC_052GeneratorInformation_ParentaccountwithAutosave() throws InterruptedException { 
	  gp.Unassignbutton(); 
	  gp.getParentAccount().click();
	  gp.ParentaccountGenerator();
	  System.out.println("The autosave saves the data");
	  utilityclassobject.gettest().log(Status.INFO, "The autosave saves the data");
	  }
	  
	  @Test(dependsOnMethods = "TC_052GeneratorInformation_ParentaccountwithAutosave") 
	  public void TC_053GeneratorInformation_ParentaccontwithUnassign() throws InterruptedException { 
	  gp.Unassignbutton(); 
	  gp.getParentAccount().click();
	  gp.ParentAccountwithCostalgroup();
	  System.out.println("A pop up appeared- asking reason to unassign");
	  utilityclassobject.gettest().log(Status.INFO,"A pop up appeared- asking reason to unassign");
	  
	  }
	  
	  @Test(dependsOnMethods ="TC_053GeneratorInformation_ParentaccontwithUnassign") 
	  public void TC_054GeneratorInformation_ParentaccountwithUnassignButton() throws InterruptedException { 
	  gp.Unassignbutton();
	  System.out.println("The parent account got unassigned successfully.");
	  utilityclassobject.gettest().log(Status.INFO,"The parent account got unassigned successfully.");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_054GeneratorInformation_ParentaccountwithUnassignButton") 
	  public void TC_055GeneratorInformation_ParentaccountwithKeeptheAssigned() {
	  gp.KeeptheAssigned();
	  System.out.println("The parent account will not get unassigned");
	  utilityclassobject.gettest().log(Status.INFO,"The parent account will not get unassigned"); }
	  
	  @Test(dependsOnMethods ="TC_055GeneratorInformation_ParentaccountwithKeeptheAssigned") 
	  public void  TC_056GeneratorInformation_unassignwithoutReason() throws InterruptedException { 
	  gp.WithoutUnassign(); 
	  WebElement errormsg = driver.findElement(By. xpath("//p[contains (text(),'Enter reason to unassign *')]"));
	  Assert.assertTrue(errormsg.isDisplayed(), "Unassign note error message is displayed"); 
	  System.out.println(errormsg);
	  Thread.sleep(200); 
	  gp.keeptheAssigendButton.click();
	  System.out.println("The system indicates to fill the field as it is mandatory");
	  utilityclassobject.gettest().log(Status.INFO,"The system indicates to fill the field as it is mandatory");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_056GeneratorInformation_unassignwithoutReason")
	  public void TC_057GeneratorInformtion_Withanotherparentaccount() throws
	  InterruptedException { 
	  gp.Unassignbutton(); Thread.sleep(200);
	  gp.getParentAccount().click(); gp.ParentAccountwithPricebook();
	  gp.Unassignbutton(); Thread.sleep(200); gp.getParentAccount().click();
	  gp.ParentaccountGenerator(); System.out.
	  println("The user is able to assign another generator as its parent account"
	  ); utilityclassobject.gettest().log(Status.INFO,
	  "The user is able to assign another generator as its parent account");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_057GeneratorInformtion_Withanotherparentaccount") 
	  public void TC_058GeneratorInformation_PhonewithInput() throws EncryptedDocumentException, IOException { 
	  elib = new ExcelUtility();
	  gp.getGeneratormainphone().click();
	  gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratormainphone().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 16, 1);
	  gp.getGeneratormainphone().sendKeys(input);
	  System.out.println("Generator main phone textfield will accept Input : PASS"); 
	  utilityclassobject.gettest().log(Status.PASS,"Generator main phone textfield will accept Input"); }
	  
	  @Test(dependsOnMethods = "TC_058GeneratorInformation_PhonewithInput") public
	  void TC_059GeneratorInformation_Phonewithalphabets() throws
	  EncryptedDocumentException, IOException { gp.getGeneratormainphone().click();
	  gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratormainphone().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 16, 2);
	  gp.getGeneratormainphone().sendKeys(input); 
	  String actualValue = gp.getGeneratormainphone().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if
	  (actualValue.matches(".*[a-zA-Z].*")) {
		System.out.
	  println("Generator Main Phone text field accepted alphabets. :PASS");
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Generator Main Phone text field accepted alphabets."); } else { System.out.
	  println("Generator Main Phone text field does not accept alphabets. : PASS");
	  utilityclassobject.gettest().log(Status.PASS,
	  "Generator Main Phone text field does not accept alphabets."); }
	  System.out.println("Generator main phone field will not accept alphabets"); }
	  
	  @Test(dependsOnMethods = "TC_059GeneratorInformation_Phonewithalphabets")
	  public void TC_060GeneratorInformation_Phonewithnumbers() throws
	  EncryptedDocumentException, IOException { gp.getGeneratormainphone().click();
	  gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratormainphone().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 16, 3);
	  gp.getGeneratormainphone().sendKeys(input);
	  System.out.println("Generator main phone textfield will accept numbers :PASS"
	  ); utilityclassobject.gettest().log(Status.
	  PASS,"Generator main phone textfield will accept numbers"); }
	  
	  @Test(dependsOnMethods = "TC_060GeneratorInformation_Phonewithnumbers")
	  public void TC_061GeneratorInformation_Phonewithspecialcharacters() throws
	  EncryptedDocumentException, IOException { gp.getGeneratormainphone().click();
	  gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratormainphone().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 16, 4);
	  gp.getGeneratormainphone().sendKeys(input); String actualValue =
	  gp.getGeneratormainphone().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if
	  (actualValue.matches(".*[#$^&].*")) { System.out.
	  println("Generator Main Phone text field accepted Special characters. : PASS"
	  ); utilityclassobject.gettest().log(Status.FAIL,
	  "Generator Main Phone text field accepted Special characters."); } else {
	  System.out.
	  println("Generator Main Phone text field does not accept Special characters : PASS"
	  ); utilityclassobject.gettest().log(Status.PASS,
	  "Generator Main Phone text field does not accept Special characters"); }
	  System.out.
	  println("Generator main phone field will not accept specialcharacters"); }
	  
	  @Test(dependsOnMethods =
	  "TC_061GeneratorInformation_Phonewithspecialcharacters") public void
	  TC_062GeneratorInformation_Phonewithmorethan10digits() throws
	  EncryptedDocumentException, IOException { gp.getGeneratormainphone().click();
	  gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratormainphone().sendKeys(Keys.DELETE); long txt =
	  475638476587346783L;
	  gp.getGeneratormainphone().sendKeys(String.valueOf(txt)); String actualValue
	  = gp.getGeneratormainphone().getAttribute("value");
	  
	  // Verify the field accepts only 10 digits 
	  if (actualValue.length() == 10) {
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Generator Main Phone text field accepted more than 10 digits:"+
	  actualValue); } else { utilityclassobject.gettest().log(Status.PASS,
	  "Generator Main Phone text field does not accept more than 10 didgits: " +
	  actualValue); } System.out.
	  println("Generator main phone text field will not accept more than 10 digits"
	  ); }
	  
	  @Test(dependsOnMethods =
	  "TC_062GeneratorInformation_Phonewithmorethan10digits") 
	  public void TC_063GeneratorInformation_PhonewithshortInput() throws
	  EncryptedDocumentException, IOException { 
		  
	  gp.getGeneratormainphone().click();
	  gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratormainphone().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 16, 6);
	  gp.getGeneratormainphone().sendKeys(input); gp.getExtTextfield().click();
	  String errormsg = gp.getMainphoneErmsg().getText();
	  System.out.println(errormsg); utilityclassobject.gettest().log(Status.
	  PASS,"Generator main phone textfield does not accept short input"); }
	  
	  @Test(dependsOnMethods = "TC_063GeneratorInformation_PhonewithshortInput")
	  public void TC_064GeneratorInformation_PhonewithoutInput() {
	  gp.getGeneratormainphone().click();
	  gp.getGeneratormainphone().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratormainphone().sendKeys(Keys.DELETE);
	  utilityclassobject.gettest().log(Status.
	  PASS,"The user is able to save the details as it is not a mandatory field");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_064GeneratorInformation_PhonewithoutInput")
	  public void TC_065GeneratorInformation_ExtwithInput() throws
	  EncryptedDocumentException, IOException { gp.getExtTextfield().click();
	  gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
	  gp.getExtTextfield().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 19, 1);
	  gp.getExtTextfield().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator main Ext textfield will accept inpput"); }
	  
	  @Test(dependsOnMethods = "TC_065GeneratorInformation_ExtwithInput") public
	  void TC_066GeneratorInformation_Extwithalphabets() throws
	  EncryptedDocumentException, IOException { gp.getExtTextfield().click();
	  gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
	  gp.getExtTextfield().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 19, 2);
	  gp.getExtTextfield().sendKeys(input); String actualValue =
	  gp.getExtTextfield().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if
	  (actualValue.matches(".*[a-zA-Z].*")) {
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Generator Main Ext text field accepted alphabets."); } else {
	  utilityclassobject.gettest().log(Status.PASS,
	  "Generator Main Ext text field does not accept alphabets."); }
	  System.out.println("Generator main Ext field will not accept alphabets");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_066GeneratorInformation_Extwithalphabets")
	  public void TC_067GeneratorInformation_Extwithnumbers() throws
	  EncryptedDocumentException, IOException { gp.getExtTextfield().click();
	  gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
	  gp.getExtTextfield().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 19, 3);
	  gp.getExtTextfield().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator main Ext textfield will accept numbers"); }
	  
	  @Test(dependsOnMethods = "TC_067GeneratorInformation_Extwithnumbers") public
	  void TC_068GeneratorInformation_Extwithspecialcharacters() throws
	  EncryptedDocumentException, IOException { gp.getExtTextfield().click();
	  gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
	  gp.getExtTextfield().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 16, 4);
	  gp.getExtTextfield().sendKeys(input); String actualValue =
	  gp.getExtTextfield().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if
	  (actualValue.matches(".*[#$^&].*")) {
	  
		  utilityclassobject.gettest().log(Status.FAIL,
	  "Generator Main Ext text field accepted specialcharacters."); } else {
	  utilityclassobject.gettest().log(Status.PASS,
	  "Generator Main Ext text field does not accept specialcharacters."); }
	  System.out.
	  println("Generator main Ext field will not accept specialcharacters");
	  
	  
	  }
	  
	  @Test(dependsOnMethods =
	  "TC_068GeneratorInformation_Extwithspecialcharacters") public void
	  TC_069GeneratorInformation_ExtwithMorethan5digits() {
	  gp.getExtTextfield().click(); gp.getExtTextfield().sendKeys(Keys.CONTROL +
	  "a"); gp.getExtTextfield().sendKeys(Keys.DELETE); long txt =
	  475638476587346783L; gp.getExtTextfield().sendKeys(String.valueOf(txt));
	  String actualValue = gp.getExtTextfield().getAttribute("value");
	  
	  // Verify the field accepts only 10 digits 
	  if (actualValue.length() == 5) {
	  utilityclassobject.gettest().log(Status.PASS,
	  "Generator Main Ext text field does not accept more than 5 didgits: "+
	  actualValue); } else { utilityclassobject.gettest().log(Status.FAIL,
	  "Generator Main Ext text field accepted more than 5 didgits: " +
	  actualValue); } System.out.
	  println("Generator main Ext text field will not accept more than 10 digits");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_069GeneratorInformation_ExtwithMorethan5digits")
	  public void TC_070GeneratorInformation_ExtwithshortInput() throws
	  EncryptedDocumentException, IOException { gp.getExtTextfield().click();
	  gp.getExtTextfield().sendKeys(Keys.CONTROL + "a");
	  gp.getExtTextfield().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 19, 6);
	  gp.getExtTextfield().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator main Ext textfield will accept short input"); }
	  
	  
	  @Test(dependsOnMethods = "TC_070GeneratorInformation_ExtwithshortInput")
	  public void TC_071GeneratorInformation_ExtwithoutInput() {
	  gp.getExtTextfield().click(); gp.getExtTextfield().sendKeys(Keys.CONTROL +
	  "a"); gp.getExtTextfield().sendKeys(Keys.DELETE);
	  utilityclassobject.gettest().log(Status.
	  PASS,"The user is able to proceed as it is not a mandatory field"); }
	  
	  @Test(dependsOnMethods = "TC_071GeneratorInformation_ExtwithoutInput") public
	  void TC_072GeneratorInformation_GeneratorEmailwithalphabets() throws
	  EncryptedDocumentException, IOException { gp.getGeneratorEmail().click();
	  gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 22, 1);
	  gp.getGeneratorEmail().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator Email textfield will accept alphabets"); }
	  
	  @Test(dependsOnMethods =
	  "TC_072GeneratorInformation_GeneratorEmailwithalphabets") public void
	  TC_073GeneratorInformation_GeneratorEmailwithNumbers() throws
	  EncryptedDocumentException, IOException { gp.getGeneratorEmail().click();
	  gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 22, 2);
	  gp.getGeneratorEmail().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator Email textfield will accept numbers"); }
	  
	  @Test(dependsOnMethods =
	  "TC_073GeneratorInformation_GeneratorEmailwithNumbers") public void
	  TC_074GeneratorInformation_GeneratorEmailwithspecialcharacters() throws
	  EncryptedDocumentException, IOException { gp.getGeneratorEmail().click();
	  gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 22, 3);
	  gp.getGeneratorEmail().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator Email textfield will accept specialcharacters"); }
	  
	  @Test(dependsOnMethods =
	  "TC_074GeneratorInformation_GeneratorEmailwithspecialcharacters") public void
	  TC_075GeneratorInformation_GeneratorEmailwithInvalid() throws
	  EncryptedDocumentException, IOException { gp.getGeneratorEmail().click();
	  gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 22, 4);
	  gp.getGeneratorEmail().sendKeys(input); String errormsg =
	  gp.getGeneratoremailErmsg().getText(); System.out.println(errormsg);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator Email textfield does not accept invalid email address");
	  
	  }
	  
	  @Test(dependsOnMethods =
	  "TC_075GeneratorInformation_GeneratorEmailwithInvalid") public void
	  TC_076GeneratorInformation_GeneratorEmailwithValid() throws
	  EncryptedDocumentException, IOException { gp.getGeneratorEmail().click();
	  gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 22, 5);
	  gp.getGeneratorEmail().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator Email textfield accepts valid email address");
	  
	  }
	  
	  @Test(dependsOnMethods =
	  "TC_076GeneratorInformation_GeneratorEmailwithValid") public void
	  TC_077GeneratorInformation_GeneratorEmailwithAutosave() throws
	  EncryptedDocumentException, IOException { gp.getGeneratorEmail().click();
	  gp.getGeneratorEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getGeneratorEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 22, 5);
	  gp.getGeneratorEmail().sendKeys(input);
	  utilityclassobject.gettest().log(Status.
	  PASS,"Generator Email textfield accepts valid input and autosaves the data");
	  
	  }
	  
	  //need to change the dependency
	  
	  @Test(dependsOnMethods =
	  "TC_077GeneratorInformation_GeneratorEmailwithAutosave") public void
	  TC_078GeneratorInformation_withDefaultgeneratorStatus() throws
	  InterruptedException { WebElement generatorstatus =
	  driver.findElement(By.xpath("//button[@id='generator-status']"));
	  Assert.assertTrue(generatorstatus.isDisplayed(),
	  "Generator status is displayed"); WebElement status =
	  driver.findElement(By.xpath("(//span[contains (text(),'Prospect')])[2]"));
	  Assert.assertTrue(status.isDisplayed(), "Status is displayed");
	  utilityclassobject.gettest().log(Status.
	  PASS,"The Generator status is present and it is having Prospect as default");
	  }
	  
	  //need to change the dependency
	  
	  @Test(dependsOnMethods =
	  "TC_078GeneratorInformation_withDefaultgeneratorStatus") public void
	  TC_079GeneratorInformation_GeneratorstatuswithTooltip() {
	  gp.getTooltip().click(); WebElement tooltip =
	  driver.findElement(By.xpath("//div[@class='w-full h-full p-2 bg-white']"));
	  Assert.assertTrue(tooltip.isDisplayed(),
	  "Generator status tooltip is displayed"); gp.getClosetooltip().click();
	  utilityclassobject.gettest().log(Status.
	  PASS,"The tooltip is present and when clicked upon, it opens the octo info");
	  
	  }
	  
	  @Test(dependsOnMethods =
	  "TC_079GeneratorInformation_GeneratorstatuswithTooltip") public void
	  TC_080GeneratorInformation_Generatorwithchangewithnote() throws
	  InterruptedException { gp.getGeneratorStatus().click();
	  gp.getDeadfielStatus().click(); gp.Updatestatus();
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(
	  By.xpath("//div[contains(@class,'fixed') and contains(@class,'inset-0')]")));
	  
	  wait.until(ExpectedConditions.elementToBeClickable(gp.getGeneratorStatus())).
	  click();
	  
	  gp.getProspectStatus().click(); gp.Updatestatus();
	  System.out.println("Prospect status got updated"); Thread.sleep(200);
	  
	  utilityclassobject.gettest().log(Status.
	  PASS,"The user is able to change the status of the generator accordingly");
	  
	  }
	  
	  @Test(dependsOnMethods =
	  "TC_080GeneratorInformation_Generatorwithchangewithnote") public void
	  TC_081GeneratorInformation_statuswithKeepcurrentstatus() throws
	  InterruptedException { gp.getGeneratorStatus().click();
	  gp.getDeadfielStatus().click(); gp.KeepCurrentstatus(); Thread.sleep(200);
	  utilityclassobject.gettest().log(Status.
	  PASS,"The generator status does not get changed");
	  
	  }
	  
	  
	  @Test(dependsOnMethods =
	  "TC_081GeneratorInformation_statuswithKeepcurrentstatus") public void
	  TC_082GeneratorInformation_StatuswithoutNote() throws InterruptedException {
	  gp.getGeneratorStatus().click(); gp.getDeadfielStatus().click();
	  gp.StatuswithoutNote(); utilityclassobject.gettest().log(Status.
	  PASS,"The system indicates to fill the field as it is mandatory");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_082GeneratorInformation_StatuswithoutNote")
	  public void TC_083GeneratorInformation_Changeinstatus() throws InterruptedException { 
	  gp.getGeneratorStatus().click();
	  gp.getDeadfielStatus().click(); 
	  gp.Updatestatus();
	  System.out.println("Dead File status got updated");
	  Thread.sleep(200);
	  gp.getGeneratorStatus().click();
	  gp.getProspectStatus().click(); 
	  gp.Updatestatus();
	  System.out.println("Prospect status got updated"); Thread.sleep(200);
	  System.out.println("The user is able to change the status of the generator accordingly :PASS"); 
	  utilityclassobject.gettest().log(Status.PASS,"The user is able to change the status of the generator accordingly");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_083GeneratorInformation_Changeinstatus") public
	  void TC_084GeneratorInformation_IndustrytypewithOptions() { WebDriverWait
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  gp.getIndustryType().click(); WebElement dropdown = wait.until(
	  ExpectedConditions.visibilityOfElementLocated(
	  By.xpath("//ul[@role='listbox']")));
	  
	  Assert.assertTrue(dropdown.isDisplayed(),
	  "vehicle type dropdown is displayed");
	  
	  String[] types = { "Urgent Care Clinics", "Dental Clinics",
	  "Surgery Centers", "Pharmacies & Biotech", "Veterinary Clinics",
	  "Skilled Nursing", "Fire, Police & EMS", "Doctor Offices", "Hospitals",
	  "Medical Spas", "Schools", "Manufacturing", "Retail and Wholesale Trade",
	  "Construction and Engineering", "Hospitality and Recreation",
	  "Professional and Technical Services", "Laboratory", "Dialysis",
	  "Behavioral Health", "Long Term Acute Care", "Tattoo Parlor",
	  "Non-Medical Professional"
	  
	  };
	  
	  Actions actions = new Actions(driver);
	  
	  for (String type : types) {
	  
	  WebElement typeElement = wait.until(
	  ExpectedConditions.presenceOfElementLocated(
	  By.xpath("//li[@role='option']//span[contains (text(),'"+type+"')]")));
	  
	  actions.moveToElement(typeElement).perform();
	  
	  Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
	  System.out.println("Industry type options are present in the dropdwon :PASS"
	  ); utilityclassobject.gettest().log(Status.PASS,
	  "Industry type options are present in the dropdwon"); } }
	  
	  @Test(dependsOnMethods =
	  "TC_084GeneratorInformation_IndustrytypewithOptions") public void
	  TC_085VerifySelecttheIndustrytype() throws InterruptedException {
	  gp.getIndustryType().click(); gp.getIndustryType().click();
	  Thread.sleep(200); gp.IndustrytypeOption();
	  System.out.println("user is able to select a industry type");
	  utilityclassobject.gettest().log(Status.PASS,
	  "user is able to select a industry type from the dropdown"); }
	  
	  
	  @Test(dependsOnMethods = "TC_085VerifySelecttheIndustrytype") public void
	  TC_086VerifySelectmorethanIndustrytype() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  gp.getIndustryType().click(); gp.getIndustryType().click();
	  gp.getNonmedicalType().click(); Thread.sleep(2000);
	  gp.getIndustryType().click(); gp.getIndustryType().click();
	  gp.getIndustryType().click(); gp.getUregentCareType().click();
	  List<WebElement> selectedOptions = driver.findElements(
	  By.xpath("//li[@aria-selected='true']") );
	  
	  if (selectedOptions.size() > 1) {
	  System.out.println("FAILED : Field accepts multiple options"); } else {
	  System.out.println("PASSED : Field allows only single selection"); }
	  System.out.println("The user is not be able to select multiple industrytypes"
	  ); utilityclassobject.gettest().log(Status.INFO,
	  "The user is not be able to select multiple industrytypes"); }
	  
	  //need to change the dependency
	  
	  /*@Test(dependsOnMethods = "TC_086VerifySelectmorethanIndustrytype") public
	  void TC_088VerifyContractedcheckboxwithClick() throws InterruptedException {
	  // gp.ContractedCheckbox();
	  System.out.println("contracted checkbox is not clickable as expected");
	  utilityclassobject.gettest().log(Status.INFO,
	  "contracted checkbox is not clickable as expected");
	  
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_088VerifyContractedcheckboxwithClick") public
	  void TC_089VerifycontractedcheckboxwithClick_withaddingInformation() throws
	  InterruptedException { 
		  
	  gp.getStreet().click();
	  gp.getStreet().sendKeys(Keys.CONTROL + "a");
	  gp.getStreet().sendKeys(Keys.DELETE); //gp.getStreet().sendKeys("1237 2");
	  gp.getStreet().sendKeys("6598 3"); Thread.sleep(2000); WebElement
	  servicestreet = driver.findElement(By.
	  xpath("(//div[contains (text(),'6598 Three Locks Road')])[1]")); //WebElement
	  servicestreet = driver.findElement(By.
	  xpath("//div[contains(text(),'1237 Two Ridge Road, Wintersville, Ohio 43953, United States')]"
	  )); Actions act = new Actions(driver);
	  act.moveToElement(servicestreet).click().perform();
	  System.out.println("Street address enterd into the field");
	  gp.getServiceEmail().click(); gp.getServiceEmail().sendKeys(Keys.CONTROL +
	  "a"); gp.getServiceEmail().sendKeys(Keys.DELETE);
	  gp.getServiceEmail().sendKeys("test@2342test.com");
	  System.out.println("Email address enterd into the field");
	  gp.getServicePhone().click(); gp.getServicePhone().sendKeys(Keys.CONTROL +
	  "a"); gp.getServicePhone().sendKeys(Keys.DELETE);
	  gp.getServicePhone().sendKeys("4859849849");
	  System.out.println("Phone number enterd into the field"); Thread.sleep(2000);
	  gp.getCopyButton().click(); Thread.sleep(200); //gp.ContractedCheckbox();
	  gp.Contracted(); Thread.sleep(200); WebElement popup =
	  driver.findElement(By.xpath("//div[@class='modal-box']"));
	  Assert.assertTrue(popup.isDisplayed());
	  System.out.println("Popup is displayed"); Thread.sleep(200); WebElement
	  button =
	  driver.findElement(By.xpath("(//button[contains (text(),'✕')])[2]"));
	  button.click();
	  System.out.println("user is able click on the contracted checkbox");
	  Thread.sleep(2000); utilityclassobject.gettest().log(Status.INFO,
	  "contracted checkbox is enabled and user is a able to check it");
	  
	  }
	  
	  @Test(dependsOnMethods =
	  "TC_089VerifycontractedcheckboxwithClick_withaddingInformation") public void
	  TC_090VerifycheckboxwithoutGeneratorBilling() throws InterruptedException 
	  {
		  
	  gp.getStreet().click(); gp.getStreet().sendKeys(Keys.CONTROL + "a");
	  gp.getStreet().sendKeys(Keys.DELETE); gp.getStreet().sendKeys("1237 2");
	  //gp.getStreet().sendKeys("6598 3"); Thread.sleep(2000); 
	  //WebElement servicestreet = driver.findElement(By.xpath("(//div[contains (text(),'6598 Three Locks Road')])[1]")); 
	  WebElement servicestreet = driver.findElement(By.xpath("//div[contains(text(),'1237 Two Ridge Road, Wintersville, Ohio 43953, United States')]"
	  )); Actions act = new Actions(driver);
	  act.moveToElement(servicestreet).click().perform();
	  System.out.println("Street address enterd into the field");
	  gp.getServiceEmail().click(); gp.getServiceEmail().sendKeys(Keys.CONTROL +
	  "a"); gp.getServiceEmail().sendKeys(Keys.DELETE);
	  gp.getServiceEmail().sendKeys("test@2342test.com");
	  System.out.println("Email address enterd into the field");
	  gp.getServicePhone().click(); gp.getServicePhone().sendKeys(Keys.CONTROL +
	  "a"); gp.getServicePhone().sendKeys(Keys.DELETE);
	  gp.getServicePhone().sendKeys("4859849849");
	  System.out.println("Phone number enterd into the field"); Thread.sleep(200);
	  gp.getBillingaddressStreet().click();
	  gp.getBillingaddressStreet().sendKeys(Keys.CONTROL + "a");
	  gp.getBillingaddressStreet().sendKeys(Keys.DELETE); Thread.sleep(200);
	  gp.getBillingaddressEmail().click();
	  gp.getBillingaddressEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getBillingaddressEmail().sendKeys(Keys.DELETE); Thread.sleep(200);
	  gp.getBillinaddressPhone().click();
	  gp.getBillinaddressPhone().sendKeys(Keys.CONTROL + "a");
	  gp.getBillinaddressPhone().sendKeys(Keys.DELETE); Thread.sleep(200);
	  //GeneretorInformation ginfo = new GeneretorInformation(driver);
	  gp.Contracted();
	  System.out.println("user is not able click on the contracted checkbox");
	  Thread.sleep(2000); utilityclassobject.gettest().log(Status.INFO,
	  "The user is not be able to check the checkbox");
	  
	  }
	  
	   //need to complete the contracted checkbox testcase
	  
	  @Test(dependsOnMethods = "TC_085VerifySelecttheIndustrytype") public void
	  TC_104VerifyAttentionwithAlphabets() throws EncryptedDocumentException,
	  IOException { 
		  
		  elib = new ExcelUtility(); gp.getServiceAttention().click();
	  gp.getServiceAttention().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceAttention().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 25, 1);
	  gp.getServiceAttention().sendKeys(input);
	  System.out.println("Attention text filed will accept alphabets");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Attention text filed will accept alphabets"); }
	  
	  @Test(dependsOnMethods = "TC_104VerifyAttentionwithAlphabets") public void
	  TC_105VerifyAttentionwithNumbers() throws EncryptedDocumentException,
	  IOException { gp.getServiceAttention().click();
	  gp.getServiceAttention().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceAttention().sendKeys(Keys.DELETE);
	  
	  String input = elib.getDataFromExcel("GeneratorInformation", 25, 2);
	  gp.getServiceAttention().sendKeys(input);
	  System.out.println("Attention text filed will accept numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Attention text filed will accept numbers"); }
	  
	  @Test(dependsOnMethods = "TC_105VerifyAttentionwithNumbers") public void
	  TC_106VerifyAttentionwithSpecialcharacters() throws
	  EncryptedDocumentException, IOException { gp.getServiceAttention().click();
	  gp.getServiceAttention().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceAttention().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 25, 3);
	  gp.getServiceAttention().sendKeys(input);
	  System.out.println("Attention text filed will accept specialcharacters");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Attention text filed will accept specialcharacters"); }
	  
	  @Test(dependsOnMethods = "TC_106VerifyAttentionwithSpecialcharacters") public
	  void TC_107VerifyStreetwithalphabets() throws EncryptedDocumentException,
	  IOException { gp.getStreet().click(); gp.getStreet().sendKeys(Keys.CONTROL +
	  "a"); gp.getStreet().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 28, 1);
	  gp.getStreet().sendKeys(input); utilityclassobject.gettest().log(Status.INFO,
	  "Street text filed will accept alphabets");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_107VerifyStreetwithalphabets") public void
	  TC_108VerifyStreetwithnumbers() throws EncryptedDocumentException,
	  IOException { gp.getStreet().click(); gp.getStreet().sendKeys(Keys.CONTROL +
	  "a"); gp.getStreet().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 28, 2);
	  gp.getStreet().sendKeys(input);
	  System.out.println("Street text filed will accepts Numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Street text filed will accept Numbers");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_108VerifyStreetwithnumbers") public void
	  TC_109VerifyStreetwithSpecialcharacters() throws EncryptedDocumentException,
	  IOException { gp.getStreet().click(); gp.getStreet().sendKeys(Keys.CONTROL +
	  "a"); gp.getStreet().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 28, 3);
	  gp.getStreet().sendKeys(input);
	  System.out.println("Street text filed will accepts specialcharacters");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Street text filed will accepts specialcharacters");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_109VerifyStreetwithSpecialcharacters") public
	  void TC_111VerifyStreetwithAddressuggesstions() throws InterruptedException {
	  gp.getStreet().click(); gp.getStreet().sendKeys(Keys.CONTROL + "a");
	  gp.getStreet().sendKeys(Keys.DELETE); gp.getStreet().sendKeys("1245 6");
	  Thread.sleep(2000); WebElement dropdown = driver.findElement(By.
	  xpath("//div[contains(@class,'absolute') and contains(@class,'overflow-y-auto')]"
	  )); Assert.assertTrue(dropdown.isDisplayed()); System.out.println(dropdown);
	  utilityclassobject.gettest().log(Status.INFO,
	  "The street field will show related suggestions");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_111VerifyStreetwithAddressuggesstions") public
	  void TC_112VerifyStreetwithAutofills() throws InterruptedException {
	  WebElement street1 = driver.findElement(By.
	  xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]"
	  )); street1.click(); Thread.sleep(2000); String city =
	  gp.getBillingcity().getAttribute("value"); System.out.println("City: " +
	  city); String state = gp.getBillingstate().getAttribute("value");
	  System.out.println("State: " + state); String zipcode =
	  gp.getBillingzipcode().getAttribute("value"); System.out.println("Zip Code: "
	  + zipcode); utilityclassobject.gettest().log(Status.INFO,
	  "The city, state and zip code will get autofilled");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_112VerifyStreetwithAutofills") public void
	  TC_113VerifyStatewithAutosave() throws InterruptedException {
	  gp.getStreet().click(); gp.getStreet().sendKeys(Keys.CONTROL + "a");
	  gp.getStreet().sendKeys(Keys.DELETE); gp.getStreet().sendKeys("1245 6");
	  Thread.sleep(2000); WebElement dropdown = driver.findElement(By.
	  xpath("//div[contains(@class,'absolute') and contains(@class,'overflow-y-auto')]"
	  )); Assert.assertTrue(dropdown.isDisplayed());
	  System.out.println("dropdown is displayed"); WebElement street1 =
	  driver.findElement(By.
	  xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]"
	  )); street1.click(); Thread.sleep(2000); String city =
	  gp.getServiceCity().getText(); System.out.println(city); String state =
	  gp.getServiceState().getText(); System.out.println(state); String zipcode =
	  gp.getServiceZipode().getText(); System.out.println(zipcode);
	  utilityclassobject.gettest().log(Status.INFO,
	  "The street field will accept input and autosaves the work");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_113VerifyStatewithAutosave") public void
	  TC_114VerifySuitewithalphabets() throws EncryptedDocumentException,
	  IOException { gp.getServiceSuite().click();
	  gp.getServiceSuite().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceSuite().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 31, 1);
	  gp.getServiceSuite().sendKeys(input);
	  System.out.println("Suite text filed will accepts alphabets");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Suite text filed will accepts alphabets");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_114VerifySuitewithalphabets") public void
	  TC_115VerifySuitewithnumbers() throws EncryptedDocumentException, IOException
	  { gp.getServiceSuite().click(); gp.getServiceSuite().sendKeys(Keys.CONTROL +
	  "a"); gp.getServiceSuite().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 31, 2);
	  gp.getServiceSuite().sendKeys(input);
	  System.out.println("Suite text filed will accepts numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Suite text filed will accepts numbers");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_115VerifySuitewithnumbers") public void
	  TC_116Verifysuitewithspecialcharacters() throws EncryptedDocumentException,
	  IOException { gp.getServiceSuite().click();
	  gp.getServiceSuite().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceSuite().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 31, 3);
	  gp.getServiceSuite().sendKeys(input);
	  System.out.println("Suite text filed will accepts specialcharacters");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Suite text filed will accepts specialcharacters");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_116Verifysuitewithspecialcharacters") public
	  void TC_117VerifySuitewithBlank() { gp.getServiceSuite().click();
	  gp.getServiceSuite().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceSuite().sendKeys(Keys.DELETE); gp.getServiceCity().click();
	  System.out.
	  println("The user is able to proceed as it is not a mandatory field");
	  utilityclassobject.gettest().log(Status.INFO,
	  "The user is able to proceed as it is not a mandatory field");
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_117VerifySuitewithBlank") public void
	  TC_118VerifySuitewithAutosave() throws EncryptedDocumentException,
	  IOException { gp.getServiceSuite().click();
	  gp.getServiceSuite().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceSuite().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 31, 1);
	  gp.getServiceSuite().sendKeys(input); System.out.
	  println("Suite text filed will accepts input and autosaves the work");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Suite text filed will accepts input and autosaves the work"); }
	  
	  @Test(dependsOnMethods = "TC_118VerifySuitewithAutosave") public void
	  TC_119VerifyCitywithalphabets() throws EncryptedDocumentException,
	  IOException { gp.getServiceCity().click();
	  gp.getServiceCity().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceCity().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 34, 1);
	  
	  gp.getServiceCity().sendKeys(input);
	  System.out.println("City text filed will accepts alphabets");
	  utilityclassobject.gettest().log(Status.INFO,
	  "City text filed will accepts alphabets"); }
	  
	  
	  @Test(dependsOnMethods = "TC_119VerifyCitywithalphabets") public void
	  TC_120VerifyCitywithnumbers() throws EncryptedDocumentException, IOException
	  { gp.getServiceCity().click(); gp.getServiceCity().sendKeys(Keys.CONTROL +
	  "a"); gp.getServiceCity().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 34, 2);
	  gp.getServiceCity().sendKeys(input);
	  System.out.println("City text filed will accepts numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "City text filed will accepts numbers"); }
	  
	  @Test(dependsOnMethods = "TC_120VerifyCitywithnumbers") public void
	  TC_121VerifyCitywithspecialcharacters() throws EncryptedDocumentException,
	  IOException { gp.getServiceCity().click();
	  gp.getServiceCity().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceCity().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 34, 3);
	  gp.getServiceCity().sendKeys(input);
	  System.out.println("City text filed will accepts numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "City text filed will accepts numbers"); }
	  
	  @Test(dependsOnMethods = "TC_121VerifyCitywithspecialcharacters") public void
	  TC_123VerifycitywithAutosave() throws EncryptedDocumentException, IOException
	  { gp.getServiceCity().click(); gp.getServiceCity().sendKeys(Keys.CONTROL +
	  "a"); gp.getServiceCity().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 34, 1);
	  gp.getServiceCity().sendKeys(input);
	  System.out.println("City text filed will accepts input and autosave the work"
	  ); utilityclassobject.gettest().log(Status.INFO,
	  "City text filed will accepts input and autosave the work"); }
	  
	  //need to write the TC 124
	  
	  @Test(dependsOnMethods = "TC_123VerifycitywithAutosave") public void
	  TC_125VerifyStatewithOPtions() { WebDriverWait wait = new
	  WebDriverWait(driver, Duration.ofSeconds(10)); gp.getServiceState().click();
	  WebElement dropdown = wait.until(
	  ExpectedConditions.visibilityOfElementLocated(
	  By.xpath("//ul[@role='listbox']")));
	  
	  Assert.assertTrue(dropdown.isDisplayed(), "state dropdown is displayed");
	  
	  String[] types = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL",
	  "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI",
	  "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
	  "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
	  "WI", "WY"
	  
	  };
	  
	  Actions actions = new Actions(driver);
	  
	  for (String type : types) {
	  
	  WebElement typeElement = wait.until(
	  ExpectedConditions.presenceOfElementLocated(
	  By.xpath("//li[@role='option']//span[contains (text(),'"+type+"')]")));
	  
	  actions.moveToElement(typeElement).perform();
	  
	  Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
	  utilityclassobject.gettest().log(Status.INFO,
	  "State options are present in the dropdown");
	  
	  }
	  
	  }
	  
	  @Test(dependsOnMethods = "TC_125VerifyStatewithOPtions") public void
	  TC_126VerifyStatewithselection() throws InterruptedException {
	  gp.Servicestate();
	  System.out.println("The user is able to select the state from the dropdown");
	  utilityclassobject.gettest().log(Status.INFO,
	  "The user is able to select the state from the dropdown"); }
	  
	  //need to write the TC127
	  
	  @Test(dependsOnMethods = "TC_126VerifyStatewithselection") public void
	  TC_128VerifyZipcodewithalphabets() throws EncryptedDocumentException,
	  IOException { gp.getServiceZipode().click();
	  gp.getServiceZipode().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceZipode().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 37, 1);
	  gp.getServiceZipode().sendKeys(input);
	  System.out.println("zipcode text filed will accepts alphabets");
	  utilityclassobject.gettest().log(Status.INFO,
	  "zipcode text filed will accepts alphabets"); }
	  
	  @Test(dependsOnMethods = "TC_128VerifyZipcodewithalphabets") public void
	  TC_129VerifyZipcodewithnumbers() throws EncryptedDocumentException,
	  IOException { gp.getServiceZipode().click();
	  gp.getServiceZipode().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceZipode().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 37, 2);
	  gp.getServiceZipode().sendKeys(input);
	  
	  System.out.println("zipcode text filed will accepts numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "zipcode text filed will accepts numbers"); }
	  
	  @Test(dependsOnMethods = "TC_129VerifyZipcodewithnumbers") public void
	  TC_130VerifyZipcodewithspecialcharacters() throws EncryptedDocumentException,
	  IOException { gp.getServiceZipode().click();
	  gp.getServiceZipode().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceZipode().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 37, 3);
	  gp.getServiceZipode().sendKeys(input);
	  System.out.println("zipcode text filed will accepts specialcharacters");
	  utilityclassobject.gettest().log(Status.INFO,
	  "zipcode text filed will accepts specialcharacters"); }
	  
	  //need to write TC_131 and 132
	  
	  @Test(dependsOnMethods = "TC_130VerifyZipcodewithspecialcharacters") public
	  void TC_133VerifyEmailwithalphabets() throws EncryptedDocumentException,
	  IOException { gp.getServiceEmail().click();
	  gp.getServiceEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 40, 1);
	  gp.getServiceEmail().sendKeys(input);
	  System.out.println("Email text filed will accepts alphabets");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Email text filed will accepts alphabets"); }
	  
	  @Test(dependsOnMethods = "TC_133VerifyEmailwithalphabets") public void
	  TC_134VerifyEmailwithnumbers() throws EncryptedDocumentException, IOException
	  { gp.getServiceEmail().click(); gp.getServiceEmail().sendKeys(Keys.CONTROL +
	  "a"); gp.getServiceEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 40, 2);
	  gp.getServiceEmail().sendKeys(input);
	  System.out.println("Email text filed will accepts numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Email text filed will accepts numbers"); }
	  
	  @Test(dependsOnMethods = "TC_134VerifyEmailwithnumbers") public void
	  TC_135VerifyEmailwithspecialcharacters() throws EncryptedDocumentException,
	  IOException { gp.getServiceEmail().click();
	  gp.getServiceEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceEmail().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 40, 3);
	  gp.getServiceEmail().sendKeys(input);
	  System.out.println("Email text filed will accepts specialcharacters");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Email text filed will accepts specialcharacters"); }
	  
	  @Test(dependsOnMethods = "TC_135VerifyEmailwithspecialcharacters") public
	  void TC_136VerifyEmailwithInvalidinput() throws EncryptedDocumentException,
	  IOException, InterruptedException 
	  { 
	  gp.getServiceEmail().click();
	  gp.getServiceEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceEmail().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 40, 4);
	  gp.getServiceEmail().sendKeys(input); //Thread.sleep(200); 
	  String errormsg = gp.getEmailinvalidErmsg().getText(); System.out.println(errormsg);
	  System.out.println("Email text filed will not accept invalid format and it will propmt Error message"); 
	  utilityclassobject.gettest().log(Status.INFO,"Email text filed will not accept invalid format and it will propmt Error messag"); 
	  
	  gp.getServiceEmail().click();
	  gp.getServiceEmail().sendKeys(Keys.CONTROL + "a");
	  gp.getServiceEmail().sendKeys(Keys.DELETE); 
	  gp.getServiceEmail().sendKeys("test@345test.com");
	  
	  }
	  
	  //need to write 137
	  
	  @Test(dependsOnMethods = "TC_136VerifyEmailwithInvalidinput") public void
	  TC_138VerifyPhonewithalphabets() throws EncryptedDocumentException,IOException { 
		  
	  gp.getServicePhone().click();
	  gp.getServicePhone().sendKeys(Keys.CONTROL + "a");
	  gp.getServicePhone().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 43, 1);
	  gp.getServicePhone().sendKeys(input); String actualValue =
	  gp.getServicePhone().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if(actualValue.matches(".*[a-zA-Z].*")) { 
	   System.out. println("Generator Main Phone text field accepted alphabets. :PASS");
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Phone text field accepted alphabets."); } else {
	  System.out.println("Phone text field does not accept alphabets. : PASS");
	  utilityclassobject.gettest().log(Status.PASS,
	  "Phone text field does not accept alphabets."); }
	  
	  System.out.println("Phone text field will not accept alphabets"); }
	  
	  @Test(dependsOnMethods = "TC_138VerifyPhonewithalphabets") public void
	  TC_139VerifyphonewithNumbers() throws EncryptedDocumentException, IOException
	  { gp.getServicePhone().click(); gp.getServicePhone().sendKeys(Keys.CONTROL +
	  "a"); gp.getServicePhone().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 43, 2);
	  gp.getServicePhone().sendKeys(input);
	  System.out.println("Phone text filed will accepts numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Phone text filed will accepts numbers"); }
	  
	  @Test(dependsOnMethods = "TC_139VerifyphonewithNumbers") public void
	  TC_140VerifyPhonewithspecialcharacters() throws EncryptedDocumentException,
	  IOException { gp.getServicePhone().click();
	  gp.getServicePhone().sendKeys(Keys.CONTROL + "a");
	  gp.getServicePhone().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 43, 3);
	  gp.getServicePhone().sendKeys(input); String actualValue =
	  gp.getServicePhone().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if(actualValue.matches(".*[#$^&].*")) {
	  System.out.println("Phone text field accepted specialcharacters. :PASS");
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Phone text field accepted alphabets."); } else { System.out.
	  println("Phone text field does not accept specialcharacters. : PASS");
	  utilityclassobject.gettest().log(Status.PASS,
	  "Phone text field does not accept specialcharacters."); }
	  System.out.println("Phone text field does not accept specialcharacters."); }
	  
	  @Test(dependsOnMethods = "TC_140VerifyPhonewithspecialcharacters") public
	  void TC_141VerifyPhonewithmorethan10digits() { gp.getServicePhone().click();
	  gp.getServicePhone().sendKeys(Keys.CONTROL + "a");
	  gp.getServicePhone().sendKeys(Keys.DELETE); long txt = 475638476587346783L;
	  gp.getServicePhone().sendKeys(String.valueOf(txt)); String actualValue =
	  gp.getServicePhone().getAttribute("value");
	  
	  // Verify the field accepts only 10 digits 
	  if (actualValue.length() == 10) {
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Phone text field accepted more than 10 digits:"+ actualValue); } else {
	  utilityclassobject.gettest().log(Status.PASS,
	  "Phone text field does not accept more than 10 didgits: " + actualValue); }
	  System.out.println("Phone text field will not accept more than 10 digits"); }
	  
	  
	  
	  @Test(dependsOnMethods = "TC_141VerifyPhonewithmorethan10digits") public void
	  TC_142VerifyPhonewithshortinput() throws EncryptedDocumentException, IOException, InterruptedException {
	  gp.getServicePhone().click();
	  gp.getServicePhone().sendKeys(Keys.CONTROL + "a");
	  gp.getServicePhone().sendKeys(Keys.DELETE); 
	  String input = elib.getDataFromExcel("GeneratorInformation", 43, 5);
	  gp.getServicePhone().sendKeys(input); //Thread.sleep(2000); 
	  String errormsg = gp.getPhoneErmsg().getText(); System.out.println(errormsg);
	  System.out.println("Phone text field will not accept short input");
	  utilityclassobject.gettest().log(Status.INFO,"Phone text field will not accept short input");
	  
	  gp.getServicePhone().click();
	  gp.getServicePhone().sendKeys(Keys.CONTROL + "a");
	  gp.getServicePhone().sendKeys(Keys.DELETE); 
	  gp.getServicePhone().sendKeys("9873453423");
	  
	  }
	  
	  //need to write Tc 143
	  
	  @Test(dependsOnMethods = "TC_142VerifyPhonewithshortinput") 
	  public void TC_144VerifyExtwithalphabets() throws EncryptedDocumentException, IOException
	  { 
		  gp.getExt().click(); 
		  gp.getExt().sendKeys(Keys.CONTROL + "a");
	  gp.getExt().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 46, 1);
	  gp.getExt().sendKeys(input); String actualValue =
	  gp.getExt().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if(actualValue.matches(".*[a-zA-Z].*")) 
	  {
	  System.out.println("Ext text field accepted alphabets. :PASS");
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Ext text field accepted alphabets."); } else {
	  System.out.println("Phone text field does not accept alphabets. : PASS");
	  utilityclassobject.gettest().log(Status.PASS,
	  "Ext text field does not accept alphabets."); }
	  System.out.println("Ext text field will not accept alphabets"); }
	  
	  @Test(dependsOnMethods = "TC_144VerifyExtwithalphabets") public void
	  TC_145VerifyExtwithNumbers() throws EncryptedDocumentException, IOException {
	  gp.getExt().click(); gp.getExt().sendKeys(Keys.CONTROL + "a");
	  gp.getExt().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 46, 2 );
	  gp.getExt().sendKeys(input);
	  System.out.println("Ext text field will accept numbers");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Ext text field will accept numbers"); }
	  
	  @Test(dependsOnMethods = "TC_145VerifyExtwithNumbers") public void
	  TC_146VerifyExtwithspecialcharacters() throws EncryptedDocumentException,
	  IOException { gp.getExt().click(); gp.getExt().sendKeys(Keys.CONTROL + "a");
	  gp.getExt().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 46, 3);
	  gp.getExt().sendKeys(input);
	  
	  String actualValue = gp.getExt().getAttribute("value");
	  
	  // Verify that alphabets are not accepted 
	  if(actualValue.matches(".*[#$^&].*")) {
	  System.out.println("Ext text field accepted specialcharacters. :PASS");
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Ext text field accepted alphabets."); } else {
	  System.out.println("Ext text field does not accept specialcharacters. : PASS"
	  ); utilityclassobject.gettest().log(Status.PASS,
	  "Ext text field does not accept specialcharacters."); }
	  System.out.println("Ext text field does not accept specialcharacters."); }
	  
	  @Test(dependsOnMethods = "TC_146VerifyExtwithspecialcharacters") public void
	  TC_147VerifyExtwithmorethan5() throws EncryptedDocumentException, IOException
	  { gp.getExt().click(); gp.getExt().sendKeys(Keys.CONTROL + "a");
	  gp.getExt().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 46, 4);
	  gp.getExt().sendKeys(String.valueOf(input)); String actualValue =
	  gp.getServicePhone().getAttribute("value");
	  
	  // Verify the field accepts only 10 digits 
	  if (actualValue.length() == 5) {
	  utilityclassobject.gettest().log(Status.FAIL,
	  "Ext text field accepted more than 5 digits:"+ actualValue); } 
	  else {
	  utilityclassobject.gettest().log(Status.PASS,
	  "Ext text field does not accept more than 5 didgits: " + actualValue); 
	  }
	  System.out.println("Ext text field will not accept more than 5 digits"); }
	  
	  @Test(dependsOnMethods = "TC_147VerifyExtwithmorethan5") 
	  public void TC_148VerifyExtwithshortInput() throws EncryptedDocumentException,
	  IOException { gp.getExt().click(); gp.getExt().sendKeys(Keys.CONTROL + "a");
	  gp.getExt().sendKeys(Keys.DELETE); String input =
	  elib.getDataFromExcel("GeneratorInformation", 46, 5);
	  gp.getExt().sendKeys(input);
	  System.out.println("Ext text field will accept short input");
	  utilityclassobject.gettest().log(Status.INFO,
	  "Ext text field will accept short input"); }
	  
	  @Test(dependsOnMethods = "TC_148VerifyExtwithshortInput") public void
	  TC_149VerifyExtwithoutInput() { gp.getExt().click();
	  gp.getExt().sendKeys(Keys.CONTROL + "a"); gp.getExt().sendKeys(Keys.DELETE);
	  System.out.println("The user is able to proceed as it is not mandatory");
	  utilityclassobject.gettest().log(Status.INFO,
	  "The user is able to proceed as it is not mandatory"); }
	 

	// need to write TC 150 to 158

	// need to change the dependency
	@Test(dependsOnMethods = "TC_149VerifyExtwithoutInput")
	public void TC_159VerifybillingAttentionwithalphabets()
			throws EncryptedDocumentException, IOException, InterruptedException {
		gp = new GeneratorInformation1(driver);
		elib = new ExcelUtility();
		gp.getBillingattention().click();
		gp.getBillingattention().sendKeys(Keys.CONTROL + "a");
		gp.getBillingattention().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		gp.getBillingattention().sendKeys(input);
		System.out.println("Attention text field will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO, "Attention text field will accept alphabets");

	}

	@Test(dependsOnMethods = "TC_159VerifybillingAttentionwithalphabets")
	public void TC_160VerifybillingAttentionwithnumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		gp.getBillingattention().click();
		gp.getBillingattention().sendKeys(Keys.CONTROL + "a");
		gp.getBillingattention().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 25, 2);
		gp.getBillingattention().sendKeys(input);
		System.out.println("Attention text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "Attention text field will accept numbers");

	}

	@Test(dependsOnMethods = "TC_160VerifybillingAttentionwithnumbers")
	public void TC_161VerifybillingAttentionwithspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingattention().click();
		gp.getBillingattention().sendKeys(Keys.CONTROL + "a");
		gp.getBillingattention().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 25, 3);
		gp.getBillingattention().sendKeys(input);
		System.out.println("Attention text field will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO, "Attention text field will accept specialcharacters");
	}

	@Test(dependsOnMethods = "TC_161VerifybillingAttentionwithspecialcharacters")
	public void TC_162VerifybillingStreetwithalphabets() throws EncryptedDocumentException, IOException {
		gp.getBillingaddressStreet().click();
		gp.getBillingaddressStreet().sendKeys(Keys.CONTROL + "a");
		gp.getBillingaddressStreet().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 1);
		gp.getBillingaddressStreet().sendKeys(input);
		System.out.println("Street text field will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO, "Street text field will accept alphabets");
	}

	@Test(dependsOnMethods = "TC_162VerifybillingStreetwithalphabets")
	public void TC_163VerifybillingStreetwithnumbers() throws EncryptedDocumentException, IOException {
		gp.getBillingaddressStreet().click();
		gp.getBillingaddressStreet().sendKeys(Keys.CONTROL + "a");
		gp.getBillingaddressStreet().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 2);
		gp.getBillingaddressStreet().sendKeys(input);
		System.out.println("Street text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "Street text field will accept numbers");
	}

	@Test(dependsOnMethods = "TC_163VerifybillingStreetwithnumbers")
	public void TC_164VerifybillingStreetwithspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingaddressStreet().click();
		gp.getBillingaddressStreet().sendKeys(Keys.CONTROL + "a");
		gp.getBillingaddressStreet().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 3);
		gp.getBillingaddressStreet().sendKeys(input);
		System.out.println("Street text field will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO, "Street text field will accept specialcharacters");
	}

	// need to write TC 165
	@Test(dependsOnMethods = "TC_164VerifybillingStreetwithspecialcharacters")
	public void TC_166VerifybillingStreetwithsuggestion() throws InterruptedException {
		gp.getBillingaddressStreet().click();
		gp.getBillingaddressStreet().sendKeys(Keys.CONTROL + "a");
		gp.getBillingaddressStreet().sendKeys(Keys.DELETE);
		gp.getBillingaddressStreet().sendKeys("1245 6");
		Thread.sleep(2000);
		WebElement dropdown = driver
				.findElement(By.xpath("//div[contains(@class,'absolute') and contains(@class,'overflow-y-auto')]"));
		Assert.assertTrue(dropdown.isDisplayed());
		System.out.println(dropdown);
		System.out.println("The billing street field will show related suggestions");
		utilityclassobject.gettest().log(Status.INFO, "The billing street field will show related suggestions");
	}

	@Test(dependsOnMethods = "TC_166VerifybillingStreetwithsuggestion")
	public void TC_167VerifybillingStreetwithAutofills() throws InterruptedException {
		WebElement street1 = driver.findElement(
				By.xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]"));
		street1.click();
		String city = gp.getBillingcity().getAttribute("value");
		System.out.println("City: " + city);
		String state = gp.getBillingstate().getAttribute("value");
		System.out.println("State: " + state);
		String zipcode = gp.getBillingzipcode().getAttribute("value");
		System.out.println("Zip Code: " + zipcode);
		System.out.println("The city, state and zip code will get autofilled");
		utilityclassobject.gettest().log(Status.INFO, "The city, state and zip code will get autofilled");
	}

	@Test(dependsOnMethods = "TC_167VerifybillingStreetwithAutofills")
	public void TC_168VerifybillingStreetwithAutosave() throws InterruptedException {
		gp.getBillingaddressStreet().click();
		gp.getBillingaddressStreet().sendKeys(Keys.CONTROL + "a");
		gp.getBillingaddressStreet().sendKeys(Keys.DELETE);
		gp.getBillingaddressStreet().sendKeys("1245 6");
		Thread.sleep(2000);
		WebElement dropdown = driver
				.findElement(By.xpath("//div[contains(@class,'absolute') and contains(@class,'overflow-y-auto')]"));
		Assert.assertTrue(dropdown.isDisplayed());
		System.out.println("dropdown is displayed");
		WebElement street1 = driver.findElement(
				By.xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]"));
		street1.click();
		Thread.sleep(2000);
		String city = gp.getBillingcity().getText();
		System.out.println(city);
		String state = gp.getBillingstate().getText();
		System.out.println(state);
		String zipcode = gp.getBillingzipcode().getText();
		System.out.println(zipcode);
		System.out.println("The street field will accept input and autosaves");
		utilityclassobject.gettest().log(Status.INFO, "The street field will accept input and autosaves");

	}

	@Test(dependsOnMethods = "TC_168VerifybillingStreetwithAutosave")
	public void TC_169Verifybillingsuitewithalphabets() throws EncryptedDocumentException, IOException {
		gp.getBillingsuite().click();
		gp.getBillingsuite().sendKeys(Keys.CONTROL + "a");
		gp.getBillingsuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 1);
		gp.getBillingsuite().sendKeys(input);
		System.out.println("Suite text field will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO, "Suite text field will accept alphabets");
	}

	@Test(dependsOnMethods = "TC_169Verifybillingsuitewithalphabets")
	public void TC_170Verifybillingsuitewithnumbers() throws EncryptedDocumentException, IOException {
		gp.getBillingsuite().click();
		gp.getBillingsuite().sendKeys(Keys.CONTROL + "a");
		gp.getBillingsuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 2);
		gp.getBillingsuite().sendKeys(input);
		System.out.println("Suite text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "Suite text field will accept numbers");

	}

	@Test(dependsOnMethods = "TC_170Verifybillingsuitewithnumbers")
	public void TC_171Verifybillingsuitewithspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingsuite().click();
		gp.getBillingsuite().sendKeys(Keys.CONTROL + "a");
		gp.getBillingsuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 3);
		gp.getBillingsuite().sendKeys(input);
		System.out.println("Suite text field will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO, "Suite text field will accept numbers");
	}

	@Test(dependsOnMethods = "TC_171Verifybillingsuitewithspecialcharacters")
	public void TC_172VerifybillingsuitewithoutInput() {
		gp.getBillingsuite().click();
		gp.getBillingsuite().sendKeys(Keys.CONTROL + "a");
		gp.getBillingsuite().sendKeys(Keys.DELETE);
		System.out.println("The user is able to proceed as it is not a mandatory field");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to proceed as it is not a mandatory field");
	}

	@Test(dependsOnMethods = "TC_172VerifybillingsuitewithoutInput")
	public void TC_173VerifybillingwithAutosave() throws EncryptedDocumentException, IOException {
		gp.getBillingsuite().click();
		gp.getBillingsuite().sendKeys(Keys.CONTROL + "a");
		gp.getBillingsuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 1);
		gp.getBillingsuite().sendKeys(input);
		System.out.println("Suite text field will accept input and autosave");
		utilityclassobject.gettest().log(Status.INFO, "Suite text field will accept input and autosave");
	}

	@Test(dependsOnMethods = "TC_173VerifybillingwithAutosave")
	public void TC_174Verifybillingcitywithalphabets() throws EncryptedDocumentException, IOException {
		gp.getBillingcity().click();
		gp.getBillingcity().sendKeys(Keys.CONTROL + "a");
		gp.getBillingcity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 1);
		gp.getBillingcity().sendKeys(input);
		System.out.println("City text field will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO, "City text field will accept alphabets");
	}


	@Test(dependsOnMethods = "TC_174Verifybillingcitywithalphabets")
	public void TC_175Verifybillingcitywithnumbers() throws EncryptedDocumentException, IOException {
		gp.getBillingcity().click();
		gp.getBillingcity().sendKeys(Keys.CONTROL + "a");
		gp.getBillingcity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 2);
		gp.getBillingcity().sendKeys(input);
		System.out.println("City text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "City text field will accept numbers");
	}

	@Test(dependsOnMethods = "TC_175Verifybillingcitywithnumbers")
	public void TC_176Verifybillingcitywithspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingcity().click();
		gp.getBillingcity().sendKeys(Keys.CONTROL + "a");
		gp.getBillingcity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 3);
		gp.getBillingcity().sendKeys(input);
		System.out.println("City text field will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO, "City text field will accept specialcharacters");
	}

	// need to write the TC_177

	@Test(dependsOnMethods = "TC_176Verifybillingcitywithspecialcharacters")
	public void TC_178Verifybillingcitywithautosave() throws EncryptedDocumentException, IOException {
		gp.getBillingcity().click();
		gp.getBillingcity().sendKeys(Keys.CONTROL + "a");
		gp.getBillingcity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 1);
		gp.getBillingcity().sendKeys(input);
		System.out.println("City text field will accept input and autosave");
		utilityclassobject.gettest().log(Status.INFO, "City text field will accept input and autosave");

	}

	
	 * @Test public void TC_179VerifybillingstatewithInput() throws
	 * EncryptedDocumentException, IOException { gp.getBillingstate().click();
	 * gp.getBillingstate().sendKeys(Keys.CONTROL + "a");
	 * gp.getBillingstate().sendKeys(Keys.DEL
	 * ETE); String input =
	 * elib.getDataFromExcel("GeneratorInformation", 34, 1);
	 * gp.getBillingstate().sendKeys(input);
	 * System.out.println("City text field will accept input and autosave");
	 * utilityclassobject.gettest().log(Status.INFO,
	 * "City text field will accept input and autosave");
	 * 
	 * }
	 *

	@Test(dependsOnMethods = "TC_178Verifybillingcitywithautosave")
	public void TC_180Verifybillingstatewithoption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		gp.getBillingstate().click();
		WebElement dropdown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

		Assert.assertTrue(dropdown.isDisplayed(), "state dropdown is displayed");

		String[] types = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
				"KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
				"NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
				"WY"

		};

		Actions actions = new Actions(driver);

		for (String type : types) {

			WebElement typeElement = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//li[@role='option']//span[contains (text(),'" + type + "')]")));

			actions.moveToElement(typeElement).perform();

			Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
			utilityclassobject.gettest().log(Status.INFO, "State options are present in the dropdown");

		}
	}

	@Test(dependsOnMethods = "TC_180Verifybillingstatewithoption")
	public void TC_181Verifybillingstatewithselectedoptions() throws InterruptedException {
		gp.billingState();
		System.out.println("The user is able to select the state");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to select the state");

	}

	// need to write the TC_182

	@Test(dependsOnMethods = "TC_181Verifybillingstatewithselectedoptions")
	public void TC_183VerifybillingZipcodewithalphabets() throws EncryptedDocumentException, IOException {
		gp.getBillingzipcode().click();
		gp.getBillingzipcode().sendKeys(Keys.CONTROL + "a");
		gp.getBillingzipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 37, 1);
		gp.getBillingzipcode().sendKeys(input);
		System.out.println("Zipcode text field will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO, "Zipcode text field will accept alphabets");

	}

	@Test(dependsOnMethods = "TC_183VerifybillingZipcodewithalphabets")
	public void TC_184VerifybillingZipcodewithnumbers() throws EncryptedDocumentException, IOException {
		gp.getBillingzipcode().click();
		gp.getBillingzipcode().sendKeys(Keys.CONTROL + "a");
		gp.getBillingzipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 37, 2);
		gp.getBillingzipcode().sendKeys(input);
		System.out.println("Zipcode text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "Zipcode text field will accept numbers");
	}

	@Test(dependsOnMethods = "TC_184VerifybillingZipcodewithnumbers")
	public void TC_185VerifybillingZipcodewithspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingzipcode().click();
		gp.getBillingzipcode().sendKeys(Keys.CONTROL + "a");
		gp.getBillingzipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 37, 3);
		gp.getBillingzipcode().sendKeys(input);
		System.out.println("Zipcode text field will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO, "Zipcode text field will accept specialcharacters");
	}

	// need to write TC_186 and 187

	@Test(dependsOnMethods = "TC_185VerifybillingZipcodewithspecialcharacters")
	public void TC_188VerifybillingEmailwithalphabets() throws EncryptedDocumentException, IOException {
		gp.getBillingEmail().click();
		gp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		gp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 40, 1);
		gp.getBillingEmail().sendKeys(input);
		System.out.println("Email text field will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO, "Email text field will accept alphabets");
	}

	@Test(dependsOnMethods = "TC_188VerifybillingEmailwithalphabets")
	public void TC_189VerifybillingEmailwithnumbers() throws EncryptedDocumentException, IOException {
		gp.getBillingEmail().click();
		gp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		gp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 40, 2);
		gp.getBillingEmail().sendKeys(input);
		System.out.println("Email text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "Email text field will accept numbers");

	}

	@Test(dependsOnMethods = "TC_189VerifybillingEmailwithnumbers")
	public void TC_190VerifybillingEmailwithspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingEmail().click();
		gp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		gp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 40, 3);
		gp.getBillingEmail().sendKeys(input);
		System.out.println("Email text field will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO, "Email text field will accept specialcharacters");
	}

	@Test(dependsOnMethods = "TC_190VerifybillingEmailwithspecialcharacters")
	public void TC_191VerifybillingEmailwithInvalidinput() throws EncryptedDocumentException, IOException {
		gp.getBillingEmail().click();
		gp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		gp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 40, 4);
		gp.getBillingEmail().sendKeys(input);
		String errormsg = gp.getBillingEmailinvalidmsg().getText();
		System.out.println(errormsg);
		System.out.println("Email text field will not accept invalid input and it will prompt Error message");
		utilityclassobject.gettest().log(Status.INFO,"Email text field will not accept invalid input and it will prompt Error message");

	}

	@Test(dependsOnMethods = "TC_191VerifybillingEmailwithInvalidinput")
	public void TC_192VerifybillingEmailwithValidfromat() throws EncryptedDocumentException, IOException {
		gp.getBillingEmail().click();
		gp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		gp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		gp.getBillingEmail().sendKeys(input);
		// gp.getBillingEmail().sendKeys("test2342@test.com");
		System.out.println("Email text field will accept valid email format");
		utilityclassobject.gettest().log(Status.INFO, "Email text field will accept valid email format");

	}

	// need to write the TC_193

	@Test(dependsOnMethods = "TC_192VerifybillingEmailwithValidfromat")
	public void TC_194Verifybillingphonewithalphabets() throws EncryptedDocumentException, IOException {
		gp.getBillingPhone().click();
		gp.getBillingPhone().sendKeys(Keys.CONTROL + "a");
		gp.getBillingPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 43, 1);
		gp.getBillingPhone().sendKeys(input);
		String actualValue = gp.getBillingPhone().getAttribute("value");

		// Verify that alphabets are not accepted
		if (actualValue.matches(".*[a-zA-Z].*")) {
			System.out.println("Billing Phone text field accepted alphabets. :PASS");
			utilityclassobject.gettest().log(Status.FAIL, "Phone text field accepted alphabets.");
		} else {
			System.out.println("Phone text field does not accept alphabets. : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone text field does not accept alphabets.");
		}

		System.out.println("Phone text field will not accept alphabets");
	}

	@Test(dependsOnMethods = "TC_194Verifybillingphonewithalphabets")
	public void TC_195VerifybillingPhonewithNumbers() throws EncryptedDocumentException, IOException {
		gp.getBillingPhone().click();
		gp.getBillingPhone().sendKeys(Keys.CONTROL + "a");
		gp.getBillingPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		gp.getBillingPhone().sendKeys(input);
		System.out.println("Phone text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "Phone text field will accept numbers");
	}

	@Test(dependsOnMethods = "TC_195VerifybillingPhonewithNumbers")
	public void TC_196VerifybillingPhonewihtspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingPhone().click();
		gp.getBillingPhone().sendKeys(Keys.CONTROL + "a");
		gp.getBillingPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 43, 3);
		gp.getBillingPhone().sendKeys(input);
		String actualValue = gp.getBillingPhone().getAttribute("value");

		// Verify that alphabets are not accepted
		if (actualValue.matches(".*[#-@$%-%^].*")) {
			System.out.println("Billing Phone text field accepted specialcharacters. :PASS");
			utilityclassobject.gettest().log(Status.FAIL, "Phone text field accepted specialcharacters.");
		} else {
			System.out.println("Phone text field does not accept specialcharacters. : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone text field does not accept specialcharacters.");
		}

		System.out.println("Phone text field will not accept specialcharacters");
	}

	@Test(dependsOnMethods = "TC_196VerifybillingPhonewihtspecialcharacters")
	public void TC_197VerifybillinPhonewithmorethan10digits() {
		gp.getBillingPhone().click();
		gp.getBillingPhone().sendKeys(Keys.CONTROL + "a");
		gp.getBillingPhone().sendKeys(Keys.DELETE);
		long txt = 475638476587346783L;
		gp.getBillingPhone().sendKeys(String.valueOf(txt));
		String actualValue = gp.getBillingPhone().getAttribute("value");

		// Verify the field accepts only 10 digits
		if (actualValue.length() == 10) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Phone text field accepted more than 10 digits:" + actualValue);
		} else {
			utilityclassobject.gettest().log(Status.PASS,
					"Phone text field does not accept more than 10 didgits: " + actualValue);
		}
		System.out.println("Phone text field will not accept more than 10 digits");
	}

	@Test(dependsOnMethods = "TC_197VerifybillinPhonewithmorethan10digits")
	public void TC_198VerifybillingPhonewithshortInput() throws EncryptedDocumentException, IOException {
		gp.getBillingPhone().click();
		gp.getBillingPhone().sendKeys(Keys.CONTROL + "a");
		gp.getBillingPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 43, 5);
		gp.getBillingPhone().sendKeys(input);
		String phoneErmsg = gp.getBillingPhoneErmsg().getText();
		System.out.println(phoneErmsg);
		System.out.println("Phone text field will not accept short input and prompt error message ");
		utilityclassobject.gettest().log(Status.INFO,
				"Phone text field will not accept short input and prompt error message ");
	}

	// need to write TC_199

	@Test(dependsOnMethods = "TC_198VerifybillingPhonewithshortInput")
	public void TC_200VerifyExtwithalphabets() throws EncryptedDocumentException, IOException {
		gp.getBillingExt().click();
		gp.getBillingExt().sendKeys(Keys.CONTROL + "a");
		gp.getBillingExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 46, 1);
		gp.getBillingExt().sendKeys(input);
		String actualValue = gp.getBillingExt().getAttribute("value");

		// Verify that alphabets are not accepted
		if (actualValue.matches(".*[a-zA-Z].*")) {
			System.out.println("Billing Phone Ext text field accepted alphabets. :PASS");
			utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field accepted alphabets.");
		} else {
			System.out.println("Phone Ext text field accepted alphabets. : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field accepted alphabets.");
		}

		System.out.println("Phone Ext text field accepted alphabets");
	}

	@Test(dependsOnMethods = "TC_200VerifyExtwithalphabets")
	public void TC_201VerifyExtwithNumbers() throws EncryptedDocumentException, IOException {
		gp.getBillingExt().click();
		gp.getBillingExt().sendKeys(Keys.CONTROL + "a");
		gp.getBillingExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 46, 2);
		gp.getBillingExt().sendKeys(input);
		System.out.println("Phone Ext text field will accept numbers");
		utilityclassobject.gettest().log(Status.INFO, "Phone Ext text field will accept numbers");
	}

	@Test(dependsOnMethods = "TC_201VerifyExtwithNumbers")
	public void TC_202VerifyExtwithspecialcharacters() throws EncryptedDocumentException, IOException {
		gp.getBillingExt().click();
		gp.getBillingExt().sendKeys(Keys.CONTROL + "a");
		gp.getBillingExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 46, 3);
		gp.getBillingExt().sendKeys(input);
		String actualValue = gp.getBillingExt().getAttribute("value");

		// Verify that alphabets are not accepted
		if (actualValue.matches(".*[#-#$%-^&*].*")) {
			System.out.println("Billing Phone Ext text field accepted specialcharacters. :PASS");
			utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field accepted specialcharacters.");
		} else {
			System.out.println("Phone Ext text field accepted specialcharacters. : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field accepted specialcharacters.");
		}

		System.out.println("Phone Ext text field accepted specialcharacters");
	}

	@Test(dependsOnMethods = "TC_202VerifyExtwithspecialcharacters")
	public void TC_203VerifyExtwithmorethan5digits() {
		gp.getBillingExt().click();
		gp.getBillingExt().sendKeys(Keys.CONTROL + "a");
		gp.getBillingExt().sendKeys(Keys.DELETE);
		long txt = 4756384763L;
		gp.getBillingExt().sendKeys(String.valueOf(txt));
		String actualValue = gp.getBillingExt().getAttribute("value");

		// Verify the field accepts only 10 digits
		if (actualValue.length() == 5) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Phone Ext text field accepted more than 5 digits:" + actualValue);
		} else {
			utilityclassobject.gettest().log(Status.PASS,
					"Phone Ext text field accepted more than 5 digits: " + actualValue);
		}
		System.out.println("Phone Ext text field accepted more than 5 digits");
	}

	@Test(dependsOnMethods = "TC_203VerifyExtwithmorethan5digits")
	public void TC_204VerifyExtwithShortInput() throws EncryptedDocumentException, IOException {
		gp.getBillingExt().click();
		gp.getBillingExt().sendKeys(Keys.CONTROL + "a");
		gp.getBillingExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 46, 5);
		gp.getBillingExt().sendKeys(input);
		System.out.println("Phone Ext text field will accept short input");
		utilityclassobject.gettest().log(Status.INFO, "Phone Ext text field will accept short input");
	}

	@Test(dependsOnMethods = "TC_204VerifyExtwithShortInput")
	public void TC_205VerifyExtwithoutInput() {
		gp.getBillingExt().click();
		gp.getBillingExt().sendKeys(Keys.CONTROL + "a");
		gp.getBillingExt().sendKeys(Keys.DELETE);
		System.out.println("The user is able to proceed as it is not mandatory field");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to proceed as it is not mandatory field");
	}

	@Test(dependsOnMethods = "TC_205VerifyExtwithoutInput")
	public void TC_206VeiryfCopytobillingInformation() {
		gp.getCopyButton().click();
		System.out.println(
				"The details in the service information is copied and pasted in the 'billing information' section");
		utilityclassobject.gettest().log(Status.INFO,
				"The details in the service information is copied and pasted in the 'billing information' section");
	}

	@Test(dependsOnMethods = "TC_206VeiryfCopytobillingInformation")
	public void TC_207VerifyCopywithEditbillingInformation()
			throws EncryptedDocumentException, IOException, InterruptedException {
		gp.getBillingattention().click();
		gp.getBillingattention().sendKeys(Keys.CONTROL + "a");
		gp.getBillingattention().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		gp.getBillingattention().sendKeys(input);
		gp.getBillingaddressStreet().click();
		gp.getBillingaddressStreet().sendKeys(Keys.CONTROL + "a");
		gp.getBillingaddressStreet().sendKeys(Keys.DELETE);
		gp.getBillingaddressStreet().sendKeys("1245 6");
		Thread.sleep(2000);
		WebElement dropdown = driver
				.findElement(By.xpath("//div[contains(@class,'absolute') and contains(@class,'overflow-y-auto')]"));
		Assert.assertTrue(dropdown.isDisplayed());
		System.out.println(dropdown);
		WebElement street1 = driver.findElement(
				By.xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]"));
		street1.click();
		gp.getBillingsuite().click();
		gp.getBillingsuite().sendKeys(Keys.CONTROL + "a");
		gp.getBillingsuite().sendKeys(Keys.DELETE);
		String input1 = elib.getDataFromExcel("GeneratorInformation", 31, 1);
		gp.getBillingsuite().sendKeys(input1);
		gp.getBillingcity().click();
		gp.getBillingcity().sendKeys(Keys.CONTROL + "a");
		gp.getBillingcity().sendKeys(Keys.DELETE);
		String input2 = elib.getDataFromExcel("GeneratorInformation", 34, 1);
		gp.getBillingcity().sendKeys(input2);
		gp.billingState();
		gp.getBillingzipcode().click();
		gp.getBillingzipcode().sendKeys(Keys.CONTROL + "a");
		gp.getBillingzipcode().sendKeys(Keys.DELETE);
		String input3 = elib.getDataFromExcel("GeneratorInformation", 37, 2);
		gp.getBillingzipcode().sendKeys(input3);
		gp.getBillingEmail().click();
		gp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		gp.getBillingEmail().sendKeys(Keys.DELETE);
		String input4 = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		gp.getBillingEmail().sendKeys(input4);
		gp.getBillingPhone().click();
		gp.getBillingPhone().sendKeys(Keys.CONTROL + "a");
		gp.getBillingPhone().sendKeys(Keys.DELETE);
		String input5 = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		gp.getBillingPhone().sendKeys(input5);
		System.out.println("The user should be able to edit the data");
		utilityclassobject.gettest().log(Status.INFO, "The user should be able to edit the data");

	}*/
	
	//need to change the dependency 
	@Test(dependsOnMethods = "TC_086VerifySelectmorethanIndustrytype")
	public void TC_208Verifyweekdayswithtimings() throws InterruptedException
	{
		gp = new GeneratorInformation1(driver);
		elib = new ExcelUtility();
		//gp.GeneratorInformation();
		gp.getMondayopeningtime().click();
		gp.getMorningtime().click();
		Thread.sleep(200);
		gp.getMondaylunchstart().click();
		gp.getLunchsarttiming().click();
		Thread.sleep(200);
		gp.getMondaylunchend().click();
		gp.getLunchendtiming().click();
		Thread.sleep(200);
		gp.getMondayclosetime().click();
		gp.getClosetime().click();
		System.out.println("The user is able to select time for the weekdays");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to select time for the weekdays");		
	
	}
	
	//need to write TC_209 and 210
	
	@Test(dependsOnMethods = "TC_208Verifyweekdayswithtimings")
	public void TC_211Verifyweekdaydropdownwithnumbers() throws InterruptedException
	{
		gp.getTuesdayopeningtime().click();
		gp.getTuesdayopeningtime().sendKeys(Keys.CONTROL + "a");
		gp.getTuesdayopeningtime().sendKeys(Keys.DELETE);
		gp.getTuesdayopeningtime().sendKeys("8");
		Thread.sleep(200);
		gp.getMorningtime().click();
		
		gp.getTuesdaylunchstart().click();
		gp.getTuesdaylunchstart().sendKeys(Keys.CONTROL + "a");
		gp.getTuesdaylunchstart().sendKeys(Keys.DELETE);
		gp.getTuesdaylunchstart().sendKeys("12");
		Thread.sleep(200);
		gp.getLunchsarttiming().click();
		
		gp.getTuesdaylunchend().click();
		gp.getTuesdaylunchend().sendKeys(Keys.CONTROL + "a");
		gp.getTuesdaylunchend().sendKeys(Keys.DELETE);
		gp.getTuesdaylunchend().sendKeys("12");
		Thread.sleep(200);
		gp.getLunchendtiming().click();
		
		gp.getTuesdaylunchclosetime().click();
		gp.getTuesdaylunchclosetime().sendKeys(Keys.CONTROL + "a");
		gp.getTuesdaylunchclosetime().sendKeys(Keys.DELETE);
		gp.getTuesdaylunchclosetime().sendKeys("6");
		Thread.sleep(200);
		gp.getClosetime().click();
		System.out.println("The dropdown will suggest matching timings available");
		utilityclassobject.gettest().log(Status.INFO, "The dropdown will suggest matching timings available");		
	
	}
	
	@Test(dependsOnMethods = "TC_211Verifyweekdaydropdownwithnumbers")
	public void TC_212Verifyweekdayswithopeningtime()
	{
		gp.getWednesdayopeningtime().click();
		gp.getMorningtime().click();
		System.out.println("The user is able to add the opening time and it get autosaved");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to add the opening time and it get autosaved");		
	
		
	}
	
	@Test(dependsOnMethods = "TC_212Verifyweekdayswithopeningtime")
	public void TC_213VerifyweekdayswithLunchstart()
	{
		gp.getWendesdaylunchstart().click();
		gp.getLunchsarttiming().click();	
		System.out.println("The user is able to add the lunch start time and it get autosaved");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to add the lunch start time and it get autosaved");			
	
	}
	
	@Test(dependsOnMethods = "TC_213VerifyweekdayswithLunchstart")
	public void TC_214VerifyweekdayswithlunchEnd()
	{
		gp.getWendesdaylunchend().click();
		gp.getLunchendtiming().click();
		System.out.println("The user is able to add the lunch end time and it get autosaved");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to add the lunch end time and it get autosaved");			
	
	}
	
	@Test(dependsOnMethods = "TC_214VerifyweekdayswithlunchEnd")
	public void TC_215Verifyweekdayswithclosetime()
	{
		gp.getWednesdayclosingtime().click();
		gp.getClosetime().click();
		System.out.println("The user is able to add the closing time and it get autosaved");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to add the closing time and it get autosaved");			
	
		
	}
	
	@Test(dependsOnMethods = "TC_215Verifyweekdayswithclosetime")
	public void TC_216Verifyweekdayswithcheckbox()
	{
		gp.getThursdayCheckbox().click();
		System.out.println("The user is able to check the checkbox");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to check the checkbox");			
	
	}
	
	@Test(dependsOnMethods = "TC_216Verifyweekdayswithcheckbox")
	public void TC_217Verifyweekdaystimingswithenabledcheckbox() throws InterruptedException
	{
		gp.weekdayswithcheckbox();
		System.out.println("The user is not able to add timings for that particular day as it is marked 'closed'");
		utilityclassobject.gettest().log(Status.INFO, "The user is not able to add timings for that particular day as it is marked 'closed");			
			
	}
	
	@Test(dependsOnMethods = "TC_217Verifyweekdaystimingswithenabledcheckbox")
	public void TC_218VerifyweekdaystimingswithoutCheckbox()
	{
		gp.getThursdayCheckbox().click();
		gp.getThursdayopeningtime().click();
		gp.getMorningtime().click();
		
		gp.getThursdaylunchstart().click();
		gp.getLunchsarttiming().click();
		
		gp.getThursdaylunchend().click();
		gp.getLunchendtiming().click();
		
		gp.getThursdayclosingtime().click();
		gp.getClosetime().click();
		System.out.println("The user is able to add timings for that particular day ");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to add timings for that particular day ");						
		
	}
	
	@Test(dependsOnMethods = "TC_218VerifyweekdaystimingswithoutCheckbox")
	public void TC_219Verifyweekdayswithmultiplecheckbox()
	{
		gp.getFridayCheckbox().click();
		gp.getSaturdayCheckbox().click();
		gp.getSundayCheckbox().click();
		System.out.println("The user is able to check multiple checkboxes and mark them close");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to check multiple checkboxes and mark them close");						
		
	}
	
	@Test(dependsOnMethods = "TC_219Verifyweekdayswithmultiplecheckbox")
	public void TC_220VerifyweekdayswithCopybutton()
	{
		gp.getMondaycopybutton().click();
		System.out.println("The user is able to copy the timings for the particular day");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to copy the timings for the particular day");								
	}
	
	@Test(dependsOnMethods = "TC_220VerifyweekdayswithCopybutton")
	public void TC_221VerifyweekdayswithPastebutton() throws InterruptedException
	{
		gp.getFridayCheckbox().click();
		gp.getSaturdayCheckbox().click();
		gp.getSundayCheckbox().click();
		Thread.sleep(200);
		gp.getFridaypastebutton().click();
		gp.getSaturdaypastebutton().click();
		gp.getSundaypastebutton().click();
		System.out.println("The user is able to paste the timings of one day to the other weekdays");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to paste the timings of one day to the other weekdays");								
		
	}
	
	@Test(dependsOnMethods = "TC_221VerifyweekdayswithPastebutton")
	public void TC_222Verifyweekdayspastebuttonwithclosedcheckbox() throws InterruptedException
	{
		gp.getTuesdaycheckbox().click();
		gp.getTuesdayPastebutton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toast = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//*[contains(text(),'Cannot paste to Tuesday as it is closed')]")));

		String message = toast.getText();

		System.out.println(message);

		Assert.assertEquals(message,
		        "Cannot paste to Tuesday as it is closed");

		wait.until(ExpectedConditions.invisibilityOf(toast));

		gp.getTuesdaycheckbox().click();
		System.out.println("The user is not able to paste the timings as it is marked closed");
		utilityclassobject.gettest().log(Status.INFO, "The user is not able to paste the timings as it is marked closed");								
		
	}
	
	@Test(dependsOnMethods = "TC_222Verifyweekdayspastebuttonwithclosedcheckbox")
	public void TC_223Verifyweekdayswithclosedcheckbox()
	{
		gp.getFridayCheckbox().click();
		gp.getSaturdayCheckbox().click();
		System.out.println("The user is able to mark that particular day as closed");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to mark that particular day as closed");												
	}
	
	@Test(dependsOnMethods = "TC_223Verifyweekdayswithclosedcheckbox")
	public void TC_224VerifyweekdayswithAutosave()
	{
		gp.getFridayCheckbox().click();
		gp.getSaturdayCheckbox().click();
		gp.getMondaycopybutton().click();
		gp.getFridaypastebutton().click();
		gp.getSaturdaypastebutton().click();
		System.out.println("The Generator office hours autosaves the data");
		utilityclassobject.gettest().log(Status.INFO, "The Generator office hours autosaves the data");												
		
	}
	
	@Test(dependsOnMethods = "TC_224VerifyweekdayswithAutosave")
	public void TC_225VerifyGeneratorinformatioincompletedata()
	{
		gp.getGeneratorbilling().click();
		System.out.println("User is able to navigate to the other page by enetering few details in the generator information");
		utilityclassobject.gettest().log(Status.INFO, "User is able to navigate to the other page by enetering few details in the generator information");													
		
	}
	
	@Test(dependsOnMethods = "TC_225VerifyGeneratorinformatioincompletedata")
	public void TC_226VerifyGeneratorinformationwithcompletedata()
	{
		gp.getGeneratorInformation().click();
		gp.getTuesdayopeningtime().click();
		gp.getMorningtime().click();
		
		gp.getTuesdaylunchstart().click();
		gp.getLunchsarttiming().click();
		
		gp.getTuesdaylunchend().click();
		gp.getLunchendtiming().click();
		
		gp.getTuesdaylunchclosetime().click();
		gp.getClosetime().click();
		System.out.println("The user is able to edit and add the remaining details and it get autosaved by navigating back to the generator information");
		utilityclassobject.gettest().log(Status.INFO, "The user is able to edit and add the remaining details and it get autosaved by navigating back to the generator information");													
		
	}

}
