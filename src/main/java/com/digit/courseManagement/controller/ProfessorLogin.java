package com.digit.courseManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.courseManagement.model.UserLogin;

@WebServlet("/ProfessorLogin")
public class ProfessorLogin extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("username");
	int id = Integer.parseInt(req.getParameter("id"));
	HttpSession session = req.getSession();
	
	String pass = req.getParameter("pin");
	
	UserLogin log = new UserLogin();
	log.setPassword(pass);
	log.setUser_name(name);
	if(log.login()) {
		session.setAttribute("pname", name);
		session.setAttribute("pid", id);
		resp.sendRedirect("/CourseManagementMVC/ProfessorService.html");
	}
	else {
		resp.sendRedirect("/CourseManagementMVC/LoginFail.html");
	}
}
}
