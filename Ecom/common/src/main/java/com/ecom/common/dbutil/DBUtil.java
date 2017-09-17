package com.ecom.common.dbutil;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtil {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:8889/EcommDB";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);
			
		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = (Connection) DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			if(dbConnection!=null) {
				System.out.println("connection suc=cessful");
			}
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
	
	public static void main(String[] args) {
		System.out.println(getDBConnection());
	}

}
