<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Book</title>
</head>
<body>

<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="createBook" />
	<br/>Title:<br/>
    <input type="text" name="createTitle" />
    <br/>AuthorId:<br/>
    <input type="text" name="createAuthorId"/>
    <br/>Amount:<br/>
    <input type="text" name="createAmount" />
    <br/>
	<input type="submit" value="create"/>
	</form>

</body>
</html>