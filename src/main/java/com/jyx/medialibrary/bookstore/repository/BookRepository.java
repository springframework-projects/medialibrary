package com.jyx.medialibrary.bookstore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyx.medialibrary.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
