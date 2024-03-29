package com.mini.project.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.StatusCheck;

@Repository
public interface StatusCheckRepository extends JpaRepository<StatusCheck, Integer>{
	
	StatusCheck findByIdStatusCheck(Integer id);
}
