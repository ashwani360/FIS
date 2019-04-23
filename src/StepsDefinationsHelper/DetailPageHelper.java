package StepsDefinationsHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Locaters.DetailPage;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class DetailPageHelper extends DetailPage {
	public WebDriver driver;
	public DetailPageHelper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	public void verifyDetailPage() {
		
		Assert.assertTrue("Correct Page Opened",DetailPageHeader.getText().equals("AUTOMATION TESTING Tutorial: What is, Process, Benefits & Tools"));
	}
}
