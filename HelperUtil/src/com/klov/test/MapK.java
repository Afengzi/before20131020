package com.klov.test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public  class MapK {
	
	static{
	     b = 3;
	}
	
	private static int b = 0 ;
	
	interface A {
		int a = 0 ;
	}
    static class Parent{
    	public static int a = 3 ;
    }
    
    static class sub extends Parent {
    	public static int a = 4;
    }
    static class cc extends sub{
    	public static int a = 5;
    }
	public static void main(String[] args){
		System.out.println(cc.a);
	}

	public Map<Integer, String> createMap() {

		Map<Integer, String> map = new HashMap<Integer, String>();
//		int a = Integer.MAX_VALUE;
		int a = 2<<20;
		int b = 2>>>3 ;
		for (int i = 0; i < a; i++) {
			map.put(i, i + "");
		}
       System.out.println("createEnd...");
		return map;

	}

	@Test
	public void test0() {
		long start0 = System.currentTimeMillis();
		Map<Integer, String> map = createMap();
		Set<Integer> set = map.keySet();
		Integer key = 0 ;
		for (Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
			 key = iter.next();
			System.out.println("key:" + key);
			System.out.println("val:" + map.get(key));
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - start0));
	}

	@Test
	public void test1() {
		long start0 = System.currentTimeMillis();
		Map<Integer, String> map = createMap();
		Set<Entry<Integer, String>> entry = map.entrySet();
		Entry<Integer, String> ent = null ;
		for (Iterator<Entry<Integer, String>> iter = entry.iterator(); iter.hasNext();) {
			ent = iter.next();
			System.out.println("key:"+ent.getKey());
			System.out.println("val:"+ent.getValue());
		}
		
		System.out.println("耗时:" + (System.currentTimeMillis() - start0));
	}
	@Test
	public void test3(){
		int a = 2;
		int b = 4 >>>3 ;
		int b1 =4>>3 ;
		System.out.println(b);
		System.out.println(b1);
		System.out.println("中国".toCharArray()[0]);
	}
}
