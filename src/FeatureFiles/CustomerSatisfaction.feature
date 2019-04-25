Feature: User is able to update Customer Satisfaction form
Description: The purpose of this feature is to test Customer Satisfaction Form


Background: User is Logged In
When User is on the login page
Then User Enters UserName and Password in the login form
And Click on the login button
Then User is on the Home Page

@53678 @Sanity @Regression @Smoke
Scenario Outline:User is opening an Service Request and update the Customer Satisfaction
When User is click on a "<Ticket>" with name Resolve
Then Customer Satisfaction Form should be open
And User enter "<Description>" details
And Click On Save button
Then The Cutomer Satisfaction "<Description>" will save in Ticket
When User Click on the Submit button
Then Thank you message will get displayed

Examples:
| Ticket | Description |
|        | 10          |







