
package Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties loadPropertyFile(String filePath) {
		File file = new File(filePath);
		Properties prop = new Properties();
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			LoggerHelper.log("Exception in Properties: " + e);
		}
		return prop;

	}

	public static String getValue(String key) {

		Properties prop = loadPropertyFile("src\\test\\resources\\ConfigFile\\config.properties");
		return prop.getProperty(key);
	}

	public static long getIntValue(String key) {
		Properties prop = loadPropertyFile("src\\test\\resources\\ConfigFile\\config.properties");
		String strKey = prop.getProperty(key);

		return Long.parseLong(strKey);
	}

	public static String[] getArray(String key) {
		Properties prop = loadPropertyFile("src\\test\\resources\\ConfigFile\\config.properties");
		String[] x = prop.getProperty(key).split(",");
		for (@SuppressWarnings("unused")
		String string : x) {
		}
		return x;
	}

}
