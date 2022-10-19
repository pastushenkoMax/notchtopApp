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
<title>Notchtop Specials</title>
</head>
<body>
 <div class="loginContainer">
	<div class="loginMainContent">
		<div class="left">
			<div class="loginText">
				<h1 class="welcome">Welcome</h1> <h1 class="to">To</h1> <h1 class="ph_st">Notchtop <strong>App</strong></h1>
			</div>
		</div>
		<div class="right">
		<form:form action="/login_user" method="post" modelAttribute="createLogin">
			<h1>Sign in to account</h1>
			<div class=forms> 
			<p><form:errors path="userName" class="text-danger"></form:errors></p>
				<form:label path="userName" for="userName">User name: </form:label>
				<form:input path="userName" type="text" class="form-control" id="userName" placeholder="User Name" autocomplete="off"></form:input>
			</div>   
			<div class=forms> 
			<p><form:errors path="password" class="text-danger"></form:errors></p>
				<form:label path="password" for="userPassword">Password: </form:label>
				<form:input path="password" type="password" class="form-control" id="userPassword" placeholder="User Password"></form:input>
			</div>   
			<div class=submitBtn> 
				<input class="btn btn-primary" type="submit" value="SIGN IN">
			</div>
		</form:form>
		</div>
	</div>
</div>
</body>
</html>