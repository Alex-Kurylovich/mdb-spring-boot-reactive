package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class Test_EmptyMonoHandling {
    private static final Logger log = LoggerFactory.getLogger(Test_EmptyMonoHandling.class);

    public static void main(String[] args) {
        Mono<String> emptyMono = Mono.empty();

        Optional<String> result = emptyMono.blockOptional();

        result.ifPresentOrElse(
                value -> log.info("Value: {}", value),
                () -> log.info("Mono was empty. Using default value.")
        );
    }
}
