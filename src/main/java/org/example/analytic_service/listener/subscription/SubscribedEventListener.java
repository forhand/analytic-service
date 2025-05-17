package org.example.analytic_service.listener.subscription;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.analytic_service.dto.event.subscription.SubscribedEvent;
import org.example.analytic_service.listener.AbstractEventListener;
import org.example.analytic_service.mapper.AnalyticEventMapper;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.service.AnalyticService;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class SubscribedEventListener extends AbstractEventListener<SubscribedEvent> {


  public SubscribedEventListener(AnalyticService service,
                                 ObjectMapper objectMapper,
                                 ChannelTopic subscribedEventChannel,
                                 AnalyticEventMapper mapper) {
    super(service, objectMapper, subscribedEventChannel, mapper, SubscribedEvent.class);
  }

  @Override
  protected AnalyticEvent mapToEntity(SubscribedEvent event) {
    return mapper.toEntity(event);
  }
}
