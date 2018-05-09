package org.Tasks.Daily_Task_Organizer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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

	String databaseName = "STORESQL";
	
	//DatabaseName is DailyTasks
	//TableName is Daily_Tasks_01
	//Columns: 1-Title, 2-Description, 3-Original_Priority, 4-Current_Priority, 
				//5- Opened_Date, 6-Opened_Time, 7-Completed_Date, 8-Completed_Time, 9-Completed_Y_N, 10-ID

	public static void Open_Local_SQL1_Database(String TTitle, String TDescription, String TPriority, String TTime, String TDate) {
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
	
		        con.close();
	}catch(SQLException|ParseException|ClassNotFoundException e){
	     System.out.println("Something Went Wrong with SQL " + e);
	}


}
}
