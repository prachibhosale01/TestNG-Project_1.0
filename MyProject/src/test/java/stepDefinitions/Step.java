package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.BaseClass;
import pageObjects.LeadPage;
import pageObjects.LoginPage;
import utils.ExcelReader;

import org.testng.ITestContext;



public class Step extends BaseClass
{

	public WebDriver driver;
	Logger log = LogManager.getLogger(BaseClass.class);
	

	@Before
	public void initializeBrowser() throws IOException 
	{
		
		configProp= new Properties();
		FileInputStream configPropFile=new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		String br=configProp.getProperty("browser");
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver=new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", configProp.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		else if (br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", configProp.getProperty("edgepath"));
			driver=new EdgeDriver();
		}
	}
		
		
	
	  @Given("user launch the browser")
		public void user_launch_the_browser() throws IOException 
		{
	
		  
			 loginPage= new LoginPage(driver);
			 accountPage=new AccountPage(driver);
			 leadPage=new LeadPage(driver);
			   
			   
		}
	
		@When("user open the URL {string}")
		public void user_open_the_url(String url) 
		{
			log.info("-----Opening the URL--------");
			driver.get(url);
			driver.manage().window().maximize();
			
			
		    }
	

		@And("user enters username as {string} and password as {string}")
		public void user_enters_username_as_and_password_as(String username, String password) 
		{
			log.info("----------Adding valis credentials---------");
			loginPage.setUsername(username);
			loginPage.setPassword(password);
		}

		@And("click on login")
		public void click_on_login()
		{
			log.info("-------------Login to the application------------------");
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
/*--------------------------------LeadCreation-------------------------------------------------	*/  
	              
	 
		
		
		@And("search for the {string} object")
		public void search_for_the_object(String string) throws InterruptedException {
		    leadPage.searchForLead();
		
		}

		@And("now user will select the \"Leads\"object from the list")
		public void now_user_will_select_the_leads_object_from_the_list() throws InterruptedException {
		    leadPage.selectForLead();
		}

		@Then("user will navigate to the leads page")
		public void user_will_navigate_to_the_leads_page() {
		    
		}

		@And("new window will open and select the radiobutton")
		public void new_window_will_open_and_select_the_radiobutton() {
		   
		}

		@And("user will click on {string} button")
		public void user_will_click_on_button(String string) throws InterruptedException {
		   leadPage.selectNext();
		}

		@Then("enter the value in firstname, lastname and email from the sheetname {string} and rownumber {int}")
		public void enter_the_value_in_firstname_lastname_and_email_from_the_sheetname_and_rownumber(String sheetName, Integer rowNumber)throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String,String>> testData = 
			reader.getData("C:\\Users\\pbhosa02\\My Files\\My Projects\\My Projects\\eclipse-workspace\\Practice Projects\\PracticeProject\\testData\\LoginDetails.xlsx", sheetName);
			
			String first = testData.get(rowNumber).get("firstname");
			String last = testData.get(rowNumber).get("lastname");
			String emaill = testData.get(rowNumber).get("email");
			
			
			leadPage.getLeadDetails(first, last, emaill);
			
			leadPage.clickOnSave();
			
		}

	  @AfterTest
	  public void tearDown()
	  {
		  driver.close();
	  }
	
}





