package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.LoginPage;

public class Step 
{

	public WebDriver driver;
	public LoginPage loginPage;
	AccountPage accountPage = new AccountPage(driver);
	
	
	@Given("user launch the browser")
	public void user_launch_the_browser() 
	{
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		   driver=new ChromeDriver();
		   loginPage=new LoginPage(driver);
		   accountPage=new AccountPage(driver);
	}

	@When("user open the URL {string}")
	public void user_open_the_url(String url) 
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	


	@And("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) 
	{
		loginPage.setUsername(username);
		loginPage.setPassword(password);
	}

	@And("click on login")
	public void click_on_login()
	{
		loginPage.clickLogin();
	}

	@Then("user is on home page and should display the {string}")
	public void user_is_on_home_page_and_should_display_the(String string) 
	{
		 Assert.assertTrue(loginPage.isAppLauncherDisplayed(), "App Launcher is not displayed");
	}

	@And("close the browser")
	public void close_the_browser()
	{
		 loginPage.closeBrowser();
	}
//-----------------------------------AccountCreation--------------------------------------------------
	

	@Then("on the home user clicks on {string}")
	public void on_the_home_user_clicks_on(String string) throws InterruptedException 
	{
	   accountPage.clickOnApplauncher();
	}

	@Then("search for the {string}")
	public void search_for_the(String string) throws InterruptedException 
	{
	    accountPage.searchForAccount();
	}

	@Then("select the {string}")
	public void select_the(String string) throws InterruptedException 
	{
	   accountPage.selectForAccount();
	}

	@Then("user will navigate to the Accounts page")
	public void user_will_navigate_to_the_accounts_page() 
	{
	    
	}

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String string) throws InterruptedException 
	{
		accountPage.selectNewButton();
	}

	@Then("New window will open and now select the radio button")
	public void new_window_will_open_and_now_select_the_radio_button() throws InterruptedException 
	{
		accountPage.next();
	}

	@Then("click on {string} button")
	public void click_on_button(String string) 
	{
	   
	}

	@Then("add the value in lastname as {string}")
	public void add_the_value_in_lastname_as(String string) 
	{
		accountPage.setLastName();
	}

	@Then("click on save button")
	public void click_on_save_button() 
	{
		accountPage.clickOnSave();
	}

	@And("user should get the page title {string}")
    public void user_should_get_the_page_title(String expectedTitle) throws InterruptedException {
		Thread.sleep(2000); // Adding a Thread.sleep for demonstration. Preferably use WebDriverWait.
        String actualTitle = accountPage.getPageTitle();
        assertEquals(actualTitle, expectedTitle, "Page title does not match!");
    }
}





