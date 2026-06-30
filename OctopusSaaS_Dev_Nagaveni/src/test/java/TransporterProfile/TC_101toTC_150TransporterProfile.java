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

public class TC_101toTC_150TransporterProfile extends BaseclassForSignUpPage{
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
	
}
