package com.epoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TestDao {
	
	public void insert() {
		Connection conn = JDBCUtil.getConn();
		
		Statement stmt = null;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into student values (?,?,?,?)";
		try {
			//获取预编译statement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ep2002");
			pstmt.setString(2, "张飞");
			
			pstmt.setDate(3, null);
			pstmt.setDouble(4, 99.9);
			//statement执行sql语句，注意preparedStatement不用传入sql参数
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void query() {
		Connection conn = JDBCUtil.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from student";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setBirthday(rs.getDate(3));
				student.setScore(rs.getDouble(4));
				System.out.println(student);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
