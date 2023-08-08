package com.digit.courseManagement.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.courseManagement.model.DBmodel;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet{
private PreparedStatement prep;
private ResultSet res;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	DBmodel db = new DBmodel();
	try {
	prep = db.con.prepareStatement("select * from srequest");
	res = prep.executeQuery();
	if(!res.next()) {
		resp.sendRedirect("/CourseManagementMVC/NoStudentAdded.html");
	}
	else {
resp.sendRedirect("/CourseManagementMVC/AddStudent.jsp");
	}
	}
	catch(Exception e) {
		resp.sendRedirect("/CourseManagementMVC/NoStudentAdded.html");
		e.printStackTrace();
	}
}
}
