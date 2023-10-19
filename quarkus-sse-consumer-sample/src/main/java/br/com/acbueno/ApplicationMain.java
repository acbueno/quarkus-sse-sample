package br.com.acbueno;

import br.com.acbueno.service.SseClientBoradcastService;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class ApplicationMain {

    public static void main(String... args) {
        SseClientBoradcastService service = new SseClientBoradcastService();
        service.consumeEvent();
    }

}
