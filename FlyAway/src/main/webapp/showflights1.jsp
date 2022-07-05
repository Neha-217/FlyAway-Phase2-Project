<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String Source = request.getParameter("src_airport");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "flyaway";
String userid = "root";
String password = "Chaturdaksh_27";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Flights</title>
</head>
<body>
<h1>Available Flights..</h1>
<table border="1">
<tr><td><h2>fid</h2></td>
<td><h2>Flight No.</h2></td>
<td><h2>Airline</h2></td>
<td><h2>Source</h2></td>
<td><h2>Destination</h2></td>
<td><h2>Price</h2></td>
<td><h2>Dates</h2></td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from flightdetails";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("fid") %></td>
<td><%=resultSet.getString("flight_number") %></td>
<td><%=resultSet.getString("airline") %></td>
<td><%=resultSet.getString("src_airport") %></td>
<td><%=resultSet.getString("dest_airport") %></td>
<td><%=resultSet.getString("Price") %></td>
<td><%=resultSet.getString("dates") %></td>
<%-- <td><a href='bookinginfo.jsp="+rs.getInt(1)+"'>Update</a></td>--%>
<td><a href='updatepage?id="+rs.getInt(1)+"'>Update</a></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 

</body>
</html>

</body>
</html>