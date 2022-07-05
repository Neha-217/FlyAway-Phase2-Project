<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%! String name="FLYAWAY"; %>
	<!-- Expression -->
	<h1><%= "WELCOME TO  "+name %></h1>
	<h3><%= "Low Fares Done Right." %></h3>
	
	<!-- Side navigation -->
<div class="sidenav">
  <%-- <a href="#">Home</a> --%>
  <a href="journeydetails.jsp">Book Flight</a>
  <%-- <a href="#">Admin Login</a>--%>
  <a href="login.jsp">Admin Login</a>
</div>

<!-- Page content -->
<div class="main">
  ...
</div>

</body>
</html>