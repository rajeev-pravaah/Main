package Octopussaas_GeneratorInformation;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@Test
	public void TC_001VerifyUpdateAddress() throws EncryptedDocumentException, IOException, InterruptedException
	{
		 gp = new GeneratorInformation1(driver);
		 elib = new ExcelUtility();
		  /*gp.getAddnew().click(); 
		  Thread.sleep(200); 
		  gp.getGenerator().click();
		  Thread.sleep(200);
		  gp.getGeneratorName().click();
		  Random random = new Random(); 
		  int sixDigit = 100000 + random.nextInt(900000); 
		  String generatorInput = elib.getDataFromExcel("GeneratorInformation", 1, 1)+sixDigit;
		  gp.getGeneratorName().sendKeys(generatorInput);
		  System.out.println(generatorInput);
		  
		  gp.getAccountNumber().click(); 
		  gp.getAccountNumber().sendKeys("1235698");
		  Thread.sleep(200); 
		  gp.getAddnewGenerator().click(); 
		  Thread.sleep(20000);
		  WebElement generatorInformation = driver.findElement(By.xpath("//div[@class='h-full p-5']"));
		  Assert.assertTrue(generatorInformation.isDisplayed(), "Generator Information page is displayed");
		  System.out.println("The user is able to access the generator information page");
		  utilityclassobject.gettest().log(Status.INFO, "The user is able to access the generator information page"); */
		
		  
		 gp.GeneratorInformation();
		 gp.scrollToElement(gp.getUpdateAddressButton());
		 gp.getUpdateAddressButton().click();
		 gp.getUpdateaddressModal().isDisplayed();
		 System.out.println("Update Address modal is displayed with all the fields");
		 utilityclassobject.gettest().log(Status.PASS, "Update Address modal is displayed with all the fields");
		 
	}
	
	@Test(dependsOnMethods = "TC_001VerifyUpdateAddress")
	public void TC_002VerifyAttentionfieldwithInput() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept Input");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept Input");
	}
	
	@Test(dependsOnMethods = "TC_002VerifyAttentionfieldwithInput")
	public void TC_003VerifyAttentionwithAlphbets() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 1);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept alphabets");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_003VerifyAttentionwithAlphbets")
	public void TC_004VerifyAttentionwithNumbers() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 2);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept numbers");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_004VerifyAttentionwithNumbers")
	public void TC_005VerifyAttentionwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorInformation", 25, 3);
		  gp.getUpdateAttentionfield().sendKeys(input);
		  System.out.println("Attention text filed will accept specialcharacters");
		  utilityclassobject.gettest().log(Status.INFO,"Attention text filed will accept specialcharacters");
		
	}
	
	@Test(dependsOnMethods = "TC_005VerifyAttentionwithSpecialcharacters")
	public void TC_006VerifyAttentionwithoutInput()
	{
		  gp.getUpdateAttentionfield().click();
		  gp.getUpdateAttentionfield().sendKeys(Keys.CONTROL + "a");
		  gp.getUpdateAttentionfield().sendKeys(Keys.DELETE); 
		  System.out.println("uesr is able to proceed furhter without filling the Attention field as its not mandatory field");
		  utilityclassobject.gettest().log(Status.INFO,"uesr is able to proceed furhter without filling the Attention field as its not mandatory field");
		
	}
	
	
	@Test(dependsOnMethods = "TC_006VerifyAttentionwithoutInput")
	public void TC_007VerifyStreetwithInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 1);
		gp.getUpdateStreetfield().sendKeys(input); 
		System.out.println("Street text filed will accept Input");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept Input");
	}
	
	@Test(dependsOnMethods = "TC_007VerifyStreetwithInput")
	public void TC_008VerifyStreetwithAlphabets() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 1);
		gp.getUpdateStreetfield().sendKeys(input); 
		System.out.println("Street text filed will accept alphabets");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_008VerifyStreetwithAlphabets")
	public void TC_009VerifyStreetwithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateStreetfield().click();
		gp.getUpdateStreetfield().sendKeys(Keys.CONTROL +"a"); 
		gp.getUpdateStreetfield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 28, 2);
		gp.getUpdateStreetfield().sendKeys(input); 
		System.out.println("Street text filed will accept numbers");
		utilityclassobject.gettest().log(Status.INFO,"Street text filed will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_009VerifyStreetwithNumbers")
	public void TC_010VerifyStreetwithSpecialcharacters() throws EncryptedDocumentException, IOException
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
	
	@Test(dependsOnMethods = "TC_010VerifyStreetwithSpecialcharacters")
	public void TC_011VerifyStreetwithAddresssuggestion() throws InterruptedException
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
	
	@Test(dependsOnMethods = "TC_011VerifyStreetwithAddresssuggestion")
	public void TC_012VerifyStreetwithAutofills() throws InterruptedException
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
	
	@Test(dependsOnMethods = "TC_012VerifyStreetwithAutofills")
	public void TC_013VerifySuitewithInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 1);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts Input");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_013VerifySuitewithInput")
	public void TC_014VerifySuitewithalphabets() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 1);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts alphabets");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_014VerifySuitewithalphabets")
	public void TC_015VerifySuitewithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 2);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts Numbers");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts Numbers");
	}
	
	@Test(dependsOnMethods = "TC_015VerifySuitewithNumbers")
	public void TC_016VerifySuitewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateSuitefield().click();
		gp.getUpdateSuitefield().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateSuitefield().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 31, 3);
		gp.getUpdateSuitefield().sendKeys(input);
		System.out.println("Suite text filed will accepts specialcharacters");
		utilityclassobject.gettest().log(Status.INFO,"Suite text filed will accepts specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_016VerifySuitewithspecialcharacters")
	public void TC_017VerifyCitywithInput() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 1);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts input");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts input");
	}
	
	@Test(dependsOnMethods = "TC_017VerifyCitywithInput")
	public void TC_018VerifyCitywithalphabets() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 1);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts alphabets");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_018VerifyCitywithalphabets")
	public void TC_019VeriyfCitywithNumbers() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 2);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts numbers");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts numbers");
	}
	
	@Test(dependsOnMethods = "TC_019VeriyfCitywithNumbers")
	public void TC_020VerifyCitywithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gp.getUpdateCityfiled().click();
		gp.getUpdateCityfiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateCityfiled().sendKeys(Keys.DELETE); 
		String input = elib.getDataFromExcel("GeneratorInformation", 34, 3);
		gp.getUpdateCityfiled().sendKeys(input);
		System.out.println("City text filed will accepts specialcharacters");
		utilityclassobject.gettest().log(Status.INFO,"City text filed will accepts specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_020VerifyCitywithspecialcharacters")
	public void TC_024VerifytheStatefield()
	{
		WebElement suite = gp.getUpdateStatefiled();
		suite.isDisplayed();
		System.out.println("Suite field is present");
		utilityclassobject.gettest().log(Status.INFO,"Suite field is present");
		
	}
	
	@Test
	public void TC_025VerifyStatewithInput()
	{
		gp.getUpdateStatefiled().click();
		gp.getUpdateStatefiled().sendKeys(Keys.CONTROL + "a");
		gp.getUpdateStatefiled().sendKeys(Keys.DELETE); 
		gp.getUpdateStatefiled().sendKeys("Sfshj");
		System.out.println("Suite field is present");
		utilityclassobject.gettest().log(Status.INFO,"Suite field is present");
		
	}
	
	
	
	
	
	
	

}
