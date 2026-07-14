package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_004  extends Baseclass{

	@Test
	public void TC_004Myprofile_Auditlog() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Auditlog();
		utilityclassobject.gettest().log(Status.INFO, "AuditLog Page is displayed");
	}
}
