package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetsRoutes {
	WebDriver driver;

	public AssetsRoutes(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebDriver getDriver() {
		return driver;
	}
	@FindBy(xpath = "//h6[text()='Assets']")
	private WebElement assets;
	@FindBy(xpath = "//h6[text()='Routes']")
	private WebElement routes;
	@FindBy(xpath ="//span[text()='Add New Route']")
	private WebElement addnewroute;
	@FindBy(xpath ="//h2[text()='Routes List']")
	private WebElement routelist;
	@FindBy(xpath ="//h2[text()='Route Details']")
	private WebElement routedetails;
	
	
	
	
	
	
	
	
	
	
	
	

	

	public WebElement getRoutedetails() {
		return routedetails;
	}

	public WebElement getRoutelist() {
		return routelist;
	}

	public WebElement getAddnewroute() {
		return addnewroute;
	}

	public WebElement getRoutes() {
		return routes;
	}

	public WebElement getAssets() {
		return assets;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
