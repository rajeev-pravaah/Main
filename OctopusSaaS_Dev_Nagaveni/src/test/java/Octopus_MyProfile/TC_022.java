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


public class TC_022 extends Baseclass{
	
	@Test
	public void TC_O22myProfile_Phonewithinput() throws InterruptedException, EncryptedDocumentException, IOException
	{
		ExcelUtility elib = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getPhoneTextfield().click();
		hp.getPhoneTextfield().sendKeys(Keys.CONTROL + "a");
		hp.getPhoneTextfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("MyProfile", 7, 1);
		hp.getPhoneTextfield().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Phone text field will accept Input");
	}

}
