package Locaters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class CreateNew {
    @FindBy(xpath="//span[text()='New']/parent::*/preceding-sibling::*/span")

    public WebElement New;
    @FindBy(xpath="//span[text()='Service Request']")

    public WebElement ServiceRequest;
    @FindBy(xpath="//span[@class='workarea_header_id']")

    public WebElement TicketId;
  
    @FindBy(xpath="//span[text()='Create service request']")

    public WebElement NewRequestform;
    
    @FindBy(xpath="//label[text()='Name']/parent::*//select")

    public WebElement NameDropdown;
    @FindBy(xpath="//label[text()='Issue']/parent::*//input")

    public WebElement IssueInput;
    
    @FindBy(xpath="//i[@title='Portal User']/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*//button[text()='Save']")

    public WebElement Save;
    @FindBy(xpath="//i[@title='Portal User']/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*//button[text()='Submit']")

    public WebElement Submit;
    
    @FindBy(xpath="//h2[text()='Create service request']/parent::*/parent::*/parent::*//span/span[text()='Name']/parent::*/following-sibling::*/span")

    public WebElement UpdatedName;
  
    @FindBy(xpath="//h2[text()='Create service request']/parent::*/parent::*/parent::*//span/span[text()='Issue']/parent::*/following-sibling::*/span")

    public WebElement UpdatedIssue;
    @FindBy(xpath="//h2[text()='Open assignments']/parent::*/parent::*/following-sibling::*/div//a[1]")

    public WebElement Nextstage;
    @FindBy(xpath="//div[@class='layout layout-noheader layout-noheader-portal_header']/div/div/div[5]/div")

    public WebElement Profile;
    @FindBy(xpath="//span[text()='Log off']")

    public WebElement Logoff;
    

}
