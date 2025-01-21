<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="saveStudent" method="post">
<div class="mb-3" align="center">
<label for="exampleInputEmail1" class="form-label">Name</label>
<input type="text" style="width:300px;" name="txtname" class="form-control"/><br>
</div>
<div class="mb-3" align="center">
<label for="exampleInputEmail1" class="form-label">Age</label>
<input type="number" style="width:300px;" name="txtage" class="form-control"/>
</div>
<div class="mb-3" align="center">
<label for="exampleInputEmail1" class="form-label">Mobile Number</label>
<input type="number" style="width:300px;" name="txtmobile" class="form-control"/>
</div>
<div class="mb-3" align="center">
<label for="exampleInputEmail1" class="form-label">Address</label>
<input type="text" style="width:300px;" name="txtaddress" class="form-control"/>
</div>
<div class="mb-3" align="center">
<label for="exampleInputEmail1" class="form-label">Email</label>
<input type="email" style="width:300px;" name="txtemail" class="form-control"/>
</div>
<div class="mb-3" align="center">
<label for="exampleInputEmail1" class="form-label">Course</label>
<input type="text" style="width:300px;" name="txtcourse" class="form-control"/>
</div>
<div class="mb-3" align="center">
<input type="submit" class="btn btn-primary" value="Save"/>
</div>
<div class="mb-3" align="center">
<a href="home.jsp">Home Page</a>
</div>
<%
if(request.getAttribute("message")!=null){
	out.println("<h4>" +request.getAttribute("message")+ "</h4>");
}
%>
</form>
</body>
</html>