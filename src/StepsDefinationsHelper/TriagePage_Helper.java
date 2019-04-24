package StepsDefinationsHelper;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.*;

import Locaters.Home_Page;
import Locaters.Triage;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class TriagePage_Helper extends Triage {
	public WebDriver driver;
	Wait<WebDriver> wait;
	public TriagePage_Helper(WebDriver driver) {
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

	
	public void OpenTicketforTriage(String arg1) throws InterruptedException {
		driver.switchTo().frame("PegaGadget0Ifr");
		filterbyCaseid.click();
		Thread.sleep(5000);
		Filterdatainput.sendKeys(arg1);
		ApplyFilterbutton.click();
		Thread.sleep(5000);
		Ticketlink.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void VerifyTriagePage() throws InterruptedException{
		Thread.sleep(5000);
		driver.switchTo().frame("PegaGadget1Ifr");
		//Assert.assertTrue("Create New Page Displayed", Triagepage.isDisplayed());
	}
	public void SelectPriority(String arg2){
		Select s1=new Select(PriorityDropdown);
		s1.selectByVisibleText(arg2);
	}
	public void VeryPriority(String arg2){
		//Assert.assertTrue("Customer Email is updated", UpdatedPriority.getText().equals(arg2));
	}
	public void VerifyNextstage() throws InterruptedException{
		Assert.assertTrue("Issues is updated", Nextstage.getText().equals("Fix (Fix)"));
		driver.switchTo().defaultContent();
		Profile.click();
		Logoff.click();
		Thread.sleep(3000);
	}
	
}
