package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_006 extends Baseclass{
	
	@Test
	public void TC_006myProfile_Logout() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Logout();
		utilityclassobject.gettest().log(Status.INFO, "user ia able to logout from the Myprofile page");
	}

}
