package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountPage 
{

public WebDriver driver;

	
	public AccountPage(WebDriver driver) 
	{
      this.driver = driver;
      PageFactory.initElements(this.driver, this);
     
    }
	
	By appLauncher = By.xpath("//button[@title='App Launcher']");
	By searchAccount = By.xpath("//input[@type='search' and @role='combobox']");
	By selectAccount= By.xpath("//a[@id='Account']//b[contains(text(),'Accounts')]");
	By newAccount = By.xpath("//button[@name='New']");
	By accountRecordType = By.xpath("//span[text()='Accounts']");
	By nextButton = By.xpath("//span[text()='Next']");
	By lastName = By.xpath("//input[@class='slds-input' and @name='Name']");
	By saveButton = By.xpath("//button[text()='Save']");
	By successMessage = By.xpath("//span[text()='Success']");
	

		
	public void clickOnApplauncher() throws InterruptedException
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(appLauncher).click();
		
		
    }
	
	public void searchForAccount() throws InterruptedException 
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(searchAccount).sendKeys("Accounts");
		
		
    }
	
	
	public void selectForAccount() throws InterruptedException 
    {
		
		driver.findElement(selectAccount).click();
		Thread.sleep(2000);
		    
     }
	public void accountRecordPage()
	{
		
	}
	
	public void selectNewButton() throws InterruptedException
	{
		driver.findElement(newAccount).click();
		Thread.sleep(2000);
	}
	public void recordType()
	{
		
	}
	public void next() throws InterruptedException
	{Thread.sleep(2000);
		driver.findElement(nextButton).click();
		
		
	}  
	
	public void setLastName()
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(lastName).sendKeys("p5");
    }

	
	public void clickOnSave()
	{
		driver.findElement(saveButton).click();
	} 
	
	public String getPageTitle() {
        return driver.getTitle();
    }
}
