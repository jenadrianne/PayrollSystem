package com.springboot.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.entities.SalaryPerWeek;
import com.springboot.entities.Student;
import com.springboot.service.SalaryperweekService;


@Controller
@RequestMapping("/salaryperweek")
public class SalaryperweekController {
   
	@Autowired
	private SalaryperweekService salaryperweekservice; 
	
	@RequestMapping(value="/calculate")
	public String calculateSalaryPerWeek(ModelMap map){
		List<SalaryPerWeek> salaryList =  salaryperweekservice.getSalariesPerWeek();
		map.addAttribute("salaryList", salaryList);
		System.out.println("jennie" + salaryList.get(0).getEmployee().getFirstName());
		return "Salaryperweek/Salaryperweek";
	}
	
	@RequestMapping(value="/calculate",method=RequestMethod.POST)
	public String computeSalaryPerWeek(HttpServletRequest request, ModelMap map){
		String id = request.getParameter("id");
		salaryperweekservice.calculateSalaryPerWeek(id);
		return "Salaryperweek/Salaryperweek";
	}
	
}
