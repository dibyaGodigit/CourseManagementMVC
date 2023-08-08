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

@WebServlet("/checkProff")
public class checkProff extends HttpServlet{
private PreparedStatement prep;
private ResultSet res;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	DBmodel db = new DBmodel();
	try {
	prep = db.con.prepareStatement("select * from prequest");
	res = prep.executeQuery();
	if(!res.next()) {
		resp.sendRedirect("/CourseManagementMVC/NoProffAdded.html");
	}
	else {
resp.sendRedirect("/CourseManagementMVC/AddProfessor.jsp");
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
