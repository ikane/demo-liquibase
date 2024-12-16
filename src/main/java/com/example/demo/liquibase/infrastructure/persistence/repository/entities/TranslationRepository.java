package com.example.demo.liquibase.infrastructure.persistence.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Long> {
    //List<TranslationEntity> findByLanguageCode(String languageCode);
}
