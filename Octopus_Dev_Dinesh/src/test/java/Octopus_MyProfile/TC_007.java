package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_007 extends Baseclass {
	@Test
	public void TC_007myProfile_Viewtos() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.ViewTos();
		utilityclassobject.gettest().log(Status.INFO, "View TOS apge is displayed");

	}

}
