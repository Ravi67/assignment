package StepDefinationsRunnerandHooks;

import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.vimalselvam.cucumber.listener.Reporter;

import Helpers.BrowserConfig;
import Helpers.ConfigReader;
import Helpers.DriverHelper;
import Helpers.LoggerHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends DriverHelper {

	public static WebDriver driver;
	public static String text;
	public static String ScenarioName;
	public static int embeddedcount = 0;
	public static int browseropencount = 0;
	public static WebElement element;

	@Before
	public static void openBrowser() {
		LoggerHelper.log("Opening Application URL....");
		BrowserConfig.selectbrowser(ConfigReader.getValue("Browser"));
		try {
			LoggerHelper.log("Getting Application URL: " + ConfigReader.getValue("OpeningLoginURL"));
			driver.get(ConfigReader.getValue("OpeningLoginURL"));
			loaddom();
			LoggerHelper.log("Application URL Opened");
		} catch (Exception e) {
			LoggerHelper.log("Exception Catched in OpenBrowser Method: " + e.getMessage());
			browseropencount++;
			LoggerHelper.log("Value of Browser Count: " + browseropencount);
			if (browseropencount == 3) {
				LoggerHelper.log("Quit the Browser after 3 Retry Attempts");
				browseropencount = 0;
			} else {
				LoggerHelper.log("Calling openbrowser method again");
				openBrowser();
			}

		}
		text = driver.getCurrentUrl();
		LoggerHelper.log("Current URL coming is: " + text);
		Assert.assertEquals(ConfigReader.getValue("ValidatingLoginURL"), text);
		LoggerHelper.log("URL got matched");

	}

	@After
	public static void embedScreenshot(Scenario scenario) throws IOException, InterruptedException {
		LoggerHelper.log("Scenario Object coming is : " + scenario + "\n" + "Scenerio Status coming is: "
				+ scenario.getStatus());
		ScenarioName = scenario.getName();
		LoggerHelper.log("Name of Scenario: " + ScenarioName);
		String scenarionameaftertrim = ScenarioName.replace(" ", "");
		LoggerHelper.log("Scenario Name after trimming: " + scenarionameaftertrim);
		if (scenario.isFailed()) {
			LoggerHelper.log("Test Scenarios got Failed");
			try {
				scenario.write("Current Page URL fetched is " + driver.getCurrentUrl());
				String screenshotFilePath = System.getProperty("user.dir") + "\\ExecutionReports\\FailedScreenshots\\"
						+ scenarionameaftertrim + ".png";
				LoggerHelper.log("File path generated is: " + screenshotFilePath);
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				@SuppressWarnings("resource")
				FileOutputStream fileOuputStream = new FileOutputStream(screenshotFilePath);
				fileOuputStream.write(screenshot);
				scenario.embed(screenshot, "image/png");
				LoggerHelper.log("Value of Embedded Count Before Adding Screenshot: " + embeddedcount);
				
				embeddedcount++;
				LoggerHelper.log("Value of Embedded Count After Adding Screenshot: " + embeddedcount);
				LoggerHelper.log("Screenshot and Reporter Added successfully");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println("Inside Platform Support Screenshot Exception: "
						+ somePlatformsDontSupportScreenshots.getMessage());
			} finally {
				LoggerHelper.log("Going to Reset the default variables in Final Block");
				Settingdefaultvaluestovars();

			}
		} else {
			LoggerHelper.log("Going to Reset the default variables");
			Settingdefaultvaluestovars();
		}
		LoggerHelper.log("**********Test Scenarios END********************");
		LoggerHelper.log("Scenario End");

	}

	public static void Settingdefaultvaluestovars() {
		LoggerHelper.log("Inside Default value set variable method");
		LoggerHelper.log("Closing the Driver Session");
		
		
		driver.close();
		LoggerHelper.log("Session Closed");

	}

}
