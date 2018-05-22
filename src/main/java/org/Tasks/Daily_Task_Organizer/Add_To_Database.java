package org.Tasks.Daily_Task_Organizer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Add_To_Database extends AddTaskServletCheck{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//static String server = "jdbc:sqlserver://localhost:3306;dailyTasks";
	static String server = "jdbc:mysql://localhost:3306/dailyTasks?verifyServerCertificate=false&useSSL=true";
	static String server2 = "jdbc:mysql://localhost/test";
	static String password = "";
	static String PCName = "root";
	static String error = "1";
	static String errormessage = " ";
	

	//String databaseName = "STORESQL";
	
	//DatabaseName is DailyTasks
	//TableName is Daily_Tasks_01
	//Columns: 1-Title, 2-Description, 3-Original_Priority, 4-Current_Priority, 
				//5- Opened_Date, 6-Opened_Time, 7-Expected_Completed_Date, 8-Expected_Completed_Time, 
					//9-Actual_Completed_Date, 10-Actual_Completed_Time, 11-Completed_Y_N, 12-ID

	public static void Open_Local_SQL1_Database(String TTitle, String TDescription, 
			String TPriority, String TTime, String TDate, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated constructor stub

	try {
		java.util.Date DTimeFormat= new SimpleDateFormat ("MM/dd/yyyy").parse(TDate);
		java.sql.Date SQLDate = new java.sql.Date(DTimeFormat.getTime());
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(server,PCName,password);
			PreparedStatement statement = (PreparedStatement) con.prepareStatement
					("INSERT INTO Daily_Tasks_01(Title, Description, Original_Priority, Current_Priority, Opened_Date, Opened_Time, Expected_Completed_Date, Expected_Completed_Time, Completed_Y_N)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, TTitle);
			statement.setString(2, TDescription);
			statement.setInt(3, Integer.parseInt(TPriority));
			statement.setInt(4, Integer.parseInt(TPriority));
			statement.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			statement.setTime(6, java.sql.Time.valueOf(java.time.LocalTime.now()));
			statement.setDate(7, (Date) SQLDate);
			statement.setTime(8, java.sql.Time.valueOf(TTime));
			statement.setBoolean(9, false);
			statement.execute();
			statement.close();
			con.close();
			//response.sendRedirect("/Success.jsp");
			//request.getRequestDispatcher("/Success.jsp");
			//HttpServletResponse.sendRedirect("/Success.jsp");
			RequestDispatcher RequetsDispatcherSuccess =request.getRequestDispatcher("/Success.jsp");
			RequetsDispatcherSuccess.forward(request, response);

			
	}catch(SQLException|ParseException|ClassNotFoundException e){
	     System.out.println("Something Went Wrong with SQL " + e);
	     error = "~There Was An Issue Connecting To The Server~";
	     errormessage = e.toString();
	     request.setAttribute("error", error);
	     request.setAttribute("errormessage", errormessage);
	     RequestDispatcher RequetsDispatcherError =request.getRequestDispatcher("/Error.jsp");
			RequetsDispatcherError.forward(request, response);
	    // RequestDispatcher RequetsDispatcherObj2 =request.getRequestDispatcher("/Error.jsp");
	/*	try {
			RequetsDispatcherObjUerror.forward(request, response);
		} catch (ServletException | IOException e1) {
			// TODO Auto-generated catch block
			RequestDispatcher RequetsDispatcherUerror =request.getRequestDispatcher("/UnknownError.jsp");
			RequetsDispatcherUerror.forward(request, response);
			request.getRequestDispatcher("/UnknownError.jsp");
		}*/

	}


}
}
