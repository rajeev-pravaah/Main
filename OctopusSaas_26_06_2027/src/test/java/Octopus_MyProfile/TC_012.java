package Octopus_MyProfile;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_012 extends Baseclass {
	
	@Test
	public void TC_012myProfile_withspecialcharacters() throws InterruptedException, EncryptedDocumentException, IOException
	{
		javautility	jlib = new javautility();
		ExcelUtility elib = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getFirstName().click();
		hp.getFirstName().sendKeys(Keys.CONTROL + "a");
		hp.getFirstName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("MyProfile", 1, 3);
		hp.getFirstName().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "First Name Text field will accept alpahbets");
	}

}
