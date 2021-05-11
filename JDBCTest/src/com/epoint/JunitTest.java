package com.epoint;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class JunitTest {

	@Test
	public void test() {
		
		Connection connection = JDBCUtil.getConn();
		System.out.println(connection);
	}
	
	@Test
	public void test2() {
		TestDao tDao = new TestDao();
		tDao.insert();
		tDao.query();
	}

}
