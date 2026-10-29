package edu.examples.reactivestreams.service;

import edu.examples.reactivestreams.model.UserImpl;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UserService {

    public Mono<User> getUserById(String id) {

        User usr = new UserImpl();
        usr.setFullName("Alex Kurylovich");
        usr.setUsername(id);

        return Mono.just(usr)
                .delayElement(Duration.ofSeconds(1));
    }
}
