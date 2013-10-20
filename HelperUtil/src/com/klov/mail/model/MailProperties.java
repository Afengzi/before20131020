package com.klov.mail.model;

/**
 * <title>MailProperties</title>
 *
 * <project>HelperUtil</project>
 *
 * <package>com.klov.mail.model</package>
 *
 * <file>MailProperties.java</file>
 *
 * <date>2013-3-1</date>
 *
 * <brief>邮箱服务器属性</brief>
 *
 * @author klov
 *
 */
public class MailProperties {

	private String host;
	private String port ;
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	
}
