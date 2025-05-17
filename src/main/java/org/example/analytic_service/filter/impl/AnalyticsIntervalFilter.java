package org.example.analytic_service.filter.impl;

import org.example.analytic_service.dto.AnalyticFilterDto;
import org.example.analytic_service.filter.AnalyticFilter;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.model.Interval;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Component
public class AnalyticsIntervalFilter implements AnalyticFilter {
    @Override
    public boolean isApplicable(AnalyticFilterDto dto) {
        return dto.getInterval() != null;
    }

    @Override
    public Stream<AnalyticEvent> action(Stream<AnalyticEvent> eventStream, AnalyticFilterDto dto) {

        return eventStream.filter(event -> {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime date = event.getReceivedAt();
            Interval interval = dto.getInterval();

          return switch (interval) {
            case HOURLY -> date.isAfter(now.minusHours(1));
            case DAILY -> date.isAfter(now.minusDays(1));
            case WEEKLY -> date.isAfter(now.minusWeeks(1));
            case MONTHLY -> date.isAfter(now.minusMonths(1));
            default -> throw new IllegalArgumentException("Invalid interval: " + interval);
          };
        });
    }
}
