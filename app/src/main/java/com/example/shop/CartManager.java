package com.example.shop;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static final List<Product> cartItems = new ArrayList<>();

    // Add product to the cart
    public static void addToCart(Product product) {
        cartItems.add(product);
    }

    // Remove product from the cart
    public static void removeFromCart(Product product) {
        cartItems.remove(product);
    }

    // Get the total price of all items in the cart
    public static double getTotalPrice() {
        double total = 0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }

    // Get the list of all items in the cart
    public static List<Product> getCartItems() {
        return cartItems;
    }
}
