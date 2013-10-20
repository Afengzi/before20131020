package com.klov.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamReadText {

	private static void read(){
		String url = "D:/xhli/copy.txt" ;
		String dst = "D:/xhli/copy/copy3.txt" ;
		
		try {
			File f = new File(url) ;
			FileInputStream fis = new FileInputStream(f) ;
			FileOutputStream fos = new FileOutputStream(dst) ;
			byte[] b = new byte[1024] ;
			int i = 0 ;
			while((i=fis.read(b))!=-1){
				fos.write(b,0,i) ;
			}
			fos.flush();
			fos.close() ;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		read() ;
	}
}
