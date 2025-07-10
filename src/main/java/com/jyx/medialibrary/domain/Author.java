package com.jyx.medialibrary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDate birthDate;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

}