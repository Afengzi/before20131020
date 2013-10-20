package com.klov.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class DynamicProxySellFisher implements InvocationHandler {

	private SellFisher sell ;
	
	public DynamicProxySellFisher(SellFisher sell) {
		this.sell = sell;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(getClass().getName()+"sell...");
		System.out.println(method.getModifiers()+" , "+method.getName()+" , "+method.getReturnType().getName());
		System.out.println(proxy.getClass().getName()+"invoke...");
		return method.invoke(sell, args) ;
	}

}
