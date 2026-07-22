package com.Octopussaass.WebdriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class utilityclassobject  {
	
    public static ThreadLocal<ExtentTest> test =new ThreadLocal<ExtentTest>();
    
   public static ThreadLocal<WebDriver>  driver= new ThreadLocal<WebDriver>();
   
   public static ExtentTest gettest()
   {
      ExtentTest t = test.get();
      if(t == null) {
          // If listener didn't initialize ExtentTest (e.g. listener not attached),
          // return a lightweight fallback ExtentTest to avoid NPE in tests.
          try {
              ExtentReports fallback = new ExtentReports();
              ExtentTest fallbackTest = fallback.createTest("FALLBACK_TEST_NO_LISTENER");
              return fallbackTest;
          } catch (Throwable e) {
              // As a last resort, return null (callers should guard if necessary)
              return null;
          }
      }
      return t;
   }
   public static void setTest(ExtentTest actTest)
   {
	   test.set(actTest);
   }
   public static void setDriver(WebDriver actDriver)
   {
	   driver.set(actDriver);
   }
   public static WebDriver getDriver() {
	   return driver.get();
   }

}
