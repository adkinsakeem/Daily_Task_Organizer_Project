package org.Tasks.Daily_Task_Organizer;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/Display")

public class TasksDisplay extends Get_From_Database{
@Context
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	@Path("/Display3")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public static String Build_HTML() {
		System.out.println("Test14");
		String FullHTML = HTML_Builder.H_Builder();
		StringBuilder HTMLBuilder = new StringBuilder();
		HTMLBuilder.append(FullHTML);
		HTMLBuilder.append("<body><center><h2>TASKS</h2> </center>");
		System.out.println("Test15");
		 int TaskObjNum = TasksList.size();
		 HTMLBuilder.append("Test");
		 System.out.println("Test16");
		 //Round of Changing Priority
		 for(int num1 = 0;num1<TaskObjNum;num1++) {
			 System.out.println("Test16.1");
			 TasksList.get(num1).Current_Priority = TasksList.get(num1).Original_Priority;
			 System.out.println("Test16.2");
			 TasksList.get(num1).Get_CurrentPriority();
			 System.out.println("Expected Time No "+ num1 + ": " +  TasksList.get(num1).Expected_Completed_Date);
		 }
		 
		 System.out.println("Test17");
		// Round of Displaying code thru HTML
		 for(int num1 = 0;num1<TaskObjNum;num1++) {
			 System.out.println("Test18");
			 TasksList.get(num1).Current_Priority = TasksList.get(num1).Original_Priority;
			 TasksList.get(num1).Get_CurrentPriority();
		 
			 HTMLBuilder.append(" <button class=\"accordion\">Priority: ");
			 //Title and Priority
			 HTMLBuilder.append(TasksList.get(num1).Current_Priority + " " + TasksList.get(num1).Title + "  Due Date: " + TasksList.get(num1).Expected_Completed_Date+"</button>");
			//Original Priority and Description
			 HTMLBuilder.append("<div class=\"panel\">\r\n" + 
			 		"<center>Original Priority: " + TasksList.get(num1).Original_Priority + "</center>\r\n" + 
			 		"  <p>" + TasksList.get(num1).Description + "/p>");
			 //Container Dates
			 HTMLBuilder.append("<div id=\"Datescontainer\">\r\n" + 
			 		"<div id=\"OpenedDate\"> \r\n" + 
			 		" <font size=\"2\"><b>Opened Date: " + TasksList.get(num1).Opened_Date + "</b></font><br>\r\n" + 
			 		"  <font size=\"2\"><b>Opened Time: " + TasksList.get(num1).Opened_Time + "</b></font><br>\r\n" + 
			 		"  </div>\r\n" + 
			 		"  <center>\r\n" + 
			 		"  <div id=\"DueDate\"> \r\n" + 
			 		" <font size=\"2\"><b>Due Date: " + TasksList.get(num1).Opened_Date + "</b></font><br>\r\n" + 
			 		"  <font size=\"2\"><b>Due Time: " + TasksList.get(num1).Opened_Time + "</b></font><br>\r\n" + 
			 		"  </div>\r\n" + 
			 		"  </center>\r\n" + 
			 		"  <div id=\"CompletedDate\"> \r\n" + 
			 		" <font size=\"2\"><b>Completed Date: " + TasksList.get(num1).Actual_Completed_Date + "</b></font><br>\r\n" + 
			 		"  <font size=\"2\"><b>Completed Time: " + TasksList.get(num1).Actual_Completed_Time + "</b></font><br>\r\n" + 
			 		"  </div>\r\n" + 
			 		"  \r\n" + 
			 		"</div>  \r\n" + 
			 		"</div>");
		 }
		 
		 HTMLBuilder.append("<script>\r\n" + 
		 		"var acc = document.getElementsByClassName(\"accordion\");\r\n" + 
		 		"var i;\r\n" + 
		 		"\r\n" + 
		 		"for (i = 0; i < acc.length; i++) {\r\n" + 
		 		"    acc[i].addEventListener(\"click\", function() {\r\n" + 
		 		"        this.classList.toggle(\"active\");\r\n" + 
		 		"        var panel = this.nextElementSibling;\r\n" + 
		 		"        if (panel.style.display === \"block\") {\r\n" + 
		 		"            panel.style.display = \"none\";\r\n" + 
		 		"        } else {\r\n" + 
		 		"            panel.style.display = \"block\";\r\n" + 
		 		"        }\r\n" + 
		 		"    });\r\n" + 
		 		"}\r\n" + 
		 		"</script>");
		 
		 
		 
		 //HTML Closing Tags
		HTMLBuilder.append("\r\n" + 
		 		"</body>\r\n" + 
		 		"</html>\r\n" + 
		 		"");
		 
		// System.out.println(HTMLBuilder);
		 String HTMLBuilder2String = HTMLBuilder.toString();
		 
		System.out.println(HTMLBuilder2String);
		 return HTMLBuilder2String;
		 
	}

}
