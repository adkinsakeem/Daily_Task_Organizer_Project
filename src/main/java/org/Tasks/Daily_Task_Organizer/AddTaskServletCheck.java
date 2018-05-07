package org.Tasks.Daily_Task_Organizer;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	String TSecond;
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
	/*	// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		session.setAttribute("dateNumOk", "dateNumOK1");
		//request.setAttribute("dateNumOk", "dateNumOK1");
		System.out.println("test2" + dateNumOK);
		getServletConfig().getServletContext().getRequestDispatcher("/Daily_Tasks_Add.jsp").forward(request, response);
		*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Test02");
		addVariablesFromJSP(request, response);
		checkInputs();
	//	if(timeNumOK == false || dateNumOK == false || timeRangeOK == false || dateRangeOK == false) {
			System.out.println("Test03");
			setReqAtt(request);
			System.out.println("Test04");
			request.setAttribute("dateNumOk", "dateNumOK");
			System.out.println("Test05");
			request.getRequestDispatcher("/Daily_Tasks_Add.jsp").forward(request, response);
			System.out.println("Test06");
System.out.println("TTitle " + TTitle);
			System.out.println("TTDescription " + TDescription);
			System.out.println("TPriority " + TPriority);
			System.out.println("THour " + THour);
			System.out.println("TMinute " + TMinute);
			System.out.println("TSecond " + TSecond);
			System.out.println("TMonth " + TMonth);
			System.out.println("TDay " + TDay);
			System.out.println("TYear " + TYear);
			System.out.println("TTime " + TTime);
			System.out.println("TDate " + TDate);

			Add_To_Database.Open_Local_SQL1_Database(TTitle, TDescription, TPriority, TTime, TDate);
			System.out.println("Test08");
			
//		}

	}
	
	
	protected void setReqAtt(HttpServletRequest request) {
		request.setAttribute("TaskTitle", TTitle);
		request.setAttribute("TasDescription", TDescription);
		request.setAttribute("TaskHour", THour);
		request.setAttribute("TaskMinute", TMinute);
		request.setAttribute("TaskSecond", TSecond);
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
		TSecond = request.getParameter("TaskSecond"); 
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
