package com.klov.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
	
		/**
		 * 是否是奇数
		 * @param number
		 * @return
		 */
		public static boolean isOddNumber(int number){
			
			return (number & 1)==1 ;
		}
	
	/**
	 * 是否是偶数
	 * @param number
	 * @return
	 */
	public static boolean isEvenNumber(int number){
		
		 return !isOddNumber(number) ;
	}

	/**
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
