package UnappliedChecks;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class unappliedcheccks_All_Tc  extends com.OctopusSaas_BaseUtilityStagging.BaseClassForStagging {
	
	ExcelUtility elib ;
	LoginPage lp;
	RouteAssignment ras;
	TransporterProfile transProf ;
	HomePage hp ;
	String Generetorname;
	Generator_BillingPage gbil ;
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
		hp.AddNew();
		hp.Generator();
		AddNewGenerator NewGen = new AddNewGenerator(driver);
		Thread.sleep(5000);
		int Rannum = jlib.getRandomNumber();
		Generetorname = elib.getDataFromExcel("Unapplied checks", 1, 1) + Rannum;
		System.out.println(Generetorname);
		String InternalAcNo = elib.getDataFromExcel("Unapplied checks", 1, 2);
		Thread.sleep(5000);
		NewGen.NewGeneretor(Generetorname, InternalAcNo);
		Thread.sleep(2000);
		GeneretorInformation ginfo = new GeneretorInformation(driver);
		// wait for Generator Name element to be clickable/present before reading it
		WebElement genNameElement = ginfo.getGenName();
		wlib.waitUntilElementClickable(driver, genNameElement);
		String ActualName = ginfo.GeneratorName();
		System.out.println(ActualName);
		if(ActualName.contains(Generetorname))
		{
			System.out.println("Generator name matched successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Generator name matched successfully : PASS");
		}
		else
		{
			System.out.println("Generator name not matched : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Generator name not matched : FAIL");
		}		
		WebElement BillingInfo = ginfo.getBillingInfo();
		wlib.scrollToelement(driver, BillingInfo);
		ginfo.IndustryDD();
		WebElement lat = ginfo.getLatitute();
		wlib.scrollToelement(driver, lat);
		ginfo.Street();
		String emailId = elib.getDataFromExcel("Unapplied checks", 1, 3);
		ginfo.Emialid(emailId);
		String Phoneno = elib.getDataFromExcel("Unapplied checks", 1, 4);
		ginfo.Phonenumber(Phoneno);
		utilityclassobject.gettest().log(Status.INFO, "Billing Information is Filled Successfully");
		WebElement ele1 = ginfo.getGenereteOff();
		wlib.scrollToelement(driver, ele1);
		WebElement lat1 = ginfo.getLatitude();
		System.out.println(lat1.getText());
		System.out.println(ginfo.getLongitude().getText());
		utilityclassobject.gettest().log(Status.INFO, "Lattitude and longtude Generetaed and verified successfully");
		ginfo.CopyBtn();
		wlib.scrollToelement(driver, ele1);
		WebElement billingEmail = ginfo.getBillingInfo();
		String BillingMail = billingEmail.getText();
		// Assert.assertTrue(BillingMail.contains(emailId));
		System.out.println("Billing Email" + BillingMail);
		utilityclassobject.gettest().log(Status.INFO, "Billing information cpoied from Generator service information");
		WebElement sun = ginfo.getSunday();
		wlib.scrollToelement(driver, sun);
		ginfo.MondayOpen();
		ginfo.lunchTime();
		ginfo.lunchEnd();
		ginfo.MondayClose();
		ginfo.CopyPasteToAllDay();
		Thread.sleep(2000);
		ginfo.Contracted();
		ginfo.GeneratorBillingPage();
		gbil = new Generator_BillingPage(driver);
		gbil.ConfirmBillingSettingsCheckbox();
		wlib.scrollToelement(driver, gbil.getGenName());
		System.out.println(Generetorname);    //---Green Waste Management109073
		
		*/
		
		// Navigate to Unapplied Checks page
		 navbar = new Navigation_SideBar(driver);
		 navbar.MovetoUnappliedchecks();
		 uac = new UnappliedChecks_Page(driver);
		String uacpagetxt = uac.getUnappliedChecks_Page().getText();
		Assert.assertTrue(uacpagetxt.contains("Unapplied Checks"));
		 List<WebElement> lists = uac.getUnappliedChecks_Tablelists();
		 // Expected headers in order for each iteration (use contains check)
		 String[] expectedHeaders = new String[] {
				"Check ID",
				"Check #",
				"Invoice #",
				"Name",
				"Octo #",
				"Amount",
				"Remaining",
				"Payment Date",
				"Status",
				"Memo",
				"Created"
			};

			for (int i = 0; i < lists.size(); i++) {
				String actualText = lists.get(i).getText();
				System.out.println(actualText);
				utilityclassobject.gettest().log(Status.PASS, "Unapplied Checks Table List : " + actualText);

				if (i < expectedHeaders.length) {
					String expected = expectedHeaders[i];
					// Use contains to allow surrounding/extra whitespace or additional text
					Assert.assertTrue(actualText.contains(expected),
							"Expected header at index " + i + " to contain '" + expected + "' but was '" + actualText + "'");
					utilityclassobject.gettest().log(Status.PASS, "Verified header contains: '" + expected + "'");
				} else {
					// No expected defined for this index - log info
					utilityclassobject.gettest().log(Status.INFO, "No expected header defined for index: " + i + ", actual: " + actualText);
				}
			}
			System.out.println("All Unapplied Checks Table List  loads and verified successfully");
			utilityclassobject.gettest().log(Status.PASS, "All Unapplied Checks Table List  loads and verified successfully");
		
	}
	@Test(dependsOnMethods = "TC_001UnappliedCheckPageLoad")
	public void TC_002UnappliedCheckPageSideBar_Menu() throws Exception {
		List<WebElement> lists = uac.getSideBarLists();
		for(WebElement list:lists)
		{
			System.out.println(list.getText());
			utilityclassobject.gettest().log(Status.PASS, "Unapplied Checks Side Bar Menu List : " + list.getText());
		}
		System.out.println("All Unapplied Checks Side Bar Menu List  loads and verified successfully");
		utilityclassobject.gettest().log(Status.PASS, "All Unapplied Checks Side Bar Menu List  loads and verified successfully");
		

		
	}
	@Test(dependsOnMethods = "TC_002UnappliedCheckPageSideBar_Menu")
	
	public void TC_002VerifytheDefaultDateRange() throws Exception {
		
		
		
	}
	@Test(dependsOnMethods = "TC_002UnappliedCheckPAgeWithEmptyState")
	public void TC_003SearchUnappliedCheckWithmoewthan5Characters() throws Exception {
		
		//while executing TC_003 independently make sure generator name should commented and manual names should uncommented 
		
		
		uac.getQuickcheckaddbutton().click();
		uac.getSearchgeneratorfieldfromquivkcheckadd().sendKeys(/*Generetorname*/"Green Waste Management109073");
		driver.findElement(By.xpath("//div[contains(text(),'Green Waste Management109073')]")).click();
		Thread.sleep(2000);
		int randomNum = (int)(Math.random() * 900000) + 100000;
		
		uac.getChecknumberfieldfromquickcheckadd().sendKeys(String.valueOf(randomNum));
		uac.AddAmountField("10");
		uac.AddMemoNote("Test Memo Note");
		uac.ClickOnSaveCheckButton();
		uac.getSearchcheckfieldfromunappliedchecks().sendKeys(/*Generetorname*/"randomNum");
		String actualcheckname = uac.getSearchcheckfieldfromunappliedchecks().getText();
		Assert.assertTrue(actualcheckname.contains(/*Generetorname*/"Green Waste Management109073"));
	
	
	
	}
	
	
}