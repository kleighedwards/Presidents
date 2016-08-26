<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Presidents</title>
</head>
<body>

<p>Please enter the President's term Result:</p>
<form action="Election" method="POST">
	<input type = "text" name ="term"/>
	<input type = "submit" value="Submit" name="button"/>
	<input type = "submit" value="Previous" name="button"/>
	<input type = "submit" value="Next" name="button"/>
</form>

<c:choose>
	<c:when test="${theterm > 44 || theterm < 1}">
		<p>Invalid Term, please correct your input!</p>
	</c:when>
	<c:otherwise>
		<p>President:</p>
		<p>${thepresident}</p>
	</c:otherwise>
</c:choose>

</body>
</html>