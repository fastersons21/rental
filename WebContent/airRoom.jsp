<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/rental/css/main.css">
<title>AirRoom</title>
</head>
<body>
	<h1>AirRoomへようこそ！</h1>
	<input type="button" onclick="location.href='userLogin.jsp'" value="はじめての方はこちら">
	<input type="button" onclick="location.href='userLogin.jsp'" value="会員ログイン">
	<hr>
	<ul id="nav">
	  <li><a href="#">AirRoomトップ</a></li>
	  <li><a href="#">商品検索</a></li>
	  <li><a href="/rental/userLogin.jsp">登録ログイン</a></li>
	  <li><a href="#">利用方法</a></li>
	</ul>

	<p class="sample">
	</p>
	<br />
	<hr>

	<!--以下twitter-->
	<a href="#" class="flat_ss">
	    <span class="iconback tw"><i class="fa fa-twitter"></i></span><span class="btnttl">TWEET</span>
	</a>

	<!--以下facebook-->
	<a href="#" class="flat_ss">
	    <span class="iconback fb"><i class="fa fa-facebook"></i></span><span class="btnttl">SHARE</span>
	</a>

	<!--以下pocket-->
	<a href="#" class="flat_ss">
	    <span class="iconback pkt"><i class="fa fa-get-pocket"></i></span><span class="btnttl">POCKET</span>
	</a>

	<!--以下feedly-->
	<a href="#" class="flat_ss">
	  <span class="iconback fdly"><i class="fa fa-rss"></i></span><span class="btnttl">FEEDLY</span>
	</a>
	<!-- SNS終わり -->


</body>
</html>