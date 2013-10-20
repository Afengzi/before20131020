package com.klov.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <title>ReadSysProp</title>
 *
 * <project>HelperUtil</project>
 *
 * <package>com.klov.util</package>
 *
 * <file>ReadSysProp.java</file>
 *
 * <date>2012-12-5</date>
 *
 * <brief>读取属性值</brief>
 *
 * @author klov
 *
 */
public class ReadSysProp {

	private static Properties prop;
	private static InputStream in;
	static {
		in = ReadSysProp.class.getResourceAsStream("config.properties");
		prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			if (in != null) {
				in = null;
			}
		}
	}
	
	/**
	 * 读取属性
	 * @param key
	 * @return
	 */
	public static String getObject(String key){
		
		return (String) prop.get(key) ;
	}
}
