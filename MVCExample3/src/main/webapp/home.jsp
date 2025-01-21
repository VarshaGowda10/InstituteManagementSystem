<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="addStudent" method="post">
<h1> Welcome to home page</h1>
<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
<input type="submit" class="btn btn-dark" name="action" value="Add Student" />
<input type="submit" class="btn btn-dark" name="action" value="Display"/>
<input type="submit" class="btn btn-dark" name="action" value="Update" />
<input type="submit" class="btn btn-dark" name="action" value="Delete"/>
</nav>
</form>
</body>
</html>