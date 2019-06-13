package com.mini.project.hotel.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mini.project.hotel.model.Kamar;
import com.mini.project.hotel.model.StatusCheck;
import com.mini.project.hotel.model.StatusKamar;
import com.mini.project.hotel.model.TipeKamar;
import com.mini.project.hotel.model.Transaksi;
import com.mini.project.hotel.services.KamarService;

@RestController
@RequestMapping("/pjihotel/api/v1")
public class KamarRESTController {
	
	@Autowired
	KamarService kamarServ;
	
	// == Kamar ==
	@GetMapping("/getAllKamar")
	public List<Kamar> getAllKamar(){
		return kamarServ.getAllKamar();
	}
	
	@GetMapping("/getAllTipeKamar")
	public List<TipeKamar> getAllTipeKamar(){
		return kamarServ.getAllTipeKamar();
	}
	
	@GetMapping("/getAllStatusKamar")
	public List<StatusKamar> getAllStatusKamar(){
		return kamarServ.getAllStatusKamar();
	}	
	
	@GetMapping("/getKamarById/{id_kamar}")
	public Kamar getKamarById(@PathVariable(value = "id_kamar") Integer id_room)
	throws ResourceNotFoundException{
		return kamarServ.getKamarByIds(id_room);
	}
	
	@GetMapping("/getKamarByIdStatus/{id_status}")
	public List<Kamar> getKamarByIdStatus(@PathVariable(value = "id_status") Integer id_status)
	throws ResourceNotFoundException{
		return kamarServ.getKamarByIdStatus(id_status);
	}
	
	@PostMapping("/addKamar")
	public Kamar addKamar(@Valid @RequestBody String noKamar, int idType, int idStatus){
		return kamarServ.addKamar(noKamar, idType, idStatus);
	}
	
	@PutMapping("/editKamarById/{id_kamar}")
	public String editKamarById(@PathVariable(value = "id_kamar") Integer id_kamar,  @Valid @RequestBody String noKamar, int idType, int idStatus) throws ParseException {
		kamarServ.editKamarById(id_kamar, noKamar, idType, idStatus);
		return "Berhasil update data kamar";
	}
	
	@DeleteMapping("/deleteKamarById/{id_kamar}")
	public String deleteKamarById(@PathVariable(value = "id_kamar") Integer id_kamar) {
		kamarServ.deleteKamarById(id_kamar);
		return "Berhasil hapus data kamar";
	}
}
