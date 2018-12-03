<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Sign in</title>
</head>
<body>

<form name="LoginForm" method="POST" action="MainServlet">
  <input type="hidden" name="command" value="signInForm"/>
  <br/>Login:<br/>
  <input type="text" name="login"/>
  <br/>Password:<br/>
  <input type="password" name="password"/>
  <br/>
  <hr/>
  <input type="submit" value="Log in"/>
  <br/>If you don't have account:<br/>
  <a href="registration.jsp">Registration</a>
</form>
<hr/>
</body>
</html>

	<!--  Hello user!!!
	<form action="MainServlet" method="post">
		<input type="hidden" name="action" value="test" /> 
		<input type="submit" value="test jsp" />
	</form>
	
	<form action="MainServlet" method="post">
		<input type="hidden" name="action" value="test2" /> 
		<input type="submit" value="test jsp 2" />
	</form> -->
