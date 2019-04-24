package StepsDefinationsHelper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.*;

import Locaters.CustomerInfo;
import Locaters.Home_Page;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Wait;
public class CustomerInfoPage_Helper extends CustomerInfo {
	public WebDriver driver;
	Wait<WebDriver> wait;
	public CustomerInfoPage_Helper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		wait = new FluentWait<WebDriver>(driver)       
				.withTimeout(600, TimeUnit.SECONDS)    
				.pollingEvery(15, TimeUnit.SECONDS)    
				.ignoring(NoSuchElementException.class); 
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
	public void VerifyNextstage() throws InterruptedException{
		Assert.assertTrue("Issues is updated", Nextstage.getText().equals("Triage (Triage)"));
		driver.switchTo().defaultContent();
		Profile.click();
		Logoff.click();
		Thread.sleep(3000);
	}
}

