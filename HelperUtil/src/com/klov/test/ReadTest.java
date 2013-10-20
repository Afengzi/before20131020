package com.klov.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.klov.readExcel.ReadExcel;
import com.klov.readTxt.ReadTxt;
import com.klov.util.CalculateAgeFromDate;
import com.klov.util.PreeminentCoder;

public class ReadTest {

	@Test
	public void testReadExcel() {
		String excelUrl = "\\com\\klov\\resources\\最新机场三字码1206_parse.xls";
		ReadExcel read = new ReadExcel(excelUrl);
		String[] param = { "1", "Sheet1", "0", "1", "2" };
		try {
			List<String[]> list = read.readExcel(param);
			for(String[] str : list){
				for(int i = 0 ; i<param.length-2 ; i++){
					System.out.println(str[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public  void testReadTxt() {
		ReadTxt txt = new ReadTxt("\\com\\hotel_cities.txt", "UTF-8", ",", 3);
		try {
			List<String[]> list = txt.getContent(true, "");
			for (String[] strs : list) {
				for (int i = 0; i < strs.length; i++) {
					System.out.println(strs[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testReadAirportHelp() {
		String excelUrl = "\\com\\klov\\resources\\2012-12-10机场帮助_模版1.xls";
		ReadExcel read = new ReadExcel(excelUrl);
		String[] param = { "1", "sheet2", "0", "1", "2","3","4","5","6","7" };
		try {
			List<String[]> list = read.readExcel(param);
			for(String[] str : list){
				for(int i = 0 ; i<param.length-2 ; i++){
					System.out.print(str[i]+" , ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testIsOddNumber(){
		
		System.out.println(PreeminentCoder.max(3,5)) ;
		ClassLoader.getSystemClassLoader();
	}
	
	@Test
	public void testIsEvenNumber(){
		
		System.out.println(~-1) ;
	}
	
	@Test
	public void testGetAge(){
		
		CalculateAgeFromDate calculate = new CalculateAgeFromDate() ;
		int age = calculate.getAgeByBirthday("1988-11-22") ;
		System.out.println(age);
		
	}
	
}
