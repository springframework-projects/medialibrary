package com.jyx.medialibrary.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AbstractItemEntity {

	private Long id;
	private String name;
	private String category;
	private String description;
	private Integer quantity;
	private LocalDate releaseDate;
}
