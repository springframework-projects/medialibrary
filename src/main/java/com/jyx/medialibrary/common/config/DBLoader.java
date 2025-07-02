package com.jyx.medialibrary.common.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jyx.medialibrary.bookstore.model.Author;
import com.jyx.medialibrary.bookstore.model.Book;
import com.jyx.medialibrary.bookstore.model.enums.BookGenre;
import com.jyx.medialibrary.bookstore.repository.AuthorRepository;
import com.jyx.medialibrary.bookstore.repository.BookRepository;
import com.jyx.medialibrary.common.model.MediaItemCategory;
import com.jyx.medialibrary.common.model.Price;

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

			// Create authors
			Author author1 = new Author();
			author1.setName("John Smith");
			author1.setBirthDate(LocalDate.of(1980, 1, 15));

			Author author2 = new Author();
			author2.setName("Emma Wilson");
			author2.setBirthDate(LocalDate.of(1975, 6, 22));

			Author author3 = new Author();
			author3.setName("Michael Brown");
			author3.setBirthDate(LocalDate.of(1985, 3, 30));

			authorRepository.saveAll(List.of(author1, author2, author3));

			// Create books
			// Create books with prices
			Book book1 = new Book();
			book1.setMediaItemCategory(MediaItemCategory.BOOK);
			book1.setBookGenre(BookGenre.COMEDY);
			book1.setTitle("The First Adventure");
			book1.setIsbn("978-1234567891");
			Price price1 = new Price(new BigDecimal(29.99f), "EUR");
			book1.setPrice(price1);
			book1.setAuthors(new HashSet<Author>(List.of(author1, author2)));

			Book book2 = new Book();
			book2.setMediaItemCategory(MediaItemCategory.BOOK);
			book2.setBookGenre(BookGenre.COMEDY);
			book2.setTitle("Mystery of the Lost City");
			book2.setIsbn("978-1234567892");
			Price price2 = new Price(new BigDecimal(19.99f), "EUR");
			book2.setPrice(price2);
			book2.setAuthors(new HashSet<Author>(List.of(author1)));

			Book book3 = new Book();
			book3.setMediaItemCategory(MediaItemCategory.BOOK);
			book3.setBookGenre(BookGenre.COMEDY);
			book3.setTitle("The Hidden Truth");
			book3.setIsbn("978-1234567893");
			Price price3 = new Price(new BigDecimal(32.75f), "EUR");
			book3.setPrice(price3);
			book3.setAuthors(new HashSet<Author>(List.of(author2)));

			Book book4 = new Book();
			book4.setMediaItemCategory(MediaItemCategory.BOOK);
			book4.setBookGenre(BookGenre.COMEDY);
			book4.setTitle("Beyond the Horizon");
			book4.setIsbn("978-1234567894");
			Price price4 = new Price(new BigDecimal(27.95f), "EUR");
			book4.setPrice(price4);
			book4.setAuthors(new HashSet<Author>(List.of(author2, author3)));

			Book book5 = new Book();
			book5.setMediaItemCategory(MediaItemCategory.BOOK);
			book5.setBookGenre(BookGenre.COMEDY);
			book5.setTitle("The Last Stand");
			book5.setIsbn("978-1234567895");
			Price price5 = new Price(new BigDecimal(49.99f), "EUR");
			book5.setPrice(price5);
			book5.setAuthors(new HashSet<Author>(List.of(author2, author3)));

			Book book6 = new Book();
			book6.setMediaItemCategory(MediaItemCategory.BOOK);
			book6.setBookGenre(BookGenre.COMEDY);
			book6.setTitle("Eternal Sunset");
			book6.setIsbn("978-1234567896");
			Price price6 = new Price(new BigDecimal(21.99f), "EUR");
			book6.setPrice(price6);
			book6.setAuthors(new HashSet<Author>(List.of(author3)));

			Book book7 = new Book();
			book7.setMediaItemCategory(MediaItemCategory.BOOK);
			book7.setBookGenre(BookGenre.COMEDY);
			book7.setTitle("The Final Chapter");
			book7.setIsbn("978-1234567897");
			Price price7 = new Price(new BigDecimal(17.25f), "EUR");
			book7.setPrice(price7);
			book7.setAuthors(new HashSet<Author>(List.of(author1, author3)));

			bookRepository.saveAll(List.of(book1, book2, book3, book4, book5, book6, book7));

		};
	}
//
//    private float getRandomPrice(float min, float max) {
//        Random random = new Random();
//        float randomFloat = random.nextFloat();
//        return min + (randomFloat * (max - min));
//    }
}
