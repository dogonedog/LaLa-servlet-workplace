<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Employee" %>
<%
Employee emp = (Employee) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<%= emp.getId() %><br>
<%= emp.getName() %><br>
<%= emp.getAge() %><br>
</p>
<p>
<a href=“/chap13/create“>登録</a>
</p>
<p>
<a href=“/chap13/create“>取消</a>
</p>
</body>
</html>