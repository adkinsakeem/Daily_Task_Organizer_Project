package org.Tasks.Daily_Task_Organizer;

import java.io.IOException;
import java.util.Date;
import java.time.LocalTime;

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
	String TPriority;
	
	String TTime;
	String TDate;
	
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
		addVariablesFromJSP(request, response);
		checkInputs();
			setReqAtt(request);
			request.setAttribute("dateNumOk", "dateNumOK");
			request.getRequestDispatcher("/Daily_Tasks_Add.jsp").forward(request, response);


			Add_To_Database.Open_Local_SQL1_Database(TTitle, TDescription, TPriority, TTime, TDate);
			
//		}

	}
	
	
	protected void setReqAtt(HttpServletRequest request) {
		request.setAttribute("TaskTitle", TTitle);
		request.setAttribute("TasDescription", TDescription);
		request.setAttribute("TaskHour", THour);
		request.setAttribute("TaskMinute", TMinute);
		//request.setAttribute("TaskSecond", TSecond);
		request.setAttribute("TaskDay", TDay);
		request.setAttribute("TaskMonth", TMonth);
		request.setAttribute("TaskYear", TYear);
		request.setAttribute("timeNumOk", timeNumOK);
		request.setAttribute("timeRangeOk", timeRangeOK);
		request.setAttribute("dateNumOk", dateNumOK);
		request.setAttribute("dateRangeOk", dateRangeOK);
		
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
			
			if((tempHour > 0 && tempHour <13) && (tempMinute >= 0 && tempMinute < 60) && (tempSecond >= 0 && tempSecond < 61)) {
				
				 TTime = (THour + ":" + TMinute + ":" + TSecond) ;
				
			}else {
				timeRangeOK = false;
			}
			
		}else{
			if(THour == "" && TMinute == "" && TSecond == ""){
				 LocalTime CTime = LocalTime.now();
				 TTime = CTime.toString();
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
			
			if((tempMonth > 0 && tempMonth <13) && (tempDay > 0 && tempDay < 31) && (tempYear >= 2018)) {
				

					TDate = (TMonth + "/" + TDay + "/" + TYear);

			}else {
				timeRangeOK = false;
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
		TPriority = request.getParameter("TaskPriority"); 
		timeNumOK = Boolean.valueOf(request.getParameter("timeNumOK")); 
		timeRangeOK = Boolean.valueOf(request.getParameter("timeRangeOK"));
		dateNumOK = Boolean.valueOf(request.getParameter("dateNumOK"));
		dateRangeOK = Boolean.valueOf(request.getParameter("dateNumOK"));
		
		
	}

}
