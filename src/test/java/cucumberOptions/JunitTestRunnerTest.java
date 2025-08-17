package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue ="stepDefinitions"
,monochrome=true ,tags = "@information or @Cart or @test  or @Home "  ,  plugin = {
        "pretty",
        "html:target/cucumber.html",   // basic HTML report
        "json:target/cucumber.json",   // JSON report
        "junit:target/cucumber.xml",   // JUnit XML report
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Extent Report
        "rerun:target/failed_scenarios.txt" // record failed scenarios
})
public class    JunitTestRunnerTest {

	
	
}
