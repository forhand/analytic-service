CREATE TABLE analytic_events (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    receiver_id bigint NOT NULL,
    actor_id bigint NOT NULL,
    event_type varchar(64) NOT NULL,
    received_at timestamp DEFAULT current_timestamp
);

CREATE INDEX events_idx ON analytic_events(receiver_id, event_type, received_at DESC);