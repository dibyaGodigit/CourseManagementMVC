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

@WebServlet("/Enroll")
public class Enroll extends HttpServlet{
private PreparedStatement prep;
private ResultSet res;
private PreparedStatement prep1;
private ResultSet res1;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	DBmodel db = new DBmodel();
	try {
	
		HttpSession session = req.getSession();
		
		prep = db.con.prepareStatement("select * from enrolled where sid = ?");
		int sid = (int)session.getAttribute("sid");
		prep.setInt(1, sid);
		
		res = prep.executeQuery();
		if(res.next()) {
			resp.sendRedirect("/CourseManagementMVC/AlreadyEnrolled.html");
		}
		

		String sname = (String)session.getAttribute("sname");
		prep = db.con.prepareStatement("insert into srequest values(?,?,?)");
		prep.setString(1, sname);
		prep.setInt(2, sid);
		prep.setInt(3, id);
		
		int x = prep.executeUpdate();
		if(x>0) {
			resp.sendRedirect("/CourseManagementMVC/EnrolledSuccessfully.html");
		}
		else {
			resp.sendRedirect("/CourseManagementMVC/AlreadyEnrolled.html");
		}
	
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
