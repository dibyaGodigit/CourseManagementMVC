<%@page import="java.sql.ResultSet"%>
<%@page import="com.digit.courseManagement.model.DBmodel"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark Sheet</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7;
    color: #333;
  }
  .container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  h1 {
    text-align: center;
    margin-bottom: 20px;
  }
  table {
    width: 100%;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: center;
  }
  th {
    background-color: #f2f2f2;
  }
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  h2 {
    text-align: center;
    margin-top: 20px;
  }
</style>
<body>
<%
DBmodel db = new DBmodel();
session = request.getSession();
int sid =(int)session.getAttribute("sid");
try{
PreparedStatement prep = db.con.prepareStatement("select * from marks where std_id=?");
prep.setInt(1,	sid);
ResultSet set = prep.executeQuery();
if(set.next()){
	int Total = set.getInt(2)+set.getInt(3)+set.getInt(4)+set.getInt(5);
	out.println("<div class=\"container\">\r\n"
			+ "    <h1>Student Mark Sheet</h1>\r\n"
			+ "    <table>\r\n"
			+ "      <tr>\r\n"
			+ "        <th>Category</th>\r\n"
			+ "        <th>Score</th>\r\n"
			+ "      </tr>\r\n"
			+ "      <tr>\r\n"
			+ "        <td>Assignment</td>\r\n"
			+ "        <td>"+set.getInt(2)+"</td>\r\n"
			+ "      </tr>\r\n"
			+ "      <tr>\r\n"
			+ "        <td>Quiz</td>\r\n"
			+ "        <td>"+set.getInt(3)+"</td>\r\n"
			+ "      </tr>\r\n"
			+ "      <tr>\r\n"
			+ "        <td>Project</td>\r\n"
			+ "        <td>"+set.getInt(4)+"</td>\r\n"
			+ "      </tr>\r\n"
			+ "      <tr>\r\n"
			+ "        <td>Final Exam</td>\r\n"
			+ "        <td>"+set.getInt(5)+"</td>\r\n"
			+ "      </tr>\r\n"
			+ "      <tr>\r\n"
			+ "        <td>Total</td>\r\n"
			+ "        <td>"+Total+"</td>\r\n"
			+ "      </tr>\r\n"
			+ "    </table>\r\n"
			+ "    <h2>Grade:"+ set.getString(6)+"</h2>\r\n"
			+" <h1><a href=\"StudentService.html\">ReDirect</a></h1>"
			+ "  </div>");
	
}
else{
	out.println("<div class=\"container\">\r\n"
			+"<h1>You Are Not Graded Yet</h1>");
	out.println("<a href=\"StudentService.html\"> Redirect</a>");
out.print("  </div>");

}
}catch(Exception e)
{
	e.printStackTrace();
}
%>

</body>
</html>