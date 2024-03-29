package com.mini.project.hotel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByIdCustomer(Integer id);
	
	Customer findByNoIdentitas(Integer noIdentitas);
	
	Page<Customer> findAll(Pageable pageable);
}
