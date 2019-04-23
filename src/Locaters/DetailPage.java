package Locaters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class DetailPage {
    @FindBy(xpath="//*[@id='g-mainbar']/div[1]/div/div/div/div/div/div[1]/h1")

    public WebElement DetailPageHeader;

    

}
