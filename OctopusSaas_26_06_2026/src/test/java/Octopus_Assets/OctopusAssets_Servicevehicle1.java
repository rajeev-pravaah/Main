package Octopus_Assets;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseclassforServicevehicle;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AssetsServicevehicle;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class OctopusAssets_Servicevehicle1  extends BaseclassforServicevehicle{
	ExcelUtility elib;
	AssetsServicevehicle as;
	
	
	
	@Test(priority = 1)
	public void TC_001AssetsServicevehicel_withservicevehiclepage() throws InterruptedException
	{
		elib = new ExcelUtility();
		as = new AssetsServicevehicle(driver);
		as.Servicevehicle();
		Thread.sleep(2000);	
		utilityclassobject.gettest().log(Status.INFO, "System is redirected the user to the Servicevehicle page");
	}
	
	@Test(dependsOnMethods = "TC_001AssetsServicevehicel_withservicevehiclepage")
	public void TC_087AssetsServicevehicle_CopyofRegistrationWithInput() throws InterruptedException
	{
		WebElement serviceVehicle = driver.findElement(By.xpath("//div[contains (text(),'SV0000246')]"));
		Actions act = new Actions(driver);
		act.moveToElement(serviceVehicle).click().perform();
		Thread.sleep(2000);
		as.CopyofRegistrationwithInput();
		utilityclassobject.gettest().log(Status.INFO, "Copy of registration field will not accept manual input");	
	}

	@Test(dependsOnMethods = "TC_087AssetsServicevehicle_CopyofRegistrationWithInput")
	public void TC_088AssetsServicevehicle_CopyofregistrationwithFile() throws InterruptedException, IOException
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
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The file input may not be in DOM until the upload control is clicked; try clicking upload icon then re-find
			try {
				as.getRegistrationCopyfield().click();
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of Registration field");			
	}
	
	@Test(dependsOnMethods = "TC_088AssetsServicevehicle_CopyofregistrationwithFile")
	public void TC_089AssetsServicevehicle_CopyofregistrationwithValidforamt() throws InterruptedException, IOException
	{
		
		Thread.sleep(20000);
		as.getRegidtrationDeletebutton().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "Sample_png.png");
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
				as.getRegistrationCopyfield().click();
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of Registration field");			
	}
	
	@Test(dependsOnMethods = "TC_089AssetsServicevehicle_CopyofregistrationwithValidforamt")
	public void TC_090AssetsServicevehicle_CopyofregistrationwithInvalidinput() throws InterruptedException, IOException
	{

		Thread.sleep(20000);
		as.getRegidtrationDeletebutton().click();
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
	
	@Test(dependsOnMethods = "TC_090AssetsServicevehicle_CopyofregistrationwithInvalidinput")
	public void TC_091AssetsServicevehicle_CopyofregistrationwithEditname() throws InterruptedException, IOException, AWTException
	{
		as.getRegistrationCopyfield().click();

		Thread.sleep(2000);

		// Project directory
		String projectDir = System.getProperty("user.dir");

		// File path
		File file = new File(projectDir + File.separator
		        + "Files_ upload" + File.separator + "companylogo.jpg");

		// Verify file exists
		if (!file.exists())
		{
		    utilityclassobject.gettest().log(Status.FAIL,
		            "Upload file not found: "
		                    + file.getAbsolutePath());

		    throw new IOException(
		            "Upload file not found: "
		                    + file.getAbsolutePath());
		}

		String absolutePath = file.getAbsolutePath();

		// Locate hidden file input
		WebElement fileInput = driver.findElement(
		        By.xpath("(//input[@type='file'])[1]"));

		// Upload file
		fileInput.sendKeys(absolutePath);

		utilityclassobject.gettest().log(Status.INFO,
		        "Logo uploaded successfully");

		Thread.sleep(5000);

		// Create wait
		WebDriverWait wait =
		        new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click edit icon
		WebElement editButton = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                as.getRegistrationEditbutton()));

		JavascriptExecutor js =
		        (JavascriptExecutor) driver;

		js.executeScript(
		        "arguments[0].click();",
		        editButton);

		utilityclassobject.gettest().log(Status.INFO,
		        "Clicked on registration edit button");

		Thread.sleep(3000);

		// Locate editable filename field
		WebElement fileNameField = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath(
		                        "//input[contains(@value,'companylogo')]")));

		// Select existing text
		fileNameField.sendKeys(Keys.CONTROL + "a");

		// Delete existing text
		fileNameField.sendKeys(Keys.DELETE);

		// Enter new name
		fileNameField.sendKeys("edited");

		utilityclassobject.gettest().log(Status.INFO,
		        "Edited file name successfully");

		// Click outside to save
		driver.findElement(By.xpath("//body")).click();

		Thread.sleep(3000);

		utilityclassobject.gettest().log(Status.INFO,
		        "Clicked outside to save edited logo name");
	}
	
	@Test(dependsOnMethods = "TC_091AssetsServicevehicle_CopyofregistrationwithEditname")
	public void TC_092AssetsServicevehicle_CopyofregistrationwithDelete() throws InterruptedException
	{
		Thread.sleep(2000);
		as.getRegidtrationDeletebutton().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO,"user is able to delete the file into the copy of Registration field");			

	}
	
	@Test(dependsOnMethods = "TC_092AssetsServicevehicle_CopyofregistrationwithDelete")
	public void TC_093AssetsServicevehicle_CopyofInsurancewithInput()
	{
		as.CopyofInsurancewithInput();
		utilityclassobject.gettest().log(Status.INFO,"Copy of insurance field will not accept input");			

	}
	
	@Test(dependsOnMethods = "TC_093AssetsServicevehicle_CopyofInsurancewithInput")
	public void TC_094AssetsServicevehile_CopyofInsurancewithFileInput() throws InterruptedException, IOException
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
				as.getInsurancecopyField().click();
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of Insurance field");	
	}
	
	@Test(dependsOnMethods = "TC_094AssetsServicevehile_CopyofInsurancewithFileInput")
	public void TC_095AssetsServicevehicle_CopyofInsurancewithValidforamt() throws InterruptedException, IOException
	{

		Thread.sleep(20000);
		as.getInsranceDeletebutton().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "Sample_png.png");
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
				as.getInsurancecopyField().click();
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of Insurance field");			
	}
	
	@Test(dependsOnMethods = "TC_095AssetsServicevehicle_CopyofInsurancewithValidforamt")
	public void TC_096AssetsServicevehicle_CopyofInsurancewithInavlidformat() throws InterruptedException, IOException
	{
		Thread.sleep(20000);
		as.getInsranceDeletebutton().click();
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
	
	@Test(dependsOnMethods = "TC_096AssetsServicevehicle_CopyofInsurancewithInavlidformat")
	public void TC_097AssetsServicevehicle_CopyofInsurancewithEdit() throws InterruptedException, IOException
	{
		as.getInsurancecopyField().click();

		Thread.sleep(2000);

		// Project directory
		String projectDir = System.getProperty("user.dir");

		// File path
		File file = new File(projectDir + File.separator
		        + "Files_ upload" + File.separator + "companylogo.jpg");

		// Verify file exists
		if (!file.exists())
		{
		    utilityclassobject.gettest().log(Status.FAIL,
		            "Upload file not found: "
		                    + file.getAbsolutePath());

		    throw new IOException(
		            "Upload file not found: "
		                    + file.getAbsolutePath());
		}

		String absolutePath = file.getAbsolutePath();

		// Locate hidden file input
		WebElement fileInput = driver.findElement(
		        By.xpath("(//input[@type='file'])[2]"));

		// Upload file
		fileInput.sendKeys(absolutePath);

		utilityclassobject.gettest().log(Status.INFO,
		        "Logo uploaded successfully");

		Thread.sleep(5000);

		// Create wait
		WebDriverWait wait =
		        new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click edit icon
		WebElement editButton = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                as.getInsuranceEditbutton()));

		JavascriptExecutor js =
		        (JavascriptExecutor) driver;

		js.executeScript(
		        "arguments[0].click();",
		        editButton);

		utilityclassobject.gettest().log(Status.INFO,
		        "Clicked on registration edit button");

		Thread.sleep(3000);

		// Locate editable filename field
		WebElement fileNameField = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath(
		                        "//input[contains(@value,'companylogo')]")));

		// Select existing text
		fileNameField.sendKeys(Keys.CONTROL + "a");

		// Delete existing text
		fileNameField.sendKeys(Keys.DELETE);

		// Enter new name
		fileNameField.sendKeys("edited");

		utilityclassobject.gettest().log(Status.INFO,
		        "Edited file name successfully");

		// Click outside to save
		driver.findElement(By.xpath("//body")).click();

		Thread.sleep(3000);

		utilityclassobject.gettest().log(Status.INFO,
		        "Clicked outside to save edited logo name");
	}
	
	@Test(dependsOnMethods = "TC_097AssetsServicevehicle_CopyofInsurancewithEdit")
	public void TC_098AssetsServicevehicle_CopyofInsurancewithDeletebutton() throws InterruptedException
	{
		Thread.sleep(2000);
		as.getInsranceDeletebutton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO,"user is able to delete the file into the copy of Insurance field");	

	}
	
	@Test(dependsOnMethods = "TC_098AssetsServicevehicle_CopyofInsurancewithDeletebutton")
	public void TC_099AssetsServicevehicle_TransporterpermitwithInput()
	{
		as.CopyofTransporetpermitwithInput();
		utilityclassobject.gettest().log(Status.INFO,"Copy of transporter permit will not accept manual input");	

	}
	
	@Test(dependsOnMethods = "TC_099AssetsServicevehicle_TransporterpermitwithInput")
	public void TC_100AssetsServicevehicle_TransporterpermitwithfileInput() throws InterruptedException, IOException
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
		List<WebElement> inputs = driver.findElements(By.xpath("(//input[@type='file'])[3]"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The file input may not be in DOM until the upload control is clicked; try clicking upload icon then re-find
			try {
				as.getTransporterpermitField().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("(//input[@type='file'])[3]"));
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of Transporter permit field");	
	}
	
	@Test(dependsOnMethods = "TC_100AssetsServicevehicle_TransporterpermitwithfileInput")
	public void TC_101AssetsServicevehicle_TransporterpermitwithValidFormat() throws InterruptedException, IOException
	{
		Thread.sleep(20000);
		as.getTransporterDeletebutton().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on delete icon");
		Thread.sleep(3000);
		
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "Sample_png.png");
		if(!file.exists()){
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new IOException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();
		// Locate the (hidden) file input and upload directly via sendKeys
		List<WebElement> inputs = driver.findElements(By.xpath("(//input[@type='file'])[3]"));
		WebElement fileInput = null;
		if(inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The file input may not be in DOM until the upload control is clicked; try clicking upload icon then re-find
			try {
				as.getTransporterpermitField().click();
			} catch(Exception e) {
				// ignore if clicking isn't available
			}
			// retry locating the input with a short wait loop
			for(int i=0;i<5;i++){
				inputs = driver.findElements(By.xpath("(//input[@type='file'])[3]"));
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
		utilityclassobject.gettest().log(Status.INFO,"user is able to upload the file into the copy of Transporter permit field");			
	}
	
	@Test(dependsOnMethods = "TC_101AssetsServicevehicle_TransporterpermitwithValidFormat")
	public void TC_102AssetsServiceveicle_TransporterpermitwithInavlidformat() throws InterruptedException, IOException
	{
		Thread.sleep(20000);
		as.getTransporterDeletebutton().click();
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
		            By.xpath("(//input[@type='file'])[3]"));

		    WebElement fileInput = null;

		    if (inputs.size() > 0) {

		        fileInput = inputs.get(0);

		    } else {

		        // Retry locating file input
		        for (int i = 0; i < 5; i++) {

		            inputs = driver.findElements(
		                    By.xpath("(//input[@type='file'])[3]"));

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
	
	@Test(dependsOnMethods = "TC_102AssetsServiceveicle_TransporterpermitwithInavlidformat")
	public void TC_103AssetsServicevehicle_TransporterwithEdit() throws InterruptedException, IOException
	{
		as.getTransporterpermitField().click();
		Thread.sleep(2000);

		// Project directory
		String projectDir = System.getProperty("user.dir");

		// File path
		File file = new File(projectDir + File.separator
		        + "Files_ upload" + File.separator + "companylogo.jpg");

		// Verify file exists
		if (!file.exists())
		{
		    utilityclassobject.gettest().log(Status.FAIL,
		            "Upload file not found: "
		                    + file.getAbsolutePath());

		    throw new IOException(
		            "Upload file not found: "
		                    + file.getAbsolutePath());
		}

		String absolutePath = file.getAbsolutePath();

		// Locate hidden file input
		WebElement fileInput = driver.findElement(
		        By.xpath("(//input[@type='file'])[3]"));

		// Upload file
		fileInput.sendKeys(absolutePath);

		utilityclassobject.gettest().log(Status.INFO,
		        "Logo uploaded successfully");

		Thread.sleep(5000);

		// Create wait
		WebDriverWait wait =
		        new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click edit icon
		WebElement editButton = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                as.getTransporterEditbutton()));

		JavascriptExecutor js =
		        (JavascriptExecutor) driver;

		js.executeScript(
		        "arguments[0].click();",
		        editButton);

		utilityclassobject.gettest().log(Status.INFO,
		        "Clicked on registration edit button");

		Thread.sleep(3000);

		// Locate editable filename field
		WebElement fileNameField = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath(
		                        "//input[contains(@value,'companylogo')]")));

		// Select existing text
		fileNameField.sendKeys(Keys.CONTROL + "a");

		// Delete existing text
		fileNameField.sendKeys(Keys.DELETE);

		// Enter new name
		fileNameField.sendKeys("edited");

		utilityclassobject.gettest().log(Status.INFO,
		        "Edited file name successfully");

		// Click outside to save
		driver.findElement(By.xpath("//body")).click();

		Thread.sleep(3000);

		utilityclassobject.gettest().log(Status.INFO,
		        "Clicked outside to save edited logo name");
	}
	
	@Test(dependsOnMethods = "TC_103AssetsServicevehicle_TransporterwithEdit")
	public void TC_104AssetsServicevehicle_TransporterwithDeletebutton() throws InterruptedException
	{
		Thread.sleep(2000);
		as.getTransporterDeletebutton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO,"user is able to delete the file into the copy of Transporter permit field");
	}
	
}
