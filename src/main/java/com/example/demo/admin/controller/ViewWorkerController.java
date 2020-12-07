package com.example.demo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.admin.domain.Worker;
import com.example.demo.admin.service.WorkerService;

@Controller
public class ViewWorkerController {
	
	@Autowired
	private WorkerService workerservice;

	@GetMapping("/allWorkers")
	public String getAllWorkers(Model model) {
		List<Worker> workers = workerservice.viwAllWorkers();
		model.addAttribute("worker", workers);		
		return "AllWorkers";
	}
	
	
	@GetMapping("/editcontact")
	public String getWorkerById(@RequestParam("id") Integer id, Model model) {

		Worker workerById = workerservice.findWorkerById(id);
		model.addAttribute("worker",workerById);
		return "registration";
	}
	
	
}
