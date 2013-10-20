package com.klov.webservice;

import org.junit.Test;

/**
 * <title>WSClient</title>
 *
 * <project>HelperUtil</project>
 *
 * <package>com.klov.webservice</package>
 *
 * <file>WSClient.java</file>
 *
 * <date>2013-1-4</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public class WSClient {

	@Test
	public void testWindsor(){
		AddressInfo info = new AddressInfo() ;
		info.setNamespace("http://tempuri.org/");
		info.setFunction("GetCardPoint") ;
		info.setEndpoint("http://220.165.247.70:83/WsGift.asmx?wsdl") ;
//		info.setEndpoint("http://220.165.247.70:83/WsGift.asmx?WSDL") ;
		String[] request = {"1900201","193777"};
		info.setRequest(request) ;
//		info.setTarget("WSServer") ;
		
		InterfaceInvoke invoke = InterfaceInvoke.getInstance() ;
		String result = invoke.invoke(info) ;
		System.out.println(result);
	}
	@SuppressWarnings("static-access")
	@Test
	public void testWeather(){
		AddressInfo info = new AddressInfo() ;
		info.setNamespace("http://tempuri.org/");
		info.setFunction("getSupportProvince") ;
		info.setEndpoint("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl") ;
//		String[] request = {"1900201"};
//		info.setRequest(request) ;
//		info.setTarget("WSServer") ;
		
		InterfaceInvoke invoke = InterfaceInvoke.getInstance() ;
		String result = invoke.invoke(info) ;
		System.out.println(result);
	}
	
	@Test
	public void testLocalWS(){
		AddressInfo info = new AddressInfo() ;
		info.setNamespace("www.funguide.com");
		info.setFunction("serverFun") ;
		info.setEndpoint("http://localhost:8080/WSServer/services/WSServer?wsdl") ;
		String[] request = {"klov"};
		info.setRequest(request) ;
//		info.setTarget("WSServer") ;
		
		InterfaceInvoke invoke = InterfaceInvoke.getInstance() ;
		String result = invoke.invoke(info) ;
		System.out.println(result);
	}
}
