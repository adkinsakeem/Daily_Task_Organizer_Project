<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSSIndex.css">

<script>

    function goBack() {
        window.history.back()
    }
    </script>

<title>Error</title>
</head>
<body>
<center>
<%
String errormessage = (String)request.getAttribute("errormessage");
String error = (String)request.getAttribute("error");
%>

Error<br>

<% out.println(error); %>
<br><br>

<% out.println(errormessage); %>
<br><br>

 <INPUT TYPE="BUTTON" NAME="mainPage" onclick="javascript:window.location='http://localhost:8080/Daily_Task_Organizer/index.jsp	';" >

<BUTTON type="button" name="back" ONCLICK="history.back()">Back</button>

</center>
</body>
</html>