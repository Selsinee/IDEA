package com.binus.idea.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.binus.idea.MainActivity;
import com.binus.idea.R;
import com.binus.idea.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(v -> {

            String username = binding.usernameField.getText().toString();
            String password = binding.passwordField.getText().toString();

            if (username.equals("")) {
                binding.errorMessage.setText(getString(R.string.username_empty_error_message));
                binding.errorMessage.setVisibility(View.VISIBLE);
                return;
            }
            if (username.length() < 8 || username.length() > 24) {
                binding.errorMessage.setText(getString(R.string.username_length_error_message));
                binding.errorMessage.setVisibility(View.VISIBLE);
                return;
            }

            if (password.equals("")) {
                binding.errorMessage.setText(getString(R.string.password_error_message));
                binding.errorMessage.setVisibility(View.VISIBLE);
                return;
            }

            binding.errorMessage.setVisibility(View.GONE);

            //Store username in shared pref so that other activities and fragments can access easily
            SharedPreferences sharedPreferences = getSharedPreferences("IDEAData", MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("username", username);
            edit.apply();


            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }

}