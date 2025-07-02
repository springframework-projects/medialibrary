package com.jyx.medialibrary.common.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jyx.medialibrary.bookstore.repository.AuthorRepository;
import com.jyx.medialibrary.bookstore.repository.BookRepository;


@Component
public class DBLoader {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
    private final Faker faker = new Faker();

    public DBLoader(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {

            // BOOK CRUD

        };
    }
//
//    private float getRandomPrice(float min, float max) {
//        Random random = new Random();
//        float randomFloat = random.nextFloat();
//        return min + (randomFloat * (max - min));
//    }
}






