<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Book</title>
</head>
<body>

	Your book(s) is here:
	<br/>
	<table border="1">
  <thead>
    <td>
      <th>Title</th>
      <th>Author</th>
      <th>Action</th>
    </td>
  </thead>
  <tbody>
     <c:forEach items="${showBookList}" var="book">
       <tr>
         <td>${book.getId()}</td>
         <td>${book.getName()}</td>
         <td>${book.getAuthor()}</td>
         <td> 
         <form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="bookBook" />
	<input type="hidden" name="book_id" value="${book.getId()}" />
	<input type="hidden" name="user_login" value="${user}" />
	<input type="submit" value="book"/>
	</form>
	</td>
       </tr>
     </c:forEach>
  </tbody>
</table>
	<br/>
	<a  href="user.jsp">Back to user page</a>
</body>
</html>