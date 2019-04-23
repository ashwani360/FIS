package Locaters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class Home_Page {
	
    @FindBy(name="q")

    public WebElement searchinput;

    @FindBy(xpath="//ul[@role='listbox']//span")

    public WebElement Suggestionlist;    
}
