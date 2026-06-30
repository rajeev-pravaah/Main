package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_002 extends Baseclass {
	@Test
	public void TC_002Myprofile_Transporter() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.TransporterSettings();
		utilityclassobject.gettest().log(Status.INFO, "Transporter Setting page is displayed");

	}

}
