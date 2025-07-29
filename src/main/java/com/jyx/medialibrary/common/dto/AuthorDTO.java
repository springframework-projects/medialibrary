package com.jyx.medialibrary.common.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorDTO {

    private String name;
    private LocalDate birthDate;
}
