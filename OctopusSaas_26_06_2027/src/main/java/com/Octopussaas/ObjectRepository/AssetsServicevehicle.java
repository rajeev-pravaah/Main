package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

public class AssetsServicevehicle {
	WebDriver driver;

	public AssetsServicevehicle(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Assets')]")
	private WebElement assets;
	@FindBy (xpath = "//h6[contains (text(),'Service Vehicles')]")
	private WebElement assetsServicevehicle;
	@FindBy (xpath = "(//div[@class='relative inline-block'])[2]")
	private WebElement servicetooltip;
	@FindBy (xpath = "//span[contains (text(),'Add New Service Vehicle')]")
	private WebElement addnewService;
	@FindBy (xpath = "//input[@placeholder='Enter Nickname']")
	private WebElement nickname;
	@FindBy (xpath = "//p[contains (text(),'Nick name is required.')]")
	private WebElement nicknameErmsg;
	@FindBy (xpath = "//button[contains (text(),'Add New Service Vehicle')]")
	private WebElement addnewServicebutton;
	@FindBy (xpath = "//button[@id='vehicle-location assignment *']")
	private WebElement vehiclelocationassignment;
	@FindBy (xpath = "(//div[contains (text(),'(Henry) Premier Med Waste Solution display')])[1]")
	private WebElement henrylocation;
	@FindBy (xpath = "(//div[contains (text(),'BioTrust Medical Disposal')])[1]")
	private WebElement biotrustmedicallocation;
	@FindBy (xpath = "//p[contains (text(),'Vehicle Location Assignment is required.')]")
	private WebElement vehiclelocationErmsg;
	@FindBy (xpath = "//button[@id='vehicle-type']")
	private WebElement vehicletype;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Box Truck')]")
	private WebElement boxtruckType;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Step Van')]")
	private WebElement stepvanType;
	@FindBy (xpath = "//button[@id='status']")
	private WebElement statusbutton;
	@FindBy (xpath = "//button[@id='viewServiceVehicleList']")
	private WebElement viewservicelist;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Active')]")
	private WebElement activestatus;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Inactive')]")
	private WebElement inactiveStatus;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Maintenance')]")
	private WebElement maintenanceStatus;
	@FindBy (xpath = "//h6[contains(text(),'Add New Service Vehicle')]/following::button[1]")
	private WebElement closeButton;
	@FindBy (xpath = "(//div[@class='relative inline-block'])[2]")
	private WebElement octoinfo;
	@FindBy (xpath = "//button[@aria-label='Close tooltip']")
	private WebElement closetooltip;
	@FindBy (xpath = "//input[@placeholder='Enter the Nickname']")
	private WebElement serviceNickname;
	@FindBy (xpath = "//input[@placeholder='Enter the Vehicle ID #']")
	private WebElement vehicleID;
	@FindBy (xpath = "//input[@placeholder='Enter the Year']")
	private WebElement year;
	@FindBy (xpath = "//input[@placeholder='Enter the Make']")
	private WebElement make;
	@FindBy (xpath = "//input[@placeholder='Enter the Model']")
	private WebElement model;
	@FindBy (xpath = "//input[@placeholder='Enter the License Plate']")
	private WebElement licenseplate;
	@FindBy (xpath = "//input[@placeholder='Enter the VIN#']")
	private WebElement vintextfield;
	@FindBy (xpath = "//button[@id='vehicle-type']")
	private WebElement serviceVehicletype;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Mobile Shred Truck')]")
	private WebElement mobileshredtrckType;
	@FindBy (xpath = "//button[@id='vehicle-class']")
	private WebElement vehicleClass;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(), 'Class 7: 26,001 to 33,000 lbs')]")
	private WebElement vehicleclassoptions;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(), 'Class 3: 10,001 to 14,000 lbs')]")
	private WebElement vehicleclass3option;
	@FindBy (xpath = "//button[@id='fuel-type']")
	private WebElement fuelType;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(), 'Electric')]")
	private WebElement electricFuel;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(), 'Diesel')]")
	private WebElement dieselFuel;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(), 'Gasoline')]")
	private WebElement gasloinFuel;
	@FindBy (xpath = "//input[@placeholder='Enter the Payload Capacity']")
	private WebElement payloadCapicty;
	@FindBy (xpath = "//button[@id='status']")
	private WebElement serviceStatus;
	@FindBy (xpath = "//button[@id='vehicle-location assignment *']")
	private WebElement serviceLocationassignment; 
	@FindBy (xpath = "(//li[@role='option']//div[contains (text(),'CleanLife Medical Waste')])[1]")
	private WebElement cleanlifemedicalLocation;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'BioTrust Medical Disposal')]")
	private WebElement servicebiotrustmedical;
	@FindBy (xpath = "//input[@placeholder='Enter the DOT#']")
	private WebElement dotField;
	@FindBy (xpath = "//input[@placeholder='Enter the Intrastate#']")
	private WebElement intrastateField;
	@FindBy (xpath = "//div[@data-testid='registration-expiration-date-picker']")
	private WebElement registrationCalendar;
	@FindBy (xpath = "(//details[@class='dropdown'])[2]")
	private WebElement registrationMonthdrp;
	@FindBy (xpath = "//div[@data-testid='insurance-expiration-date-picker']")
	private WebElement insuranceCalendar;
	@FindBy (xpath = "//textarea[@id='special-equipment']")
	private WebElement specialequipment;
	@FindBy (xpath = "//div[@data-testid='truck-cost-per-mile-input']//input")
	private WebElement truckcostField;
	@FindBy (xpath = "//textarea[@id='notes']")
	private WebElement serviceNotes;
	@FindBy (xpath = "//button[@id='save']")
	private WebElement savebutton;
	@FindBy (xpath = "//div[@data-testid='registration-copy-upload']")
	private WebElement registrationCopyfield;
	@FindBy (xpath = "//button[@class='hover:text-red-500']")
	private WebElement regidtrationDeletebutton;
	@FindBy (xpath = "//button[@class='hover:text-cardTextBlue']")
	private WebElement registrationEditbutton;
	@FindBy (xpath = "//div[@data-testid='insurance-copy-upload']")
	private WebElement insurancecopyField;
	@FindBy (xpath = "//button[@class='hover:text-red-500']")
	private WebElement insranceDeletebutton;
	@FindBy (xpath = "//button[@class='hover:text-cardTextBlue']")
	private WebElement insuranceEditbutton;
	@FindBy (xpath = "//div[@data-testid='transporter-permit-upload']")
	private WebElement transporterpermitField;
	@FindBy (xpath = "//button[@class='hover:text-red-500']")
	private WebElement transporterDeletebutton;
	@FindBy (xpath = "//button[@class='hover:text-cardTextBlue']")
	private WebElement transporterEditbutton;
	@FindBy (xpath = "//div[@data-testid='service-vehicle-status-dropdown']")
	private WebElement servicelistStatusdrp;
	@FindBy (xpath = "//input[@placeholder='Search options...']")
	private WebElement searchOption;
	@FindBy (xpath = "//div[@class='relative flex items-center gap-2 w-full']//span[contains (text(),'Active')]")
	private WebElement listedActivestatus;
	@FindBy (xpath = "//div[@class='relative flex items-center gap-2 w-full']//span[contains (text(),'Inactive')]")
	private WebElement listedInactivestatus;
	@FindBy (xpath = "//div[@class='relative flex items-center gap-2 w-full']//span[contains (text(),'Maintenance')]")
	private WebElement listedmaintenancestatus;
	@FindBy (xpath = "//button[contains (text(),'Export')]")
	private WebElement exportButton;
	@FindBy (xpath = "(//input[@type='checkbox'])[1]")
	private WebElement checkbox;
	
	
	public WebElement getCheckbox() {
		return checkbox;
	}
	public WebElement getExportButton() {
		return exportButton;
	}
	public WebElement getListedmaintenancestatus() {
		return listedmaintenancestatus;
	}
	public WebElement getListedInactivestatus() {
		return listedInactivestatus;
	}
	public WebElement getListedActivestatus() {
		return listedActivestatus;
	}
	public WebElement getSearchOption() {
		return searchOption;
	}
	public WebElement getServicelistStatusdrp() {
		return servicelistStatusdrp;
	}
	public WebElement getTransporterEditbutton() {
		return transporterEditbutton;
	}
	public WebElement getTransporterDeletebutton() {
		return transporterDeletebutton;
	}
	public WebElement getTransporterpermitField() {
		return transporterpermitField;
	}
	public WebElement getInsuranceEditbutton() {
		return insuranceEditbutton;
	}
	public WebElement getInsranceDeletebutton() {
		return insranceDeletebutton;
	}
	public WebElement getInsurancecopyField() {
		return insurancecopyField;
	}
	public WebElement getRegistrationEditbutton() {
		return registrationEditbutton;
	}
	public WebElement getRegidtrationDeletebutton() {
		return regidtrationDeletebutton;
	}
	public WebElement getRegistrationCopyfield() {
		return registrationCopyfield;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getServiceNotes() {
		return serviceNotes;
	}
	public WebElement getTruckcostField() {
		return truckcostField;
	}
	public WebElement getSpecialequipment() {
		return specialequipment;
	}
	public WebElement getInsuranceCalendar() {
		return insuranceCalendar;
	}
	public WebElement getRegistrationCalendar() {
		return registrationCalendar;
	}
	public WebElement getIntrastateField() {
		return intrastateField;
	}
	public WebElement getDotField() {
		return dotField;
	}
	public WebElement getServicebiotrustmedical() {
		return servicebiotrustmedical;
	}
	public WebElement getCleanlifemedicalLocation() {
		return cleanlifemedicalLocation;
	}
	public WebElement getServiceLocationassignment() {
		return serviceLocationassignment;
	}
	public WebElement getServiceStatus() {
		return serviceStatus;
	}
	public WebElement getPayloadCapicty() {
		return payloadCapicty;
	}
	public WebElement getGasloinFuel() {
		return gasloinFuel;
	}
	public WebElement getElectricFuel() {
		return electricFuel;
	}
	public WebElement getDieselFuel() {
		return dieselFuel;
	}

	public WebElement getFuelType() {
		return fuelType;
	}

	public WebElement getVehicleclass3option() {
		return vehicleclass3option;
	}

	public WebElement getVehicleclassoptions() {
		return vehicleclassoptions;
	}

	public WebElement getVehicleClass() {
		return vehicleClass;
	}

	public WebElement getMobileshredtrckType() {
		return mobileshredtrckType;
	}

	public WebElement getServiceVehicletype() {
		return serviceVehicletype;
	}

	public WebElement getVintextfield() {
		return vintextfield;
	}

	public WebElement getLicenseplate() {
		return licenseplate;
	}

	public WebElement getModel() {
		return model;
	}

	public WebElement getMake() {
		return make;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getVehicleID() {
		return vehicleID;
	}

	public WebElement getServiceNickname() {
		return serviceNickname;
	}

	public WebElement getClosetooltip() {
		return closetooltip;
	}

	public WebElement getOctoinfo() {
		return octoinfo;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getMaintenanceStatus() {
		return maintenanceStatus;
	}

	public WebElement getInactiveStatus() {
		return inactiveStatus;
	}

	public WebElement getActivestatus() {
		return activestatus;
	}

	public WebElement getViewservicelist() {
		return viewservicelist;
	}

	public WebElement getStatusbutton() {
		return statusbutton;
	}

	public WebElement getStepvanType() {
		return stepvanType;
	}

	public WebElement getBoxtruckType() {
		return boxtruckType;
	}

	public WebElement getVehicletype() {
		return vehicletype;
	}

	public WebElement getVehiclelocationErmsg() {
		return vehiclelocationErmsg;
	}

	public WebElement getBiotrustmedicallocation() {
		return biotrustmedicallocation;
	}

	public WebElement getHenrylocation() {
		return henrylocation;
	}

	public WebElement getVehiclelocationassignment() {
		return vehiclelocationassignment;
	}

	public WebElement getAddnewServicebutton() {
		return addnewServicebutton;
	}

	public WebElement getNicknameErmsg() {
		return nicknameErmsg;
	}

	public WebElement getNickname() {
		return nickname;
	}

	public WebElement getAddnewService() {
		return addnewService;
	}

	public WebElement getServicetooltip() {
		return servicetooltip;
	}

	public WebElement getAssetsServicevehicle() {
		return assetsServicevehicle;
	}

	public WebElement getAssets() {
		return assets;
	}
	
	public void Servicevehicle()
	{
		assets.click();
		Actions act = new Actions(driver);
		act.moveToElement(assetsServicevehicle).click().perform();
	}
	
	public void VehiclelocationwithInput()
	{
		Actions act = new Actions(driver);
		vehiclelocationassignment.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
		vehiclelocationassignment.click();

	}
	
	public void VehiclelocationwithVehicleLocations()
	{
		vehiclelocationassignment.click();
		vehiclelocationassignment.click();
		vehiclelocationassignment.click();
		WebElement day1 = driver.findElement(By.xpath("//div[contains (text(),'Main Location')]"));
	    Assert.assertTrue(day1.isDisplayed(), "Mainlocation is displayed");
	    WebElement day2 = driver.findElement(By.xpath("//div[contains (text(),'Satellite Locations')]"));
	    Assert.assertTrue(day2.isDisplayed(), "Satellite Locations is displayed");
	}
	
	public void VehicletypewithInput()
	{
		Actions act = new Actions(driver);
		vehicletype.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
		vehicletype.click();

	}
	
	public void Vehiclestatus() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(viewservicelist).click().perform();
		Thread.sleep(2000);
		Actions act1 = new Actions(driver);
		act1.moveToElement(addnewService).click().perform();
		WebElement day1 = driver.findElement(By.xpath("//button[@id='status']"));
	    Assert.assertTrue(day1.isDisplayed(), "status is displayed");
	    WebElement day2 = driver.findElement(By.xpath("//span[contains (text(),'Active')]"));
	    Assert.assertTrue(day2.isDisplayed(), "Active status is displayed");
	}
	
	public void vehiclestatuswithInput()
	{
		Actions act = new Actions(driver);
		statusbutton.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
		statusbutton.click();
	}
	public void ServicevehiclePage()
	{
		WebElement vehiclepage = driver.findElement(By.xpath("//div[@class='p-5']"));
	    Assert.assertTrue(vehiclepage.isDisplayed(), "Service vehicle page is displayed");
	}
	
	public void VehicleIDwithEdit()
	{
		Assert.assertTrue(vehicleID.isDisplayed(),
	            "Vehicle ID field is not displayed");

	    Assert.assertFalse(vehicleID.isEnabled(),
	            "Vehicle ID field is editable but should not be editable");

	    utilityclassobject.gettest().log(Status.PASS,
	            "Vehicle ID field is displayed and non-editable as expected");
	}
	
	public void ServicevehicleType()
	{
		WebElement vehicletype = driver.findElement(By.xpath("//button[@id='vehicle-type']"));
	    Assert.assertTrue(vehicletype.isDisplayed(), "Vehicle type  is displayed");
	    WebElement  vehicletype1= driver.findElement(By.xpath("//span[contains (text(),'Step Van')]"));
	    Assert.assertTrue(vehicletype1.isDisplayed(), "Added vehicle type is displayed");
	}
	
	public void VehicleclasswithInput()
	{
		Actions act = new Actions(driver);
		vehicleClass.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
		vehicleClass.click();

	}
	
	public void FueltypewithInput()
	{
		Actions act = new Actions(driver);
		fuelType.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
		fuelType.click();
	}
	
	public void ServiceStatus()
	{
		WebElement vehicletype = driver.findElement(By.xpath("//button[@id='status']"));
	    Assert.assertTrue(vehicletype.isDisplayed(), "Status  is displayed");
	    WebElement  vehicletype1= driver.findElement(By.xpath("//span[contains (text(),'Active')]"));
	    Assert.assertTrue(vehicletype1.isDisplayed(), "Status type is displayed");
	}
	
	public void ServiceLocationassignment()
	{
		WebElement vehicletype = driver.findElement(By.xpath("//button[@id='vehicle-location assignment *']"));
	    Assert.assertTrue(vehicletype.isDisplayed(), "vehicle location assignment is displayed");
	    WebElement  vehicletype1= driver.findElement(By.xpath("//span[contains (text(),'(Henry) Premier Med Waste Solution display')]"));
	    Assert.assertTrue(vehicletype1.isDisplayed(), "Location type is displayed");
	}
	
	public void ServicelocationChange() throws InterruptedException
	{
		vehiclelocationassignment.click();
		Thread.sleep(200);
		Actions act = new Actions(driver);
		act.moveToElement(cleanlifemedicalLocation).click().perform();
		vehiclelocationassignment.click();
		Thread.sleep(200);
		Actions act1 = new Actions(driver);
		act1.moveToElement(servicebiotrustmedical).click().perform();	
	}
	
	public void ServicelocationAutosave() throws InterruptedException
	{
		vehiclelocationassignment.click();
		Thread.sleep(200);
		Actions act = new Actions(driver);
		act.moveToElement(cleanlifemedicalLocation).click().perform();
		vehiclelocationassignment.click();
		Thread.sleep(200);
		Actions act1 = new Actions(driver);
		act1.moveToElement(servicebiotrustmedical).click().perform();	
		vehiclelocationassignment.click();
		Thread.sleep(200);
		Actions act2 = new Actions(driver);
		act2.moveToElement(henrylocation).click().perform();
	}
	
	public void RegistrationDatewithInput()
	{
		Actions act = new Actions(driver);
		registrationCalendar.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
		registrationCalendar.click();

	}
	
	public void RegistrationcalendarwithDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

		By calendar = By.xpath("//div[@data-testid='registration-expiration-date-picker']");

		WebElement calendarElement =
		        wait.until(ExpectedConditions.elementToBeClickable(calendar));

		calendarElement.click();

		WebElement today =
		        wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//div[contains(@class,'react-datepicker__day--today')]")));

		today.click();
	}
	
	public void InsuranceDatewithInput()
	{
		Actions act = new Actions(driver);
		insuranceCalendar.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
		insuranceCalendar.click();
	}
	
	public void InsurancecalendarwithDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

		By calendar = By.xpath("//div[@data-testid='insurance-expiration-date-picker']");

		WebElement calendarElement =
		        wait.until(ExpectedConditions.elementToBeClickable(calendar));

		calendarElement.click();

		WebElement today =
		        wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//div[contains(@class,'react-datepicker__day--today')]")));

		today.click();
	}
	
	public void TruckcostfieldwithValue()
	{
		WebElement truckcost = driver.findElement(By.xpath("//div[@data-testid='truck-cost-per-mile-input']"));
	    Assert.assertTrue(truckcost.isDisplayed(), "turck cost per mile is displayed");
	    WebElement  value = driver.findElement(By.xpath("//input[@value='2.00']"));
	    Assert.assertTrue(value.isDisplayed(), "default truck cost is  displayed");
	}
	
	public void Savebutton()
	{
		savebutton.click();
		Actions act = new Actions(driver);
		act.moveToElement(savebutton).click().perform();
	}
	
	public void CopyofRegistrationwithInput()
	{

		Actions act = new Actions(driver);
		registrationCopyfield.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
	}
	
	public void CopyofInsurancewithInput()
	{
		Actions act = new Actions(driver);
		insurancecopyField.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
	}
	
	public void CopyofTransporetpermitwithInput()
	{
		Actions act = new Actions(driver);
		transporterpermitField.click();
		act.sendKeys("hjfj874")
		   .sendKeys(Keys.ENTER)
		   .perform();
	}
	
	
}
