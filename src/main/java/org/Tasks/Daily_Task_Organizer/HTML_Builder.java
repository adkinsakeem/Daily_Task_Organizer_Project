package org.Tasks.Daily_Task_Organizer;

public class HTML_Builder extends TasksDisplay {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
static String To_Title;
static String To_Head;

protected static String H_Builder() {
	To_Title = ("<html>\r\n" + 
			"<title>\r\n" + 
			"\r\n" + 
			"</title>");
	To_Head = ("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
			"<link rel=\"stylesheet\" href=\"CSSIndex.css\">\r\n" + 
			"<head>\r\n" + 
			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"\r\n" + 
			"</head>");
	
	return(To_Title + To_Head);
	
	
	/*To_Title = ("<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\r\n" + 
			"    pageEncoding=\"ISO-8859-1\"%>\r\n" + 
			"    <%@ page import = \"java.io.*,java.util.*, javax.servlet.*\" %>\r\n" + 
			"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
			"<html>\r\n" + 
			"<title>\r\n" + 
			"\r\n" + 
			"</title>");*/
	
	

}
}
