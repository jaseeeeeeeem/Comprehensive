Feature: Tracking page functionality

Scenario: Tracking an invalid order

Given user is in the homepage
When user clicks on Track Order
And User enters the order id and Phone number and submits
Then Error message is displayed to the user