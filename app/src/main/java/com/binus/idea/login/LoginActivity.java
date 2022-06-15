package com.binus.idea.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.binus.idea.MainActivity;
import com.binus.idea.R;
import com.binus.idea.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        loginBtn = findViewById(R.id.login_button);



        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(v -> {

//            loginBtn.setOnClickListener(new View.OnClickListener() {
                //@Override
                //public void onClick(View v) {

               // }
           // });

            String username = binding.usernameField.getText().toString();
            //TODO: Validations
            if (username.equals("")) {
                Toast.makeText(getApplicationContext(), "username must not be empty",
                        Toast.LENGTH_LONG).show();

                return;
            }
            if (username.length() < 8 || username.length()>24){
                Toast.makeText(getApplicationContext(), "username must be between 8-24",
                        Toast.LENGTH_LONG).show();

                return;
            }



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