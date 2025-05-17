package org.example.analytic_service.listener.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.analytic_service.dto.event.subscription.UnsubscribedEvent;
import org.example.analytic_service.listener.AbstractEventListener;
import org.example.analytic_service.mapper.AnalyticEventMapper;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.service.AnalyticService;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class UnsubscribedEventListener extends AbstractEventListener<UnsubscribedEvent> {


  public UnsubscribedEventListener(AnalyticService service,
                                   ObjectMapper objectMapper,
                                   ChannelTopic unsubscribedEventChannel,
                                   AnalyticEventMapper mapper) {
    super(service, objectMapper, unsubscribedEventChannel, mapper, UnsubscribedEvent.class);
  }

  @Override
  protected AnalyticEvent mapToEntity(UnsubscribedEvent event) {
    return mapper.toEntity(event);
  }

}
