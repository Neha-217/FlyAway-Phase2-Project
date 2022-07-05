package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminlist")
public class AdminList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst= con.prepareStatement("select * from admin");
			ResultSet rs= pst.executeQuery();
			out.print("<h2>Welcome Admin..!!</h2>"
					+ "<h3>Press 'Update Password' to Change your Password!</h3>");
			out.print("<table border=1 cellpadding=10 cellspacing=0>"
					+ "<tr><th>aid</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Pwd</th>"
					+ "<th colspan=2>Operation</th></tr>");
			while(rs.next())
			{
				out.print("<tr>");
				out.print("<td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getString(5)+"</td>");
				/*out.print("<td>"+rs.getString(6)+"</td>");
				out.print("<td>"+rs.getString(7)+"</td>");
				out.print("<td><a href='delete?id="+rs.getInt(1)+"'>Delete</a></td>");*/
				out.print("<td><a href='updatepassword?aid="+rs.getInt(1)+"'>Update Password</a></td>");
				out.print("</tr>");
			}
			out.print("</table>");
		
	}
catch(Exception e) {
	e.printStackTrace();
}
		
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
