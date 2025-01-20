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

    public class WishListAdapter extends BaseAdapter {

        private Context context;
        private List<Product> wishListItems;

        public WishListAdapter(Context context, List<Product> wishListItems) {
            this.context = context;
            this.wishListItems = wishListItems;
        }

        @Override
        public int getCount() {
            return wishListItems.size();
        }

        @Override
        public Object getItem(int position) {
            return wishListItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.wish_list_item, parent, false);
            }

            // Bind wishlist item data to views
            Product product = wishListItems.get(position);

            ImageView productImageView = convertView.findViewById(R.id.wishListProductImage);
            TextView productNameTextView = convertView.findViewById(R.id.wishListProductName);
            TextView productPriceTextView = convertView.findViewById(R.id.wishListProductPrice);
            Button removeButton = convertView.findViewById(R.id.removeFromWishListButton);

            removeButton.setOnClickListener(v -> {
                wishListItems.remove(position);               // Remove item from the list
                WishListManager.removeFromWishList(product);  // Update the WishListManager
                notifyDataSetChanged();                       // Notify the adapter about the change
            });

            productImageView.setImageResource(product.getImageResId());
            productNameTextView.setText(product.getName());
            productPriceTextView.setText("Price: ₹" + product.getPrice());

            return convertView;
        }
}
