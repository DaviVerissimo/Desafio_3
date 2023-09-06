package com.compass.uol.davi.desafio3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.compass.uol.davi.desafio3.service.CommentService;
import com.compass.uol.davi.desafio3.service.PostService;

import dto.CommentDTO;
import dto.PostDTO;

@SpringBootApplication
public class Desafio3Application implements CommandLineRunner {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<PostDTO> posts = postService.seachAllPostAPI();
		postService.saveAllPost(posts);
		List<CommentDTO> comments = commentService.seachAllCommentAPI();
		commentService.saveAllComments(comments);
	}

}
