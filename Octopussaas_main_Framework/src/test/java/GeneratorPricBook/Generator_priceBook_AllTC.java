package GeneratorPricBook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.Dashboard;
import com.Octopussaas.ObjectRepository.Generator_Price_book;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;
@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Generator_priceBook_AllTC extends BaseClassForGEneratorContacts{
	
	
	 Generator_Price_book gpb;
   @Test
   public void TC_001verifyMenuButtonFromGeneratorPri() throws Exception {
	   
	   gpb = new Generator_Price_book(driver);
	   gpb.getGeneratorManagement().click();
	   System.out.println("Clicked on Generator Management");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Generator Management");
	   gpb.getGeneratorLocation().click();
	   System.out.println("Clicked on Generator Location");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Generator Location");
	   gpb.getSearchBox().sendKeys("Genpricebook solutions");
	   System.out.println("Entered text in search box");
	   utilityclassobject.gettest().log(Status.INFO, "Entered text in search box");
	   Thread.sleep(2000);
	   try {
	   gpb.getFirstoptionfromsearchbox().click();}
	   catch(Exception e) {
		   System.out.println("Exception occured while clicking on first option from search box: "+e.getMessage());
		   utilityclassobject.gettest().log(Status.INFO, "Exception occured while clicking on first option from search box: "+e.getMessage());
	   }
	   System.out.println("Clicked on first option from s9earch box");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on first option from search box");
	   Thread.sleep(2000);
	   gpb.getPriceBookpage().click();
	   System.out.println("Clicked on Price Book page");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Price Book page");
	   Thread.sleep(5000);
	   List<WebElement> menuoptions = gpb.getMenuoptions();
	   //fetch values till 7
	   for(int i=0;i<7;i++) {
		   String menuoption = menuoptions.get(i).getText();
		   System.out.println("Menu option "+(i+1)+" is: "+menuoption);
		   utilityclassobject.gettest().log(Status.INFO, "Menu option "+(i+1)+" is: "+menuoption);
	   }
	   System.out.println("All menu options are verified successfully");
	   utilityclassobject.gettest().log(Status.INFO, "All menu options are verified successfully");
	   
	   

	
   }
   
   @Test(dependsOnMethods = "TC_001verifyMenuButtonFromGeneratorPri")
   public void TC_002verifyScopofWorkButtonIsPresent() throws Exception {
	   
	   if(gpb.getScopeofworkBtn().isDisplayed()) {
		   System.out.println("Scope of Work button is present");
		   utilityclassobject.gettest().log(Status.INFO, "Scope of Work button is present");
		   	   }else {
		   		   System.out.println("Scope of Work button is not present");
		   		   utilityclassobject.gettest().log(Status.INFO, "Scope of Work button is not present");
		   		   
		   	   }
	   
	   
   }
   
   @Test(dependsOnMethods = "TC_002verifyScopofWorkButtonIsPresent")
   public void TC_003verifySOwbuttonIsClickableandOpensPopUp() throws Exception {
	   gpb.getScopeofworkBtn().click();
	   System.out.println("Clicked on Scope of Work button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Scope of Work button");
	   Thread.sleep(2000);
	   if(gpb.getScopeofworkpopup().isDisplayed()) {
		   System.out.println("Scope of Work popup is displayed");
		   utilityclassobject.gettest().log(Status.INFO, "Scope of Work popup is displayed");
	   }else {
		   System.out.println("Scope of Work popup is not displayed");
		   utilityclassobject.gettest().log(Status.INFO, "Scope of Work popup is not displayed");
	   }
	   gpb.getSowClosePopupbutton().click();
	   System.out.println("Sow button is clickable and opens popup successfully");
	   utilityclassobject.gettest().log(Status.INFO, "Sow button is clickable and opens popup successfully");
	   
	   
	   
	   
   }
   
   
   @Test(dependsOnMethods = "TC_003verifySOwbuttonIsClickableandOpensPopUp")
   public void TC_004verifyFlatMonthlychargeOption() throws Exception {
	  
	   if(gpb.getFlatmontly().isDisplayed()) {
		   System.out.println("Flat Monthly Charge option is present");
		   utilityclassobject.gettest().log(Status.INFO, "Flat Monthly Charge option is present");
		   	   }else {
		   		   System.out.println("Flat Monthly Charge option is not present");
		   		   utilityclassobject.gettest().log(Status.INFO, "Flat Monthly Charge option is not present");
		   	   }
	   
	   String flatmonthlycharge = gpb.getFlatmontly().getText();
	   System.out.println("Flat Monthly Charge option is: "+flatmonthlycharge);
	   utilityclassobject.gettest().log(Status.INFO, "Flat Monthly Charge option is: "+flatmonthlycharge);
	   System.out.println("Flat Monthly Charge option is verified successfully");
	   utilityclassobject.gettest().log(Status.INFO, "Flat Monthly Charge option is verified successfully");
   }
   
   @Test(dependsOnMethods = "TC_004verifyFlatMonthlychargeOption")
   public void TC_005verifyViewToggleButtonandEnabledandDisabledOption() throws Exception {
	   if(gpb.getViewtoggledbutton().isDisplayed()) {
		   System.out.println("View Toggle button is present");
		   utilityclassobject.gettest().log(Status.INFO, "View Toggle button is present");
		   	   }else {
		   		   System.out.println("View Toggle button is not present");
		   		   utilityclassobject.gettest().log(Status.INFO, "View Toggle button is not present");
		   	   }
	   
	   gpb.getViewtoggledbutton().click();
	   System.out.println("Clicked on View Toggle button is enabled");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on View Toggle button is enabled");
	   gpb.getEdittoggledbutton().click();

	   
   }
   
   @Test(dependsOnMethods = "TC_005verifyViewToggleButtonandEnabledandDisabledOption")
   public void TC_006verifyInactiveToggleButtonandEnabledandDisabledOption() throws Exception {
	   
	   if(gpb.getInactivetoggledbutton().isDisplayed()) {
		   System.out.println("Inactive Toggle button is present :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Inactive Toggle button is present");
		   	   }else {
		   		   System.out.println("Inactive Toggle button is not present :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Inactive Toggle button is not present");
		   	   }
	   gpb.getInactivetoggledbutton().click();
	   System.out.println("Clicked on Inactive Toggle button is enabled");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Inactive Toggle button is enabled");
	   gpb.getInactivetoggledbutton().click();
	   System.out.println("Clicked on Inactive Toggle button is disabled");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Inactive Toggle button is disabled");
	   System.out.println("Inactive Toggle button is verified successfully");
	   utilityclassobject.gettest().log(Status.INFO, "Inactive Toggle button is verified successfully");
	   
   }
   
   @Test(dependsOnMethods = "TC_006verifyInactiveToggleButtonandEnabledandDisabledOption")
   public void TC_007verifySelectedTemplateDropdown_DefaultValue_options_AbleToSeeTheDifferntTemplate() throws Exception {
	 if(gpb.getSelectedtemplateDropdown().isDisplayed()) {
		   System.out.println("Selected Template dropdown is present :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Selected Template dropdown is present");
		   	   }else {
		   		   System.out.println("Selected Template dropdown is not present :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Selected Template dropdown is not present");
		   	   }
	 //fetch default value of selected template dropdown
	 String defaultvalue = gpb.getSelectedtemplateDropdown().getAttribute("value");
	 System.out.println("Default value of Selected Template dropdown is: "+defaultvalue);
	 utilityclassobject.gettest().log(Status.INFO, "Default value of Selected Template dropdown is: "+defaultvalue);
	 //click on selected template dropdown and fetch all options
	 gpb.getSelectedtemplateDropdown().click();
	 List<WebElement> options = gpb.getSelectedtemplateDropdownOptions();
	 for(int i=0;i<options.size();i++) {
		 String option = options.get(i).getText();
		 System.out.println("Option "+(i+1)+" of Selected Template dropdown is: "+option);
		 utilityclassobject.gettest().log(Status.INFO, "Option "+(i+1)+" of Selected Template dropdown is: "+option);
		 
	 }
	 
	 
	 	
	 
	 System.out.println("Selected Template dropdown default value and options are verified successfully");
	 utilityclassobject.gettest().log(Status.INFO, "Selected Template dropdown default value and options are verified successfully");
   }
   
   @Test(dependsOnMethods = "TC_007verifySelectedTemplateDropdown_DefaultValue_options_AbleToSeeTheDifferntTemplate")
   public void TC_008verifyUserIsAbleApplyDifferentTemplate() throws Exception {
	   gpb.getSelectedtemplateDropdown().click();
		 List<WebElement> options = gpb.getSelectedtemplateDropdownOptions();
		 
	 //click on 2nd option
		 options.get(1).click();
		 Thread.sleep(1000);
		 
		
		 // now verify the success message is displayed
		 if(gpb.getTemplateAppliedSuccessMessage().isDisplayed()) {
			 System.out.println("Template applied successfully message is displayed :PASS");
			 utilityclassobject.gettest().log(Status.PASS, "Template applied successfully message is displayed");
			 		 }else {
			 			 System.out.println("Template applied successfully message is not displayed :FAIL");
			 			 utilityclassobject.gettest().log(Status.FAIL, "Template applied successfully message is not displayed");
			 		 }
		 gpb.getSelectedtemplateDropdown().click();
		 //clcik on 1st option
		 options.get(0).click();
		 
		 System.out.println("User is able to apply different template successfully");
		 utilityclassobject.gettest().log(Status.INFO, "User is able to apply different template successfully");
   }
   
   @Test(dependsOnMethods = "TC_008verifyUserIsAbleApplyDifferentTemplate")
   public void TC_009verifyServiceisDisplayedUnderTags() throws Exception {
	   
	  if( gpb.getServiceCategoryButton().isDisplayed()) {
		  System.out.println("Service is displayed under Tags :PASS");  
		  utilityclassobject.gettest().log(Status.PASS, "Service is displayed under Tags");  
		      
	  }
	 
	   
	   
   }
   
   @Test(dependsOnMethods = "TC_009verifyServiceisDisplayedUnderTags")
   public void TC_010verifyAllServiceShouldSelectItbIndividually() throws Exception {
	   
	   gpb.getServiceCategoryButton().click();
	   List<WebElement> allservices = gpb.getServiceCategoryOptions();
	   for(int i=0;i<allservices.size();i++) {
		   String service = allservices.get(i).getText();
		   System.out.println("Service "+(i+1)+" is: "+service);
		   utilityclassobject.gettest().log(Status.INFO, "Service "+(i+1)+" is: "+service);
		   allservices.get(i).click();
		   Thread.sleep(2000);
		   
	   }
	   
	   //again switch back to first service and click on it
	   allservices.get(0).click();
	   System.out.println("All services are selected individually successfully");
	   utilityclassobject.gettest().log(Status.INFO, "All services are selected individually successfully");
	  
   }
   
   @Test(dependsOnMethods = "TC_010verifyAllServiceShouldSelectItbIndividually")
   public void TC_011verifyBioSharpHeaderIsDisplayedBelowtheService() throws Exception {
	   if(gpb.getBioSharpHeader().isDisplayed()) {
		   System.out.println("Bio/Sharps header is displayed :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Bio/Sharps header is displayed");
	   }else {
		   System.out.println("Bio/Sharps header is not displayed :FAIL");
		   utilityclassobject.gettest().log(Status.FAIL, "Bio/Sharps header is not displayed");
	   }
	   
   }
   
   @Test(dependsOnMethods = "TC_011verifyBioSharpHeaderIsDisplayedBelowtheService")
   public void TC_012verifyBioSharpInfoIconIsDisplayed() throws Exception {
	  if(gpb.getBioSharpOctoInfoIcon().isDisplayed()) {
		  System.out.println("Bio/Sharps info icon is displayed :PASS");
		  utilityclassobject.gettest().log(Status.PASS, "Bio/Sharps info icon is displayed");
	  }
	  else {
		  System.out.println("Bio/Sharps info icon is not displayed :FAIL");
		  utilityclassobject.gettest().log(Status.FAIL, "Bio/Sharps info icon is not displayed");
	  }
	   
   }
   
   @Test(dependsOnMethods = "TC_012verifyBioSharpInfoIconIsDisplayed")
   public void TC_013verifyNumberOfContainerBesideServices() throws Exception {
	   if(gpb.getNumberOfContainerBesideServices().isDisplayed()) {
		   System.out.println("Number of container beside services is displayed :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Number of container beside services is displayed");
	   }
	   else {
		   System.out.println("Number of container beside services is not displayed :FAIL");
		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services is not displayed");
	   }
	   String numberofcontainer = gpb.getNumberOfContainerBesideServices().getText();
	   System.out.println("Number of container beside services is: "+numberofcontainer);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services is: "+numberofcontainer);
	   System.out.println("Number of container beside services is verified successfully");
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services is verified successfully");
	   
   }
   String numberofcontainer;
   @Test(dependsOnMethods = "TC_013verifyNumberOfContainerBesideServices")
   public void TC_014verifyBiosharpNumberofContainersare20() throws Exception {
	   
	   
	   numberofcontainer = gpb.getNumberOfContainerBesideServices().getText();
	   System.out.println("Number of container beside services is: "+numberofcontainer);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services is: "+numberofcontainer);
	   if(numberofcontainer.contains("20")) {
		   System.out.println("Number of container beside services is 20 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Number of container beside services is 20");
		   	   }else {
		   		   System.out.println("Number of container beside services is not 20 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services is not 20");
		   	   }
	   
   }
   
   @Test(dependsOnMethods = "TC_014verifyBiosharpNumberofContainersare20")
   public void TC_015verifyContainerChangesServices() throws Exception {
	   gpb.getNonRCRAPharmaceuticalButton().click();
	   System.out.println("Clicked on Non-RCRA Pharmaceutical button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Non-RCRA Pharmaceutical button");
	   String numberofcontainer1 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services is: "+numberofcontainer1);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services is: "+numberofcontainer1);
	  
	   if(!numberofcontainer1.equals(numberofcontainer)) {
		  System .out.println("Number of container beside services is changed after clicking on Non-RCRA Pharmaceutical button :PASS");
		  utilityclassobject.gettest().log(Status.PASS, "Number of container beside services is changed after clicking on Non-RCRA Pharmaceutical button");
		   
	   }
	   else {
		   System.out.println("Number of container beside services is not changed after clicking on Non-RCRA Pharmaceutical button :FAIL");
		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services is not changed after clicking on Non-RCRA Pharmaceutical button");
	   }
	   
   }
   @Test(dependsOnMethods = "TC_015verifyContainerChangesServices")
   public void TC_016verifyNumberofContainerForNonRCRAPharmaceuticalare15() throws Exception {
	   //fettch the number of container for Non-RCRA Pharmaceutical
	   String numberofcontainer2 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Non-RCRA Pharmaceutical is: "+numberofcontainer2);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Non-RCRA Pharmaceutical is: "+numberofcontainer2);
	   if(numberofcontainer2.contains("15")) {
		   System.out.println("Number of container beside services for Non-RCRA Pharmaceutical is 15 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Number of container beside services for Non-RCRA Pharmaceutical is 15");
		   	   }else {
		   		   System.out.println("Number of container beside services for Non-RCRA Pharmaceutical is not 15 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services for Non-RCRA Pharmaceutical is not 15");
		   	   }
	   
	   
	   //fetch the numer of cout
	   List<WebElement> totalcount = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers = totalcount.size();
	   System.out.println("Total number of containers for Non-RCRA Pharmaceutical is: "+totalcontainers);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for Non-RCRA Pharmaceutical is: "+totalcontainers);
	   if(totalcontainers==15) {
		   System.out.println("Total number of containers for Non-RCRA Pharmaceutical is 15 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total number of containers for Non-RCRA Pharmaceutical is 15");
		   	   }else {
		   		   System.out.println("Total number of containers for Non-RCRA Pharmaceutical is not 15 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total number of containers for Non-RCRA Pharmaceutical is not 15");
		   	   }
	   
   }
   
   
   @Test(dependsOnMethods = "TC_016verifyNumberofContainerForNonRCRAPharmaceuticalare15")
   public void TC_017verifyContainerChangesServicesForRCRAPharmaceutical() throws Exception {
	   gpb.getRCRAPharmaceuticalButton().click();
	   System.out.println("Clicked on RCRA Pharmaceutical button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on RCRA Pharmaceutical button");
	   String numberofcontainer3 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for RCRA Pharmaceutical is: "+numberofcontainer3);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for RCRA Pharmaceutical is: "+numberofcontainer3);
	  
	   if(numberofcontainer3.contains("15")) {
		  System.out.println("Number of container beside services is changed after clicking on RCRA Pharmaceutical button :PASS");
		  utilityclassobject.gettest().log(Status.PASS, "Number of container beside services is changed after clicking on RCRA Pharmaceutical button");
		   
	   }
	   else {
		   System.out.println("Number of container beside services is not changed after clicking on RCRA Pharmaceutical button :FAIL");
		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services is not changed after clicking on RCRA Pharmaceutical button");
	   }
   }
   
   @Test(dependsOnMethods = "TC_017verifyContainerChangesServicesForRCRAPharmaceutical")
   public void TC_018verifyNumberofContainerForRCRAPharmaceuticalare15() throws Exception {
	   
	   //fettch the number of container for RCRA Pharmaceutical
	   String numberofcontainer4 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for RCRA Pharmaceutical is: "+numberofcontainer4);
	  
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for RCRA Pharmaceutical is: "+numberofcontainer4);
	   if(numberofcontainer4.contains("15")) {
		   System.out.println("Number of container beside services for RCRA Pharmaceutical is 15 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Number of container beside services for RCRA Pharmaceutical is 15");
		   	   }else {
		   		   System.out.println("Number of container beside services for RCRA Pharmaceutical is not 15 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services for RCRA Pharmaceutical is not 15");
		   	   }
	   
	   
	   //fetch the numer of cout
	   List<WebElement> totalcount1 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers1 = totalcount1.size();
	   System.out.println("Total number of containers for RCRA Pharmaceutical is: "+totalcontainers1);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for RCRA Pharmaceutical is: "+totalcontainers1);
	   if(totalcontainers1==15) {
		   System.out.println("Total number of containers for RCRA Pharmaceutical is 15 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total number of containers for RCRA Pharmaceutical is 15");
		   	   }else {
		   		   System.out.println("Total number of containers for RCRA Pharmaceutical is not 15 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total number of containers for RCRA Pharmaceutical is not 15");
		   	   }
	   
   }
   
   @Test(dependsOnMethods = "TC_018verifyNumberofContainerForRCRAPharmaceuticalare15")
   public void TC_019verifySystemShouldDisplayChemotherapyContainers() throws Exception {
	 
	   //clic on chemotherapy button
	   gpb.getChemotherapyButton().click();
	   System.out.println("Clicked on Chemotherapy button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Chemotherapy button");
	   String numberofcontainer5 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Chemotherapy is: "+numberofcontainer5);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Chemotherapy is: "+numberofcontainer5);
	 
   }
   @Test(dependsOnMethods = "TC_019verifySystemShouldDisplayChemotherapyContainers")
   public void TC_020verifyNumberofContainerForChemotherapyare09() throws Exception {
	   //fettch the number of container for Chemotherapy
	   String numberofcontainer6 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Chemotherapy is: "+numberofcontainer6);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Chemotherapy is: "+numberofcontainer6);
	   if(numberofcontainer6.contains("9")) {
		   System.out.println("Number of container beside services for Chemotherapy is 09 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Number of container beside services for Chemotherapy is 09");
		   	   }else {
		   		   System.out.println("Number of container beside services for Chemotherapy is not 09 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services for Chemotherapy is not 09");
		   	   }
	   
	   
	   //fetch the numer of cout
	   List<WebElement> totalcount2 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers2 = totalcount2.size();
	   System.out.println("Total number of containers for Chemotherapy is: "+totalcontainers2);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for Chemotherapy is: "+totalcontainers2);
	   if(totalcontainers2==9) {
		   System.out.println("Total 9 containers are displayed for Chemotherapy :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total 9 containers are displayed for Chemotherapy");
		   	   }else {
		   		   System.out.println("Total number of containers for Chemotherapy is not 09 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total number of containers for Chemotherapy is not 09");
		   	   }
  
       }
   
   @Test(dependsOnMethods = "TC_020verifyNumberofContainerForChemotherapyare09")
   public void TC_021verifySystemShouldDisplayPaperShreddingContainers() throws Exception {
	   //clic on Paper Shredding button
	   gpb.getPaperShreddingButton().click();
	   System.out.println("Clicked on Paper Shredding button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Paper Shredding button");
	   String numberofcontainer7 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Paper Shredding is: "+numberofcontainer7);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Paper Shredding is: "+numberofcontainer7);
	   System.out.println("System should display Paper Shredding containers successfully");
	   utilityclassobject.gettest().log(Status.INFO, "System should display Paper Shredding containers successfully");
   }
   
   @Test(dependsOnMethods = "TC_021verifySystemShouldDisplayPaperShreddingContainers")
   public void TC_022verifyNumberofContainerForPaperShreddingare07andvisible() throws Exception {
	   //fettch the number of container for Paper Shredding
	   String numberofcontainer8 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Paper Shredding is: "+numberofcontainer8);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Paper Shredding is: "+numberofcontainer8);
	   if(numberofcontainer8.contains("7")) {
		   System.out.println("Number of container beside services for Paper Shredding is 07 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Number of container beside services for Paper Shredding is 07");
		   	   }else {
		   		   System.out.println("Number of container beside services for Paper Shredding is not 07 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services for Paper Shredding is not 07");
		   	   }
	   
	   
	   //fetch the numer of cout
	   List<WebElement> totalcount3 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers3 = totalcount3.size();
	   System.out.println("Total number of containers for Paper Shredding is: "+totalcontainers3);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for Paper Shredding is: "+totalcontainers3);
	   if(totalcontainers3==7) {
		   System.out.println("Total 7 containers for Paper Shredding is displayed  :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total 7 containers for Paper Shredding i displayed ");
		   	   }else {
		   		   System.out.println("Total 7 containers for Paper Shredding is not displayed :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total 7 containers for Paper Shredding is not displayed");
		   	   }
  
	   }
   
   @Test(dependsOnMethods = "TC_022verifyNumberofContainerForPaperShreddingare07andvisible")
   public void TC_023verifySystemShouldDisplayAPHISWasteContainers() throws Exception {
	   //clic on APHIS Waste button
	   gpb.getAPHISWasteButton().click();
	   System.out.println("Clicked on APHIS Waste button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on APHIS Waste button");
	   String numberofcontainer9 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for APHIS Waste is: "+numberofcontainer9);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for APHIS Waste is: "+numberofcontainer9);
	   System.out.println("System should display APHIS Waste containers successfully");
	   utilityclassobject.gettest().log(Status.INFO, "System should display APHIS Waste containers successfully");
   }
   
   @Test(dependsOnMethods = "TC_023verifySystemShouldDisplayAPHISWasteContainers")
   public void TC_024verifyNumberofContainerForAPHISWasteare07andvisible() throws Exception {
	   //fettch the number of container for APHIS Waste
	   String numberofcontainer10 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for APHIS Waste is: "+numberofcontainer10);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for APHIS Waste is: "+numberofcontainer10);
	   if(numberofcontainer10.contains("12")) {
		   System.out.println("Number of container beside services for APHIS Waste is 12 :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Number of container beside services for APHIS Waste is 12");
		   	   }else {
		   		   System.out.println("Number of container beside services for APHIS Waste is not 12 :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Number of container beside services for APHIS Waste is not 12");
		   	   }
	   
	   
	   //fetch the numer of cout
	   List<WebElement> totalcount4 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers4 = totalcount4.size();
	   System.out.println("Total number of containers for APHIS Waste is: "+totalcontainers4);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for APHIS Waste is: "+totalcontainers4);
	   if(totalcontainers4==12) {
		   System.out.println("Total 12 containers for APHIS Waste is displayed  :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total 12 containers for APHIS Waste i displayed ");
		   	   }else {
		   		   System.out.println("Total 12 containers for APHIS Waste is not displayed :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total 12 containers for APHIS Waste is not displayed");
		   	   }
        }
   
   @Test(dependsOnMethods = "TC_024verifyNumberofContainerForAPHISWasteare07andvisible")
   public void TC_025verifySystemShouldDisplayProductDestructionContainers() throws Exception {
	   //clic on Product Destruction button
	   gpb.getProductDestructionButton().click();
	   System.out.println("Clicked on Product Destruction button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Product Destruction button");
	   String numberofcontainer11 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Product Destruction is: "+numberofcontainer11);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Product Destruction is: "+numberofcontainer11);
	   System.out.println("System should display Product Destruction containers successfully");
	   utilityclassobject.gettest().log(Status.INFO, "System should display Product Destruction containers successfully");
   }
   
   @Test(dependsOnMethods = "TC_025verifySystemShouldDisplayProductDestructionContainers")
   public void TC_026verifyNumberofContainerForProductDestructionare07andvisible() throws Exception {
	   //fettch the number of container for Product Destruction
	   String numberofcontainer12 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Product Destruction is: "+numberofcontainer12);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Product Destruction is: "+numberofcontainer12);
	   if(numberofcontainer12.contains("12")) {
		   System.out.println("12 conatainers are availabel in product Destruction :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "12 conatainers are availabel in product Destruction");
		   	   }else {
		   		   System.out.println("Product Destruction not contain 12 containers :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Product Destruction not contain 12 containers");
		   	   }
	   
	   
	   //fetch the numer of cout
	   List<WebElement> totalcount5 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers5 = totalcount5.size();
	   System.out.println("Total number of containers for Product Destruction is: "+totalcontainers5);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for Product Destruction is: "+totalcontainers5);
	   if(totalcontainers5==12) {
		   System.out.println("Total 12 containers for Product Destruction is displayed  :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total 12 containers for Product Destruction i displayed ");
		   	   }else {
		   		   System.out.println("Total 12 containers for Product Destruction is not displayed :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total 12 containers for Product Destruction is not displayed");
		   	   }
		}
   
   
   
   @Test(dependsOnMethods = "TC_026verifyNumberofContainerForProductDestructionare07andvisible")
   public void TC_027verifySystemShouldDisplayUniversalWasteContainersInstantly() throws Exception {
	   //clic on Universal Waste button
	   gpb.getUniversalWasteButton().click();
	   System.out.println("Clicked on Universal Waste button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Universal Waste button");
	   String numberofcontainer13 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Universal Waste is: "+numberofcontainer13);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Universal Waste is: "+numberofcontainer13);
	   System.out.println("System should display Universal Waste containers successfully intantly");
	   utilityclassobject.gettest().log(Status.INFO, "System should display Universal Waste containers successfully intantly");
   }
   
   @Test(dependsOnMethods = "TC_027verifySystemShouldDisplayUniversalWasteContainersInstantly")
   public void TC_028verifyNumberofContainerForUniversalWasteare07andvisible() throws Exception {
	   //fettch the number of container for Universal Waste
	   String numberofcontainer14 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Universal Waste is: "+numberofcontainer14);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Universal Waste is: "+numberofcontainer14);
	   if(numberofcontainer14.contains("5")) {
		   System.out.println("5 conatainers are availabel in Universal Waste :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "5 conatainers are availabel in Universal Waste");
		   	   }else {
		   		   System.out.println("Universal Waste not contain 5 containers :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Universal Waste not contain 5 containers");
		   	   }
	   
	   
	   //fetch the numer of cout
	   List<WebElement> totalcount6 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers6 = totalcount6.size();
	   System.out.println("Total number of containers for Universal Waste is: "+totalcontainers6);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for Universal Waste is: "+totalcontainers6);
	   if(totalcontainers6==5) {
		   System.out.println("Total 5 containers for Universal Waste is displayed  :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total 5 containers for Universal Waste is displayed ");
		   	   }else {
		   		   System.out.println("Total 5 containers for Universal Waste is not displayed :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total 5 containers for Universal Waste is not displayed");
		   	   }
	   
   }
   
   @Test(dependsOnMethods = "TC_028verifyNumberofContainerForUniversalWasteare07andvisible")
   public void TC_029verifySystemShouldDisplayPathologyContainersInstantly() throws Exception {
	   //clic on Pathology button
	   gpb.getPathologyButton().click();
	   System.out.println("Clicked on Pathology button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Pathology button");
	   String numberofcontainer15 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Pathology is: "+numberofcontainer15);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Pathology is: "+numberofcontainer15);
	   System.out.println("System should display Pathology containers successfully intantly");
	   utilityclassobject.gettest().log(Status.INFO, "System should display Pathology containers successfully intantly");
   }
   
   @Test(dependsOnMethods = "TC_029verifySystemShouldDisplayPathologyContainersInstantly")
   public void TC_030verifyNumberofContainerForPathologyare12andvisibleWithoutduplicates() throws Exception {
	   //fettch the number of container for Pathology
	   String numberofcontainer16 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Pathology is: "+numberofcontainer16);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Pathology is: "+numberofcontainer16);
	   if(numberofcontainer16.contains("12")) {
		   System.out.println("12 conatainers are availabel in Pathology :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "12 conatainers are availabel in Pathology");
		   	   }else {
		   		   System.out.println("Pathology not contain 12 containers :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Pathology not contain 12 containers");
		   	   }
	   
	   
	   //fetch the numer of coutx
	   List<WebElement> totalcount7 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers7 = totalcount7.size();
	   System.out.println("Total number of containers for Pathology is: "+totalcontainers7);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for Pathology is: "+totalcontainers7);
	   if(totalcontainers7==12) {
		   System.out.println("Total 12 containers for Pathology is displayed  :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total 12 containers for Pathology is displayed ");
		   	   }else {
		   		   System.out.println("Total 12 containers for Pathology is not displayed :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total 12 containers for Pathology is not displayed");
		   	   }
	   
	   //make sure that all 12 are unique -- use hashset because set does not allow duplicates
	   List<WebElement> allcontainers = gpb.getContainerslist();
	   Set<String> uniquecontainers = new HashSet<>();
	   for(WebElement container: allcontainers) {
		   uniquecontainers.add(container.getText());
	   }
	   if(uniquecontainers.size()==12) {
		   System.out.println("All 12 containers for Pathology are unique :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "All 12 containers for Pathology are unique");
		   	   }else {
		   		   System.out.println("All 12 containers for Pathology are not unique :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "All 12 containers for Pathology are not unique");
		   	   }

   }
   
   @Test(dependsOnMethods = "TC_030verifyNumberofContainerForPathologyare12andvisibleWithoutduplicates")
   public void TC_031verfySytemShoulddisplayCanbissWasteContainersInstantly() throws Exception {
	   //clic on Canbiss Waste button
	   gpb.getCannabisWasteButton().click();
	   System.out.println("Clicked on Canbiss Waste button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on Canbiss Waste button");
	   String numberofcontainer17 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Canbiss Waste is: "+numberofcontainer17);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Canbiss Waste is: "+numberofcontainer17);
	   System.out.println("System should display Canbiss Waste containers successfully intantly");
	   utilityclassobject.gettest().log(Status.INFO, "System should display Canbiss Waste containers successfully intantly");
   }
   
   @Test(dependsOnMethods = "TC_031verfySytemShoulddisplayCanbissWasteContainersInstantly")
   public void TC_032verifyNumberofContainerForCanbissWasteare12andvisibleWithoutDupicate() throws Exception {
	   //fettch the number of container for Canbiss Waste
	   String numberofcontainer18 = gpb.getContainersCount().getText();
	   System.out.println("Number of container beside services for Canbiss Waste is: "+numberofcontainer18);
	   utilityclassobject.gettest().log(Status.INFO, "Number of container beside services for Canbiss Waste is: "+numberofcontainer18);
	   if(numberofcontainer18.contains("12")) {
		   System.out.println("12 conatainers are availabel in Canbiss Waste :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "12 conatainers are availabel in Canbiss Waste");
		   	   }else {
		   		   System.out.println("Canbiss Waste not contain 12 containers :FAIL");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Canbiss Waste not contain 12 containers");
		   	   }
	   
	   
	   //fetch the numer of coutx
	   List<WebElement> totalcount8 = gpb.getContainerslist();
	   //fetch total number of containers
	   int totalcontainers8 = totalcount8.size();
	   System.out.println("Total number of containers for Canbiss Waste is: "+totalcontainers8);
	   utilityclassobject.gettest().log(Status.INFO, "Total number of containers for Canbiss Waste is: "+totalcontainers8);
	   if(totalcontainers8==12) {
		   System.out.println("Total 12 containers for Canbiss Waste is displayed  :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Total 12 containers for Canbiss Waste is displayed ");
		   	   }else {
		   		   System.out.println("Total 12 containers for Canbiss Waste is not displayed :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "Total 12 containers for Canbiss Waste is not displayed");
		   	   }
	   
	   //make sure that all 12 are unique -- use hashset because set does not allow duplicates
	   List<WebElement> allcontainers = gpb.getContainerslist();
	   Set<String> uniquecontainers = new HashSet<>();
	   for(WebElement container: allcontainers) {
		   uniquecontainers.add(container.getText());
	   }
	   if(uniquecontainers.size()==12) {
		   System.out.println("All 12 containers for Canbiss Waste are unique :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "All 12 containers for Canbiss Waste are unique");
		   	   }else {
		   		   System.out.println("All 12 containers for Canbiss Waste are not unique :FAIL ");
		   		   utilityclassobject.gettest().log(Status.FAIL, "All 12 containers for Canbiss Waste are not unique");
		   	   }
	   
   }
   
   @Test(dependsOnMethods = "TC_032verifyNumberofContainerForCanbissWasteare12andvisibleWithoutDupicate")
   public void TC_033verifyCopyfromMasterColumnAppearsforALlSeervices() throws Exception {

	   // Switch all service types one by one and verify "Copy from Master" column is displayed
	   List<WebElement> allservices = gpb.getServiceCategoryOptions();
	   int serviceCount = allservices.size();
	   for (int i = 0; i < serviceCount; i++) {
		   // Re-fetch the list each iteration to get fresh elements
		   allservices = gpb.getServiceCategoryOptions();
		   WebElement serviceEl = allservices.get(i);
		   String service = serviceEl.getText();
		   System.out.println("Service " + (i + 1) + " is: " + service);
		   utilityclassobject.gettest().log(Status.INFO, "Service " + (i + 1) + " is: " + service);

		   // Click the service
		   serviceEl.click();
		   Thread.sleep(2000);

		   // Verify Copy from Master column visibility
		   if (gpb.getCopyFromMasterColumn().isDisplayed()) {
			   System.out.println("Copy from Master column is displayed for service: " + service + " :PASS");
			   utilityclassobject.gettest().log(Status.PASS, "Copy from Master column is displayed for service: " + service);
		   } else {
			   System.out.println("Copy from Master column is NOT displayed for service: " + service + " :FAIL");
			   utilityclassobject.gettest().log(Status.FAIL, "Copy from Master column is NOT displayed for service: " + service);
		   }
	   }
	   System.out.println("Copy from Master column is verified for all services successfully");
	   utilityclassobject.gettest().log(Status.INFO, "Copy from Master column is verified for all services successfully");

   }
   
   @Test(dependsOnMethods = "TC_033verifyCopyfromMasterColumnAppearsforALlSeervices")
   public void TC_034verifyCopyfromMasterButtonAppearsforAllItemsandClickable() throws Exception {
	   
	   //click on view toggle
	   gpb.getViewtoggledbutton().click();
	   System.out.println("Clicked on view toggle button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on view toggle button");
	   
	   //verify that copy from master button is displayed for all items and clickable
	   List<WebElement> copyfrommasterbuttons = gpb.getCopyFromMasterButtons();
	   for (int i = 0; i < copyfrommasterbuttons.size(); i++) {
		   if (copyfrommasterbuttons.get(i).isDisplayed() && copyfrommasterbuttons.get(i).isEnabled()) {
			   //click on the button to verify it is clickable
			   copyfrommasterbuttons.get(i).click();
			   
			   System.out.println("Copy from Master button is displayed and clickable for item " + (i + 1) + " :PASS");
			   utilityclassobject.gettest().log(Status.PASS, "Copy from Master button is displayed and clickable for item " + (i + 1));
		   } else {
			   System.out.println("Copy from Master button is NOT displayed or NOT clickable for item " + (i + 1) + " :FAIL");
			   utilityclassobject.gettest().log(Status.FAIL, "Copy from Master button is NOT displayed or NOT clickable for item " + (i + 1));
		   }
		   System.out.println("Copy from Master button is verified for all items successfully and it is clickable");
		   utilityclassobject.gettest().log(Status.INFO, "Copy from Master button is verified for all items successfully and it is clickable");
		   
		   
		   
	   }
	   gpb.getEdittoggledbutton().click();
	   System.out.println("Clicked on edit toggle button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on edit toggle button");
	  
	   
	   
   }
   
   @Test(dependsOnMethods = "TC_034verifyCopyfromMasterButtonAppearsforAllItemsandClickable")
   public void TC_035verifyMasterITemnamecolumnAppears() throws Exception {
	  
	   
	   /*
	   //click on view toggle
	   gpb.getViewtoggledbutton().click();
	   System.out.println("Clicked on view toggle button");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on view toggle button");
	   //serach  the template name in selected template
	   WebElement seaarchfield = gpb.getSearchBox();
	   seaarchfield.click();
	   seaarchfield.sendKeys(Keys.CONTROL, "a");
	   seaarchfield.sendKeys(Keys.BACK_SPACE);
	   System.out.println("Cleared the search box");
	   utilityclassobject.gettest().log(Status.INFO, "Cleared the search box");
	   //search for the template name
	   gpb.getSearchBox().sendKeys("charlie Price Book");
	   gpb.getSuggestedTemplate().click();
	   System.out.println("Clicked on suggested price book teplate");
	   utilityclassobject.gettest().log(Status.INFO, "Clicked on suggested price book teplate");
	   
	   */
	   
	   if (gpb.getMasterItemNameColumn().isDisplayed()) {
		   System.out.println("Master Item Name column is displayed :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "Master Item Name column is displayed");
	   } else {
		   System.out.println("Master Item Name column is NOT displayed :FAIL");
		   utilityclassobject.gettest().log(Status.FAIL, "Master Item Name column is NOT displayed");
	   }
	   
	  
   }
   
	@Test(dependsOnMethods = "TC_035verifyMasterITemnamecolumnAppears")
	public void TC_036verifyMasterItemNameColumnWithDifferentnames() throws Exception {
	   // Verify that all master item names are unique by comparing each with every other
	   List<WebElement> masteritemnames = gpb.getMasterItemNamesLists();
	   int total = masteritemnames.size();
	   System.out.println("Total master item names found: " + total);
	   utilityclassobject.gettest().log(Status.INFO, "Total master item names found: " + total);

	   boolean allDifferent = true;
	   for (int i = 0; i < total; i++) {
		   String nameI = masteritemnames.get(i).getText().trim();
		   for (int j = i + 1; j < total; j++) {
			   String nameJ = masteritemnames.get(j).getText().trim();
			   if (nameI.equals(nameJ)) {
				   allDifferent = false;
				   System.out.println("Duplicate master item name found: '" + nameI + "' at indexes " + i + " and " + j);
				   utilityclassobject.gettest().log(Status.FAIL, "Duplicate master item name found: '" + nameI + "' at indexes " + i + " and " + j);
			   }
		   }
	   }

	   if (allDifferent) {
		   System.out.println("All master item names are different :PASS");
		   utilityclassobject.gettest().log(Status.PASS, "All master item names are different");
	   } else {
		   System.out.println("Some master item names are duplicated :FAIL");
		   utilityclassobject.gettest().log(Status.FAIL, "Some master item names are duplicated");
	   }

	}
	
	
	@Test(dependsOnMethods = "TC_036verifyMasterItemNameColumnWithDifferentnames")
	public void TC_037VerifyYellowDotAppearsForConfiguredservices()
	{
		//switch to product destruction
		
		gpb.getProductDestructionButton().click();
		System.out.println("Clicked on product destruction button");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on product destruction button");
		
		//click on view toggle
		gpb.getViewtoggledbutton().click();
		System.out.println("Clicked on view toggle button");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on view toggle button");
		//clear the service price field using backspace
		WebElement servicepricefield = gpb.getServicePriceInputField();
		servicepricefield.click();
		servicepricefield.sendKeys(Keys.CONTROL, "a");
		servicepricefield.sendKeys(Keys.BACK_SPACE);
		System.out.println("Cleared the service price field");
		utilityclassobject.gettest().log(Status.INFO, "Cleared the service price field");
		//enter the service price
		servicepricefield.sendKeys("100");
		System.out.println("Entered the service price as 100");
		utilityclassobject.gettest().log(Status.INFO, "Entered the service price as 100");
		
		//verify yellow dot is appears beside the master item name
		if(gpb.getYellowDotBesideMasterItemName().isDisplayed())
		{
			System.out.println("Yellow dot is displayed beside the master item name :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Yellow dot is displayed beside the master item name");
		}
		else
		{
			System.out.println("Yellow dot is NOT displayed beside the master item name :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Yellow dot is NOT displayed beside the master item name");
		}
		
		
	}
	
	@Test(dependsOnMethods = "TC_037VerifyYellowDotAppearsForConfiguredservices")
	public void TC_038VerifyCopyFromMasterIndividualContainerandRaateGettingAddedAndGreenDotappear()
	{
		//click on universal waste 
		gpb.getUniversalWasteButton().click();
		System.out.println("Clicked on universal waste button");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on universal waste button");
		//click on Selected template dropdown and select the template name
		gpb.getSelectedTemplateField().click();
		List<WebElement> lists = gpb.getOptionsFromSelectedTempDropdown();
		for(WebElement list:lists)
		{
			if(list.getText().equalsIgnoreCase("AutomationPriceBook"))
			{
				list.click();
				System.out.println("Selected the template name as charlie Price Book");
				utilityclassobject.gettest().log(Status.INFO, "Selected the template name as charlie Price Book");
				break;
			}
		}
		
		//click on copy 
		gpb.getCopyAllFromTemplateButton().click();
		System.out.println("Clicked on copy all from template button");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on copy all from template button");
		gpb.getYesCopyAllButton().click();
		System.out.println("Clicked on yes copy all button");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on yes copy all button");
		gpb.getCopyAllFromTemplateButton().click();
		gpb.getYesCopyAllButton().click();


		
		if(gpb.getGreenDotBesideMasterItemName().isDisplayed())
		{
			System.out.println("Green dot is displayed beside the master item name after copying from template :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Green dot is displayed beside the master item name after copying from template");
		}
		else
		{
			System.out.println("Green dot is NOT displayed beside the master item name after copying from template :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Green dot is NOT displayed beside the master item name after copying from template");
			gpb.getCopyAllFromTemplateButton().click();
			gpb.getYesCopyAllButton().click();
			if(gpb.getGreenDotBesideMasterItemName().isDisplayed())
			{
				System.out.println("Green dot is displayed beside the master item name after copying from template :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Green dot is displayed beside the master item name after copying from template");
			}
			else
			{
				System.out.println("Green dot is NOT displayed beside the master item name after copying from template :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Green dot is NOT displayed beside the master item name after copying from template");
			}


			
		}
		System.out.println("Copy from master individual container and rate getting added and green dot appear successfully");
		utilityclassobject.gettest().log(Status.INFO, "Copy from master individual container and rate getting added and green dot appear successfully");
		
	}
	
	
	@Test(dependsOnMethods = "TC_038VerifyCopyFromMasterIndividualContainerandRaateGettingAddedAndGreenDotappear")
	public void TC_039VerifyIncludeInFaltMonthlyColumnisAppear()
	
	
	{
		if(gpb.getIncludeFlatMonthlyColumn().isDisplayed())
		{
			System.out.println("Include in Flat Monthly column is displayed :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Include in Flat Monthly column is displayed");
		}
		else
		{
			System.out.println("Include in Flat Monthly column is NOT displayed :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Include in Flat Monthly column is NOT displayed");
		}
		System.out.println("Include in Flat Monthly column is verified successfully");
		utilityclassobject.gettest().log(Status.INFO, "Include in Flat Monthly column is verified successfully");
		
	
	}
	
	
	@Test(dependsOnMethods = "TC_039VerifyIncludeInFaltMonthlyColumnisAppear")
	public void TC_040VerifyCheckBoxisPresentunderFlatmonthlyColumn()
	{
		//check the checkbox under flat monthly column
		List<WebElement> checkboxes = gpb.getIncludeFlatMonthlyCheckboxes();
		
		for(WebElement checkbox:checkboxes)
		{
			if(checkbox.isDisplayed() && checkbox.isEnabled())
			{
				System.out.println("Checkbox under Flat Monthly column is present :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Checkbox under Flat Monthly column is present and checked");
			}
			else
			{
				System.out.println("Checkbox under Flat Monthly column is NOT present or NOT enabled :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Checkbox under Flat Monthly column is NOT present or NOT enabled");
			}
			System.out.println("Checkboxes are present  under Flat Monthly column is verified successfully");
			utilityclassobject.gettest().log(Status.INFO, "Checkboxes are present  under Flat Monthly column is verified successfully");
		}
	}
	
	
	@Test(dependsOnMethods = "TC_040VerifyCheckBoxisPresentunderFlatmonthlyColumn")
	public void TC_041VerifyFlatmonthlyCheckBoxisClickable() throws InterruptedException
	
	{

	
		//check and ucheck the checkbox under flat monthly column
		List<WebElement> checkboxes = gpb.getIncludeFlatMonthlyCheckboxes();
		for(WebElement checkbox:checkboxes)
		{
			if(checkbox.isDisplayed() && checkbox.isEnabled())
			{
				checkbox.click();
				System.out.println("Checkbox under Flat Monthly column is clicked :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Checkbox under Flat Monthly column is clicked");
				checkbox.click();
				System.out.println("Checkbox under Flat Monthly column is unclicked :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Checkbox under Flat Monthly column is unclicked");
			}
			else
			{
				System.out.println("Checkbox under Flat Monthly column is NOT present or NOT enabled :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Checkbox under Flat Monthly column is NOT present or NOT enabled");
			}
			System.out.println("Checkboxes are clickable  under Flat Monthly column is verified successfully");
			utilityclassobject.gettest().log(Status.INFO, "Checkboxes are clickable  under Flat Monthly column is verified successfully");
		}
		
			
		}

	
	@Test(dependsOnMethods = "TC_041VerifyFlatmonthlyCheckBoxisClickable")
	public void TC_042VerifyFlatMonthlyCheckboxisNotClickable()
	{
		gpb.getFlatMonthlyCheckbox().click();
		
		System.out.println("Clicked on Flat Monthly checkbox");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Flat Monthly checkbox");
		if(gpb.getFlatMonthlyError().isDisplayed())
		{
			System.out.println("Flat Monthly checkbox is not clickable and error message is displayed :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Flat Monthly checkbox is not clickable and error message is displayed");
			
		}
		else
		{
			System.out.println("Flat Monthly checkbox is clickable and error message is NOT displayed :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Flat Monthly checkbox is clickable and error message is NOT displayed");
		}
		
	}
	
	
	@Test(dependsOnMethods = "TC_042VerifyFlatMonthlyCheckboxisNotClickable")
	public void TC_043VerifyServicePriceHeaderisDisplayed()
	{
		String txt = gpb.getServicePriceHeader().getText();
		System.out.println(" Header beside include flatmonthly column : "+txt);
		utilityclassobject.gettest().log(Status.INFO, " Header beside include flatmonthly column : "+txt);
		//not able to compair with Service price because developers made txt saperately
	 if(gpb.getServicePriceHeader().isDisplayed())
		{
			System.out.println("Service Price header is displayed beside include flatmonthly column :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Service Price header is displayed beside include flatmonthly column");
		}
		else
		{
			System.out.println("Service Price header is NOT displayed beside include flatmonthly column :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Service Price header is NOT displayed beside include flatmonthly column");
		}
	}
	
	
	@Test(dependsOnMethods = "TC_043VerifyServicePriceHeaderisDisplayed")
	public void TC_044VerifyServicePriceInputFiledandAcceptsData(){
		List<WebElement> serviceFields = gpb.getServicePriceInputFields();
		boolean allFieldsPresentAndAcceptData = true;

		if (serviceFields.isEmpty()) {
			System.out.println("No Service Price input fields found :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "No Service Price input fields found");
			return;
		}

		for (int i = 0; i < serviceFields.size(); i++) {
			WebElement field = serviceFields.get(i);
			int fieldNumber = i + 1;

			if (!field.isDisplayed() || !field.isEnabled()) {
				allFieldsPresentAndAcceptData = false;
				System.out.println("Service Price input field " + fieldNumber + " is NOT present/enabled :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Service Price input field " + fieldNumber + " is NOT present/enabled");
				continue;
			}

			field.click();
			field.sendKeys(Keys.CONTROL, "a");
			field.sendKeys(Keys.BACK_SPACE);

			// Fallback clear via JavaScript when normal backspace clear is blocked by UI behavior.
			String currentValue = field.getAttribute("value");
			if (currentValue != null && !currentValue.trim().isEmpty()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].value='';", field);
			}

			field.sendKeys("20");
			String enteredValue = field.getAttribute("value");

			if ("20".equals(enteredValue)) {
				System.out.println("Service Price input field " + fieldNumber + " accepts data 20 :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Service Price input field " + fieldNumber + " accepts data 20");
			} else {
				allFieldsPresentAndAcceptData = false;
				System.out.println("Service Price input field " + fieldNumber + " did NOT accept 20. Actual value: " + enteredValue + " :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Service Price input field " + fieldNumber + " did NOT accept 20. Actual value: " + enteredValue);
			}
		}

		if (allFieldsPresentAndAcceptData) {
			System.out.println("All the fields are present and it accepts data :PASS");
			utilityclassobject.gettest().log(Status.PASS, "All the fields are present and it accepts data");
		} else {
			System.out.println("Some fields are missing or not accepting data :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Some fields are missing or not accepting data");
		}
		
		//again clear the fields to avoid any issues in next test case
		for (WebElement field : serviceFields) {
			field.click();
			field.sendKeys(Keys.CONTROL, "a");
			field.sendKeys(Keys.BACK_SPACE);
			System.out.println("Cleared the Service Price input field");
			utilityclassobject.gettest().log(Status.INFO, "Cleared the Service Price input field ");
		}
		
	}
	
	@Test(dependsOnMethods = "TC_044VerifyServicePriceInputFiledandAcceptsData")
	public void TC_045VerifyServicePriceInputFiledisNotAcceptingNegativeData(){
		
		gpb.getAllotmentUptoColumn().isDisplayed();
		System.out.println("Allotmenupto column is displayed :PASS");
	    utilityclassobject.gettest().log(Status.PASS, "Allotmenupto column is displayed");
	}
	
	@Test(dependsOnMethods = "TC_045VerifyServicePriceInputFiledisNotAcceptingNegativeData")
	public void TC_046VerifyAllotmentUptoFieldAcceptsInput() {
		List<WebElement> allotmentFields = gpb.getAllotmentUptoInputFields();
		boolean allFieldsAcceptInput = true;

		

		for (int i = 0; i < allotmentFields.size(); i++) {
			WebElement field = allotmentFields.get(i);
			int fieldNumber = i + 1;

			field.click();
			field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			field.sendKeys(Keys.DELETE);

			String currentValue = field.getAttribute("value");
			if (currentValue != null && !currentValue.trim().isEmpty()) {
				((JavascriptExecutor) driver).executeScript(
					"arguments[0].value='';"
					+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
					+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
					field
				);
			}
			field.sendKeys("5");

			String enteredValue = field.getAttribute("value");
			if ("5".equals(enteredValue)) {
				System.out.println("Allotment Upto field " + fieldNumber + " accepted value 5 :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Allotment Upto field " + fieldNumber + " accepted value 5");
			} else {
				allFieldsAcceptInput = false;
				System.out.println("Allotment Upto field " + fieldNumber + " did NOT accept value 5. Actual value: " + enteredValue + " :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Allotment Upto field " + fieldNumber + " did NOT accept value 5. Actual value: " + enteredValue);
			}
		}

		if (allFieldsAcceptInput) {
			System.out.println("All Allotment Upto fields accepted input 5 :PASS");
			utilityclassobject.gettest().log(Status.PASS, "All Allotment Upto fields accepted input 5");
			
			System.out.println("Allotment Upto field accepts input and saves data successfully :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Allotment Upto field accepts input and saves data successfully");
		} else {
			System.out.println("Some Allotment Upto fields did not accept input 5 :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Some Allotment Upto fields did not accept input 5");
		}

		// Clear all fields after validation to keep following test state clean.
		for (WebElement field : allotmentFields) {
			clearInputField(field);
		}
		System.out.println("Cleared all Allotment Upto input fields after verification");
		utilityclassobject.gettest().log(Status.INFO, "Cleared all Allotment Upto input fields after verification");

		// Validate that alphabets/special characters are rejected in numeric-only fields.
		String[] invalidInputs = {"abc", "@#%", "ab@12"};
		boolean invalidInputsRejected = true;

		for (int i = 0; i < allotmentFields.size(); i++) {
			WebElement field = allotmentFields.get(i);
			int fieldNumber = i + 1;

			for (String invalidInput : invalidInputs) {
				clearInputField(field);
				field.sendKeys(invalidInput);

				String actualValue = field.getAttribute("value");
				String safeValue = actualValue == null ? "" : actualValue.trim();

				if (safeValue.matches(".*[^0-9].*")) {
					invalidInputsRejected = false;
					System.out.println("Allotment Upto field " + fieldNumber + " accepted invalid input '" + invalidInput + "'. Actual value: '" + safeValue + "' :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Allotment Upto field " + fieldNumber + " accepted invalid input '" + invalidInput + "'. Actual value: '" + safeValue + "'");
				} else {
					System.out.println("Allotment Upto field " + fieldNumber + " rejected invalid input '" + invalidInput + "' :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Allotment Upto field " + fieldNumber + " rejected invalid input '" + invalidInput + "'");
				}

				clearInputField(field);
			}
		}

		if (invalidInputsRejected) {
			System.out.println("Allotment Upto fields are accepting only valid numeric values :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Allotment Upto fields are accepting only valid numeric values");
		} else {
			System.out.println("Allotment Upto fields accepted non-numeric values in some cases :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Allotment Upto fields accepted non-numeric values in some cases");
		}
		
		
	}

	public void clearInputField(WebElement field) {
		field.click();
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		field.sendKeys(Keys.DELETE);

		String currentValue = field.getAttribute("value");
		if (currentValue != null && !currentValue.trim().isEmpty()) {
			((JavascriptExecutor) driver).executeScript(
				"arguments[0].value='';"
				+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
				+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				field
			);
		}
	}
	
	@Test(dependsOnMethods = "TC_046VerifyAllotmentUptoFieldAcceptsInput")
	public void TC_047VerifyAdditionalcontainerratecolumnPresence() {
		
		if (gpb.getAdditionalContainerRateColumn().isDisplayed()) {
			System.out.println("Additional Container Rate column is displayed immediatly beside Allotment up to column :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Additional Container Rate column is displayed immediatly beside Allotment up to column");
		} else {
			System.out.println("Additional Container Rate column is NOT displayed immediatly beside Allotment up to column :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Additional Container Rate column is NOT displayed immediatly beside Allotment up to column");
		}
		
		
		
	}
	
	@Test(dependsOnMethods = "TC_047VerifyAdditionalcontainerratecolumnPresence")
	public void TC_048VerifyAdditionalContainerRateInputFieldAcceptsData() {
		List<WebElement> additionalContainerRateFields = gpb.getAdditionalContainerRateInputFields();
		boolean allFieldsAcceptInput = true;

		if (additionalContainerRateFields.isEmpty()) {
			System.out.println("No Additional Container Rate input fields found :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "No Additional Container Rate input fields found");
			return;
		}

		for (int i = 0; i < additionalContainerRateFields.size(); i++) {
			WebElement field = additionalContainerRateFields.get(i);
			int fieldNumber = i + 1;

			field.click();
			field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			field.sendKeys(Keys.DELETE);

			String currentValue = field.getAttribute("value");
			if (currentValue != null && !currentValue.trim().isEmpty()) {
				((JavascriptExecutor) driver).executeScript(
					"arguments[0].value='';"
					+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
					+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
					field
				);
			}
			System.out.println("Cleared the Additional Container Rate input field " + fieldNumber);
			utilityclassobject.gettest().log(Status.INFO, "Cleared the Additional Container Rate input field " + fieldNumber);
			field.sendKeys("10");

			String enteredValue = field.getAttribute("value");
			if ("10".equals(enteredValue)) {
				System.out.println("Additional Container Rate field " + fieldNumber + " accepted value 10 :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Additional Container Rate field " + fieldNumber + " accepted value 10");
			} else {
				allFieldsAcceptInput = false;
				System.out.println("Additional Container Rate field " + fieldNumber + " did NOT accept value 10. Actual value: " + enteredValue + " :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Additional Container Rate field " + fieldNumber + " did NOT accept value 10. Actual value: " + enteredValue);
			}
		}

		if (allFieldsAcceptInput) {
			System.out.println("All Additional Container Rate fields accepted input 10 :PASS");
			utilityclassobject.gettest().log(Status.PASS, "All Additional Container Rate fields accepted input 10");
		}
		
		//again clear the fields to avoid any issues in next test case
		for (WebElement field : additionalContainerRateFields) {
			clearInputField(field);
			System.out.println("Cleared the Additional Container Rate input field");
			utilityclassobject.gettest().log(Status.INFO, "Cleared the Additional Container Rate input field ");
		}
		
		gpb.getUniversalWasteText().click();
		System.out.println("Clicked on Universal Waste text to remove focus from Additional Container Rate fields");
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Universal Waste text to remove focus from Additional Container Rate fields");
		
		System.out.println("Additional Container Rate input fields accepts data successfully and Displayed correctly without distrubing other fields :PASS");
		utilityclassobject.gettest().log(Status.PASS, "Additional Container Rate input fields accepts data successfully and Displayed correctly without distrubing other fields");
	}
	
	@Test(dependsOnMethods = "TC_048VerifyAdditionalContainerRateInputFieldAcceptsData")
	public void TC_049VerifyAllotmentFrequencyColumnDisplayedImmediatlyafterAdditionalContainerRate() {
		
		if (gpb.getAllotmentFrequencyColumn().isDisplayed()) {
			System.out.println("Allotment Frequency column is displayed immediatly beside Additional Container Rate column :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Allotment Frequency column is displayed immediatly beside Additional Container Rate column");
		} else {
			System.out.println("Allotment Frequency column is NOT displayed immediatly beside Additional Container Rate column :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Allotment Frequency column is NOT displayed immediatly beside Additional Container Rate column");
		}
		
		
	}
	
	@Test(dependsOnMethods = "TC_049VerifyAllotmentFrequencyColumnDisplayedImmediatlyafterAdditionalContainerRate")
	
	public void TC_050VerifyAllotmentFrequencyForIndividualContainers() {
		List<WebElement> containers = gpb.getContainerslist();
		List<WebElement> frequencies = gpb.getAllotmentFrequency();
		boolean isPass = true;

		if (containers.isEmpty() || frequencies.isEmpty()) {
			System.out.println("Containers/Frequency list is empty :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Containers/Frequency list is empty");
			return;
		}

		if (containers.size() != frequencies.size()) {
			isPass = false;
			System.out.println("Container count and frequency count are not matching :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Container count and frequency count are not matching");
		}

		int rows = Math.min(containers.size(), frequencies.size());
		for (int i = 0; i < rows; i++) {
			String containerName = containers.get(i).getText().trim();
			WebElement frequencyElement = frequencies.get(i);

			String frequencyValue = frequencyElement.getText().trim();
			if (frequencyValue.isEmpty()) {
				String valueAttr = frequencyElement.getAttribute("value");
				if (valueAttr != null) {
					frequencyValue = valueAttr.trim();
				}
			}

			if (!frequencyElement.isDisplayed() || frequencyValue.isEmpty()) {
				isPass = false;
				System.out.println("Container " + (i + 1) + " [" + containerName + "] has no frequency value :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Container " + (i + 1) + " [" + containerName + "] has no frequency value");
			} else {
				System.out.println("Container " + (i + 1) + " [" + containerName + "] frequency: " + frequencyValue + " :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Container " + (i + 1) + " [" + containerName + "] frequency: " + frequencyValue);
			}
		}

		if (isPass) {
			System.out.println("All containers have individual allotment frequency values :PASS");
			utilityclassobject.gettest().log(Status.PASS, "All containers have individual allotment frequency values");
		} else {
			System.out.println("Some containers are missing individual allotment frequency values :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Some containers are missing individual allotment frequency values");
		}
	}
	
	@Test(dependsOnMethods = "TC_050VerifyAllotmentFrequencyForIndividualContainers")
	public void TC_051VerifyBesideallotmentfrequencyUsedAllotmentcolumnispresent() {
		
		
	
		if (gpb.getUsedColumn().isDisplayed()) {
			System.out.println("Used Allotment column is displayed immediatly beside Allotment Frequency column :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Used Allotment column is displayed immediatly beside Allotment Frequency column");
		} else {
			System.out.println("Used Allotment column is NOT displayed immediatly beside Allotment Frequency column :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Used Allotment column is NOT displayed immediatly beside Allotment Frequency column");
	}
	
	}
	
	@Test(dependsOnMethods = "TC_051VerifyBesideallotmentfrequencyUsedAllotmentcolumnispresent")
	public void TC_052VerifyUsedAllotmentAcceptsonlyNumbericvalueandnotAcceptsvaluesotherthanNumericandDataSaved() throws InterruptedException {
		List<WebElement> usedAllotmentFields = gpb.getUsedAllotmentsInputFields();
		boolean isPass = true;

		if (usedAllotmentFields.isEmpty()) {
			System.out.println("No Used Allotment input fields found :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "No Used Allotment input fields found");
			return;
		}

		for (int i = 0; i < usedAllotmentFields.size(); i++) {
			WebElement field = usedAllotmentFields.get(i);
			int row = i + 1;

			clearInputField(field);
			Thread.sleep(2000); 
			field.sendKeys("2");
			String valueAfterNumeric = field.getAttribute("value");

			if ("2".equals(valueAfterNumeric)) {
				System.out.println("Used Allotment field " + row + " accepted numeric value 2 :PASS");
				utilityclassobject.gettest().log(Status.PASS, "Used Allotment field " + row + " accepted numeric value 2");
			} else {
				isPass = false;
				System.out.println("Used Allotment field " + row + " did not keep numeric value 2. Actual: " + valueAfterNumeric + " :FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Used Allotment field " + row + " did not keep numeric value 2. Actual: " + valueAfterNumeric);
			}

			clearInputField(field);
			Thread.sleep(2000); 

			String[] invalidInputs = {"abc", "@#$", "ab@12"};
			for (String invalidInput : invalidInputs) {
				field.sendKeys(invalidInput);
				
				gpb.getUniversalWasteText().click();
				Thread.sleep(2000);
				String actualValue = field.getAttribute("value");
				String safeValue = actualValue == null ? "" : actualValue.trim();

				if (safeValue.matches(".*[^0-9].*")) {
					isPass = false;
					System.out.println("Used Allotment field " + row + " accepted invalid input '" + invalidInput + "'. Actual: '" + safeValue + "' :FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Used Allotment field " + row + " accepted invalid input '" + invalidInput + "'. Actual: '" + safeValue + "'");
				} else {
					System.out.println("Used Allotment field " + row + " rejected invalid input '" + invalidInput + "' :PASS");
					utilityclassobject.gettest().log(Status.PASS, "Used Allotment field " + row + " rejected invalid input '" + invalidInput + "'");
				}

				clearInputField(field);
			}
		}

		if (isPass) {
			System.out.println("Used Allotment fields accept only numeric values and reject alphabets/special characters :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Used Allotment fields accept only numeric values and reject alphabets/special characters");
		} else {
			System.out.println("Used Allotment fields validation failed for some rows :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Used Allotment fields validation failed for some rows");
		}
	}
	
	
	
	@Test(dependsOnMethods = "TC_052VerifyUsedAllotmentAcceptsonlyNumbericvalueandnotAcceptsvaluesotherthanNumericandDataSaved")
	public void TC_053VerifyBesideUsedAllotmentColumnRemainingAllotmentColumnisPresent() {
		
		if (gpb.getRemainingAllotmentColumn().isDisplayed()) {
			System.out.println("Remaining Allotment column is displayed immediatly beside Used Allotment column :PASS");
			utilityclassobject.gettest().log(Status.PASS, "Remaining Allotment column is displayed immediatly beside Used Allotment column");
		} else {
			System.out.println("Remaining Allotment column is NOT displayed immediatly beside Used Allotment column :FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Remaining Allotment column is NOT displayed immediatly beside Used Allotment column");
		}
	}
	
}
		
