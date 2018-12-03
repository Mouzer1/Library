<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>

	<font size= "16">Welcome</font>
	<!--  <hr/>
	<c:out value="${user}, hello!" />
	<hr/> -->
	
	<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="showUserList" />
	<input type="submit" value="showUserList"/>
	</form>
	
	<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="showBookListAdmin" />
	<input type="submit" value="show booklist"/>
	</form>
	
	<a  href="createBook.jsp">Create Book</a>
	
	<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="showNewBookings" />
	<input type="submit" value="New Bookings"/>
	</form>
	
	<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="showActiveBookings" />
	<input type="submit" value="Active Bookings"/>
	</form>
	
	<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="showActiveOrders" />
	<input type="submit" value="Active Orders"/>
	</form>


<p>
	<hr/>
	<a  href="index.jsp">Logout</a>
</body>
</html>