<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%-- <h4>Welcome <%= request.getParameter("uname") %></h4>--%>
<%-- <a href='adminlist?aid="+rs.getInt(1)+"'>Update Password</a>--%>

<%-- <jsp:include page="traveldetails.jsp"></jsp:include>--%>
<%-- <h1><%= "Welcome Admin..!!" %></h1>--%>
<%
//out.println("Welcome Admin!!");
RequestDispatcher rd = request.getRequestDispatcher("adminlist");
rd.include(request, response);

RequestDispatcher rd1 = request.getRequestDispatcher("list");
rd1.include(request, response);
%>

</body>
</html>