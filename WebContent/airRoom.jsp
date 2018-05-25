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

	<hr/>
		ソート:<a href="/rental/RentalItemServlet?action=sort&key=price_asc">値段の低い順</a>
			<a href="/rental/RentalItemServlet?action=sort&key=price_desc">値段の高い順</a><br/>

		<form action="/rental/RentalItemServlet" method="post">
		追加:商品名<input type="text" name="name" />価格<input type="text" name="price" size="5"/>を<input type="submit" value="追加">
		<input type="hidden" name="action" value="add" />
		</form>

		<form action="/rental/RentalItemServlet" method="post">
		検索:<input type="text" name="price" size="5" />円以下の商品を<input type="submit" value="検索">
		<input type="hidden" name="action" value="search" />
		</form>

		<form action="/rental/RentalItemServlet" method="post">
		削除:商品番号<input type="text" name="code" size="5" />番の商品を<input type="submit" value="削除">
		<input type="hidden" name="action" value="delete" />
		</form>

	<table border="1" >
	<tr><td>NO</td><td>商品名</td><td>値段</td><td>在庫数</td></tr>

	<c:forEach items = "${items}" var="item">
		<tr><td>${item.id}</td><td>${item.name}</td><td>${item.stock}</td><td>${item.price}</td></tr>
	</c:forEach>

	</table>


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