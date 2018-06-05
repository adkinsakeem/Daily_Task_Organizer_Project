package org.Tasks.Daily_Task_Organizer;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task_Object implements Comparable<Task_Object>{
	
	String Title;
	String Description;
	static int Original_Priority;
	static int Current_Priority;
	static Date Opened_Date;
	Time Opened_Time;
	static Date Expected_Completed_Date;
	static Time Expected_Completed_Time;
	 java.util.Date Actual_Completed_Date;
	 java.util.Date Actual_Completed_Time;
	boolean Completed_Y_N;
	int ID;
	static int currentdateInt = 0;
	static int dateNum = 1;
	static int timeInt = 0;
	
	
	
	//Columns: 1-Title, 2-Description, 3-Original_Priority, 4-Current_Priority, 
			//5- Opened_Date, 6-Opened_Time, 7-Expected_Completed_Date, 8-Expected_Completed_Time, 
				//9-Actual_Completed_Date, 10-Actual_Completed_Time, 11-Completed_Y_N, 12-ID
	
	
	
	
	public static void Get_CurrentPriority() {
		// TODO Auto-generated constructor stub
		java.util.Date date1 = new java.util.Date();
		java.util.Date date2 = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	     date1 = (Expected_Completed_Date);
	     System.out.println("EXPECTED COMPLETED TIME: " + date1);
	     java.util.Date Tempdate = new java.util.Date();
	 	date2 = (Tempdate);
	 	System.out.println("Todays Date: " + date2);

	     currentdateInt = daysBetween(date1.getTime(),date2.getTime());
	     
	     
	     
	    // Current_Priority = Current_Priority - currentdateInt;
	     
	     if(currentdateInt == 1) {
	    	 Current_Priority = Current_Priority - 1;
	     }else if(Current_Priority == 2) {
	    	 Current_Priority = Current_Priority - 3;
	     }else if(Current_Priority == 3) {
	    	 Current_Priority = Current_Priority - 5;
	     }else if(Current_Priority > 3) {
	    	 Current_Priority = 1;
	    	 dateNum = 1;
	     }
	     
	     if(Current_Priority < 1) {
	    	 Current_Priority = 1;
	     }
	     
	     
	     
	     System.out.println("Old Priority="+ Original_Priority);
	     System.out.println("Plus "+currentdateInt);
	     System.out.println("New Priority="+ Current_Priority);
	}
	
    public static int daysBetween(long date1, long date2){
    	
    	int dateDiff = 0;
    	dateDiff = (int)( (date2 - date1) / (1000 * 60 * 60 * 24));
    	System.out.println("Days Difference = " + dateDiff);
    	
    	if(dateDiff < 0) {
    		return 0;
    	}else {
    		return dateDiff;
    	
    	}

    	//timeInt.setTime(8, java.sql.Time.valueOf(Expected_Completed_Time));
   
}
    
    @Override
    public int compareTo(Task_Object T_Object) {
        // usually toString should not be used,
        // instead one of the attributes or more in a comparator chain
    	 return  (this.dateNum < ((Task_Object) T_Object).dateNum ? -1 : (this.dateNum == ((Task_Object) T_Object).dateNum ? 0 : 1));
    }
		
		
		
	

}
