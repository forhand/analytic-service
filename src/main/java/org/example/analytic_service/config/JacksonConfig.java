package org.example.analytic_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Отключаем вывод дат в миллисекундах
    objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true)); // Используем стандартный формат с временными зонами
    objectMapper.setTimeZone(TimeZone.getTimeZone("UTC"));
    return objectMapper;
  }
}
