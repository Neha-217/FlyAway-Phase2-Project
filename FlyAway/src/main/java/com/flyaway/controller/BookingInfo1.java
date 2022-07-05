package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bookinginfo1")
public class BookingInfo1 extends HttpServlet {
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
		String travle_date = request.getParameter("tdate");
		int num_of_pass = Integer.parseInt(request.getParameter("num"));
		String price = request.getParameter("price");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			PreparedStatement pst= 
					con.prepareStatement("insert into traveldetails(fName, lName, email, phone, src_city, dest_city, travle_date, num_of_passenger, price) values (?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, f_name);
			pst.setString(2, l_name);
			pst.setString(3, email_addr);
			pst.setString(4, phone);
			pst.setString(5, src_city);
			pst.setString(6, dest_city);
			pst.setString(7, travle_date);
			pst.setInt(8, num_of_pass);
			pst.setString(9, price);
		
			pst.executeUpdate();
			//ResultSet rs=pst.getGeneratedKeys().;
			//System.out.println("result "+x);
			//int x=rs.getInt(1);
			
			out.println("Information saved..");
			
			//out.print("<table><td><a href='/fetchinfo1?id=x'>Confirm Details</a></td>\");</table>");
			
			RequestDispatcher rd = request.getRequestDispatcher("fetchinfo1");
			rd.forward(request, response);
			
	}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}
