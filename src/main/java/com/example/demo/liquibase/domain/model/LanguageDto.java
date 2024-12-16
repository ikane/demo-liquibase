package com.example.demo.liquibase.domain.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
  private Long id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String code;
}
