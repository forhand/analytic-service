package org.example.analytic_service;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@EnableFeignClients("org.example.analytic_service.client")
public class AnalyticServiceApp {
  public static void main(String[] args) {
    new SpringApplicationBuilder(AnalyticServiceApp.class)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
  }
}
