package com.klov.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.commons.lang.math.NumberUtils;


public class ClientMain {

	public static void main(String[] args) {
		
		SellFisher seller = new ConcreteSellFisher() ;
//		ProxySellFisher p = new ProxySellFisher(seller);
//		p.sell();
		
		InvocationHandler invoc = new DynamicProxySellFisher(seller);
		Object obj = Proxy.newProxyInstance(seller.getClass().getClassLoader(), seller.getClass().getInterfaces(), invoc) ;
		((SellFisher)obj).sell();
		System.out.println(obj.getClass().getName());
		System.out.println("***************************");
		System.out.println();
		System.out.println(Proxy.getProxyClass(seller.getClass().getClassLoader(), seller.getClass().getInterfaces()).getName());
	}
}
