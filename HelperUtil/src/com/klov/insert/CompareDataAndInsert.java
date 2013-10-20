package com.klov.insert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.klov.readExcel.ReadExcel;
import com.klov.util.ConnDatabase;

/**
 * <title>CompareDataAndInsert</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.insert</package>
 * 
 * <file>CompareDataAndInsert.java</file>
 * 
 * <date>2013-1-16</date>
 * 
 * <brief>比较数据并插入差异的</brief>
 * 
 * @author klov
 * 
 */
public class CompareDataAndInsert {
	
	public static void main(String[] args) {
		CompareDataAndInsert in = new CompareDataAndInsert() ;
		in.compareData() ;
	}
	
	public boolean compareData(){
		
//		String excelUrl = "\\com\\klov\\resources\\机场三字码0109abc.xls";
		String excelUrl = "\\com\\klov\\resources\\机场三字码0109def.xls";
		List<String[]> excelList = getAirportFromExcel(excelUrl) ;
		System.out.println(excelList.size());
		Map<String,String[]> map = new HashMap<String,String[]>() ;
		for(int i = 0 ; i<excelList.size() ;i++){
			String[] str = excelList.get(i) ;
			map.put(str[2],str) ;
		}
	System.out.println(map.size());
//		String sql = "insert into airportcityinfo (cityname,airportname,airpotshorter,cityandairportname) values (?,?,?,?)";
//		Connection conn;
//		try {
//			conn = ConnDatabase.conn();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			int index = 1;
//			for(Iterator iter = map.keySet().iterator();iter.hasNext();){
//				String key = (String) iter.next() ;
//				String[] s = map.get(key) ;
//				pstmt.setString(1, s[0]);
//				pstmt.setString(2, s[1]);
//				pstmt.setString(3, s[2]);
//				pstmt.setString(4, s[0]+"("+s[1]+")");
//				
//				pstmt.addBatch() ;
//				
//				Logger.getLogger(getClass().getName()).info(
//						new StringBuffer().append("index = ").append(index++).append(
//								" , cityname = ").append(s[0]).append(" , airportname = ")
//								.append(s[1]).append(" , airpotshorter = ").append(s[2])
//								.toString());
//			}
//			pstmt.executeBatch() ;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		
		return true ;
	}
   /**
    * 读取EXCEL数据
    * @param fileName
    * @return
    */
	public List<String[]> getAirportFromExcel(String fileName) {
		
		
		ReadExcel read = new ReadExcel(fileName);
		String[] param = { "1", "Sheet2", "0", "1", "2" };

		try {
			return read.readExcel(param);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null ;
	}

	/**
	 * 读取DB数据
	 * 
	 * @return
	 */
	public List<String[]> getAirpotFromDB() {
		String[] air = new String[3];
		List<String[]> airList = new ArrayList<String[]>();
        
		String sql = "select airportname,cityname,airpotshorter,cityandairportname from airportcityinfo";
		Connection conn;
		try {
			conn = ConnDatabase.conn();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				air[0] = rs.getString("airportname");
				air[1] = rs.getString("cityname");
				air[2] = rs.getString("airpotshorter");

				
				airList.add(air);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return airList;

	}
}
