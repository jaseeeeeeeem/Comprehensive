Feature: Store page functionality

Scenario: To validate the number of stores present in the page.

Given user is in the homepage
When user clicks on stores and navigate to the page
Then The Stores page should contain 10 stores displayed