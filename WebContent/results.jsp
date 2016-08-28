<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyles.css">
<title>Do you know your U.S. Presidents?</title>
</head>
<body>
<div id="container">
	<div id="header">
		<h1>Do you know your U.S. Presidents?</h1>
	</div>
	<div id="content">
<c:choose>
	<c:when test="${term > 44 || term < 1}">
		<p>Invalid term, please provide a correct entry.</p>
	</c:when>
	<c:otherwise>
			<h2>${thepresident.firstName} ${thepresident.middleName} ${thepresident.lastName}</h2>
			<h3>${thepresident.number}th Term</h3><br>
		    	<img src="./images/${term}.jpg"/><br>
		    <h3>${thepresident.startTerm}-${thepresident.endTerm}</h3><br>
		    <h3>${thepresident.party}</h3><br>
		    
			<h3>Fun Fact : ${thefact.statement}</h3>
	</c:otherwise>
</c:choose>
		<div id="nav">
			<h3></h3>
			<ul>
				<li><li>
				<li><li>
				<li><li>
				<li><li>
				<li><li>
			</ul>
		</div>
		<div id="main">
		<form action="Election" method="POST">
 			 <p>Please enter the President's term:
				<input type = "text" name ="term"/>
				<input type = "submit" value="Submit" name="button"/><br>
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
		<p>Fact with do here</p>
		</div>
	</div>
	<div id="footer">
		Copyright &copy; 2016 Rod Hammond, Kristen Edwards, & Toland Gooch
	</div>
</div>




</body>
</html>