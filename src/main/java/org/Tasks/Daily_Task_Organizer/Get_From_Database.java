package org.Tasks.Daily_Task_Organizer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.AbstractList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@WebServlet(description= "Checks Values", urlPatterns = "/Display2")

public class Get_From_Database extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String server = "jdbc:mysql://localhost:3306/dailyTasks?verifyServerCertificate=false&useSSL=true";
	static String password = "";
	static String PCName = "root";
	static String error = "1";
	static String errormessage = " ";
	static ArrayList<Task_Object> TasksList = new ArrayList();
	static String FullFinalHTML = "";

	//String databaseName = "STORESQL";
	
	//DatabaseName is DailyTasks
	//TableName is Daily_Tasks_01
	//Columns: 1-Title, 2-Description, 3-Original_Priority, 4-Current_Priority, 
		//5- Opened_Date, 6-Opened_Time, 7-Expected_Completed_Date, 8-Expected_Completed_Time, 
			//9-Actual_Completed_Date, 10-Actual_Completed_Time, 11-Completed_Y_N, 12-ID


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated constructor stub


			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(server,PCName,password);
				 String query = "SELECT * FROM daily_tasks_01";
			      // create the java statement
			      Statement State = con.createStatement();
			      // execute the query, and get a java resultset
			      ResultSet rs = State.executeQuery(query);
			      // iterate through the java resultset
			    //  TasksList = Collections.emptyList();
			      int listNum = 0;
			      while (rs.next())
			      {
			    	  
			    	Task_Object Tasks = new Task_Object();

			    	Tasks.Title = rs.getString("Title");
			       Tasks.Description = rs.getString("Description");
			        Tasks.Original_Priority = rs.getInt("Original_Priority");
			        Tasks.Current_Priority = rs.getInt("Current_Priority");
			        Tasks.Opened_Date = rs.getDate("Opened_Date");
			        Tasks.Opened_Time = rs.getTime("Opened_Time");
			        Tasks.Expected_Completed_Date = rs.getDate("Expected_Completed_Date");
			        Tasks.Expected_Completed_Time = rs.getTime("Expected_Completed_Time");
			        Tasks.Actual_Completed_Date = rs.getDate("Actual_Completed_Date");
			        Tasks.Actual_Completed_Time = rs.getTime("Actual_Completed_Time");
			        Tasks.Completed_Y_N = rs.getBoolean("Completed_Y_N");
			        Tasks.dateNum = rs.getInt("dateNum");
			        Tasks.ID = rs.getInt("ID");
			        System.out.println("First " + Tasks.Expected_Completed_Date);
			        TasksList.add(Tasks);
			        System.out.println("Second " +  TasksList.get(listNum).Expected_Completed_Date);
			        listNum++;
			        System.out.println("Test11");
			        
				
			      }
			      System.out.println("Test12");
			     // Collections.sort(TasksList, Task_Object.dateNum);
			      FullFinalHTML = TasksDisplay.Build_HTML();
			      //RequestDispatcher RequetsDispatcherSuccess =request.getRequestDispatcher("/Display3");
			      //RequetsDispatcherSuccess.forward(request, response);

			      
			      response.setContentType("text/html");
			      PrintWriter out = response.getWriter();
			      out.println(FullFinalHTML);
			      
				
			} catch (SQLException|ClassNotFoundException e) {
				// TODO Auto-generated catch block
			     System.out.println("Something Went Wrong with SQL " + e);
			     error = "~There Was An Issue Getting The Data From The Server~";
			     errormessage = e.toString();
			     request.setAttribute("error", error);
			     request.setAttribute("errormessage", errormessage);
			     RequestDispatcher RequetsDispatcherObj2 =request.getRequestDispatcher("/Error.jsp");
						RequetsDispatcherObj2.forward(request, response);

			}

}


}
