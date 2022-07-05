<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Journey Details</title>
</head>
<body>

<h1>JOURNEY DETAILS</h1>

<form action="bookflight" method="get">
Source<input type="text" name="src"><br><br>
Destination<input type="text" name="dest"><br><br>
Travel Date<input type="text" name="date"><br><br>
No. of Travelers<input type="text" name="num"><br><br>

<input type="submit" value="Show Flights">
  </form>      
</body>
</html>