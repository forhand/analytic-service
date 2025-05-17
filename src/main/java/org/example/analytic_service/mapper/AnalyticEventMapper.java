package org.example.analytic_service.mapper;

import org.example.analytic_service.dto.AnalyticEventDto;
import org.example.analytic_service.dto.event.subscription.SubscribedEvent;
import org.example.analytic_service.dto.event.subscription.UnsubscribedEvent;
import org.example.analytic_service.dto.event.user.UserRetrievedEvent;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.model.EventType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnalyticEventMapper {
  AnalyticEventDto toDto(AnalyticEvent entity);

  AnalyticEvent toEntity(AnalyticEventDto event);

  @Mapping(target = "receiverId", source = "followeeId")
  @Mapping(target = "actorId", source = "followerId")
  @Mapping(target = "eventType", expression = "java(org.example.analytic_service.model.EventType.SUBSCRIBED)")
  @Mapping(target = "receivedAt", source = "eventAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
  AnalyticEvent toEntity(SubscribedEvent event);

  @Mapping(target = "receiverId", source = "followeeId")
  @Mapping(target = "actorId", source = "followerId")
  @Mapping(target = "eventType", expression = "java(org.example.analytic_service.model.EventType.UNSUBSCRIBED)")
  @Mapping(target = "receivedAt", source = "eventAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
  AnalyticEvent toEntity(UnsubscribedEvent event);

  @Mapping(target = "receiverId", source = "userId")
  @Mapping(target = "eventType", expression = "java(org.example.analytic_service.model.EventType.USER_RETRIEVED)")
  @Mapping(target = "receivedAt", source = "eventAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
  AnalyticEvent toEntity(UserRetrievedEvent event);

  List<AnalyticEventDto> toDtoList(List<AnalyticEvent> entities);

  default EventType getEventAt(String eventType) {
    return EventType.fromString(eventType);
  }

  default String getEventAt(EventType eventType) {
    return "yyyy-MM-dd'T'HH:mm:ss";
  }
}