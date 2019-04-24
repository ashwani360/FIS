package StepsDefinationsHelper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.*;

import Locaters.Home_Page;
import Locaters.Login;
import Utils.LocatorReader;
import Utils.ProeprtyReader;
import junit.framework.Assert;

public class LoginPage_Helper extends Login {
	public WebDriver driver;
	public LoginPage_Helper(WebDriver driver) {
		// this.driver = driver;
		this.driver=driver;
		System.out.println("In base Helperclase: "+driver.toString());
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyLoginpage() {
		Assert.assertTrue("Login Page Displayed", LoginPage.isDisplayed());
	}
	public void EnterUsername(String username){
		
		Username.sendKeys(username);
	}
	public void Password(String password){
		
		Password.sendKeys(password);
	}
	public void ClickLogin() {
		//searchinput.sendKeys(s);
		//Assert.assertTrue("Title of the Page is correct", driver.getTitle().toString().equals("Google"));
		Login.click();
	}
	public void VerifyHomepage() {
		//Suggestionlist.click();
		//driver.switchTo().frame("PegaGadget2Ifr");
		driver.switchTo().frame("PegaGadget0Ifr");
		Assert.assertTrue("Header of Homepage", HomapageHeading.getText().equals("Summary for"));
		driver.switchTo().defaultContent();
	}
}