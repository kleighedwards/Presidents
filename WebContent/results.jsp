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

<form action="Election" method="POST">
  <p>Please enter the President's term:
	<input type = "text" name ="term"/>
	<input type = "submit" value="Submit" name="button"/>
	<input type = "submit" value="Previous" name="button"/>
	<input type = "submit" value="Next" name="button"/>
    <select name="Filter">
       <option value="All Presidents" selected name="fbutton">All Presidents</option>
       <option value="Democrats" name="fbutton">Democrats</option>
       <option value="Republicans" name="fbutton">Republicans</option>
       <option value="Whigs" name="fbutton">Whigs</option>
       <option value="Independents" name="fbutton">Independents</option>
       <option value="Federalists" name="fbutton">Federalists</option>
    </select>
  </p>
</form>

<c:choose>–
	<c:when test="${term > 44 || term < 1}">
		<p>Invalid term, please provide a correct entry.</p>
	</c:when>
	<c:otherwise>
			<h2>${thepresident.firstName} ${thepresident.middleName} ${thepresident.lastName}</h2><br>
			
			<p>Fun Fact: ${thefact.statement}</p>
	</c:otherwise>
</c:choose>

</body>
</html>