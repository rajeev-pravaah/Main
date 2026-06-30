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

public class TC_051toTC_100TranspoterProfile extends BaseclassForSignUpPage{
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

	//Nagaveni 
	@Test(dependsOnMethods = "TC_006CompanynameTextFieldwithInput")
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
	public void TC_94SosCode_Texteithalphabets() throws InterruptedException
	
	{
		Thread.sleep(3000);
		tp.getSosCode().click();
		Thread.sleep(2000);
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
	
}
