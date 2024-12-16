package com.example.demo.liquibase.infrastructure.persistence.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
    LanguageEntity findByCode(String code);
}
