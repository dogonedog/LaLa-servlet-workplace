<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

</head>
<body>
<h1>社員管理アプリケーション</h1>
<p><a href="<%=request.getContextPath() %>/CreateeConfirm"><button>新規社員登録</button></a></p>
<h2>社員一覧</h2>
<table>
<tr>
<th>ID</th>
<th>名前</th>
<th>年齢</th>
</tr>
<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.id}</td><td>${emp.name}</td><td>${emp.age}</td>
</tr>
</c:forEach>
</table>
</body>
</html>