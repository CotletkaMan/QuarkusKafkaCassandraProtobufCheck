package controller;

import model.KafkaEvent;
import model.KafkaEventProtos;
import service.KafkaProducer;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
public class KafkaController {

    @Inject
    KafkaProducer kafkaProducer;

    @POST
    @Path("/sendEvent")
    public void sendEvent(KafkaEvent kafkaEvent) {
        kafkaProducer.send(kafkaEvent);
    }
}
