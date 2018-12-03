<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Book List</title>
</head>
<body>

<font size= "16">Welcome</font>
	 <hr/>
	<c:out value="${user}, hello!" />
	<hr/> 

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





	<!-- <h3>List Books:</h3>
	<c:forEach items="${showBookList}" var="book" >
	<p>
	<c:out value="${book.getName()}" />
	<form action="MainServlet" method="GET">
	<input type="hidden" name="command" value="book_book" />
	<input type="hidden" name="book_id" value="${book.getId()}" />
	<input type="submit" value="book"/>
	</form>

	</c:forEach> -->
	<br/>
	<a  href="user.jsp">Back to user page</a>
</body>
</html>