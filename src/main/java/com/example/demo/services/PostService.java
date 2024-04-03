package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitleContaining(String text) {
		List<Post> obj = repository.searchTitle(text);
		return obj;
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		return repository.fullSearch(text, minDate, new Date(maxDate.getTime() + 24 * 60 * 60 * 1000));
	}
}
