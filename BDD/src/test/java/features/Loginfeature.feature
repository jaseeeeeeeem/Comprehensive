Feature: Login functionality

Scenario: Invalid Credential Login Validation

Given user is in the homepage
When user moves to the login icon and clicks login
And user enters "some123@gmail.com" as email and "someone123" as password
And user clicks on login button
Then error message should be displayed