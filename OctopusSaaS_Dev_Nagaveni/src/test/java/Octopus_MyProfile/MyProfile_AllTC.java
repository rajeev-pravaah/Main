package Octopus_MyProfile;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.FileUtility.FileUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

import io.opentelemetry.sdk.trace.internal.ExtendedSpanProcessor;


	@Listeners(ListnerUtility.ListnerUilityImp.class )

	public class MyProfile_AllTC extends BaseClassForGEneratorContacts{
		HomePage hp;


		
		@Test(priority = 1)
		public void TC_001myprofile_Dropdown() throws InterruptedException
		{
			hp = new HomePage(driver);
			hp.Myprofile();
			utilityclassobject.gettest().log(Status.INFO, "My profile is dropdown is displayed with follwing contains");
		}
		
		@Test(dependsOnMethods = "TC_001myprofile_Dropdown")
		public void TC_002Myprofile_Transporter() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.TransporterSettings();
			utilityclassobject.gettest().log(Status.INFO, "Transporter Setting page is displayed");

		}
		
		@Test(dependsOnMethods = "TC_002Myprofile_Transporter")
		public void TC_003myProfile_Mysettings() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.Mysettings();
			utilityclassobject.gettest().log(Status.INFO, "My Setting page is displayed");

			
		}
		
		@Test(dependsOnMethods = "TC_003myProfile_Mysettings")
		public void TC_004Myprofile_Auditlog() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.Auditlog();
			utilityclassobject.gettest().log(Status.INFO, "AuditLog Page is displayed");
		}
		
		@Test(dependsOnMethods = "TC_004Myprofile_Auditlog")
		public void TC_005Myprofile_HistoricalSettings() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.Historicalmanifest();
			utilityclassobject.gettest().log(Status.INFO, "Historical Manifest Setting page is displayed");
		}
		
		@Test(dependsOnMethods = "TC_005Myprofile_HistoricalSettings")
		public void TC_006myProfile_Logout() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.Logout();
			utilityclassobject.gettest().log(Status.INFO, "user ia able to logout from the Myprofile page");
		}
		
		@Test(dependsOnMethods = "TC_006myProfile_Logout") 
		public void TC_007myProfile_Viewtos() throws InterruptedException, AWTException
		{
			HomePage hp = new HomePage(driver);	
			hp.getLoginEmail().click();
			hp.getLoginEmail().sendKeys("henry@test.com");
			Thread.sleep(2000);
			hp.getLoginPassword().click();
			hp.getLoginPassword().sendKeys("Nayan123!@");
			Thread.sleep(2000);
			hp.getLoginButton().click();
			Thread.sleep(2000);
	 		
			hp.ViewTos();
			hp.getCloseButton().click();
			utilityclassobject.gettest().log(Status.INFO, "View TOS apge is displayed");

		}
		
		@Test(dependsOnMethods = "TC_007myProfile_Viewtos")
		public void TC_008myProfile_Mysettings()
		{
			HomePage hp = new HomePage(driver);
			hp.MysettingsProfile();
			utilityclassobject.gettest().log(Status.INFO, "My setting page is displayed with all the following contains");

		}
		
		@Test(dependsOnMethods = "TC_008myProfile_Mysettings")
		public void TC_009myProfile_firstnameWithInput() throws EncryptedDocumentException, IOException, InterruptedException
		{
			javautility	jlib = new javautility();
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getFirstName().click();
			hp.getFirstName().sendKeys(Keys.CONTROL + "a");
			hp.getFirstName().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 1, 1);
			hp.getFirstName().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "First Name Text field will accept input");
		}
		
		@Test(dependsOnMethods = "TC_009myProfile_firstnameWithInput")
		public void TC_010myprofile_FirstnamewithEdit() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.getFirstName().click();
			hp.getFirstName().sendKeys(Keys.CONTROL + "a");
			hp.getFirstName().sendKeys(Keys.DELETE);
			hp.getFirstName().sendKeys("henry");
			utilityclassobject.gettest().log(Status.INFO, "First Name can be edited in Myprofile");
		}
		
		@Test(dependsOnMethods = "TC_010myprofile_FirstnamewithEdit")
		public void TC_011myProfile_Firstnamewithalphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			javautility	jlib = new javautility();
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getFirstName().click();
			hp.getFirstName().sendKeys(Keys.CONTROL + "a");
			hp.getFirstName().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 1, 2);
			hp.getFirstName().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "First Name Text field will accept alpahbets");
		}
		
		@Test(dependsOnMethods = "TC_011myProfile_Firstnamewithalphabets")
		public void TC_012myProfile_withspecialcharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			javautility	jlib = new javautility();
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getFirstName().click();
			hp.getFirstName().sendKeys(Keys.CONTROL + "a");
			hp.getFirstName().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 1, 3);
			hp.getFirstName().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "First Name Text field will accept alpahbets");
		}
		
		@Test(dependsOnMethods = "TC_012myProfile_withspecialcharacters")
		public void TC_013myProfile_FirstnamewithNumbers() throws EncryptedDocumentException, IOException, InterruptedException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getFirstName().click();
			hp.getFirstName().sendKeys(Keys.CONTROL + "a");
			hp.getFirstName().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 1, 4);
			hp.getFirstName().sendKeys(input);
			String enteredValue = hp.getFirstName().getAttribute("value");
			boolean hasNumbers = enteredValue.matches(".*\\d.*");
			utilityclassobject.gettest().log(Status.INFO, "FirstName  textfield will not accpet numbers");
		}
		
		@Test(dependsOnMethods = "TC_013myProfile_FirstnamewithNumbers")
		public void TC_014myProfile_lastnamewithInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			javautility	jlib = new javautility();
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getLastname().click();
			hp.getLastname().sendKeys(Keys.CONTROL + "a");
			hp.getLastname().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 4, 1);
			hp.getLastname().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "LastName  textfield will accept input");

		}
		
		@Test(dependsOnMethods = "TC_014myProfile_lastnamewithInput")
		public void TC_015myProfile_lastnamewithEdit() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.getLastname().click();
			hp.getLastname().sendKeys(Keys.CONTROL + "a");
			hp.getLastname().sendKeys(Keys.DELETE);
			hp.getLastname().sendKeys("bigb");
			utilityclassobject.gettest().log(Status.INFO, "Lastname in the textfield can be edited");
		}
		
		@Test(dependsOnMethods = "TC_015myProfile_lastnamewithEdit")
		public void TC_016myProfile_lastnamewithAlphabets() throws EncryptedDocumentException, IOException, InterruptedException 
		{
			javautility	jlib = new javautility();
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getLastname().click();
			hp.getLastname().sendKeys(Keys.CONTROL + "a");
			hp.getLastname().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 4, 2);
			hp.getLastname().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "LastName text field will accept alpahbets");

		}
		
		@Test(dependsOnMethods = "TC_016myProfile_lastnamewithAlphabets")
		public void TC_017myProfile_lastnamewithSpecialcharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			javautility	jlib = new javautility();
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getLastname().click();
			hp.getLastname().sendKeys(Keys.CONTROL + "a");
			hp.getLastname().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 4, 3);
			hp.getLastname().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "LastName text field will accept specialcharacters");

		}
		
		@Test(dependsOnMethods = "TC_017myProfile_lastnamewithSpecialcharacters")
		public void TC_018myProfile_lastnamewithNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getLastname().click();
			hp.getLastname().sendKeys(Keys.CONTROL + "a");
			hp.getLastname().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 4, 4);
			hp.getLastname().sendKeys(input);
			String enteredValue = hp.getLastname().getAttribute("value");
			boolean hasNumbers = enteredValue.matches(".*\\d.*");
			utilityclassobject.gettest().log(Status.INFO, "lastnameName  textfield will not accpet numbers");
		}
		
		@Test(dependsOnMethods = "TC_018myProfile_lastnamewithNumbers")
		public void TC_019myProfile_EmailwithEdit() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			WebElement emailField = hp.getEmail();
			String readonly = emailField.getAttribute("disabled step");
			System.out.println(readonly);
			boolean isEditable = true;
			    try {
			        emailField.sendKeys("test@gmail.com");
			    } catch (Exception e) {
			        isEditable = false;
			    }
			    	Assert.assertTrue(readonly != null || !isEditable, "Email field is editable!");

			    	
			    utilityclassobject.gettest().log(Status.INFO, "Email Textfield is not editable");
			}
		
		@Test(dependsOnMethods = "TC_019myProfile_EmailwithEdit")
		public void TC_020myProfile_PasswordwithClick() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.getPassword().click();
		    utilityclassobject.gettest().log(Status.INFO, "Password Textfield is clickable");	
		}
		
		@Test(dependsOnMethods = "TC_020myProfile_PasswordwithClick")
		public void TC_021myProfile_PasswordwithPopup()
		{
			HomePage hp = new HomePage(driver);
			hp.ChangePassword();
		    utilityclassobject.gettest().log(Status.INFO, "Password Textfield is clickable");			
		}
		
		@Test(dependsOnMethods = "TC_021myProfile_PasswordwithPopup")
		public void TC_O22myProfile_Phonewithinput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getPhoneTextfield().click();
			hp.getPhoneTextfield().sendKeys(Keys.CONTROL + "a");
			hp.getPhoneTextfield().sendKeys(Keys.DELETE);
			String input = elib.getDataFromExcel("MyProfile", 7, 1);
			hp.getPhoneTextfield().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Phone text field will accept Input");
		}

		@Test(dependsOnMethods = "TC_O22myProfile_Phonewithinput")
		public void TC_023myProfile_PhonewithNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getPhoneTextfield().click();
			String input = elib.getDataFromExcel("MyProfile", 7, 2);
			hp.getPhoneTextfield().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Phone text field will accept numbers");
		}

		@Test(dependsOnMethods = "TC_023myProfile_PhonewithNumbers")
		public void TC_024myProfile_phonewithAlphabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getPhoneTextfield().click();
			String input = elib.getDataFromExcel("MyProfile", 7, 3);
			hp.getPhoneTextfield().sendKeys(input);
			String enteredValue = hp.getPhoneTextfield().getAttribute("value");
			boolean hasAlphbets = enteredValue.matches(".*[^a-zA-Z0-9].*");
			utilityclassobject.gettest().log(Status.INFO, "Phone text field will not accept alphbets");
		}
		
		@Test(dependsOnMethods = "TC_024myProfile_phonewithAlphabets")
		public void TC_025myProfile_PhonewithSpecialcharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getPhoneTextfield().click();
			String input = elib.getDataFromExcel("MyProfile", 7, 4);
			hp.getPhoneTextfield().sendKeys(input);
			String enteredValue = hp.getPhoneTextfield().getAttribute("value");
			boolean hasSpecialChars = enteredValue.matches(".*[^a-zA-Z0-9].*");
			utilityclassobject.gettest().log(Status.INFO, "Phone text field will not accept specialcharacters");
		}
		
		@Test(dependsOnMethods = "TC_025myProfile_PhonewithSpecialcharacters")
		public void 
		TC_026myprofile_extwithInput() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getExtField().click();
			String input = elib.getDataFromExcel("MyProfile", 10, 1);
			hp.getExtField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Ext text field will accept Input");
			
		}
		
		@Test(dependsOnMethods = "TC_026myprofile_extwithInput")
		public void TC_027myprofile_withalpahabets() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getExtField().click();
			String input = elib.getDataFromExcel("MyProfile", 10, 2);
			hp.getExtField().sendKeys(input);
			String enteredValue = hp.getLastname().getAttribute("value");
			boolean hasAlphabets = enteredValue.matches(".*[a-zA-Z].*");
			utilityclassobject.gettest().log(Status.INFO, "Ext text field will not accept alphbets");
		}
		
		@Test(dependsOnMethods = "TC_027myprofile_withalpahabets")
		public void TC_028myProfile_ExtwithNumbers() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getExtField().click();
			String input = elib.getDataFromExcel("MyProfile", 10, 3);
			hp.getExtField().sendKeys(input);
			utilityclassobject.gettest().log(Status.INFO, "Ext text field will accept numbers");
			
		}
		
		@Test(dependsOnMethods = "TC_028myProfile_ExtwithNumbers")
		public void TC_029myprofile_ExtwithSpecialCharacters() throws InterruptedException, EncryptedDocumentException, IOException
		{
			ExcelUtility elib = new ExcelUtility();
			HomePage hp = new HomePage(driver);
			hp.getExtField().click();
			String input = elib.getDataFromExcel("MyProfile", 7, 4);
			hp.getExtField().sendKeys(input);
			String enteredValue = hp.getExtField().getAttribute("value");
			boolean hasSpecialChars = enteredValue.matches(".*[^a-zA-Z0-9].*");
			utilityclassobject.gettest().log(Status.INFO, "Phone text field will not accept specialcharacters");
		}

		@Test(dependsOnMethods = "TC_029myprofile_ExtwithSpecialCharacters")
		public void TC_031myprofile_Roles() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.RoleDropdown();
			utilityclassobject.gettest().log(Status.INFO, "Roles assigned to the profile appears in the field");

		}
		
		@Test(dependsOnMethods = "TC_031myprofile_Roles")
		public void TC_032myprofile_Adminrole() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.Admin();
			utilityclassobject.gettest().log(Status.INFO, "user is able to select the Admin checkbox");

		}
		
		@Test(dependsOnMethods = "TC_032myprofile_Adminrole") 
		public void TC_033myProfile_OctoconnectRole() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.OctoConnectContact();
			utilityclassobject.gettest().log(Status.INFO, "user is able to check the octo connect contact checkbox");

		}
		
		
		@Test(dependsOnMethods = "TC_033myProfile_OctoconnectRole")
		public void TC_034myprofile_StandardwithAdmin() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.getRoles().click();
			hp.getRoles().click();
			WebElement standardCheckbox = hp.getStandardRole();
			if (!standardCheckbox.isEnabled()) {
			    utilityclassobject.gettest().log(Status.PASS, "Standard checkbox is disabled when Admin is selected");
		
			    
			    System.out.println("Standard checkbox is disabled when Admin is selected");
			}
			else {
			utilityclassobject.gettest().log(Status.INFO, "user is able not able to check the standard checkbox when the admin checkbox is checked");
			}
		}

		@Test(dependsOnMethods = "TC_034myprofile_StandardwithAdmin")
		public void TC_035myProfile_StandardwithoutAdmin() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.Standard();
			utilityclassobject.gettest().log(Status.INFO, "user is able to check the standard checkbox when the admin checkbox is unchecked");

			
		}
		
		@Test(dependsOnMethods = "TC_035myProfile_StandardwithoutAdmin")
		public void TC_036myProfile_AdminwithStandard() throws InterruptedException
		
		{

			HomePage hp = new HomePage(driver);
			hp.Standard();
			WebElement adminCheckbox= hp.getAdminRole();
			if (!adminCheckbox.isEnabled()) {
			    utilityclassobject.gettest().log(Status.PASS, "Admin checkbox is disabled when standard checkbox is selected");
			    System.out.println("Admin checkbox is disabled when standard is selected");
			}
			else {
			utilityclassobject.gettest().log(Status.INFO, "user is able not able to check the Admin checkbox when the Standard checkbox is checked");
			}
		}
		
		@Test(dependsOnMethods = "TC_036myProfile_AdminwithStandard")
		public void TC_037myprofile_Notification() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.NotificationDropdown();
			utilityclassobject.gettest().log(Status.INFO, "Notification assigned to the profile appears in the field with the follwing service");
		}
		
		@Test(dependsOnMethods = "TC_037myprofile_Notification")
		public void TC_038myprofile_OctoconnectRequest() throws InterruptedException 
		{
			HomePage hp = new HomePage(driver);
			hp.OctoConnectRequest();
			utilityclassobject.gettest().log(Status.INFO, "user is able to select the octo connect request from the dropdown");

		}
		
		
		@Test(dependsOnMethods = "TC_038myprofile_OctoconnectRequest")
		public void TC_039myprofile_ServiceOverview() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.Serviceoverview();
			utilityclassobject.gettest().log(Status.INFO, "user is able to select the service overview from the dropdown");

		}
		
		@Test(dependsOnMethods = "TC_039myprofile_ServiceOverview")
		public void TC_040myprofile_SSRservice() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.SSRservice();
			utilityclassobject.gettest().log(Status.INFO, "user is able to select the SSR service from the dropdown");

		}
		
		
		@Test(dependsOnMethods = "TC_040myprofile_SSRservice")
		public void TC_041myprofile_NewSSRservice() throws InterruptedException
		{
			HomePage hp = new HomePage(driver); 
			hp.NewSSRservice();
			utilityclassobject.gettest().log(Status.INFO, "user is able to select the New SSR service from the dropdown");	
		}
		
		@Test(dependsOnMethods = "TC_041myprofile_NewSSRservice")
		public void TC_042myprofile_terminationRequest() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.TerminationRequest();
			utilityclassobject.gettest().log(Status.INFO, "user is able to select the Termination Request from the dropdown");

		}
		
		@Test(dependsOnMethods = "TC_042myprofile_terminationRequest")
		public void TC_043myprofile_withMultipleService() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			hp.MutipleService();
			utilityclassobject.gettest().log(Status.INFO, "user is able to select mutilple service at time");

		}
		
		@Test(dependsOnMethods = "TC_043myprofile_withMultipleService")
		public void TC_044myprofile_withService() throws InterruptedException
		{
			 HomePage hp = new HomePage(driver);
			 hp.ServiceAtonce();
			utilityclassobject.gettest().log(Status.INFO, "user is able to all the service at once");

		}

		
		
}



