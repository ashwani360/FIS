package StepsDefinationsHelper;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.*;

import Locaters.CreateNew;
import Locaters.Home_Page;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class CreateNewPage_Helper extends CreateNew {
	public WebDriver driver;
	Wait<WebDriver> wait;
	public CreateNewPage_Helper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		wait = new FluentWait<WebDriver>(driver)       
				.withTimeout(600, TimeUnit.SECONDS)    
				.pollingEvery(15, TimeUnit.SECONDS)    
				.ignoring(NoSuchElementException.class); 
		
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickonnew() throws InterruptedException
	{  Thread.sleep(2000);
		New.click();
	}
	public void clickonServicereques() throws InterruptedException
	{Thread.sleep(2000);
		ServiceRequest.click();
	}
	public void VerifyPageheader()
	{
		driver.switchTo().frame("PegaGadget1Ifr");
		Assert.assertTrue("Create New Page Displayed", NewRequestform.isDisplayed());
	}
	
	public void SelectProduct(String arg1){
		Select s1=new Select(NameDropdown);
		s1.selectByVisibleText(arg1);
		
	}
	public void EnterIssue(String arg1){
		IssueInput.sendKeys(arg1);
	}
	public String ClickSave() throws InterruptedException{
		Save.click();
		Thread.sleep(3000);
		System.out.println("Ticket ID is"+TicketId.getText().toString().substring(1, TicketId.getText().toString().length()-2));
		return TicketId.getText().toString().substring(1, TicketId.getText().toString().length()-1);
		
	}
	public void VerifyProduct(String arg1){
		
		Assert.assertTrue("Name is updated", UpdatedName.getText().equals(arg1));
	}
	public void VerifyIssue(String arg2){
		Assert.assertTrue("Issues is updated", UpdatedIssue.getText().equals(arg2));
	}
	public void ClickSubmit() throws InterruptedException{
		Submit.click();
		Thread.sleep(3000);
	}
	public void VerifyNext() throws InterruptedException{
		Assert.assertTrue("Issues is updated", Nextstage.getText().equals("Collect customer details (Create)"));
		driver.switchTo().defaultContent();
		Profile.click();
		Logoff.click();
		Thread.sleep(3000);
	}
}
