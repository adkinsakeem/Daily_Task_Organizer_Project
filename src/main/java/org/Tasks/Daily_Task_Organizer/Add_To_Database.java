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
	static String server = "jdbc:sqlserver://127.0.0.1:1433";
	static String server2 = "jdbc:mysql://localhost/test";
	static String password = "Akira214";
	static String PCName = "LAPTOP-QP5643IQ";

	String databaseName = "STORESQL";
	
	//DatabaseName is DailyTasks
	//TableName is Daily_Tasks_01
	//Columns: 1-Title, 2-Description, 3-Original_Priority, 4-Current_Priority, 
				//5-Completed_Date, 6-Completed_Time, 7-Completed_Y_N, 8-ID

	public static void Open_Local_SQL1_Database() {
		// TODO Auto-generated constructor stub
		try {
			Connection con = DriverManager.getConnection(server,PCName,password);
			PreparedStatement statement = (PreparedStatement) con.prepareStatement
					("INSERT INTO Daily_Tasks_01(?,?,?)VALUES(?,?,?)");
			statement.setString(1, TTitle);
			statement.close();
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		        
		        //java.sql.Statement stm= con.createStatement();
		        con.close();
	}catch(SQLException e){
	     System.out.println("Something Went Wrong with SQL " + e);
	 }catch(ClassNotFoundException e){
	     System.out.println("Something Went wrong with class " + e);
	 }	

}
}
