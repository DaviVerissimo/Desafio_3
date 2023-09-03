package com.compass.uol.davi.desafio3.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<List<Post>> saveAllPost(){
	    List<Post> posts = null;
		posts = postService.getAllPost();
	    return ResponseEntity.ok(posts); // Define o código de status 200 OK
	}
}
