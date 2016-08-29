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
			<h3>${thepresident.ordinal} President</h3>
		    	<img src="./images/${thepresident.number}.jpg"/>
		    <h3>Term: ${thepresident.startTerm}-${thepresident.endTerm}</h3>
		    <h3>Party: ${thepresident.party}</h3> 
			<h3>Fun Fact : ${thefact.statement}</h3>
	</c:otherwise>
</c:choose>
		<div id="nav">
			<h3></h3>
		</div>
		<div id="main">
		<form action="Election" method="POST">
 			 <p ${filter != 'All Presidents'?'style="visibility:hidden"':''}>Please enter the President's term:
			 <input type = "text" name ="term" ${filter != 'All Presidents'?'style="visibility:hidden"':''}/></p>
				<p><input type = "submit" value="Submit" name="button"/>
				<input type = "submit" value="Previous" name="button"/>
				<input type = "submit" value="Next" name="button"/></p>

				<p>Filter:
   			 	<select name="Filter">
      				<option value="All Presidents" name="fbutton" ${filter == 'All Presidents'?'selected':''}>All Presidents</option>
      				<option value="Democrats" name="fbutton" ${filter == 'Democrats'?'selected':''}>Democrats</option>
      				<option value="Republicans" name="fbutton" ${filter == 'Republicans'?'selected':''}>Republicans</option>
      			 	<option value="Whigs" name="fbutton" ${filter == 'Whigs'?'selected':''}>Whigs</option>
      			 	<option value="Independents" name="fbutton" ${filter == 'Independents'?'selected':''}>Independents</option>
       				<option value="Federalists" name="fbutton" ${filter == 'Federalists'?'selected':''}>Federalists</option>
    				</select>
    				</p>
		</form>	
		</div>
	</div>
	
	<div id="footer">
		Copyright &copy; 2016 Rod Hammond, Kristen Edwards, & Toland Gooch
	</div>
</div>




</body>
</html>