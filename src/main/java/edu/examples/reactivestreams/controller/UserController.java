package edu.examples.reactivestreams.controller;

import edu.examples.reactivestreams.model.UserImpl;
import edu.examples.reactivestreams.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable String id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok) // Reactive mapping to ResponseEntity
                .defaultIfEmpty(ResponseEntity.notFound().build()); // Handle empty Mono
    }
}
