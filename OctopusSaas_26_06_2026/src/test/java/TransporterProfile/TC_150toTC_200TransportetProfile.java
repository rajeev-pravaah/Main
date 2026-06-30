package TransporterProfile;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
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

public class TC_150toTC_200TransportetProfile extends BaseclassForSignUpPage{
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
	public void TC_151serviceDep_zipcodeaithnumbers() throws EncryptedDocumentException, IOException
	{
	   tp.getZipCode().click();
	   tp.getZipCode().sendKeys(Keys.CONTROL + "a");
	   tp.getZipCode().sendKeys(Keys.DELETE);
	   String input = elib.getDataFromExcel("TransporterProfile", 40, 3);
	   tp.getZipCode().sendKeys(input);
	   utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_151serviceDep_zipcodeaithnumbers")
	public void TC_152serviceDep_zipcodewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		   tp.getZipCode().click();
		   tp.getZipCode().sendKeys(Keys.CONTROL + "a");
		   tp.getZipCode().sendKeys(Keys.DELETE);
		   String input = elib.getDataFromExcel("TransporterProfile", 40, 4);
		   tp.getZipCode().sendKeys(input);
		   utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_152serviceDep_zipcodewithspecialcharacters")
	public void TC_153serviceDep_zipcodewihoutInput()
	{
	     tp.getZipCode().click();
		 tp.getZipCode().sendKeys(Keys.CONTROL + "a");
		 tp.getZipCode().sendKeys(Keys.DELETE);
		 tp.SubmitBtn();
		 String errormsg = tp.getZipcodeErmsg().getText();
		 System.out.println(errormsg);
		 utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field without Input displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_153serviceDep_zipcodewihoutInput")
	public void TC_154serviceDep_zipcodewithAutosave() throws EncryptedDocumentException, IOException
	{
	tp.getZipCode().click();
	String input = elib.getDataFromExcel("TransporterProfile", 40, 1);
	tp.getZipCode().sendKeys(input);
	utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted input and autosaved");
    }
	
	
	@Test(dependsOnMethods = "TC_154serviceDep_zipcodewithAutosave")
	public void TC_155serviceDep_EmailwithInput() throws EncryptedDocumentException, IOException
	{
		tp.getEmail().click();
		String input = elib.getDataFromExcel("TransporterProfile", 43, 1);
		tp.getEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_155serviceDep_EmailwithInput") 
	public void TC_156serviceDep_Emailwithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getEmail().click();
		tp.getEmail().sendKeys(Keys.CONTROL + "a");
		tp.getEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 2);
		tp.getEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_156serviceDep_Emailwithalphabets")
	public void TC_157serviceDep_Emailwithnumbers() throws EncryptedDocumentException, IOException
	{
		tp.getEmail().click();
		tp.getEmail().sendKeys(Keys.CONTROL + "a");
		tp.getEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 3);
		tp.getEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_157serviceDep_Emailwithnumbers")
	public void TC_158serviceDep_Emailwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getEmail().click();
		tp.getEmail().sendKeys(Keys.CONTROL + "a");
		tp.getEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 4);
		tp.getEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_158serviceDep_Emailwithspecialcharacters")
	public void TC_159serviceDep_Emailwithinvalid() throws EncryptedDocumentException, IOException
	{
		tp.getEmail().click();
		tp.getEmail().sendKeys(Keys.CONTROL + "a");
		tp.getEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 5);
		tp.getEmail().sendKeys(input);
		String errormsg = tp.getInvalidErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field with invalid email displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_159serviceDep_Emailwithinvalid")
	public void TC_160serviceDep_EmailwithoutInput()
	{
		tp.getEmail().click();
		tp.getEmail().sendKeys(Keys.CONTROL + "a");
		tp.getEmail().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getEmailErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field without input and  displayed error message");
	}
	
	@Test(dependsOnMethods ="TC_160serviceDep_EmailwithoutInput")
	public void TC_161serviceDep_EmailwithAutosave() throws EncryptedDocumentException, IOException
	{
		tp.getEmail().click();
		String input = elib.getDataFromExcel("TransporterProfile", 43, 1);
		tp.getEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Email text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_161serviceDep_EmailwithAutosave")
	public void TC_162serviceDep_PhonewithInput() throws EncryptedDocumentException, IOException
	{
		tp.getServicePhone().click();
		String input = elib.getDataFromExcel("TransporterProfile", 46, 1);
		tp.getServicePhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field accepted input");
		
	}
	
	@Test(dependsOnMethods = "TC_162serviceDep_PhonewithInput")
	public void TC_163serviceDep_Phonewithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getServicePhone().click();
		tp.getServicePhone().sendKeys(Keys.CONTROL + "a");
		tp.getServicePhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 2);
		tp.getServicePhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept alphabets");
		
	}
	
	@Test(dependsOnMethods = "TC_163serviceDep_Phonewithalphabets")
	public void TC_164serviceDep_Phonewithnumbers() throws EncryptedDocumentException, IOException
	{
		tp.getServicePhone().click();
		tp.getServicePhone().sendKeys(Keys.CONTROL + "a");
		tp.getServicePhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 3);
		tp.getServicePhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field accept numbers");
		
	}
	
	@Test(dependsOnMethods = "TC_164serviceDep_Phonewithnumbers")
	public void TC_165serviceDep_Phonewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getServicePhone().click();
		tp.getServicePhone().sendKeys(Keys.CONTROL + "a");
		tp.getServicePhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 4);
		tp.getServicePhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept specialcharacters");
		
	}
	
	@Test(dependsOnMethods = "TC_165serviceDep_Phonewithspecialcharacters")
	public void TC_166serviceDep_phonewith10digits() throws EncryptedDocumentException, IOException
	{
		tp.getServicePhone().click();
		tp.getServicePhone().sendKeys(Keys.CONTROL + "a");
		tp.getServicePhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 5);
		tp.getServicePhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field will not accept more than 10 digits");
		
	}
	
	@Test(dependsOnMethods = "TC_166serviceDep_phonewith10digits")
	public void TC_167serviceDep_Phonewithlessdigits() throws EncryptedDocumentException, IOException
	{
		tp.getServicePhone().click();
		tp.getServicePhone().sendKeys(Keys.CONTROL + "a");
		tp.getServicePhone().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 6);
		tp.getEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field with less than 10 digits");
		
	}
	
	@Test(dependsOnMethods = "TC_166serviceDep_phonewith10digits")
	public void TC_168serviceDep_PhonewithoutInput()
	{
		tp.getServicePhone().click();
		tp.getServicePhone().sendKeys(Keys.CONTROL + "a");
		tp.getServicePhone().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getServicephoneErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field without input and displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_168serviceDep_PhonewithoutInput")
	public void TC_169serviceDep_PhonewithAutosave() throws EncryptedDocumentException, IOException
	{
		tp.getServicePhone().click();
		String input = elib.getDataFromExcel("TransporterProfile", 46, 1);
		tp.getServicePhone().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_169serviceDep_PhonewithAutosave")
	public void TC_170serviceDep_ExtwithInput() throws EncryptedDocumentException, IOException
	{
		tp.getPhoneExt().click();
		String input = elib.getDataFromExcel("TransporterProfile", 49, 1);
		tp.getPhoneExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone Ext text field accepted input");

	}
	
	@Test(dependsOnMethods = "TC_170serviceDep_ExtwithInput")
	public void TC_171serviceDep_Extwithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getPhoneExt().click();
		tp.getPhoneExt().sendKeys(Keys.CONTROL + "a");
		tp.getPhoneExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 2);
		tp.getPhoneExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone Ext text field will not accept alphabets");
	}
	
	@Test(dependsOnMethods = "TC_171serviceDep_Extwithalphabets")
	public void TC_172serviceDep_Extwithnumbers() throws EncryptedDocumentException, IOException
	{
		tp.getPhoneExt().click();
		tp.getPhoneExt().sendKeys(Keys.CONTROL + "a");
		tp.getPhoneExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 3);
		tp.getPhoneExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone Ext text field will not accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_172serviceDep_Extwithnumbers")
	public void TC_173serviceDep_Extwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getPhoneExt().click();
		tp.getPhoneExt().sendKeys(Keys.CONTROL + "a");
		tp.getPhoneExt().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 4);
		tp.getPhoneExt().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone Ext text field will not accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_173serviceDep_Extwithspecialcharacters")
	public void TC_174serviceDep_ExtwithoutInput()
	{
		tp.getPhoneExt().click();
		tp.getPhoneExt().sendKeys(Keys.CONTROL + "a");
		tp.getPhoneExt().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "Service Department Phone Ext text field without input error message is not displayed (not mandatory field)");
	}
	
	@Test(dependsOnMethods = "TC_174serviceDep_ExtwithoutInput")
	public void TC_175serviceDep_Copytobilling()
	{
		tp.getCopyButton().click();
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "copy to billing information copy button is clickable");

	}
	 
	@Test(dependsOnMethods = "TC_175serviceDep_Copytobilling" )
	public void TC_176billinadd_NamewithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddName().click();
		tp.getBillingaddName().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 25, 1);
		tp.getBillingaddName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Name text field accepted Input");
	}
	
	
	@Test(dependsOnMethods = "TC_176billinadd_NamewithInput")
	public void TC_177billingadd_Namewithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddName().click();
		tp.getBillingaddName().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 25, 2);
		tp.getBillingaddName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Name text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_177billingadd_Namewithalphabets")
	public void  TC_178billingadd_Namewithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddName().click();
		tp.getBillingaddName().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 25, 3);
		tp.getBillingaddName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Name text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_178billingadd_Namewithnumbers")
	public void TC_179billingadd_Namewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddName().click();
		tp.getBillingaddName().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 25, 4);
		tp.getBillingaddName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Name text field accepted special characters");
	}
	
	@Test(dependsOnMethods = "TC_179billingadd_Namewithspecialcharacters")
	public void TC_180billinadd_NamewithoutInput() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddName().click();
		tp.getBillingaddName().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddName().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getNameErmag().getText();
		System.out.println(errormsg);
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Name text field accepted special characters");
	}
	
	@Test(dependsOnMethods = "TC_180billinadd_NamewithoutInput")
	public void TC_181billingadd_NamewithAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddName().click();
		String input = elib.getDataFromExcel("TransporterProfile", 25, 1);
		tp.getBillingaddName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Name text field accepted Input and autosaved");
	}
	
	
	@Test(dependsOnMethods = "TC_181billingadd_NamewithAutosave")
	public void TC_182billingadd_streetwithInput() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.BillingStreet();
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Street text field accepted Input");
	}
	
	@Test(dependsOnMethods = "TC_182billingadd_streetwithInput")
	public void TC_183billingadd_streetwithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddStreet().click();
		tp.getBillingaddStreet().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddStreet().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 28, 1);
		tp.getBillingaddStreet().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Street text field accepted alpahbets");
	}
	
	@Test(dependsOnMethods = "TC_183billingadd_streetwithalphabets")
	public void TC_184billingadd_streetwithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddStreet().click();
		tp.getBillingaddStreet().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddStreet().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 28, 2);
		tp.getBillingaddStreet().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Street text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_184billingadd_streetwithnumbers")
	public void TC_185billingadd_streetwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddStreet().click();
		tp.getBillingaddStreet().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddStreet().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 28, 3);
		tp.getBillingaddStreet().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Street text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_185billingadd_streetwithspecialcharacters")
	public void TC_186billingadd_StreetwithoutInput() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(2000);
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddStreet().click();
		Thread.sleep(2000);

		tp.getBillingaddStreet().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddStreet().sendKeys(Keys.DELETE);
		Thread.sleep(2000);

		tp.SubmitBtn();
		String errormsg = tp.getBillingStreetErmsg().getText();
		System.out.println(errormsg);
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Street text field without input displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_186billingadd_StreetwithoutInput")
	public void TC_187billingadd_StreetwithAutosave() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.BillingStreet();
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Street text field accepted input and autosaved");
	}
	
	//change
	@Test(dependsOnMethods = "TC_187billingadd_StreetwithAutosave")
	public void TC_188billingadd_suitewithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingSuite().click();
		tp.getBillingSuite().sendKeys(Keys.CONTROL + "a");
		tp.getBillingSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 1);
		tp.getBillingSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Suite text field accepted input");

	}
	
	@Test(dependsOnMethods = "TC_188billingadd_suitewithInput") 
	public void TC_189billingadd_suitewithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingSuite().click();
		tp.getBillingSuite().sendKeys(Keys.CONTROL + "a");
		tp.getBillingSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 2);
		tp.getBillingSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Suite text field accepted alphabets");
		
	}
	
	@Test(dependsOnMethods = "TC_189billingadd_suitewithalphabets")
	public void TC_190billingadd_suitewithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingSuite().click();
		tp.getBillingSuite().sendKeys(Keys.CONTROL + "a");
		tp.getBillingSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 3);
		tp.getBillingSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Suite text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_190billingadd_suitewithnumbers")
	public void TC_191billingadd_suitewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingSuite().click();
		tp.getBillingSuite().sendKeys(Keys.CONTROL + "a");
		tp.getBillingSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 4);
		tp.getBillingSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Suite text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_191billingadd_suitewithspecialcharacters")
	public void TC_192billingadd_SuitewithoutInput()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingSuite().click();
		tp.getBillingSuite().sendKeys(Keys.CONTROL + "a");
		tp.getBillingSuite().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Suite text field without input error message is not displayed(not mandatory field)");
	}
	
	@Test(dependsOnMethods = "TC_192billingadd_SuitewithoutInput")
	public void TC_193billingadd_SuitewithAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingSuite().click();
		tp.getBillingSuite().sendKeys(Keys.CONTROL + "a");
		tp.getBillingSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 1);
		tp.getBillingSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department Suite text field accepted input and autosaved");
	}
	
	//change
	@Test(dependsOnMethods = "TC_193billingadd_SuitewithAutosave")
	public void TC_194billingadd_CitywithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingCity().click();
		tp.getBillingCity().sendKeys(Keys.CONTROL + "a");
		tp.getBillingCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 1);
		tp.getBillingCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department City text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_194billingadd_CitywithInput")
	public void TC_195billingadd_citywithalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingCity().click();
		tp.getBillingCity().sendKeys(Keys.CONTROL + "a");
		tp.getBillingCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 2);
		tp.getBillingCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department City text field accepted alpahbets");
	}
	
	@Test(dependsOnMethods = "TC_195billingadd_citywithalphabets")
	public void TC_196billingadd_citywithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingCity().click();
		tp.getBillingCity().sendKeys(Keys.CONTROL + "a");
		tp.getBillingCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 3);
		tp.getBillingCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department City text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_196billingadd_citywithnumbers")
	public void TC_197billingadd_citywithspecialchracters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingCity().click();
		tp.getBillingCity().sendKeys(Keys.CONTROL + "a");
		tp.getBillingCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 4);
		tp.getBillingCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department City text field accepted special characters");
	}
	
	@Test(dependsOnMethods = "TC_197billingadd_citywithspecialchracters")
	public void TC_198billingadd_citywithoutInput()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingCity().click();
		tp.getBillingCity().sendKeys(Keys.CONTROL + "a");
		tp.getBillingCity().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getBillingCityErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department City text field without input and displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_198billingadd_citywithoutInput")
	public void TC_199billingadd_citywithAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingCity().click();
		tp.getBillingCity().sendKeys(Keys.CONTROL + "a");
		tp.getBillingCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 1);
		tp.getBillingCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department City text field accpeted input and autosaved");
	}
	
	//change
	@Test(dependsOnMethods = "TC_199billingadd_citywithAutosave")
	public void TC_200billingadd_statewithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddState().click();
		tp.getBillingaddState().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 1);
		tp.getBillingaddState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Billing Department State text field accpeted input");
	}

}
