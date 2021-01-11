package com.myproject.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=UTF-8","root","");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
