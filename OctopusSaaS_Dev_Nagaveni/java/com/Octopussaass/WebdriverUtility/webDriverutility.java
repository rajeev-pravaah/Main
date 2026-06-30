package com.Octopussaass.WebdriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverutility {

	// implicit wait
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

// explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Switch to tab on url
	public void switchToTabonURL(WebDriver driver, String PartialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains(PartialURL))
			{
				break;
			}
		}
	}

	// switch to new tab based on tiltle
	public void switchToTabonTitle(WebDriver driver, String Partiallink) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		System.out.println("size:" + set.size());
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String acturl = driver.getTitle();
			if (acturl.contains(Partiallink))
				;
			{
				// break;
			}
		}

	}

	// switch to frame
	public void switchToFrameonIDNEX(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameonNAME(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	public void switchToFrameonELEMENT(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// switch to alert
	public void switchToAlertandAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void switchToAlertandDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToAlertandsendkeys(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	// Dropdown
	public void selectByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement element, int num) {
		Select s = new Select(element);
		s.selectByIndex(num);
	}

	public void deselectByIndex(WebElement element, int num) {
		Select s = new Select(element);
		s.deselectByIndex(num);
	}

	public void deselectByvalue(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByValue(text);
	}

	public void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public void deselectByvisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	// Action class
	public void mousemoveonElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		;
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		;
	}

	public void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
		Actions act = new Actions(driver);
		act.clickAndHold(element1).moveToElement(element2).release().perform();
	}

	public void scrollToelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
		;
	}

	public void javascriptexecutor(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 150)");
	}

	public void waitForElementPresent(WebDriver driver, String homeTitle) {
		// TODO Auto-generated method stub
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(homeTitle));
		
	}
	public void waitUntilElementClickable(WebDriver driver, WebElement locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void uploadFile(String filePath) {
		// TODO Auto-generated method stub
		try {
			Runtime.getRuntime().exec(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}


}
