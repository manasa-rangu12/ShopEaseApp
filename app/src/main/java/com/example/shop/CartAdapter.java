package com.example.shop;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CartAdapter extends BaseAdapter {

    private final Context context;
    private final List<Product> cartItems;

    public CartAdapter(Context context, List<Product> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        }

        // Bind cart item data to views
        Product product = cartItems.get(position);

        ImageView productImageView = convertView.findViewById(R.id.cartProductImage);
        TextView productNameTextView = convertView.findViewById(R.id.cartProductName);
        TextView productPriceTextView = convertView.findViewById(R.id.cartProductPrice);
        Button removeButton = convertView.findViewById(R.id.removeFromCartButton);

        removeButton.setOnClickListener(v -> {
            cartItems.remove(position);               // Remove item from the list
            CartManager.removeFromCart(product);      // Update the CartManager
            notifyDataSetChanged();                   // Notify the adapter about the change
        });

        productImageView.setImageResource(product.getImageResId());
        productNameTextView.setText(product.getName());
        productPriceTextView.setText("Price: ₹" + product.getPrice());

        return convertView;
    }
}
