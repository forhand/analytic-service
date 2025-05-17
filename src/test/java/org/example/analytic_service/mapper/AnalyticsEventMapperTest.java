package org.example.analytic_service.mapper;

import org.example.analytic_service.dto.AnalyticEventDto;
import org.example.analytic_service.dto.event.subscription.SubscribedEvent;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.model.EventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsEventMapperTest {
  private AnalyticEventMapperImpl mapper = new AnalyticEventMapperImpl();
  private AnalyticEvent entity;
  private AnalyticEventDto dto;

  @BeforeEach
  void setUp() {
    long id = 0L;
    long requestId = 2L;
    long actorId = 3L;
    EventType eventType = EventType.POST_PUBLISHED;
    LocalDateTime receivedAt = LocalDateTime.now();
    entity = new AnalyticEvent(id, requestId, actorId, eventType, receivedAt);
    dto = new AnalyticEventDto(id, requestId, actorId, eventType, receivedAt);

  }

  @Test
  void toDto() {
    AnalyticEventDto actDto = mapper.toDto(entity);

    assertEquals(dto, actDto);
  }

  @Test
  void toEntity_AnalyticsEventDto() {
    entity.setId(1L);
    dto.setId(1L);
    AnalyticEvent actEntity = mapper.toEntity(dto);

    assertEquals(entity, actEntity);
  }

  @Test
  void toEntity_UserSubscriptionEvent() {
    SubscribedEvent event = SubscribedEvent.builder()
            .followeeId(entity.getReceiverId())
            .followerId(entity.getActorId())
            .eventAt(entity.getReceivedAt())
            .build();
    entity.setEventType(EventType.SUBSCRIBED);

    AnalyticEvent actEntity = mapper.toEntity(event);

    assertEquals(entity, actEntity);
  }
}