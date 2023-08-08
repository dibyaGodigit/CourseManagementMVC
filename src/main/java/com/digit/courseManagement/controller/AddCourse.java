package com.digit.courseManagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.courseManagement.model.CoursesModel;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CoursesModel c = new CoursesModel();
	c.setCid(Integer.parseInt(req.getParameter("cid")));
	c.setCname(req.getParameter("cname"));
	c.setFees(Integer.parseInt(req.getParameter("fees")));
	c.setDur_months(Integer.parseInt(req.getParameter("duration")));
	System.out.println(Integer.parseInt(req.getParameter("cid")));
	boolean res = c.addCourse();
	HttpSession session = req.getSession();
	if(res) {
		session.setAttribute("cid",c.getCid());
		resp.sendRedirect("/CourseManagementMVC/AddCourseSuccess.html");
	}
	else {
		resp.sendRedirect("/CourseManagementMVC/AddCourseFail.html");
	}
}
}
