package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_037 extends Baseclass{
	
	@Test
	public void TC_037myprofile_Notification() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.NotificationDropdown();
		utilityclassobject.gettest().log(Status.INFO, "Notification assigned to the profile appears in the field with the follwing service");
		

	}

}
