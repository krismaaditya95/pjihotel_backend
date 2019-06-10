package com.mini.project.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.Pengguna;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Integer>{
	
	Pengguna findByUserName(String username);
	
	Pengguna findByUserId(Integer id);
	
	Pengguna findByUserNameAndUserPass(String username, String userpass);
	
}
