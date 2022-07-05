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

@WebServlet("/fetchinfo")
public class FetchInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		String Src = request.getParameter("src");
		String Dest = request.getParameter("dest");
		
		out.println("<h2>Please Check all the information..</h2>");
		
		out.print("<table border='1'><tr><th>Source</th>"
				+ "<th>Destination</th><th>Dates</th><th>No. of Passengers</th></tr>");
		
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement st = con.prepareStatement("select * from bookinginfo where src_airport=? and dest_airport=?");
			st.setString(1, Src);
			st.setString(2, Dest);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				/*out.print("<tr><td>");
				out.println(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(6));
				out.print("</td>");
				out.print("<td>");*/
				out.println(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(5));
				out.print("</td>");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		out.print("</table>");
	}
}


