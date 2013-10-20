package com.klov.tcp_ip.base;

/**
 * <title>Serviceable</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.tcp_ip</package>
 * 
 * <file>Serviceable.java</file>
 * 
 * <date>2013-2-28</date>
 * 
 * <brief></brief>
 * 
 * @author klov
 * 
 */
public abstract class Serviceable {

	/**
	 * 初始化
	 * 
	 * @return
	 */
	public abstract boolean init();

	/**
	 * 开启服务
	 * 
	 * @return
	 */
	public abstract boolean start();

	/**
	 * 终止服务
	 * 
	 * @return
	 */
	public abstract boolean stop();

}
