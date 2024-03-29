package com.mini.project.hotel.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.project.hotel.model.Customer;
import com.mini.project.hotel.model.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer>{
	
	Page<Transaksi> findAll(Pageable pageable);
	
	Transaksi findByIdTransaksi(Integer id);
	
	Transaksi findByIdCustomer(Integer id);
	
	Transaksi findByCheckInDate(Date checkInDate);
	
	Transaksi findByIdStatusCheck(Integer id);
}
