package com.compass.uol.davi.desafio3.model;

import dto.CommentDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	private Integer id;
	@Column(name = "body", length = 500)
	private String body;
	private Integer postId;
	private String name;
	private String email;

	public Comment() {

	}

	public Comment(CommentDTO commentDTO) {
		this.id = commentDTO.id;
		this.body = commentDTO.body;
		this.postId = commentDTO.postId;
		this.name = commentDTO.name;
		this.email = commentDTO.email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
