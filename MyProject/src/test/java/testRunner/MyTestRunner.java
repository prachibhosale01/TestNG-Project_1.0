package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features=".//src/test/resources/Features",
                glue={"stepDefinitions"}, 
                tags = "@runThis",
                dryRun=false,
               
                plugin= {"pretty","html:target/cucumber-reports/cucumber.html"}
)
                

public class MyTestRunner extends AbstractTestNGCucumberTests
{

	
}

