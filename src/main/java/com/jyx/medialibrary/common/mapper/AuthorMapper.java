package com.jyx.medialibrary.common.mapper;

import com.jyx.medialibrary.common.dto.AuthorDTO;
import com.jyx.medialibrary.domain.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO authorToAuthorDTO(Author author);
}
