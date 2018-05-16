package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.springboot.entities.Employee;
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
	public String addEmployee(HttpServletRequest request, ModelMap map) {
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String employeeType = "Regular"; // default regular
		String hourlyRateTemp = request.getParameter("hourlyRate");
		double hourlyRate = Double.parseDouble(hourlyRateTemp);
		
		employeeService.addEmployee(lastName, firstName, hourlyRate, employeeType);

		return listEmployee(map);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateEmployee(HttpServletRequest request, ModelMap map) {
		String empId = request.getParameter("empId");
		Employee selectedEmployee = employeeService.getEmployeeById(empId);
		map.addAttribute("selectedEmployee", selectedEmployee);
		return "Employee/updateEmp";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String executeUpdateUser(HttpServletRequest request, ModelMap map) {
		String empId = request.getParameter("empId");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String employeeType = "Regular"; // default regular
		String hourlyRateTemp = request.getParameter("hourlyRate");
		double hourlyRate = Double.parseDouble(hourlyRateTemp);
		
		employeeService.updateEmployee(empId, lastName, firstName, hourlyRate, employeeType);
		
		return listEmployee(map);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String removeEmployee(HttpServletRequest request, ModelMap map){
		String[] employeeToDelete = request.getParameterValues("employeeIdToDelete");
		employeeService.removeEmployee(employeeToDelete);
		return listEmployee(map);
	}
	
	@RequestMapping(value="/list")
	public String listEmployee(ModelMap map){
		List<Employee> employeeList = employeeService.getEmployee();
		System.out.println("employeeList" + employeeList.size());
		map.addAttribute("employeeList", employeeList);
		return "Employee/listEmp";
	}
}
