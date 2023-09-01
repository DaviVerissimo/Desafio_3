package com.compass.uol.davi.desafio3.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Post {
	@Id
	private Number id;
	private String title;	
	private String body;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private List<Comment> comments;
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private List<History> History;

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<History> getHistory() {
		return History;
	}

	public void setHistory(List<History> history) {
		History = history;
	}

}
