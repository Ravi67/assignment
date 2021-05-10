package Helpers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;

import StepDefinationsRunnerandHooks.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfig {
	public static WebDriver selectbrowser(String myBrowser) {
		if (System.getProperty("os.name").contains("Window")) {
			if (myBrowser.equalsIgnoreCase(ConfigReader.getValue("Browser"))) {
				WebDriverManager.chromedriver().clearDriverCache();
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				/* options.addArguments("--headless"); */
				/* options.addArguments("--window-size=1920,1080"); */

				options.addArguments("--ignore-certificate-errors");
				System.setProperty("http.proxyHost", "127.0.0.1");
				System.setProperty("http.proxyPort", "8182");
				Hooks.driver = new ChromeDriver(options);
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator
						+ "externalFiles" + File.separator + "downloadFiles");
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("excludeSwitches", "enable-automation");
				options.setExperimentalOption("prefs", prefs);
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				options.addArguments("--ignore-certificate-errors");
				Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Hooks.driver.manage().deleteAllCookies();
				LoggerHelper.log("Going to execute Test Cases");
			}
		}
		return null;
	}

}