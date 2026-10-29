package GeneratorPortal_login;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.GeneratorPortal;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

public class NewGenerator_Portal extends BaseClassForGEneratorContacts{
	
	GeneratorPortal gpn;
	ExcelUtility elib ;
	
	
	@Test
	public void TC_001VerifyGeneratorportalloginlink() throws InterruptedException
	{
		gpn = new GeneratorPortal(driver);
		elib = new ExcelUtility();
		gpn.getUserprofileButton().click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(gpn.getTransportesettings()).click().perform();
		Thread.sleep(2000);
		act.scrollToElement(gpn.getGeneratorportalLink()).perform();
		System.out.println("Log In to Generator Portal link is present");
		utilityclassobject.gettest().log(Status.PASS,"Log In to Generator Portal link is present");
		
	}
	
	@Test(dependsOnMethods = "TC_001VerifyGeneratorportalloginlink")
	public void TC_002VerifyGeneratorportalloginisClickable() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.scrollToElement(gpn.getGeneratorportalLink()).click().perform();
		Thread.sleep(2000);
		System.out.println("User is able to click on Login to Generator portal");
		utilityclassobject.gettest().log(Status.PASS,"User is able to click on Login to Generator portal");
	}
	
	
	@Test(dependsOnMethods = "TC_002VerifyGeneratorportalloginisClickable")
	public void TC_003Generatorportallogin_Newtab() throws InterruptedException
	{
		 String parentWindow = driver.getWindowHandle();

		    WebElement generatorPortal = gpn.getGeneratorportalLink();

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", generatorPortal);
		    Thread.sleep(1000);

		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", generatorPortal);

		    Thread.sleep(3000);

		    Set<String> allWindows = driver.getWindowHandles();

		    System.out.println("Window Count: " + allWindows.size());

		    for (String window : allWindows) {
		        if (!window.equals(parentWindow)) {
		            driver.switchTo().window(window);
		            break;
		        }
		    }

		    System.out.println("Title: " + driver.getTitle());
		    System.out.println("URL: "+ driver.getCurrentUrl());

		    utilityclassobject.gettest().log(Status.PASS,"Generator Portal opened successfully");
	}
	
	@Test(dependsOnMethods = "TC_003Generatorportallogin_Newtab")
	public void TC_048VerifyGeneratorPortal_NewuserRegistration()
	{
		gpn.getNewuserRegistrationButton().click();
		System.out.println("user is able to click on new user registration button successfully");
		utilityclassobject.gettest().log(Status.PASS,"user is able to click on new user registration button successfully");
		
	}
	
	@Test(dependsOnMethods = "TC_048VerifyGeneratorPortal_NewuserRegistration")
	public void TC_054VerifyGeneratorPortal_FirstnamewithvalidName() throws EncryptedDocumentException, IOException
	{
		gpn.getFirstname().click();
		gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
		gpn.getFirstname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 10, 5);
		gpn.getFirstname().sendKeys(input);
		System.out.println("First name textfield accepts Valid Input");
		utilityclassobject.gettest().log(Status.PASS,"First name textfield accepts Valid Input");		
		
	}
	
	@Test(dependsOnMethods = "TC_054VerifyGeneratorPortal_FirstnamewithvalidName")
	public void TC_060VerifyGeneratorPortal_LastnamewithValidInput() throws EncryptedDocumentException, IOException
	{
		gpn.getLastname().click();
		gpn.getLastname().sendKeys(Keys.CONTROL+"a");
		gpn.getLastname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 13, 5);
		gpn.getLastname().sendKeys(input);		
		System.out.println("Last name textfield accepts valid input");
		utilityclassobject.gettest().log(Status.PASS,"Last name textfield accepts valid input");
	}
	
	@Test(dependsOnMethods = "TC_060VerifyGeneratorPortal_LastnamewithValidInput")
	public void TC_67VerifyGeneratorPortal_RegEmailwithValidInput() throws EncryptedDocumentException, IOException
	{
		gpn.getRegEmail().click();
		gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
		gpn.getRegEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 16, 4);
		gpn.getRegEmail().sendKeys(input);
		System.out.println("Email text field accepts valid input");
		utilityclassobject.gettest().log(Status.PASS,"Email text field accepts valid input");
		
	}
	
	@Test(dependsOnMethods = "TC_67VerifyGeneratorPortal_RegEmailwithValidInput")
	public void TC_069VerifyGeneratorPortal_PhonenumberwithNumbers() throws EncryptedDocumentException, IOException
	{
		  gpn.getPhoneNumber().click();
		  gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
		  gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorPortal", 19, 2);
		  gpn.getPhoneNumber().sendKeys(input); 
		  System.out.println("phone number text field accepts numbers");
		  utilityclassobject.gettest().log(Status.PASS,"phone number text field accepts numbers"); 
	}
	
	@Test(dependsOnMethods = "TC_069VerifyGeneratorPortal_PhonenumberwithNumbers")
	public void TC_074VerifyGeneratorPortal_CompanynamewithAlphabets() throws EncryptedDocumentException, IOException
	{
		  gpn.getCompanyname().click();
		  gpn.getCompanyname().sendKeys(Keys.CONTROL + "a");
		  gpn.getCompanyname().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorPortal", 22, 1);
		  gpn.getCompanyname().sendKeys(input); 
		  System.out.println("Company name text field accepts alphabets");
		  utilityclassobject.gettest().log(Status.PASS,"Company name text field accepts alphabets"); 
		
	}
	
	@Test(dependsOnMethods = "TC_074VerifyGeneratorPortal_CompanynamewithAlphabets")
	public void TC_079VerifyGeneratorPortal_ServicelocationwithNumbers() throws EncryptedDocumentException, IOException
	{
		  gpn.getSerivcelocationAddress().click();
		  gpn.getSerivcelocationAddress().sendKeys(Keys.CONTROL + "a");
		  gpn.getSerivcelocationAddress().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorPortal", 25, 2);
		  gpn.getSerivcelocationAddress().sendKeys(input); 
		  System.out.println("Serivce location address text field accepts numbers");
		  utilityclassobject.gettest().log(Status.PASS,"Serivce location address text field accepts numbers"); 
	}
	
	@Test(dependsOnMethods = "TC_079VerifyGeneratorPortal_ServicelocationwithNumbers")
	public void TC_085VerifyGeneratorPortal_AccountnumberwithoutInput()
	{
		  gpn.getAccountNumber().click();
		  gpn.getAccountNumber().sendKeys(Keys.CONTROL + "a");
		  gpn.getAccountNumber().sendKeys(Keys.DELETE); 
		  gpn.getRegisternowButton().click();
		  System.out.println("Not displayed any error message it is not mandatory field");
		  utilityclassobject.gettest().log(Status.PASS,"Not displayed any error message it is not mandatory field"); 
	}
	
	@Test
	public void TC_086()
	{
		System.out.println("Hi");
	}
	
	

}
