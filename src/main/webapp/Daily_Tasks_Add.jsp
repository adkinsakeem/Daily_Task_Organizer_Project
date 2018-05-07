<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Daily Task </title>
</head>
<body>
${dateNumOK}
<%
Boolean timeNumOK = true;
Boolean timeRangeOK = true;
//Boolean dateNumOK = true;
Boolean dateRangeOK = true;
String dateNumOK = "";
if(request.getAttribute("dateNumOK") != null){
dateNumOK = request.getAttribute("dateNumOK").toString(); 
//String dateNumOK =  (String)request.getAttribute("dateNumOK"); 
}

System.out.println(dateNumOK);

%>
Test <%=dateNumOK %>

<center>
<h1>ADD A DAILY TASK</h1><BR>
<form method="post" action="/Daily_Task_Organizer/checkValue">
<h3>Title</h3>
<input type="text" maxlength="50" name="TaskTitle" size="40">
<br><br>
<h3>Task Description</h3>
<textarea name= "TaskDescrption" rows="4" cols="150">
</textarea>
<br><br>
<h3>Priority</h3>
<select name="TaskPriority">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
  </select><br><br>
<h3>When Does Task Need Be Done</h3>
<% if(dateNumOK != null){
if (dateNumOK == "false") { %>
<div><b><font color="red">- Dates Must Be A Number</font></b></div><br>
<% } %>
<% if (dateRangeOK == false) { %>
<div><b><font color="red">- Date Is Out Of Range</font></b></div><br>
<% } }%>
MM&nbsp;&nbsp; / &nbsp;&nbsp;  DD  &nbsp;&nbsp;  /  &nbsp;&nbsp;YYYY<br>
<input type="text" maxlength="2" name="TaskMonth" size="2">/
<input type="text" maxlength="2" name="TaskDay" size="2">/
<input type="text" maxlength="4" name="TaskYear" size="4">
<br><br>
<% if (timeNumOK == false) { %>
<div><b><font color="red">- Times Must Be A Number</font></b></div><br>
<% } %>
<% if (timeRangeOK == false) { %>
<div><b><font color="red">- Time Is Out Of Range</font></b></div><br>
<% } %>
HH &nbsp; :  &nbsp;  MM  &nbsp; : &nbsp; SS&nbsp;<br>
<input type="text" maxlength="2" name="TaskHour" size="2">:
<input type="text" maxlength="2" name="TaskMinute" size="2">:
<input type="text" maxlength="2" name="TaskSecond" size="2">
<br><br><br>
 <INPUT TYPE="SUBMIT" NAME="submit" VALUE="Submit">
&nbsp;&nbsp;&nbsp;
  <INPUT TYPE="SUBMIT" NAME="cancel" VALUE="Cancel">
  
  <%--
  <c:set var="numberAsString">${TaskHour}</c:set>
<c:if test ="${numberAsString.matches('[0-9]+')}">
    It's a number!
</c:if>
--%>

</form>
</center>
</body>
</html>