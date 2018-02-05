Feature: Catch Application monitor Page Scenarios

Background:
Given user has selected "chrome" browser
Then "https://cam:M0nitor@cam.broadnet.no/cam_status.php" is launched
Then verify page url is "https://cam:M0nitor@cam.broadnet.no/cam_status.php"


@cam_log_page
Scenario: to verify all links are working
When user clicks on "Oppfølgingsliste"
Then verify page url is "https://cam:M0nitor@cam.broadnet.no/cam_alerts.php"
Then get all error ancher links on cam_alerts page
