package com.jyx.medialibrary.bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import com.jyx.medialibrary.bookstore.model.enums.BookGenre;
import com.jyx.medialibrary.common.model.AbstractItemEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DiscriminatorValue("LIBRARY")
public class Book extends AbstractItemEntity {

	@Column
	private String title;

	@Column
	private String isbn;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	BookGenre bookGenre;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

}