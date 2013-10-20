package com.klov.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.soap.SOAPHandler;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.log4j.Logger;

/**
 * <title>InterfaceInvoke</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.webservice</package>
 * 
 * <file>InterfaceInvoke.java</file>
 * 
 * <date>2013-1-4</date>
 * 
 * <brief>接口调用实现类</brief>
 * 
 * @author klov
 * 
 */
public class InterfaceInvoke {

	private static InterfaceInvoke invoke = new InterfaceInvoke();

	private InterfaceInvoke() {

	}

	public static InterfaceInvoke getInstance() {
		return invoke;
	}

	/**
	 * 调用第三方接口实现接口
	 * 
	 * @param addr
	 * @return
	 */
	public static String invoke(AddressInfo addr) {
		
		javax.xml.soap.SOAPHeader header = null ;
		 String action = addr.getNamespace()+addr.getFunction() ;
		 
		 
		
		SOAPHeaderElement soapHeaderElement;
		soapHeaderElement = new SOAPHeaderElement("soap", "Header");
		soapHeaderElement.setNamespaceURI(addr.getNamespace());
		try {
			SOAPElement parent_element = soapHeaderElement.addChildElement("MySoapHeader") ;
			parent_element.setPrefix("") ;
			parent_element.setAttribute("xmlns", "http://tempuri.org/") ;
			
			SOAPElement u_element = parent_element.addChildElement("UserName");
			u_element.setPrefix("") ;
			u_element.setValue("Gift_User@WS") ;
			SOAPElement p_element = parent_element.addChildElement("Password");
			p_element.setPrefix("") ;
			p_element.setValue("Gift_UserS@WS2012") ;
			
			
		} catch (SOAPException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String result = "1234";
		Service service = new Service();
		
		Call call = null;
		try {
			call = (Call) service.createCall();
			call.setUseSOAPAction(true) ;
			call.setSOAPActionURI(action);
			call.addHeader(soapHeaderElement);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		try {
			call.setTargetEndpointAddress(new URL(addr.getEndpoint()));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		call.setOperationName(new QName(addr.getNamespace(), addr.getFunction()));
		
		try {
			// 调用第三方接口
			result = (String) call.invoke((Object[]) addr.getRequest());
		} catch (RemoteException e) {
			Logger.getLogger("InterfaceInvoke").error(e);
		}
		return result;
	}

	public static String invoke2(AddressInfo addr) {

		
          return null ;
	}
}
