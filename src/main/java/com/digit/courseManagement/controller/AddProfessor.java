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
@WebServlet("/AddProfessor")
public class AddProfessor extends HttpServlet{
private PreparedStatement prep;
private ResultSet res;
private PreparedStatement prep1;
private PreparedStatement prep2;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	

	DBmodel db = new DBmodel();

	try {
		prep1 = db.con.prepareStatement("select * from prequest where id=?");
		prep1.setInt(1, id);
		res = prep1.executeQuery();
		res.next();
		int ecid = res.getInt("cid");
	prep = db.con.prepareStatement("insert into penrolled values(?,?)");
	prep.setInt(1, id);
	prep.setInt(2, ecid);
	int x = prep.executeUpdate();
	if(x>0) {
		prep2 = db.con.prepareStatement("delete from prequest where id=?");
		prep2.setInt(1, id);
		prep2.executeUpdate();
		resp.sendRedirect("/CourseManagementMVC/professorAdded.html");
	}else {
		resp.sendRedirect("/CourseManagementMVC/NoProfessorAdded.html");
	}
	
	}catch(Exception e) {
		resp.sendRedirect("/CourseManagementMVC/NoProfessorAdded.html");
		e.printStackTrace();
		
	}
	
	
}
}
