package service;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import model.KafkaEvent;

public class KafkaEventDeserializer extends ObjectMapperDeserializer<KafkaEvent> {
    public KafkaEventDeserializer() {
        super(KafkaEvent.class);
    }
}
