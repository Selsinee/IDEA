package com.binus.idea;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.binus.idea.databinding.ProductDetailBinding;

import java.util.Objects;

public class ProductDetail extends AppCompatActivity {

    private ProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding.buyButton.setOnClickListener(v -> {
            String inp = binding.quant.getText().toString();
            int quantity = Integer.parseInt(inp);

            if (quantity > 0) {
                successDialog();
            } else {
                failDialog();
            }
        });
    }

    void failDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Quantity is Empty, Unable to Purchase")
                .setPositiveButton("Return", (dialog, id) -> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    void successDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Transaction Success")
                .setPositiveButton("OK", (dialog, id) -> finish());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
