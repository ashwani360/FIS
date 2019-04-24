Feature: User is able to Triage a ticket
Description: The purpose of this feature is to test Triage Form

Background: User is Logged In
When User is on the login page
Then User Enters UserName and Password in the login form
And Click on the login button
Then User is on the Home Page

@53572 @Sanity @Regression @Smoke
Scenario Outline: User is opening an Service Request and update the Cutomer Details
When User is click on a "<Ticket>" with name Triage
Then Triage Form should be open
And User enter "<Priority>" of the Ticket
And Click On Save button
Then The Triage "<Priority>" will save in Ticket
When User Click on the Submit button
Then Open Assignment updated as Fix

Examples:
| Ticket | Priority  |
| SR-87   | High     |



