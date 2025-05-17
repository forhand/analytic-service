package org.example.analytic_service.dto.event.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.analytic_service.dto.event.Event;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnsubscribedEvent extends Event {
  private long followerId;
  private long followeeId;
  private LocalDateTime eventAt;
}
