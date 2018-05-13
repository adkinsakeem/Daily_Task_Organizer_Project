package org.Tasks.Daily_Task_Organizer;

import java.io.IOException;
import java.util.Date;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTaskServletCheck
 */
@WebServlet(description= "Checks Values", urlPatterns = "/checkValue")
public class AddTaskServletCheck extends HttpServlet {
	
	String TTitle;
	String TDescription;
	String THour;
	String TMinute;
	String TSecond = "00";
	String TMonth;
	String TDay;
	String TYear;
	Boolean timeNumOK = true;
	Boolean timeRangeOK = true;
	Boolean dateNumOK = true;
	Boolean dateRangeOK = true;
	Boolean priorityNumOK = true;
	String TPriority = "1";
	
	String TTime;
	String TDate;
	Boolean titleLengthOK = true;
	Boolean descLengthOK = true;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("before" + priorityNumOK);
		addVariablesFromJSP(request, response);
		
		checkInputs();
			setReqAtt(request);
			System.out.println("Test 1");
			//request.setAttribute("test", false);
			
			//request.getRequestDispatcher("/Daily_Tasks_Add.jsp").forward(request, response);
			System.out.println("after" + priorityNumOK);
			System.out.println("Priority =" + TPriority);
			if(timeNumOK == false || timeRangeOK == false || dateNumOK == false || dateRangeOK == false 
					|| titleLengthOK == false || descLengthOK == false || priorityNumOK == false) {
				System.out.println("Test 2");
					
			RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/Daily_Tasks_Add.jsp");
			RequetsDispatcherObj.forward(request, response);
			}else {
				System.out.println("Test 3");
			Add_To_Database.Open_Local_SQL1_Database(TTitle, TDescription, TPriority, TTime, TDate, request, response);
			
	}

	}
	
	
	public void setReqAtt(HttpServletRequest request) {
		request.setAttribute("TTitle", TTitle);
		request.setAttribute("TDescription", TDescription);
		request.setAttribute("THour", THour);
		request.setAttribute("TMinute", TMinute);
		request.setAttribute("TPriority", TPriority);
		request.setAttribute("TDay", TDay);
		request.setAttribute("TMonth", TMonth);
		request.setAttribute("TYear", TYear);
		request.setAttribute("timeNumOK", timeNumOK);
		request.setAttribute("timeRangeOK", timeRangeOK);
		request.setAttribute("dateNumOK", dateNumOK);
		request.setAttribute("dateRangeOK", dateRangeOK);
		request.setAttribute("titleLengthOK", titleLengthOK);
		request.setAttribute("descLengthOK", descLengthOK);
		request.setAttribute("priorityNumOK", priorityNumOK);
		
	}
	
	
	protected void checkInputs() {
		int tempHour;
		int tempMinute;
		int tempSecond;
		int tempMonth;
		int tempDay;
		int tempYear;
		
		
		if((THour.matches("-?\\d+(\\.\\d+)?")) && 
				(TMinute.matches("-?\\d+(\\.\\d+)?")) && 
				(TSecond.matches("-?\\d+(\\.\\d+)?"))){
			
			tempHour = Integer.parseInt(THour);
			tempMinute = Integer.parseInt(TMinute);
			tempSecond = Integer.parseInt(TSecond);
			
			if((tempHour > 0 && tempHour < 24) && (tempMinute >= 0 && tempMinute < 60) && (tempSecond >= 0 && tempSecond < 61)) {
				
				 TTime = (THour + ":" + TMinute + ":" + TSecond) ;
				
			}else {
				timeRangeOK = false;
			}
			
		}else{
			if(THour == "" && TMinute == "" && TSecond == ""){
				 //LocalTime CTime = LocalTime.now();
				 TTime = "23:59:59";
				timeNumOK = true;
				timeRangeOK = true;
			}else{
			timeNumOK = false;

			}

		}

		if((TMonth.matches("-?\\d+(\\.\\d+)?")) && 
				(TDay.matches("-?\\d+(\\.\\d+)?")) && 
				(TYear.matches("-?\\d+(\\.\\d+)?"))){
			
			
			tempMonth = Integer.parseInt(TMonth);
			tempDay = Integer.parseInt(TDay);
			tempYear = Integer.parseInt(TYear);
			if((tempMonth > 0 && tempMonth < 13) && (tempDay > 0 && tempDay < 31) && (tempYear >= 2018)) {
				

					TDate = (TMonth + "/" + TDay + "/" + TYear);
					

			}else {
				dateRangeOK = false;
			}
			
		}else{
			
			if(TMonth == "" && TDay == "" && TYear == ""){

				Date CDate = new Date();
			TDate = CDate.toString();
			
			dateRangeOK = true;
			dateNumOK = true;
			}else{
			dateNumOK = false;

		}

		}
		if(TTitle.length() <=4) {
			titleLengthOK = false;
		}else {
			titleLengthOK = true;
		}
		
		if(TDescription.length() <=4) {
			descLengthOK = false;
		}else {
			descLengthOK = true;
		}
		
		if (TPriority == "" || TPriority == null || TPriority == " " || TPriority.equals("blank")) {
			priorityNumOK = false;
		}else {
			priorityNumOK = true;
		}
	}
	
	
	protected void addVariablesFromJSP(HttpServletRequest request, HttpServletResponse response) {
		TTitle = request.getParameter("TaskTitle"); 
		TDescription = request.getParameter("TaskDescrption"); 
		THour = request.getParameter("TaskHour"); 
		TMinute = request.getParameter("TaskMinute"); 
		//TSecond = request.getParameter("TaskSecond"); 
		TMonth = request.getParameter("TaskMonth"); 
		TDay = request.getParameter("TaskDay"); 
		TYear = request.getParameter("TaskYear"); 
		TPriority = request.getParameter("TPriority"); 
		//timeNumOK = Boolean.valueOf(request.getParameter("timeNumOK")); 
		//timeRangeOK = Boolean.valueOf(request.getParameter("timeRangeOK"));
		//dateNumOK = Boolean.valueOf(request.getParameter("dateNumOK"));
		//dateRangeOK = Boolean.valueOf(request.getParameter("dateNumOK"));
		
		
	}

}
