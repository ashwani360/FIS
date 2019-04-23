package StepsDefinationsHelper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.*;

import Locaters.Home_Page;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class HomePage_Helper extends Home_Page {
	public WebDriver driver;
	public HomePage_Helper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyTitle() {
		Assert.assertTrue("Title of the Page is correct", driver.getTitle().toString().equals("Google"));
	}
	public void EnterSearchData( String s) {
		searchinput.sendKeys(s);
		//Assert.assertTrue("Title of the Page is correct", driver.getTitle().toString().equals("Google"));
	}
	public void SelectSuggestions(String s) {
		Suggestionlist.click();
		//Assert.assertTrue("Title of the Page is correct", driver.getTitle().toString().equals("Google"));
	}
}
