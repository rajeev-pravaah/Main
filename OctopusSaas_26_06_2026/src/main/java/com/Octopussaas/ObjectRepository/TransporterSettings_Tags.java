package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Octopussaass.WebdriverUtility.webDriverutility;

public class TransporterSettings_Tags {
	WebDriver driver;

	public TransporterSettings_Tags(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	
	@FindBy(xpath = "//a[text()='Tags']")
	private WebElement tagslink;
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement octopusicomtooltip;
	@FindBy(xpath = "//h2[text()='OCTO Info: Tags']")
	private WebElement octoinfotitle;
	@FindBy(xpath = "//button[@aria-label='Close tooltip']")
	private WebElement tooltipclosebtn;
	@FindBy(xpath = "//button[text()='System Tags']")
	private WebElement systemtagsbtn;
	@FindBy(xpath = "//span[text()='Add New Tag']")
	private WebElement addnewtagbtn;
	@FindBy(xpath = "//h2[text()='Create New Tag']")
	private WebElement createnewtagtitle;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement tagnametxtfield;
	@FindBy(xpath = "//button[text()='Create Tag']")
	private WebElement createtagbtn;
	@FindBy(xpath = "//p[text()='Tag name is required']")
	private WebElement tagnameerrormsg;
	@FindBy(xpath = "//*[contains(text(),'A tag with this name already exists')]")
	private WebElement alreadyexisttagnameerrormsg;
	
	public static final By ALREADY_EXIST_TOAST_LOCATOR = By.xpath("//*[contains(text(),'A tag with this name already exists')]");
	@FindBy(xpath = "//p[text()='Quick Select']/../descendant::button")
	private List<WebElement> colorsbox;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement thirdrdcolorbox;
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement fourthcolorbox;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelbtn;
	@FindBy(xpath = "//div[@class='truncate w-72 flex items-center gap-2']")
	private List<WebElement> createdtagnamelist;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement deleteconfirmbtn;
	@FindBy(xpath = "//button[text()='All Tags']")
	private WebElement alltagsbtn;
	@FindBy(xpath = "(//p[text()='Selected Color']/../descendant::p)[2]")
	private WebElement selectedcolorname;
	@FindBy(xpath = "//h6[text()='Generator Management']")
	private WebElement generatormanagementtitle;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchtxtfield;
	@FindBy(xpath = "//span[text()='Add Tag']")
	private WebElement addtagbtn;
	@FindBy(xpath = "//span[@class='text-sm text-gray-700 truncate']")
	private List<WebElement> tagnameintaglist;
	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement applybtn;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updatebtn;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelbtninedit;
	@FindBy(xpath = "//div[@class='flex gap-3']")
	private List<WebElement> filtertags;
	@FindBy(xpath = "//button[text()='User Tags']")
	private WebElement usertagsbtn;
	@FindBy(xpath = "//div[@class='truncate w-72 flex items-center gap-2']")
	private List<WebElement> usercreatedtagnamelist;
	@FindBy(xpath = "//button[text()='System Tags']")
	private WebElement systemtagsbtn1;
	@FindBy(xpath = "//div[@class='truncate w-72 flex items-center gap-2']")
	private List<WebElement> systemcreatedtagnamelist;
	@FindBy(xpath = "//div[@class='truncate w-72 flex items-center gap-2']")
	private List<WebElement> allcreatedtagnamelist;
	
	
	public List<WebElement> getAllcreatedtagnamelist() {
		return allcreatedtagnamelist;
	}
	public List<WebElement> getSystemcreatedtagnamelist() {
		return systemcreatedtagnamelist;
	}
	public WebElement getSystemtagsbtn1() {
		return systemtagsbtn;
	}
	public List<WebElement> getUsercreatedtagnamelist() {
		return usercreatedtagnamelist;
	}
	public WebElement getUsertagsbtn() {
		return usertagsbtn;
	}
	public List<WebElement> getFiltertags() {
		return filtertags;
	}
	public WebElement getCancelbtninedit() {
		return cancelbtninedit;
	}
	public WebElement getUpdatebtn() {
		return updatebtn;
	}
	public WebElement getApplybtn() {
		return applybtn;
	}
	public List<WebElement> getTagnameintaglist() {
		return tagnameintaglist;
	}
	public WebElement getAddtagbtn() {
		return addtagbtn;
	}
	public WebElement getSearchtxtfield() {
		return searchtxtfield;
	}
	public WebElement getGeneratormanagementtitle() {
		return generatormanagementtitle;
	}
	public WebElement getSelectedcolorname() {
		return selectedcolorname;
	}
	public WebElement getAlltagsbtn() {
		return alltagsbtn;
	}
	public WebElement getDeleteconfirmbtn() {
		return deleteconfirmbtn;
	}
	
	public List<WebElement> getCreatedtagnamelist() {
		return createdtagnamelist;
	}
	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	public WebElement getFourthcolorbox() {
		return fourthcolorbox;
	}
	public WebElement getThirdrdcolorbox() {
		return thirdrdcolorbox;
	}
	public List<WebElement> getColorsbox() {
		return colorsbox;
	}
	public WebElement getAlreadyexisttagnameerrormsg() {
		return alreadyexisttagnameerrormsg;
	}
	public WebElement getTagnameerrormsg() {
		return tagnameerrormsg;
	}
	public WebElement getCreatetagbtn() {
		return createtagbtn;
	}
	public WebElement getTagnametxtfield() {
		return tagnametxtfield;
	}
	public WebElement getCreatenewtagtitle() {
		return createnewtagtitle;
	}
	public WebElement getAddnewtagbtn() {
		return addnewtagbtn;
	}
	public WebElement getSystemtagsbtn() {
		return systemtagsbtn;
	}
	public WebElement getTooltipclosebtn() {
		return tooltipclosebtn;
	}
	public WebElement getOctoinfotitle() {
		return octoinfotitle;
	}
	public WebElement getOctopusicomtooltip() {
		return octopusicomtooltip;
	}
	
	public WebElement getTagslink() {
		return tagslink;
	}
	
	
	public void Deletetag(String tagname) throws InterruptedException
	{
		WebElement delete = driver.findElement(By.xpath("//div[text()='"+tagname+"']/../descendant::button[text()='Delete']"));
		webDriverutility wlib = new webDriverutility();
		wlib.scrollToelement(driver, delete);
		Thread.sleep(2000);
		delete.click();
		deleteconfirmbtn.click();
		Thread.sleep(5000);

		
	}

}
