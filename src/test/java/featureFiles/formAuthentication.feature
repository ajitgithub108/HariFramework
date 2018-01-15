Feature: Form Authentication 

@homepage1
Scenario: to verify home page 
Then verify page url is "https://the-internet.herokuapp.com/"
And close browser

@logincred
Scenario: to verify form authentication with correct credential
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Form Authentication"
Then verify page url is "https://the-internet.herokuapp.com/login"
And pass username as "tomsmith" and password as "SuperSecretPassword!" 
Then click on login button 
And verify message as "You logged into a secure area!"
Then click on Logout button 
And verify message as "You logged out of the secure area!"

@logincred2
Scenario: to verify form authentication with incorrect credential
Given user has selected "chrome" browser
Then "https://the-internet.herokuapp.com/" is launched
And verify page title is "The Internet"
When user clicks on "Form Authentication"
Then verify page url is "https://the-internet.herokuapp.com/login"
And pass username as "tomsmith" and password as "SuperSecretPassword1233!" 
Then click on login button 
And verify message as "Your password is invalid!"

