package Octopus_MyProfile;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_024 extends Baseclass{

	@Test
	public void TC_024myProfile_phonewithAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
	{
		ExcelUtility elib = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getPhoneTextfield().click();
		String input = elib.getDataFromExcel("MyProfile", 7, 3);
		hp.getPhoneTextfield().sendKeys(input);
		String enteredValue = hp.getPhoneTextfield().getAttribute("value");
		boolean hasAlphbets = enteredValue.matches(".*[^a-zA-Z0-9].*");
		utilityclassobject.gettest().log(Status.INFO, "Phone text field will not accept alphbets");
	}
}
