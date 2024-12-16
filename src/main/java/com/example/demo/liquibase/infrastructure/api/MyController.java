package com.example.demo.liquibase.infrastructure.api;

import com.example.demo.liquibase.domain.model.LanguageDto;
import com.example.demo.liquibase.domain.model.TranslationDto;
import com.example.demo.liquibase.infrastructure.persistence.mapper.LanguageMapper;
import com.example.demo.liquibase.infrastructure.persistence.mapper.TranslationMapper;
import com.example.demo.liquibase.infrastructure.persistence.repository.entities.LanguageRepository;
import com.example.demo.liquibase.infrastructure.persistence.repository.entities.TranslationRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
//@Slf4j
public class MyController {

  Logger log = org.slf4j.LoggerFactory.getLogger(MyController.class);

  private final LanguageRepository languageRepository;
  private final TranslationRepository translationRepository;
  private final TranslationMapper translationMapper;

  public MyController(LanguageRepository languageRepository, TranslationRepository translationRepository, TranslationMapper translationMapper) {
    this.languageRepository = languageRepository;
    this.translationRepository = translationRepository;
    this.translationMapper = translationMapper;
  }

  // create endpoint to create a translation
    @PostMapping("/translations")
    public TranslationDto createTranslation(@Valid @RequestBody TranslationDto translationDto) {
        final var translationEntity = translationMapper.toEntity(translationDto);
        final var translationEntitySaved = translationRepository.save(translationEntity);
        return translationMapper.toDomain(translationEntitySaved);
    }

  // endpoint to get all translations
  @GetMapping("/translations")
  public List<TranslationDto> getTranslations() {
    final var translationDtos = translationRepository.findAll()
        .stream()
        .map(translationMapper::toDomain)
        .toList();
    log.info("Translations: {}", translationDtos);
    return translationDtos;
  }

  @GetMapping("/languages")
  public List<LanguageDto> getLanguages() {
    final var languageDtos = languageRepository.findAll()
        .stream()
        .map(LanguageMapper.MAPPER::toDomain)
        .toList();

    log.info("Languages: {}", languageDtos);

    return languageDtos;
  }

  @GetMapping("/{id}")
  public LanguageDto getLanguage(@PathVariable Long id) {
    return languageRepository.findById(id)
        .map(LanguageMapper.MAPPER::toDomain)
        .orElse(null);
  }

  @PostMapping
  public LanguageDto createLanguage(@Valid @RequestBody LanguageDto languageDto) {

    final var languageEntity = LanguageMapper.MAPPER.toEntity(languageDto);

    final var languageEntitySaved = languageRepository.save(languageEntity);

    return LanguageMapper.MAPPER.toDomain(languageEntitySaved);
  }

  @GetMapping("/languages/search")
    public LanguageDto getLanguageByCode(@RequestParam String code) {
        return Optional.ofNullable(languageRepository.findByCode(code))
            .map(LanguageMapper.MAPPER::toDomain)
            .orElse(null);
    }
}
