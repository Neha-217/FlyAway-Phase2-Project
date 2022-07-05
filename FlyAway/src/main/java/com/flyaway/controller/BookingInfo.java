package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookinginfo")
public class BookingInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text.html");
		PrintWriter out= response.getWriter();
		
		String f_name= request.getParameter("fname");
		String l_name= request.getParameter("lname");
		String email_addr= request.getParameter("email");
		String phone= request.getParameter("pnum");
		String src_city = request.getParameter("scity");
		String dest_city = request.getParameter("dcity");
		String travel_date = request.getParameter("tdate");
		int num_of_pass = Integer.parseInt(request.getParameter("num"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			//String q="insert into customer(fName,lName,email,phone) values (?,?,?,?)";
			
			PreparedStatement pst= con.prepareStatement("insert into customer(fName, lName, email, phone) values (?,?,?,?)");
			PreparedStatement pst1= con.prepareStatement("insert into bookinginfo(src_city, dest_city, travel_date, num_of_pass) values (?,?,?,?)");
			pst.setString(1, f_name);
			pst.setString(2, l_name);
			pst.setString(3, email_addr);
			pst.setString(4, phone);
			pst1.setString(1, src_city);
			pst1.setString(2, dest_city);
			pst1.setString(3, travel_date);
			pst1.setInt(4, num_of_pass);
			
			pst.executeUpdate();
			pst1.executeUpdate();
			
			out.println("Information saved..");
			out.print("<table><td><a href='/fetchinfo?id='>Book Now</a></td>\");</table>");
			
			//response.sendRedirect("FetchInfo.java");
			
			//RequestDispatcher rd = request.getRequestDispatcher("FetchInfo");
			//rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
       
		
	}


