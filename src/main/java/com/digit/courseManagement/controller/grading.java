package com.digit.courseManagement.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.courseManagement.model.DBmodel;

@WebServlet("/grading")
public class grading extends HttpServlet{
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int assign = Integer.parseInt(req.getParameter("assign"));
	int quizz = Integer.parseInt(req.getParameter("quizz"));
	int project = Integer.parseInt(req.getParameter("project"));
	int finall = Integer.parseInt(req.getParameter("final"));
	String grade="";
	if(finall>=95) {
		grade="O";
	}else if(finall>=85) {
		grade="E";
	}
	else if(finall>=75) {
		grade="A";
	}
	else if(finall>=65) {
		grade="B";
	}
	else if(finall>=55) {
		grade="C";
	}
	else if(finall>=45) {
		grade="D";
	}
	else {
		grade="F";
	}
	
	HttpSession session = req.getSession();
	int sid = (int)session.getAttribute("gid");
	DBmodel db = new DBmodel();
	try {
		prep = db.con.prepareStatement("insert into marks values(?,?,?,?,?,?)");
		prep.setInt(1, sid);
		prep.setInt(2, assign);
		prep.setInt(3, quizz);
		prep.setInt(4, project);
		prep.setInt(5, finall);
		prep.setString(6,grade);
		
		int x = prep.executeUpdate();
		if(x>0) {
			resp.sendRedirect("/CourseManagementMVC/GradingSuccessfull.html");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
