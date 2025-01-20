package com.example.shop;

import java.util.ArrayList;
import java.util.List;

public class WishListManager {
    private static final List<Product> wishListItems = new ArrayList<>();

    // Add product to wish list
    public static void addToWishList(Product product) {
        if (!wishListItems.contains(product)) {
            wishListItems.add(product);
        }
    }

    // Remove product from wish list
    public static void removeFromWishList(Product product) {
        wishListItems.remove(product);
    }

    public static boolean isInWishList(Product product) {
        return wishListItems.contains(product);
    }


    // Get the list of all items in the wish list
    public static List<Product> getWishListItems() {
        return wishListItems;
    }
}
