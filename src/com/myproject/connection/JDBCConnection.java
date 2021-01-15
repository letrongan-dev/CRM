package com.myproject.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=UTF-8","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
