Feature: Check form checkbox 

@select_checkbox
Scenario: to verify form checkbox 
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Checkboxes"
Then verify page url is "https://the-internet.herokuapp.com/checkboxes"
And "check" on checkbox "1"
And "check" on checkbox "2"
And "uncheck" on checkbox "1"
And "uncheck" on checkbox "2"