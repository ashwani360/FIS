package StepsDefinationsHelper;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.*;

import Locaters.CustomerSatisfaction;
import Locaters.Home_Page;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class CustomerSatisfactionPage_Helper extends CustomerSatisfaction {
	public WebDriver driver;
	Wait<WebDriver> wait;
	ProeprtyReader pr=new ProeprtyReader("Config.properties");
	public CustomerSatisfactionPage_Helper(WebDriver driver) {
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
		Filterdatainput.sendKeys("Customer satisfaction");
		Thread.sleep(1000);
		ApplyFilterbutton.click();
		Thread.sleep(5000);
		Ticketlink.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void OpenTicketinresolve(String arg1,String Mod) throws InterruptedException {
		
		
		if(pr.getdata("Runmod").equals("Parallel"))
		{
		OpenTicketbyName();
		}
		else {
			driver.switchTo().frame("PegaGadget0Ifr");
			filterbyCaseid.click();
			Thread.sleep(1000);
			Filterdatainput.sendKeys(arg1);
			Thread.sleep(1000);
			ApplyFilterbutton.click();
			Thread.sleep(5000);
		 Ticketlink.click();
		}
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void VerifyCustomerSatisfactionPage() throws InterruptedException{
		Thread.sleep(5000);
		driver.switchTo().frame("PegaGadget1Ifr");
		//Assert.assertTrue("Create New Page Displayed", CustomerSatisfactionpage.isDisplayed());
	}
	public void SelectNPSscore(String  arg1){
		Select s1=new Select(NPSScoreDropdown);
		s1.selectByVisibleText(arg1);
	}
	public void VerifyNPSScore(String arg1){
		//Assert.assertTrue("Customer Email is updated", UpdatedNPSScore.getText().equals(arg1));
	}
	public void VerifyNextstage() throws InterruptedException{
		Assert.assertTrue("Issues is updated", Nextstage.getText().equals("Resolve (Resolve)"));
		driver.switchTo().defaultContent();
		Profile.click();
		Logoff.click();
		Thread.sleep(3000);
	}
}
