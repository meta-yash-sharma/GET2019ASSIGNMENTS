<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body>
	<h2 align="center">${welcomeMessage}</h2>
	<div align = "left"><a href="logout" id="logout"> LogOut </a><br></div>
	<div align="center">
		<a href="/addStudent" id="stuDetail"> Add Student Details </a> <br>
		<a href="/showStudent" id="showStudents"> Student List </a><br>
	</div>

</body>
</html>