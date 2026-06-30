package TransporterProfile;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

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

public class SignUpTransporterpage extends BaseclassForSignUpPage {
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
	@Test(dependsOnMethods = "TC_046GoogleReviewLinkwithInvaliddata")
	public void TC_047GoogleReviewLinkwithValidFormat() throws EncryptedDocumentException, IOException
	{
		tp.getGoogleReviewLink().sendKeys(Keys.CONTROL + "a");
		tp.getGoogleReviewLink().sendKeys(Keys.DELETE);
		tp.getGoogleReviewLink().click();
		String GvalidInput = elib.getDataFromExcel("TransporterProfile", 19, 1);
		tp.GoogleReviewLink(GvalidInput);
 		utilityclassobject.gettest().log(Status.INFO, "Google review link text field accepted valid url link");
	}
	
	/*@Test(dependsOnMethods = "TC_047GoogleReviewLinkwithValidFormat")
	public void TC_048Company_logoUpload() throws InterruptedException
	{
		/*WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));

		upload.sendKeys("C:\\Users\\Rajeev\\Octopussaas_main_Framework\\Files_upload\\Download-Free-Pictures-3840x2160.jpg");
		
		//WebElement upload = driver.findElement(By.xpath("(//*[local-name()='svg' and contains(@class,'text-cardTextGray')])[1]"));
		System.out.println("HIjhghj");
		//tp.getUploadfile().click();
		System.out.println("bjhwvdfwjh");
		Thread .sleep(2000);
		tp.getUploadfile().sendKeys("./Files_upload/Download-Free-Pictures-3840x2160.jpg");
		}*/
	
	
	//Nagaveni 
	@Test(dependsOnMethods = "TC_047GoogleReviewLinkwithValidFormat")
	public void TC_57RegistrationNumber1_Textwithinput()
	{
		tp = new TransporterProfile(driver);
		tp.getRegistrationNumber1().sendKeys("1247526538");
 		utilityclassobject.gettest().log(Status.INFO, "Registration Number1 text Field accepted valid input");

	}
	
	@Test(dependsOnMethods = "TC_57RegistrationNumber1_Textwithinput")
	public void TC_58RegistrationNumber1_Textwithalphabets()
	{

		tp.getRegistrationNumber1().click();
		tp.getRegistrationNumber1().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber1().sendKeys(Keys.DELETE);
		tp.getRegistrationNumber1().sendKeys("adahganbha");
 		utilityclassobject.gettest().log(Status.INFO, "Registration Number1 text Field accepted alphabets");
}
	
	@Test(dependsOnMethods = "TC_58RegistrationNumber1_Textwithalphabets")
	public void TC_59RegistrationNumber1_Textwithnumbers()
	{
		tp.getRegistrationNumber1().click();
		tp.getRegistrationNumber1().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber1().sendKeys(Keys.DELETE);
		tp.getRegistrationNumber1().sendKeys("12361531");
 		utilityclassobject.gettest().log(Status.INFO, "Registration Number1 text Field accepted numbers");
}
	
	@Test(dependsOnMethods = "TC_59RegistrationNumber1_Textwithnumbers")
	public void TC_60RegistrationNumber1_TextwithspecialCharacters()
	{
		tp.getRegistrationNumber1().click();
		tp.getRegistrationNumber1().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber1().sendKeys(Keys.DELETE);
		tp.getRegistrationNumber1().sendKeys("!@#$@$");
		utilityclassobject.gettest().log(Status.INFO, "Registration Number1 text Field accepted SpecialCharacters");
	}
	
	@Test(dependsOnMethods = "TC_60RegistrationNumber1_TextwithspecialCharacters")
	public void TC_61RegistrationNumber1_Textwithoutproviding()
	{
		tp.getRegistrationNumber1().click();
		tp.getRegistrationNumber1().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber1().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getRegistrationNumber1Ermsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Registration Number1 text without input displyed error message");

	}
	
	@Test(dependsOnMethods = "TC_61RegistrationNumber1_Textwithoutproviding" ) 
	public void TC_62RegistrationNumber1_TextwithAutosave()
	{
		tp.getRegistrationNumber1().click();
		tp.getRegistrationNumber1().sendKeys("1247526538");
		utilityclassobject.gettest().log(Status.INFO, "Registration Number1 text Field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_62RegistrationNumber1_TextwithAutosave")
	public void TC_63RegistrationNumber2_Textwithinput()
	{
		tp.getRegistrationNumber2().sendKeys("182718484");
		utilityclassobject.gettest().log(Status.INFO, "Registration Number2  text Field accepted valid input");
	}
	
	@Test(dependsOnMethods = "TC_63RegistrationNumber2_Textwithinput")
	public void TC_64RegistrationNumber2_Textwithalphabets()
	{
		tp.getRegistrationNumber2().click();
		tp.getRegistrationNumber2().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber2().sendKeys(Keys.DELETE);
		tp.getRegistrationNumber2().sendKeys("adkahwihf");
		utilityclassobject.gettest().log(Status.INFO, "Registration Number2  text Field accepted alphabets");
}
	@Test(dependsOnMethods = "TC_64RegistrationNumber2_Textwithalphabets" )
	public void TC_65RegistrationNumber2_TextWithnumbers()
	{
		tp.getRegistrationNumber2().click();
		tp.getRegistrationNumber2().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber2().sendKeys(Keys.DELETE);
		tp.getRegistrationNumber2().sendKeys("174198468");
		utilityclassobject.gettest().log(Status.INFO, "Registration Number2  text Field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_65RegistrationNumber2_TextWithnumbers")
	public void TC_66RegistrationNumber2_TextwithSpecialcharacters()
	{
		tp.getRegistrationNumber2().click();
		tp.getRegistrationNumber2().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber2().sendKeys(Keys.DELETE);
		tp.getRegistrationNumber2().sendKeys("!@@$%$%@");
		utilityclassobject.gettest().log(Status.INFO, "Registration Number2  text Field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_66RegistrationNumber2_TextwithSpecialcharacters" )
	public void TC_67RegistrationNumber2_Textwithoutinput()
	{
		tp.getRegistrationNumber2().click();
		tp.getRegistrationNumber2().sendKeys(Keys.CONTROL + "a");
		tp.getRegistrationNumber2().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "Registration Number2 text Field without input error message is not displayed(not mandatory field)");
	}
	
	@Test(dependsOnMethods = "TC_67RegistrationNumber2_Textwithoutinput")
	public void TC_68RegistrationNumber2_TextwithAutosave()
	{
		tp.getRegistrationNumber2().click();
		tp.getRegistrationNumber2().sendKeys("182718484");
		utilityclassobject.gettest().log(Status.INFO, "Registration Number2  text Field acceptedinput and autosaved");
	
	}
	
	@Test(dependsOnMethods = "TC_68RegistrationNumber2_TextwithAutosave")
	public void TC_69EPAIDNumber_Textwithinput()
	{
		tp.getEpaIDNumber().sendKeys("13871489174");
		utilityclassobject.gettest().log(Status.INFO, "EPAID number text Field accepted valid input");

	}
	
	@Test(dependsOnMethods = "TC_69EPAIDNumber_Textwithinput")
	public void TC_70EPAIDNumber_Textwithalphabets()
	{
		tp.getEpaIDNumber().click();
		tp.getEpaIDNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEpaIDNumber().sendKeys(Keys.DELETE);
		tp.getEpaIDNumber().sendKeys("aghfaugaj");
		utilityclassobject.gettest().log(Status.INFO, "EPAID number text Field accepted valid alphabets");
	}
	
	@Test(dependsOnMethods = "TC_70EPAIDNumber_Textwithalphabets")
	public void TC_71EPAIDNumber_Textwithnumbers()
	{
		tp.getEpaIDNumber().click();
		tp.getEpaIDNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEpaIDNumber().sendKeys(Keys.DELETE);
		tp.getEpaIDNumber().sendKeys("1431874184");
		utilityclassobject.gettest().log(Status.INFO, "EPAID number text Field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_71EPAIDNumber_Textwithnumbers")
	public void TC_72EPAIDNumber_Textwithspecialcharacters()
	{
		tp.getEpaIDNumber().click();
		tp.getEpaIDNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEpaIDNumber().sendKeys(Keys.DELETE);
		tp.getEpaIDNumber().sendKeys("1431874184");
		utilityclassobject.gettest().log(Status.INFO, "EPAID number text Field accepted specailcharacters");
	}
	
	@Test(dependsOnMethods = "TC_72EPAIDNumber_Textwithspecialcharacters")
	public void TC_73EPAIDNumber_Textwithoutinput()
	{
		tp.getEpaIDNumber().click();
		tp.getEpaIDNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEpaIDNumber().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "EPAID number text Field without input error message is not displayed(not mandatory field)");
	}
	
	@Test(dependsOnMethods = "TC_73EPAIDNumber_Textwithoutinput")
	public void TC_74EPAIDNumber_TextwithAutosave()
	{
		tp.getEpaIDNumber().click();
		tp.getEpaIDNumber().sendKeys("13871489174");
		utilityclassobject.gettest().log(Status.INFO, "EPAID number text Field accepted input and austosaved");
	}
	
	@Test(dependsOnMethods = "TC_74EPAIDNumber_TextwithAutosave")
	public void TC_75dotNumber_TextwithInput()
	{
		tp.getDotNumber().sendKeys("193871847");
		utilityclassobject.gettest().log(Status.INFO, "DOT number text Field accepted valid input");

	}
	
	@Test(dependsOnMethods = "TC_75dotNumber_TextwithInput")
	public void TC_76dotNumber_Textwithalphabets()
	{
		tp.getDotNumber().click();
		tp.getDotNumber().sendKeys(Keys.CONTROL + "a");
		tp.getDotNumber().sendKeys(Keys.DELETE);
		tp.getDotNumber().sendKeys("akjhfuahf");
		utilityclassobject.gettest().log(Status.INFO, "DOT number text Field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_76dotNumber_Textwithalphabets")
	public void TC_77dotNumber_TextwithNumbers()
	{
		tp.getDotNumber().click();
		tp.getDotNumber().sendKeys(Keys.CONTROL + "a");
		tp.getDotNumber().sendKeys(Keys.DELETE);
		tp.getDotNumber().sendKeys("137198371");
		utilityclassobject.gettest().log(Status.INFO, "DOT number text Field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_77dotNumber_TextwithNumbers")
	public void TC_78dotNumber_TextwithSpecialcharacters()
	{
		tp.getDotNumber().click();
		tp.getDotNumber().sendKeys(Keys.CONTROL + "a");
		tp.getDotNumber().sendKeys(Keys.DELETE);
		tp.getDotNumber().sendKeys("!@#$%^&");
		utilityclassobject.gettest().log(Status.INFO, "DOT number text Field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_78dotNumber_TextwithSpecialcharacters")
	public void TC_79dotNumber_TextwithoutInput()
	{
		tp.getDotNumber().click();
		tp.getDotNumber().sendKeys(Keys.CONTROL + "a");
		tp.getDotNumber().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "DOT number text Field without input error message is not displayed(not mandatory field)");	
	}
	
	@Test(dependsOnMethods = "TC_79dotNumber_TextwithoutInput")
	public void TC_80dotNumber_TextwithAutosave()
	{
		tp.getDotNumber().click();
		tp.getDotNumber().sendKeys("193871847");
		utilityclassobject.gettest().log(Status.INFO, "DOT number text Field accepted valid input and autosaved");
		}
	
	@Test(dependsOnMethods = "TC_80dotNumber_TextwithAutosave")
	public void TC_81EIN_TextwithInput()
	{
		tp.getEinNumber().sendKeys("adbe12#@");
		utilityclassobject.gettest().log(Status.INFO, "EIN text Field accepted valid input");
	}
	
	@Test(dependsOnMethods = "TC_81EIN_TextwithInput")
	public void TC_82EIN_Textwithalphabets()
	{
		tp.getEinNumber().click();
		tp.getEinNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEinNumber().sendKeys(Keys.DELETE);
		tp.getEinNumber().sendKeys("ahaubae");
		utilityclassobject.gettest().log(Status.INFO, "EIN text Field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_82EIN_Textwithalphabets")
	public void TC_83EIN_Textwithnumbers()
	{
		tp.getEinNumber().click();
		tp.getEinNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEinNumber().sendKeys(Keys.DELETE);
		tp.getEinNumber().sendKeys("131981984");
		utilityclassobject.gettest().log(Status.INFO, "EIN text Field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_83EIN_Textwithnumbers")
	public void TC_84EIN_TextwithSpecialcharacters()
	{
		tp.getEinNumber().click();
		tp.getEinNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEinNumber().sendKeys(Keys.DELETE);
		tp.getEinNumber().sendKeys("!@#$@%%@");
		utilityclassobject.gettest().log(Status.INFO, "EIN text Field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_84EIN_TextwithSpecialcharacters")
	public void TC_85EIN_TextwithoutInput()
	{
		tp.getEinNumber().click();
		tp.getEinNumber().sendKeys(Keys.CONTROL + "a");
		tp.getEinNumber().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "EIN text Field without input error message is not displayed (not mandatory field");
	}
	
	@Test(dependsOnMethods = "TC_85EIN_TextwithoutInput")
	public void TC_86EIN_TextwithAutosave()
	{
		tp.getEinNumber().click();
		tp.getEinNumber().sendKeys("1731864");
		utilityclassobject.gettest().log(Status.INFO, "EIN text Field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_86EIN_TextwithAutosave")
	public void TC_87EntityId_TextwithInput()
	{
		tp.getEntityId().click();
		tp.getEntityId().sendKeys("1918918");
		utilityclassobject.gettest().log(Status.INFO, "Entity ID number text Field accepted valid input");
	}
	
	@Test(dependsOnMethods = "TC_87EntityId_TextwithInput")
	public void TC_88EntityId_Textwithalphabets()
	{
		tp.getEntityId().click();
		tp.getEntityId().sendKeys(Keys.CONTROL + "a");
		tp.getEntityId().sendKeys(Keys.DELETE);
		tp.getEntityId().sendKeys("jfajbfn");
		utilityclassobject.gettest().log(Status.INFO, "Entity ID number text Field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_88EntityId_Textwithalphabets")
	public void TC_89EntityId_TextwithNumbers()
	{
		tp.getEntityId().click();
		tp.getEntityId().sendKeys(Keys.CONTROL + "a");
		tp.getEntityId().sendKeys(Keys.DELETE);
		tp.getEntityId().sendKeys("19831974");
		utilityclassobject.gettest().log(Status.INFO, "Entity ID number text Field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_89EntityId_TextwithNumbers")
	public void TC_90EntityID_Textwithspecialcharacters()
	{
		tp.getEntityId().click();
		tp.getEntityId().sendKeys(Keys.CONTROL + "a");
		tp.getEntityId().sendKeys(Keys.DELETE);
		tp.getEntityId().sendKeys("!@!$@^#^");
		utilityclassobject.gettest().log(Status.INFO, "Entity ID number text Field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_90EntityID_Textwithspecialcharacters")
	public void TC_91EntityID_TextwithoutInput()
	{
		tp.getEntityId().click();
		tp.getEntityId().sendKeys(Keys.CONTROL + "a");
		tp.getEntityId().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "Entity ID number text field without input error message is not displayed(not mandatory field)");
	}
	
	@Test(dependsOnMethods = "TC_91EntityID_TextwithoutInput")
	public void TC_92EntityID_TextwithAutosave()
	{
		tp.getEntityId().click();
		tp.getEntityId().sendKeys("1391497");
		utilityclassobject.gettest().log(Status.INFO, "Entity ID number text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_92EntityID_TextwithAutosave")
	public void TC_93SosCode_TextwithInput()
	{
		tp.getSosCode().click();
		tp.getSosCode().sendKeys("1391497");
		utilityclassobject.gettest().log(Status.INFO, "SOS code text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_93SosCode_TextwithInput")
	public void TC_94SosCode_Texteithalphabets()
	{
		tp.getSosCode().click();
		tp.getSosCode().sendKeys(Keys.CONTROL + "a");
		tp.getSosCode().sendKeys(Keys.DELETE);
		tp.getSosCode().sendKeys("ajdabcnab");
		utilityclassobject.gettest().log(Status.INFO, "SOS code text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_94SosCode_Texteithalphabets")
	public void TC_95SosCode_TextwithNumbers()
	{
		tp.getSosCode().click();
		tp.getSosCode().sendKeys(Keys.CONTROL + "a");
		tp.getSosCode().sendKeys(Keys.DELETE);
		tp.getSosCode().sendKeys("76476434");
		utilityclassobject.gettest().log(Status.INFO, "SOS code text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_95SosCode_TextwithNumbers")
	public void TC_96SosCode_Textwithspecialcharacters()
	{
		tp.getSosCode().click();
		tp.getSosCode().sendKeys(Keys.CONTROL + "a");
		tp.getSosCode().sendKeys(Keys.DELETE);
		tp.getSosCode().sendKeys("!#@!$@%");
		utilityclassobject.gettest().log(Status.INFO, "SOS code text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_96SosCode_Textwithspecialcharacters")
	public void TC_97SosCode_TextwithoutInput()
	{
		tp.getSosCode().click();
		tp.getSosCode().sendKeys(Keys.CONTROL + "a");
		tp.getSosCode().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "SOS code text field without input error message is not displayed(not mandatory field)");
	}
	
	@Test(dependsOnMethods = "TC_97SosCode_TextwithoutInput")
	public void TC_98SosCode_TextwithAutosave()
	{
		tp.getSosCode().click();
		tp.getSosCode().sendKeys("Vdskj@327");
		utilityclassobject.gettest().log(Status.INFO, "SOS code text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_98SosCode_TextwithAutosave")
	public void TC_99SicCode_TextwithInput()
	{
		tp.getSicCode().click();
		tp.getSicCode().sendKeys("187@$fadhg");
		utilityclassobject.gettest().log(Status.INFO, "SIC code text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_99SicCode_TextwithInput")
	public void TC_100Siccode_Textwithalphabets()
	{
	tp.getSicCode().click();
	tp.getSicCode().sendKeys(Keys.CONTROL + "a");
	tp.getSicCode().sendKeys(Keys.DELETE);
	tp.getSicCode().sendKeys("mjdhajbd");
	utilityclassobject.gettest().log(Status.INFO, "SIC code text field accepted alphabets");
     }
	
	
	@Test(dependsOnMethods = "TC_100Siccode_Textwithalphabets"/*"TC_006CompanynameTextFieldwithInput"*/)
	public void TC_101Siccode_TextwithNumbers()
	{
		tp.getSicCode().click();
		tp.getSicCode().sendKeys(Keys.CONTROL + "a");
		tp.getSicCode().sendKeys(Keys.DELETE);
		tp.getSicCode().sendKeys("19381907");
		utilityclassobject.gettest().log(Status.INFO, "SIC code text field accepted numbers");
		
	}
	
	@Test(dependsOnMethods = "TC_101Siccode_TextwithNumbers")
	public void TC_102Siccode_Textwithspecialcharacters()
	{
		tp.getSicCode().click();
		tp.getSicCode().sendKeys(Keys.CONTROL + "a");
		tp.getSicCode().sendKeys(Keys.DELETE);
		tp.getSicCode().sendKeys("!#!$%&*");
		utilityclassobject.gettest().log(Status.INFO, "SIC code text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_102Siccode_Textwithspecialcharacters")
	public void TC_103Siccode_TextwithoutInput()
	{
		tp.getSicCode().click();
		tp.getSicCode().sendKeys(Keys.CONTROL + "a");
		tp.getSicCode().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "SIC code text field without input error message is not displayed(not mandatory field)");
	}
	
	@Test(dependsOnMethods = "TC_103Siccode_TextwithoutInput")
	public void TC_104SicCode_TextwithAutosave()
	{
		tp.getSicCode().click();
		tp.getSicCode().sendKeys(Keys.CONTROL + "a");
		tp.getSicCode().sendKeys(Keys.DELETE);
		tp.getSicCode().sendKeys("1938hfj!@#");
		utilityclassobject.gettest().log(Status.INFO, "SIC code text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_104SicCode_TextwithAutosave")
	public void TC_105NAICSCode_TextwithInput()
	{
		tp.getNaicsCode().click();
		tp.getNaicsCode().sendKeys("1938hfj!@#");
		utilityclassobject.gettest().log(Status.INFO, "NAICS Code text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_105NAICSCode_TextwithInput")
	public void TC_106NAICSCode_Textwithalphabets()
	{
		tp.getNaicsCode().click();
		tp.getNaicsCode().sendKeys(Keys.CONTROL + "a");
		tp.getNaicsCode().sendKeys(Keys.DELETE);
		tp.getNaicsCode().sendKeys("kajhdajk");
		utilityclassobject.gettest().log(Status.INFO, "NAICS Code text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_106NAICSCode_Textwithalphabets")
	public void TC_107NAICSCode_Textwithnumbers()
	{
		tp.getNaicsCode().click();
		tp.getNaicsCode().sendKeys(Keys.CONTROL + "a");
		tp.getNaicsCode().sendKeys(Keys.DELETE);
		tp.getNaicsCode().sendKeys("198391083");
		utilityclassobject.gettest().log(Status.INFO, "NAICS Code text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_107NAICSCode_Textwithnumbers")
	public void TC_108NAICSCode_Textwithspecialcharacters()
	{
		tp.getNaicsCode().click();
		tp.getNaicsCode().sendKeys(Keys.CONTROL + "a");
		tp.getNaicsCode().sendKeys(Keys.DELETE);
		tp.getNaicsCode().sendKeys("!#@!$@%");
		utilityclassobject.gettest().log(Status.INFO, "NAICS Code text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_108NAICSCode_Textwithspecialcharacters")
	public void TC_109NAICSCode_TextwithoutInput()
	{
		tp.getNaicsCode().click();
		tp.getNaicsCode().sendKeys(Keys.CONTROL + "a");
		tp.getNaicsCode().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "NAICS Code text field without input error message is not displayed(not mandatory field) ");
	}
	
	@Test(dependsOnMethods = "TC_109NAICSCode_TextwithoutInput")
	public void TC_110NAICSCode_TextwithAutosave()
	{
		tp.getNaicsCode().click();
		tp.getNaicsCode().sendKeys("jah@123");
		utilityclassobject.gettest().log(Status.INFO, "NAICS Code text field accepted input and autosaved");
	}
	
	
	@Test(dependsOnMethods = "TC_110NAICSCode_TextwithAutosave")
	public void TC_111CAGECode_TextwithInput()
	{
		tp.getCageCode().click();
		tp.getCageCode().sendKeys(Keys.CONTROL + "a");
		tp.getCageCode().sendKeys(Keys.DELETE);
		tp.getCageCode().sendKeys("ahd!@#123");
		utilityclassobject.gettest().log(Status.INFO, "CAGE Code text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_111CAGECode_TextwithInput")
	public void TC_112CAGECode_Textwithalphabets()
	{
		tp.getCageCode().click();
		tp.getCageCode().sendKeys(Keys.CONTROL + "a");
		tp.getCageCode().sendKeys(Keys.DELETE);
		tp.getCageCode().sendKeys("jfsihfjs");
		utilityclassobject.gettest().log(Status.INFO, "CAGE Code text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_112CAGECode_Textwithalphabets")
	public void TC_113CAGECode_Textwithnumbers()
	{
		tp.getCageCode().click();
		tp.getCageCode().sendKeys(Keys.CONTROL + "a");
		tp.getCageCode().sendKeys(Keys.DELETE);
		tp.getCageCode().sendKeys("1983718");
		utilityclassobject.gettest().log(Status.INFO, "CAGE Code text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_113CAGECode_Textwithnumbers")
	public void TC_114CAGECode_TextwithSpecialcharacters()
	{
		tp.getCageCode().click();
		tp.getCageCode().sendKeys(Keys.CONTROL + "a");
		tp.getCageCode().sendKeys(Keys.DELETE);
		tp.getCageCode().sendKeys("!@!#%*&");
		utilityclassobject.gettest().log(Status.INFO, "CAGE Code text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_114CAGECode_TextwithSpecialcharacters")
	public void TC_115CAGECode_TextwithoutInput()
	{
		tp.getCageCode().click();
		tp.getCageCode().sendKeys(Keys.CONTROL + "a");
		tp.getCageCode().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "CAGE Code text field without input error message is not displayed(not mandatory field)");
		
	}
	
	@Test(dependsOnMethods = "TC_115CAGECode_TextwithoutInput")
	public void TC_116CAGECode_TextwithAutosave() throws EncryptedDocumentException, IOException
	{
		tp.getCageCode().click();
		String input = elib.getDataFromExcel("TransporterProfile", 22, 1);
		tp.getCageCode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "CAGE Code text field accepted input and autosaved");
	}
	
	/*@Test(dependsOnMethods = "TC_116CAGECode_TextwithAutosave")
	public void TC_117ServiceDep_Tooltip()
	{
		tp.ToolTip();
		WebElement popup = driver.findElement(By.xpath("//strong[text()='Service Department Information']"));
		Assert.assertTrue(popup.isDisplayed(), "Service Department popup is not visible");
	}*/
	
	
	@Test(dependsOnMethods = "TC_116CAGECode_TextwithAutosave")
	public void TC_118ServiceDep_NamewithInput() throws EncryptedDocumentException, IOException
	{
		tp.getServiceName().click();
		String input = elib.getDataFromExcel("TransporterProfile", 25, 1);
		tp.getServiceName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Name text field accepted input");

	}
	
	@Test(dependsOnMethods = "TC_118ServiceDep_NamewithInput")
	public void TC_119ServiceDep_Namewithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getServiceName().click();
		tp.getServiceName().sendKeys(Keys.CONTROL + "a");
		tp.getServiceName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 25, 2);
		tp.getServiceName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Name text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_119ServiceDep_Namewithalphabets")
	public void TC_120ServiceDep_Namewithnumbers() throws EncryptedDocumentException, IOException
	{
	tp.getServiceName().click();
	tp.getServiceName().sendKeys(Keys.CONTROL + "a");
	tp.getServiceName().sendKeys(Keys.DELETE);
	String input = elib.getDataFromExcel("TransporterProfile", 25, 3);
	tp.getServiceName().sendKeys(input);
	utilityclassobject.gettest().log(Status.INFO, "Service Department Name text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_120ServiceDep_Namewithnumbers")
	public void TC_121ServiceDep_NamewithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getServiceName().click();
		tp.getServiceName().sendKeys(Keys.CONTROL + "a");
		tp.getServiceName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 25, 4);
		tp.getServiceName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Name text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_121ServiceDep_NamewithSpecialcharacters")
	public void TC_122ServiceDep_NamewithoutInput()
	{
		tp.getServiceName().click();
		tp.getServiceName().sendKeys(Keys.CONTROL + "a");
		tp.getServiceName().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getServiceNameErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Name text field without input and displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_122ServiceDep_NamewithoutInput")
	public void TC_123ServiceDep_NamewithAutosave() throws EncryptedDocumentException, IOException
	{
		tp.getServiceName().click();
		String input = elib.getDataFromExcel("TransporterProfile", 25, 1);
		tp.getServiceName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department Name text field accepted input and autosaved");

	}
	
	@Test(dependsOnMethods = "TC_123ServiceDep_NamewithAutosave")
	public void TC_124ServiceDep_streetwithInput() throws InterruptedException 
	{
		tp = new TransporterProfile(driver);
		tp.Streets();
		utilityclassobject.gettest().log(Status.INFO, "Service Department street text field accepted input");

	}
	
	@Test(dependsOnMethods = "TC_124ServiceDep_streetwithInput")
	public void TC_125ServiceDep_streetwithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getServiceAddress().click();
		tp.getServiceAddress().sendKeys(Keys.CONTROL + "a");
		tp.getServiceAddress().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 28, 1);
		tp.getServiceAddress().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department street text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_125ServiceDep_streetwithalphabets")
	public void TC_126serviceDep_streetwithnumbers() throws EncryptedDocumentException, IOException
	{
		tp.getServiceAddress().click();
		tp.getServiceAddress().sendKeys(Keys.CONTROL + "a");
		tp.getServiceAddress().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 28, 2);
		tp.getServiceAddress().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department street text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_126serviceDep_streetwithnumbers")
	public void TC_127serviceDep_streeetwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getServiceAddress().click();
		tp.getServiceAddress().sendKeys(Keys.CONTROL + "a");
		tp.getServiceAddress().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 28, 3);
		tp.getServiceAddress().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department street text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_127serviceDep_streeetwithspecialcharacters")
	public void TC_128serviceDep_streetwithoutInput()
	{
		tp.getServiceAddress().click();
		tp.getServiceAddress().sendKeys(Keys.CONTROL + "a");
		tp.getServiceAddress().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getServiceNameErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department street text field without input and displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_128serviceDep_streetwithoutInput")
	public void TC_129serviceDep_streetwithAutosave() throws InterruptedException
	{
		//TransporterProfile tpw = new TransporterProfile(driver);
		tp.getServiceAddress().click();
		tp.getServiceAddress().sendKeys(Keys.CONTROL + "a");
		tp.getServiceAddress().sendKeys(Keys.DELETE);
		tp.Streets();
		utilityclassobject.gettest().log(Status.INFO, "Service Department street text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_129serviceDep_streetwithAutosave")
	public void TC_130serviceDep_suitewithInput() throws EncryptedDocumentException, IOException
	{
		tp.getSuite().click();
		String input = elib.getDataFromExcel("TransporterProfile", 31, 1);
		tp.getSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department suite text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_130serviceDep_suitewithInput")
	public void TC_131serviceDep_suitewithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getSuite().click();
		tp.getSuite().sendKeys(Keys.CONTROL + "a");
		tp.getSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 2);
		tp.getSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department suite text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_131serviceDep_suitewithalphabets")
	public void TC_132serviceDep_suitewithnumbers() throws EncryptedDocumentException, IOException
	{
		tp.getSuite().click();
		tp.getSuite().sendKeys(Keys.CONTROL + "a");
		tp.getSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 3);
		tp.getSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department suite text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_132serviceDep_suitewithnumbers")
	public void TC_133serviceDep_suitewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getSuite().click();
		tp.getSuite().sendKeys(Keys.CONTROL + "a");
		tp.getSuite().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 31, 4);
		tp.getSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department suite text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_133serviceDep_suitewithspecialcharacters")
	public void TC_134serviceDep_suitewithoutInput()
	{
		tp.getSuite().click();
		tp.getSuite().sendKeys(Keys.CONTROL + "a");
		tp.getSuite().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "Service Department suite text field without input error message is not displayed(not mandatrory field)");
	}
	
	@Test(dependsOnMethods = "TC_134serviceDep_suitewithoutInput")
	public void TC_135serviceDep_suitewithAutosave() throws EncryptedDocumentException, IOException
	{
		tp.getSuite().click();
		String input = elib.getDataFromExcel("TransporterProfile", 31, 1);
		tp.getSuite().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department suite text field accepted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_135serviceDep_suitewithAutosave")
	public void TC_136serviceDep_CitywithInput() throws EncryptedDocumentException, IOException
	{
		tp.getCity().click();
		tp.getCity().sendKeys(Keys.CONTROL + "a");
		tp.getCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 1);
		tp.getCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department city text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_136serviceDep_CitywithInput")
	public void TC_137serviceDep_Citywithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getCity().click();
		tp.getCity().sendKeys(Keys.CONTROL + "a");
		tp.getCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 2);
		tp.getCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department city text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_137serviceDep_Citywithalphabets")
	public void TC_138serviceDep_Citywithnumbers() throws EncryptedDocumentException, IOException
	{
		tp.getCity().click();
		tp.getCity().sendKeys(Keys.CONTROL + "a");
		tp.getCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 3);
		tp.getCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department city text field accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_138serviceDep_Citywithnumbers")
	public void TC_139serviceDep_CitywithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getCity().click();
		tp.getCity().sendKeys(Keys.CONTROL + "a");
		tp.getCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 34, 4);
		tp.getCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department city text field accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_139serviceDep_CitywithSpecialcharacters")
	public void TC_140serviceDep_CitywithputInput() throws EncryptedDocumentException, IOException
	{
		tp.getCity().click();
		tp.getCity().sendKeys(Keys.CONTROL + "a");
		tp.getCity().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getServiceCityErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department city text field without input and displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_140serviceDep_CitywithputInput")
	public void TC_141serviceDep_CitywithAutosave() throws EncryptedDocumentException, IOException
	{
		tp.getCity().click();
		tp.getCity().sendKeys(Keys.CONTROL + "a");
		tp.getCity().sendKeys(Keys.DELETE);	
		String input = elib.getDataFromExcel("TransporterProfile", 34, 1);
		tp.getCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department city text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_141serviceDep_CitywithAutosave")
	public void TC_142serviceDep_StatewithInput() throws EncryptedDocumentException, IOException
	{
		tp.getState().click();
		tp.getState().sendKeys(Keys.CONTROL + "a");
		tp.getState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 1);
		tp.getState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department State dropdown accepted input");
	}
	
	@Test(dependsOnMethods = "TC_142serviceDep_StatewithInput")
	public void TC_143serviceDep_statewithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getState().click();
		tp.getState().sendKeys(Keys.CONTROL + "a");
		tp.getState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 2);
		tp.getState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department state dropdown accepted alpahbets");
	}
	
	@Test(dependsOnMethods = "TC_143serviceDep_statewithalphabets")
	public void TC_144serviceDep_statewithnumbers() throws EncryptedDocumentException, IOException
	{
		tp.getState().click();
		tp.getState().sendKeys(Keys.CONTROL + "a");
		tp.getState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 3);
		tp.getState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department state dropdown will not accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_144serviceDep_statewithnumbers")
	public void TC_145serviceDep_statewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		tp.getState().click();
		tp.getState().sendKeys(Keys.CONTROL + "a");
		tp.getState().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 37, 4);
		tp.getState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department state dropdown will not accept specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_145serviceDep_statewithspecialcharacters")
	public void TC_146serviceDep_stateDropdown()
	{
		tp.getState().click();
		tp.getState().sendKeys(Keys.CONTROL + "a");
		tp.getState().sendKeys(Keys.DELETE);
		tp.SelectAZstate();
		utilityclassobject.gettest().log(Status.INFO, "From Service Department state dropdown state is selected ");
	}
	
	
	/*@Test(dependsOnMethods = "TC_146serviceDep_stateDropdown")
	public void TC_147serviceDep_statewithoutInput()
	{
		tp.getState().click();
		tp.getState().sendKeys(Keys.CONTROL + "a");
		tp.getState().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getStateErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Service Department state dropdown without input displayed error message");
	}*/
	
	
	@Test(dependsOnMethods = "TC_146serviceDep_stateDropdown")
	public void TC_148serviceDep_statewithAutosave()
	{
		tp.getState().click();
		tp.getState().sendKeys(Keys.CONTROL + "a");
		tp.getState().sendKeys(Keys.DELETE);
		tp.SelectCAstate();
		utilityclassobject.gettest().log(Status.INFO, "From Service Department state dropdown state is selected and autosaved ");
	}
	
	@Test(dependsOnMethods = "TC_148serviceDep_statewithAutosave")
	public void TC_149ServiceDep_zipcodewithInput() throws EncryptedDocumentException, IOException
	{
		tp.getZipCode().click();
		tp.getZipCode().sendKeys(Keys.CONTROL + "a");
		tp.getZipCode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 40, 1);
		tp.getZipCode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted input");
	}
	
	@Test(dependsOnMethods = "TC_149ServiceDep_zipcodewithInput")
	public void TC_150serviceDep_zipcodewithalphabets() throws EncryptedDocumentException, IOException
	{
		tp.getZipCode().click();
		tp.getZipCode().sendKeys(Keys.CONTROL + "a");
		tp.getZipCode().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 40, 2);
		tp.getZipCode().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service Department zipcode text field accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_150serviceDep_zipcodewithalphabets")
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
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingaddStreet().click();
		tp.getBillingaddStreet().sendKeys(Keys.CONTROL + "a");
		tp.getBillingaddStreet().sendKeys(Keys.DELETE);
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
	
		
	@Test(dependsOnMethods = "TC_200billingadd_statewithInput"/*"TC_006CompanynameTextFieldwithInput"*/)
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
	public void TC_218billingadd_EmailwithoutInput()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getBillingEmail().click();
		tp.getBillingEmail().sendKeys(Keys.CONTROL + "a");
		tp.getBillingEmail().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
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
	
	
	@Test(dependsOnMethods = "TC_250businesshour_PasteButton"/*"TC_006CompanynameTextFieldwithInput"*/)
	public void TC_251businesshour_Pasteforday()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondayTime();
		tp.Mondaylunchtime();
		tp.MondaylunchEnd();
		tp.MondaycloseTime();
		tp.PasteForParticularday();
		utilityclassobject.gettest().log(Status.INFO, "User is able to copy the business hours and paste for the particular days");
	}
	
	@Test(dependsOnMethods = "TC_251businesshour_Pasteforday")
	public void TC_252businesshour_withClose()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondayTime();
		tp.Mondaylunchtime();
		tp.MondaylunchEnd();
		tp.MondaycloseTime();
		tp.PastewithCloseddays();
		utilityclassobject.gettest().log(Status.INFO, "User is able to check the closed checkbox for the day along with the business hours");
	}
	
	@Test(dependsOnMethods = "TC_252businesshour_withClose")
	public void TC_253businesshours_WithAutosave()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.MondayTime();
		tp.Mondaylunchtime();
		tp.MondaylunchEnd();
		tp.MondaycloseTime();
		tp.PasteButton();
		utilityclassobject.gettest().log(Status.INFO, "User is able to add the business hours and it is autosaved");
	}
	
	@Test(dependsOnMethods = "TC_253businesshours_WithAutosave")
	public void TC_254shortdescription_withInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getShortdescription().click();
        String input = elib.getDataFromExcel("TransporterProfile", 55, 1);
		tp.getShortdescription().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Short description text filed accepted input");

     }
	
	@Test(dependsOnMethods = "TC_254shortdescription_withInput")
	public void TC_255shortdescription_withalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getShortdescription().click();
    	    tp.getShortdescription().sendKeys(Keys.CONTROL + "a");
		tp.getShortdescription().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 55, 2);
		tp.getShortdescription().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Short description text filed accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_255shortdescription_withalphabets")
	public void TC_256shortdescription_withNumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getShortdescription().click();
    	    tp.getShortdescription().sendKeys(Keys.CONTROL + "a");
		tp.getShortdescription().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 55, 3);
		tp.getShortdescription().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Short description text filed accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_256shortdescription_withNumbers")
	public void TC_257shortdescription_withspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getShortdescription().click();
    	    tp.getShortdescription().sendKeys(Keys.CONTROL + "a");
		tp.getShortdescription().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 55, 4);
		tp.getShortdescription().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Short description text filed accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_257shortdescription_withspecialcharacters")
	public void TC_258Bio_withInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getBioField().click();
    	    tp.getBioField().sendKeys(Keys.CONTROL + "a");
		tp.getBioField().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 58, 1);
		tp.getBioField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Bio text filed accepted Input");
	}
	
	@Test(dependsOnMethods = "TC_258Bio_withInput")
	public void TC_259Bio_withalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getBioField().click();
    	    tp.getBioField().sendKeys(Keys.CONTROL + "a");
		tp.getBioField().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 58, 2);
		tp.getBioField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Bio text filed accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_259Bio_withalphabets")
	public void TC_260Bio_withNumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getBioField().click();
    	    tp.getBioField().sendKeys(Keys.CONTROL + "a");
		tp.getBioField().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 58, 3);
		tp.getBioField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Bio text filed accepted numbers");
	}
	
	
	@Test(dependsOnMethods = "TC_260Bio_withNumbers"/*"TC_006CompanynameTextFieldwithInput"*/)
	public void TC_261Bio_withSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getBioField().click();
    	    tp.getBioField().sendKeys(Keys.CONTROL + "a");
		tp.getBioField().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 58, 4);
		tp.getBioField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Bio text filed accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_261Bio_withSpecialcharacters")
	public void TC_262ShortDescription_withAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
        tp.getShortdescription().click();
        tp.getShortdescription().sendKeys(Keys.CONTROL + "a");
    		tp.getShortdescription().sendKeys(Keys.DELETE);
        String input = elib.getDataFromExcel("TransporterProfile", 55, 1);
		tp.getShortdescription().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Short description text filed accepted input");
	}
	
	
	@Test(dependsOnMethods = "TC_262ShortDescription_withAutosave")
	public void TC_263serviceoffered_Tooltip()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceofferedTooltip();
		utilityclassobject.gettest().log(Status.INFO, "Service Offered tooltip is displayed");
	}
	
	@Test(dependsOnMethods = "TC_263serviceoffered_Tooltip")
	public void TC_264serviceoffered_withServices()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceofferedCheckbox();
		utilityclassobject.gettest().log(Status.INFO, "User is able to check all the services checkbox");
	}
	
	@Test(dependsOnMethods = "TC_264serviceoffered_withServices")
	public void TC_265serviceoffered_withMainservice() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		Thread.sleep(2000);
		tp.MedicalwasteCancelation();
		tp.waitForOverlayToDisappear();
		tp.PapersheddingCancelation();
		tp.waitForOverlayToDisappear();
		tp.ElectronicwasteCancelation();
		tp.waitForOverlayToDisappear();
		tp.DisposalfacilityCancelation();
		tp.waitForOverlayToDisappear();
		tp.ProductdestructionCancelation();
		tp.waitForOverlayToDisappear();
		tp.UniversalwasteCancelation();
		tp.waitForOverlayToDisappear();
		tp.ServiceofferedCheckbox();
		utilityclassobject.gettest().log(Status.INFO, "User is able to check all the services checkboxes by clicking on the Main service type ");
	}
	
	@Test(dependsOnMethods = "TC_265serviceoffered_withMainservice")
	public void TC_266serviceoffered_withSubwaste()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceofferedsubWaste();
		utilityclassobject.gettest().log(Status.INFO, "User is able to select the sub waste type individually");
	}
	
	@Test(dependsOnMethods = "TC_266serviceoffered_withSubwaste")
	public void TC_267serviceofferes_WithDisablewaste() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		Thread.sleep(2000);
		tp.ServiceofferedDisable();
		utilityclassobject.gettest().log(Status.INFO, "User is able to not select the disabled service types");
	}
	
	
	@Test(dependsOnMethods = "TC_267serviceofferes_WithDisablewaste")
	public void TC_268serviceoffered_uncheckIndividually() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		Thread.sleep(2000);
		tp.BioSharpCancelation();
		tp.waitForOverlayToDisappear();
		tp.AphisCancelation();
		tp.waitForOverlayToDisappear();
		tp.OnsiteCancelation();
		tp.waitForOverlayToDisappear();
		tp.OffsiteCancelation();
		tp.waitForOverlayToDisappear();
		tp.TransferCancelation();
		tp.waitForOverlayToDisappear();
		tp.TreatmentCancelation();
		tp.waitForOverlayToDisappear();
		utilityclassobject.gettest().log(Status.INFO, "User is able to unselect the sub waste type individually");
	}
	
	@Test(dependsOnMethods = "TC_268serviceoffered_uncheckIndividually")
	public void TC_269serviceoffered_Uncheckmainservice() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		Thread.sleep(2000);
		tp.ServiceofferedCheckbox();
		tp.MedicalwasteCancelation();
		tp.waitForOverlayToDisappear();
		tp.PapersheddingCancelation();
		tp.waitForOverlayToDisappear();
		tp.ElectronicwasteCancelation();
		tp.waitForOverlayToDisappear();
		tp.DisposalfacilityCancelation();
		tp.waitForOverlayToDisappear();
		tp.ProductdestructionCancelation();
		tp.waitForOverlayToDisappear();
		tp.UniversalwasteCancelation();
		tp.waitForOverlayToDisappear();
		utilityclassobject.gettest().log(Status.INFO, "User is able to unselect the Main waste type individually");
	}
	
	@Test(dependsOnMethods = "TC_269serviceoffered_Uncheckmainservice")
	public void TC_270serviceoffered_Autosave()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceofferedCheckbox();
	}
	
	
	@Test(dependsOnMethods = "TC_270serviceoffered_Autosave"/*"TC_006CompanynameTextFieldwithInput"*/)
	public void TC_271DispatchEmail_withInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchEmail().click();
		tp.getDispatchEmail().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 1);
		tp.getDispatchEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Email textfield accepted Input");
	}
	
	@Test(dependsOnMethods = "TC_271DispatchEmail_withInput")
	public void TC_272DispatchEmail_withalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchEmail().click();
		tp.getDispatchEmail().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 2);
		tp.getDispatchEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Email textfield accepted alpahabets");
	}
	
	@Test(dependsOnMethods = "TC_272DispatchEmail_withalphabets")
	public void TC_273DispatchEmail_withnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchEmail().click();
		tp.getDispatchEmail().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 3);
		tp.getDispatchEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Email textfield accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_273DispatchEmail_withnumbers")
	public void TC_274dispatchEmail_withspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchEmail().click();
		tp.getDispatchEmail().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 4);
		tp.getDispatchEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Email textfield accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_274dispatchEmail_withspecialcharacters")
	public void TC_275dispatchEmail_withInavalidformat() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchEmail().click();
		tp.getDispatchEmail().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchEmail().sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 5);
		tp.getDispatchEmail().sendKeys(input);
		String errormsg = tp.getDispatchEmailInvalid().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Email textfield with invalid email displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_275dispatchEmail_withInavalidformat")
	public void TC_276dispatchEmail_withoutInput() throws InterruptedException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchEmail().click();
		tp.getDispatchEmail().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchEmail().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		Thread.sleep(2000);
		String errormsg = tp.getDispatchEmailErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Email textfield without input displayed Error message");
	}
	
	@Test(dependsOnMethods = "TC_276dispatchEmail_withoutInput")
	public void TC_277dispatchEmail_withAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchEmail().click();
		tp.getDispatchEmail().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 43, 1);
		tp.getDispatchEmail().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Email textfield accepted Input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_277dispatchEmail_withAutosave")
	public void TC_278dispatchPhone_withInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 1);
		tp.getDispatchPhonefield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield accepted Input");
	}
	
	@Test(dependsOnMethods = "TC_278dispatchPhone_withInput")
	public void TC_279dispatchPhone_withalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 2);
		tp.getDispatchPhonefield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield accepted alphabets");
	}
	
	@Test(dependsOnMethods = "TC_279dispatchPhone_withalphabets")
	public void TC_280dispatchPhone_Withnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 3);
		tp.getDispatchPhonefield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield accepted numbers");
	}
	
	
	@Test(dependsOnMethods = "TC_280dispatchPhone_Withnumbers"/*"TC_006CompanynameTextFieldwithInput"*/)
	public void TC_281dispatchPhone_withspecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 4);
		tp.getDispatchPhonefield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_281dispatchPhone_withspecialcharacters")
	public void TC_282dispatchPhone_morethan10digits() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 5);
		tp.getDispatchPhonefield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield will not accept more than 10 digits");
	}
	
	@Test(dependsOnMethods = "TC_282dispatchPhone_morethan10digits")
	public void TC_283dispatchPhone_lessthan10digits() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 6);
		tp.getDispatchPhonefield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield with less than 10 digits");
	}
	
	@Test(dependsOnMethods = "TC_283dispatchPhone_lessthan10digits")
	public void TC_284dispatchPhone_withoutInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		String errormsg = tp.getDispatchPhoneErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield wihtout input and displayed error message");
	}
	
	@Test(dependsOnMethods = "TC_284dispatchPhone_withoutInput")
	public void TC_285dispatchPhone_WithAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispatchPhonefield().click();
		tp.getDispatchPhonefield().sendKeys(Keys.CONTROL + "a");
		tp.getDispatchPhonefield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 46, 1);
		tp.getDispatchPhonefield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield accpted input and autosaved");
	}
	

	@Test(dependsOnMethods = "TC_285dispatchPhone_WithAutosave")
	public void TC_286dispatchExt_withInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispathchExtField().click();
		tp.getDispathchExtField().sendKeys(Keys.CONTROL + "a");
		tp.getDispathchExtField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 1);
		tp.getDispathchExtField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Ext textfield accpted input");
	}
	
	@Test(dependsOnMethods = "TC_286dispatchExt_withInput")
	public void TC_287dispatchExt_withalphabets() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispathchExtField().click();
		tp.getDispathchExtField().sendKeys(Keys.CONTROL + "a");
		tp.getDispathchExtField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 2);
		tp.getDispathchExtField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Ext textfield accpted alpahbets");
	}
	
	@Test(dependsOnMethods = "TC_287dispatchExt_withalphabets")
	public void TC_288dispatchExt_withnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispathchExtField().click();
		tp.getDispathchExtField().sendKeys(Keys.CONTROL + "a");
		tp.getDispathchExtField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 3);
		tp.getDispathchExtField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Ext textfield accpted numbers");
	}
	
	@Test(dependsOnMethods  = "TC_288dispatchExt_withnumbers")
	public void TC_289dispatchExt_withspecialcharacters() throws EncryptedDocumentException, IOException 
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispathchExtField().click();
		tp.getDispathchExtField().sendKeys(Keys.CONTROL + "a");
		tp.getDispathchExtField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 4);
		tp.getDispathchExtField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Phone textfield accpted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_289dispatchExt_withspecialcharacters")
	public void TC_290dispatchExt_withoutInput()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispathchExtField().click();
		tp.getDispathchExtField().sendKeys(Keys.CONTROL + "a");
		tp.getDispathchExtField().sendKeys(Keys.DELETE);
		tp.SubmitBtn();
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Ext textfield without input error message is not displayed");
	}
	

	@Test(dependsOnMethods = "TC_290dispatchExt_withoutInput"/*"TC_006CompanynameTextFieldwithInput"*/)
	public void TC_291dispatchExt_withAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getDispathchExtField().click();
		tp.getDispathchExtField().sendKeys(Keys.CONTROL + "a");
		tp.getDispathchExtField().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 49, 1);
		tp.getDispathchExtField().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Dispatch department Ext textfield accpted input and autosaved");
	}
	
	@Test(dependsOnMethods = "TC_291dispatchExt_withAutosave")
	public void TC_292subcontractor_OptinButton()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.OptInButton();
		utilityclassobject.gettest().log(Status.INFO, "User is able to click on the OptinButton");
	}
	
	
	@Test(dependsOnMethods = "TC_292subcontractor_OptinButton")
	public void TC_293subcontractor_categoriesSelect()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CategoryEwaste();
		utilityclassobject.gettest().log(Status.INFO, "User is able to select the categories from the category dropdown");
	}
	
	@Test(dependsOnMethods = "TC_293subcontractor_categoriesSelect")
	public void TC_294subcontractor_categoriesMorethan3()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CategorySelection();
		utilityclassobject.gettest().log(Status.INFO, "User is not able to select more than 3 categories from the dropdown");
	}

	@Test(dependsOnMethods = "TC_294subcontractor_categoriesMorethan3")
	public void TC_295subcontractor_withoutCategory()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CategoryDropdown();
		tp.SubmitBtn();
		String errormsg = tp.getCategoryErmsg().getText();
		System.out.println(errormsg);
		utilityclassobject.gettest().log(Status.INFO, "Category dropdown without categories error message is displayed");
	}
	
	@Test(dependsOnMethods = "TC_295subcontractor_withoutCategory")
	public void TC_308subcontractor_WithoutServiceArea() 
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.SubmitBtn();
		String errormsg = tp.getServiceareaErmsg().getText();
		System.out.println(errormsg);
	}
	
	@Test(dependsOnMethods = "TC_308subcontractor_WithoutServiceArea")
	public void TC_296subcontractor_Servicearea()
	{
	TransporterProfile tp = new TransporterProfile(driver);
	tp.getNationwideRadioButton().click();
	utilityclassobject.gettest().log(Status.INFO, "user is able to select service area");
	}
	
	@Test(dependsOnMethods = "TC_296subcontractor_Servicearea"/*"TC_006CompanynameTextFieldwithInput"*/) 
	public void TC_297subcontractor_serviceareaCity()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getCityRadioButton().click();
		utilityclassobject.gettest().log(Status.INFO, "user is able to select service area");
    }
	
	@Test(dependsOnMethods = "TC_297subcontractor_serviceareaCity")
	public void TC_298subcontractor_citywithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getServiceareaCity().click();
		tp.getServiceareaCity().sendKeys(Keys.CONTROL + "a");
		tp.getServiceareaCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 61, 1);
		tp.getServiceareaCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service area city textfield accepted Input");
	}
	
	@Test(dependsOnMethods = "TC_298subcontractor_citywithInput")
	public void TC_299subcontractor_citywithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getServiceareaCity().click();
		tp.getServiceareaCity().sendKeys(Keys.CONTROL + "a");
		tp.getServiceareaCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 61, 2);
		tp.getServiceareaCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service area city textfield accepted numbers");
	}
	
	@Test(dependsOnMethods = "TC_299subcontractor_citywithnumbers")
	public void TC_300subcontractor_citywithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getServiceareaCity().click();
		tp.getServiceareaCity().sendKeys(Keys.CONTROL + "a");
		tp.getServiceareaCity().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("TransporterProfile", 61, 3);
		tp.getServiceareaCity().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service area city textfield accepted specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_300subcontractor_citywithSpecialcharacters")
	public void TC_301subcontractor_statewithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getServiceareaState().click();
		//String input = elib.getDataFromExcel("TransporterProfile", 61, 1);
		//tp.getServiceareaState().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service area state dropdown will not accept input");
	}
	
	@Test(dependsOnMethods = "TC_301subcontractor_statewithInput")
	public void TC_302subcontractor_statewithdropdown()
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.getServiceareaState().click();
		tp.ServiceareaatateAZ();
		tp.getServiceareaState().click();
		tp.ServiceareastateAk();
		utilityclassobject.gettest().log(Status.INFO, "user is able to select the state from the dropdown");
	}
	
	@Test(dependsOnMethods = "TC_302subcontractor_statewithdropdown")
	public void TC_303subcontractor_MileswithInput() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceAreaWithInput();
		utilityclassobject.gettest().log(Status.INFO, "Service area Miles textfield will accept input");
	}
	
	@Test(dependsOnMethods = "TC_303subcontractor_MileswithInput")
	public void TC_304subcontractor_Mileswithalphabets()
	{
		WebElement milesField = driver.findElement(By.xpath("//input[@placeholder='Miles *']"));
		milesField.sendKeys("abc");
		String enteredValue = milesField.getAttribute("value");
		Assert.assertTrue(enteredValue.isEmpty() || enteredValue.matches("\\d+"),
		    "Field accepted invalid alphabet input!");
		utilityclassobject.gettest().log(Status.INFO, "Service area Miles textfield will not accpet alphabets");
	}
	
	@Test(dependsOnMethods = "TC_304subcontractor_Mileswithalphabets")
	public void TC_305subcontractor_Mileswithnumbers() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceAreaWithInput();
		utilityclassobject.gettest().log(Status.INFO, "Service area Miles textfield will accept numbers");
	}
	
	@Test(dependsOnMethods = "TC_305subcontractor_Mileswithnumbers")
	public void TC_306subcontracor_Mileswithspecialcharacters()
	{
		WebElement milesField = driver.findElement(By.xpath("//input[@placeholder='Miles *']"));
		milesField.sendKeys("#$%^");
		String enteredValue = milesField.getAttribute("value");
		Assert.assertTrue(enteredValue.isEmpty() || enteredValue.matches("\\d+"),
		    "Field accepted invalid alphabet input!");
		utilityclassobject.gettest().log(Status.INFO, "Service area Miles textfield will not accpet alphabets");
	}
	
	@Test(dependsOnMethods = "TC_306subcontracor_Mileswithspecialcharacters")
	public void TC_307subcontractor_Addbutton() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceAreacityInput();
		tp.getServiceareaState().click();
		tp.ServiceareaatateAZ();
		tp.ServiceAreaWithInput();
		tp.getAddButton().click();
		utilityclassobject.gettest().log(Status.INFO, "User is able to click on the Add button");

	}
	
	@Test(dependsOnMethods = "TC_307subcontractor_Addbutton")
	public void TC_309subcontractor_withSubmitButton() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.ServiceAreacityInput();
		tp.getServiceareaState().click();
		tp.ServiceareaatateAZ();
		tp.ServiceAreaWithInput();
		tp.getAddButton().click();
		utilityclassobject.gettest().log(Status.INFO, "User is able to click on the submit button after adding all the mandatory information");

	}
	
	@Test(dependsOnMethods = "TC_309subcontractor_withSubmitButton")
	public void TC_310subcontractor_withAutosave() throws EncryptedDocumentException, IOException
	{
		TransporterProfile tp = new TransporterProfile(driver);
		tp.CategoryEwaste();
		tp.getNationwideRadioButton().click();
		tp.getCityRadioButton().click();
		tp.ServiceAreacityInput();
		tp.getServiceareaState().click();
		tp.ServiceareaatateAZ();
		tp.ServiceAreaWithInput();
		tp.getAddButton().click();
		utilityclassobject.gettest().log(Status.INFO, "service area infromation is added and autosaved");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

	


	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	
	
	
	

	


		
	

		

		
		

	

	
	
	
	
	

