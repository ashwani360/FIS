package Locaters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class CustomerInfo {
    @FindBy(xpath="//div[text()='Case']/parent::*/following-sibling::*/a")

    public WebElement filterbyCaseid;
    @FindBy(xpath="//div[text()='Name']/parent::*/following-sibling::*/a")

    public WebElement filterbyName;
    @FindBy(xpath="//a[text()='Clear Filter']/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/following-sibling::*/following-sibling::*/following-sibling::*//input")

    public WebElement Filterdatainput;
    @FindBy(xpath="//a[text()='Clear Filter']/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/following-sibling::*/following-sibling::li//button[text()='Apply']")

    public WebElement ApplyFilterbutton;
   
    @FindBy(xpath="//div[text()='Case']/parent::*/parent::*/parent::*/parent::*/following-sibling::*/td[3]//a")

    public WebElement Ticketlink;
    
    @FindBy(xpath="//div[text()='Case']/parent::*/parent::*/parent::*/parent::*/following-sibling::*/td[2]//a")

    public WebElement FilterTicketlinkName;
  
    @FindBy(xpath="//span[text()='Collect customer details']")

    public WebElement CustomerInformationPage;
    
    @FindBy(xpath="//label[text()='Name']/parent::*//input")

    public WebElement NameInput;
    @FindBy(xpath="//label[text()='Phone']/parent::*//input")

    public WebElement PhoneInput;
    @FindBy(xpath="//h2[text()='Collect customer details']/parent::*/parent::*/parent::*//span/span[text()='Name']/parent::*/following-sibling::*/span")

    public WebElement UpdatedName;
  
    @FindBy(xpath="//h2[text()='Collect customer details']/parent::*/parent::*/parent::*//span/span[text()='Phone']/parent::*/following-sibling::*/span")

    public WebElement UpdatedPhone;
    @FindBy(xpath="//h2[text()='Open assignments']/parent::*/parent::*/following-sibling::*/div//a[1]")

    public WebElement Nextstage;
    @FindBy(xpath="//div[@class='layout layout-noheader layout-noheader-portal_header']/div/div/div[5]/div")

    public WebElement Profile;
    @FindBy(xpath="//span[text()='Log off']")

    public WebElement Logoff;
}
