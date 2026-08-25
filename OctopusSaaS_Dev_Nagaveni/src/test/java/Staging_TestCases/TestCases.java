package Staging_TestCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseclassforStaging;
import com.Octopussaas.ObjectRepository.Staging;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

public class TestCases extends BaseclassforStaging {
	Staging stag;
	int sixDigit;
	
	@Test
	public void TC_001VerifyUnappliedcheckspageloadswithcheckdata() throws InterruptedException
	{
		 stag = new Staging(driver);
		 stag.getAddnew().click(); 
		 Thread.sleep(200); 
		 stag.getGenerator().click();
		 Thread.sleep(200); 
		 stag.getGeneratorName().click(); 
		 Random random = new Random(); 
		 sixDigit = 100000 + random.nextInt(900000); 
		 String generator = "Generator"+ sixDigit;
		 stag.getGeneratorName().sendKeys(generator);
		 System.out.println(generator);		  
		 stag.getAccountNumber().click(); 
		 stag.getAccountNumber().sendKeys("1235698");
		 Thread.sleep(200); 
		 stag.getAddnewGenerator().click(); 
		 Thread.sleep(20000);
		 WebElement generatorInformation = driver.findElement(By.xpath("//div[@class='h-full p-5']"));
		 Assert.assertTrue(generatorInformation.isDisplayed(),"Generator Information page is displayed"); 
		 System.out.println("The user is able to access the generator information page");
		 utilityclassobject.gettest().log(Status.INFO,"The user is able to access the generator information page");
		 
		 stag.getStreet().click();
		 stag.getStreet().sendKeys("3456 4");
		 WebElement input = driver.findElement(By.xpath("//div[contains (text(),'3456 Four Mile Run Road')]"));
		 input.click();
		 stag.getServiceEmail().click();
		 String email = "test"+ sixDigit+ "@gmail.com";
		 stag.getServiceEmail().sendKeys(email);
		 stag.getServicephone().click();
		 stag.getServicephone().sendKeys("9876544312");
		 Thread.sleep(200);
		 stag.getCopyButton().click();
		 stag.getCopyButton().click();
		 stag.getCopyButton().click();
		 stag.getCopyButton().click();
		 System.out.println("User is able to select the copy the information");
		 stag.Contracted();
		 System.out.println("Contracted checkbox is selected");
		 
		 
		 
		 
		 
		 
		 
		
	}

}
