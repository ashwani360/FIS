package Locaters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class SearchResultPage {
    @FindBy(xpath="//*[@id='rso']/div[1]/div/div[1]/div/div/div[1]/a/h3")
    public WebElement Resultlink;

    
}
