package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_035 extends Baseclass{
	
	@Test
	public void TC_035myProfile_StandardwithoutAdmin() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.Standard();
		utilityclassobject.gettest().log(Status.INFO, "user is able to check the standard checkbox when the admin checkbox is unchecked");

		
	}

}
