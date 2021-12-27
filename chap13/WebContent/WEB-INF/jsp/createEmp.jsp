<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/FormSampleServlet" method="post">
ID：<input type="hidden" name="id" value="${emp.id}">
名前：<input type="hidden" name="name" value="${emp.name}">
年齢：<input type="hidden" name="age" value="${emp.age}">
</form>
</body>
</html>