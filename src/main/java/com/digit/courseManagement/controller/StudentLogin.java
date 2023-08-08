package com.digit.courseManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.courseManagement.model.UserLogin;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String pass = req.getParameter("password");
	int id = Integer.parseInt(req.getParameter("id"));
	HttpSession session = req.getSession();
	UserLogin log = new UserLogin();
	log.setPassword(pass);
	log.setUser_name(name);
	if(log.login()) {
		session.setAttribute("sid", id);
		session.setAttribute("sname", name);
		resp.sendRedirect("/CourseManagementMVC/StudentService.html");
	}
	else {
		resp.sendRedirect("/CourseManagementMVC/LoginFail.html");
	}
}
}
