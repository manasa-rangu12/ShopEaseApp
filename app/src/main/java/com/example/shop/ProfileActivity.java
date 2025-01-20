package com.example.shop;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Retrieve user data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
        String userName = sharedPreferences.getString("UserName", null); // Get saved name
        String userEmail = sharedPreferences.getString("UserEmail", null); // Get saved email

        // Bind user data to views
        TextView nameTextView = findViewById(R.id.userName);
        TextView emailTextView = findViewById(R.id.userEmail);

        if (userName != null && userEmail != null) {
            // Display user data
            nameTextView.setText("Name: " + userName);
            emailTextView.setText("Email: " + userEmail);
        } else {
            // Fallback in case no data exists (e.g., user not signed in)
            nameTextView.setText("Name: Not Available");
            emailTextView.setText("Email: Not Available");
        }
    }
}
