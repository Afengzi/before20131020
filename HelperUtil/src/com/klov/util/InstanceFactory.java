package com.klov.util;


/**
 * <title>InstanceFactory</title>
 *
 * <project>HelperUtil</project>
 *
 * <package>com.klov.util</package>
 *
 * <file>InstanceFactory.java</file>
 *
 * <date>2013-3-1</date>
 *
 * <brief>实例工厂</brief>
 *
 * @author klov
 *
 */
public class InstanceFactory {

	/**
	 * 获取实例
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public static <T> T getInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
