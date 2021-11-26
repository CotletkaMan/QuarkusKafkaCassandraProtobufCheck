package service;

import model.KafkaEvent;
import model.KafkaEventProtos;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class KafkaProducer {
    @Inject
    @Channel("test-events")
    Emitter<byte[]> kafkaEventEmitter;

    public void send(KafkaEvent event) {
        KafkaEventProtos.KafkaEvent protos = KafkaEventProtos.KafkaEvent.newBuilder()
                .setName(event.getName())
                .setPayload(event.getPayload())
                .build();

        kafkaEventEmitter.send(protos.toByteArray());
    }
}
