<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
h4{
color:green;
}
h3{
color:red;
}
</style>
</head>
<body>
<form action="removeStudent" method="post">
<div class="mb-3" align="center" >
<label for="exampleInputEmail1" class="form-label">Enter Mobile Number</label>
<input type="text"  style="width:300px;" name="txtmobile" class="form-control"/>
</div>
<%
if(request.getAttribute("message")!=null)
{
out.println("<h4>"+request.getAttribute("message")+"</h4>");	
}
if(request.getAttribute("display")!=null)
{
out.println("<h3>"+request.getAttribute("display")+"</h3>");	
}
%>
<div class="mb-3" align="center">
<input type="submit" class="btn btn-primary" value="Submit"/> </br>
<a href="home.jsp">Home Page</a>
</div>
</form>
</body>
</html>