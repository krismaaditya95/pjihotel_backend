package com.mini.project.hotel.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mini.project.hotel.controller.CustomerRESTController;
import com.mini.project.hotel.controller.TransaksiRESTController;
import com.mini.project.hotel.model.Customer;
import com.mini.project.hotel.model.Kamar;
import com.mini.project.hotel.model.StatusCheck;
import com.mini.project.hotel.model.StatusKamar;
import com.mini.project.hotel.model.Transaksi;
import com.mini.project.hotel.repository.CustomerRepository;
import com.mini.project.hotel.repository.KamarRepository;
import com.mini.project.hotel.repository.StatusCheckRepository;
import com.mini.project.hotel.repository.StatusKamarRepository;
import com.mini.project.hotel.repository.TipeKamarRepository;
import com.mini.project.hotel.repository.TransaksiRepository;

@Service
public class TransaksiService {
	
	@Autowired
	TransaksiRepository transaksiRepo;
	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	KamarRepository kamarRepo;
	
//	@Autowired
//	PenggunaRepository userRepo;
	
	@Autowired
	TipeKamarRepository tipeKamarRepo;
	
	@Autowired
	StatusCheckRepository statusCheckRepo;
	
	@Autowired
	StatusKamarRepository statusKamarRepo;
	
	DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat time = new SimpleDateFormat("HH:mm");
	
	public List<Transaksi> getAllTransaksi(){
		List<Transaksi> transaksis = transaksiRepo.findAll();
		return transaksis;
	}
	
	public Transaksi getTransaksiById(int id_transaksi){
		Transaksi transaksi = transaksiRepo.findByIdTransaksi(id_transaksi);
		return transaksi;
	}
	
	public Page<Transaksi> getAllTransaksiPageable(Integer halaman, Integer jumlah_records){
		Pageable request = PageRequest.of(halaman, jumlah_records, Sort.by("idTransaksi"));
		
		Page<Transaksi> transaksi = transaksiRepo.findAll(request);
		return transaksi;
	}
	
	public Transaksi createTransaksi(int idCustomer, int idKamar, String check_in_date, String check_in_time, String check_out_date, String check_out_time, int idStatusCheck) throws ParseException {
		
		Transaksi transaksi = new Transaksi(check_in_date, check_in_time, check_out_date, check_out_time);
		
		Customer customer = custRepo.findByIdCustomer(idCustomer);
		Kamar kamar = kamarRepo.findByIdKamar(idKamar);
		StatusCheck statuscheck = statusCheckRepo.findByIdStatusCheck(idStatusCheck);
		
		StatusKamar tersedia = statusKamarRepo.findByIdStatusKamar(1);
		StatusKamar terpakai = statusKamarRepo.findByIdStatusKamar(2);
		StatusKamar booked = statusKamarRepo.findByIdStatusKamar(3);
		
		int hargaKamar = kamar.getTipeKamar().getHarga();
		
		LocalDate dateB = LocalDate.parse(check_in_date);
		LocalDate dateA = LocalDate.parse(check_out_date);
		long daysBetween = ChronoUnit.DAYS.between(dateB, dateA);
		
		
		int totalHargaKamar = (int) (hargaKamar * daysBetween);
		
		transaksi.setCustomer(customer);
		transaksi.setKamar(kamar);
		transaksi.setStatusCheck(statuscheck);
		transaksi.setTotalHarga(totalHargaKamar);
		
		
		// mengeset status kamar
		// jika check in
		if(idStatusCheck == 1) {
			kamar.setStatusKamar(terpakai);
		}else if (idStatusCheck == 2){
			// jika check out
			kamar.setStatusKamar(tersedia);
		}else if(idStatusCheck == 3) {
			// jika booking
			kamar.setStatusKamar(booked);
		}
		
		kamarRepo.save(kamar);
		return transaksiRepo.save(transaksi);
	}
	
	public String editTransaksiById(int idTransaksi, int idCustomer, int idKamar, String check_in_date, String check_in_time, String check_out_date, String check_out_time, int idStatusCheck) throws ParseException {
		
		Transaksi transaksi = transaksiRepo.getOne(idTransaksi);
		Customer customer = custRepo.findByIdCustomer(idCustomer);
		Kamar kamar = kamarRepo.findByIdKamar(idKamar);
		StatusCheck statuscheck = statusCheckRepo.findByIdStatusCheck(idStatusCheck);
		
		StatusKamar tersedia = statusKamarRepo.findByIdStatusKamar(1);
		StatusKamar terpakai = statusKamarRepo.findByIdStatusKamar(2);
		StatusKamar booked = statusKamarRepo.findByIdStatusKamar(3);
		
		transaksi.setCustomer(customer);
		transaksi.setKamar(kamar);
		transaksi.setStatusCheck(statuscheck);
		
		DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat time_format = new SimpleDateFormat("HH:mm");
		
		Date cid_format_parsed = date_format.parse(check_in_date);
		Date cod_format_parsed = date_format.parse(check_out_date);
		Date cit_format_parsed = time_format.parse(check_in_time);
		Date cot_format_parsed = time_format.parse(check_out_time);
		
		transaksi.setCheckInDate(cid_format_parsed);
		transaksi.setCheckInTime(cit_format_parsed);
		transaksi.setCheckOutDate(cod_format_parsed);
		transaksi.setCheckOutTime(cot_format_parsed);
		transaksi.setIdStatusCheck(idStatusCheck);
		
		LocalDate dateB = LocalDate.parse(check_in_date);
		LocalDate dateA = LocalDate.parse(check_out_date);
		long daysBetween = ChronoUnit.DAYS.between(dateB, dateA);
		
		int hargaKamar = kamar.getTipeKamar().getHarga();
		int totalHargaKamar = (int) (hargaKamar * daysBetween);
		
		transaksi.setTotalHarga(totalHargaKamar);
		
		// mengeset status kamar
		// jika check in
		if(idStatusCheck == 1) {
			kamar.setStatusKamar(terpakai);
		}else if (idStatusCheck == 2){
		// jika check out
			kamar.setStatusKamar(tersedia);
		}else if(idStatusCheck == 3) {
		// jika booking
			kamar.setStatusKamar(booked);
		}
		
		kamarRepo.save(kamar);
		if(transaksiRepo.save(transaksi) == null) {
			return "Gagal Update data transaksi";
		}
		
		return "Berhasil update data transaksi";
	}
	
	public List<StatusCheck> getAllStatusCheck(){
		List<StatusCheck> statusCheck = statusCheckRepo.findAll();
		return statusCheck;
	}
	
	public void deleteTransaksiById(int id_transaksi) {
		transaksiRepo.deleteById(id_transaksi);
	}
	
}
