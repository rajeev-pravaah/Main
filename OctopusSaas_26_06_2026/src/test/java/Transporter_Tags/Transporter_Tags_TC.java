package Transporter_Tags;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForMasterPriceBook;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaas.ObjectRepository.TransporterSettingsPage;
import com.Octopussaas.ObjectRepository.TransporterSettings_Tags;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Transporter_Tags_TC extends BaseClassForMasterPriceBook {
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	TransporterSettingsPage tsp;
	TransporterSettings_Tags tst;
	List<WebElement> list;
	JavascriptExecutor js;

	Random random;
	
	String oldtag;

	@Test
	public void TC_001VerifyTagsPage() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib = new webDriverutility();
		tst = new TransporterSettings_Tags(driver);
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

		Thread.sleep(5000);
		tst.getTagslink().click();
		utilityclassobject.gettest().log(Status.INFO, "Tags page is  displayed successfully");
		System.out.println("Tags page is  displayed successfully");
	}

	@Test(dependsOnMethods = "TC_001VerifyTagsPage")
	public void TC_002VerifyAddTags() throws InterruptedException {
		tst.getOctopusicomtooltip().click();
		Thread.sleep(2000);
		// verify the OCTO info title is displayed
		if (tst.getOctoinfotitle().isDisplayed()) {
			System.out.println("OCTO info title is displayed successfully");
			utilityclassobject.gettest().log(Status.PASS, "OCTO info title is displayed successfully");
		} else {
			System.out.println("OCTO info title is not displayed");
			utilityclassobject.gettest().log(Status.FAIL, "OCTO info title is not displayed");
		}
		tst.getTooltipclosebtn().click();
	}

	@Test(dependsOnMethods = "TC_002VerifyAddTags")
	public void TC_003VerifySystemTags() throws InterruptedException {
		tst.getSystemtagsbtn().click();
		Thread.sleep(2000);
		// verify the system tags page is displayed
		if (tst.getSystemtagsbtn().isDisplayed()) {
			System.out.println("System tags page is displayed successfully");
			utilityclassobject.gettest().log(Status.PASS, "System tags page is displayed successfully");
		} else {
			System.out.println("System tags page is not displayed");
			utilityclassobject.gettest().log(Status.FAIL, "System tags page is not displayed");
		}
	}

	@Test(dependsOnMethods = "TC_003VerifySystemTags")
	public void TC_004VerifyAddNewTag() throws InterruptedException {
		tst.getAddnewtagbtn().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add new tag button successfully");
		System.out.println("Clicked on Add new tag button successfully");
		Thread.sleep(2000);
		// verify the create new tag popup is displayed
		try {
			if (tst.getCreatenewtagtitle().isDisplayed()) {
				System.out.println("Create new tag popup is displayed successfully");
				utilityclassobject.gettest().log(Status.PASS, "Create new tag popup is displayed successfully");
			} else {
				System.out.println("Create new tag popup is not displayed");
				utilityclassobject.gettest().log(Status.FAIL, "Create new tag popup is not displayed");
			}
		} catch (Exception e) {
			System.out.println("Create new tag popup is not displayed: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "Create new tag popup is not displayed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC_004VerifyAddNewTag")
	public void TC_005VerifyTagNameFieldWithAlphabets() throws InterruptedException {
		tst.getTagnametxtfield().sendKeys("Test Tag");
		utilityclassobject.gettest().log(Status.INFO, "Entered tag name successfully");
		System.out.println("Entered tag name successfully");
		Thread.sleep(2000);
		// verify the tag name is entered in the text field
		if (tst.getTagnametxtfield().getAttribute("value").contains("Test Tag")) {
			System.out.println("Tag name is entered successfully");
			utilityclassobject.gettest().log(Status.PASS, "Tag name is entered successfully");
		} else {
			System.out.println("Tag name is not entered");
			utilityclassobject.gettest().log(Status.FAIL, "Tag name is not entered");
		}

	}

	@Test(dependsOnMethods = "TC_005VerifyTagNameFieldWithAlphabets")
	public void TC_006VerifyTagNameFieldWithNumbers() throws InterruptedException {
		// clear the text field and enter tag name with numbers
		tst.getTagnametxtfield().clear();
		tst.getTagnametxtfield().sendKeys("123");
		utilityclassobject.gettest().log(Status.INFO, "Entered numbers successfully");
		System.out.println("Entered numbers successfully");

	}

	@Test(dependsOnMethods = "TC_006VerifyTagNameFieldWithNumbers")
	public void TC_007VerifyTagNameFieldWithSpecialCharacters() throws InterruptedException {
		// clear the text field and enter tag name with special characters
		tst.getTagnametxtfield().clear();
		tst.getTagnametxtfield().sendKeys("@#$%");
		utilityclassobject.gettest().log(Status.INFO, "Entered special characters successfully");
		System.out.println("Entered special characters successfully");

	}

	@Test(dependsOnMethods = "TC_007VerifyTagNameFieldWithSpecialCharacters")
	public void TC_008VerifyCreateTagWithoutTagname() throws InterruptedException {
		tst.getTagnametxtfield().clear();
		tst.getCreatetagbtn().click();
		// verify the error message is displayed
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Tag name is required']")));
			System.out.println("Tag name error message is displayed successfully");
			utilityclassobject.gettest().log(Status.PASS, "Tag name error message is displayed successfully");
		} catch (Exception e) {
			System.out.println("Tag name error message is not displayed: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "Tag name error message is not displayed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC_008VerifyCreateTagWithoutTagname")
	public void TC_009VerifyCreateTagWithAlreadyExistsTagName() throws InterruptedException {
		tst.getTagnametxtfield().sendKeys("After Care");
		tst.getCreatetagbtn().click();
		// Use WebDriverWait with visibilityOfElementLocated so it handles
		// NoSuchElementException while the toast is not yet in the DOM
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'A tag with this name already exists')]")));
			System.out.println("A tag with this name already exists error message is displayed successfully");
			utilityclassobject.gettest().log(Status.PASS,
					"A tag with this name already exists error message is displayed successfully");
		} catch (Exception e) {
			System.out.println("A tag with this name already exists error message is not displayed: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL,
					"A tag with this name already exists error message is not displayed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC_009VerifyCreateTagWithAlreadyExistsTagName")
	public void TC_010VerifyColorsBox() throws InterruptedException {
		// fetch the number of colors and print them and also verify that the colors box
		// is displayed
		int colorscount = tst.getColorsbox().size();
		System.out.println("Number of colors available: " + colorscount);
		for (int i = 0; i < colorscount; i++) {
			if (tst.getColorsbox().get(i).isDisplayed()) {
				System.out.println("Color " + (i + 1) + " is displayed successfully");
				utilityclassobject.gettest().log(Status.PASS, "Color " + (i + 1) + " is displayed successfully");
			} else {
				System.out.println("Color " + (i + 1) + " is not displayed");
				utilityclassobject.gettest().log(Status.FAIL, "Color " + (i + 1) + " is not displayed");
			}
		}

	}

	@Test(dependsOnMethods = "TC_010VerifyColorsBox")
	public void TC_011SelectTagColor() throws InterruptedException {
		tst.getThirdrdcolorbox().click();
		utilityclassobject.gettest().log(Status.INFO, "Selected the third color successfully");
		System.out.println("Selected the third color successfully");

	}

	@Test(dependsOnMethods = "TC_011SelectTagColor")
	public void TC_012CustomizeTagColor() throws InterruptedException {
		tst.getFourthcolorbox().click();
		utilityclassobject.gettest().log(Status.INFO, "User can customize the tag color successfully");
		System.out.println("User can customize the tag color successfully");
	}

	String tagname = "";

	@Test(dependsOnMethods = "TC_012CustomizeTagColor")
	public void TC_013SameColorWithDifferentTag() throws InterruptedException {
		// pass name with 5 digit random number in the tag name field and select the
		// same color as third color box and click on create tag button
		random = new Random();
		int randomNumber = 10000 + random.nextInt(90000);

		System.out.println(randomNumber);
		tst.getTagnametxtfield().clear();
		tagname = "Test Tag " + randomNumber;
		System.out.println(tagname);
		tst.getTagnametxtfield().sendKeys(tagname);
		tst.getCreatetagbtn().click();
		utilityclassobject.gettest().log(Status.INFO, "Created a tag with same color");
		System.out.println("Created a tag with same color");
		// verify the created tagname is present in list
		Thread.sleep(5000);
		tst.getAlltagsbtn().click();
		Thread.sleep(3000);
		List<WebElement> list = tst.getCreatedtagnamelist();
		boolean found = false;
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(tagname)) {
					found = true;
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						WebElement delete = driver.findElement(
								By.xpath("//div[text()='" + tagname + "']/../descendant::button[text()='Delete']"));
						wlib.scrollToelement(driver, delete);
						Thread.sleep(2000);
						delete.click();
						tst.getDeleteconfirmbtn().click();
						System.out.println("Deleted the created tag successfully");
						utilityclassobject.gettest().log(Status.INFO, "Deleted the created tag successfully");
					} catch (Exception ex) {
						System.out.println("Could not delete tag in TC_013: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not delete tag in TC_013: " + ex.getMessage());
					}
					break;
				}
			} catch (Exception ex) {
				System.out.println("Stale/error reading element in TC_013: " + ex.getMessage());
			}
		}
		if (!found) {
			System.out.println("Tag name is not present in the tag name list");
			utilityclassobject.gettest().log(Status.FAIL, "Tag name is not present in the tag name list");
		}

	}

	@Test(dependsOnMethods = "TC_013SameColorWithDifferentTag")
	public void TC_014VerifyCancelTag() throws InterruptedException {
		tst.getAddnewtagbtn().click();
		String tagname = "Test Tag ";
		tst.getTagnametxtfield().sendKeys(tagname);
		tst.getCancelbtn().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on cancel button successfully");
		System.out.println("Clicked on cancel button successfully");

	}

	@Test(dependsOnMethods = "TC_014VerifyCancelTag")
	public void TC_015VerifyCreatedTagNamePresentintheTagNameList() throws InterruptedException {
		try {
			tst.getAddnewtagbtn().click();
			tst.getTagnametxtfield().sendKeys(tagname);
			tst.getCreatetagbtn().click();
			utilityclassobject.gettest().log(Status.INFO, "Created a tag successfully");
			System.out.println("Created a tag successfully");
			Thread.sleep(5000);
			tst.getAlltagsbtn().click();
			Thread.sleep(3000);
			List<WebElement> list = tst.getCreatedtagnamelist();
			boolean found = false;
			for (WebElement ele : list) {
				try {
					if (ele.getText().contains(tagname)) {
						found = true;
						System.out.println("Tag name is present in the tag name list");
						utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
						try {
							String tagnamedetails = driver.findElement(By.xpath("//div[text()='" + tagname + "']/..")).getText();
							System.out.println("Tag name details: " + tagnamedetails);
							WebElement delete = driver.findElement(
									By.xpath("//div[text()='" + tagname + "']/../descendant::button[text()='Delete']"));
							wlib.scrollToelement(driver, delete);
							Thread.sleep(2000);
							delete.click();
							tst.getDeleteconfirmbtn().click();
							System.out.println("Deleted the created tag successfully");
							utilityclassobject.gettest().log(Status.INFO, "Deleted the created tag successfully");
						} catch (Exception ex) {
							System.out.println("Could not delete tag in TC_015: " + ex.getMessage());
							utilityclassobject.gettest().log(Status.FAIL, "Could not delete tag in TC_015: " + ex.getMessage());
						}
						break;
					}
				} catch (Exception ex) {
					System.out.println("Stale/error reading element in TC_015: " + ex.getMessage());
				}
			}
			if (!found) {
				System.out.println("Tag name is not present in the tag name list");
				utilityclassobject.gettest().log(Status.FAIL, "Tag name is not present in the tag name list");
			}
		} catch (Exception e) {
			System.out.println("TC_015 failed: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "TC_015 failed: " + e.getMessage());
		}
	}

	String colornum;

	@Test(dependsOnMethods = "TC_015VerifyCreatedTagNamePresentintheTagNameList")
	public void TC_016VerifyaddedTagcolor() throws InterruptedException {
		/*
		 * tst.getAddnewtagbtn().click(); tst.getTagnametxtfield().sendKeys(tagname);
		 * tst.getThirdrdcolorbox().click(); colornum =
		 * tst.getSelectedcolorname().getText();
		 * System.out.println("Selected color name: " + colornum);
		 * tst.getCreatetagbtn().click(); utilityclassobject.gettest().log(Status.INFO,
		 * "Created a tag with third color successfully");
		 * System.out.println("Created a tag with third color successfully");
		 * Thread.sleep(5000); tst.getAlltagsbtn().click(); Thread.sleep(3000);
		 * List<WebElement> list = tst.getCreatedtagnamelist(); boolean found = false;
		 * for(WebElement ele : list) { if(ele.getText().contains(tagname)) { found =
		 * true; System.out.println("Tag name is present in the tag name list");
		 * utilityclassobject.gettest().log(Status.PASS,
		 * "Tag name is present in the tag name list"); String tagnamedetails =
		 * driver.findElement(By.xpath("//div[text()='"+tagname+"']/..")).getText();
		 * System.out.println("Tag name details: " + tagnamedetails);
		 * driver.findElement(By.xpath("//div[text()='"+tagname+
		 * "']/../descendant::button[text()='Edit']")).click(); String selectedcolornum
		 * = driver.findElement((By.
		 * xpath("(//p[text()='Selecte........d Color']/../descendant::p)[2]"))).getText();
		 * //verify the selected color name is same as colornum Thread.sleep(2000); if
		 * (selectedcolornum.contains(colornum)) { System.out.
		 * println("Selected color name is same as the color name of the created tag");
		 * utilityclassobject.gettest().log(Status.PASS,
		 * "Selected color name is same as the color name of the created tag"); } else {
		 * System.out.
		 * println("Selected color name is not same as the color name of the created tag"
		 * ); utilityclassobject.gettest().log(Status.FAIL,
		 * "Selected color name is not same as the color name of the created tag"); }
		 * 
		 * tst.getCancelbtn().click(); Thread.sleep(2000); WebElement delete =
		 * driver.findElement(By.xpath("//div[text()='"+tagname+
		 * "']/../descendant::button[text()='Delete']")); wlib.scrollToelement(driver,
		 * delete); Thread.sleep(2000); delete.click();
		 * //tst.getCreatedtagdeletebtn().click(); tst.getDeleteconfirmbtn().click();
		 * System.out.println("Deleted the created tag successfully");
		 * utilityclassobject.gettest().log(Status.INFO,
		 * "Deleted the created tag successfully"); break; } } if (!found) {
		 * System.out.println("Tag name is not present in the tag name list");
		 * utilityclassobject.gettest().log(Status.FAIL,
		 * "Tag name is not present in the tag name list"); }
		 */
	}

	@Test(dependsOnMethods = "TC_016VerifyaddedTagcolor")
	public void TC_017VerifyCountofTag() throws InterruptedException {
		try {
			tst.getAddnewtagbtn().click();
			System.out.println(tagname);
			tst.getTagnametxtfield().sendKeys(tagname);
			tst.getCreatetagbtn().click();
			utilityclassobject.gettest().log(Status.INFO, "Created a tag successfully");
			System.out.println("Created a tag successfully");
			Thread.sleep(5000);
			tst.getAlltagsbtn().click();
			Thread.sleep(3000);
			List<WebElement> list = tst.getCreatedtagnamelist();
			boolean found = false;
			for (WebElement ele : list) {
				try {
					if (ele.getText().contains(tagname)) {
						found = true;
						System.out.println("Tag name is present in the tag name list");
						utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
						try {
							String tagnamedetails = driver.findElement(By.xpath("//div[text()='" + tagname + "']/..")).getText();
							System.out.println("Tag name details: " + tagnamedetails);
							String count = driver.findElement(By.xpath("(//div[text()='" + tagname + "']/../descendant::div)[3]")).getText();
							System.out.println("Count of the tag: " + count);
							utilityclassobject.gettest().log(Status.INFO, "Count of the tag is: " + count);
							WebElement delete = driver.findElement(
									By.xpath("//div[text()='" + tagname + "']/../descendant::button[text()='Delete']"));
							wlib.scrollToelement(driver, delete);
							Thread.sleep(2000);
							delete.click();
							tst.getDeleteconfirmbtn().click();
							System.out.println("Deleted the created tag successfully");
							utilityclassobject.gettest().log(Status.INFO, "Deleted the created tag successfully");
						} catch (Exception ex) {
							System.out.println("Error during tag details/delete in TC_017: " + ex.getMessage());
							utilityclassobject.gettest().log(Status.FAIL, "Error during tag details/delete in TC_017: " + ex.getMessage());
						}
						break;
					}
				} catch (Exception ex) {
					System.out.println("Stale/error reading element in TC_017: " + ex.getMessage());
				}
			}
			if (!found) {
				System.out.println("Tag name is not present in the tag name list");
				utilityclassobject.gettest().log(Status.FAIL, "Tag name is not present in the tag name list");
			}
		} catch (Exception e) {
			System.out.println("TC_017 failed: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "TC_017 failed: " + e.getMessage());
		}
	}

	String gname;

	@Test(dependsOnMethods = "TC_017VerifyCountofTag"/* "TC_001VerifyTagsPage" */)
	public void TC_018VerifyInscreseCountofTagAfteraddinginGenerator() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Create a new tag
		WebElement addNewTagBtn = wait.until(ExpectedConditions.elementToBeClickable(tst.getAddnewtagbtn()));
		js.executeScript("arguments[0].click();", addNewTagBtn);
		tst.getTagnametxtfield().sendKeys(tagname);
		js.executeScript("arguments[0].click();", tst.getCreatetagbtn());
		utilityclassobject.gettest().log(Status.INFO, "Created a tag successfully");
		System.out.println("Created a tag successfully");
		Thread.sleep(5000);

		// Click All Tags button
		WebElement allTagsBtn = wait.until(ExpectedConditions.elementToBeClickable(tst.getAlltagsbtn()));
		js.executeScript("arguments[0].click();", allTagsBtn);
		Thread.sleep(3000);

		// Verify tag is in the list
		list = tst.getCreatedtagnamelist();
		boolean found = false;
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(tagname)) {
					found = true;
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String tagnamedetails = driver.findElement(By.xpath("//div[text()='" + tagname + "']/..")).getText();
						System.out.println("Tag name details: " + tagnamedetails);
						String count = driver.findElement(By.xpath("(//div[text()='" + tagname + "']/../descendant::div)[3]")).getText();
						System.out.println("Count of the tag: " + count);
						utilityclassobject.gettest().log(Status.INFO, "Count of the tag is: " + count);
					} catch (Exception ex) {
						System.out.println("Could not get tag details/count in TC_018: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get tag details/count in TC_018: " + ex.getMessage());
					}
					break;
				}
			} catch (Exception ex) {
				System.out.println("Stale/error reading element in TC_018 verify loop: " + ex.getMessage());
			}
		}
		if (!found) {
			System.out.println("Tag name is not present in the tag name list");
			utilityclassobject.gettest().log(Status.FAIL, "Tag name is not present in the tag name list");
		}

		try {
			// Click Generator Management title using JavascriptExecutor
			WebElement gmTitle = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Generator Management']")));
			js.executeScript("arguments[0].click();", gmTitle);
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Clicked on generator management title successfully");
			System.out.println("Clicked on generator management title successfully");

			// Search for generator
			gname = "Charlie_108227";
			tst.getSearchtxtfield().sendKeys(gname);
			Thread.sleep(2000);
			WebElement gac = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='" + gname + "']")));
			wlib.scrollToelement(driver, gac);
			js.executeScript("arguments[0].click();", gac);
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked on the generator successfully and generator dashboard is displayed successfully");
			System.out
					.println("Clicked on the generator successfully and generator dashboard is displayed successfully");

			// Find tag in generator dashboard and apply
			driver.findElement(By.xpath("//span[text()='Add Tag']/..")).click();
			List<WebElement> tagnamelist = tst.getTagnameintaglist();
			boolean tagFound = false;
			for (WebElement ele : tagnamelist) {
				try {
				if (ele.getText().contains(tagname)) {
					tagFound = true;
					System.out.println("Tag name is present in the tag name list in generator dashboard");
					utilityclassobject.gettest().log(Status.PASS,
							"Tag name is present in the tag name list in generator dashboard");
					try {
						WebElement tagCheckbox = driver
								.findElement(By.xpath("//span[text()='" + tagname + "']/../../descendant::input"));
						js.executeScript("arguments[0].click();", tagCheckbox);
						Thread.sleep(1000);
						WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(tst.getApplybtn()));
						js.executeScript("arguments[0].click();", applyBtn);
						utilityclassobject.gettest().log(Status.PASS, "Tag applied successfully");
						System.out.println("Tag applied successfully");
					} catch (Exception ex) {
						System.out.println("Could not click tag checkbox/apply: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL,
								"Could not click tag checkbox/apply: " + ex.getMessage());
					}
					break;
				}
				} catch (Exception ex) {
					System.out.println("Stale/error reading element in TC_018 tagnamelist: " + ex.getMessage());
				}
			}
			if (!tagFound) {
				System.out.println("Tag name is not present in the generator tag list");
				utilityclassobject.gettest().log(Status.FAIL, "Tag name is not present in the generator tag list");
			}
		} catch (Exception e) {
			System.out.println("Error navigating to generator management: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL,
					"Error navigating to generator management: " + e.getMessage());
		}
		hp.getUserprofile().click();
		// set page zoom to 80%
		js.executeScript("document.body.style.zoom='80%'");

		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");

		Thread.sleep(5000);
		tst.getTagslink().click();
		utilityclassobject.gettest().log(Status.INFO, "Tags page is  displayed successfully");
		System.out.println("Tags page is  displayed successfully");
		// refresh page
		driver.navigate().refresh();
		Thread.sleep(5000);
		List<WebElement> list1 = tst.getCreatedtagnamelist();
		for (WebElement ele : list1) {
			try {
				if (ele.getText().contains(tagname)) {
					try {
						String updatedcount = driver.findElement(By.xpath("(//div[text()='" + tagname + "']/../descendant::div)[3]")).getText();
						System.out.println("Updated count of the tag after applying in generator: " + updatedcount);
						utilityclassobject.gettest().log(Status.INFO, "Updated count of the tag after applying in generator: " + updatedcount);
					} catch (Exception ex) {
						System.out.println("Could not get updated count in TC_018: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get updated count in TC_018: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Stale/error reading element in TC_018 list1: " + ex.getMessage());
			}
		}
		/*
		 * List<WebElement> list2 = tst.getCreatedtagnamelist(); for(WebElement ele :
		 * list2) { if(ele.getText().contains(tagname)) { found = true; System.out.
		 * println("Tag name is present in the tag name list after refreshing the page"
		 * ); utilityclassobject.gettest().log(Status.PASS,
		 * "Tag name is present in the tag name list after refreshing the page");
		 * WebElement delete = driver.findElement(By.xpath("//div[text()='"+tagname+
		 * "']/../descendant::button[text()='Delete']")); wlib.scrollToelement(driver,
		 * delete); Thread.sleep(2000); delete.click();
		 * tst.getDeleteconfirmbtn().click(); Thread.sleep(5000);
		 * 
		 * System.out.println("Deleted the created tag successfully");
		 * utilityclassobject.gettest().log(Status.INFO,
		 * "Deleted the created tag successfully"); break; } }
		 */

	}

	@Test(dependsOnMethods = "TC_018VerifyInscreseCountofTagAfteraddinginGenerator")
	public void TC_019VerifyCountofTagAfterRemovedFromGenerator() throws InterruptedException {
		// set page zoom to 80%
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement gmTitle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Generator Management']")));
		js.executeScript("arguments[0].click();", gmTitle);
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on generator management title successfully");
		System.out.println("Clicked on generator management title successfully");

		// Search for generator - use the same search field as TC_018
		WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement searchField = longWait.until(ExpectedConditions.elementToBeClickable(tst.getSearchtxtfield()));
		js.executeScript("arguments[0].scrollIntoView(true);", searchField);
		js.executeScript("arguments[0].click();", searchField);
		Thread.sleep(500);
		// Force clear using JS and trigger React/Angular input events
		js.executeScript(
				"var el = arguments[0];" +
				"var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
				"nativeInputValueSetter.call(el, '');" +
				"el.dispatchEvent(new Event('input', { bubbles: true }));" +
				"el.dispatchEvent(new Event('change', { bubbles: true }));",
				searchField);
		Thread.sleep(300);
		searchField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		searchField.sendKeys(Keys.DELETE);
		Thread.sleep(300);
		searchField.sendKeys(gname);
		System.out.println("Typed generator name in search: " + gname);

		// Wait for search results to load and the generator tile to appear
		/*WebElement gac = longWait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mark[text()='" + gname + "']")));
		longWait.until(ExpectedConditions.elementToBeClickable(gac));
		wlib.scrollToelement(driver, gac);
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", gac);*/
		//searchtxt.sendKeys(accountname);
		Thread.sleep(3000);
		
		for(int i=0;i<3;i++) {
		    try {
		        driver.findElement(By.xpath("//div[@title='"+gname+"']")).click();
		        break;
		    } 
		    catch(StaleElementReferenceException e) {
		        System.out.println("Retrying...");
		    }
		}
		    
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked on the generator successfully and generator dashboard is displayed successfully");
		System.out.println("Clicked on the generator successfully and generator dashboard is displayed successfully");
		Thread.sleep(3000);
		List<WebElement> addedtag = driver
				.findElements(By.xpath("//button[@id='tag-add-button']/../../descendant::div"));
		for (WebElement ele : addedtag) {
			try {
				if (ele.getText().contains(tagname)) {
					System.out.println("Tag name is present in the generator tag list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the generator tag list");
					try {
						ele.findElement(By.xpath(".//span[text()='" + tagname + "']/../descendant::button")).click();
						utilityclassobject.gettest().log(Status.INFO, "Removed the tag from generator successfully");
						System.out.println("Removed the tag from generator successfully");
						Thread.sleep(5000);
					} catch (Exception ex) {
						System.out.println("Could not click remove button in TC_019: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not click remove button in TC_019: " + ex.getMessage());
					}
					break;
				}
			} catch (Exception ex) {
				System.out.println("Stale/error reading element in TC_019 addedtag loop: " + ex.getMessage());
			}
		}
		// driver.findElement(By.xpath("//div[@id='tag-CpsEPvBKfe2UNigtFkiw']/descendant::button[text()='Remove']")).click();
		// utilityclassobject.gettest().log(Status.INFO, "Removed the tag from generator
		// successfully");
		// System.out.println("Removed the tag from generator successfully");
		// Thread.sleep(5000);
		Thread.sleep(5000);
		hp.getUserprofile().click();
		// set page zoom to 80%
		js.executeScript("document.body.style.zoom='80%'");

		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");

		Thread.sleep(5000);
		tst.getTagslink().click();
		utilityclassobject.gettest().log(Status.INFO, "Tags page is  displayed successfully");
		System.out.println("Tags page is  displayed successfully");
		// refresh page
		driver.navigate().refresh();
		Thread.sleep(5000);
		List<WebElement> list1 = tst.getCreatedtagnamelist();
		for (WebElement ele : list1) {
			try {
				String updatedcount;
				if (ele.getText().contains(tagname)) {
					try {
						updatedcount = driver.findElement(By.xpath("(//div[text()='" + tagname + "']/../descendant::div)[3]")).getText();
						System.out.println("Updated count of the tag after removing tag from generator: " + updatedcount);
						utilityclassobject.gettest().log(Status.INFO, "Updated count of the tag after removing tag from  generator: " + updatedcount);
					} catch (Exception ex) {
						System.out.println("Could not get updated count in TC_019 list1: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get updated count in TC_019 list1: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Stale/error in TC_019 list1: " + ex.getMessage());
			}
		}
		List<WebElement> list2 = tst.getCreatedtagnamelist();
		for (WebElement ele : list2) {
			try {
				if (ele.getText().contains(tagname)) {
					System.out.println("Tag name is present in the tag name list after refreshing the page");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list after refreshing the page");
					try {
						WebElement delete = driver.findElement(
								By.xpath("//div[text()='" + tagname + "']/../descendant::button[text()='Delete']"));
						wlib.scrollToelement(driver, delete);
						Thread.sleep(2000);
						delete.click();
						tst.getDeleteconfirmbtn().click();
						Thread.sleep(5000);
						System.out.println("Deleted the created tag successfully");
						utilityclassobject.gettest().log(Status.INFO, "Deleted the created tag successfully");
					} catch (Exception ex) {
						System.out.println("Could not delete tag in TC_019 list2: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not delete tag in TC_019 list2: " + ex.getMessage());
					}
					break;
				}
			} catch (Exception ex) {
				System.out.println("Stale/error in TC_019 list2: " + ex.getMessage());
			}
		}
	}

	@Test(dependsOnMethods = "TC_019VerifyCountofTagAfterRemovedFromGenerator")
	public void TC_020VeifyTagsCreatedby() throws InterruptedException {
		// reduce the page zoom to 80%
		js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
		try {
			tst.getAddnewtagbtn().click();
			tst.getTagnametxtfield().sendKeys(tagname);
			tst.getCreatetagbtn().click();
			utilityclassobject.gettest().log(Status.INFO, "Created a tag successfully");
			System.out.println("Created a tag successfully");
			Thread.sleep(5000);
			tst.getAlltagsbtn().click();
			Thread.sleep(3000);
			List<WebElement> list = tst.getCreatedtagnamelist();
			boolean found = false;
			for (WebElement ele : list) {
				try {
					if (ele.getText().contains(tagname)) {
						found = true;
						System.out.println("Tag name is present in the tag name list");
						utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
						try {
							String createdby = driver.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::div[4]")).getText();
							System.out.println("Tag created by: " + createdby);
							utilityclassobject.gettest().log(Status.INFO, "Tag created by: " + createdby);
						} catch (Exception ex) {
							System.out.println("Could not get 'created by' info: " + ex.getMessage());
							utilityclassobject.gettest().log(Status.FAIL, "Could not get 'created by' info: " + ex.getMessage());
						}
						break;
					}
				} catch (Exception ex) {
					System.out.println("Error reading tag element: " + ex.getMessage());
				}
			}
			if (!found) {
				System.out.println("Tag name not found in tag list");
				utilityclassobject.gettest().log(Status.FAIL, "Tag name not found in tag list");
			}
		} catch (Exception e) {
			System.out.println("TC_020 failed: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "TC_020 failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC_020VeifyTagsCreatedby")
	public void TC_021VerifyTagsCreatedBySystem() throws InterruptedException {
		List<WebElement> crestedbyssystem = driver.findElements(
				By.xpath("//div[contains(@class,'hover:bg-opacity-20')]//div[contains(@class,'truncate')][4]"));
		for (WebElement ele : crestedbyssystem) {
			if (ele.getText().contains("System")) {

				List<WebElement> Systemtaglists = driver
						.findElements(By.xpath("//div[text()='System']/../descendant::div"));
				for (WebElement ele1 : Systemtaglists) {
					System.out.println("System tag name: " + ele1.getText());
					utilityclassobject.gettest().log(Status.INFO, "System tag name: " + ele1.getText());
				}
			}
		}
	}

	@Test(dependsOnMethods = "TC_021VerifyTagsCreatedBySystem")
	public void TC_022VerifyNameofthUserInCreatedTag() throws InterruptedException {
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(tagname)) {
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String createdby = driver.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::div[4]")).getText();
						System.out.println("Tag created by: " + createdby);
						utilityclassobject.gettest().log(Status.INFO, "Tag created by: " + createdby);
					} catch (Exception ex) {
						System.out.println("Could not get 'created by' field: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get 'created by' field: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Error reading tag element in TC_022: " + ex.getMessage());
			}
		}
	}

	@Test(dependsOnMethods = "TC_022VerifyNameofthUserInCreatedTag")
	public void TC_023VerifyTagCreatedTime() throws InterruptedException {
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(tagname)) {
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String createdtime = driver.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::div[5]")).getText();
						System.out.println("Tag created time: " + createdtime);
						utilityclassobject.gettest().log(Status.INFO, "Tag created Time: " + createdtime);
					} catch (Exception ex) {
						System.out.println("Could not get created time: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get created time: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Error reading tag element in TC_023: " + ex.getMessage());
			}
		}
	}

	@Test(dependsOnMethods = "TC_023VerifyTagCreatedTime")
	public void TC_024VerifyTagCratedDate() throws InterruptedException {
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(tagname)) {
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String createddatetime = driver.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::div[5]")).getText();
						String createddate = createddatetime.contains(",") ? createddatetime.split(",")[0].trim() : createddatetime;
						System.out.println("Tag created date: " + createddate);
						utilityclassobject.gettest().log(Status.INFO, "Tag created Date: " + createddate);
					} catch (Exception ex) {
						System.out.println("Could not get created date: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get created date: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Error reading tag element in TC_024: " + ex.getMessage());
			}
		}
	}

	@Test(dependsOnMethods = "TC_024VerifyTagCratedDate")
	public void TC_025VerifyTagCreatedTimeFormat() throws InterruptedException {
		
		List<WebElement> list = tst.getCreatedtagnamelist();
		boolean found = false;
		for (WebElement ele : list) {
			if (ele.getText().contains(tagname)) {
				found = true;
				System.out.println("Tag name is present in the tag name list");
				utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
				String createddatetime = driver
						.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::div[5]")).getText();
				System.out.println("Tag created date & time raw value: " + createddatetime);

				// Extract time part: expected format after comma e.g. "10:13:24 AM"
				String timePart = "";
				if (createddatetime.contains(",")) {
					timePart = createddatetime.split(",")[1].trim();
				} else {
					timePart = createddatetime.trim();
				}
				System.out.println("Extracted time part: " + timePart);
				utilityclassobject.gettest().log(Status.INFO, "Extracted time part: " + timePart);

				// Validate time format HH:MM:SS (12-hour or 24-hour with optional AM/PM)
				// Pattern: one or two digits : two digits : two digits (optional space + AM/PM)
				boolean isValidTimeFormat = timePart.matches("^(0?[1-9]|1[0-2]):[0-5][0-9]:[0-5][0-9]\\s?(AM|PM)$")
						|| timePart.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$");

				if (isValidTimeFormat) {
					System.out.println("Time format is valid HH:MM:SS - " + timePart);
					utilityclassobject.gettest().log(Status.PASS, "Time format is valid HH:MM:SS - " + timePart);
				} else {
					System.out.println("Time format is NOT valid HH:MM:SS - " + timePart);
					utilityclassobject.gettest().log(Status.FAIL, "Time format is NOT valid HH:MM:SS - " + timePart);
				}

				/*WebElement delete = driver.findElement(
						By.xpath("//div[text()='" + tagname + "']/../descendant::button[text()='Delete']"));
				wlib.scrollToelement(driver, delete);
				Thread.sleep(2000);
				delete.click();
				tst.getDeleteconfirmbtn().click();
				System.out.println("Deleted the created tag successfully");
				utilityclassobject.gettest().log(Status.INFO, "Deleted the created tag successfully");
				break;*/
			}
		}
		if (!found) {
			System.out.println("Tag name is not present in the tag name list");
			utilityclassobject.gettest().log(Status.FAIL, "Tag name is not present in the tag name list");
		}
		
	}
	
	@Test(dependsOnMethods = "TC_025VerifyTagCreatedTimeFormat")
	public void TC_026VerifyLastuserDateandTime() throws InterruptedException {
		oldtag = "After Care";
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(oldtag)) {
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String ladtusedtimeanddate = driver.findElement(By.xpath("//div[text()='" + oldtag + "']/../descendant::div[6]")).getText();
						System.out.println("Last used time and date " + ladtusedtimeanddate);
						utilityclassobject.gettest().log(Status.INFO, "Last used time and date  " + ladtusedtimeanddate);
					} catch (Exception ex) {
						System.out.println("Could not get last used date/time: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get last used date/time: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Error reading tag element in TC_026: " + ex.getMessage());
			}
		}
	}
	@Test(dependsOnMethods = "TC_026VerifyLastuserDateandTime")
	public void TC_027VerifyLastUsedTimeWithoutusingtag() throws InterruptedException {
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(tagname)) {
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String ladtusedtimeanddate = driver.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::div[6]")).getText();
						System.out.println("Last used time and date without using tag " + ladtusedtimeanddate);
						utilityclassobject.gettest().log(Status.INFO, "Last used time and date without using tag  " + ladtusedtimeanddate);
						if (ladtusedtimeanddate.contains("-")) {
							System.out.println("Last used time and date is displayed as '-' when the tag is not used");
							utilityclassobject.gettest().log(Status.PASS, "Last used time and date is displayed as '-' when the tag is not used");
						} else {
							System.out.println("Last used time and date is not displayed as '-' when the tag is not used");
							utilityclassobject.gettest().log(Status.FAIL, "Last used time and date is not displayed as '-' when the tag is not used");
						}
					} catch (Exception ex) {
						System.out.println("Could not get last used time/date: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get last used time/date: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Error reading tag element in TC_027: " + ex.getMessage());
			}
		}
	}
	@Test(dependsOnMethods = "TC_027VerifyLastUsedTimeWithoutusingtag")
	public void TC_028VerifyLastUsedTimeAfterUsingTag() throws InterruptedException {
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(oldtag)) {
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String ladtusedtimeanddate = driver.findElement(By.xpath("//div[text()='" + oldtag + "']/../descendant::div[6]")).getText();
						System.out.println("Last used time and date of earlier tag" + ladtusedtimeanddate);
						utilityclassobject.gettest().log(Status.INFO, "Last used time and date of earlier tag " + ladtusedtimeanddate);
					} catch (Exception ex) {
						System.out.println("Could not get last used date/time for oldtag: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get last used date/time for oldtag: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Error reading tag element in TC_028: " + ex.getMessage());
			}
		}
		System.out.println(tagname);
	}
	@Test(dependsOnMethods = "TC_028VerifyLastUsedTimeAfterUsingTag")
	public void TC_029VerifyLastUsedTimeAfterUsingTag() throws InterruptedException {
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(oldtag)) {
					System.out.println("Tag name is present in the tag name list");
					utilityclassobject.gettest().log(Status.PASS, "Tag name is present in the tag name list");
					try {
						String ladtusedtimeanddate = driver
								.findElement(By.xpath("//div[text()='" + oldtag + "']/../descendant::div[6]")).getText();
						// Extract only the time part (after the comma)
						String timePart = "";
						if (ladtusedtimeanddate.contains(",")) {
							timePart = ladtusedtimeanddate.split(",")[1].trim();
						} else {
							timePart = ladtusedtimeanddate.trim();
						}
						System.out.println("Last used time of earlier tag: " + timePart);
						utilityclassobject.gettest().log(Status.INFO, "Last used time of earlier tag: " + timePart);
					} catch (Exception ex) {
						System.out.println("Could not get last used time in TC_029: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not get last used time in TC_029: " + ex.getMessage());
					}
				}
			} catch (Exception ex) {
				System.out.println("Stale/error reading element in TC_029: " + ex.getMessage());
			}
		}
	}
	
	@Test(dependsOnMethods = "TC_029VerifyLastUsedTimeAfterUsingTag")
	public void TC_030VerifySystemTagCreatedBySysstemisUnderActions() throws InterruptedException {
		List<WebElement> actionlist = driver.findElements(By.xpath("//span[text()='System Tag']/../.."));
		for (WebElement ele : actionlist) {
			System.out.println(ele.getText());
			if (ele.getText().contains("System Tag")) {
				System.out.println("System tag created by system is under actions");
				utilityclassobject.gettest().log(Status.PASS, "System tag created by system is under actions");
			} else {
				System.out.println("System tag created by system is not under actions");
				utilityclassobject.gettest().log(Status.FAIL, "System tag created by system is not under actions");
			}
		}
	}
	@Test(dependsOnMethods = "TC_030VerifySystemTagCreatedBySysstemisUnderActions")
	public void TC_031VerifySystemTagarenoteditable() throws InterruptedException {
		// Directly check if any Edit button exists inside System Tag rows - fast single XPath
		List<WebElement> editButtons = driver.findElements(By.xpath("//span[text()='System Tag']/../..//button[text()='Edit']"));
		if (editButtons.isEmpty()) {
			System.out.println("System tags do not have Edit option - PASS");
			utilityclassobject.gettest().log(Status.PASS, "System tags do not have Edit option as expected");
		} else {
			System.out.println("System tags have Edit option - FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "System tags should not have Edit option but it is present");
		}
	}
	@Test(dependsOnMethods = "TC_031VerifySystemTagarenoteditable")
	public void TC_032VerifySystemTagarenotdeletable() throws InterruptedException {
		// Directly check if any Delete button exists inside System Tag rows - fast single XPath
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//span[text()='System Tag']/../..//button[text()='Delete']"));
		if (deleteButtons.isEmpty()) {
			System.out.println("System tags do not have Delete option - PASS");
			utilityclassobject.gettest().log(Status.PASS, "System tags do not have Delete option as expected");
		} else {
			System.out.println("System tags have Delete option - FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "System tags should not have Delete option but it is present");
		}
	}
	@Test(dependsOnMethods = "TC_032VerifySystemTagarenotdeletable")
	public void TC_033VerifyCreatedTagHaveBothEditandDeleteOption() {
		List<WebElement> actions = driver.findElements(By.xpath("//div[text()='" + tagname + "']/../descendant::button"));
		boolean editFound = false;
		boolean deleteFound = false;
		for (WebElement action : actions) {
			String actionText = action.getText();
			if (actionText.contains("Edit")) {
				editFound = true;
			} else if (actionText.contains("Delete")) {
				deleteFound = true;
			}
		}
		if (editFound && deleteFound) {
			System.out.println("Created tag has both Edit and Delete options - PASS");
			utilityclassobject.gettest().log(Status.PASS, "Created tag has both Edit and Delete options");
		} else {
			System.out.println("Created tag does not have both Edit and Delete options - FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Created tag should have both Edit and Delete options but it does not");
		}
	}
	@Test(dependsOnMethods = "TC_033VerifyCreatedTagHaveBothEditandDeleteOption")
	public void TC_034VerifySystemTagEdit() throws InterruptedException {
		list = tst.getCreatedtagnamelist();
		for (WebElement ele : list) {
			try {
				if (ele.getText().contains(tagname)) {
					try {
						WebElement editBtn = driver.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::button[text()='Edit']"));
						wlib.scrollToelement(driver, editBtn);
						Thread.sleep(2000);
						editBtn.click();
						driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
						Thread.sleep(2000);
						tst.getUpdatebtn().click();
						Thread.sleep(3000);
						utilityclassobject.gettest().log(Status.INFO, "Tag edited successfully");
						System.out.println("Tag edited successfully");
					} catch (Exception ex) {
						System.out.println("Could not edit tag: " + ex.getMessage());
						utilityclassobject.gettest().log(Status.FAIL, "Could not edit tag: " + ex.getMessage());
					}
					break;
				}
			} catch (Exception ex) {
				System.out.println("Error reading tag element in TC_034: " + ex.getMessage());
			}
		}
	}
	@Test(dependsOnMethods = "TC_034VerifySystemTagEdit")
	public void TC_035VerifyTagDelete() throws InterruptedException {
		System.out.println(tagname);
		try {
			tst.Deletetag(tagname);
			utilityclassobject.gettest().log(Status.INFO, "Tag deleted successfully");
			System.out.println("Tag deleted successfully");
		} catch (Exception e) {
			System.out.println("Could not delete tag: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "Could not delete tag: " + e.getMessage());
		}
	}
	@Test(dependsOnMethods = "TC_035VerifyTagDelete")
	public void TC_036VerifyAbletosaveTagAfterClickingOnDelete() throws InterruptedException {
		try {
			tst.getAddnewtagbtn().click();
			tst.getTagnametxtfield().sendKeys(tagname);
			tst.getCreatetagbtn().click();
			utilityclassobject.gettest().log(Status.INFO, "Created a tag successfully");
			System.out.println("Created a tag successfully");
			Thread.sleep(5000);
			WebElement delete = driver.findElement(By.xpath("//div[text()='" + tagname + "']/../descendant::button[text()='Delete']"));
			webDriverutility wlib = new webDriverutility();
			wlib.scrollToelement(driver, delete);
			Thread.sleep(2000);
			delete.click();
			tst.getCancelbtninedit().click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Cancelled the delete action on Tag successfully");
			System.out.println("Cancelled the delete action on Tag successfully");
		} catch (Exception e) {
			System.out.println("TC_036 encountered exception: " + e.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "TC_036 encountered exception: " + e.getMessage());
		}
		System.out.println(tagname);
	}
	String tagname1;
	@Test(dependsOnMethods = "TC_036VerifyAbletosaveTagAfterClickingOnDelete")
	public void TC_037VerifyAbletoDeleteMultipleTagsat_a_Time() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		random = new Random();
		int randomNumber = 10000 + random.nextInt(90000);
		tagname1 = "Charlie tag " + randomNumber;
		System.out.println(tagname1);

		// Wait for page to fully settle after TC_036's cancel action
		Thread.sleep(5000);

		// Create tagname1 - with retry fallback if page is still loading
		try {
			js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(tst.getAddnewtagbtn())));
		} catch (Exception retryEx) {
			System.out.println("Add New Tag button not ready, retrying after extra wait: " + retryEx.getMessage());
			Thread.sleep(5000);
			js.executeScript("arguments[0].click();", new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.elementToBeClickable(tst.getAddnewtagbtn())));
		}
		Thread.sleep(1000);
		tst.getTagnametxtfield().sendKeys(tagname1);
		js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(tst.getCreatetagbtn())));
		utilityclassobject.gettest().log(Status.INFO, "Created tag1 successfully");
		System.out.println("Created tag1 successfully");
		Thread.sleep(5000);

		js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(tst.getAlltagsbtn())));
		Thread.sleep(3000);

		// --- Direct checkbox click for tagname1 (no for-loop, avoids stale element) ---
		try {
			WebElement checkbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[contains(text(),'" + tagname1 + "')]/ancestor::div[contains(@class,'hover')]//input[@type='checkbox']")));
			wlib.scrollToelement(driver, checkbox1);
			Thread.sleep(500);
			try {
				checkbox1.click();
			} catch (Exception e1) {
				js.executeScript("arguments[0].click();", checkbox1);
			}
			System.out.println("Checkbox selected for tagname1: " + tagname1);
			utilityclassobject.gettest().log(Status.INFO, "Checkbox selected for tagname1: " + tagname1);
		} catch (Exception e1) {
			System.out.println("Could not select checkbox for tagname1: " + e1.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "Could not select checkbox for tagname1: " + e1.getMessage());
		}
		Thread.sleep(1000);

		// --- Direct checkbox click for tagname (no for-loop, avoids stale element) ---
		try {
			WebElement checkbox2 = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[contains(text(),'" + tagname + "')]/ancestor::div[contains(@class,'hover')]//input[@type='checkbox']")));
			wlib.scrollToelement(driver, checkbox2);
			Thread.sleep(500);
			try {
				checkbox2.click();
			} catch (Exception e2) {
				js.executeScript("arguments[0].click();", checkbox2);
			}
			System.out.println("Checkbox selected for tagname: " + tagname);
			utilityclassobject.gettest().log(Status.INFO, "Checkbox selected for tagname: " + tagname);
		} catch (Exception e2) {
			System.out.println("Could not select checkbox for tagname: " + e2.getMessage());
			utilityclassobject.gettest().log(Status.FAIL, "Could not select checkbox for tagname: " + e2.getMessage());
		}
		Thread.sleep(1000);

		// Click bulk Delete button (top-right corner action bar)
		Thread.sleep(1000);
		WebElement bulkDeleteBtn = null;

		// Strategy 1: button positioned in fixed/sticky top-right action bar
		String[] bulkDeleteXpaths = {
			"(//button[normalize-space(text())='Delete'])[last()]",
			"//div[contains(@class,'fixed')]//button[normalize-space(text())='Delete']",
			"//div[contains(@class,'sticky')]//button[normalize-space(text())='Delete']",
			"//div[contains(@class,'absolute')]//button[normalize-space(text())='Delete']",
			"//div[contains(@class,'top')]//button[normalize-space(text())='Delete']",
			"//button[normalize-space(text())='Delete']"
		};

		for (String xpath : bulkDeleteXpaths) {
			try {
				List<WebElement> btns = driver.findElements(By.xpath(xpath));
				if (!btns.isEmpty()) {
					bulkDeleteBtn = btns.get(btns.size() - 1);
					// scroll to top-right: use JS to bring into view
					js.executeScript("arguments[0].scrollIntoView({block:'center',inline:'center'});", bulkDeleteBtn);
					Thread.sleep(500);
					System.out.println("Bulk Delete button found via xpath: " + xpath);
					System.out.println("Bulk Delete button location: " + bulkDeleteBtn.getLocation() + " | displayed: " + bulkDeleteBtn.isDisplayed() + " | enabled: " + bulkDeleteBtn.isEnabled());
					break;
				}
			} catch (Exception ignored) {}
		}

		if (bulkDeleteBtn != null) {
			try {
				bulkDeleteBtn.click();
				System.out.println("Bulk Delete clicked via normal click");
			} catch (Exception e1) {
				try {
					js.executeScript("arguments[0].click();", bulkDeleteBtn);
					System.out.println("Bulk Delete clicked via JS click");
				} catch (Exception e2) {
					// Scroll page to top so sticky/fixed button is visible, then retry
					js.executeScript("window.scrollTo(0,0);");
					Thread.sleep(500);
					js.executeScript("arguments[0].click();", bulkDeleteBtn);
					System.out.println("Bulk Delete clicked after scrolling to top");
				}
			}
		} else {
			System.out.println("Bulk Delete button not found after all strategies");
			utilityclassobject.gettest().log(Status.FAIL, "Bulk Delete button not found after all strategies");
			return;
		}
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(tst.getDeleteconfirmbtn())));

		utilityclassobject.gettest().log(Status.PASS, "Able to Delete multiple tags at a time successfully");
		System.out.println("Able to Delete multiple tags at a time successfully");
	}
	@Test(dependsOnMethods = "TC_037VerifyAbletoDeleteMultipleTagsat_a_Time")
	public void TC_038VerifyFilterTags() throws InterruptedException {
	  List<WebElement> filtertahgs = tst.getFiltertags();
	  for (WebElement ele : filtertahgs) {
		 System.out.println(ele.getText());
		 utilityclassobject.gettest().log(Status.INFO, "Filter tag option: " + ele.getText());
		 
		 
		 
		  }
	  }
	@Test(dependsOnMethods = "TC_038VerifyFilterTags")
	public void TC_039VerifyFilterTagsFunctionality() throws InterruptedException {
		tst.getUsertagsbtn().click();
		Thread.sleep(2000);
		List<WebElement> usernamelist = tst.getUsercreatedtagnamelist();
		for (WebElement ele : usernamelist) {
			System.out.println("User lists" +ele.getText());
			utilityclassobject.gettest().log(Status.INFO, "User Tags are displayed successfully: " + ele.getText());
		}
	}
	@Test(dependsOnMethods = "TC_039VerifyFilterTagsFunctionality")
	public void TC_040VerifySystemFilterTagsFunctionality() throws InterruptedException {
		tst.getSystemtagsbtn().click();
		Thread.sleep(2000);
		List<WebElement> systemtaglist = tst.getSystemcreatedtagnamelist();
		for (WebElement ele : systemtaglist) {
			System.out.println("System tag lists" +ele.getText());
			utilityclassobject.gettest().log(Status.INFO, "System Tags are displayed successfully: " + ele.getText());
		}
	}
	@Test(dependsOnMethods = "TC_040VerifySystemFilterTagsFunctionality")
	public void TC_041VerifySearchAllTagFunctionality() throws InterruptedException {
		tst.getAlltagsbtn().click();
		Thread.sleep(2000);
		List<WebElement> alltaglist = tst.getAllcreatedtagnamelist();
		for (WebElement ele : alltaglist) {
			System.out.println("All tag lists" +ele.getText());
			utilityclassobject.gettest().log(Status.INFO, "All Tags are displayed successfully: " + ele.getText());
		}
		
	}
	
}
