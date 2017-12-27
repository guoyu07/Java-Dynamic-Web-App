<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="javax.servlet.ServletContext" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
<style>
	body { background-color:lightblue;}
	h1 {text-align:center;}
	form{text-align:center;}
</style>
</head>
<body>
<%
//Can access the implicit session object...
String user = (String) session.getAttribute("user");
String userName = null;
String sessionId = null;
Logger logger = Logger.getLogger("loginSucces.jsp");
ServletContext context = getServletContext();

Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie : cookies ){
		if(cookie.getName().equals("user")){
			userName = cookie.getValue();
		}
		if(cookie.getName().equals("JSESSIONID")){
			sessionId = cookie.getValue();
			logger.info("The Session ID is: "+sessionId);
			context.log("The Session ID is: "+sessionId);
		}
	}		
}

%>
<!-- <h3>Hi <%=userName %>, Login Successful. Your Session ID =<%=sessionId %></h3> -->
<br>
Current User=<%=userName %>
<a href="logoutPage.jsp"> Logout Page</a>
<h1>Hi <%=userName %>, Login Successful.</h1>
<br><br>
<br><br>
<form action="MenuItemsServlet" method="post">
	<input type="submit" value="Schedule" name="schedule"><br><br>
	<input type="submit" value="---------" name="unimplemented"><br><br>
	<input type="submit" value="---------" name="unimplemented"><br><br>
	<input type="submit" value="---------" name="unimplemented"><br><br>
</form>
</body>
</html>