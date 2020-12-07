package com.example.demo.admin.service;

import java.util.List;

import com.example.demo.admin.domain.Plan;
import com.example.demo.admin.domain.Worker;

public interface WorkerService {

	
	public boolean saveWorker(Worker worker);
	public boolean isUniqueEmail(String email);
	public List<Worker> viwAllWorkers();
	public void lockWorker(String email);
	public void activateWorker(String email);
	public String getRegSuccMailBody(Worker worker);
	public boolean sendRegSuccEmail(String to, String subject, String body);
	public Worker findWorkerById(Integer id);
	public boolean deleteWorkerById(Integer id);
	
	public boolean savePlan(Plan plan);

	
}
