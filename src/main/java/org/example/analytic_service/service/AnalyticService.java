package org.example.analytic_service.service;

import lombok.RequiredArgsConstructor;
import org.example.analytic_service.dto.AnalyticEventDto;
import org.example.analytic_service.dto.AnalyticFilterDto;
import org.example.analytic_service.filter.AnalyticFilter;
import org.example.analytic_service.mapper.AnalyticEventMapper;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.repository.AnalyticEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AnalyticService {

  private final List<AnalyticFilter> analyticsFilters;
  private final AnalyticEventRepository repository;
  private final AnalyticEventMapper mapper;


  public void save(AnalyticEvent analyticEvent) {
    repository.save(analyticEvent);
  }

  @Transactional
  public List<AnalyticEventDto> getAnalytics(AnalyticFilterDto filters) {
    Stream<AnalyticEvent> analytics = repository.findByReceiverIdAndEventType(filters.getReceiverId(), filters.getEventType());

    return analyticsFilters.stream()
            .filter(filter -> filter.isApplicable(filters))
            .findFirst()
            .map(f -> f.action(analytics, filters))
            .orElse(analytics)
            .map(mapper::toDto)
            .toList();
  }

}
