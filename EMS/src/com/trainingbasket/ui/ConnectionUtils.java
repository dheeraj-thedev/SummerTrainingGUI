package com.trainingbasket.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	static Connection connection;
	private ConnectionUtils() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			new ConnectionUtils();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
		}
		return connection;
	}
}