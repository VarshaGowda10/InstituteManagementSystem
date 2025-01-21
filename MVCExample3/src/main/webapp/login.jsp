<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h4{
color:red;
}</style>
</head>
<body>
<h1>Login Page</h1>
<form action="log" method="post">
<label>Username</label><input type="text" name="txtUserName"/><br>
<label>Password</label><input type="password" name="txtUserPassword"/><br>
<label>
<%//=
if(request.getAttribute("message")!=null)
{
out.println("<h4>" +request.getAttribute("message")+ "</h4>");
}
%>
</label>
<input type="submit" value="Login"/>
<a href="registration.jsp">Sign Up</a>
</form>
</body>
</html>