<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	<div class="panel panel-default">
	  <div class="panel-heading">
	  	<h1><strong><center>Add Employees</center></strong></h1>
	  </div>
	  <div class="panel-body">
	  	<form action="/employee/add" method="POST">
	  	
		  <div class="form-group">
		    <label for="LastName">Last Name: </label>
		    <input type="text" class="form-control" id="LastName" name="lastName">
		  </div>
		  
		  <div class="form-group">
		    <label for="FirstName">First Name: </label>
		    <input type="text" class="form-control" id="FirstName" name="firstName">
		  </div>
		  
		  <div class="form-group">
		    <label for="HourlyRate">Hourly Rate: </label>
		    <input type="text" class="form-control" id="HourlyRate" name="hourlyRate">
		  </div>
		  
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	  </div>
	</div>
<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>