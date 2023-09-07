package com.compass.uol.davi.desafio3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.uol.davi.desafio3.exceptions.PostNotFoundException;
import com.compass.uol.davi.desafio3.exceptions.PostProcessedException;
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

		return ResponseEntity.ok(posts);
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostByID(@PathVariable Integer id) {
		Post post = null;
		try {
			post = postService.seachPostByID(id);
		} catch (PostNotFoundException e) {
			System.err.print(e.getMessage());
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

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
		Post post = null;
		try {
			post = postService.processPostByID(postId);
		} catch (PostNotFoundException e) {
			System.err.print(e.getMessage());
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return ResponseEntity.ok(post);
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Post> disablePostByID(@PathVariable Integer id) {
		Post post = null;
		try {
			post = postService.disablePostById(id);
		} catch (PostNotFoundException e) {
			System.err.print(e.getMessage());
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.ok(post);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> reprocessPostByID(@PathVariable Integer id) {
		Post post = null;
		try {
			post = postService.reprocessPostById(id);
		} catch (PostNotFoundException e) {
			System.err.print(e.getMessage());
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.ok(post);
	}
}
