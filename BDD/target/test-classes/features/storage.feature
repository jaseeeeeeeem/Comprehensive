Feature: Storage page functionality

Scenario: Validating the number of types of storage

Given user is in the homepage
When user clicks on storage and navigate to the page
Then The storage page should contains 10 types of storage

Scenario: Validate that TV Units 

Given user is in the homepage
When user clicks on storage and navigate to the page
Then The storage should contain "TV Units" as the first type 



