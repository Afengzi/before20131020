package com.klov.util;

import java.util.ResourceBundle;

/**
 * <title>PropertiesFactory</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.util</package>
 * 
 * <file>PropertiesFactory.java</file>
 * 
 * <date>2013-3-1</date>
 * 
 * <brief>读取属性文件</brief>
 * 
 * @author klov
 * 
 */
public class PropertiesFactory {

	private ResourceBundle resource;

	private PropertiesFactory(String file) {
		resource = ResourceBundle.getBundle(file);
	}

	public static PropertiesFactory getInstance(String file) {
		return new PropertiesFactory(file);
	}

	public String get(String key) {
		return resource.getString(key);
	}

	public String[] getArray(String key) {
		return resource.getStringArray(key);
	}
}
