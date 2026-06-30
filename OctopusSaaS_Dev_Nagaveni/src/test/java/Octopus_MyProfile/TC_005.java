package Octopus_MyProfile;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_005 extends Baseclass{

	@Test
	public void TC_005Myprofile_HistoricalSettings() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.Historicalmanifest();
		utilityclassobject.gettest().log(Status.INFO, "Historical Manifest Setting page is displayed");
	}
}
