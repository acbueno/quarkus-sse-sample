package br.com.acbueno.resource;

import br.com.acbueno.service.EventServiceProducer;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.sse.SseEventSink;

@Path("/events")
@Produces(MediaType.SERVER_SENT_EVENTS)
public class EventResource {

    @Inject
    EventServiceProducer eventServiceProducer;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Response generateEvent(@Context SseEventSink eventSink) {
        try {
            eventServiceProducer.sendEvent(eventSink);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
