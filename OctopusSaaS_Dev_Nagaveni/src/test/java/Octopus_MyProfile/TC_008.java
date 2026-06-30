package Octopus_MyProfile;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_008 extends Baseclass{
	
	@Test
	public void TC_008myProfile_Mysettings()
	{
		HomePage hp = new HomePage(driver);
		hp.MysettingsProfile();
		utilityclassobject.gettest().log(Status.INFO, "My setting page is displayed with all the following contains");

	}

}
