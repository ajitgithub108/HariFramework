Feature: Home Page Scenarios

Background:
Given user has selected "chrome" browser
Then "https://admin:admin@the-internet.herokuapp.com/" is launched
Then verify page url is "https://admin:admin@the-internet.herokuapp.com/"

@homepage1
Scenario: to verify home page 
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
Then verify page url is "https://the-internet.herokuapp.com/"
And close browser

@smoke
Scenario: to verify link count  on home page 
Given user has selected "chrome" browser
Then "https://admin:admin@the-internet.herokuapp.com/" is launched
Then verify page url is "https://the-internet.herokuapp.com/"
And verify page title is "The Internet"
Then get link count on home page
And verify link count is 41
And close browser

@homepage_auth
Scenario: to verify all links are working
When user clicks on "Basic Auth"
Then verify page url is "https://the-internet.herokuapp.com/abtest"


@homepage99
Scenario: to verify all links are working
When user clicks on "A/B Testing"
Then verify page url is "https://the-internet.herokuapp.com/abtest"
Then nevigate back to home page 
And close browser

@homepage123
Scenario Outline: to verify all links are working
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "<linkName>"
Then verify page url is "<url>"
Then nevigate back to home page 
And close browser
Examples: 
|linkName   		| url 																								|
|A/B Testing  	| https://the-internet.herokuapp.com/abtest 					|
|Challenging DOM|https://the-internet.herokuapp.com/challenging_dom	|
|Dropdown				|https://the-internet.herokuapp.com/dropdown								|


@homepage_switch
Scenario: to verify multiple windows are working
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Multiple Windows"
Then verify page url is "https://the-internet.herokuapp.com/windows"
When user clicks on "Click Here"
And switch to another window 
Then verify page url is "https://the-internet.herokuapp.com/windows/new"
And switch to another window 
Then verify page url is "https://the-internet.herokuapp.com/windows"




