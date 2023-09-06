package com.compass.uol.davi.desafio3.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.uol.davi.desafio3.model.Comment;
import com.compass.uol.davi.desafio3.model.History;
import com.compass.uol.davi.desafio3.model.Post;
import com.compass.uol.davi.desafio3.model.State;
import com.compass.uol.davi.desafio3.repository.PostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.PostDTO;

@Service
public class PostService {

	private PostRepository postRepository;

	private HistoryService historyService;

	private CommentService commentService;

	@Autowired
	public PostService(PostRepository postRepository, HistoryService historyService, CommentService commentService) {

		this.postRepository = postRepository;
		this.historyService = historyService;
		this.commentService = commentService;
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

	public Post processPostByID(Integer postId) {
		
		Post post = this.seachPostByID(postId);
		if (post.isProcessed()) {
			// launch postProcessedException
		}
		
		//CRIANDO	
		
		History history = historyService.saveHistory(postId, State.CREATED);
		List<History> list = new ArrayList<>();
		list.add(history);
		post.setHistory(list);
		this.savePost(post);
		
		//	post_find
		
		history = historyService.saveHistory(postId, State.POST_FIND);
		list.add(history);
		post.setHistory(list);
		this.savePost(post);
		
		// post_ok
		
		history = historyService.saveHistory(postId, State.POST_OK);
		list.add(history);
		post.setHistory(list);
		this.savePost(post);
		
		// comment_find
		
		history = historyService.saveHistory(postId, State.COMMENTS_FIND);
		list.add(history);
		post.setHistory(list);
		this.savePost(post);
		List<Comment> listComment = commentService.getCommentOfPost(postId);
		post.setComments(listComment);
		
		// comment_ok
		
		history = historyService.saveHistory(postId, State.COMMENTS_OK);
		list.add(history);
		post.setHistory(list);
		this.savePost(post);
		
		// enabled
		
		history = historyService.saveHistory(postId, State.ENABLED);
		list.add(history);
		post.setHistory(list);
		post.setProcessed(true);
		this.savePost(post);
		
		return post;
	}

}
