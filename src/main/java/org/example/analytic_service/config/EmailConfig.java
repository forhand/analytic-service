package org.example.analytic_service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {
  private String from;
  private String host;
  private Integer port;
  private String username;
  private String password;
  private String protocol;
  private String defaultEncoding;
  private String subject;
  private Map<String, Object> properties = new HashMap<>();
}
