package org.Tasks.Daily_Task_Organizer;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Display")
@Produces(MediaType.TEXT_HTML)
public class TasksDisplay extends Get_From_Database{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	public static void Build_HTML() {
		String FullHTML = HTML_Builder.H_Builder();
		StringBuilder HTMLBuilder = new StringBuilder();
		HTMLBuilder.append(FullHTML);
		HTMLBuilder.append("<center> <body><h2>TASKS</h2> </center>");
		
		 int TaskObjNum = TasksList.size();
		 
		 
		 for(int num1 = 0;num1<TaskObjNum;num1++) {
			 TasksList[num1].Current_Priority = TasksList[num1].Original_Priority;
			 //.Current_Priority = TasksList(num1).Original_Priority;
			// Get_CurrentPriority()
		 }
	}

}
