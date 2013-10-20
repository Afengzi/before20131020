package com.klov.webservice;

/**
 * <title>AddressInfo</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.webservice</package>
 * 
 * <file>AddressInfo.java</file>
 * 
 * <date>2013-1-4</date>
 * 
 * <brief>WebService 调用接口地址信息</brief>
 * 
 * @author klov
 * 
 */
public class AddressInfo {

	/* 命名空间 */
	private String namespace;
	/* 接收方地址 */
	private String target;
	/* 接口地址 */
	private String endpoint;
	/* 请求接口名 */
	private String function;
	/* 请求内容 */
	private String[] request;

	/**
	 * @return the request
	 */
	public String[] getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(String[] request) {
		this.request = request;
	}

	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 接口地址
	 * http://localhost:8080/WSServer/services/WSServer?wsdl
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * @param endpoint the endpoint to set
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	/**
	 * @return the function
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * @param function the function to set
	 */
	public void setFunction(String function) {
		this.function = function;
	}

}
