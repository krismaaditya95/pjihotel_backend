package com.mini.project.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.TipeKamar;

@Repository
public interface TipeKamarRepository extends JpaRepository<TipeKamar, Integer>{
	
	List<TipeKamar> findByOrderByIdTipeKamar();
	
	TipeKamar findByIdTipeKamarOrderByIdTipeKamar(Integer id);
}
