Feature:  Verify object records are created or not


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
And user should get the page title "p5| Account | Salesforce"



Scenario Outline: Lead data comes from the excel sheet

Given user launch the browser
When user open the URL "https://login.salesforce.com"
And user enters username as "prachi.bhosale@merkle.com.nippondev" and password as "Prachi@123"
And click on login
Then user is on home page and should display the "AppLauncher" 
And on the home user clicks on "AppLauncher"
And search for the "Leads" object
And now user will select the "Leads"object from the list
Then user will navigate to the leads page
When user clicks on "New" button
Then new window will open and select the radiobutton
And user will click on "Next" button
And enter the value in firstname, lastname and email from the sheetname "<SheetName>" and rownumber <RowNumber>
And click on "Save" button

Examples:
| SheetName | RowNumber |
| Leads | 0 |
| Leads | 1 |
| Leads | 3 |
| Leads | 4 |