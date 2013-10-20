package com.klov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnDatabase {

	/**
	 * 获取连接
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection conn() throws SQLException, ClassNotFoundException {

		Logger.getLogger(ConnDatabase.class.getName()).info(Constant.DATABASE_DRIVER);
		Class.forName(Constant.DATABASE_DRIVER);
		Connection conn = DriverManager.getConnection(Constant.DATABASE_URL, Constant.DATABASE_USR,
				Constant.DATABASE_PWD);
		return conn;

	}
}
