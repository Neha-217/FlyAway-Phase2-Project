package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.flyaway.dao.CustomerDao;
import com.flyaway.model.Customer;
import com.mysql.cj.Session;


@WebServlet("/saveCustomer")
public class SaveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text.html");
		PrintWriter out= response.getWriter();
		
		String f_name= request.getParameter("fname");
		String l_name= request.getParameter("lname");
		String email_addr= request.getParameter("email");
		String password= request.getParameter("pwd");
		
		/*out.println(f_name);
		out.println(l_name);
		out.println(email_addr);
		out.println(password);*/
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
			
			String q="insert into customer(fName,lName,email,pwd) values (?,?,?,?)";
			
			PreparedStatement pst= con.prepareStatement(q);
			pst.setString(1, f_name);
			pst.setString(2, l_name);
			pst.setString(3, email_addr);
			pst.setString(4, password);
			
			pst.executeUpdate();
			
			out.println("Registered Successfully");
			
			response.sendRedirect("journeydetails.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
       
    
}
