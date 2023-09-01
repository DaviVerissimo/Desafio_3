package com.compass.uol.davi.desafio3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {
	
	@Id
	private Number id;	
	private String body;
	
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
