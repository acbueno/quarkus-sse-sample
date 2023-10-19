package br.com.acbueno.service;

import java.util.concurrent.locks.LockSupport;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import br.com.acbueno.enums.SseEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.sse.OutboundSseEvent;
import jakarta.ws.rs.sse.Sse;
import jakarta.ws.rs.sse.SseEventSink;

@ApplicationScoped
public class EventServiceProducer {

    @Context
    Sse sse;

    @ConfigProperty(name = "user.config")
    private String userName;

    public void sendEvent(@Context SseEventSink enEventSink) {

        //**Create 5 user
        for(int i=0;i<5;i++) {
            enEventSink.send(createEvent(SseEvent.CREATED.name(), userName+i));
            LockSupport.parkNanos(1_000_000_000L);
        }

        for(int i=0;i<3;i++) {
            enEventSink.send(createEvent(SseEvent.DELETE.name(), userName+i));
            LockSupport.parkNanos(1_000_000_000L);
        }

        for(int i=0;i<2;i++) {
            enEventSink.send(createEvent(SseEvent.UPDATE.name(), userName+i));
            LockSupport.parkNanos(1_000_000_000L);
        }

    }

    private OutboundSseEvent createEvent(String eventName, String data) {
        return sse.newEventBuilder().name(eventName).data(data).build();
    }

}
