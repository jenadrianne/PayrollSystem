<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="../${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Payroll System</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">Salary Weekly</a></li>
					<li><a href="#salary">Salary Monthly</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="panel panel-default col-md-10 col-md-offset-1">
	  <div class="panel-heading">
	  	<h1><strong><center>Testing Penalties</center></strong></h1>
	  </div>
	  <div class="panel-body">
	  	<form action="/penalty/add" method="POST">
	  	
		  <div class="form-group">
		     <label for="appt-time">Choose an appointment time: </label>
  <input id="appt-time" type="time" name="timeIn" step="2">
		  </div>
		  
		  <div class="form-group">
		    <label for="FirstName">Time Out: </label>
		    <input type="time" class="form-control" id="timeOut" name="timeOut">
		  </div>
		  
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	  </div>
	</div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
