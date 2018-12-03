<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Users</title>
</head>
<body>

<h3>Users List:</h3>

<table border="1">
  <thead>
    <td>
      <th>Name</th>
      <th>Surname</th>
      <th>Email</th>
      <th>Login</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items= "${showUserList}" var="user">
       <tr>
         <td>${user.getId()}</td>
         <td>${user.getName()}</td>
         <td>${user.getSurname()}</td>
         <td>${user.getEmail()}</td>
         <td>${user.getLogin()}</td>
       </tr>
     </c:forEach>
  </tbody>
</table>

	<a  href="admin.jsp">Back to the main page</a>
</body>
</html>