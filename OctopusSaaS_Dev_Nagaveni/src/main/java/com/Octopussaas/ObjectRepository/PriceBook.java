package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceBook {
	WebDriver driver;

	public PriceBook(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement togglebtn;
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement yesbtn;
	
	@FindBy(xpath = " (//input[@type='number' and @inputmode='decimal'])[4]")
	private WebElement seventeengalServiceprice;
	@FindBy(xpath = "(//input[@type='number' and @inputmode='decimal'])[7]")
	private WebElement eighteenserviceprice;
	@FindBy(xpath = "(//div[@class='relative'])[1]")
	private WebElement profile;
	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	private WebElement logoutbtn;

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public WebElement getProfile() {
		return profile;
	}
	public WebElement getSeventeengalServiceprice() {
		return seventeengalServiceprice;
	}
	public WebElement getEighteenserviceprice() {
		return eighteenserviceprice;
	}
	public WebElement getYesbtn() {
		return yesbtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getTogglebtn() {
		return togglebtn;
	}
 
	public void ViewModeToggle()
	{
		driver.navigate().refresh();

		togglebtn.click();
		yesbtn.click();
	}
	public void SeventeenServicePrice(String Gal1)
	{
		seventeengalServiceprice.click();
		
		seventeengalServiceprice.sendKeys(Keys.CONTROL,"a");
		seventeengalServiceprice.sendKeys(Keys.DELETE);
		seventeengalServiceprice.sendKeys(Gal1);



	}
	public void EighteenServicePrice(String Gal2)
	{
		eighteenserviceprice.click();
		eighteenserviceprice.sendKeys(Keys.CONTROL,"a");
		eighteenserviceprice.sendKeys(Keys.DELETE);
		eighteenserviceprice.sendKeys(Gal2);
	}
	public void Logout()
	{
		profile.click();
		Actions act = new  Actions(driver);
		act.moveToElement(logoutbtn).click().perform();
	}
	
}
