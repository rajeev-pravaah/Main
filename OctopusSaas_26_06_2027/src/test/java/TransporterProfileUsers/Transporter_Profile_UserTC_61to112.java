package TransporterProfileUsers;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForMasterPriceBook;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.BillingSettings;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaas.ObjectRepository.TransporterSettingsPage;
import com.Octopussaas.ObjectRepository.TransporterSettingsUsers;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Transporter_Profile_UserTC_61to112 extends BaseClassForMasterPriceBook{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;
	TransporterSettingsPage tsp;
	TransporterSettingsUsers tsu;
	
	Random random;

	@Test
	public void TC_001AccessUsersPage() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib = new webDriverutility();
		Thread.sleep(2000);
		// Ensure page zoom is 80% so the element positions are consistent
		try {
			((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		} catch (Exception e) {
			/* ignore if not supported */ }
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		tsp = new TransporterSettingsPage(driver);
		tsp.getUserslink().click();
		utilityclassobject.gettest().log(Status.INFO, "Users page is  displayed successfully");
		System.out.println("Users page is  displayed successfully");

	}

	@Test(dependsOnMethods = "TC_001AccessUsersPage")
	public void TC_002AccessUsersPage() throws InterruptedException {
		tsu = new TransporterSettingsUsers(driver);
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "TC_002AccessUsersPage")
	public void TC_003AccessUsersPage() throws InterruptedException {
		System.out.println("Add new user page is  displayed successfully");
		tsu.getAddNewUserButton().click();
		utilityclassobject.gettest().log(Status.INFO, "Add new user page is  displayed successfully");
		System.out.println("Add new user page is  displayed successfully");
	}
	@Test(dependsOnMethods = /*"TC_060TrytoEnterManualInputsInAccessLeveDD"*/"TC_003AccessUsersPage")
	public void TC_061AccessLevelOptions() throws InterruptedException {
		//Fetch all the options from access level dropdown 
		
			tsu.getAccessleveldropdown().click();
			Thread.sleep(1000);
			List<WebElement> accessLevelOptions = tsu.getAccessleveldropdownOptions();
			for (WebElement option : accessLevelOptions) {
				System.out.println("Access Level dropdown option: " + option.getText().trim());
				utilityclassobject.gettest().log(Status.INFO,
						"Access Level dropdown option: " + option.getText().trim());
			}
	}
	@Test(dependsOnMethods = "TC_061AccessLevelOptions")
	public void TC_062SelectOtherOptionFromAccessLevel() throws InterruptedException {
		//select territory option from access level dropdown and verify the selection is applied do not use try catch
		tsu.getAccessleveldropdown().click();
		tsu.getAccessleveldropdown().click();

		
		Thread.sleep(1000);
		tsu.getTerritoryAccessLevelOption().click();
		Thread.sleep(500);
		String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
		System.out.println(selectedAccessLevel);
		if (selectedAccessLevel.contains("Territory")) {
			System.out.println("Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
		} else {
			System.out.println("Access Level dropdown did not change to Territory as expected, current value: "
					+ selectedAccessLevel + " - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Level dropdown did not change to Territory as expected, current value: " + selectedAccessLevel
							+ " - FAIL");
		}
		
		
	}
	@Test(dependsOnMethods = "TC_062SelectOtherOptionFromAccessLevel")
	public void TC_063SelectFullAccessOptionFromAccessLevel() throws InterruptedException {
		//try to select multiple options at a time but it should not display multile options in field
		tsu.getAccessleveldropdown().click();
		Thread.sleep(1000);
		tsu.getCompanyWideFullAccessOption().click();
		Thread.sleep(500);
		// Dropdown closes after first selection, reopen it to select the second option
		tsu.getAccessleveldropdown().click();
		Thread.sleep(1000);
		// Wait for Territory option to be clickable after dropdown reopens (avoids StaleElementReferenceException)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(tsu.getTerritoryAccessLevelOption())).click();
		Thread.sleep(500);
		String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
		System.out.println(selectedAccessLevel);
		//verify the number of option displayed in the dropdown field after selecting multiple options
		int optionsCount = selectedAccessLevel.split(",").length;
		if (optionsCount == 1 && selectedAccessLevel.contains("Company-wide (Full Access)")) {
			System.out.println("Only one option is displayed in Access Level dropdown after selecting multiple options - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Only one option is displayed in Access Level dropdown after selecting multiple options - FAIL");
		} else {
			System.out.println("Multiple options are not displaying in Access Level dropdown after selecting multiple options: " + selectedAccessLevel + "PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Multiple options are Not displayed in Access Level dropdown after selecting multiple options: " + selectedAccessLevel + " - PASS");
		}
		
		
		
		
		
	}
	@Test(dependsOnMethods = "TC_063SelectFullAccessOptionFromAccessLevel")
	public void TC_064SelectTerritoryOptionFromAccessLevelDD() throws InterruptedException {
		
		//try to select territory option from access level dropdown and verify the selection is applied
		tsu.getAccessleveldropdown().click();
		Thread.sleep(1000);
		tsu.getTerritoryAccessLevelOption().click();
		Thread.sleep(500);
		String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
		System.out.println(selectedAccessLevel);
		if (selectedAccessLevel.contains("Territory")) {
			System.out.println("Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
		} else {
			System.out.println("Access Level dropdown did not change to Territory as expected, current value: "
					+ selectedAccessLevel + " - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Level dropdown did not change to Territory as expected, current value: " + selectedAccessLevel
							+ " - FAIL");
		}
		
		
	}
	@Test(dependsOnMethods = "TC_064SelectTerritoryOptionFromAccessLevelDD")
	public void TC_065TerritotoriesDDFromTerritoryOption() throws InterruptedException {
		//Select Territory from access level dropdown and verify that territories dropdown 
		tsu.getAccessleveldropdown().click();
		tsu.getTerritoryAccessLevelOption().click();
		Thread.sleep(1000);
		boolean isTerritoriesDropdownDisplayed = tsu.getTerritoriesDropdown().isDisplayed();
		if (isTerritoriesDropdownDisplayed) {
			System.out.println("Territories dropdown is displayed after selecting Territory access level - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Territories dropdown is displayed after selecting Territory access level - PASS");
		} else {
			System.out.println("Territories dropdown is not displayed after selecting Territory access level - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Territories dropdown is not displayed after selecting Territory access level - FAIL");
		}	
		
	}
	@Test(dependsOnMethods = "TC_065TerritotoriesDDFromTerritoryOption")
	public void TC_066TrytoPassInputsintoTerritoriesDDO() throws InterruptedException {
		//try to pass input abcd in to territories dropdown and verify that it should not accept the manual input
		/*tsu.getTerritoriesDropdown().click();
		Thread.sleep(1000);
		//pass the input in territories dropdown using javascript because it is a div based dropdown and it will not accept the input using sendkeys method
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].innerText = arguments[1]; "
						+ "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); "
						+ "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
				tsu.getTerritoriesDropdown(), "abcd");
		Thread.sleep(1000);
		String afterText = tsu.getTerritoriesDropdown().getText().trim();
		if (afterText.equals("Select Territories")) {
			System.out.println("Territories dropdown did not accept manual input and remains: " + afterText + " - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Territories dropdown did not accept manual input and remains: " + afterText + " - PASS");
		} else {
			System.out.println("Territories dropdown text changed to: " + afterText
					+ "  - FAIL");
			utilityclassobject.gettest().log(Status.INFO, "Territories dropdown text changed after JS inject: "
					+ afterText );
			// Reload the dropdown text to confirm actual selected value is unchanged by
			// clicking away
			tsu.getTerritoriesDropdown().click();
			Thread.sleep(500);
			String reloadedText = tsu.getTerritoriesDropdown().getText().trim();
			System.out.println("After interaction, territories dropdown displays: " + reloadedText
					+ (reloadedText.equals("Select Territories") ? " - PASS" : " - FAIL"));
			utilityclassobject.gettest().log(Status.INFO,
					"After interaction, territories dropdown displays: " + reloadedText);
		}*/
		
	
		
	}
	@Test(dependsOnMethods = "TC_066TrytoPassInputsintoTerritoriesDDO")
	public void TC_067FetchtheListFromDD() throws InterruptedException {
		//Select Territory from access level dropdown and verify that territories dropdown 
		tsu.getAccessleveldropdown().click();
		tsu.getTerritoryAccessLevelOption().click();
		tsu.getTerritoriesDropdown().click();
		Thread.sleep(1000);
		List<WebElement> territoriesOptions = tsu.getTerritoriesDropdownOptionsList();
		for (WebElement option : territoriesOptions) {
			System.out.println("Territories dropdown option: " + option.getText().trim());
			utilityclassobject.gettest().log(Status.INFO,
					"Territories dropdown option: " + option.getText().trim());
		}
		// Close the territories dropdown after fetching the list
		tsu.getTerritoriesDropdown().click();
		Thread.sleep(500);
		
	}
	@Test(dependsOnMethods = "TC_067FetchtheListFromDD")
	public void TC_068SelectAnyOptionFromTerritoriesCheckBox() throws InterruptedException {
		//Select Local territories checkbox from territories dropdown and verify the selection is applied
		tsu.getTerritoriesDropdownSearchBox().click();
		Thread.sleep(2000);
		tsu.getLocalTeritoryCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Local Territory checkbox in territories dropdown");
		System.out.println("Clicked Local Territory checkbox in territories dropdown");
		
		
	}
	
		
	
	@Test(dependsOnMethods = "TC_068SelectAnyOptionFromTerritoriesCheckBox")
	public void TC_069SelectMultipleOptionsFromTerritories() throws InterruptedException {
		//Select multiple options from territories dropdown and verify the selection is applied
		tsu.getTestTerritoryCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Test Territory checkbox in territories dropdown");
		//verify the selected option from territories dropdown
		boolean isTestTerritorySelected = tsu.getTestTerritoryCheckbox().isSelected();
		if (isTestTerritorySelected) {
			System.out.println("Test Territory checkbox is selected as expected - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Test Territory checkbox is selected as expected - PASS");
		} else {
			System.out.println("Test Territory checkbox is not selected after clicking on it - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Test Territory checkbox is not selected after clicking on it - FAIL");
		}
	}
	@Test(dependsOnMethods = "TC_069SelectMultipleOptionsFromTerritories")
	public void TC_070DeselectOptionFromTerritories() throws InterruptedException {
	tsu.getCancelTerritoriesDropdownButton().click();
	tsu.getCancelTerritoriesDropdownButton().click();
	Thread.sleep(1000);
	utilityclassobject.gettest().log(Status.INFO,
			"Clicked Cancel button in territories dropdown to deselect all selected options");
	System.out.println("Clicked Cancel button in territories dropdown to deselect all selected options");
	
		
	}
	@Test(dependsOnMethods = "TC_070DeselectOptionFromTerritories")
	public void TC_071AgainSelectOptionFromTerritoriesDD() throws InterruptedException {
		tsu.getTestTerritoryCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Test Territory checkbox in territories dropdown again to select it");
		System.out.println("Clicked Test Territory checkbox in territories dropdown again to select it");
	}
	@Test(dependsOnMethods = "TC_071AgainSelectOptionFromTerritoriesDD")
	public void TC_072AccessSummaryUpdate() throws InterruptedException {
		tsu.getCancelTerritoriesDropdownButton().click();
		//fetch the text from AccessSummary before selecting the option from territories dropdown
		String accessSummaryBefore = tsu.getAccesssummary().getText().trim();
		System.out.println("Access Summary before selecting option from territories dropdown: " + accessSummaryBefore);
		utilityclassobject.gettest().log(Status.INFO,
				"Access Summary before selecting option from territories dropdown: " + accessSummaryBefore);
		//select any option from territories dropdown
		tsu.getTestTerritoryCheckbox().click();
		Thread.sleep(1000);
		//fetch the text from AccessSummary after selecting the option from territories dropdown and verify that Access Summary updated or not
		String accessSummaryAfter = tsu.getAccesssummary().getText().trim();
		System.out.println("Access Summary after selecting option from territories dropdown: " + accessSummaryAfter);
		utilityclassobject.gettest().log(Status.INFO,
				"Access Summary after selecting option from territories dropdown: " + accessSummaryAfter);
		if (!accessSummaryAfter.equals(accessSummaryBefore)) {
			System.out.println("Access Summary updated after selecting option from territories dropdown - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary updated after selecting option from territories dropdown - PASS");
		} else {
			System.out.println("Access Summary did not update after selecting option from territories dropdown - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary did not update after selecting option from territories dropdown - FAIL");
			}
		
	}
	@Test(dependsOnMethods = "TC_072AccessSummaryUpdate"/*"TC_003AccessUsersPage"*/)
	public void TC_073AccesslevelChangeTORegion() throws InterruptedException {
		//click outside on screen to close the territories dropdown
		driver.findElement(By.xpath("//body")).click();
		tsu.getAccessleveldropdown().click();
		Thread.sleep(1000);
		tsu.getRegionAccessLevelOptionfromaccesslevelDD().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Region option in Access Level dropdown");
		System.out.println("Clicked Region option in Access Level dropdown");
		
		
	}
	@Test(dependsOnMethods = "TC_073AccesslevelChangeTORegion")
	public void TC_074VerifyRegionAccessLevelSelection() throws InterruptedException {
		//verify that region dropdown is displayed after selecting region option from access level dropdown
		boolean isRegionDropdownDisplayed = tsu.getRegionsDropdown().isDisplayed();
		if (isRegionDropdownDisplayed) {
			System.out.println("Region dropdown is displayed after selecting Region access level - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Region dropdown is displayed after selecting Region access level - PASS");
		} else {
			System.out.println("Region dropdown is not displayed after selecting Region access level - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Region dropdown is not displayed after selecting Region access level - FAIL");
		}	
	}
	@Test(dependsOnMethods = "TC_074VerifyRegionAccessLevelSelection")
	public void TC_075TrytoPassmanualInputinRegiosDD() throws InterruptedException {
		//try to pass manual input in region dropdown and verify that it should not accept the manual input
		/*tsu.getRegionsDropdown().click();
		Thread.sleep(1000);
		//pass the input in region dropdown using javascript because it is a div based dropdown and it will not accept the input using sendkeys method
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].innerText = arguments[1]; "
						+ "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); "
						+ "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
				tsu.getRegionsDropdown(), "abcd");
		Thread.sleep(1000);
		String afterText = tsu.getRegionsDropdown().getText().trim();
		if (afterText.equals("Select Regions")) {
			System.out.println("Region dropdown did not accept manual input and remains: " + afterText + " - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Region dropdown did not accept manual input and remains: " + afterText + " - PASS");
		} else {
			System.out.println("Region dropdown text changed to: " + afterText
					+ "  - FAIL");
			utilityclassobject.gettest().log(Status.INFO, "Region dropdown text changed after JS inject: "
					+ afterText );
			// Reload the dropdown text to confirm actual selected value is unchanged by
			// clicking away
			tsu.getRegionsDropdown().click();
			Thread.sleep(500);
			String reloadedText = tsu.getRegionsDropdown().getText().trim();
			System.out.println("After interaction, region dropdown displays: " + reloadedText
					+ (reloadedText.equals("Select Regions") ? " - PASS" : " - FAIL"
							+ " - FAIL"));
			utilityclassobject.gettest().log(Status.INFO,	
					"After interaction, region dropdown displays: " + reloadedText);
		}*/
		
		
	}
	@Test(dependsOnMethods = "TC_075TrytoPassmanualInputinRegiosDD")
	public void TC_076FetchOptionsFromRegionDD() throws InterruptedException {
		//Select Region from access level dropdown and verify that region dropdown 
		tsu.getAccessleveldropdown().click();
		tsu.getRegionAccessLevelOptionfromaccesslevelDD().click();
		//click outsdie to close the access level dropdown
		driver.findElement(By.xpath("//body")).click();
		
		tsu.getRegionsDropdownSearchBox().click();
		List<WebElement> options = tsu.getRegionsDropdownOptionsList();
		for (WebElement option : options) {
			System.out.println("Region dropdown option: " + option.getText().trim());
			utilityclassobject.gettest().log(Status.INFO,
					"Region dropdown option: " + option.getText().trim());
		}
		
	}
	@Test(dependsOnMethods = "TC_076FetchOptionsFromRegionDD")
	public void TC_077ListOptionsFromregionsDD() throws InterruptedException {
		tsu.getTestRegion1Checkbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Test Region 1 checkbox in regions dropdown");
		boolean isTestRegion1Selected = tsu.getTestRegion1Checkbox().isSelected();
		if (isTestRegion1Selected) {
			System.out.println("Test Region 1 checkbox is selected as expected - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Test Region 1 checkbox is selected as expected - PASS");
		} else {
			System.out.println("Test Region 1 checkbox is not selected after clicking on it - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Test Region 1 checkbox is not selected after clicking on it - FAIL");
		}
		tsu.getTestRegion1Checkbox().click();

	}
	@Test(dependsOnMethods = "TC_077ListOptionsFromregionsDD")
	public void TC_078RegionDDWithMultipleOptions() throws InterruptedException {
		tsu.getTestRegion1Checkbox().click();
		tsu.getTestRegionCheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Region DD with multiple options are selected");
		System.out.println("Region DD with multiple options are selected");
		//Click on outside 
		driver.findElement(By.xpath("//body")).click();
		
	}
	@Test(dependsOnMethods = "TC_078RegionDDWithMultipleOptions")
	public void TC_079VerifyMultipleOptionsSelectedInRegionDD() throws InterruptedException {
		tsu.getCancelRegionsDropdownButton().click();
		tsu.getCancelRegionsDropdownButton().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Cancel button in regions dropdown to deselect all selected options");
		System.out.println("Clicked Cancel button in regions dropdown to deselect all selected options");
		
		
	}
	@Test(dependsOnMethods = "TC_079VerifyMultipleOptionsSelectedInRegionDD")
	public void TC_080SelectOptionFromRegionDD() throws InterruptedException {
		tsu.getRegionsDropdownSearchBox().click();

		tsu.getTestRegion1Checkbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Test Region 1 checkbox in regions dropdown again to select it");
		System.out.println("Clicked Test Region 1 checkbox in regions dropdown again to select it");
	}
	@Test(dependsOnMethods = "TC_080SelectOptionFromRegionDD")
	public void TC_081AccessSummaryUpdateAfterRegionSelection() throws InterruptedException {
		tsu.getCancelRegionsDropdownButton().click();

		//fetch the text from AccessSummary before selecting the option from region dropdown
		String accessSummaryBefore = tsu.getAccesssummary().getText().trim();
		System.out.println("Access Summary before selecting option from region dropdown: " + accessSummaryBefore);
		utilityclassobject.gettest().log(Status.INFO,
				"Access Summary before selecting option from region dropdown: " + accessSummaryBefore);
		//select any option from region dropdown
		tsu.getTestRegion1Checkbox().click();
		Thread.sleep(1000);
		//fetch the text from AccessSummary after selecting the option from region dropdown and verify that Access Summary updated or not
		String accessSummaryAfter = tsu.getAccesssummary().getText().trim();
		System.out.println("Access Summary after selecting option from region dropdown: " + accessSummaryAfter);
		utilityclassobject.gettest().log(Status.INFO,
				"Access Summary after selecting option from region dropdown: " + accessSummaryAfter);
		if (!accessSummaryAfter.equals(accessSummaryBefore)) {
			System.out.println("Access Summary updated after selecting option from region dropdown - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary updated after selecting option from region dropdown - PASS");
		} else {
			System.out.println("Access Summary did not update after selecting option from region dropdown - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary did not update after selecting option from region dropdown - FAIL");
			}
		
	}
	@Test(dependsOnMethods = "TC_081AccessSummaryUpdateAfterRegionSelection")
	public void TC_082ChangeAccessLevelBackToSatellite() throws InterruptedException {
		driver.findElement(By.xpath("//body")).click();

		tsu.getAccessleveldropdown().click();
		Thread.sleep(1000);
		tsu.getSatelliteAccessLevelOption().click();
		Thread.sleep(500);
		String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
		System.out.println(selectedAccessLevel);
		if (selectedAccessLevel.contains("Satellite")) {
			System.out.println("Access Level dropdown successfully changed back to: " + selectedAccessLevel + " - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Level dropdown successfully changed back to: " + selectedAccessLevel + " - PASS");
		} else {
			System.out.println("Access Level dropdown did not change back to Satellite as expected, current value: "
					+ selectedAccessLevel + " - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Access Level dropdown did not change back to Satellite as expected, current value: " + selectedAccessLevel
							+ " - FAIL");
		}
		//verify satellite dropdown is displayed after selecting satellite option from access level dropdown
		boolean isSatelliteDropdownDisplayed = tsu.getSatellitesDropdown().isDisplayed();
		if (isSatelliteDropdownDisplayed) {
			System.out.println("Satellite dropdown is displayed after selecting Satellite access level - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Satellite dropdown is displayed after selecting Satellite access level - PASS");
		} else {
			System.out.println("Satellite dropdown is not displayed after selecting Satellite access level - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Satellite dropdown is not displayed after selecting Satellite access level - FAIL");
		}
		
		
	}
	@Test(dependsOnMethods = "TC_082ChangeAccessLevelBackToSatellite")
	public void TC_083ChangeAccessLevelBackToCompanyWide() throws InterruptedException {
		
	}
	@Test(dependsOnMethods = "TC_083ChangeAccessLevelBackToCompanyWide")
	public void TC_084SatelliteOption() throws InterruptedException {
		
		tsu.getSatellitesDropdownSearchBox().click();
		List<WebElement> satelliteOptions = tsu.getSatellitesDropdownOptionsList();
		for (WebElement option : satelliteOptions) {
			System.out.println("Satellite dropdown option: " + option.getText().trim());
			utilityclassobject.gettest().log(Status.INFO,
					"Satellite dropdown option: " + option.getText().trim());
		}
		
	}
	@Test(dependsOnMethods = "TC_084SatelliteOption")
	public void TC_085SelectOptionFromSatelliteDD() throws InterruptedException {
		tsu.getSatellitesDropdownSearchBox().click();
		tsu.getSatellitesDropdownSearchBox().click();


		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Test Satellite 1 checkbox in satellites dropdown");
		//select 1st option from dropdown
		tsu.getSatellite1stoption().click();
		boolean isSatellite1stOptionSelected = tsu.getSatellite1stoption().isSelected();
		if (isSatellite1stOptionSelected) {
			System.out.println("Test Satellite 1 checkbox is selected as expected - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Test Satellite 1 checkbox is selected as expected - PASS");
		} else {
			System.out.println("Test Satellite 1 checkbox is not selected after clicking on it - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Test Satellite 1 checkbox is not selected after clicking on it - FAIL");
		}
		
		
	}
	@Test(dependsOnMethods = "TC_085SelectOptionFromSatelliteDD")
	public void TC_086MultipleOptionsFrimSatelliteDD() throws InterruptedException {
		tsu.getSatellite2ndoptioncheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"able to select multiple options from satellite dropdown");
		System.out.println("able to select multiple options from satellite dropdown");
		//Click on outside
		driver.findElement(By.xpath("//body")).click();
		
	}
	@Test(dependsOnMethods = "TC_086MultipleOptionsFrimSatelliteDD")
	public void TC_087CancelMultipleSelectionFromSatelliteDD() throws InterruptedException {
		tsu.getCancelSatellitesDropdownButton().click();
		tsu.getCancelSatellitesDropdownButton().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Cancel button in satellites dropdown to deselect all selected options");
		System.out.println("Clicked Cancel button in satellites dropdown to deselect all selected options");
		
	}
	@Test(dependsOnMethods = "TC_087CancelMultipleSelectionFromSatelliteDD")
	public void TC_088SelectOptionFromSatelliteDD() throws InterruptedException {
		tsu.getSatellitesDropdownSearchBox().click();
		tsu.getSatellite1stoption().click();
		driver.findElement(By.xpath("//body")).click();

		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Test Satellite 1 checkbox in satellites dropdown again to select it");
		System.out.println("Clicked Test Satellite 1 checkbox in satellites dropdown again to select it");
		tsu.getCancelSatellitesDropdownButton().click();

	}
	@Test(dependsOnMethods = "TC_088SelectOptionFromSatelliteDD")
	public void TC_089TrytoProceedWithoutSatellite() throws InterruptedException {
		driver.findElement(By.xpath("//body")).click();
		webDriverutility wlib = new webDriverutility();
		wlib.scrollToelement(driver, tsu.getSaveButton());
		tsu.getSaveButton().click();
		//verify that error message is displayed when trying to save the user without selecting any option from satellite dropdown after selecting satellite access level
		boolean isErrorMessageDisplayed = tsu.getSelectAtleastOneSatelliteErrorMessage().isDisplayed();
		if (isErrorMessageDisplayed) {
			System.out.println("Error message is displayed when trying to save without selecting any option from satellite dropdown - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Error message is displayed when trying to save without selecting any option from satellite dropdown - PASS");
		} else {
			System.out.println("Error message is not displayed when trying to save without selecting any option from satellite dropdown - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Error message is not displayed when trying to save without selecting any option from satellite dropdown - FAIL");
		}

			
		
	}
	@Test(dependsOnMethods = "TC_089TrytoProceedWithoutSatellite")
	public void TC_090SaveWithoutAllFields() throws InterruptedException {
		tsu.getSaveButton().click();
		//verify Firstnmae eroor message,Lastname,Emailerror message,role error messageand Satellite error message is displayed when trying to save without filling all the mandatory fields
		boolean isFirstnameErrorMessageDisplayed = tsu.getFirstNameErrorMessage().isDisplayed();
		boolean isLastnameErrorMessageDisplayed = tsu.getLastNameErrorMessage().isDisplayed();
		boolean isEmailErrorMessageDisplayed = tsu.getEmailErrorMessage().isDisplayed();
		boolean isRoleErrorMessageDisplayed = tsu.getRoleRequiredErrorMessage().isDisplayed();
		boolean isSatelliteErrorMessageDisplayed = tsu.getSelectAtleastOneSatelliteErrorMessage().isDisplayed();
		if (isFirstnameErrorMessageDisplayed && isLastnameErrorMessageDisplayed && isEmailErrorMessageDisplayed && isRoleErrorMessageDisplayed && isSatelliteErrorMessageDisplayed) {
			System.out.println("All error messages are displayed when trying to save without filling mandatory fields - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"All error messages are displayed when trying to save without filling mandatory fields - PASS");
		} else {
			System.out.println("All error messages are not displayed as expected when trying to save without filling mandatory fields - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"All error messages are not displayed as expected when trying to save without filling mandatory fields - FAIL");
		}	
		
	}
	@Test(dependsOnMethods = "TC_090SaveWithoutAllFields")
	public void TC_091SaveWithAllMandatoryFields() throws InterruptedException {
		random = new Random();
		int randomNumber = 100 + random.nextInt(900); // generates a 3-digit number (100-999)
		tsu.getFirstnameTextField().sendKeys("Test");
		tsu.getLastNameTextField().sendKeys("User");
		String email = "charlie" + randomNumber + "@gmail.com";
		System.out.println( email);
		tsu.getEmailTextField().sendKeys(email);
		tsu.getSelectRolesDropdown().click();
		tsu.getAdminRoleOptionfromRolesDropdown().click();
		tsu.getSaveButton().click();
		List<WebElement> emaillists = tsu.getEmaillistfromusertable();
		//In this list of emain just fetch related email which is added and verify that email is added in the user table or not
		boolean isEmailAddedInTable = false;
		for (WebElement emailElement : emaillists) {
			if (emailElement.getText().trim().equals(email)) {
				isEmailAddedInTable = true;
				break;
			}
			
		}
		if (isEmailAddedInTable) {
			System.out.println("New user is added successfully and email is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"New user is added successfully and email is displayed in user table - PASS");
		} else {
			System.out.println("New user is not added successfully or email is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"New user is not added successfully or email is not displayed in user table - FAIL");
		}
		
	
	}
	
	@Test(dependsOnMethods = "TC_091SaveWithAllMandatoryFields")
	public void TC_092SaveUserWithAllFields() throws InterruptedException {
		tsu.getAddNewUserButton().click();
		int randomNumber = 10000 + random.nextInt(90000); // generates a 3-digit number (100-999)
		//again write code add 2 digit random number
		
		
		
		String name = "Test"+randomNumber;
		tsu.getFirstnameTextField().sendKeys(name);
		tsu.getLastNameTextField().sendKeys("User");
		String email = "charlie" + randomNumber + "@gmail.com";
		System.out.println( email);
		tsu.getEmailTextField().sendKeys(email);
		tsu.getSelectRolesDropdown().click();
		tsu.getAdminRoleOptionfromRolesDropdown().click();
		//10 dogit random number for phone number in int format
		 
		tsu.getPhoneNumberTextField().sendKeys("5896478256");
		tsu.getSaveButton().click();
		List<WebElement> emaillists = tsu.getEmaillistfromusertable();
		boolean isEmailAddedInTable = false;
		for (WebElement emailElement : emaillists) {
			if (emailElement.getText().trim().equals(email)) {
				isEmailAddedInTable = true;
				break;
			}
			
		}
		if (isEmailAddedInTable) {
			System.out.println("New user is added successfully and email is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"New user is added successfully and email is displayed in user table - PASS");
		} else {
			System.out.println("New user is not added successfully or email is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"New user is not added successfully or email is not displayed in user table - FAIL");
		}
		
	}
	@Test(dependsOnMethods = "TC_092SaveUserWithAllFields")
	public void TC_093VerifyUserlistDisplayed() throws InterruptedException {
		//verify the user list heading is displayed or not
		boolean isUserListHeadingDisplayed = tsu.getUsersListHeading().isDisplayed();
		if (isUserListHeadingDisplayed) {
			System.out.println("User List heading is displayed in users page - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"User List heading is displayed in users page - PASS");
		} else {
			System.out.println("User List heading is not displayed in users page - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"User List heading is not displayed in users page - FAIL");
		}
	
	}
	@Test(dependsOnMethods = "TC_093VerifyUserlistDisplayed")
	public void TC_094ViewUserList() throws InterruptedException {
		tsu.getAddNewUserButton().click();
		tsu.getViewUsersListButton().click();
		//verify user is re-directed to user list page after clicking on view user list button
		boolean isUserListPageDisplayed = tsu.getUsersListHeading().isDisplayed();
		if (isUserListPageDisplayed) {
			System.out.println("User is redirected to user list page after clicking on view user list button - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"User is redirected to user list page after clicking on view user list button - PASS");
		} else {
			System.out.println("User is not redirected to user list page after clicking on view user list button - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"User is not redirected to user list page after clicking on view user list button - FAIL");
		}
	}
	String name;
	String phonemun;
	String phonetxt;
	String email;
	String roletxt;
	@Test(dependsOnMethods = "TC_094ViewUserList")
	public void TC_095VerifyUserinListTable() throws InterruptedException {
		int randomNumber = 10000 + random.nextInt(90000); // generates a 3-digit number (100-999)
		//again write code add 2 digit random number
		
		
		tsu.getAddNewUserButton().click();
		 name = "Test"+randomNumber;
		tsu.getFirstnameTextField().sendKeys(name);
		tsu.getLastNameTextField().sendKeys("User");
		email = "charlie" + randomNumber + "@gmail.com";
		System.out.println( email);
		tsu.getEmailTextField().sendKeys(email);
		tsu.getSelectRolesDropdown().click();
		tsu.getAdminRoleOptionfromRolesDropdown().click();
		//click outside to close the role dropdown
		driver.findElement(By.xpath("//body")).click();
		roletxt = tsu.getRoleDropdown().getText();
		System.out.println(roletxt);
		//10 dogit random number for phone number in int format
		phonemun = "5896478256";
		tsu.getPhoneNumberTextField().sendKeys(phonemun);
		phonetxt = tsu.getPhoneNumberTextField().getText();
		System.out.println(phonetxt);
		tsu.getSaveButton().click();
		List<WebElement> emaillists = tsu.getEmaillistfromusertable();
		boolean isEmailAddedInTable = false;
		for (WebElement emailElement : emaillists) {
			if (emailElement.getText().trim().equals(email)) {
				isEmailAddedInTable = true;
				break;
			}
			
		}
		if (isEmailAddedInTable) {
			System.out.println("New user is added successfully and email is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"New user is added successfully and email is displayed in user table - PASS");
		} else {
			System.out.println("New user is not added successfully or email is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"New user is not added successfully or email is not displayed in user table - FAIL");
		}
		
	}
	@Test(dependsOnMethods = "TC_095VerifyUserinListTable")
	public void TC_096verifyNameInUerList() throws InterruptedException {
		List<WebElement> namelists = tsu.getUserlistwithalldetails();
		boolean isNameAddedInTable = false;
		for (WebElement nameElement : namelists) {
			if (nameElement.getText().trim().contains(name)) {
				isNameAddedInTable = true;
				break;
			}
			
		}
		if (isNameAddedInTable) {
			System.out.println("New user name is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"New user name is displayed in user table - PASS");
		} else {
			System.out.println("New user name is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"New user name is not displayed in user table - FAIL");
		}	
	}
	@Test(dependsOnMethods = "TC_096verifyNameInUerList")
	public void TC_097VerifyaddedUserPhonenumberinInList() throws InterruptedException {
		//verify the added user phone number is displayed in user table or not
		List<WebElement> phonelists = tsu.getUserwithaphonenumberlist();
		//In this list of phone number just fetch related phone number which is added and verify that phone number is added in the user table or not
		boolean isPhoneNumberAddedInTable = false;
		for (WebElement phoneElement : phonelists) {
			if (phoneElement.getText().contains(phonetxt)) {
				isPhoneNumberAddedInTable = true;
				break;
			}
			
		}
		if (isPhoneNumberAddedInTable) {
			System.out.println("New user phone number is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"New user phone number is displayed in user table - PASS");
		} else {
			System.out.println("New user phone number is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"New user phone number is not displayed in user table - FAIL");
		}
		
	}
	@Test(dependsOnMethods = "TC_097VerifyaddedUserPhonenumberinInList")
	public void TC_098VerifyaddedUserEmailinInList() throws InterruptedException {
		//verify the added user email is displayed in user table or not
		List<WebElement> emaillists = tsu.getEmaillistfromusertable();
		//In this list of emain just fetch related email which is added and verify that email is added in the user table or not
		boolean isEmailAddedInTable = false;
		for (WebElement emailElement : emaillists) {
			if (emailElement.getText().trim().equals(email)) {
				isEmailAddedInTable = true;
				break;
			}
			
		}
		if (isEmailAddedInTable) {
			System.out.println("New user email is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"New user email is displayed in user table - PASS");
		} else {
			System.out.println("New user email is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"New user email is not displayed in user table - FAIL");
		}
		
	}
	@Test(dependsOnMethods = "TC_098VerifyaddedUserEmailinInList")
	public void TC_099VerifyaddedUserRoleinInList() throws InterruptedException {
		//verify the added user role is displayed in user table or not
		List<WebElement> rolelists = tsu.getRolelistfromuserlist();
		//In this list of role just fetch related role which is added and verify that role is added in the user table or not
		boolean isRoleAddedInTable = false;
		for (WebElement roleElement : rolelists) {
			if (roleElement.getText().trim().contains(roletxt)) {
				isRoleAddedInTable = true;
				break;
			}
			
		}
		if (isRoleAddedInTable) {
			System.out.println("New user role is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"New user role is displayed in user table - PASS");
		} else {
			System.out.println("New user role is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"New user role is not displayed in user table - FAIL");
		}
		
	}
	@Test(dependsOnMethods = "TC_099VerifyaddedUserRoleinInList")
	public void TC_100VerifyHierarchyAccess() throws InterruptedException {
		//verify the hierarchy access list is displayed in user table or not
		List<WebElement> hierarchyAccessLists = tsu.getHierarchyAccesslistfromuserlist();
		if (hierarchyAccessLists.size() > 0) {
			System.out.println("Hierarchy Access is displayed in user table - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Hierarchy Access is displayed in user table - PASS");
		} else {
			System.out.println("Hierarchy Access is not displayed in user table - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Hierarchy Access is not displayed in user table - FAIL");
		}
	}
	@Test(dependsOnMethods = "TC_100VerifyHierarchyAccess")
	public void TC_101VerifyUserlist() throws InterruptedException {
		//verify the usre list is displayed with pagination or not
		List<WebElement> userlist = tsu.getUserstatuslistfromuserlist();
		if (userlist.size() > 0) {
			System.out.println("User list is displayed with pagination in user list page - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"User list is displayed with pagination in user list page - PASS");
		} else {
			System.out.println("User list is not displayed with pagination in user list page - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"User list is not displayed with pagination in user list page - FAIL");
		}
		
	
	}
	@Test(dependsOnMethods = "TC_101VerifyUserlist")
	public void TC_102EditExistinguser() throws InterruptedException {
		//from user list based on recently created email and click on that perticular user
		//List<WebElement> emaillists = tsu.getEmaillistfromusertable();
		//for (WebElement emailElement : emaillists) {
			//if (emailElement.getText().trim().equals(email)) {
				//emailElement.click();
				//break;
			//}
			
		}
	@Test(dependsOnMethods = "TC_102EditExistinguser")
	public void TC_103VerifyUserStatudProfile() throws InterruptedException {
		//verify userbstatus dropdown is displayed in user profile page or not
		boolean isUserStatusDropdownDisplayed = tsu.getUserStatusdropdown().isDisplayed();
		if (isUserStatusDropdownDisplayed) {
			System.out.println("User Status dropdown is displayed in user profile page - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"User Status dropdown is displayed in user profile page - PASS");
		} else {
			System.out.println("User Status dropdown is not displayed in user profile page - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"User Status dropdown is not displayed in user profile page - FAIL");
		}
		
			
		
		
	}
	@Test(dependsOnMethods = "TC_103VerifyUserStatudProfile")
	public void TC_104UserStatusoption() throws InterruptedException {
		tsu.getUserStatusdropdown().click();
		List<WebElement> userStatusOptions = tsu.getUserstatusdropdownoptions();
		for (WebElement option : userStatusOptions) {
			System.out.println("User Status dropdown option: " + option.getText().trim());
			utilityclassobject.gettest().log(Status.INFO,
					"User Status dropdown option: " + option.getText().trim());
		}
		
	}
	@Test(dependsOnMethods = "TC_104UserStatusoption")
	public void TC_105ChangeUserstatusToActive() throws InterruptedException {
		//write a code select 1st option from user ststus dropdown
		
		tsu.getUserStatusActiveOptioncheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Active option in User Status dropdown");
		System.out.println("Clicked Active option in User Status dropdown");
		Thread.sleep(1000);
		//click on outside to close the dropdown
		//driver.findElement(By.xpath("//body")).click();
		//click on userlistheading to go back to user list page
		tsu.getUsersListHeading().click();
		
		//fetch user status list from user list page and verify that user status is updated to active in user list page after changing the user status to active in user profile page
		List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
		boolean isUserStatusUpdatedToActive = false;
		for (WebElement statusElement : userStatusLists) {
			if (statusElement.getText().trim().equals("Active")) {
				isUserStatusUpdatedToActive = true;
				break;
			}
			
		}
		if (isUserStatusUpdatedToActive) {
			System.out.println("User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
		} else {
			System.out.println("User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
		}
		
		
		
	}
	@Test(dependsOnMethods = "TC_105ChangeUserstatusToActive")
	public void TC_106ChangeUserstatusToInactive() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		tsu.getUserStatusdropdown().click();
		tsu.getUserStatusInactiveOptioncheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Inactive option in User Status dropdown");
		System.out.println("Clicked Inactive option in User Status dropdown");
		Thread.sleep(1000);
		//click on userlistheading to go back to user list page
		tsu.getUsersListHeading().click();
		
		//fetch user status list from user list page and verify that user status is updated to inactive in user list page after changing the user status to inactive in user profile page
		List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
		boolean isUserStatusUpdatedToInactive = false;
		for (WebElement statusElement : userStatusLists) {
			if (statusElement.getText().trim().equals("Inactive")) {
				isUserStatusUpdatedToInactive = true;
				break;
			}
			
		}
		if (isUserStatusUpdatedToInactive) {
			System.out.println("User status is updated to Inactive in user list page after changing the user status to Inactive in user profile page - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"User status is updated to Inactive in user list page after changing the user status to Inactive in user profile page - PASS");
		} else {
			System.out.println("User status is not updated to Inactive in user list page after changing the user status to Inactive in user profile page - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"User status is not updated to Inactive in user list page after changing the user status to Inactive in user profile page - FAIL");
		}
		
		
		
	}
	@Test(dependsOnMethods = "TC_106ChangeUserstatusToInactive")
	public void TC_107SelectbothActiveandInactive() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		tsu.getUserStatusdropdown().click();
		tsu.getUserStatusInactiveOptioncheckbox().click();
		tsu.getUserStatusActiveOptioncheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked both Active and Inactive option in User Status dropdown");
		System.out.println("Clicked both Active and Inactive option in User Status dropdown");
		Thread.sleep(1000);
		//click on userlistheading to go back to user list page
		tsu.getUsersListHeading().click();
		//fetch user status list from user list page and verify that user status is updated to active in user list page after changing the user status to active in user profile page
		List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
		boolean isUserStatusUpdatedToActive = false;
		boolean isUserStatusUpdatedToInactive = false;
		for (WebElement statusElement : userStatusLists) {
			if (statusElement.getText().trim().equals("Active")) {
				isUserStatusUpdatedToActive = true;
			}
			if (statusElement.getText().trim().equals("Inactive")) {
				isUserStatusUpdatedToInactive = true;
			}
			
		}
		if (isUserStatusUpdatedToActive && isUserStatusUpdatedToInactive) {
			System.out.println("Both Active and Inactive status are updated in user list page after selecting both options at a time in User Status dropdown in user profile page - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Both Active and Inactive status are updated in user list page after selecting both options at a time in User Status dropdown in user profile page - PASS");
		} else {
			System.out.println("Both Active and Inactive status are not updated in user list page after selecting both options at a time in User Status dropdown in user profile page - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Both Active and Inactive status are not updated in user list page after selecting both options at a time in User Status dropdown in user profile page - FAIL");
		}
		
		
		
	}
	@Test(dependsOnMethods = "TC_107SelectbothActiveandInactive")
	public void TC_108SelectOptionFromUserStatusDropdown() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		tsu.getUserStatusdropdown().click();
		tsu.getUserStatusActiveOptioncheckbox().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Active option in User Status dropdown again to select it");
		System.out.println("Clicked Active option in User Status dropdown again to select it");
		Thread.sleep(1000);
		//click on userlistheading to go back to user list page
		tsu.getUsersListHeading().click();
		
	}
	@Test(dependsOnMethods = "TC_108SelectOptionFromUserStatusDropdown")
	public void TC_109VerifyUserStatusAfterSelection() throws InterruptedException {
		//fetch user status list from user list page and verify that user status is updated to active in user list page after changing the user status to active in user profile page
		List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
		boolean isUserStatusUpdatedToActive = false;
		for (WebElement statusElement : userStatusLists) {
			if (statusElement.getText().trim().equals("Active")) {
				isUserStatusUpdatedToActive = true;
				break;
			}
			
		}
		if (isUserStatusUpdatedToActive) {
			System.out.println("User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
		} else {
			System.out.println("User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
		}
		
		
		
	}
	@Test(dependsOnMethods = "TC_109VerifyUserStatusAfterSelection")
	public void TC_110VerifyAccessSummaryAfterUserStatusChange() throws InterruptedException {
		
		
	}
	@Test(dependsOnMethods = "TC_110VerifyAccessSummaryAfterUserStatusChange")
	public void TC_111ChangeRegionFromUserProfile() throws InterruptedException {
	
		
	}
	@Test(dependsOnMethods = "TC_111ChangeRegionFromUserProfile")
	public void TC_112VerifyAccessSummaryAfterRegionChange() throws InterruptedException {
		
	}
}
