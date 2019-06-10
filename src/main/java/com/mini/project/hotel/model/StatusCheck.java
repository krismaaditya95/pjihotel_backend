package com.mini.project.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_check")
public class StatusCheck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStatusCheck;
	
	@Column(name = "nama_status", nullable = false)
	private String namaStatus;

	public int getIdStatusCheck() {
		return idStatusCheck;
	}

	public void setIdStatusCheck(int idStatusCheck) {
		this.idStatusCheck = idStatusCheck;
	}

	public String getNamaStatus() {
		return namaStatus;
	}

	public void setNamaStatus(String namaStatus) {
		this.namaStatus = namaStatus;
	}
	
	
}
