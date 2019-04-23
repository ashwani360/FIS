Feature: Google Search

@Sanity @Regression @smoke
Scenario Outline: Search a Keyword on Google
Given I am on the Homepage of Google
When I enter the "<testdata>" in input box
When I select the "<suggestionlist>" from the suggestion list
Then Search will displayed the "<linktext>"

Examples:
 | testdata | suggestionlist   | linktext                                                          |
 | Testing1  | testing bdd      | What's the difference between Unit Testing, TDD and BDD …         |
 | Selenium1 | selenium with ie | How can I start InternetExplorerDriver using Selenium WebDriver … |
 | TesNg1    | testng           | TestNG - Welcome                                                  |
 | Test1    | testing bdd      | What's the difference between Unit Testing, TDD and BDD …         |

#@Regression
#Scenario: Open A result Page
#Given I am on the Homepage of Google
#When I enter the "Automation Testing" in input box
#When I select the "Automation Testing" from the suggestion list
#Then Search will displayed the "AUTOMATION TESTING Tutorial: What is, Process, Benefits & Tools"
#When I Click on the "AUTOMATION TESTING Tutorial: What is, Process, Benefits & Tools"
#Then Detail Page will open
