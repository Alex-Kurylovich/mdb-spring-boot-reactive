package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

/*
Waits indefinitely for the Mono to emit a single value. Throws:
    NoSuchElementException if the Mono completes without emitting any value.
    The underlying exception if the Mono errors.
 */
public class Test_block {
    private static final Logger log = LoggerFactory.getLogger(Test_block.class);

    static void main(String[] args) {
        Mono<String> greetingMono = Mono.just("Hello, Reactor!");
        try {
            String greeting = greetingMono.block();
            log.info(greeting);
        } catch (NoSuchElementException e) {
            log.error("Mono was empty: {}", e.getClass());

        } catch (Exception e) {
            log.error("Error occurred: {}, {}", e.getClass(), e.getMessage());
        }
    }
}
