package Octopus_MyProfile;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


public class TC_019 extends Baseclass {
	
	@Test
	public void TC_019myProfile_EmailwithEdit() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Mysettings();
		WebElement emailField = hp.getEmail();
		String readonly = emailField.getAttribute("disabled step");
		System.out.println(readonly);
		boolean isEditable = true;
		    try {
		        emailField.sendKeys("test@gmail.com");
		    } catch (Exception e) {
		        isEditable = false;
		    }
		    	Assert.assertTrue(readonly != null || !isEditable, "Email field is editable!");

		    utilityclassobject.gettest().log(Status.INFO, "Email Textfield is not editable");
		}

}
