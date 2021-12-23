<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@
page import ="ex.Fruit"   
 %>
 <%
 Fruit fruit = (Fruit)application.getAttribute("fruit");
 %>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--<p><%= fruit.getName() %>の値段は<%= fruit.getPrice() %>円です。</p>--%>
<p><c:out value="${applicationScope.fruit.name}" />の値段は</p>
<p><c:out value="${applicationScope.fruit.price}" />円です。</p>
<p>${applicationScope.fruit.name}の値段は${fruit.price}円です。</p>
</body>
</html>