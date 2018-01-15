Feature: Check form dropdown 

@select_dropdown
Scenario: to verify form authentication with correct credential
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Dropdown"
Then verify page url is "https://the-internet.herokuapp.com/dropdown"
Then select "1" by "index" from dropdown 
Then select "Option 2" by "visibleText" from dropdown
Then select "1" by "value" from dropdown
And close browser