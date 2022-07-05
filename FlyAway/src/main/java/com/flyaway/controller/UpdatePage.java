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


@WebServlet("/updatepage")
public class UpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		String fid= (request.getParameter("fid"));
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst= con.prepareStatement("select * from flightdetails where fid=?");
			pst.setString(1, fid);
			
			ResultSet rs= pst.executeQuery();
			rs.next();
			
			out.print("<h1>Heloo Admin! Please Update the Flight Number..</h1>");
			out.print("<form action='update' method='post'>");
			out.print("<input type='hidden' name='fid' value='"+rs.getString(1)+"'>");
			out.print("flight_number: <input type='text' name='fnum' value='"+rs.getString(2)+"'><br><br>");
			//out.print("Airline: <input type='text' name='airname' value='"+rs.getString(3)+"'><br><br>");
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
