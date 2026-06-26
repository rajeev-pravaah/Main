package Octopus_MyProfile;

import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_010 extends Baseclass{

	@Test
	public void TC_010myprofile_FirstnamewithEdit() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getFirstName().click();
		hp.getFirstName().sendKeys(Keys.CONTROL + "a");
		hp.getFirstName().sendKeys(Keys.DELETE);
		hp.getFirstName().sendKeys("henry");
		utilityclassobject.gettest().log(Status.INFO, "First Name can be edited in Myprofile");
	}
	
}
