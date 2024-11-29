package com.example.cassandra.springbootcassandrademo.model;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.annotation.Id;

@Table("product")
public class Product {

    @Id
    private int id;

    private String name;
    private double price;  // Added price field

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {  // Getter for price
        return price;
    }

    public void setPrice(double price) {  // Setter for price
        this.price = price;
    }
}
