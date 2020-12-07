package com.example.demo.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.admin.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Integer> {

}
