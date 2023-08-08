package com.digit.courseManagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin {
private String user_name;
private String password;
private Connection con;
private PreparedStatement prep;
private ResultSet res;
private DBmodel db = new DBmodel();


public boolean login() {
	
	try {
		prep = db.con.prepareStatement("select * from users where user_name=? and password=?");
		prep.setString(1, user_name);
		prep.setString(2, password);
		res = prep.executeQuery();
		if(res.next()) {
			
			return true;
		}
		else {
			
			return false;
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
		prep.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	return false;
}

/**
 * @param user_name the user_name to set
 */
public void setUser_name(String user_name) {
	this.user_name = user_name;
}




/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

}
