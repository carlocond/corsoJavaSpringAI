package com.azienda.jdbcEsercizio2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/esercizio_2?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
