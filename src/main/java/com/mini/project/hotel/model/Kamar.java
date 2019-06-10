package com.mini.project.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "kamar")
public class Kamar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idKamar;
	
	@Column(name = "no_kamar", nullable = false)
	private String noKamar;
	
	@Column(nullable = false, insertable = false, updatable = false)
	private int idTipeKamar;
	
	@Column(nullable = false, insertable = false, updatable = false)
	private int idStatusKamar;
	
	// -- Foreign Key Id tipe kamar ----------
	@ManyToOne
	@JoinColumn(name = "idTipeKamar", nullable = false)
	private TipeKamar tipeKamar;

	public TipeKamar getTipeKamar() {
		return tipeKamar;
	}

	public void setTipeKamar(TipeKamar tipeKamar) {
		this.tipeKamar = tipeKamar;
	}
	// ---------------------------------------
	
	// -- Foreign Key Id Status Kamar --------
	@ManyToOne
	@JoinColumn(name = "idStatusKamar", nullable = false)
	private StatusKamar statusKamar;
	
	public StatusKamar getStatusKamar() {
		return statusKamar;
	}

	public void setStatusKamar(StatusKamar statusKamar) {
		this.statusKamar = statusKamar;
	}
	// ----------------------------------------
	
	public Kamar() {
		
	}
	
	public Kamar(String noKamar) {
		this.noKamar = noKamar;
	}

	public Integer getIdKamar() {
		return idKamar;
	}

	public void setIdKamar(Integer idKamar) {
		this.idKamar = idKamar;
	}

	public String getNoKamar() {
		return noKamar;
	}

	public void setNoKamar(String noKamar) {
		this.noKamar = noKamar;
	}

	public int getIdTipeKamar() {
		return idTipeKamar;
	}

	public void setIdTipeKamar(int idTipeKamar) {
		this.idTipeKamar = idTipeKamar;
	}

	public int getIdStatusKamar() {
		return idStatusKamar;
	}

	public void setIdStatusKamar(int idStatusKamar) {
		this.idStatusKamar = idStatusKamar;
	}
}
