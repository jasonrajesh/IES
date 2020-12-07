package com.example.demo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.admin.domain.Worker;
import com.example.demo.admin.service.WorkerService;

@Controller
public class RegisterWorkerController {
	@Autowired
	private WorkerService workerservice;

	@GetMapping("/workerReg")
	public String index(Model model) {

		model.addAttribute("worker", new Worker());
		return "registration";

	}

	@PostMapping("/saveWorker")
	public String handleSubmitBtn(@ModelAttribute("worker") Worker worker, RedirectAttributes rdattbts) {
		
		boolean sw = workerservice.saveWorker(worker);
		
		if (sw) {
			rdattbts.addFlashAttribute("SvSucc", "Saved Successfully");
		} else {
			rdattbts.addFlashAttribute("SvFail", "Save worker Failed");
		}
		return "redirect:/savedWorkerrd";
	}

	@GetMapping("/savedWorkerrd")
	public String RdSavedWorker(Model model) {
		model.addAttribute("worker", new Worker());
		return "registration";

	}
	
	@GetMapping("/uniqueMailCheck")
	@ResponseBody
	public String isEmailUnique(@RequestParam("email") String email) {
		return workerservice.isUniqueEmail(email) ? "UNIQUE" : "DUPLICATE";
	}
	

}
