<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Mutter" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
@SuppressWarnings("unchecked")
List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
  <h1>どこつぶメイン</h1>
  <p>
    <%= loginUser.getName() %>さん、ログイン中
    <a href="<%=request.getContextPath() %>/Logout">ログアウト</a>
  </p>
  <p><a href="<%=request.getContextPath() %>/Main">更新</a></p>
  <form action="<%=request.getContextPath() %>/Main" method="post">
  	<input type="text" name="text">
  	<input type="submit" value="つぶやく">
  </form>
  
  <% if (errorMsg != null) { %>
  	<p><%= errorMsg %></p>
  <% } %>
  
  <% for (Mutter mutter : mutterList) { %>
  	<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
  <% } %>
</body>
</html>