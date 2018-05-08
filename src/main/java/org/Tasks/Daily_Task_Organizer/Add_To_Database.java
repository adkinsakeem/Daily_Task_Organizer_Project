package org.Tasks.Daily_Task_Organizer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		SimpleDateFormat DTimeFormat = new SimpleDateFormat ("MM/dd/yyyy");
		SimpleDateFormat TTimeFormat = new SimpleDateFormat ("HH:mm:ss");
		long millis=System.currentTimeMillis(); 
		java.sql.Date SQLDate = new java.sql.Date(millis);  
		//((PreparedStatement) SQLDate).setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		
	//java.sql.Date SQLDate = new java.sql.Date(utilDate.getTime());
	java.sql.Timestamp SQLTime = new Timestamp(System.currentTimeMillis());;
		
	try {
		SQLDate = (Date) DTimeFormat.parse (TDate);
		SQLTime = (Timestamp) TTimeFormat.parse (TTime);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("There was an issue with converting the Date and Time");
		System.out.println(e1);
	}

		
		System.out.println("Test08.1");
		try {
			System.out.println("Test08.2");
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("Test08.3");
			Connection con = DriverManager.getConnection(server,PCName,password);
			
			PreparedStatement statement = (PreparedStatement) con.prepareStatement
					("INSERT INTO Daily_Tasks_01(?, ?, ?, ?, ?, ?, ?, ?, ?)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, TTitle);
			statement.setString(2, TDescription);
			statement.setInt(3, Integer.parseInt(TPriority));
			statement.setInt(4, Integer.parseInt(TPriority));
			statement.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			statement.setDate(7, (Date) SQLDate);
			statement.setTimestamp(8, SQLTime);
			statement.setBoolean(9, false);
			statement.executeUpdate();
			statement.close();
			con.close();
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		        
		        //java.sql.Statement stm= con.createStatement();
		        con.close();
	}catch(SQLException|ClassNotFoundException e){
	     System.out.println("Something Went Wrong with SQL " + e);
	}


}
}
