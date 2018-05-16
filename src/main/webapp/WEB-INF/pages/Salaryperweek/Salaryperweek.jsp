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

	<div class="container col-md-10 col-md-offset-1">
		<br> <br>
		<div class="panel panel-default">
		  <div class="panel-heading">
		  	<h1><strong><center>Salary Per Week</center></strong></h1>
		  </div>
		  <div class="panel-body">
		  	<form action="/salaryperweek/calculate" method="POST">
		  		<input id="id" name="id"/>
			  	<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<br>
			<br>
			
			<table class="table">
			   <thead>
			     <tr>
			       <th>Id</th>
			       <th>Employee Name</th>
			       <th>Salary Id</th>
			       <th>Net Salary</th>
			       <th>Date Created</th>
			     </tr>
			   </thead>
			   <tbody>
			    
			      <c:forEach items="${salaryList}" var="sList">
			      	 <tr><td>${sList.salaryId}</td>
					<td>${sList.employee.empId}</td>
					<td>${sList.basicSalary}</td>
					<td>${sList.netSalary}</td>
					<td>${sList.dateCreated}</td></tr>
				</c:forEach>
			     
			   </tbody>
			 </table>
		  </div>
		</div>
	</div>
	
	<br> 
	<br>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
