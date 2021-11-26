package controller;

import model.KafkaEvent;
import service.KafkaEventDao;
import service.KafkaProducer;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
public class KafkaController {

    @Inject
    KafkaEventDao kafkaEventDao;

    @GET
    @Path("/getEvents")
    public List<KafkaEvent> sendEvent() {
        return kafkaEventDao.findAll().all();
    }
}
