package com.klov.mkdirs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <title>MakeDirs</title>
 *
 * <project>HelperUtil</project>
 *
 * <package>com.klov.mkdirs</package>
 *
 * <file>MakeDirs.java</file>
 *
 * <date>Mar 25, 2013</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public class MakeDirs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "F:\\klov\\app2\\test" ;
		mkdirs(path);
	}
	
	private  static boolean mkdirs(String path){
		
		File f = new File(path) ;
		if(!f.exists()){
			System.out.println(f.mkdirs());
		}
		try {
			FileOutputStream fos = new FileOutputStream(f+"\\sys.txt");
			fos.write("hello".getBytes()) ;
			fos.flush() ;
			fos.close() ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true ;
	}
	
	private static void test(String path){
		File f = new File(path) ;
		if(f.exists()){
			String[] s = f.list() ;
			System.out.println(s[0]);
		}
	}

}
