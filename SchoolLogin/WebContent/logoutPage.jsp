<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body { background-color:lightblue;}
	h1 {text-align:center;}
	form{text-align:center;}
</style>
</head>
<body>

<%
String userName = null;
String sessionId = null;

Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie : cookies ){
		if(cookie.getName().equals("user")){
			userName = cookie.getValue();
		}
	}		
}
%>

<h3><%=userName %>, to complete logout click button.</h3>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>