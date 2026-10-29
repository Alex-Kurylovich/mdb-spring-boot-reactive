package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Test_StandaloneApp {
    private static final Logger log = LoggerFactory.getLogger(Test_StandaloneApp.class);

    static void main() {
        Mono<String> apiResponseMono = simulateApiCall();

        try {
            String response = apiResponseMono.block(Duration.ofSeconds(3));
            log.info("API Response: {}", response);
        } catch (Exception e) {
            log.error("Failed to get API response: {}, {}", e.getClass(), e.getMessage());
        }
    }

    private static Mono<String> simulateApiCall() {
        return Mono.just("Success: Data retrieved")
                .delayElement(Duration.ofSeconds(2)); // Simulate API delay
    }
}
