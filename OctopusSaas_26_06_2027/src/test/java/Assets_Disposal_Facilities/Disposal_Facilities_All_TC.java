package Assets_Disposal_Facilities;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.DisposalFacilities;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Disposal_Facilities_All_TC extends BaseClassForGEneratorContacts {

	DisposalFacilities df;

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
		if (driver.getCurrentUrl().contains("Add New Disposal Facility")) {
			System.out.println("Able to access Add New Disposal Facility Page :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Able to access Add New Disposal Facility Page ");
		} else {
			System.out.println("Not Able to access Add New Disposal Facility Page :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Not Able to access Add New Disposal Facility Page ");
		}
	}

}
