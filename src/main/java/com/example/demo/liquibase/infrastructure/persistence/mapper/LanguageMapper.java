package com.example.demo.liquibase.infrastructure.persistence.mapper;

import com.example.demo.liquibase.domain.model.LanguageDto;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class LanguageMapper {

    public static final LanguageMapper MAPPER = getMapper(LanguageMapper.class);

    public abstract LanguageDto toDomain(
        com.example.demo.liquibase.infrastructure.persistence.repository.entities.LanguageEntity entity);

    public abstract com.example.demo.liquibase.infrastructure.persistence.repository.entities.LanguageEntity toEntity(
        LanguageDto domain);
}
