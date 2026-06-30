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

public class TC_300toTc_320TransporterProfile extends BaseclassForSignUpPage{
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
