package com.compass.uol.davi.desafio3.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "history")
public class History {

	@Id
	private Integer id;
	private LocalDate date;
	private String status;
	private Integer idPost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}

	public History() {

	}

	public History(Integer idPost, LocalDate date, String status) {
		this.idPost = idPost;
		this.date = date;
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
