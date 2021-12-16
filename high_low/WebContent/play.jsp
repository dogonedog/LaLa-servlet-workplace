<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 int com = (int) (Math.random() * 10);
 String comtxt = String.valueOf(com);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>High and Low</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/judge" method="post">
<%-- /high_low サーブレットのWebアノテーションを書く--%>
0から9 の数を入力してください。
<input type="hidden" name="com" value="<%= comtxt %>">
<input type="number" name="number">
<input type="submit" value="送信">
</form>
</body>
</html>