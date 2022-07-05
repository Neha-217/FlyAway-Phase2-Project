package com.flyaway.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Connect {

public static void main(String[] args) {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/flyaway";
		String username="root";
		String password="Chaturdaksh_27";
		
		try {
			//load the driver
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			if(conn!=null)
			{
			System.out.println("Connection Established");
			
			String q = "create table flightdetails(fid int(20) primary key auto_increment, flight_number int(20), airline varchar(200) not null, days varchar(50), "
					+ "src_airport varchar(400), dest_airport varchar(400))";
			
			Statement st=conn.createStatement();
			st.executeUpdate(q);
			System.out.println("Table Created in Database..");
			conn.close();}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}