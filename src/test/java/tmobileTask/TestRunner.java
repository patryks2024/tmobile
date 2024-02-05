package tmobileTask;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/Features", glue = { "" }, plugin = { "pretty",
		"json:target/JSONReports/report.json" })
public class TestRunner {

}