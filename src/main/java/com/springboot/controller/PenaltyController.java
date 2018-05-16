package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.service.PenaltyService;

@Controller
@RequestMapping("/penalty")
public class PenaltyController {
	
	@Autowired
	private PenaltyService penaltyService;
	
	@RequestMapping(value="/add")
	public String loadAddUserScreen() {
		return "Penalty/addPenalty"; 
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPenalty(HttpServletRequest request, ModelMap map) {
		String timeIn = request.getParameter("timeIn");
		String timeOut = request.getParameter("timeOut");
		
		penaltyService.calculatePenalty(timeIn, timeOut);
		return "Penalty/addPenalty"; 
	}
}
