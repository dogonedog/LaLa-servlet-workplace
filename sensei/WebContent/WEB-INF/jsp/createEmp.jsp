<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録</title>
</head>
<body>
  <h1>新規社員登録</h1>
  <form action="<%=request.getContextPath()%>/createConfirm" method="post">
  	<p>ID:<input type="text" name="id"></p>
  	<p>名前:<input type="text" name="name"></p>
  	<p>年齢:<input type="number" name="age"></p>
  	<p><input type="submit" value="確認"></p>
  </form>
</body>
</html>