package com.example.demo.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.ar.data.Citizen;
import com.example.demo.ar.service.CitizenService;

@Controller
public class CitizenController {
	@Autowired
	private CitizenService citizenservice;

	@GetMapping("/citizen")
	public String formLoad(Model model) {
		model.addAttribute("citizen", new Citizen());
		return "AppRegist";
	}

	@PostMapping("/saveCitizen")
	public String handleSubmit(@ModelAttribute("citizen") Citizen citizen, Model model) {
		boolean saveCitizen = citizenservice.saveCitizen(citizen);
		if (saveCitizen) {
			model.addAttribute("succ", "Saved successfully");
		} else {
			model.addAttribute("fail", "Not a KT citizen");
		}

		return "AppRegist";

	}
}
