package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneratorManagentPage {
	WebDriver driver;

	public GeneratorManagentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchtxt;
	@FindBy(xpath = "//div[@title='Charlie_106893']")
	private WebElement chrlieacc;
	@FindBy(xpath = "//div[@class='min-w-fit']")
	private WebElement chaliefull;

	public WebElement getChaliefull() {
		return chaliefull;
	}

	public WebElement getChrlieacc() {
		return chrlieacc;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}
	public void CharlieAccount(String accountname) throws InterruptedException
	{
		searchtxt.sendKeys(accountname);
		Thread.sleep(3000);
		/*Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(chrlieacc).perform();
		chaliefull.click();
		//chrlieacc.click();
		///
		 */
		//driver.findElement(By.xpath("//div[@title='Charlie_106893']")).click();
		//driver.findElement(By.xpath("//div[@title='Charlie_106893']")).click();
		for(int i=0;i<3;i++) {
		    try {
		        driver.findElement(By.xpath("//div[@title='"+accountname+"']")).click();
		        break;
		    } 
		    catch(StaleElementReferenceException e) {
		        System.out.println("Retrying...");
		    }
		 
		}
	}
		public void CharlieAccounttwo(String accountname) throws InterruptedException
		{
			searchtxt.sendKeys(accountname);
			Thread.sleep(3000);
			
			for(int i=0;i<3;i++) {
			    try {
			        driver.findElement(By.xpath("//div[@title='"+accountname+"']")).click();
			        break;
			    } 
			    catch(StaleElementReferenceException e) {
			        System.out.println("Retrying...");
			    }
		}
		
		
	}
	
}
