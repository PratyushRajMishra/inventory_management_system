package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	Connection con;
	java.sql.Statement stmt;

	public Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			stmt = con.createStatement();


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

