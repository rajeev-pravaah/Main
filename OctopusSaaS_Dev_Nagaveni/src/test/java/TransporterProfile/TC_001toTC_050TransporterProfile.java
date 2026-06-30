package TransporterProfile;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class TC_001toTC_050TransporterProfile extends BaseclassForSignUpPage{
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
	public void TC_007CompanynameTextFieldwithAlphabets() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CompanyNameTextField();
		String input = elib.getDataFromExcel("TransporterProfile", 1, 2);
		tp.getCompanynametxtfield().clear();
		tp.getCompanynametxtfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company name text field accepts Alphabets");
	}

	
	@Test(dependsOnMethods = "TC_007CompanynameTextFieldwithAlphabets")
	public void TC_008CompanynameTextFieldwithNumbers() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CompanyNameTextField();
		String input = elib.getDataFromExcel("TransporterProfile", 1, 3);
		tp.getCompanynametxtfield().clear();
		tp.getCompanynametxtfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company name text field accepts Numbers");
	}

	@Test(dependsOnMethods = "TC_008CompanynameTextFieldwithNumbers")
	public void TC_009CompanynameTextFieldwithSpecialCharater() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		tp = new TransporterProfile(driver);
		tp.CompanyNameTextField();
		String input = elib.getDataFromExcel("TransporterProfile", 1, 4);
		tp.getCompanynametxtfield().clear();
		tp.getCompanynametxtfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company name text field accepts Special characters");
	}

	
	@Test(dependsOnMethods = "TC_009CompanynameTextFieldwithSpecialCharater")
	public void TC_010CompanynameTextFieldwithoutData() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CompanyNameTextField();
		tp.getCompanynametxtfield().clear();
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO,
				"Company name text field withot data -user should not able to proceed further");
	}

	@Test(dependsOnMethods = "TC_010CompanynameTextFieldwithoutData")
	public void TC_011CompanyNameAutoSave() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CompanyNameTextField();
		String input = elib.getDataFromExcel("TransporterProfile", 1, 1);
		tp.getCompanynametxtfield().clear();
		tp.getCompanynametxtfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company name Autosaved successfully");
		tp.getClickOnOtherside().click();
	}

	@Test(dependsOnMethods = "TC_011CompanyNameAutoSave")
	public void TC_012CompanyDisplayNamewithinput() throws EncryptedDocumentException, IOException {
		tp.getCcompanydisplayname().click();
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel");
		String input = elib.getDataFromExcel("TransporterProfile", 4, 1);
		tp.getCcompanydisplayname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company displayname text field accepted input ");

	}

	@Test(dependsOnMethods = "TC_012CompanyDisplayNamewithinput")
	public void TC_013CompanyDisplayNamewithAplhabets()
			throws EncryptedDocumentException, IOException, InterruptedException {
		tp.getCcompanydisplayname().click();
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel");
		String input = elib.getDataFromExcel("TransporterProfile", 4, 2);
		tp.getCcompanydisplayname().clear();
		Thread.sleep(3000);
		tp.getCcompanydisplayname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,
				"Company displayname text field accepted Alphabets Successfully ");

	}

	@Test(dependsOnMethods = "TC_013CompanyDisplayNamewithAplhabets")
	public void TC_014CompanyDisplayNamewithNumbers()
			throws EncryptedDocumentException, IOException, InterruptedException {
		tp.getCcompanydisplayname().click();
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel");
		String input = elib.getDataFromExcel("TransporterProfile", 4, 3);
		tp.getCcompanydisplayname().clear();
		Thread.sleep(3000);
		tp.getCcompanydisplayname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company displayname text field accepted Numbers Successfully ");

	}

	@Test(dependsOnMethods = "TC_014CompanyDisplayNamewithNumbers")
	public void TC_015CompanyDisplayNamewithSpecialCharter()
			throws EncryptedDocumentException, IOException, InterruptedException {
		tp.getCcompanydisplayname().click();
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel");
		String input = elib.getDataFromExcel("TransporterProfile", 4, 4);
		tp.getCcompanydisplayname().clear();
		Thread.sleep(3000);
		tp.getCcompanydisplayname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO,
				"Company displayname text field accepted Special character Successfully ");

	}

	@Test(dependsOnMethods = "TC_015CompanyDisplayNamewithSpecialCharter")
	public void TC_016CompanyDisplayNamewithoutIput() throws EncryptedDocumentException, IOException {
		tp.getCcompanydisplayname().click();
		tp.getCcompanydisplayname().clear();
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO,
				"Company display name text field withot data -user should not able to proceed further");

	}

	@Test(dependsOnMethods = "TC_016CompanyDisplayNamewithoutIput")
	public void TC_017CompanyDisplayNameAutoSave()
			throws EncryptedDocumentException, IOException, InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		tp.getCcompanydisplayname().click();
		Thread.sleep(3000);
		String input = elib.getDataFromExcel("TransporterProfile", 4, 1);
		tp.getCcompanydisplayname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Company display name Autosaved successfully");
		tp.getClickOnOtherside().click();
	}

	@Test(dependsOnMethods = "TC_017CompanyDisplayNameAutoSave")
	public void TC_018GenralPhonewithInput() throws EncryptedDocumentException, IOException, InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 7, 1);
		tp.GeneralPhoneNumberWithInput(input);
		utilityclassobject.gettest().log(Status.INFO, "general phone number accepts valid input successfully");
		System.out.println("general phone accept Input successfully");
		Thread.sleep(3000);
		// tp.getPhonenumber().click();

		tp.getPhonenumber().sendKeys(Keys.CONTROL + "a");
		tp.getPhonenumber().sendKeys(Keys.DELETE);

		// tp.getPhonenumber().clear();
	}

	@Test(dependsOnMethods = "TC_018GenralPhonewithInput")
	public void TC_019GenralPhonewithalphabets() throws EncryptedDocumentException, IOException, InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 7, 2);
		tp.GeneralPhoneWithAlphbets(input);
		utilityclassobject.gettest().log(Status.INFO, "General phone should not accept alphabets");
		System.out.println("general phone Should not accept Alphabtes successfully");
		Thread.sleep(3000);
		tp.getPhonenumber().sendKeys(Keys.CONTROL + "a");
		tp.getPhonenumber().sendKeys(Keys.DELETE);

	}

	@Test(dependsOnMethods = "TC_019GenralPhonewithalphabets")
	public void TC_020GenralPhonewithNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 7, 3);
		tp.GeneralPhoneWithAlphbets(input);
		utilityclassobject.gettest().log(Status.INFO, "general phone number should accept numbers");
		System.out.println("general phone Should accept Alphabtes Numbers");
		Thread.sleep(3000);
		tp.getPhonenumber().sendKeys(Keys.CONTROL + "a");
		tp.getPhonenumber().sendKeys(Keys.DELETE);

	}

	@Test(dependsOnMethods = "TC_020GenralPhonewithNumbers")
	public void TC_021GenralPhonewithSpecialCharacter()
			throws EncryptedDocumentException, IOException, InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 7, 4);
		tp.GeneralPhoneWithAlphbets(input);
		utilityclassobject.gettest().log(Status.INFO, "general phone number should not accept special characters");
		System.out.println("general phone Should not accept special charatcter");
		Thread.sleep(3000);
		tp.getPhonenumber().sendKeys(Keys.CONTROL + "a");
		tp.getPhonenumber().sendKeys(Keys.DELETE);

	}

	@Test(dependsOnMethods = "TC_021GenralPhonewithSpecialCharacter")
	public void TC_022GenralPhonewithoutInput() throws EncryptedDocumentException, IOException, InterruptedException {
		utilityclassobject.gettest().log(Status.INFO,
				"general phone number should not accept empty text field It should mandatory");
		System.out.println("general phone Should not accept empty");
		tp.SubmitBtn();
	}

	@Test(dependsOnMethods = "TC_022GenralPhonewithoutInput")
	public void TC_023GenralPhonewithNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 7, 3);
		tp.GeneralPhoneWithAlphbets(input);
		utilityclassobject.gettest().log(Status.INFO,
				"general phone number should accept numbers and autosave successfully");
		System.out.println("general phone Should accept Alphabtes Numbers and auto saves");
	}

	@Test(dependsOnMethods = "TC_023GenralPhonewithNumbers")
	public void TC_024GeneralMailwithInput() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 10, 1);
		Random random1 = new Random();
		int number1 = 100 + random1.nextInt(900); // generates 3-digit number
		String email = input + number1 + "@gmail.com";
		System.out.println(email);
		tp.GeneralEmailwithInput(email);
		String txt = tp.getGeneralEmail().getText();	
		Assert.assertTrue(email.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "General Email accepts valid email id ");

	}

	@Test(dependsOnMethods = "TC_024GeneralMailwithInput")
	public void TC_025GeneralMailwithAlphabets() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 10, 2);
		tp.getGeneralEmail().click();
		tp.getGeneralEmail().sendKeys(Keys.CONTROL + "a");
		tp.getGeneralEmail().sendKeys(Keys.DELETE);
		tp.GeneralEmailwithAlphabets(input);
		String txt = tp.getGeneralEmail().getText();
		Assert.assertTrue(input.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "General Email accepts alphabets ");

	}
	@Test(dependsOnMethods = "TC_025GeneralMailwithAlphabets")
	public void TC_026GeneralMailwithNumbers() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 10, 3);
		tp.getGeneralEmail().click();
		tp.getGeneralEmail().sendKeys(Keys.CONTROL + "a");
		tp.getGeneralEmail().sendKeys(Keys.DELETE);
		tp.GeneralEmailwithAlphabets(input);
		String txt = tp.getGeneralEmail().getText();
		Assert.assertTrue(input.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "General Email accepts numbers ");

	}

	@Test(dependsOnMethods = "TC_026GeneralMailwithNumbers")
	public void TC_027GeneralMailwithSpecialChar() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 10, 4);
		tp.getGeneralEmail().click();
		tp.getGeneralEmail().sendKeys(Keys.CONTROL + "a");
		tp.getGeneralEmail().sendKeys(Keys.DELETE);
		tp.GeneralEmailwithAlphabets(input);
		String txt = tp.getGeneralEmail().getText();
		Assert.assertTrue(input.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "General Email accepts Special character ");
	}

	@Test(dependsOnMethods = "TC_027GeneralMailwithSpecialChar")
	public void TC_028GeneralMailwithoutInput() throws EncryptedDocumentException, IOException {

		tp.getGeneralEmail().click();
		tp.getGeneralEmail().sendKeys(Keys.CONTROL + "a");
		tp.getGeneralEmail().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "General Email should not proceed further");
	}
	@Test(dependsOnMethods = "TC_028GeneralMailwithoutInput")
	public void TC_029GeneralMailwithValidInput() throws EncryptedDocumentException, IOException {
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 10, 1);
		Random random1 = new Random();
		int number1 = 100 + random1.nextInt(900); // generates 3-digit number
		String email = input + number1 + "@gmail.com";
		System.out.println(email);
		tp.GeneralEmailwithInput(email);
		String txt = tp.getGeneralEmail().getText();
		Assert.assertTrue(email.contains(txt));
		tp.getClickOnOtherside();
		utilityclassobject.gettest().log(Status.INFO, "General Email accepts valid email id ");
	}
	@Test(dependsOnMethods = "TC_029GeneralMailwithValidInput")
	public void TC_030WebsiteUrlwithValidInput() throws EncryptedDocumentException, IOException
	{
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 13, 1);
		tp.WebSiteURLwithValiInput(input);
		String txt = tp.getWebsiteUrl().getText();
		Assert.assertTrue(input.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "Website Url accepts valid input ");
	}
	@Test(dependsOnMethods = "TC_030WebsiteUrlwithValidInput")
	public void TC_031WebsiteUrlwithAlphabets() throws EncryptedDocumentException, IOException
	{
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 13, 2);
		tp.getWebsiteUrl().click();
		tp.getWebsiteUrl().sendKeys(Keys.CONTROL + "a");
		tp.getWebsiteUrl().sendKeys(Keys.DELETE);
		tp.WebSiteURLwithValiInput(input);
		String txt = tp.getWebsiteUrl().getText();
		Assert.assertTrue(input.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "Website Url accepts alphabets ");
	}
	@Test(dependsOnMethods = "TC_031WebsiteUrlwithAlphabets")
	public void TC_032WebsiteUrlwithNumbers() throws EncryptedDocumentException, IOException
	{
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 13, 3);
		tp.getWebsiteUrl().click();
		tp.getWebsiteUrl().sendKeys(Keys.CONTROL + "a");
		tp.getWebsiteUrl().sendKeys(Keys.DELETE);
		tp.WebSiteURLwithValiInput(input);
		String txt = tp.getWebsiteUrl().getText();
		Assert.assertTrue(input.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "Website Url accepts Numbers ");
	}
	@Test(dependsOnMethods = "TC_032WebsiteUrlwithNumbers")
	public void TC_033WebsiteUrlwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		utilityclassobject.gettest().log(Status.INFO, "Reading data from excel ");
		String input = elib.getDataFromExcel("TransporterProfile", 13, 4);
		tp.getWebsiteUrl().click();
		tp.getWebsiteUrl().sendKeys(Keys.CONTROL + "a");
		tp.getWebsiteUrl().sendKeys(Keys.DELETE);
		tp.WebSiteURLwithValiInput(input);
		String txt = tp.getWebsiteUrl().getText();
		Assert.assertTrue(input.contains(txt));
		utilityclassobject.gettest().log(Status.INFO, "Website Url accepts Special characters ");
	}
	@Test(dependsOnMethods = "TC_033WebsiteUrlwithSpecialcharacters")
	public void TC_034WebsiteUrlwithoutInput() throws EncryptedDocumentException, IOException
	{
		tp.getWebsiteUrl().click();
		tp.getWebsiteUrl().sendKeys(Keys.CONTROL + "a");
		tp.getWebsiteUrl().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "without Website Url user can able to proceed  ");
	}
	@Test(dependsOnMethods = "TC_034WebsiteUrlwithoutInput")
	public void TC_035WebsiteUrlwithInvalidFormat() throws EncryptedDocumentException, IOException
	{
		tp.getWebsiteUrl().click();
		String input = elib.getDataFromExcel("TransporterProfile", 13, 5);
		System.out.println(input);
		tp.getWebsiteUrl().sendKeys(input);
		String urlerror = driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid URL.')]")).getText();
		System.out.println(urlerror);
	    Assert.assertEquals(urlerror,"Please enter a valid URL.");
		Assert.assertTrue(urlerror.contains("Please enter a valid URL."));
		utilityclassobject.gettest().log(Status.INFO, "Invilid Website Url should not accept  ");
		utilityclassobject.gettest().log(Status.INFO, "Error message verified successfully");
	}
	@Test(dependsOnMethods = "TC_035WebsiteUrlwithInvalidFormat")
    public void TC_036WebsiteurlRedirect() throws EncryptedDocumentException, IOException, InterruptedException
    {
		tp.getWebsiteUrl().click();
		tp.getWebsiteUrl().sendKeys(Keys.CONTROL + "a");
		tp.getWebsiteUrl().sendKeys(Keys.DELETE);
		tp.getWebsiteUrl().click();
		String input = elib.getDataFromExcel("TransporterProfile", 13, 6);
		System.out.println(input);
		tp.getWebsiteUrl().sendKeys(input);
		tp.getRedirectUrl().click();
		// Step 1: Store parent window
		String parentWindow = driver.getWindowHandle();
		// Click (opens new tab)
		tp.getRedirectUrl().click();
		// Step 2: Get all windows
		//set<String> allWindows = driver.getWindowHandles();
		Set<String> allwindows = driver.getWindowHandles();
		utilityclassobject.gettest().log(Status.INFO, "sswitch to new tab");
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
    }
	@Test(dependsOnMethods = "TC_036WebsiteurlRedirect")
    public void TC_037Websiteurlautosave() throws EncryptedDocumentException, IOException
    {
		tp.getWebsiteUrl().click();
		String input = elib.getDataFromExcel("TransporterProfile", 13, 6);
		System.out.println(input);
		tp.getWebsiteUrl().sendKeys(input);
		tp.getClickOnOtherside();
		utilityclassobject.gettest().log(Status.INFO, "website url autosaved");
    }
	
	@Test(dependsOnMethods = "TC_037Websiteurlautosave")
    public void TC_038StartOfFacialYearByManualenter() throws EncryptedDocumentException, IOException
    {
		//tp.getStartfacialyear().click();
		//String input = elib.getDataFromExcel("TransporterProfile", 16, 1);
		//System.out.println(input);
		//tp.getStartfacialyear().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Should not accept");
    }
	@Test(dependsOnMethods = "TC_038StartOfFacialYearByManualenter")
	public void TC_039StartOfFacialYearfromCalendar() throws InterruptedException
	{
		// Click date input first
		//tp.getStartfacialyear().click();
		Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@data-testid='custom-date-picker']")).click();
  		utilityclassobject.gettest().log(Status.INFO, "Enter current date");
		Thread.sleep(2000);
         driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--today')]")).click();
 		utilityclassobject.gettest().log(Status.INFO, "Should accept date from calendar");

		
	}
	@Test(dependsOnMethods = "TC_039StartOfFacialYearfromCalendar")
	public void TC_040StartOfFacialYearAutosave() throws InterruptedException
	{
		// Click date input first
		//tp.getStartfacialyear().click();
         //driver.findElement(By.xpath("//div[@data-testid='custom-date-picker']")).click();
		Thread.sleep(2000);
		tp.getDatePicker().click();
   		utilityclassobject.gettest().log(Status.INFO, "Enter current date");
   		Thread.sleep(2000);
         driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--today')]")).click();
 		utilityclassobject.gettest().log(Status.INFO, "Start of fiscal year text field autosaved successfully");
	}
	@Test(dependsOnMethods = "TC_040StartOfFacialYearAutosave")
	public void TC_041GoogleReviewLinkwithValidInput() throws EncryptedDocumentException, IOException
	{
		tp.getGoogleReviewLink().click();
		String GvalidInput = elib.getDataFromExcel("TransporterProfile", 19, 1);
		tp.GoogleReviewLink(GvalidInput);
 		utilityclassobject.gettest().log(Status.INFO, "Google review link text field accepted valid url link");
	}
	@Test(dependsOnMethods = "TC_041GoogleReviewLinkwithValidInput")
	public void TC_042GoogleReviewLinkwithAlphabets() throws EncryptedDocumentException, IOException
	{
 		tp.getGoogleReviewLink().sendKeys(Keys.CONTROL + "a");
		tp.getGoogleReviewLink().sendKeys(Keys.DELETE);
		String Galphabets = elib.getDataFromExcel("TransporterProfile", 19, 2);
		tp.GoogleReviewLink(Galphabets);
		//String errormsg = driver.findElement(By.xpath("//p[contains(text(),'Please enter a valid URL')]")).getText();
		//System.out.println(errormsg);
 		utilityclassobject.gettest().log(Status.INFO, "Google review link text field not accepted only  alphabets");

		
	}
	@Test(dependsOnMethods = "TC_042GoogleReviewLinkwithAlphabets")
	public void TC_043GoogleReviewLinkwithNumbers() throws EncryptedDocumentException, IOException
	{
		tp.getGoogleReviewLink().sendKeys(Keys.CONTROL + "a");
		tp.getGoogleReviewLink().sendKeys(Keys.DELETE);
		String Gnum = elib.getDataFromExcel("TransporterProfile", 19, 3);
		tp.GoogleReviewLink(Gnum);
 		utilityclassobject.gettest().log(Status.INFO, "Google review link text field not accepted only numbers");

		
	}
	@Test(dependsOnMethods = "TC_043GoogleReviewLinkwithNumbers")
	public void TC_044GoogleReviewLinkwithSpecialCharacters() throws EncryptedDocumentException, IOException
	{
		tp.getGoogleReviewLink().sendKeys(Keys.CONTROL + "a");
		tp.getGoogleReviewLink().sendKeys(Keys.DELETE);
		String GSpec = elib.getDataFromExcel("TransporterProfile", 19, 4);
		tp.GoogleReviewLink(GSpec);
 		utilityclassobject.gettest().log(Status.INFO, "Google review link text field not accepted only Special characters");
	
	}
	@Test(dependsOnMethods = "TC_044GoogleReviewLinkwithSpecialCharacters")
	public void TC_045GoogleReviewLinkwithSpecialCharacters() throws EncryptedDocumentException, IOException
	{
		tp.getGoogleReviewLink().sendKeys(Keys.CONTROL + "a");
		tp.getGoogleReviewLink().sendKeys(Keys.DELETE);
		String GSpec = elib.getDataFromExcel("TransporterProfile", 19, 4);
		tp.GoogleReviewLink(GSpec);
 		utilityclassobject.gettest().log(Status.INFO, "Google review link text field not accepted only Special characters");
	
	}
	@Test(dependsOnMethods = "TC_045GoogleReviewLinkwithSpecialCharacters")
	public void TC_046GoogleReviewLinkwithInvaliddata() throws EncryptedDocumentException, IOException, InterruptedException
	{
		tp.getGoogleReviewLink().sendKeys(Keys.CONTROL + "a");
		tp.getGoogleReviewLink().sendKeys(Keys.DELETE);
		String GInvalid = elib.getDataFromExcel("TransporterProfile", 19, 5);
		tp.GoogleReviewLink(GInvalid);
		Thread.sleep(2000);
		//String gerrortxt = driver.findElement(By.xpath("//p[contains(text(),'Please enter a valid URL')]")).getText();
		//System.out.println(gerrortxt);
		//Assert.assertTrue(gerrortxt.contains("Please enter a valid URL"));
		utilityclassobject.gettest().log(Status.INFO, "Google review link text field not accept invalid format og link");
	
	}
	/*
	@Test(dependsOnMethods = "TC_046GoogleReviewLinkwithInvaliddata")
	public void TC_047GoogleReviewLinkwithValidFormat() throws EncryptedDocumentException, IOException
	{
		tp.getGoogleReviewLink().sendKeys(Keys.CONTROL + "a");
		tp.getGoogleReviewLink().sendKeys(Keys.DELETE);
		tp.getGoogleReviewLink().click();
		String GvalidInput = elib.getDataFromExcel("TransporterProfile", 19, 1);
		tp.GoogleReviewLink(GvalidInput);
 		utilityclassobject.gettest().log(Status.INFO, "Google review link text field accepted valid url link");
	}*/
}
