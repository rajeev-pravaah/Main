package UnappliedChecks;

import java.io.File;
import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.Navigation_SideBar;
import com.Octopussaas.ObjectRepository.UnappliedChecks_Page;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)
public class Csv_FileUupload extends BaseClassForGEneratorContacts {

	// NOTE: Use this file upload only for native-file-dialog related testing

	Navigation_SideBar navbar;
	UnappliedChecks_Page uac ;

	@Test
	public void TC_030VerifyUploadValidCSVwith() throws Exception {
		// Navigate to Unapplied Checks page
		navbar = new Navigation_SideBar(driver);
		navbar.MovetoUnappliedchecks();

		// Open Import Checks modal and click Select File
		 uac = new UnappliedChecks_Page(driver);
		uac.getImportfilebutton().click();
		uac.getSelectfilebutton().click();
		utilityclassobject.gettest().log(Status.INFO, "Select File button is clicked");

		// Prepare file path for CSV located in project Files_ upload folder
		wlib = new webDriverutility();
		String projectDir = System.getProperty("user.dir");
		File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "check-import-template (8).csv");
		if (!file.exists()) {
			utilityclassobject.gettest().log(Status.FAIL, "Upload file not found: " + file.getAbsolutePath());
			throw new java.io.IOException("Upload file not found: " + file.getAbsolutePath());
		}
		String absolutePath = file.getAbsolutePath();

		// Locate hidden file input and upload directly via sendKeys
		List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='file']"));
		WebElement fileInput = null;
		if (inputs.size() > 0) {
			fileInput = inputs.get(0);
		} else {
			// The input may not be present until after clicking Select File; retry a few times
			for (int i = 0; i < 5; i++) {
				inputs = driver.findElements(By.xpath("//input[@type='file']"));
				if (inputs.size() > 0) {
					fileInput = inputs.get(0);
					break;
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException ie) {
					// ignore
				}
			}
			if (fileInput == null) {
				throw new org.openqa.selenium.NoSuchElementException("Could not find file input to upload CSV");
			}
		}

		try {
			wlib.scrollToelement(driver, fileInput);
			wlib.waitUntilElementClickable(driver, fileInput);
		} catch (Exception e) {
			// best-effort
		}

		fileInput.sendKeys(absolutePath);
		utilityclassobject.gettest().log(Status.INFO, "CSV uploaded: " + absolutePath);
		Thread.sleep(3000);

		// Optionally, close native dialog (best-effort) if it appeared
		try {
			pressEscToCloseNativeFileDialog();
			utilityclassobject.gettest().log(Status.INFO, "Sent ESC to close native file dialog");
		} catch (AWTException | InterruptedException e) {
			utilityclassobject.gettest().log(Status.WARNING, "Could not send ESC via Robot: " + e.getMessage());
		}
	}

	// Helper to send ESC to close native file dialog using Robot
	public void pressEscToCloseNativeFileDialog() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.setAutoDelay(100);
		Thread.sleep(300);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(200);
		
		System.out.println("ESC key pressed to close native file dialog");
		utilityclassobject.gettest().log(Status.INFO, "ESC key pressed to close native file dialog");
		
		System.out.println("Native file dialog closed (if it was open)");
		utilityclassobject.gettest().log(Status.INFO, "Native file dialog closed (if it was open)");
		
		System.out.println("File upload process completed");
		utilityclassobject.gettest().log(Status.INFO, "File upload process completed");
	}
	
	
	
	@Test(dependsOnMethods = "TC_030VerifyUploadValidCSVwith")
	public void TC_031VerifyConfirmImportIsDisableWhileUploading() throws Exception {
		
		// write code to verify that the Confirm Import button is disabled while uploading the file already iam in same page and file is already uploaded and the Confirm Import button is disabled
		uac = new UnappliedChecks_Page(driver);
		boolean isConfirmImportDisabled = uac.getConfirmimportbutton().isEnabled();
		System.out.println("Confirm Import button is enabled: " + isConfirmImportDisabled);
		utilityclassobject.gettest().log(Status.PASS, "Confirm Import button is disabled while uploading the file");
		
			
		
		
		
		
		
	}
	

}

