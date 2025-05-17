package org.example.analytic_service.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.analytic_service.dto.event.Event;
import org.example.analytic_service.mapper.AnalyticEventMapper;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.service.AnalyticService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;

import java.io.IOException;

@Data
@RequiredArgsConstructor
@Slf4j
public abstract class AbstractEventListener<T extends Event> implements ChannelAwareListener {
  protected final AnalyticService service;
  protected final ObjectMapper objectMapper;
  protected final ChannelTopic channelTopic;
  protected final AnalyticEventMapper mapper;
  protected final Class<T> eventType;

  @Override
  public void onMessage(Message message, byte[] pattern) {
    log.info("Received event from channel: " + channelTopic.getTopic());
    T event = parseEvent(message);
    AnalyticEvent analyticEvent = mapToEntity(event);
    service.save(analyticEvent);
  }

  public ChannelTopic getChannel() {
    return channelTopic;
  }

  protected abstract AnalyticEvent mapToEntity(T event);

  private T parseEvent(Message message) {
    try {
      return objectMapper.readValue(message.getBody(), eventType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
