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


@WebServlet("/fetchinfo1")
public class FetchInfo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst= con.prepareStatement("select * from traveldetails");
			ResultSet rs= pst.executeQuery();
			
			out.print("<h1>Complete Travel Details Page...Confirm Before Payment</h1>");
			out.print("<table border=1 cellpadding=10 cellspacing=0>"
					+ "<tr><th>tid</th><th>fName</th><th>lName</th><th>email</th><th>phone</th><th>src_city</th>"
					+ "<th>dest_city</th><th>travle_date</th><th>num_of_passenger</th><th>price</th><th>flight_num</th><th>airline</th>"
					+ "<th colspan=2>Operation</th></tr>");
			while(rs.next())
			{
				out.print("<tr>");
				out.print("<td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getString(5)+"</td>");
				out.print("<td>"+rs.getString(6)+"</td>");
				out.print("<td>"+rs.getString(7)+"</td>");
				out.print("<td>"+rs.getString(8)+"</td>");
				out.print("<td>"+rs.getInt(9)+"</td>");
				out.print("<td>"+rs.getString(10)+"</td>");
				out.print("<td>"+rs.getInt(11)+"</td>");
				out.print("<td>"+rs.getString(12)+"</td>");
				//out.print("<td><a href='delete?id="+rs.getInt(1)+"'>Delete</a></td>");
				out.print("<td><a href='Checkout.jsp?id="+rs.getInt(1)+"'>Pay Now</a></td>");
				out.print("</tr>");
			}
			out.print("</table>");
		
		
	}
catch(Exception e) {
	e.printStackTrace();
}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
