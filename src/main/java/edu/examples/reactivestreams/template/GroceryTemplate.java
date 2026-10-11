package edu.examples.reactivestreams.template;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class GroceryTemplate {
    private final ReactiveMongoTemplate template;

    public GroceryTemplate(ReactiveMongoTemplate template) {
        this.template = template;
    }

}
