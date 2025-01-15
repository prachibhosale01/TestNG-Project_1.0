package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class BaseClass
{
	   protected WebDriver driver; 
	    protected LoginPage loginPage;
	    protected AccountPage accountPage;
	    protected Properties configProp;
	    protected LeadPage leadPage;
	    public Logger log;
	    }
	



	



		
		
		
		



