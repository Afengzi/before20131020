package com.klov.test;

public class DllClass {

	static boolean foo(char c){
		System.out.println(c);
		return true ;
	}
	
	public static void main(String[] args) {
		int i = 0 ;
		for(foo('A');foo('B')&i<2;foo('C')){
			i++;
			foo('D');
		}
		String b ="";
		
//		for(int i = 0 ; i<3 ;i++){
//			System.out.println(i);
//		}
	}
}

