package com.klov.util;

/**
 * <title>PreeminentCoder</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.util</package>
 * 
 * <file>PreeminentCoder.java</file>
 * 
 * <date>2012-12-14</date>
 * 
 * <brief>优秀代码段收集类</brief>
 * 
 * @author klov
 * 
 */
public class PreeminentCoder {
	/**
	 * 是否是奇数
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isOddNumber(int number) {

		return (number & 1) == 1;
	}

	/**
	 * 求除以2的square次方
	 * 
	 * @param number
	 * @param square
	 * @return //计算n*(2^m)
	 */
	public static int devidNumber(int number, int square) {

		return number >> square;
	}

	/**
	 * 乘以2的square次方
	 * 
	 * @param number
	 * @param square
	 * @return
	 */
	public static int multiplyNumber(int number, int square) {
		return number << square;
	}

	/**
	 * 叫唤两个数
	 */
	public static void swapNumber() {
		int a = 3;
		int b = 5;

		a ^= b;
		b ^= a;
		a ^= b;

		System.out.println(a);
		System.out.println(b);

	}

	/**
	 * 求最大值
	 * @param a
	 * @param b
	 * @return
	 */
	public static int max(int a, int b) {
		return b & ((a - b) >> 31) | a & (~(a - b) >> 31);
		/* 如果a>=b,(a-b)>>31为0，否则为-1 */
	}
}
