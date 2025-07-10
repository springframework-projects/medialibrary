package com.jyx.medialibrary.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyx.medialibrary.domain.Author;
import com.jyx.medialibrary.repository.AuthorRepository;

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
