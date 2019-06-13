package com.mini.project.hotel.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;


public class TransaksiRequest{
	// -- Primary Key --------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTransaksi;
	
	public Integer getIdTransaksi() {
		return idTransaksi;
	}

	public void setIdTransaksi(Integer idTransaksi) {
		this.idTransaksi = idTransaksi;
	}
	// -----------------------------------------
	
	// -- Foreign Key id_customer --------------
	@Column(nullable = false, insertable = false, updatable = false)
	private int idCustomer;
	
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	@ManyToOne
	@JoinColumn(name = "idCustomer", nullable = false)
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	// -----------------------------------------
	
	// -- Foreign Key id_kamar -----------------
	@Column(nullable = false, insertable = false, updatable = false)
	private int idKamar;
	
	public int getIdKamar() {
		return idKamar;
	}
	public void setIdKamar(int idKamar) {
		this.idKamar = idKamar;
	}
	
	@ManyToOne
	@JoinColumn(name = "idKamar", nullable = false)
	private Kamar kamar;
	
	public Kamar getKamar() {
		return kamar;
	}
	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}
	// -----------------------------------------

	// -- Check In Date ------------------------
	@Column(name = "check_in_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate checkInDate;
//	
//	public LocalDate getCheckInDate() {
//		return checkInDate;
//	}
//
//	public void setCheckInDate(LocalDate checkInDate) {
//		this.checkInDate = checkInDate;
//	}
	
//	private Date checkInDate;
//	
//	public Date getCheckInDate() {
//		return checkInDate;
//	}
//
//	public void setCheckInDate(Date checkInDate) {
//		this.checkInDate = checkInDate;
//	}
	
	private String checkInDate;
	
	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	// -- Check In Time ------------------------
	@Column(name = "check_in_time", nullable = false)
	private String checkInTime;
	
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
//	private LocalTime checkInTime;
//	
//	public LocalTime getCheckInTime() {
//		return checkInTime;
//	}
//	public void setCheckInTime(LocalTime checkInTime) {
//		this.checkInTime = checkInTime;
//	}

//	private Date checkInTime;
//	
//	public Date getCheckInTime() {
//		return checkInTime;
//	}
//	public void setCheckInTime(Date checkInTime) {
//		this.checkInTime = checkInTime;
//	}
	
	// -- Check Out Date ------------------------
	@Column(name = "check_out_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate checkOutDate;
//	
//	public LocalDate getCheckOutDate() {
//		return checkOutDate;
//	}
//	public void setCheckOutDate(LocalDate checkOutDate) {
//		this.checkOutDate = checkOutDate;
//	}
	
//	private Date checkOutDate;
//	
//	public Date getCheckOutDate() {
//		return checkOutDate;
//	}
//	public void setCheckOutDate(Date checkOutDate) {
//		this.checkOutDate = checkOutDate;
//	}
	
	private String checkOutDate;
	
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	// -- Check Out Time ------------------------
	@Column(name = "check_out_time", nullable = false)
	private String checkOutTime;
	
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
//	private LocalTime checkOutTime;
//	
//	public LocalTime getCheckOutTime() {
//		return checkOutTime;
//	}
//	public void setCheckOutTime(LocalTime checkOutTime) {
//		this.checkOutTime = checkOutTime;
//	}
//	private Date checkOutTime;
//	
//	public Date getCheckOutTime() {
//		return checkOutTime;
//	}
//	public void setCheckOutTime(Date checkOutTime) {
//		this.checkOutTime = checkOutTime;
//	}
	
	// -- Foreign Key id_status_check -----------------
	@Column(nullable = false, insertable = false, updatable = false)
	private int idStatusCheck;
	
	public int getIdStatusCheck() {
		return idStatusCheck;
	}
	public void setIdStatusCheck(int idStatusCheck) {
		this.idStatusCheck = idStatusCheck;
	}
	
	@ManyToOne
	@JoinColumn(name = "idStatusCheck", nullable = false)
	private StatusCheck statusCheck;
	
	public StatusCheck getStatusCheck() {
		return statusCheck;
	}

	public void setStatusCheck(StatusCheck statusCheck) {
		this.statusCheck = statusCheck;
	}
	// -----------------------------------------------

	
	// -- Total Harga --------------------------------
	@Column(name = "total_harga", nullable = false)
	private int totalHarga;
	
	public int getTotalHarga() {
		return totalHarga;
	}

	public void setTotalHarga(int totalHarga) {
		this.totalHarga = totalHarga;
	}
	
	@Column(name = "kode_transaksi", nullable = false)
	private String kodeTransaksi;
	
	public String getKodeTransaksi() {
		return kodeTransaksi;
	}

	public void setKodeTransaksi(String kodeTransaksi) {
		this.kodeTransaksi = kodeTransaksi;
	}

	// -- Constructors -------------------------
	public TransaksiRequest() {
		
	}
	
	// tanpa total harga
	public TransaksiRequest(String check_in_date, String check_in_time, String check_out_date, String check_out_time) throws ParseException {
		
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
		
		Date cid_format_parsed = date_format.parse(check_in_date);
		Date cod_format_parsed = date_format.parse(check_out_date);
		Date cit_format_parsed = time_format.parse(check_in_time);
		Date cot_format_parsed = time_format.parse(check_out_time);
		
//		this.checkInDate = cid_format_parsed;
//		this.checkInTime = cit_format_parsed;
//		this.checkOutDate = cod_format_parsed;
//		this.checkOutTime = cot_format_parsed;
	}
}
