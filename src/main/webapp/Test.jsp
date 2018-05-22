<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>

</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSSIndex.css">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

<h2>Accordion</h2>

<button class="accordion">Priority: 1  Test Title  Due Date: 12/12/18</button>
<div class="panel">
<center>Original Priority </center>
  <p>Hopefully this works as a template.</p>

  <div id="Datescontainer">
<div id="OpenedDate"> 
 <font size="2"><b>Opened Date: 12/12/18</b></font><br>
  <font size="2"><b>Opened Time: 02:05:00</b></font><br>
  </div>
  <center>
  <div id="DueDate"> 
 <font size="2"><b>Due Date: 12/14/18</b></font><br>
  <font size="2"><b>Due Time: 02:05:00</b></font><br>
  </div>
  </center>
  <div id="CompletedDate"> 
 <font size="2"><b>Completed Date: 12/12/18</b></font><br>
  <font size="2"><b>Completed Time: 02:05:00</b></font><br>
  </div>
  
</div>  
</div>


<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function() {
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
        } else {
            panel.style.display = "block";
        }
    });
}
</script>

</body>
</html>
