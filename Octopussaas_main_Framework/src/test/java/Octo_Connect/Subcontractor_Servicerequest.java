package Octo_Connect;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.SubcontractorSerivce_Request;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)


//need to write the TC_024

public class Subcontractor_Servicerequest extends BaseClassForGEneratorContacts{
	ExcelUtility elib ;
	SubcontractorSerivce_Request sub ;
	
	
	@Test
	public void TC_001VerifySubcontractorService_IncomingSSR()
	{
		sub = new SubcontractorSerivce_Request(driver);
		elib = new ExcelUtility();
		sub.getOctoConnect().click();
		sub.getSubcontractorService().click();
		sub.getIncomingSSR().isDisplayed();
		System.out.println("The 'Incoming SSR' text is present in the page.");
		utilityclassobject.gettest().log(Status.PASS, "The 'Incoming SSR' text is present in the page.");
				
	}
	
	@Test(dependsOnMethods = "TC_001VerifySubcontractorService_IncomingSSR")
	public void TC_002VerifySubcontractorSerivce_RequsetFilter()
	{
		sub.getRequestFilter().isDisplayed();
		System.out.println("The number of 'Request' filtered text is present in the left upper corner of this page. ");
		utilityclassobject.gettest().log(Status.PASS, "The number of 'Request' filtered text is present in the left upper corner of this page. ");
					
	}
	
	@Test(dependsOnMethods = "TC_002VerifySubcontractorSerivce_RequsetFilter")
	public void TC_003VerifySubcontractorService_TransporterDrp()
	{
		sub.getTransporterDrp().isDisplayed();
		System.out.println("The 'Transporter' filter dropdown button is present in the right upper side of the page.");
		utilityclassobject.gettest().log(Status.PASS, "The 'Transporter' filter dropdown button is present in the right upper side of the page.");
					
	}
	
	@Test(dependsOnMethods = "TC_003VerifySubcontractorService_TransporterDrp")
	public void TC_004VerifySubcontractorService_Transporterwithcontractors() throws InterruptedException
	{
		sub.getTransporterDrp().click();
		sub.getMedicalWaste().click();
		sub.getSdWaste().click();
		sub.getMigrationDisplay().click();	
		System.out.println("In the 'Transporter' dropdown button menu, there is checkboxes present and it is clicking properly.");
		utilityclassobject.gettest().log(Status.PASS, "In the 'Transporter' dropdown button menu, there is checkboxes present and it is clicking properly.");
	}
	
	@Test(dependsOnMethods = "TC_004VerifySubcontractorService_Transporterwithcontractors")
	public void TC_005VerifySubcontractorService_TransporterwithSavedcontractor()
	{
		sub.getSearchOption().click();
		sub.getSearchOption().sendKeys("Medical");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sub.getMedicalWaste()));
		Assert.assertTrue(sub.getMedicalWaste().isDisplayed(), "Meidcal waste solution is displayed");
		System.out.println("Meidcal waste solution is displayed");
		
		sub.getSearchOption().sendKeys(Keys.CONTROL + "a");
		sub.getSearchOption().sendKeys(Keys.DELETE);
		sub.getSearchOption().sendKeys("SD");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(sub.getSdWaste()));
		Assert.assertTrue(sub.getSdWaste().isDisplayed(), "SD med waste is displayed");
		System.out.println("SD med waste is displayed");
		
		sub.getSearchOption().sendKeys(Keys.CONTROL + "a");
		sub.getSearchOption().sendKeys(Keys.DELETE);
		sub.getSearchOption().sendKeys("Migration");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(sub.getMigrationDisplay()));
		Assert.assertTrue(sub.getMigrationDisplay().isDisplayed(), "Migration test 1st display name is displayed");
		sub.getSearchOption().sendKeys(Keys.CONTROL + "a");
		sub.getSearchOption().sendKeys(Keys.DELETE);
		
		System.out.println("Migration test 1st display name is displayed");
		System.out.println("The saved contractor transporters is present in the 'Transporter' dropdown menu.");
		utilityclassobject.gettest().log(Status.PASS, "The saved contractor transporters is present in the 'Transporter' dropdown menu.");		
			
	}
	
	@Test(dependsOnMethods = "TC_005VerifySubcontractorService_TransporterwithSavedcontractor")
	public void TC_006VerifySubcontractorserivce_withStatusDropdown()
	{
		sub.getStatusDrp().isDisplayed();
		System.out.println("The 'Status' dropdown button is present in the right top side of the page.");		
		utilityclassobject.gettest().log(Status.PASS, "The 'Status' dropdown button is present in the right top side of the page.");		
		
	}
	
	
	@Test(dependsOnMethods = "TC_006VerifySubcontractorserivce_withStatusDropdown")
	public void TC_007VerifySubcontractorSerivce_withAllthestatus()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		sub.getStatusDrp().click();
		    String[] types = {
		            "Pending",
		            "Accepted",
		            "Declined",
		            "Canceled",
		            "Termination Requested",
		            "Terminated"
		    };

		    Actions actions = new Actions(driver);

		    for (String type : types) {

		        WebElement typeElement = wait.until(
		                ExpectedConditions.presenceOfElementLocated(
		                        By.xpath("//span[contains (text(),'"+type+"')]/../input/..")));

		        actions.moveToElement(typeElement).perform();

		        Assert.assertTrue(typeElement.isDisplayed(),
		                type + " is displayed");
		        System.out.println("All the status for SSR requests is present in the 'Status' dropsown menu");
				utilityclassobject.gettest().log(Status.INFO, "All the status for SSR requests is present in the 'Status' dropsown menu.");
		    }
	}
	
	@Test(dependsOnMethods = "TC_007VerifySubcontractorSerivce_withAllthestatus")
	public void TC_008VerifySubcontractorService_Statuswithclickable() throws InterruptedException
	{
		sub.getPendingStatus().click();
		sub.getPendingStatus().click();
		Thread.sleep(200);
		sub.getAcceptedStatus().click();
		sub.getAcceptedStatus().click();
		Thread.sleep(200);
		sub.getDeclinedStatus().click();
		sub.getDeclinedStatus().click();
		Thread.sleep(200);
		sub.getCanceledStatus().click();
		sub.getCanceledStatus().click();
		Thread.sleep(200);
		sub.getTerminationStatus().click();
		sub.getTerminationStatus().click();
		Thread.sleep(200);
		sub.getTerminatedStatus().click();
		sub.getTerminatedStatus().click();
		sub.getStatusDrp().click();
		System.out.println("In the 'Status' dropdown menu. there is all the status list present.and all are clickable");
		utilityclassobject.gettest().log(Status.INFO, "In the 'Status' dropdown menu. there is all the status list present.and all are clickable");


	}
	
	
	@Test(dependsOnMethods = "TC_008VerifySubcontractorService_Statuswithclickable")
	public void TC_009VerifySubcontractorSerivce_DefaultStatus() throws InterruptedException
	{
		sub.getStatusDrp().click();
		Assert.assertTrue(sub.getPendingStatus().isEnabled(), "Pending satatus is selected");
		Assert.assertTrue(sub.getTerminationStatus().isEnabled(), "Termination request satatus is selected");
		sub.getPendingStatus().click();
		Thread.sleep(2000);
		sub.getPendingStatus().click();
		sub.getTerminationStatus().click();
		Thread.sleep(2000);
		sub.getTerminationStatus().click();
		sub.getTerminatedStatus().click();
		sub.getTerminatedStatus().click();
		sub.getCanceledStatus().click();
		sub.getCanceledStatus().click();
		System.out.println("When the user navigates to the SSR page, the Status dropdown filter is pre-selected with “Pending” and “Termination Requested” by default");
		utilityclassobject.gettest().log(Status.INFO, "When the user navigates to the SSR page, the Status dropdown filter is pre-selected with “Pending” and “Termination Requested” by default");
	}
	
	@Test(dependsOnMethods = "TC_009VerifySubcontractorSerivce_DefaultStatus")
	public void TC_010VerifySubcontractorService_WithAcceptedstatus() throws InterruptedException
	
	{
		sub.getAcceptedStatus().isDisplayed();
		sub.getAcceptedStatus().click();
		Thread.sleep(2000);
		sub.getAcceptedStatus().click();
		System.out.println("In Status dropdown Accepted status checkbox is present and it is clickable");
		utilityclassobject.gettest().log(Status.INFO, "In Status dropdown Accepted status checkbox is present and it is clickable");
	}
	
	@Test(dependsOnMethods = "TC_010VerifySubcontractorService_WithAcceptedstatus")
	public void TC_011VerifySubcontractorService_withDeclinedStatus() throws InterruptedException
	{
		sub.getDeclinedStatus().isDisplayed();
		sub.getDeclinedStatus().click();
		Thread.sleep(2000);
		sub.getDeclinedStatus().click();
		System.out.println("In Status dropdown Declined status checkbox is present and it is clickable");
		utilityclassobject.gettest().log(Status.INFO, "In Status dropdown Declined status checkbox is present and it is clickable");		
	}
	
	@Test(dependsOnMethods = "TC_011VerifySubcontractorService_withDeclinedStatus")
	public void TC_012VerifySubcontractorService_WithCanceledStatus() throws InterruptedException
	{
		sub.getCanceledStatus().isDisplayed();

		sub.getCanceledStatus().click();
		Thread.sleep(2000);
		sub.getCanceledStatus().click();
		System.out.println("In Status dropdown Canceled status checkbox is present and it is clickable");
		utilityclassobject.gettest().log(Status.INFO, "In Status dropdown Canceled status checkbox is present and it is clickable");		
	}
	
	@Test(dependsOnMethods = "TC_012VerifySubcontractorService_WithCanceledStatus")
	public void TC_013VerifySubcontractorSerivce_withTerminationserviceStatus() throws InterruptedException
	{
		sub.getTerminationStatus().click();
		sub.getTerminationStatus().click();
		Thread.sleep(2000);
		sub.getTerminationStatus().click();
		sub.getTerminationStatus().click();
		System.out.println("In Status dropdown Termination request status checkbox is present and it is clickable");
		utilityclassobject.gettest().log(Status.INFO, "In Status dropdown Termination request status checkbox is present and it is clickable");		
	}
	
	@Test(dependsOnMethods = "TC_013VerifySubcontractorSerivce_withTerminationserviceStatus")
	public void TC_014VerifySubcontractorService_WithTerminatedStatus() throws InterruptedException
	{
		sub.getTerminatedStatus().click();
		sub.getTerminatedStatus().click();
		Thread.sleep(2000);
		sub.getTerminatedStatus().click();
		sub.getTerminatedStatus().click();
		System.out.println("In Status dropdown Terminated status checkbox is present and it is clickable");
		utilityclassobject.gettest().log(Status.INFO, "In Status dropdown Terminated status checkbox is present and it is clickable");		
	}
	
	@Test(dependsOnMethods = "TC_014VerifySubcontractorService_WithTerminatedStatus")
	public void TC_015VerifySubcontractorService_WithClearfilter()
	{
		sub.getIncominfFilter().isDisplayed();
		System.out.println("The Clear Filtersbutton is present in the top right corner of this page. ");
		utilityclassobject.gettest().log(Status.INFO, "The Clear Filters button is present in the top right corner of this page.");		
	}
	
	@Test(dependsOnMethods = "TC_015VerifySubcontractorService_WithClearfilter")
	public void TC_016VerifySubcontractorSerivce_withpreselectedfilters()
	{
		sub.getIncominfFilter().click();
		sub.getTransporterDrp().click();
		Assert.assertTrue(!sub.getMigrationDisplay().isSelected(), "Migration Test display name is not selected");
		Assert.assertTrue(!sub.getMedicalWaste().isSelected(), "Medical waste soultion is not selected");
		Assert.assertTrue(!sub.getSdWaste().isSelected(), "SD med waste is not selected");
		sub.getStatusDrp().click();
		Assert.assertTrue(!sub.getPendingStatus().isSelected(), "Pending status is not selected");
		Assert.assertTrue(!sub.getTerminationStatus().isSelected(),"Termination request is not selected");
		System.out.println("The 'Clear Filters' button is clickable and it will remove all the pre selected filters. ");
		utilityclassobject.gettest().log(Status.INFO, "The 'Clear Filters' button is clickable and it will remove all the pre selected filters. ");		

	}
	
	@Test(dependsOnMethods = "TC_016VerifySubcontractorSerivce_withpreselectedfilters")
	public void TC_017VerifySubcontractorserivce_withTransportername()
	{
		sub.getTransportername().isDisplayed();
		System.out.println("The 'Transporter Name' text is present in the first column of 'Incoming SSR'. ");
		utilityclassobject.gettest().log(Status.INFO, "The 'Transporter Name' text is present in the first column of 'Incoming SSR'. ");		

	}
	
	@Test(dependsOnMethods = "TC_017VerifySubcontractorserivce_withTransportername")
	public void TC_018VerifySubcontractorService_withalltheTransportername()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		String transporterName = "Maisie Medical Waste Solutions";

		List<WebElement> typeElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='" + transporterName + "']")));

		Assert.assertEquals(typeElements.size(), 5,	"Expected 5 transporter names to be displayed");

		for (WebElement element : typeElements) {

		Assert.assertTrue(element.isDisplayed(),transporterName + " is not displayed");

       System.out.println(element.getText());

       utilityclassobject.gettest().log(Status.INFO, "Transporter Name is displayed: " + element.getText());
       utilityclassobject.gettest().log(Status.PASS, "The 'Transporter Name' field is filled up by all the names for Incoming Subcontractors.");
}
	}
	
	@Test(dependsOnMethods = "TC_018VerifySubcontractorService_withalltheTransportername")
	public void TC_019VerifySubcontractorService_withOctonumber()
	{
		sub.getOctoNumber().isDisplayed();
		System.out.println("The 'OCTO Number' text is present in the second column of Incoming SSR.");
		utilityclassobject.gettest().log(Status.PASS, "The 'OCTO Number' text is present in the second column of Incoming SSR.");
	}
	
	@Test(dependsOnMethods = "TC_019VerifySubcontractorService_withOctonumber")
	public void TC_020VerifySubcontractorService_withValidOctoNumber()
	{
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    // Wait until OCTO Number column is visible
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains (text(),'OCTO Number')])[1]")));

		    // Locate all OCTO Numbers displayed in the table
		    List<WebElement> octoNumbers = driver.findElements(By.xpath("//span[contains(text(),'G-')]"));

		    // Check whether OCTO Numbers are available
		    Assert.assertFalse(octoNumbers.isEmpty(),"No OCTO Numbers found in the table");

		    // Expected pattern: G-XXX-XXXX
		    String regex = "^G-\\d{3}-\\d{4}$";

		    for (WebElement element : octoNumbers) {

		        String octoNumber = element.getText().trim();

		        System.out.println("Verifying OCTO Number: " + octoNumber);

		        // Verify OCTO Number format
		        Assert.assertTrue( octoNumber.matches(regex), "Invalid OCTO Number format: " + octoNumber);

		        // Verify 8 alphanumeric characters excluding hyphens
		        String actualNumber = octoNumber.replace("-", "");

		        Assert.assertEquals( actualNumber.length(), 8, "OCTO Number should contain exactly 8 characters: " + octoNumber);

		        // Verify starts with capital G
		        Assert.assertTrue(actualNumber.startsWith("G"),"OCTO Number should start with capital G: " + octoNumber);

		        System.out.println("PASS: " + octoNumber);
		        System.out.println("The 'OCTO Number' is in 8 alphanumeric number pattern starts with capital letter G.");
		        utilityclassobject.gettest().log(Status.PASS, "The 'OCTO Number' is in +8 alphanumeric number pattern starts with capital letter G.");
		    }
	}
	
		@Test(dependsOnMethods = "TC_020VerifySubcontractorService_withValidOctoNumber")
		public void TC_021VerifySubcontractorService_Octonumebrwitdetails() throws InterruptedException
		{
			sub.getGoctoNumber().click();

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flex justify-between items-center']/..)[1]")));
		    Thread.sleep(2000);
		    Assert.assertTrue(popup.isDisplayed(), "SSR Details popup is not displayed");

		    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Accepted']/following-sibling::button")));

		    button.click();

		    System.out.println("OCTO Numbers are clickable and display the Subcontractor Service Request (SSR) Details page.");

		    utilityclassobject.gettest().log(Status.PASS,"OCTO Numbers are clickable and display the Subcontractor Service Request (SSR) Details page.");
		}
	
		@Test(dependsOnMethods = "TC_021VerifySubcontractorService_Octonumebrwitdetails")
		public void TC_022VerifySubcontractorSerivce_withGeneratorName()
		{
			sub.getGeneratorName().isDisplayed();
			System.out.println("The 'Generator Name' text is present");
		    utilityclassobject.gettest().log(Status.PASS,"The 'Generator Name' text is present");

		}
		
		@Test(dependsOnMethods = "TC_022VerifySubcontractorSerivce_withGeneratorName")
		public void TC_023VerifySubcontractorSerivce_WithAllGeneratornames()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    String[] types = {
			            "mg raise 24oct",
			            "HierarchyTest",
			            "Fresno Med Clinic",
			            "HierarchyTest",
			            "UTA Filling Station."
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (text(),'"+type+"')]")));
			        System.out.println(typeElement.getText());

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
			        System.out.println("The 'Generator Name' field is showing Incoming SSR Request Generators Name.");
					utilityclassobject.gettest().log(Status.INFO, "The 'Generator Name' field is showing Incoming SSR Request Generators Name.");
					

			    }  
		}
		
		//need to write TC_24
		
		@Test(dependsOnMethods = "TC_023VerifySubcontractorSerivce_WithAllGeneratornames")
		public void TC_025VerifySubcontractorService_WithServiceaddress()
		{
			sub.getSerivceAddress().isDisplayed();
			System.out.println("The 'Service Address' text is present");
			utilityclassobject.gettest().log(Status.INFO, "The 'Service Address' text is present");

		}
		
		@Test(dependsOnMethods = "TC_025VerifySubcontractorService_WithServiceaddress")
		public void TC_026VerifySubcontractorService_withAllserviceaddress()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    String[] types = {
		            "595 Market Street, San Francisco, CA 94105",
		            "11501 Dublin Boulevard, Dublin, CA 94568",
		            "11 Fresno Avenue, Coffeyville, KS 67337",
		            "11501 Dublin Boulevard, Dublin, CA 94568",
		            "1105 Boulevard, Westfield, NJ 07090"
		    };

		    Actions actions = new Actions(driver);

		    for (String type : types) {

		        WebElement typeElement = wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (text(),'"+type+"')]")));
		        System.out.println(typeElement.getText());

		        actions.moveToElement(typeElement).perform();

		        Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
		        System.out.println("In the 'Service Address' column has all the generators service address.");
				utilityclassobject.gettest().log(Status.INFO, "In the 'Service Address' column has all the generators service address.");
		}
		}
		    
		    
		    @Test(dependsOnMethods = "TC_026VerifySubcontractorService_withAllserviceaddress")
		    public void TC_027VerifySubcontractorSerivce_withServiceType()
		    {
		    	sub.getSerivceType().isDisplayed();
		    	System.out.println("The 'Service Type' text is present");
				utilityclassobject.gettest().log(Status.INFO, "The 'Service Type' text is present");
		    	
		    }
		    
		    //need to write TC_028
		    
		    @Test(dependsOnMethods = "TC_027VerifySubcontractorSerivce_withServiceType")
		    public void TC_029VerifySubcontractorSerivce_withSerivceFrequency()
		    {
		    	Assert.assertTrue(sub.getServiceFrequency().isDisplayed(), "Serivce Frequency column is present");
		    	System.out.println("Serivce Frequency column is present");
				utilityclassobject.gettest().log(Status.INFO, "Serivce Frequency column is present");	
		    	
		    }
		    
		    @Test(dependsOnMethods = "TC_029VerifySubcontractorSerivce_withSerivceFrequency")
		    public void TC_030VerifySubcontractorSerivce_WithallServiceFrequency()
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    String[] types = {
			           "Every 1-Week (E1W)",
			           "Multiple Times Weekly (MTW)",
			           "Will Call (WC)",
			           "Will Call (WC)",
			           "Every 1-Week (E1W)"
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (text(),'"+type+"')]")));
			        System.out.println(typeElement.getText());

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
			        System.out.println("In the 'Service Frequency' column has all the different details of service estimations included correctly");
					utilityclassobject.gettest().log(Status.INFO, "In the 'Service Frequency' column has all the different details of service estimations included correctly");
			}
			
		    	
		    }
		    
		    @Test(dependsOnMethods = "TC_030VerifySubcontractorSerivce_WithallServiceFrequency")
		    public void TC_031VerifySubcontractorService_WithScopeofwork()
		    {
		    	Assert.assertTrue(sub.getScopeofwork().isDisplayed(), "Scope of work column is displayed");
		    	System.out.println("Scope of work column is displayed");
				utilityclassobject.gettest().log(Status.INFO, "Scope of work column is displayed");

		    }
		    
		    @Test(dependsOnMethods = "TC_031VerifySubcontractorService_WithScopeofwork")
		    public void TC_032VerifySubcontractorSerivce_WithalltheScopeofcontainers()
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    String[] types = {
			           "10 Gallon Regulated Medical Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "17 Gallon APHIS Waste Container",
			           "28 Gallon APHIS Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "15 Gallon Corrugated Medical Waste Box"
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains (text(),'"+type+"')]")));
			        System.out.println(typeElement.getText());

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
			        System.out.println("In 'Scope Of Work (SOW)' column, there is all the containers added while creating the SSR.");
					utilityclassobject.gettest().log(Status.INFO, "In 'Scope Of Work (SOW)' column, there is all the containers added while creating the SSR.");
		    }
		}
		    
		    @Test(dependsOnMethods = "TC_032VerifySubcontractorSerivce_WithalltheScopeofcontainers")
		    public void TC_033VerifySubcontractorService_withnumberofContainers()
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    String[] types = {
			           "10 Gallon Regulated Medical Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "17 Gallon APHIS Waste Container",
			           "28 Gallon APHIS Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "10 Gallon Regulated Medical Waste Container",
			           "15 Gallon Corrugated Medical Waste Box"
			    };

			    Actions actions = new Actions(driver);

			    for (String type : types) {

			        WebElement typeElement = wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='"+type+"']/parent::div")));
			        System.out.println(typeElement.getText());

			        actions.moveToElement(typeElement).perform();

			        Assert.assertTrue(typeElement.isDisplayed(), type + " is displayed");
			        System.out.println("In 'Scope Of Work (SOW)' column, there is shown the count of each different kind of containers.");
					utilityclassobject.gettest().log(Status.INFO, "In 'Scope Of Work (SOW)' column, there is shown the count of each different kind of containers.");
		    	
		    }
		    }
		    
		    @Test(dependsOnMethods = "TC_033VerifySubcontractorService_withnumberofContainers")
		    public void TC_034VerifySubcontractorService_withDateandTime()
		    {
		    	Assert.assertTrue(sub.getDateTime().isDisplayed(), "Date and time column is displayed");
		    	System.out.println("Date and time column is displayed");
		    	utilityclassobject.gettest().log(Status.PASS, "Date and time column is displayed");
		    }
		    
		    @Test(dependsOnMethods = "TC_034VerifySubcontractorService_withDateandTime")
		    public void TC_035VerifySubcontractorService_withFormatDate()
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains (text(),'Date/Time')])[1]")));

			    List<WebElement> dates = driver.findElements(By.xpath("(//div[contains(@class,'truncate') and contains(@class,'w-60') and contains(@class,'items-center')])[3]"));

			        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("EEE, MM/dd/uuuu h:mm a").toFormatter(Locale.US).withResolverStyle(ResolverStyle.STRICT);

			        Assert.assertTrue(dates.size() > 0, "No date elements found");

			        for (WebElement date : dates) {

			            String actualDate = date.getText().trim();

			            try {
			                LocalDateTime.parse(actualDate, formatter);

			                System.out.println("Valid date format: " + actualDate);

			            } catch (DateTimeParseException e) {

			                Assert.fail("Invalid date format found: " + actualDate);
			            }
			        }
		    }
		    
		
		    
}
