package com.example.shop;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView setup
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));  // 2 columns in the grid

        // Initialize product list
        productList = new ArrayList<>();
        populateProductList();

        // Adapter with click listener
        // Handle product click: Open a new Activity
        ProductAdapter productAdapter = new ProductAdapter(this, productList, product -> {
            // Handle product click: Open a new Activity
            Intent intent = new Intent(MainActivity1.this, ProductDetailActivity.class);
            intent.putExtra("PRODUCT_NAME", product.getName());
            intent.putExtra("PRODUCT_PRICE", product.getPrice());
            intent.putExtra("PRODUCT_DESCRIPTION", product.getDescription());
            intent.putExtra("PRODUCT_IMAGE", product.getImageResId());
            startActivity(intent);
        });
        recyclerView.setAdapter(productAdapter);

        // Bottom Navigation setup
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home) {
                // Already on home screen
                return true;
            } else if (id == R.id.cart) {
                // Open Cart Activity
                startActivity(new Intent(MainActivity1.this, CartActivity.class));
                return true;
            } else if (id == R.id.wish_list) {
                startActivity(new Intent(MainActivity1.this, WishListActivity.class));
                return true;
            } else if (id == R.id.profile) {
                // Open Profile Activity
                startActivity(new Intent(MainActivity1.this, ProfileActivity.class));
                return true;
            }
            return false;
        });
    }

    // Method to populate product list
    private void populateProductList() {
        productList.add(new Product("Smartphone", "Latest model with high specs, 6GB RAM, 128GB Storage", 12000, R.drawable.product_1));
        productList.add(new Product("Laptop", "Powerful laptop with Intel i7 processor and 16GB RAM", 50000, R.drawable.product_2));
        productList.add(new Product("Smartwatch", "Fitness tracker with heart-rate monitor and sleep tracking", 1200, R.drawable.product_3));
        productList.add(new Product("Headphones", "Noise-cancelling over-ear headphones, 40 hours battery life",3000 , R.drawable.product_4));
        productList.add(new Product("Tablet", "10-inch tablet with stylus support, perfect for drawing", 1000, R.drawable.product_5));
        productList.add(new Product("Wireless Earbuds", "True wireless earbuds with superior sound quality", 2300, R.drawable.product_6));
        productList.add(new Product("Smart TV", "4K UHD Smart TV with built-in voice assistant", 50000, R.drawable.product_7));
        productList.add(new Product("Bluetooth Speaker", "Portable Bluetooth speaker with deep bass and 20 hours playtime", 2000, R.drawable.product_8));
        productList.add(new Product("Gaming Console", "Next-gen gaming console with 4K support and exclusive games", 2000, R.drawable.product_9));
        productList.add(new Product("Leather Jacket", "Genuine leather jacket for stylish winter looks", 20000, R.drawable.product_10));
    }
}