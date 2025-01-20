package com.example.shop;

import java.util.Objects;

public class Product {
    private final String name;
    private final String description;
    private final double price;
    private final int imageResId;

    // Constructor
    public Product(String name, String description, double price, int imageResId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }

    // Override equals() to compare Product objects based on their properties
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                imageResId == product.imageResId &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    // Override hashCode() to ensure consistent hashing based on properties
    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, imageResId);
    }
}