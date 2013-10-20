package com.klov.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * <title>PrepareInitLog4j</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.util</package>
 * 
 * <file>PrepareInitLog4j.java</file>
 * 
 * <date>2013-2-26</date>
 * 
 * <brief></brief>
 * 
 * @author klov
 * 
 */
public class _InitLog4j {

	/**
	 * 初始化log4j
	 * 
	 * @param if(fileName==null)fileName = "log4j.properties";
	 */
	public static void initialLog4jProperties(String fileName) {
		if (fileName == null || fileName.isEmpty()) {
			fileName = "_log4j.properties";
		}

		PropertyConfigurator.configure(getProperties(fileName));
		Logger.getLogger("PrepareInitLog4j").info("log4j initial success...");
	}

	public static Properties getProperties(String fileName) {

		InputStream in = _InitLog4j.class.getResourceAsStream(fileName);

		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static void main(String[] args) {
		initialLog4jProperties(null);
	}
}
