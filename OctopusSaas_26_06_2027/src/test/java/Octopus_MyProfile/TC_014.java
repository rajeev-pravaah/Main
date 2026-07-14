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


public class TC_014  extends Baseclass{

	@Test
	public void TC_014myProfile_lastnamewithInput() throws InterruptedException, EncryptedDocumentException, IOException
	{
		javautility	jlib = new javautility();
		ExcelUtility elib = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getLastname().click();
		hp.getLastname().sendKeys(Keys.CONTROL + "a");
		hp.getLastname().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("MyProfile", 4, 1);
		hp.getLastname().sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "LastName  textfield will accept input");

	}
	
}
