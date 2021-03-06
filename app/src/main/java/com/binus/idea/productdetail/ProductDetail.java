package com.binus.idea.productdetail;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.binus.idea.entity.Product;
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
        setTitle("Product Detail");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Product item = (Product) getIntent().getSerializableExtra("product");

        if (item != null){
            binding.productImage.setImageResource(item.getImage());
            binding.productName.setText(item.getName());
            binding.productPrice.setText(item.getPrice());
        }


        binding.buyButton.setOnClickListener(v -> {
            String inp = binding.quant.getText().toString();
            int quantity = 0;
            try {
                quantity = Integer.parseInt(inp);
            } catch (Exception ignored) {

            }

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
