package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/add")
	public String loadAddUserScreen() {
		return "Employee/AddEmployee"; 
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addEmployee(HttpServletRequest request, ModelMap map) {
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String employeeType = "Regular"; // default regular
		String hourlyRateTemp = request.getParameter("hourlyRate");
		double hourlyRate = Double.parseDouble(hourlyRateTemp);
		
		employeeService.addEmployee(lastName, firstName, hourlyRate, employeeType);
	}
}
