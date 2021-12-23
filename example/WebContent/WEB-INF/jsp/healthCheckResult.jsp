<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="model.Health" %>
<%
  Health health = (Health) request.getAttribute("health");
%>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
<h1>スッキリ健康診断</h1>
<p>
<%-- <%= health.getHeight() %><br>
<%= health.getWeight() %><br>
<%= health.getBmi() %><br>
<%= health.getBodyType() %><br>
</p>--%>
身長：${health.height}<br>
体重：${health.weight}<br>
BMI：${health.bmi}<br>
体型：${health.bodyType}<br>
<a href="/example/HealthCheck">戻る</a>
</body>
</html>