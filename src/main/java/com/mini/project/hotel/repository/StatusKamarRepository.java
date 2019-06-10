package com.mini.project.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.StatusKamar;

@Repository
public interface StatusKamarRepository extends JpaRepository<StatusKamar, Integer>{
	
	StatusKamar findByIdStatusKamar(Integer id);
}
