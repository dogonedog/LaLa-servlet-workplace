<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
//EL式挿入したのでコメントアウト
<%@ page import="model.Game" %>
<%
	Game game = (Game) session.getAttribute("game");//gameがなかったらｒnullが入ってる　最初null
%>
--%>



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
	<%--
	<% if (game != null){ %>
		<h2>結果</h2>
		<p>user:<%= game.getUser() %></p>
		<p>com:<%= game.getCom() %></p>
		<p><%= game.getMsg() %></p>
	<% } %>
	--%>
	
	<c:if test="${game.user != 0}"><%--ゲームがnullでなければ--%>
	<h2>結果</h2>
	<p>user:　${game.user}</p>
	<p>com:　${game.com}</p>
	<p>${game.msg}</p>
	</c:if>

<a href="<%= request.getContextPath()%>/game?replay=yes">
<button>別の数字でやる</button></a><%--dogetメソッドで取得できる --%>
<a href="<%= request.getContextPath()%>/game?replay=end">
<button>やめる</button></a>
</body>
</html>