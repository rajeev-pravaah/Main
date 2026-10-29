package Octopussaas_GeneratorInformation;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.GeneratorInformation1;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class UpdateAdrress  extends BaseClassForGEneratorContacts{
	GeneratorInformation1 gp;
	ExcelUtility elib ;
	
	
	@Test(priority = 1)
	public void TC_227VerifyUpdateAddress() throws EncryptedDocumentException, IOException, InterruptedException
	{
		 gp = new GeneratorInformation1(driver);
		 elib = new ExcelUtility();  
		 gp.GeneratorInformation();
		 gp.scrollToElement(gp.getUpdateAddressButton());
		 gp.getUpdateAddressButton().click();
		 gp.getUpdateaddressModal().isDisplayed();
		 System.out.println("Update Address modal is displayed with all the fields");
		 utilityclassobject.gettest().log(Status.PASS, "Update Address modal is displayed with all the fields");
		 
	}
	
	@Test(dependsOnMethods = "TC_227VerifyUpdateAddress")
	public void TC_228VerifyAttentionfieldwithInput() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept Input");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept Input");
	}
	
	@Test(dependsOnMethods = "TC_228VerifyAttentionfieldwithInput")
	public void TC_229VerifyAttentionwithAlphbets() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept alphabets");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_229VerifyAttentionwithAlphbets")
	public void TC_230VerifyAttentionwithNumbers() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 2);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept numbers");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_230VerifyAttentionwithNumbers")
	public void TC_231VerifyAttentionwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 3);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept specialcharacters");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept specialcharacters");
		
	}
	
	@Test(dependsOnMethods = "TC_231VerifyAttentionwithSpecialcharacters")
	public void TC_232VerifyAttentionwithoutInput()
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  System.out.println("uesr is able to proceed furhter without filling the Attention field as its not mandatory field");
		  utilityclassobject.gettest().log(Status.INFO,"uesr is able to proceed furhter without filling the Attention field as its not mandatory field");
		
	}
	
	
	@Test(dependsOnMethods = "TC_232VerifyAttentionwithoutInput")
	public void TC_233VerifyStreetwithInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 1);
		gp.getUpdateStreetfield().sendKeys(input); 
		System.out.println("Street text filed will accept Input");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept Input");
	}
	
	@Test(dependsOnMethods = "TC_233VerifyStreetwithInput")
	public void TC_234VerifyStreetwithAlphabets() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 1);
		gp.getUpdateStreetfield().sendKeys(input); 
		System.out.println("Street text filed will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_234VerifyStreetwithAlphabets")
	public void TC_235VerifyStreetwithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 2);
		gp.getUpdateStreetfield().sendKeys(input); 
		System.out.println("Street text filed will accept numbers");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_235VerifyStreetwithNumbers")
	public void TC_236VerifyStreetwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 3);
		gp.getUpdateStreetfield().sendKeys(input); 
		System.out.println("Street text filed will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept specialcharacters");
	}
	
	/*@Test
	public void TC_011VerifyStreetwithoutInput()
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
	
		System.out.println("Street text filed will accept specialcharacters");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept specialcharacters");
	}*/
	
	@Test(dependsOnMethods = "TC_236VerifyStreetwithSpecialcharacters")
	public void TC_238VerifyStreetwithAddresssuggestion() throws InterruptedException
	{
		 gp.getUpdateStreetfield().click(); 
		 gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		 gp.getUpdateStreetfield().sendKeys("1245 6");
		 Thread.sleep(2000); 
		 WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class,'absolute') and contains(@class,'overflow-y-auto')]")); 
		 Assert.assertTrue(dropdown.isDisplayed()); 
		 System.out.println(dropdown);
		 utilityclassobject.gettest().log(Status.INFO,"The street field will show related suggestions");
	}
	
	@Test(dependsOnMethods = "TC_238VerifyStreetwithAddresssuggestion")
	public void TC_239VerifyStreetwithAutofills() throws InterruptedException
	{
		WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]")); 
		street1.click(); 
		Thread.sleep(2000); 
		String city = gp.getUpdateCityfiled().getAttribute("value"); 
		System.out.println("City: " + city); 
		String state = gp.getUpdateStatefiled().getAttribute("value");
		System.out.println("State: " + state); 
		String zipcode = gp.getUpdateZipcodefield().getAttribute("value"); 
		System.out.println("Zip Code: " + zipcode); 
		System.out.println("The city, state and zip code will get autofilled");
		utilityclassobject.gettest().log(Status.INFO,"The city, state and zip code will get autofilled");
	}
	
	@Test(dependsOnMethods = "TC_239VerifyStreetwithAutofills")
	public void TC_240VerifySuitewithInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 1);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts Input");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_240VerifySuitewithInput")
	public void TC_241VerifySuitewithalphabets() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 1);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts alphabets");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_241VerifySuitewithalphabets")
	public void TC_242VerifySuitewithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 2);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts Numbers");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts Numbers");
	}
	
	@Test(dependsOnMethods = "TC_242VerifySuitewithNumbers")
	public void TC_243VerifySuitewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 3);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts specialcharacters");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_243VerifySuitewithspecialcharacters")
	public void TC_245VerifyCitywithInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 1);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts input");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts input");
	}
	
	@Test(dependsOnMethods = "TC_245VerifyCitywithInput")
	public void TC_246VerifyCitywithalphabets() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 1);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts alphabets");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_246VerifyCitywithalphabets")
	public void TC_247VeriyfCitywithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 2);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts numbers");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts numbers");
	}
	
	@Test(dependsOnMethods = "TC_247VeriyfCitywithNumbers")
	
	public void TC_248VerifyCitywithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 3);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts specialcharacters");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_248VerifyCitywithspecialcharacters")
	public void TC_250VerifytheStatefield()
	{
		WebElement suite = gp.getUpdateStatefiled();
		suite.isDisplayed();
		System.out.println("Suite field is present");
		utilityclassobject.gettest().log(Status.INFO,"Suite field is present");
		
	}
	
	@Test(dependsOnMethods = "TC_250VerifytheStatefield")
	public void TC_251VerifyStatewithInput()
	{
		gp.getUpdateStatefiled().click();
		gp.getUpdateStatefiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateStatefiled().sendKeys(Keys.DELETE); 
		gp.getUpdateStatefiled().sendKeys("Sfshj");
		System.out.println("Suite field is present");
		utilityclassobject.gettest().log(Status.INFO,"Suite field is present");		
	}
	
	@Test(dependsOnMethods = "TC_251VerifyStatewithInput")
	public void TC_252VerifyStatewithOptions()
	{
		gp.getUpdateStatefiled().click();
		gp.getUpdateStatefiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateStatefiled().sendKeys(Keys.DELETE); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		gp.getUpdateStatefiled().click();
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));
		Assert.assertTrue(dropdown.isDisplayed(), "state dropdown is displayed");
		 String[] types = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL",
		 "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI",
		 "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
		 "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
		  Actions actions = new Actions(driver);
		  for (String type : types) {
				  
				  WebElement typeElement = wait.until(
				  ExpectedConditions.presenceOfElementLocated(
				  By.xpath("//li[@role='option']//span[contains (text(),'"+type+"')]")));
				  
				  actions.moveToElement(typeElement).perform();
				  
				  Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
				  utilityclassobject.gettest().log(Status.INFO,"State options are present in the dropdown");
				  
				  }
	}
	
	@Test(dependsOnMethods = "TC_252VerifyStatewithOptions")
	public void TC_253VerifyStatewithselectedoption() throws InterruptedException
	{
		gp.UpdateState();
		System.out.println("User is able to select the options from the dropdown");
		utilityclassobject.gettest().log(Status.INFO,"User is able to select the options from the dropdown");
		
	}
	
	
	@Test(dependsOnMethods = "TC_253VerifyStatewithselectedoption")
	public void TC_255VerifyZipcodewithInput() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateZipcodefield().click();
		  gp.getUpdateZipcodefield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateZipcodefield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 37, 1);
		  gp.getUpdateZipcodefield().sendKeys(input);
		  System.out.println("zipcode text filed will accepts Input");
		  utilityclassobject.gettest().log(Status.INFO,"zipcode text filed will accepts input");
	}
	
	@Test(dependsOnMethods = "TC_255VerifyZipcodewithInput")
	public void TC_256VerifyZipcodewithalphabets() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateZipcodefield().click();
		  gp.getUpdateZipcodefield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateZipcodefield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 37, 1);
		  gp.getUpdateZipcodefield().sendKeys(input);
		  System.out.println("zipcode text filed will accepts alphabets");
		  utilityclassobject.gettest().log(Status.INFO,"zipcode text filed will accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_256VerifyZipcodewithalphabets")
	public void TC_257VerifyZipcodewithNumbers() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateZipcodefield().click();
		  gp.getUpdateZipcodefield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateZipcodefield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 37, 2);
		  gp.getUpdateZipcodefield().sendKeys(input);
		  System.out.println("zipcode text filed will accepts numbers");
		  utilityclassobject.gettest().log(Status.INFO,"zipcode text filed will accepts numbers");

	}
	
	@Test(dependsOnMethods = "TC_257VerifyZipcodewithNumbers")
	public void TC_258VerifyZipcodewithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateZipcodefield().click();
		  gp.getUpdateZipcodefield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateZipcodefield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 37, 3);
		  gp.getUpdateZipcodefield().sendKeys(input);
		  System.out.println("zipcode text filed will accepts specialcharacters");
		  utilityclassobject.gettest().log(Status.INFO,"zipcode text filed will accepts specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_258VerifyZipcodewithSpecialcharacters")
	public void TC_260VerifyEmailwithInput() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 40, 1);
		  gp.getUpdateEmailaddress().sendKeys(input);
		  System.out.println("Email text filed will accepts input");
		  utilityclassobject.gettest().log(Status.INFO,"Email text filed will accepts input");
	}
	
	@Test(dependsOnMethods = "TC_260VerifyEmailwithInput")
	public void TC_261VerifyEmailwithAlphabets() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 40, 1);
		  gp.getUpdateEmailaddress().sendKeys(input);
		  System.out.println("Email text filed will accepts alphabets");
		  utilityclassobject.gettest().log(Status.INFO,"Email text filed will accepts alphabets");	
	}
	
	@Test(dependsOnMethods = "TC_261VerifyEmailwithAlphabets")
	public void TC_262VerifyEmailwithNumbers() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 40, 2);
		  gp.getUpdateEmailaddress().sendKeys(input);
		  System.out.println("Email text filed will accepts numbers");
		  utilityclassobject.gettest().log(Status.INFO,"Email text filed will accepts numbers");	
	}
	
	@Test(dependsOnMethods = "TC_262VerifyEmailwithNumbers")
	public void TC_263VerifyEmailwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 40, 3);
		  gp.getUpdateEmailaddress().sendKeys(input);
		  System.out.println("Email text filed will accepts specialcharacters");
		  utilityclassobject.gettest().log(Status.INFO,"Email text filed will accepts specialcharacters");	
	}
	
	//need to write TC_038
	
	@Test(dependsOnMethods = "TC_263VerifyEmailwithSpecialcharacters")
	public void TC_265VerifyEmailwithValidInput() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		  gp.getUpdateEmailaddress().sendKeys(input);
		  System.out.println("Email text filed will accepts valid email");
		  utilityclassobject.gettest().log(Status.INFO,"Email text filed will accepts valid email");	
		
	}
	
	//need to write TC_040
	
	@Test(dependsOnMethods = "TC_265VerifyEmailwithValidInput")
	public void TC_267erifyPhonewithInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdatePhonetextfield().click(); 
		gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		gp.getUpdatePhonetextfield().sendKeys(input);
		System.out.println("Phone text filed will accepts input");
		utilityclassobject.gettest().log(Status.INFO,"Phone text filed will accepts input");
	}
	
	@Test(dependsOnMethods = "TC_267erifyPhonewithInput")
	public void TC_268VerifyPhonewithAlphabets() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdatePhonetextfield().click();
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 43, 1);
		  gp.getUpdatePhonetextfield().sendKeys(input); 
		  String actualValue = gp.getUpdatePhonetextfield().getAttribute("value");
		  
		  // Verify that alphabets are not accepted 
		  if(actualValue.matches(".*[a-zA-Z].*"))
		  { 
		   System.out. println("Generator Main Phone text field accepted alphabets. :PASS");
		  utilityclassobject.gettest().log(Status.FAIL, "Phone text field accepted alphabets."); 
		  }
		  else {
		  System.out.println("Phone text field does not accept alphabets. : PASS");
		  utilityclassobject.gettest().log(Status.PASS,"Phone text field does not accept alphabets.");
		  }  
		  System.out.println("Phone text field will not accept alphabets");
		  utilityclassobject.gettest().log(Status.INFO,"Phone text field will not accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_268VerifyPhonewithAlphabets")
	public void TC_269VerifyPhonewithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getUpdatePhonetextfield().click(); 
		gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		gp.getUpdatePhonetextfield().sendKeys(input);
		System.out.println("Phone text filed will accepts numbers");
		utilityclassobject.gettest().log(Status.INFO,"Phone text filed will accepts numbers");
		
	}
	
	@Test(dependsOnMethods = "TC_269VerifyPhonewithNumbers")
	public void TC_270VerifyPhonewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdatePhonetextfield().click();
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 43, 3);
		  gp.getUpdatePhonetextfield().sendKeys(input); 
		  String actualValue = gp.getUpdatePhonetextfield().getAttribute("value");
		  
		  // Verify that alphabets are not accepted 
		  if(actualValue.matches(".*[#$^&].*")) 
		  {
		  System.out.println("Phone text field accepted specialcharacters. :PASS");
		  utilityclassobject.gettest().log(Status.FAIL, "Phone text field accepted alphabets."); 
		  } 
		  else { 
		 System.out.println("Phone text field does not accept specialcharacters. : PASS");
		  utilityclassobject.gettest().log(Status.PASS, "Phone text field does not accept specialcharacters."); 
		  }
		  System.out.println("Phone text field does not accept specialcharacters.");
		  utilityclassobject.gettest().log(Status.INFO,"Phone text field does not accept specialcharacters");

	}
	
	@Test(dependsOnMethods = "TC_270VerifyPhonewithspecialcharacters")
	public void TC_271VerifyPhonewithMorethan10digits()
	{
		  gp.getUpdatePhonetextfield().click();
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); long txt = 475638476587346783L;
		  gp.getUpdatePhonetextfield().sendKeys(String.valueOf(txt));
		  String actualValue = gp.getUpdatePhonetextfield().getAttribute("value");
		  
		  // Verify the field accepts only 10 digits 
		  if (actualValue.length() == 10) 
		  {
		  utilityclassobject.gettest().log(Status.FAIL, "Phone text field accepted more than 10 digits:"+ actualValue); 
		  } 
		  else {
		  utilityclassobject.gettest().log(Status.PASS,"Phone text field does not accept more than 10 didgits: " + actualValue); 
		  }
		  System.out.println("Phone text field will not accept more than 10 digits");
		  utilityclassobject.gettest().log(Status.INFO,"Phone text field will not accept more than 10 digits");

	}
	
	//need to write TC_046 and TC_047
	
	@Test(dependsOnMethods = "TC_271VerifyPhonewithMorethan10digits")
	public void TC_274VerifyExtwithInput() throws EncryptedDocumentException, IOException
	{
		 gp.getUpdateExtfield().click(); 
		 gp.getUpdateExtfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateExtfield().sendKeys(Keys.DELETE); 
		 String input = elib.getDataFromExcel("GeneratorInformation", 46, 2 );
		 gp.getUpdateExtfield().sendKeys(input);
		 System.out.println("Ext text field will accepts Input");
		 utilityclassobject.gettest().log(Status.INFO, "Ext text field will accepts Input");
	}
	
	@Test(dependsOnMethods = "TC_274VerifyExtwithInput")
	public void TC_275VerifyExtwithAlphabets() throws EncryptedDocumentException, IOException
	{
		 gp.getUpdateExtfield().click(); 
		 gp.getUpdateExtfield().sendKeys(Keys.CONTROL + "a");
	     gp.getUpdateExtfield().sendKeys(Keys.DELETE); 
	     String input = elib.getDataFromExcel("GeneratorInformation", 46, 1);
	     gp.getUpdateExtfield().sendKeys(input); 
	     String actualValue = gp.getUpdateExtfield().getAttribute("value");
	     // Verify that alphabets are not accepted 
	     if(actualValue.matches(".*[a-zA-Z].*")) 
	    {
	     System.out.println("Ext text field accepted alphabets. :PASS");
	     utilityclassobject.gettest().log(Status.FAIL,  "Ext text field accepted alphabets."); 
	     } 
	     else {
	    System.out.println("Ext text field does not accept alphabets. : PASS");
	    utilityclassobject.gettest().log(Status.PASS, "Ext text field does not accept alphabets.");
	    }
	    System.out.println("Ext text field will not accept alphabets");	 
	 
	 }
	
	@Test(dependsOnMethods = "TC_275VerifyExtwithAlphabets")
	public void TC_276VerifyExtwithNumbers() throws EncryptedDocumentException, IOException
	{
		 gp.getUpdateExtfield().click(); 
		 gp.getUpdateExtfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateExtfield().sendKeys(Keys.DELETE); 
		 String input = elib.getDataFromExcel("GeneratorInformation", 46, 2);
		 gp.getUpdateExtfield().sendKeys(input);
		 System.out.println("Ext text field will accepts Input");
		 utilityclassobject.gettest().log(Status.INFO, "Ext text field will accepts Input");
	}
	
	@Test(dependsOnMethods = "TC_276VerifyExtwithNumbers")
	public void TC_277VerifyExtwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		 gp.getUpdateExtfield().click(); 
		 gp.getUpdateExtfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateExtfield().sendKeys(Keys.DELETE); 
		 String input = elib.getDataFromExcel("GeneratorInformation", 46, 3);
		 gp.getUpdateExtfield().sendKeys(input);
		  
		  String actualValue = gp.getUpdateExtfield().getAttribute("value");
		  
		  // Verify that alphabets are not accepted 
		  if(actualValue.matches(".*[#$^&].*")) 
		  {
		  System.out.println("Ext text field accepted specialcharacters. :PASS");
		  utilityclassobject.gettest().log(Status.FAIL, "Ext text field accepted alphabets."); 
		  } 
		  else {
		  System.out.println("Ext text field does not accept specialcharacters. : PASS"); 
		  utilityclassobject.gettest().log(Status.PASS,"Ext text field does not accept specialcharacters."); 
		  }
		  System.out.println("Ext text field does not accept specialcharacters.");
	}
	
	@Test(dependsOnMethods = "TC_277VerifyExtwithspecialcharacters")
	public void TC_278VerifyExtwithmorethan5digits() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateExtfield().click(); 
		gp.getUpdateExtfield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateExtfield().sendKeys(Keys.DELETE); 
	    String input = elib.getDataFromExcel("GeneratorInformation", 46, 4);
	    gp.getUpdateExtfield().sendKeys(String.valueOf(input)); 
	    String actualValue = gp.getUpdateExtfield().getAttribute("value");
		 // Verify the field accepts only 10 digits 33
		  if (actualValue.length() == 5)
		  {
		  utilityclassobject.gettest().log(Status.FAIL, "Ext text field accepted more than 5 digits:"+ actualValue); 
		  } 
		  else {
		  utilityclassobject.gettest().log(Status.PASS, "Ext text field does not accept more than 5 didgits: " + actualValue); 
		  }
		  System.out.println("Ext text field will not accept more than 5 digits");
	}
	
	@Test(dependsOnMethods = "TC_278VerifyExtwithmorethan5digits")
	public void TC_279VerifyEXtwithShortInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateExtfield().click(); 
		gp.getUpdateExtfield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateExtfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 46, 5);
		gp.getUpdateExtfield().sendKeys(input);
		System.out.println("Ext text field will accept short input");
		utilityclassobject.gettest().log(Status.INFO, "Ext text field will accept short input");
	}
	
	//need to write TC_054
		 //need to change the dependency
	
	@Test(dependsOnMethods = "TC_279VerifyEXtwithShortInput")
	public void TC_281VeifywithValidlatitude() throws InterruptedException
	{
		 gp.getUpdateStreetfield().click(); 
		 gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		 gp.getUpdateStreetfield().sendKeys("1245 6");
		 Thread.sleep(2000);
		 WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]")); 
		 street1.click(); 
		 Thread.sleep(2000);
		 String latitude = gp.getCordinates().getText();
		 System.out.println("latitudes: " + latitude);
		 System.out.println(latitude);
		 System.out.println("The latitude populate afeter entering valid address");
		 utilityclassobject.gettest().log(Status.INFO, "The latitude populate afeter entering valid address");
				 
	}
	
	@Test(dependsOnMethods = "TC_281VeifywithValidlatitude")
	public void TC_282VerifywithoutLatitude() throws InterruptedException
	{
		 gp.getUpdateStreetfield().click(); 
		 gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		 Thread.sleep(2000);
		 String latitude = gp.getUnabletoResolve().getText();
		 System.out.println("latitudes: " + latitude);
		 System.out.println(latitude);
		 System.out.println("The system populates to unable to resolve");
		 utilityclassobject.gettest().log(Status.INFO, "The system populates to unable to resolve");
				 
	}
	
	@Test(dependsOnMethods = "TC_282VerifywithoutLatitude")
	public void TC_283VerifywithLangitude() throws InterruptedException
	{
		 gp.getUpdateStreetfield().click(); 
		 gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		 gp.getUpdateStreetfield().sendKeys("1245 6");
		 Thread.sleep(2000);
		 WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]")); 
		 street1.click(); 
		 Thread.sleep(2000);
		 String langitude = gp.getCordinates().getText();
		 System.out.println("langitudes: " + langitude);
		 System.out.println(langitude);
		 System.out.println("The langitude populate afeter entering valid address");
		 utilityclassobject.gettest().log(Status.INFO, "The langitude populate afeter entering valid address");			 
	}
	
	@Test(dependsOnMethods = "TC_283VerifywithLangitude")
	public void TC_284VerifywithoutLangitude() throws InterruptedException
	{
		 gp.getUpdateStreetfield().click(); 
		 gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		 gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		 Thread.sleep(2000);
		 String latitude = gp.getUnabletoResolve().getText();
		 System.out.println("latitudes: " + latitude);
		 System.out.println(latitude);
		 System.out.println("The system populates to unable to resolve");
		 utilityclassobject.gettest().log(Status.INFO, "The system populates to unable to resolve");
	}
	
	@Test(dependsOnMethods = "TC_284VerifywithoutLangitude")
	public void TC_285VerifyEnableUpdateAddress() throws EncryptedDocumentException, IOException, InterruptedException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  
		  gp.getUpdateStreetfield().sendKeys("1245 6");
		  Thread.sleep(2000);
		  WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'1245 6th Street Southwest, Warren, Ohio 44485, United States')]")); 
		  street1.click();
		  
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input1 = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		  gp.getUpdateEmailaddress().sendKeys(input1);
		  
		  gp.getUpdatePhonetextfield().click(); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input2 = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		  gp.getUpdatePhonetextfield().sendKeys(input2);
		  
		  Thread.sleep(2000);
		  if (gp.getUpdateAddressmodalButton().isEnabled())
		  {
			  System.out.println("Update Address button is enabled after entering all the mandatory fields");
			  utilityclassobject.gettest().log(Status.INFO, "Update Address button is enabled after entering all the mandatory fields");
		  }
		  
		  else
		  {
			  System.out.println("Update Address button is disabled after entering all the mandatory fields");
			  utilityclassobject.gettest().log(Status.INFO, "Update Address button is disabled after entering all the mandatory fields");
		  }	  
		  
	}
	
	
	@Test(dependsOnMethods = "TC_285VerifyEnableUpdateAddress")
	public void TC_286VerifyDisabledUpdateAddress() throws InterruptedException
	{
		 gp.getUpdateAttentionfield().click();
		 gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
	     gp.getUpdateAttentionfield().sendKeys(Keys.DELETE);
	     
	     gp.getUpdateStreetfield().click();
		 gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
	     gp.getUpdateStreetfield().sendKeys(Keys.DELETE);
		
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  
		  gp.getUpdatePhonetextfield().click(); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  
		  gp.getUpdateAddressmodalButton().click();
		  System.out.println("User is not able to update the generator service information through update address wihout providing the mandatory fields ");
		  utilityclassobject.gettest().log(Status.INFO, "User is not able to update the generator service information through update address wihout providing the mandatory fields ");
		 
	}
	
	
	@Test(dependsOnMethods = "TC_286VerifyDisabledUpdateAddress")
	public void TC_287VerifyServiceinformationwithUpdateaddress() throws EncryptedDocumentException, IOException, InterruptedException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street1.click();
		  
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input1 = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		  gp.getUpdateEmailaddress().sendKeys(input1);
		  
		  gp.getUpdatePhonetextfield().click(); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input2 = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		  gp.getUpdatePhonetextfield().sendKeys(input2);
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street2 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street2.click();
		  
		  
		  gp.getUpdateAddressmodalButton().click();
		  gp.getSavenewAddressmodal().isDisplayed();
		  Thread.sleep(200);
		  gp.getSavenewAddressbutton().click();
		  System.out.println("The generator service information address is updated after updating the address in the Update Address modal.");
		  utilityclassobject.gettest().log(Status.INFO, "The generator service information address is updated after updating the address in the Update Address modal.");
		 
	}
		
	
	
	
	@Test(dependsOnMethods = "TC_287VerifyServiceinformationwithUpdateaddress")
	public void TC_288VerifywithupdateAddresswithSavenewaddressbutton() throws EncryptedDocumentException, IOException, InterruptedException
	{
		  gp.getUpdateAddressButton().click();
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street1.click();
		  
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input1 = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		  gp.getUpdateEmailaddress().sendKeys(input1);
		  
		  gp.getUpdatePhonetextfield().click(); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input2 = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		  gp.getUpdatePhonetextfield().sendKeys(input2);
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street2 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street2.click();
		  
		  gp.getUpdateAddressmodalButton().click();
		  gp.getSavenewAddressmodal().isDisplayed();
		  Thread.sleep(200);
		  gp.getSavenewAddressbutton().click();
		  System.out.println("The generator service information address is updated by clicking on the save new address button");
		  utilityclassobject.gettest().log(Status.INFO, "The generator service information address should be updated by clicking on the save new address button");
		 
	}
	
	@Test(dependsOnMethods = "TC_288VerifywithupdateAddresswithSavenewaddressbutton")
	public void TC_289VerifySaveaddresswithCancelbutton() throws EncryptedDocumentException, IOException, InterruptedException
	{
		 gp.getUpdateAddressButton().click();
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street1.click();
		  
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input1 = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		  gp.getUpdateEmailaddress().sendKeys(input1);
		  
		  gp.getUpdatePhonetextfield().click(); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input2 = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		  gp.getUpdatePhonetextfield().sendKeys(input2);
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street2 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street2.click();
		  
		  gp.getUpdateAddressmodalButton().click();
		  gp.getSavenewAddressmodal().isDisplayed();
		  Thread.sleep(200);
		  gp.getCancelButton1().click();
		  System.out.println("Save new address modal closes when the cancel button is clicked and changes are not saved");
		  utilityclassobject.gettest().log(Status.INFO, "Save new address modal closes when the cancel button is clicked and changes are not saved");
		 
	}
	

	@Test(dependsOnMethods = "TC_289VerifySaveaddresswithCancelbutton")
	public void TC_290VerifyupdateaddresswithCancelbutton() throws EncryptedDocumentException, IOException, InterruptedException
	{
		 gp.getUpdateAddressButton().click();
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street1.click();
		  
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input1 = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		  gp.getUpdateEmailaddress().sendKeys(input1);
		  
		  gp.getUpdatePhonetextfield().click(); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input2 = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		  gp.getUpdatePhonetextfield().sendKeys(input2);
		  gp.getUpdatecancelButton().click();
		  System.out.println("The Update Address modal is closed");
		  utilityclassobject.gettest().log(Status.INFO, "The Update Address modal is closed");

	}
	
	
	@Test(dependsOnMethods = "TC_290VerifyupdateaddresswithCancelbutton")
	public void TC_291VerifyUpdateAddresswithNochanges() throws EncryptedDocumentException, IOException, InterruptedException
	{
		  gp.getUpdateAddressButton().click();
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  
		  
		  gp.getUpdateStreetfield().click();
		  gp.getUpdateStreetfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		  gp.getUpdateStreetfield().sendKeys("3456 6");
		  Thread.sleep(2000);
		  WebElement street1 = driver.findElement(By.xpath("//div[contains (text(),'3456 6th Street Southwest, Canton, Ohio 44710, United States')]")); 
		  street1.click();
		  
		  gp.getUpdateEmailaddress().click();
		  gp.getUpdateEmailaddress().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateEmailaddress().sendKeys(Keys.DELETE); 
		  String input1 = elib.getDataFromExcel("GeneratorInformation", 40, 5);
		  gp.getUpdateEmailaddress().sendKeys(input1);
		  
		  gp.getUpdatePhonetextfield().click(); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.CONTROL +"a"); 
		  gp.getUpdatePhonetextfield().sendKeys(Keys.DELETE); 
		  String input2 = elib.getDataFromExcel("GeneratorInformation", 43, 2);
		  gp.getUpdatePhonetextfield().sendKeys(input2);
		  gp.getUpdatecancelButton().click();
		  System.out.println("The Update Address modal is closed and changes are nit saved");
		  utilityclassobject.gettest().log(Status.INFO, "The Update Address modal is closed and changes are not saved");
		
	}
	
	
	

}
