<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AirRoom会員ログイン</title>
</head>
<body>
	<form action="/rental/rLoginServlet" method="post">
	ユーザー名:<input type ="text" name="name" /><br/>
	パスワード:<input type="password" name ="pass" /><br/>
	<input type ="hidden" name ="action" value="login" />
	<input type ="submit" value ="ログイン" />
	</form>

	

</body>
</html>