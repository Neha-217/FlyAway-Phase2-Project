package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String flight_number= request.getParameter("fnum");
		String airline=request.getParameter("pprice");
		int fid= Integer.parseInt(request.getParameter("fid"));
try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst= con.prepareStatement("update flightdetails set flight_number=? where fid=?");
			pst.setString(1, flight_number);
			//pst.setString(2, airline);
			pst.setInt(2, fid);
			int x= pst.executeUpdate();
			if(x>0)
				response.sendRedirect("list");
			else
				out.print("Error while inserting data");
			
		
	}
catch(Exception e) {
	e.printStackTrace();
}
	}	
	

}
