package br.com.acbueno.service;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.sse.InboundSseEvent;
import jakarta.ws.rs.sse.SseEventSource;

public class SseClientBoradcastService {

    private static final String server = "http://localhost:9056/events";

    public void consumeEvent() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(server);

        try (final SseEventSource eventSource = SseEventSource.target(target)
                .reconnectingEvery(5, TimeUnit.SECONDS).build()) {
            eventSource.register(onEvent, onError, onComplete);
            eventSource.open();
            System.out.println("Wainting for incoming event ...");
            //Consuming events for one hour
            Thread.sleep(60 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.close();
        System.out.println("End");

    }

    // A new event is received
    private static Consumer<InboundSseEvent> onEvent = (inboundSseEvent) -> {
        String eventName = inboundSseEvent.getName();
        String data = inboundSseEvent.readData();
        System.out.println(String.format("Event name: %s, data: %s", eventName, data));
    };

    //Error
    private static Consumer<Throwable> onError = (throwable) -> {
        throwable.printStackTrace();
    };

    //Connection close and there is nothing to receive
    private static Runnable onComplete = () -> {
        System.out.println("Done!");
    };

}
