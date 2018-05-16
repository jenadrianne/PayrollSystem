<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="http://localhost:8010/employee/delete" method="post">
	<table>
	<tr>
	   <th>EMPLOYEE ID</th>
    <th>LAST NAME</th>
    <th>FIRST NAME</th>
    <th></th>
    <th></th>
 
  </tr>
	<c:forEach items="${employeeList}" var="employeeVar">
	<tr>
	<td>${employeeVar.empId}</td>
	<td>${employeeVar.lastName}</td>
	<td>${employeeVar.firstName}</td>
	<td><input type="button" value="UPDATE" onclick="window.location.href='http://localhost:8010/employee/update?empId=${employeeVar.empId}'" /></td>
	<td><button type="submit" name="employeeIdToDelete" value="${employeeVar.empId}">DELETE</button></td>
	</tr>
		
	</c:forEach>
	</table>
	</form>
	
</body>
</html>