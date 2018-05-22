package org.Tasks.Daily_Task_Organizer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Get_From_Database extends HttpServlet{
	
	static String server = "jdbc:mysql://localhost:3306/dailyTasks?verifyServerCertificate=false&useSSL=true";
	static String password = "";
	static String PCName = "root";
	static String error = "1";
	static String errormessage = " ";
	
	static List<Task_Object> TasksList = new ArrayList<Task_Object>();

	//String databaseName = "STORESQL";
	
	//DatabaseName is DailyTasks
	//TableName is Daily_Tasks_01
	//Columns: 1-Title, 2-Description, 3-Original_Priority, 4-Current_Priority, 
		//5- Opened_Date, 6-Opened_Time, 7-Expected_Completed_Date, 8-Expected_Completed_Time, 
			//9-Actual_Completed_Date, 10-Actual_Completed_Time, 11-Completed_Y_N, 12-ID

	public static void Get_Info_From_Database(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated constructor stub


			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(server,PCName,password);
				
				 String query = "SELECT * FROM users";

			      // create the java statement
			      Statement State = con.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs = State.executeQuery(query);
			      
			      // iterate through the java resultset
			      TasksList = Collections.emptyList();
			      
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
			        Tasks.ID = rs.getInt("ID");
			        
			        TasksList.add(Tasks);
			        
			        listNum++;
				
				
			      }
				
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
