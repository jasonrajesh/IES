package com.example.demo.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ar.entity.CitizenEntity;

public interface CitizenRepository extends JpaRepository<CitizenEntity, Integer>{

}
