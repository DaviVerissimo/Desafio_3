package com.compass.uol.davi.desafio3.model;

import java.util.List;

import dto.PostDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	@Id
	private Integer id;
	private Integer userId;
	private String title;
	@Column(name = "body", length = 500)
	private String body;
	private boolean processed;
	private boolean reprocessed;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Comment> comments;
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<History> history;

	public Integer getId() {
		return id;
	}

	public Post() {

	}

	public Post(PostDTO postDTO) {
		this.id = postDTO.id;
		this.userId = postDTO.userId;
		this.title = postDTO.title;
		this.body = postDTO.body;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public boolean isReprocessed() {
		return reprocessed;
	}

	public void setReprocessed(boolean reprocessed) {
		this.reprocessed = reprocessed;
	}

}
