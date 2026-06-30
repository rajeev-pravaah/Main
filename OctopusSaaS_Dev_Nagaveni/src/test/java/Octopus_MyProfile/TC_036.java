package Octopus_MyProfile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_036 extends Baseclass {
	
	@Test
	public void TC_036myProfile_AdminwithStandard() throws InterruptedException
	{

		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.Standard();
		WebElement adminCheckbox= hp.getAdminRole();
		if (!adminCheckbox.isEnabled()) {
		    utilityclassobject.gettest().log(Status.PASS, "Admin checkbox is disabled when standard checkbox is selected");
		    System.out.println("Admin checkbox is disabled when standard is selected");
		}
		else {
		utilityclassobject.gettest().log(Status.INFO, "user is able not able to check the Admin checkbox when the Standard checkbox is checked");
		}
	}

}
