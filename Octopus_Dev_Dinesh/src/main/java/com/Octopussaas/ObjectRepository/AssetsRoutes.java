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
	@FindBy(xpath ="(//div[@class=\"relative inline-block\"])[2]")
	private WebElement routedetails;
	@FindBy(xpath ="//button[@aria-label='Close tooltip']")
	private WebElement routedetailscls;	
	@FindBy(xpath ="//div[@class=\"atlas-control-container\"]")
	private WebElement mapcanvas;
	@FindBy(xpath ="//div[contains(@class,'bottom-5') and contains(@class,'right-5')]/button[1]")
	private WebElement zoominbtn;
	@FindBy(xpath ="//div[contains(@class,'bottom-5') and contains(@class,'right-5')]/button[2]")
	private WebElement zoomoutbtn;
	@FindBy(xpath ="//input[@placeholder=\"Enter Route Name\"]")
	private WebElement routename;
	@FindBy(xpath ="(//button[@id=\"default-start location *\"])")
	private WebElement defaultstartloc;
	@FindBy(xpath ="(//div[text()='Main Location'])")
	private WebElement defaultstartlocmainloc;
	@FindBy(xpath ="(//div[text()='Satellite Locations'])")
	private WebElement defaultstartlocsateliteloc;
	@FindBy(xpath ="(//div[@class='flex items-center gap-2'])[4]")
	private WebElement defaultstartloc1satelite;
	@FindBy(xpath ="(//button[normalize-space()='Yes'])")
	private WebElement yes1;
	@FindBy(xpath ="(//div[text()='Disposal Facilities'])")
	private WebElement defaultstartlocdisposal;
	@FindBy(xpath ="(//div[@class='flex items-center gap-2'])[21]")
	private WebElement defaultstartloc1disposal;
	@FindBy(xpath ="(//button[normalize-space()='Cancel'])")
	private WebElement cancel1;
	@FindBy(xpath ="//h3[text()='Are you sure to change this route start location?']")
	private WebElement areyousure;
	@FindBy(xpath ="//input[@spellcheck='false']")
	private WebElement routecolour;
	@FindBy(xpath ="//div[@aria-label='Color']")
	private WebElement colourbox;
	@FindBy(xpath ="//div[@class='flex items-center gap-1 overflow-x-hidden py-1 pl-2 w-full']")
	private WebElement routetype;
	@FindBy(xpath ="//p[text()='Route Type is required']")
	private WebElement routetypevalidation;
	@FindBy(xpath ="//button[@id='default-end location *']")
	private WebElement defaultendloc;
	@FindBy(xpath ="(//div[text()='Main Location'])")
	private WebElement defaultendlocmainloc;
	@FindBy(xpath ="(//div[text()='Satellite Locations'])")
	private WebElement defaultendlocsateliteloc;
	@FindBy(xpath ="(//div[@class='flex items-center gap-2'])[4]")
	private WebElement defaultendloc1satelite;
	@FindBy(xpath ="(//button[@class='btn btn-primary btn-sm'])[2]")
	private WebElement yes2;
	@FindBy(xpath ="(//div[text()='Disposal Facilities'])")
	private WebElement defaultendlocdisposal;
	@FindBy(xpath ="(//div[@class='flex items-center gap-2'])[22]")
	private WebElement defaultendloc1disposal;
	@FindBy(xpath ="(//button[@class='btn btn-error btn-sm'])[2]")
	private WebElement cancel2;
	@FindBy(xpath ="//button[@id='status']")
	private WebElement statusfield;
	@FindBy(xpath ="//div[text()='Active']")
	private WebElement active;
	@FindBy(xpath ="//div[text()='Inactive']")
	private WebElement inactive;
	@FindBy(xpath ="(//button[@class='btn btn-primary btn-sm'])[3]")
	private WebElement yes3;
	@FindBy(xpath ="(//button[@class='btn btn-error btn-sm'])[3]")
	private WebElement cancel3;
	@FindBy(xpath ="//textarea[@id='note']")
	private WebElement note;
	@FindBy(xpath ="//h6[text()='Stats For Nerds']")
	private WebElement statsfornerds;
	@FindBy(xpath = "(//h6[@class='text-lg']/span)[1]")
	private WebElement servicesPerformed;
	@FindBy(xpath = "(//h6[@class='text-lg']/span)[2]")
	private WebElement scheduledServices;
	@FindBy(xpath = "(//h6[@class='text-lg']/span)[3]")
	private WebElement generatorsAssigned;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;
	@FindBy(xpath = "//p[text()='Route Name is required']")
	private WebElement routeNameValidation;
	@FindBy(xpath = "//p[text()='Default Start Location is required']")
	private WebElement defaultStartLocationValidation;
	@FindBy(xpath = "//p[text()='Route Type is required']")
	private WebElement routeTypeValidation1;
	@FindBy(xpath = "//p[text()='Default End Location is required']")
	private WebElement defaultEndLocationValidation;
	@FindBy(xpath = "//button[text()='View Route List']")
	private WebElement viewroutelist;
	@FindBy(xpath = "(//div[@class=\"relative inline-block\"])[2]")
	private WebElement routelisttooltip;
	@FindBy(xpath = "//button[@aria-label='Close tooltip']")
	private WebElement tooltipclose;
	@FindBy(xpath = "//span[text()='Route Status']")
	private WebElement statusfilter;
	@FindBy(xpath = "//div[text()='Out Of Network Services']")
	private WebElement OONservice;
	@FindBy(xpath = "//button[.//span[normalize-space()='Active']]")
	private WebElement active1;

	@FindBy(xpath = "//button[.//span[normalize-space()='Inactive']]")
	private WebElement inactive1;

	@FindBy(xpath = "//button[.//span[normalize-space()='Out Of Network Services']]")
	private WebElement outOfNetworkServices1;
	
	
	
	
	
	
	public WebElement getActive1() {
		return active1;
	}

	public WebElement getInactive1() {
		return inactive1;
	}

	public WebElement getOutOfNetworkServices1() {
		return outOfNetworkServices1;
	}

	public WebElement getOONservice() {
		return OONservice;
	}

	public WebElement getStatusfilter() {
		return statusfilter;
	}

	public WebElement getTooltipclose() {
		return tooltipclose;
	}

	public WebElement getRoutelisttooltip() {
		return routelisttooltip;
	}

	public WebElement getViewroutelist() {
		return viewroutelist;
	}

	public WebElement getRouteNameValidation() {
		return routeNameValidation;
	}

	public WebElement getDefaultStartLocationValidation() {
		return defaultStartLocationValidation;
	}

	public WebElement getRouteTypeValidation1() {
		return routeTypeValidation1;
	}

	public WebElement getDefaultEndLocationValidation() {
		return defaultEndLocationValidation;
	}
	
	public WebElement getSave() {
		return save;
	}

	public WebElement getServicesPerformed() {
		return servicesPerformed;
	}

	public WebElement getScheduledServices() {
		return scheduledServices;
	}

	public WebElement getGeneratorsAssigned() {
		return generatorsAssigned;
	}

	public WebElement getStatsfornerds() {
		return statsfornerds;
	}

	public WebElement getNote() {
		return note;
	}

	public WebElement getInactive() {
		return inactive;
	}
	public WebElement getYes3() {
		return yes3;
	}

	public WebElement getCancel3() {
		return cancel3;
	}

	public WebElement getActive() {
		return active;
	}

	public WebElement getStatusfield() {
		return statusfield;
	}

	public WebElement getCancel2() {
		return cancel2;
	}

	public WebElement getDefaultendlocdisposal() {
		return defaultendlocdisposal;
	}

	public WebElement getDefaultendloc1disposal() {
		return defaultendloc1disposal;
	}

	public WebElement getDefaultendlocsateliteloc() {
		return defaultendlocsateliteloc;
	}

	public WebElement getDefaultendloc1satelite() {
		return defaultendloc1satelite;
	}

	public WebElement getYes2() {
		return yes2;
	}

	public WebElement getDefaultendlocmainloc() {
		return defaultendlocmainloc;
	}

	public WebElement getDefaultendloc() {
		return defaultendloc;
	}

	public WebElement getRoutetypevalidation() {
		return routetypevalidation;
	}

	public WebElement getRoutetype() {
		return routetype;
	}

	public WebElement getColourbox() {
		return colourbox;
	}

	public WebElement getRoutecolour() {
		return routecolour;
	}

	public WebElement getAreyousure() {
		return areyousure;
	}

	public WebElement getCancel1() {
		return cancel1;
	}

	public WebElement getDefaultstartloc1disposal() {
		return defaultstartloc1disposal;
	}

	public WebElement getDefaultstartlocdisposal() {
		return defaultstartlocdisposal;
	}

	public WebElement getYes1() {
		return yes1;
	}

	public WebElement getDefaultstartloc1satelite() {
		return defaultstartloc1satelite;
	}

	public WebElement getDefaultstartlocsateliteloc() {
		return defaultstartlocsateliteloc;
	}

	public WebElement getDefaultstartlocmainloc() {
		return defaultstartlocmainloc;
	}

	public WebElement getDefaultstartloc() {
		return defaultstartloc;
	}

	public WebElement getRoutename() {
		return routename;
	}

	public WebElement getZoominbtn() {
		return zoominbtn;
	}

	public WebElement getZoomoutbtn() {
		return zoomoutbtn;
	}

	public WebElement getMapcanvas() {
		return mapcanvas;
	}

	public WebElement getRoutedetailscls() {
		return routedetailscls;
	}

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
