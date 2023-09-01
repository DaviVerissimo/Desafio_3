package com.compass.uol.davi.desafio3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.compass.uol.davi.desafio3.service.PostService;

@RestController
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		
		this.postService = postService;
	}

}
