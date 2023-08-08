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

@WebServlet("/Apply")
public class ApplyForCourse extends HttpServlet{
private PreparedStatement prep;
private ResultSet res;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	DBmodel db = new DBmodel();
	try {
	
		HttpSession session = req.getSession();
		
		prep = db.con.prepareStatement("select * from applied where pid = ?");
		int pid = (int)session.getAttribute("pid");
		prep.setInt(1, pid);
		
		res = prep.executeQuery();
		if(res.next()) {
			resp.sendRedirect("/CourseManagementMVC/AlreadyAplied.html");
		}
		

		String pname = (String)session.getAttribute("pname");
		prep = db.con.prepareStatement("insert into prequest values(?,?,?)");
		prep.setString(1, pname);
		prep.setInt(2, pid);
		prep.setInt(3, id);
		
		int x = prep.executeUpdate();
		if(x>0) {
			resp.sendRedirect("/CourseManagementMVC/ApliedSuccessfully.html");
		}
		else {
			resp.sendRedirect("/CourseManagementMVC/AlreadyAplied.html");
		}
	
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
