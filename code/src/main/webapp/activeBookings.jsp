<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Bookings</title>
</head>
<body>

<font size= "16">Here are active bookings: </font>

<table border="1">
  <thead>
    <td>
      <th>Booking date</th>
      <th>Title</th>
      <th>Name</th>
      <th>Surname</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items="${showActiveBookings}" var="booking">
       <tr>
         <td>${booking.getId()}</td>
         <td>${booking.getDateBooking()}</td>
         <td>${booking.getBook()}</td>
         <td>${booking.getName()}</td>
         <td>${booking.getSurname()}</td>
         <td> 
         <form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="reject" />
	<input type="hidden" name="booking_id" value="${booking.getId()}" />
	<input type="submit" value="delete"/>
	</form>
	</td>
		<td> 
		<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="makeOrder" />
	<input type="hidden" name="booking_id" value="${booking.getId()}" />
	<input type="submit" value="make order"/>
	</form> 
		</td>
       </tr>
     </c:forEach>
  </tbody>
</table>

</body>
</html>