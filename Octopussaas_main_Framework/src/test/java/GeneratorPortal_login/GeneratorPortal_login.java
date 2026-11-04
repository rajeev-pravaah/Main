package GeneratorPortal_login;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.FileUtility.FileUtility;
import com.Octopussaas.ObjectRepository.GeneratorPortal;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

import io.reactivex.rxjava3.functions.Action;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class GeneratorPortal_login extends BaseClassForGEneratorContacts{
	GeneratorPortal gpn;
	ExcelUtility elib ;
	String input;
	String input2;
	
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
	public void TC_004VerifyGeneratorContacts_welcomepage()
	{
		gpn.getWelcomepage().isDisplayed();
		System.out.println("Successfully displayed welcome page");
	    utilityclassobject.gettest().log(Status.PASS,"Successfully displayed welcome page");		
	}
	
	@Test(dependsOnMethods = "TC_004VerifyGeneratorContacts_welcomepage")
	public void TC_005VerifyGeneratorPortal_textfields()
	{
		gpn.getEmailtextfield().isDisplayed();
		gpn.getPasswordtextfield().isDisplayed();
		gpn.getLogin().isDisplayed();
		System.out.println("Welcom page is displayed along with Enter email text field and password and Login button");
	    utilityclassobject.gettest().log(Status.PASS,"Successfully displayed welcome page");		
		
	}
	
	@Test(dependsOnMethods = "TC_005VerifyGeneratorPortal_textfields")
	public void TC_006VerifyGeneratorPortal_URLlink() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException
	{
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currenturl);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(1000);

		String copiedUrl = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

		System.out.println("Copied URL: " + copiedUrl);
		
		if(currenturl.equals(copiedUrl))
		{
			System.out.println("Able to copy Link");
		}
		else {
			System.out.println("not able to copy Link");
		}
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		System.out.println("Able to copy Link");
	    utilityclassobject.gettest().log(Status.PASS,"Able to copy Link");			
		
	}
	
	@Test(dependsOnMethods = "TC_006VerifyGeneratorPortal_URLlink")
	public void TC_007VerifyGeneratorcontacts_EmailwithAlphabets() throws IOException
	{
		gpn.getEmailtextfield().click();
		gpn.getEmailtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getEmailtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 1, 1);
		gpn.getEmailtextfield().sendKeys(input);
		System.out.println("Email text field accepts alphabets");
	    utilityclassobject.gettest().log(Status.PASS,"Email text field accepts alphabets");			
	}
	
	
	@Test(dependsOnMethods = "TC_007VerifyGeneratorcontacts_EmailwithAlphabets")
	public void TC_008VerifyGeneratorPortal_EmailwithNumbers() throws EncryptedDocumentException, IOException
	{
		gpn.getEmailtextfield().click();
		gpn.getEmailtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getEmailtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 1, 2);
		gpn.getEmailtextfield().sendKeys(input);
		
		gpn.getEmailtextfield().sendKeys("95692689");
		System.out.println("Email text field accepts numbers");
	    utilityclassobject.gettest().log(Status.PASS,"Email text field accepts numbers");	
	}
	
	@Test(dependsOnMethods = "TC_008VerifyGeneratorPortal_EmailwithNumbers")
	public void TC_009VerifyGeneratorPortal_Emailwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gpn.getEmailtextfield().click();
		gpn.getEmailtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getEmailtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 1, 3);
		gpn.getEmailtextfield().sendKeys(input);
		gpn.getEmailtextfield().sendKeys("@$@#%#");
		System.out.println("Email text field accepts specialcharacters");
	    utilityclassobject.gettest().log(Status.PASS,"Email text field accepts specialcharacters");	
	}
	
	@Test(dependsOnMethods = "TC_009VerifyGeneratorPortal_Emailwithspecialcharacters")
	public void TC_010VerfiyGeneratorPortal_EmailwithCombinationCharacters() throws EncryptedDocumentException, IOException
	{
		gpn.getEmailtextfield().click();
		gpn.getEmailtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getEmailtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 1, 4);
		gpn.getEmailtextfield().sendKeys(input);
		System.out.println("Email text field accepts specialcharacters");
	    utilityclassobject.gettest().log(Status.PASS,"Email text field accepts specialcharacters");	
	}
	
	@Test(dependsOnMethods = "TC_010VerfiyGeneratorPortal_EmailwithCombinationCharacters") 
	public void TC_011VerifyGeneratorPortal_EmailwithoutInput()
	{
		gpn.getEmailtextfield().click();
		gpn.getEmailtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getEmailtextfield().sendKeys(Keys.DELETE);
		gpn.getLogin().click();
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Invalid email format')]")));

				// Verify the error message
				String actualMessage = toast.getText();
				Assert.assertEquals(actualMessage,"Invalid email format");
				System.out.println("Error toast verified: " + actualMessage);
		System.out.println("Displayed invalid email format error message successfully");
	    utilityclassobject.gettest().log(Status.PASS,"Email text field accepts specialcharacters");	
	}
	
	
	@Test(dependsOnMethods = "TC_011VerifyGeneratorPortal_EmailwithoutInput")
	public void TC_012VerifyGeneratorPortal_EmailwithInvalidinput() throws EncryptedDocumentException, IOException
	{
		gpn.getEmailtextfield().click();
		gpn.getEmailtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getEmailtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 1, 6);
		gpn.getEmailtextfield().sendKeys(input);
		gpn.getLogin().click();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Invalid email format')]")));

				// Verify the error message
				String actualMessage = toast.getText();
				Assert.assertEquals(actualMessage,"Invalid email format");
				System.out.println("Error toast verified: " + actualMessage);
	    System.out.println("Displayed invalid email format error message successfully");
	    utilityclassobject.gettest().log(Status.PASS,"Email text field accepts specialcharacters");	
	}
	
	@Test(dependsOnMethods = "TC_012VerifyGeneratorPortal_EmailwithInvalidinput")
	public void TC_013VerifyGeneratorPortal_EmailwithValidInput() throws EncryptedDocumentException, IOException
	{
		gpn.getEmailtextfield().click();
		gpn.getEmailtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getEmailtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 1, 5);
		gpn.getEmailtextfield().sendKeys(input);
	    System.out.println("Not displayed any error message for valid mail");
	    utilityclassobject.gettest().log(Status.PASS,"Not displayed any error message for valid mail");	
	}
	
	@Test(dependsOnMethods = "TC_013VerifyGeneratorPortal_EmailwithValidInput")
	public void TC_014VerifyGeneratorPortal_Passwordtextfield()
	{
		gpn.getPasswordtextfield().isDisplayed();
		System.out.println("Password text field is present");
	    utilityclassobject.gettest().log(Status.PASS,"Password text field is present");			
	}
	
	@Test(dependsOnMethods = "TC_014VerifyGeneratorPortal_Passwordtextfield")
	public void TC_015VerifyGeneratorPortal_Passwordwithoutinput()
	{
		gpn.getPasswordtextfield().click();
		gpn.getLogin().click();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Password cannot be empty')]")));

				// Verify the error message
				String actualMessage = toast.getText();
				Assert.assertEquals(actualMessage,"Password cannot be empty");
				System.out.println("Error toast verified: " + actualMessage);
		System.out.println("Displayed erorr message as Password can not be empty");
	    utilityclassobject.gettest().log(Status.PASS,"Displayed erorr message as Password can not be empty");		
	}
	
	@Test(dependsOnMethods = "TC_015VerifyGeneratorPortal_Passwordwithoutinput")
	public void TC_016VerifyGeneratorPortal_Passwordwithalphabets() throws EncryptedDocumentException, IOException
	{
		gpn.getPasswordtextfield().click();
		gpn.getPasswordtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getPasswordtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 4, 1);
		gpn.getPasswordtextfield().sendKeys(input);
	    System.out.println("Password textfield accepts alphabets");
	    utilityclassobject.gettest().log(Status.PASS,"Password textfield accepts alphabets");	
	}
	
	@Test(dependsOnMethods = "TC_016VerifyGeneratorPortal_Passwordwithalphabets")
	public void TC_017VerifyGeneratorPortal_Passwordwithnumbers() throws EncryptedDocumentException, IOException
	{
		gpn.getPasswordtextfield().click();
		gpn.getPasswordtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getPasswordtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 4, 2);
		gpn.getPasswordtextfield().sendKeys(input);
	    System.out.println("Password textfield accepts numbers");
	    utilityclassobject.gettest().log(Status.PASS,"Password textfield accepts numbers");	
	}
	
	@Test(dependsOnMethods = "TC_017VerifyGeneratorPortal_Passwordwithnumbers")
	public void TC_018VerifyGeneratorPortal_Passwordwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gpn.getPasswordtextfield().click();
		gpn.getPasswordtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getPasswordtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 4, 3);
		gpn.getPasswordtextfield().sendKeys(input);
	    System.out.println("Password textfield accepts specialcharacters");
	    utilityclassobject.gettest().log(Status.PASS,"Password textfield accepts specialcharacters");	
	}
	
	@Test(dependsOnMethods = "TC_018VerifyGeneratorPortal_Passwordwithspecialcharacters")
	public void TC_019VerifyGeneratorPortal_Passwordwithcombinationofchar() throws EncryptedDocumentException, IOException
	{
		gpn.getPasswordtextfield().click();
		gpn.getPasswordtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getPasswordtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 4, 4);
		gpn.getPasswordtextfield().sendKeys(input);
	    System.out.println("Password textfield accepts combination of characters");
	    utilityclassobject.gettest().log(Status.PASS,"Password textfield accepts combination of characters");	
	}
	
	@Test(dependsOnMethods = "TC_019VerifyGeneratorPortal_Passwordwithcombinationofchar")
	public void TC_025VerifyGeneratorPortal_Passwordwithspaces()
	{
		gpn.getPasswordtextfield().click();
		gpn.getPasswordtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getPasswordtextfield().sendKeys(Keys.DELETE);
		gpn.getPasswordtextfield().sendKeys("     ");
		String value = gpn.getPasswordtextfield().getAttribute("value");
		gpn.getLogin().click();
		System.out.println("Entered value: [" + value + "]");
		System.out.println("Field length: " + value.length());
		System.out.println("Displayed passworsd can not be empty");
	    utilityclassobject.gettest().log(Status.PASS,"Displayed passworsd can not be empty");	
	}
	
	@Test(dependsOnMethods = "TC_025VerifyGeneratorPortal_Passwordwithspaces") 
	public void TC_033VerifyGeneratorPortal_withValidpassword() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(2000);
		gpn.getPasswordtextfield().click();
		gpn.getPasswordtextfield().sendKeys(Keys.CONTROL + "a");
		gpn.getPasswordtextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 4, 5);
		gpn.getPasswordtextfield().sendKeys(input);
	    System.out.println("Password textfield accepts combination of characters");
	    utilityclassobject.gettest().log(Status.PASS,"Password textfield accepts combination of characters");	
	}
	
	@Test(dependsOnMethods = "TC_033VerifyGeneratorPortal_withValidpassword")
	public void TC_035VerifyGeneratorPortal_PasswordwithVisibility() throws InterruptedException
	{
		gpn.getEyeicon().click();
		Thread.sleep(200);
		gpn.getEyeicon().click();
		System.out.println("User is able to view the entered password");
		utilityclassobject.gettest().log(Status.PASS,"User is able to view the entered password");		
	}
	
	@Test(dependsOnMethods = "TC_035VerifyGeneratorPortal_PasswordwithVisibility")
	public void TC_036VerifyGeneratorPortal_Forgotpasswordlink()
	{
		gpn.getForgotpassword().isDisplayed();
		gpn.getForgotpassword().click();
		WebElement page = driver.findElement(By.xpath("(//h3[contains(text(),'Forgot Password')]/ancestor::div)[6]"));
		page.isDisplayed();
		System.out.println("Forgot password link is displayed ");
		utilityclassobject.gettest().log(Status.PASS,"Forgot password link is displayed ");			
	}
	
	@Test(dependsOnMethods = "TC_036VerifyGeneratorPortal_Forgotpasswordlink")
	public void TC_037VerifyGeneratorPortal_Forgotpasswordpage()
	{
		WebElement page = driver.findElement(By.xpath("(//h3[contains(text(),'Forgot Password')]/ancestor::div)[6]"));
		page.isDisplayed();
		System.out.println("Forgot password page is displayed ");
		utilityclassobject.gettest().log(Status.PASS,"Forgot password page is displayed ");
	}
	
	@Test(dependsOnMethods = "TC_037VerifyGeneratorPortal_Forgotpasswordpage")
	public void TC_038VerifyGeneratorPortal_ForgotpasswordwithEmail()
	{
		gpn.getForgotpasswordEmail().isDisplayed();
		System.out.println("Successfully displayed Email  field");
		utilityclassobject.gettest().log(Status.PASS,"Successfully displayed Email  field");
		
	}
	
	@Test(dependsOnMethods = "TC_038VerifyGeneratorPortal_ForgotpasswordwithEmail")
	public void TC_039VerifyGeneratorPortal_ForgotpasswordwithValidemail() throws EncryptedDocumentException, IOException
	{
		gpn.getForgotpasswordEmail().click();
		gpn.getForgotpasswordEmail().sendKeys(Keys.CONTROL + "a");
		gpn.getForgotpasswordEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 7, 1);
		gpn.getForgotpasswordEmail().sendKeys(input);
		System.out.println("Forgotpassword email text field accepts valid mail Id");
		utilityclassobject.gettest().log(Status.PASS,"Forgotpassword email text field accepts valid mail Id");
	}
	
	@Test(dependsOnMethods = "TC_039VerifyGeneratorPortal_ForgotpasswordwithValidemail")
	public void TC_040VerifyGeneratorPortal_ForgotPasswordwithInvalidemail() throws EncryptedDocumentException, IOException
	{
		gpn.getForgotpasswordEmail().click();
		gpn.getForgotpasswordEmail().sendKeys(Keys.CONTROL + "a");
		gpn.getForgotpasswordEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 7, 2);
		gpn.getForgotpasswordEmail().sendKeys(input);
		gpn.getSubmitButton().click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Invalid email format')]")));

				// Verify the error message
				String actualMessage = toast.getText();
				Assert.assertEquals(actualMessage,"Invalid email format");
				System.out.println("Error toast verified: " + actualMessage);
		System.out.println("Forgot password email text field will not accept invalid email displayed invalid email format error message");
		utilityclassobject.gettest().log(Status.PASS,"Forgot password email text field will not accept invalid email displayed invalid email format error message");
	}
	
	@Test(dependsOnMethods = "TC_040VerifyGeneratorPortal_ForgotPasswordwithInvalidemail")
	public void TC_041VerifyGeneratorPortal_SubmitButton()
	{
		gpn.getSubmitButton().isDisplayed();
		System.out.println("Submit Button is displayed");
		utilityclassobject.gettest().log(Status.PASS,"Submit Button is displayed");
		
	}
	
	//Defect need to be fixed
	
	/*@Test
	public void TC_042VerifyGeneratorPortal_ForgotpasswordEmaillink()
	{
		gpn.getForgotpasswordEmail().click();
		gpn.getForgotpasswordEmail().sendKeys(Keys.CONTROL + "a");
		gpn.getForgotpasswordEmail().sendKeys(Keys.DELETE);
		gpn.getForgotpasswordEmail().sendKeys("henrry123@gmail.com");
		gpn.getSubmitButton().click();
		System.out.println("Submit Button is displayed");
		utilityclassobject.gettest().log(Status.PASS,"Submit Button is displayed");
		
		
	}*/
	
	@Test(dependsOnMethods = "TC_041VerifyGeneratorPortal_SubmitButton")
	public void TC_043VerifyGeneratorPortal_Backtologin()
	{
		gpn.getBacktoLoginButton().click();
		gpn.getWelcomepage().isDisplayed();
		System.out.println("Successfully Redirected to welcome page");
		utilityclassobject.gettest().log(Status.PASS,"Successfully Redirected to welcome page");
	}
	
	@Test(dependsOnMethods = "TC_043VerifyGeneratorPortal_Backtologin")
	public void TC_045VerifyGenratorPortal_WelcomepageIncognitomode() throws InterruptedException
	{
		   ChromeOptions options = new ChromeOptions();
		    options.addArguments("--incognito");

		    ChromeDriver incognitoDriver = new ChromeDriver(options);
		    incognitoDriver.manage().window().maximize();

		    try {
		        // Open the Generator Login Portal
		        incognitoDriver.get("https://dev.octopussaas.com/generator-portal-auth?transporterId=vuLql6DPJAheAtEE1nlrLnzk1L22");

		        WebDriverWait wait = new WebDriverWait(
		            incognitoDriver, Duration.ofSeconds(15));

		        WebElement welcome = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//*[contains(text(),'Welcome')]")
		            )
		        );

		        Assert.assertTrue( welcome.isDisplayed(), "Welcome page is not displayed");

		    } finally {
		        // Close only the Incognito browser session
		        incognitoDriver.quit();
		    }

		    System.out.println("Welcomepage is displayed successfully");
			utilityclassobject.gettest().log(Status.PASS,"Welcomepage is displayed successfully");
		    
	}
	
	@Test(dependsOnMethods = "TC_045VerifyGenratorPortal_WelcomepageIncognitomode")
	public void TC_046VerifyGeneratorPortal_HomepageIncognitmode() throws InterruptedException
	{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			
			ChromeDriver incognitoDriver = new ChromeDriver(options);
			incognitoDriver.manage().window().maximize();
			
			try {
			    // Open the Generator Login Portal
			    incognitoDriver.get("https://dev.octopussaas.com/generator-portal-auth?transporterId=vuLql6DPJAheAtEE1nlrLnzk1L22");
			
			    WebDriverWait wait = new WebDriverWait(incognitoDriver, Duration.ofSeconds(15));
			  // Verify Welcome page
			    WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[contains(text(),'Welcome')]")));
			
			    Assert.assertTrue(welcome.isDisplayed(), "Welcome page is displayed");
			
			    // Enter email in Incognito window
			    WebElement emailtextfield = wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Email']")));
			    emailtextfield.sendKeys("henrry123@gmail.com");
			
			    // Enter password in Incognito window
			    WebElement passwordtextfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Password']")));
			    passwordtextfield.sendKeys("Henry123!@");
			
			    // Click Login in Incognito window
			    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//button[contains(text(),'Login')]")));
			    loginButton.click();
			
			    Thread.sleep(4000);
			
			} finally {
			    // Close only the Incognito WebDriver session
			    incognitoDriver.quit();
			}
			System.out.println("Login page is displayed");
			utilityclassobject.gettest().log(Status.PASS,"Login page is displayed");
	}
	
	
	@Test(dependsOnMethods = "TC_046VerifyGeneratorPortal_HomepageIncognitmode")
	public void TC_047VerifyGeneratorPortal_NewuserRegisrationButton()
	{
		elib =new ExcelUtility();
		gpn.getNewuserRegistrationButton().isDisplayed();
		System.out.println("new user registration button displayed successfully");
		utilityclassobject.gettest().log(Status.PASS,"new user registration button displayed successfully");
		
	}
	
	@Test(dependsOnMethods = "TC_047VerifyGeneratorPortal_NewuserRegisrationButton")
	public void TC_048VerifyGeneratorPortal_NewuserRegistration()
	{
		gpn.getNewuserRegistrationButton().click();
		System.out.println("user is able to click on new user registration button successfully");
		utilityclassobject.gettest().log(Status.PASS,"user is able to click on new user registration button successfully");
		
	}
	
	@Test(dependsOnMethods = "TC_048VerifyGeneratorPortal_NewuserRegistration")
	public void TC_049VerifyGeneratorPortal_UserRegistrationpage()
	{
		gpn.getUserRegistrationPage().isDisplayed();
		System.out.println("New user registration  page displayed successfully");
		utilityclassobject.gettest().log(Status.PASS,"New user registration  page displayed successfully");		
		
	}
	
	@Test(dependsOnMethods = "TC_049VerifyGeneratorPortal_UserRegistrationpage")
	public void TC_050VerifyGeneratorPortal_FirstnamewithAlphabets() throws EncryptedDocumentException, IOException
	{
		gpn.getFirstname().click();
		gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
		gpn.getFirstname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 10, 1);
		gpn.getFirstname().sendKeys(input);
		System.out.println("First name textfield accepts alphabets");
		utilityclassobject.gettest().log(Status.PASS,"First name textfield accepts alphabets");		
			
	}
	
	@Test(dependsOnMethods = "TC_050VerifyGeneratorPortal_FirstnamewithAlphabets")
	public void TC_051VerifyGeneratorPortal_FirstnamewithNumbers() throws EncryptedDocumentException, IOException
	{
		gpn.getFirstname().click();
		gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
		gpn.getFirstname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 10, 2);
		gpn.getFirstname().sendKeys(input);
		System.out.println("First name textfield accepts numbers");
		utilityclassobject.gettest().log(Status.PASS,"First name textfield accepts numbers");		
			
	}
	
	@Test(dependsOnMethods = "TC_051VerifyGeneratorPortal_FirstnamewithNumbers")
	public void TC_052VerifyGeneratorPortal_FirstnameWithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		
		gpn.getFirstname().click();
		gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
		gpn.getFirstname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 10, 3);
		gpn.getFirstname().sendKeys(input);
		System.out.println("First name textfield accepts specialcharacters");
		utilityclassobject.gettest().log(Status.PASS,"First name textfield accepts specialcharacters");		
	}
	
	@Test(dependsOnMethods = "TC_052VerifyGeneratorPortal_FirstnameWithSpecialcharacters")
	public void TC_053VerifyGeneratorPortal_FirstnamewithcombinationofCharacters() throws EncryptedDocumentException, IOException
	{
		gpn.getFirstname().click();
		gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
		gpn.getFirstname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 10, 4);
		gpn.getFirstname().sendKeys(input);
		System.out.println("First name textfield accepts combination of characters");
		utilityclassobject.gettest().log(Status.PASS,"First name textfield accepts combination of characters");		
	}
	
	@Test(dependsOnMethods = "TC_053VerifyGeneratorPortal_FirstnamewithcombinationofCharacters")
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
	public void TC_055VerifyGeneratorPortal_FirstnamewithoutInput()
	{
		gpn.getFirstname().click();
		gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
		gpn.getFirstname().sendKeys(Keys.DELETE);
		gpn.getRegisternowButton().click();
		
		String actualMessage = gpn.getFirstname().getAttribute("validationMessage");
		System.out.println("Actual validation message: " + actualMessage);
		Assert.assertEquals(actualMessage,"Please fill out this field.");
		System.out.println("First name textfield without input Displayed suggestion as please fill out this field");
		utilityclassobject.gettest().log(Status.PASS,"First name textfield without input Displayed suggestion as please fill out this field");		
		
		
	}
	
	@Test(dependsOnMethods = "TC_055VerifyGeneratorPortal_FirstnamewithoutInput")
	public void TC_056VerifyGenratorPortal_LastnamewithAlphabets() throws EncryptedDocumentException, IOException
	{
		gpn.getLastname().click();
		gpn.getLastname().sendKeys(Keys.CONTROL+"a");
		gpn.getLastname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 13, 1);
		gpn.getLastname().sendKeys(input);
		System.out.println("Last name textfield accepts alphabets");
		utilityclassobject.gettest().log(Status.PASS,"Last name textfield accepts alphabets");				
		
	}
	
	@Test(dependsOnMethods = "TC_056VerifyGenratorPortal_LastnamewithAlphabets")
	public void TC_057VerifyGneratorPortal_LastnamewithNumbers() throws EncryptedDocumentException, IOException
	{
		gpn.getLastname().click();
		gpn.getLastname().sendKeys(Keys.CONTROL+"a");
		gpn.getLastname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 13, 2);
		gpn.getLastname().sendKeys(input);
		System.out.println("Last name textfield accepts numbers");
		utilityclassobject.gettest().log(Status.PASS,"Last name textfield accepts numbers");				
	}
	
	@Test(dependsOnMethods = "TC_057VerifyGneratorPortal_LastnamewithNumbers")
	public void TC_058VerifyGeneratorPortal_Lastnamewithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		gpn.getLastname().click();
		gpn.getLastname().sendKeys(Keys.CONTROL+"a");
		gpn.getLastname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 13, 3);
		gpn.getLastname().sendKeys(input);
		System.out.println("Last name textfield accepts specialcharacters");
		utilityclassobject.gettest().log(Status.PASS,"Last name textfield accepts specialcharacters");			
		
	}
	
	@Test(dependsOnMethods = "TC_058VerifyGeneratorPortal_Lastnamewithspecialcharacters")
	public void TC_059VerifyGeneratorPortal_LastnamewithCombinationofChar() throws EncryptedDocumentException, IOException
	{
		gpn.getLastname().click();
		gpn.getLastname().sendKeys(Keys.CONTROL+"a");
		gpn.getLastname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 13, 4);
		gpn.getLastname().sendKeys(input);
		System.out.println("Last name textfield accepts combination of characters");
		utilityclassobject.gettest().log(Status.PASS,"Last name textfield accepts combination of characters");				
		
	}
	
	@Test(dependsOnMethods = "TC_059VerifyGeneratorPortal_LastnamewithCombinationofChar")
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
	public void TC_061VerifyGeneratorPortal_LastnamewithoutInput()
	{
		gpn.getFirstname().click();
		gpn.getFirstname().sendKeys("Jhon");
		gpn.getLastname().click();
		gpn.getLastname().sendKeys(Keys.CONTROL+"a");
		gpn.getLastname().sendKeys(Keys.DELETE);
		gpn.getRegisternowButton().click();
		
		
		String actualMessage = gpn.getLastname().getAttribute("validationMessage");
		System.out.println("Actual validation message: " + actualMessage);
		Assert.assertEquals(actualMessage,"Please fill out this field.");
		System.out.println("Displayed suggestion as please fill out this field");
		utilityclassobject.gettest().log(Status.PASS,"Displayed suggestion as please fill out this field");
	}
	
	@Test(dependsOnMethods = "TC_061VerifyGeneratorPortal_LastnamewithoutInput")
	public void TC_062VerifyGeneratorPortal_RegEmailwithAlphabets() throws EncryptedDocumentException, IOException
	
	
	{
		gpn.getRegEmail().click();
		gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
		gpn.getRegEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 16, 1);
		gpn.getRegEmail().sendKeys(input);
		System.out.println("Email text field accepts alphabets");
		utilityclassobject.gettest().log(Status.PASS,"Email text field accepts alphabets");
	}
	
	@Test(dependsOnMethods = "TC_062VerifyGeneratorPortal_RegEmailwithAlphabets")
	public void TC_063VerifyGeneratorPortal_RegEmailwithNumbers() throws EncryptedDocumentException, IOException
	{
		gpn.getRegEmail().click();
		gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
		gpn.getRegEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 16, 2);
		gpn.getRegEmail().sendKeys(input);
		System.out.println("Email text field accepts numbers");
		utilityclassobject.gettest().log(Status.PASS,"Email text field accepts numbers");
	}
	
	@Test(dependsOnMethods = "TC_063VerifyGeneratorPortal_RegEmailwithNumbers")
	public void TC_064VerifyGeneratorPortal_RegEmailwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		gpn.getRegEmail().click();
		gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
		gpn.getRegEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 16, 3);
		gpn.getRegEmail().sendKeys(input);
		System.out.println("Email text field accepts specialcharacters");
		utilityclassobject.gettest().log(Status.PASS,"Email text field accepts specialcharacters");
	}
	
	@Test(dependsOnMethods = "TC_064VerifyGeneratorPortal_RegEmailwithSpecialcharacters")
	public void TC_065VerifyGeneratorPortal_RegEmailwithoutInput() throws EncryptedDocumentException, IOException
	{
		gpn.getLastname().click();
		gpn.getLastname().sendKeys(Keys.CONTROL+"a");
		gpn.getLastname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 13, 5);
		gpn.getLastname().sendKeys(input);	
		gpn.getRegEmail().click();
		gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
		
		gpn.getRegEmail().sendKeys(Keys.DELETE);
		gpn.getRegisternowButton().click();
		
		String actualMessage = gpn.getRegEmail().getAttribute("validationMessage");
		System.out.println("Actual validation message: " + actualMessage);
		Assert.assertEquals(actualMessage,"Please fill out this field.");
		System.out.println("Displayed suggestion as please fill out this field");
		utilityclassobject.gettest().log(Status.PASS,"Displayed suggestion as please fill out this field");
		
	}
	
	@Test(dependsOnMethods = "TC_065VerifyGeneratorPortal_RegEmailwithoutInput")
	public void TC_066VerifyGneratorPortal_RegEmailwithInvalidInput() throws EncryptedDocumentException, IOException
	{
		gpn.getRegEmail().click();
		gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
		gpn.getRegEmail().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("GeneratorPortal", 1, 4);
		gpn.getRegEmail().sendKeys(input);
		
		String actualMessage = gpn.getRegEmail().getAttribute("validationMessage");
		System.out.println("Actual validation message: " + actualMessage);
		System.out.println("A part of following '@' should not contain the symbol '@', ',','#'' etc suggestion is displayed");
		utilityclassobject.gettest().log(Status.PASS,"A part of following '@' should not contain the symbol '@', ',','#'' etc suggestion is displayed");
	}
	
	@Test(dependsOnMethods = "TC_066VerifyGneratorPortal_RegEmailwithInvalidInput")
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
	public void TC_068VerifyGeneratorPortal_PhonenumberwithAlphabets() throws EncryptedDocumentException, IOException
	{
		  gpn.getPhoneNumber().click();
		  gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
		  gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorPortal", 19, 1);
		  gpn.getPhoneNumber().sendKeys(input); 
		  String actualValue = gpn.getPhoneNumber().getAttribute("value");
		  
		  if(actualValue.matches(".*[a-zA-Z].*")) 
		  {
			  
			  
		  System.out.println("Phone number text field accepted alphabets. :PASS");
		  utilityclassobject.gettest().log(Status.FAIL,"Phone number text field accepted alphabets."); 
		  } 
		  else { System.out.println("Phone number text field does not accept alphabets. : PASS");
		  utilityclassobject.gettest().log(Status.PASS,"Phone number text field does not accept alphabets."); 
		  }
		  System.out.println("Phone number text field does not accept alphabets");
		  utilityclassobject.gettest().log(Status.PASS,"Phone number text field does not accept alphabet."); 
	}
	
	@Test(dependsOnMethods = "TC_068VerifyGeneratorPortal_PhonenumberwithAlphabets")
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
	public void TC_070VerifyGeneratorPortal_Phonenumberwithspecialcharacters() throws EncryptedDocumentException, IOException
	{
		  gpn.getPhoneNumber().click();
		  gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
		  gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorPortal", 19, 3);
		  gpn.getPhoneNumber().sendKeys(input); 
		  String actualValue = gpn.getPhoneNumber().getAttribute("value");
		  
		  if(actualValue.matches(".*[#$-%@-^&*].*")) 
		  {
		  System.out.println("Phone number text field accepted specialcharacters. :PASS");
		  utilityclassobject.gettest().log(Status.FAIL,"Phone number text field accepted specialcharacters."); 
		  } 
		  else { System.out.println("Phone number text field does not accept specialcharacters. : PASS");
		  utilityclassobject.gettest().log(Status.PASS,"Phone number text field does not accept specialcharacters."); 
		  }
		  System.out.println("Phone number text field does not accept specialcharacters");
		  utilityclassobject.gettest().log(Status.PASS,"Phone number text field does not accept specialcharacters"); 
	}
	
	@Test(dependsOnMethods = "TC_070VerifyGeneratorPortal_Phonenumberwithspecialcharacters")
	public void TC_071VerifyGeneratorPortal_PhonenumberwithMorethan10digits() throws EncryptedDocumentException, IOException
	{
		  gpn.getPhoneNumber().click();
		  gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
		  gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
		  String input = elib.getDataFromExcel("GeneratorPortal", 19, 4);
		  gpn.getPhoneNumber().sendKeys(input); 
		  String actualValue = gpn.getPhoneNumber().getAttribute("value");
		  
		  if(actualValue.length() == 10) 
		  {
		  System.out.println("Phone number text field accepted more than 10 digits. :PASS");
		  utilityclassobject.gettest().log(Status.FAIL,"Phone number text field accepted more than 10 digits"); 
		  } 
		  else { System.out.println("Phone number text field does not accept more than 10 digits: PASS");
		  utilityclassobject.gettest().log(Status.PASS,"Phone number text field does not accept more than 10 digits"); 
		  }
		  
		  
		  
		  System.out.println("Phone number text field does not accept more than 10 digits");
		  utilityclassobject.gettest().log(Status.PASS,"Phone number text field does not accept more than 10 digits"); 
	}
	
	
		@Test(dependsOnMethods = "TC_071VerifyGeneratorPortal_PhonenumberwithMorethan10digits")
		public void TC_072VerifyGeneratorPortal_PhonenumberwithShortInput() throws EncryptedDocumentException, IOException
		{
			  gpn.getPhoneNumber().click();
			  gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
			  gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 19, 5);
			  gpn.getPhoneNumber().sendKeys(input); 
			  gpn.getRegisternowButton().click();
			  
			  
			  System.out.println("Phone number text field does not accept less than 10 digits and Enter valid phone number is required messge is displayed");
			  utilityclassobject.gettest().log(Status.PASS,"Phone number text field does not accept less than 10 digits and Enter valid phone number is required messge is displayeds"); 
		}
		
		@Test(dependsOnMethods = "TC_072VerifyGeneratorPortal_PhonenumberwithShortInput")
		public void TC_073VerifyGeneratorPortal_PhonenumberwithoutInput() throws EncryptedDocumentException, IOException
		{
			  gpn.getPhoneNumber().click();
			  gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
			  gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
			  gpn.getRegisternowButton().click();
			  
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Valid phone number is required')]")));

					// Verify the error message
					String actualMessage = toast.getText();
					Assert.assertEquals(actualMessage,"Valid phone number is required");
					System.out.println("Error toast verified: " + actualMessage);
			  gpn.getPhoneNumber().click();
			  String input = elib.getDataFromExcel("GeneratorPortal", 19, 2);
			  gpn.getPhoneNumber().sendKeys(input); 
			  System.out.println("Phone number text field wihtout input Enter valid phone number is required messge is displayed");
			  utilityclassobject.gettest().log(Status.PASS,"Phone number text field wihtout input Enter valid phone number is required messge is displayed"); 
			
		}
		
		@Test(dependsOnMethods = "TC_073VerifyGeneratorPortal_PhonenumberwithoutInput")
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
		public void TC_075VerifyGeneratorPortal_CompanynamewithNumbers() throws EncryptedDocumentException, IOException
		{
			  gpn.getCompanyname().click();
			  gpn.getCompanyname().sendKeys(Keys.CONTROL + "a");
			  gpn.getCompanyname().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 22, 2);
			  gpn.getCompanyname().sendKeys(input); 
			  System.out.println("Company name text field accepts numbers");
			  utilityclassobject.gettest().log(Status.PASS,"Company name text field accepts numbers"); 
			
		}
		
		@Test(dependsOnMethods = "TC_075VerifyGeneratorPortal_CompanynamewithNumbers")
		public void TC_076VerifyGeneratorPortal_CompanynamewithSpecialcharacters() throws EncryptedDocumentException, IOException
		{
			  gpn.getCompanyname().click();
			  gpn.getCompanyname().sendKeys(Keys.CONTROL + "a");
			  gpn.getCompanyname().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 22, 3);
			  gpn.getCompanyname().sendKeys(input); 
			  System.out.println("Company name text field accepts specialcharacters");
			  utilityclassobject.gettest().log(Status.PASS,"Company name text field accepts specialcharacters"); 
		}
		
		@Test(dependsOnMethods = "TC_076VerifyGeneratorPortal_CompanynamewithSpecialcharacters")
		public void TC_077VerifyGeneratorPortal_CompanynamewithoutInput() throws EncryptedDocumentException, IOException
		{
			  gpn.getCompanyname().click();
			  gpn.getCompanyname().sendKeys(Keys.CONTROL + "a");
			  gpn.getCompanyname().sendKeys(Keys.DELETE); 
			  gpn.getRegisternowButton().click();
			  
			  
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Company name is required')]")));

					// Verify the error message
					String actualMessage = toast.getText();
					Assert.assertEquals(actualMessage,"Company name is required");
					System.out.println("Error toast verified: " + actualMessage);
			  
			  gpn.getCompanyname().click();
			  String input = elib.getDataFromExcel("GeneratorPortal", 22, 1);
			  gpn.getCompanyname().sendKeys(input);
			  
			  System.out.println("Company name text field wihtout input company name is required error message is displayed");
			  utilityclassobject.gettest().log(Status.PASS,"Company name text field wihtout input company name is required error message is displayed"); 
		}
		
		@Test(dependsOnMethods = "TC_077VerifyGeneratorPortal_CompanynamewithoutInput")
		public void TC_078VerifyGeneratorPortal_SerivcelocationwithAlphabets() throws EncryptedDocumentException, IOException
		{
			  gpn.getSerivcelocationAddress().click();
			  gpn.getSerivcelocationAddress().sendKeys(Keys.CONTROL + "a");
			  gpn.getSerivcelocationAddress().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 25, 1);
			  gpn.getSerivcelocationAddress().sendKeys(input); 
			  System.out.println("Serivce location address text field accepts alphabets");
			  utilityclassobject.gettest().log(Status.PASS,"Serivce location address text field accepts alphabets"); 
		}
		
		@Test(dependsOnMethods = "TC_078VerifyGeneratorPortal_SerivcelocationwithAlphabets")
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
		public void TC_080VerifyGeneratorPortal_ServicelocationwithSpecialcharacters() throws EncryptedDocumentException, IOException
		{
			  gpn.getSerivcelocationAddress().click();
			  gpn.getSerivcelocationAddress().sendKeys(Keys.CONTROL + "a");
			  gpn.getSerivcelocationAddress().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 25, 3);
			  gpn.getSerivcelocationAddress().sendKeys(input); 
			  System.out.println("Serivce location address text field accepts specialcharacters");
			  utilityclassobject.gettest().log(Status.PASS,"Serivce location address text field accepts specialcharacters"); 
		}
		
		@Test(dependsOnMethods = "TC_080VerifyGeneratorPortal_ServicelocationwithSpecialcharacters")
		public void TC_081VerifyGeneratorPortal_SerivcelocationwihtoutInput() throws EncryptedDocumentException, IOException, InterruptedException
		{
			  gpn.getSerivcelocationAddress().click();
			  gpn.getSerivcelocationAddress().sendKeys(Keys.CONTROL + "a");
			  gpn.getSerivcelocationAddress().sendKeys(Keys.DELETE); 
			  gpn.getRegisternowButton().click();
			  
			  
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			  WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Service location address is required')]")));

					// Verify the error message
					String actualMessage = toast.getText();
					Assert.assertEquals(actualMessage,"Service location address is required");
					System.out.println("Error toast verified: " + actualMessage); 
					Thread.sleep(2000);
			  gpn.getSerivcelocationAddress().click();
			  String input = elib.getDataFromExcel("GeneratorPortal", 25, 2);
			  gpn.getSerivcelocationAddress().sendKeys(input); 
			  System.out.println("Serivce location address text field without input, Service location address is required error message is displayed");
			  utilityclassobject.gettest().log(Status.PASS,"Serivce location address text field without input, Service location address is required error message is displayed"); 
		}
		
		@Test(dependsOnMethods = "TC_081VerifyGeneratorPortal_SerivcelocationwihtoutInput")
		public void TC_082VerifyGeneratorPortal_AccountnumberwithAlphabets() throws EncryptedDocumentException, IOException
		{
			  gpn.getAccountNumber().click();
			  gpn.getAccountNumber().sendKeys(Keys.CONTROL + "a");
			  gpn.getAccountNumber().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 28, 1);
			  gpn.getAccountNumber().sendKeys(input); 
			  String actualValue = gpn.getAccountNumber().getAttribute("value");
			  
			  if(actualValue.matches(".*[a-zA-Z].*")) 
			  {
			  System.out.println("Account number text field accepted alphabets. :PASS");
			  utilityclassobject.gettest().log(Status.FAIL,"Account number text field accepted alphabets."); 
			  } 
			  else { System.out.println("Account number text field does not accept alphabets. : PASS");
			  utilityclassobject.gettest().log(Status.PASS,"Account number text field does not accept alphabets."); 
			  }
			  System.out.println("Account number text field does not accept alphabets");
			  utilityclassobject.gettest().log(Status.PASS,"Account number text field does not accept alphabet."); 
			
		}
		
		@Test(dependsOnMethods = "TC_082VerifyGeneratorPortal_AccountnumberwithAlphabets")
		public void TC_083VerifyGeneratorPortal_AccountnumberwithNumbers() throws EncryptedDocumentException, IOException
		{
			  gpn.getAccountNumber().click();
			  gpn.getAccountNumber().sendKeys(Keys.CONTROL + "a");
			  gpn.getAccountNumber().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 28, 2);
			  gpn.getAccountNumber().sendKeys(input); 
			  System.out.println("Account number text field accepts numbers");
			  utilityclassobject.gettest().log(Status.PASS,"Account number text field accepts numbers"); 
		}
		
		@Test(dependsOnMethods = "TC_083VerifyGeneratorPortal_AccountnumberwithNumbers")
		public void TC_084VeriyGeneratorPortal_AccountnumberwithSpecialcharacters() throws EncryptedDocumentException, IOException
		{
			  gpn.getAccountNumber().click();
			  gpn.getAccountNumber().sendKeys(Keys.CONTROL + "a");
			  gpn.getAccountNumber().sendKeys(Keys.DELETE); 
			  String input = elib.getDataFromExcel("GeneratorPortal", 28, 1);
			  gpn.getAccountNumber().sendKeys(input); 
			  String actualValue = gpn.getAccountNumber().getAttribute("value");
			  
			  if(actualValue.matches(".*[#-$%-^&].*")) 
			  {
			  System.out.println("Account number text field accepted alphabets. :PASS");
			  utilityclassobject.gettest().log(Status.FAIL,"Account number text field accepted alphabets."); 
			  } 
			  else { System.out.println("Account number text field does not accept alphabets. : PASS");
			  utilityclassobject.gettest().log(Status.PASS,"Account number text field does not accept alphabets."); 
			  }
			  System.out.println("Account number text field does not accept alphabets");
			  utilityclassobject.gettest().log(Status.PASS,"Account number text field does not accept alphabet."); 
		}
		
		@Test(dependsOnMethods = "TC_084VeriyGeneratorPortal_AccountnumberwithSpecialcharacters")
		public void TC_085VerifyGeneratorPortal_AccountnumberwithoutInput()
		{
			  gpn.getAccountNumber().click();
			  gpn.getAccountNumber().sendKeys(Keys.CONTROL + "a");
			  gpn.getAccountNumber().sendKeys(Keys.DELETE); 
			  System.out.println("Not displayed any error message it is not mandatory field");
			  utilityclassobject.gettest().log(Status.PASS,"Not displayed any error message it is not mandatory field"); 
		}
		
		@Test(dependsOnMethods = "TC_085VerifyGeneratorPortal_AccountnumberwithoutInput")
		public void TC_086VerifyGeneatorPortal_Alreadyhaveanaccount()
		{
			gpn.getAlreadyhaveanaccount().click();
			gpn.getWelcomepage().isDisplayed();
			System.out.println("Not displayed any error message it is not mandatory field");
			utilityclassobject.gettest().log(Status.PASS,"Not displayed any error message it is not mandatory field");
			
			
		}
		
		@Test(dependsOnMethods = "TC_086VerifyGeneatorPortal_Alreadyhaveanaccount")
		public void TC_087VerifyGeneratorPortal_NewuserwithexistingEmail() throws EncryptedDocumentException, IOException, InterruptedException
		{
			gpn.getNewuserRegistrationButton().click();
			gpn.getFirstname().click();
			gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
			gpn.getFirstname().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorPortal", 10, 5);
			gpn.getFirstname().sendKeys(input);
			
			gpn.getLastname().click();
			gpn.getLastname().sendKeys(Keys.CONTROL+"a");
			gpn.getLastname().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("GeneratorPortal", 13, 5);
			gpn.getLastname().sendKeys(input1);	
			
			gpn.getRegEmail().click();
			gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
			gpn.getRegEmail().sendKeys(Keys.DELETE);
			String input2 = elib.getDataFromExcel("GeneratorPortal", 16, 4);
			gpn.getRegEmail().sendKeys(input2);
			
			gpn.getPhoneNumber().click();
			gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
			gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
			String input3 = elib.getDataFromExcel("GeneratorPortal", 19, 2);
			gpn.getPhoneNumber().sendKeys(input3); 
				
			gpn.getCompanyname().click();
			gpn.getCompanyname().sendKeys(Keys.CONTROL + "a");
			gpn.getCompanyname().sendKeys(Keys.DELETE); 
			String input4 = elib.getDataFromExcel("GeneratorPortal", 22, 1);
			gpn.getCompanyname().sendKeys(input4);
			
			gpn.getSerivcelocationAddress().click();
			gpn.getSerivcelocationAddress().sendKeys(Keys.CONTROL + "a");
			gpn.getSerivcelocationAddress().sendKeys(Keys.DELETE); 
			String input5 = elib.getDataFromExcel("GeneratorPortal", 25, 1);
			gpn.getSerivcelocationAddress().sendKeys(input5); 
			
			gpn.getRegisternowButton().click();
			WebElement page = driver.findElement(By.xpath("(//h3[contains(text(),'Forgot Password')]/ancestor::div)[6]"));
			page.isDisplayed();
			String text = gpn.getForgotpasswordEmail().getText();
			System.out.println(text);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'An account with this email already exists. Please use Forgot Password to recover access.')]")));
			String actualMessage = toast.getText();
			Assert.assertEquals(actualMessage,"An account with this email already exists. Please use Forgot Password to recover access.");
			System.out.println("Error toast verified: " + actualMessage);
			Thread.sleep(20000);
			System.out.println("It got redirected to the forgot password page and An account with this email already exists. Please use Forgot password to recover access message is displayed");
			utilityclassobject.gettest().log(Status.PASS,"It got redirected to the forgot password page and An account with this email already exists. Please use Forgot password to recover access message is displayed"); 
		}
		
		
		@Test(dependsOnMethods = "TC_087VerifyGeneratorPortal_NewuserwithexistingEmail")
		public void TC_088VerifyGeneratorPortal_withNewuserRegistration() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
		{
			gpn.getBacktoLogin().click();
			gpn.getNewuserRegistrationButton().click();
			gpn.getFirstname().click();
			gpn.getFirstname().sendKeys(Keys.CONTROL+"a");
			gpn.getFirstname().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("GeneratorPortal", 10, 5);
			gpn.getFirstname().sendKeys(input);
			
			gpn.getLastname().click();
			gpn.getLastname().sendKeys(Keys.CONTROL+"a");
			gpn.getLastname().sendKeys(Keys.DELETE);
			String input1 = elib.getDataFromExcel("GeneratorPortal", 13, 5);
			gpn.getLastname().sendKeys(input1);	
			
			gpn.getRegEmail().click();
			gpn.getRegEmail().sendKeys(Keys.CONTROL+"a");
			gpn.getRegEmail().sendKeys(Keys.DELETE);
			Random random = new Random();
			
			int fourdigit = 1000+random.nextInt(9000);
			input2 = elib.getDataFromExcel("GeneratorPortal", 13, 5)+fourdigit+"@gmail.com";
			gpn.getRegEmail().sendKeys(input2);	
			
			gpn.getPhoneNumber().click();
			gpn.getPhoneNumber().sendKeys(Keys.CONTROL + "a");
			gpn.getPhoneNumber().sendKeys(Keys.DELETE); 
			String input3 = elib.getDataFromExcel("GeneratorPortal", 19, 2);
			gpn.getPhoneNumber().sendKeys(input3); 
				
			gpn.getCompanyname().click();
			gpn.getCompanyname().sendKeys(Keys.CONTROL + "a");
			gpn.getCompanyname().sendKeys(Keys.DELETE); 
			String input4 = elib.getDataFromExcel("GeneratorPortal", 22, 1);
			gpn.getCompanyname().sendKeys(input4);
			
			gpn.getSerivcelocationAddress().click();
			gpn.getSerivcelocationAddress().sendKeys(Keys.CONTROL + "a");
			gpn.getSerivcelocationAddress().sendKeys(Keys.DELETE); 
			String input5 = elib.getDataFromExcel("GeneratorPortal", 25, 1);
			gpn.getSerivcelocationAddress().sendKeys(input5); 
			
			gpn.getRegisternowButton().click();
			WebElement text = driver.findElement(By.xpath("//h3[contains (text(),'Verify Your Email')]"));
			text.isDisplayed();	
			System.out.println("It displayed verification code has been sent to your email and also it redirect to verify your email page");
			utilityclassobject.gettest().log(Status.PASS,"It displayed verification code has been sent to your email and also it redirect to verify your email page"); 
			
			
		}
		
		@Test(dependsOnMethods = "TC_088VerifyGeneratorPortal_withNewuserRegistration")
		public void TC_089VerifyGeneratorPortal_RegistrationPage() throws InterruptedException
		{
			String parentWindow = null;

			Set<String> allWindows = driver.getWindowHandles();

			System.out.println("Window Count: " + allWindows.size());

			// Find the parent window using its URL
			for (String window : allWindows) {
			    driver.switchTo().window(window);

			    String currentUrl = driver.getCurrentUrl();

			    System.out.println("Handle: " + window);
			    System.out.println("URL: " + currentUrl);

			    if (currentUrl.contains("/admin/profile")) {
			        parentWindow = window;
			        break;
			    }
			}

			// Switch back to the parent window
			if (parentWindow != null) {
			    driver.switchTo().window(parentWindow);

			    System.out.println("---- Switched to Parent Window ----");
			    System.out.println("Current Handle: " + driver.getWindowHandle());
			    System.out.println("Current URL: " + driver.getCurrentUrl());
			    System.out.println("Current Title: " + driver.getTitle());
			} else {
			    System.out.println("Parent window not found!");
			}
			 
			
			WebElement management = driver.findElement(By.xpath("//h6[contains (text(),'Generator Management')]"));
			management.click();
			WebElement contacts = driver.findElement(By.xpath("//h6[contains (text(),'Generator Contacts')]"));
			contacts.click();
			WebElement placefolder = driver.findElement(By.xpath("//input[@placeholder='Search by name, email or phone...']"));
			placefolder.click();
			placefolder.sendKeys(input2);
			Thread.sleep(200);
			String authcode = driver.findElement(By.xpath("(//span[@class='text-xs px-2 py-0.5 bg-blue-50 text-blue-700 rounded-full'])[2]")).getText();		
			System.out.println(authcode);
			
			Thread.sleep(2000);			
			String parentWindow1 = null;

			Set<String> allWindows1 = driver.getWindowHandles();

			System.out.println("Window Count: " + allWindows1.size());

			// Find the parent window using its URL
			for (String window : allWindows1) {
			    driver.switchTo().window(window);

			    String currentUrl = driver.getCurrentUrl();

			    System.out.println("Handle: " + window);
			    System.out.println("URL: " + currentUrl);

			    if (currentUrl.contains("generator-portal-auth?transporterId=vuLql6DPJAheAtEE1nlrLnzk1L22")) {
			        parentWindow1 = window;
			        break;
			    }
			}

			// Switch back to the parent window
			if (parentWindow1 != null) {
			    driver.switchTo().window(parentWindow1);

			    System.out.println("---- Switched to child Window ----");
			    System.out.println("Current Handle: " + driver.getWindowHandle());
			    System.out.println("Current URL: " + driver.getCurrentUrl());
			    System.out.println("Current Title: " + driver.getTitle());
			} else {
			    System.out.println("child window not found!");
			}
			
			WebElement textfield = driver.findElement(By.xpath("//input[@placeholder='Enter 6-digit code']"));
			textfield.click();
			textfield.sendKeys(authcode);
			WebElement button = driver.findElement(By.xpath("//button[contains (text(),'Verify & Submit')]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.elementToBeClickable(button)).click();
			Thread.sleep(2000);
			WebElement page = driver.findElement(By.xpath("//div[@class='bg-green-50 border border-green-200 rounded-lg p-6 mb-4']"));
			page.isDisplayed();
			System.out.println("Thank you for registering page is dispayed");
			utilityclassobject.gettest().log(Status.PASS,"Thank you for registering page is dispayed"); 

			
		}
		
		@Test(dependsOnMethods = "TC_089VerifyGeneratorPortal_RegistrationPage")
		public void TC_090VerifyGeneratorPortal_Welcomepagewithnewuaser()
		{
			gpn.getBacktoLogin().click();
			gpn.getWelcomepage().isDisplayed();		
			System.out.println("Welcome page is displayed");
			utilityclassobject.gettest().log(Status.PASS,"Welcome page is displayed");
		}
		
		
		
		
		
	
	
	
	
	
	
}
