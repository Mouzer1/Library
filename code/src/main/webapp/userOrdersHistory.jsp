<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders</title>
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
     <c:forEach items= "${showActiveOrderList}" var="order">
       <tr>
         <td>${order.getId()}</td>
         <td>${order.getDateTaking()}</td>
         <td>${order.getBook()}</td>
       </tr>
     </c:forEach>
  </tbody>
</table>

<table border="1">
  <thead>
    <td>
      <th>Taking date</th>
      <th>Book</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items="${showInactiveOrderList}" var="order">
       <tr>
         <td>${order.getDateTaking()}</td>
         <td>${order.getBook()}</td>
         <td> 
         <form action="MainServlet" method="GET">
	</form>
	</td>
       </tr>
     </c:forEach>
  </tbody>
</table>




</body>
</html>