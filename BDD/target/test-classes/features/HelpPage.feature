Feature: Help Page Functionality

Scenario: To validate the number of questions in Help page

Given user is in the homepage
When user clicks on Help and navigate to the page
Then The Help page should contain "10" questions

Scenario: To validate the number of topics in Help page

Given user is in the homepage
When user clicks on Help and navigate to the page
Then The Help page should contain "10" topics
 

