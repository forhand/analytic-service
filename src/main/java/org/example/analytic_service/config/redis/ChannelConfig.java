package org.example.analytic_service.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
public class ChannelConfig {

  @Bean
  public ChannelTopic subscribedEventChannel(@Value("${spring.data.redis.channels.subscription.subscribed.name}") String topicName) {
    return new ChannelTopic(topicName);
  }

  @Bean
  public ChannelTopic unsubscribedEventChannel(@Value("${spring.data.redis.channels.subscription.unsubscribed.name}") String topicName) {
    return new ChannelTopic(topicName);
  }

  @Bean
  public ChannelTopic userRetrievedEventChannel(@Value("${spring.data.redis.channels.user.user_retrieved.name}") String topicName) {
    return new ChannelTopic(topicName);
  }

}
