<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
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
		    <label for="LastName">First Name: </label>
		    <input type="text" class="form-control" id="LastName" name="firstName">
		  </div>
		  
		  <div class="form-group">
		    <label for="LastName">Hourly Rate: </label>
		    <input type="text" class="form-control" id="LastName" name="hourlyRate">
		  </div>
		  
		  <div class="form-group">
		    <label for="LastName">Employee Type: </label>
		    <label class="checkbox-inline"><input type="checkbox" value="0" name="employeeType">Admin</label>
			<label class="checkbox-inline"><input type="checkbox" value="1" name="employeeType">Regular</label>
		  </div>
		  
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	  </div>
	</div>
</body>
</html>