package StepDefinationsRunnerandHooks;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "./src/test/resources/FeatureFiles" }, plugin = { "pretty",
		"html:target/cucumber-html-report", "json:target/cucumber.json",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/report.html" },
		tags = { "@Droppable,"+"@Selectable,"+"Controlgroup"})

public class TestSuiteRunner extends AbstractTestNGCucumberTests {
	}

