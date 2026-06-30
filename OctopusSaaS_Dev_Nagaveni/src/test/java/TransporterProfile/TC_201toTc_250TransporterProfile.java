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

public class TC_201toTc_250TransporterProfile extends BaseclassForSignUpPage{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;
	ExcelUtility eliv2;

	SignInPage SignInPage;
	Octo365SignUP octo365signupPage;

	TransporterProfile tp;
	

	@Test(priority = 1)
	public void TC_001VerifySignUpPage() throws EncryptedDocumentException, IOException {
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

	@Test(dependsOnMethods = "TC_001VerifySignUpPage")
	public void TC_002AcceptTerms() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Terms and condtions Page is displayed");
		octo365signupPage.CheckBox();
		octo365signupPage.AcceptTerms();
		utilityclassobject.gettest().log(Status.INFO, "Check box checked and accepted ");
		// driver.quit();
	}

	/*
	 * @Test(priority = 2) public void TC_003AcceptTermswithoutCheckBox() throws
	 * EncryptedDocumentException, IOException, InterruptedException {
	 * System.out.println("Hi");
	 * 
	 * utilityclassobject.gettest().log(Status.INFO, "Signin Page is displayed");
	 * elib = new ExcelUtility(); jlib = new javautility(); String Email =
	 * elib.getDataFromExcel("TransporterPage", 1, 1); String Password =
	 * elib.getDataFromExcel("TransporterPage", 1, 2); String ConfirmPassword =
	 * elib.getDataFromExcel("TransporterPage", 1, 2); String Firstname =
	 * elib.getDataFromExcel("TransporterPage", 1, 4); String Lastname =
	 * elib.getDataFromExcel("TransporterPage", 1, 5); String Companyname =
	 * elib.getDataFromExcel("TransporterPage", 1, 6); int randomnumber =
	 * jlib.getRandomNumber(); Random random6digit = new Random(); int Sixnumber =
	 * 100000 + random6digit.nextInt(900000); // 100000–999999 Thread.sleep(3000);
	 * SignInPage = new SignInPage(driver); SignInPage.getSignuplink().click();
	 * utilityclassobject.gettest().log(Status.INFO,
	 * "Octo365 signup Page is displayed"); octo365signupPage = new
	 * Octo365SignUP(driver); String email = Email + randomnumber + "@gmail.com";
	 * octo365signupPage.EmailTextField(email);
	 * octo365signupPage.PasswordTextField(Password);
	 * octo365signupPage.ConFirmPwdTextField(ConfirmPassword);
	 * octo365signupPage.FirstnameTextField(Firstname);
	 * octo365signupPage.LastNameTextField(Lastname);
	 * octo365signupPage.CompanyName(Companyname); System.out.println(Sixnumber);
	 * octo365signupPage.AuthorizationCode(Sixnumber);
	 * utilityclassobject.gettest().log(Status.INFO, "All the data's are added");
	 * octo365signupPage.SignUpBtn(); String terms =
	 * octo365signupPage.getAceptterms().getText(); System.out.println(terms);
	 * //Assert.assertTrue(terms.contains("I ACCEPT"));
	 * utilityclassobject.gettest().log(Status.INFO,
	 * "displayed Octopus Website and Platform Terms of Service Page");
	 * utilityclassobject.gettest().log(Status.INFO,
	 * "Terms and condtions Page is displayed"); octo365signupPage.AcceptTerms();
	 * utilityclassobject.gettest().log(Status.INFO,
	 * "Check box is un-checked and not accepted ");
	 * 
	 * 
	 * }
	 */

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
	public void TC_201billingadd_Statewithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddState().click();
		tp.getBillingaddState().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 2);
		tp.getBillingaddState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department State text field accpeted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_201billingadd_Statewithalphabets")
	public void TC_202billingadd_statewithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddState().click();
		tp.getBillingaddState().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 3);
		tp.getBillingaddState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department State text field will not accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_202billingadd_statewithnumbers")
	public void TC_203billingadd_statewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddState().click();
		tp.getBillingaddState().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 4);
		tp.getBillingaddState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department State text field will not accept special characters");
	}
	
	@Test(dependsOnMethods = "TC_203billingadd_statewithspecialcharacters")
	public void TC_204billingadd_StatewithDropdown()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddState().click();
		tp.getBillingaddState().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddState().sendKeys(Keys.DELETE);
		tp.SelectbillinAZstate();
		utilityclassobject.gettest().log(Status.INFO, "From Billing Department state dropdown state is selected ");
	}
	
	@Test(dependsOnMethods = "TC_204billingadd_StatewithDropdown") 
	public void TC_206billingadd_statewithAutosave()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddState().click();
		tp.getBillingaddState().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddState().sendKeys(Keys.DELETE);
		tp.SelectbillingCAstate();
		utilityclassobject.gettest().log(Status.INFO, "From Billing Department state dropdown state is selected and autosaved");
	}
	
	//change
	@Test(dependsOnMethods = "TC_206billingadd_statewithAutosave")
	public void TC_207billingadd_ZipcodewithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddZipcode().click();
		tp.getBillingaddZipcode().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddZipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 40, 1);
		tp.getBillingaddZipcode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted input");
	}
	
	
	@Test(dependsOnMethods = "TC_207billingadd_ZipcodewithInput")
	public void TC_208billingadd_Zipcodewithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddZipcode().click();
		tp.getBillingaddZipcode().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddZipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 40, 2);
		tp.getBillingaddZipcode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted alpahbets");
	}
	
	@Test(dependsOnMethods = "TC_208billingadd_Zipcodewithalphabets")
	public void TC_209billingadd_Zipcodenumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddZipcode().click();
		tp.getBillingaddZipcode().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddZipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 40, 3);
		tp.getBillingaddZipcode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_209billingadd_Zipcodenumbers")
	public void TC_210billingadd_Zipcodespecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddZipcode().click();
		tp.getBillingaddZipcode().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddZipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 40, 4);
		tp.getBillingaddZipcode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_210billingadd_Zipcodespecialcharacters")
	public void TC_211billing_ZipcodewithoutInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddZipcode().click();
		tp.getBillingaddZipcode().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddZipcode().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getBillingZipcodeErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text feild without input and displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_211billing_ZipcodewithoutInput")
	public void TC_212billingadd_ZipcodeAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddZipcode().click();
		tp.getBillingaddZipcode().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddZipcode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 40, 1);
		tp.getBillingaddZipcode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted input and autosaved");
	}
	
	
	@Test(dependsOnMethods = "TC_212billingadd_ZipcodeAutosave")
	public void TC_213billingadd_EmailwithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 1);
		tp.getBillingEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted input");

	}
	
	@Test(dependsOnMethods = "TC_213billingadd_EmailwithInput")
	public void TC_214billingadd_Emailwithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 2);
		tp.getBillingEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_214billingadd_Emailwithalphabets")
	public void TC_215billingadd_Emailwithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 3);
		tp.getBillingEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_215billingadd_Emailwithnumbers")
	public void TC_216billingadd_Emailwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 4);
		tp.getBillingEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_216billingadd_Emailwithspecialcharacters")
	public void TC_217billingadd_EmailwithInvalidinput() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		Thread.sleep(2000); 
		String input = elib.getDataFromExcel("TransporterProfile", 43, 5);
		tp.getBillingEmail().sendKeys(input);
		String errormsg = tp.getBillingEmailErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field with invalid input and displayed error message");

	}
	
	@Test(dependsOnMethods = "TC_217billingadd_EmailwithInvalidinput")
	public void TC_218billingadd_EmailwithoutInput() throws InterruptedException
	{
		Thread.sleep(2000);
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		Thread.sleep(2000);

		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		Thread.sleep(2000);

		tp.SubmitBtn();
		Thread.sleep(2000);

		String errormsg = tp.getBillingEmailErrormsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field without input and displayed error message");

	}
	
	@Test(dependsOnMethods = "TC_218billingadd_EmailwithoutInput")
	public void TC_219billingadd_EmailwithAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 1);
		tp.getBillingEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_219billingadd_EmailwithAutosave")
	public void TC_220billingadd_PhonewithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		tp.getBillindaddPhone().sendKeys(Keys.CONTROL + "a");
		tp.getBillindaddPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 1);
		tp.getBillindaddPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field accepted input");

	}
	
	@Test(dependsOnMethods = "TC_220billingadd_PhonewithInput")
	public void TC_221billingadd_PhoneWithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		tp.getBillindaddPhone().sendKeys(Keys.CONTROL + "a");
		tp.getBillindaddPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 2);
		tp.getBillindaddPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept alphabets");
	
	}
	
	@Test(dependsOnMethods = "TC_221billingadd_PhoneWithalphabets")
	public void TC_222billingadd_Phonewithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		tp.getBillindaddPhone().sendKeys(Keys.CONTROL + "a");
		tp.getBillindaddPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 3);
		tp.getBillindaddPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept numbers");
	
	}
	
	@Test(dependsOnMethods = "TC_222billingadd_Phonewithnumbers")
	public void TC_223billingadd_Phonewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		tp.getBillindaddPhone().sendKeys(Keys.CONTROL + "a");
		tp.getBillindaddPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 4);
		tp.getBillindaddPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_223billingadd_Phonewithspecialcharacters")
	public void TC_224billingadd_Phonemorethan10digits() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		tp.getBillindaddPhone().sendKeys(Keys.CONTROL + "a");
		tp.getBillindaddPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 5);
		tp.getBillindaddPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept more than 10 digits");
	}
	
	/*
	@Test(dependsOnMethods = "TC_224billingadd_Phonemorethan10digits")
	public void TC_225billingadd_Phonelessthan10digits() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		tp.getBillindaddPhone().sendKeys(Keys.CONTROL + "a");
		tp.getBillindaddPhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 6);
		tp.getBillindaddPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept less than 10 digits");
	}*/
	
	
   @Test(dependsOnMethods = "TC_224billingadd_Phonemorethan10digits")
    public void TC_226billingadd_PhonewithoutInput() throws EncryptedDocumentException, IOException
    {
     	TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		tp.getBillindaddPhone().sendKeys(Keys.CONTROL + "a");
		tp.getBillindaddPhone().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getBillingPhoneErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field without input and displayed error message");
	}
    
    @Test(dependsOnMethods = "TC_226billingadd_PhonewithoutInput")
    public void TC_227billingadd_PhonewithAutosave() throws EncryptedDocumentException, IOException
    {
    		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillindaddPhone().click();
		String input = elib.getDataFromExcel("TransporterProfile", 46, 1);
		tp.getBillindaddPhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field accpeted input and autosaved");
	}
    
    @Test(dependsOnMethods = "TC_227billingadd_PhonewithAutosave")
    public void TC_228billingadd_ExtwithInput() throws EncryptedDocumentException, IOException
    {
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddExt().click();
		tp.getBillingaddExt().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 1);
		tp.getBillingaddExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Ext text field accpeted input");

    }
    
    @Test(dependsOnMethods = "TC_228billingadd_ExtwithInput")
    public void TC_229billingadd_Extwithalphabets() throws EncryptedDocumentException, IOException
    {
    		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddExt().click();
		tp.getBillingaddExt().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 2);
		tp.getBillingaddExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Ext text field will not accpet alphabets");

    }
    
    @Test(dependsOnMethods = "TC_229billingadd_Extwithalphabets")
    public void TC_230billingadd_Extwithnumbers() throws EncryptedDocumentException, IOException
    {
     	TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddExt().click();
		tp.getBillingaddExt().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 3);
		tp.getBillingaddExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Ext text field will not accpet numbers");

    }
    
    @Test(dependsOnMethods = "TC_230billingadd_Extwithnumbers")
    public void TC_231billingadd_Extwithspecialcharacters() throws EncryptedDocumentException, IOException
    {

     	TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddExt().click();
		tp.getBillingaddExt().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 4);
		tp.getBillingaddExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Ext text field will not accpet specialcharacters");

    }
    
    @Test(dependsOnMethods = "TC_231billingadd_Extwithspecialcharacters")
    public void TC_232billingadd_ExtwithoutInput() throws EncryptedDocumentException, IOException
    {
    		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddExt().click();
		tp.getBillingaddExt().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddExt().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "Service Department Ext text field without input");

    }
    
    @Test(dependsOnMethods = "TC_232billingadd_ExtwithoutInput")
    public void TC_233billingadd_ExtwithAutosave() throws EncryptedDocumentException, IOException
    {
     	TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddExt().click();
		tp.getBillingaddExt().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 1);
		tp.getBillingaddExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Ext text field accpeted input");

    }
    
	
    @Test(dependsOnMethods = "TC_233billingadd_ExtwithAutosave")
    public void TC_236businesshours_Tooltip()
    {
       TransporterProfile tp = new TransporterProfile(driver);
       tp.BusinessToolTip();
       WebElement popup = driver.findElement(By.xpath("//strong[contains(text(),'Business Hours')]"));
       Assert.assertTrue(popup.isDisplayed(), "Business Hours popup is  visible");

    }
	
	@Test(dependsOnMethods = "TC_236businesshours_Tooltip")
	public void TC_237businesshours_dropdownselect()
	{
	   TransporterProfile tp = new TransporterProfile(driver);
	   tp.MondayTime();
	   tp.TuesdayTime();
	   tp.WednesdayTime();
	   tp.ThursdayTime();
	   tp.FridayTime();
	   tp.SaturdayTime();
	   tp.SundayTime();
	   utilityclassobject.gettest().log(Status.INFO, "From Business Hours weekdays dropdown timings selected");

	}
	
	@Test(dependsOnMethods = "TC_237businesshours_dropdownselect")
	public void TC_238businesshours_withalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBusinessMondaytime().click();
		tp.getBusinessMondaytime().sendKeys(Keys.CONTROL + "a");
		tp.getBusinessMondaytime().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 52, 1);
		tp.getBusinessMondaytime().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Business Hours weekdays dropdown accepted alphabets");

	}
	
	@Test(dependsOnMethods = "TC_238businesshours_withalphabets")
	public void TC_239businesshours_withnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBusinessMondaytime().click();
		tp.getBusinessMondaytime().sendKeys(Keys.CONTROL + "a");
		tp.getBusinessMondaytime().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 52, 2);
		tp.getBusinessMondaytime().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Business Hours weekdays dropdown accepted numbers");

	}
	
	@Test(dependsOnMethods = "TC_239businesshours_withnumbers")
	public void TC_240businesshours_withspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBusinessMondaytime().click();
		tp.getBusinessMondaytime().sendKeys(Keys.CONTROL + "a");
		tp.getBusinessMondaytime().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 52, 3);
		tp.getBusinessMondaytime().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Business Hours weekdays dropdown accepted specailcharacters");
	}
	
	@Test(dependsOnMethods = "TC_240businesshours_withspecialcharacters")
	public void TC_241businesshour_withOpenTime()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondayTime();
		utilityclassobject.gettest().log(Status.INFO, "User is able to the opening time from the Business hours weekday dropdown");
	}
	
	@Test(dependsOnMethods = "TC_241businesshour_withOpenTime")
	public void TC_242businesshour_withLunchTime()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.Mondaylunchtime();
		utilityclassobject.gettest().log(Status.INFO, "User is able to the lunch time from the Business hours weekday dropdown");

	}
	
	@Test(dependsOnMethods = "TC_242businesshour_withLunchTime")
	public void TC_243businesshour_withlunchEnd()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondaylunchEnd();
		utilityclassobject.gettest().log(Status.INFO, "User is able to the lunch end time  from the Business hours weekday dropdown");

	}
	
	@Test(dependsOnMethods = "TC_243businesshour_withlunchEnd")
	public void TC_244businesshour_withclose()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondaycloseTime();
		utilityclassobject.gettest().log(Status.INFO, "User is able to the close time from the Business hours weekday dropdown");

	}
	
	@Test(dependsOnMethods = "TC_244businesshour_withclose") 
	public void TC_245businesshour_Checkbox()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondayCheckBox();
		utilityclassobject.gettest().log(Status.INFO, "User is able to the check the Checkbox");

	}
	
	@Test(dependsOnMethods = "TC_245businesshour_Checkbox")
	public void TC_246businesshour_withCheckbox()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondayCheckBox();
		tp.getBusinessMondaytime().click();
		tp.getBusinessMondaylunch().click();
		tp.getBusinessMondaylunchEnd().click();
		tp.getBusinessMondayclose().click();
		utilityclassobject.gettest().log(Status.INFO, "User is not able to enter the business hours when the Checkbox is checked");

	}
	
	@Test(dependsOnMethods = "TC_246businesshour_withCheckbox")
	public void TC_247businesshour_withoutCheckbox() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CheckBox();
		Thread.sleep(2000);
		tp.MondayTime();
		tp.Mondaylunchtime();
		tp.MondaylunchEnd();
		tp.MondaycloseTime();
		utilityclassobject.gettest().log(Status.INFO, "User is able to enter the business hours when the Checkbox is unchecked");

	}
	
	@Test(dependsOnMethods = "TC_247businesshour_withoutCheckbox")
	public void TC_248businesshour_MultipleCheckbox()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MultipleCheckbox();
		utilityclassobject.gettest().log(Status.INFO, "User is able to check the multiple checkbox");

	}
	
	@Test(dependsOnMethods = "TC_248businesshour_MultipleCheckbox")
	public void TC_249businesshour_Copybutton() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MultipleCheckbox();
		tp.MultipleCheckbox();
		Thread.sleep(2000);
		tp.MondayTime();
		tp.Mondaylunchtime();
		tp.MondaylunchEnd();
		tp.MondaycloseTime();
		tp.getCopybutton().click();
		utilityclassobject.gettest().log(Status.INFO, "User is able to copy the business hours");
	}
	
	@Test(dependsOnMethods = "TC_249businesshour_Copybutton")
	public void TC_250businesshour_PasteButton()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondayTime();
		tp.Mondaylunchtime();
		tp.MondaylunchEnd();
		tp.MondaycloseTime();
		tp.PasteButton();
		utilityclassobject.gettest().log(Status.INFO, "User is able to copy the business hours and paste");
	}
	
}
