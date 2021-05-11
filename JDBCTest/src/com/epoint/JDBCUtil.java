package com.epoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 注册驱动，获取Connection对象
 * @author hp
 *
 */
public class JDBCUtil {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String user = "epoint";
	static String password = "Gepoint";
	public static Connection getConn() {
		Connection conn = null;
		try {
			//注册驱动
			Class.forName(driver);
			//获取Connection对象
			conn = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
