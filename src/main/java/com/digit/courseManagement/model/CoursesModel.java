package com.digit.courseManagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CoursesModel {
	private int cid;
	private String cname;
	private int fees;
	private int dur_months;
	private DBmodel db = new DBmodel();
	private PreparedStatement prep;
	private ResultSet resultSet;
	
	
	public boolean addCourse() {
		try {
			prep = db.con.prepareStatement("insert into course values(?,?,?,?)");
			prep.setInt(1, getCid());
			prep.setString(2, getCname());
			prep.setInt(3, getFees());
			prep.setInt(4, getDur_months());
			
			int x = prep.executeUpdate();
			
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isEmpty() {
		try {
		prep = db.con.prepareStatement("select * from course");
		resultSet = prep.executeQuery();
		if(!resultSet.next()) {
			return true;
		}
		else {
			return false;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}
	/**
	 * @param fees the fees to set
	 */
	public void setFees(int fees) {
		this.fees = fees;
	}
	/**
	 * @return the dur_months
	 */
	public int getDur_months() {
		return dur_months;
	}
	/**
	 * @param dur_months the dur_months to set
	 */
	public void setDur_months(int dur_months) {
		this.dur_months = dur_months;
	}
	
	
}
