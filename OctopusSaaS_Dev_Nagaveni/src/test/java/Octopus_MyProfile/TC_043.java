package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_043 extends Baseclass {
	
	@Test
	public void TC_043myprofile_withMultipleService() throws InterruptedException
	{
		HomePage hp = new HomePage(driver); 
		hp.Mysettings();
		hp.MutipleService();
		utilityclassobject.gettest().log(Status.INFO, "user is able to select mutilple service at time");

	}
	
	

}
