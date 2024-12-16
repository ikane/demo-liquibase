package com.example.demo.liquibase.infrastructure.persistence.mapper;

import com.example.demo.liquibase.domain.model.TranslationDto;
import com.example.demo.liquibase.infrastructure.persistence.repository.entities.TranslationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface TranslationMapper {

  TranslationDto toDomain(
      TranslationEntity entity);

  TranslationEntity toEntity(
      TranslationDto domain);
}
