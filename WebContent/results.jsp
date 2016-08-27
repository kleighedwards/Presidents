<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyles.css">
<title>Presidents</title>
</head>
<body>
<a img src="./images/prez.jpg" alt="President"></a>

<p>Please enter the President's term:</p>
<form action="Election" method="POST">
	<input type = "text" name ="term"/>
	<input type = "submit" value="Submit" name="button"/>
	<input type = "submit" value="Previous" name="button"/>
	<input type = "submit" value="Next" name="button"/>
</form>

<c:choose>
	<c:when test="${term > 44 || theterm < 1}">
		<p>Invalid term, please provide a correct entry.</p>
	</c:when>
	<c:otherwise>
		<p>President:</p>
		<p>${thepresident}</p>
		<p>Fun Fact: ${thefact}</p>
	</c:otherwise>
</c:choose>

</body>
</html>