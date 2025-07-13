package com.jyx.medialibrary.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "item_id")
@Builder
public class Book extends AbstractItemEntity {

	@NotBlank(message = "Title is required")
	@Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
	@Column
	private String title;

	@Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$", message = "Invalid ISBN format")
	@Column
	private String isbn;

	@NotNull(message = "Book genre is required")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BookGenre bookGenre;

	@NotNull(message = "Authors set cannot be null")
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

}