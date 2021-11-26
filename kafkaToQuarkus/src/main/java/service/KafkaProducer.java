package service;

import io.smallrye.common.annotation.Blocking;
import model.KafkaEvent;
import model.KafkaEventProtos;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Inject
    KafkaEventDao kafkaEventDao;

    @Blocking
    @Transactional
    @Incoming("test-events")
    public void listen(byte[] event) {
        try {
            KafkaEventProtos.KafkaEvent protoEvent = KafkaEventProtos.KafkaEvent.parseFrom(event);
            KafkaEvent kafkaEvent = new KafkaEvent(protoEvent.getName(), protoEvent.getPayload());
            LOGGER.info("Receive event {}", kafkaEvent);

            kafkaEventDao.update(kafkaEvent);
        } catch (Exception e) {
            LOGGER.error("Problem with serialization: ", e);
            return;
        }
    }
}
