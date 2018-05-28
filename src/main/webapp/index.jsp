<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="CSSIndex.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daily Tasks Organizer </title>
</head>
<body>
<center>
<h1>Daily Task Organizer</h1>
<br><br><br><br>
<h2>Add A Task or View Tasks</h2>
<br><br>
<button class="button" onClick="location='http://localhost:8080/Daily_Task_Organizer/Daily_Tasks_Add.jsp'" >Add Tasks</button>
&nbsp;
&nbsp;
&nbsp;
<button class="button" onClick="location='http://localhost:8080/Daily_Task_Organizer/webapi/Display/'" >View Tasks</button>

</center>


</body>
</html>
