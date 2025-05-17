package org.example.analytic_service.dto.event.subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.analytic_service.dto.event.Event;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class SubscribedEvent extends Event {
  private Long followerId;
  private Long followeeId;
  private LocalDateTime eventAt;
}
