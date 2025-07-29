package com.jyx.medialibrary.service;

import com.jyx.medialibrary.common.dto.AuthorDTO;
import com.jyx.medialibrary.common.exceptions.ResourceNotFoundException;
import com.jyx.medialibrary.common.mapper.AuthorMapper;
import com.jyx.medialibrary.domain.Author;
import com.jyx.medialibrary.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorDTO> getAll() {
        return repository.findAll().stream()
                .map(AuthorMapper.INSTANCE::authorToAuthorDTO)
                .toList();
    }

    public Author findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new
                ResourceNotFoundException("User with name" + name + " not found"));
    }
}
