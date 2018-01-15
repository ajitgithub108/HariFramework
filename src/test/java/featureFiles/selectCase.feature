Feature: Check select Scenarios


@homepage_checkbox
Scenario: to verify click on check box 
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Checkboxes"
Then verify page url is "https://the-internet.herokuapp.com/checkboxes"
And check checkbox "checkbox 1"
And close browser


@homepage_dropdown
Scenario: to verify dropbox functionality 
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Dropdown"
Then verify page url is "https://the-internet.herokuapp.com/dropdown"
And select option "option1"
And close browser