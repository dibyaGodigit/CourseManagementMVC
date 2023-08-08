package com.digit.courseManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.courseManagement.model.CoursesModel;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CoursesModel c = new CoursesModel();
	HttpSession s = req.getSession(true);
	if(c.isEmpty()) {
		resp.sendRedirect("/CourseManagementMVC/AdminLogin.html");
	}
	else {
		resp.sendRedirect("/CourseManagementMVC/Home.html");
	}
}
}
