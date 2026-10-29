package com.Octopussaas.BaseUtility;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.FileUtility.FileUtility;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;

public class BaseClass80 {
	public FileUtility flib = new FileUtility();
	public ExcelUtility Elib = new ExcelUtility();	
	public javautility jlib = new javautility();
	public webDriverutility wlib = new webDriverutility();

	public WebDriver driver = null;
	public static  WebDriver sdriver=null;
	
	@BeforeClass(alwaysRun = true)
	public void Bc(/*@Optional("Chrome") String browser*/) throws IOException, InterruptedException {
		System.out.println("Before class");
		Thread.sleep(2000);
		
		
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> prefs = new HashMap<>();
			prefs.put("autofill.profile_enabled", false);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			// ChromeOptions options = new ChromeOptions();
		       // options.addArguments("--force-device-scale-factor=0.8"); // 80% 
			driver= new ChromeDriver(options);
			 

		}
		else
		{
			driver=new ChromeDriver();
		}
		sdriver= driver;
		utilityclassobject.setDriver(driver);
		 
         wlib.waitForPageLoad(driver);
}
	@BeforeMethod(alwaysRun = true)
	public void Bm() throws IOException, InterruptedException {
		System.out.println("Before method");
		String URL = flib.getDataFromPropertiesFile("url");
		Thread.sleep(2000);

		driver.get(URL);
		wlib.waitForPageLoad(driver);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		String USERNAME = flib.getDataFromPropertiesFile("username");
		System.out.println(USERNAME);
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		//;age lp = new LoginPage(driver);
		Thread.sleep(3000);
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		//adjust screen size to 80%
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
		
		

	}
	@AfterMethod(alwaysRun = true)
	public void Am() throws InterruptedException {
		System.out.println("After method");
		Thread.sleep(2000);
	}
	
	

	

	@AfterClass(alwaysRun = true)
	public void Ac() throws InterruptedException {
		System.out.println("After class");
		Thread.sleep(2000);

	

		driver.quit();
		Thread.sleep(2000);
	}
	
	

}