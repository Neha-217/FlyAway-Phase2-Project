package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatepasswordshow")
public class UpdatePasswordShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String Pwd= request.getParameter("pass");
		//String airline=request.getParameter("pprice");
		int aid= Integer.parseInt(request.getParameter("aid"));
try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst= con.prepareStatement("update admin set Pwd=? where aid=?");
			pst.setString(1, Pwd);
			//pst.setString(2, airline);
			pst.setInt(2, aid);
			int x= pst.executeUpdate();
			if(x>0)
				response.sendRedirect("adminlist");
			else
				out.print("Error while changing password");
			
		
	}
catch(Exception e) {
	e.printStackTrace();
}
	}	
	
		
		
		
		
	}

	
	

