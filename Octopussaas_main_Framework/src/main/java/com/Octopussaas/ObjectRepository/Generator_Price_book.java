package com.Octopussaas.ObjectRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generator_Price_book {
	WebDriver driver;

	public Generator_Price_book(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@FindBy(xpath = "//h6[text()='Generator Management']")
	private WebElement generatorManagementDropdown;
	
	
	public WebElement getGeneratorManagement() {
		return generatorManagementDropdown;
	}
		
		
	@FindBy(xpath = "//h6[text()='Generator Locations']")
	private WebElement generatorLocation;
	
	public WebElement getGeneratorLocation() {
		return generatorLocation;
		
	}
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	@FindBy(xpath = "(//div[@class='w-40 h-full text-cardTextBlue text-wrap flex items-center'])[2]")
	private WebElement firstoptionfromsearchbox;
	
	public WebElement getFirstoptionfromsearchbox() {
		return firstoptionfromsearchbox;
	}
	
	@FindBy(xpath = "//a[text()='Price Book']")
	private WebElement priceBookpage;
	
	public WebElement getPriceBookpage() {
		return priceBookpage;
	}
	
	@FindBy(xpath = "//div[@class='flex items-center border-b']/descendant::button")
	private List<WebElement> menuoptions;
	
	
	public List<WebElement> getMenuoptions() {
		return menuoptions;
	}
	
	@FindBy(xpath = "//button[text()='SOW']")
	private WebElement scopeofworkbtn;
	
	
	public WebElement getScopeofworkBtn() {
		return scopeofworkbtn;
	}
	
	@FindBy(xpath = "//h3[text()='Scope Of Work (SOW)']")
	private WebElement scopeofworkpopup;
	
	public WebElement getScopeofworkpopup() {
		return scopeofworkpopup;
	}
	
	@FindBy(xpath = "//button[text()='SOW']/../descendant::div")
	private WebElement flatmontly;
	
	public WebElement getFlatmontly() {
		return flatmontly;
	}
	
	@FindBy(xpath = "//span[text()='View']/../descendant::button")
	private WebElement viewtoggledbutton;
	
	public WebElement getViewtoggledbutton() {
		return viewtoggledbutton;
	}
	@FindBy(xpath = "//span[text()='Edit']/../descendant::button")
	private WebElement edittoggledbutton;
	
	public WebElement getEdittoggledbutton() {
		return edittoggledbutton;
	}
	
	@FindBy(xpath = "(//button[@aria-label='Close'])[2]")
	private WebElement sowclosepopupbutton;
	
	public WebElement getSowClosePopupbutton() {
		return sowclosepopupbutton;
	
	}
	@FindBy(xpath = "//span[text()='Inactive']/../descendant::button")
	private WebElement inactivetoggledbutton;
	
	public WebElement getInactivetoggledbutton() {
		return inactivetoggledbutton;
	}
	
	@FindBy(xpath = "//p[text()='Selected Template']/../descendant::input")
	private WebElement selectedtemplatedropdown;
	
	public WebElement getSelectedtemplateDropdown() {
		return selectedtemplatedropdown;
	}
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> selectedtemplatedropdownoptions;
	
	public List<WebElement> getSelectedtemplateDropdownOptions() {
		return selectedtemplatedropdownoptions;
	}
	@FindBy(xpath = "//div[text()='Template applied successfully!']")
	private WebElement templateappliedsuccessmessage;
	
	public WebElement getTemplateAppliedSuccessMessage() {
		return templateappliedsuccessmessage;
	}
	
	
	@FindBy(xpath = "//div[@class='flex items-center border-b']/descendant::button")
	private WebElement servicecategorybutton;
	
	public WebElement getServiceCategoryButton() {
		return servicecategorybutton;
	}
	
	@FindBy(xpath = "//div[@class='flex flex-wrap gap-2']/descendant::button")
	private List<WebElement> servicecategoryoptions;
	
	public List<WebElement> getServiceCategoryOptions() {
		return servicecategoryoptions;
	}
	
	@FindBy(xpath = "//h3[text()='Bio/Sharps']")
	private WebElement biosharpheader;
	
	public WebElement getBioSharpHeader() {
		return biosharpheader;
	}
	
	@FindBy(xpath = "//h3[@class='text-m font-bold']/../descendant::div")
	private WebElement biosharpoctoinfoicon;
	
	
	public WebElement getBioSharpOctoInfoIcon() {
		return biosharpoctoinfoicon;
	}
	
	@FindBy(xpath = "//h3[@class='text-m font-bold']/../descendant::p")
	private WebElement numberofcontainerbesideservices;
	
	public WebElement getNumberOfContainerBesideServices() {
		return numberofcontainerbesideservices;
	}
	
	@FindBy(xpath = "//button[text()='Non-RCRA Pharmaceutical']")
	private WebElement nonrcrapharmaceuticalbutton;
	
	public WebElement getNonRCRAPharmaceuticalButton() {
		return nonrcrapharmaceuticalbutton;
	}
	
	@FindBy(xpath = "//p[@class='text-sm text-gray-500']")
	private WebElement containerscount;
	
	public WebElement getContainersCount() {
		return containerscount;
	}
	
	@FindBy(xpath = "//div[@class='flex min-w-0 items-start gap-2']")
	private List<WebElement> containerslist;
	
	public List<WebElement> getContainerslist() {
		return containerslist;
	}
	
	@FindBy(xpath = "//button[text()='RCRA Pharmaceutical']")
	private WebElement rcrapharmaceuticalbutton;
	
	
	public WebElement getRCRAPharmaceuticalButton() {
		return rcrapharmaceuticalbutton;
	}
	
	@FindBy(xpath = "//button[text()='Chemotherapy']")
	private WebElement chemotherapybutton;
	
	public WebElement getChemotherapyButton() {
		return chemotherapybutton;
	}
	
	@FindBy(xpath = "//button[text()='Paper Shredding']")
	private WebElement papershreddingbutton;
	
	public WebElement getPaperShreddingButton() {
		return papershreddingbutton;
	}
	
	@FindBy(xpath = "//button[text()='APHIS Waste']")
	private WebElement aphiswastebutton;
	
	public WebElement getAPHISWasteButton() {
		return aphiswastebutton;
	}
	
	@FindBy(xpath = "//button[text()='Product Destruction']")
	private WebElement productdestructionbutton;
	
	public WebElement getProductDestructionButton() {
		return productdestructionbutton;
	}
	
	@FindBy(xpath = "//button[text()='Universal Waste']")
	private WebElement universalwastebutton;
	
	public WebElement getUniversalWasteButton() {
		return universalwastebutton;
	}
	
	@FindBy(xpath = "//button[text()='Pathology']")
	private WebElement pathologybutton;
	
	public WebElement getPathologyButton() {
		return pathologybutton;
	}
	
	@FindBy(xpath = "//button[text()='Cannabis Waste']")
	private WebElement cannabiswastebutton;
	
	public WebElement getCannabisWasteButton() {
		return cannabiswastebutton;
	}
	
	@FindBy(xpath = "//div[@class='w-[3rem] flex-none overflow-hidden px-1 leading-tight']")
	private List<WebElement> servicecontainerscount;
	
	public List<WebElement> getServiceContainersCount() {
		return servicecontainerscount;
	}
	
	
	@FindBy(xpath = "//div[@class='w-[3rem] flex-none overflow-hidden px-1 leading-tight']")
	private WebElement copyfrommastercolumn;
	
	public WebElement getCopyFromMasterColumn() {
		return copyfrommastercolumn;
	}
	
	
	@FindBy(xpath = "//div[@class='flex w-[3rem] flex-none items-start justify-center pt-1']/descendant::button")
	private List<WebElement> copyfrommasterbuttons;
	
	public List<WebElement> getCopyFromMasterButtons() {
		return copyfrommasterbuttons;
	}
	
	@FindBy(xpath = "//p[text()='Selected Template']/../descendant::input")
	private WebElement selectedtemplatefield;
	
	public WebElement getSelectedTemplateField() {
		return selectedtemplatefield;
	}
	
	@FindBy(xpath = "//span[@class='line-clamp-3']")
	private WebElement suggestedtemplate;
	
	public WebElement getSuggestedTemplate() {
		return suggestedtemplate;
	}
	
	
	@FindBy(xpath = "//div[@class='w-[12rem] flex-none overflow-hidden pr-1 leading-tight']")
	private WebElement masteritemnamecolumn;
	
	public WebElement getMasterItemNameColumn() {
		return masteritemnamecolumn;
	}
	
	@FindBy(xpath = "//div[contains(@class, 'w-[12rem]')]//div[contains(@class, 'font-semibold') and contains(@class, 'text-slate-800')]")
	private List<WebElement> masteritemnameslists;
	
	public List<WebElement> getMasterItemNamesLists() {
		return masteritemnameslists;
	}
	
	@FindBy(xpath = "//input[@type='number']")
	private WebElement  servicepriceinputfield;
	
	public WebElement getServicePriceInputField() {
		return servicepriceinputfield;
	}
	
	@FindBy(xpath = "//span[@class='mt-0.5 inline-flex h-3.5 w-3.5 flex-none rounded-full border border-amber-400 bg-amber-300']")
	private WebElement  yellowdotbesidemasteritemname;
	
	public WebElement getYellowDotBesideMasterItemName() {
		return yellowdotbesidemasteritemname;
	}
	
	@FindBy(xpath = "//span[text()='Copy All From Template']")
	private WebElement  copyallfromtemplatebutton;
	
	
	public WebElement getCopyAllFromTemplateButton() {
		return copyallfromtemplatebutton;
	}
	
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement>  optionsfromselectedtempdropdown;
	
	
	public List<WebElement> getOptionsFromSelectedTempDropdown() {
		return optionsfromselectedtempdropdown;
	}
	
	@FindBy(xpath = "//span[@class='mt-0.5 inline-flex h-3.5 w-3.5 flex-none rounded-full border border-emerald-600 bg-emerald-500']")
	private WebElement  greendotbesidemasteritemname;
	
	public WebElement getGreenDotBesideMasterItemName() {
		return greendotbesidemasteritemname;
	}
	
	@FindBy(xpath = "//button[text()='Yes, Copy All']")
	private WebElement  yescopyallbutton;
	
	public WebElement getYesCopyAllButton() {
		return yescopyallbutton;
	}
	
	@FindBy(xpath = "//span[text()='Include']/..")
	private WebElement  includeflatmonthlycoulmn;
	
	
	public WebElement getIncludeFlatMonthlyColumn() {
		return includeflatmonthlycoulmn;
	}
	
	@FindBy(xpath = "//div[contains(@class,'group') and contains(@class,'items-stretch')]/div[5]//div[@role='checkbox']")
	private List<WebElement>  includeflatmonthlycheckboxes;
	
	
	public List<WebElement> getIncludeFlatMonthlyCheckboxes() {
		return includeflatmonthlycheckboxes;
	}
	
	@FindBy(xpath = "//button[text()='Flat Monthly']")
	private WebElement  flatmonthlybutton;
	
	public WebElement getFlatMonthlyButton() {
		return flatmonthlybutton;
	}
	
	@FindBy(xpath = "//input[@type='number']")
	private WebElement  flatmonthlyinputfield;
	
	public WebElement getFlatMonthlyInputField() {
		return flatmonthlyinputfield;
	}
	
	@FindBy(xpath = "//button[text()='Change To Flat Monthly Billing']")
	private WebElement  changetoflatmonthlybillingbutton;
	
	public WebElement getChangeToFlatMonthlyBillingButton() {
		return changetoflatmonthlybillingbutton;
	}
	
	
	@FindBy(xpath = "//button[text()='Yes Change Billing Type']")
	private WebElement  yeschangebillingtypebuttonfromconfirmationpopup;
	
	public WebElement getYesChangeBillingTypeButtonFromConfirmationPopup() {
		return yeschangebillingtypebuttonfromconfirmationpopup;
	}
	
	@FindBy(xpath = "//button[text()='Services']")
	private WebElement  servicesbutton;
	
	public WebElement getServicesButton() {
		return servicesbutton;
	}
	
	
	@FindBy(xpath = "//button[text()='Remove From Flat Monthly Charge']")
	private WebElement  removefromflatmonthlychargebutton;
	
	public WebElement getRemoveFromFlatMonthlyChargeButton() {
		return removefromflatmonthlychargebutton;
	}
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement  confirmbutton;
	
	public WebElement getConfirmButton() {
		return confirmbutton;
	}

}
