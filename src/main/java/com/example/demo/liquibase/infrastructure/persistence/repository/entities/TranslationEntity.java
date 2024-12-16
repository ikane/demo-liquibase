package com.example.demo.liquibase.infrastructure.persistence.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "translation", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "key", nullable = false)
  private String key;

  @Column(name = "value", nullable = false)
  private String value;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private LanguageEntity language;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(columnDefinition = "json")
  private Map<String, String> metadata;
}
