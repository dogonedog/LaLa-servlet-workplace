<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
	<h1>新規社員登録：確認</h1>
	<c:if test="${not empty emp}">
		<p>ID:<c:out value="${emp.id}" /></p>
		<p>名前:<c:out value="${emp.name}" /></p>
		<p>年齢:<c:out value="${emp.age}" /></p>
		<form action="<%=request.getContextPath()%>/create" method="post">
			<input type="hidden" name="id" value="${emp.id}">
			<input type="hidden" name="name" value="${emp.name}">
			<input type="hidden" name="age" value="${emp.age}">
			<input type="submit" value="登録">
		</form>
		<p><a href="<%=request.getContextPath()%>/create">
			<button>取消</button></a></p>
	</c:if>	
</body>
</html>