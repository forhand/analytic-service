package org.example.analytic_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.analytic_service.model.EventType;
import org.example.analytic_service.model.Interval;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AnalyticFilterDto {

  @NotNull(message = "ReceiverId can't be null")
  private Long receiverId;
  @NotNull(message = "EventType can't be null")
  private EventType eventType;
  private Interval interval;
  @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
  private LocalDateTime from;
  @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
  private LocalDateTime to;
}
