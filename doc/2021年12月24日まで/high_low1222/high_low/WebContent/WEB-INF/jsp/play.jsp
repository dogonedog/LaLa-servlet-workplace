<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Game" %>
<%
Game game = (Game) session.getAttribute("game");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>High and Low</h1>
	<form action="<%=request.getContextPath()%>/game" method="post">
		<input type="number" name="num"><br>
		<input type="submit" value="OK">
	</form>
	
	<% if (game != null) { %>
		<h2>結果</h2>
		<p>user:  <%= game.getUser() %></p>
		<!-- <p>com:   <%-- game.getCom() --%></p> -->
		<p><%= game.getMsg() %></p>
	<% } %>
	
	<a href="<%=request.getContextPath()%>/game?replay=yes">
	    <button>別の数字でやる</button></a>
	<a href="<%=request.getContextPath()%>/game?replay=end">
	    <button>やめる</button></a>

</body>
</html>