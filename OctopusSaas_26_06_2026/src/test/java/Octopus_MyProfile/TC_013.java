package Octopus_MyProfile;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)



public class TC_013 extends Baseclass{
	
	@Test
	public void TC_013myProfile_FirstnamewithNumbers() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ExcelUtility elib = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getFirstName().click();
		hp.getFirstName().sendKeys(Keys.CONTROL + "a");
		hp.getFirstName().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("MyProfile", 1, 4);
		hp.getFirstName().sendKeys(input);
		String enteredValue = hp.getFirstName().getAttribute("value");
		boolean hasNumbers = enteredValue.matches(".*\\d.*");
		utilityclassobject.gettest().log(Status.INFO, "FirstName  textfield will not accpet numbers");
	}
	
	}
