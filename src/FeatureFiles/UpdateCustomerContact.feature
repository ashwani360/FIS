Feature: User is able to update the Customer Details in a Ticket for which Open Assignment is Collect Customer Infomration

Background: User is Logged In
When User is on the login page
Then User Enters UserName and Password in the login form
And Click on the login button
Then User is on the Home Page

@53573 @Sanity @Regression @Smoke
Scenario Outline: User is opening an Service Request and update the Cutomer Details
When User is click on a "<Ticket>" with name Collect Customer infomration
Then Cutomer Detail form should be open
And User enter "<Name>" and "<Phone>" in the form
And Click On Save button
Then The Cutomer "<Name>" and "<Phone>" will save in Ticket
When User Click on the Submit button
Then Open Assignment updated as Triage

Examples:
| Ticket  | Name        | Phone       |
|         | Ashwani     | 8882216537  |








