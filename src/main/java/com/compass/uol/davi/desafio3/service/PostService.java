package com.compass.uol.davi.desafio3.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.uol.davi.desafio3.model.Post;
import com.compass.uol.davi.desafio3.repository.PostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostService {

	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {

		this.postRepository = postRepository;
	}

	public List<Post> seachAllPostAPI() throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
				.build();
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		String jsonResponse = response.body();
		// Jackson for deserialize the JSON
		ObjectMapper objectMapper = new ObjectMapper();
		List<Post> posts = objectMapper.readValue(jsonResponse, new TypeReference<List<Post>>() {
		});

		return posts;
	}

	public Post savePost(Post post) {
		postRepository.save(post);
		
		return post;
	}

	public List<Post> saveAllPost(List<Post> posts) {
		for (int i = 0; i < posts.size(); i++) {
			Post post = posts.get(i);
			this.savePost(post);
		}

		return posts;
	}

}
