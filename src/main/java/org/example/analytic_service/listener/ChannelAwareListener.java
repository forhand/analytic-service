package org.example.analytic_service.listener;

import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;

public interface ChannelAwareListener extends MessageListener {
  ChannelTopic getChannel();
}
