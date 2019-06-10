package com.mini.project.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mini.project.hotel.exception.ResourceNotFoundException;
// IMPORT model customer.java dan 
// interface customerrepository
import com.mini.project.hotel.model.Customer;
import com.mini.project.hotel.repository.CustomerRepository;
import com.mini.project.hotel.services.CustomerService;

@RestController
@RequestMapping("/pjihotel/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerRESTController {
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private CustomerService custServ;
	
	@GetMapping("/")
	public String login() {
		return "Halaman awal dari rest controller";
	}
	
//	@GetMapping("/getAllCustomers")
//	public List<Customer> getAllCustomers(){
//		return custServ.getAllCustomers();
//	}
	
//	@GetMapping("/customers")
//	public List<Customer> getAllCustomers(){
//		return custServ.getAllCustomers();
//	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return custRepo.findAll();
	}
	
	@GetMapping("/getAllCustomers/{halaman}/{jumlah_records}")
	public Page<Customer> getAllCustomersPageable(@PathVariable(value="halaman") Integer halaman, @PathVariable(value="jumlah_records") Integer jumlah_records){
		return custServ.getAllCustomersPageable(halaman, jumlah_records);
	}
	
	@GetMapping("/getCustomerById/{id_customer}")
	public Customer getCustomerById(@PathVariable(value = "id_customer") Integer idCustomer)
	throws ResourceNotFoundException{
		return custServ.getCustomerById(idCustomer);
	}
	
//	@PostMapping("/createCustomers")
//	public Customer createCustomers(@Valid @RequestBody Integer noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
//		return custServ.createCustomer(noIdentitas, namaDepan, namaBelakang, noTelp, email, alamat);
//	}
	
//	@PostMapping("/customers")
//	public Customer createCustomers(@Valid @RequestBody Integer noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
//		return custServ.createCustomer(noIdentitas, namaDepan, namaBelakang, noTelp, email, alamat);
//	}
	
	@PostMapping("/customers")
	public void createCustomers(@Valid @RequestBody Customer customer) {
		custRepo.save(customer);
	}
	
	// ---------------------------- PUT / EDIT CUSTOMER ----------------------------
//	@PutMapping("/editCustomer/{id_customer}")
//	public String editCustomer(@PathVariable(value = "id_customer") Integer idCustomer,  @Valid @RequestBody Integer noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
//		custServ.editCustomerById(idCustomer, noIdentitas, namaDepan, namaBelakang, noTelp, email, alamat);
//		return "Berhasil update data customer";
//	}
	
//	@PutMapping("/customers/{id_customer}")
//	public String editCustomer(@PathVariable(value = "id_customer") Integer idCustomer,  @Valid @RequestBody Integer noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
//		custServ.editCustomerById(idCustomer, noIdentitas, namaDepan, namaBelakang, noTelp, email, alamat);
//		return "Berhasil update data customer";
//	}
	
//	@PutMapping("/customers/{id_customer}")
//	public void editCustomer(@PathVariable(value = "id_customer") Integer idCustomer,  @Valid @RequestBody Integer noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
//		custServ.editCustomerById(idCustomer, noIdentitas, namaDepan, namaBelakang, noTelp, email, alamat);
////		return "Berhasil update data customer";
//	}
	
	@PutMapping("/customers/{id_customer}")
	public ResponseEntity<Customer> editCustomerById(@PathVariable(value = "id_customer") Integer id_customer,  @Valid @RequestBody Customer customerEdit) throws ResourceNotFoundException {
		//custServ.editCustomerById(id_customer, noIdentitas, namaDepan, namaBelakang, noTelp, email, alamat);
		Customer customer = custRepo.findById(id_customer).orElseThrow(() -> new ResourceNotFoundException("Customer tidak ditemukan"));
		
		customer.setNoIdentitas(customerEdit.getNoIdentitas());
		customer.setNamaDepan(customerEdit.getNamaDepan());
		customer.setNamaBelakang(customerEdit.getNamaBelakang());
		customer.setNoTelp(customerEdit.getNoTelp());
		customer.setEmail(customerEdit.getEmail());
		customer.setAlamat(customerEdit.getAlamat());
		
		Customer updatedCustomer = custRepo.save(customer);
		
		return ResponseEntity.ok(updatedCustomer);
	}
	
	
	// ---------------------------------- DELETE MAPPING -----------------------------
//	@DeleteMapping("/deleteCustomerById/{id_customer}")
//	public String deleteCustomerById(@PathVariable(value = "id_customer") Integer id_customer) {
//		custServ.deleteCustomerById(id_customer);
//		return "Berhasil hapus";
//	}
	
//	@DeleteMapping("/customers/{id_customer}")
//	public String deleteCustomerById(@PathVariable(value = "id_customer") Integer id_customer) {
//		custServ.deleteCustomerById(id_customer);
//		return "Berhasil hapus";
//	}
	
	// pakai response entity
//	@DeleteMapping("/customers/{id_customer}")
//	public ResponseEntity<String> deleteCustomerById(@PathVariable(value = "id_customer") Integer id_customer) {
////		custServ.deleteCustomerById(id_customer);
//		custRepo.deleteById(id_customer);
//		return new ResponseEntity<>("Tamu sudah dihapus!", HttpStatus.OK);
//	}
	
	// pakai Map/HashMap
	@DeleteMapping("/customers/{id_customer}")
	public Map<String, Boolean> deleteCustomerById(@PathVariable(value = "id_customer") Integer id_customer) throws ResourceNotFoundException {
		Customer customer = custRepo.findById(id_customer).orElseThrow(() -> new ResourceNotFoundException("Tamu tidak ditemukan"));
		custRepo.delete(customer);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Tamu berhasil dihapus", Boolean.TRUE);
		return response;
	}
}
