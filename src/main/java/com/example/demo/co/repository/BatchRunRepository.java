package com.example.demo.co.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.co.entity.BatchRunDtlsEntity;

public interface BatchRunRepository extends JpaRepository<BatchRunDtlsEntity, Integer> {

}
