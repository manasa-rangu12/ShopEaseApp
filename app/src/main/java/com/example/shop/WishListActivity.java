package com.example.shop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> wishListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get items from WishListManager
        wishListItems = WishListManager.getWishListItems();

        // Set the adapter with updated wish list items
        adapter = new ProductAdapter(this, wishListItems, product -> {
            // Handle product click, if necessary
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the wishlist when returning to this activity
        wishListItems = WishListManager.getWishListItems();
        adapter.notifyDataSetChanged();
    }
}