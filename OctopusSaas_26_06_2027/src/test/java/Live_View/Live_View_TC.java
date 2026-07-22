package Live_View;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LiveView;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)
public class Live_View_TC extends BaseClassForGEneratorContacts{
	HomePage hp;
	LiveView lv;
	
	 webDriverutility wlib;
	
	@Test
	public void Live_View() throws InterruptedException  {
		hp = new HomePage(driver);
		Thread.sleep(6000);
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("Home Page is displayed");
		lv = new LiveView(driver);
		lv.getOperations().click();
		lv.getLive_View().click();
		 lv.getLive_View_Page().isDisplayed();
			utilityclassobject.gettest().log(Status.INFO, "Live view page is displayed successfully");
		 System.out.println("Live View Page is displayed");
		 Thread.sleep(15000);
		 //refresh the page to load the route names
		 driver.switchTo().defaultContent();
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		 wlib = new webDriverutility();
		 wlib.scrollToelement(driver, lv.getView_Details());
		 List<WebElement> routenames = lv.getRouteName();

                int count = routenames.size();

              System.out.println("Total Elements Count: " + count);
		 for (WebElement route : routenames) {
			 String routeName = route.getText();
			 if(routeName.contains("David Route")) {
				 wlib.scrollToelement(driver, route);
				 System.out.println( routeName);

				 utilityclassobject.gettest().log(Status.INFO, "Route Name is displayed successfully");
				 System.out.println("Route Name is displayed");
			 }
		 }
		
		
	}
}
