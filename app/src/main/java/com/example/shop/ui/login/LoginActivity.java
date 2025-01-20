package com.example.shop.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shop.MainActivity1;
import com.example.shop.R;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            // Get user input
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Retrieve user data from SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
            String storedEmail = sharedPreferences.getString("UserEmail", "");
            String storedPassword = sharedPreferences.getString("UserPassword", "");

            // Validate login
            if (email.equals(storedEmail) && password.equals(storedPassword)) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                // Navigate to MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity1.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}