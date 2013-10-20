package com.klov.insert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.klov.readExcel.ReadExcel;
import com.klov.readTxt.ReadTxt;
import com.klov.util.ConnDatabase;

/**
 * <title>InsertData</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.insert</package>
 * 
 * <file>InsertData.java</file>
 * 
 * <date>2012-12-4</date>
 * 
 * <brief>向数据库中插入数据</brief>
 * 
 * @author klov
 * 
 */
public class InsertData {
	
	private volatile int a ;

	private final Logger LOG = Logger.getLogger(getClass().getName());

	/**
	 * 插入机场名
	 */
	@Test
	public void testInsertAir() {
		int b = ModifierTest.a ;
		insertAir();
	}

/**
 * 添加机场交通信息
 */
	@Test
	public void testInsertTraffic() {
		readAirportTraffic();

	}
	
	/**
	 * 添加机场电话
	 */
	@Test
	public void testInserAirPhone(){
		readAirportPhone() ;
	}

	private void insertAir() {

		String sql = "insert into airportcityinfo (cityname,airportname,airpotshorter,cityandairportname) values (?,?,?,?)";
		String excelUrl = "\\com\\klov\\resources\\机场三字码0109.xls";
//		String excelUrl = "\\com\\klov\\resources\\机场三字码1217.xls";
		ReadExcel read = new ReadExcel(excelUrl);
		String[] param = { "1", "Sheet2", "0", "1", "2" };
		try {

			Connection conn = ConnDatabase.conn();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			List<String[]> list = read.readExcel(param);
			int index = 1;
			for (String[] str : list) {

				pstmt.setString(1, str[0]);
				pstmt.setString(2, str[1]);
				pstmt.setString(3, str[2]);
				pstmt.setString(4, str[0]+"("+str[1]+")");

				pstmt.addBatch();

				Logger.getLogger(getClass().getName()).info(
						new StringBuffer().append("index = ").append(index++).append(
								" , cityname = ").append(str[0]).append(" , airportname = ")
								.append(str[1]).append(" , airpotshorter = ").append(str[2])
								.toString());

//				pstmt.executeBatch();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 读取机场交通数据
	 */
	public void readAirportTraffic() {

		String excelUrl = "\\com\\klov\\resources\\机场交通2012-12-17.xls";
		ReadExcel read = new ReadExcel(excelUrl);
		String[] param = { "1", "Sheet2", "0", "1", "2", "3", "4", "5", "6", "7" };
		List<String[]> list = null;
		try {
			list = read.readExcel(param);
			LOG.info("读取Excel完毕" + list.size());
			insertAirportTraffic2Db(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 查询机场电话
	 */
	public void readAirportPhone() {

		String excelUrl = "\\com\\klov\\resources\\机场电话2012-12-17.xls";
		ReadExcel read = new ReadExcel(excelUrl);
		String[] param = { "1", "Sheet1", "0", "1", "2"};
		List<String[]> list = null;
		try {
			list = read.readExcel(param);
			LOG.info("读取Excel完毕" + list.size());
			insertAirportPhone2Db(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 将机场交通数据插入数据库
	 * @param list
	 */
	public void insertAirportTraffic2Db(List<String[]> list) {

		String sql = "insert into airporttraffic (airportid,typename,linename,direction,stations,timeinterval,price,startstoptime,cityandairportname) values (?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		String airportId = "";
		String typename = "";
		try {
			conn = ConnDatabase.conn();
			pstmt = conn.prepareStatement(sql);
			int index = 0;

			for (String[] str : list) {
				index++;
				if (StringUtils.isEmpty(str[0])) {
					continue;
				}
				airportId = queryAirportIdByAirportName(str[0], conn);
				if (StringUtils.isEmpty(airportId)) {
					LOG.info("未找到对应的数据   "+index +" ,"+ str[0]);
					continue;
				}

				if ("大巴".equals(str[5])) {
					typename = "bus";
				} else if ("快轨".equals(str[5])) {
					typename = "fast_track";
				} else {
					LOG.info("未识别的交通类型" +index +" ,"+ str[0]);
					continue;
				}
				pstmt.setInt(1, Integer.parseInt(airportId));
				pstmt.setString(2, typename);
				pstmt.setString(3, str[1]);
				pstmt.setString(4, str[2]);
				pstmt.setString(5, str[3]);
				pstmt.setString(6, str[6]);
				pstmt.setString(7, str[7]);
				pstmt.setString(8, str[4]);
				pstmt.setString(9, str[0]);
               
				pstmt.addBatch();

//				LOG.info("batch添加一条数据 : " + str[0] + " , " + index);
			}

			pstmt.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 将机场电话插入数据库
	 * @param list
	 */
	public void insertAirportPhone2Db(List<String[]> list) {

		String sql = "insert into airportphone (airportid,phonetype,airportphone,cityandairportname) values (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		String airportId = "";
		String typename = "";
		try {
			conn = ConnDatabase.conn();
			pstmt = conn.prepareStatement(sql);
			int index = 0;

			for (String[] str : list) {
				index++;
				if (StringUtils.isEmpty(str[0])) {
					continue;
				}
				airportId = queryAirportIdByAirportName(str[0], conn);
				if (StringUtils.isEmpty(airportId)) {
					LOG.info("未找到对应的数据   " + str[0]);
					continue;
				}
				 
				pstmt.setInt(1, Integer.parseInt(airportId));
				pstmt.setString(2, str[1]);
				pstmt.setString(3, str[2]);
				pstmt.setString(4, str[0]);

				pstmt.addBatch();

//				LOG.info("batch添加一条数据 : " + str[0] + " , " + index);
				 
			}

//			pstmt.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据机场名字查询机场标志ID
	 * @param airportName
	 * @param conn
	 * @return
	 */
	public String queryAirportIdByAirportName(String airportName, Connection conn) {

		String sql = "select airportid from airportcityinfo where cityandairportname = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String airportId = "";
		try {
//			conn = ConnDatabase.conn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, airportName.trim());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				airportId = rs.getString("airportid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airportId;
	}

	/**
	 * 插入酒店城市
	 */
	public void testInsertHotel() {

		InsertData insert = new InsertData();
		insert.insert();
	}

	public void insert() {

		List<String[]> list = new ArrayList<String[]>();

		ReadTxt txt = new ReadTxt("\\com\\klov\\resources\\hotel_cities.txt", "UTF-8", ",", 3);
		try {
			list = txt.getContent(true, "");

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			int index = 1;
			String sql = "insert into hotelcity (name,pinyin,shorter) values (?,?,?)";
			Connection conn = ConnDatabase.conn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (String[] str : list) {
				pstmt.setString(1, str[0]);
				pstmt.setString(2, str[1]);
				pstmt.setString(3, str[2]);

				pstmt.addBatch();

				Logger.getLogger(getClass().getName()).info(
						new StringBuffer().append("index = ").append(index++).append(" , name = ")
								.append(str[0]).append(" , pinyin = ").append(str[1]).append(
										" , shorter = ").append(str[2]).toString());
			}

			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getNextException());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
