package com.klov.test;

import java.util.Random;

public class StaticClass {
	
	public static int b = 22;
	public static final double a = new Random().nextInt();
	static {
		System.out.println("a ==" + a);
	}
}
interface bb{
 
}