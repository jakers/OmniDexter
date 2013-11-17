package com.omnidex.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OmniDex {

	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/omnidex";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "omnidexter";
	private static Connection conn;
	private static OmniDex instance;

	public static Connection getConnection() {
		if (instance == null) {
			instance = new OmniDex();
		}
		return conn;
	}

	private OmniDex() {
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to locate " + DRIVER_CLASS + " driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to establish connection to "+DB_URL);
			e.printStackTrace();
		} 
	}
}
