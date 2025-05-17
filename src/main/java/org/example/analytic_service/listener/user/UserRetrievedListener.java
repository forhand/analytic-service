package org.example.analytic_service.listener.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.analytic_service.dto.event.user.UserRetrievedEvent;
import org.example.analytic_service.listener.AbstractEventListener;
import org.example.analytic_service.mapper.AnalyticEventMapper;
import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.service.AnalyticService;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class UserRetrievedListener extends AbstractEventListener<UserRetrievedEvent> {


  public UserRetrievedListener(AnalyticService service,
                               ObjectMapper objectMapper,
                               ChannelTopic userRetrievedEventChannel,
                               AnalyticEventMapper mapper) {
    super(service, objectMapper, userRetrievedEventChannel, mapper, UserRetrievedEvent.class);
  }

  @Override
  protected AnalyticEvent mapToEntity(UserRetrievedEvent event) {
    return mapper.toEntity(event);
  }
}
