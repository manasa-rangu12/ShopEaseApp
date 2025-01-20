package com.example.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;
    private OnProductClickListener clickListener;

    // Constructor
    public ProductAdapter(Context context, List<Product> productList, OnProductClickListener clickListener) {
        this.context = context;
        this.productList = productList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        // Set product details
        holder.productTitle.setText(product.getName());
        holder.productPrice.setText("₹" + product.getPrice());
        holder.productDescription.setText(product.getDescription());
        holder.productImage.setImageResource(product.getImageResId());

        // Set the initial state of the like button
        if (WishListManager.isInWishList(product)) {
            holder.likeButton.setImageResource(R.drawable.ic_heart_filled);
        } else {
            holder.likeButton.setImageResource(R.drawable.ic_heart_outline);
        }

        // Handle like button click
        holder.likeButton.setOnClickListener(v -> {
            if (WishListManager.isInWishList(product)) {
                WishListManager.removeFromWishList(product);  // Correctly remove from WishListManager
                holder.likeButton.setImageResource(R.drawable.ic_heart_outline);
            } else {
                WishListManager.addToWishList(product);  // Correctly add to WishListManager
                holder.likeButton.setImageResource(R.drawable.ic_heart_filled);
            }
            notifyDataSetChanged();  // Refresh the adapter to reflect changes
        });

        holder.itemView.setOnClickListener(v -> clickListener.onProductClick(product));

        holder.addToCartButton.setOnClickListener(v -> {
            CartManager.addToCart(product);  // Add product to cart
            Toast.makeText(context, "Product added to cart", Toast.LENGTH_SHORT).show();
        });



    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    // ViewHolder class
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        Button addToCartButton;
        ImageView productImage;
        TextView productTitle, productPrice, productDescription;
        ImageButton likeButton; // Reference to the like button

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDescription = itemView.findViewById(R.id.productDescription);
            likeButton = itemView.findViewById(R.id.likeButton);
            addToCartButton= itemView.findViewById(R.id.addToCartButton); // Initialize the like button
        }
    }

    // Interface for product click listener
    public interface OnProductClickListener {
        void onProductClick(Product product);
    }
}