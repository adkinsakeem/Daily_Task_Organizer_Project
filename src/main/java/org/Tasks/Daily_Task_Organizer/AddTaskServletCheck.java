package org.Tasks.Daily_Task_Organizer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		addVariablesFromJSP(request, response);
		//checkInputs();
		if(timeNumOK == false || dateNumOK == false || timeRangeOK == false || dateRangeOK == false) {
			setReqAtt(request);
			request.setAttribute("dateNumOk", "dateNumOK");
			request.getRequestDispatcher("/Daily_Tasks_Add.jsp").forward(request, response);
		}else {
			
			
		}

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
		if((THour.matches("-?\\d+(\\.\\d+)?")) && 
				(TMinute.matches("-?\\d+(\\.\\d+)?")) && 
				(TSecond.matches("-?\\d+(\\.\\d+)?"))){
			
		}else{
			if(THour == "" && TMinute == "" && TSecond == ""){
				timeNumOK = true;
			}else{
			timeNumOK = false;

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
