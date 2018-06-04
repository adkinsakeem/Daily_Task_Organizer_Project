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

<%
Boolean titleLengthOK  = true;



String TTitle = (String)request.getAttribute("TTitle");
String TDescription = (String)request.getAttribute("TDescription");
String TPriority = (String)request.getAttribute("TPriority");
String TMonth = (String)request.getAttribute("TMonth");
String TDay = (String)request.getAttribute("TDay");
String TYear = (String)request.getAttribute("TYear");
String THour = (String)request.getAttribute("THour");
String TMinute = (String)request.getAttribute("TMinute");


if(TTitle == null){
TTitle = "";
}

if(TDescription == null){
TDescription = "";
}

if(TPriority == null){
TPriority = "";
}

if(TMonth == null){
TMonth = "";
}

if(TDay == null){
TDay = "";
}

if(TYear == null){
TYear = "";
}

if(THour == null){
THour = "";
}

if(TMinute == null){
TMinute = "";
}


%>



<center>
<h1>ADD A DAILY TASK</h1><BR>
<form method="post" action="/Daily_Task_Organizer/checkValue">
<h3>Title</h3>
<input type="text" maxlength="50" name="TaskTitle" value="<%=TTitle%>" size="40">
<br>


<font color = "Red">
<%
titleLengthOK = (Boolean)request.getAttribute("titleLengthOK");

if(titleLengthOK!=null){
if(titleLengthOK == false){
out.println("Insufficient Amount of Characters in Title");
}
}
%>
</font>


<br>
<h3>Task Description</h3>
<textarea name= "TaskDescrption" rows="4" cols="150">
<%=TDescription%>
</textarea>
<br>
<font color = "Red">
<%
Boolean descLengthOK = (Boolean)request.getAttribute("descLengthOK");
if(descLengthOK!=null){
if(descLengthOK == false){
out.println("Insufficient Amount of Characters in Description");
}
}
%>
</font>



<br>
<h3>Priority</h3>

<select name="TPriority">

	<option value="blank"> </option>
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
  </select>
  <font color = "Red">
  <br>
<%

Boolean priorityNumOK = (Boolean)request.getAttribute("priorityNumOK");

if(priorityNumOK!=null){
if(priorityNumOK == false){
out.println("You Must Enter A Priority For Your Task");
}
}
%>
</font>
  

  <br>
<h3>When Does Task Need Be Done</h3>

MM&nbsp;&nbsp; / &nbsp;&nbsp;  DD  &nbsp;&nbsp;  /  &nbsp;&nbsp;YYYY<br>
<input type="text" maxlength="2" name="TaskMonth" value="<%=TMonth%>" size="2">/
<input type="text" maxlength="2" name="TaskDay" value="<%=TDay%>" size="2">/
<input type="text" maxlength="4" name="TaskYear" value="<%=TYear%>" size="4">
<br>

<font color = "Red">
<%

Boolean dateNumOK = (Boolean)request.getAttribute("dateNumOK");
Boolean dateRangeOK = (Boolean)request.getAttribute("dateRangeOK");
if(dateNumOK!=null){
if(dateNumOK == false){
out.println("Dates Entered Must Be A Number");
}else if(dateRangeOK == false){
out.println("Dates Are Out Of Range");
}
}
%>
</font>


<br><br>

<h4>Use Military Time</h4>
&nbsp; HH &nbsp; :  &nbsp;  MM  &nbsp;<br>
<input type="text" maxlength="2" name="TaskHour" value="<%=THour%>" size="2">:
<input type="text" maxlength="2" name="TaskMinute" value="<%=TMinute%>" size="2">
<br>
  <font color = "Red">
<%
Boolean timeNumOK = (Boolean)request.getAttribute("timeNumOK");
Boolean timeRangeOK = (Boolean)request.getAttribute("timeRangeOK");
if(timeNumOK!=null){
if(timeNumOK == false){
out.println("Times Entered Must Be A Number");
}else if(timeRangeOK == false){
out.println("Times Are Out Of Range");

}
}
%>
</font>
<br><br><br>
 <INPUT TYPE="SUBMIT" NAME="submit" VALUE="Submit">
&nbsp;&nbsp;&nbsp;
  <INPUT TYPE="BUTTON" NAME="cancel" VALUE="Cancel"  ONCLICK ="javascript:window.location='http://localhost:8080/Daily_Task_Organizer/index.jsp	';" >





</form>


</center>
</body>
</html>