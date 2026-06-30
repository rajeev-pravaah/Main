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

public class TC_250tcTC_300TransporterProfile extends BaseclassForSignUpPage{
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
	
	
	@Test(dependsOnMethods = /*"TC_262ShortDescription_withAutosave"*/"TC_006CompanynameTextFieldwithInput")
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
	public void TC_266serviceoffered_withSubwaste() throws InterruptedException
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
	

}
