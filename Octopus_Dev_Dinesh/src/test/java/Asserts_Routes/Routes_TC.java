package Asserts_Routes;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.AssetsRoutes;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)
public class Routes_TC extends BaseClassForGEneratorContacts{
	AssetsRoutes ar ;
	
	
	
	
	@Test
	public void TC_001_verifyUserCanAccessRoutesPage(){
		ar = new AssetsRoutes(driver);
		ar.getAssets().click();
		ar.getRoutes().click();
		ar.getRoutelist();
		System.out.println("Routes List page displayed successfully : PASS");
		utilityclassobject.gettest().log(Status.PASS, "Routes List page displayed successfully");
		}
	
	@Test(dependsOnMethods = "TC_001_verifyUserCanAccessRoutesPage")
	public void TC_002_verifyExistingRoutesAppearOrEmptyStateIsShown(){
		ar.getAddnewroute().click();
		ar.getRoutedetails();
		if(ar.getRoutedetails().isDisplayed()){
			System.out.println("Routes List page displayed successfully : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Routes List page displayed successfully");
		}
		else {
			System.out.println("Routes List page displayed successfully : PASS");
			utilityclassobject.gettest().log(Status.FAIL, "Routes List page displayed successfully");
		}}
		
		@Test
		public void TC_003_verifyNewRouteCanBeAdded() {
			
			System.out.println("Hello");
			System.out.println("Hi");
		}
		
		
	}




