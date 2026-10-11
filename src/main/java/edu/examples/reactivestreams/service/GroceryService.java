package edu.examples.reactivestreams.service;

import edu.examples.reactivestreams.repository.GroceryRepository;
import edu.examples.reactivestreams.template.GroceryTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

@Service
public class GroceryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroceryService.class);
    private final GroceryTemplate groceryTemplate;
    private final GroceryRepository groceryRepository;
    private final TransactionalOperator transactionalOperator;

    GroceryService(GroceryTemplate groceryTemplate,
               GroceryRepository groceryRepository,
               TransactionalOperator transactionalOperator) {
        this.groceryTemplate = groceryTemplate;
        this.groceryRepository = groceryRepository;
        this.transactionalOperator = transactionalOperator;
    }
}
