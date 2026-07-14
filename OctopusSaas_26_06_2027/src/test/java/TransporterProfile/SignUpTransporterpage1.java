package TransporterProfile;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseclassForSignUpPage;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.Octo365SignUP;
import com.Octopussaas.ObjectRepository.SignInPage;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class SignUpTransporterpage1 extends BaseclassForSignUpPage {
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;
	ExcelUtility eliv2;

	SignInPage SignInPage;
	Octo365SignUP octo365signupPage;

	TransporterProfile tp;
	
	@Test(priority = 1)
	public void TC_001verifySignuppage() throws EncryptedDocumentException, IOException
	{
		utilityclassobject.gettest().log(Status.INFO, "Signin Page is displayed");
		elib = new ExcelUtility();
		jlib = new javautility();
		String Email = elib.getDataFromExcel("Signup365", 1, 1);
		String Password = elib.getDataFromExcel("Signup365", 1, 2);
		String ConfirmPassword = elib.getDataFromExcel("Signup365", 1, 2);
		String Firstname = elib.getDataFromExcel("Signup365", 1, 4);
		String Lastname = elib.getDataFromExcel("Signup365", 1, 5);
		String Companyname = elib.getDataFromExcel("Signup365", 1, 6);
		int randomnumber = jlib.getRandomNumber();
		Random random6digit = new Random();
		int Sixnumber = 100000 + random6digit.nextInt(900000); // 100000–999999
		SignInPage = new SignInPage(driver);
		SignInPage.getSignuplink().click();
		utilityclassobject.gettest().log(Status.INFO, "Octo365 signup Page is displayed");
		octo365signupPage = new Octo365SignUP(driver);
		String email = Email + randomnumber + "@gmail.com";
		octo365signupPage.EmailTextField(email);
		octo365signupPage.PasswordTextField(Password);
		octo365signupPage.ConFirmPwdTextField(ConfirmPassword);
		octo365signupPage.FirstnameTextField(Firstname);
		octo365signupPage.LastNameTextField(Lastname);
		octo365signupPage.CompanyName(Companyname);
		System.out.println(Sixnumber);
		octo365signupPage.AuthorizationCode(Sixnumber);
		utilityclassobject.gettest().log(Status.INFO, "All the data's are added");
		octo365signupPage.SignUpBtn();
		String terms = octo365signupPage.getAceptterms().getText();
		System.out.println(terms);
		utilityclassobject.gettest().log(Status.INFO, "displayed Octopus Website and Platform Terms of Service Page");
	}
	

	@Test(dependsOnMethods = "TC_001verifySignuppage")
	public void TC_002AcceptTerms() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Terms and condtions Page is displayed");
		octo365signupPage.CheckBox();
		octo365signupPage.AcceptTerms();
		utilityclassobject.gettest().log(Status.INFO, "Check box checked and accepted ");
		// driver.quit();
	}
	
	@Test(dependsOnMethods = "TC_002AcceptTerms")
	public void TC_006CompanynameTextFieldwithInput() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		 tp = new TransporterProfile(driver);
		tp.CompanyNameTextField();
		String input = elib.getDataFromExcel("TransporterProfile", 1, 1);
		tp.getCompanynametxtfield().clear();
		tp.getCompanynametxtfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company name text field accepts Valid input");
	}
	
	@Test(dependsOnMethods = "TC_006CompanynameTextFieldwithInput")
	public void TC_311stateTransist_statewithInput()
	{
		WebElement statedrp = driver.findElement(By.xpath("//button[@id='state']"));
		statedrp.sendKeys("abc");
		String enteredValue = statedrp.getAttribute("value");
		Assert.assertTrue(enteredValue.isEmpty() || enteredValue.matches("\\d+"),
		    "Field accepted invalid input!");
		utilityclassobject.gettest().log(Status.INFO, "State Transist Id's state dropdown will not accpet input");
	}
	
	@Test(dependsOnMethods = "TC_311stateTransist_statewithInput")
	public void TC_312stateTransist_State()
	{
		tp.StateTransistDropdown();
		tp.StatetransistDropdwons();
		utilityclassobject.gettest().log(Status.INFO, "User is able select state from the state dropdown");
	}
	
	@Test(dependsOnMethods = "TC_312stateTransist_State")
	public void TC_313stateTransist_TransistIDwithInput() throws EncryptedDocumentException, IOException
	{
		tp.getTransistIdField().click();
		String  input = elib.getDataFromExcel("TransporterProfile", 67, 1);
		tp.getTransistIdField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Transist ID text filed will accept input");
	}
	
	@Test(dependsOnMethods = "TC_313stateTransist_TransistIDwithInput")
	public void TC_314stateTransist_TransistIdwithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getTransistIdField().click();
		tp.getTransistIdField().sendKeys(Keys.CONTROL + "a");
		tp.getTransistIdField().sendKeys(Keys.DELETE);
		String  input = elib.getDataFromExcel("TransporterProfile", 67, 2);
		tp.getTransistIdField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Transist ID text filed will accept alpahbets");
	}
	
	@Test(dependsOnMethods = "TC_314stateTransist_TransistIdwithalphabets")
	public void TC_315stateTransist_TransistIDwithNumbers() throws EncryptedDocumentException, IOException
	{
		tp.getTransistIdField().click();
		tp.getTransistIdField().sendKeys(Keys.CONTROL + "a");
		tp.getTransistIdField().sendKeys(Keys.DELETE);
		String  input = elib.getDataFromExcel("TransporterProfile", 67, 3);
		tp.getTransistIdField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Transist ID text filed will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_315stateTransist_TransistIDwithNumbers")
	public void TC_316stateTransist_TransistIDwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getTransistIdField().click();
		tp.getTransistIdField().sendKeys(Keys.CONTROL + "a");
		tp.getTransistIdField().sendKeys(Keys.DELETE);
		String  input = elib.getDataFromExcel("TransporterProfile", 67, 4);
		tp.getTransistIdField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Transist ID text filed will accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_316stateTransist_TransistIDwithspecialcharacters")
	public void TC_317stateTransist_Addbutton()
	{
		tp.getTransistAddButton().click();
		utilityclassobject.gettest().log(Status.INFO, "State Transist ID Add button is clickable");
	}
	
	@Test(dependsOnMethods = "TC_317stateTransist_Addbutton")
	public void TC_318stateTransist_withIDs() throws EncryptedDocumentException, IOException, InterruptedException
	{
		tp.StateTransistDropdown();
		Thread.sleep(2000);
		tp.getTransistIdField().click();
		String  input = elib.getDataFromExcel("TransporterProfile", 67, 1);
		tp.getTransistIdField().sendKeys(input);
		tp.getTransistAddButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "State Transist IDs are displayed after clicking on add button");
	}
	
	@Test(dependsOnMethods = "TC_318stateTransist_withIDs")
	public void TC_319stateTransist_withAutosave() throws EncryptedDocumentException, IOException, InterruptedException
	{
		tp.StateTransistDropdown();
		Thread.sleep(2000);
		tp.getTransistIdField().click();
		String  input = elib.getDataFromExcel("TransporterProfile", 67, 3);
		tp.getTransistIdField().sendKeys(input);
		tp.getTransistAddButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "State Transist IDs are displayed after clicking on add button");
	}
	
	@Test(dependsOnMethods = "TC_319stateTransist_withAutosave")
	public void TC_320stateTransist_withDeletebutton() throws InterruptedException, EncryptedDocumentException, IOException
	{
		tp.StateTransistDropdown();
		Thread.sleep(2000);
		tp.getTransistIdField().click();
		String  input = elib.getDataFromExcel("TransporterProfile", 67, 3);
		tp.getTransistIdField().sendKeys(input);
		tp.getTransistAddButton().click();
		Thread.sleep(2000);
		tp.getTransistDeletebutton().click();
		utilityclassobject.gettest().log(Status.INFO, "State Transist IDs are deleted after clicking on the delete button");
	}
	
	
	
	
	
	

	
	}
	
