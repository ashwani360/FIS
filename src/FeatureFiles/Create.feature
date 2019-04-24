Feature: User is able to Create New Service Request
Description: The purpose of this feature is to test Create New Form

Background: User is Logged In
When User is on the login page
Then User Enters UserName and Password in the login form
And Click on the login button
Then User is on the Home Page

@53572 @Sanity @Regression @Smoke
Scenario Outline: User is able to Create a New Services Request
When User is Click on the New button
Then Create New should get displayed
And User Select "<ProductName>" and Enter "<Issues>" in the Form
And Click On Save button
Then The "<ProductName>" and "<Issues>" Case Information will get save
When User Click on the Submit button
Then Open Assignment updated as Collect Cutomer Detail

Examples:
| ProductName | Issues           |
| Roku 3      | Test Automation  |