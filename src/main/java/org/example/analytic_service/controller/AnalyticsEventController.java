package org.example.analytic_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.analytic_service.dto.AnalyticEventDto;
import org.example.analytic_service.dto.AnalyticFilterDto;
import org.example.analytic_service.service.AnalyticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/analytics")
public class AnalyticsEventController {

  private final AnalyticService service;

  @GetMapping("/list")
  public List<AnalyticEventDto> getAnalytics(@Valid AnalyticFilterDto filters) {
    List<AnalyticEventDto> analytics = service.getAnalytics(filters);
    System.out.println(analytics);
    return analytics;
  }
}
