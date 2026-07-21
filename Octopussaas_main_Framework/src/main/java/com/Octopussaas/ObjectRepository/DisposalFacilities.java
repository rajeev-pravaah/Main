package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisposalFacilities {

	WebDriver driver;

	public DisposalFacilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	public WebDriver getDriver() {
		return driver;
	}
	
	
	@FindBy(xpath = "//h6[text()='Assets']")
	private WebElement assetsDD;
	@FindBy(xpath = "//h6[text()='Disposal Facilities']")
	private WebElement disposalFacilities;
	@FindBy(xpath = "//h2[text()='Disposal Facilities List']")
	private WebElement disposalFacilitiesList;
	@FindBy(xpath = "(//div[@class='relative inline-block'])[2]")
	private WebElement octoinfologo;
	@FindBy(xpath = "//h2[text()='OCTO Info: Disposal Facility']")
	private WebElement octoinfoDisposalFacilityfromtooltip;
	@FindBy(xpath = "//button[@aria-label='Close tooltip']")
	private WebElement closeTooltip;
	@FindBy(xpath = "//span[text()='Add New Disposal Facility']")
	private WebElement addNewDisposalFacilitybtn;
	
	
	
	
	
	
	public WebElement getAddNewDisposalFacilitybtn() {
		return addNewDisposalFacilitybtn;
	}
	public WebElement getCloseTooltip() {
		return closeTooltip;
	}
	public WebElement getOctoinfoDisposalFacilityfromtooltip() {
		return octoinfoDisposalFacilityfromtooltip;
	}
	public WebElement getOctoinfologo() {
		return octoinfologo;
	}
	public WebElement getDisposalFacilitiesList() {
		return disposalFacilitiesList;
	}
	public WebElement getDisposalFacilities() {
		return disposalFacilities;
	}
	public WebElement getAssetsDD() {
		return assetsDD;
	}
	
}
