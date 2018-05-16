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

	<div class="container">
		<br> <br>
		<div class="panel panel-default">
		  <div class="panel-heading">
		  	<h1><strong><center>List of Employees</center></strong></h1>
		  </div>
		  <div class="panel-body">
		  	<a href="/employee/add">Create User</a>
		  	<a href="/employee/list">Listssss User</a>
		  </div>
		</div>


	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
