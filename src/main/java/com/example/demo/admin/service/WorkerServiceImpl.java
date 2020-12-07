package com.example.demo.admin.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.admin.domain.Plan;
import com.example.demo.admin.domain.Worker;
import com.example.demo.admin.entity.PlanEntity;
import com.example.demo.admin.entity.WorkerEntity;
import com.example.demo.admin.repository.PlanRepository;
import com.example.demo.admin.repository.WorkerRepository;
import com.example.demo.util.EmailUtils;

import javassist.expr.NewArray;

@Service
public class WorkerServiceImpl implements WorkerService {
	@Autowired
	private WorkerRepository workerRepo;
	
	@Autowired
	private PlanRepository planRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean saveWorker(Worker worker) {

		WorkerEntity workerEntity = new WorkerEntity();
		BeanUtils.copyProperties(worker, workerEntity);
		WorkerEntity entity = workerRepo.save(workerEntity);
//		return entity.getSno() != null;
		if (entity.getSno() != null) {
			String to = worker.getEmail();
			String subject = "Your registration successful for IES project";
			String body = getRegSuccMailBody(worker);
			sendRegSuccEmail(to, subject, body);
			return true;
		}
		return false;
	}

	@Override
	public List<Worker> viwAllWorkers() {
		List<WorkerEntity> findAll = workerRepo.findAll();
		List<Worker> arrayList = new ArrayList<>();
		for(WorkerEntity entity: findAll) {
			Worker worker = new Worker();
			BeanUtils.copyProperties(entity, worker);
			arrayList.add(worker);
		}
		return arrayList;
	}

	@Override
	public void lockWorker(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activateWorker(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUniqueEmail(String email) {
		WorkerEntity workerEntity = workerRepo.findByEmail(email);
		return workerEntity != null ? false : true;
	}

	@Override
	public String getRegSuccMailBody(Worker worker) {
		String fileName = "WORKER-REG-MAIL.txt";
		List<String> replacedLines = null;
		String mailBody = null;
		try {
			Path path = Paths.get(fileName, "");
			Stream<String> lines = Files.lines(path);

			replacedLines = lines
					.map(line -> line.replace("{FNAME}", worker.getFirstName()).replace("{LNAME}", worker.getLastName())
							.replace("{PWD}", worker.getPassword()).replace("{EMAIL}", worker.getEmail()))
					.collect(Collectors.toList());

			mailBody = String.join("", replacedLines);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailBody;

	}

	@Override
	public boolean sendRegSuccEmail(String to, String subject, String body) {
		return emailUtils.sendEmail(to, subject, body);
	}

	@Override
	public Worker findWorkerById(Integer id) {
		Optional<WorkerEntity> optional = workerRepo.findById(id);
		if (optional.isPresent()) {
			WorkerEntity workerEntity = optional.get();
			Worker worker = new Worker();
			BeanUtils.copyProperties(workerEntity, worker);
			return worker;
		}
		
		return null;
	}

	@Override
	public boolean deleteWorkerById(Integer id) {
		Optional<WorkerEntity> optional = workerRepo.findById(id);
		if (optional.isPresent()) {
			WorkerEntity entity = optional.get();
			entity.setAccStatus("LOCKED");
			return true;
		}
		return false;
	}

	@Override
	public boolean savePlan(Plan plan) {
		
		PlanEntity planEntity = new PlanEntity();
		BeanUtils.copyProperties(plan, planEntity);
		planRepo.save(planEntity);
		return true;
		
	}

}
