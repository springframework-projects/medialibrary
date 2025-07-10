package com.jyx.medialibrary.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyx.medialibrary.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

}
