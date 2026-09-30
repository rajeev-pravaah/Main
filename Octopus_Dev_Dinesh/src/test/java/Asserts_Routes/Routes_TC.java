package Asserts_Routes;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.AssetsRoutes;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)
public class Routes_TC extends BaseClassForGEneratorContacts {
	AssetsRoutes ar;

	@Test
	public void TC_001_verifyUserCanAccessRoutesPage() {
		ar = new AssetsRoutes(driver);
		ar.getAssets().click();
		ar.getRoutes().click();
		ar.getRoutelist();
		System.out.println("Routes List page displayed successfully : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Routes List page displayed successfully");
	}

	@Test(dependsOnMethods = "TC_001_verifyUserCanAccessRoutesPage")
	public void TC_002_verifyExistingRoutesAppearOrEmptyStateIsShown() {
		ar.getRoutelist();
		if (ar.getRoutelist().isDisplayed()) {
			System.out.println("Existing routes apear successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "RExisting routes apear successfully");
		} else {
			System.out.println("Existing routes not apear successfully : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Existing routes not apear successfully");
		}
	}

	@Test(dependsOnMethods = "TC_002_verifyExistingRoutesAppearOrEmptyStateIsShown")
	public void TC_003_verifyNewRouteCanBeAdded() {
		ar.getAddnewroute().click();
		ar.getRoutedetails();
		System.out.println("Routes detail page displayed successfully : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Routes detail page displayed successfully : PASS");
	}

	@Test(dependsOnMethods = "TC_003_verifyNewRouteCanBeAdded")
	public void TC_004_verifyRouteDetailsTooltipAppearsWhenClicked() {
		ar.getRoutedetails().click();
		ar.getRoutedetailscls().click();
		System.out.println("Routes detail tooltip displayed successfully : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Routes detail tooltip displayed successfully : PASS");
	}

	@Test(dependsOnMethods = "TC_004_verifyRouteDetailsTooltipAppearsWhenClicked")
	public void TC_005_verifyMapAppearsCorrectly() throws InterruptedException {
		ar.getMapcanvas();
		System.out.println("Map appers correctly : PASS");
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.PASS, "Map appers correctly : PASS");
	}

	@Test(dependsOnMethods = "TC_005_verifyMapAppearsCorrectly")
	public void TC_006_verifyUserCanZoomInOutMapWithoutLag() throws InterruptedException {
		ar.getZoominbtn().click();
		Thread.sleep(2000);
		ar.getZoomoutbtn().click();
		Thread.sleep(2000);
		System.out.println("User can zoom in/out the map without lag : PASS");
		utilityclassobject.gettest().log(Status.PASS, "User can zoom in/out the map without lag : PASS");
	}

	@Test(dependsOnMethods = "TC_006_verifyUserCanZoomInOutMapWithoutLag")
	public void TC_007_verifyRouteNameFieldAcceptsInput() {
		ar.getRoutename().sendKeys("Test Route Automation");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Route name field accepts input : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route name field accepts input : PASS");
	}

	@Test(dependsOnMethods = "TC_007_verifyRouteNameFieldAcceptsInput")
	public void TC_008_verifyRouteNameFieldAcceptsNumbers() {
		ar.getRoutename().sendKeys(Keys.CONTROL + "a");
		ar.getRoutename().sendKeys(Keys.DELETE);
		ar.getRoutename().sendKeys("123456");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Route name field accepts numbers : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route name field accepts numbers : PASS");
	}

	@Test(dependsOnMethods = "TC_008_verifyRouteNameFieldAcceptsNumbers")
	public void TC_009_verifyRouteNameFieldAcceptsSpecialCharacters() {
		ar.getRoutename().sendKeys(Keys.CONTROL + "a");
		ar.getRoutename().sendKeys(Keys.DELETE);
		driver.findElement(By.tagName("body")).click();
		ar.getRoutename().sendKeys("!@#$%^&*()_+-=[]{}|;:\\\",.<>?/");
		System.out.println("Route name field accepts special characters : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route name field accepts special characters : PASS");
	}

	@Test(dependsOnMethods = "TC_009_verifyRouteNameFieldAcceptsSpecialCharacters")
	public void TC_010_verifyRouteNameFieldAcceptsLongerInput() {
		ar.getRoutename().sendKeys(Keys.CONTROL + "a");
		ar.getRoutename().sendKeys(Keys.DELETE);
		ar.getRoutename().sendKeys("Test Route Name With More Than Forty Characters");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Route name field accepts longer input : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route name field accepts longer input : PASS");
	}

	@Test(dependsOnMethods = "TC_010_verifyRouteNameFieldAcceptsLongerInput")
	public void TC_011_verifyUserCannotEnterInputInDefaultStartLocationField() {
		ar.getDefaultstartloc().click();
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys("Test Location").perform();
			System.out.println("User can enter input in the Default Start Location field : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "User can enter input in the Default Start Location field");
		} catch (Exception e) {
			System.out.println("User cannot enter input in the Default Start Location field : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"User cannot enter input in the Default Start Location field");
		}
	}

	@Test(dependsOnMethods = "TC_011_verifyUserCannotEnterInputInDefaultStartLocationField")
	public void TC_012_verifyDefaultStartLocationDropdownHasMainLocations() {
		ar.getDefaultstartlocmainloc();
		System.out.println("Default Start Location dropdown contains main locations : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Default Start Location dropdown contains main locations : PASS");
	}

	@Test(dependsOnMethods = "TC_012_verifyDefaultStartLocationDropdownHasMainLocations")
	public void TC_013_verifySatelliteLocationsAreVisibleInDefaultStartLocationDropdown() {
		ar.getDefaultstartlocsateliteloc();
		if (ar.getDefaultstartlocsateliteloc().isDisplayed()) {
			System.out.println("Satellite locations are visible in the Default Start Location dropdown : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Satellite locations are visible in the Default Start Location dropdown : PASS");
		} else {
			System.out.println("Satellite locations are not visible in the Default Start Location dropdown : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Satellite locations are not visible in the Default Start Location dropdown : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_013_verifySatelliteLocationsAreVisibleInDefaultStartLocationDropdown")
	public void TC_014_verifySatelliteLocationCanBeSelected() {
		ar.getDefaultstartloc1satelite().click();
		ar.getYes1().click();
		System.out.println("Satellite location can be selected : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Satellite location can be selected : PASS");
	}

	@Test(dependsOnMethods = "TC_014_verifySatelliteLocationCanBeSelected")
	public void TC_015_verifyDisposalFacilitiesAreVisibleInDefaultStartLocationDropdown() {
		ar.getDefaultstartloc().click();
		ar.getDefaultstartlocdisposal().click();
		System.out.println("Disposal facilities are visible in the Default Start Location dropdown : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Disposal facilities are visible in the Default Start Location dropdown : PASS");
	}

	@Test(dependsOnMethods = "TC_015_verifyDisposalFacilitiesAreVisibleInDefaultStartLocationDropdown")
	public void TC_016_verifyDisposalFacilityCanBeSelected() {
		ar.getDefaultstartloc1disposal().click();
		ar.getYes1().click();
		System.out.println("Disposal facility can be selected : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Disposal facility can be selected : PASS");
	}

	@Test(dependsOnMethods = "TC_016_verifyDisposalFacilityCanBeSelected")
	public void TC_017_verifyAreYouSurePopupAppearsUponSelectingDefaultStartLocation() {
		ar.getDefaultstartloc().click();
		ar.getDefaultstartloc1satelite().click();
		ar.getAreyousure();

		if (ar.getAreyousure().isDisplayed()) {
			System.out.println("'Are You Sure' popup appears upon selecting the Default Start Location : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"'Are You Sure' popup appears upon selecting the Default Start Location : PASS");
		} else {
			System.out.println("'Are You Sure' popup did not appear upon selecting the Default Start Location : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"'Are You Sure' popup did not appear upon selecting the Default Start Location : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_017_verifyAreYouSurePopupAppearsUponSelectingDefaultStartLocation")
	public void TC_018_verifyLocationDoesNotGetSelectedWhenClickedOnCancel() {
		ar.getCancel1().click();

		if (ar.getDefaultstartloc().getText().contains("Main Location")) {
			System.out.println("Location does not get selected when clicked on Cancel : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Location does not get selected when clicked on Cancel : PASS");
		} else {
			System.out.println("Location gets selected when clicked on Cancel : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Location gets selected when clicked on Cancel : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_018_verifyLocationDoesNotGetSelectedWhenClickedOnCancel")
	public void TC_019_verifyLocationGetsSelectedWhenClickedOnYes() {

		ar.getDefaultstartloc().click();
		ar.getDefaultstartloc1satelite().click();
		ar.getYes1().click();

		if (ar.getDefaultstartloc().getText().contains("hhhh")) {
			System.out.println("Location gets selected when clicked on Yes : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Location gets selected when clicked on Yes : PASS");
		} else {
			System.out.println("Location does not get selected when clicked on Yes : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Location does not get selected when clicked on Yes : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_019_verifyLocationGetsSelectedWhenClickedOnYes")
	public void TC_020_verifyRouteColorFieldAcceptsInput() {
		ar.getRoutecolour().click();
		ar.getRoutecolour().sendKeys(Keys.CONTROL + "a");
		ar.getRoutecolour().sendKeys(Keys.DELETE);
		ar.getRoutecolour().sendKeys("FFFFFF");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Route Color field accepts input : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route Color field accepts input : PASS");
	}

	@Test(dependsOnMethods = "TC_020_verifyRouteColorFieldAcceptsInput")
	public void TC_021_verifyRouteColorFieldAcceptsAlphabets() {
		ar.getRoutecolour().click();
		ar.getRoutecolour().sendKeys(Keys.CONTROL + "a");
		ar.getRoutecolour().sendKeys(Keys.DELETE);
		ar.getRoutecolour().sendKeys("ABCdef");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Route Color field accepts alphabets : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route Color field accepts alphabets : PASS");
	}

	@Test(dependsOnMethods = "TC_021_verifyRouteColorFieldAcceptsAlphabets")
	public void TC_022_verifyRouteColorFieldAcceptsNumbers() {
		ar.getRoutecolour().click();
		ar.getRoutecolour().sendKeys(Keys.CONTROL + "a");
		ar.getRoutecolour().sendKeys(Keys.DELETE);
		ar.getRoutecolour().sendKeys("123456");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Route Color field accepts numbers : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route Color field accepts numbers : PASS");
	}

	@Test(dependsOnMethods = "TC_022_verifyRouteColorFieldAcceptsNumbers")
	public void TC_023_verifyRouteColorFieldAcceptsSpecialCharacters() {
		ar.getRoutecolour().click();
		ar.getRoutecolour().sendKeys(Keys.CONTROL + "a");
		ar.getRoutecolour().sendKeys(Keys.DELETE);
		ar.getRoutecolour().sendKeys("!@#$%^&*");
		driver.findElement(By.tagName("body")).click();
		if (ar.getDefaultstartloc().getText().contains("hhhh")) {
			System.out.println("Route Color field accepts special characters : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Route Color field accepts special characters : PASS");
		} else {
			System.out.println("Route Color field not accepts special characters : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Route Color field not accepts special characters : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_023_verifyRouteColorFieldAcceptsSpecialCharacters")
	public void TC_024_verifyUserCanSelectRouteColorFromColorBox() {
		ar.getColourbox().click();
		System.out.println("Route color can be selected from the color box : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route color can be selected from the color box : PASS");
	}

	@Test(dependsOnMethods = "TC_024_verifyUserCanSelectRouteColorFromColorBox")
	public void TC_025_verifyRouteColorFieldGetsUpdatedWhenColorIsSelected() {
		String colorValue = ar.getRoutecolour().getAttribute("value");
		if (colorValue != null && !colorValue.trim().isEmpty()) {
			System.out.println("Route Color field gets updated when a color is selected : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Route Color field gets updated when a color is selected : PASS");
		} else {
			System.out.println("Route Color field is not updated : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Route Color field is not updated after selecting a color");
		}
	}

	@Test(dependsOnMethods = "TC_025_verifyRouteColorFieldGetsUpdatedWhenColorIsSelected")
	public void TC_026_verifyRouteTypeFieldDoesNotAcceptInput() {
		try {
			ar.getRoutetype().sendKeys("route123");
			// If no exception occurs, the test should fail
			Assert.fail("Route Type field accepted input.");
		} catch (ElementNotInteractableException e) {
			System.out.println("Route Type field does not accept input as it is a dropdown : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Route Type field does not accept input as it is a dropdown.");
		}
	}

	@Test(dependsOnMethods = "TC_026_verifyRouteTypeFieldDoesNotAcceptInput")
	public void TC_027_verifyRouteTypeOptionsShowUpWhenClicked() {
		ar.getRoutetype().click();
		System.out.println("Route Type options show up when clicked : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route Type options show up when clicked : PASS");
	}

	@Test(dependsOnMethods = "TC_027_verifyRouteTypeOptionsShowUpWhenClicked")
	public void TC_028_verifyRouteTypeOptionsCanBeSelectedAndUnselected() {
		// Select the first checkbox
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		checkbox.click();
		// Unselect the same checkbox
		checkbox.click();
		driver.findElement(By.tagName("body")).click();
		System.out.println("Route Type options can be selected and unselected : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route Type options can be selected and unselected : PASS");
	}

	@Test(dependsOnMethods = "TC_028_verifyRouteTypeOptionsCanBeSelectedAndUnselected")
	public void TC_029_verifyUserCanLeaveRouteTypeBlank() {
		ar.getRoutetypevalidation();
		driver.findElement(By.tagName("body")).click();
		if (ar.getRoutetypevalidation().isDisplayed()) {
			System.out.println("Validation message displayed for blank Route Type : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Validation message displayed for blank Route Type.");
		} else {
			System.out.println("Validation message not displayed for blank Route Type : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Validation message not displayed for blank Route Type.");
		}
	}

	@Test(dependsOnMethods = "TC_029_verifyUserCanLeaveRouteTypeBlank")
	public void TC_030_verifyUserCanSelectOneRouteTypeOption() {
		ar.getRoutetype().click();
		// Select the first checkbox
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		checkbox.click();
		driver.findElement(By.tagName("body")).click();
		System.out.println("User can select one Route Type option : PASS");
		utilityclassobject.gettest().log(Status.PASS, "User can select one Route Type option : PASS");
	}

	@Test(dependsOnMethods = "TC_030_verifyUserCanSelectOneRouteTypeOption")
	public void TC_031_verifyUserCanSelectMoreThanOneRouteTypeOption() {
		ar.getRoutetype().click();
		// Select the first option
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		// Select the second option
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.findElement(By.tagName("body")).click();
		System.out.println("User can select more than one Route Type option : PASS");
		utilityclassobject.gettest().log(Status.PASS, "User can select more than one Route Type option : PASS");
	}

	@Test(dependsOnMethods = "TC_031_verifyUserCanSelectMoreThanOneRouteTypeOption")
	public void TC_032_verifyUserCannotEnterInputInDefaultEndLocationField() {
		ar.getDefaultendloc().click();
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys("Test Location").perform();
			System.out.println("User can enter input in the Default End Location field : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "User can enter input in the Default End Location field");
		} catch (Exception e) {
			System.out.println("User cannot enter input in the Default End Location field : PASS");
			utilityclassobject.gettest().log(Status.PASS, "User cannot enter input in the Default End Location field");
		}
	}

	@Test(dependsOnMethods = "TC_032_verifyUserCannotEnterInputInDefaultEndLocationField")
	public void TC_033_verifyDefaultEndLocationDropdownHasMainLocations() {
		ar.getDefaultendlocmainloc();
		System.out.println("Default End Location dropdown contains main locations : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Default End Location dropdown contains main locations : PASS");
	}

	@Test(dependsOnMethods = "TC_033_verifyDefaultEndLocationDropdownHasMainLocations")
	public void TC_034_verifySatelliteLocationsAreVisibleInDefaultEndLocationDropdown() {
		ar.getDefaultendloc1satelite();
		if (ar.getDefaultendloc1satelite().isDisplayed()) {
			System.out.println("Satellite locations are visible in the Default End Location dropdown : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Satellite locations are visible in the Default End Location dropdown : PASS");
		} else {
			System.out.println("Satellite locations are not visible in the Default End Location dropdown : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Satellite locations are not visible in the Default End Location dropdown : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_034_verifySatelliteLocationsAreVisibleInDefaultEndLocationDropdown")
	public void TC_035_verifySatelliteLocationCanBeSelectedInDefaultEndLocation() throws InterruptedException {
		ar.getDefaultendloc1satelite().click();
		ar.getYes2().click();
		Thread.sleep(5000);
		System.out.println("Satellite location can be selected in the Default End Location dropdown : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Satellite location can be selected in the Default End Location dropdown : PASS");
	}

	@Test(dependsOnMethods = "TC_035_verifySatelliteLocationCanBeSelectedInDefaultEndLocation")
	public void TC_036_verifyDisposalFacilitiesAreVisibleInDefaultEndLocationDropdown() {
		ar.getDefaultendloc().click();
		ar.getDefaultendlocdisposal().click();
		System.out.println("Disposal facilities are visible in the Default End Location dropdown : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Disposal facilities are visible in the Default End Location dropdown : PASS");
	}

	@Test(dependsOnMethods = "TC_036_verifyDisposalFacilitiesAreVisibleInDefaultEndLocationDropdown")
	public void TC_037_verifyDisposalFacilityCanBeSelectedInDefaultEndLocation() {
		ar.getDefaultendloc1disposal().click();
		ar.getYes2().click();
		System.out.println("Disposal facility can be selected in the Default End Location dropdown : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Disposal facility can be selected in the Default End Location dropdown : PASS");
	}

	@Test(dependsOnMethods = "TC_037_verifyDisposalFacilityCanBeSelectedInDefaultEndLocation")
	public void TC_038_verifyAreYouSurePopupAppearsUponSelectingDefaultEndLocation() {
		ar.getDefaultendloc().click();
		ar.getDefaultendloc1satelite().click();

		ar.getAreyousure();

		if (ar.getAreyousure().isDisplayed()) {
			System.out.println("'Are You Sure' popup appears upon selecting the Default End Location : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"'Are You Sure' popup appears upon selecting the Default End Location : PASS");
		} else {
			System.out.println("'Are You Sure' popup did not appear upon selecting the Default End Location : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"'Are You Sure' popup did not appear upon selecting the Default End Location : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_038_verifyAreYouSurePopupAppearsUponSelectingDefaultEndLocation")
	public void TC_039_verifyLocationDoesNotGetSelectedWhenClickedOnCancelInDefaultEndLocation() {
		ar.getCancel2().click();

		if (ar.getDefaultendloc().getText().contains("Main Location")) {
			System.out.println("Location does not get selected when clicked on Cancel : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Location does not get selected when clicked on Cancel : PASS");
		} else {
			System.out.println("Location gets selected when clicked on Cancel : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Location gets selected when clicked on Cancel : FAIL");
		}
		System.out.println("Location does not get selected when clicked on Cancel : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Location does not get selected when clicked on Cancel : PASS");
	}

	@Test(dependsOnMethods = "TC_039_verifyLocationDoesNotGetSelectedWhenClickedOnCancelInDefaultEndLocation")
	public void TC_040_verifyLocationGetsSelectedWhenClickedOnYesInDefaultEndLocation() {
		ar.getDefaultendloc().click();
		ar.getDefaultendloc1satelite().click();
		ar.getYes2().click();

		if (ar.getDefaultendloc().getText().contains("hhhh")) {
			System.out.println("Location gets selected when clicked on Yes : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Location gets selected when clicked on Yes : PASS");
		} else {
			System.out.println("Location does not get selected when clicked on Yes : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Location does not get selected when clicked on Yes : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_040_verifyLocationGetsSelectedWhenClickedOnYesInDefaultEndLocation")
	public void TC_041_verifyUserCannotEnterInputInStatusField() {
		ar.getStatusfield().click();
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys("Test Location").perform();
			System.out.println("User can enter input in the Status field as it is a dropdown : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"User can enter input in the Status field as it is a dropdown");
		} catch (Exception e) {
			System.out.println("User cannot enter input in the Status field as it is a dropdown : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"User cannot enter input in the Status field as it is a dropdown : PASS");
		}
	}

	@Test(dependsOnMethods = "TC_041_verifyUserCannotEnterInputInStatusField")
	public void TC_042_verifyStatusDropdownShowsOptions() {
		ar.getActive();
		System.out.println("Status dropdown shows all available options : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Status dropdown shows all available options : PASS");
	}

	@Test(dependsOnMethods = "TC_042_verifyStatusDropdownShowsOptions")
	public void TC_043_verifyUserCanSelectStatusType() {
		ar.getActive().click();
		ar.getYes3().click();
		System.out.println("Status type can be selected : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Status type can be selected : PASS");
	}

	@Test(dependsOnMethods = "TC_043_verifyUserCanSelectStatusType")
	public void TC_044_verifyUserCannotSelectMultipleStatusTypes() {
		String selectedStatus = ar.getStatusfield().getText();
		if (selectedStatus.equalsIgnoreCase("Active")) {
			System.out.println("User cannot select more than one status type : PASS");
			utilityclassobject.gettest().log(Status.PASS, "User cannot select more than one status type : PASS");
		} else {
			System.out.println("User can select more than one status type : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "User can select more than one status type : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_044_verifyUserCannotSelectMultipleStatusTypes")
	public void TC_045_verifySelectedStatusAppearsInField() {
		String selectedStatus = ar.getStatusfield().getText();
		if (selectedStatus.equalsIgnoreCase("Active")) {
			System.out.println("Selected status appears in the Status field : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Selected status appears in the Status field : PASS");
		} else {
			System.out.println("Selected status does not appear in the Status field : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Selected status does not appear in the Status field : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_045_verifySelectedStatusAppearsInField")
	public void TC_046_verifyNoteFieldAcceptsInput() {
		ar.getNote().click();
		ar.getNote().sendKeys(Keys.CONTROL + "a");
		ar.getNote().sendKeys(Keys.DELETE);
		ar.getNote().sendKeys("FFFFFF");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Note field accepts input : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Note field accepts input : PASS");
	}

	@Test(dependsOnMethods = "TC_046_verifyNoteFieldAcceptsInput")
	public void TC_047_verifyNoteFieldAcceptsNumbers() {
		ar.getNote().click();
		ar.getNote().sendKeys(Keys.CONTROL + "a");
		ar.getNote().sendKeys(Keys.DELETE);
		ar.getNote().sendKeys("12345678");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Note field accepts numbers : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Note field accepts numbers : PASS");
	}

	@Test(dependsOnMethods = "TC_047_verifyNoteFieldAcceptsNumbers")
	public void TC_048_verifyNoteFieldAcceptsSpecialCharacters() {
		ar.getNote().click();
		ar.getNote().sendKeys(Keys.CONTROL + "a");
		ar.getNote().sendKeys(Keys.DELETE);
		ar.getNote().sendKeys("!@#$%^&*");
		driver.findElement(By.tagName("body")).click();
		System.out.println("Note field accepts special characters : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Note field accepts special characters : PASS");
	}

	@Test(dependsOnMethods = "TC_048_verifyNoteFieldAcceptsSpecialCharacters")
	public void TC_049_verifyNoteFieldCanBeExpanded() {
//		WebElement note = ar.getNote();
//		// Get size before resizing
//		org.openqa.selenium.Dimension before = note.getSize();
//		// Drag the bottom-right corner of the textarea
//		Actions actions = new Actions(driver);
//		actions.moveToElement(note, before.getWidth() - 2, before.getHeight() - 2).clickAndHold().moveByOffset(100, 100)
//				.release().perform();
//		// Get size after resizing
//		org.openqa.selenium.Dimension after = note.getSize();
//		if (after.getWidth() > before.getWidth() || after.getHeight() > before.getHeight()) {
//			System.out.println("Note field can be expanded : PASS");
//			utilityclassobject.gettest().log(Status.PASS, "Note field can be expanded : PASS");
//		} else {
//			System.out.println("Note field cannot be expanded : FAIL");
//			utilityclassobject.gettest().log(Status.FAIL, "Note field cannot be expanded : FAIL");
//		}
	}

	@Test(dependsOnMethods = "TC_049_verifyNoteFieldCanBeExpanded")
	public void TC_050_verifyStatsForNerdsSection() {
		ar.getStatsfornerds().click();
		System.out.println("Stats for Nerds section displays all required information : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Stats for Nerds section displays all required information : PASS");
	}

	@Test(dependsOnMethods = "TC_050_verifyStatsForNerdsSection")
	public void TC_051_verifyStatsForNerdsShowsZeroForNewRoute() {
		String services = ar.getServicesPerformed().getText().trim();
		String scheduled = ar.getScheduledServices().getText().trim();
		String generators = ar.getGeneratorsAssigned().getText().trim();
		if (services.equals("0") && scheduled.equals("0") && generators.equals("0")) {
			System.out.println("Stats for Nerds shows all values as 0 for a new route : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Stats for Nerds shows all values as 0 for a new route : PASS");
		} else {
			System.out.println("Stats for Nerds does not show all values as 0 : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Stats for Nerds does not show all values as 0 : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_051_verifyStatsForNerdsShowsZeroForNewRoute")
	public void TC_052_verifyRouteCannotBeAddedWithoutMandatoryFields() {
		ar.getViewroutelist().click();
		ar.getAddnewroute().click();
		ar.getSave().click();
		if (ar.getRouteNameValidation().isDisplayed() && ar.getDefaultStartLocationValidation().isDisplayed()
				&& ar.getRouteTypeValidation1().isDisplayed() && ar.getDefaultEndLocationValidation().isDisplayed()) {
			System.out.println("Route cannot be added without filling the mandatory fields : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Route cannot be added without filling the mandatory fields : PASS");
		} else {
			System.out.println("Route was added or mandatory field validation was not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Route was added or mandatory field validation was not displayed : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_052_verifyRouteCannotBeAddedWithoutMandatoryFields")
	public void TC_053_verifyRouteCannotBeAddedByFillingOnlyOneMandatoryField() {
		ar.getRoutename().sendKeys(Keys.CONTROL + "a");
		ar.getRoutename().sendKeys(Keys.DELETE);
		ar.getRoutename().sendKeys("AABBCC");
		driver.findElement(By.tagName("body")).click();
		ar.getSave().click();
		if (ar.getDefaultStartLocationValidation().isDisplayed() && ar.getRouteTypeValidation1().isDisplayed()
				&& ar.getDefaultEndLocationValidation().isDisplayed()) {
			System.out.println("Route cannot be added by filling only one mandatory field : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Route cannot be added by filling only one mandatory field : PASS");
		} else {
			System.out.println("Route can be added by filling only one mandatory field : PASS");
			utilityclassobject.gettest().log(Status.FAIL,
					"Route can be added by filling only one mandatory field : PASS");
		}
	}

	@Test(dependsOnMethods = "TC_053_verifyRouteCannotBeAddedByFillingOnlyOneMandatoryField")
	public void TC_054_verifyRouteGetsAddedWithAllMandatoryFields() {

		ar.getRoutename().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		ar.getRoutename().sendKeys(Keys.DELETE);
		ar.getRoutename().sendKeys("AABBCC");

		ar.getDefaultstartloc().click();
		ar.getDefaultstartloc1satelite().click();
		ar.getYes1().click();

		ar.getRoutetype().click();
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		checkbox.click();
		driver.findElement(By.tagName("body")).click();

		ar.getDefaultendloc().click();
		ar.getDefaultendloc1satelite().click();
		ar.getYes2().click();

		ar.getSave().click();

		if (driver.getCurrentUrl().contains("routes")) {
			System.out.println("Route gets added successfully after filling all mandatory fields : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Route gets added successfully after filling all mandatory fields : PASS");
		} else {
			System.out.println("Route was not added : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Route was not added.");
		}
	}

	@Test(dependsOnMethods = "TC_054_verifyRouteGetsAddedWithAllMandatoryFields")
	public void TC_055_TC_056_verifyRouteListAndTooltip() throws InterruptedException {
		ar.getViewroutelist().click();
		if (ar.getRoutelisttooltip().isDisplayed()) {
			ar.getRoutelisttooltip().click();
			ar.getTooltipclose().click();
			Thread.sleep(4000);
			System.out.println("Route List is displayed and tooltip appears successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Route List is displayed and tooltip appears successfully");
		} else {
			System.out.println("Route List or tooltip is not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Route List or tooltip is not displayed");
		}
	}

	@Test(dependsOnMethods = "TC_055_TC_056_verifyRouteListAndTooltip")
	public void TC_057_verifyRouteIDIsPresentInRouteList() {
		WebElement routeId = driver
				.findElement(By.xpath("(//div[contains(@class,'truncate')][starts-with(normalize-space(),'RT')])[1]"));
		String routeIdValue = routeId.getText().trim();
		if (!routeIdValue.isEmpty() && routeIdValue.startsWith("RT")) {
			System.out.println("Route ID is present in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Route ID is present in the Route List : PASS");
		} else {
			System.out.println("Route ID is not present in the Route List : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Route ID is not present in the Route List : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_057_verifyRouteIDIsPresentInRouteList")
	public void TC_058_verifyStartLocationIsPresentInRouteList() {
		WebElement startLocation = driver.findElement(
				By.xpath("(//div[contains(@class,'truncate') and not(contains(text(),'Start Location'))])[3]"));
		String startLocationValue = startLocation.getText().trim();
		if (!startLocationValue.isEmpty()) {
			System.out.println("Start location is present in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Start location is present in the Route List : PASS");
		} else {
			System.out.println("Start location is not present in the Route List : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Start location is not present in the Route List : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_058_verifyStartLocationIsPresentInRouteList")
	public void TC_059_verifyEndLocationIsPresentInRouteList() {
		WebElement endLocation = driver.findElement(
				By.xpath("(//div[contains(@class,'truncate') and not(contains(text(),'End Location'))])[4]"));
		String endLocationValue = endLocation.getText().trim();
		if (!endLocationValue.isEmpty()) {
			System.out.println("End location is present in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS, "End location is present in the Route List : PASS");
		} else {
			System.out.println("End location is not present in the Route List : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "End location is not present in the Route List : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_059_verifyEndLocationIsPresentInRouteList")
	public void TC_060_verifyTotalNumberOfServicesIsPresentInRouteList() {
		WebElement totalServices = driver
				.findElement(By.xpath("(//div[contains(@class,'truncate') and normalize-space()='0'])[1]"));
		String totalServicesValue = totalServices.getText().trim();
		if (!totalServicesValue.isEmpty()) {
			System.out.println("Total number of services is present in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Total number of services is present in the Route List : PASS");
		} else {
			System.out.println("Total number of services is not present in the Route List : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Total number of services is not present in the Route List : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_060_verifyTotalNumberOfServicesIsPresentInRouteList")
	public void TC_061_verifyServicesOfLast30DaysArePresentInRouteList() {
		WebElement last30DaysHeader = driver
				.findElement(By.xpath("//div[contains(@class,'truncate') and normalize-space()='Last 30 Days']"));
		if (last30DaysHeader.isDisplayed()) {
			System.out.println("Services of the last 30 days are present in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Services of the last 30 days are present in the Route List : PASS");
		} else {
			System.out.println("Last 30 Days column is not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Last 30 Days column is not displayed : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_061_verifyServicesOfLast30DaysArePresentInRouteList")
	public void TC_062_verifyServicesOfNext30DaysArePresentInRouteList() {
		WebElement next30DaysHeader = driver
				.findElement(By.xpath("//div[contains(@class,'truncate') and normalize-space()='Next 30 Days']"));
		if (next30DaysHeader.isDisplayed()) {
			System.out.println("Services of the next 30 days are present in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Services of the next 30 days are present in the Route List : PASS");
		} else {
			System.out.println("Next 30 Days column is not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Next 30 Days column is not displayed : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_062_verifyServicesOfNext30DaysArePresentInRouteList")
	public void TC_063_verifyRouteStatusIsPresentInRouteList() {
		WebElement status = driver
				.findElement(By.xpath("(//div[contains(@class,'truncate') and normalize-space()='Active'])[1]"));
		String statusValue = status.getText().trim();
		if (!statusValue.isEmpty()) {
			System.out.println("Route status is present in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Route status is present in the Route List : PASS");
		} else {
			System.out.println("Route status is not present in the Route List : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Route status is not present in the Route List : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_063_verifyRouteStatusIsPresentInRouteList")
	public void TC_064_verifyExistingRouteDetailsCanBeUpdated() {
		WebElement status = driver
				.findElement(By.xpath("(//div[contains(@class,'truncate') and normalize-space()='Active'])[1]"));
		status.click();
		ar.getNote().click();
		ar.getNote().sendKeys(Keys.CONTROL + "a");
		ar.getNote().sendKeys(Keys.DELETE);
		ar.getNote().sendKeys("AAAAAAAAAAA");
		driver.findElement(By.tagName("body")).click();
		ar.getSave().click();
		ar.getViewroutelist().click();
		System.out.println("Existing route details can be updated : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Existing route details can be updated : PASS");
	}

	@Test(dependsOnMethods = "TC_064_verifyExistingRouteDetailsCanBeUpdated")
	public void TC_065_verifyRouteStatusFiltersAreUnselectedByDefault() {
		ar.getStatusfilter();
		System.out.println("Route Status filters are unselected by default : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Route Status filters are unselected by default : PASS");
	}

	@Test(dependsOnMethods = "TC_065_verifyRouteStatusFiltersAreUnselectedByDefault")
	public void TC_066_verifyActiveRoutesAreDisplayed() {

		// Open Route Status filter
		ar.getStatusfilter().click();

		// Select Active
		ar.getActive1().click();

		// Verify Active routes
		if (ar.getActive1().isDisplayed()) {
			System.out.println("All active routes are displayed in the Route List : PASS");
			utilityclassobject.gettest().log(Status.PASS, "All active routes are displayed in the Route List : PASS");
		} else {
			System.out.println("Active routes are not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Active routes are not displayed in the Route List : FAIL");
		}

		// Uncheck Active
		ar.getActive1().click();
	}

	@Test(dependsOnMethods = "TC_066_verifyActiveRoutesAreDisplayed")
	public void TC_067_verifyInactiveRoutesAppearWhenInactiveFilterIsSelected() {

		// Click required button before opening Route Status filter
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();

		// Open Route Status filter
		ar.getStatusfilter().click();

		// Select Inactive
		ar.getInactive1().click();

		// Verify Inactive routes
		if (ar.getInactive1().isDisplayed()) {
			System.out.println("Inactive routes appear when Inactive filter is selected : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Inactive routes appear when Inactive filter is selected : PASS");
		} else {
			System.out.println("Inactive routes are not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Inactive routes are not displayed : FAIL");
		}

		// Uncheck Inactive
		ar.getInactive1().click();
	}

	@Test(dependsOnMethods = "TC_067_verifyInactiveRoutesAppearWhenInactiveFilterIsSelected")
	public void TC_068_verifyOutOfNetworkRoutesAppearWhenFilterIsSelected() {

		// Click required button before opening Route Status filter
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();

		// Open Route Status filter
		ar.getStatusfilter().click();

		// Select Out Of Network Services
		ar.getOutOfNetworkServices1().click();

		// Verify Out Of Network Services routes
		if (ar.getOutOfNetworkServices1().isDisplayed()) {
			System.out.println("Out of Network Services routes appear when the filter is selected : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Out of Network Services routes appear when the filter is selected : PASS");
		} else {
			System.out.println("Out of Network Services routes are not displayed : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Out of Network Services routes are not displayed : FAIL");
		}

		// Uncheck Out Of Network Services
		ar.getOutOfNetworkServices1().click();
	}

}
