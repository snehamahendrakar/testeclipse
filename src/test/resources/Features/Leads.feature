Feature: Lead functionality

Background:
Given user navigate to url "http://localhost:100" on chrome
Then Login page should be appear

@smoke
Scenario: Create lead with mandatory fields
When user enters valid userid and password
And click on Login button
Then user should be landed on homepage
When user click on new lead link
Then create lead page will be opened
When user enters lastname and company name and click on save button
Then lead should be created successfully
And close the browser