Feature:  Verify object records are created or not

@runThis
Scenario: Verify account record creation

Given user launch the browser
When user open the URL "https://login.salesforce.com"
And user enters username as "prachi.bhosale@merkle.com.nippondev" and password as "Prachi@123"
And click on login
Then user is on home page and should display the "AppLauncher" 
And on the home user clicks on "AppLauncher"
And search for the "Accounts" 
And select the "Accounts"
Then user will navigate to the Accounts page
When user clicks on "New" button
Then New window will open and now select the radio button 
And click on "Next" button
And add the value in lastname as "p5"
And click on save button 
And user should get the page title "p5 | Account | Salesforce"
