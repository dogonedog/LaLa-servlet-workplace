<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果</title>
</head>
<body>
  <h1>登録結果</h1>
  <c:out value="${msg}" />
  <p><a href="<%=request.getContextPath() %>/employee">
     <button>一覧にもどる</button></a></p>
</body>
</html>