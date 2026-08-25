package FIle_Upload_Reusable;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class FileUpload extends BaseClassForGEneratorContacts {
	 public void uploadLogo(String filepath) throws Exception {

	//verify the logo is uploaded successfully
	//navigate to taht upload logo click on that and upload jpg file from File_upload folder
	TransporterProfile tp = new TransporterProfile(driver);
	//tp.getUploadfile().click();
	// Prepare utility and build absolute path to the image in repo `Files_ upload`
	wlib = new webDriverutility();
	String projectDir = System.getProperty("user.dir");
	File file = new File(projectDir + File.separator + "Files_ upload" + File.separator + "+filepath+");
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
		
	}
}

}
