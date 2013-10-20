package com.klov.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.BooleanUtils;

public class ClassLoadT {
	public static void main(String[] args) {
		
      ClassLoader myLoader = new ClassLoader() {
    	  @Override
    	public Class<?> loadClass(String name) throws ClassNotFoundException {
    		 
    		  String fileName = name.substring(name.lastIndexOf(".")+1)+".class" ;
    		  System.out.println("filenam : "+fileName);
    		  InputStream in = getClass().getResourceAsStream(fileName) ;
    		  if(null==in){
    			  System.out.println("in is null");
    			  return super.loadClass(name) ;
    		  }
    		try {
				byte[] b = new byte[in.available()] ;
				System.out.println(b.length); 
				in.read(b) ;
				return defineClass(fileName,b, 0, b.length) ;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null ;
    	}
	};
	System.out.println("======*********");
	Object obj = null ;
	Boolean.valueOf("");
	
	BooleanUtils.toBoolean("");
	try {
		obj = myLoader.loadClass("com.klov.test.Parent").newInstance() ;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(obj instanceof com.klov.test.Parent);
	}
}
