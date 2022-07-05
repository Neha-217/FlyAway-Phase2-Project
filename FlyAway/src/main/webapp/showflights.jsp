<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
      <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
       <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<h2>Available Flights..</h2>
	
	<sql:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/flyaway" user="root" password="Chaturdaksh_27" var="ds"></sql:setDataSource>
	
	<sql:query datasource="${ds}" var="rs" >select * from flightdetails</sql:query>
	
	<%-- <form action="showflight" method="post"></form>--%>
	<table>
	<tr>
	<td>Source Airport</td>
	<td>Destination Airport</td>

	</table>
	
</body>
</html>