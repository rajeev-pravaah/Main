package com.Octopussaas.BaseUtility;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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

public class BaseClassForGEneratorContacts {
	public FileUtility flib = new FileUtility();
	public ExcelUtility Elib = new ExcelUtility();	
	public javautility jlib = new javautility();
	public webDriverutility wlib = new webDriverutility();

	public WebDriver driver = null;
	public static  WebDriver sdriver=null;
	ChromeOptions options;
	@BeforeClass(alwaysRun = true)
	public void Bc(/*@Optional("Chrome") String browser*/) throws IOException, InterruptedException, AWTException {
		System.out.println("Before class");
		Thread.sleep(2000);
		
		
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
	        //driver = new EdgeDriver();


		} else if (BROWSER.equalsIgnoreCase("chrome")) {

			
		 options = new ChromeOptions();
		// options.addArguments("--disable-save-password-bubble");
	     //   options.addArguments("--disable-notifications");
			HashMap<String, Object> prefs = new HashMap<>();
			prefs.put("autofill.profile_enabled", false);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			// ChromeOptions options = new ChromeOptions();
		       // options.addArguments("--force-device-scale-factor=0.8"); // 80% 
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.setExperimentalOption("excludeSwitches",
			        Arrays.asList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			
			driver= new ChromeDriver(options);
			((JavascriptExecutor) driver).executeScript(
				    "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
			//to clear all the cookies
			driver.manage().deleteAllCookies();
			System.out.println("Chrome Version : " +
			        ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());
			
			 

		}
		else if (BROWSER.equalsIgnoreCase("edge")) {

		    System.setProperty(
		        "webdriver.edge.driver",
		        "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		    driver = new EdgeDriver();
		}
		   
		else
		{
			driver=new ChromeDriver();
			System.out.println("Chrome Version : " +
			        ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());
			
		}
		sdriver= driver;
		utilityclassobject.setDriver(driver);
		 
		
		
         wlib.waitForPageLoad(driver);
         String URL = flib.getDataFromPropertiesFile("url").trim();
 		Thread.sleep(2000);
 		

 		driver.get(URL);
 		Thread.sleep(3000);
 		wlib.waitForPageLoad(driver);
 		driver.manage().window().maximize();
 		Thread.sleep(2000);

 		String USERNAME = flib.getDataFromPropertiesFile("username").trim();
 		System.out.println(USERNAME);
 		String PASSWORD = flib.getDataFromPropertiesFile("password").trim();
 		//;age lp = new LoginPage(driver);
 		Thread.sleep(3000);
 		LoginPage lp = new LoginPage(driver);
 		lp.LoginToApp(USERNAME, PASSWORD);
 		
 		Robot robot = new Robot();

 		robot.keyPress(KeyEvent.VK_CONTROL);
 		robot.keyPress(KeyEvent.VK_SUBTRACT);
 		robot.keyRelease(KeyEvent.VK_SUBTRACT);
 		robot.keyPress(KeyEvent.VK_SUBTRACT);
 		robot.keyRelease(KeyEvent.VK_SUBTRACT);
 		robot.keyRelease(KeyEvent.VK_CONTROL);
}
	
	
	@BeforeMethod(alwaysRun = true)
	public void Bm() throws IOException, InterruptedException {
		System.out.println("Before method");
		
		 

		
		
		
		

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

	

		//driver.quit();
		Thread.sleep(2000);
	}
}