<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
<<<<<<< HEAD
	href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="../${jstlCss}" rel="stylesheet" />
=======
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
>>>>>>> f6a71e749b4d66ce9cb58b77aad7b05e8732bb92

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
<<<<<<< HEAD
	</div>
	<!-- /.container -->
=======
<!-- /.container -->

	
>>>>>>> f6a71e749b4d66ce9cb58b77aad7b05e8732bb92

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> f6a71e749b4d66ce9cb58b77aad7b05e8732bb92
