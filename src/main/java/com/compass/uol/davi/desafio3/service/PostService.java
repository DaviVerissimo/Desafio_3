package com.compass.uol.davi.desafio3.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.uol.davi.desafio3.model.Post;
import com.compass.uol.davi.desafio3.repository.PostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.PostDTO;

@Service
public class PostService {

	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {

		this.postRepository = postRepository;
	}

	public List<PostDTO> seachAllPostAPI() throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
				.build();
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		String jsonResponse = response.body();
		// Jackson for deserialize the JSON
		ObjectMapper objectMapper = new ObjectMapper();
		List<PostDTO> posts = objectMapper.readValue(jsonResponse, new TypeReference<List<PostDTO>>() {
		});

		return posts;
	}

	public List<Post> getAllPost() {
		List<Post> posts = postRepository.findAll();

		return posts;
	}

	public Post savePost(Post post) {
		postRepository.save(post);

		return post;
	}

	public List<PostDTO> saveAllPost(List<PostDTO> posts) {
		for (int i = 0; i < posts.size(); i++) {
			Post post = new Post(posts.get(i));
			// criar historico inicial para o post aqui
			this.savePost(post);
		}

		return posts;
	}

	public Post seachPostByID(Integer id) {
		Post post = null;
		Optional<Post> postAux = postRepository.findById(id);
		if (postAux.isPresent()) {
			post = postAux.get();
		} else {
			// launch exception PostNotFoundException
		}

		return post;
	}

	public Post deletePostByID(Integer id) {
		Post post = this.seachPostByID(id);

		if (!post.equals(null)) {
			postRepository.deleteById(id);
		} else {
			// launch exception PostNotFoundException
		}

		return post;
	}

}
