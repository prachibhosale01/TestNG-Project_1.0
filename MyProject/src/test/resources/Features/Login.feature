Feature: Login Functionality

Scenario: Successful Login with valid cred

Given user launch the browser
When user open the URL "https://login.salesforce.com"
And user enters username as "prachi.bhosale@merkle.com.nippondev" and password as "Prachi@123"
And click on login
Then user is on home page and should display the "AppLauncher" 
And close the browser

@runThis
Scenario Outline: Login Data Driven

Given user launch the browser
When user open the URL "https://login.salesforce.com"
And user enters username as "<username>" and password as "<password>"
And click on login
Then user is on home page and should display the "AppLauncher"
And close the browser

Examples:
| username | password |
| prachi.bhosale@merkle.com.nippondev | Prachi@123|
| prachi.bhosale@merkle.com.nippondev | Prachi@1234|