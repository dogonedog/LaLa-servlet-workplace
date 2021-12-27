<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員</title>
</head>
<body>
	<h1>社員</h1>
	<p><a href="<%=request.getContextPath() %>/create">
	   <button>新規社員登録</button></a></p>
	<table>
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>年齢</th>
		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td><c:out value="${emp.id}" /></td>
				<td><c:out value="${emp.name}" /></td>
				<td><c:out value="${emp.age}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>