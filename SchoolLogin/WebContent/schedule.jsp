<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Today's Schedule</title>
<style type="text/css">
	body {
		background-color:lightblue;
	}
	h1 {
		text-align:center;
	}
	table, th, td{
	border: 1px solid Black;
	padding: 5px;
	}
	table{
	margin-left: auto;
	margin-right: auto;
	border-spacing: 15px;
	}
</style>
</head>
<body>
<a href="loginSuccess.jsp">Back</a>
	<h1><label>Today's Schedule</label></h1>
<br><br><br>

<%
//Simulating data loaded to table. Would usually get from database.
String[] titles = {"Lesson Time","Lesson Type","Lesson Type"};
String[] times = {"10:00-10:40","10:50-11:30","11:40-12:20","12:30-13:10","13:20-14:00","14:10-14:50","15:00-15:40","15:50-16:30","16:40-17:20"};
String[] type = {"Adult M to M", "Adult Group","Kids Group","Kids M to M","Lunch","Adult M to M", "Adult Group","Kids Group","Adult Group"};
String[] numStu = {"1 Student","4 Students","8 Students","1 Student","0 Students","1 Student","4 Students","8 Students","4 Students"};
out.println("<table>");
out.println("<tr><th>"+titles[0]+"</th><th>"+titles[1]+"</th><th>"+titles[2]+"</th></tr>");
for(int i = 0; i < 9; i++){
	out.println("<tr><th>"+times[i]+"</th><th>"+type[i]+"</th><th>"+numStu[i]+"</th></tr>");
}
out.println("</table>");
%>

</body>
</html>