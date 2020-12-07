package com.example.demo.ar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ar.data.Citizen;
import com.example.demo.ar.data.CitizenHold;
import com.example.demo.ar.entity.CitizenEntity;
import com.example.demo.ar.repository.CitizenRepository;

@Service
public class CitizenImpl implements CitizenService {
	@Autowired
	private CitizenRepository citizenrepo;

	@Override
	public boolean saveCitizen(Citizen citizen) {

		RestTemplate rt = new RestTemplate();
		ResponseEntity<CitizenHold> forEntity = rt.getForEntity("http://localhost:8080/verify/" + citizen.getSsnId(),
				CitizenHold.class);
		int statusCodeValue = forEntity.getStatusCodeValue();
		if (statusCodeValue == 200) {
			if (forEntity.getBody().getState().equals("KT")) {
				CitizenEntity entity = new CitizenEntity();
				BeanUtils.copyProperties(citizen, entity);
				citizenrepo.save(entity);
				return true;
			}
		}
		return false;
	}
}
