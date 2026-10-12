package edu.examples.reactivestreams.controller;

import edu.examples.reactivestreams.entity.TransferRequest;
import edu.examples.reactivestreams.model.Grocery;
import edu.examples.reactivestreams.model.Txn;
import edu.examples.reactivestreams.repository.GroceryRepository;
import edu.examples.reactivestreams.service.GroceryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GroceryController {

    private final static Logger LOGGER = LoggerFactory.getLogger(GroceryController.class);
    private final GroceryRepository groceryRepository;
    private final GroceryService groceryService;

    public GroceryController(GroceryRepository groceryRepository, GroceryService groceryService) {
        this.groceryRepository = groceryRepository;
        this.groceryService = groceryService;
    }

    @PostMapping("/grocery/create")
    public Mono<Grocery> createGrocery(@RequestBody Grocery grocery) {
        Mono<Grocery> groceryCreated = groceryRepository.save(grocery);
        LOGGER.info("Grocery created = {}", groceryCreated);
        return groceryCreated;
    }

    @GetMapping("/grocery/count")
    public Mono<Long> countOfGrocery() {
        Mono<Long> count = groceryRepository.count();
        LOGGER.info("Number of documents in the collection grocery = {}", count);
        return count;
    }

    @GetMapping("/grocery/all")
    public Flux<Grocery> allGrocery() {
        Flux<Grocery> grocery = groceryRepository.findAll();
        LOGGER.info("List of all in the collection grocery = {}", grocery);
        return grocery;
    }

    @GetMapping("/grocery/name/{name}")
    public Mono<Grocery> getGroceryByName(@PathVariable String name) {
        Mono<Grocery> grocery = groceryRepository.findGroceryByName(name);
        LOGGER.info("Grocery by name in the collection grocery = {}", grocery);
        return grocery;
    }

    @GetMapping("/grocery/category/{category}")
    public Flux<Grocery> getItemsByCategory(@PathVariable String category) {
        Flux<Grocery> list = groceryRepository.findAll(category);
        LOGGER.info("Grocery by category in the collection grocery = {}", list);
        return list;
    }
}
