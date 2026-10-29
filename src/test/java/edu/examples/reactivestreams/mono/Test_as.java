package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Test_as {
    private static final Logger log = LoggerFactory.getLogger(Test_as.class);

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello from Mono");

        // Adapt to CompletableFuture
        CompletableFuture<String> future = mono.as(Mono::toFuture);

        // Process asynchronously
        future.thenAccept(value -> log.info("CompletableFuture received: {}", value));

        // Keep main thread alive
        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

}
