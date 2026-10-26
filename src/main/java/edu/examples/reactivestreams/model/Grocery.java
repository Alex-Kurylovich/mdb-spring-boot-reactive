package edu.examples.reactivestreams.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("grocery")
public class Grocery {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;

    public Grocery(String name, int quantity, String category) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemQuantity() {
        return quantity;
    }

    public void setItemQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
