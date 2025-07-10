package com.jyx.medialibrary.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyx.medialibrary.domain.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
