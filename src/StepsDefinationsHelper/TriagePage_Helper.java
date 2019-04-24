package StepsDefinationsHelper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.*;

import Locaters.Home_Page;
import Locaters.Triage;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class TriagePage_Helper extends Triage {
	public WebDriver driver;
	public TriagePage_Helper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	

	
	public void OpenTicketforTriage(String arg1) throws InterruptedException {
		driver.switchTo().frame("PegaGadget0Ifr");
		filterbyCaseid.click();
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
	public void VerifyNextstage(){
		Assert.assertTrue("Issues is updated", Nextstage.getText().equals("Fix (Fix)"));
	}
	
}
