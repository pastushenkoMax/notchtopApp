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
	<div class="mainContent postLayout">
		<div class="postAddLayout">
		<form:form action="/newPost" enctype="multipart/form-data" method="post" modelAttribute="createPost">
			<div class=submitBtn> 
			   	<label for="imageFile">Upload Photo: </label>
    			<input type="file" name="imageFile" id="imageFile" accept="image/png, image/jpeg"  value="choose" class="fileChooseBtn"/>
    		</div>
    		<div class=forms>
    		<p><form:errors path="name" class="text-danger"></form:errors></p>
			    <form:label path="name" for="nameOfUser">Food Name: </form:label>
			    <form:input path="name" type="text" class="form-control" id="user_Name" placeholder="Name" autocomplete="off"></form:input>
			</div> 
			<div class=forms>
			    <form:label path="post_text" for="description">Special description: </form:label>
				<div>
					<form:textarea path="post_text" id="description" rows="7" cols="50"/>
				</div>
			</div>    
    		<div class=forms>
				<form:input type="hidden" path="admin" value="${admin_id}" class="form-control"/>
			</div>
			<div class=submitBtn> 
				<input class="btn btn-primary" type="submit" value="Post">
			</div>
		</form:form>
	</div>
	</div>
	<div class="postFooter">
	</div>
</div>
</body>
</html>