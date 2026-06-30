package com.Octopussaas.ObjectRepository;

import java.util.List;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class BillingSettings {
	WebDriver driver;

	public BillingSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//h1[contains(normalize-space(),'Billing') or contains(normalize-space(),'Billing Settings')]")
	private WebElement BillingHeader;
	@FindBy(xpath = "//input[@type='number']")
	private WebElement yeartoDateRevenue;
	@FindBy(xpath = "(//div[text()='2025']/ancestor::div[@class='flex items-center gap-2']/descendant::div)[2]")
	private WebElement year2025TextField;
	@FindBy(xpath = "//span[text()='Invoice #']/preceding-sibling::div")
	private WebElement invoiceCheckbox;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmButton;
	@FindBy(xpath = "(//button[text()='✕'])[10]")
	private WebElement closeButton;
	@FindBy(xpath = "//span[text()='Invoice Date']/preceding-sibling::div")
	private WebElement invoiceDateCheckbox;
	@FindBy(xpath = "//span[text()='Due Date']/preceding-sibling::div")
	private WebElement dueDateCheckbox;
	@FindBy(xpath = "//span[text()='Terms']/preceding-sibling::div")
	private WebElement termsCheckbox;
	@FindBy(xpath = "(//span[text()='Invoice Total']/preceding-sibling::div)[1]")
	private WebElement invoiceTotalCheckbox1;
	@FindBy(xpath = "(//span[text()='Bill To']/preceding-sibling::div)[1]")
	private WebElement billToCheckbox;
	@FindBy(xpath = "(//span[text()='Previous Balance']/preceding-sibling::div)[1]")
	private WebElement previousBalanceCheckbox;
	@FindBy(xpath = "(//span[text()='Autopay Status']/preceding-sibling::div)[1]")
	private WebElement autopayStatus;
	@FindBy(xpath = "(//span[text()='Last Payment']/preceding-sibling::div)[1]")
	private WebElement lastPaymentCheckbox;
	@FindBy(xpath = "(//span[text()='Overdue Total Notice']/preceding-sibling::div)[1]")
	private WebElement overdueTotalNoticeCheckbox;
	@FindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement textfield2025;
	@FindBy(xpath = "(//input[@type='number'])[3]")
	private WebElement textfield2024;
	@FindBy(xpath = "(//input[@type='number'])[4]")
	private WebElement textfield2023;
	@FindBy(xpath = "(//input[@type='number'])[5]")
	private WebElement textfield2022;
	@FindBy(xpath = "(//input[@type='number'])[6]")
	private WebElement textfield2021;
	@FindBy(xpath = "(//input[@type='number'])[7]")
	private WebElement textfield2020;
	@FindBy(xpath = "(//input[@type='number'])[8]")
	private WebElement textfield2019;
	@FindBy(xpath = "(//input[@type='number'])[9]")
	private WebElement textfield2018;
	@FindBy(xpath = "(//input[@type='number'])[10]")
	private WebElement textfield2017;
	@FindBy(xpath = "(//input[@type='number'])[11]")
	private WebElement textfield2016;
	@FindBy(xpath = "(//span[text()='Account Number']/preceding-sibling::div)[1]")
	private WebElement accountNumberCheckbox;
	@FindBy(xpath = "(//span[text()='Generator Location Name']/preceding-sibling::div)[1]")
	private WebElement generatorLocationNameCheckbox;
	@FindBy(xpath = "(//span[text()='Generator Service Address']/preceding-sibling::div)[1]")
	private WebElement generatorServiceAddressCheckbox;
	@FindBy (xpath = "(//span[text()='Service Date']/preceding-sibling::div)[1]")
	private WebElement serviceDateCheckbox;
	@FindBy(xpath = "(//span[text()='Document ID']/preceding-sibling::div)[1]")
	private WebElement documentIDCheckbox;
	@FindBy(xpath = "(//span[text()='Description']/preceding-sibling::div)[1]")
	private WebElement descriptionChcekbox;
	@FindBy(xpath = "(//span[text()='Quantity']/preceding-sibling::div)[1]")
	private WebElement quantityChcekbox;
	@FindBy(xpath = "(//span[text()='Weight']/preceding-sibling::div)[1]")
	private WebElement weightcheckBox;
	@FindBy(xpath = "(//span[text()='Total']/preceding-sibling::div)[1]")
	private WebElement totalcheckbox;
	@FindBy(xpath = "(//span[text()='Taxes']/preceding-sibling::div)[1]")
	private WebElement taxesCheckbox;
	@FindBy(xpath = "(//span[text()='Subtotal']/preceding-sibling::div)[1]")
	private WebElement subtotalCheckbox;
	@FindBy(xpath = "(//span[text()='Rate']/preceding-sibling::div)[1]")
	private WebElement rateCheckbox;
	@FindBy(xpath = "(//span[text()='Discount']/preceding-sibling::div)[1]")
	private WebElement discountCheckbox;
	@FindBy(xpath = "(//span[text()='Invoice Total']/preceding-sibling::div)[2]")
	private WebElement invoiceTotalCheckbox2fromInvoicefooter;
	@FindBy(xpath = "(//span[text()='Aging Report']/preceding-sibling::div)[1]")
	private WebElement agingReportCheckbox;
	@FindBy(xpath = "(//span[text()='Payment Voucher']/preceding-sibling::div)[1]")
	private WebElement paymentVoucherCheckbox;
	@FindBy(xpath = "//div[@data-placeholder='Enter a message to display on all invoices']")
	private WebElement custominvoicemessageTextfield;
	@FindBy(xpath = "//h3[text()='Printing & Envelope Instructions']")
	private WebElement printingAndEnvelopeInstructionsHeader;
	@FindBy(xpath = "(//button[@type='button'])[8]")
	private WebElement paymenttermsdropdown;
	@FindBy(xpath = "//p[text()='+ Add Payment Type']")
	private WebElement addPaymentTypelink;
	@FindBy(xpath = "//div[@class='bg-white rounded-lg p-6 w-96 shadow-lg']")
	private WebElement addPaymentTypePopup;
	@FindBy(xpath = "//input[@placeholder='Enter payment type name']")
	private WebElement paymentTypeTextField;
	@FindBy(xpath = "(//button[text()='Cancel'])[3]")
	private WebElement cancelButtonfrompaymentTypePopup;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonfromPaymentTypePopup;
	@FindBy (xpath = "//div[@class='flex flex-wrap gap-6 pl-6']")
	private WebElement acceptedpaymentTypeListSection;
	@FindBy(xpath = "//span[text()='card']/../descendant::div")
	private WebElement cardCheckbox;
	@FindBy(xpath = "//div[@class='w-3 h-3 bg-white rounded-full']")
	private WebElement autoapplyecxessradiobtn;
	@FindBy(xpath = "(//div[@class='flex items-center rounded-lg  gap-3  cursor-pointer']/../descendant::div)[5]")
	private WebElement holdexcessPaymentasaccountcredit;
	@FindBy(xpath = "//span[text()='Electronic Billing (Email)']/preceding-sibling::div")
    private WebElement 	electronicBillingCheckbox;
	@FindBy(xpath = "//span[text()='Generator Portal Billing']/preceding-sibling::div")
	private WebElement generatorPortalBillingCheckbox;
	@FindBy(xpath = "//span[text()='Paper Billing']/preceding-sibling::div")
	private WebElement paperBillingCheckbox;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement replayToemailAddresstextfield;
	@FindBy(xpath = "//span[text()='OCTO Smart Manifest']/preceding-sibling::div")
	private WebElement octoSmartManifestCheckbox;
	@FindBy(xpath = "//span[text()='OCTO Delivery Receipts']/preceding-sibling::div")
	private WebElement octoDeliveryReceiptsCheckbox;
	@FindBy(xpath = "//span[text()='OCTO Shredding Service Document']/preceding-sibling::div")
	private WebElement octoShreddingServiceDocumentCheckbox;
	@FindBy(xpath = "//span[text()='Initial:']/ancestor::div[@class='pl-6 flex items-center gap-4']/descendant::div")
	private WebElement notificationfrequencyinitialCheckbox;
	@FindBy(xpath = "//div[text()='Subsequent:']/ancestor::div[@class='pl-6 flex items-center gap-4 my-4']/descendant::div")
	private WebElement notificationfrequencySubsequentCheckbox;
	@FindBy(xpath = "//span[text()='Initial:']/following::input[1]")
	private WebElement notificationfrequencyinitialTextfield;
	@FindBy(xpath = "//span[text()='Subsequent:']/following::input[1]")
	private WebElement notificationfrequencySubsequentTextfield;
	
	// By-locators for robust re-finding to avoid stale-element issues
    private By notificationfrequencyinitialCheckboxBy = By.xpath("//span[text()='Initial:']/ancestor::div[@class='pl-6 flex items-center gap-4']/descendant::div");
    private By notificationfrequencyinitialTextfieldBy = By.xpath("//span[text()='Initial:']/following::input[1]");
	
	public WebElement getNotificationfrequencySubsequentTextfield() {
		return notificationfrequencySubsequentTextfield;
	}
	public WebElement getNotificationfrequencyinitialTextfield() {
		return notificationfrequencyinitialTextfield;
	}
	
	public WebElement getNotificationfrequencySubsequentChcekBox() {
		return notificationfrequencySubsequentCheckbox;
	}
	
	public WebElement getNotificationfrequencyinitialCheckBox() {
		return notificationfrequencyinitialCheckbox;
	}
	
	public WebElement getOctoShreddingServiceDocumentCheckbox() {
		return octoShreddingServiceDocumentCheckbox;
	}
	
	public WebElement getOctoDeliveryReceiptsCheckbox() {
		return octoDeliveryReceiptsCheckbox;
	}
	public WebElement getOctoSmartManifestCheckbox() {
		return octoSmartManifestCheckbox;
	}
	public WebElement getReplayToemailAddresstextfield() {
		return replayToemailAddresstextfield;
	}
	public WebElement getPaperBillingCheckbox() {
		return paperBillingCheckbox;
	}
	
	public WebElement getGeneratorPortalBillingCheckbox() {
		return generatorPortalBillingCheckbox;
	}
	
	public WebElement getElectronicBillingCheckbox() {
		return electronicBillingCheckbox;
	}
	
	
	public WebElement getHoldexcessPaymentasaccountcredit() {
		return holdexcessPaymentasaccountcredit;
	}
	public WebElement getAutoapplyecxessradiobtn() {
		return autoapplyecxessradiobtn;
	}
	
	public WebElement getCardCheckbox() {
		return cardCheckbox;
	}
	public WebElement getAcceptedpaymentTypeListSection() {
		return acceptedpaymentTypeListSection;
	}
	public WebElement getSaveButtonfromPaymentTypePopup() {
		return saveButtonfromPaymentTypePopup;
	}
	public WebElement getCancelButtonfrompaymentTypePopup() {
		return cancelButtonfrompaymentTypePopup;
	}
	public WebElement getPaymentTypeTextField() {
		return paymentTypeTextField;
	}
	
	
	public WebElement getAddPaymentTypePopup() {
		return addPaymentTypePopup;
	}
	public WebElement getAddPaymentTypelink() {
		return addPaymentTypelink;
	}
	
	
	
	public WebElement getPaymenttermsdropdown() {
		return paymenttermsdropdown;
	}
	public WebElement getPrintingAndEnvelopeInstructionsHeader() {
		return printingAndEnvelopeInstructionsHeader;
	}
	public WebElement getCustominvoicemessageTextfield() {
		return custominvoicemessageTextfield;
	}
	public WebElement getPaymentVoucherCheckbox() {
		return paymentVoucherCheckbox;
	}
	public WebElement getAgingReportCheckbox() {
		return agingReportCheckbox;
	}
	public WebElement getInvoiceTotalCheckbox2fromInvoicefooter() {
		return invoiceTotalCheckbox2fromInvoicefooter;
	}
	public WebElement getDiscountCheckbox() {
		return discountCheckbox;
	}
	public WebElement getRateCheckbox() {
		return rateCheckbox;
	}
	public WebElement getSubtotalCheckbox() {
		return subtotalCheckbox;
	}
	public WebElement getTaxesCheckbox() {
		return taxesCheckbox;
	}
	public WebElement getTotalcheckbox() {
		return totalcheckbox;
	}
	public WebElement getWeightcheckBox() {
		return weightcheckBox;
	}
	public WebElement getQuantityChcekbox() {
		return quantityChcekbox;
	}
	public WebElement getDescriptionChcekbox() {
		return descriptionChcekbox;
	}
	public WebElement getDocumentIDCheckbox() {
		return documentIDCheckbox;
	}
	public WebElement getServiceDateCheckbox() {
		return serviceDateCheckbox;
	}
	public WebElement getGeneratorServiceAddressCheckbox() {
		return generatorServiceAddressCheckbox;
	}
	public WebElement getGeneratorLocationNameCheckbox() {
		return generatorLocationNameCheckbox;
	}
	public WebElement getAccountNumberCheckbox() {
		return accountNumberCheckbox;
	}
	public WebElement getTextfield2016() {
		return textfield2016;
	}
	public WebElement getTextfield2017() {
		return textfield2017;
	}
	public WebElement getTextfield2018() {
		return textfield2018;
	}
	public WebElement getTextfield2019() {
		return textfield2019;
	}
	public WebElement getTextfield2020() {
		return textfield2020;
	}
	public WebElement getTextfield2021() {
		return textfield2021;
	}
	public WebElement getTextfield2022() {
		return textfield2022;
	}
	public WebElement getTextfield2023() {
		return textfield2023;
	}
	public WebElement getTextfield2024() {
		return textfield2024;
	}
	public WebElement getTextfield2025() {
		return textfield2025;
	}
	public WebElement getOverdueTotalNoticeCheckbox() {
		return overdueTotalNoticeCheckbox;
	}
	public WebElement getLastPaymentCheckbox() {
		return lastPaymentCheckbox;
	}
	public WebElement getAutopayStatus() {
		return autopayStatus;
	}
	public WebElement getPreviousBalanceCheckbox() {
		return previousBalanceCheckbox;
	}
	public WebElement getBillToCheckbox() {
		return billToCheckbox;
	}
	public WebElement getInvoiceTotalCheckbox1() {
		return invoiceTotalCheckbox1;
	}
	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}
	public WebElement getDueDateCheckbox() {
		return dueDateCheckbox;
	}
	public WebElement getInvoiceDateCheckbox() {
		return invoiceDateCheckbox;
	}
	public WebElement getCloseButton() {
		return closeButton;
	}
	public WebElement getConfirmButton() {
		return confirmButton;
	}
	public WebElement getInvoiceCheckbox() {
		return invoiceCheckbox;
	}
	public WebElement getYear2025TextField() {
		return year2025TextField;
	}
	public WebElement getYeartoDateRevenue() {
		return yeartoDateRevenue;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getBillingHeader() {
		return BillingHeader;
	}
	
	// Dynamically find the Hard Close date element using several candidate XPaths with a wait.
	public WebElement getHardCloseDate() {
		List<By> candidates = Arrays.asList(
			By.xpath("//label[contains(normalize-space(),'Hard Close')]/following-sibling::*[1]"),
			By.xpath("//label[contains(normalize-space(),'Hard Close')]/following::input[1]"),
			By.xpath("//*[contains(normalize-space(),'Hard Close')]/following::div[1]"),
			By.xpath("//input[contains(@aria-label,'Hard Close') or contains(@placeholder,'Hard Close') or contains(@name,'hardClose')]")
		);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (By by : candidates) {
			try {
				// wait until at least one element located by this By is present
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
				List<WebElement> els = driver.findElements(by);
				for (WebElement el : els) {
					if (el != null && el.isDisplayed()) {
						// ensure visibility
						wait.until(ExpectedConditions.elementToBeClickable(el));
						return el;
					}
				}
			} catch (Exception e) {
				// ignore and try next candidate
			}
		}
		// build helpful debug message
		StringBuilder sb = new StringBuilder();
		sb.append("Tried the following XPaths:\n");
		for (By b : candidates) sb.append(b.toString()).append("\n");
		throw new NoSuchElementException("Hard Close date element not found. " + sb.toString());
	}

	// Robust check for custom-styled checkbox state. Some UI checkbox widgets are divs
	// without a native checked property. This method examines several attributes
	// (aria-checked, class, and finally isSelected) to determine state.
	public boolean isNotificationfrequencyinitialChecked() {
		WebElement checkboxEl = null;
		try {
			checkboxEl = driver.findElement(notificationfrequencyinitialCheckboxBy);
		} catch (Exception e) {
			checkboxEl = notificationfrequencyinitialCheckbox; // fallback to PageFactory field
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(checkboxEl));
		} catch (Exception e) {
			// ignore
		}
		try {
			String aria = checkboxEl.getAttribute("aria-checked");
			if (aria != null) {
				if (aria.equalsIgnoreCase("true") || aria.equalsIgnoreCase("checked"))
					return true;
				if (aria.equalsIgnoreCase("false") || aria.equalsIgnoreCase("unchecked"))
					return false;
			}
		} catch (Exception e) {
			// ignore
		}
		try {
			String cls = checkboxEl.getAttribute("class");
			if (cls != null) {
				// common patterns for checked state in custom controls
				if (cls.contains("checked") || cls.contains("active") || cls.contains("bg-") || cls.contains("true") || cls.contains("selected"))
					return true;
				if (cls.contains("unchecked") || cls.contains("inactive") || cls.contains("false"))
					return false;
			}
		} catch (Exception e) {
			// ignore
		}
		try {
			// Fallback to isSelected (useful if element is an input)
			return checkboxEl.isSelected();
		} catch (Exception e) {
			// if everything fails, assume unchecked
			return false;
		}
	}

	// Click helper with fallback to JS click. Returns true if after the method
	// the checkbox appears checked.
	public boolean clickNotificationfrequencyinitialCheckbox() {
		WebElement checkboxEl = null;
		try {
			checkboxEl = driver.findElement(notificationfrequencyinitialCheckboxBy);
		} catch (Exception e) {
			checkboxEl = notificationfrequencyinitialCheckbox;
		}
		try {
			checkboxEl.click();
			Thread.sleep(300);
			if (isNotificationfrequencyinitialChecked()) return true;
		} catch (Exception e) {
			// ignore and try JS click
		}
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkboxEl);
			Thread.sleep(300);
		} catch (Exception e) {
			// ignore
		}
		return isNotificationfrequencyinitialChecked();
	}

    // Ensure the Initial notification checkbox reaches desired state (checked/unchecked).
    // Tries multiple strategies: normal click, JS click, waits for attribute/class change.
    public boolean ensureNotificationfrequencyinitialChecked(boolean wantChecked, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
         try {
            // try to find element each time to avoid stale element refs
            try { driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ignore) {}
         } catch (Exception e) {
             // ignore
         }
         // scroll into view to improve click reliability
         try {
            WebElement el = null;
            try { el = driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ex) { el = notificationfrequencyinitialCheckbox; }
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
         } catch (Exception e) {
             // ignore
         }
         int attempts = 0;
         while (attempts < 4) {
            boolean current = isNotificationfrequencyinitialChecked();
            if (current == wantChecked) {
                return true;
            }
            try {
                WebElement el = null;
                try { el = driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ex) { el = notificationfrequencyinitialCheckbox; }
                wait.until(ExpectedConditions.elementToBeClickable(el));
                el.click();
                Thread.sleep(300);
            } catch (Exception e) {
                try {
                    WebElement el = null;
                    try { el = driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ex) { el = notificationfrequencyinitialCheckbox; }
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
                    Thread.sleep(300);
                } catch (Exception ex) {
                    // ignore and continue to next attempt
                }
            }
            // small wait for DOM updates
            try { Thread.sleep(300); } catch (InterruptedException ie) { /* ignore */ }
            // if some frameworks change aria-checked or class, wait briefly for it
            try {
                wait.withTimeout(Duration.ofSeconds(1)).until(d -> isNotificationfrequencyinitialChecked() == wantChecked);
                return isNotificationfrequencyinitialChecked() == wantChecked;
            } catch (Exception e) {
                // not yet changed, continue
            }
            attempts++;
         }
         return isNotificationfrequencyinitialChecked() == wantChecked;
     }
 
 }