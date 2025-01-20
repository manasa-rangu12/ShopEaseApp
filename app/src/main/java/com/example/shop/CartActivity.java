package com.example.shop;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ListView cartListView = findViewById(R.id.cartListView);

        // Get the cart items
        List<Product> cartItems = CartManager.getCartItems();

        // Display the cart items using a custom adapter
        CartAdapter cartAdapter = new CartAdapter(this, cartItems);
        cartListView.setAdapter(cartAdapter);

        if (cartItems.isEmpty()) {
            Toast.makeText(this, "Your cart is empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
