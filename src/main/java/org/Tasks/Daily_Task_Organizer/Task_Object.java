package org.Tasks.Daily_Task_Organizer;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task_Object {
	
	String Title;
	String Description;
	static int Original_Priority;
	static int Current_Priority;
	static Date Opened_Date;
	Time Opened_Time;
	static Date Expected_Completed_Date;
	Time Expected_Completed_Time;
	Date Actual_Completed_Date;
	Time Actual_Completed_Time;
	boolean Completed_Y_N;
	int ID;
	static int currentdateInt = 0;
	
	
	//Columns: 1-Title, 2-Description, 3-Original_Priority, 4-Current_Priority, 
			//5- Opened_Date, 6-Opened_Time, 7-Expected_Completed_Date, 8-Expected_Completed_Time, 
				//9-Actual_Completed_Date, 10-Actual_Completed_Time, 11-Completed_Y_N, 12-ID
	
	
	
	
	public static void Get_CurrentPriority() {
		// TODO Auto-generated constructor stub
		
		Calendar date1 = new GregorianCalendar();
	    Calendar date2 = new GregorianCalendar();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	     date1.setTime(Expected_Completed_Date);

	     Date Tempdate = (Date) Calendar.getInstance().getTime();
	 	date2.setTime(Tempdate);
			

	     currentdateInt = daysBetween(date1.getTime(),date2.getTime());
	     
	     
	     Current_Priority = Current_Priority - currentdateInt;
	     if(Current_Priority < 1) {
	    	 Current_Priority = 1;
	     }
	     
	     System.out.println("Old Priority="+ Original_Priority);
	     System.out.println("Plus "+currentdateInt);
	     System.out.println("New Priority="+ Current_Priority);
	}
	
    public static int daysBetween(java.util.Date date1, java.util.Date date2){
    	
    	int dateDiff = 0;
    	dateDiff = (int)( (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    	
    	if(dateDiff < 0) {
    		return 0;
    	}else {
    		return dateDiff;
    	
    	}
}
		
		
		
	

}
