<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookings</title>
</head>
<body>

<table border="1">
  <thead>
    <td>
      <th>Taking date</th>
      <th>Book</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items= "${showBookings}" var="booking">
       <tr>
         <td>${booking.getId()}</td>
         <td>${booking.getDateBooking()}</td>
         <td>${booking.getBook()}</td>
         <td> 
         <form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="cancelBooking" />
	<input type="hidden" name="booking_id" value="${booking.getId()}" />
	<input type="submit" value="cancel"/>
	</form>
	</td>
       </tr>
     </c:forEach>
  </tbody>
</table>

</body>
</html>