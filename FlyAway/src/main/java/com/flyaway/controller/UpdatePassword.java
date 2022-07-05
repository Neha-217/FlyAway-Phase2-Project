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


@WebServlet("/updatepassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		String aid= (request.getParameter("aid"));
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst= con.prepareStatement("select * from admin where aid=?");
			pst.setString(1, aid);
			
			ResultSet rs= pst.executeQuery();
			rs.next();
			out.print("<h1>Admin Password Update Page</h1>");
			out.print("<form action='updatepasswordshow' method='post'>");
			out.print("<input type='hidden' name='aid' value='"+rs.getString(1)+"'>");
			out.print("Pwd: <input type='password' name='pass' value='"+rs.getString(2)+"'><br><br>");
			out.print("<input type='submit' value='save'></form> ");
		
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
