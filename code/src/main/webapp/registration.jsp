<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in</title>
</head>
<body>

<form name="SignUpForm" method="POST" action="MainServlet">
<input type="hidden" name="command" value="signUpForm"/>
<br/>Name:<br/>
<input type="text" name="name"/>
<br/>Surname:<br/>
<input type="text" name="surname"/>
<br/>Email:<br/>
<input type="text" name="email"/>
<br/>Login:<br/>
<input type="text" name="login" />
<br/>Password:<br/>
<input type="password" name="password"/>
<br/>
<hr/>
<input type="submit" value="Register" />
</body>
</html>