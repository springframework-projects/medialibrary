package com.jyx.medialibrary.bookstore.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import com.jyx.medialibrary.bookstore.model.enums.BookGenre;
import com.jyx.medialibrary.common.model.AbstractItemEntity;

@Data
@Builder
@Entity
@DiscriminatorValue("LIBRARY")
public class Book  extends AbstractItemEntity {

	@Column
	private String isbn;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	BookGenre bookGenre;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

	

	// Getters and Setters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "BookItem{" + super.toString() + ", isbn='" + isbn + '\'' + ", authors=" + authors + '}';
	}
}