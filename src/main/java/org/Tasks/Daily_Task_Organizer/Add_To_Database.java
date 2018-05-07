package org.Tasks.Daily_Task_Organizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				//5-Completed_Date, 6-Completed_Time, 7-Completed_Y_N, 8-ID

	public static void Open_Local_SQL1_Database(String TTitle, String TDescription, String TPriority, String TTime, String TDate) {
		// TODO Auto-generated constructor stub
		System.out.println("Test08.1");
		try {
			System.out.println("Test08.2");
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("Test08.3");
			Connection con = DriverManager.getConnection(server,PCName,password);
			PreparedStatement statement = (PreparedStatement) con.prepareStatement
					("INSERT INTO Daily_Tasks_01(?,?,?)VALUES(?,?,?)");
			statement.setString(1, TTitle);
			statement.close();
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		        
		        //java.sql.Statement stm= con.createStatement();
		        con.close();
	}catch(SQLException|ClassNotFoundException e){
	     System.out.println("Something Went Wrong with SQL " + e);
	}


}
}
