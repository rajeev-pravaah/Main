package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Generator_Dashboard {
	WebDriver driver;

	public Generator_Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebDriver getDriver() {
		return driver;
		}
	@FindBy(xpath = "//h6[text()='Add New']")
	private WebElement addnewbutton;
	@FindBy(xpath = "//li[text()='Generator']")
	private WebElement generatorbtn;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement generatornametxtfield;
	@FindBy(xpath = "//button[text()='Add new generator']")
	private WebElement addnewgeneratorbtn;
	@FindBy(xpath = "//h6[@title='Generator Name']")
	private WebElement generatornametxt;
	
	
	
	
	
	
	
	
	
	
	

	public WebElement getGeneratornametxt() {
		return generatornametxt;
	}

	public WebElement getAddnewgeneratorbtn() {
		return addnewgeneratorbtn;
	}

	public WebElement getGeneratornametxtfield() {
		return generatornametxtfield;
	}

	public WebElement getGeneratorbtn() {
		return generatorbtn;
	}

	public WebElement getAddnewbutton() {
		return addnewbutton;
	}
	
	
}
