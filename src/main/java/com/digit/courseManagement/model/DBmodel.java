package com.digit.courseManagement.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBmodel {

	public Connection con;

	public DBmodel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/crs";

			String user = "root";
			String pwd  = "2023";
			// Step:2
			con = DriverManager.getConnection(url, user, pwd);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
