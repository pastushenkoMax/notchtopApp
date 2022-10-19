<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Notchtop Specials</title>
</head>
<body>
<div class="container">
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
		<div class="postEditLayout">
			<div class="postImgLayout">
				<img alt="img" src="https://d2hj25gq6hzp2l.cloudfront.net/<c:out value="${post.fileName}" />">
				<div class="deleteBtn">
					<form action="/post/delete/${post.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input class="btnDelete" type="submit" value="Delete">
					</form>
				</div>
			</div>
			<form:form action="/post/${post.id}/update" enctype="multipart/form-data" method="post" modelAttribute="editPost">
				<input type="hidden" name="_method" value="put">
				<div class=submitBtn> 
					<label for="imageFile">Upload Photo: </label>
	    			<input type="file" name="imageFile" id="imageFile" accept="image/png, image/jpeg"  value="choose" class="fileChooseBtn"/>
	    		</div>
	    		<div class=forms>
	    		<p><form:errors path="name" class="text-danger"></form:errors></p>
				    <form:label path="name" for="nameOfUser">Food Name: </form:label>
				    <form:input path="name" type="text" class="form-control" id="user_Name" value="${post.name}" autocomplete="off"></form:input>
				</div> 
				<div class=forms>
				    <form:label path="post_text" for="description">Post: </form:label>
					<div>
						<form:input type="hidden" path="post_text" id="post_text" value="${post.post_text}"/>
						<textarea id="description" onchange="here();" rows="7" cols="50">${post.post_text}</textarea>
					</div>
				</div>
				<div class=forms>
					<form:input type="hidden" path="admin" value="${admin_id}" class="form-control"/>
				</div>
				<div class=submitBtn> 
					<input class="btn btn-primary" type="submit" value="Update">
				</div>
			</form:form>
			<div class="hideDeleteBtn">
				<form action="/post/delete/${post.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input class="btnDelete" type="submit" value="Delete">
				</form>
			</div>
		</div>
	</div>
	<div class="postFooter">
	</div>
</div>
<script>
  var text1 = document.getElementById('description').value;
  function here() {
     text1 = document.getElementById('description').value;
     document.getElementById("post_text").value = text1;
  }
</script>
</body>
</html>