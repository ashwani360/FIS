package StepsDefinationsHelper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.*;

import Locaters.CustomerInfo;
import Locaters.Home_Page;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class CustomerInfoPage_Helper extends CustomerInfo {
	public WebDriver driver;
	public CustomerInfoPage_Helper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	public void OpenTicketbyName() throws InterruptedException{
		driver.switchTo().frame("PegaGadget0Ifr");
		filterbyName.click();
		Thread.sleep(1000);
		Filterdatainput.sendKeys("Collect customer details");
		Thread.sleep(1000);
		ApplyFilterbutton.click();
		Thread.sleep(5000);
		Ticketlink.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	
	public void OpenTicket(String arg1) throws InterruptedException{
		driver.switchTo().frame("PegaGadget0Ifr");
		filterbyCaseid.click();
		Thread.sleep(1000);
		Filterdatainput.sendKeys(arg1);
		Thread.sleep(1000);
		ApplyFilterbutton.click();
		Thread.sleep(5000);
		Ticketlink.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void VerifyCustomerinfopage() throws InterruptedException{
		Thread.sleep(5000);
		driver.switchTo().frame("PegaGadget1Ifr");
		Assert.assertTrue("Create New Page Displayed", CustomerInformationPage.isDisplayed());
	}
	public void EnterName(String arg1){
		NameInput.sendKeys(arg1);
	}
	public void EnterPhone(String arg2){
		PhoneInput.sendKeys(arg2);
	}
	public void VerifyName(String arg1){
		Assert.assertTrue("Customer Name is updated", UpdatedName.getText().equals(arg1));
	}
	public void VerifyPhone(String arg2){
		Assert.assertTrue("Customer Email is updated", UpdatedPhone.getText().equals(arg2));
	}
	public void VerifyNextstage(){
		Assert.assertTrue("Issues is updated", Nextstage.getText().equals("Triage (Triage)"));
	}
}

