<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Registration Form</h1>
	<h3>Please Enter your Details...</h3>

<form action="saveCustomer" method="post">
First Name: <input type="text" name="fname" placeholder="Enter your First Name"/><br><br>
Last Name: <input type="text" name="lname" placeholder="Enter your Last Name"/><br><br>
Email: <input type="text" name="email" placeholder="Enter your Email"/><br><br>
Password: <input type="text" name="pwd" placeholder="Enter your Password"/><br><br>

<input type="submit" value="Register">


</form>

</body>
</html>