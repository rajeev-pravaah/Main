package Assets_Disposal_Facilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.DisposalFacilities;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Disposal_Facilities_All_TC extends BaseClassForGEneratorContacts {

	DisposalFacilities df;
	ExcelUtility elib;
	String inputname;
	@Test
	public void TC_001VerifyAbletoAccessDisposalFacilitiesPage() {
		df = new DisposalFacilities(driver);
		df.getAssetsDD().click();
		System.out.println("Clicked on Assets Dropdown");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Assets Dropdown");
		df.getDisposalFacilities().click();
		System.out.println("Clicked on Disposal Facilities");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Disposal Facilities");
		if (df.getDisposalFacilitiesList().isDisplayed()) {
			System.out.println("Able to access Disposal Facilities Page :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Able to access Disposal Facilities Page ");
		} else {
			System.out.println("Not Able to access Disposal Facilities Page :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Not Able to access Disposal Facilities Page ");
		}

	}

	@Test(dependsOnMethods = "TC_001VerifyAbletoAccessDisposalFacilitiesPage")
	public void TC_002VerifyAbletoctoInfofromTootlip() {
		df.getOctoinfologo().click();
		System.out.println("Clicked on Octo Info Logo");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Octo Info Logo");
		if (df.getOctoinfoDisposalFacilityfromtooltip().isDisplayed()) {
			System.out.println("Able to access Octo Info from Tooltip :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Able to access Octo Info from Tooltip ");
		} else {
			System.out.println("Not Able to access Octo Info from Tooltip :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Not Able to access Octo Info from Tooltip ");
		}
		df.getCloseTooltip().click();
		System.out.println("Clicked on Close Tooltip");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Close Tooltip");

	}

	@Test(dependsOnMethods = "TC_002VerifyAbletoctoInfofromTootlip")
	public void TC_003VerifyAbletoAddNewDisposalFacility() {
		df.getAddNewDisposalFacilitybtn().click();
		System.out.println("Clicked on Add New Disposal Facility Button");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Disposal Facility Button");
		if (df.getAddNewDisposalFacilitypopup().isDisplayed()) {
			System.out.println("Able to access Add New Disposal Facility Page :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Able to access Add New Disposal Facility Page ");
		} else {
			System.out.println("Not Able to access Add New Disposal Facility Page :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Not Able to access Add New Disposal Facility Page ");
		}
	}

	@Test(dependsOnMethods = "TC_003VerifyAbletoAddNewDisposalFacility")
	public void TC_004VerifyUserNotAbletoProceedfurtheWithoutInput() throws EncryptedDocumentException, IOException {

		df.getSubmitbtnFromAddNewDisposalFacilitypopup().click();
		WebElement nameErr = df.getNamefielderrormsg(); // returns null if not visible (safeGet)
		if (nameErr != null && nameErr.isDisplayed()) {
			System.out.println("Name text field without input shows error message :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Name text field without input shows error message ");
		} else {
			System.out.println("Name text field without input does not show error message :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Name text field without input does not show error message ");
		}

	}

	@Test(dependsOnMethods = "TC_004VerifyUserNotAbletoProceedfurtheWithoutInput")
	public void TC_005VerifyNameFieldWithAlphabets() throws EncryptedDocumentException, IOException {
		df.getNamefieldFromAddewDisposalFacilitypopup().click();
		df.getNamefieldFromAddewDisposalFacilitypopup().clear();
		elib = new ExcelUtility();
		String alphabets = elib.getDataFromExcel("Disposal Facillity", 1, 2);

		df.getNamefieldFromAddewDisposalFacilitypopup().sendKeys(alphabets);
		System.out.println("Name text field accepts alphabets :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Name text field accepts alphabets ");

	}

	@Test(dependsOnMethods = "TC_005VerifyNameFieldWithAlphabets")
	public void TC_006VerifyNameTextFieldAcceptsNumbers() throws EncryptedDocumentException, IOException {
		df.getNamefieldFromAddewDisposalFacilitypopup().click();
		df.getNamefieldFromAddewDisposalFacilitypopup().clear();
		String numbers = elib.getDataFromExcel("Disposal Facillity", 1, 3);

		df.getNamefieldFromAddewDisposalFacilitypopup().sendKeys(numbers);
		System.out.println("Name text field accepts numbers :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Name text field accepts numbers ");

	}

	@Test(dependsOnMethods = "TC_006VerifyNameTextFieldAcceptsNumbers")
	public void TC_007VerifyNameTextFieldAcceptsSpecialCharacters()
			throws EncryptedDocumentException, IOException, InterruptedException {
		df.getNamefieldFromAddewDisposalFacilitypopup().click();
		df.getNamefieldFromAddewDisposalFacilitypopup().clear();
		String specialcharacters = elib.getDataFromExcel("Disposal Facillity", 1, 4);

		df.getNamefieldFromAddewDisposalFacilitypopup().sendKeys(specialcharacters);
		System.out.println("Name text field accepts special characters :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Name text field accepts special characters ");
		df.getNamefieldFromAddewDisposalFacilitypopup().clear();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "TC_007VerifyNameTextFieldAcceptsSpecialCharacters")
	public void TC_008VerifyNameTextFieldvalidInput() throws EncryptedDocumentException, IOException {
		df.getNamefieldFromAddewDisposalFacilitypopup().click();
		String input1 = elib.getDataFromExcel("Disposal Facillity", 1, 1);
		// add 5 digits random number to the input
		int randomNum = (int) (Math.random() * 100000);
		String input = input1 + randomNum;

		df.getNamefieldFromAddewDisposalFacilitypopup().sendKeys(input);
		System.out.println("NAme text field accepts input :PASS");
		utilityclassobject.gettest().log(Status.PASS, "NAme text field accepts input ");
	}

	@Test(dependsOnMethods = "TC_008VerifyNameTextFieldvalidInput")
	public void TC_009VerifyEmailFieldAcceptsInputs() throws EncryptedDocumentException, IOException {
		df.getEmailfieldFromAddNewDisposalFacilitypopup().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 4, 1);
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(input);
		System.out.println("Email text field accepts input :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Email text field accepts input ");
		df.getEmailfieldFromAddNewDisposalFacilitypopup().clear();

	}

	@Test(dependsOnMethods = "TC_009VerifyEmailFieldAcceptsInputs")
	public void TC_010VerifyEmailFieldAcceptsAlphabtes() throws EncryptedDocumentException, IOException {
		df.getEmailfieldFromAddNewDisposalFacilitypopup().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 4, 2);
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(input);
		System.out.println("Email text field accepts alphabets :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Email text field accepts alphabets ");
		df.getEmailfieldFromAddNewDisposalFacilitypopup().clear();

	}

	@Test(dependsOnMethods = "TC_010VerifyEmailFieldAcceptsAlphabtes")
	public void TC_011VerifyEmailFieldAcceptsNumbers() throws EncryptedDocumentException, IOException {
		df.getEmailfieldFromAddNewDisposalFacilitypopup().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 4, 3);
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(input);
		System.out.println("Email text field accepts numbers :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Email text field accepts numbers ");
		df.getEmailfieldFromAddNewDisposalFacilitypopup().clear();

	}

	@Test(dependsOnMethods = "TC_011VerifyEmailFieldAcceptsNumbers")
	public void TC_012VerifyEmailFieldAcceptsSpecialCharacters() throws EncryptedDocumentException, IOException {
		df.getEmailfieldFromAddNewDisposalFacilitypopup().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 4, 4);
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(input);
		System.out.println("Email text field accepts special characters :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Email text field accepts special characters ");
		df.getEmailfieldFromAddNewDisposalFacilitypopup().clear();

	}

	@Test(dependsOnMethods = "TC_012VerifyEmailFieldAcceptsSpecialCharacters")
	public void TC_013VerifyEmailFieldShouldNptAcceptsInValidEmail() throws EncryptedDocumentException, IOException {
		df.getEmailfieldFromAddNewDisposalFacilitypopup().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 4, 5);
		System.out.println(input);
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(input);
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(Keys.TAB); // blur to trigger email validation
		// df.getSubmitbtnFromAddNewDisposalFacilitypopup().click();
		WebElement emailErr = df.getEmailfielderrormsg(); // returns null if not visible (safeGet)
		if (emailErr != null && emailErr.isDisplayed()) {
			System.out.println("Email text field shows error message as Please Enter Valid mail :PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Email text field shows error message as Please Enter Valid mail");
		} else {
			System.out.println("Email text field does not show error message for invalid email :FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Email text field does not show error message for invalid email ");
		}
		df.getEmailfieldFromAddNewDisposalFacilitypopup().click();
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(Keys.CONTROL + "a");
		df.getEmailfieldFromAddNewDisposalFacilitypopup().sendKeys(Keys.DELETE);
		System.out.println("Email text field cleared using Ctrl+A and Delete");
		utilityclassobject.gettest().log(Status.INFO, "Email text field cleared using Ctrl+A and Delete");

	}

	@Test(dependsOnMethods = "TC_013VerifyEmailFieldShouldNptAcceptsInValidEmail")
	public void TC_014VerifyUserISAbleTOProceedWithoutEmail() throws EncryptedDocumentException, IOException {
		df.getSubmitbtnFromAddNewDisposalFacilitypopup().click();
		System.out.println("Clicked on Add new Disposal Facility Submit Button");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add new Disposal Facility Submit Button");
		if (df.getDisposalFacilityProfile().isDisplayed()) {
			System.out.println("Able to proceed without email :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Able to proceed without email");
		} else {
			System.out.println("Not Able to proceed without email :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Not Able to proceed without email");
		}

	}

	// Jaxon Reed82645
	@Test(dependsOnMethods = "TC_014VerifyUserISAbleTOProceedWithoutEmail")
	public void TC_015VerifyDefaultValueFromNotificationTypeDropdown() throws EncryptedDocumentException, IOException {
		df.getDisposalFacilityListlink().click();
		df.getAddNewDisposalFacilitybtn().click();

		df.getNotificationTypedropdown().click();
		String defaultvalue = df.getNotificationTypedropdown().getText();
		System.out.println("Default value from Notification Type Dropdown is: " + defaultvalue);
		utilityclassobject.gettest().log(Status.INFO,
				"Default value from Notification Type Dropdown is: " + defaultvalue);

	}

	@Test(dependsOnMethods = "TC_015VerifyDefaultValueFromNotificationTypeDropdown")
	public void TC_016VerifyNotificationTypeDropdownAcceptsInputs() throws EncryptedDocumentException, IOException {
		// Get the input text to try typing into the dropdown
		String input = elib.getDataFromExcel("Disposal Facillity", 7, 1);
		df.getNotificationTypedropdown().click();
		df.getNotificationTypedropdown().sendKeys(input);
		String typedvalue = df.getNotificationTypedropdown().getText();
		if (typedvalue.equals(input)) {
			System.out.println("Notification Type Dropdown  accept input: PASS");
			utilityclassobject.gettest().log(Status.FAIL, "Notification Type Dropdown accept input");
		} else {
			System.out.println("Notification Type Dropdown does not accept input: PASS");
			utilityclassobject.gettest().log(Status.PASS, "Notification Type Dropdown does not accept input");
		}

	}

	@Test(dependsOnMethods = "TC_016VerifyNotificationTypeDropdownAcceptsInputs")
	public void TC_017VerifyNotificationTypeDropdownOptions() throws EncryptedDocumentException, IOException {
		df.getNotificationTypedropdown().click();
		// fetch all the options from the dropdown using select class
		List<WebElement> options = df.getNotificationTypeoptions();
		for (WebElement option : options) {
			System.out.println("Notification Type Dropdown option: " + option.getText());
			utilityclassobject.gettest().log(Status.INFO, "Notification Type Dropdown option: " + option.getText());
		}
		System.out.println("Total options in Notification Type Dropdown: " + options.size());
		utilityclassobject.gettest().log(Status.INFO, "Total options in Notification Type Dropdown: " + options.size());

	}

	@Test(dependsOnMethods = "TC_017VerifyNotificationTypeDropdownOptions")
	public void TC_018VerifyUserAbletoSelectoptionsFromNotifucationTypedropdown()
			throws EncryptedDocumentException, IOException {
		df.getNotificationTypedropdown().click();
		df.getNotificationTypedropdown().click();

		List<WebElement> options = df.getNotificationTypeoptions();
		if (options.size() > 0) {
			String selectedOptionText = options.get(0).getText(); // capture text BEFORE click to avoid StaleElementReferenceException
			options.get(0).click();
			System.out.println("Selected option from Notification Type Dropdown: " + selectedOptionText);
			utilityclassobject.gettest().log(Status.INFO,
					"Selected option from Notification Type Dropdown: " + selectedOptionText);
		} else {
			System.out.println("No options available in Notification Type Dropdown");
			utilityclassobject.gettest().log(Status.INFO, "No options available in Notification Type Dropdown");
		}

	}

	@Test(dependsOnMethods = "TC_018VerifyUserAbletoSelectoptionsFromNotifucationTypedropdown")
	public void TC_019VerifyUserAbletoSelectMultipleOptions() throws EncryptedDocumentException, IOException {
		// Open dropdown and fetch fresh options list
		df.getNotificationTypedropdown().click();

		List<WebElement> options = df.getNotificationTypeoptions();

		if (options.size() > 1) {
			// Click first option
			String firstOptionText = options.get(0).getText();
			options.get(0).click();
			System.out.println("Selected first option: " + firstOptionText);
			utilityclassobject.gettest().log(Status.INFO, "Selected first option: " + firstOptionText);

			// Re-open dropdown to select second option (custom dropdown closes after each
			// selection)
			df.getNotificationTypedropdown().click();
			List<WebElement> freshOptions = df.getNotificationTypeoptions();
			String secondOptionText = freshOptions.get(1).getText();
			freshOptions.get(1).click();
			System.out.println("Selected second option: " + secondOptionText);
			utilityclassobject.gettest().log(Status.PASS, "Selected multiple options from Notification Type Dropdown: "
					+ firstOptionText + ", " + secondOptionText);
		} else {
			System.out.println("Not enough options available in Notification Type Dropdown to select multiple");
			utilityclassobject.gettest().log(Status.INFO,
					"Not enough options available in Notification Type Dropdown to select multiple");
		}
	}

	String valuefromNoticationdd;

	@Test(dependsOnMethods = "TC_019VerifyUserAbletoSelectMultipleOptions")
	public void TC_020VerifyDisposalFaciltygetAdded() throws EncryptedDocumentException, IOException {

		// pass valid name inside name text field and click on submit button
		df.getNamefieldFromAddewDisposalFacilitypopup().click();
		String input1 = elib.getDataFromExcel("Disposal Facillity", 1, 1);
		// add 5 digits random number to the input
		int randomNum = (int) (Math.random() * 100000);
		inputname = input1 + randomNum;
		df.getNamefieldFromAddewDisposalFacilitypopup().sendKeys(inputname);
		// fetch the value from notification type dropdown and print it
		valuefromNoticationdd = df.getNotificationTypedropdown().getText();
		System.out.println("Value from Notification Type Dropdown: " + valuefromNoticationdd);
		utilityclassobject.gettest().log(Status.INFO,
				"Value from Notification Type Dropdown: " + valuefromNoticationdd);
		df.getSubmitbtnFromAddNewDisposalFacilitypopup().click();
		if (df.getDisposalFacilityProfile().isDisplayed()) {
			System.out
					.println("Able to proceed after selecting multiple options from Notification Type Dropdown :PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Able to proceed after selecting multiple options from Notification Type Dropdown");
		} else {
			System.out.println(
					"Not Able to proceed after selecting multiple options from Notification Type Dropdown :FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Not Able to proceed after selecting multiple options from Notification Type Dropdown");
		}
		
	/*	String actualnotificationvalue = df.getNotificationTypefieldfromDisposalFacilityPage().getAttribute("value");
		if (actualnotificationvalue.equals(valuefromNoticationdd)) {
			System.out.println(
					"Notification Type value from Disposal Facility Page matches with the selected value from Dropdown :PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Notification Type value from Disposal Facility Page matches with the selected value from Dropdown");
		} else {
			System.out.println(
					"Notification Type value from Disposal Facility Page does not match with the selected value from Dropdown :FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Notification Type value from Disposal Facility Page does not match with the selected value from Dropdown");
		}*/
		System.out.println("Name of the Disposal Facility added: " + inputname);
		utilityclassobject.gettest().log(Status.INFO, "Name of the Disposal Facility added: " + inputname);
	}
	@Test(dependsOnMethods = "TC_020VerifyDisposalFaciltygetAdded")
	public void TC_021VerifyRedirectedtoDisposalFaciltyDetails() throws EncryptedDocumentException, IOException {
		if (df.getDisposalFacilityDetailLink().isDisplayed()) {
			System.out.println("Able to access Disposal Facility Detail Page :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Able to access Disposal Facility Detail Page");
		} else {
			System.out.println("Not Able to access Disposal Facility Detail Page :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Not Able to access Disposal Facility Detail Page");
		}
	}

	@Test(dependsOnMethods = "TC_021VerifyRedirectedtoDisposalFaciltyDetails")
	public void TC_022VerifyOctoInfoFromDisposalFaciltyDetails() throws EncryptedDocumentException, IOException {
		df.getOctoinfotooltip().click();
		System.out.println("Clicked on Octo Info Logo from Disposal Facility Details Page");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Octo Info Logo from Disposal Facility Details Page");
		if (df.getOctoinfotooltipheader().isDisplayed()) {
			System.out.println("Able to access Octo Info from Tooltip :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Able to access Octo Info from Tooltip ");
		} else {
			System.out.println("Not Able to access Octo Info from Tooltip :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Not Able to access Octo Info from Tooltip ");
		}
		df.getCloseTooltip().click();
		System.out.println("Clicked on Close Tooltip");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Close Tooltip");

	}
	// =====================================================================
	// DO NOT REMOVE OR MODIFY THE @Test ANNOTATION BELOW.
	// dependsOnMethods is intentionally commented out so this test can be
	// launched independently using Eclipse's  ▶ Run  /  🐞 Debug  buttons
	// without needing the full TC_001-TC_022 chain to have run first.
	// The standalone navigation block (Assets DD → Disposal Facilities)
	// inside this method MUST also be preserved for the same reason.
	// =====================================================================
	
	//String targetName;
	@Test(dependsOnMethods = "TC_022VerifyOctoInfoFromDisposalFaciltyDetails")
	public void TC_023VerifyMapFromDisposalFaciltyDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================

		
		/*
		
		// --- Standalone navigation (required for Run / Debug) --- DO NOT REMOVE ---
		df = new DisposalFacilities(driver);
		df.getAssetsDD().click();
		System.out.println("Clicked on Assets Dropdown");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Assets Dropdown");
		df.getDisposalFacilities().click();
		System.out.println("Clicked on Disposal Facilities");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Disposal Facilities");
		Thread.sleep(2000);
		// -------------------------------------------------------------------------

		targetName = "Jaxon Reed53403";

		// Step 1: Use the search field to filter list - avoids pagination issue
		try {
			WebElement searchInput = driver.findElement(By.xpath(
				"//input[@type='search' or @placeholder='Search' or @placeholder='Search...' or contains(@placeholder,'earch')]"));
			searchInput.clear();
			searchInput.sendKeys(targetName);
			Thread.sleep(1500);
			System.out.println("Typed in search field: " + targetName);
			utilityclassobject.gettest().log(Status.INFO, "Typed in search field: " + targetName);
		} catch (Exception e) {
			System.out.println("No search field found, proceeding without filter: " + e.getMessage());
		}

		// Step 2: Find the element directly by text - no loop needed
	
		
		// Tries multiple XPath patterns to match the actual DOM
		String[] xpaths = {
			"//*[normalize-space(text())='" + targetName + "']/ancestor::a[1]",
			"//a[.//*[normalize-space(text())='" + targetName + "']]",
			"//*[normalize-space(text())='" + targetName + "']",
			"//*[contains(text(),'" + targetName + "')]/ancestor::a[1]",
			"//*[contains(text(),'" + targetName + "')]"
		};

		boolean clicked = false;
		for (String xpath : xpaths) {
			try {
				WebElement el = driver.findElement(By.xpath(xpath));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
				Thread.sleep(500);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
				System.out.println("Clicked '" + targetName + "' using XPath: " + xpath + " :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Clicked Disposal Facility: " + targetName);
				clicked = true;
				break;
			} catch (Exception e) {
				System.out.println("XPath failed [" + xpath + "]: " + e.getMessage());
			}
		}

		if (!clicked) {
			System.out.println("Could not find '" + targetName + "' in the list :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Could not find Disposal Facility: " + targetName);
		}
		*/
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================

		//verify map is displayed
		if (df.getMap().isDisplayed()) {
			System.out.println("Map is displayed on Disposal Facility Details Page :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Map is displayed on Disposal Facility Details Page");
		} else {
			System.out.println("Map is not displayed on Disposal Facility Details Page :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Map is not displayed on Disposal Facility Details Page");
		}
	}
	
	@Test(dependsOnMethods = "TC_023VerifyMapFromDisposalFaciltyDetails")
	public void TC_024VerifyUserAbletoZoominAndZoomoutMAp() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getMap().click();
		System.out.println("Clicked on Map on Disposal Facility Details Page");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Map on Disposal Facility Details Page");
		df.getMapzoominbutton().click();
		System.out.println("Clicked on Zoom In button on Map");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Zoom In button on Map");
		Thread.sleep(2000);
		df.getMapzoomoutbutton().click();
		System.out.println("Clicked on Zoom Out button on Map");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Zoom Out button on Map");
		
	}
	@Test(dependsOnMethods = "TC_024VerifyUserAbletoZoominAndZoomoutMAp")
	public void TC_025VerifyUserAbletoDaginsideMap() throws EncryptedDocumentException, IOException, InterruptedException {
		// Drag the map by clicking and holding, then moving the mouse to left and right
		Actions actions = new Actions(driver);
		actions.moveToElement(df.getMap()).clickAndHold().moveByOffset(-500, 0).moveByOffset(200, 0).release().perform();
		System.out.println("Dragged the map left and right");
		utilityclassobject.gettest().log(Status.INFO, "Dragged the map left and right");
		
		
	}
	@Test(dependsOnMethods = "TC_025VerifyUserAbletoDaginsideMap")
	public void TC_026VerifyNameOftheDisposalFacilityisPresent() throws EncryptedDocumentException, IOException, InterruptedException {
	
		// Verify that the name of the disposal facility is present in the name text field
		String nameInField = df.getNamefield().getAttribute("value");
		// null-safe: use inputname.equals() so NPE is avoided if nameInField is null
		if(inputname != null && inputname.equals(nameInField)) {
			System.out.println("Name of the Disposal Facility is present in the Name text field :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Name of the Disposal Facility is present in the Name text field");
		} else {
			System.out.println("Name of the Disposal Facility is not present in the Name text field :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Name of the Disposal Facility is not present in the Name text field");
		}
		
	}
	@Test(dependsOnMethods = "TC_026VerifyNameOftheDisposalFacilityisPresent")
	public void TC_027VerifyUserAbletoEditname() throws EncryptedDocumentException, IOException, InterruptedException {
		
		///read it 
		//==========While executing from Tc_023 make sure it is editing name of the Disposal facility which is present in the list, otherwise it will fail=========
		//===========for next execution use new edited name ====================

	//verify user is able to edit the name of the disposal facility just click on name text field and remove last 2 words
		String nameInField = df.getNamefield().getAttribute("value");
		df.getNamefield().click();
		df.getNamefield().sendKeys(Keys.END);
		for(int i=0;i<2;i++) {
			df.getNamefield().sendKeys(Keys.BACK_SPACE);
		}
		String editedNameInField = df.getNamefield().getAttribute("value");
		// null-safe: ensure editedNameInField is not null before calling equals()
		if(editedNameInField != null && !editedNameInField.equals(nameInField)) {
			System.out.println("User is able to edit the name of the Disposal Facility :PASS");
			utilityclassobject.gettest().log(Status.PASS, "User is able to edit the name of the Disposal Facility");
		} else {
			System.out.println("User is not able to edit the name of the Disposal Facility :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "User is not able to edit the name of the Disposal Facility");
		}
		df.getNametext().click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getNamefield());
		df.getNamefield().sendKeys(Keys.CONTROL + "a");
		df.getNamefield().sendKeys(Keys.DELETE);
		
		df.getNamefield().sendKeys(inputname);
		System.out.println(inputname+" :Name of the Disposal Facility is restored to original value");
		
		
	}
	
	@Test(dependsOnMethods = "TC_027VerifyUserAbletoEditname")
	public void TC_028VerifyAutoSavesTheData() throws EncryptedDocumentException, IOException, InterruptedException {

		// After name is edited, click elsewhere to trigger auto-save, then verify
		// the auto-save message "Autosaved treatment details" appears in the right corner
		df.getNametext().click();
		System.out.println("Clicked outside the name field to trigger auto-save");
		utilityclassobject.gettest().log(Status.INFO, "Clicked outside the name field to trigger auto-save");

		Thread.sleep(3000); // wait for auto-save to trigger

		List<WebElement> autoSaveMsgs = driver.findElements(
				By.xpath("//*[contains(text(),'Autosaved') or contains(text(),'autosaved')]"));

		if (!autoSaveMsgs.isEmpty() && autoSaveMsgs.get(0).isDisplayed()) {
			String autoSaveText = autoSaveMsgs.get(0).getText();
			System.out.println("Auto-save message displayed: " + autoSaveText + " :PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Auto-save message 'Autosaved treatment details' is displayed in the right corner: " + autoSaveText);
		} else {
			System.out.println("Auto-save message 'Autosaved treatment details' is NOT displayed :FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Auto-save message 'Autosaved treatment details' is NOT displayed in the right corner");
		}
	}
	@Test(dependsOnMethods = "TC_028VerifyAutoSavesTheData")
	public void TC_029VerifyAbleToEnterValidInputInStreetTextField() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getStreetfield().click();
		elib= new ExcelUtility();
		String input = elib.getDataFromExcel("Disposal Facillity", 13, 1);
		df.getStreetfield().sendKeys(input);
		String streetInField = df.getStreetfield().getAttribute("value");
		// null-safe: use input.equals() so NPE is avoided if streetInField is null
		if(input != null && input.equals(streetInField)) {
			System.out.println("User is able to enter valid input in the Street text field :PASS");
			utilityclassobject.gettest().log(Status.PASS, "User is able to enter valid input in the Street text field");
		} else {
			System.out.println("User is not able to enter valid input in the Street text field :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "User is not able to enter valid input in the Street text field");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getStreetfield());
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
		
	}
	@Test(dependsOnMethods = "TC_029VerifyAbleToEnterValidInputInStreetTextField")
	public void TC_030VerifyStreetTextfieldAcceptsAlphabets() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getStreetfield().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getStreetfield());
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Disposal Facillity", 13, 2);
		df.getStreetfield().sendKeys(input);
		String streetInField = df.getStreetfield().getAttribute("value");
		if(input != null && input.equals(streetInField)) {
			System.out.println("Street text field accepts alphabets :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Street text field accepts alphabets");
		} else {
			System.out.println("Street text field does not accept alphabets :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Street text field does not accept alphabets");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getStreetfield());
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
	}
	@Test(dependsOnMethods = "TC_030VerifyStreetTextfieldAcceptsAlphabets")
	public void TC_031VerifyStreetTextfieldAcceptsNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getStreetfield().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getStreetfield());
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Disposal Facillity", 13, 3);
		df.getStreetfield().sendKeys(input);
		String streetInField = df.getStreetfield().getAttribute("value");
		if(input != null && input.equals(streetInField)) {
			System.out.println("Street text field accepts numbers :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Street text field accepts numbers");
		} else {
			System.out.println("Street text field does not accept numbers :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Street text field does not accept numbers");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getStreetfield());
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
	}
	@Test(dependsOnMethods = "TC_031VerifyStreetTextfieldAcceptsNumbers")
	public void TC_032VerifyStreetTextfieldAcceptsSpecialCharacters() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getStreetfield().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getStreetfield());
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
		String input = elib.getDataFromExcel("Disposal Facillity", 13, 4);
		df.getStreetfield().sendKeys(input);
		String streetInField = df.getStreetfield().getAttribute("value");
		if(input != null && input.equals(streetInField)) {
			System.out.println("Street text field accepts special characters :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Street text field accepts special characters");
		} else {
			System.out.println("Street text field does not accept special characters :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Street text field does not accept special characters");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", df.getStreetfield());
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
	}
	@Test(dependsOnMethods = "TC_032VerifyStreetTextfieldAcceptsSpecialCharacters")
	public void TC_033VerifyStreetTextfieldisMandatoryField() throws EncryptedDocumentException, IOException, InterruptedException {
		// Clear field and click outside (blur) to trigger validation — required to make error message appear
		df.getStreetfield().click();
		df.getStreetfield().sendKeys(Keys.CONTROL + "a");
		df.getStreetfield().sendKeys(Keys.DELETE);
		df.getNametext().click(); // click outside the street field to trigger blur validation
		System.out.println("Cleared Street field and clicked outside to trigger validation");
		utilityclassobject.gettest().log(Status.INFO, "Cleared Street field and clicked outside to trigger validation");
		WebElement streetErr = df.getStreetfielderrormsg(); // returns null if not visible (safeGet)
		if(streetErr != null && streetErr.isDisplayed()) {
			System.out.println("Street text field shows error message as Please Enter Street :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Street text field shows error message as Please Enter Street");
		} else {
			System.out.println("Street text field does not show error message for mandatory field :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Street text field does not show error message for mandatory field");
		}
	}
	@Test(dependsOnMethods = "TC_033VerifyStreetTextfieldisMandatoryField")
	public void TC_034VerifySuggestionForStreetField() throws EncryptedDocumentException, IOException, InterruptedException {
		
		df.getStreetfield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 13, 5);
		df.getStreetfield().sendKeys(input);
		Thread.sleep(2000);
		WebElement suggestionEl = df.getStreetfieldsuggestionoptions(); // returns null if not visible (safeGet)
		if(suggestionEl != null && suggestionEl.isDisplayed()) {
			System.out.println("Street text field shows suggestion options :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Street text field shows suggestion options");
		} else {
			System.out.println("Street text field does not show suggestion options :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Street text field does not show suggestion options");
		}

	
	
	}	
	@Test(dependsOnMethods = "TC_034VerifySuggestionForStreetField")
	public void TC_035VerifyClickingOnSuggestionAutoFillsCity_State_Zipcode() throws EncryptedDocumentException, IOException, InterruptedException {
	List<WebElement> suggestedoptions = df.getStreetfieldsuggestionoptionslist();
	String optionText = "";
	for(WebElement option : suggestedoptions) {
		optionText = option.getText();
		option.click();
		System.out.println("Clicked on suggestion option: " + optionText);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on suggestion option: " + optionText);
		Thread.sleep(2000);
	
	
		break; // exit the loop after first iteration
	}
	
	String city = df.getCityfield().getDomProperty("value");
	System.out.println("City field value after clicking suggestion: " + city);
	utilityclassobject.gettest().log(Status.INFO, "City field value after clicking suggestion: " + city);
	//Select select = new Select(df.getStatefield());
	String state = df.getStatefield().getDomProperty("value");
	System.out.println(state);
	System.out.println("State field value after clicking suggestion: " + state);
	utilityclassobject.gettest().log(Status.INFO, "State field value after clicking suggestion: " + state);
	String zip = df.getZipfield().getDomProperty("value");
	System.out.println("Zipcode field value after clicking suggestion: " + zip);
	utilityclassobject.gettest().log(Status.INFO, "Zipcode field value after clicking suggestion: " + zip);
	
	}
	@Test(dependsOnMethods = "TC_035VerifyClickingOnSuggestionAutoFillsCity_State_Zipcode")
	public void TC_036VerifyAutosavesStreetData() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//write code just give one back space 
		df.getStreetfield().click();
		df.getStreetfield().sendKeys(Keys.BACK_SPACE);
		//clear the entire field
		df.ClearTextField(df.getStreetfield());
			
		//again add that removed word
		df.getStreetfield().click();

		String input = elib.getDataFromExcel("Disposal Facillity", 13, 5);
		df.getStreetfield().sendKeys(input);
		List<WebElement> suggestedoptions = df.getStreetfieldsuggestionoptionslist();
	/*	for(WebElement option : suggestedoptions) {
			String optionText = option.getText();
			option.click();
		}*/
		suggestedoptions.get(0).click();
		//fetch data from 
	//write code to verify it should display Autosaved treatment details  message in right corner of the page

		List<WebElement> autoSaveMsgs = driver.findElements(
				By.xpath("//*[contains(text(),'Autosaved') or contains(text(),'autosaved')]"));

		if (!autoSaveMsgs.isEmpty() && autoSaveMsgs.get(0).isDisplayed()) {
			String autoSaveText = autoSaveMsgs.get(0).getText();
			System.out.println("Auto-save message displayed: " + autoSaveText + " :PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Auto-save message 'Autosaved treatment details' is displayed in the right corner: " + autoSaveText);
		} else {
			System.out.println("Auto-save message 'Autosaved treatment details' is NOT displayed :FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Auto-save message 'Autosaved treatment details' is NOT displayed in the right corner");
		}
		
		
	}
	@Test(dependsOnMethods = "TC_036VerifyAutosavesStreetData")
	public void TC_037VerifySuiteTextFieldAcceptsInput() throws EncryptedDocumentException, IOException, InterruptedException {
	//verify suite field accepts inputs
		df.getSuitefield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 15, 1);
		df.getSuitefield().sendKeys(input);
		String suiteInField = df.getSuitefield().getAttribute("value");
		if(input != null && input.equals(suiteInField)) {
			System.out.println("User is able to enter valid input in the Suite text field :PASS");
			utilityclassobject.gettest().log(Status.PASS, "User is able to enter valid input in the Suite text field");
		} else {
			System.out.println("User is not able to enter valid input in the Suite text field :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "User is not able to enter valid input in the Suite text field");
		}
		//clear the suite field
		df.ClearTextField(df.getSuitefield());
	}
	@Test(dependsOnMethods = "TC_037VerifySuiteTextFieldAcceptsInput")
	public void TC_038VerifySuiteTextFiledAccepptsalphabets() throws EncryptedDocumentException, IOException, InterruptedException {
	df.getSuitefield().click();
	String input = elib.getDataFromExcel("Disposal Facillity", 15, 2);
	df.getSuitefield().sendKeys(input);
	String suiteInField = df.getSuitefield().getAttribute("value");
	if(input != null && input.equals(suiteInField)) {

		System.out.println("Suite text field accepts alphabets :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Suite text field accepts alphabets");
	} else {
		System.out.println("Suite text field does not accept alphabets :FAIL");
		utilityclassobject.gettest().log(Status.FAIL, "Suite text field does not accept alphabets");
	}
	df.ClearTextField(df.getSuitefield());
	
	}
	@Test(dependsOnMethods = "TC_038VerifySuiteTextFiledAccepptsalphabets")
	public void TC_039VerifySuiteTextFiledAccepptsNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getSuitefield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 15, 3);
		df.getSuitefield().sendKeys(input);
		String suiteInField = df.getSuitefield().getAttribute("value");
		if(input != null && input.equals(suiteInField)) {

			System.out.println("Suite text field accepts numbers :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Suite text field accepts numbers");
		} else {
			System.out.println("Suite text field does not accept numbers :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Suite text field does not accept numbers");
		}
		df.ClearTextField(df.getSuitefield());
	}
	@Test(dependsOnMethods = "TC_039VerifySuiteTextFiledAccepptsNumbers")
	public void TC_040VerifySuiteTextFiledAccepptsSpecialCharacters() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getSuitefield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 15, 4);
		df.getSuitefield().sendKeys(input);
		String suiteInField = df.getSuitefield().getAttribute("value");
		if(input != null && input.equals(suiteInField)) {

			System.out.println("Suite text field accepts special characters :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Suite text field accepts special characters");
		} else {
			System.out.println("Suite text field does not accept special characters :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Suite text field does not accept special characters");
		}
		df.ClearTextField(df.getSuitefield());
	}
	@Test(dependsOnMethods = "TC_040VerifySuiteTextFiledAccepptsSpecialCharacters")
	public void TC_041VerifySuiteTextfieldisNotMandatoryField() throws EncryptedDocumentException, IOException, InterruptedException {
		// Clear field and click outside (blur) to trigger validation — required to make error message appear
		df.getSuitefield().click();
		df.getSuitefield().sendKeys(Keys.CONTROL + "a");
		df.getSuitefield().sendKeys(Keys.DELETE);
		df.getNametext().click(); // click outside the suite field to trigger blur validation
		System.out.println("Cleared Suite field and clicked outside to trigger validation");
		utilityclassobject.gettest().log(Status.INFO, "Cleared Suite field and clicked outside to trigger validation");
	
	
	}
	@Test(dependsOnMethods = "TC_041VerifySuiteTextfieldisNotMandatoryField")
	public void TC_042VerifyAutosavesSuiteData() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//write code just give one back space 
		df.getSuitefield().click();
		//clear the entire field
		df.ClearTextField(df.getSuitefield());
			
		//again add that removed word
		df.getSuitefield().click();

		String input = elib.getDataFromExcel("Disposal Facillity", 15, 1);
		df.getSuitefield().sendKeys(input);
		
		//verify it should display Autosaved treatment details  message in right corner of the page
		df.getNametext().click(); // click outside the suite field to trigger blur validation
		List<WebElement> autoSaveMsgs = driver.findElements(
				By.xpath("//*[contains(text(),'Autosaved') or contains(text(),'autosaved')]"));

		if (!autoSaveMsgs.isEmpty() && autoSaveMsgs.get(0).isDisplayed()) {
			String autoSaveText = autoSaveMsgs.get(0).getText();
			System.out.println("Auto-save message displayed: " + autoSaveText + " :PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Auto-save message 'Autosaved treatment details' is displayed in the right corner: " + autoSaveText);
		} else {
			System.out.println("Auto-save message 'Autosaved treatment details' is NOT displayed :FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Auto-save message 'Autosaved treatment details' is NOT displayed in the right corner");
		}
		System.out.println("Suite field data is auto-saved successfully");
		utilityclassobject.gettest().log(Status.INFO, "Suite field data is auto-saved successfully");
	}
	@Test(dependsOnMethods = "TC_042VerifyAutosavesSuiteData")
	public void TC_043VerifyCityTextFieldAcceptsInput() throws EncryptedDocumentException, IOException, InterruptedException {
		//verify city field accepts inputs
		df.getCityfield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 17, 1);
		df.getCityfield().sendKeys(input);
		String cityInField = df.getCityfield().getAttribute("value");
			System.out.println("User is able to enter valid input in the City text field :PASS");
			utilityclassobject.gettest().log(Status.PASS, "User is able to enter valid input in the City text field");
	
		//clear the city field
		df.ClearTextField(df.getCityfield());
	}
	@Test(dependsOnMethods = "TC_043VerifyCityTextFieldAcceptsInput")
	public void TC_044VerifyCityTextFiledAccepptsalphabets() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getCityfield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 17, 2);
		df.getCityfield().sendKeys(input);
		String cityInField = df.getCityfield().getAttribute("value");
		if(input != null && input.equals(cityInField)) {

			System.out.println("City text field accepts alphabets :PASS");
			utilityclassobject.gettest().log(Status.PASS, "City text field accepts alphabets");
		} else {
			System.out.println("City text field does not accept alphabets :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "City text field does not accept alphabets");
		}
		df.ClearTextField(df.getCityfield());
	}
	@Test(dependsOnMethods = "TC_044VerifyCityTextFiledAccepptsalphabets")
	public void TC_045VerifyCityTextFiledAccepptsNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getCityfield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 17, 3);
		df.getCityfield().sendKeys(input);
		String cityInField = df.getCityfield().getAttribute("value");
		if(input != null && input.equals(cityInField)) {

			
			
			System.out.println("City text field accepts numbers :PASS");
			utilityclassobject.gettest().log(Status.PASS, "City text field accepts numbers");
		} else {
			System.out.println("City text field does not accept numbers :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "City text field does not accept numbers");
		}
		df.ClearTextField(df.getCityfield());
	}
	@Test(dependsOnMethods = "TC_045VerifyCityTextFiledAccepptsNumbers")
	public void TC_046VerifyCityTextFiledAccepptsSpecialCharacters() throws EncryptedDocumentException, IOException, InterruptedException {
		df.getCityfield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 17, 4);
		df.getCityfield().sendKeys(input);
		String cityInField = df.getCityfield().getAttribute("value");
		if(input != null && input.equals(cityInField)) {

			System.out.println("City text field accepts special characters :PASS");
			utilityclassobject.gettest().log(Status.PASS, "City text field accepts special characters");
		} else {
			System.out.println("City text field does not accept special characters :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "City text field does not accept special characters");
		}
		df.ClearTextField(df.getCityfield());
	}
	
	@Test(dependsOnMethods = "TC_046VerifyCityTextFiledAccepptsSpecialCharacters")
	public void TC_047VerifyCityTextfieldisMandatoryField() throws EncryptedDocumentException, IOException, InterruptedException {
		// Clear field and click outside (blur) to trigger validation — required to make error message appear
		String input = elib.getDataFromExcel("Disposal Facillity", 17, 4);
		df.getCityfield().sendKeys(input);
		df.getCityfield().click();
		df.getCityfield().sendKeys(Keys.CONTROL + "a");
		df.getCityfield().sendKeys(Keys.DELETE);
		df.getNametext().click(); // click outside the city field to trigger blur validation
		System.out.println("Cleared City field and clicked outside to trigger validation");
		utilityclassobject.gettest().log(Status.INFO, "Cleared City field and clicked outside to trigger validation");
		WebElement cityErr = df.getCityfielderrormsg(); // returns null if not visible (safeGet)
		if(cityErr != null && cityErr.isDisplayed()) {
			System.out.println("City text field shows error message as Please Enter City :PASS");
			utilityclassobject.gettest().log(Status.PASS, "City text field shows error message as Please Enter City");
		} else {
			System.out.println("City text field does not show error message for mandatory field :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "City text field does not show error message for mandatory field");
		}
	}
	@Test(dependsOnMethods = "TC_047VerifyCityTextfieldisMandatoryField")
	public void TC_048VerifyAutosavesCityData() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//write code just give one back space 
		df.getCityfield().click();
		//clear the entire field
		df.ClearTextField(df.getCityfield());
			
		//again add that removed word
		df.getCityfield().click();

		String input = elib.getDataFromExcel("Disposal Facillity", 17, 1);
		df.getCityfield().sendKeys(input);
		
		//verify it should display Autosaved treatment details  message in right corner of the page
		df.getNametext().click(); // click outside the city field to trigger blur validation
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement autosaveMessage = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//*[contains(text(),'Autosaved treatment details')]")
		        ));

		if (autosaveMessage.isDisplayed()) {
		    System.out.println("PASS: Autosaved treatment details message is displayed.");
		    utilityclassobject.gettest().log(Status.PASS,
		            "Autosaved treatment details message is displayed.");
		} else {
		    System.out.println("FAIL: Autosaved treatment details message is not displayed.");
		    utilityclassobject.gettest().log(Status.FAIL,
		            "Autosaved treatment details message is not displayed.");
		
		}	
	}
	@Test(dependsOnMethods = "TC_048VerifyAutosavesCityData")
	public void TC_049VerifyStateTextFieldAcceptsInput() throws EncryptedDocumentException, IOException, InterruptedException {
		//write code for try to pass input inside text field and make sure that it should not accept any input 
	df.getStatefield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 19, 1);
		df.getStatefield().sendKeys(input);
		//verify that it should not accept any input
		String stateInField = df.getStatefield().getAttribute("value");
		if(stateInField != null && stateInField.equals(input)) {
			System.out.println("State text field accepts input :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "State text field accepts input");
		} else {
			System.out.println("State text field does not  accepts input :PASS");
			utilityclassobject.gettest().log(Status.PASS, "State text field does not accepts input");
		}
	}
	@Test(dependsOnMethods = "TC_049VerifyStateTextFieldAcceptsInput")
	public void TC_050VerifyStateOptonsPresentIntheoptions() throws EncryptedDocumentException, IOException, InterruptedException {
		List<WebElement> options = df.getStatefieldoptions();
		for(WebElement option : options) {
			System.out.println("State option: " + option.getText());
			utilityclassobject.gettest().log(Status.INFO, "State option: " + option.getText());
		}
		System.out.println("Total number of state options: " + options.size());
		utilityclassobject.gettest().log(Status.INFO, "Total number of state options: " + options.size());
		System.out.println("State options are present in the dropdown :PASS");
		utilityclassobject.gettest().log(Status.PASS, "State options are present in the dropdown");
		
		
		
	}
	@Test(dependsOnMethods = "TC_050VerifyStateOptonsPresentIntheoptions")
	public void TC_051VerifyUserAbletoSelectStateFromDropdown() throws EncryptedDocumentException, IOException, InterruptedException {
		//select any state from the dropdown
		List<WebElement> options = df.getStatefieldoptions();
		String selectedState = "";
		for(WebElement option : options) {
			selectedState = option.getText();
			option.click();
			System.out.println("Selected state: " + selectedState);
			utilityclassobject.gettest().log(Status.INFO, "Selected state: " + selectedState);
			break; // select the first option and exit the loop
		}
	System.out.println("User is able to select state from the dropdown :PASS");
	utilityclassobject.gettest().log(Status.PASS, "User is able to select state from the dropdown");
	}

		@Test(dependsOnMethods = "TC_051VerifyUserAbletoSelectStateFromDropdown")
		public void TC_052VerifyUserCanproceedWithoutStateField() throws EncryptedDocumentException, IOException, InterruptedException {
		//not able to clear the state field
			
		}
		
		
		@Test(dependsOnMethods = "TC_052VerifyUserCanproceedWithoutStateField")
		public void TC_053VerifyZipcodeTextFieldAcceptsInput() throws EncryptedDocumentException, IOException, InterruptedException {
			//verify zipcode field accepts inputs
			df.getZipfield().click();
			String input = elib.getDataFromExcel("Disposal Facillity", 21, 1);
			df.getZipfield().sendKeys(input);
			String zipInField = df.getZipfield().getDomProperty("value");
				System.out.println("User is able to enter valid input in the Zipcode text field :PASS");
				utilityclassobject.gettest().log(Status.PASS, "User is able to enter valid input in the Zipcode text field");
			
			//clear the zipcode field
			df.ClearTextField(df.getZipfield());
		}
		@Test(dependsOnMethods = "TC_053VerifyZipcodeTextFieldAcceptsInput")
		public void TC_054VerifyZipcodeTextFiledAccepptsAlphabets() throws EncryptedDocumentException, IOException, InterruptedException {
			
			df.getZipfield().click();
			String input = elib.getDataFromExcel("Disposal Facillity", 21, 2);
			df.getZipfield().sendKeys(input);
			String zipInField = df.getZipfield().getAttribute("value");
			if(input != null && input.equals(zipInField)) {

				System.out.println("Zipcode text field accepts alphabets :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Zipcode text field accepts alphabets");
			} else {
				System.out.println("Zipcode text field does not accept alphabets :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Zipcode text field does not accept alphabets");
			}
			df.ClearTextField(df.getZipfield());
		}
			
		@Test(dependsOnMethods = "TC_054VerifyZipcodeTextFiledAccepptsAlphabets")
		public void TC_055VerifyZipcodeTextFiledAccepptsNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
			df.getZipfield().click();
			String input = elib.getDataFromExcel("Disposal Facillity", 21, 3);
			df.getZipfield().sendKeys(input);
			String zipInField = df.getZipfield().getAttribute("value");
			if(input != null && input.equals(zipInField)) {

				System.out.println("Zipcode text field accepts numbers :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Zipcode text field accepts numbers");
			} else {
				System.out.println("Zipcode text field does not accept numbers :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Zipcode text field does not accept numbers");
			}
			df.ClearTextField(df.getZipfield());
		}
		@Test(dependsOnMethods = "TC_055VerifyZipcodeTextFiledAccepptsNumbers")
		public void TC_056VerifyZipcodeTextFiledAccepptsSpecialCharacters() throws EncryptedDocumentException, IOException, InterruptedException {
			df.getZipfield().click();
			String input = elib.getDataFromExcel("Disposal Facillity", 21, 4);
			df.getZipfield().sendKeys(input);
			String zipInField = df.getZipfield().getAttribute("value");
				if(input != null && input.equals(zipInField)) {
					
				System.out.println("Zipcode text field accepts special characters :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Zipcode text field accepts special characters");
			} else {	
				System.out.println("Zipcode text field does not accept special characters :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Zipcode text field does not accept special characters");
			}
			//df.ClearTextField(df.getZipfield());
		}
	@Test(dependsOnMethods = "TC_056VerifyZipcodeTextFiledAccepptsSpecialCharacters")
	public void TC_057VerifyZipcodeTextfieldisDisplayZipmustbenumeric() throws EncryptedDocumentException, IOException, InterruptedException {
		//pass alphabets inside the zipcode field and click outside to trigger validation
		df.getNametext().click();
		try {
			if(df.getZipfielderrormsg().isDisplayed()) {
				System.out.println("Zipcode text field prompted error message :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Zipcode text field prompted error message");
			} else {
				System.out.println("Zipcode text field is not displayed error message:FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Zipcode text field is not displayed error message");
			}
		} catch (Exception e) {
			System.out.println("Zipcode text field is not displayed error message:FAIL - " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "Zipcode text field is not displayed error message: " + e.getMessage());
		}
		df.ClearTextField(df.getZipfield());
		// Clear the zipcode field using backspace key
		df.getZipfield().click();
		// Select all text using chord (correct way to send Ctrl+A in Selenium)
		df.getZipfield().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		df.getZipfield().sendKeys(Keys.BACK_SPACE);
		System.out.println("Cleared Zipcode field using Ctrl+A chord and Backspace");
		utilityclassobject.gettest().log(Status.INFO, "Cleared Zipcode field using Ctrl+A chord and Backspace");

		// Verify field is actually cleared
		String zipValue = df.getZipfield().getAttribute("value");
		if (zipValue == null || zipValue.isEmpty()) {
			System.out.println("Zipcode field cleared successfully :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Zipcode field cleared successfully");
		} else {
			// Fallback: clear character by character using backspace
			df.getZipfield().sendKeys(Keys.END);
			int length = zipValue.length();
			for (int i = 0; i < length; i++) {
				df.getZipfield().sendKeys(Keys.BACK_SPACE);
			}
			System.out.println("Zipcode field cleared using backspace fallback :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Zipcode field cleared using backspace fallback");
		}
		df.getNametext().click(); // click outside the zipcode field to trigger blur validation
		//again clear the zipfield
		df.ClearTextField(df.getZipfield());
		df.getZipfieldtext().click();

		
	}
	@Test(dependsOnMethods = "TC_057VerifyZipcodeTextfieldisDisplayZipmustbenumeric")
	public void TC_058VerifyZipcodeisMandatory() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
	//Not able to clear zip field
		
		
		
		
		
		
		
		
	}
	@Test(dependsOnMethods = "TC_058VerifyZipcodeisMandatory")
	public void TC_059VerifyDisposalFaciltyVisibleIntheMap() throws EncryptedDocumentException, IOException, InterruptedException {
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================

		
		
		/*
		// --- Standalone navigation (required for Run / Debug) --- DO NOT REMOVE ---
		df = new DisposalFacilities(driver);
		df.getAssetsDD().click();
		System.out.println("Clicked on Assets Dropdown");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Assets Dropdown");
		df.getDisposalFacilities().click();
		System.out.println("Clicked on Disposal Facilities");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Disposal Facilities");
		Thread.sleep(2000);
		// -------------------------------------------------------------------------

		String targetName = "Jaxon Reed58331";

		// Step 1: Use the search field to filter list - avoids pagination issue
		try {
			WebElement searchInput = driver.findElement(By.xpath(
				"//input[@type='search' or @placeholder='Search' or @placeholder='Search...' or contains(@placeholder,'earch')]"));
			searchInput.clear();
			searchInput.sendKeys(targetName);
			Thread.sleep(1500);
			System.out.println("Typed in search field: " + targetName);
			utilityclassobject.gettest().log(Status.INFO, "Typed in search field: " + targetName);
		} catch (Exception e) {
			System.out.println("No search field found, proceeding without filter: " + e.getMessage());
		}

		// Step 2: Find the element directly by text - no loop needed
	
		
		// Tries multiple XPath patterns to match the actual DOM
		String[] xpaths = {
			"//*[normalize-space(text())='" + targetName + "']/ancestor::a[1]",
			"//a[.//*[normalize-space(text())='" + targetName + "']]",
			"//*[normalize-space(text())='" + targetName + "']",
			"//*[contains(text(),'" + targetName + "')]/ancestor::a[1]",
			"//*[contains(text(),'" + targetName + "')]"
		};

		boolean clicked = false;
		for (String xpath : xpaths) {
			try {
				WebElement el = driver.findElement(By.xpath(xpath));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
				Thread.sleep(500);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
				System.out.println("Clicked '" + targetName + "' using XPath: " + xpath + " :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Clicked Disposal Facility: " + targetName);
				clicked = true;
				break;
			} catch (Exception e) {
				System.out.println("XPath failed [" + xpath + "]: " + e.getMessage());
			}
		}

		if (!clicked) {
			System.out.println("Could not find '" + targetName + "' in the list :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Could not find Disposal Facility: " + targetName);
		}
		
		*/
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================
		//=========================Comment it utilize this for single Tc execution=========================
      
		
		
		//scroll to map
		Thread.sleep(2000);
		wlib.scrollToelement(driver, df.getMapfromDisposalfacilty());
		if(df.getMapmarker().isDisplayed()) {
			System.out.println("Disposal facility is Visible in the Map :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Disposal facility is Visible in the Map");
		} else {
			System.out.println("Disposal facility is not Visible in the Map :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Disposal facility is not Visible in the Map");
		}
		
		
	}
	@Test(dependsOnMethods = "TC_059VerifyDisposalFaciltyVisibleIntheMap")
	public void TC_060VerifyUserIsableToDragtheMapMarker() throws EncryptedDocumentException, IOException, InterruptedException {
		//scroll to map
		wlib.scrollToelement(driver, df.getMapfromDisposalfacilty());
		Actions actions = new Actions(driver);
		WebElement marker = df.getMapmarker();
		Point originalLocation = marker.getLocation();
		int xOffset = 50; // pixels to move right
		int yOffset = 50; // pixels to move down
		actions.dragAndDropBy(marker, xOffset, yOffset).perform();
		Thread.sleep(2000); // wait for the action to complete
		Point newLocation = marker.getLocation();
		if (!originalLocation.equals(newLocation)) {
			System.out.println("User is able to drag the map marker :PASS");
			utilityclassobject.gettest().log(Status.PASS, "User is able to drag the map marker");
		} else {
			System.out.println("User is not able to drag the map marker :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "User is not able to drag the map marker");
		}
	}
	@Test(dependsOnMethods = "TC_060VerifyUserIsableToDragtheMapMarker")	
	public void TC_061VerifyUserIsAbleToPAsstheValueInsidePhoneTextField() throws EncryptedDocumentException, IOException
	{
		
		df.getPhonefield().click();
		elib=new ExcelUtility();
		String input = elib.getDataFromExcel("Disposal Facillity", 23, 1);
		df.getPhonefield().sendKeys(input);
		String phoneInField = df.getPhonefield().getAttribute("value");
		if( input.contains(phoneInField)) {

			System.out.println("Phone text field accepts valid input :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone text field accepts valid input");
		} else {
			System.out.println("Phone text field does not accept valid input :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Phone text field does not accept valid input");
		}
		df.ClearTextField(df.getPhonefield());
	}
		
	@Test(dependsOnMethods = "TC_061VerifyUserIsAbleToPAsstheValueInsidePhoneTextField")
	public void TC_062VerifyUserIsAbleToPassAlpabetsInsideTextField() throws EncryptedDocumentException, IOException
	{
		
		
		df.getPhonefield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 23, 2);
		df.getPhonefield().sendKeys(input);
		String phoneInField = df.getPhonefield().getAttribute("value");
		if(input != null && input.equals(phoneInField)) {

			System.out.println("Phone text field accepts alphabets :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Phone text field accepts alphabets");
		} else {
			System.out.println("Phone text field does not accept alphabets :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone text field does not accept alphabets");
		}
		df.ClearTextField(df.getPhonefield());
	}
	
	@Test(dependsOnMethods = "TC_062VerifyUserIsAbleToPassAlpabetsInsideTextField")
	public void TC_063VerifyUserISAbleToPassNumbersInsideTextField() throws EncryptedDocumentException, IOException
	{
		df.getPhonefield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 23, 3);
		df.getPhonefield().sendKeys(input);
		String phoneInField = df.getPhonefield().getAttribute("value");
		if(input != null && input.equals(phoneInField)) {

			System.out.println("Phone text field accepts numbers :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone text field accepts numbers");
		} else {
			System.out.println("Phone text field does not accept numbers :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Phone text field does not accept numbers");
				
		
		}
	}
	@Test(dependsOnMethods = "TC_063VerifyUserISAbleToPassNumbersInsideTextField")
	public void TC_064VerifyUserISAbleToPassSpecialCharactersInsideTextField() throws EncryptedDocumentException, IOException
	{
		df.getPhonefield().click();
		String input = elib.getDataFromExcel("Disposal Facillity", 23, 4);
		df.getPhonefield().sendKeys(input);
		String phoneInField = df.getPhonefield().getAttribute("value");
		if(input != null && input.equals(phoneInField)) {

			System.out.println("Phone text field accepts special characters :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Phone text field accepts special characters");
		} else {
			System.out.println("Phone text field does not accept special characters :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Phone text field does not accept special characters");
				
		
		}
		//clear text field
		df.ClearTextField(df.getPhonefield());

	}
		@Test(dependsOnMethods = "TC_064VerifyUserISAbleToPassSpecialCharactersInsideTextField")
		public void TC_065VerifyUserISAbleToPassBlankInsideTextField() throws EncryptedDocumentException, IOException
		{
			df.getNametext().click();
				try {
					if(df.getPhonefielderrormsg().isDisplayed()) {
						System.out.println("Phone text field prompted error message :PASS");
						utilityclassobject.gettest().log(Status.PASS, "Phone text field prompted error message");
					} else {
						System.out.println("Phone text field is not displayed error message:FAIL");
						utilityclassobject.gettest().log(Status.FAIL, "Phone text field is not displayed error message");
					}
				} catch (Exception e) {
					System.out.println("Phone text field is not displayed error message:FAIL - " + e.getMessage());
					utilityclassobject.gettest().log(Status.FAIL, "Phone text field is not displayed error message: " + e.getMessage());
				}
		}
			@Test(dependsOnMethods = "TC_065VerifyUserISAbleToPassBlankInsideTextField")
			public void TC_066VerifyPhoneExtFieldAcceptsInput() throws EncryptedDocumentException, IOException, InterruptedException {
				df.getPhoneextfield().click();
				String input = elib.getDataFromExcel("Disposal Facillity", 25, 1);
				df.getPhoneextfield().sendKeys(input);
				String phoneextInField = df.getPhoneextfield().getAttribute("value");
				if(input != null && input.equals(phoneextInField)) {

					System.out.println("Phone Ext text field accepts valid input :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field accepts valid input");
				} else {
					System.out.println("Phone Ext text field does not accept valid input :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field does not accept valid input");
				}
				//clear the phone ext field
				df.ClearTextField(df.getPhoneextfield());
			
			}
			@Test(dependsOnMethods = "TC_066VerifyPhoneExtFieldAcceptsInput")
			public void TC_067VerifyPhoneExtFieldAcceptsAlphabets() throws EncryptedDocumentException, IOException, InterruptedException {
				df.getPhoneextfield().click();
				String input = elib.getDataFromExcel("Disposal Facillity", 25, 2);
				df.getPhoneextfield().sendKeys(input);
				String phoneextInField = df.getPhoneextfield().getAttribute("value");
				if(input != null && input.equals(phoneextInField)) {

					System.out.println("Phone Ext text field accepts alphabets :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field accepts alphabets");
				} else {
					System.out.println("Phone Ext text field does not accept alphabets :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field does not accept alphabets");
				}
				//clear the phone ext field
				df.ClearTextField(df.getPhoneextfield());
			}

			@Test(dependsOnMethods = "TC_067VerifyPhoneExtFieldAcceptsAlphabets")
			public void TC_068VerifyPhoneExtFieldAcceptsNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
				df.getPhoneextfield().click();
				String input = elib.getDataFromExcel("Disposal Facillity", 25, 3);
				df.getPhoneextfield().sendKeys(input);
				String phoneextInField = df.getPhoneextfield().getAttribute("value");
				if(input != null && input.equals(phoneextInField)) {

					System.out.println("Phone Ext text field accepts numbers :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field accepts numbers");
				} else {
					System.out.println("Phone Ext text field does not accept numbers :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field does not accept numbers");
				}
				//clear the phone ext field
				df.ClearTextField(df.getPhoneextfield());
			}
			@Test(dependsOnMethods = "TC_068VerifyPhoneExtFieldAcceptsNumbers")
			public void TC_069VerifyPhoneExtFieldAcceptsSpecialCharacters() throws EncryptedDocumentException, IOException, InterruptedException {
				df.getPhoneextfield().click();
				String input = elib.getDataFromExcel("Disposal Facillity", 25, 4);
				df.getPhoneextfield().sendKeys(input);
				String phoneextInField = df.getPhoneextfield().getAttribute("value");
				if(input != null && input.equals(phoneextInField)) {

					System.out.println("Phone Ext text field accepts special characters :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field accepts special characters");
				} else {
					System.out.println("Phone Ext text field does not accept special characters :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field does not accept special characters");
				}
				//clear the phone ext field
				df.ClearTextField(df.getPhoneextfield());
			}
			@Test(dependsOnMethods = "TC_069VerifyPhoneExtFieldAcceptsSpecialCharacters")
			public void TC_070VerifyPhoneExtFieldNotAcceptsMoreThan5digits() throws EncryptedDocumentException, IOException, InterruptedException {
				
				df.getPhoneextfield().click();
				String input = elib.getDataFromExcel("Disposal Facillity", 25, 5);
				df.getPhoneextfield().sendKeys(input);
				String phoneextInField = df.getPhoneextfield().getAttribute("value");
				if(phoneextInField.length() <= 5) {

					System.out.println("Phone Ext text field does not accept more than 5 digits :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field does not accept more than 5 digits");
				} else {
					System.out.println("Phone Ext text field accepts more than 5 digits :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field accepts more than 5 digits");
				}
				//clear the phone ext field
				df.ClearTextField(df.getPhoneextfield());
			
				
				
				
			}
			@Test(dependsOnMethods = "TC_070VerifyPhoneExtFieldNotAcceptsMoreThan5digits")
			public void TC_071VerifyPhoneExtFieldNotAcceptsShortInput() throws EncryptedDocumentException, IOException, InterruptedException {
				
				df.getPhoneextfield().click();

				String input = elib.getDataFromExcel("Disposal Facillity", 25, 5);
				df.getPhoneextfield().sendKeys(input);
				String phoneextInField = df.getPhoneextfield().getAttribute("value");
				if(phoneextInField.length() <= 5) {

					System.out.println("Phone Ext text field does not accept more than 5 digits :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field does not accept more than 5 digits");
				} else {
					System.out.println("Phone Ext text field accepts more than 5 digits :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Phone Ext text field accepts more than 5 digits");
				}
				//clear the phone ext field
				df.ClearTextField(df.getPhoneextfield());
			
			}
			@Test(dependsOnMethods = "TC_071VerifyPhoneExtFieldNotAcceptsShortInput")
			public void TC_072VerifyPhoneExtFieldWithoutInput() throws EncryptedDocumentException, IOException, InterruptedException {
				df.getNametext().click();
					System.out.println("Phone Ext text field is  not mandatory field :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone Ext text field is not mandatory field");
					
			}
			@Test(dependsOnMethods = "TC_072VerifyPhoneExtFieldWithoutInput")
			public void TC_073VerifyUserisAbletoPassInputInsideDisposalFacilityDropdown() throws EncryptedDocumentException, IOException, InterruptedException {
			
				df.getDisposalFacilityStatusdropdown().click();
				String input = elib.getDataFromExcel("Disposal Facillity", 27, 1);
				df.getDisposalFacilityStatusdropdown().sendKeys(input);
				if(input != null && input.equals(df.getDisposalFacilityStatusdropdown().getAttribute("value"))) {

					System.out.println("Disposal Facility dropdown accepts valid input :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Disposal Facility dropdown accepts valid input");
				} else {
					System.out.println("Disposal Facility dropdown does not accept valid input :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Disposal Facility dropdown does not accept valid input");
				}

				
			}
			@Test(dependsOnMethods = "TC_073VerifyUserisAbletoPassInputInsideDisposalFacilityDropdown")
			public void TC_074VerifyListofOptionsFromDisposalFaciltyDropdown() throws EncryptedDocumentException, IOException, InterruptedException {
				//select any option from the dropdown
				df.getDisposalFacilityStatusdropdown().click();
				List<WebElement> options = df.getDisposalFacilityStatusoptions();
				String selectedOption = "";
				for(WebElement option : options) {
					selectedOption = option.getText();
					//option.click();
					System.out.println("Selected option: " + selectedOption);
					utilityclassobject.gettest().log(Status.INFO, "Selected option: " + selectedOption);
					break; // select the first option and exit the loop
				}
			}
			@Test(dependsOnMethods = "TC_074VerifyListofOptionsFromDisposalFaciltyDropdown")
			public void TC_075VerifyUserIsAbleToSelectOptionFromDisposalFacilityDropdown() throws EncryptedDocumentException, IOException, InterruptedException {
				//select 2nd option from the dropdown
			  wlib.scrollToelement(driver, df.getDisposalFacilityStatusdropdown());
				df.getDisposalFacilityStatusdropdown().click();
				List<WebElement> options = df.getDisposalFacilityStatusoptions();
				String selectedOption = "";
				if(options.size() > 1) {
					selectedOption = options.get(1).getText();
					options.get(1).click();
					System.out.println("Selected option: " + selectedOption);
					utilityclassobject.gettest().log(Status.INFO, "Selected option: " + selectedOption);
				} else {
					System.out.println("Not enough options to select the second one.");
					utilityclassobject.gettest().log(Status.WARNING, "Not enough options to select the second one.");
				}
				//again change bac to 1st option
				df.getDisposalFacilityStatusdropdown().click();
				if(options.size() > 0) {
					selectedOption = options.get(0).getText();
					options.get(0).click();
					System.out.println("Changed back to first option: " + selectedOption);
					utilityclassobject.gettest().log(Status.INFO, "Changed back to first option: " + selectedOption);
				} else {
					System.out.println("No options available to select.");
					utilityclassobject.gettest().log(Status.WARNING, "No options available to select.");
				}
			}
			
			@Test(dependsOnMethods = "TC_075VerifyUserIsAbleToSelectOptionFromDisposalFacilityDropdown")
			public void TC_076VerifyUserIsAbleToChangeTheStatusIftheStatusIsActive() throws EncryptedDocumentException, IOException, InterruptedException {
			    df.getStreetfield().clear();
				df.getStreetfield().sendKeys("fjkbfkj");
				df.getCityfield().clear();
				df.getCityfield().sendKeys("jbfkjbf");
				df.getZipfield().clear();
				df.getZipfield().sendKeys("123");
				//scroll to Disposal facility dropdown  select 1st option from disposal facility dropdown
				wlib.scrollToelement(driver, df.getDisposalFacilityStatusdropdown());
				df.getDisposalFacilityStatusdropdown().click();
				df.getDisposalFacilityStatusoptions().get(0).click();
				df.getNametext().click(); // click outside to trigger any potential validation
				df.getPhonefield().sendKeys("5689745896");
				//verify it should display Autosaved treatment details  message in right corner of the page
				
				
				System.out.println("Npt prompting Any Mesage");
				utilityclassobject.gettest().log(Status.INFO, "Not prompting Any Message");
				//it is not prompting Anything
				//it is not prompting Anything
				//it is not prompting Anything


				
			
			}
			@Test(dependsOnMethods = "TC_076VerifyUserIsAbleToChangeTheStatusIftheStatusIsActive")
			public void TC_077VerifyUserIsAbleToChangeTheStatusIftheStatusIsInactive() throws EncryptedDocumentException, IOException, InterruptedException {
			 System.out.println("Manual TC");
			 utilityclassobject.gettest().log(Status.INFO, "Manual TC");
			 
			 
			}
			@Test(dependsOnMethods = "TC_077VerifyUserIsAbleToChangeTheStatusIftheStatusIsInactive")
			public void TC_078VerifyEmail1TextFieldAcceptsAlphabets() throws EncryptedDocumentException, IOException, InterruptedException {
			
			 df.getEmail1field().click();
				String input = elib.getDataFromExcel("Disposal Facillity", 29, 1);
				df.getEmail1field().sendKeys(input);
				if(input != null && input.equals(df.getEmail1field().getAttribute("value"))) {

					System.out.println("Email1 text field accepts alphabets :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Email1 text field accepts alphabets");
				} else {
					System.out.println("Email1 text field does not accept alphabets :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Email1 text field does not accept alphabets");
				}

			 
			 
			}
			@Test(dependsOnMethods = "TC_078VerifyEmail1TextFieldAcceptsAlphabets")
			public void TC_079VerifyEmail1TextFieldAcceptsNumbers() throws EncryptedDocumentException, IOException, InterruptedException {
				 df.getEmail1field().click();
					String input = elib.getDataFromExcel("Disposal Facillity", 29, 2);
					df.getEmail1field().sendKeys(input);
					if(input != null && input.equals(df.getEmail1field().getAttribute("value"))) {

						System.out.println("Email1 text field accepts numbers :FAIL");
						utilityclassobject.gettest().log(Status.FAIL, "Email1 text field accepts numbers");
					} else {
						System.out.println("Email1 text field does not accept numbers :PASS");
						utilityclassobject.gettest().log(Status.PASS, "Email1 text field does not accept numbers");
					}
			}
			@Test(dependsOnMethods = "TC_079VerifyEmail1TextFieldAcceptsNumbers")
			public void TC_080VerifyEmail1TextFieldAcceptsSpecialCharacters() throws EncryptedDocumentException, IOException, InterruptedException {
				 df.getEmail1field().click();
					String input = elib.getDataFromExcel("Disposal Facillity", 29, 3);
					df.getEmail1field().sendKeys(input);
					if(input != null && input.equals(df.getEmail1field().getAttribute("value"))) {

						System.out.println("Email1 text field accepts special characters :FAIL");
						utilityclassobject.gettest().log(Status.FAIL, "Email1 text field accepts special characters");
					} else {
						System.out.println("Email1 text field does not accept special characters :PASS");
						utilityclassobject.gettest().log(Status.PASS, "Email1 text field does not accept special characters");
					}
					df.ClearTextField(df.getEmail1field());
			}
			@Test(dependsOnMethods = "TC_080VerifyEmail1TextFieldAcceptsSpecialCharacters")
			public void TC_081VerifyEmail1TextFieldisMandatoryField() throws EncryptedDocumentException, IOException, InterruptedException {
				
			if(df.getEmail1fielderrormsg().isDisplayed()) {
				System.out.println("Email1 text field is mandatory field :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Email1 text field is mandatory field");
			} else {
				System.out.println("Email1 text field is not mandatory field :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Email1 text field is not mandatory field");
				
			}
			}
			
}
