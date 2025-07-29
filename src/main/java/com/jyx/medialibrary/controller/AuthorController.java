package com.jyx.medialibrary.controller;

import java.util.List;
import java.util.Optional;

import com.jyx.medialibrary.common.dto.AuthorDTO;
import com.jyx.medialibrary.common.mapper.AuthorMapper;
import com.jyx.medialibrary.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyx.medialibrary.domain.Author;
import com.jyx.medialibrary.repository.AuthorRepository;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/authors/{name}")
    public Author findByName(@PathVariable("name") String name) {
        return service.findByName(name);
    }
}
