package com.mini.project.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipe_kamar")
public class TipeKamar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipeKamar;
	
	@Column(name = "nama_tipe", nullable = false)
	private String namaTipe;
	
	@Column(name = "harga", nullable = false)
	private int harga;

	public int getIdTipeKamar() {
		return idTipeKamar;
	}

	public void setIdTipeKamar(int idTipeKamar) {
		this.idTipeKamar = idTipeKamar;
	}

	public String getNamaTipe() {
		return namaTipe;
	}

	public void setNamaTipe(String namaTipe) {
		this.namaTipe = namaTipe;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}
}
