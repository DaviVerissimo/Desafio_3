package com.compass.uol.davi.desafio3.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.uol.davi.desafio3.model.Comment;
import com.compass.uol.davi.desafio3.repository.CommentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.CommentDTO;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository) {
		
		this.commentRepository = commentRepository;
	}
	
	public List<CommentDTO> seachAllCommentAPI() throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/comments"))
				.build();
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		String jsonResponse = response.body();
		ObjectMapper objectMapper = new ObjectMapper();
		List<CommentDTO> comments = objectMapper.readValue(jsonResponse, new TypeReference<List<CommentDTO>>() {
		});

		return comments;
	}
	
	public List<CommentDTO> saveAllComments(List<CommentDTO> comments) {
		for (int i = 0; i < comments.size(); i++) {
			Comment comment = new Comment(comments.get(i));
			this.saveComment(comment);
		}

		return comments;
	}

	public Comment saveComment(Comment comment) {
		
		return commentRepository.save(comment);
		
	}

	public List<Comment> getAllComment() {
		
		return commentRepository.findAll();
	}
	
	public List<Comment> getCommentOfPost(Integer postId) {
		
		return commentRepository.findByPostId(postId);
	}

}
