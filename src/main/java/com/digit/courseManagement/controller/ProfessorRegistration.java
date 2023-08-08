package com.digit.courseManagement.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.courseManagement.model.DBmodel;

@WebServlet("/ProfessorRegistration")
public class ProfessorRegistration extends HttpServlet{
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	String username = req.getParameter("name");
	int exp = Integer.parseInt(req.getParameter("exp"));
	String pass = req.getParameter("password");
	String cnf = req.getParameter("cnf");
	
	if(!pass.equals(cnf)) {
		System.out.println("Incorrect Password");
		resp.sendRedirect("/CourseManagementMVC/studentRegisterationFail.html");
	}
	
	try {
		
		DBmodel db = new DBmodel();
		prep = db.con.prepareStatement("insert into professor values(?,?,?)");
		prep.setInt(1, id);
		prep.setString(2, username);
		prep.setInt(3, exp);
		
		int x = prep.executeUpdate();
		if(x<0) {
			resp.sendRedirect("/CourseManagementMVC/ProfessorRegistrationFail.html");
		}
		
		prep = db.con.prepareStatement("insert into users values(?,?)");
		prep.setString(1, username);
		prep.setString(2, cnf);
		
		x = prep.executeUpdate();
		if(x>0) {
			resp.sendRedirect("/CourseManagementMVC/ProfessorRegisterationSuccess.html");
		}
		else {
			resp.sendRedirect("/CourseManagementMVC/ProfessorRegisterationFail.html");
		}
		
	}catch(Exception e) {
		resp.sendRedirect("/CourseManagementMVC/ProfessorRegisterationFail.html");
		
		e.printStackTrace();
	}
}
}
