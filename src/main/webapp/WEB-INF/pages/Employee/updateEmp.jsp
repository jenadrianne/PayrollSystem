<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8010/employee/update" method="post">
		<input type="hidden" name="empId" value="${selectedEmployee.empId}" />
		Last Name:
		<input type="text" name="lastName" value="${selectedEmployee.lastName}" />
		<br /> First Name:
		<input type="text" name="firstName" value="${selectedEmployee.firstName}" />
		<br /> Hourly Rate:
		<input type="text" name="hourlyRate" value="${selectedEmployee.hourlyRate}" />
		<br />
		<button type="submit">Update Me!!!</button>
	</form>

</body>
</html>