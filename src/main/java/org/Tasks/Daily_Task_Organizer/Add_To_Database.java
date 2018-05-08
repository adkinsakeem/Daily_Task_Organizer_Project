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
		//java.util.Date DTimeFormat = new Date(000);
		//java.sql.Date SQLDate = new Date(000);
		
		SimpleDateFormat TTimeFormat = new SimpleDateFormat ("HH:mm:ss");
		long millis=System.currentTimeMillis(); 
		//java.sql.Date SQLDate = new java.sql.Date(millis);
		//java.sql.Date SQLDate();
		//((PreparedStatement) SQLDate).setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		
	//java.sql.Date SQLDate = new java.sql.Date(utilDate.getTime());
	//java.sql.Timestamp SQLTime = new Timestamp(System.currentTimeMillis());;
		
	try {
		java.util.Date DTimeFormat= new SimpleDateFormat ("MM/dd/yyyy").parse(TDate);
		java.sql.Date SQLDate = new java.sql.Date(DTimeFormat.getTime());
		
		//Timestamp SQLTime = java.sql.Time.valueOf(TTime);
		//SQLDate = java.sql.Date.valueOf(TDate);
		//SQLDate = (Date) DTimeFormat.parse (TDate);
		//java.sql.Timestamp SQLTime = (Timestamp) TTimeFormat.parse (TTime);
		java.sql.Time SQLTime = new java.sql.Time(TTimeFormat.parse(TTime).getTime());



		
		System.out.println("Test08.1");

			System.out.println("Test08.2");
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("Test08.3");
			Connection con = DriverManager.getConnection(server,PCName,password);
			
			PreparedStatement statement = (PreparedStatement) con.prepareStatement
					("INSERT INTO Daily_Tasks_01(Title, Description, Original_Priority, Current_Priority, Opened_Date, Opened_Time, Completed_Date, Completed_Time, Completed_Y_N)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, TTitle);
			statement.setString(2, TDescription);
			statement.setInt(3, Integer.parseInt(TPriority));
			statement.setInt(4, Integer.parseInt(TPriority));
			statement.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			statement.setDate(7, (Date) SQLDate);
			statement.setTime(8, SQLTime);
			statement.setBoolean(9, false);
			//statement.setNull(10, java.sql.Types.INTEGER);
		//	statement.setInt(10, (Integer) null);
			statement.execute();
			
			statement.close();
			con.close();
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		        
		        //java.sql.Statement stm= con.createStatement();
		        con.close();
	}catch(SQLException|ParseException|ClassNotFoundException e){
	     System.out.println("Something Went Wrong with SQL " + e);
	}


}
}
