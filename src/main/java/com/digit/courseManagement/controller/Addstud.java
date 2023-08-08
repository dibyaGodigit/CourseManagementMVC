package com.digit.courseManagement.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.courseManagement.model.DBmodel;

@WebServlet("/Addstud")
public class Addstud extends HttpServlet{
private PreparedStatement prep;
private PreparedStatement prep1;
private ResultSet res;
private PreparedStatement prep2;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	DBmodel db = new DBmodel();
	try {
		prep1 = db.con.prepareStatement("select * from srequest where id=?");
		prep1.setInt(1, id);
		res = prep1.executeQuery();
		res.next();
		int ecid = res.getInt("cid");
	prep = db.con.prepareStatement("insert into enrolled values(?,?)");
	prep.setInt(1, id);
	prep.setInt(2, ecid);
	int x = prep.executeUpdate();
	if(x>0) {
		prep2 = db.con.prepareStatement("delete from srequest where id=?");
		prep2.setInt(1, id);
		prep2.executeUpdate();
		resp.sendRedirect("/CourseManagementMVC/StudentAdded.html");
	}else {
		resp.sendRedirect("/CourseManagementMVC/StudentAddingFailed.html");
	}
	
	}catch(Exception e) {
		resp.sendRedirect("/CourseManagementMVC/NoStudentAdded.html");
		e.printStackTrace();
		
	}
}
}
