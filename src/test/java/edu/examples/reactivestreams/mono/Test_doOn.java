package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

/*
Operators for Side Effects
Use operators like doOnNext(), doOnError(), or doOnComplete() to perform side effects (e.g., logging)
without extracting the value.
These operators don’t modify the Mono’s content, so you can continue chaining reactive operators.
 */
public class Test_doOn {
    private static final Logger log = LoggerFactory.getLogger(Test_doOn.class);

    public static void main(String[] args) {
        Mono<String> dataMono = Mono.just("Sensitive Data")
                .delayElement(Duration.ofSeconds(1));
        // log.info(dataMono.block());

        dataMono.doOnNext(value -> log.info("Processing data: {}", value))
                .map(String::toUpperCase)
                .doOnSuccess(value -> log.info("Data processed successfully: {}", value))
                .subscribe();
    }
}
