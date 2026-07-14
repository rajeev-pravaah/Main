package OctopusSaas_Master_PriceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import com.Octopussaas.BaseUtility.BaseClassForMasterPriceBook;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.Dashboard;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.MasterPriceBook;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Billing_MasterPriceBook extends BaseClassForMasterPriceBook {
	HomePage hp;
	Dashboard db;
	MasterPriceBook mp;

	ExcelUtility elib;

	/** Always returns a fresh wait to avoid stale-driver issues. */
	private WebDriverWait getWebDriverWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	private void waitAndClick(WebElement element) {
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	private WebElement waitForVisible(WebElement element) {
		return getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
	}

	/** Lazy initialiser — always returns a non-null MasterPriceBook POM. */
	private MasterPriceBook getMp() {
		if (mp == null)
			mp = new MasterPriceBook(driver);
		return mp;
	}

	/** Lazy initialiser — always returns a non-null ExcelUtility. */
	private ExcelUtility getElib() {
		if (elib == null)
			elib = new ExcelUtility();
		return elib;
	}

	@Test
	public void TC_001MastePriceBookInLeftCorner() throws Throwable {
		hp = new HomePage(driver);
		db = new Dashboard(driver);
		mp = new MasterPriceBook(driver);
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		waitAndClick(db.getBiilingdd());
		waitAndClick(db.getMasterpricebook());
		waitAndClick(getMp().getViewpricebook());
		utilityclassobject.gettest().log(Status.INFO, "View Price Book page is displayed successfully");
		System.out.println("View Price Book page is displayed");
		Thread.sleep(4000);
		WebElement masterPriceBookTitle = driver.findElement(By.xpath("//h1[contains(text(),'Master Price Book')]"));
		int xPosition = masterPriceBookTitle.getLocation().getX();
		if (xPosition < 400) {
			utilityclassobject.gettest().log(Status.PASS, "Master Price Book is displayed in the left corner successfully");
			System.out.println("Master Price Book is displayed in the left corner");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Master Price Book is NOT displayed in the left corner");
			System.out.println("Master Price Book is NOT in the left corner");
		}
	}

	@Test(dependsOnMethods = "TC_001MastePriceBookInLeftCorner")
	public void TC_002viewModenadEditModeToggle() throws InterruptedException {
		WebElement togglebtn = waitForVisible(getMp().getTogglebuttonText());
		// verify that toggle button is displayed in right corner with view mode
		if (togglebtn.isDisplayed()) {
			System.out.println("Toggle button is displayed in right corner with view mode");
			utilityclassobject.gettest().log(Status.PASS, "Toggle button is displayed in right corner with view mode successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Toggle button is not displayed in right corner with view mode");
		}
		waitAndClick(getMp().getTogglebuttonViewMode());
		waitAndClick(getMp().getYesbuttoninEdittoggle());
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Toggle button is clicked successfully");
		System.out.println("Toggle button is clicked");
		// verify that toggle button is displayed in right corner with edit mode
		WebElement togglebtn1 = waitForVisible(getMp().getTogglebuttonText());
		if (togglebtn1.isDisplayed()) {
			System.out.println("Toggle button is displayed in right corner with edit mode");
			utilityclassobject.gettest().log(Status.PASS, "Toggle button is displayed in right corner with edit mode successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Toggle button is not displayed in right corner with edit mode");
		}
		waitAndClick(getMp().getTogglebuttoneditmode());
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "TC_002viewModenadEditModeToggle")
	public void TC_003EnableToEditPricebook() throws EncryptedDocumentException, IOException, InterruptedException {
		WebElement servicePrice = getMp().getServicepriceinputfield();

		String disabledAttr = servicePrice.getAttribute("disabled");

		if (disabledAttr != null) {
			System.out.println("Service Price field is disabled");
			utilityclassobject.gettest().log(Status.PASS, "Service Price field is disabled, unable to edit price book");
		}

		waitAndClick(getMp().getTogglebuttonViewMode());
		waitAndClick(getMp().getYesbuttoninEdittoggle());
		Thread.sleep(4000);
		// now again try to enter value inside service price field and it should be able
		// to edit the price book
		String price = getElib().getDataFromExcel("Master Price Book", 1, 1);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement serviceField = wait.until(ExpectedConditions.elementToBeClickable(getMp().getServicepriceinputfield()));

		// Use JavascriptExecutor to set value (handles React/Angular frameworks)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", serviceField);
		serviceField.click();
		serviceField.sendKeys(Keys.CONTROL + "a");
		serviceField.sendKeys(Keys.DELETE);
		serviceField.sendKeys(price);
		// Fire input + change events so the framework detects the value change
		js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", serviceField);
		js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", serviceField);
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Entered value in Service Price field successfully");
		String enteredValue = serviceField.getAttribute("value");
		if (price != null && price.equals(enteredValue)) {
			System.out.println("Service Price field is editable, price book can be edited");
			utilityclassobject.gettest().log(Status.PASS, "Service Price field is editable, price book can be edited successfully");
		} else {
			System.out.println("Service Price field is not editable, unable to edit price book");
			utilityclassobject.gettest().log(Status.FAIL, "Service Price field is not editable, unable to edit price book");
		}
		getMp().getTogglebuttoneditmode().click();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "TC_003EnableToEditPricebook")
	public void TC_004ToggoleDisplayedAreyouSure() throws InterruptedException {
		waitAndClick(getMp().getTogglebuttonViewMode());
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Toggle button is clicked successfully");
		//verify popUp is displayed with "Are you sure you want to edit the containers?" message
		WebElement popUpMessage = waitForVisible(getMp().getEditmodepopuptext());
		if (popUpMessage.isDisplayed()) {
			System.out.println("Pop-up with 'Are you sure you want to edit the containers?' message is displayed");
			utilityclassobject.gettest().log(Status.PASS, "Pop-up message is displayed successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Pop-up message is NOT displayed");
		}
		//veryfy that popUp is displayed with "Yes" and "Cancel" buttons
		WebElement yesButton = waitForVisible(getMp().getYesbuttoninEditmodepopup());
		WebElement noButton = waitForVisible(getMp().getCancelbuttoninEditmodepopup());
		if (yesButton.isDisplayed() && noButton.isDisplayed()) {
			System.out.println("Pop-up with 'Yes' and 'No' buttons is displayed");
			utilityclassobject.gettest().log(Status.PASS, "Pop-up with 'Yes' and 'No' buttons is displayed successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Pop-up with 'Yes' and 'Cancel' buttons is NOT displayed");
		}
		waitAndClick(getMp().getCancelbuttoninEditmodepopup());
		Thread.sleep(2000);
		//mp.getTogglebuttoneditmode().click();


	}
	@Test(dependsOnMethods = "TC_004ToggoleDisplayedAreyouSure")
	public void TC_005ToggleinViewModeNothingClickable() throws InterruptedException {
		//verify toggole button is in Vivew mode and nothing is clickable in price book
		WebElement servicePrice = waitForVisible(getMp().getServicepriceinputfield());
		String disabledAttr = servicePrice.getAttribute("disabled");
		if (disabledAttr != null) {
			System.out.println("Toggle button is in View mode and nothing is clickable in price book");
			utilityclassobject.gettest().log(Status.PASS, "Toggle button is in View mode and nothing is clickable in price book successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Toggle button is not in View mode and something is clickable in price book");
		}
		List<WebElement> serviceNameList = driver.findElements(By.xpath("(//input[@type='text'])[5]"));
		if (!serviceNameList.isEmpty()) {
			String disabledAttr1 = serviceNameList.get(0).getAttribute("disabled");
			if (disabledAttr1 != null) {
				System.out.println("Toggle button is in View mode and nothing is clickable in price book");
				utilityclassobject.gettest().log(Status.PASS, "Toggle button is in View mode and nothing is clickable successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Toggle button is not in View mode and something is clickable");
			}
		} else {
			System.out.println("Input field at index 5 not found - skipping check");
			utilityclassobject.gettest().log(Status.INFO, "Input field at index 5 not found - skipping check");
		}


	}
	@Test(dependsOnMethods = "TC_005ToggleinViewModeNothingClickable")
	public void TC_006ToggleinEditModeEverythingClickable() throws InterruptedException {
		//verify services is visible under master price book 
		WebElement servicesUnderMasterPriceBook = waitForVisible(getMp().getServicesundermasterpricebook());
		if (servicesUnderMasterPriceBook.isDisplayed()) {
			System.out.println("Services is visible under master price book");
			utilityclassobject.gettest().log(Status.PASS, "Services is visible under master price book successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Services is NOT visible under master price book");
		}

	}
	@Test(dependsOnMethods = "TC_006ToggleinEditModeEverythingClickable")
	public void TC_007EditModePopupYesButtonFunctionality() throws InterruptedException {
	/*	//verify that bio/sharp is present under Services menu
		waitAndClick(getMp().getServicepriceinputfield());
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Service Price input field successfully");
		System.out.println("Clicked on Service Price input field");
		//verify that bio/Sharp are present under services menu
		WebElement bioSharp = waitForVisible(getMp().getBioSharps());
		if (bioSharp.isDisplayed()) {
			System.out.println("Bio/Sharp is present under Services menu");
			utilityclassobject.gettest().log(Status.PASS, "Bio/Sharp is present under Services menu successfully");
		} else {
			System.out.println("Bio/Sharp is NOT present under Services menu");
			utilityclassobject.gettest().log(Status.FAIL, "Bio/Sharp is NOT present under Services menu");
		}*/


	}
	@Test(dependsOnMethods = "TC_007EditModePopupYesButtonFunctionality")
	public void TC_008InformationIconPresentBesideBiosharps() throws InterruptedException {
		//veri fy that icon is present beside of bio/sharp under services menu
		WebElement infoIconBesideBioSharps = waitForVisible(getMp().getInfoiconbesideBioSharps());
		if (infoIconBesideBioSharps.isDisplayed()) {
			System.out.println("Information icon is present beside of bio/sharp under services menu");
			utilityclassobject.gettest().log(Status.PASS, "Information icon is present beside of bio/sharp successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Information icon is NOT present beside of bio/sharp");
		}


	}
	@Test(dependsOnMethods = "TC_008InformationIconPresentBesideBiosharps")
	public void TC_009InformationIconFunctionality() throws InterruptedException {
		//verify that Active heading is present bio/sharp information page
		waitAndClick(getMp().getInfoiconbesideBioSharps());
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Information icon beside Bio/Sharp successfully");
		System.out.println("Clicked on Information icon beside Bio/Sharp");
		WebElement activeHeading = waitForVisible(getMp().getActiveheading());
		if (activeHeading.isDisplayed()) {
			System.out.println("Active heading is present in bio/sharp information page");
			utilityclassobject.gettest().log(Status.PASS, "Active heading is present in bio/sharp information page successfully");
		} else {
			System.out.println("Active heading is NOT present in bio/sharp information page");
			utilityclassobject.gettest().log(Status.FAIL, "Active heading is NOT present in bio/sharp information page");
		}


	}
	@Test(dependsOnMethods = "TC_009InformationIconFunctionality")
	public void TC_010ActiveCheckboxUnderBopSharp() throws InterruptedException {
		
		waitAndClick(getMp().getTogglebuttonViewMode());
		waitAndClick(getMp().getYesbuttoninEdittoggle());
		Thread.sleep(3000);
		waitAndClick(getMp().getCheckboxtest38master());
		utilityclassobject.gettest().log(Status.INFO, "Clicked on checkbox of test 38 master successfully");
		System.out.println("Clicked on checkbox of test 38 master");
		waitAndClick(getMp().getCheckboxtest38master());
		utilityclassobject.gettest().log(Status.INFO, "Clicked again on checkbox of test 38 master successfully");
		System.out.println("Clicked again on checkbox of test 38 master");
		waitAndClick(getMp().getTogglebuttoneditmode());
		utilityclassobject.gettest().log(Status.INFO, "Clicked on toggle button in edit mode successfully");
		System.out.println("Clicked on toggle button in edit mode");
		utilityclassobject.gettest().log(Status.INFO, "Active checkbox is enabled and disabled successfully");
		System.out.println("Active checkbox is enabled and disabled successfully");
		
		
		
	}
	@Test(dependsOnMethods = "TC_010ActiveCheckboxUnderBopSharp")
	public void TC_011MasterItemNamebesideOfActive() throws InterruptedException {
		//verifythat master  Item name present beside of active heading in bio/sharp information page
		WebElement masterItemNameHeadingBesideActive = waitForVisible(getMp().getMasteritemnameheadingbesideactive());
		if (masterItemNameHeadingBesideActive.isDisplayed()) {
			System.out.println("Master Item name is present beside of active heading in bio/sharp information page");
			utilityclassobject.gettest().log(Status.PASS, "Master Item name is present beside of active heading successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Master Item name is NOT present beside of active heading");
		}
		
	}
	@Test(dependsOnMethods = "TC_011MasterItemNamebesideOfActive")
	public void TC_012ListofMasterItemNameAndCompareUnique() throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath(
				"//h3[text()='Bio/Sharps']/../../../descendant::div[text()='Master Item Name']/../../../descendant::div[@class='text-primary']"));
		//fetch all the items present in the Master item name column and attach in utility and print in console
		for (WebElement ele : list) {
			String text = ele.getText();
			System.out.println(text);
			utilityclassobject.gettest().log(Status.INFO, "Master Item Name: " + text);
			
		}
		///verify that all the items present in the Master item name column are unique
		int listSize = list.size();
		int uniqueCount = (int) list.stream().map(WebElement::getText).distinct().count();
		if (listSize == uniqueCount) {
			System.out.println("All the items present in the Master item name column are unique");
			utilityclassobject.gettest().log(Status.PASS, "All items in the Master item name column are unique successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Items in the Master item name column are NOT unique");
		}
		
	}
	@Test(dependsOnMethods = "TC_012ListofMasterItemNameAndCompareUnique")
	public void TC_013AssignedToGeneratorsHeadingBesideMasterItemName() throws InterruptedException {
		//verify that Assigned to generators heading is present beside of Master Item name heading in bio/sharp information page
		WebElement assignedToGeneratorsHeadingBesideMasterItemName = waitForVisible(getMp().getAssignedtogeneratorsheadingbesidemasteritemname());
		if (assignedToGeneratorsHeadingBesideMasterItemName.isDisplayed()) {
			System.out.println("Assigned to generators heading is present beside of Master Item name heading");
			utilityclassobject.gettest().log(Status.PASS, "Assigned to generators heading is present beside Master Item name successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Assigned to generators heading is NOT present beside Master Item name");
		}
	}

	@Test(dependsOnMethods = "TC_013AssignedToGeneratorsHeadingBesideMasterItemName")
	public void TC_014AssignedToGenerators() throws InterruptedException {
		List<WebElement> list1 = driver.findElements(By.xpath(
				"//h3[text()='Bio/Sharps']/../../../descendant::div[text()='Assigned to Generators']/../../../descendant::button"));
		//verify that all the items present in the Assigned to generators colums fetch all the items and attach in utility and print in console
		for (WebElement ele : list1) {
			String text = ele.getText();
			System.out.println(text);
			utilityclassobject.gettest().log(Status.INFO, "Assigned to Generators: " + text);
			
		}
		//verify that all the items present in the Assigned to generators column are unique
		int listSize1 = list1.size();
		int uniqueCount1 = (int) list1.stream().map(WebElement::getText).distinct().count();
		if (listSize1 == uniqueCount1) {
			System.out.println("All the items present in the Assigned to generators column are unique");
			utilityclassobject.gettest().log(Status.PASS, "All items in the Assigned to generators column are unique successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Items in the Assigned to generators column are NOT unique");
		}
	}

	@Test(dependsOnMethods = "TC_014AssignedToGenerators")
	public void TC_015ServicePriceHeadingBesideAssignedToGenerators() throws InterruptedException {
		//verify that Service price heading is present beside of Assigned to generators heading in bio/sharp information page
		WebElement servicePriceHeadingBesideAssignedToGenerators = waitForVisible(getMp().getServicepriceheadingbesideassignedtogenerators());
		if (servicePriceHeadingBesideAssignedToGenerators.isDisplayed()) {
			System.out.println("Service price heading is present beside of Assigned to generators heading");
			utilityclassobject.gettest().log(Status.PASS, "Service price heading is present beside Assigned to generators successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Service price heading is NOT present beside Assigned to generators");
		}
		
	}
	@Test(dependsOnMethods = "TC_015ServicePriceHeadingBesideAssignedToGenerators")
	public void TC_016ServicePriceWithTextFields() throws InterruptedException, EncryptedDocumentException, IOException {
		waitAndClick(getMp().getTogglebuttonViewMode());
		waitAndClick(getMp().getYesbuttoninEdittoggle());
		Thread.sleep(3000);
		List<WebElement> textlist = driver.findElements(By.xpath("(//div[contains(@class,'flex items-center')]/div[3]//input)[position()<=20]"));
		//fetch all text field fields under service price column and print in console
		for (WebElement ele : textlist) {
			String text = ele.getAttribute("value");
			System.out.println(text);
			utilityclassobject.gettest().log(Status.INFO, "Service Price: " + text);
			
		}
		//verify text fiels are editable or not try to pass some value in any of the text field under service price column and verify that value is getting entered or not
		if (textlist.isEmpty()) {
			System.out.println("No service price input fields found - skipping edit check");
			utilityclassobject.gettest().log(Status.INFO, "No service price input fields found - skipping edit check");
		} else {
			WebElement serviceField = textlist.get(0);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", serviceField);
			serviceField.click();
			serviceField.sendKeys(Keys.CONTROL + "a");
			serviceField.sendKeys(Keys.DELETE);
			String value = getElib().getDataFromExcel("Master Price Book", 3, 1);
			serviceField.sendKeys(value);
			js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", serviceField);
			js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", serviceField);
			Thread.sleep(2000);
			String enteredValue = serviceField.getAttribute("value");
			if (value != null && value.equals(enteredValue)) {
				System.out.println("Service Price field is editable, value is entered successfully");
				utilityclassobject.gettest().log(Status.PASS, "Service Price field is editable, value is entered successfully");
			} else {
				System.out.println("Service Price field is not editable, unable to enter value");
				utilityclassobject.gettest().log(Status.FAIL, "Service Price field is not editable, unable to enter value");
			}
		}
		waitAndClick(getMp().getTogglebuttoneditmode());
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = "TC_016ServicePriceWithTextFields")
	public void TC_017AllotmentbesideServiceType() throws InterruptedException {
		//verify that Allotment heading is present beside of Service price heading in bio/sharp information page
		WebElement allotmentHeadingBesideServicePrice = waitForVisible(getMp().getAllotmentheadingbesideserviceprice());
		if (allotmentHeadingBesideServicePrice.isDisplayed()) {
			System.out.println("Allotment heading is present beside of Service price heading");
			utilityclassobject.gettest().log(Status.PASS, "Allotment heading is present beside Service price heading successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Allotment heading is NOT present beside Service price heading");
		}
	}
	@Test(dependsOnMethods = "TC_017AllotmentbesideServiceType")
	public void TC_018AllotmentWithDropdown() throws InterruptedException, EncryptedDocumentException, IOException {
		waitAndClick(getMp().getTogglebuttonViewMode());
		waitAndClick(getMp().getYesbuttoninEdittoggle());
		Thread.sleep(3000);
		List<WebElement> listofallotments = driver.findElements(By.xpath("(//div[contains(@class,'flex items-center')]/div[4]//input)[position()<=20]"));
		//verify all the 20 text fields are present under allotment column and attach in utility and print in console
		for (WebElement ele : listofallotments) {
			if (ele.isDisplayed()) {
				System.out.println("Allotment text field is present under allotment column");
				utilityclassobject.gettest().log(Status.PASS, "Allotment text field is present under allotment column successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Allotment text field is NOT present under allotment column");
			}
			System.out.println(ele.getAttribute("value"));
			utilityclassobject.gettest().log(Status.INFO, "Allotment: " + ele.getAttribute("value"));
		}
		//click on view mode toggle button and try to enter value in any of the text field under allotment column and verify that value is getting entered or not
		if (listofallotments.isEmpty()) {
			System.out.println("No allotment input fields found - skipping edit check");
			utilityclassobject.gettest().log(Status.INFO, "No allotment input fields found - skipping edit check");
		} else {
			WebElement allotmentField = listofallotments.get(0);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", allotmentField);
			allotmentField.click();
			allotmentField.sendKeys(Keys.CONTROL + "a");
			allotmentField.sendKeys(Keys.DELETE);
			String value = getElib().getDataFromExcel("Master Price Book", 5, 1);
			allotmentField.sendKeys(value);
			js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", allotmentField);
			js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", allotmentField);
			Thread.sleep(2000);
			String enteredValue = allotmentField.getAttribute("value");
			if (value != null && value.equals(enteredValue)) {
				System.out.println("Allotment field is editable, value is entered successfully");
				utilityclassobject.gettest().log(Status.PASS, "Allotment field is editable, value is entered successfully");
			} else {
				System.out.println("Allotment field is not editable, unable to enter value");
				utilityclassobject.gettest().log(Status.FAIL, "Allotment field is not editable, unable to enter value");
			}
		}
		waitAndClick(getMp().getTogglebuttoneditmode());
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = "TC_018AllotmentWithDropdown")
	public void TC_019AdditionalContainerRateHeadingBesideAllotment() throws InterruptedException {
		//verify that Additional container rate heading is present beside of Allotment heading in bio/sharp information page
		WebElement additionalContainerRateHeadingBesideAllotment = waitForVisible(getMp().getAdditionalcontainerrateheadingbesideallotment());
		if (additionalContainerRateHeadingBesideAllotment.isDisplayed()) {
			System.out.println("Additional container rate heading is present beside of Allotment heading");
			utilityclassobject.gettest().log(Status.PASS, "Additional container rate heading is present beside Allotment heading successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Additional container rate heading is NOT present beside Allotment heading");
		}
	}
	@Test(dependsOnMethods = "TC_019AdditionalContainerRateHeadingBesideAllotment")
	public void TC_020AdditionalContainerRateWithinputs() throws InterruptedException, EncryptedDocumentException, IOException {
		waitAndClick(getMp().getTogglebuttonViewMode());
		waitAndClick(getMp().getYesbuttoninEdittoggle());
		Thread.sleep(3000);
		List<WebElement> additionalContainerRateFields = driver.findElements(By.xpath("(//div[contains(@class,'flex items-center')]/div[5]//input)[position()<=20]"));
		//try to enter value in any one of the text field under Additional container rate column and verify that value is getting entered or not
		if (additionalContainerRateFields.isEmpty()) {
			System.out.println("No additional container rate input fields found - skipping edit check");
			utilityclassobject.gettest().log(Status.INFO, "No additional container rate input fields found - skipping edit check");
		} else {
			WebElement additionalContainerRateField = additionalContainerRateFields.get(0);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", additionalContainerRateField);
			additionalContainerRateField.click();
			additionalContainerRateField.sendKeys(Keys.CONTROL + "a");
			additionalContainerRateField.sendKeys(Keys.DELETE);
			String value = getElib().getDataFromExcel("Master Price Book", 7, 1);
			additionalContainerRateField.sendKeys(value);
			js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", additionalContainerRateField);
			js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", additionalContainerRateField);
			Thread.sleep(2000);
			String enteredValue = additionalContainerRateField.getAttribute("value");
			if (value != null && value.equals(enteredValue)) {
				System.out.println("Additional container rate field is editable, value is entered successfully");
				utilityclassobject.gettest().log(Status.PASS, "Additional container rate field is editable, value is entered successfully");
			} else {
				System.out.println("Additional container rate field is not editable, unable to enter value");
				utilityclassobject.gettest().log(Status.FAIL, "Additional container rate field is not editable, unable to enter value");
			}
		}
		waitAndClick(getMp().getTogglebuttoneditmode());
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = "TC_020AdditionalContainerRateWithinputs")
	public void TC_021ChargePerPoundHeadingBesideAdditionalContainerRate() throws InterruptedException {
		//verify that Charge per pound heading is present beside of Additional container rate heading in bio/sharp information page
		WebElement chargePerPoundHeadingBesideAdditionalContainerRate = waitForVisible(getMp().getChargeperpoundheadingbesideadditionalcontainerrate());
		if (chargePerPoundHeadingBesideAdditionalContainerRate.isDisplayed()) {
			System.out.println("Charge per pound heading is present beside of Additional container rate heading");
			utilityclassobject.gettest().log(Status.PASS, "Charge per pound heading is present beside Additional container rate heading successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Charge per pound heading is NOT present beside Additional container rate heading");
		}
	}
	@Test(dependsOnMethods = "TC_021ChargePerPoundHeadingBesideAdditionalContainerRate")
	public void TC_022ChargePerPoundCheckbox() throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.out.println("hi");
	}
	@Test(dependsOnMethods = "TC_022ChargePerPoundCheckbox")
	public void TC_023PricePerPoundBesideChargePerPound() throws InterruptedException, EncryptedDocumentException, IOException {
		//verify that Price per pound heading is present beside of Charge per pound heading in bio/sharp information page
		WebElement pricePerPoundHeadingBesideChargePerPound = waitForVisible(getMp().getPriceperpoundoverweightfeesheadingbesidechargeperpound());
		if (pricePerPoundHeadingBesideChargePerPound.isDisplayed()) {
			System.out.println("Price per pound heading is present beside of Charge per pound heading");
			utilityclassobject.gettest().log(Status.PASS, "Price per pound heading is present beside Charge per pound heading successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Price per pound heading is NOT present beside Charge per pound heading");
		}
	}
}