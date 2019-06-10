package com.mini.project.hotel.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mini.project.hotel.exception.ResourceNotFoundException;
import com.mini.project.hotel.model.Customer;
import com.mini.project.hotel.model.Transaksi;
import com.mini.project.hotel.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository custRepo;
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = custRepo.findAll();
		return customers;
	}
	
	public Page<Customer> getAllCustomersPageable(Integer halaman, Integer jumlah_records){
		Pageable request = PageRequest.of(halaman, jumlah_records, Sort.by("idCustomer"));
		
		Page<Customer> customers = custRepo.findAll(request);
		return customers;
	}
	
	
	public Customer createCustomer(Integer noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
		Customer customer = new Customer(noIdentitas, namaDepan, namaBelakang, noTelp, email, alamat);
//		Customer customer = new Customer();
//		
//		customer.setNoIdentitas(noIdentitas);
//		customer.setNamaDepan(namaDepan);
//		customer.setNamaBelakang(namaBelakang);
//		customer.setNoTelp(noTelp);
//		customer.setEmail(email);
//		customer.setAlamat(alamat);
		
		Customer noidentitas = custRepo.findByNoIdentitas(noIdentitas);
		
		if(noidentitas.equals(noidentitas.getNoIdentitas())) {
//			no identitas sudah ada
		}
		Customer newCustomer = custRepo.save(customer);
		return newCustomer;
	}
	
	// cari customer berdasarkan Id
	public Customer getCustomerById(Integer idCustomer){
		Customer customer = custRepo.findByIdCustomer(idCustomer);
		return customer;
	}
	
	
	public String editCustomerById(Integer idCustomer, Integer noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
		Customer customer = custRepo.getOne(idCustomer);
		
		customer.setNoIdentitas(noIdentitas);
		customer.setNamaDepan(namaDepan);
		customer.setNamaBelakang(namaBelakang);
		customer.setNoTelp(noTelp);
		customer.setEmail(email);
		customer.setAlamat(alamat);
		
		if(custRepo.save(customer) == null) {
			return "Gagal Update data tamu";
		}
		
		return "Berhasil update data tamu";
	}
	
	public void deleteCustomerById(Integer idCustomer) {
		custRepo.deleteById(idCustomer);
	}
}
