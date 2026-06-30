package com.Octopussaas.ObjectRepository;

import java.awt.AWTException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Octopussaass.WebdriverUtility.webDriverutility;

public class RouteAssignment {


	WebDriver driver;

	public RouteAssignment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	Actions act1;
	
	@FindBy(xpath = "//div[@class='text-sm flex gap-5 items-center']")
	private WebElement addservice;
	@FindBy(id = "route")
	private WebElement routes;
	@FindBy(xpath = "//input[@placeholder='Search options...']")
	private WebElement placeholder;
	@FindBy(xpath = "//h6[contains(text(),'Reminders/Notifications')]")
	private WebElement flex;
	@FindBy(xpath = "//div[@class='ml-auto absolute top-0 right-0']")
	private WebElement addser;
	@FindBy(xpath = "(//div[@class='flex items-center gap-2'])[8]")
	private WebElement nayanroute;
	@FindBy(xpath = "(//span[contains(text(),'Route')])[2]")
	private WebElement Routedd;
	@FindBy(xpath = "//div[contains(text(),'Nayan Route')]")
	private WebElement nayan;
	@FindBy(xpath = "(//div[@role='combobox'])[2]")
	private WebElement servicetypedd;
	@FindBy(xpath = "//button[@id='service-input-1']")
	private WebElement ServiceType2;
	public WebElement getServiceType2() {
		return ServiceType2;
	}
	@FindBy(xpath = "//li[@role='option']")
	private WebElement medicalwaste;
	@FindBy(id  = "service-frequency")
	private WebElement servicefreq;
	@FindBy(xpath = "(//button[@id='service-frequency'])[2]")
	private WebElement servicefreq2;
	public WebElement getServicefreq2() {
		return servicefreq2;
	}
	@FindBy(xpath = "//div[contains(text(),'Multiple Times Weekly (MTW)')]")
	private WebElement mutli;
	@FindBy(xpath = "//span[contains(text(),'Select Weekdays')]")
	private WebElement selectweekday;
	@FindBy(xpath = "(//input[@type='checkbox'])[4]")
	private WebElement Thusday;
	@FindBy(xpath = "(//input[@type='checkbox'])[5]")
	private WebElement Friday;
	@FindBy(xpath = "(//input[@type='checkbox'])[6]")
	private WebElement Satday;
	@FindBy(xpath = "(//input[@type='checkbox'])[7]")
	private WebElement Sunday;
	@FindBy(xpath = "//span[contains(text(),'Service Scope Of Work (SOW)')]")
	private WebElement scopeofwrk;
	@FindBy(xpath = "(//div[@class='flex items-center gap-1 overflow-x-hidden py-1 pl-2 w-full'])[4]")
	private WebElement scopeOfWork2;
	public WebElement getScopeOfWork2() {
		return scopeOfWork2;
	}
	@FindBy(xpath = "(//input[@type='checkbox'])[15]")
	private WebElement seventeengalCheck;
	@FindBy(xpath = "(//input[@type='checkbox'])[16]")
	private WebElement EighteengalCheck;
	@FindBy(xpath = "//div[@class='react-datepicker__input-container']")
	private WebElement calendar;
	@FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[2]")
	private WebElement calenderfromsubcontractor;
	@FindBy(xpath = "(//div[contains(text(),'10')])[1]")                 //remember to change date
	private WebElement todaytdate;
	@FindBy(xpath = "(//div[@class='relative w-2/3']/descendant::button[@type='button'])[1]")
	private WebElement galoneinc;
	@FindBy(xpath = "(//div[@class='relative w-2/3']/descendant::button[@type='button'])[3]")
	private WebElement galtwoinc;
	@FindBy(xpath = "//button[contains(text(),'Add to Route')]")
	private WebElement addroutebtn;
	@FindBy(xpath = "//a[contains(text(),'Price Book')]")
	private WebElement pricebook;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement togglebtn;
	@FindBy(xpath = "//h6[@title='Generator Name']")
	private WebElement generatorname;
	@FindBy(xpath = "//span[@class='text-cardTextGray']")
    private WebElement genAddress;
	@FindBy(xpath = "//h6[.//span and contains(text(),'Created Date')]/span")
	private WebElement createddate;
	@FindBy(xpath = "//button[@id='tag-add-button']")
	private WebElement addtagbtn;
	@FindBy(xpath = "//div[@id='tag-options-list']//label")
	private  WebElement taglist;
	@FindBy(xpath = "(//button[contains(text(),'Go Back to Generator Profile')])[3]")
	private WebElement GobacktorouteAssignmentpageBtn;
	@FindBy(xpath = "//div[contains(@class,'marker-container')]//*[name()='svg']")
	private WebElement starsymbol;
	@FindBy(xpath = "//p[@class='text-base font-semibold']")
	private WebElement mapGenName;
	@FindBy(xpath = "(//button[.//*[name()='svg']])[17]")
	private WebElement plusIconinMap;
	@FindBy(xpath = "(//button[.//*[name()='svg']])[18]")
	private WebElement minusicon;
	@FindBy(xpath = "//input[@placeholder='Select Subcontractor']")
	private WebElement subcontractor;
	@FindBy(xpath = "//button[@id='service-frequency']")
	private WebElement servicefrequencydd;
	@FindBy(xpath = "//span[contains(text(),'Subcontractor Service Request (SSR)')]")
	private WebElement SSRbtn;
	@FindBy(xpath = "//span[contains(text(),'Add a Service')]")
	private WebElement AddServicebtn;
	@FindBy(xpath = "//button[@id='route']")
	private WebElement Routedropdown;
	
	
	
	
	public WebElement getRoutedropdown() {
		return Routedropdown;
	}
	@FindBy(xpath = "//input[@placeholder='Search options...']")
	private WebElement routetextfield;
	@FindBy(xpath = "//li[@role='option']")
	private WebElement nayanname;
	@FindBy(xpath = "//button[@id='service-frequency']")
	private WebElement servicefrequency;
	@FindBy(xpath = "//span[contains(text(),'Scope Of Work (SOW)')]")
	private WebElement clickoutside;
	@FindBy(xpath = "//label[contains(text(),'Default Disposal Facility')]")
	private WebElement defaultdisposalFacility;
	@FindBy(xpath = "(//div[@class='relative flex items-center  my-2 '])[3]")
	private WebElement defaultdisposalDD;
	@FindBy(xpath = "//div[contains(text(),'Bio Sharps Transfer')]")
	private WebElement biosharftrans;
	@FindBy(xpath = "//button[@id='service-duration']")
	private WebElement serviceduration;
	@FindBy(xpath = "//div[contains(text(),'10 minutes')]")
	private WebElement tenmin;
	@FindBy(xpath = "(//span[contains(text(),'Scope Of Work (SOW)')])[2]")
	private WebElement scopofworkdd;
	@FindBy(xpath = "(//span[contains(text(),'Scope Of Work (SOW)')])[2]")
	private WebElement sowclick;
	@FindBy(xpath = "(//p[contains(text(),'Service Type *')])[2]")
	private WebElement serviceType22;
	
	@FindBy(xpath = "(//button[@type='button'])[28]")
	private WebElement decreasebtn;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement Requitepiccheckbox;
	@FindBy(xpath = "//button[contains(text(),'Add to Route')]")
	private WebElement AddRoutebuttn;
	@FindBy(xpath = "//label[text()='Established Date']/following::div[contains(@class,'bg-gray-100')][1]")
	private WebElement Establisdate;
	@FindBy(xpath = "//button[contains(text(),'Remove service schedule')]")
	private WebElement RemoveServiceSchedule;
	@FindBy(xpath = "//textarea[@name='cancellationNote']")
	private WebElement CancellationNotetxtarea;
	@FindBy(xpath = "//textarea[@rows='3']")
	
	private WebElement cancellationtxtarea2;
	@FindBy(xpath = "//label[contains(text(),'Require Picture')]")
	private WebElement reqout;
	public WebElement getReqout() {
		return reqout;
	}
	public WebElement getCancellationtxtarea2() {
		return cancellationtxtarea2;
	}
	@FindBy(xpath = "//button[contains(text(),'Remove Schedule')]")
	private WebElement removescheduleBtn;
	@FindBy(xpath = "//button[contains(text(),'Remove service schedule')]")
	private WebElement removeserviceschedule;
	public WebElement getRemoveserviceschedule() {
		return removeserviceschedule;
	}
	@FindBy(xpath = "(//button[contains(text(),'Remove Schedule')])[2]")
	private WebElement removeschedule2;
	public WebElement getRemoveschedule2() {
		return removeschedule2;
	}
	@FindBy(xpath = "(//button[contains(text(),'Update')])[1]")
	private WebElement Updatebtn;
	@FindBy(xpath = "//button[contains(text(),'Update Schedule')]")
	private WebElement Updateschedule;
	@FindBy(xpath = "//span[contains(text(),'Add a Service')]")
	private WebElement AddserviceBtnt;
	@FindBy(xpath = "(//button[@id='route'])[2]")
	private WebElement Routetwo;
	@FindBy (xpath = "(//button[@id='route'])[2]")
	private WebElement route2;
	@FindBy(xpath = "(//label[contains(text(),'Anchor Date')]/following::div[contains(@class,'bg-inputBg')])[4]")
	private WebElement calendar2;
	@FindBy(xpath = "(//div[@class='relative flex items-center  my-2 '])[8]")
	private WebElement disposalfacility2;
	@FindBy(xpath = "//div[@class='flex gap-2 flex-wrap']")
	private WebElement Clickout2;
	@FindBy(xpath = "(//button[contains(text(),'Remove service schedule')])[2]")
	private WebElement RemoveServiceschedule2;
	@FindBy(xpath = "//input[@id='24-hour-notice']")
	private WebElement hrCheckbox24;
	@FindBy(xpath = "//input[@id='same-day-notice']")
	private WebElement samedaycheckbox;
	@FindBy(xpath = "//h6[contains(text(),'Generator Service Instructions')]")
	private WebElement genratorServiceInstr;
	@FindBy(xpath = "//textarea[@id='delivery-note-(del)']")
	private WebElement deliveryNote;
	@FindBy(xpath = "//textarea[@id='service-instructions']")
	private WebElement ServiceInstructionTextsrea;
	@FindBy(xpath = "//textarea[@id='location-of-waste-(loc)']")
	private WebElement locationOfwaste;
	@FindBy(xpath = "//textarea[@id='access-code']")
	private WebElement accesscode;
	@FindBy(xpath = "//textarea[@id='service-instructions']")
	private WebElement serviceInst;
	@FindBy(xpath = "//span[text()='Scheduled Services: ']/ancestor::h6/descendant::span[2]")
	private WebElement ScheduleserName;
	@FindBy(xpath = "//div[@class='ml-auto']")
	private WebElement copyToclipBoard;
	@FindBy(xpath = "//div[contains(text(),'Service Type')]")
	private WebElement ServiceTypecln;
	@FindBy(xpath = "//div[contains(@class,'flex-wrap')]//div[contains(@class,'rounded-full')]//p[1]")
	private WebElement NextSicServicedate;
	@FindBy(xpath = "//span[text()='Normal Priority']/preceding::input[@type='checkbox'][1]")
	private WebElement CheckboxInScheduleservices;
	@FindBy(xpath = "//span[contains(text(),'High Priority')]")
	private WebElement HighPriority;
	@FindBy(xpath = "//div[@data-tip='Mark all as high priority.']//input[@type='checkbox']")
	private WebElement highPriorityForalll;
	@FindBy(xpath = "//div[@class='relative inline-block']")
	private WebElement backEllipse;
	@FindBy(xpath = "//button[contains(text(),'Generator Information')]")
	private WebElement GenInfoInbackEllipse;
	@FindBy(xpath = "//h6[contains(text(),'Sunday')]")
	private WebElement sundayname;
	@FindBy(xpath = "//button[@id='route']")
	private WebElement routeValue;
	@FindBy(xpath = "//input[starts-with(@id,'temporaryServiceInstruction')]")
	private WebElement tempserviceInstruction;
	@FindBy(xpath = "(//button[normalize-space()='Cancel Service'])[4]")
	private WebElement cancelServiceBtn;
	@FindBy(xpath = "//textarea[@name='cancellationNote']")
	private WebElement cancellationNote;
	@FindBy(xpath = "//button[contains(text(),'Cancel This Service')]")
	private WebElement  cancelthisserviceBtn;
	@FindBy(xpath = "//button[contains(text(),'Reinstate Service')]")
	private WebElement reinstateseervie;
	@FindBy(xpath = "//button[contains(text(),'Reinstate This Service')]")
	private WebElement reinstateThisservice;
	@FindBy(xpath = "//h6[contains(text(),'Copy Service Dates to Clipboard')]")
	private WebElement copyservicedateToclipboard;
	@FindBy(xpath = "//strong[contains(text(),'Historical Manifests Report')]")
	private WebElement historicalmanifessrep;
	@FindBy(xpath = "//h6[text()='Service Summary']")
	private WebElement ServiceSummaryBox;
	@FindBy(xpath = "//h6[contains(text(),'Delivery Summary')]")
	private WebElement deliverySummary;
	@FindBy(xpath = "//button[contains(@class,'text-primary')]")
	private WebElement servicesummarylink;
	@FindBy(xpath = "(//button[contains(@class,'text-primary')])[2]")
	private WebElement deliversummaryreciptlink;
	@FindBy(xpath = "//a[contains(@class,'text-primary')]")
	private WebElement viewImage;
	@FindBy(xpath = "//p[@class='w-full max-w-96 text-wrap ']")
	private WebElement tempServiceInstr;
	@FindBy(xpath = "//p[text()='Driver Note:']/following-sibling::p")
	private WebElement drivernote;
	@FindBy(xpath = "//p[text()='Contractor:']/following-sibling::p")
	private WebElement contractorname;
	@FindBy(xpath = "//span[contains(text(),'Subcontractor Service Request (SSR)')]")
	private WebElement SubcontractiorserviceRequest;
	@FindBy(xpath = "//input[@id='subcontractor']")
	private WebElement subcontractordd;
	@FindBy(xpath = "//span[contains(text(),'T-3')]")
	private WebElement t_3Subcontractor;
	@FindBy(xpath = "//button[text()='Send To Subcontractor']/../descendant::button")
	private WebElement canclebtninsubcontractor;
	@FindBy(xpath = "//span[contains(text(),'Service Scope Of Work (SOW) *')]")
	private WebElement SCopeOfwork2;
	@FindBy(xpath = "//textarea[@id='shared-service-note']")
	private WebElement sharedserviceNoteinsubcontractor;
	@FindBy(xpath = "//span[contains(text(),'Service Type')]")
	private WebElement servcetypeinSSR;
	@FindBy(xpath = "(//button[@id='service-duration'])[2]")
	private WebElement servicedurationinSSR;
	@FindBy(xpath = "//button[contains(text(),'Send To Subcontractor')]")
	private WebElement sendtosubcontractor;
	@FindBy(xpath = "//span[contains(text(),'Service Scope Of Work (SOW)')]/ancestor::div[contains(@class,'overflow-hidden')]")
	private WebElement scopeofworkInSSR;
	@FindBy(xpath = "(//div[contains(@class,'overflow-x-auto')])[2]")
	private WebElement scrolltoSubcontractor;
	@FindBy(xpath = "//p[contains(text(),'Contractor:')]/following-sibling::p")
	private WebElement contractornamefromserviceHistoryReport;
	@FindBy(xpath = "//button[normalize-space()='Reassign']/preceding-sibling::button")
	private WebElement cancelSSR;
	@FindBy(xpath = "(//textarea[@rows='3'])[2]")
	private WebElement cancelSSrNOTe;
	@FindBy(xpath = "//button[contains(text(),'Cancel  Request')]")
	private WebElement cancelRequestBtn;
	@FindBy(xpath = "//h6[@title='Operations' or text()='Operations']")
	private WebElement operations;
	@FindBy(xpath = "//h6[text()='Route Optimization']")
	private WebElement routeoptimization;
	@FindBy(xpath = "//div[contains(text(),'Date')]")
	private WebElement dateclcikoutside;
	@FindBy(xpath = "//textarea[@id='parking-note-(prk)']")
	private WebElement parkingNote;
	@FindBy(xpath = "//span[text()='DEL: ']/..")
	private WebElement DElinRouteoptimization;
	@FindBy(xpath = "//span[text()='PRK: ']/..")
	private WebElement prkinRouteOptimization;
	@FindBy (xpath = "//span[text()='Code: ']/..")
	private WebElement AccessCodeInRouteOptimization;
	@FindBy(xpath = "//span[text()='Service Notes: ']/..")
	private WebElement ServiceNoteInRoueoptimization;
	@FindBy(xpath = "//button[contains(text(),'Cancel Service')]")
	private WebElement cancelServiceInRouteOptimization;
	@FindBy(xpath = "//textarea[@name='cancellationNote']")
	private WebElement cancellationNoteInRouteopt;
	@FindBy(xpath = "//button[text()='Yes, Cancel This Service']")
	private WebElement cancelbtnServiceinRoteoptimization;
	@FindBy(xpath = "//div[text()='Pending']")
	private WebElement servicestatusinSSR;
	@FindBy(xpath = "//h6[contains(text(),'Billing')]")
	private WebElement biiling;
	@FindBy(xpath = "//h6[contains(text(),'Master Price Books')]")
	private WebElement masterpricebook;
	@FindBy(xpath = "//a[contains(text(),'View Price Book')]")
	private WebElement viewpricebook;
	@FindBy(xpath = "//span[contains(@class,'truncate') and text()='Medical Waste']")
	private WebElement servicetxt;
	@FindBy(xpath = "//button[text()='Send To Subcontractor']/../descendant::button")
	private WebElement cancelbuttoninSSRbesideSendtosubcontractor;
	@FindBy(xpath = "(//button[text()='Go Back to Generator Profile'])[3]")
	private WebElement gobacktorouteassignmentpage;
	@FindBy(xpath = "(//h3[text()='Generator Profile Not Setup'])[2]")
	private WebElement generatorprofilenotsetuppopup;
	@FindBy(xpath = "//a[text()='Generator Information']")
	private WebElement GeneratorInformationtab;
	@FindBy(xpath = "//div[@class='flex items-center gap-2 flex-1 min-w-0']")
	private List<WebElement> Addtagslists;
	@FindBy(xpath = ".//input[@type='checkbox']")
	private WebElement checkboxforalladdtsglists;
	
	
	
	
	
	
	
	public WebElement getCheckboxforalladdtsglists() {
		return checkboxforalladdtsglists;
	}
	public List<WebElement> getAddTagsLists() {
		return Addtagslists;
	}
	public WebElement getGeneratorInformationtab() {
		return GeneratorInformationtab;
	}
	public WebElement getGeneratorprofilenotsetuppopup() {
		return generatorprofilenotsetuppopup;
	}
	public WebElement getGobacktorouteassignmentpage() {
		return gobacktorouteassignmentpage;
	}
	public WebElement getCancelbuttoninSSRbesideSendtosubcontractor() {
		return cancelbuttoninSSRbesideSendtosubcontractor;
	}
	public WebElement getServicetxt() {
		return servicetxt;
	}
	
	public WebElement getViewpricebook() {
		return viewpricebook;
	}
	public WebElement getMasterpricebook() {
		return masterpricebook;
	}
	public WebElement getBiiling() {
		return biiling;
	}
	public WebElement getServicestatusinSSR() {
		return servicestatusinSSR;
	}
	public WebElement getCancelbtnServiceinRoteoptimization() {
		return cancelbtnServiceinRoteoptimization;
	}
	public WebElement getCancellationNoteInRouteopt() {
		return cancellationNoteInRouteopt;
	}
	public WebElement getCancelServiceInRouteOptimization() {
		return cancelServiceInRouteOptimization;
	}
	public WebElement getAccessCodeInRouteOptimization() {
		return AccessCodeInRouteOptimization;
	}
	public WebElement getServiceNoteInRoueoptimization() {
		return ServiceNoteInRoueoptimization;
	}
	public WebElement getAccessCode() {
		return AccessCodeInRouteOptimization;
	}
	public WebElement getPrkinRouteOptimization() {
		return prkinRouteOptimization;
	}
	public WebElement getDElinRouteoptimization() {
		return DElinRouteoptimization;
	}
	public WebElement getParkingNote() {
		return parkingNote;
	}
	public WebElement getDateclcikoutside() {
		return dateclcikoutside;
	}
	public WebElement getRouteoptimization() {
		return routeoptimization;
	}
	public WebElement getOperations() {
		return operations;
	}
	public WebElement getCancelRequestBtn() {
		return cancelRequestBtn;
	}
	public WebElement getCancelSSrNOTe() {
		return cancelSSrNOTe;
	}
	public WebElement getCancelSSR() {
		return cancelSSR;
	}
	public WebElement getContractornamefromserviceHistoryReport() {
		return contractornamefromserviceHistoryReport;
	}
	public WebElement getScrolltoSubcontractor() {
		return scrolltoSubcontractor;
	}
	public WebElement getScopeofworkInSSR() {
		return scopeofworkInSSR;
	}
	public WebElement getSendtosubcontractor() {
		return sendtosubcontractor;
	}
	public WebElement getFifteenminInSSR() {
		return fifteenminInSSR;
	}
	@FindBy(xpath = "//div[contains(text(),'15 minutes')]")
	private WebElement fifteenminInSSR;
	
	
	public WebElement getServicedurationinSSR() {
		return servicedurationinSSR;
	}
	public WebElement getServcetypeinSSR() {
		return servcetypeinSSR;
	}
	public WebElement getSharedserviceNoteinsubcontractor() {
		return sharedserviceNoteinsubcontractor;
	}
	public WebElement getCalenderfromsubcontractor() {
		return calenderfromsubcontractor;
	}
	public WebElement getSCopeOfwork2() {
		return SCopeOfwork2;
	}
	public WebElement getCanclebtninsubcontractor() {
		return canclebtninsubcontractor;
	}
	public WebElement getT_3Subcontractor() {
		return t_3Subcontractor;
	}
	public WebElement getSubcontractordd() {
		return subcontractordd;
	}
	public WebElement getSubcontractiorserviceRequest() {
		return SubcontractiorserviceRequest;
	}
	public WebElement getDrivernote() {
		return drivernote;
	}
	public WebElement getTempServiceInstr() {
		return tempServiceInstr;
	}
	public WebElement getViewImage() {
		return viewImage;
	}
	public WebElement getDeliversummaryreciptlink() {
		return deliversummaryreciptlink;
	}
	public WebElement getContractorname() {
		return contractorname;
	}
	public WebElement getServicesummarylink() {
		return servicesummarylink;
	}
	public WebElement getDeliverySummary() {
		return deliverySummary;
	}
	public WebElement getServiceSummaryBox() {
		return ServiceSummaryBox;
	}
	public WebElement getHistoricalmanifessrep() {
		return historicalmanifessrep;
	}
	public WebElement getCopyservicedateToclipboard() {
		return copyservicedateToclipboard;
	}
	public WebElement getReinstateThisservice() {
		return reinstateThisservice;
	}
	public WebElement getReinstateseervie() {
		return reinstateseervie;
	}
	public WebElement getCancelthisservice() {
		return cancelthisserviceBtn;
	}
	public WebElement getCancellationNote() {
		return cancellationNote;
	}
	public WebElement getCancelService() {
		return cancelServiceBtn;
	}
	public WebElement getTempserviceInstruction() {
		return tempserviceInstruction;
	}
	public WebElement getRouteValue() {
		return routeValue;
	}
	public WebElement getSundayname() {
		return sundayname;
	}
	public WebElement getGenInfoInbackEllipse() {
		return GenInfoInbackEllipse;
	}
	public WebElement getBackEllipse() {
		return backEllipse;
	}
	public WebElement getHighPriorityForalll() {
		return highPriorityForalll;
	}
	public WebElement getHighPriority() {
		return HighPriority;
	}
	public WebElement getCheckboxInScheduleservices() {
		return CheckboxInScheduleservices;
	}
	public WebElement getNextSicServicedate() {
		return NextSicServicedate;
	}
	public WebElement getServiceTypecln() {
		return ServiceTypecln;
	}
	public WebElement getCopyToclipBoard() {
		return copyToclipBoard;
	}
	public WebElement getScheduleserName() {
		return ScheduleserName;
	}
	public WebElement getServiceInst() {
		return serviceInst;
	}
	public WebElement getAccesscode() {
		return accesscode;
	}
	public WebElement getLocationOfwaste() {
		return locationOfwaste;
	}
	public WebElement getServiceInstructionTextsrea() {
		return ServiceInstructionTextsrea;
	}
	public WebElement getDeliveryNote() {
		return deliveryNote;
	}
	public WebElement getSamedaycheckbox() {
		return samedaycheckbox;
	}
	public WebElement getGenratorServiceInstr() {
		return genratorServiceInstr;
	}
	public WebElement getHrCheckbox24() {
		return hrCheckbox24;
	}
	public WebElement getRemoveServiceschedule2() {
		return RemoveServiceschedule2;
	}
	public WebElement getClickout2() {
		return Clickout2;
	}
	public WebElement getDisposalfacility2() {
		return disposalfacility2;
	}
	public WebElement getCalendar2() {
		return calendar2;
	}
	public WebElement getServiceType22() {
		return serviceType22;
	}
	public WebElement getRoute2() {
		return route2;
	}
	public WebElement getRoutetwo() {
		return Routetwo;
	}
	public WebElement getAddserviceBtnt() {
		return AddserviceBtnt;
	}
	public WebElement getUpdateschedule() {
		return Updateschedule;
	}
	public WebElement getUpdatebtn() {
		return Updatebtn;
	}
	public WebElement getRemovescheduleBtn() {
		return removescheduleBtn;
	}
	public WebElement getCancellationNotetxtarea() {
		return CancellationNotetxtarea;
	}
	public WebElement getRemoveServiceSchedule() {
		return RemoveServiceSchedule;
	}
	public WebElement getEstablisdate() {
		return Establisdate;
	}
	public WebElement getAddRoutebuttn() {
		return AddRoutebuttn;
	}
	public WebElement getRequitepiccheckbox() {
		return Requitepiccheckbox;
	}
	public WebElement getDecreasebtn() {
		return decreasebtn;
	}
	public WebElement getSowclick() {
		return sowclick;
	}
	public WebElement getScopofworkdd() {
		return scopofworkdd;
	}
	public WebElement getTenmin() {
		return tenmin;
	}
	public WebElement getServiceduration() {
		return serviceduration;
	}
	public WebElement getBiosharftrans() {
		return biosharftrans;
	}
	public WebElement getDefaultdisposalDD() {
		return defaultdisposalDD;
	}
	public WebElement getDefaultdisposalFacility() {
		return defaultdisposalFacility;
	}
	public WebElement getClickoutside() {
		return clickoutside;
	}
	public WebElement getServicefrequency() {
		return servicefrequency;
	}
	public WebElement getNayanname() {
		return nayanname;
	}
	public WebElement getRoutetextfield() {
		return routetextfield;
	}
	public WebElement getRoutes() {
		return routes;
	}
	public WebElement getAddServicebtn() {
		return AddServicebtn;
	}
	public WebElement getServicefrequencydd() {
		return servicefrequencydd;
	}
	public WebElement getSubcontractor() {
		return subcontractor;
	}
	public WebElement getMinusicon() {
		return minusicon;
	}

	
	
	
	public WebElement getSSRbtn() {
		return SSRbtn;
	}
	public WebElement getPlusIconinMap() {
		return plusIconinMap;
	}
	public WebElement getMapGenName() {
		return mapGenName;
	}
	public WebElement getStarsymbol() {
		return starsymbol;
	}
	public WebElement getGobacktorouteAssignmentpageBtn() {
		return GobacktorouteAssignmentpageBtn;
	}
	public WebElement getTaglist() {
		return taglist;
	}
	public WebElement getAddtagbtn() {
		return addtagbtn;
	}
	public WebElement getCreateddate() {
		return createddate;
	}
	public WebElement getGenAddress() {
		return genAddress;
	}
	public WebElement getGeneratorname() {
		return generatorname;
	}
	public WebElement getTogglebtn() {
		return togglebtn;
	}
	public WebElement getPricebook() {
		return pricebook;
	}
	public WebElement getAddroutebtn() {
		return addroutebtn;
	}
	public WebElement getGaloneinc() {
		return galoneinc;
	}
	public WebElement getGaltwoinc() {
		return galtwoinc;
	}
	public WebElement getTodaytdate() {
		return todaytdate;
	}
	public WebElement getCalendar() {
		return calendar;
	}
	public WebElement getSeventeengalCheck() {
		return seventeengalCheck;
	}
	public WebElement getEighteengalCheck() {
		return EighteengalCheck;
	}
	public WebElement getScopeofwrk() {
		return scopeofwrk;
	}
	public WebElement getFriday() {
		return Friday;
	}
	public WebElement getSatday() {
		return Satday;
	}
	public WebElement getSunday() {
		return Sunday;
	}
	public WebElement getThusday() {
		return Thusday;
	}
	public WebElement getSelectweekday() {
		return selectweekday;
	}
	public WebElement getMutli() {
		return mutli;
	}
	public WebElement getServicefreq() {
		return servicefreq;
	}
	public WebElement getMedicalwaste() {
		return medicalwaste;
	}
	public WebElement getServicetypedd() {
		return servicetypedd;
	}
	public WebElement getNayan() {
		return nayan;
	}
	public WebElement getRoutedd() {
		return Routedd;
	}
	public WebElement getNayanroute() {
		return nayanroute;
	}
	public WebElement getAddser() {
		return addser;
	}
	public WebElement getFlex() {
		return flex;
	}
	public WebElement getPlaceholder() {
		return placeholder;
	}
	public WebElement getRoute() {
		return routes;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getAddservice() {
		return addservice;
	}
	public void AddService() throws InterruptedException
	{
		
		Actions act = new Actions(driver);
		act.scrollToElement(flex).perform();
		Thread.sleep(10000);

		addser.click();
	
		
	}
	public void Route1() throws AWTException, InterruptedException
	{
		Actions act1 = new Actions(driver);
	
		Routedd.click();
		act1.moveToElement(placeholder).sendKeys("Nayan Route").perform();
		act1.moveToElement(nayan).click().perform();
		
	}
	public void Route2()
	{
		Actions act1 = new Actions(driver);
		
		route2.click();
		act1.moveToElement(placeholder).sendKeys("Nayan Route").perform();
		act1.moveToElement(nayan).click().perform();
	}
	public void ServiceType() throws InterruptedException
	{
		//Actions act1 = new Actions(driver);
		Thread.sleep(2000);
		servicetypedd.click();
		
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(medicalwaste).click().perform();

	}
	public void ServiceType2()
	{
		ServiceType2.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(medicalwaste).click().perform();

	}
	public void ServiceFrequency() throws InterruptedException
	{
		servicefreq.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(mutli).click().perform();
		Thread.sleep(2000);

	}
	public void Servicefreq2() throws InterruptedException
	{
		servicefreq2.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(mutli).click().perform();
		Thread.sleep(2000);
	}
	public void SelectWeekDay()
	{
		selectweekday.click();
		Thusday.click();
		Friday.click();
		Satday.click();
		Sunday.click();
	}
	public void selectweekday2()
	{
		selectweekday.click();
		Thusday.click();
		Friday.click();
		Satday.click();
		Sunday.click();
		SCopeOfwork2.click();
	
	}
	public void ScopeOfWork() throws InterruptedException
	{
		Thread.sleep(2000);
		scopeofwrk.click();
		Thread.sleep(2000);
		Actions act1 = new Actions(driver);
		act1.moveToElement(seventeengalCheck).perform();
		seventeengalCheck.click();
		act1.moveToElement(EighteengalCheck).perform();
		EighteengalCheck.click();
		webDriverutility wlib = new webDriverutility();
		wlib.mousemoveonElement(driver, reqout);
		reqout.click();
		//sowclick.click();
		
	}
	public void ScopeOfWork2() throws InterruptedException
	{
		
		scopeOfWork2.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(seventeengalCheck).click().perform();
		Clickout2.click();
	}
	public void AnchorDate() 
	{
		getCalendar().click();

	    LocalDate today = LocalDate.now();
	    String day = String.valueOf(today.getDayOfMonth());

	    driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
		
	}
	public void RequestStartDate()
	{
		calenderfromsubcontractor.click();
	    LocalDate today = LocalDate.now();

	    String day = String.valueOf(today.getDayOfMonth());

	    driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
	}
	public void Anchordate2()
	{
		calendar2.click();
		 LocalDate today = LocalDate.now();
		    String day = String.valueOf(today.getDayOfMonth());

		    driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
	}
	
	public void defaultdisposaldd()
	{
		defaultdisposalDD.click();
		Actions act5 = new Actions(driver);
		act5.moveToElement(biosharftrans).click().perform();
		//biosharftrans.click();
	}
	public void disposalfacility2()
	{
		disposalfacility2.click();
		Actions act5 = new Actions(driver);
		act5.moveToElement(biosharftrans).click().perform();
	}
	public void IncreaseGalone()
	{
		galoneinc.click();
		galoneinc.click();
		galoneinc.click();
	}
	public void IncreaseGaltwo()
	{
		galtwoinc.click();
		galtwoinc.click();
		galtwoinc.click();
	}
	public void decreasesevGalBioone()
	{
		decreasebtn.click();
		decreasebtn.click();
	}
	public void AddRoute() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions act1 = new Actions(driver);
         act1.scrollToElement(addroutebtn).perform();
		addroutebtn.click();
	}
	
	public void CopyToclipBoard()
	{
		Actions act1 = new Actions(driver);
       act1.moveToElement(copyToclipBoard).perform();
	}
	public void MoveToServiceTypecolumn()
	{
	   	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", ServiceTypecln);
	}
	public void PriceBook()
	{
		pricebook.click();
	}
	public void ViewModeToggleBtn()
	{
		togglebtn.click();
	
	}
	public String GeneratorName()
	{
		String txt = generatorname.getText();
		return txt;
	}
	public void NayanRoute()
	{
		Routedropdown.click();
		routetextfield.sendKeys("Nayan Route");
		webDriverutility wlib = new webDriverutility();
		wlib.mousemoveonElement(driver, nayanname);
		nayanname.click();
		
		
		}
	public void ServiceDuration()
	{
		serviceduration.click();
		tenmin.click();
	
	}
	public void ScopeOfworko()
	{
		scopofworkdd.click();
	}
	public void CancellationNOTe()
	{
	
		CancellationNotetxtarea.sendKeys("delete this ");
		removescheduleBtn.click();
	}
	public void CancellationNOTe2()
	{
	
		cancellationtxtarea2.sendKeys("delete this ");
		removeschedule2.click();
	}
	public void AddserviceSecondBtn()
	{
		Actions act = new Actions(driver);
		act.scrollToElement(AddserviceBtnt).perform();
		AddserviceBtnt.click();
	}
   public void DeliveryNOte(String DelNote)
   {
	   deliveryNote.sendKeys(DelNote);
   }
   public void ServiceInstructionTextReaFlield(String InstructionNote)
   {
	   ServiceInstructionTextsrea.click();
	   ServiceInstructionTextsrea.sendKeys(Keys.CONTROL + "a");
	   ServiceInstructionTextsrea.sendKeys(Keys.DELETE);
	   ServiceInstructionTextsrea.sendKeys(InstructionNote);

   }
   public void LocationTextareaField(String LOC)
   {
	   locationOfwaste.click();
	   locationOfwaste.sendKeys(Keys.CONTROL + "a");
	   locationOfwaste.sendKeys(Keys.DELETE);
	   locationOfwaste.sendKeys(LOC);
   }
   public void AccessCode(String access)
   {
	   accesscode.sendKeys(access);
   }
   public void ServiceInstruction(String Serviceinput)
   {
	 serviceInst.sendKeys(Serviceinput);
   }
   public String ServiceSchedulName()
   {
	   String name = ScheduleserName.getText();
	   return name;
   }
   public void RemoveServiceSchedule()
   {
	   Actions atc = new Actions(driver);
	   atc.moveToElement(removeserviceschedule).perform();
	    removeserviceschedule.click();
	    driver.findElement(By.xpath("//div[contains(@class,'modal-box')]//textarea")).sendKeys("delete");
	    driver.findElement(By.xpath("//button[contains(text(),'Remove Schedule')]")).click();
   }
   public void MoveTogeneratorInfo()
   {
	   backEllipse.click();
	   GenInfoInbackEllipse.click();
   }
   public void MoveTosundsay()
   {
	   Actions act = new Actions(driver);
	   act.moveToElement(sundayname).perform();;
   }
   public void TempuraryServiceInstruction(String Instruction)
   {
	   tempserviceInstruction.sendKeys(Instruction);
   }
   public void MovetoCancelService()
   {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView(true);", cancelServiceBtn);
   }
   public void CancelServiceBTn()
   {
	   Actions act = new Actions(driver);
	   act.scrollToElement(cancelServiceBtn).perform();
	   cancelServiceBtn.click();
	   cancellationNote.sendKeys("cancel this service");
	   cancelthisserviceBtn.click();
	   
	   
   }
   public void HistoricalmaniFesReport()
   {
	   Actions act = new Actions(driver);
	   act.moveToElement(historicalmanifessrep).perform();
   }
   public void Viewimage() throws InterruptedException
   {
	   viewImage.click();

       Thread.sleep(5000);     // Store main tab
       String mainTab = driver.getWindowHandle();

       // Switch to new tab
       for (String tab : driver.getWindowHandles()) {
           if (!tab.equals(mainTab)) {
               driver.switchTo().window(tab);
               driver.close();   // closes PDF tab
               Thread.sleep(2000);
           }
       }

       // Switch back to OctopusSaaS tab
       driver.switchTo().window(mainTab);
   }
   public String TempuraryServiceInstruction()
   {
	   String tempserInst = tempServiceInstr.getText();
	   return tempserInst;
   }
   
   public String DriverNote()
   {
	   String drinote = drivernote.getText();
	   return drinote;
   }
   public String ContractorName()
   {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView(true);", contractorname);
	   String cname = contractorname.getText();
	   return cname;
   }
   public void SubcontractorDropdown() throws InterruptedException
   {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dropdown = subcontractordd;

		for (int i = 0; i < 5; i++) {
		    dropdown.click();

		    try {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//span[contains(text(),'T-3')]")
		        ));
		        break; // stop loop once option appears
		    } catch (Exception e) {
		        Thread.sleep(500); // retry clicking
		    }
		}
	
   }
   public void SharedServiceNote(String Note)
   {
	   sharedserviceNoteinsubcontractor.sendKeys(Note);
   }
   public void ServiceTypeInSSR()
	{
		servcetypeinSSR.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(medicalwaste).click().perform();

	}
   public void ServiceDurationInSSR()
   {
	   servicedurationinSSR.click();
	   fifteenminInSSR.click();
   }
	public void ScopeOfWorkInSSR() throws InterruptedException
	{
		Thread.sleep(2000);
		scopeofworkInSSR.click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//li[contains(.,'17 Gallon Regulated Medical Waste Container')]//input[@type='checkbox']"));
		
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(ele).perform();
		ele.click();
		//reqout.click();
		//sowclick.click();
		
	}
	public String PrintContractorName()
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 500;", scrolltoSubcontractor);
		
		String contractornam = contractornamefromserviceHistoryReport.getText();
		return contractornam;
	}
	public String printSubcontractorName()
	{
		WebElement subcontractor = driver.findElement(
		        By.xpath("//p[contains(text(),'Subcontractor:')]/following-sibling::p")
		);
		String subcon = subcontractor.getText();
		return subcon;
		
	}
	public void CnacelSSR1()
	{
		cancelSSR.click();
		cancelSSrNOTe.sendKeys("Cancel SSR ");
		cancelRequestBtn.click();
	}
   
   public void CancelServiceInRouteOptimization()
   {
	   cancelServiceInRouteOptimization.click();
	   cancellationNoteInRouteopt.sendKeys("cancel the services");
	   cancelbtnServiceinRoteoptimization.click();
   }
   public void MasterPricebook()
   {
	   biiling.click();
	   masterpricebook.click();
	   viewpricebook.click();
   }
   
	}
