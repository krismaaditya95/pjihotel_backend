package com.mini.project.hotel.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
import com.mini.project.hotel.repository.TransaksiRepository;
import com.mini.project.hotel.services.KamarService;
import com.mini.project.hotel.services.TransaksiService;

@RestController
@RequestMapping("/pjihotel/api/v1")
public class TransaksiRESTController {
	
	@Autowired
	private TransaksiRepository transaksiRepo;
	
	@Autowired
	private TransaksiService transaksiServ;
	
	@Autowired
	private KamarService kamarServ;
	
	// untuk jsp
	@GetMapping("/getAllTransaksi")
	public List<Transaksi> getAllTransaksi(){
		
		List<Transaksi> trx = transaksiServ.getAllTransaksi();
		return trx;
	}
	
	@GetMapping("/getAllTransaksi/{halaman}/{jumlah_records}")
	public Page<Transaksi> getAllTransaksiPageable(@PathVariable(value="halaman") Integer halaman, @PathVariable(value="jumlah_records") Integer jumlah_records){
		return transaksiServ.getAllTransaksiPageable(halaman, jumlah_records);
	}
	
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
	
	@PostMapping("/createTransaksi")
	public Transaksi createTransaksi(@Valid @RequestBody int idCustomer, int idKamar, String check_in_date, String check_in_time, String check_out_date, String check_out_time, int idStatusCheck) throws ParseException {
		return transaksiServ.createTransaksi(idCustomer, idKamar, check_in_date, check_in_time, check_out_date, check_out_time, idStatusCheck);
	}
	
	@GetMapping("/getTransaksiById/{id_transaksi}")
	public Transaksi getTransaksiById(@PathVariable(value = "id_transaksi") Integer id_transaksi)
	throws ResourceNotFoundException{
		return transaksiServ.getTransaksiById(id_transaksi);
	}
	
	@PutMapping("/editTransaksiById/{id_transaksi}")
	public String editTransaksiById(@PathVariable(value = "id_transaksi") Integer id_transaksi,  @Valid @RequestBody int idCustomer, int idKamar, String check_in_date, String check_in_time, String check_out_date, String check_out_time, int idStatusCheck) throws ParseException {
		//custServ.editCustomerById(id_customer, no_identitas, nama_customer, no_telp, email, alamat);
		transaksiServ.editTransaksiById(id_transaksi, idCustomer, idKamar, check_in_date, check_in_time, check_out_date, check_out_time, idStatusCheck);
		return "Berhasil update data transaksi";
	}
	
	// == Status CheckIn/Out
	@GetMapping("/getAllStatusCheck")
	public List<StatusCheck> getAllStatusCheck(){
		return transaksiServ.getAllStatusCheck();
	}
	
	@DeleteMapping("/deleteCustomerById/{id_transaksi}")
	public String deleteTransaksiById(@PathVariable(value = "id_transaksi") Integer id_transaksi) {
		transaksiServ.deleteTransaksiById(id_transaksi);
		
		return "Berhasil hapus data transaksi";
	}
}
