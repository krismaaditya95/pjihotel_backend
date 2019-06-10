package com.mini.project.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCustomer;

	@Column(name = "no_identitas", nullable = false)
	private int noIdentitas;
	
	@Column(name = "nama_depan", nullable = false)
	private String namaDepan;
	
	@Column(name = "nama_belakang", nullable = false)
	private String namaBelakang;
	
	@Column(name = "no_telp", nullable = false)
	private String noTelp;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "alamat", nullable = false)
	private String alamat;
	
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getNoIdentitas() {
		return noIdentitas;
	}

	public void setNoIdentitas(int noIdentitas) {
		this.noIdentitas = noIdentitas;
	}

	public String getNamaDepan() {
		return namaDepan;
	}

	public void setNamaDepan(String namaDepan) {
		this.namaDepan = namaDepan;
	}

	public String getNamaBelakang() {
		return namaBelakang;
	}

	public void setNamaBelakang(String namaBelakang) {
		this.namaBelakang = namaBelakang;
	}

	public String getNoTelp() {
		return noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Customer() {
		
	}
	
	public Customer(int noIdentitas, String namaDepan, String namaBelakang, String noTelp, String email, String alamat) {
		this.noIdentitas = noIdentitas;
		this.namaDepan = namaDepan;
		this.namaBelakang = namaBelakang;
		this.noTelp = noTelp;
		this.email = email;
		this.alamat = alamat;
	}
}
