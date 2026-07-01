package GeneratorDashboard;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.Generator_Dashboard;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Generator_Dashboard_TC extends BaseClassForGEneratorContacts{
	Generator_Dashboard gd;
	
	
	
	
	
	
	
	@Test
	public void TC_001_verify_Generator_Dashboard() {
		gd = new Generator_Dashboard(driver);
		gd.getAddnewbutton().click();
		gd.getGeneratorbtn().click();
		System.out.println("Generator button clicked sucessfully : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Generator button clicked sucessfully : PASS");
		int randomNumber = (int) (Math.random() * 10000);
        String generatorName = "Generator_" + randomNumber;
		gd.getGeneratornametxtfield().sendKeys(generatorName);
		System.out.println("Generator name added sucessfully : PASS");
		utilityclassobject.gettest().log(Status.INFO, "Generator name added sucessfully : PASS");
		gd.getAddnewgeneratorbtn().click();
		WebElement gname = gd.getGeneratornametxt();
		if(gname.getText().contains(generatorName)) {
			System.out.println("generator information page displayed sucessfully");
			utilityclassobject.gettest().log(Status.PASS, "Generator button clicked sucessfully : PASS");}
		else {
			System.out.println("generator information page displayed sucessfully");
			utilityclassobject.gettest().log(Status.FAIL, "generator information not page displayed ");
		}
	}}
	

