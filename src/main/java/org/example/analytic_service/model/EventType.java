package org.example.analytic_service.model;

public enum EventType {
    SUBSCRIBED,
    UNSUBSCRIBED,
    POST_PUBLISHED,
    POST_VIEW,
    ACHIEVEMENT_RECEIVED,
    USER_RETRIEVED;

    public static EventType of(int type) {
        for (EventType eventType : EventType.values()) {
            if (eventType.ordinal() == type) {
                return eventType;
            }
        }
        throw new IllegalArgumentException("Unknown event type: " + type);
    }

    public static EventType fromString(String value){
        return EventType.valueOf(value.toUpperCase());
    }
}
