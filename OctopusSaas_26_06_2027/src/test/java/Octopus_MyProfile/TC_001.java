package Octopus_MyProfile;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;


	@Listeners(ListnerUtility.ListnerUilityImp.class )

	public class TC_001 extends Baseclass{
		HomePage hp;
		
		@Test
		public void TC_001myprofile_Dropdown() throws InterruptedException
		{
			hp = new HomePage(driver);
			hp.Myprofile();
			utilityclassobject.gettest().log(Status.INFO, "My profile is dropdown is displayed with follwing contains");
		}
		
		
}



