package OctopussaasBillingSettings;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClass80;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_001DashBoardPage extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	@Test
    public void TC_001dashboardpage()
    {
		utilityclassobject.gettest().log(Status.INFO, "Login Page is displayed");
		lp=new LoginPage(driver);		lp.getLoginBtn().click();
		hp = new HomePage(driver);
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed");
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = "Octopus SaaS";
		Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
		utilityclassobject.gettest().log(Status.INFO, "Dashboard page is displayed");

    }

}
