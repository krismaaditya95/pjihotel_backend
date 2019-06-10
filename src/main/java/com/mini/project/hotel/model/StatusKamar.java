package com.mini.project.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_kamar")
public class StatusKamar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStatusKamar;
	
	@Column(name = "nama_status_kamar", nullable = false)
	private String namaStatusKamar;

	public int getIdStatusKamar() {
		return idStatusKamar;
	}

	public void setIdStatusKamar(int idStatusKamar) {
		this.idStatusKamar = idStatusKamar;
	}

	public String getNamaStatusKamar() {
		return namaStatusKamar;
	}

	public void setNamaStatusKamar(String namaStatusKamar) {
		this.namaStatusKamar = namaStatusKamar;
	}

	
	
	
	
	
}
