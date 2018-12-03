<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>

	<font size= "16">Welcome</font>
	 <hr/>
	<c:out value="${user}, hello!" />
	<hr/> 
	<a  href="index.jsp">Logout</a>
<form action="MainServlet" method="GET">
		<input type="hidden" name="command" value="showBookList" /> 
		<input type="hidden" name="user_login" value="${user_login}" />
		<input type="submit" value="show books"/>
</form>
<form action="MainServlet" method="GET">
<input type="hidden" name="command" value="searchBook"/>
<br/>Input book:<br/>  
<input type="text" name="bookValue" />
<input type="submit" value="find book" />
</form>

<form action="MainServlet" method="GET">
<input type="hidden" name="command" value="showOrdersHistory"/>
<input type="submit" value="orders history" />
</form>

<form action="MainServlet" method="GET">
<input type="hidden" name="command" value="showBookingsHistory"/>
<input type="submit" value="bookings history" />
</form>
</body>
</html>