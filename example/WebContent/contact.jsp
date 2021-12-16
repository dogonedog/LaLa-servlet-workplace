<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/testenq" method="post"><%-- request.getContextPath() このURLはアプリ--%>
	<p>お問い合わせの種類</p> 
	<select name="qtype">
		<option value="company">会社について</option>
		<option value="product">製品について</option>
		<option value="support">アフターサポートについて</option>
	</select>
	<p>お問い合わせ内容</p>
	<textarea name="body"></textarea>
	<input type="submit" value="送信">
</form>

</body>
</html>