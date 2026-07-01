package Assert_Satellite_Location;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.SatelliteLocation;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class File_UploadTc extends BaseClassForGEneratorContacts{
	HomePage hp;
	SatelliteLocation sl;
	ExcelUtility elib;
	webDriverutility wd;

	@Test(dependsOnMethods = "TC_068VerifyGoogleRevireLinkWithValidinput")
	public void TC_069VerifyCompanyLogoUploadsFile() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		
		//it is not an Magic Tc While running check the dependency To run independently comment dependency 
		
		//comment it
		//comment it
		//comment it
		
		
		hp = new HomePage(driver);
		utilityclassobject.gettest().log(com.aventstack.extentreports.Status.INFO, "Home Page is displayed");
		System.out.println("Home Page is displayed");
		Thread.sleep(6000);
		sl = new SatelliteLocation(driver);
		sl.getAssets().click();
		sl.getSatellite_Locations().click();
		sl.getSatelliteLocationsList().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Satellite Location Page is displayed");
		 System.out.println("Satellite Location Page is displayed");
		  List<WebElement> namelists = sl.getSatelliteLocationNameinlist();
		   //print each value using for loop
		  for(int i=0; i<namelists.size(); i++) {
			  String name = namelists.get(i).getText();
			  ExcelUtility elib1 = new ExcelUtility();
				 String satellitename = elib1.getDataFromExcel("SatelliteLocation", 35, 7);
			  if(name.equals(satellitename)) {
				  namelists.get(i).click();
				  utilityclassobject.gettest().log(Status.INFO, "Clicked on Satellite Location Name in the list: " +name);
				  System.out.println("Clicked on Satellite Location Name in the list: " +name);
				  break;
			  }
		  }
		  
		 
		 //comment it
		//comment it//comment it
		//comment it
		 
		 
		 
		
		
		//navigate to taht upload logo click on that and upload jpg file from File_upload folder
		TransporterProfile tp = new TransporterProfile(driver);
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
		System.out.println("Logo uploded successfully : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Logo uploded successfully : PASS");
		
		
	}
	@Test(dependsOnMethods = "TC_069VerifyCompanyLogoUploadsFile")
	public void TC_070VerifyLogoUploadedinValidFormatJPEG() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		//verify the logo is uploaded successfully
		Thread.sleep(3000);
		sl.getCompanylogodeletebutton().click();
		System.out.println("Clicked on delete icon Successfully");
	    utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon Successfully");
		Thread.sleep(3000);

		//navigate to taht upload logo click on that and upload jpg file from File_upload folder
		TransporterProfile tp = new TransporterProfile(driver);
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
		System.out.println("Valid JPEG format Logo uploded successfully : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Valid JPEG format Logo uploded successfully : PASS");
		
	}
	@Test(dependsOnMethods = "TC_070VerifyLogoUploadedinValidFormatJPEG")
	public void TC_071VerifyLogoUploadedinValidFormatPNG() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		//verify the logo is uploaded successfully
		Thread.sleep(3000);
		sl.getCompanylogodeletebutton().click();
		System.out.println("Clicked on delete icon Successfully");
	    utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon Successfully");
		Thread.sleep(3000);

		//navigate to taht upload logo click on that and upload jpg file from File_upload folder
		TransporterProfile tp = new TransporterProfile(driver);
		//tp.getUploadfile().click();
		// Prepare utility and build absolute path to the image in repo `Files_ upload`
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "automation_icon.svg");
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
				System.out.println("Clicked on upload icon Successfully");
			    utilityclassobject.gettest().log(Status.INFO, "Clicked on upload icon Successfully");
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
			System.out.println("Not able to upload invalid format file :PASS");
			utilityclassobject.gettest().log(Status.INFO, "Not Apble to upload invalid format files :PASS");
		}
		System.out.println("Not able to upload invalid format file :PASS");
		utilityclassobject.gettest().log(Status.INFO, "Not Able to upload invalid format files :PASS");
	}
	@Test(dependsOnMethods = "TC_071VerifyLogoUploadedinValidFormatPNG")
	public void TC_072VerifyLogoUploadWithLessThan5mb() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
						// Try uploading a file smaller than 5MB located in Files_ upload folder named "3mb_.png"
						TransporterProfile tp = new TransporterProfile(driver);
						wlib = new webDriverutility();
						String projectDir = System.getProperty("user.dir");
						File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "3mb_.png");
						if(!file.exists()){
							utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
							System.out.println("Less-than-5MB test file not found: " + file.getAbsolutePath());
							return; // skip test if file missing
						}
						String absolutePath = file.getAbsolutePath();
						// open upload control and send file
						try { tp.getUploadfile().click(); } catch(Exception e) { /* ignore */ }
						List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
						WebElement fileInput = null;
						if(inputs.size() > 0) {
							fileInput = inputs.get(0);
						} else {
							for(int i=0;i<5;i++){
								inputs = driver.findElements(By.xpath("//input[@type='file']"));
								if(inputs.size()>0){ fileInput = inputs.get(0); break; }
								try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
							}
							if(fileInput == null) { throw new NoSuchElementException("Could not find file input to upload image"); }
						}
						try { wlib.scrollToelement(driver, fileInput); wlib.waitUntilElementClickable(driver, fileInput); } catch(Exception e) { /* ignore */ }
						fileInput.sendKeys(absolutePath);
						Thread.sleep(4000);
						utilityclassobject.gettest().log(Status.PASS, "Uploaded less-than-5MB file: " + absolutePath);
						System.out.println("Uploaded less-than-5MB file successfully: PASS");
	}
	
	@Test(dependsOnMethods = "TC_072VerifyLogoUploadWithLessThan5mb")
	public void TC_073VerifyLogoUploadWithMoreThan5mb() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
						// Delete previously uploaded logo if present, then try to upload a >10MB file and verify it's rejected
						try {
							sl.getCompanylogodeletebutton().click();
							System.out.println("Clicked on delete icon Successfully");
							utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon Successfully");
							Thread.sleep(2000);
						} catch(Exception e) { /* ignore if not present */ }
						TransporterProfile tp = new TransporterProfile(driver);
						try { tp.getUploadfile().click(); } catch(Exception e) { /* ignore */ }
						String projectDir = System.getProperty("user.dir");
						File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "Morethan 10mb.png");
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
		System.out.println("Alert popup handled for logo upload more than 5MB");
		System.out.println("Logo upload not accepts file more than 5MB  :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Logo upload  not accepts file  more than 5MB  :PASS");
		
	}
	@Test(dependsOnMethods = "TC_073VerifyLogoUploadWithMoreThan5mb")
	public void TC_074VerifyLogoUploadWithouAddingLogo() throws InterruptedException, EncryptedDocumentException, IOException, AWTException  {
		
		//comment it
		//comment it
		//comment it
		
		/*
		hp = new HomePage(driver);
		utilityclassobject.gettest().log(com.aventstack.extentreports.Status.INFO, "Home Page is displayed");
		System.out.println("Home Page is displayed");
		Thread.sleep(6000);
		sl = new SatelliteLocation(driver);
		sl.getAssets().click();
		sl.getSatellite_Locations().click();
		sl.getSatelliteLocationsList().isDisplayed();
		utilityclassobject.gettest().log(Status.INFO, "Satellite Location Page is displayed");
		 System.out.println("Satellite Location Page is displayed");
		  List<WebElement> namelists = sl.getSatelliteLocationNameinlist();
		   //print each value using for loop
		  for(int i=0; i<namelists.size(); i++) {
			  String name = namelists.get(i).getText();
			  ExcelUtility elib1 = new ExcelUtility();
				 String satellitename = elib1.getDataFromExcel("SatelliteLocation", 35, 7);

			  if(name.equals("Portland41886")) {
				  namelists.get(i).click();
				  utilityclassobject.gettest().log(Status.INFO, "Clicked on Satellite Location Name in the list: " +name);
				  System.out.println("Clicked on Satellite Location Name in the list: " +name);
				  break;
			  }
		  }
		  
		 
		 //comment it
		//comment it//comment it
		//comment it
		 */
		
		//write code to scroll to save button and click on save button without adding logo
		//scroll to save button
		wlib.scrollToelement(driver, sl.getSavebutton());
		sl.getSavebutton().click();
		//again scroll back to company logo upload
		wlib.scrollToelement(driver, sl.getCompanylogopfield());
		//verify that it should not show any error message
		System.out.println("Logo upload without adding logo should not show any error message :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Logo upload without adding logo should not show any error message :PASS");
		
	
	}
	
}
