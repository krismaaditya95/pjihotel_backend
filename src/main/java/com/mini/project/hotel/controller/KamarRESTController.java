package com.mini.project.hotel.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mini.project.hotel.exception.ResourceNotFoundException;
import com.mini.project.hotel.model.Kamar;
import com.mini.project.hotel.model.StatusKamar;
import com.mini.project.hotel.model.TipeKamar;
import com.mini.project.hotel.repository.KamarRepository;
import com.mini.project.hotel.repository.StatusKamarRepository;
import com.mini.project.hotel.repository.TipeKamarRepository;
import com.mini.project.hotel.services.KamarService;

@RestController
@RequestMapping("/pjihotel/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class KamarRESTController {
	
	@Autowired
	private KamarRepository kamarRepo;
	
	@Autowired
	private TipeKamarRepository tipekamarRepo;
	
	@Autowired
	private StatusKamarRepository statuskamarRepo;
	
	@Autowired
	KamarService kamarServ;
	
	// == Kamar ==
	@GetMapping("/getAllKamar")
	public List<Kamar> getAllKamar(){
//		return kamarRepo.findAll();
		return kamarRepo.findByOrderByIdKamar();
	}
	
	@GetMapping("/getKamarById/{id_kamar}")
	public Kamar getKamarById(@PathVariable(value = "id_kamar") Integer id_kamar)
	throws ResourceNotFoundException{
//		return kamarServ.getKamarByIds(id_kamar);
		return kamarRepo.findById(id_kamar).orElseThrow(() -> new ResourceNotFoundException("Kamar tidak ditemukan"));
	}
	
	@GetMapping("/getKamarByIdStatus/{id_status}")
	public List<Kamar> getKamarByIdStatus(@PathVariable(value = "id_status") Integer id_status)
	throws ResourceNotFoundException{
//		return kamarServ.getKamarByIdStatus(id_status);
		return kamarRepo.findByIdStatusKamar(id_status);
	}
	
//	@PostMapping("/addKamar")
//	public Kamar addKamar(@Valid @RequestBody String noKamar, int idType, int idStatus){
//		return kamarServ.addKamar(noKamar, idType, idStatus);
//	}
	
	@PostMapping("/addKamar")
	public void addTipeKamar(@Valid @RequestBody Kamar kamar) throws ResourceNotFoundException {
		TipeKamar tipekamar = tipekamarRepo.findById(kamar.getIdTipeKamar()).orElseThrow(() -> new ResourceNotFoundException("Tipe kamar tidak ditemukan"));
		StatusKamar statuskamar = statuskamarRepo.findById(kamar.getIdStatusKamar()).orElseThrow(() -> new ResourceNotFoundException("Status kamar tidak ditemukan"));
		
		kamar.setTipeKamar(tipekamar);
		kamar.setStatusKamar(statuskamar);
		
		kamarRepo.save(kamar);
	}
	
//	@PutMapping("/editKamarById/{id_kamar}")
//	public String editKamarById(@PathVariable(value = "id_kamar") Integer id_kamar,  @Valid @RequestBody String noKamar, int idType, int idStatus) throws ParseException {
//		kamarServ.editKamarById(id_kamar, noKamar, idType, idStatus);
//		return "Berhasil update data kamar";
//	}
	
	@PutMapping("/editKamar/{idKamar}")
	public ResponseEntity<Kamar> editKamarById(@PathVariable(value="idKamar") Integer idKamar, @Valid @RequestBody Kamar kamaredit) throws ResourceNotFoundException{
		Kamar kamar = kamarRepo.findById(idKamar).orElseThrow(() ->new ResourceNotFoundException("Kamar tidak ditemukan"));
		
		TipeKamar tipekamar = tipekamarRepo.findById(kamaredit.getIdTipeKamar()).orElseThrow(() -> new ResourceNotFoundException("Tipe kamar tidak ditemukan"));
		StatusKamar statuskamar = statuskamarRepo.findById(kamaredit.getIdStatusKamar()).orElseThrow(() -> new ResourceNotFoundException("Status kamar tidak ditemukan"));
		
		kamar.setNoKamar(kamaredit.getNoKamar());
		kamar.setTipeKamar(tipekamar);
		kamar.setStatusKamar(statuskamar);
		
		Kamar updatedKamar = kamarRepo.save(kamar);
		
		return ResponseEntity.ok(updatedKamar);
	}
	
//	@DeleteMapping("/deleteKamarById/{id_kamar}")
//	public String deleteKamarById(@PathVariable(value = "id_kamar") Integer id_kamar) {
//		kamarServ.deleteKamarById(id_kamar);
//		return "Berhasil hapus data kamar";
//	}
	
	@DeleteMapping("/deleteKamar/{idKamar}")
	public Map<String, Boolean> deleteKamarById(@PathVariable(value = "idKamar") Integer idKamar) throws ResourceNotFoundException{
		Kamar kamar = kamarRepo.findById(idKamar).orElseThrow(() -> new ResourceNotFoundException("Tipe kamar tidak ditemukan"));
		
		kamarRepo.delete(kamar);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Kamar berhasil dihapus", Boolean.TRUE);
		return response;
	}
	
	// -- Tipe Kamar -------------
	@GetMapping("/getAllTipeKamar")
	public List<TipeKamar> getAllTipeKamar(){
//		return tipekamarRepo.findAll();
		return tipekamarRepo.findByOrderByIdTipeKamar();
	}
	
	@GetMapping("/getTipeKamarById/{id_tipe_kamar}")
	public TipeKamar getTipeKamarById(@PathVariable(value = "id_tipe_kamar") Integer id_tipe_kamar)
	throws ResourceNotFoundException{
//		return tipekamarRepo.findByIdTipeKamar(id_tipe_kamar);
		return tipekamarRepo.findById(id_tipe_kamar).orElseThrow(() -> new ResourceNotFoundException("Tipe kamar tidak ditemukan"));
	}
	
	@PostMapping("/addTipeKamar")
	public void addTipeKamar(@Valid @RequestBody TipeKamar tipekamar) {
		tipekamarRepo.save(tipekamar);
	}
	
	@PutMapping("/editTipeKamar/{idTipeKamar}")
	public ResponseEntity<TipeKamar> editTipeKamarById(@PathVariable(value="idTipeKamar") Integer idTipeKamar, @Valid @RequestBody TipeKamar edittipekamar) throws ResourceNotFoundException{
		TipeKamar tipekamar = tipekamarRepo.findById(idTipeKamar).orElseThrow(() ->new ResourceNotFoundException("Tipe Kamar tidak ditemukan"));
		
		tipekamar.setNamaTipe(edittipekamar.getNamaTipe());
		tipekamar.setHarga(edittipekamar.getHarga());
		
		TipeKamar updatedTipeKamar = tipekamarRepo.save(tipekamar);
		
		return ResponseEntity.ok(updatedTipeKamar);
	}
	
	@DeleteMapping("/deleteTipeKamar/{idTipeKamar}")
	public Map<String, Boolean> deleteTipeKamarById(@PathVariable(value = "idTipeKamar") Integer idTipeKamar) throws ResourceNotFoundException{
		TipeKamar tipekamar = tipekamarRepo.findById(idTipeKamar).orElseThrow(() -> new ResourceNotFoundException("Tipe kamar tidak ditemukan"));
		
		tipekamarRepo.delete(tipekamar);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Tipe Kamar berhasil dihapus", Boolean.TRUE);
		return response;
	}
	
	// -- Status Kamar ---
	
	@GetMapping("/getAllStatusKamar")
	public List<StatusKamar> getAllStatusKamar(){
		return statuskamarRepo.findAll();
	}
	
	@GetMapping("/getStatusKamarById/{id_status_kamar}")
	public StatusKamar getStatusKamarById(@PathVariable(value = "id_status_kamar") Integer id_status_kamar)
	throws ResourceNotFoundException{
//		return tipekamarRepo.findByIdTipeKamar(id_tipe_kamar);
		return statuskamarRepo.findById(id_status_kamar).orElseThrow(() -> new ResourceNotFoundException("Tipe kamar tidak ditemukan"));
	}
	
//	@PostMapping("/addTipeKamar")
//	public void addTipeKamar(@Valid @RequestBody TipeKamar tipekamar) {
//		tipekamarRepo.save(tipekamar);
//	}
//	
//	@PutMapping("/editTipeKamar/{idTipeKamar}")
//	public ResponseEntity<TipeKamar> editTipeKamarById(@PathVariable(value="idTipeKamar") Integer idTipeKamar, @Valid @RequestBody TipeKamar edittipekamar) throws ResourceNotFoundException{
//		TipeKamar tipekamar = tipekamarRepo.findById(idTipeKamar).orElseThrow(() ->new ResourceNotFoundException("Tipe Kamar tidak ditemukan"));
//		
//		tipekamar.setNamaTipe(edittipekamar.getNamaTipe());
//		tipekamar.setHarga(edittipekamar.getHarga());
//		
//		TipeKamar updatedTipeKamar = tipekamarRepo.save(tipekamar);
//		
//		return ResponseEntity.ok(updatedTipeKamar);
//	}
//	
//	@DeleteMapping("/deleteTipeKamar/{idTipeKamar}")
//	public Map<String, Boolean> deleteTipeKamarById(@PathVariable(value = "idTipeKamar") Integer idTipeKamar) throws ResourceNotFoundException{
//		TipeKamar tipekamar = tipekamarRepo.findById(idTipeKamar).orElseThrow(() -> new ResourceNotFoundException("Tipe kamar tidak ditemukan"));
//		
//		tipekamarRepo.delete(tipekamar);
//		
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("Tipe Kamar berhasil dihapus", Boolean.TRUE);
//		return response;
//	}
	
	
}
