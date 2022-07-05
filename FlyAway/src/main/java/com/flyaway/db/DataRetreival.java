package com.flyaway.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.math.*;

public class DataRetreival {

	public static void main(String[] args) {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/flyaway";
		String username="root";
		String password="Chaturdaksh_27";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			
			if(conn!=null)
			{
				System.out.println("Connection Established");
				String query = "Select * from flightdetails";
				PreparedStatement st = conn.prepareStatement(query);
				ResultSet result = st.executeQuery();
				
				while(result.next())
				{
					System.out.println(result.getInt(1)+" "+result.getInt(2)+" "
				+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
				}
				
			}
			else
				System.out.println("Error while connecting to Database");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
