package com.jyx.medialibrary.config;

import com.github.javafaker.Faker;
import com.jyx.medialibrary.domain.Author;
import com.jyx.medialibrary.domain.Book;
import com.jyx.medialibrary.domain.BookGenre;
import com.jyx.medialibrary.domain.MediaItemCategory;
import com.jyx.medialibrary.repository.AuthorRepository;
import com.jyx.medialibrary.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Configuration
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
            // Create authors
            List<Author> authors = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
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



            // Create books with prices and parent class fields
            List<Book> books = new ArrayList<>();
            Random random = new Random();
            BookGenre[] genres = BookGenre.values();

            for (int i = 0; i < 25; i++) {
                Book book = new Book();

                // base attributes
                book.setDescription(faker.lorem().paragraph());
                book.setMediaItemCategory(MediaItemCategory.BOOK);
                book.setPrice(BigDecimal.valueOf(10 + random.nextLong(90)));
                book.setImageUrl(faker.internet().image());
                book.setAvailable(true);
                book.setMediaItemCategory(MediaItemCategory.BOOK);
                book.setAvailable(true);

                // book specific attributes
                book.setTitle(faker.book().title());
                book.setIsbn("978" + faker.number().digits(10));
                book.setBookGenre(genres[random.nextInt(genres.length)]);

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