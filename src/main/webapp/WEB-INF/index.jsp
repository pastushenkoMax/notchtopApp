<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@0,300;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/slideShowStyle.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Notchtop Specials</title>
</head>
<body>
<div class="slideContainer">
	<div class = "slide">
		<img alt="img" src="/images/20160115-5DM30245.jpg"/>
		<div  class="welcome_text"><h1 id="hOneWelcometext">Welcome <br>To<br> Notchtop <br>Bakery & Cafe</h1></div>
	</div>
	<div class = "slide">
		<img alt="img" src="/images/20160115-5DM30245.jpg"/>
		<div  class="header"><h1 class="hOne" id="hOneWelcometext">About us</h1></div>
		<h3 class="aboutUsFooter" id="hOneWelcometext">Notchtop Cafe originally opened in 1993 and was named after Notchtop Mountain in Rocky Mountain National Park. The Notchtop Mountain peak at height of 12,129 foot in Rocky Mountain National Park.
			Today we are known as Notchtop Bakery Cafe that serves tasty breakfast and Lunch.  We aspire to use the most naturally grown and fresh ingredient locally available (focusing on organic) in our food.
			</h3>
	</div>
	<div class="slide ownerSlide">
		<div class="ownerSlideText"><h1>Meet the owner</h1>
			<p>She owns The Notchtop Cafe since 2012, She is creating all recipes on the menu and baking all of our famous pastries</p>
		</div>
		<img alt="img" src="/images/nailya.jpg"/>
	</div>
	<c:forEach var="post" items="${posts}">
		<div class = "slide">
			<img alt="img" src="https://d2hj25gq6hzp2l.cloudfront.net/<c:out value="${post.fileName}"/>" class="">
			<div  class="header"><h1 class="hOne"><c:out value ="${post.name}"></c:out></h1></div>
			<h3 class="footer" id="footer"><c:out value="${post.post_text}"></c:out></h3>
		</div>
	</c:forEach>
</div>
<script type="text/javascript" src="<c:url value="/js/script.js" />"></script>
</body>
</html> 