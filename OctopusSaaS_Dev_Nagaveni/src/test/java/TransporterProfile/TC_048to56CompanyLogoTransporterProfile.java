package TransporterProfile;
import com.Octopussaas.BaseUtility.BaseclassForSignUpPage;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.Octo365SignUP;
import com.Octopussaas.ObjectRepository.SignInPage;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_048to56CompanyLogoTransporterProfile extends BaseclassForSignUpPage{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	SignInPage SignInPage;
	Octo365SignUP octo365signupPage;
	TransporterProfile tp;

	@Test
	public void TC_048CompanyLogoUpload() throws EncryptedDocumentException, IOException, InterruptedException {
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
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='I ACCEPT']")).click();
		//navigate to taht upload logo click on that and upload jpg file from File_upload folder
		tp = new TransporterProfile(driver);
		//tp.getUploadfile().click();
		// Prepare utility and build absolute path to the image in repo `Files_ upload`
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "companylogo.jpg");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new IOException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		// Locate the (hidden) file input and upload directly via sendKeys
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The file input may not be in DOM until the upload control is clicked; try clicking upload icon then re-find
			try {
				tp.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("//input[@type='file']"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload image");
			}
		}
		// make sure element is in view and clickable if possible
		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch(Exception e) {
			// best-effort; proceed to sendKeys even if scroll/wait fail
		}
		fileInput.sendKeys(absolutePath);
		utilityclassobject.gettest().log(Status.INFO, "Logo uploaded: " + absolutePath);
		Thread.sleep(5000);
		
		
		
		
	}
	
	@Test(dependsOnMethods = "TC_048CompanyLogoUpload")
	public void TC_049CompanyLogoUpload() throws InterruptedException, IOException {
		Thread.sleep(3000);
		octo365signupPage.getDeleteicon().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
//again click on that upload icon and try to upload file sample_image.webp file  and we will get alert popup  
		tp.getUploadfile().click();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "sample_image.webp");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new IOException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			throw new NoSuchElementException("Could not find file input to upload image");
		}
		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch(Exception e) {
			// best-effort; proceed to sendKeys even if scroll/wait fail
		}
		fileInput.sendKeys(absolutePath);
		Thread.sleep(2000);
		//habdle alert popup
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		utilityclassobject.gettest().log(Status.INFO, "Alert popup handled for invalid file upload");
		
		
		 
	}
	
	@Test(dependsOnMethods = "TC_049CompanyLogoUpload")
	public void TC_050CompanyLogoUpload() throws EncryptedDocumentException, IOException, InterruptedException {
		// Reuse the same flow as TC_048CompanyLogoUpload (signup + valid logo upload)
		tp.getUploadfile().click();

		// navigate to upload logo and upload jpg file from File_upload folder (same as TC_048)
		tp = new TransporterProfile(driver);
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "companylogo.jpg");
		if (!file.exists()) {
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found (TC_050): " + file.getAbsolutePath());
			throw new IOException("Upload file not found (TC_050): " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();

		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if (inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			try {
				tp.getUploadfile().click();
			} catch (Exception e) {
				// ignore
			}
			for (int i = 0; i < 5; i++) {
				inputs = driver.findElements(By.xpath("//input[@type='file']"));
				if (inputs.size() > 0) {
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch (InterruptedException ie) { /* ignore */ }
			}
			if (fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload image - TC_050");
			}
		}

		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch (Exception e) {
			// best-effort
		}

		fileInput.sendKeys(absolutePath);
		utilityclassobject.gettest().log(Status.INFO, "Logo uploaded in TC_050: " + absolutePath);
		Thread.sleep(5000);
	}
	
	@Test(dependsOnMethods = "TC_050CompanyLogoUpload")
	public void TC_051EditLogoName() throws InterruptedException, IOException, AWTException
	{
		
		
		//again delete and add new logo and check the edited logo name is displayed or not
		octo365signupPage.getDeleteicon().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon to verify edited logo name");
		 //again upload logo
		tp.getUploadfile().click();
		Thread.sleep(20000);
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "companylogo.jpg");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new IOException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		// Locate the (hidden) file input and upload directly via sendKeys
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The file input may not be in DOM until the upload control is clicked; try clicking upload icon then re-find
			try {
				tp.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("//input[@type='file']"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload image");
			}
		}
		// make sure element is in view and clickable if possible
		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch(Exception e) {
			// best-effort; proceed to sendKeys even if scroll/wait fail
		}
		fileInput.sendKeys(absolutePath);
		utilityclassobject.gettest().log(Status.INFO, "Logo uploaded: " + absolutePath);
		Thread.sleep(5000);
		//clcik on edit icon
		octo365signupPage.getEditicon().click();
		Thread.sleep(3000);
		//Click on back space 2 times by using robot class cretae object for robot class 
		Robot robot = new Robot();
		// Press backspace key twice
		robot.keyPress(java.awt.event.KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(java.awt.event.KeyEvent.VK_BACK_SPACE);
		robot.keyPress(java.awt.event.KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(java.awt.event.KeyEvent.VK_BACK_SPACE);
		//enter new logo name
		String newLogoName = "edited";
		utilityclassobject.gettest().log(Status.INFO, "Entered new logo name: " + newLogoName);
		//Assuming the logo name input field is focused after backspace, send the new name
		robot.keyPress(java.awt.event.KeyEvent.VK_E);
		robot.keyRelease(java.awt.event.KeyEvent.VK_E);
		robot.keyPress(java.awt.event.KeyEvent.VK_D);
		robot.keyRelease(java.awt.event.KeyEvent.VK_D);
		robot.keyPress(java.awt.event.KeyEvent.VK_I);
		robot.keyRelease(java.awt.event.KeyEvent.VK_I);
		robot.keyPress(java.awt.event.KeyEvent.VK_T);
		robot.keyRelease(java.awt.event.KeyEvent.VK_T);
		utilityclassobject.gettest().log(Status.INFO, "Edited logo name using Robot class");
		Thread.sleep(3000);
		//click on outside of the logo name field to save the edited name (assuming clicking on the page body will save)
		driver.findElement(By.xpath("//body")).click();
		
	   		Thread.sleep(3000);
	   		utilityclassobject.gettest().log(Status.INFO, "Clicked outside to save edited logo name");	
		
	}
	@Test(dependsOnMethods = "TC_051EditLogoName")
	public void Tc_052deleteEditedLogo() throws InterruptedException
	{
		//delete the edited logo and check the default logo is displayed or not
		octo365signupPage.getDeleteicon().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon to verify default logo is displayed");
		
	}
	@Test(dependsOnMethods = "Tc_052deleteEditedLogo")
	public void TC_053Reuploadlogo() throws InterruptedException
	{
		Thread.sleep(20000);
		//again upload logo and check the uploaded logo is displayed or not
		tp.getUploadfile().click();
		Thread.sleep(20000);

		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "companylogo.jpg");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new RuntimeException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			try {
				tp.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("//input[@type='file']"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload image");
			}
		}
		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch(Exception e) {
			// best-effort; proceed to sendKeys even if scroll/wait fail
		}
		fileInput.sendKeys(absolutePath);
		utilityclassobject.gettest().log(Status.INFO, "Logo re-uploaded: " + absolutePath);
	}
	
	@Test(dependsOnMethods = "TC_053Reuploadlogo")
	public void TC_054VerifyUploadedLogo() throws InterruptedException
	{
		//verify the uploaded logo is displayed or not
		Thread.sleep(20000);
		// Use a generic locator here instead of tp.getCompanylogo() since that method does not exist
		// Adjust the XPath/CSS selector according to your actual logo element in the DOM
		WebElement logoElement = driver.findElement(By.xpath("//img[contains(@src,'logo') or contains(@alt,'logo') or contains(@class,'logo')]"));
		boolean isLogoDisplayed = logoElement.isDisplayed();
		if(isLogoDisplayed) {
			utilityclassobject.gettest().log(Status.PASS, "Uploaded logo is displayed successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Uploaded logo is NOT displayed");
		}
	}
		
	@Test(dependsOnMethods = "TC_054VerifyUploadedLogo")
	public void TC_055CompanyLogoMorethan5mb() throws InterruptedException
	{
		System.out.println("Hi");
		octo365signupPage.getDeleteicon().click();
		Thread.sleep(20000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon to verify upload of logo more than 5MB");
		//again click on that upload icon and try to upload file more than 5mb and we will get alert popup
		tp.getUploadfile().click();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "sample_logo_large.png");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new RuntimeException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			try {
				tp.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("//input[@type='file']"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload image");
			}
		}
		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch(Exception e) {
			// best-effort; proceed to sendKeys even if scroll/wait fail
		}
		fileInput.sendKeys(absolutePath);
		utilityclassobject.gettest().log(Status.INFO, "Logo re-uploaded: " + absolutePath);
		//hndle alert popup
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		utilityclassobject.gettest().log(Status.INFO, "Alert popup handled for logo upload more than 5MB");
	
		
	
	
	}
	@Test(dependsOnMethods = "TC_055CompanyLogoMorethan5mb")
	public void TC_056VerifyAutosavefunctionality() throws InterruptedException
	{
		//delete the logo and verify the default logo is displayed or not
		octo365signupPage.getDeleteicon().click();
		Thread.sleep(20000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon to verify default logo is displayed");
		 //again upload logo
		tp.getUploadfile().click();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "companylogo.jpg");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new RuntimeException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			try {
				tp.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("//input[@type='file']"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload image");
			}
		}
		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch(Exception e) {
			// best-effort; proceed to sendKeys even if scroll/wait fail
		}
		fileInput.sendKeys(absolutePath);
		utilityclassobject.gettest().log(Status.INFO, "Logo uploaded: " + absolutePath);
		Thread.sleep(5000);
		
		
	}
		
		
	

}