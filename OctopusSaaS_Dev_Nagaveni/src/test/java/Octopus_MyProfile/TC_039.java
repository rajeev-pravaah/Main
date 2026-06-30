package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_039 extends Baseclass{
	
	@Test
	public void TC_039myprofile_ServiceOverview() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.Serviceoverview();
		utilityclassobject.gettest().log(Status.INFO, "user is able to select the service overview from the dropdown");

	}

}
