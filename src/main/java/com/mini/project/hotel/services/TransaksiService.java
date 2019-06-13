package com.mini.project.hotel.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mini.project.hotel.controller.CustomerRESTController;
import com.mini.project.hotel.controller.TransaksiRESTController;
import com.mini.project.hotel.exception.ResourceNotFoundException;
import com.mini.project.hotel.model.Customer;
import com.mini.project.hotel.model.Kamar;
import com.mini.project.hotel.model.StatusCheck;
import com.mini.project.hotel.model.StatusKamar;
import com.mini.project.hotel.model.Transaksi;
import com.mini.project.hotel.model.TransaksiRequest;
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
	
//	DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//	DateFormat time = new SimpleDateFormat("HH:mm");
	
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
	
//	public Transaksi createTransaksi(int idCustomer, int idKamar, String check_in_date, String check_in_time, String check_out_date, String check_out_time, int idStatusCheck) throws ParseException {
//		
//		Transaksi transaksi = new Transaksi(check_in_date, check_in_time, check_out_date, check_out_time);
//		
//		Customer customer = custRepo.findByIdCustomer(idCustomer);
//		Kamar kamar = kamarRepo.findByIdKamar(idKamar);
//		StatusCheck statuscheck = statusCheckRepo.findByIdStatusCheck(idStatusCheck);
//		
//		StatusKamar tersedia = statusKamarRepo.findByIdStatusKamar(1);
//		StatusKamar terpakai = statusKamarRepo.findByIdStatusKamar(2);
//		StatusKamar booked = statusKamarRepo.findByIdStatusKamar(3);
//		
//		int hargaKamar = kamar.getTipeKamar().getHarga();
//		
//		LocalDate dateB = LocalDate.parse(check_in_date);
//		LocalDate dateA = LocalDate.parse(check_out_date);
//		long daysBetween = ChronoUnit.DAYS.between(dateB, dateA);
//		
//		
//		int totalHargaKamar = (int) (hargaKamar * daysBetween);
//		
//		transaksi.setCustomer(customer);
//		transaksi.setKamar(kamar);
//		transaksi.setStatusCheck(statuscheck);
//		transaksi.setTotalHarga(totalHargaKamar);
//		
//		
//		// mengeset status kamar
//		// jika check in
//		if(idStatusCheck == 1) {
//			kamar.setStatusKamar(terpakai);
//		}else if (idStatusCheck == 2){
//			// jika check out
//			kamar.setStatusKamar(tersedia);
//		}else if(idStatusCheck == 3) {
//			// jika booking
//			kamar.setStatusKamar(booked);
//		}
//		
//		kamarRepo.save(kamar);
//		return transaksiRepo.save(transaksi);
//	}
	
	public void addTransaksi(TransaksiRequest transaksireq) throws ParseException {
		
		Transaksi transaksiadd = new Transaksi();
		
		Customer customer = custRepo.findByIdCustomer(transaksireq.getIdCustomer());
		Kamar kamar = kamarRepo.findByIdKamar(transaksireq.getIdKamar());
		StatusCheck statuscheck = statusCheckRepo.findByIdStatusCheck(transaksireq.getIdStatusCheck());
		
		StatusKamar tersedia = statusKamarRepo.findByIdStatusKamar(1);
		StatusKamar terpakai = statusKamarRepo.findByIdStatusKamar(2);
//		StatusKamar booked = statusKamarRepo.findByIdStatusKamar(3);
		
		int hargaKamar = kamar.getTipeKamar().getHarga();
		
		LocalDate dateB = LocalDate.parse(transaksireq.getCheckInDate().toString());
		LocalDate dateA = LocalDate.parse(transaksireq.getCheckOutDate().toString());
		
		
		long daysBetween = ChronoUnit.DAYS.between(dateB, dateA);
		
		int totalHargaKamar = (int) (hargaKamar * daysBetween);
		String kodeTransaksi = "";
		Random rand = new Random();
		
		String[] words = {"A","B","C","D","E","F","G","H","I","J","K",
				"L","M","N","O","P","Q","R","S","T","U","V",
				"W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
//		int kode[] = null;
		
		for(int i=0; i<7; i++) {
			int index = rand.nextInt(words.length);
			kodeTransaksi += words[index];
//			System.out.println(words);
		}
		
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
		
		transaksiadd.setCustomer(customer);
		transaksiadd.setKamar(kamar);
		
		String ci_date_str = transaksireq.getCheckInDate();
		String co_date_str = transaksireq.getCheckOutDate();
		String ci_time_str = transaksireq.getCheckInTime();
		String co_time_str = transaksireq.getCheckOutTime();
		
		Date ci_date = date_format.parse(ci_date_str);
		Date co_date = date_format.parse(co_date_str);
		LocalTime ci_time = LocalTime.parse(ci_time_str);
		LocalTime co_time = LocalTime.parse(co_time_str);
		
		String ci_date_a = date_format.format(ci_date);
		String co_date_a = date_format.format(co_date);
		
		transaksiadd.setCheckInDate(ci_date);
		transaksiadd.setCheckInTime(ci_time);
		transaksiadd.setCheckOutDate(co_date);
		transaksiadd.setCheckOutTime(co_time);
		
		
		transaksiadd.setStatusCheck(statuscheck);
		transaksiadd.setTotalHarga(totalHargaKamar);
		transaksiadd.setKodeTransaksi(kodeTransaksi);
//		transaksiadd.setKodeTransaksi("#AA78A");
		
		int idStatusCheck = transaksireq.getIdStatusCheck();
		// mengeset status kamar
		// jika check in
		if(idStatusCheck == 1) {
			kamar.setStatusKamar(terpakai);
		}else if (idStatusCheck == 2){
			// jika check out
			kamar.setStatusKamar(tersedia);
		}
//		else if(idStatusCheck == 3) {
//			// jika booking
//			kamar.setStatusKamar(booked);
//		}
		
		kamarRepo.save(kamar);
		transaksiRepo.save(transaksiadd);
	}
	
	public Transaksi editTransaksiById(Integer idTransaksi, TransaksiRequest transaksiedit) throws ResourceNotFoundException {
		Transaksi transaksi = transaksiRepo.findById(idTransaksi).orElseThrow(() -> new ResourceNotFoundException("Transaksi tidak ditemukan"));
		
		Customer customer = custRepo.findByIdCustomer(transaksiedit.getIdCustomer());
		Kamar kamar = kamarRepo.findByIdKamar(transaksiedit.getIdKamar());
		StatusCheck statuscheck = statusCheckRepo.findByIdStatusCheck(transaksiedit.getIdStatusCheck());
		
		StatusKamar tersedia = statusKamarRepo.findByIdStatusKamar(1);
		StatusKamar terpakai = statusKamarRepo.findByIdStatusKamar(2);
//		StatusKamar booked = statusKamarRepo.findByIdStatusKamar(3);
		
		int hargaKamar = kamar.getTipeKamar().getHarga();
		
		LocalDate dateB = LocalDate.parse(transaksiedit.getCheckInDate().toString());
		LocalDate dateA = LocalDate.parse(transaksiedit.getCheckOutDate().toString());
		long daysBetween = ChronoUnit.DAYS.between(dateB, dateA);
		
		int totalHargaKamar = (int) (hargaKamar * daysBetween);
		
		transaksiedit.setCustomer(customer);
		transaksiedit.setKamar(kamar);
		transaksiedit.setStatusCheck(statuscheck);
		transaksiedit.setTotalHarga(totalHargaKamar);
		
		int idStatusCheck = transaksiedit.getIdStatusCheck();
		// mengeset status kamar
		// jika check in
		if(idStatusCheck == 1) {
			kamar.setStatusKamar(terpakai);
		}else if (idStatusCheck == 2){
			// jika check out
			kamar.setStatusKamar(tersedia);
		}
//		else if(idStatusCheck == 3) {
//			// jika booking
//			kamar.setStatusKamar(booked);
//		}
		
		kamarRepo.save(kamar);
		return transaksiRepo.save(transaksi);
	}
	
	public Transaksi changeStatusCheckIn(Integer idTransaksi, TransaksiRequest changestatusedit) throws ResourceNotFoundException {
		Transaksi transaksi = transaksiRepo.findById(idTransaksi).orElseThrow(() -> new ResourceNotFoundException("Transaksi tidak ditemukan"));
		
		int idStatusCheck = changestatusedit.getIdStatusCheck();
		Kamar kamar = kamarRepo.findByIdKamar(changestatusedit.getIdKamar());
		StatusCheck statuscheck = statusCheckRepo.findByIdStatusCheck(idStatusCheck);
		
		StatusKamar tersedia = statusKamarRepo.findByIdStatusKamar(1);
		StatusKamar terpakai = statusKamarRepo.findByIdStatusKamar(2);
		
		transaksi.setStatusCheck(statuscheck);
		
		if(idStatusCheck == 1) {
			// kalau check in
			kamar.setStatusKamar(terpakai);
		}else if (idStatusCheck == 2){
			// jika check out
			kamar.setStatusKamar(tersedia);
		}
		kamarRepo.save(kamar);
		return transaksiRepo.save(transaksi);
	}
	
	public List<StatusCheck> getAllStatusCheck(){
		List<StatusCheck> statusCheck = statusCheckRepo.findAll();
		return statusCheck;
	}
	
	public void deleteTransaksiById(int id_transaksi) {
		transaksiRepo.deleteById(id_transaksi);
	}
}
