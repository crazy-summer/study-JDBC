package com.epoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ע����������ȡConnection����
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
			//ע������
			Class.forName(driver);
			//��ȡConnection����
			conn = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
