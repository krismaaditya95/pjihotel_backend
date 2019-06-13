package com.mini.project.hotel.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.project.hotel.exception.ResourceNotFoundException;
import com.mini.project.hotel.model.Customer;
import com.mini.project.hotel.model.StatusCheck;
import com.mini.project.hotel.model.Transaksi;
import com.mini.project.hotel.model.TransaksiRequest;
import com.mini.project.hotel.repository.CustomerRepository;
import com.mini.project.hotel.repository.KamarRepository;
import com.mini.project.hotel.repository.StatusCheckRepository;
import com.mini.project.hotel.repository.TransaksiRepository;
import com.mini.project.hotel.services.KamarService;
import com.mini.project.hotel.services.TransaksiService;

@RestController
@RequestMapping("/pjihotel/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class TransaksiRESTController {
	
	@Autowired
	private TransaksiRepository transaksiRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private KamarRepository kamarRepo;
	
	@Autowired
	private StatusCheckRepository scRepo;
	
	@Autowired
	private TransaksiService transaksiServ;
	
	@Autowired
	private KamarService kamarServ;
	
	@GetMapping("/getAllTransaksi")
	public List<Transaksi> getAllTransaksi(){
		return transaksiRepo.findAll();
	}
	
	@GetMapping("/getTransaksiById/{id_transaksi}")
	public Transaksi getTransaksiById(@PathVariable(value = "id_transaksi") Integer id_transaksi)
	throws ResourceNotFoundException{
//		return transaksiServ.getTransaksiById(id_transaksi);
		return transaksiRepo.findById(id_transaksi).orElseThrow(() -> new ResourceNotFoundException("Transaksi tidak ditemukan"));
	}
	
	@GetMapping("/getTransaksiByIdStatusCheckIn/{idStatusCheck}")
	public List<Transaksi> getTransaksiByIdStatusCheck(@PathVariable(value = "idStatusCheck") Integer idStatusCheck){
		return transaksiRepo.findByIdStatusCheck(idStatusCheck);
	}
	
//	@GetMapping("/")
	
	// find All dengan pageable
//	@GetMapping("/getAllTransaksi/{halaman}/{jumlah_records}")
//	public Page<Transaksi> getAllTransaksi(@PathVariable(value="halaman") Integer halaman, @PathVariable(value="jumlah_records") Integer jumlah_records){
////		return transaksiServ.getAllTransaksiPageable(halaman, jumlah_records);
//		Pageable request = PageRequest.of(halaman, jumlah_records, Sort.by("idTransaksi"));
//		return transaksiRepo.findAll(request);
//	}
	
	// untuk json
//	@GetMapping("/getAllTransaksi")
//	public String getAllTransaksi(){
//		List<Transaksi> transc = transaksiServ.getAllTransaksi();
//		ObjectMapper mapper = new ObjectMapper();
//		
//		String json = "";
//		
//		try {
//			json = mapper.writeValueAsString(transc);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//			return json;
//		}
	
//	@GetMapping("/getTransaksiById/{id_transaksi}")
//	public ResponseEntity<Transaksi> getTransaksiById(@PathVariable(value = "id_transaksi") int id_transaksi)
//	throws ResourceNotFoundException{
//		Transaksi transc = transaksiRepo.findById(id_transaksi).orElseThrow(() -> new ResourceNotFoundException("Transaksi dengan id transaksi :"+ id_transaksi + " tidak ditemukan"));
//		return ResponseEntity.ok().body(transc);
//	}
	
//	@PostMapping("/createTransaksi")
//	public Transaksi createTransaksi(@Valid @RequestBody int idCustomer, int idKamar, String check_in_date, String check_in_time, String check_out_date, String check_out_time, int idStatusCheck) throws ParseException {
//		return transaksiServ.createTransaksi(idCustomer, idKamar, check_in_date, check_in_time, check_out_date, check_out_time, idStatusCheck);
//	}
	
	@PostMapping("/addTransaksi")
	public void addTransaksi(@Valid @RequestBody TransaksiRequest transaksireq) throws ParseException{
//		Customer customer = cust
		transaksiServ.addTransaksi(transaksireq);
	}
	
//	@PutMapping("/editTransaksiById/{id_transaksi}")
//	public String editTransaksiById(@PathVariable(value = "id_transaksi") Integer id_transaksi,  @Valid @RequestBody int idCustomer, int idKamar, String check_in_date, String check_in_time, String check_out_date, String check_out_time, int idStatusCheck) throws ParseException {
//		//custServ.editCustomerById(id_customer, no_identitas, nama_customer, no_telp, email, alamat);
//		transaksiServ.editTransaksiById(id_transaksi, idCustomer, idKamar, check_in_date, check_in_time, check_out_date, check_out_time, idStatusCheck);
//		return "Berhasil update data transaksi";
//	}
	
	@PutMapping("/editTransaksi/{idTransaksi}")
	public ResponseEntity<Transaksi> editTransaksiById(@PathVariable (value = "idTransaksi") Integer idTransaksi, @Valid @RequestBody TransaksiRequest transaksiedit) throws ResourceNotFoundException{
		Transaksi updatedTransaksi = transaksiServ.editTransaksiById(idTransaksi, transaksiedit);
		
		return ResponseEntity.ok(updatedTransaksi);
	}
	
	@PutMapping("/changeStatusCheckIn/{idTransaksi}")
	public ResponseEntity<Transaksi> changeStatusCheckIn(@PathVariable (value = "idTransaksi") Integer idTransaksi, @Valid @RequestBody TransaksiRequest transaksiedit) throws ResourceNotFoundException{
		Transaksi updatedTransaksi = transaksiServ.changeStatusCheckIn(idTransaksi, transaksiedit);
	
		return ResponseEntity.ok(updatedTransaksi);
	}
	
//	@DeleteMapping("/deleteCustomerById/{id_transaksi}")
//	public String deleteTransaksiById(@PathVariable(value = "id_transaksi") Integer id_transaksi) {
//		transaksiServ.deleteTransaksiById(id_transaksi);
//		
//		return "Berhasil hapus data transaksi";
//	}
	
	@DeleteMapping("/deleteTransaksi/{idTransaksi}")
	public Map<String, Boolean> deleteTransaksiById(@PathVariable(value = "idTransaksi") Integer idTransaksi) {
		transaksiServ.deleteTransaksiById(idTransaksi);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Transaksi berhasil dihapus atau dibatalkan", Boolean.TRUE);
		return response;
	}
	
	// == Status CheckIn/Out
	@GetMapping("/getAllStatusCheck")
	public List<StatusCheck> getAllStatusCheck(){
//		return transaksiServ.getAllStatusCheck();
		return scRepo.findAll();
	}
}
