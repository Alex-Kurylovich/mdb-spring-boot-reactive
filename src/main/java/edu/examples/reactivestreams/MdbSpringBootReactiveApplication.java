package edu.examples.reactivestreams;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
// http://localhost:8080/swagger-ui/index.html
@OpenAPIDefinition(
        info = @Info(
                title = "Transactions API",
                version = "1.0",
                description = "API documentation for managing account transactions"
        )
)
public class MdbSpringBootReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootReactiveApplication.class, args);
    }

}
