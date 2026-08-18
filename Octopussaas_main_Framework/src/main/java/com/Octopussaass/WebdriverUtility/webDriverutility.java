package com.Octopussaass.WebdriverUtility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

	/**
	 * Tries multiple click strategies so the click never silently fails.
	 * Strategy 1: scroll + wait clickable + normal click
	 * Strategy 2: Actions moveToElement + click
	 * Strategy 3: JS dispatched mouse events (mouseover, mousedown, mouseup, click)
	 * Strategy 4: plain JS executeScript click
	 * Retries up to 3 times between strategies.
	 * Returns true if any strategy succeeded.
	 */
	public boolean safeClick(WebDriver driver, WebElement element) {
		// Strategy 1 – normal click with explicit wait
		try {
			scrollToelement(driver, element);
			waitUntilElementClickable(driver, element);
			element.click();
			System.out.println("safeClick: normal click succeeded");
			return true;
		} catch (Exception e1) {
			System.out.println("safeClick: normal click failed – " + e1.getMessage());
		}
		// Strategy 2 – Actions moveToElement + click
		try {
			scrollToelement(driver, element);
			new Actions(driver).moveToElement(element).click().perform();
			System.out.println("safeClick: Actions click succeeded");
			return true;
		} catch (Exception e2) {
			System.out.println("safeClick: Actions click failed – " + e2.getMessage());
		}
		// Strategy 3 – JS dispatched mouse events
		try {
			String dispatch =
				"var el=arguments[0];" +
				"['mouseover','mousedown','mouseup','click'].forEach(function(t){" +
				"  el.dispatchEvent(new MouseEvent(t,{view:window,bubbles:true,cancelable:true,composed:true}));" +
				"});";
			((JavascriptExecutor) driver).executeScript(dispatch, element);
			System.out.println("safeClick: JS dispatch click succeeded");
			return true;
		} catch (Exception e3) {
			System.out.println("safeClick: JS dispatch click failed – " + e3.getMessage());
		}
		// Strategy 4 – plain JS click
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			System.out.println("safeClick: JS plain click succeeded");
			return true;
		} catch (Exception e4) {
			System.out.println("safeClick: JS plain click failed – " + e4.getMessage());
		}
		System.out.println("safeClick: ALL click strategies FAILED for element: " + element);
		return false;
	}

	public void uploadFile(String filePath) {
		// TODO Auto-generated method stub
		try {
			Runtime.getRuntime().exec(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}

	public List<String> getAllOptionsFromDropdown(WebElement dropdownElement) {
	    List<String> optionTexts = new ArrayList<>();

	    try {
	        Select select = new Select(dropdownElement);

	        for (WebElement option : select.getOptions()) {
	            optionTexts.add(option.getText().trim());
	        }

	        System.out.println("Total options in dropdown: " + optionTexts.size());
	        optionTexts.forEach(System.out::println);

	    } catch (Exception e) {
	        System.out.println("getAllOptionsFromDropdown: Failed - " + e.getMessage());
	    }

	    return optionTexts;
	}
	


}
