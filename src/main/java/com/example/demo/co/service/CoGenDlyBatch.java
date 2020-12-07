package com.example.demo.co.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.co.entity.BatchRunDtlsEntity;
import com.example.demo.co.repository.BatchRunRepository;
import com.example.demo.ed.domain.EligibilityDtls;
import com.example.demo.ed.entity.CotriggersEntity;
import com.example.demo.ed.entity.EligibilityDtlsEntity;
import com.example.demo.ed.repository.CotriggersRepository;
import com.example.demo.ed.repository.EligibilityDtlsRepository;

@Service
public class CoGenDlyBatch implements CoBatchService{

	@Autowired
	private BatchRunRepository batchRunRepo;
	@Autowired
	private CotriggersRepository cotriggerRepo;
	@Autowired
	private EligibilityDtlsRepository eligiRepo;
	
	
	@Override
	public void preProcess() {
		BatchRunDtlsEntity entity = new BatchRunDtlsEntity();
		entity.setBatchName("CO_GEN_DLY");
		entity.setStartDate(new Date());
		batchRunRepo.save(entity);
		
		
	}

	@Override
	public void start() {
		List<CotriggersEntity> triggers = cotriggerRepo.findAll();
		for (CotriggersEntity trigger : triggers) {
			if (trigger.getTrgStatus().equals("P")) {
				Integer caseNum = trigger.getCaseNum();
				Optional<EligibilityDtlsEntity> optional = eligiRepo.findById(caseNum);
				EligibilityDtlsEntity eligibilityDtlsEntity = optional.get();
				EligibilityDtls eligibilityDtls = new EligibilityDtls();
				BeanUtils.copyProperties(eligibilityDtlsEntity, eligibilityDtls);
				process();
			}
		}
	}

	@Override
	public void process() {
		// Logic to create/send pdf, change status P to C in co-triggers table
		
	}

	@Override
	public void postProcess() {
		BatchRunDtlsEntity entity = new BatchRunDtlsEntity();
		entity.setEndDate(new Date());
		batchRunRepo.save(entity);
		
	}

	
}
