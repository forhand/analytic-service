package org.example.analytic_service.repository;

import org.example.analytic_service.model.AnalyticEvent;
import org.example.analytic_service.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AnalyticEventRepository extends JpaRepository<AnalyticEvent, Integer> {

  Stream<AnalyticEvent> findByReceiverIdAndEventType(long receiverId, EventType eventType);
}
