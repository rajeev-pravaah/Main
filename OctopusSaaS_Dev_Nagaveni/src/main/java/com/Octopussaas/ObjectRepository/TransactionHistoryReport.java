package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionHistoryReport {
	WebDriver driver;

	public TransactionHistoryReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public WebDriver getDriver() {
		return driver;
		
	}
	
	
	
	@FindBy(xpath = "//button[text()='Create New Transaction']")
	public WebElement createNewTransactionButton;
	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchBox;
	@FindBy(xpath = "//div[@class='font-medium text-sm']")
	public WebElement searchsuggetion;
	@FindBy(xpath = "//p[text()='No Items Found.']/../descendant::button")
	public WebElement additembutton;
	@FindBy(xpath = "//h3[text()='Add New Invoice Item']/../descendant::button[text()='Add']")
	public WebElement addbuttonfromadditempopupbutton;
	@FindBy(xpath = "//input[@aria-haspopup='listbox']")
	public WebElement selectitemfromdropdown;
	@FindBy(xpath = "//li[@role='option']")
	public List<WebElement> selectitemfromdropdownlist;
	@FindBy(xpath = "(//input[@type='number'])[2]")
	public WebElement ratetextbox;
	@FindBy(xpath = "//button[text()='Create Invoice']")
	public WebElement createinvoicebutton;
	@FindBy(xpath = "//div[@class='ml-auto font-semibold']/descendant::p")
	public WebElement invoicenumber;
	@FindBy(xpath = "//button[text()='Receive Payment']")
	public WebElement receivepaymentbutton;
	@FindBy(xpath = "//label[text()='Payment Type *']/../../descendant::button[@aria-haspopup='listbox']")
	public WebElement paymenttypedropdown;
	@FindBy(xpath = "//ul[@role='listbox']/descendant::li")
	public List<WebElement> paymenttypelist;
	@FindBy(xpath = "//input[@placeholder='Search by check #, reference, or amount...']")
	public WebElement searchbyreferancefield;
	@FindBy(xpath = "(//h2[text()='Available Unapplied Checks']/../descendant::td[@class='px-3 py-2'])[3]")
	public WebElement referancenumberfromunappliedchecklist;
	@FindBy(xpath = "(//td[@class=\"px-3 py-2\"])[1]")
	public WebElement checkradiobutton;
	@FindBy(xpath = "//h4[text()='Outstanding Invoices']/../descendant::td")
	public WebElement outstandinginvoicelist;
	@FindBy(xpath = "//button[text()='Record Payment']")
	public WebElement recordpaymentbutton;
	@FindBy(xpath = "//div[text()='Payment recorded successfully!']")
	public WebElement paymentrecordedsuccessfullymessage;
	@FindBy(xpath = "//p[@class='w-1/5 text-gray-700']")
	public List<WebElement> paymenttransactiondetails;
	@FindBy(xpath = "//h6[text()='Unapplied Checks']")
	public WebElement unappliedcheckspage;

	
	
	
	
	
	
	
	
	public WebElement getUnappliedcheckspage() {
		return unappliedcheckspage;
	}
	public List<WebElement> getPaymenttransactiondetails() {
		return paymenttransactiondetails;
	}
	public WebElement getPaymentrecordedsuccessfullymessage() {
		return paymentrecordedsuccessfullymessage;
	}
	public WebElement getRecordpaymentbutton() {
		return recordpaymentbutton;
	}
	public WebElement getOutstandinginvoicelist() {
		return outstandinginvoicelist;
	}
	public WebElement getCheckradiobutton() {
		return checkradiobutton;
	}
	public WebElement getReferancenumberfromUnappliedchecklist() {
		return referancenumberfromunappliedchecklist;
	}
	public WebElement getSearchbyreferancefield() {
		return searchbyreferancefield;
	}
	public List<WebElement> getPaymenttypelist() {
		return paymenttypelist;
	}
	public WebElement getPaymenttypeDropdown() {
		return paymenttypedropdown;
	}
	public WebElement getReceivepaymentButton() {
		return receivepaymentbutton;
	}
	public WebElement getInvoicenumber() {
		return invoicenumber;
	}
	public WebElement getCreateinvoicebutton() {
		return createinvoicebutton;
	}
	public WebElement getRatetextbox() {
		return ratetextbox;
	}
	public List<WebElement> getSelectitemfromdropdownlist() {
		return selectitemfromdropdownlist;
	}
	public WebElement getSelectitemfromdropdown() {
		return selectitemfromdropdown;
	}
	public WebElement getAddbuttonfromadditempopupbutton() {
		return addbuttonfromadditempopupbutton;
	}
	public WebElement getAdditembutton() {
		return additembutton;
	}
	public WebElement getSearchsuggetion() {
		return searchsuggetion;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getCreateNewTransactionButton() {
		return createNewTransactionButton;
	}
	

}
