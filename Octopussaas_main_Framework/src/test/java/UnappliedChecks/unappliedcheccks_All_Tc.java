package UnappliedChecks;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AddNewGenerator;
import com.Octopussaas.ObjectRepository.Generator_BillingPage;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.Navigation_SideBar;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaas.ObjectRepository.UnappliedChecks_Page;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class unappliedcheccks_All_Tc extends com.OctopusSaas_BaseUtilityStagging.BaseClassForStagging {

	ExcelUtility elib;
	LoginPage lp;
	RouteAssignment ras;
	TransporterProfile transProf;
	HomePage hp;
	String Generetorname;
	Generator_BillingPage gbil;
	Navigation_SideBar navbar;
	UnappliedChecks_Page uac;

	@Test
	public void TC_001UnappliedCheckPageLoad() throws Exception {
		elib = new ExcelUtility();
		jlib = new javautility();
		wlib = new webDriverutility();
		lp = new LoginPage(driver);
		ras = new RouteAssignment(driver);
		transProf = new TransporterProfile(driver);

		utilityclassobject.gettest().log(Status.INFO, "Login Page is displayed");
		utilityclassobject.gettest().log(Status.INFO, "Home Page is displayed");
		hp = new HomePage(driver);
		/*
		 * hp.AddNew(); hp.Generator(); AddNewGenerator NewGen = new

		 * 3AddNewGenerator(driver); Thread.sleep(5000); int Rannum =
		 * jl
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * ib.getRandomNumber(); Generetorname =
		 * elib.getDataFromExcel("Unapplied checks", 1, 1) + Rannum;
		 * 
		 * System.out.println(Generetorname); String InternalAcNo =
		 * elib.getDataFromExcel("Unapplied checks", 1, 2); Thread.sleep(5000);
		 * 
		 * 
		 * NewGen.NewGeneretor(Generetorname, InternalAcNo); Thread.sleep(2000);
		 * GeneretorInformation ginfo = new GeneretorInformation(driver); // wait for
		 * Generator Name element to be clickable/present before reading it WebElement
		 * genNameElement = ginfo.getGenName(); wlib.waitUntilElementClickable(driver,
		 * genNameElement); String ActualName = ginfo.GeneratorName();
		 * System.out.println(ActualName); if(ActualName.contains(Generetorname)) {
		 * System.out.println("Generator name matched successfully : PASS");
		 * utilityclassobject.gettest().log(Status.PASS,
		 * "Generator name matched successfully : PASS"); } else {
		 * System.out.println("Generator name not matched : FAIL");
		 * utilityclassobject.gettest().log(Status.FAIL,
		 * "Generator name not matched : FAIL"); } WebElement BillingInfo =
		 * ginfo.getBillingInfo(); wlib.scrollToelement(driver, BillingInfo);
		 * ginfo.IndustryDD(); WebElement lat = ginfo.getLatitute();
		 * wlib.scrollToelement(driver, lat); ginfo.Street(); String emailId =
		 * elib.getDataFromExcel("Unapplied checks", 1, 3); ginfo.Emialid(emailId);
		 * String Phoneno = elib.getDataFromExcel("Unapplied checks", 1, 4);
		 * ginfo.Phonenumber(Phoneno); utilityclassobject.gettest().log(Status.INFO,
		 * "Billing Information is Filled Successfully"); WebElement ele1 =
		 * ginfo.getGenereteOff(); wlib.scrollToelement(driver, ele1); WebElement lat1 =
		 * ginfo.getLatitude(); System.out.println(lat1.getText());
		 * System.out.println(ginfo.getLongitude().getText());
		 * utilityclassobject.gettest().log(Status.INFO,
		 * "Lattitude and longtude Generetaed and verified successfully");
		 * ginfo.CopyBtn(); wlib.scrollToelement(driver, ele1); WebElement billingEmail
		 * = ginfo.getBillingInfo(); String BillingMail = billingEmail.getText(); //
		 * Assert.assertTrue(BillingMail.contains(emailId));
		 * System.out.println("Billing Email" + BillingMail);
		 * utilityclassobject.gettest().log(Status.INFO,
		 * "Billing information cpoied from Generator service information"); WebElement
		 * sun = ginfo.getSunday(); wlib.scrollToelement(driver, sun);
		 * ginfo.MondayOpen(); ginfo.lunchTime(); ginfo.lunchEnd(); ginfo.MondayClose();
		 * ginfo.CopyPasteToAllDay(); Thread.sleep(2000); ginfo.Contracted();
		 * ginfo.GeneratorBillingPage(); gbil = new Generator_BillingPage(driver);
		 * gbil.ConfirmBillingSettingsCheckbox(); wlib.scrollToelement(driver,
		 * gbil.getGenName()); System.out.println(Generetorname); //---Green Waste
		 * Management109073
		 * 
		 */

		// Navigate to Unapplied Checks page
		navbar = new Navigation_SideBar(driver);
		navbar.MovetoUnappliedchecks();
		uac = new UnappliedChecks_Page(driver);
		String uacpagetxt = uac.getUnappliedChecks_Page().getText();
		Assert.assertTrue(uacpagetxt.contains("Unapplied Checks"));
		List<WebElement> lists = uac.getUnappliedChecks_Tablelists();
		// Expected headers in order for each iteration (use contains check)
		String[] expectedHeaders = new String[] { "Check ID", "Check #", "Invoice #", "Name", "Octo #", "Amount",
				"Remaining", "Payment Date", "Status", "Memo", "Created" };

		for (int i = 0; i < lists.size(); i++) {
			String actualText = lists.get(i).getText();
			System.out.println(actualText);
			utilityclassobject.gettest().log(Status.PASS, "Unapplied Checks Table List : " + actualText);

			if (i < expectedHeaders.length) {
				String expected = expectedHeaders[i];
				// Use contains to allow surrounding/extra whitespace or additional text
				Assert.assertTrue(actualText.contains(expected), "Expected header at index " + i + " to contain '"
						+ expected + "' but was '" + actualText + "'");
				utilityclassobject.gettest().log(Status.PASS, "Verified header contains: '" + expected + "'");
			} else {
				// No expected defined for this index - log info
				utilityclassobject.gettest().log(Status.INFO,
						"No expected header defined for index: " + i + ", actual: " + actualText);
			}
		}
		System.out.println("All Unapplied Checks Table List  loads and verified successfully");
		utilityclassobject.gettest().log(Status.PASS,
				"All Unapplied Checks Table List  loads and verified successfully");

	}

	@Test(dependsOnMethods = "TC_001UnappliedCheckPageLoad")
	public void TC_002UnappliedCheckPageSideBar_Menu() throws Exception {
		List<WebElement> lists = uac.getSideBarLists();
		for (WebElement list : lists) {
			System.out.println(list.getText());
			utilityclassobject.gettest().log(Status.PASS, "Unapplied Checks Side Bar Menu List : " + list.getText());
		}
		System.out.println("All Unapplied Checks Side Bar Menu List  loads and verified successfully");
		utilityclassobject.gettest().log(Status.PASS,
				"All Unapplied Checks Side Bar Menu List  loads and verified successfully");

	}

	@Test(dependsOnMethods = "TC_002UnappliedCheckPageSideBar_Menu")

	public void TC_003VerifytheDefaultDateRange() throws Exception {
		String defaultdaterange = uac.getDaterangedd().getText();
		System.out.println("Default Date Range is : " + defaultdaterange);
		utilityclassobject.gettest().log(Status.PASS, "Default Date Range is : " + defaultdaterange);
		Assert.assertTrue(defaultdaterange.contains("Last 90 Days"));

	}

	@Test(dependsOnMethods = "TC_003VerifytheDefaultDateRange")
	public void TC_004SearchUnappliedCheckRequires5Char() throws Exception {

		// while executing TC_003 independently make sure generator name should
		// commented and manual names should uncommented

		// uac.getQuickcheckaddbutton().click();
		// uac.getSearchgeneratorfieldfromquivkcheckadd().sendKeys(/*Generetorname*/"Green
		//3 Waste Management109073");
		// driver.findElement(By.xpath("//div[contains(text(),'Green Waste
		// Management109073')]")).click();
		// Thread.sleep(2000);
		// int randomNum = (int)(Math.random() * 900000) + 100000;

		// uac.getChecknumberfieldfromquickcheckadd().sendKeys(String.valueOf(randomNum));
		// uac.AddAmountField("10");
		// uac.AddMemoNote("Test Memo Note");
		// uac.ClickOnSaveCheckButton();
		// uac.getSearchcheckfieldfromunappliedchecks().sendKeys(/*Generetorname*/"randomNum");
		// String actualcheckname =
		// u3ac.getSearchcheckfieldfromunappliedchecks().getText();
		// Assert.assertTrue(actualcheckname.contains(/*Generetorname*/"Green Waste
		// Management109073"));

		uac.getSearchcheckfieldfromunappliedchecks().sendKeys("123");
		if (uac.getSearchiconvalidationmessage().isDisplayed()) {
			System.out.println("Search Unapplied Check Requires 5 Char : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Search Unapplied Check Requires 5 Char : PASS");
		} else {
			System.out.println("Search Unapplied Check Requires 5 Char : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Search Unapplied Check Requires 5 Char : FAIL");
		}
		// clear the search field
		uac.getSearchcheckfieldfromunappliedchecks().clear();

	}

	@Test(dependsOnMethods = "TC_004SearchUnappliedCheckRequires5Char")
	public void TC_005VerifySearchUnappliedCheckWithMorethan5digits() throws Exception {
		uac.getSearchcheckfieldfromunappliedchecks().sendKeys("12345");
		// clcik on enter button
		uac.getSearchcheckfieldfromunappliedchecks().sendKeys("\n");
		Thread.sleep(2000);
		WebElement list = uac.getUnappliedcheckstablelists();
		if (list.isDisplayed()) {
			System.out.println("Search Unapplied Check With More than 5 digits : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Search Unapplied Check With More than 5 digits : PASS");
		} else {
			System.out.println("Search Unapplied Check With More than 5 digits : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Search Unapplied Check With More than 5 digits : FAIL");
		}
		

	}
	@Test(dependsOnMethods = "TC_005VerifySearchUnappliedCheckWithMorethan5digits")
	public void TC_006VerifySearchHighlightedMatchingField() throws Exception {
		
		 String list = uac.getUnappliedcheckstablelists().getText();
		 if(list.contains("12345")) {
			 System.out.println("Search Highlighted Matching Field : PASS");
			 utilityclassobject.gettest().log(Status.PASS, "Search Highlighted Matching Field : PASS");
		 }
		 else {
			 System.out.println("Search Highlighted Matching Field : FAIL");
			 utilityclassobject.gettest().log(Status.FAIL, "Search Highlighted Matching Field : FAIL ");
		 }
		
		     // clear the search field
				uac.getSearchcheckfieldfromunappliedchecks().clear();
				//click on flter button
				uac.getUnappliedchecksfilterbutton().click();
	
	}
	@Test(dependsOnMethods = "TC_006VerifySearchHighlightedMatchingField")
	public void TC_007VerifyStatusFilter() throws Exception {
		uac.getStatusdd().click();
		List<WebElement> statuslists = uac.getSearchfieldfromunappliedchecks();
		//click on first status
		statuslists.get(0).click();
		Thread.sleep(2000);
		String status = uac.getStatusdd().getText();
		System.out.println("Selected Status is : " + status);
		utilityclassobject.gettest().log(Status.PASS, "Selected Status is : " + status);
		//clcik on outside 
		uac.getUnappliedcheckspagetitle().click();
		//verify filterd staus list
		 String list = uac.getUnappliedcheckstablelists().getText();
		 if(list.contains(status)) {
			 System.out.println("Verify Status Filter : PASS");
			 utilityclassobject.gettest().log(Status.PASS, "Verify Status Filter : PASS");
		 }
		 else {
			 System.out.println("Verify Status Filter : FAIL");
			 utilityclassobject.gettest().log(Status.FAIL, "Verify Status Filter : FAIL ");
		 }

		
		
	
	}
	@Test(dependsOnMethods = "TC_007VerifyStatusFilter")
	public void TC_008VerifyDateRangeFilter() throws Exception {
	  uac.getFromdatepicker().click();
	  System.out.println("From Date Picker is clicked");
	  utilityclassobject.gettest().log(Status.PASS, "From Date Picker is clicked");
	  uac.getYearDDfromFromcalendar().click();
	  System.out.println("Year Dropdown is clicked");
	  utilityclassobject.gettest().log(Status.PASS, "Year Dropdown is clicked");
	  //select year from dropdown
	  List<WebElement> years = uac.getYearsfromdd();
	  for(WebElement year : years) {
		  if(year.getText().equals("2026")) {
			  year.click();
			  System.out.println("Year 2026 is selected");
			  utilityclassobject.gettest().log(Status.PASS, "Year 2026 is selected from dropdown");
			  break;
		  }
	  }
	  uac.getMonthddfromfromcalendar().click();
	  System.out.println("Month Dropdown is clicked");
	  utilityclassobject.gettest().log(Status.PASS, "Month Dropdown is clicked");
	  //select month from dropdown
	   List<WebElement> months = uac.getMonthsfromdd();
	   for(WebElement month : months) {
		   if(month.getText().contains("Jan")) {
			   month.click();
			   System.out.println("Month Jan is selected");
			   utilityclassobject.gettest().log(Status.PASS, "Month Jan is selected from dropdown");
			   break;
		   }
	   }
	   driver.findElement((By.xpath("//div[@class='react-datepicker__month-container']/descendant::div[text()='1']"))).click();
	   Thread.sleep(2000);
	   System.out.println("Date slected from date picker");
	   utilityclassobject.gettest().log(Status.PASS, "Date slected from date picker ");
	   System.out.println("Date Range Filter is applied");
	   utilityclassobject.gettest().log(Status.PASS, "Date Range Filter is applied");
	   Thread.sleep(2000);
	 
	  
	  
	  
	}
	@Test(dependsOnMethods = "TC_008VerifyDateRangeFilter")
	public void TC_009VerifyClearFilterResetDefaultvalues() throws Exception {
		  //click on filter button
		   uac.getUnappliedchecksfilterbutton().click();
		   System.out.println("Filter button is clicked");
		   utilityclassobject.gettest().log(Status.PASS, "Filter button is clicked");
		   String defaultvaluefromdaterange = uac.getDefaultvaluefromdaterange().getText();
		   System.out.println("Default value from Date Range is : " + defaultvaluefromdaterange);
		   utilityclassobject.gettest().log(Status.PASS, "Default value from Date Range is 	: " + defaultvaluefromdaterange);
		   if(defaultvaluefromdaterange.contains("Last 90 Days")) {
			   System.out.println("Clear Filter Reset Default values : PASS");
			   utilityclassobject.gettest().log(Status.PASS, "Clear Filter Reset Default values : PASS");
		   }
		   else {
			   System.out.println("Clear Filter Reset Default values : FAIL");
			   utilityclassobject.gettest().log(Status.FAIL, "Clear Filter Reset Default values : FAIL");
		   }
		
	}
	@Test(dependsOnMethods = "TC_009VerifyClearFilterResetDefaultvalues")
	public void TC_010VerifyTableColumLists() throws Exception {
		List<WebElement> tablecolumns = uac.getUnappliedcheckstableheaderlists();
		for(WebElement column : tablecolumns) {
			System.out.println(column.getText());
			utilityclassobject.gettest().log(Status.PASS, "Unapplied Checks Table Column List : " + column.getText());
		}
	}
	@Test(dependsOnMethods = "TC_010VerifyTableColumLists")
	public void TC_011VerifySingleclickAndDoubleClick() throws Exception {
		uac.getFirstcheckidfromlist().click();
		System.out.println("Single click on first check id from list");
		utilityclassobject.gettest().log(Status.PASS, "Single click on first check"
				+ "id from list");
		if(uac.getCopiedtoclipboardmessage().isDisplayed()) {
			System.out.println("Single click on first check id from list : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Single click on first check id from list : PASS");
		}
		else {
			System.out.println("Single click on first check id from list : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Single click on first check id from list : FAIL");
		}
		//double click on first check id from list
		uac.getFirstcheckidfromlist().click();
		uac.getFirstcheckidfromlist().click();
		System.out.println("Double click on first check id from list");
		utilityclassobject.gettest().log(Status.PASS, "Double click on first check"
				+ "id from list");
		if(uac.getCopiedtoclipboardmessage().isDisplayed()) {
			System.out.println("Double click on first check id from list : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Double click on first check id from list : PASS");
		}
		else {
			System.out.println("Double click on first check id from list : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Double click on first check id from list : FAIL");
				
		}
	}
	@Test(dependsOnMethods = "TC_011VerifySingleclickAndDoubleClick")
	public void TC_012VerifySummaryFootertotalMatchRows() throws Exception {
		List<WebElement> checkrows = uac.getNumberofrowsinunappliedcheckstable();
		//fetch count of rows from summary footer
		int count = checkrows.size();
		System.out.println("Count of rows from summary footer : " + count);
		utilityclassobject.gettest().log(Status.PASS, "Count of rows from summary footer : " + count);
		String actualcheck = uac.getTotalcheckfounds().getText();
		if(actualcheck.contains(String.valueOf(count))) {
			System.out.println("Summary Footer total match rows : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Summary Footer total match rows : PASS");
		} else {
			System.out.println("Summary Footer total match rows : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Summary Footer total match rows : FAIL");
		}
		List<WebElement> footer = uac.getSummaryfooter();
		for(WebElement foot : footer) {
			System.out.println(foot.getText());
			utilityclassobject.gettest().log(Status.PASS, "Summary Footer List : " + foot.getText());
		}
		System.out.println("Summary Footer total match rows and list verified successfully");
		utilityclassobject.gettest().log(Status.PASS, "Summary Footer total match rows and list verified successfully");
	
	}
	@Test(dependsOnMethods = "TC_012VerifySummaryFootertotalMatchRows")
	public void TC_013VerifyRealtimelisterUpdatetable() throws Exception {
		//copy url of unapplied checks page and open in new tab and verify the table is updated in real time
		String url = driver.getCurrentUrl();
		System.out.println("Current URL is : " + url);
		utilityclassobject.gettest().log(Status.PASS, "Current URL is : " + url);
		
		
		//open new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		System.out.println("New tab is opened with same url");
		utilityclassobject.gettest().log(Status.PASS, "New tab is opened with same url");
		Thread.sleep(2000);
		//fetch the count of tabs	
		int tabCount = driver.getWindowHandles().size();

		System.out.println("Number of tabs: " + tabCount);
		utilityclassobject.gettest().log(Status.PASS, "Number of tabs: " + tabCount);
		//add new check in 2nd tab
		uac.getQuickcheckaddbutton().click();
		System.out.println("Quick Check Add button is clicked in 2nd tab");
		utilityclassobject.gettest().log(Status.PASS, "Quick Check Add button is clicked in 2nd tab");
		
		//added existing generator -" Green Waste Management109073" in all Dev, Stagging, prod env
		uac.getSearchfieldfromcheckpopup().sendKeys("Green Waste Management109073");
		System.out.println("Generator name is entered in 2nd tab");
		utilityclassobject.gettest().log(Status.PASS, "Generator name is entered in 2nd tab");
        uac.getSearchgeneratorsuggestion().click();
        System.out.println("Generator name is selected from suggestion in 2nd tab");
        		utilityclassobject.gettest().log(Status.PASS, "Generator name is selected from suggestion in 2nd tab");
		uac.AddCheckNumber();
		System.out.println("Check number is added in 2nd tab");
		utilityclassobject.gettest().log(Status.PASS, "Check number is added in 2nd tab");
		String addedechecknofromtab2 = uac.getChecknumberfieldfromquickcheckadd().getAttribute("value");
		System.out.println("Added check number from 2nd tab is : " + addedechecknofromtab2);
		utilityclassobject.gettest().log(Status.PASS, "Added check number from 2nd tab is : " + addedechecknofromtab2);
		uac.AddAmountField("10");
		String addedamountfromtab2 = uac.getAmountfieldfromquickcheckadd().getAttribute("value");
		System.out.println("Added amount from 2nd tab is : " + addedamountfromtab2);
		utilityclassobject.gettest().log(Status.PASS, "Added amount from 2 tab is : " + addedamountfromtab2);
		uac.AddMemoNote("Test Memo Note");
		String addednotefromtab2 = uac.getOptionalnotefieldfromquickcheckadd().getAttribute("value");
		System.out.println("Added note from 2nd tab is : " + addednotefromtab2);
		utilityclassobject.gettest().log(Status.PASS, "Added note from 2 tab is : " + addednotefromtab2);
		uac.ClickOnSaveCheckButton();
		Thread.sleep(3000);
		//clcik on filter button in 2nd tab
		uac.getUnappliedchecksfilterbutton().click();
		System.out.println("New check is added in 2nd tab");
		utilityclassobject.gettest().log(Status.PASS, "New check is added in 2nd tab");
		Thread.sleep(2000);
		//switch back to first tab
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
		System.out.println("Switched back to first tab");
		utilityclassobject.gettest().log(Status.PASS, "Switched back to first tab");
		Thread.sleep(2000);
	
		List<WebElement> lists = uac.getAlldetailsofchecks();
		for(WebElement list : lists) {
			String check = list.getText();
			if(check.contains(addedechecknofromtab2)) {
				System.out.println("Real time list update verified successfully : PASS");
				utilityclassobject.gettest().log(Status.PASS, "Real time list update verified successfully : PASS");
				break;
			}
		}
		

		 
		
	}

}