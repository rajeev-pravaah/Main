package Octo_Connect;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	/*@Test(dependsOnMethods = "TC_001VerifySubcontractorService_IncomingSSR")
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
					
	}*/
	
	@Test(dependsOnMethods = "TC_001VerifySubcontractorService_IncomingSSR")
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
	

}
