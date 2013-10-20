package com.klov.reversal;

/**
 * <title>StringUtil</title>
 *
 * <project>HelperUtil</project>
 *
 * <package>com.klov.reversal</package>
 *
 * <file>StringUtil.java</file>
 *
 * <date>2013-2-28</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public class StringUtil {

	/**
	 * 翻转字符串
	 * @param source
	 * @return
	 */
	public static char[] reversal(char[] source) {

		int length = source.length;
		char[] result = new char[length];

		for (int i = 0, j = length - 1; i < length; i++, j--) {

			if (j < 0) {
				break;
			}
			result[j] = source[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(reversal("abcdefg".toCharArray())) ;
	}
}
