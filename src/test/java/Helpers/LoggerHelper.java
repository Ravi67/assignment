package Helpers;

import java.util.logging.*;


public class LoggerHelper {

	public static Logger log = Logger.getLogger(LoggerHelper.class.getName());

	public static void log(String s) {
		System.out.println(s);		
	}

}
