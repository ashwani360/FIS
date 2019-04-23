package StepsDefinationsHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Locaters.SearchResultPage;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class SearchResultPageHelper extends SearchResultPage {
	public WebDriver driver;
	public SearchResultPageHelper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLink(String s) {
		
		Assert.assertTrue("Name to the result is correct", Resultlink.getText().equals(s));
	}
public void ClickonLink(String s) {
	Resultlink.click();
	
		//Assert.assertTrue("Name to the result is correct", Resultlink.getText().equals(s));
	}
}
