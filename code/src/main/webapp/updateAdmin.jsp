<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html class='no-js' lang='en'>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>

<h3>Update Book</h3>
<form name = "updateBook" action="MainServlet" method="POST">
<input type = "hidden" name= "command" value = "updateBook"/>
	<c:out value="Book id: ${idBook}" />
	<hr/>
					
	<br/>Title:<br/>
    <input type="text" name="updateTitle" />
    <br/>Author:<br/>
    <input type="text" name="updateAuthor"/>
    <br/>Year:<br/>
    <input type="text" name="updateYear" />
    <br/>
	<input type="submit" value="updateBook"/>
	
</form>
</body>
</html>