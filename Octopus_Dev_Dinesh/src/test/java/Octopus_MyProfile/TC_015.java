package Octopus_MyProfile;

import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_015 extends Baseclass{

	@Test
	public void TC_015myProfile_lastnamewithEdit() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getLastname().click();
		hp.getLastname().sendKeys(Keys.CONTROL + "a");
		hp.getLastname().sendKeys(Keys.DELETE);
		hp.getLastname().sendKeys("bigb");
		utilityclassobject.gettest().log(Status.INFO, "Lastname in the textfield can be edited");
	}
}
