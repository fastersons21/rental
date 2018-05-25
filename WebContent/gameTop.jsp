<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<link rel="stylesheet" type="text/css" href="/rental/css/game.css">-->
<link rel="stylesheet" type="text/css" href="/rental/css/Babel.css">
<script type="text/javascript" src="/rental/js/sample.js"></script>
<title>TOP PAGE</title>
</head>
<body>
	<form action="/rental/MainServlet" method="post">
	<input type="submit" value="DOWNLOAD" /><br/>
	<input type="submit" value="Continue" /><br/>
	<input type="submit" value="Exit" /><br/>
	</form>



<a class="DOWNLOAD" href="#platforms"></a>
<div class="platforms" id="platforms">
    <a href="#Install" data-os="Install"></a>
    <a href="#Continue" data-os="Continue"></a>
    <a href="#Settings" data-os="Settings"></a>
</div>
<div class="installer" id="Install">
    <div class="info" data-weight="753 KB"></div>
    <div class="details">
        <p>Install Your Story</p>
        <span>Version 1.0.6</span>
        <ul>
            <li>Episode 1</li>
            <li>Episode 2</li>
            <li>Episode 3</li>
            <li>Episode 4</li>
            <li>Episode 5</li>
        </ul>
    </div>
    <label for="progressInstall"><input type="radio" id="progressInstall"/><span></span></label>
    <a class="back" href="#platforms"></a>
    <a class="close" href="#"></a>
</div>
<div class="installer" id="Continue">
    <div class="info" data-weight="634 KB"></div>
    <div class="details">
        <p>Continue</p>
        <span>Version 1.0.6</span>
        <ul>
            <li>Save Data 1</li>
            <li>Save Data 2</li>
            <li>Save Data 3</li>
            <li>Save Data 4</li>
            <li>Save Data 5</li>
        </ul>
    </div>
    <label for="progressContinue"><input type="radio" id="progressContinue"/><span></span></label>
    <a class="back" href="#platforms"></a>
    <a class="close" href="#"></a>
</div>
<div class="installer" id="Settings">
    <div class="info" data-weight="781 KB"></div>
    <div class="details">
        <p>Settings</p>
        <span>Version 1.0.6</span>
        <ul>
            <li></li>
            <li>Graphic</li>
            <li>Volume</li>
            <li>Controler</li>
            <li>Others</li>
        </ul>
    </div>
    <label for="progressSettings"><input type="radio" id="progressSettings"/><span></span></label>
    <a class="back" href="#platforms"></a>
    <a class="close" href="#"></a>
</div>




</body>
</html>