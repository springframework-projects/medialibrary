package com.jyx.medialibrary.config;

import java.time.LocalDate;
import java.util.*;
import java.time.*;
import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;
import com.jyx.medialibrary.domain.Author;
import com.jyx.medialibrary.domain.Book;
import com.jyx.medialibrary.domain.BookGenre;
import com.jyx.medialibrary.repository.AuthorRepository;
import com.jyx.medialibrary.repository.BookRepository;
import com.jyx.medialibrary.repository.PriceRepository;
import com.jyx.medialibrary.domain.MediaItemCategory;
import com.jyx.medialibrary.domain.Price;

@Configuration
public class DBLoader {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PriceRepository priceRepository; // Add this

    private final Faker faker = new Faker();

    public DBLoader(BookRepository bookRepository, AuthorRepository authorRepository, PriceRepository priceRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.priceRepository = priceRepository;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
            // Create authors
            List<Author> authors = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Author author = new Author();
                author.setName(faker.name().fullName());
                LocalDate birthDate = LocalDate.of(
                        faker.number().numberBetween(1940, 1990),
                        faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1, 28));
                author.setBirthDate(birthDate);
                authors.add(author);
            }
            authorRepository.saveAll(authors);

            // Save prices first
            List<Price> prices = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Price price = new Price();
                price.setAmount(BigDecimal.valueOf(faker.number().randomDouble(2, 10, 100)));
                price.setCurrency("EUR");
                prices.add(price);
            }
            priceRepository.saveAll(prices);

            // Create books with prices and parent class fields
            List<Book> books = new ArrayList<>();
            Random random = new Random();
            BookGenre[] genres = BookGenre.values();

            for (int i = 0; i < 10; i++) {
                Book book = new Book();
                // Set MediaItem (parent) fields
                book.setTitle(faker.book().title());
                book.setDescription(faker.lorem().paragraph());

                book.setMediaItemCategory(MediaItemCategory.BOOK);
                book.setAvailable(true);

                // Set Book specific fields
                book.setBookGenre(genres[random.nextInt(genres.length)]);
                book.setIsbn("978" + faker.number().digits(10));
                book.setPrice(prices.get(i));

                // Assign 1-3 random authors
                HashSet<Author> bookAuthors = new HashSet<>();
                int authorCount = random.nextInt(3) + 1;
                while (bookAuthors.size() < authorCount) {
                    bookAuthors.add(authors.get(random.nextInt(authors.size())));
                }
                book.setAuthors(bookAuthors);

                books.add(book);
            }
            bookRepository.saveAll(books);
        };
    }
}