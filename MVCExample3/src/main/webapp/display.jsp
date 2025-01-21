<%@page import="com.techpalle.bean.Student"%>
<%@page import="java.util.ArrayList"%>
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

<table  border="1" table class="table-bordered border-success table table-success table-striped-columns">
<thead>
<tr>
<th>  &nbsp Sid &nbsp </th>
<th>  &nbsp Name &nbsp </th>
<th>  &nbsp Age &nbsp </th>
<th>  &nbsp Mobile &nbsp </th>
<th> &nbsp Address &nbsp </th>
<th> &nbsp Email &nbsp </th>
<th> &nbsp Course &nbsp </th>
</tr>
</thead>
<tbody>
 <% ArrayList<Student> al=(ArrayList<Student>) request.getAttribute("student list");
 for(Student s:al)
 {  %>
 	<tr> 
	 <td> &nbsp <%= s.getSid() %> &nbsp</td>
	 <td> &nbsp <%= s.getName() %> &nbsp </td>
	 <td> &nbsp <%= s.getAge() %> &nbsp </td>
	 <td> &nbsp <%= s.getMobile() %> &nbsp </td>
	 <td> &nbsp <%= s.getAddress() %> &nbsp </td>
	 <td> &nbsp <%= s.getEmail() %> &nbsp </td>
	 <td> &nbsp <%= s.getCourse() %> &nbsp </td>
	 </tr>
 <% } %>

</tbody>
</table>
<div class="mb-3" align="center">
<a href="home.jsp">Home Page</a>
</div>
</body>
</html>