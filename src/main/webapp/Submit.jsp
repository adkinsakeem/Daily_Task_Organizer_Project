<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
String TTitle = request.getParameter("TaskTitle"); 
String TDescrption = request.getParameter("TaskDescrption"); 
String THour = request.getParameter("TaskHour"); 
String TMinute = request.getParameter("TaskMinute"); 
String TSecond = request.getParameter("TaskSecond"); 
String TMonth = request.getParameter("TaskMonth"); 
String TDay = request.getParameter("TaskDay"); 
String TYear = request.getParameter("TaskYear"); 
Boolean timesNumOK = true;
Boolean timesRangeOK = true;
Boolean dateNumOK = true;
Boolean dateRangeOK = true;

if((THour.matches("-?\\d+(\\.\\d+)?")) && 
		(TMinute.matches("-?\\d+(\\.\\d+)?")) && 
		(TSecond.matches("-?\\d+(\\.\\d+)?"))){
	
}else{
	if(THour == "" && TMinute == "" && TSecond == ""){
		timesNumOK = true;
	}else{
	timesNumOK = false;
	//request.setAttribute("errorMessage", "Time Must Be A Numeric Value");
    //response.sendRedirect("Daily_Tasks_Add.jsp");
	}

}


if((TMonth.matches("-?\\d+(\\.\\d+)?")) && 
		(TDay.matches("-?\\d+(\\.\\d+)?")) && 
		(TYear.matches("-?\\d+(\\.\\d+)?"))){
	
}else{
	if(TMonth == "" && TDay == "" && TYear == ""){
		dateNumOK = true;
	}else{
	dateNumOK = false;
	request.setAttribute("errorMessage", "Date Must Be A Numeric Value");
    response.sendRedirect("Daily_Tasks_Add.jsp");
}

}






%>