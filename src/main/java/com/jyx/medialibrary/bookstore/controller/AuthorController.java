package com.jyx.medialibrary.bookstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyx.medialibrary.bookstore.model.Author;
import com.jyx.medialibrary.bookstore.repository.AuthorRepository;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {

	private final AuthorRepository repository;

	public AuthorController(AuthorRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/authors")
	public List<Author> getAll() {
		return repository.findAll();
	}
}
