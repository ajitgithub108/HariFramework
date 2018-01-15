Feature: Check dynamic operation on page

@dynamic_select
Scenario: to verify dynamic operation on page
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Dynamic Controls"
Then verify page url is "https://the-internet.herokuapp.com/dynamic_controls"
Then click on "Remove" button
And verify message  "It's gone!"
Then click on "Add" button
And verify message  "It's back!"
And close browser