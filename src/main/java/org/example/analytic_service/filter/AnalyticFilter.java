package org.example.analytic_service.filter;

import org.example.analytic_service.dto.AnalyticFilterDto;
import org.example.analytic_service.model.AnalyticEvent;

import java.util.stream.Stream;

public interface AnalyticFilter {

    boolean isApplicable(AnalyticFilterDto dto);

    Stream<AnalyticEvent> action(Stream<AnalyticEvent> eventStream, AnalyticFilterDto dto);
}
