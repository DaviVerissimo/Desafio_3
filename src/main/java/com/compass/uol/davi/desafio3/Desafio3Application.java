package com.compass.uol.davi.desafio3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.compass.uol.davi.desafio3.model.Post;
import com.compass.uol.davi.desafio3.service.PostService;

@SpringBootApplication
public class Desafio3Application  implements CommandLineRunner{
	
	@Autowired
	private PostService postService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 List<Post> posts = postService.seachAllPostAPI();
		 postService.saveAllPost(posts);
	}

}
