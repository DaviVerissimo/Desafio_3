package com.compass.uol.davi.desafio3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.uol.davi.desafio3.model.Comment;
import com.compass.uol.davi.desafio3.model.Post;
import com.compass.uol.davi.desafio3.service.CommentService;
import com.compass.uol.davi.desafio3.service.PostService;

@RestController
public class PostController {

	private PostService postService;

	private CommentService commentService;

	@Autowired
	public PostController(PostService postService, CommentService commentService) {

		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPost() {
		List<Post> posts = null;
		posts = postService.getAllPost();

		return ResponseEntity.ok(posts); // Define o código de status 200 OK
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostByID(@PathVariable Integer id) {
		Post post = postService.seachPostByID(id);

		return ResponseEntity.ok(post);
	}
	
	@GetMapping("/comments")
	public ResponseEntity<List<Comment>> getAllCommnet() {
		List<Comment> comments = null;
		comments = commentService.getAllComment();

		return ResponseEntity.ok(comments);
	}
	
	@PostMapping("/posts/{postId}")
	public ResponseEntity<Post> processPostByID(@PathVariable Integer postId) {
		Post post = postService.processPostByID(postId);

		return ResponseEntity.ok(post);
	}
}
