package StepsDefinationsHelper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.*;

import Locaters.Fix;
import Locaters.Home_Page;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class FixPage_Helper extends Fix {
	public WebDriver driver;
	public FixPage_Helper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void OpenTicketinfix(String arg1) throws InterruptedException {
		driver.switchTo().frame("PegaGadget0Ifr");
		filterbyCaseid.click();
		Thread.sleep(5000);
		Filterdatainput.sendKeys(arg1);
		Thread.sleep(5000);
		ApplyFilterbutton.click();
		Thread.sleep(5000);
		Ticketlink.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	public void VerifyFixPage() throws InterruptedException{
		Thread.sleep(5000);
		driver.switchTo().frame("PegaGadget1Ifr");
		//Assert.assertTrue("Create New Page Displayed", Fixpage.isDisplayed());
	}
	public void EnterFixDescription(String  arg1){
		FixDescription.sendKeys(arg1);
	}
	public void VerifyFixDescription(String arg1){
		//Assert.assertTrue("Customer Email is updated", UpdatedFixDescription.getText().equals(arg1));
	}
	public void VerifyNextstage(){
		Assert.assertTrue("Issues is updated", Nextstage.getText().equals("Customer satisfaction (Resolved)"));
	}
}

