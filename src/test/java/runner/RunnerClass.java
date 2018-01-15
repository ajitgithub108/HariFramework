package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
		@CucumberOptions(
		
				features = "src\\test\\java\\featureFiles",
				tags= "@homepage_auth",
				glue ="stepdef",
				monochrome = true,
				dryRun = false,
				plugin = {
						"pretty" ,"html:target" ,"json:target/cucumber.json","junit:target/cucumber.json",
						"junit:target/cucumber.xml"}
						
						
				
				
		) 
public class RunnerClass {

}
