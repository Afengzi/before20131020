package com.klov.util;

/**
 * <title>HelperException</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.util</package>
 * 
 * <file>HelperException.java</file>
 * 
 * <date>2012-12-6</date>
 * 
 * <brief>自定义异常</brief>
 * 
 * @author klov
 * 
 */
public class HelperException {

	private Throwable e;
	private String message;

	public HelperException(Throwable e, String message) {
		this.e = e;
		this.message = message;
	}

	public HelperException() {
	}

	/**
	 * @return the e
	 */
	public Throwable getE() {
		return e;
	}

	/**
	 * @param e the e to set
	 */
	public void setE(Throwable e) {
		this.e = e;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
