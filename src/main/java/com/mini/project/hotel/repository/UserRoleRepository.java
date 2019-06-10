package com.mini.project.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	
}
