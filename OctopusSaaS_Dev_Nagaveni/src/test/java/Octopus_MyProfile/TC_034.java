package Octopus_MyProfile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_034 extends Baseclass{
	
	@Test
	public void TC_034myprofile_StandardwithAdmin() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		hp.getRoles().click();
		WebElement standardCheckbox = hp.getStandardRole();
		if (!standardCheckbox.isEnabled()) {
		    utilityclassobject.gettest().log(Status.PASS, "Standard checkbox is disabled when Admin is selected");
		    System.out.println("Standard checkbox is disabled when Admin is selected");
		}
		else {
		utilityclassobject.gettest().log(Status.INFO, "user is able not able to check the standard checkbox when the admin checkbox is checked");
		}
	}

}
