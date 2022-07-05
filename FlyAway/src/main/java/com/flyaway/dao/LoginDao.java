package com.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDao {
	
	String sql = "select * from admin where Email=? and Pwd=?";
	public boolean check(String Email,String Pwd) {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","Chaturdaksh_27");
		
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, Email);
		pst.setString(2, Pwd);
		ResultSet rs= pst.executeQuery();
		if(rs.next())
		{
			return true;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
		return false;
		


	}
}