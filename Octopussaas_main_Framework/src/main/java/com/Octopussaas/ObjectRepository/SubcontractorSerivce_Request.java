package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubcontractorSerivce_Request {
	
	 WebDriver driver;


	public SubcontractorSerivce_Request(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//h6[contains (text(),'OCTO Connect')]")
	private WebElement octoConnect;
	@FindBy (xpath = "//h6[contains (text(),'Subcontractor Service Request')]")
	private WebElement subcontractorService;
	@FindBy (xpath = "//h1[contains (text(),'Incoming SSR')]")
	private WebElement incomingSSR;
	@FindBy (xpath = "(//h6[@class='text-nowrap text-sm font-normal text-cardTextGray '])[1]")
	private WebElement requestFilter;
	@FindBy (xpath = "//span[text()='Transporter']/../../..")
	private WebElement transporterDrp;
	@FindBy (xpath = "//span[contains (text(),'Maisie Medical Waste Solutions (T-3)')]")
	private WebElement medicalWaste;
	@FindBy (xpath = "//span[contains (text(),'SD med waste (T-7)')]")
	private WebElement sdWaste;
	@FindBy (xpath = "//span[contains (text(),'Migration Test 1st Display Name (T-20)')]")
	private WebElement migrationDisplay;
	@FindBy (xpath = "//input[@placeholder='Search options...']")
	private WebElement searchOption;
	@FindBy (xpath = "(//span[text()='Pending']/../..)[1]")
	private WebElement statusDrp;
	@FindBy (xpath = "//span[contains (text(),'Pending')]/../input/..")
	private WebElement pendingStatus;
	@FindBy (xpath = "//span[contains (text(),'Accepted')]/../input/..")
	private WebElement acceptedStatus;
	@FindBy (xpath = "//span[contains (text(),'Declined')]/../input/..")
	private WebElement declinedStatus;
	@FindBy (xpath = "//span[contains (text(),'Canceled')]/../input/..")
	private WebElement canceledStatus;
	@FindBy (xpath = "//span[contains (text(),'Termination Requested')]/../input/..")
	private WebElement terminationStatus;
	@FindBy (xpath = "//span[contains (text(),'Terminated')]/../input/..")
	private WebElement terminatedStatus;
	@FindBy (xpath = "(//button[@class='px-2 text-primary text-nowrap hover:text-blue-900 text-sm'])[1]")
	private WebElement incominfFilter;

	public WebElement getIncominfFilter() {
		return incominfFilter;
	}

	public WebElement getTerminatedStatus() {
		return terminatedStatus;
	}

	public WebElement getTerminationStatus() {
		return terminationStatus;
	}

	public WebElement getCanceledStatus() {
		return canceledStatus;
	}

	public WebElement getDeclinedStatus() {
		return declinedStatus;
	}

	public WebElement getAcceptedStatus() {
		return acceptedStatus;
	}

	public WebElement getPendingStatus() {
		return pendingStatus;
	}

	public WebElement getStatusDrp() {
		return statusDrp;
	}

	public WebElement getSearchOption() {
		return searchOption;
	}

	public WebElement getMigrationDisplay() {
		return migrationDisplay;
	}

	public WebElement getSdWaste() {
		return sdWaste;
	}

	public WebElement getMedicalWaste() {
		return medicalWaste;
	}

	public WebElement getTransporterDrp() {
		return transporterDrp;
	}

	public WebElement getRequestFilter() {
		return requestFilter;
	}

	public WebElement getIncomingSSR() {
		return incomingSSR;
	}

	public WebElement getSubcontractorService() {
		return subcontractorService;
	}

	public WebElement getOctoConnect() {
		return octoConnect;
	}

}
