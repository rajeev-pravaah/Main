package Octopus_MyProfile;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_021 extends Baseclass{
	
	@Test 
	public void TC_021myProfile_PasswordwithPopup()
	{
		HomePage hp = new HomePage(driver);
		hp.ChangePassword();
	    utilityclassobject.gettest().log(Status.INFO, "Password Textfield is clickable");	

		
	}

}
