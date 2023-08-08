package com.digit.courseManagement.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.courseManagement.model.DBmodel;

@WebServlet("/Grade")
public class grade extends HttpServlet{
private PreparedStatement prep;
private ResultSet res;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	DBmodel db = new DBmodel();
	HttpSession session = req.getSession();
	try {
		prep = db.con.prepareStatement("select * from marks where std_id=?");
		prep.setInt(1, id);
		res = prep.executeQuery();
		if(res.next()) {
			resp.sendRedirect("/CourseManagementMVC/AlreadyGraded.html");
		}
		else {
			session.setAttribute("gid", id);
			resp.sendRedirect("/CourseManagementMVC/grading.html");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	
}
}
