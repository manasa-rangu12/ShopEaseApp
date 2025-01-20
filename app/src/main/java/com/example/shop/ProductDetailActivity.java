package com.example.shop;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Retrieve product details from Intent
        String name = getIntent().getStringExtra("PRODUCT_NAME");
        String description = getIntent().getStringExtra("PRODUCT_DESCRIPTION");
        double price = getIntent().getDoubleExtra("PRODUCT_PRICE",0);
        int imageResId = getIntent().getIntExtra("PRODUCT_IMAGE", 0);

        // Bind data to views
        ((TextView) findViewById(R.id.productName)).setText(name);
        ((TextView) findViewById(R.id.productDescription)).setText(description);
        ((TextView) findViewById(R.id.productPrice)).setText("₹" + price);
        ((ImageView) findViewById(R.id.productImage)).setImageResource(imageResId);

        // Handle Add to Cart button
        Button addToCartButton = findViewById(R.id.addToCartButton);
        addToCartButton.setOnClickListener(v -> {
            // Create a product object
            Product product = new Product(name, description, price, imageResId);

            // Add the product to the cart
            CartManager.addToCart(product);

            // Notify the user
            Toast.makeText(ProductDetailActivity.this, name + " added to cart", Toast.LENGTH_SHORT).show();
        });
    }
}