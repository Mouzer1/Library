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

<font size= "16">Here are active orders: </font>

<table border="1">
  <thead>
    <td>
      <th>Taking date</th>
      <th>Title</th>
      <th>Name</th>
      <th>Surname</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items="${showActiveOrders}" var="order">
       <tr>
         <td>${order.getId()}</td>
         <td>${order.getDateTaking()}</td>
         <td>${order.getBook()}</td>
         <td>${order.getName()}</td>
         <td>${order.getSurname()}</td>
         <form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="wasReturned" />
	<input type="hidden" name="order_id" value="${order.getId()}" />
	<input type="submit" value="wasReturned"/>
	</form>
	</td>
       </tr>
     </c:forEach>
  </tbody>
</table>

</body>
</html>
