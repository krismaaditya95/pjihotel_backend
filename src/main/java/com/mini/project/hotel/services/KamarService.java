package com.mini.project.hotel.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.project.hotel.model.Customer;
import com.mini.project.hotel.model.Kamar;
import com.mini.project.hotel.model.StatusCheck;
import com.mini.project.hotel.model.StatusKamar;
import com.mini.project.hotel.model.TipeKamar;
import com.mini.project.hotel.model.Transaksi;
import com.mini.project.hotel.repository.KamarRepository;
import com.mini.project.hotel.repository.StatusKamarRepository;
import com.mini.project.hotel.repository.TipeKamarRepository;

@Service
public class KamarService {
	
	@Autowired
	KamarRepository kamarRepo;
	
	@Autowired
	TipeKamarRepository tipeKamarRepo;
	
	@Autowired
	StatusKamarRepository statusKamarRepo;
	
	// -- Kamar --------------------------------------------
	public List<Kamar> getAllKamar(){
		List<Kamar> kamar = kamarRepo.findAll();
		return kamar;
	}
	
	public Kamar getKamarByIds(int id_room){
		Kamar kamar = kamarRepo.findByIdKamar(id_room);
		return kamar;
	}
	
	public List<Kamar> getKamarByIdStatus(int id_status) {
		List<Kamar> kamar = kamarRepo.findByIdStatusKamar(id_status);
		return kamar;
	}
	
	public Kamar addKamar(String noKamar, int idTipeKamar, int idStatusKamar){
		Kamar kamar = new Kamar(noKamar);
		TipeKamar tipeKamar = tipeKamarRepo.findByIdTipeKamar(idTipeKamar);
		StatusKamar statusKamar = statusKamarRepo.findByIdStatusKamar(idStatusKamar);
		
		kamar.setTipeKamar(tipeKamar);
		kamar.setStatusKamar(statusKamar);
		
		return kamarRepo.save(kamar);
	}
	
	public String editKamarById(int idKamar, String noKamar, int idTipeKamar, int idStatusKamar) throws ParseException {

		Kamar kamar = kamarRepo.findByIdKamar(idKamar);
		TipeKamar tipeKamar = tipeKamarRepo.findByIdTipeKamar(idTipeKamar);
		StatusKamar statusKamar = statusKamarRepo.findByIdStatusKamar(idStatusKamar);
		
		kamar.setNoKamar(noKamar);
		kamar.setTipeKamar(tipeKamar);
		kamar.setStatusKamar(statusKamar);
		
		if(kamarRepo.save(kamar) == null) {
			return "Gagal Update data kamar";
		}
		return "Berhasil update data kamar";
	}
	
	public void deleteKamarById(int idKamar) {
		kamarRepo.deleteById(idKamar);
	}
	
	// ------------------------------------------------------
	
	// -- Tipe Kamar ----------------------------------------
	public List<TipeKamar> getAllTipeKamar(){
		List<TipeKamar> tipekamar = tipeKamarRepo.findAll();
		return tipekamar;
	}
	// ------------------------------------------------------
	
	// -- Status Kamar --------------------------------------
	public List<StatusKamar> getAllStatusKamar(){
		List<StatusKamar> statuskamar = statusKamarRepo.findAll();
		return statuskamar;
	}
	// ------------------------------------------------------
}
