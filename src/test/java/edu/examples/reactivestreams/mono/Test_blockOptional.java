package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Optional;

/*
Returns an Optional<T> instead of throwing an exception for empty Monos.
This method is safer than block() when the Mono might not emit a value.
 */
public class Test_blockOptional {
    private static final Logger log = LoggerFactory.getLogger(Test_blockOptional.class);

    static void main(String[] args) {
        // Non-empty Mono
        Mono<String> nonEmptyMono = Mono.just("Hello");
        Optional<String> nonEmptyResult = nonEmptyMono.blockOptional();
        nonEmptyResult.ifPresent(value -> log.info("Non-empty result: {}", value));

        // Empty Mono
        Mono<String> emptyMono = Mono.empty();
        Optional<String> emptyResult = emptyMono.blockOptional();
        if (emptyResult.isEmpty()) {
            log.info("Empty Mono handled gracefully");
        }
    }}
