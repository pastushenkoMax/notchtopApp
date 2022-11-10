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
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Notchtop Specials</title>
</head>
<body>
<div class="container adminPage">
	<div class="topBar" id="topbar">
		<h1><a href="/admin_page">Notchtop <strong>App</strong></a></h1>
	 	<a class="myBtn" href="/addPost"><span>Add Item</span>
	 	<span>
	 		<img alt="" src="/images/add_icon.png" >
	 	</span>
	 	</a>
	 	<a class="myBtn logoutBtn" href="/logout"><span>Logout</span>
		<span>
	 		<img alt="" src="/images/logout_icon.png" >
	 	</span>
		</a>
	</div>
 	<div class="adminPageContent">
		<div class="itemContent">
			<c:forEach var="post" items="${posts}">
		  		<a href="/post/${post.id}/edit">
		  		<div class="content">
				<img th:src="@{https://d2hj25gq6hzp2l.cloudfront.net/{name}(name=${post.fileName })}">
				<div class="overlay">
					<div class="contentText"><c:out value="${post.name}"/></div>
				</div>
				</div>
				</a>
			</c:forEach>
		</div>
	</div>
	<div class="footer">
	</div>
</div>
</body>
</html>