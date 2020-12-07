package com.example.demo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.admin.domain.Plan;
import com.example.demo.admin.service.WorkerService;

@Controller
public class PlanController {

	@Autowired
	private WorkerService workerService;
	
	@GetMapping("/createplan")
	public String formLoad(Model model) {
		model.addAttribute("plan", new Plan());
		return "CreatePlans"; 
	}
	
	@PostMapping("/planSave")
	public String savePlan(@ModelAttribute("plan") Plan plan, Model model) {
		boolean savePlan = workerService.savePlan(plan);
		if(savePlan) {
			model.addAttribute("succ", "Plan saved successfully");
		}
		return "CreatePlans";
	}
	
}
