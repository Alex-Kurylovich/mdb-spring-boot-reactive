package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

/*
Waits for the Mono to emit a value for a specified duration.
    Throws TimeoutException/IllegalStateException if the Mono doesn’t emit a value within the given time.
 */
public class Test_blockDuration {
    private static final Logger log = LoggerFactory.getLogger(Test_blockDuration.class);

    static void main(String[] args) {
        Mono<String> delayedMono = Mono.just("Delayed Hello")
                .delayElement(Duration.ofSeconds(3)); // Simulate async delay

        try {
            String result = delayedMono.block(Duration.ofSeconds(2)); // Times out after 2s
            log.info(result);
        } catch (Exception e) {
            log.error("Operation timed out: {}, {}", e.getClass(), e.getMessage());
        }
    }
}
