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
<form>
	<input type = "text" name ="term"/>
	<input type = "submit" value="submit"/>
	<input type = "submit" value="Previous"/>
	<input type = "submit" value="Next"/>
</form>

<p>President for term ${theterm}:</p>
<p>${thepresident}</p>
<p>${thepresident.firstName}</p>

</body>
</html>