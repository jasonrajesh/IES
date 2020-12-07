package com.example.demo.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.admin.entity.WorkerEntity;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Integer>{

	public WorkerEntity findByEmail(String email);
	
	
}
