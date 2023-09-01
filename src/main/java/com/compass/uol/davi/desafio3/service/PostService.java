package com.compass.uol.davi.desafio3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.uol.davi.desafio3.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {

		this.postRepository = postRepository;
	}

}
