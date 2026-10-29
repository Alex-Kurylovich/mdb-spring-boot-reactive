package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
with Consumers
Registers callbacks to handle the emitted value, errors, or completion events.
This method is non-blocking, so the current thread continues execution immediately.
 */
public class Test_subscribe {
    private static final Logger log = LoggerFactory.getLogger(Test_subscribe.class);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1); // Prevents main thread from exiting

        Mono<String> asyncMono = Mono.just("Hello from async")
                .delayElement(Duration.ofSeconds(2));

        asyncMono.subscribe(
                value ->  log.info("Received: {}", value), // On next
                error -> {
                    log.error("Error: {}, {}", error.getClass(), error.getMessage());
                    latch.countDown();
                }, // On error
                latch::countDown // On complete
        );

        boolean b = latch.await(3, TimeUnit.SECONDS); // Wait for the Mono to complete
        log.info("Latch await: {}", b);
    }
}
