<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Employee" %>
<%
Employee employee = new Employee("0001", "湊 雄輔");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<% for (int i = 1; i <= 10; i++) { %>
	<% if (i % 3 == 1) { %>
		<p class="red">
	<% } else { %>
		<p>
	<% } %>
	idは<%= employee.getId() %>、名前は<%= employee.getName() %>です。</p>
<% } %>
</body>
</html>