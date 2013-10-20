package com.klov.convert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class ConvertStringFomart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String url = "com\\klov\\resources\\北京-海口.json" ;
//        String url = "com\\klov\\resources\\海口-北京.json" ;
        Map m = new Hashtable<String,String>() ;
        readTxt(url) ;
//        System.out.println(System.getProperty("file.encoding"));
	}
	
	public  static void readTxt(String url){
		
		InputStream in = ConvertStringFomart.class.getClassLoader().getResourceAsStream(url) ;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(in,System.getProperty("file.encoding")));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String line = "" ;
		StringBuilder result = new StringBuilder() ;
		try {
			while((line = br.readLine())!= null){
				if(StringUtils.isBlank(line)){
					line="" ;
				}
				if("//s+".equals(line)){
					line="";
				}
				if("//n//r".equals(line)){
					line="";
				}
				result.append(line) ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(result.toString());
	}
}
