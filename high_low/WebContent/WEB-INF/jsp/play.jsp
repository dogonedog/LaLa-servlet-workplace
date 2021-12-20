<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Game" %>
<%
	Game game = (Game) request.getAttribute("game");//gameがなかったらｒnullが入ってる　最初null
%>
<%--Integer user = (Integer) request.getAttribute("userNum");
	Integer com = (Integer) request.getAttribute("comNum");
	String Msg = (String) request.getAttribute("Msg");
--%>
    
 <%--<%
 int com = (int) (Math.random() * 10);
 String comtxt = String.valueOf(com);
 %>--%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>High and Low</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/game" method="post"><%--http://localhost:8080/high_low/play.jsp--%>
<%-- /high_low サーブレットのWebアノテーションを書く--%>
0から9 の数を入力してください。
<%--<input type="hidden" name="com" value="<%= comtxt %>">--%>
<input type="number" name="number">
<input type="submit" value="送信">
</form>
<%--nullだから最初は以下の画面表示されない--%>
	<% if (game != null){ %>
		<h2>結果</h2>
		<p>user:<%= game.getUser() %></p>
		<p>com:<%= game.getCom() %></p>
		<p><%= game.getMsg() %></p>
	<% } %>





</body>
</html>