<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PSO Master</title>
<link rel="stylesheet" href="resources/css/login.css" media="screen">
</head>
<body>

<div class="login">
    <h1>Login</h1>
    <form action="login" method="post">
    	<input type="text" name="username" placeholder="Username" required="required" />
        <input type="password" name="password" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
    </form>
    <br>
    
    <h3>${message_login}</h3>
    <c:if test="${message_login!=null}">
	  <h3>${message_login}</h3>
	</c:if>
    
</div>
</body>
</html>