<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%--PHP　ディレクティブ--%>>
<%
String name = "湊　ゆうすけ";
int age = 23;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--　これはコメントです。 これはソースの表示ででないコメント--%>>
<% for (int i =0; i < 5; i++) { %>
私の名前は<%= name %>。年齢は<%= age %>です。<br>
<% } %>
<!--　これはコメントです。 -->
</body>
</html>