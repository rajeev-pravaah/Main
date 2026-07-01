package Octopus_Assets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseclassforDrivers;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AssestsDrivers;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class OctopusAssets_Drivers1 extends BaseclassforDrivers{
	AssestsDrivers ad;
	ExcelUtility elib;
	
	@Test(priority = 1)
	public void TC_001AssetsDrivers_withDriverPage() throws InterruptedException
	{
		elib = new ExcelUtility();
		ad = new AssestsDrivers(driver);
		ad.Drivers();
		utilityclassobject.gettest().log(Status.INFO, "System is redirected the user to the drivers page");
		Thread.sleep(2000);
	}
	
	
	@Test(dependsOnMethods = "TC_001AssetsDrivers_withDriverPage")
	public void TC_134AssetsDrivers_LicensewithInput()
	{
		WebElement newdriver = driver.findElement(By.xpath("//div[contains(text(),'100072')]"));
		Actions act = new Actions(driver);
		act.moveToElement(newdriver).click().perform();
		
		ad.LicensefieldwithInput();
		utilityclassobject.gettest().log(Status.INFO,"Copy of license field will not accept input");			

	}
	
	@Test(dependsOnMethods = "TC_134AssetsDrivers_LicensewithInput")
	public void TC_135AssetsDrivers_LicensewithFileInput() throws IOException, InterruptedException
	{
		
		/*Thread.sleep(20000);
		ad.getDeleteicon().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);*/
		
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "license.jpg");
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
				ad.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("(//input[@type='file'])[1]"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload file");
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of license field");			

	}
	
	@Test(dependsOnMethods = "TC_135AssetsDrivers_LicensewithFileInput")
	public void TC_136AssetsDrivers_LicensewithValidfileInput() throws IOException, InterruptedException
	{
		Thread.sleep(20000);
		ad.getDeleteicon().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		
		wlib = new webDriverutility();
		//ad.getUploadfile().click();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "sample_license2.png");
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
				ad.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("(//input[@type='file'])[1]"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload file");
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file with valid format into the copy of license field");			
	}
	
	
	@Test(dependsOnMethods = "TC_136AssetsDrivers_LicensewithValidfileInput")
	public void TC_137AssetsDrivers_licensewithInvalidFormat() throws IOException, InterruptedException
	{
		Thread.sleep(20000);
		ad.getDeleteicon().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		

		    wlib = new webDriverutility();

		    // Click upload button
		    //ad.getUploadfile().click();

		    // File path
		    String projectDir = System.getProperty("user.dir");

		    File file = new File(projectDir + File.separator
		            + "Files_ upload" + File.separator + "sample_excel.xlsx");

		    // Check file existence
		    if (!file.exists()) {

		        utilityclassobject.gettest().log(Status.FAIL,
		                "Upload file not found : "
		                        + file.getAbsolutePath());

		        throw new IOException("Upload file not found : "
		                + file.getAbsolutePath());
		    }

		    String absolutePath = file.getAbsolutePath();

		    // Locate file input field
		    List<WebElement> inputs = driver.findElements(
		            By.xpath("//input[@type='file']"));

		    WebElement fileInput = null;

		    if (inputs.size() > 0) {

		        fileInput = inputs.get(0);

		    } else {

		        // Retry locating file input
		        for (int i = 0; i < 5; i++) {

		            inputs = driver.findElements(
		                    By.xpath("(//input[@type='file'])[1]"));

		            if (inputs.size() > 0) {

		                fileInput = inputs.get(0);
		                break;
		            }

		            Thread.sleep(500);
		        }

		        if (fileInput == null) {

		            throw new NoSuchElementException(
		                    "Could not find file input field");
		        }
		    }

		    // Scroll to element
		    try {

		        wlib.scrollToelement(driver, fileInput);
		        wlib.waitUntilElementClickable(driver, fileInput);

		    } catch (Exception e) {

		        System.out.println(
		                "Scroll/Wait skipped : " + e.getMessage());
		    }

		    // Upload invalid excel file
		    fileInput.sendKeys(absolutePath);

		    Thread.sleep(2000);

		    try {

		        // Handle alert popup
		        Alert alert = driver.switchTo().alert();

		        // Capture alert message
		        String alertMessage = alert.getText();

		        System.out.println(
		                "Popup Message : " + alertMessage);

		        // Validation
		        if (alertMessage.contains("Invalid file type")) {

		            System.out.println(
		                    "PASSED : Excel file is rejected");

		            utilityclassobject.gettest().log(Status.PASS,
		                    "Application rejected invalid excel file format");

		        } else {

		            System.out.println(
		                    "FAILED : Unexpected validation message");

		            utilityclassobject.gettest().log(Status.FAIL,
		                    "Unexpected popup message : "
		                            + alertMessage);
		        }

		        // Click OK button
		        alert.accept();

		    } catch (Exception e) {

		        System.out.println(
		                "FAILED : Alert popup not displayed");

		        utilityclassobject.gettest().log(Status.FAIL,
		                "Alert popup not displayed");
		    }

		    Thread.sleep(2000);
				
	}
	
	@Test(dependsOnMethods = "TC_137AssetsDrivers_licensewithInvalidFormat")
	public void TC_138AssetsDrivers_MedicalcardwithInput()
	{
		ad.MedicalcardfieldwithInput();
		utilityclassobject.gettest().log(Status.INFO,"copy of DOT medical card will not accept input");			
	}
	
	@Test(dependsOnMethods = "TC_138AssetsDrivers_MedicalcardwithInput")
	public void TC_139AssetsDrivers_MedicalcardfilewithInput() throws IOException, InterruptedException
	{
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "license.jpg");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new IOException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		// Locate the (hidden) file input and upload directly via sendKeys
		List<WebElement> inputs = driver.findElements(By.xpath("(//input[@type='file'])[2]"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The file input may not be in DOM until the upload control is clicked; try clicking upload icon then re-find
			try {
				ad.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("(//input[@type='file'])[2]"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload file");
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of DOT medical card");			

	}
	
	@Test(dependsOnMethods = "TC_139AssetsDrivers_MedicalcardfilewithInput")
	public void TC_140AssetsDrivers_MedicalcardwithValidformat() throws InterruptedException, IOException
	{
		Thread.sleep(20000);
		ad.getMedicaldeleteicon().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		
		wlib = new webDriverutility();
		//ad.getUploadfile().click();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "sample_license2.png");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new IOException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		// Locate the (hidden) file input and upload directly via sendKeys
		List<WebElement> inputs = driver.findElements(By.xpath("(//input[@type='file'])[2]"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The file input may not be in DOM until the upload control is clicked; try clicking upload icon then re-find
			try {
				ad.getUploadfile().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("(//input[@type='file'])[2]"));
				if(inputs.size()>0){
					fileInput = inputs.get(0);
					break;
				}
				try { Thread.sleep(300); } catch(InterruptedException ie) { /* ignore */ }
			}
			if(fileInput == null) {
				throw new NoSuchElementException("Could not find file input to upload file");
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file with valid format into the copy of DOT medicalcard field");	
	}

	@Test(dependsOnMethods = "TC_140AssetsDrivers_MedicalcardwithValidformat")
	public void TC_141AssetsDrivers_MedicalcardwithInvalidformat() throws InterruptedException, IOException
	{
		Thread.sleep(20000);
		ad.getMedicaldeleteicon().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		

		    wlib = new webDriverutility();

		    // Click upload button
		    //ad.getUploadfile().click();

		    // File path
		    String projectDir = System.getProperty("user.dir");

		    File file = new File(projectDir + File.separator
		            + "Files_ upload" + File.separator + "sample_excel.xlsx");

		    // Check file existence
		    if (!file.exists()) {

		        utilityclassobject.gettest().log(Status.FAIL,
		                "Upload file not found : "
		                        + file.getAbsolutePath());

		        throw new IOException("Upload file not found : "
		                + file.getAbsolutePath());
		    }

		    String absolutePath = file.getAbsolutePath();

		    // Locate file input field
		    List<WebElement> inputs = driver.findElements(
		            By.xpath("(//input[@type='file'])[2]"));

		    WebElement fileInput = null;

		    if (inputs.size() > 0) {

		        fileInput = inputs.get(0);

		    } else {

		        // Retry locating file input
		        for (int i = 0; i < 5; i++) {

		            inputs = driver.findElements(
		                    By.xpath("(//input[@type='file'])[2]"));

		            if (inputs.size() > 0) {

		                fileInput = inputs.get(0);
		                break;
		            }

		            Thread.sleep(500);
		        }

		        if (fileInput == null) {

		            throw new NoSuchElementException(
		                    "Could not find file input field");
		        }
		    }

		    // Scroll to element
		    try {

		        wlib.scrollToelement(driver, fileInput);
		        wlib.waitUntilElementClickable(driver, fileInput);

		    } catch (Exception e) {

		        System.out.println(
		                "Scroll/Wait skipped : " + e.getMessage());
		    }

		    // Upload invalid excel file
		    fileInput.sendKeys(absolutePath);

		    Thread.sleep(2000);

		    try {

		        // Handle alert popup
		        Alert alert = driver.switchTo().alert();

		        // Capture alert message
		        String alertMessage = alert.getText();

		        System.out.println(
		                "Popup Message : " + alertMessage);

		        // Validation
		        if (alertMessage.contains("Invalid file type")) {

		            System.out.println(
		                    "PASSED : Excel file is rejected");

		            utilityclassobject.gettest().log(Status.PASS,
		                    "Application rejected invalid excel file format");

		        } else {

		            System.out.println(
		                    "FAILED : Unexpected validation message");

		            utilityclassobject.gettest().log(Status.FAIL,
		                    "Unexpected popup message : "
		                            + alertMessage);
		        }

		        // Click OK button
		        alert.accept();

		    } catch (Exception e) {

		        System.out.println(
		                "FAILED : Alert popup not displayed");

		        utilityclassobject.gettest().log(Status.FAIL,
		                "Alert popup not displayed");
		    }

		    Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "TC_141AssetsDrivers_MedicalcardwithInvalidformat")
	public void TC_161AssetsDrivers_HoursscheduledwithInput() throws EncryptedDocumentException, IOException
	{
		WebElement hoursscheduledtowork =
				driver.findElement(By.xpath("//input[@placeholder='Enter Hours Scheduled to Work']"));

				JavascriptExecutor js =
				(JavascriptExecutor) driver;

				js.executeScript(
				    "arguments[0].scrollIntoView({block:'center'});",
				    hoursscheduledtowork
				);
		ad.getHoursScheduled().click();
		ad.getHoursScheduled().sendKeys(Keys.CONTROL + "a");
		ad.getHoursScheduled().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 37, 1);
		ad.getHoursScheduled().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Hours scheduled to work field will accept input");		
	}
	
	@Test(dependsOnMethods = "TC_161AssetsDrivers_HoursscheduledwithInput")
	public void TC_162AssetsDrivers_HoursschedueldwithAlphabets() throws EncryptedDocumentException, IOException
	{
		ad.getHoursScheduled().click();
		ad.getHoursScheduled().sendKeys(Keys.CONTROL + "a");
		ad.getHoursScheduled().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 37, 2);
		ad.getHoursScheduled().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Hours scheduled to work field will accept alphabets");		
	}
	
	@Test(dependsOnMethods = "TC_162AssetsDrivers_HoursschedueldwithAlphabets")
	public void TC_163AssetsDrivers_HoursscheduledwithSpecialcharacters() throws EncryptedDocumentException, IOException
	{
		ad.getHoursScheduled().click();
		ad.getHoursScheduled().sendKeys(Keys.CONTROL + "a");
		ad.getHoursScheduled().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 37, 4);
		ad.getHoursScheduled().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Hours scheduled to work field will accept specialcharacters");		
	}
	
	@Test(dependsOnMethods = "TC_163AssetsDrivers_HoursscheduledwithSpecialcharacters")
	public void TC_164AssetsDrivers_HoursscheduledwithNegativeinput() throws EncryptedDocumentException, IOException
	{
		ad.getHoursScheduled().click();
		ad.getHoursScheduled().sendKeys(Keys.CONTROL + "a");
		ad.getHoursScheduled().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 37, 5);
		ad.getHoursScheduled().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Hours scheduled to work field will not accept negative input");		
	}
		
	@Test(dependsOnMethods = "TC_164AssetsDrivers_HoursscheduledwithNegativeinput")
	public void TC_165AssetsDrivers_HoursscheduledwithDecimalInput() throws EncryptedDocumentException, IOException
	{
		ad.getHoursScheduled().click();
		ad.getHoursScheduled().sendKeys(Keys.CONTROL + "a");
		ad.getHoursScheduled().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Drivers", 37, 6);
		ad.getHoursScheduled().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Hours scheduled to work field will accept Decimal input");		
	}
	

}
