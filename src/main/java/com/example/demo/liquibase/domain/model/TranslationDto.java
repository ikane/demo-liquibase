package com.example.demo.liquibase.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class TranslationDto {
  private Long id;
  private String key;
  private String value;
  private LanguageDto language;
  private Map<String, String> metadata;
}
