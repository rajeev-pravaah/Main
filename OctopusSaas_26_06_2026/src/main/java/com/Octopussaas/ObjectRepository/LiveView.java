package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveView {
	WebDriver driver;

	public LiveView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h6[text()='Operations']")
	private WebElement Operations;

	public WebDriver getDriver() {
		return driver;
	}

	
	
	@FindBy(xpath = "//h6[text()='Live View']")
	private WebElement Live_View;
	@FindBy(xpath = "//p[text()='Live View']")
	private WebElement Live_View_Page;
	@FindBy(xpath = "//button[text()='View Details']")
	private WebElement View_Details;
	@FindBy(xpath = "//div[@class='w-80 overflow-y-auto flex-shrink-0']/descendant::span")
	private List<WebElement> RouteName;
	
	
	
	
	
	
	
	
	public List<WebElement> getRouteName() {
		return RouteName;
	}
	public WebElement getView_Details() {
		return View_Details;
	}
	public WebElement getLive_View_Page() {
		return Live_View_Page;
	}
	public WebElement getOperations() {
		return Operations;
	}
	public WebElement getLive_View() {
		return Live_View;
	}
	
	
}
