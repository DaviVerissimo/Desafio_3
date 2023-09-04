package com.compass.uol.davi.desafio3.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.compass.uol.davi.desafio3.model.Post;
import com.compass.uol.davi.desafio3.service.PostService;

@RestController
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {

		this.postService = postService;
	}

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> saveAllPost() {
		List<Post> posts = null;
		posts = postService.getAllPost();

		return ResponseEntity.ok(posts); // Define o código de status 200 OK
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostByID(@PathVariable Integer id) {
		Post post = postService.seachPostByID(id);

		return ResponseEntity.ok(post);
	}
}
