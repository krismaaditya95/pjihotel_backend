package com.mini.project.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.Kamar;

@Repository
public interface KamarRepository extends JpaRepository<Kamar, Integer>{
	
	Kamar findByIdKamar(Integer id);
	
	Kamar findByNoKamar(String noKamar);
	
	List<Kamar> findByIdTipeKamar(Integer id);
	
	List<Kamar> findByIdStatusKamar(Integer id);
}
