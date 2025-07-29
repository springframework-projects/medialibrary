package com.jyx.medialibrary.repository;

import com.jyx.medialibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
