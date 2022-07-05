package com.flyaway.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showflight")
public class ShowFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text.html");
		PrintWriter out= response.getWriter();
		
		String source= request.getParameter("src_airport");
		String dest = request.getParameter("dest_airport");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst = con.prepareStatement("select * from flightdetails where src_airport=? and dest_airport=?");
			ResultSet rs = pst.executeQuery();
			
			out.println("<html><body><table><tr><td>src_airport</td><td>dest_airport</td></tr>");
		
			while (rs.next()){
			out.println("<tr><td>"+ rs.getString(1)+"</td><td>"+ rs.getString(2)+"</td>");
			}
			out.println("</table></body></html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
