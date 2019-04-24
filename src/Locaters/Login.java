package Locaters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class Login {
	 @FindBy(xpath="//*[@id='login']")

	    public WebElement LoginPage;
    @FindBy(xpath="//*[@id='txtUserID']")

    public WebElement Username;
    @FindBy(xpath="//*[@id='txtPassword']")

    public WebElement Password;
    @FindBy(xpath="//*[@id='sub']")

    public WebElement Login;
    @FindBy(xpath="//h1[1]")

    public WebElement HomapageHeading;
    

}
