package org.example.analytic_service.filter.impl;

import org.example.analytic_service.dto.AnalyticFilterDto;
import org.example.analytic_service.filter.AnalyticFilter;
import org.example.analytic_service.model.AnalyticEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Component
public class AnalyticsDateRangeFilter implements AnalyticFilter {
    @Override
    public boolean isApplicable(AnalyticFilterDto dto) {
        return dto.getFrom() != null && dto.getTo() != null;
    }

    @Override
    public Stream<AnalyticEvent> action(Stream<AnalyticEvent> events, AnalyticFilterDto dto) {
       return events.filter(event -> {
           LocalDateTime time = event.getReceivedAt();
           return time.isEqual(dto.getFrom()) || time.isAfter(dto.getFrom())
                   && (time.isEqual(dto.getTo()) || time.isBefore(dto.getTo()));
       });
    }
}
