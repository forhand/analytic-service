package org.example.analytic_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.analytic_service.model.EventType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnalyticsEventDto {
    private long id;
    private long receiverId;
    private long actorId;
    private EventType eventType;
    @JsonFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private LocalDateTime receivedAt;
}
