package org.example.analytic_service.config.redis;


import org.example.analytic_service.listener.ChannelAwareListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.List;

@Configuration
public class RedisConfig {
  @Value("${spring.data.redis.host}")
  private String host;
  @Value("${spring.data.redis.port}")
  private int port;

  @Bean
  public JedisConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
    return new JedisConnectionFactory(config);
  }

  @Bean
  public RedisMessageListenerContainer container(JedisConnectionFactory connectionFactory,
                                                 List<ChannelAwareListener> listeners) {
    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);

    for (ChannelAwareListener listener : listeners) {
      container.addMessageListener(listener, listener.getChannel());
    }

    return container;
  }
}
