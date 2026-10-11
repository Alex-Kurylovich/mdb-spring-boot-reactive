package edu.examples.reactivestreams.repository;

import edu.examples.reactivestreams.model.Grocery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GroceryRepository extends ReactiveMongoRepository<Grocery, String> {
    @Query("{name:'?0'}")
    Mono<Grocery> findGroceryByName(String name);

    @Query(value="{category:'?0'}")
    Flux<Grocery> findAll(String category);
}
