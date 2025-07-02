package com.jyx.medialibrary.bookstore.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Data
@Builder
@Entity
@Table(name = "authors")
public class Author {
	

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	 
}