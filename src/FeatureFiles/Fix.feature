Feature: User is able to update the Ticket with the Fix Description
Description: The purpose of this feature is to test Resolve Form


Background: User is Logged In
When User is on the login page
Then User Enters UserName and Password in the login form
And Click on the login button
Then User is on the Home Page

@53572 @Sanity @Regression @Smoke
Scenario Outline: User is opening an Service Request and update the Fix Details
When User is click on a "<Ticket>" with name Fix
Then Fix Form should be open
And User enter "<Description>" of the fix
And Click On Save button
Then The Fix "<Description>" will save in Ticket
When User Click on the Submit button
Then Open Assignment updated as Customer satisfaction (Resolved)

Examples:
| Ticket | Description                |
| SR-87   | Test Fix Descrition       |






