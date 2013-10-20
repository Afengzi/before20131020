package com.klov.readTxt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * <title>ReadTxt</title>
 * 
 * <project>Helper</project>
 * 
 * <package>com.util</package>
 * 
 * <file>ReadTxt.java</file>
 * 
 * <date>2012-12-4</date>
 * 
 * <brief>读取文本文件帮助类</brief>
 * 
 * @author klov
 * 
 */
public class ReadTxt {

	// 文件存放路径
	private String txtUrl = "";
	// 以字符编码格式读取文件
	private String characterEncoder;
	// 分隔符
	private String splitChar;
	// 分割后的数组长度
	private int length;

	private List<String[]> list = new ArrayList<String[]>();

	public ReadTxt() {
		super();
	}

	public ReadTxt(String txtUrl, String characterEncoder, String splitChar, int lenght) {
		this.txtUrl = txtUrl;
		this.characterEncoder = characterEncoder;
		this.splitChar = splitChar;
		this.length = lenght;
	}

	/**
	 * 读取文件
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public BufferedReader readTxt() throws FileNotFoundException, UnsupportedEncodingException {

		InputStream in = this.getClass().getClassLoader().getResourceAsStream(txtUrl) ;
		return new BufferedReader(new InputStreamReader(in, characterEncoder));
	}

	/**
	 * 格式化文件 split后的长度不够时是否丢弃
	 * 
	 * @param isDiscard true：丢弃，false 补充
	 * @param supplement 补充物
	 * @return
	 * @throws IOException
	 */
	public List<String[]> getContent(Boolean isDiscard, String supplement) throws IOException {

		String line = "";
		BufferedReader br = readTxt();
		while ((line = br.readLine()) != null) {
			String[] str = resovle(line);
			if (null != str) {

				if (isDiscard) {
					if (str.length == this.length) {
						list.add(str);
					}
				} else {
					if (str.length < this.length) {
						list.add(fullStringArrays(str, supplement));
					} else {
						list.add(str);
					}
				}

			}

		}
		return list;

	}

	/**
	 * 填补数组
	 * 
	 * @param str
	 * @param supplement
	 * @return
	 */
	public String[] fullStringArrays(String[] str, String supplement) {

		String[] str2 = new String[this.length];

		str2 = Arrays.copyOf(str, str.length);
		for (int i = str.length; i < this.length; i++) {
			str2[i] = supplement;
		}
		return str2;
	}

	/**
	 * 解析字符串
	 * 
	 * @param line
	 * @return
	 */
	public String[] resovle(String line) {

		if (StringUtils.isEmpty(line)) {
			return null;
		}
		String[] str = line.split(splitChar);
		// if (str.length < this.length) {
		// return null;
		// }
		return str;
	}

	/**
	 * @return the txtUrl
	 */
	public String getTxtUrl() {
		return txtUrl;
	}

	/**
	 * @param txtUrl the txtUrl to set
	 */
	public void setTxtUrl(String txtUrl) {
		this.txtUrl = txtUrl;
	}

	/**
	 * @return the characterEncoder
	 */
	public String getCharacterEncoder() {
		return characterEncoder;
	}

	/**
	 * @param characterEncoder the characterEncoder to set
	 */
	public void setCharacterEncoder(String characterEncoder) {
		this.characterEncoder = characterEncoder;
	}

	/**
	 * @return the splitChar
	 */
	public String getSplitChar() {
		return splitChar;
	}

	/**
	 * @param splitChar the splitChar to set
	 */
	public void setSplitChar(String splitChar) {
		this.splitChar = splitChar;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

}
