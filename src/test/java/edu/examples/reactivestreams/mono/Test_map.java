package edu.examples.reactivestreams.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/*
for Chaining
Instead of extracting the value, transform it using map() (for synchronous transformations)
or flatMap() (for asynchronous transformations that return another Mono).
This keeps the pipeline reactive.
 */
public class Test_map {
    private static final Logger log = LoggerFactory.getLogger(Test_map.class);

    static void main() {

        Mono<String> nameMono = Mono.just("Alice In Wonderland");

        // Synchronous transformation with map()
        Mono<Integer> nameLengthMono = nameMono.map(String::length);
        log.info("Length: {} ", nameLengthMono.block());

        // Async transformation with flatMap()
        Mono<String> greetingMono = nameMono.flatMap(name ->
                Mono.just("Hello, " + name)
        );

        greetingMono.subscribe(log::info); // Output: Hello, Alice
    }}
