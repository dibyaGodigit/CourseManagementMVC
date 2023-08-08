package com.digit.courseManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.courseManagement.model.UserLogin;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("id");
	String pass = req.getParameter("pin");
	
	UserLogin log = new UserLogin();
	log.setPassword(pass);
	log.setUser_name(name);
	if(log.login()) {
		resp.sendRedirect("/CourseManagementMVC/AdminService.html");
	}
	else {
		resp.sendRedirect("/CourseManagementMVC/LoginFail.html");
	}
}
}
