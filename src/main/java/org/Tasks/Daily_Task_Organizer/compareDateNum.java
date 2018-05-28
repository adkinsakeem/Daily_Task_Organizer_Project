package org.Tasks.Daily_Task_Organizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class compareDateNum extends Get_From_Database{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@Test
	public compareDateNum() {
		// TODO Auto-generated method stub
		//Task_Object.dateNum
		 Collections.sort(TasksList, new Comparator<Task_Object>() {
		        @Override
		        public int compare(Task_Object T_O_1, Task_Object T_O_2) {
		            return Integer.compare(T_O_1.dateNum, (T_O_2.dateNum));
		        }
		 });
	}

}
